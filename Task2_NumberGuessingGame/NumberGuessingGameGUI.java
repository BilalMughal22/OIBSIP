import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame {




    private Random random = new Random();
    private int numberToGuess = 0;
    private int attempts = 0;
    private int score = 0;
    private boolean hasWon = false;


    private JLabel scoreLabel;
    private JLabel attemptsLabel;
    private JLabel messageLabel;
    private JTextField guessField;

    // Constructor
    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game 🎮");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(30, 30, 60)); // dark blue background
        mainPanel.setLayout(new BorderLayout());

        // TOP PANEL - Title
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(30, 30, 60));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));


        JLabel titleLabel = new JLabel("🎮 Number Guessing Game");
        titleLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 28));
        titleLabel.setForeground(new Color(255, 215, 0)); // golden color
        titleLabel.setHorizontalAlignment(JLabel.CENTER);


        JLabel subtitleLabel = new JLabel("Guess a number between 1 and 100!");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(255, 255, 255)); // white
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);


        titlePanel.setLayout(new GridLayout(2, 1));
        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);


        mainPanel.add(titlePanel, BorderLayout.NORTH);



      
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(30, 30, 60));
        centerPanel.setLayout(new GridLayout(6, 1, 10, 15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

// Score Label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(new Color(0, 255, 150)); // green
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

// Attempts Label
        attemptsLabel = new JLabel("Attempts: 0");
        attemptsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        attemptsLabel.setForeground(new Color(255, 255, 255));
        attemptsLabel.setHorizontalAlignment(JLabel.CENTER);

// Input Field
        guessField = new JTextField();
        guessField.setFont(new Font("Arial", Font.PLAIN, 20));
        guessField.setHorizontalAlignment(JTextField.CENTER);
        guessField.setBackground(new Color(50, 50, 90));
        guessField.setForeground(Color.WHITE);
        guessField.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(new Color(255, 215, 0), 2),
        "Enter Your Guess",
        0, 0,
        new Font("Arial", Font.PLAIN, 12),
        new Color(255, 215, 0)
    ));

        // Message Label
        messageLabel = new JLabel("Game Started! Make your guess!");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setForeground(new Color(255, 215, 0));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add to center panel
        centerPanel.add(scoreLabel);
        centerPanel.add(attemptsLabel);
        centerPanel.add(guessField);
        centerPanel.add(messageLabel);

        // Add to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);


        // BOTTOM PANEL - Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(30, 30, 60));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Guess Button
        JButton guessButton = new JButton("🎯 Guess!");
        guessButton.setFont(new Font("Arial", Font.BOLD, 16));
        guessButton.setBackground(new Color(0, 200, 100));
        guessButton.setForeground(Color.WHITE);
        guessButton.setFocusPainted(false);
        guessButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        guessButton.setPreferredSize(new Dimension(140, 45));

        // New Game Button
        JButton newGameButton = new JButton("🔄 New Game");
        newGameButton.setFont(new Font("Arial", Font.BOLD, 16));
        newGameButton.setBackground(new Color(50, 150, 255));
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setFocusPainted(false);
        newGameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        newGameButton.setPreferredSize(new Dimension(140, 45));

        // Exit Button
        JButton exitButton = new JButton("❌ Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setBackground(new Color(255, 80, 80));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setPreferredSize(new Dimension(140, 45));

        // Add buttons to panel
        buttonPanel.add(guessButton);
        buttonPanel.add(newGameButton);
        buttonPanel.add(exitButton);

        // Add to main panel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            // Generate first number when game starts
        numberToGuess = random.nextInt(100) + 1;

        // GUESS BUTTON Logic
        guessButton.addActionListener(e -> {
            String input = guessField.getText();
    
        if (input == null || input.isEmpty()) {
            messageLabel.setForeground(new Color(255, 80, 80));
            messageLabel.setText("Please enter a number!");
            return;
        }

        int userGuess = Integer.parseInt(input);
        attempts++;
        attemptsLabel.setText("Attempts: " + attempts);
        guessField.setText("");

        if (userGuess == numberToGuess) {
            if (attempts <= 3) score += 10;
            else if (attempts <= 6) score += 5;
            else score += 1;
            scoreLabel.setText("Score: " + score);
            messageLabel.setForeground(new Color(0, 255, 150));
            messageLabel.setText("🎉 Correct! It was " + numberToGuess + "!");
            guessButton.setEnabled(false);

        } else if (userGuess < numberToGuess) {
            messageLabel.setForeground(new Color(255, 150, 0));
            messageLabel.setText("📈 Too Low! Try Higher!");
        } else {
            messageLabel.setForeground(new Color(255, 80, 80));
            messageLabel.setText("📉 Too High! Try Lower!");
        }
    });

    // NEW GAME BUTTON Logic
    newGameButton.addActionListener(e -> {
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;
        hasWon = false;
        attemptsLabel.setText("Attempts: 0");
        messageLabel.setForeground(new Color(255, 215, 0));
        messageLabel.setText("New Game Started! Make your guess!");
        guessField.setText("");
        guessButton.setEnabled(true);
    });

    // EXIT BUTTON Logic
    exitButton.addActionListener(e -> {
        JOptionPane.showMessageDialog(null, 
            "Thanks for playing! Final Score: " + score);
        System.exit(0);
    });

            // Add panel to window
            add(mainPanel);
        }

        public static void main(String[] args) {    
            
            SwingUtilities.invokeLater(() -> {
            NumberGuessingGameGUI window = new NumberGuessingGameGUI();
            window.setVisible(true);
        });
        }
    }