package com.AWT;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SurfaceShearing extends JPanel {

    private void doDrawing(Graphics g) {// графика

        Graphics2D g2d = (Graphics2D) g.create();// объявление класса Graphics2D

        AffineTransform tx1 = new AffineTransform();// наш эффект
        tx1.translate(50, 90);// переместить

        g2d.setTransform(tx1);
        g2d.setPaint(Color.green);// цвет
        g2d.drawRect(0, 0, 160, 50);// закрасить прямоуголник

        AffineTransform tx2 = new AffineTransform();// наш эффект
        tx2.translate(50, 90);// переместить
        tx2.shear(0, 1);

        g2d.setTransform(tx2);
        g2d.setPaint(Color.blue);// цвет

        g2d.draw(new Rectangle(0, 0, 80, 50));// закрасить прямоуголник

        AffineTransform tx3 = new AffineTransform();// наш эффект
        tx3.translate(130, 10);// переместить
        tx3.shear(0, 1);

        g2d.setTransform(tx3);
        g2d.setPaint(Color.red);// цвет
        g2d.drawRect(0, 0, 80, 50);// закрасить прямоуголник

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {// компонент графики

        super.paintComponent(g);
        doDrawing(g);// вызов нашей графики
    }
}

public class ShearingEx extends JFrame {

    public ShearingEx() { // конструктор
        // инициализация
        initUI();
    }

    private void initUI() {

        add(new SurfaceShearing()); // добавление нашего объекта, на форму

        setTitle("Shearing");
        setSize(330, 270);// размеры
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// выход
    }

    public static void main(String[] args) {// главный класс, начало кода

        EventQueue.invokeLater(new Runnable() { // поток
            @Override
            public void run() {// запуск

                ShearingEx ex = new ShearingEx();// создание нашего класса
                ex.setVisible(true);// видимость
            }
        });
    }
}
