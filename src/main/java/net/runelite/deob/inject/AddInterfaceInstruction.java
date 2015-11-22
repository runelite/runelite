package net.runelite.deob.inject;

import org.objectweb.asm.tree.ClassNode;

public class AddInterfaceInstruction {
   private final String clientClass;
   private final String interfaceClass;

   public AddInterfaceInstruction(String var1, String var2) {
      this.clientClass = var1;
      this.interfaceClass = var2;
   }

   public String getClientClass() {
      return this.clientClass;
   }

   public String getInterfaceClass() {
      return this.interfaceClass;
   }

   public boolean valid(ClassNode var1) {
      return var1.name.equalsIgnoreCase(this.clientClass);
   }

   public void inject(ClassNode var1) {
      var1.interfaces.add(this.interfaceClass);
   }
}
