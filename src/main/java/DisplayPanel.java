import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private Chip chip;

    public DisplayPanel(Chip chip) {
        this.chip = chip;
    }

    public void paint(Graphics graphics) {
        //draw graphics here
        byte[] display = chip.getDisplay();
        for(int i=0; i<display.length; i++) {
            if(display[i] == 0) {
                graphics.setColor(Color.BLACK);
            } else {
                graphics.setColor(Color.WHITE);
            }
            int x = (i % 64);
            int y = (int) Math.floor(i / 64);

            graphics.fillRect(x * 10, y *10, 10, 10);
        }
    }

}
