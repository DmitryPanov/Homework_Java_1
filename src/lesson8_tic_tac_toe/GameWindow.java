package lesson8_tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static final int WINDOW_POS_X = 100;
    private static final int WINDOW_POS_Y = 100;
    private static final int WINDOW_HEIGTH = 500;
    private static final int WINDOW_WINDTH = 500;

    Settings settings;
    BattleMap field;

    public GameWindow(){
        setBounds(WINDOW_POS_X,WINDOW_POS_Y,WINDOW_WINDTH,WINDOW_HEIGTH);
        setTitle("Tic_Tac_Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton btnNewGame = new JButton("NewGame");
        JButton btnExit = new JButton("Exit");

        panel.add(btnNewGame);
        panel.add(btnExit);
        add(panel,BorderLayout.SOUTH);

        settings = new Settings(this);
        field = new BattleMap();
        add(field,BorderLayout.CENTER);


        btnExit.addActionListener(e->{
            System.exit(0);
        });

        btnNewGame.addActionListener(e -> {
            settings.setVisible(true);
        });


        setVisible(true);
    }

    public void startNewGame(int mode, int sizeMapX,int sizeMapY,int sizeWinLine ){
        field.startNewGame(mode, sizeMapX,sizeMapY,sizeWinLine);
    }
}
