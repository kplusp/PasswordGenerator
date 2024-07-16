import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This is the front end side of this app
public class GUI extends JFrame {
    private Generator passwordGen;
    public GUI(){
        // It gives the app a title
        super("Password Generator App");
        // Sets the size of the app
        setSize(540,570);
        setLocationRelativeTo(null);
        // Prevents it from resizing
        setResizable(false);
        // Sets layout to null
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        passwordGen = new Generator();
        subcomponents();
    }

    private void subcomponents(){
        // Adding Heading to the app
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD,32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel);

        // Here the password would be generated to be copied by the user
        JTextArea password = new JTextArea();
        password.setEditable(false);
        password.setFont(new Font("Dialog", Font.BOLD,32));
        JScrollPane scroll = new JScrollPane(password);
        scroll.setBounds(25,97,479, 70);
        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scroll);

        //Label for Password Length
        JLabel passwordLength = new JLabel("Password Length");
        passwordLength.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLength.setBounds(25,215,272,39);
        add(passwordLength);
        // Password Length Input
        JTextArea lengthInput = new JTextArea();
        lengthInput.setFont(new Font("Dialog", Font.PLAIN, 32));
        lengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lengthInput.setBounds(310,215,192,39);
        add(lengthInput);

        // Creating Toggle Buttons to customize the password
        JToggleButton uppercase = new JToggleButton("Uppercase");
        uppercase.setFont(new Font("Dialog", Font.PLAIN,26));
        uppercase.setBounds(25,302,225,56);
        add(uppercase);

        JToggleButton lowercase = new JToggleButton("Lowercase");
        lowercase.setFont(new Font("Dialog", Font.PLAIN,26));
        lowercase.setBounds(282,302,225,56);
        add(lowercase);

        JToggleButton numbers = new JToggleButton("Numbers");
        numbers.setFont(new Font("Dialog", Font.PLAIN,26));
        numbers.setBounds(25,373,225,56);
        add(numbers);

        JToggleButton symbols = new JToggleButton("Symbols");
        symbols.setFont(new Font("Dialog", Font.PLAIN,26));
        symbols.setBounds(282,373,225,56);
        add(symbols);

        // A Generate button to uh... generate password
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155,467,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordLength.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercase.isSelected() || uppercase.isSelected() || numbers.isSelected() || symbols.isSelected();

                int passLength = Integer.parseInt(lengthInput.getText());
                if (anyToggleSelected) {
                    String generatedPass = passwordGen.generatePassword(passLength, uppercase.isSelected(), lowercase.isSelected(), numbers.isSelected(), symbols.isSelected());
                    password.setText(generatedPass);
                }
            }
        });
        add(generateButton);
    }
}
