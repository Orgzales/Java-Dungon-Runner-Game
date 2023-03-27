import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.lang.model.element.Element;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;
import javax.xml.transform.OutputKeys;


public class Main extends JFrame{

    private static Random Rand = new Random();

    private static Player Player = new Player("NONMAE", 10, 1, 6, 12,2, 2, "Weapon: Short Sword ( 1 - 6 ) dmg", new ImageIcon("src/pics/Basic class.jpg"));
    private static int player_level = 1;

    private static JPanel top = new JPanel();
    private static JTextPane side = new JTextPane();
    private static JTextPane playerinfo = new JTextPane();
    private static StyledDocument doc = side.getStyledDocument();
    private static JLabel Title = new JLabel();
    private static JFrame Main;
    private static JFrame New_Player_GUI;

    private static Enemy Enemy1;
    private static int Player_current_dmg = 0;
    private static int Enemy_current_dmg = 0;
    private static int current_level = 1;
    private static boolean is_enemy_dead = true;

    private static int Enemy_Count = 5;
    private static int Highscore = 0;
    private static int kill_count = 0;
    private static int level_up_req = 5;
    private static int Chest_kill_req = 6;

    private static Item[] invo_items = new Item[15];

    public static void main(String[] args)
    {
        Main_menu();
        //New_Player();
        //GUI_CREAT();

    }

