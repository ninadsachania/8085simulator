package io.github.intel8085simulator;

import org.approvaltests.Approvals;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Intel8085SimulatorTest {

    private void runCode(String[] code, AssemblerEngine engine, Matrix matrix, Assembler assembler) {
        int mem = 0;
        for (String string : code) {
            String[] s = engine.MnemonicToHexcode(string);

            int functionNumber = Integer.parseInt(s[3]);
            matrix.memory[mem++] = functionNumber;

            for (int j = 1; j < engine.I[functionNumber][0]; j++) {
                matrix.memory[mem++] = engine.Hex2Dec(s[j]);
            }
        }

        while (!assembler.stop) {
            matrix.functionRun(matrix.memory[matrix.PC]);
        }
    }

    @Test
    public void test1sComplementOfAn8BitNumber() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x96;

        // 1's complement of an 8-bit number.
        String[] code = {
                "LDA C050",
                "CMA",
                "STA C051",
                "HLT"
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x69, matrix.memory[0xC051]);
    }

    @Test
    public void test2sComplementOfAn8BitNumber() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x96;

        // 2's complement of an 8-bit number.
        String[] code = {
                "LDA C050",
                "CMA",
                "INR A",
                "STA C051",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x6A, matrix.memory[0xC051]);
    }

    @Test
    public void testAdditionOfTwo8BitNumbers() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Inputs.
        matrix.memory[0xC050] = 0x55;
        matrix.memory[0xC051] = 0x66;

        // Addition of two 8-bit numbers.
        String[] code = {
                "LXI H,C050",
                "MOV A,M",
                "INX H",
                "ADD M",
                "STA C052",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0xBB, matrix.memory[0xC052]);
    }

    @Test
    public void testShiftAn8BitNumberLeftByOne() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x65;

        // Shift an 8-bit number left by 1 bit
        String[] code = {
                "LDA C050",
                "ADD A",
                "STA C051",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0xCA, matrix.memory[0xC051]);
    }

    @Test
    public void testFindSquareFromLookupTable() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Look-up table.
        for (int i = 0; i < 10; i += 1) {
            matrix.memory[0xC060 + i] = i * i;
        }

        // Input.
        matrix.memory[0xC050] = 9;

        // To find square from loop-up table.
        String[] code = {
                "LDA C050",
                "ADI 60",
                "MOV L,A",
                "MVI H,C0",
                "MOV A,M",
                "STA C051",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(81, matrix.memory[0xC051]);
    }

    @Test
    public void test8BitDecimalSubtraction() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x99;
        matrix.memory[0xC051] = 0x48;

        // 8-bit decimal subtraction.
        // If 2nd no is greater than 1st no then the answer will in 2's complement.
        String[] code = {
                "LXI H,C051",
                "MVI A,99",
                "SUB M",
                "INR A",
                "DCX H",
                "ADD M",
                "DAA",
                "STA C052",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x51, matrix.memory[0xC052]);
    }

    @Test
    public void testMaskOffLeastSignificant4BitsOfAn8BitNumber() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x96;

        // Mask off least significant 4 bits of an 8-bit number.
        String[] code = {
                "LDA C050",
                "ANI F0",
                "STA C051",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x90, matrix.memory[0xC051]);
    }

    @Test
    public void testMaskOffMostSignificant4BitsOfAn8BitNumber() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x96;

        // Mask off most significant 4 bits of an 8-bit number.
        String[] code = {
                "LDA C050",
                "ANI 0F",
                "STA C051",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x06, matrix.memory[0xC051]);
    }

    @Test
    public void testShiftAn8BitNumberLeftBy1Bit() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x65;

        // Shift an 8-bit number left by 1 bit.
        String[] code = {
                "LDA C050",
                "ADD A",
                "STA C051",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0xCA, matrix.memory[0xC051]);
    }

    @Test
    public void testShiftAn16BitNumberLeftBy1Bit() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x96;
        matrix.memory[0xC051] = 0x75;

        // Shift an 16-bit number left by 1 bit.
        String[] code = {
                "LHLD C050",
                "DAD H",
                "SHLD C052",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x2C, matrix.memory[0xC052]);
        assertEquals(0xEB, matrix.memory[0xC053]);
    }

    @Test
    public void testShiftAn16BitNumberLeftBy2Bits() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x96;
        matrix.memory[0xC051] = 0x15;

        // Shift an 16-bit number left by 2 bits.
        String[] code = {
                "LHLD C050",
                "DAD H",
                "DAD H",
                "SHLD C052",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x58, matrix.memory[0xC052]);
        assertEquals(0x56, matrix.memory[0xC053]);
    }

    @Test
    public void testSubtractionOfTwo8BitNumbers() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x95;
        matrix.memory[0xC051] = 0x65;

        // Subtraction of two 8-bit numbers.
        String[] code = {
                "LXI H,C050",
                "MOV A,M",
                "INX H",
                "SUB M",
                "INX H",
                "MOV M,A",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x30, matrix.memory[0xC052]);
    }

    @Test
    public void test1sComplementOfA16BitNumber() {
        Assembler assembler = new Assembler();
        Matrix matrix = new Matrix(assembler);
        AssemblerEngine engine = new AssemblerEngine(matrix);

        // Input.
        matrix.memory[0xC050] = 0x85;
        matrix.memory[0xC051] = 0x54;

        // 1's complement of a 16-bit number.
        String[] code = {
                "LXI H,C050",
                "MOV A,M",
                "CMA",
                "STA C052",
                "INX H",
                "MOV A,M",
                "CMA",
                "STA C053",
                "HLT",
        };

        runCode(code, engine, matrix, assembler);

        Approvals.verify(matrix);
        assertEquals(0x7A, matrix.memory[0xC052]);
        assertEquals(0xAB, matrix.memory[0xC053]);
    }

}
