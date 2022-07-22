package dev.fullstackcode.eis;



import dev.fullstackcode.eis.entity.Department;
import dev.fullstackcode.eis.entity.Employee;
import dev.fullstackcode.eis.entity.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeControllerIT extends BaseIT {

    @Test
    @Sql({"/import.sql"})
    public void testCreateEmployee() {

        Department dept = new Department();
        dept.setId(100);

        Employee emp = new Employee();

        emp.setFirst_name("abc");
        emp.setLast_name("xyz");
        emp.setDepartment(dept);
        emp.setBirth_date(LocalDate.of(1980, 11, 11));
        emp.setHire_date(LocalDate.of(2020, 01, 01));
        emp.setGender(Gender.F);

        ResponseEntity<Employee> response = testRestTemplate.postForEntity("/employee", emp, Employee.class);

        Employee employee = response.getBody();
        System.out.println(employee);
        assertNotNull(employee.getId());
        assertEquals("abc", employee.getFirst_name());

    }

    @Test
    @Sql({"/import.sql"})
    public void testGetEmployeeById() {

        ResponseEntity<Employee> response = testRestTemplate.getForEntity("/employee/{id}", Employee.class, 8);
        Employee employee = response.getBody();

        assertEquals(8, employee.getId());
        assertEquals("Ibrar", employee.getFirst_name());

    }
}

