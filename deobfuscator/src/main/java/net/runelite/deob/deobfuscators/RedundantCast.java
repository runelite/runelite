/* 
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info> 
 * All rights reserved. 
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this 
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR 
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND 
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.execution.*;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RedundantCast implements Deobfuscator
{
    private static final Logger logger = LoggerFactory.getLogger(RedundantCast.class);

    private int removed;

    private final List<Instruction> interesting = new ArrayList<>();

    private void visit(InstructionContext ictx)
    {
        if (!(ictx.getInstruction() instanceof CheckCast))
        {
            return;
        }

        if (interesting.contains(ictx.getInstruction()))
        {
            return;
        }

        ClassGroup group = ictx.getInstruction().getInstructions().getCode().getMethod().getClassFile().getGroup();
        CheckCast cast = (CheckCast) ictx.getInstruction();
        StackContext sctx = ictx.getPops().get(0);

        Type from = sctx.type;
        Type to = new Type(cast.getType_());

        if (to.equals(from))
        {
            interesting.add(cast);
        }

        else if (!from.isArray() && !to.isArray())
        {
            ClassFile fromC = group.findClass(from.type);
            ClassFile toC = group.findClass(to.type);

            if (fromC != null && toC != null)
            {
                //Class.isAssignableFrom(Class<?>)
                //superclass or superinterface of, the class or interface represented by the specified Class parameter
                if (toC.getChildren().contains(fromC))
                {
                    interesting.add(cast);
                }
            }
        }
    }

    private void visit(MethodContext ctx)
    {
        Instructions ins = ctx.getMethod().getCode().getInstructions();
        interesting.forEach(ins::remove);
        removed += interesting.size();
        interesting.clear();
    }

    @Override
    public void run(ClassGroup group)
    {
        Execution execution = new Execution(group);
        execution.addExecutionVisitor(i -> visit(i));
        execution.addMethodContextVisitor(i -> visit(i));
        execution.populateInitialMethods();
        execution.run();

        logger.info("Removed {} redundant casts", removed);
    }

}