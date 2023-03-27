import java.util.Random;

public class Dmg_Item extends Item{

    private static String Name = "";
    private static int Max_amount;
    private static int Min_amount;
    private static Random Rand = new Random();

    public Dmg_Item(int MIN, int MAX)
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
                this.Name = "Bomb: ";
                break;
            case 1:
                this.Name = "Throwing Knife: ";
                break;
            case 2:
                this.Name = "Dart: ";
                break;
        }
        return null;
    }

    public String toString() {
        return this.Name + "( " + String.valueOf(this.Min_amount) + " - " + String.valueOf(this.Max_amount) + ") DMG";
    }

    public int total()
    {

        return Rand.nextInt(Max_amount - Min_amount + 1) + Min_amount;
    }

    public int Type(){
        return 2;
    }

}
