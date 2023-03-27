import java.util.Random;

public class Healing_Item extends Item {

    private static String Name = "";
    private static int Max_amount;
    private static int Min_amount;
    private static Random Rand = new Random();

    public Healing_Item(int MIN, int MAX)
    {

        Create_Name();
        this.Min_amount = MIN;
        this.Max_amount = MAX;

    }

    public String Create_Name()
    {

        int choice = Rand.nextInt(3);

        switch (choice){
            case 0:
                this.Name = "HP - Potion: ";
                break;
            case 1:
                this.Name = "Steak: ";
                break;
            case 2:
                this.Name = "Ration: ";
                break;
        }
        return null;
    }

    public String toString() {
        return this.Name + "( " + String.valueOf(this.Min_amount) + " - " + String.valueOf(this.Max_amount) + ") HEALING";
    }

    public int total()
    {
        return Rand.nextInt(Max_amount - Min_amount + 1) + Min_amount;
    }

    public int Type(){
        return 1;
    }



}
