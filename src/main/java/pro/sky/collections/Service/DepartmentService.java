package pro.sky.collections.Service;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.Exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public double maxSalary(int deptId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == deptId)
                .map(Employee::getSalary)
                .max(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    public double minSalary(int deptId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == deptId)
                .map(Employee::getSalary)
                .min(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    public List<Employee> findAllByDept(int deptId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == deptId)
                .collect(Collectors.toList());
    }

    public void groupDeDept() {
        Map<Integer, List<Employee>> map = employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}