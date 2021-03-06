package com.tarnet.desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public MainForm() throws HeadlessException {
        this.setSize(600, 400);
        this.setTitle("Tarnet Messenger");

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem connectMenuItem = new JMenuItem("Connect");
        JMenuItem disConnectMenuItem = new JMenuItem("Disconnect");
        fileMenu.add(connectMenuItem);
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        fileMenu.add(disConnectMenuItem);
        menuBar.add(helpMenu);

        JPanel panel = new JPanel();
        JLabel lblEnterMessage = new JLabel("Enter Message:");
        JTextField txtMessage = new JFormattedTextField(15);
        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"First");
            }
        });

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(actionEvent -> {
            JOptionPane.showMessageDialog(null,"Form has been reset.");
        });

        panel.add(lblEnterMessage);
        panel.add(txtMessage);
        panel.add(btnSend);
        panel.add(btnReset);
        JTextArea summary = new JTextArea();
        this.getContentPane().add(BorderLayout.PAGE_START, menuBar);
        this.getContentPane().add(BorderLayout.CENTER,summary);
        this.getContentPane().add(BorderLayout.PAGE_END, panel);
        this.setVisible(true);
    }
}
