package net.runelite.cache.script.assembler;

public class Instructor extends rs2asmBaseListener {

    int pos;

    @Override
    public void exitInstruction(rs2asmParser.InstructionContext ctx) { ++pos; }

}
