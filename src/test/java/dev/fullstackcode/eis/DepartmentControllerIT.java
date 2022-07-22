package dev.fullstackcode.eis;

import dev.fullstackcode.eis.entity.Department;
import dev.fullstackcode.eis.entity.Employee;
import dev.fullstackcode.eis.entity.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DepartmentControllerIT extends BaseIT2 {

    @Test
    @Sql({ "/import.sql" })
    public void testGetDepartmentById() {

        ResponseEntity<Department> response = testRestTemplate.getForEntity( "/department/{id}",Department.class,100);
        Department dept =  response.getBody();

        assertEquals(100,dept.getId());
        assertEquals("HR", dept.getName());

    }

    @Test
    @Sql({"/import.sql"})
    public void testCreateDepartment() {

        Department dept = new Department();
        dept.setName("SALES");
        dept.setEmployees(new ArrayList<Employee>());



        ResponseEntity<Department> response = testRestTemplate.postForEntity("/department", dept, Department.class);

        Department department = response.getBody();
        System.out.println(department);
        assertNotNull(department.getId());
        assertEquals("SALES", department.getName());

    }


}