package lesson8_tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class Conclusion extends JFrame{

    private static final int WINDOW_POS_X = 200;
    private static final int WINDOW_POS_Y = 200;
    private static final int WINDOW_HEIGTH = 300;
    private static final int WINDOW_WINDTH = 300;
    private static final int CHANGE_WINDOW = 50;

    public Conclusion(String string) {
        setBounds(WINDOW_POS_X+CHANGE_WINDOW, WINDOW_POS_Y+CHANGE_WINDOW, WINDOW_WINDTH-2*CHANGE_WINDOW, WINDOW_HEIGTH-2*CHANGE_WINDOW);
        setUndecorated(true);

        JPanel panel = new JPanel(new GridLayout(1,1));
        JButton btnOK = new JButton(string);

        panel.add(btnOK);
        add(panel,BorderLayout.CENTER);

        btnOK.addActionListener(e -> {
            setVisible(false);

        });

        setVisible(true);
    }
}


