package lesson8_tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {
    private final GameWindow gameWindow;
    private static final int WINDOW_POS_X = 100;
    private static final int WINDOW_POS_Y = 100;
    private static final int WINDOW_HEIGTH = 500;
    private static final int WINDOW_WINDTH = 500;
    private static final int CHANGE_WINDOW = 25;

    private JRadioButton jrbHumanVsAi;
    private JRadioButton jrbHumanVsHuman;
    private ButtonGroup changeGame;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_SIZE = 3;
    private static final int MAX_WIN_SIZE = 10;

    private static final String STR_FIELD_SIZE = "Field Size: ";
    private static final String STR_WIN_LINE ="Win Line: " ;

    private JSlider slFieldSize;
    private JSlider slWinSize;


    public Settings(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X+CHANGE_WINDOW, WINDOW_POS_Y+CHANGE_WINDOW, WINDOW_WINDTH-2*CHANGE_WINDOW, WINDOW_HEIGTH-2*CHANGE_WINDOW);
        setTitle("Settings");
        setLayout(new GridLayout(10,1));

        jrbHumanVsAi = new JRadioButton("Human VS Ai",true);
        jrbHumanVsHuman = new JRadioButton("Human VS Human");
        changeGame = new ButtonGroup();
        changeGame.add(jrbHumanVsAi);
        changeGame.add(jrbHumanVsHuman);

        add(new JLabel("  Choose of games: "));
        add(jrbHumanVsAi);
        add(jrbHumanVsHuman);

        slFieldSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        slWinSize = new JSlider(MIN_WIN_SIZE,MIN_WIN_SIZE,MIN_WIN_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));

        slWinSize.setMajorTickSpacing(1);
        slWinSize.setPaintTicks(true);
        slWinSize.setPaintLabels(true);
        slWinSize.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));

        add(new JLabel("  Choose Map:  "));
        JLabel jlFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(jlFieldSize);
        add(slFieldSize);

        add(new JLabel("  Choose WinLine: " ));
        JLabel jlWinLine = new JLabel(STR_WIN_LINE + MIN_WIN_SIZE);
        add(jlWinLine);
        add(slWinSize);

        slFieldSize.addChangeListener(e -> {
            int changeFieldSize = slFieldSize.getValue();
            jlFieldSize.setText(STR_FIELD_SIZE + changeFieldSize);
            slWinSize.setMaximum(changeFieldSize);
        });

        slWinSize.addChangeListener(e -> {
            int changeWinLine = slWinSize.getValue();
            jlWinLine.setText(STR_WIN_LINE + changeWinLine);
        });

        JButton btnStartGame = new JButton("Start Game ");
        add(btnStartGame);

        btnStartGame.addActionListener(e -> {
            int gameMode;
            if (jrbHumanVsAi.isSelected()){
                gameMode = BattleMap.H_VS_A;
            } else {
                gameMode = BattleMap.H_VS_H;
            }
            int fieldSize = slFieldSize.getValue();
            int winSize = slWinSize.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOT_TO_WIN = winSize;
            Logic.doMap();
            Logic.gameOver = false;
            Logic.Count = 0;

            gameWindow.startNewGame(gameMode,fieldSize,fieldSize,winSize);
            setVisible(false);
        });

        setVisible(false);
    }
}
