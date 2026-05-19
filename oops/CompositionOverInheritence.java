// class brain{
//     void think(){
//         System.out.println("Brain think");
//     }
// }
// class heart{
//     void pump(){
//         System.out.println("Heart Pump");
//     }
// }
// class Human {
//     heart h=new heart();
//     brain b=new brain();
//     void live(){
//         h.pump();
//         b.think();
//         System.out.println("Human Alive");
//     }
// }
class Employee {
    double calculateBonus(double salary) {
        return salary * 0.10; // 10% for all employees
    }
}

class SalesEmployee extends Employee {
    @Override
    double calculateBonus(double salary) {
        return salary * 0.25; // 25% commission-based override
    }
}


public class CompositionOverInheritence{
    public static void main(String[] args) {
        // Human h=new Human();
        // h.live();
        Employee emp = new SalesEmployee(); // supertype reference
        System.out.println(emp.calculateBonus(10000));

    }
}
