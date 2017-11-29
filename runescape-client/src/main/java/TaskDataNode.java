import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   TaskDataNode field1633;
   @ObfuscatedName("f")
   int field1632;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   AbstractIntegerNode0 field1634;
   @ObfuscatedName("e")
   volatile boolean field1635;

   protected TaskDataNode() {
      this.field1635 = true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected abstract TaskDataNode vmethod4054();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected abstract TaskDataNode vmethod4055();

   @ObfuscatedName("t")
   protected abstract int vmethod4056();

   @ObfuscatedName("p")
   protected abstract void vmethod4057(int[] var1, int var2, int var3);

   @ObfuscatedName("l")
   protected abstract void vmethod4058(int var1);

   @ObfuscatedName("av")
   int vmethod2413() {
      return 255;
   }

   @ObfuscatedName("et")
   final void method2407(int[] var1, int var2, int var3) {
      if(this.field1635) {
         this.vmethod4057(var1, var2, var3);
      } else {
         this.vmethod4058(var3);
      }

   }
}
