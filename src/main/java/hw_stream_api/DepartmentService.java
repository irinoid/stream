package hw_stream_api;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> getMaxSalary(int departmentId);

    Optional<Employee> getMinSalary(int departmentId);

    List<Employee> getDepartmentEmployee(int departmentId);

    List<Employee> getDepartmentEmployee();
}
