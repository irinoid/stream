package hwStreamAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hwStreamAPI.EmployeeConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    @Test
    public void shouldReturnEmployeeIvanWhenAddEmployeeIvan() {
        Employee result = out.addEmployee(LAST_NAME_ADD, FIRST_NAME_ADD, DEPARTMENT_ID1, SALARY1);
        Assertions.assertEquals(result, EMPLOYEE_ADD);
    }
    @Test
    public void shouldReturnEmpExistExceptionWhenEmployeeExist() {
        Assertions.assertThrows(EmpExistException.class,
                () -> out.addEmployee(LAST_NAME_DEL, FIRST_NAME_DEL, DEPARTMENT_ID1, SALARY1)
        );
    }


    @Test
    public void shouldReturnDeletedEmployeeIvanWhenDeleteEmployeeIvan() {
        Employee result = out.deleteEmployee(LAST_NAME_DEL, FIRST_NAME_DEL);
        Assertions.assertEquals(result, EMPLOYEE_DEL);
    }

    @Test
    public void shouldReturnEmpNotFoundExceptionWhenEmployeeNotFound() {
        Assertions.assertThrows(EmpNotFoundException.class,
                () -> out.deleteEmployee(LAST_NAME_ADD, FIRST_NAME_ADD)
        );
    }

    @Test
    public void shouldReturnFindEmployeeIvanWhenFindEmployeeIvan() {
        Employee result = out.findEmployee(LAST_NAME_FIND, FIRST_NAME_FIND);
        Assertions.assertEquals(result, EMPLOYEE_FIND);
    }

    @Test
    public void shouldReturnEmpNotFoundExceptionWhenEmployeeDoNotExist() {
        Assertions.assertThrows(EmpNotFoundException.class,
                () -> out.findEmployee(LAST_NAME_ADD, FIRST_NAME_ADD)
        );
    }
}