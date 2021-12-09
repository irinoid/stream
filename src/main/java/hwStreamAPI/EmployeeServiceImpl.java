package hwStreamAPI;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> empMap;

    public EmployeeServiceImpl() {
        this.empMap = new HashMap<>();

        empMap.put("Иванов Иван", new Employee("Иванов", "Иван", 1, 100_000));
        empMap.put("Петров Петр", new Employee("Петров", "Петр", 2, 50_000));
        empMap.put("Васильев Василий", new Employee("Иванов", "Иван", 3, 7_000));
        empMap.put("Абрамов Абрам", new Employee("Абрамов", "Абрам", 1, 10_000));
        empMap.put("Захаров Захар", new Employee("Захаров", "Захар", 2, 150_000));
        empMap.put("Игнатов Игнат", new Employee("Игнатов", "Игнат", 3, 15_000));
        empMap.put("Давидов Давид", new Employee("Давидов", "Давид", 1, 18_000));
        empMap.put("Степанов Степан", new Employee("Степанов", "Степан", 2, 35_000));
        empMap.put("Денисов Денис", new Employee("Денисов", "Денис", 3, 55_000));
        empMap.put("Кириллов Кирилл", new Employee("Кириллов", "Кирилл", 1, 64_000));
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, int departmentId, int salary) {
        Employee empTemp = empMap.get(lastName + " " + firstName);
        if (empTemp == null) {
            Employee newEmp = new Employee(lastName, firstName, departmentId, salary);
            empMap.put(lastName + " " + firstName, newEmp);
            return newEmp;
        }
        throw new EmpExistException();
    }


    @Override
    public Employee deleteEmployee(String lastName, String firstName) {

        if (empMap.containsKey(lastName + " " + firstName)) {
            Employee delEmp = empMap.get(lastName + " " + firstName);
            empMap.remove(lastName + " " + firstName);

            return delEmp;
        }
        throw new EmpNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        if (!empMap.containsKey(lastName + " " + firstName)) {
            throw new EmpNotFoundException();
        }
        return empMap.get(lastName + " " + firstName);
    }

    @Override
    public Set<Employee> getEmployees() {
        return new HashSet<>(empMap.values());
    }
}
