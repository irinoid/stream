package hwStreamAPI;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {

    Employee addEmployee(String lastName, String firstName, int departmentId, int salary);

    String deleteEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Set<Employee> getEmployees();
}
