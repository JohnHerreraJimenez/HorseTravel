/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import finalHorseTravel.HorseWindow;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Diego BV
 * 
 */
public class WelcomeWindow extends JFrame implements ActionListener{    
    
    public JPanel panel;
    private JButton out;
    private JButton play;
    private JLabel text;
    Font myFont = new Font("Lucida Handwritting", Font.ITALIC, 20);

    public WelcomeWindow() {
    
        super("Ventana de bienvenido");

        this.setSize(500, 500);
        panel = new JPanel();
        out = new JButton("Salir");
        play = new JButton("Jugar");
        text = new JLabel("EL SALTO DEL CABALLO");
        
        JButton image = new JButton();
        image.setIcon((new ImageIcon("src/Pictures/horse.jpg")));        
        image.setSize(200, 190);
        image.setLocation(150, 160);
        image.setForeground(Color.BLACK);
        panel.add(image);

        panel.setSize(500, 500);
        panel.setLayout(null);
        
        this.add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        play.setSize(100, 50);
        play.setLocation(147, 380);
        panel.add(play);

        out.setSize(100, 50);
        out.setLocation(259, 380);
        panel.add(out);
        
        text.setSize(250, 250);
        text.setLocation(140, 20);
        text.setFont(myFont);
        panel.add(text);
        
        out.addActionListener(this);       
        play.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == out) {
            System.exit(0);
        }
        
        if(e.getSource() == play){
            HorseWindow hWindow = new HorseWindow();
            hWindow.setSize(700, 700);
            hWindow.setVisible(true);
            this.setVisible(false);            
        }
    }
}
