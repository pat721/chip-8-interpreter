import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    private byte[] displayBuffer;

    private byte scale = 20;
    private final short width = 64;
    private final short height = 32;

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
            int x = (i % width);
            int y = (int) Math.floor(i / width);

            graphics.fillRect(x * scale, y * scale, scale, scale);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(width * scale, height * scale);
    }
}
