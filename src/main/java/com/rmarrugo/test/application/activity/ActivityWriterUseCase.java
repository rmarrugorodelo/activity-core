package com.rmarrugo.test.application.activity;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.activity.ActivityStatus;
import com.rmarrugo.test.domain.activity.port.ActivityFinderRepository;
import com.rmarrugo.test.domain.activity.port.ActivityWriterRepository;
import com.rmarrugo.test.domain.activity.port.ActivityWriter;
import com.rmarrugo.test.domain.employee.Employee;
import com.rmarrugo.test.domain.employee.port.EmployeeFinderRepository;
import com.rmarrugo.test.domain.exception.BadRequestException;
import com.rmarrugo.test.domain.exception.ErrorCode;
import com.rmarrugo.test.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class ActivityWriterUseCase implements ActivityWriter {

    private final ActivityWriterRepository activityWriterRepository;
    private final ActivityFinderRepository activityFinderRepository;
    private final EmployeeFinderRepository employeeFinderRepository;

    @Override
    public void create(Activity activity, Long employeeId) {
        validateExecutionDate(activity.getExecutionDate());
        Employee employee = findEmployeeById(employeeId);
        activityWriterRepository.save(
                activity
                        .withEmployee(employee)
                        .withStatus(ActivityStatus.PENDING)
        );
    }

    @Override
    public void update(Long id, Activity activity, Long employeeId) {
        validateExecutionDate(activity.getExecutionDate());
        Activity savedActivity = findById(id);
        Employee employee = findEmployeeById(employeeId);
        activityWriterRepository.save(
                activity.withId(id)
                        .withEmployee(employee)
                        .withStatus(savedActivity.getStatus())
        );
    }

    @Override
    public void delete(Long id) {
        activityWriterRepository.delete(id);
    }

    @Override
    public void complete(Long id) {
        Activity activity = findById(id);
        activityWriterRepository.save(
                activity.withStatus(ActivityStatus.COMPLETED)
                .withCompletedDate(LocalDateTime.now())
        );
    }

    private Employee findEmployeeById(Long employeeId) {
        return employeeFinderRepository.findById(employeeId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorCode.EMPLOYEE_NOT_FOUND)
                );
    }

    private Activity findById(Long id) {
        return activityFinderRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException(ErrorCode.ACTIVITY_NOT_FOUND)
                );
    }

    private void validateExecutionDate(LocalDateTime executionDate) {
        if(executionDate.isBefore(LocalDateTime.now())){
            throw new BadRequestException(ErrorCode.INVALID_EXECUTION_DATE);
        }
    }

}
