/**
 * Implementation of the Chip-8 memory
 */
public class Memory {

    // 4K Bytes of Memory
    private char[] memory;

    //16-Level Stack
    private char[] stack;

    //Display Memory
    private byte[] displayBuffer;

    public Memory() {
        memory = new char[4096];
        stack = new char[16];
        displayBuffer = new byte[64 * 32];
    }

    // Return Bytebuffer for displaying it
    public byte[] getDisplayBuffer() {
        return displayBuffer;
    }
}