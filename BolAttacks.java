import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.awt.event.*;

public class BolAttacks
{
    private static JFrame frame = new JFrame();
    private static JPanel northPanel = new JPanel();
    private static JPanel westPanel = new JPanel();
    private static JPanel centerPanel = new JPanel();
    private static JPanel eastPanel = new JPanel();
    private static JPanel southPanel = new JPanel();

    private static boolean rage = false;
    private static boolean battle = false;
    private static boolean force20 = false;

    private static int battleDamage = 0;
    private static int bludgeoningDamage = 0;
    private static int bonusDamage = 0;
    private static int fireDamage = 0;
    private static int forceDamage = 0;
    private static int piercingDamage = 0;
    private static int radiantDamage = 0;

    private static final int PROFICIENCY_BONUS = 5;
    private static final int STRENGTH_BONUS = 3;
    private static final int DEXTERITY_BONUS = 2;

    private static JLabel attackLabel = new JLabel("      0");
    private static JLabel physicalDamageLabel = new JLabel("      0");
    private static JLabel fireDamageLabel = new JLabel("      0");
    private static JLabel forceDamageLabel = new JLabel("      0");
    private static JLabel radiantDamageLabel = new JLabel("      0");
    private static JLabel totalDamageLabel = new JLabel("      0");

    private static JComboBox<String> weaponComboBox;
    private static JComboBox<String> advantageComboBox;
    private static JComboBox<String> goatComboBox;
    private static JComboBox<String> smiteComboBox;
   
    /**
    public static void main(String[] args)
    {
        frame.setSize(new Dimension(768,512));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setNorthPanel();
        setWestPanel();
        setCenterPanel();
        setEastPanel();
        setSouthPanel();

        frame.getContentPane().add(northPanel, BorderLayout.NORTH);
        frame.getContentPane().add(westPanel, BorderLayout.WEST);
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        frame.getContentPane().add(eastPanel, BorderLayout.EAST);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    */

    public BolAttacks()
    {

    }

