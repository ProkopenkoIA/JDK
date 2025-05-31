public class Employee {

    private int serviceNumber;
    private int phoneNumber;
    private String name;
    private int workExperience;

    public Employee(int serviceNumber, int phoneNumber, String name, int workExperience) {
        this.name = name;
        this.workExperience = workExperience;
        this.phoneNumber = phoneNumber;
        this.serviceNumber = serviceNumber;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "\n" +
                "{" +
                "Табельный номер = " + serviceNumber +
                ", Номер телефона = " + phoneNumber +
                ", Имя = '" + name + '\'' +
                ", Стаж = " + workExperience +
                '}';
    }
}
