package hwStreamAPI;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> empMap;

    public EmployeeServiceImpl() {
        this.empMap = new HashMap<>();

        empMap.put("Иван Иванов", new Employee("Иванов", "Иван", 1, 100_000));
        empMap.put("Петр Петров", new Employee("Петров", "Петр", 2, 50_000));
        empMap.put("Василий Васильев", new Employee("Иванов", "Иван", 3, 7_000));
        empMap.put("Абрам Абрамов", new Employee("Абрамов", "Абрам", 1, 10_000));
        empMap.put("Захар Захаров", new Employee("Захаров", "Захар", 2, 150_000));
        empMap.put("Игнат Игнатов", new Employee("Игнатов", "Игнат", 3, 15_000));
        empMap.put("Давид Давидов", new Employee("Давидов", "Давид", 1, 18_000));
        empMap.put("Степан Степанов", new Employee("Степанов", "Степан", 2, 35_000));
        empMap.put("Денис Денисов", new Employee("Денисов", "Денис", 3, 55_000));
        empMap.put("Кирилл Кириллов", new Employee("Кириллов", "Кирилл", 1, 64_000));
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, int departmentId, int salary) {
        Employee newEmp = new Employee(lastName, firstName, departmentId, salary);
        empMap.put(lastName + " " + firstName, newEmp);
        return empMap.get(lastName + " " + firstName);
    }

    @Override
    public Optional<Employee> getMaxSalary(int departmentId) {
        final Employee maxSalEmp;
        Optional<Employee> maxSal = empMap.values().stream().filter(e -> e.getDepartment() == departmentId).max(Comparator.comparingInt(e -> e.getSalary()));
        return maxSal;
    }

    @Override
    public Optional<Integer> getMinSalary(int departmentId) {
        Optional<Integer> minSal = empMap.values().stream().filter(e -> e.getDepartment() == departmentId).map(Employee::getSalary).min(Comparator.naturalOrder());
        return minSal;
    }

    @Override
    public List<Employee> printDepartmentEmployee(int departmentId) {
        List<Employee> all = empMap.values().stream().filter(e -> e.getDepartment() == departmentId).collect(Collectors.toList());
        return all;
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) {
        if (empMap.containsKey(lastName + " " + firstName)) {
            empMap.remove(lastName + " " + firstName);
            return lastName + " " + firstName;
        }
        throw new EmpNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        if (empMap.containsKey(lastName + " " + firstName)) {
            return empMap.get(lastName + " " + firstName);
        }
        throw new EmpNotFoundException();
    }
}
