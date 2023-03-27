import java.util.Random;

public class Enemy {

    private static String X_Name = "Empty";
    private static int X_Hp = 1;
    private static int X_min_dmg = 0;
    private static int X_max_dmg = 1;
    private static int X_Armor = 0;
    private static int X_Speed = 0;

    public Enemy(String Name, int Hp, int min_dmg, int max_dmg, int Armor, int speed)
    {
        this.X_Name = Name;
        this.X_Hp = Hp;
        this.X_min_dmg = min_dmg;
        this.X_max_dmg = max_dmg;
        this.X_Armor = Armor;
        this.X_Speed = speed;

    }

    public static String Name()
    {
        return X_Name;

    }

    public static int HP()
    {
        return X_Hp;
    }
    public static int Min_Dmg()
    {
        return X_min_dmg;
    }
    public static int Max_Dmg()
    {
        return X_max_dmg;
    }
    public static int AC()
    {
        return X_Armor;
    }
    public static int SP()
    {
        return X_Speed;
    }
    public static void dmg_take(int dmg)
    {
        X_Hp = X_Hp - dmg;
    }

}
