import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    private DisplayPanel panel;

    public Display(Chip chip) {
        setPreferredSize(new Dimension(640, 320));
        pack();
        setPreferredSize(new Dimension(640 + getInsets().left + getInsets().right, 320 + getInsets().left + getInsets().right));
        panel = new DisplayPanel(chip);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chip-8 Interpreter");
        pack();
        setVisible(true);
    }
}
