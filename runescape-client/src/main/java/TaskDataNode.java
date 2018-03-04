import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   TaskDataNode field1640;
   @ObfuscatedName("v")
   int field1638;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("data")
   AbstractIntegerNode0 data;
   @ObfuscatedName("b")
   volatile boolean field1639;

   protected TaskDataNode() {
      this.field1639 = true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected abstract TaskDataNode vmethod4438();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected abstract TaskDataNode vmethod4433();

   @ObfuscatedName("s")
   protected abstract int vmethod4443();

   @ObfuscatedName("x")
   protected abstract void vmethod4435(int[] var1, int var2, int var3);

   @ObfuscatedName("t")
   protected abstract void vmethod4436(int var1);

   @ObfuscatedName("aj")
   int vmethod2542() {
      return 255;
   }

   @ObfuscatedName("ff")
   final void method2551(int[] var1, int var2, int var3) {
      if(this.field1639) {
         this.vmethod4435(var1, var2, var3);
      } else {
         this.vmethod4436(var3);
      }

   }
}
