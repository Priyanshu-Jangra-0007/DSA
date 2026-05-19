class animal{
    String name;
    void breath(){
        System.out.println(name+" breathes ");
    }
    void makesound(){
        System.out.println("...");
    }
}
class dog extends animal{
    @Override
    void makesound(){
        System.out.println("woof !!");
    }
    void fetch(){
        System.out.println("fetching ");
    }
}
public class Inheritence{
    public static void main(String[] args) {
        dog d=new dog();
        d.name="Tommy";
        d.breath();
        d.makesound();
        d.fetch();
    }
}