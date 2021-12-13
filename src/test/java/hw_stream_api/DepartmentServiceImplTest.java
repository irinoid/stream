package hw_stream_api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static hw_stream_api.EmployeeConstants.*;
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

        assertIterableEquals(TEST_SORTED_LIST_EMPLOYEE, out.getDepartmentEmployee());
    }

    @Test
    public void shouldReturnEmptySetWhenEmployeesSetNotExist() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertIterableEquals(TEST_EMPTY_SET_EMPLOYEE, out.getDepartmentEmployee());
    }

    @Test
    public void shouldReturnAllEmployeesInDepartment() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertIterableEquals(TEST_SORTED_DEPART_LIST_EMPLOYEE, out.getDepartmentEmployee(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmptySetInDepartmentWhenSetIsEmpty() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertIterableEquals(TEST_EMPTY_SET_EMPLOYEE, out.getDepartmentEmployee(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnMaxSalaryEmployee() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(EMPLOYEE_4, out.getMaxSalary(DEPARTMENT_ID1).get());
    }

    @Test
    public void shouldReturnEmptyMaxSalaryEmployeeWhenDepartmentIncorrect() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

    @Test
    public void shouldReturnEmptyMaxSalaryEmployeeWhenSetIsEmpty() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

    @Test
    public void shouldReturnMinSalaryEmployee() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(EMPLOYEE_1, out.getMinSalary(DEPARTMENT_ID1).get());
    }

    @Test
    public void shouldReturnEmptyMinSalaryEmployeeWhenDepartmentIncorrect() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

    @Test
    public void shouldReturnEmptyMinSalaryEmployeeWhenSetIsEmpty() {
        when(employeeServiceMock.getEmployees())
                .thenReturn(TEST_EMPTY_SET_EMPLOYEE);

        assertEquals(Optional.empty(), out.getMaxSalary(DEPARTMENT_ID_INCORRECT));
    }

}