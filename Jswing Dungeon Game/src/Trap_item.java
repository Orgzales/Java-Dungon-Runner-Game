import java.util.Random;

public class Trap_item extends Item{

    private static String Name = "";
    private static int Total_dmg;
    private static Random Rand = new Random();

    public Trap_item(String name, int MIN, int MAX)
    {
        this.Total_dmg = Rand.nextInt(MAX - MIN) + MIN;
        this.Name = name;
    }


    public String toString() {
        return this.Name + String.valueOf(this.Total_dmg);
    }

    public int total()
    {
        return Total_dmg;

    }

    public int Type(){
        return 5;
    }
}
