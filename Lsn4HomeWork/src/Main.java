

public class Main {
    public static void main(String[] args) {
        EmployeeServices dir = new EmployeeServices();

        Employee employee1 = new Employee(1,123456,"Sveta",5);
        Employee employee2 = new Employee(2,456789,"Katya",1);
        Employee employee3 = new Employee(3,102345,"Ira",7);
        Employee employee4 = new Employee(4,123123,"Olya",3);

        dir.addEmployee(employee1);
        dir.addEmployee(employee2);
        dir.addEmployee(employee3);
        dir.addEmployee(employee4);
        System.out.println(dir);
        System.out.println();

        System.out.println("1. Поиск сотрудника по стажу = 5 (Sveta): ");
        System.out.println(dir.searchByExperience(5));

        System.out.println();
        System.out.println("2. Поиск номера телефона сотрудника по имени (Katya): ");
        System.out.println(dir.getPhoneByName("Katya"));

        System.out.println();
        System.out.println("3. Поиск сотрудника по номеру (Olya): ");
        System.out.println(dir.searchByNumber(4));

        System.out.println();
        System.out.println("4. Добавляем нового сотрудника: ");
        Employee employee5 = new Employee(5,111,"Ivan",0);
        dir.addEmployee(employee5);

        System.out.println(dir);
    }
}