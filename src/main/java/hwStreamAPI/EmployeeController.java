package hwStreamAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String lastName, @RequestParam String firstName, @RequestParam int departmentId, @RequestParam int salary) {
        return employeeService.addEmployee(lastName, firstName, departmentId, salary);
    }

    @GetMapping("/remove")
    public String deleteEmployee(@RequestParam String lastName, @RequestParam String firstName) throws EmpNotFoundException {
        return "Удалён: " + employeeService.deleteEmployee(lastName, firstName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String lastName, @RequestParam String firstName) throws EmpNotFoundException {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/department/max-salary")
    public String getMaxSalary(@RequestParam int departmentId) {
        return "Сотрудник с максимальной ЗП в отделе №" + departmentId + " - " + employeeService.getMaxSalary(departmentId);
    }

    @GetMapping("/department/min-salary")
    public String getMinSalary(@RequestParam int departmentId) {
        return "Сотрудник с минимальной ЗП в отделе №" + departmentId + " - " + employeeService.getMinSalary(departmentId);
    }

    @GetMapping("/department/alldep")
    public String printAllEmployee() {
        return "Сотрудники отдела 1: " + employeeService.printDepartmentEmployee(1) + System.lineSeparator() + "Сотрудники отдела 2: " + employeeService.printDepartmentEmployee(2) + System.lineSeparator() + "Сотрудники отдела 3: " + employeeService.printDepartmentEmployee(3);
    }

    @GetMapping("/department/all")
    public String printDepartmentEmployee(@RequestParam int departmentId) {
        return "Сотрудники отдела " + departmentId + ": " + employeeService.printDepartmentEmployee(departmentId);
    }

}
