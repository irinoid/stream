package hwStreamAPI;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void generateEmployeeMap();

    Employee addEmployee(String lastName, String firstName, int departmentId, int salary);

    Optional<Employee> getMaxSalary(int departmentId);

    Optional<Integer> getMinSalary(int departmentId);

    List<Employee> printDepartmentEmployee(int departmentId);

    String deleteEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);
}
