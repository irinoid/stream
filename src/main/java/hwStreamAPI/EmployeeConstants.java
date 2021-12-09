package hwStreamAPI;

import java.util.*;

public class EmployeeConstants {
    public static final String FIRST_NAME_ADD = "Федор";
    public static final String LAST_NAME_ADD = "Федоров";
    public static final String FIRST_NAME_DEL = "Иван";
    public static final String LAST_NAME_DEL = "Иванов";
    public static final String FIRST_NAME_FIND = "Петр";
    public static final String LAST_NAME_FIND = "Петров";
    public static final int SALARY1 = 100_000;
    public static final int DEPARTMENT_ID1 = 2;
    public static final int DEPARTMENT_ID_INCORRECT = 0;
    public static final Employee EMPLOYEE_ADD =  new Employee(LAST_NAME_ADD, FIRST_NAME_ADD, DEPARTMENT_ID1, SALARY1);
    public static final Employee EMPLOYEE_DEL =  new Employee(LAST_NAME_DEL, FIRST_NAME_DEL, DEPARTMENT_ID1, SALARY1);
    public static final Employee EMPLOYEE_FIND =  new Employee(LAST_NAME_FIND, FIRST_NAME_FIND, DEPARTMENT_ID1, SALARY1);
    public static final Employee EMPLOYEE_1 = new Employee("Петров", "Петр", 2, 50_000);
    public static final Employee EMPLOYEE_2 = new Employee("Иванов", "Иван", 3, 7_000);
    public static final Employee EMPLOYEE_3 = new Employee("Абрамов", "Абрам", 1, 10_000);
    public static final Employee EMPLOYEE_4 = new Employee("Захаров", "Захар", 2, 150_000);
    public static final Employee EMPLOYEE_5 = new Employee("Игнатов", "Игнат", 3, 15_000);

    public static final Set<Employee> TEST_SET_EMPLOYEE = new HashSet<>(Set.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3, EMPLOYEE_4, EMPLOYEE_5));
    public static final List<Employee> TEST_SORTED_LIST_EMPLOYEE = new ArrayList<>(List.of(EMPLOYEE_3, EMPLOYEE_4, EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_5));
    public static final List<Employee> TEST_SORTED_DEPART_LIST_EMPLOYEE = new ArrayList<>(List.of(EMPLOYEE_4, EMPLOYEE_1));

}
