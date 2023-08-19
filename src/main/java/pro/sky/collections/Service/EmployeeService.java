package pro.sky.collections.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.Exception.EmployeeAlreadyAddException;
import pro.sky.collections.Exception.EmployeeNotFoundException;
import pro.sky.collections.Exception.EmployeeStorageIsFullException;
import pro.sky.collections.Exception.WrongNameException;

import java.util.*;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeService {

    private static int SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddException();
        }
        employees.put(key, new Employee(capitalize(firstName),capitalize (lastName))); //содаем сотрудника,
               // если его нет(var employee= new Employee(firstName, lastName)) //
    }

    public Employee findEmployee(String firstName, String lastName) {
        var emp = employees.get(makeKey(firstName, lastName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
        // return employee.get(makeKey(firstName, lastName)); без Exception //
    }

    public boolean removeEmployee(String firstName, String lastName) {
        Employee removed = employees.remove(makeKey(firstName, lastName));
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    private String makeKey(String firstName, String lastName) {
        return (firstName + " " + lastName).toLowerCase();
    }
}

