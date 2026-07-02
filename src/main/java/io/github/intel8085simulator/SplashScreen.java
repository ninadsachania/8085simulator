package io.github.intel8085simulator;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {

    private final int duration;

    public SplashScreen(int duration) {
        setAlwaysOnTop(true);
        this.duration = duration;
        showSplashScreenAndExit();
    }

    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor.
    public void showSplashScreen() {
        JPanel content = (JPanel) getContentPane();

        // Set the window's bounds, centering the window.
        int width = 300;
        int height = 50;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Build the splash screen
        getContentPane().setBackground(Color.BLACK);

        JLabel label = new JLabel("Jubin's 8085 Simulator", JLabel.CENTER);
        label.setForeground(new Color(255, 215, 0, 255));
        label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 21));
        content.add(label, BorderLayout.NORTH);

        Color oraRed = new Color(156, 20, 220, 255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

        JProgressBar p = new JProgressBar();
        p.setForeground(new Color(156, 210, 220, 255));
        p.setIndeterminate(true);
        p.setVisible(true);
        content.add(p, BorderLayout.LINE_END);

        // Display it.
        setVisible(true);

        // Wait a little while, maybe while loading resources.
        try {
            Thread.sleep(duration);
        } catch (Exception ignored) {
        }

        // Stop displaying it.
        setVisible(false);
    }

    public void showSplashScreenAndExit() {
        showSplashScreen();
        dispose();
    }

    public static void main(String[] args) {
        new SplashScreen(1000);
        Assembler.main(args);
        // Normally, we'd call splash.showSplash() and get on
        // with the program. But, since this is only a test...
    }
}
