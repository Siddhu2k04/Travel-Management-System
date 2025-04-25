package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteCustomer extends JFrame {
    private JPanel contentPane;
    private Choice c1;
    private JLabel l2, l3, l4, l5, l6, l7, l8, l9;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DeleteCustomer frame = new DeleteCustomer();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DeleteCustomer() throws SQLException {
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/delete.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 100, 300, 300);
        add(l1);

        JLabel lblTitle = new JLabel("DELETE CUSTOMER DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblTitle.setBounds(118, 11, 300, 53);
        contentPane.add(lblTitle);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setBounds(35, 70, 200, 14);
        contentPane.add(lblUsername);

        c1 = new Choice();
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("SELECT username FROM customer");
            while (rs.next()) {
                c1.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 70, 150, 30);
        contentPane.add(c1);

    //    JLabel lblId = new JLabel("ID :");
   //     lblId.setBounds(35, 110, 200, 14);
    //    contentPane.add(lblId);

    //    l2 = new JLabel();
     //   l2.setBounds(271, 110, 200, 14);
      //  contentPane.add(l2);

        JLabel lblNumber = new JLabel("Number :");
        lblNumber.setBounds(35, 150, 200, 14);
        contentPane.add(lblNumber);

        l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(35, 190, 200, 14);
        contentPane.add(lblName);

        l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);

        JLabel lblAddress = new JLabel("Permanent Address :");
        lblAddress.setBounds(35, 310, 200, 14);
        contentPane.add(lblAddress);

        l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        contentPane.add(l7);

        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setBounds(35, 350, 200, 14);
        contentPane.add(lblPhone);

        l8 = new JLabel();
        l8.setBounds(271, 350, 200, 14);
        contentPane.add(l8);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(35, 390, 200, 14);
        contentPane.add(lblEmail);

        l9 = new JLabel();
        l9.setBounds(271, 390, 200, 14);
        contentPane.add(l9);

        // Fetch customer details when clicking "Check"
        JButton btnCheck = new JButton("Check");
        btnCheck.addActionListener(e -> {
            try {
                Conn c2 = new Conn();
                ResultSet rs = c2.s.executeQuery("SELECT * FROM customer WHERE username = '" + c1.getSelectedItem() + "'");
                if (rs.next()) {
                  //  l2.setText(rs.getString("id"));
                    l3.setText(rs.getString("number"));
                    l4.setText(rs.getString("name"));
                    l5.setText(rs.getString("gender"));
                    l6.setText(rs.getString("country"));
                    l7.setText(rs.getString("address"));
                    l8.setText(rs.getString("phone"));
                    l9.setText(rs.getString("email"));
                } else {
                    JOptionPane.showMessageDialog(null, "No customer found!");
                }
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        btnCheck.setBounds(425, 70, 80, 22);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        contentPane.add(btnCheck);

        // Delete Customer
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(e -> {
            try {
                Conn c3 = new Conn();
                String selectedUser = c1.getSelectedItem();
                String deleteQuery = "DELETE FROM customer WHERE username = '" + selectedUser + "'";
                c3.s.executeUpdate(deleteQuery);
                JOptionPane.showMessageDialog(null, "Customer Details Deleted Successfully");
                setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting customer.");
            }
        });
        btnDelete.setBounds(100, 430, 120, 30);
        btnDelete.setBackground(Color.BLACK);
        btnDelete.setForeground(Color.WHITE);
        contentPane.add(btnDelete);

        // Back Button
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> setVisible(false));
        btnBack.setBounds(260, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        getContentPane().setBackground(Color.WHITE);
    }
}
