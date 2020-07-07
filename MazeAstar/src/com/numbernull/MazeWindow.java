package com.numbernull;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class MazeWindow extends JFrame {

    boolean isBegin = false;
    boolean isEnd = false;

    int beginX;
    int beginY;
    int endX;
    int endY;
    Vector<Vector<JLabel>> mazeField;

    private void updateField(Maze maze){
        for(int i = 0; i < maze.sizeY; i++){
            for(int j = 0; j < maze.sizeX; j++){
                if(maze.labyrinth.elementAt(i).elementAt(j).isPath){
                    mazeField.elementAt(i).elementAt(j).setBackground(Color.RED);
                }
            }
        }

    }


    public MazeWindow(String s, int x, int y, Maze labyrinth) {
        super(s);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        Container container = getContentPane();
        container.setLayout(new GridLayout(0, 2));

        GridLayout mazeStyle = new GridLayout(x, y, 0, 0);
        JPanel maze = new JPanel();
        maze.setSize(800, 600);
        maze.setLayout(mazeStyle);

        FlowLayout optionsStyle = new FlowLayout(FlowLayout.CENTER);
        JPanel options = new JPanel();
        options.setLayout(optionsStyle);

        JButton start = new JButton("Старт");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == start) {
                    Astar.search(labyrinth, labyrinth.labyrinth.elementAt(beginY).elementAt(beginX), labyrinth.labyrinth.elementAt(endY).elementAt(endX));
                    updateField(Astar.snap.states.get(Astar.snap.states.size() - 1));
                }
            }
        });

        options.add(start);
        options.add(new JButton("Вперед"));
        options.add(new JButton("Назад"));
        options.add(new JButton("Сохранить лабиринт"));
        options.add(new JButton("Загрузить лабиринт"));

        JButton setBegin = new JButton("Указать начало");
        JButton setEnd = new JButton("Указать конец");

        setBegin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == setBegin) {
                    isBegin = true;
                    isEnd = false;
                }
            }
        });

        setEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setEnd) {
                    isEnd = true;
                    isBegin = false;
                }
            }
        });


        options.add(setBegin);
        options.add(setEnd);

        mazeField = new Vector<>();


        for (int i = 0; i < y; i++) {
            Vector<JLabel> cells = new Vector<>();
            for (int j = 0; j < x; j++) {
                if (!labyrinth.labyrinth.elementAt(i).elementAt(j).isWall) {
                    JLabel textLabel = new JLabel();
                    textLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
                    textLabel.setBackground(Color.GREEN);
                    textLabel.setOpaque(true);
                    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    textLabel.setText(j + " " + i);
                    textLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int x;
                            int y;
                            String[] args = textLabel.getText().split(" ");
                            x = Integer.parseInt(args[0]);
                            y = Integer.parseInt(args[1]);
                            System.out.println("\tx = " + x + " y = " + y);
                            if (isBegin) {
                                beginX = x;
                                beginY = y;
                                isBegin = false;
                            }
                            if (isEnd) {
                                endX = x;
                                endY = y;
                                isEnd = false;
                            }
                        }
                    });
                    cells.addElement(textLabel);
                    maze.add(textLabel);
                } else {
                    JLabel textLabel = new JLabel();
                    textLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                    textLabel.setBackground(Color.BLACK);
                    textLabel.setOpaque(true);
                    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    cells.addElement(textLabel);
                    maze.add(textLabel);
                }
            }
            mazeField.addElement(cells);
        }


        container.add(maze);
        container.add(options);

    }
}