    public static void setAll()
    {
        frame.setSize(new Dimension(768,512));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setNorthPanel();
        setWestPanel();
        setCenterPanel();
        setEastPanel();
        setSouthPanel();

        frame.getContentPane().add(northPanel, BorderLayout.NORTH);
        frame.getContentPane().add(westPanel, BorderLayout.WEST);
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        frame.getContentPane().add(eastPanel, BorderLayout.EAST);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void setNorthPanel()
    {
        Vector<String> weaponVector = new Vector<String>();
        weaponVector.add("Goat Staff");
        weaponVector.add("Demon Hammer");
        weaponVector.add("Javelin");
        weaponVector.add("Longbow");
        weaponVector.add("Fire Shield");
        weaponComboBox = new JComboBox<String>(weaponVector);
        
        Vector<String> advantageVector = new Vector<String>();
        advantageVector.add("Advantage");
        advantageVector.add("Disadvantage");
        advantageVector.add("Neutral");
        advantageComboBox = new JComboBox<String>(advantageVector);

        Vector<String> goatVector = new Vector<String>();
        goatVector.add("0 Charges");
        goatVector.add("1 Charge");
        goatVector.add("2 Charges");
        goatVector.add("3 Charges");
        goatComboBox = new JComboBox<String>(goatVector);

        Vector<String> smiteVector = new Vector<String>();
        smiteVector.add("No Smite");
        smiteVector.add("lvl 1 Smite");
        smiteVector.add("lvl 2 Smite");
        smiteVector.add("lvl 3 Smite");
        smiteComboBox = new JComboBox<String>(smiteVector);

        JCheckBox rageCheckBox = new JCheckBox("Rage");
        rageCheckBox.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            rage = !rage;
        }});

        JCheckBox battleCheckBox = new JCheckBox("Battle Master");
        battleCheckBox.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            battle = !battle;
        }});

        JCheckBox force20CheckBox = new JCheckBox("Force 20");
        force20CheckBox.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            force20 = !force20;
        }});

        northPanel.add(weaponComboBox);
        northPanel.add(advantageComboBox);
        northPanel.add(goatComboBox);
        northPanel.add(smiteComboBox);
        northPanel.add(rageCheckBox);
        northPanel.add(battleCheckBox);
        northPanel.add(force20CheckBox);
    }
    public static void setWestPanel()
    {
        JButton rollButton = new JButton("DO THE THING");
        westPanel.add(rollButton);
        rollButton.setPreferredSize(new Dimension(256,256+128));

        rollButton.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            int attackRoll = 0;
            int d20 = 0;
            int d20Other = 0;
            boolean natural = false;
            int iterations = 1;
            int charges = 0;
            int smiteCharges = 0;
            int ii;
            battleDamage = 0;
            bludgeoningDamage = 0;
            fireDamage = 0;
            forceDamage = 0;
            piercingDamage = 0;
            bonusDamage = 0;
            radiantDamage = 0;

            if(weaponComboBox.getSelectedItem().equals("Goat Staff"))
                attackRoll = 3 + PROFICIENCY_BONUS + STRENGTH_BONUS;
            if(weaponComboBox.getSelectedItem().equals("Demon Hammer"))
                attackRoll = 1 + PROFICIENCY_BONUS + STRENGTH_BONUS;
            if(weaponComboBox.getSelectedItem().equals("Javelin"))
                attackRoll = 0 + PROFICIENCY_BONUS + STRENGTH_BONUS;
            if(weaponComboBox.getSelectedItem().equals("Longbow"))
                attackRoll = 0 + PROFICIENCY_BONUS + DEXTERITY_BONUS;
            
            if(!weaponComboBox.getSelectedItem().equals("Fire Shield"))
            {
                d20 = (int)(Math.random() * 20) + 1;
                d20Other = (int)(Math.random() * 20) + 1;
                if(advantageComboBox.getSelectedItem().equals("Advantage"))
                {
                    if(d20Other > d20)
                    {
                        d20 = d20Other;
                    }
                }
                else if(advantageComboBox.getSelectedItem().equals("Disadvantage"))
                {
                    if(d20Other < d20)
                    {
                        d20 = d20Other;
                    }
                }
                attackRoll += d20;
                d20Other = 0;
                System.out.println(d20);
            }
            if((d20 == 20 || force20) && !weaponComboBox.getSelectedItem().equals("Fire Shield"))
            {
                attackLabel.setText("NAT TWENNY");
                natural = true;
            }
            else if(d20 == 1 && !weaponComboBox.getSelectedItem().equals("Fire Shield"))
            {
                attackLabel.setText("How tf Did You Miss?");
            }
            else
                attackLabel.setText("" + attackRoll);
            
            if(natural == true)
                iterations = 2;
            else
                iterations = 1;
            for(int i = 0; i < iterations; i++)
            {
                bonusDamage = 0;
                if(battle && !weaponComboBox.getSelectedItem().equals("Fire Shield"))
                {
                    battleDamage += (int)(Math.random() * 8) + 1;
                    //System.out.println("USES BATTLE");
                }
                if(!weaponComboBox.getSelectedItem().equals("Fire Shield"))
                {
                    if(!weaponComboBox.getSelectedItem().equals("Longbow"))
                    {
                        if(smiteComboBox.getSelectedItem().equals("lvl 1 Smite"))
                            smiteCharges = 2; // based on number of dice, not charges
                        else if(smiteComboBox.getSelectedItem().equals("lvl 2 Smite"))
                            smiteCharges = 3;
                        else if(smiteComboBox.getSelectedItem().equals("lvl 3 Smite"))
                            smiteCharges = 4;
                    }
                }
                for(ii = 0; ii < smiteCharges; ii++)
                {
                    radiantDamage += (int)(Math.random()*8) + 1;
                }

                if(weaponComboBox.getSelectedItem().equals("Goat Staff"))
                {
                    bonusDamage += 3; //magic weapon
                    if(rage)
                        bonusDamage += 2;
                    bonusDamage += STRENGTH_BONUS;
                    bonusDamage += 2; //fighting style
                    bludgeoningDamage += (int)(Math.random()*6) + 1;
                    if(goatComboBox.getSelectedItem().equals("1 Charge"))
                        charges = 1;                        
                    if(goatComboBox.getSelectedItem().equals("2 Charges"))
                        charges = 2;
                    if(goatComboBox.getSelectedItem().equals("3 Charges"))
                        charges = 3;
                    for(ii = 0; ii < charges; ii++)
                        forceDamage += (int)(Math.random()*6) + 1;
                }
                if(weaponComboBox.getSelectedItem().equals("Demon Hammer"))
                {
                    bonusDamage += 1; //magic weapon
                    if(rage)
                        bonusDamage += 2;
                    bonusDamage += STRENGTH_BONUS;
                    bonusDamage += 2; //fighting style
                    bludgeoningDamage += (int)(Math.random()*8) + 1;
                    fireDamage += (int)(Math.random()*8) + 1;
                    fireDamage += (int)(Math.random()*8) + 1;
                }
                if(weaponComboBox.getSelectedItem().equals("Javelin"))
                {
                    if(rage)
                        bonusDamage += 2;
                    bonusDamage += STRENGTH_BONUS;
                    bonusDamage += 2; //fighting style
                    piercingDamage += (int)(Math.random()*6) + 1;
                }
                if(weaponComboBox.getSelectedItem().equals("Longbow"))
                {
                    bonusDamage += DEXTERITY_BONUS;
                    piercingDamage += (int)(Math.random()*8) + 1;
                }
                if(weaponComboBox.getSelectedItem().equals("Fire Shield"))
                {
                    fireDamage += (int)(Math.random()*4) + 1;
                    fireDamage += (int)(Math.random()*4) + 1;
                }
            }
            piercingDamage += bludgeoningDamage;
            piercingDamage += bonusDamage + battleDamage;
            physicalDamageLabel.setText("      " + piercingDamage);
            forceDamageLabel.setText("      " + forceDamage);
            fireDamageLabel.setText("      " + fireDamage);
            radiantDamageLabel.setText("      " + radiantDamage);
            totalDamageLabel.setText("      " + (piercingDamage + forceDamage + fireDamage + radiantDamage));
        }});
    }
    public static void setCenterPanel()
    {

        JLabel physicalLabel = new JLabel("    Physical");
        JLabel fireLabel = new JLabel("    Fire");
        JLabel forceLabel = new JLabel("    Force");
        JLabel radiantLabel = new JLabel("    Radiant");
        JLabel totalLabel = new JLabel("    TOTAL DAMAGE");
        JLabel emptyLabel = new JLabel("    ");

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        physicalLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        physicalDamageLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        fireLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        fireDamageLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        forceLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        forceDamageLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        radiantLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        radiantDamageLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        emptyLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        totalLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        totalDamageLabel.setFont(new Font("Verdana", Font.BOLD, 36));

        centerPanel.add(physicalLabel);
        centerPanel.add(physicalDamageLabel);
        centerPanel.add(forceLabel);
        centerPanel.add(forceDamageLabel);
        centerPanel.add(radiantLabel);
        centerPanel.add(radiantDamageLabel);
        centerPanel.add(fireLabel);
        centerPanel.add(fireDamageLabel);
        centerPanel.add(emptyLabel);
        centerPanel.add(totalLabel);
        centerPanel.add(totalDamageLabel);
    }

    public static void setEastPanel()
    {
        JButton physicalButton = new JButton("Halve Physical");
        JButton fireButton = new JButton("Halve Fire");
        JButton forceButton = new JButton("Halve Force");
        JButton radiantButton = new JButton("Halve Radiant");

        physicalButton.setPreferredSize(new Dimension(256,64));
        fireButton.setPreferredSize(new Dimension(256,64));
        forceButton.setPreferredSize(new Dimension(256,64));
        radiantButton.setPreferredSize(new Dimension(256,64));

        physicalButton.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            int dmg = Integer.parseInt(physicalDamageLabel.getText().substring(6));
            dmg /= 2;
            physicalDamageLabel.setText("      " + dmg);
            dmg = Integer.parseInt(physicalDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(forceDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(fireDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(radiantDamageLabel.getText().substring(6));
            totalDamageLabel.setText("      " + dmg);
        }});
        fireButton.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            int dmg = Integer.parseInt(fireDamageLabel.getText().substring(6));
            dmg /= 2;
            fireDamageLabel.setText("      " + dmg);
            dmg = Integer.parseInt(physicalDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(forceDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(fireDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(radiantDamageLabel.getText().substring(6));
            totalDamageLabel.setText("      " + dmg);
        }});
        forceButton.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            int dmg = Integer.parseInt(forceDamageLabel.getText().substring(6));
            dmg /= 2;
            forceDamageLabel.setText("      " + dmg);
            dmg = Integer.parseInt(physicalDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(forceDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(fireDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(radiantDamageLabel.getText().substring(6));
            totalDamageLabel.setText("      " + dmg);
        }});
        radiantButton.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            int dmg = Integer.parseInt(radiantDamageLabel.getText().substring(6));
            dmg /= 2;
            radiantDamageLabel.setText("      " + dmg);
            dmg = Integer.parseInt(physicalDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(forceDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(fireDamageLabel.getText().substring(6));
            dmg += Integer.parseInt(radiantDamageLabel.getText().substring(6));
            totalDamageLabel.setText("      " + dmg);
        }});

        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.add(physicalButton);
        eastPanel.add(forceButton);
        eastPanel.add(radiantButton);
        eastPanel.add(fireButton);
    }
    public static void setSouthPanel()
    {
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        JLabel screwKeaton = new JLabel("You Rolled a:");
        screwKeaton.setFont(new Font("Verdana", Font.BOLD, 24));
        attackLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        southPanel.add(screwKeaton);
        southPanel.add(attackLabel);
    }
}