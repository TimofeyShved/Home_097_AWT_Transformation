package com.AWT;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SurfaceScaling extends JPanel {

    private void doDrawing(Graphics g) {// графика

        Graphics2D g2d = (Graphics2D) g.create();// объявление класса Graphics2D

        g2d.setColor(new Color(150, 150, 150));// цвет
        g2d.fillRect(20, 20, 80, 50);// закрасить прямоуголник

        AffineTransform tx1 = new AffineTransform(); // наш эффект
        tx1.translate(110, 22); // переместить
        tx1.scale(0.5, 0.5); // размеры изменить

        g2d.setTransform(tx1);
        g2d.fillRect(0, 0, 80, 50);// закрасить прямоуголник

        AffineTransform tx2 = new AffineTransform();
        tx2.translate(170, 20);// переместить
        tx2.scale(1.5, 1.5); // размеры изменить

        g2d.setTransform(tx2);
        g2d.fillRect(0, 0, 80, 50);// закрасить прямоуголник

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {// компонент графики

        super.paintComponent(g);
        doDrawing(g);// вызов нашей графики
    }
}

public class ScalingEx extends JFrame {

    public ScalingEx() { // конструктор
        // инициализация
        initUI();
    }

    private void initUI() {

        add(new SurfaceScaling());// добавление нашего объекта, на форму

        setTitle("Scaling");
        setSize(330, 160);// размеры
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// выход
    }

    public static void main(String[] args) {// главный класс, начало кода

        EventQueue.invokeLater(new Runnable() { // поток
            @Override
            public void run() {// запуск

                ScalingEx ex = new ScalingEx();// создание нашего класса
                ex.setVisible(true); // видимость
            }
        });
    }
}
