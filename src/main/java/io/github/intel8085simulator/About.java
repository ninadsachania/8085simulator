package io.github.intel8085simulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

public class About extends JFrame {

    public About() {
        initComponents();
    }

    private void initComponents() {
        JLabel appTitleLabel    = new JLabel();
        JLabel appDescLabel     = new JLabel();
        JLabel versionLabel     = new JLabel();
        JLabel appVersionLabel  = new JLabel();
        JLabel vendorLabel      = new JLabel();
        JLabel appVersionLabel1 = new JLabel();
        JLabel vendorLabel1     = new JLabel();
        JLabel appVersionLabel2 = new JLabel();
        JButton jButton1        = new JButton();
        JLabel jLabel1          = new JLabel();

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("About");
        setAlwaysOnTop(true);
        setBounds(new Rectangle(400, 250, 200, 200));
        setForeground(Color.white);
        setResizable(false);

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(Font.BOLD, appTitleLabel.getFont().getSize() + 4));
        appTitleLabel.setText("8085 Simulator");

        appDescLabel.setText("Programming made easy.");

        versionLabel.setFont(versionLabel.getFont().deriveFont(Font.BOLD));
        versionLabel.setText("Product version:");

        appVersionLabel.setText("2.0");

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(Font.BOLD));
        vendorLabel.setText("Created by:");

        appVersionLabel1.setText("Jubin Mitra");

        vendorLabel1.setFont(vendorLabel1.getFont().deriveFont(Font.BOLD));
        vendorLabel1.setText("Contact:");

        jButton1.setMnemonic('c');
        jButton1.setText("Close");
        jButton1.addActionListener(About.this::jButton1ActionPerformed);

        appVersionLabel2.setText("<html> <a href=\"\">http://8085simulatorj.blogspot.in/</a></html>");
        appVersionLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://8085simulatorj.blogspot.in/"));
                } catch (Exception ex) {
                    // It looks like there's a problem
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });

        jLabel1.setIcon(new ImageIcon(super.getClass().getResource("/create.dat")));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(appTitleLabel).addComponent(appDescLabel, -1, 248, 32767).addGroup(layout.createSequentialGroup().addComponent(versionLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(appVersionLabel)).addGroup(layout.createSequentialGroup().addComponent(vendorLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appVersionLabel1)).addGroup(layout.createSequentialGroup().addComponent(vendorLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appVersionLabel2)))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(appTitleLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appDescLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(versionLabel).addComponent(appVersionLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(vendorLabel).addComponent(appVersionLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(vendorLabel1).addComponent(appVersionLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(jButton1).addContainerGap()).addComponent(jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));

        pack();
    }


    private void jButton1ActionPerformed(ActionEvent ignoredEvt) {
        dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new About().setVisible(true));
    }
}