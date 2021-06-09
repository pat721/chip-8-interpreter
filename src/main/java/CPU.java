/**
 * Implements the CPU. The controlling as well as the processing.
 */
public class CPU {

    private Register register;
    private Memory memory;

    public CPU(Memory memory, Register register) {
        this.memory = memory;
        this.register = register;
    }

    public void cpu_cycle() {
        char pc = register.pc;
        // Fetch opcode
        /**
         * Read instruction from address
         * Shift address 8 bit to the left to make room for second instruction
         * Read second instruction from address
         */
        byte opcode = (memory.getMemory(pc));
        opcode <<= 8;
        opcode |= memory.getMemory((char) (pc + 1));

        // Increment the program counter
        pc += (char) 2;

        // decode opcode
        switch(opcode & 0xF000) {
            case 0x0000:
                switch(opcode & 0x000F) {
                    case 0x0000: break; // 00E0 - Clears the screen.
                    case 0x000E: break; // 00EE - Returns from a subroutine.
                    default:
                        System.err.println("Unsupported Opcode!");
                        System.exit(0);
                        break;
                }
            case 0x1000: break; // 1NNN - Jumps to address NNN.
            case 0x2000: break; // 2NNN - Calls subroutine at NNN.
            case 0x3000: break; // 3XNN - Skips the next instruction if VX equals NN. (Usually the next instruction is a jump to skip a code block);
            case 0x4000: break; // 4XNN - Skips the next instruction if VX does not equal NN. (Usually the next instruction is a jump to skip a code block);
            case 0x5000: break; // 5XY0 - Skips the next instruction if VX equals VY. (Usually the next instruction is a jump to skip a code block);
            case 0x6000: break; // 6XNN - Sets VX to NN.
            case 0x7000: break; // 7XNN - Adds NN to VX. (Carry flag is not changed);
            case 0x8000:
                switch(opcode & 0x000F) {
                    case 0x0000: break; // 8XY0 - Sets VX to the value of VY.
                    case 0x0001: break; // 8XY1 - Sets VX to VX or VY. (Bitwise OR operation);
                    case 0x0002: break; // 8XY2 - Sets VX to VX and VY. (Bitwise AND operation);
                    case 0x0003: break; // 8XY3 - Sets VX to VX xor VY.
                    case 0x0004: break; // 8XY4 - Adds VY to VX. VF is set to 1 when there's a carry, and to 0 when there is not.
                    case 0x0005: break; // 8XY5 - VY is subtracted from VX. VF is set to 0 when there's a borrow, and 1 when there is not.
                    case 0x0006: break; // 8XY6 - Stores the least significant bit of VX in VF and then shifts VX to the right by 1.
                    case 0x0007: break; // 8XY7 - Sets VX to VY minus VX. VF is set to 0 when there's a borrow, and 1 when there is not.
                    case 0x000E: break; // 8XYE - Sets VX to VY minus VX. VF is set to 0 when there's a borrow, and 1 when there is not.
                    default:
                        System.err.println("Unsupported Opcode!");
                        System.exit(0);
                        break;
                }
                break;
            case 0x9000: break; // 9XY0 - Skips the next instruction if VX does not equal VY. (Usually the next instruction is a jump to skip a code block);
            case 0xA000: break; // ANNN - Sets I to the address NNN.
            case 0xB000: break; // BNNN - Jumps to the address NNN plus V0.
            case 0xC000: break; // CXNN - Sets VX to the result of a bitwise and operation on a random number (Typically: 0 to 255) and NN.
            case 0xD000: break; // DXYN - Draws a sprite at coordinate (VX, VY) that has a width of 8 pixels and a height of N+1 pixels. Each row of 8 pixels is read as bit-coded starting from memory location I; I value does not change after the execution of this instruction. As described above, VF is set to 1 if any screen pixels are flipped from set to unset when the sprite is drawn, and to 0 if that does not happen
            case 0xE000:
                switch(opcode & 0x000F) {
                    case 0x000E: break; // EX9E - Skips the next instruction if the key stored in VX is pressed. (Usually the next instruction is a jump to skip a code block);
                    case 0x0001: break; // EXA1 - Skips the next instruction if the key stored in VX is not pressed. (Usually the next instruction is a jump to skip a code block);
                    default:
                        System.err.println("Unsupported Opcode!");
                        System.exit(0);
                        break;
                }
                break;
            case 0xF000:
                switch(opcode & 0x00FF) {
                    case 0x0007: break; // FX07 - Sets VX to the value of the delay timer.
                    case 0x000A: break; // FX0A - A key press is awaited, and then stored in VX. (Blocking Operation. All instruction halted until next key event);
                    case 0x0015: break; // FX15 - Sets the delay timer to VX.
                    case 0x0018: break; // FX18 - Sets the sound timer to VX.
                    case 0x001E: break; // FX1E - Adds VX to I. VF is not affected.
                    case 0x0029: break; // FX29 - Sets I to the location of the sprite for the character in VX. Characters 0-F (in hexadecimal) are represented by a 4x5 font.
                    case 0x0033: break; // FX33 - Stores the binary-coded decimal representation of VX, with the most significant of three digits at the address in I, the middle digit at I plus 1, and the least significant digit at I plus 2. (In other words, take the decimal representation of VX, place the hundreds digit in memory at location in I, the tens digit at location I+1, and the ones digit at location I+2.);
                    case 0x0055: break; // FX55 - Stores V0 to VX (including VX) in memory starting at address I. The offset from I is increased by 1 for each value written, but I itself is left unmodified.
                    case 0x0065: break; // FX65 - Fills V0 to VX (including VX) with values from memory starting at address I. The offset from I is increased by 1 for each value written, but I itself is left unmodified.
                }
            default:
                System.err.println("Unsupported Opcode!");
                System.exit(0);
                break;
        }
        // Execute opcode here
    }

}
