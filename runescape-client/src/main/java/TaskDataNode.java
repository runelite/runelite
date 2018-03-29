import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("w")
   volatile boolean field1638;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   TaskDataNode field1639;
   @ObfuscatedName("h")
   int field1640;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("data")
   AbstractIntegerNode0 data;

   protected TaskDataNode() {
      this.field1638 = true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected abstract TaskDataNode vmethod4336();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected abstract TaskDataNode vmethod4337();

   @ObfuscatedName("p")
   protected abstract int vmethod4338();

   @ObfuscatedName("w")
   protected abstract void vmethod4339(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void vmethod4340(int var1);

   @ObfuscatedName("ay")
   int vmethod2472() {
      return 255;
   }

   @ObfuscatedName("fi")
   final void method2487(int[] var1, int var2, int var3) {
      if(this.field1638) {
         this.vmethod4339(var1, var2, var3);
      } else {
         this.vmethod4340(var3);
      }

   }
}
