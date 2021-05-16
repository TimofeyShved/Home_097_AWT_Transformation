package com.AWT;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SurfaceDonut extends JPanel {

    private void doDrawing(Graphics g) {// графика

        Graphics2D g2d = (Graphics2D) g.create();// объявление класса Graphics2D

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); // установка для прорисовки

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh); // установка рендоринга в графику

        Dimension size = getSize(); // размеры
        double w = size.getWidth();
        double h = size.getHeight();

        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130); // овал
        g2d.setStroke(new BasicStroke(1)); // толщина
        g2d.setPaint(Color.gray); // цвет

        for (double deg = 0; deg < 360; deg += 5) { // цикл
            AffineTransform at =
                    AffineTransform.getTranslateInstance(w / 2, h / 2); // наш эффект
            at.rotate(Math.toRadians(deg)); // разварот
            g2d.draw(at.createTransformedShape(e)); // прорисовка
        }
    }

    @Override
    public void paintComponent(Graphics g) {// компонент графики

        super.paintComponent(g);
        doDrawing(g);// вызов нашей графики
    }
}

public class DonutEx extends JFrame {

    public DonutEx() { // конструктор
        // инициализация
        initUI();
    }

    private void initUI() {

        add(new SurfaceDonut());// добавление нашего объекта, на форму

        setTitle("Donut");
        setSize(370, 320);// размеры
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// выход
    }

    public static void main(String[] args) {// главный класс, начало кода

        EventQueue.invokeLater(new Runnable() { // поток
            @Override
            public void run() {// запуск

                DonutEx ex = new DonutEx();// создание нашего класса
                ex.setVisible(true);// видимость
            }
        });
    }
}
