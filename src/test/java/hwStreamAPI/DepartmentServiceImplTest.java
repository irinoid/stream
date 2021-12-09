package hwStreamAPI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static hwStreamAPI.EmployeeConstants.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;


    @Test
    public void shouldReturnAllEmployeesWhenEmployeesSetExist() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertIterableEquals(TEST_SORTED_LIST_EMPLOYEE, out.printDepartmentEmployee());
    }

    @Test
    public void shouldReturnAllEmployeesInDepartment() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertIterableEquals(TEST_SORTED_DEPART_LIST_EMPLOYEE, out.printDepartmentEmployee(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnMaxSalaryEmployee() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(EMPLOYEE_4, out.getMaxSalary(DEPARTMENT_ID1).get());
        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

    @Test
    public void shouldReturnMinSalaryEmployee() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(EMPLOYEE_1, out.getMinSalary(DEPARTMENT_ID1).get());
        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }


}