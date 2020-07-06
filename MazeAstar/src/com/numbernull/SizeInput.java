package com.numbernull;

import org.w3c.dom.ranges.RangeException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**TODO
 * окно об ошибке
 * перепелить под квадрат
 */
public class SizeInput extends JFrame{
    private JLabel info;
    private JTextField xCord;
    private JTextField yCord;
    private int x = 0;
    private int y = 0 ;
    private JButton ok;

    public SizeInput(final String s) {
        super(s);
        setLayout(new GridLayout(3, 1, 10, 10));
        this.ok = new JButton("Ok");
        this.info = new JLabel("Введите размер:");
        this.xCord = new JTextField("ширина лабиринта", 5);
        this.yCord = new JTextField("длина лабиринта", 5);
        add(this.info);
        add(new JPanel());
        add(this.xCord);
        add(this.yCord);
        add(new JPanel());
        add(this.ok);

        ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ok){
                    try {
//                        x = Integer.parseInt(xCord.getText());
                        y = Integer.parseInt(yCord.getText());
                        setVisible(false);
                        if (y < 4 || y > 150)
                            throw new RangeException((short) 0,"size should be from 4 to 150");
                        new MazeWindow(s, y, y, new Maze(y, y));
                    }catch (NumberFormatException err){
                        System.out.println("nice try");
                        //TODO кинуть окно, мол введи норм
                    }catch (RangeException err){
                        System.out.println(err.getMessage());
                        //TODO кинуть окно, мол введи норм
                    }
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
