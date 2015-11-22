package net.runelite.deob.inject;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class AddMethodInstruction {
   private final String clientClass;
   private final String methodName;
   private final String methodDesc;
   private final AbstractInsnNode[] instructions;

   public AddMethodInstruction(String var1, String var2, String var3, AbstractInsnNode[] var4) {
      this.clientClass = var1;
      this.methodName = var2;
      this.methodDesc = var3;
      this.instructions = var4;
   }

   public boolean valid(ClassNode var1) {
      return var1.name.equalsIgnoreCase(this.clientClass);
   }

   public void inject(ClassNode var1) {
      MethodNode var2 = new MethodNode(1, this.methodName, this.methodDesc, (String)null, (String[])null);
      AbstractInsnNode[] var6 = this.instructions;
      int var5 = this.instructions.length;

      for(int var4 = 0; var4 < var5; ++var4) {
         AbstractInsnNode var3 = var6[var4];
         var2.instructions.add(var3);
      }

      var2.visitMaxs(0, 0);
      var1.methods.add(var2);
   }
}
