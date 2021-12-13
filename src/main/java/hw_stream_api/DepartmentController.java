package hw_stream_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/department")
@RestController

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam int departmentId) {
        return departmentService.getMaxSalary(departmentId)
                .orElseThrow();
    }

    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam int departmentId) {
        return departmentService.getMinSalary(departmentId)
                .orElseThrow();
    }

    @GetMapping("/all")
    public List<Employee> printDepartmentEmployee(Integer departmentId) {
        if (departmentId == null) {
            return departmentService.getDepartmentEmployee();
        } else {
            return departmentService.getDepartmentEmployee(departmentId);
        }

    }
}
