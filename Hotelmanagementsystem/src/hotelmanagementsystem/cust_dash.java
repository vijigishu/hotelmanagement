/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cust_dash extends JFrame {
    private JButton bookNowButton;
    private JButton changePasswordButton;
    private JButton logoutButton;

    public cust_dash() {
        setTitle("Customer Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        bookNowButton = new JButton("Book Now");
        changePasswordButton = new JButton("Change Password/Username");
        logoutButton = new JButton("Logout");

        panel.add(bookNowButton);
        panel.add(changePasswordButton);
        panel.add(logoutButton);

        add(panel);

        bookNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement book now functionality
                JOptionPane.showMessageDialog(cust_dash.this, "Booking functionality will be implemented soon.");
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement change password/username functionality
                JOptionPane.showMessageDialog(cust_dash.this, "Change password/username functionality will be implemented soon.");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(cust_dash.this, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Implement logout functionality
                    JOptionPane.showMessageDialog(cust_dash.this, "Logged out successfully.");
                    dispose(); // Close the dashboard window
                    // Code to navigate back to login or wherever needed
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new cust_dash().setVisible(true);
            }
        });
    }
}
