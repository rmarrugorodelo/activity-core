package com.rmarrugo.test.application.activity;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.activity.port.ActivityFinderRepository;
import com.rmarrugo.test.domain.activity.port.ActivityWriterRepository;
import com.rmarrugo.test.domain.activity.port.ActivityWriter;
import com.rmarrugo.test.domain.employee.Employee;
import com.rmarrugo.test.domain.employee.port.EmployeeFinderRepository;
import com.rmarrugo.test.domain.exception.ErrorCode;
import com.rmarrugo.test.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ActivityWriterUseCase implements ActivityWriter {

    private final ActivityWriterRepository activityWriterRepository;
    private final ActivityFinderRepository activityFinderRepository;
    private final EmployeeFinderRepository employeeFinderRepository;

    @Override
    public void create(Activity activity, Long employeeId) {
        Employee employee = findEmployeeById(employeeId);
        activityWriterRepository.save(
                activity.withEmployee(employee)
        );
    }

    @Override
    public void update(Long id, Activity activity, Long employeeId) {
        if (!activityFinderRepository.existsById(id)) {
            throw new NotFoundException(ErrorCode.ACTIVITY_NOT_FOUND);
        }
        Employee employee = findEmployeeById(employeeId);
        activityWriterRepository.save(
                activity.withId(id).withEmployee(employee)
        );
    }

    @Override
    public void delete(Long id) {
        activityWriterRepository.delete(id);
    }

    private Employee findEmployeeById(Long employeeId) {
        return employeeFinderRepository.findById(employeeId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorCode.EMPLOYEE_NOT_FOUND)
                );
    }

}
