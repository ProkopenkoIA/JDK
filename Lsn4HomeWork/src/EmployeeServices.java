
import java.util.ArrayList;

public class EmployeeServices {
    ArrayList<Employee> employees;

    public EmployeeServices() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public ArrayList<Employee> searchByExperience(int workExperience) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees) {
            if (employee.getWorkExperience() == workExperience) {
                result.add(employee);
            }
        }
        return result;
    }

    public ArrayList<Employee> getPhoneByName(String name) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    public Employee searchByNumber(int serviceNumber) {
        for (Employee employee : this.employees) {
            if (employee.getServiceNumber() == serviceNumber) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Сотрудники: " + "\n" + employees;
    }
}
