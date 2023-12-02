import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        // Set up the frame
        setTitle("Styled Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the frame on the screen
        setResizable(false); // Disable resizing

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login logic here
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                String passwordStr = new String(password);

                // Replace this with your authentication logic
                if (authenticate(username, passwordStr)) {
                    JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!");
                    // Add code to open the main application window or perform other actions after login
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Login Failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set up the layout with padding
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Style components
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        usernameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));

        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        // Set background color
        getContentPane().setBackground(new Color(240, 240, 240));

        // Make the frame visible
        setVisible(true);
    }

    // Replace this method with your authentication logic
    private boolean authenticate(String username, String password) {
        // Replace this with actual authentication logic (e.g., check against a database)
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}

