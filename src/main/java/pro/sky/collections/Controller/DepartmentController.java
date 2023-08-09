package pro.sky.collections.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.Employee;
import pro.sky.collections.Service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee max(@RequestParam int deportmentId) {
        return service.maxSalary(deportmentId);
    }
    @GetMapping("/min-salary")
    public Employee min(@RequestParam int deportmentId) {
        return service.minSalary(deportmentId);
    }
    @GetMapping(path = "/all")
    public List<Employee> findAllByDept(@RequestParam int deportmentId) {
        return service.findAllByDept(deportmentId);
    }
    @GetMapping(path = "/all", params = {"departmentId"})
    public List<Employee> groupDeDept(@RequestParam int deportmentId) {
        return service.groupDeDept();
    }
}