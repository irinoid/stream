package hw_stream_api;

import java.util.Set;

public interface EmployeeService {

    Employee addEmployee(String lastName, String firstName, int departmentId, int salary);

    Employee deleteEmployee(String lastName, String firstName) throws EmpNotFoundException;

    Employee findEmployee(String lastName, String firstName);

    Set<Employee> getEmployees();
}