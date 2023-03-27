import javax.swing.*;
import java.util.Random;

public class Player {

    private static String X_Name = "Empty";
    private static int X_Hp = 10;
    private static int X_min_dmg = 1;
    private static int X_max_dmg = 6;
    private static int X_Armor = 0;
    private static int X_Speed = 0;
    private static int X_current_hp = 10;
    private static int X_Class = 2; ////1 = heavy; 2 = basic; 3 = light
    private static String X_weapon;
    private static ImageIcon class_icon;
    private static int SP_effect = 0;

    public Player(String Name, int Hp, int min_dmg, int max_dmg, int Armor, int speed, int Class, String Weapon, ImageIcon pic)
    {
        this.X_Name = Name;
        this.X_Hp = Hp;
        this.X_min_dmg = min_dmg;
        this.X_max_dmg = max_dmg;
        this.X_Armor = Armor;
        this.X_Speed = speed;
        this.X_weapon = Weapon;
        this.X_Class = Class;
        this.X_current_hp = X_Hp;
        this.class_icon = pic;
    }

    public static String Name()
    {
        return X_Name;
    }
    public static int HP()
    {
        return X_Hp;
    }
    public static int Current_HP()
    {
        return X_current_hp;
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
        return X_Speed + SP_effect;
    }
    public static int SPF()
    {
        return SP_effect;
    }
    public static String Weapon()
    {
        return X_weapon;
    }
    public static int Class()
    {
        return X_Class;
    }
    public static ImageIcon Class_icon()
    {
        return class_icon;
    }




    public static void change_name(String name)
    {
        X_Name = name;
    }

    public static void change_weapon(String name, int MIN, int MAX)
    {


        X_min_dmg = MIN;
        X_max_dmg = MAX;
        X_weapon = name + ": (" + String.valueOf(MIN) + " - " + String.valueOf(MAX) + ")";

    }

    public static void change_armor(int AC,int spfect)
    {

        X_Armor = AC;
        SP_effect = spfect;

    }
    public static void dmg_take(int dmg)
    {
        X_current_hp = X_current_hp - dmg;
    }

    public static void heal(int healing)
    {
        X_current_hp = X_current_hp + healing;
        if (X_current_hp > X_Hp)
        {
            X_current_hp = X_Hp;
        }


    }



    public static void Levelup_Player(boolean sp)
    {

        switch(Player.X_Class)
        {
            case 1: //Heavy class
                Player.X_Hp = X_Hp + 7;
                Player.X_current_hp = X_Hp;
                if(sp == true)
                {
                    Player.X_Speed = Player.X_Speed + 1;
                }
                break;
            case 2: //Basic class
                Player.X_Hp = X_Hp + 5;
                Player.X_current_hp = X_Hp;
                if(sp == true)
                {
                    Player.X_Speed = Player.X_Speed + 2;
                }
                break;
            case 3: //Light class
                Player.X_Hp = X_Hp + 3;
                Player.X_current_hp = X_Hp;
                if(sp == true)
                {
                    Player.X_Speed = Player.X_Speed + 3;
                }
                break;
        }

    }



}
