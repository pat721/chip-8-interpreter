import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    private byte[] displayBuffer;

    public Display(Memory memory) {
        displayBuffer = memory.getDisplayBuffer();
    }

    public void paint(Graphics graphics) {
        for (int i = 0; i < displayBuffer.length; i++) {
            if (displayBuffer[i] == 0) {
                graphics.setColor(Color.BLACK);
            } else {
                graphics.setColor(Color.WHITE);
            }
            int x = (i % 64);
            int y = (int) Math.floor(i / 64);

            graphics.fillRect(x * 10, y * 10, 10, 10);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(64 * 10, 32 * 10);
    }
}
