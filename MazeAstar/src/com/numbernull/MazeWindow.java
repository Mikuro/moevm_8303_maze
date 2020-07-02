package com.numbernull;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MazeWindow extends JFrame {


    public MazeWindow(String s, int x, int y){
        super(s);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        Container container = getContentPane();
        container.setLayout(new GridLayout(0,2));

        GridLayout mazeStyle = new GridLayout(x, y, 10, 10);
        JPanel maze = new JPanel();
        maze.setLayout(mazeStyle);

        FlowLayout optionsStyle = new FlowLayout(FlowLayout.CENTER);
        JPanel options = new JPanel();
        options.setLayout(optionsStyle);

        options.add(new JButton("Старт"));
        options.add(new JButton("Вперед"));
        options.add(new JButton("Назад"));


        for(int i = 0; i < y; i++)
            for(int j = 0; j < x; j++){
                JLabel textLabel = new JLabel(Integer.toString(j) + ", " + Integer.toString(i));
                textLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                textLabel.setHorizontalAlignment(SwingConstants.CENTER);
                maze.add(textLabel);
            }
        container.add(maze);
        container.add(options);


    }

}
