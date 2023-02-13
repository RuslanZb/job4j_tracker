package ru.job4j.games;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class PinPong {

    public static int firstRac = 0;
    public static int secondRac = 0;
    public static int ballX = 20;
    public static int ballY = 5;
    public static boolean revers = false;
    public static boolean reversVertical = false;
    public static boolean up = false;
    public static boolean down = false;
    public static int cmd1 =0;
    public static int cmd2 =0;


    public static void main(String args[]) throws Exception {


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameTextField = new JTextField();
        frame.add(nameTextField, BorderLayout.NORTH);

        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) {
                algo(keyEvent);
            }

            public void keyReleased(KeyEvent keyEvent) {
            }

            public void keyTyped(KeyEvent keyEvent) {
            }

            private void algo(KeyEvent keyEvent) {
                if (keyEvent.getKeyChar() == 'z' && firstRac < 8) {
                    firstRac++;
                }
                if (keyEvent.getKeyChar() == 'a' && firstRac > 0) {
                    firstRac--;
                }
                if (keyEvent.getKeyChar() == 'm' && secondRac < 8) {
                    secondRac++;
                }
                if (keyEvent.getKeyChar() == 'k' && secondRac > 0) {
                    secondRac--;
                }
            }
        };
        nameTextField.addKeyListener(keyListener);

        frame.setSize(50, 50);
        frame.setVisible(true);

        System.out.println("Игра Пинг понг");
        while (1 > 0) {
            game();
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void game() {

        System.out.println("                СЧЁТ: " + cmd1 + " : " + cmd2);
        wall("=");
        System.out.println("");
        int firstRacEnd = firstRac + 2;
        int secondRacEnd = secondRac + 2;


        for (int i = 0; i <= 10; i++) {
            mapGorizont(i >= firstRac && i <= firstRacEnd,
                    i >= secondRac && i <= secondRacEnd,
                    i);
        }

        if (revers) {
            if (down) {
                ballX--;
                ballY++;
            } else if (up) {
                ballX--;
                ballY--;
            } else {
                ballX--;
            }
        } else {
            if (down) {
                ballX++;
                ballY++;
            } else if (up) {
                ballX++;
                ballY--;
            } else {
                ballX++;
            }
        }


        wall("=");
        System.out.println("");

    }


    public static void mapGorizont(boolean rac1, boolean rac2, int y) {
        if (rac1) {
            System.out.print("|");
        } else {
            System.out.print(" ");
        }
        for (int i = 1; i <= 39; i++) {

            if (y == ballY) {
                if (ballY == 0 && up) {
                    up = false;
                    down = true;
                } else if (ballY == 10 && down) {
                    up = true;
                    down = false;
                }
            }

            if (y == ballY) {
                if (ballX == i) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
                if (revers && ballX == 1) {
                    if (firstRac == y) {
                        revers = false;
                        up = true;
                        down = false;
                    } else if (firstRac + 1 == y) {
                        revers = false;
                        up = false;
                        down = false;
                    } else if (firstRac + 2 == y) {
                        revers = false;
                        up = false;
                        down = true;
                    } else {
                        cmd2++;
                        ballX = 20;
                        ballY = 5;
                        revers = false;
                    }
                } else if (!revers && ballX == 39) {
                    if (secondRac == y) {
                        revers = true;
                        up = true;
                        down = false;
                    } else if (secondRac + 1 == y) {
                        revers = true;
                        up = false;
                        down = false;
                    } else if (secondRac + 2 == y) {
                        revers = true;
                        up = false;
                        down = true;
                    } else {
                        cmd1++;
                        ballX = 20;
                        ballY = 5;
                        revers = true;
                    }
                }
            } else {
                System.out.print(" ");
            }
        }
        if (rac2) {
            System.out.println("|");
        } else {
            System.out.println(" ");
        }
    }

    public static void wall(String string) {
        for (int up = 0; up <= 40; up++) {
            System.out.print(string);
        }
    }
}
           