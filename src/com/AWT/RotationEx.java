package com.AWT;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

    private void doDrawing(Graphics g) { // графика

        Graphics2D g2d = (Graphics2D) g.create(); // объявление класса Graphics2D

        g2d.setPaint(new Color(150, 150, 150)); // цвет
        g2d.fillRect(20, 20, 80, 50); // закрасить прямоуголник
        g2d.translate(180, -50); // переместить
        g2d.rotate(Math.PI/4); // повернуть
        g2d.fillRect(80, 80, 80, 50);// закрасить прямоуголник

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) { // компонент графики

        super.paintComponent(g);
        doDrawing(g);// вызов нашей графики
    }
}

public class RotationEx extends JFrame {

    public RotationEx() { // конструктор
        // инициализация
        initUI();
    }

    private void initUI() {

        setTitle("Rotation");

        add(new Surface()); // добавление нашего объекта, на форму

        setSize(300, 200); // размеры
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход
    }

    public static void main(String[] args) { // главный класс, начало кода

        EventQueue.invokeLater(new Runnable() { // поток
            @Override
            public void run() { // запуск

                RotationEx ex = new RotationEx(); // создание нашего класса
                ex.setVisible(true); // видимость
            }
        });
    }
}
