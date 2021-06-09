/**
 * Implementation of the Chip-8 registers
 */
public class Register {

    //16 8-bit registers for general purpose
    private byte[] registers;

    //Index Register for storing memory address
    private char index;

    //Program Counter
    private char pc;

    //Pointer for the Stack
    private int stackPointer;

    //Delay timer
    private int delay_timer;

    //Sound timer
    private int sound_timer;

    public Register() {
        registers = new byte[16];
        pc = 0x200;
        index = 0x0;
        stackPointer = 0;
        delay_timer = 0;
        sound_timer = 0;
    }
}
