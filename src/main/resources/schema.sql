CREATE DATABASE activity_db;

CREATE TABLE employees (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE activities (
    id INTEGER NOT NULL AUTO_INCREMENT,
    description TEXT NOT NULL,
    status VARCHAR(20) NOT NULL,
    employee_id INTEGER NOT NULL,
    completed_date datetime(6) DEFAULT NULL,
    execution_date datetime(6) DEFAULT NULL,
    PRIMARY KEY (id),
     CONSTRAINT activities_fk_employees FOREIGN KEY (employee_id) REFERENCES employees (id)
);