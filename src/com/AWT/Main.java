package com.AWT;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

public class Main extends Frame {

    public Main(){
        super("Java AWT Transformation"); // вызов фрейма от которого наследуем
        prepareGUI(); // вызов функции
    }

    public static void main(String[] args){
        Main  mainGraphics = new Main(); // созданиеп нашего Main
        mainGraphics.setVisible(true); // делаем окно выидимым
    }

    private void prepareGUI(){
        setSize(1200,800); // размеры
        addWindowListener(new WindowAdapter() { // действие на закрытие окна
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; // создание рисунка
        g.drawString("Tрансформация фигур:", 50, 70);

        g2.setColor(Color.blue);

        Rectangle2D rectangle1 = new Rectangle2D.Float();// создание Rectangle2D
        rectangle1.setFrame(100, 100, 100, 100);  // размеры
        g2.draw (rectangle1); // прорисовка Rectangle2D

        // больше
        AffineTransform tx1 = new AffineTransform();
        tx1.translate(0,0); // сдвиг
        tx1.scale(0.5,0.5);
        g2.setTransform(tx1);

        Rectangle2D rectangle2 = new Rectangle2D.Float();// создание Rectangle2D
        rectangle2.setFrame(400, 200, 100, 100);  // размеры
        g2.fill (rectangle2); // прорисовка Rectangle2D

        g2.setColor(Color.green);
        // сдвиг
        AffineTransform tx2 = new AffineTransform();
        tx2.translate(20,20); // сдвиг
        g2.setTransform(tx2);

        Rectangle2D rectangle3 = new Rectangle2D.Float();// создание Rectangle2D
        rectangle3.setFrame(300, 100, 100, 100);  // размеры
        g2.fill (rectangle3); // прорисовка Rectangle2D

        g2.setColor(Color.red);
        // сломать
        AffineTransform tx3 = new AffineTransform();
        tx3.translate(0,0); // сдвиг
        tx3.shear(0.5,0);
        g2.setTransform(tx3);

        Rectangle2D rectangle4 = new Rectangle2D.Float();// создание Rectangle2D
        rectangle4.setFrame(400, 100, 100, 100);  // размеры
        g2.fill (rectangle4); // прорисовка Rectangle2D

        g2.setColor(Color.yellow);
        AffineTransform tx4 = new AffineTransform();
        tx4.translate(0,0); // сдвиг
        //tx4.rotate(45);
        g2.setTransform(tx4);

        Rectangle2D rectangle5 = new Rectangle2D.Float();// создание Rectangle2D
        rectangle5.setFrame(600, 100, 100, 100);  // размеры
        g2.fill (rectangle5); // прорисовка Rectangle2D

        g2.setColor(Color.black);
        AffineTransform tx5 = new AffineTransform();
        tx5.translate(0,0); // сдвиг
        tx5.rotate(45);
        g2.setTransform(tx5);

        Rectangle2D rectangle6 = new Rectangle2D.Float();// создание Rectangle2D
        rectangle5.setFrame(600, 100, 100, 100);  // размеры
        g2.fill (rectangle5); // прорисовка Rectangle2D

        g2.dispose();
    }
}

