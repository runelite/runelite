package net.runelite.deob.inject;

import java.util.Iterator;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodNode;

public class TableJumpInstruction {
   private final TableJumpInstruction$TableJump[] tableJumps;
   private final int[] labels;
   private final int start;
   private final AbstractInsnNode[] instructions;
   private final String owner;
   private final String name;
   private final String desc;

   public TableJumpInstruction(TableJumpInstruction$TableJump[] var1, AbstractInsnNode[] var2, int[] var3, int var4, String var5, String var6, String var7) {
      this.tableJumps = var1;
      this.instructions = var2;
      this.labels = var3;
      this.owner = var5;
      this.name = var6;
      this.desc = var7;
      this.start = var4;
   }

   public boolean valid(ClassNode var1) {
      return var1.name.equalsIgnoreCase(this.owner);
   }

   public void inject(ClassNode var1) {
      Iterator var3 = var1.methods.iterator();

      MethodNode var2;
      do {
         if(!var3.hasNext()) {
            return;
         }

         var2 = (MethodNode)var3.next();
      } while(!var2.name.equalsIgnoreCase(this.name) || !var2.desc.equalsIgnoreCase(this.desc));

      this.insert(var2);
   }

   private void insert(MethodNode var1) {
      AbstractInsnNode[] var2 = new AbstractInsnNode[this.instructions.length];
      Label[] var3 = new Label[this.labels.length];
      InsnList var4 = var1.instructions;

      int var5;
      for(var5 = 0; var5 < this.labels.length; ++var5) {
         int var6 = this.labels[var5];
         if(var6 == -1) {
            var3[var5] = new Label();
         } else {
            JumpInsnNode var7 = (JumpInsnNode)var4.get(var6);
            var3[var5] = var7.label.getLabel();
         }
      }

      for(var5 = 0; var5 < this.instructions.length; ++var5) {
         Object var11 = this.instructions[var5];
         if(var11 == null) {
            TableJumpInstruction$TableJump var12 = this.getJump(var5);
            LabelNode var8 = new LabelNode(var3[var12.labelArrayIndex]);
            if(var12.opcode != 9000) {
               var11 = new JumpInsnNode(var12.opcode, var8);
            } else {
               var11 = var8;
            }
         }

         var2[var5] = (AbstractInsnNode)var11;
      }

      AbstractInsnNode var10 = var4.get(this.start);
      AbstractInsnNode[] var9 = var2;
      int var15 = var2.length;

      for(int var13 = 0; var13 < var15; ++var13) {
         AbstractInsnNode var14 = var9[var13];
         var4.insertBefore(var10, var14);
      }

   }

   private TableJumpInstruction$TableJump getJump(int var1) {
      TableJumpInstruction$TableJump[] var5 = this.tableJumps;
      int var4 = this.tableJumps.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         TableJumpInstruction$TableJump var2 = var5[var3];
         if(var2.instructionIndex == var1) {
            return var2;
         }
      }

      return null;
   }
}