    private static void Main_menu()
    {

        GUI Window = new GUI("BLOOD RUSH", 600, 800, Color.BLACK);
        Main = Window.Create_GUI();

        GridBagLayout a = new GridBagLayout();
        Main.setLayout(a);
        Unity gbc = new Unity();
        JButton Start_Button = new JButton("START");
        JButton Tutorial_Button = new JButton("TUTORIAL");
        JButton Continue = new JButton("SOMETING");
        JButton Exit_Button = new JButton("EXIT");

        JLabel Title = new JLabel(new ImageIcon("src/pics/Title.jpg"));
        Main.add(Title);
        Main.add(Start_Button, gbc.gbc(0,1,GridBagConstraints.BOTH,200,100,0,2));
        Main.add(Tutorial_Button, gbc.gbc(0,2,GridBagConstraints.BOTH,200,100,0,2));
        Main.add(Continue, gbc.gbc(0,3,GridBagConstraints.BOTH,200,100,0,2));
        Main.add(Exit_Button, gbc.gbc(0,4,GridBagConstraints.BOTH,200,100,0,2));

        JLabel Aurther = new JLabel("Created By: Orion G."); //clean this code later
        Aurther.setHorizontalAlignment(SwingConstants.RIGHT);
        Aurther.setVerticalAlignment(SwingConstants.TOP);
        Main.add(Aurther, gbc.gbc(0,5,GridBagConstraints.BOTH,200,100,0,2));

        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.setLocationRelativeTo(null); //set window in center of screen
        Main.setVisible(true);

        Start_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.dispose();
                New_Player();
            }
        });

        Tutorial_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tutuorial();
            }
        });

        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "SOMETHING",
                        "SOMETHING", 0, null );
            }
        });

        Exit_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dispose();
            }
        });
    }


    private static void Tutuorial()
    {
        ImageIcon icon = new ImageIcon("src/pics/Tutorial.jpg");

        JOptionPane.showMessageDialog(null, "",
                "TUTORIAL", 0, icon );
    }


    private static void New_Player()
    {

        //-----------------------------BASIC FRAME-------------------------------
        GUI Window = new GUI("BLOOD RUSH", 600, 800, Color.BLACK);
        New_Player_GUI = Window.Create_GUI();

        GridBagLayout a = new GridBagLayout();
        New_Player_GUI.setLayout(a);
        Unity gbc = new Unity();

        Border WhiteB = BorderFactory.createLineBorder(Color.white, 2);

        JLabel Title = new JLabel("~ CREATE  CHARATER ~");
        Title.setFont(new Font("Serif", Font.BOLD, 36));
        Title.setHorizontalAlignment(SwingConstants.CENTER);

        New_Player_GUI.add(Title, gbc.gbc(0,0, GridBagConstraints.CENTER, 0, 0, 0, 0, 3, 1));

        //-----------------------------Classes to pick-------------------------------

        JLabel HeavyIcon = new JLabel(new ImageIcon("src/pics/Heavy Class.jpg"));
        JLabel BasicIcon = new JLabel(new ImageIcon("src/pics/Basic class.jpg"));
        JLabel LightIcon = new JLabel(new ImageIcon("src/pics/light class.jpg"));


        HeavyIcon.setBorder(WhiteB);
        BasicIcon.setBorder(WhiteB);
        LightIcon.setBorder(WhiteB);

        New_Player_GUI.add(HeavyIcon, gbc.gbc(0,1, GridBagConstraints.BOTH, 25, 0, 0, 0, 1, 1));
        New_Player_GUI.add(BasicIcon, gbc.gbc(1,1, GridBagConstraints.BOTH, 25, 0, 0, 0, 1, 1));
        New_Player_GUI.add(LightIcon, gbc.gbc(2,1, GridBagConstraints.BOTH, 25, 0, 0, 0, 1, 1));

        JButton Heavy_select = new JButton("Heavy Class");
        JButton Basic_select = new JButton("Basic Class");
        JButton Light_select = new JButton("Light Class");

        Heavy_select.setBackground(Color.LIGHT_GRAY);
        Heavy_select.setOpaque(true);
        Basic_select.setBackground(Color.LIGHT_GRAY);
        Basic_select.setOpaque(true);
        Light_select.setBackground(Color.LIGHT_GRAY);
        Light_select.setOpaque(true);

        New_Player_GUI.add(Heavy_select, gbc.gbc(0, 2, 0, 25, 10, 0, 0, 1,1, new Insets(25,0,0,0)  ));
        New_Player_GUI.add(Basic_select, gbc.gbc(1, 2, 0, 25, 10, 0, 0, 1,1, new Insets(25,0,0,0) ));
        New_Player_GUI.add(Light_select, gbc.gbc(2, 2, 0, 25, 10, 0, 0, 1,1, new Insets(25,0,0,0) ));


        //-----------------------------CLASSES TEXT -------------------------------

        JLabel Basic_Title = new JLabel("} BASIC CLASS {");
        Basic_Title.setFont(new Font("Serif", Font.BOLD, 48));
        Basic_Title.setHorizontalAlignment(SwingConstants.CENTER);
        Basic_Title.setForeground(Color.red);

        JLabel Basic_HP_stat = new JLabel("Health Points: 10");
        Basic_HP_stat.setFont(new Font("Serif", Font.ITALIC, 32));
        Basic_HP_stat.setForeground(Color.red);

        JLabel Basic_AC_stat = new JLabel("Armor Class: 12");
        Basic_AC_stat.setFont(new Font("Serif", Font.ITALIC, 32));
        Basic_AC_stat.setForeground(Color.red);

        JLabel Basic_SP_stat = new JLabel("Speed Bonus: +2");
        Basic_SP_stat.setFont(new Font("Serif", Font.ITALIC, 32));
        Basic_SP_stat.setForeground(Color.red);

        JLabel Basic_Weapon = new JLabel("Weapon: Short Sword ( 1 - 6 ) dmg");
        Basic_Weapon.setFont(new Font("Serif", Font.ITALIC, 32));
        Basic_Weapon.setForeground(Color.red);

        New_Player_GUI.add(Basic_Title, gbc.gbc(0, 3, 0, 0, 0, 0, 0, 3,1, new Insets(5,0,0,0) ));
        New_Player_GUI.add(Basic_HP_stat, gbc.gbc(0, 4, 0, 0, 0, 0, 0, 3,1 ));
        New_Player_GUI.add(Basic_AC_stat, gbc.gbc(0, 5, 0, 0, 0, 0, 0, 3,1 ));
        New_Player_GUI.add(Basic_SP_stat, gbc.gbc(0, 6, 0, 0, 0, 0, 0, 3,1 ));
        New_Player_GUI.add(Basic_Weapon, gbc.gbc(0, 7, 0, 0, 0, 0, 0, 3,1 ));




        //-----------------------------Buttons Actions-------------------------------

        JLabel Name = new JLabel("NAME:");
        Name.setFont(new Font("Serif", Font.BOLD, 24));
        Name.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField test = new JTextField(15);
        test.setHorizontalAlignment(SwingConstants.LEFT);
        JButton submit = new JButton("CREATE CHARATER");


        New_Player_GUI.add(Name, gbc.gbc(0, 8, GridBagConstraints.HORIZONTAL, 0, 10, 0, 0, 1,1, new Insets(25,0,0,0) ));
        New_Player_GUI.add(test,gbc.gbc(1, 8, GridBagConstraints.HORIZONTAL, 0, 10, 0, 0, 2,1, new Insets(25,0,0,0) ));
        New_Player_GUI.add(submit,gbc.gbc(0, 9, GridBagConstraints.BOTH, 50, 30, 0, 0, 3,2 ));

        Heavy_select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Basic_Title.setText("} HEAVY CLASS {");
                Basic_HP_stat.setText("Health Points: 15");
                Basic_AC_stat.setText("Armor Class: 13");
                Basic_SP_stat.setText("Speed Bonus: 0");
                Basic_Weapon.setText("Weapon: Battle Axe ( 2 - 8 )");

                Player = new Player("", 15, 2, 8, 13,0, 1, Basic_Weapon.getText(), new ImageIcon("src/pics/Heavy Class.jpg"));

                Basic_Title.setForeground(Color.blue);
                Basic_HP_stat.setForeground(Color.blue);
                Basic_AC_stat.setForeground(Color.blue);
                Basic_SP_stat.setForeground(Color.blue);
                Basic_Weapon.setForeground(Color.blue);
            }
        });

        Basic_select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Basic_Title.setText("} BASIC CLASS {");
                Basic_HP_stat.setText("Health Points: 10");
                Basic_AC_stat.setText("Armor Class: 12");
                Basic_SP_stat.setText("Speed Bonus: +2");
                Basic_Weapon.setText("Weapon: Short Sword ( 1 - 6 )");


                Player = new Player("", 10, 1, 6, 12,2, 2, Basic_Weapon.getText(), new ImageIcon("src/pics/Basic class.jpg" ));


                Basic_Title.setForeground(Color.red);
                Basic_HP_stat.setForeground(Color.red);
                Basic_AC_stat.setForeground(Color.red);
                Basic_SP_stat.setForeground(Color.red);
                Basic_Weapon.setForeground(Color.red);
            }
        });

        Light_select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Basic_Title.setText("} LIGHT CLASS {");
                Basic_HP_stat.setText("Health Points: 8");
                Basic_AC_stat.setText("Armor Class: 11");
                Basic_SP_stat.setText("Speed Bonus: +4");
                Basic_Weapon.setText("Weapon: Sharp Dagger ( 1 - 4 )");

                Player = new Player("", 8, 1, 4, 11,4, 3, Basic_Weapon.getText(), new ImageIcon("src/pics/light class.jpg"));


                Basic_Title.setForeground(Color.MAGENTA);
                Basic_HP_stat.setForeground(Color.MAGENTA);
                Basic_AC_stat.setForeground(Color.MAGENTA);
                Basic_SP_stat.setForeground(Color.MAGENTA);
                Basic_Weapon.setForeground(Color.MAGENTA);

            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Player.change_name(test.getText());


                int n = JOptionPane.showConfirmDialog(null, "Name: " + Player.Name() + "\n" + Basic_Title.getText() + "\nHP: " +
                                                String.valueOf(Player.HP()) + "\nAC: " + String.valueOf(Player.AC()) + "\nSP: " + String.valueOf(Player.SP())
                                                + "\n" + Player.Weapon() + "\n", "Confirm Charater", JOptionPane.OK_CANCEL_OPTION, 0, Player.Class_icon());

                if( n == JOptionPane.OK_OPTION)
                {
                    New_Player_GUI.dispose();
                    GUI_CREAT();
                }

            }
        });

        New_Player_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        New_Player_GUI.setLocationRelativeTo(null); //set window in center of screen
        New_Player_GUI.setVisible(true);

    }


    private static void GUI_CREAT()
    {
        GUI Window = new GUI("BLOOD RUSH", 1300, 600, Color.BLACK);
        JFrame Game = Window.Create_GUI();
        GridBagLayout a = new GridBagLayout();
        Unity gbc = new Unity();

        top.setLayout(a);
        top.setBackground(Color.BLACK);

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.BLACK);
        bottom.setLayout(new GridLayout(1,4)); //change to gridbag layout

        JPanel clear = new JPanel(); //for clear button
        clear.setLayout(a);
        clear.setBackground(Color.black);
        side.setEditable(false);
        side.setBackground(Color.black);
        side.setForeground(Color.white);
        JScrollPane sidescroll = new JScrollPane(side); // for scroll bar

        playerinfo.setEditable(false);
        playerinfo.setBackground(Color.BLACK);
        playerinfo.setForeground(Color.WHITE);
        playerinfo.setFont(new Font("Arial", Font.BOLD, 18));
        Player_info_update();

        //clear button for updater
        JButton Clear_all = new JButton("CLEAR ALL");
        Clear_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                side.setText("");
            }
        });
        clear.add(Clear_all);

        JSplitPane JS = new JSplitPane(JSplitPane.VERTICAL_SPLIT, top, bottom);
        JS.setDividerLocation(450);
        JSplitPane JC = new JSplitPane(JSplitPane.VERTICAL_SPLIT, playerinfo, sidescroll);
        JC.setDividerLocation(180);
        JSplitPane JI = new JSplitPane(JSplitPane.VERTICAL_SPLIT, JC, clear);
        JI.setDividerLocation(500);

        JSplitPane JY = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, JS, JI);
        JY.setDividerLocation(980);
        Game.setContentPane(JY);
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border WhiteB = BorderFactory.createLineBorder(Color.red, 2);


        Title.setFont(new Font("Serif", Font.BOLD, 50));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setVerticalTextPosition(SwingConstants.NORTH);
        Title.setForeground(Color.RED);
        Title.setBackground(Color.BLACK);
        Title.setBorder(WhiteB);
        Title.setText("~~~ Level " + String.valueOf(current_level) + " ~~~");

        JLabel Hero = new JLabel();

        switch (Player.Class())
        {
            case 1:
                Hero = new JLabel(new ImageIcon("src/pics/hero2.png"));
                break;
            case 2:
                Hero = new JLabel(new ImageIcon("src/pics/hero1.png"));
                break;
            case 3:
                Hero = new JLabel(new ImageIcon("src/pics/hero3.png"));
                break;
        }

        JLabel Enemy = new JLabel(new ImageIcon("src/pics/skeleton.png "));
        JLabel Spcaer = new JLabel(new ImageIcon("src/pics/spacer.png"));

        top.add(Title, gbc.gbc(0,0,GridBagConstraints.HORIZONTAL, 0,0,0,0,5,2));
        top.add(Hero, gbc.gbc(0,2,0, 0,0,0,0,1,1));
        top.add(Spcaer, gbc.gbc(1,2,0, 0,0,0,0,1,1));


        JButton QATK_Button = new JButton("QUICK ATTACK");
        JButton NATK_Button = new JButton("NORMAL ATTACK");
        JButton HATK_Button = new JButton("HEAVY ATTACK");
        JButton Invo_Button = new JButton("Inventory");

        QATK_Button.setBounds(20,20,200,50);
        NATK_Button.setBounds(20,20,200,50);
        HATK_Button.setBounds(20,20,200,50);
        Invo_Button.setBounds(20,20,200,50);

        QATK_Button.setFont(new Font("Architects Daughter", Font.BOLD, 20));
        NATK_Button.setFont(new Font("Architects Daughter", Font.BOLD, 20));
        HATK_Button.setFont(new Font("Architects Daughter", Font.BOLD, 20));
        Invo_Button.setFont(new Font("Architects Daughter", Font.BOLD, 20));

        bottom.add(QATK_Button);
        bottom.add(NATK_Button);
        bottom.add(HATK_Button);
        bottom.add(Invo_Button);

        Game.setLocationRelativeTo(null); //set window in center of screen
        Game.setVisible(true);

        Timer animation = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top.add(Spcaer, gbc.gbc(1,2,0, 0,0,0,0,1,1));
                top.revalidate();
                top.repaint();
                top.setBackground(Color.BLACK);
            }
        });

        Timer Enemy_animation = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top.add(Enemy, gbc.gbc(2,2,0, 0,0,0,0,1,1));
                top.revalidate();
                top.repaint();


            }
        });


        //////////GAME CONTROLS////////////////
        Style style = side.addStyle("Arial", null);
        Enemy_animation.start();
        QATK_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                top.remove(Spcaer);
                top.revalidate();
                top.repaint();
                top.setBackground(Color.RED);
                animation.start();


                if(is_enemy_dead == true) {
                    create_enemy(current_level);

                }
                Player_turn(Enemy1.AC(), Player.SP(), 2, Math.round(Player.Min_Dmg()));

                if(Enemy1.HP() <= 0)
                {



                    Enemy_Count = Enemy_Count - 1;
                    StyleConstants.setForeground(style, Color.orange);
                    update("\n" + Enemy1.Name() + " IS DEAD!" , style);
                    is_enemy_dead = true;
                    top.remove(Enemy);
                    top.revalidate();
                    top.repaint();
                    Player_info_update();

                    kill_count = kill_count + 1;
                    if (kill_count >= level_up_req)
                    {
                        Level_up();
                    }

                    if (kill_count >= Chest_kill_req)
                    {
                        Chest();
                    }

                    if (Enemy_Count <= 0){
                        next_level();
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }
                    else
                    {
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }

                }
                else
                {
                    Enemy_turn(Player.AC(), Enemy1.SP());
                }

                if(Player.Current_HP() <= 0)
                {
                    StyleConstants.setForeground(style, Color.red);
                    update("\n" + Player.Name() + "IS DEAD... GAME OVER", style);
                    JOptionPane.showMessageDialog(null, "GAME OVER\n HIGHSCORE: "  + String.valueOf(Highscore) + "\nENEMIES KILLED: " + String.valueOf(kill_count), "YOU ARE DEAD", JOptionPane.OK_OPTION);
                    Enemy_animation.stop();
                    Game.dispose();
                    Game_over();

                }


            }
        });

        NATK_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                top.remove(Spcaer);
                top.revalidate();
                top.repaint();
                top.setBackground(Color.RED);
                animation.start();

                if(is_enemy_dead == true) {
                    create_enemy(current_level);
                }
                Player_turn(Enemy1.AC(), Player.SP(), 0, Math.round(Player.Max_Dmg()/2));

                if(Enemy1.HP() <= 0)
                {

                    Enemy_Count = Enemy_Count - 1;
                    StyleConstants.setForeground(style, Color.orange);
                    update("\n" + Enemy1.Name() + " IS DEAD!" , style);
                    is_enemy_dead = true;
                    top.remove(Enemy);
                    top.revalidate();
                    top.repaint();
                    Player_info_update();

                    kill_count = kill_count + 1;
                    if (kill_count == level_up_req)
                    {
                        Level_up();
                    }

                    if (kill_count >= Chest_kill_req)
                    {
                        Chest();
                    }

                    if (Enemy_Count <= 0){
                        next_level();
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }
                    else
                    {
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }

                }
                else
                {
                    Enemy_turn(Player.AC(), Enemy1.SP());
                }

                if(Player.Current_HP() <= 0)
                {
                    StyleConstants.setForeground(style, Color.red);
                    update("\n" + Player.Name() + " IS DEAD... GAME OVER", style);
                    JOptionPane.showMessageDialog(null, "GAME OVER\n HIGHSCORE: "  + String.valueOf(Highscore) + "\nENEMIES KILLED: " + String.valueOf(kill_count), "YOU ARE DEAD", JOptionPane.OK_OPTION);
                    Enemy_animation.stop();
                    Game.dispose();
                    Game_over();
                }


            }
        });

        HATK_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top.remove(Spcaer);
                top.revalidate();
                top.repaint();
                top.setBackground(Color.RED);
                animation.start();

                if(is_enemy_dead == true) {
                    create_enemy(current_level);
                }
                Player_turn(Enemy1.AC(), Player.SP(), -2, Math.round(Player.Max_Dmg()));


                if(Enemy1.HP() <= 0)
                {


                    Enemy_Count = Enemy_Count - 1;
                    StyleConstants.setForeground(style, Color.orange);
                    update("\n" + Enemy1.Name() + " IS DEAD!" , style);
                    is_enemy_dead = true;
                    top.remove(Enemy);
                    top.revalidate();
                    top.repaint();
                    Player_info_update();

                    kill_count = kill_count + 1;
                    if (kill_count == level_up_req)
                    {
                        Level_up();
                    }

                    if (kill_count >= Chest_kill_req)
                    {
                        Chest();
                    }

                    if (Enemy_Count <= 0){
                        next_level();
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }
                    else
                    {
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }

                }
                else
                {
                    Enemy_turn(Player.AC(), Enemy1.SP());
                }

                if(Player.Current_HP() <= 0)
                {
                    StyleConstants.setForeground(style, Color.red);
                    update("\n" + Player.Name() + "IS DEAD... GAME OVER", style);
                    JOptionPane.showMessageDialog(null, "GAME OVER\n HIGHSCORE: "  + String.valueOf(Highscore) + "\nENEMIES KILLED: " + String.valueOf(kill_count), "YOU ARE DEAD", JOptionPane.OK_OPTION);
                    Enemy_animation.stop();
                    Game.dispose();
                    Game_over();
                }



            }
        });


        Invo_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory_GUI();

                if(is_enemy_dead == true) {
                    create_enemy(current_level);
                }
                if(Enemy1.HP() <= 0)
                {

                    Enemy_Count = Enemy_Count - 1;
                    StyleConstants.setForeground(style, Color.orange);
                    update("\n" + Enemy1.Name() + " IS DEAD!" , style);
                    is_enemy_dead = true;
                    top.remove(Enemy);
                    top.revalidate();
                    top.repaint();
                    Player_info_update();

                    kill_count = kill_count + 1;
                    if (kill_count == level_up_req)
                    {
                        Level_up();
                    }

                    if (kill_count >= Chest_kill_req)
                    {
                        Chest();
                    }

                    if (Enemy_Count <= 0){
                        next_level();
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }
                    else
                    {
                        Enemy_animation.start();
                        StyleConstants.setForeground(style, Color.blue);
                        update("\nNEW " + Enemy1.Name() + " IS COMING!!!", style);
                    }

                }
            }
        });


    }


    private static void update(String str, Style stuff)
    {
        try { doc.insertString(doc.getLength(), str,stuff); }
        catch (BadLocationException e){}

    }

    private static void Player_turn(int EAC, int PSP, int att_mod, int dmg_mod) //ENenmy sp
    {
        int hit_chance = Rand.nextInt(20) + att_mod;
        if (hit_chance > EAC)
        {
            Player_current_dmg = (Rand.nextInt(Player.Max_Dmg() - Player.Min_Dmg() + 1) + Player.Min_Dmg()) + dmg_mod;
            Enemy1.dmg_take(Player_current_dmg);
            Style style = side.addStyle("Arial", null);
            StyleConstants.setForeground(style, Color.green);
            update("\n" + Player.Weapon() +" HITS: " + String.valueOf(Player_current_dmg) + " DMG", style);
            Highscore = Highscore + (Player_current_dmg * 100);
            Player_info_update();
        }
        else
        {
            Player_current_dmg = 0;
            Style style = side.addStyle("Arial", null);
            StyleConstants.setForeground(style, Color.pink);
            update("\n" + Player.Weapon() +" MISSES: 0 DMG", style);
            Highscore = Highscore + 1;
            Player_info_update();

        }

    }



    private static void Enemy_turn(int PAC, int ESP)
    {
        int hit_chance = Rand.nextInt(20) + ESP;
        if(hit_chance > PAC)
        {
            Enemy_current_dmg = Rand.nextInt(Enemy1.Max_Dmg() - Enemy1.Min_Dmg() +1) + Enemy1.Min_Dmg();
            Player.dmg_take(Enemy_current_dmg);
            Style style = side.addStyle("Arial", null);
            StyleConstants.setForeground(style, Color.red);
            update("\n" + Enemy1.Name() + " HITS YOU FOR: "+ String.valueOf(Enemy_current_dmg) + " DMG",style);
            Highscore = Highscore + (Enemy_current_dmg * 10);
            Player_info_update();
        }
        else
        {
            Enemy_current_dmg = 0;
            Style style = side.addStyle("Arial", null);
            StyleConstants.setForeground(style, Color.magenta);
            update("\n" + Enemy1.Name() + " MISSSS YOU: 0 DMG",style);
            Highscore = Highscore + 5;
            Player_info_update();
        }

    }

    private static void Player_info_update()
    {

        switch(Player.Class()) {
            case 1:
                playerinfo.setForeground(Color.blue);
                break;
            case 2:
                playerinfo.setForeground(Color.red);
                break;
            case 3:
                playerinfo.setForeground(Color.magenta);
                break;
        }

        playerinfo.setText(Player.Name() + " LV." + String.valueOf(player_level) +"\nHP: " + String.valueOf(Player.Current_HP()) + "\nAC: " + String.valueOf(Player.AC()) + "\nSP: " + String.valueOf(Player.SP() + "\n\nHIGHSCORE: " +
                String.valueOf(Highscore) + "\nEnemies Remaining: " + String.valueOf(Enemy_Count)));
    }



    private static void next_level()
    {
        current_level = current_level + 1;
        Enemy_Count = Rand.nextInt(5) + 5 + current_level;
        JOptionPane.showMessageDialog(null, "CONGRATS, YOU CLEARED THE FLOOR! \nNOW CONTINUE TO LEVEL " + String.valueOf(current_level), "PROGRESS", JOptionPane.OK_OPTION, Player.Class_icon());
        Title.setText("~~~ Level " + String.valueOf(current_level) + " ~~~");
        Style style = side.addStyle("Arial", null);
        StyleConstants.setForeground(style, Color.GRAY);
        update("\nYOU COMPLETED LEVEL " + String.valueOf( current_level - 1) ,style);
        Highscore = Highscore + (current_level * 1000);
        Player_info_update();

    }

    private static void Chest()
    {

        Style style = side.addStyle("Arial", null);
        StyleConstants.setForeground(style, Color.RED);
        update("\nYOU FIND A CHEST!",style);

        ImageIcon chest_pic = new ImageIcon("src/pics/special chest.png");
        int n = JOptionPane.showConfirmDialog(null, "YOU FOUND A CHEST! DO YOU DARE OPEN IT???", "OOO! SHINY CHEST!", JOptionPane.YES_NO_OPTION,0,chest_pic);
        if (n == JOptionPane.YES_OPTION)
        {
            int type = Rand.nextInt(5) +1;
            int arrayspot = 0;
            int min, max, AC, Sp;
            Item item_found;

            for(int x = 0; x < invo_items.length; x++){
                if (invo_items[x] == null)
                {
                    arrayspot = x;
                    break;
                }

            }

            StyleConstants.setForeground(style, Color.YELLOW);
            switch(type) { //1 = healing, 2 = dmg, 3 = weapon, 4 = armor 5 = trap
                case 1:

                    min = player_level;
                    max = player_level * 4;
                    item_found = new Healing_Item(min , max);
                    invo_items[arrayspot] = item_found;
                    JOptionPane.showMessageDialog(null, "YOU FOUND: " + item_found.toString(), "NEW ITEM", JOptionPane.OK_OPTION, Player.Class_icon());
                    update("\n" + Player.Name() + " Found: " + item_found.toString() ,style);
                    break;

                case 2:
                    min = player_level;
                    max = player_level * 4;
                    item_found = new Dmg_Item(min , max);
                    invo_items[arrayspot] = item_found;
                    JOptionPane.showMessageDialog(null, "YOU FOUND: " + item_found.toString(), "NEW ITEM", JOptionPane.OK_OPTION, Player.Class_icon());
                    update("\n" + Player.Name() + " Found: " + item_found.toString() ,style);
                    break;

                case 3:
                    min = Rand.nextInt(player_level) + 1;
                    max = Rand.nextInt(((player_level + 1) * 2) ) + min;
                    String name = "weapon" ;
                    switch(Player.Class())
                    {
                        case 1:
                            name = "Great Axe";
                            break;
                        case 2:
                            name = "Short Sword";
                            break;
                        case 3:
                            name = "Dagger";
                            break;
                    }
                    String weapon =  name + ": (" + String.valueOf(min) + " - " + String.valueOf(max) + ")";
                    int c = JOptionPane.showConfirmDialog(null, "Would you like to switch your Weapon?\n OLD WEAPON: " + Player.Weapon() + "\n NEW WEAPON: "
                            + weapon, "Switch?!", JOptionPane.YES_NO_OPTION,0,chest_pic);
                    if (c == JOptionPane.YES_OPTION) {
                        Player.change_weapon(name, min, max);
                        update("\n" + Player.Name() + " Found: NEW WEAPON" ,style);
                    }
                    break;

                case 4:
                    AC = (Rand.nextInt(6) - 3) + Player.AC();
                    Sp = Rand.nextInt(3)  + 1;


                    c = JOptionPane.showConfirmDialog(null, "Would you like to switch your Armor?\n OLD ARMOR: AC - " + String.valueOf(Player.AC()) + " | SP - "
                            + String.valueOf(Player.SP()) + " + BONUS: " + String.valueOf(Player.SPF()) + "\nNEW ARMOR: AC - " + String.valueOf(AC) + " | SP - " +
                            String.valueOf(Player.SP()) + " + BONUS: " + String.valueOf(Sp), "Switch?!", JOptionPane.YES_NO_OPTION,0,chest_pic);
                    if (c == JOptionPane.YES_OPTION) {
                        Player.change_armor(AC, Sp);
                        update("\n" + Player.Name() + " Found: NEW ARMOR" ,style);
                    }
                    break;

                case 5:
                    min = Math.round(player_level / 2);
                    max = player_level;
                    int choice = Rand.nextInt(1);
                    String trap_name = "TRAP: ";

                    StyleConstants.setForeground(style, Color.red);

                    switch (choice){
                        case 0:
                            trap_name = "Bomb Trap: ";
                            break;
                        case 1:
                            trap_name = "Gas Trap: ";
                            break;
                    }

                    item_found = new Trap_item(trap_name, min , max);

                    JOptionPane.showMessageDialog(null, "YOU WERE CAUGHT OFF GUARD: " + trap_name + " (" +
                            String.valueOf(min) + " - " + String.valueOf(max) + ")", "IT'S A TRAP!", JOptionPane.OK_OPTION, Player.Class_icon());
                    int dmg = Rand.nextInt(max - min + 1) + min;
                    Player.dmg_take(dmg);
                    JOptionPane.showMessageDialog(null, "YOU TAKE: " + String.valueOf(dmg) + " DMG", "IT'S A TRAP!", JOptionPane.OK_OPTION, Player.Class_icon());
                    update("\n" + Player.Name() + " GOT CAUGHT IN A " + item_found.toString() + " DMG",style);
                    break;
                case 6:

                    JOptionPane.showMessageDialog(null, "EMPTY CHEST, YOU GOT BAMBOOZLED", " YOU GOT ROBBED ", JOptionPane.OK_OPTION, Player.Class_icon());
                    break;
            }
        }
        Chest_kill_req = Chest_kill_req + (Rand.nextInt(5) + 2);
        Player_info_update();


    }

    private static void Level_up()
    {
        boolean sp = false;
        player_level = player_level + 1;
        if(player_level % 5 == 0)
        {
            sp = true;
        }
        else
        {
            sp = false;
        }

        Player.Levelup_Player(sp);
        String playerinfo = "Name: " + Player.Name() + " LV." + String.valueOf(player_level) + "\nHP: " + String.valueOf(Player.HP()) + "\nAC: " + String.valueOf(Player.AC()) +
                "\nSP: " + String.valueOf(Player.SP()) + "\n" + Player.Weapon() + "\n";
        JOptionPane.showMessageDialog(null, "YOU LEVELED UP!!!\n\n" + playerinfo, "LEVEL UP!", JOptionPane.OK_OPTION, Player.Class_icon());
        Style style = side.addStyle("Arial", null);
        StyleConstants.setForeground(style, Color.yellow);
        update("\n" + Player.Name() + " LEVELED UP!",style);
        Highscore = Highscore + (player_level * 1000);
        Player_info_update();
        level_up_req = level_up_req + 10 + player_level;



    }


    private static void create_enemy(int level)
    {
        String Enemy_name = "SKELETON";
        int Enemy_HP = Rand.nextInt(Math.round(Player.HP()/2) - Math.round(Player.HP()/4)) + Player.HP()/4;
        int Enemy_mindmg = level + 1;
        int Enemy_maxdmg = level + 4;
        int Enemy_Armor = 5 + Rand.nextInt(3);
        int Enemy_speed = -2 + Rand.nextInt(2);
        Enemy1 = new Enemy(Enemy_name, Enemy_HP, Enemy_mindmg, Enemy_maxdmg, Enemy_Armor, Enemy_speed);
        is_enemy_dead = false;
    }

    private static void Game_over()
    {
        top.removeAll();
        playerinfo = new JTextPane();
        side.setText("");
        current_level = 1;
        is_enemy_dead = true;
        Enemy_Count = 5;
        Highscore = 0;
        kill_count = 0;
        Chest_kill_req = 6;
        level_up_req = 5;
        Player = new Player("NONAME", 10, 1, 6, 12,2, 2, "Weapon: Short Sword ( 1 - 6 ) dmg", new ImageIcon("src/pics/Basic class.jpg"));
        player_level = 1;
        invo_items = new Item[15];
        Main.setVisible(true);
    }

    private static void Inventory_GUI()
    {

        JFrame Frame = new JFrame();
        JPanel INVO = new JPanel(new GridLayout(16,0));
        ButtonGroup ITEMS = new ButtonGroup();
        JCheckBox item = new JCheckBox();
        JCheckBox[] inventory = new JCheckBox[15];

        for(int x = 0; x < invo_items.length; x++)
        {

            if (invo_items[x] == null)
            {
                item = new JCheckBox(String.valueOf(x + 1)+ ":: Empty", false);
                inventory[x] = item;
                ITEMS.add(item);

            }
            else
            {
                item  = new JCheckBox(String.valueOf(x + 1)+ ":: " + invo_items[x].toString(), false);
                inventory[x] = item;
                ITEMS.add(item);

            }
            INVO.add(item);

        }


        int x = JOptionPane.showConfirmDialog(Frame, INVO,
                "YOUR INVENTORY",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null);

        if( x == JOptionPane.OK_OPTION)
        {

            try{
                if (inventory[0].isSelected())
                    Inventory_item_use(invo_items[0], 0);
                if (inventory[1].isSelected())
                    Inventory_item_use(invo_items[1], 1);
                if (inventory[2].isSelected())
                    Inventory_item_use(invo_items[2], 2);
                if (inventory[3].isSelected())
                    Inventory_item_use(invo_items[3], 3);
                if (inventory[4].isSelected())
                    Inventory_item_use(invo_items[4], 4);
                if (inventory[5].isSelected())
                    Inventory_item_use(invo_items[5], 5);
                if (inventory[6].isSelected())
                    Inventory_item_use(invo_items[6], 6);
                if (inventory[7].isSelected())
                    Inventory_item_use(invo_items[7], 7);
                if (inventory[8].isSelected())
                    Inventory_item_use(invo_items[8], 8);
                if (inventory[9].isSelected())
                    Inventory_item_use(invo_items[9], 9);
                if (inventory[10].isSelected())
                    Inventory_item_use(invo_items[10], 10);
                if (inventory[11].isSelected())
                    Inventory_item_use(invo_items[11], 11);
                if (inventory[12].isSelected())
                    Inventory_item_use(invo_items[12], 12);
                if (inventory[13].isSelected())
                    Inventory_item_use(invo_items[13], 13);
                if (inventory[14].isSelected())
                    Inventory_item_use(invo_items[14], 14);
            }
            catch (Exception e)
            {}

        }

    }


    private static void Inventory_item_use(Item stuff, int index)
    {
        Style style = side.addStyle("Arial", null);
        StyleConstants.setForeground(style, Color.CYAN);
        update("\n" + Player.Name() + " used: " + stuff.toString()  ,style);

        //1 = healing, 2 = dmg
        if (stuff.Type() == 1)
        {
            int H = stuff.total();
            StyleConstants.setForeground(style, Color.GREEN);
            update("\n" + Player.Name() + " HEALS: " + String.valueOf(H),style);
            Player.heal(H);
            Player_info_update();
        }
        if (stuff.Type() == 2)
        {
            int D = stuff.total();
            StyleConstants.setForeground(style, Color.GREEN);
            update("\n" + Enemy1.Name() + " TAKES: " + String.valueOf(D) + " DMG",style);
            Enemy1.dmg_take(D);
            Player_info_update();
        }

        invo_items[index] = null;

    }



}
