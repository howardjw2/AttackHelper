/**
 * Attack Tab
 * Skills Tab
 * Abilities Tab
 * Spells Tab
 * Items Tab
 * Attunements
 * Health
 * Death Saves
 * 
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;

import java.util.Vector;

public class BolGUI
{
    private static JFrame frame = new JFrame();
    private static JPanel northPanel = new JPanel();
    private static JPanel westPanel = new JPanel();
    private static JPanel centerPanel = new JPanel();
    private static JPanel eastPanel = new JPanel();
    private static JPanel southPanel = new JPanel();
    public static void main(String [] args)
    {
        frame.setSize(new Dimension(512,512));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setEastPanel();
        //setSouthPanel();

        frame.getContentPane().add(northPanel, BorderLayout.NORTH);
        frame.getContentPane().add(westPanel, BorderLayout.WEST);
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        frame.getContentPane().add(eastPanel, BorderLayout.EAST);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void setEastPanel()
    {
        JButton attackButton = new JButton("ATTACK");

        attackButton.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
        {
            BolAttacks.setAll();
        }});
        eastPanel.add(attackButton);
    }
}
