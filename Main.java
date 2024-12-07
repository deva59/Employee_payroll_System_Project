package New_Project;

import java.util.ArrayList;
import java.util.List;

//*Create Employee Class using abstract keyword.
abstract class Employee{//Use Abstraction
    //Use Private Access Modifier
    //Corresponding name or variable
    private  String name;
    private int id;

    //Create Constructor - Jaisiye hamara object Create hoga vaise hi Constructor run hoga
    //Corresponding name or variable Assign this Constructor
    public Employee(String name, int id){
        this.name =name;//Corresponding name or variable Assign
        this.id = id;
    }
    //Create Get Method
    //Encapsulation use Getter or Setter Method this Method use help to user to Access
    //de sakta hu ki Oo Perticular kisi bhi value ko check kar sakta hai bina us variable ko direct access karne ke liye
    public  String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    //Create Abstract Method
    abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee[name: "+name+", id: "+id+", Salary: "+calculateSalary()+"]";
    }
}

//Use Inheritance
//*Create Full Time Employee*..
class FullTimeEmployee extends Employee { //First Priroty Create abstraction methods
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);//Run the Parent class ya this Parent class constructor
        this.monthlySalary=monthlySalary;//Isi perticulaer class ka data hai to main yahi pe assign kar dunga.
    }

    //Use Polymorphism
    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

//*Create PartTime Employee
class PartTimeEmployee extends Employee {
    //Monthly Salary normally variable se calculate nahi hogi uske liye humko number of hours or hourly rate chahiye iske liye

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id,int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    //Use Polymorphism
    @Override
    double calculateSalary() {
        // part time emplyoee ki salary calculate karenge hoursWorked multiply by hourlyRate(Eg.ek emp ne 5 hours work kiya to uska total salary 500rs hoga.
        return hoursWorked * hourlyRate;

    }
}

//Create PayrollSystem.
class PayrollSystem {
    //Its Use Collection Framework
    //apna data hetrogenous hai isliye humne List ka use kiya Acess karne liye.
    private List<Employee> employeelist;//Employee is liye likha gaya hai ki humara har ek object is list ke under store hoga.

    public PayrollSystem() {//Ye construcor ke under ye perticular create kiya gaya Employeelist ke emplyoee data rakne ke liye use ki gaya hai
        employeelist = new ArrayList<>();
    }

    //Add employee
    public void addEmployee(Employee employee) {
        employeelist.add(employee);//inbuilt function add
    }


    //Remove employee
    public void removeEmployee(int id) { //Id is PrimaryKey.
        //Create Null Variable
        Employee employeeToRemove = null;
        //null-maine variable banaya jiska naam tha employeetoRemove thik hai or isko maine
        //null value assign ker di or ye jo varible hai vo Employee type ka hai merko employee remove karna hai
        //to merko Employee type ka variable chaiye tha haan vo alag bat hai ke me us variable ko findout ker raha hu ek perticular Integer Id ki help se.
        //fir me us Employee ke variable me daldunga. jaise hi oo merko milega or fir is varible ke perticular jo bhi Corresponding data hoga to vo arraylist mese remove kar dunga.


        for (Employee employee : employeelist) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeelist.remove(employeeToRemove);
        }
    }

    public void displayEmployee() {
        for (Employee employeee : employeelist) {
            System.out.println(employeee);
        }
    }
}
        class Main {
            public static void main(String[] args) {
                //Create Object
                PayrollSystem payrollSystem = new PayrollSystem();

                //Create Object of FullTimeEmployee Assingn default Constructor Values
                FullTimeEmployee emp1 = new FullTimeEmployee("Devendra", 101, 70000.0);

                //Create Object of PartTimeEmployee Assingn default Constructor Values
                PartTimeEmployee emp2 = new PartTimeEmployee("Rohan", 102, 40, 100);

                //Insert value in ArrayList Using add function
                payrollSystem.addEmployee(emp1);
                payrollSystem.addEmployee(emp2);

                //Get details from user
                System.out.println("Intial Employee Details: ");
                payrollSystem.displayEmployee();

                System.out.println("Removing Employees");
                payrollSystem.removeEmployee(102);

                System.out.println("Remainig Employess Details: ");
                payrollSystem.displayEmployee();


            }
        }

