package finalHorseTravel;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 *
 * @author Diego BV
 *
 */
public class HorseWindow extends JFrame implements ActionListener {

    private JButton buttons[][] = new JButton[8][8];
    private JButton finalButton;
    private JButton out;
    private Container container1, container2;
    private Border border;
    private Game game;
    private GridBagConstraints position;
    private int panel[][];
    private int count, positionA, positionB;

    public HorseWindow() {
        super("Ventana de juego");

        container1 = new Container();
        container2 = new Container();

        game = new Game(8, 8);
        position = new GridBagConstraints();

        finalButton = new JButton("Resolver");
        out = new JButton("Salir");

        container2.add(finalButton);
        container2.add(out);

        this.getContentPane().setLayout(new GridBagLayout());
        container2.setLayout(new FlowLayout());
        container1.setLayout(new GridLayout(8, 8));
        container2.setSize(720, 300);

        border = BorderFactory.createLineBorder(Color.black, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton("");
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        buttons[i][j].setBackground(Color.white);
                    } else {
                        buttons[i][j].setBackground(Color.black);
                    }
                } else {
                    if (j % 2 == 1) {
                        buttons[i][j].setBackground(Color.white);
                    } else {
                        buttons[i][j].setBackground(Color.black);
                    }
                }
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBorder(border);
                buttons[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                buttons[i][j].setVerticalAlignment(SwingConstants.CENTER);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                container1.add(buttons[i][j]);
            }
        }

        position.gridx = 0;
        position.gridy = 0;
        position.gridheight = 8;
        position.gridwidth = 8;
        position.weightx = 1.0;
        position.weighty = 1.0;
        position.fill = GridBagConstraints.BOTH;
        this.getContentPane().add(container1, position);
        position.weightx = 1.0;
        position.weighty = 0;
        position.gridx = 0;
        position.gridy = 9;
        position.gridheight = 8;
        position.gridwidth = 2;
        position.fill = GridBagConstraints.HORIZONTAL;
        this.getContentPane().add(container2, position);
        finalButton.addActionListener(this);
        out.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == out) {
            System.exit(0);
        }

        if (e.getSource() == finalButton && count != 65) {
            finalButton.setEnabled(false);
            count = 65;
            bringBoard();
        }

        if (panel == null) {
            boolean aux = true;
            for (int i = 0; i < 8 && aux; i++) {
                for (int j = 0; j < 8 && aux; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        positionB = i;
                        positionA = j;
                        aux = false;
                        panel = game.start(positionB, positionA);
                        count++;
                        bringBoard();
                    }
                }
            }
        }
    }

    private void bringBoard() {
        boolean aux;
        if (panel == null) {
            panel = game.start(0, 0);
        }
        for (int i = 1; i < count + 1; i++) {
            aux = true;
            for (int j = 0; j < 8 && aux; j++) {
                for (int h = 0; h < 8 && aux; h++) {
                    if (panel[j][h] == i) {
                        buttons[j][h].setOpaque(true);
                        buttons[j][h].setForeground(Color.red);
                        buttons[j][h].setText("" + i);
                        aux = false;
                    }
                }
            }
        }
    }

    public int getPositionA() {
        return positionA;
    }

    public int getPositionB() {
        return positionB;
    }
}
