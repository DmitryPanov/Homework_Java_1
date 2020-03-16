package lesson8_tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    public static final int CHANGE_SIZE_FIGURE = 10;
    public static final int H_VS_A = 0;
    public static final int H_VS_H = 1;
    int sizeMapX;
    int sizeMapY;
    int sizeWinLine;
    int cellHeight;
    int cellWidth;
    boolean isInit = false;

    public BattleMap() {
        setBackground(Color.yellow);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintLine(g);
    }

    void paintLine(Graphics g) {
        if (isInit == false) {
            return;
        }
        int panelHeight = getHeight();
        int panelWidth = getWidth();

        cellHeight = panelHeight / sizeMapY;
        cellWidth = panelWidth / sizeMapX;

        for (int i = 0; i < sizeMapY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < sizeMapX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j <Logic.SIZE ; j++) {
                if(Logic.map[i][j]==Logic.DOT_X){
                    drawX(g,j,i);
                }
                if(Logic.map[i][j]==Logic.DOT_O){
                    drawO(g,j,i);
                }
            }
        }

    }

    public void startNewGame(int mode, int sizeMapX, int sizeMapY, int sizeWinLine) {
        System.out.printf("mode %d sizeMapX %d sizeMapY %d sizeWinLine %d\n",
                mode, sizeMapX, sizeMapY, sizeWinLine);
        this.sizeMapX = sizeMapX;
        this.sizeMapY = sizeMapY;
        this.sizeWinLine = sizeWinLine;

        isInit = true;
        repaint();

    }

    private void update(MouseEvent e) {
        if (e.getButton() == 1) {
            int cellX = e.getX() / cellWidth;
            int cellY = e.getY() / cellHeight;

            if (!Logic.gameOver) {
                Logic.setHumanXY(cellY, cellX);
            } else {
                System.out.println(Logic.winnerName);
            }
            repaint();
        }
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        g.setColor(new Color(11, 5, 255));
        Graphics2D g2 =(Graphics2D) g;
        g2.setStroke(new BasicStroke(5.f));
        g2.drawLine((cellX * cellWidth)+CHANGE_SIZE_FIGURE, (cellY * cellHeight)+CHANGE_SIZE_FIGURE, (cellX + 1) * cellWidth-CHANGE_SIZE_FIGURE, (cellY + 1) * cellHeight-CHANGE_SIZE_FIGURE);
        g2.drawLine(cellX * cellWidth+CHANGE_SIZE_FIGURE, (cellY+1) * cellHeight-CHANGE_SIZE_FIGURE, (cellX + 1) * cellWidth-CHANGE_SIZE_FIGURE, cellY  * cellHeight+CHANGE_SIZE_FIGURE);
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        Graphics2D g2 =(Graphics2D) g;
        g2.setStroke(new BasicStroke(5.f));
        g.setColor(new Color(255, 0, 5));
        g.drawOval(cellX * cellWidth+CHANGE_SIZE_FIGURE,cellY * cellHeight+CHANGE_SIZE_FIGURE,cellWidth-2*CHANGE_SIZE_FIGURE,cellHeight-2*CHANGE_SIZE_FIGURE);
    }

}
