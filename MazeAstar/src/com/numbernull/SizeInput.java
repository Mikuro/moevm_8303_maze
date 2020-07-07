package com.numbernull;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class SizeInput extends JFrame{
    private final JTextField xCord;
    private final JTextField yCord;
    private int x;
    private int y;
    private final JButton ok;

    public SizeInput(final String s){
        super(s);
        setLayout(new GridLayout(3, 1, 10, 10));
        this.ok = new JButton("Ok");
        JLabel info = new JLabel("Введите координаты:");
        this.xCord = new JTextField("ширина лабиринта", 5);
        this.yCord = new JTextField("длина лабиринта", 5);
        add(info);
        add(new JPanel());
        add(this.xCord);
        add(this.yCord);
        add(new JPanel());
        add(this.ok);

        ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ok){
                    x = Integer.parseInt(xCord.getText());
                    y = Integer.parseInt(yCord.getText());
                        setVisible(false);
                        new MazeWindow(s, x, y, new Maze(x, y));
                }
            }
        });

        xCord.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                xCord.setText("");
            }
        });

        yCord.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                yCord.setText("");
            }
        });

    }
}
