import java.util.Random;

public class Enemy_Boss{


    private static String X_Name = "Empty";
    private static int X_Hp = 1;
    private static int X_min_dmg = 0;
    private static int X_max_dmg = 1;
    private static int X_Armor = 0;
    private static int X_Speed = 0;

    public Enemy_Boss(String Name, int Hp, int min_dmg, int max_dmg, int Armor, int speed)
    {
        this.X_Name = Name;
        this.X_Hp = Hp;
        this.X_min_dmg = min_dmg;
        this.X_max_dmg = max_dmg;
        this.X_Armor = Armor;
        this.X_Speed = speed;

    }

    public int Enemy_attack()
    {
        return 0;
    }
}
