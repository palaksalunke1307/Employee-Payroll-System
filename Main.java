import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    Employee(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }
    abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    FullTimeEmployee(String name, int id,double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){

        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee{
    private int hoursworked;
    private double hourlyrate;

    public PartTimeEmployee(String name,int id,int hoursworked,double hourlyrate){

        super(name,id);
        this.hoursworked = hoursworked;
        this.hourlyrate = hourlyrate;
    }

    @Override
    public double calculateSalary() {
        return hoursworked * hourlyrate;
    }
}
class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;

        for(Employee employee : employeeList){

            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
    }
            if(employeeToRemove !=  null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Karan", 23, 40000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Abhi", 76, 54500);
        PartTimeEmployee emp3 = new PartTimeEmployee("Satendra", 12, 230,200);
        PartTimeEmployee emp4 = new PartTimeEmployee("Raghav", 34, 150,300);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);

        System.out.println("Initial Employee Details :");
        payrollSystem.displayEmployee();

        System.out.println("\n Removing Employee");
        payrollSystem.removeEmployee(34);
        payrollSystem.displayEmployee();

    }
}