import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   TaskDataNode field1600;
   @ObfuscatedName("f")
   int field1602;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("data")
   AbstractIntegerNode0 data;
   @ObfuscatedName("x")
   volatile boolean field1603;

   protected TaskDataNode() {
      this.field1603 = true;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected abstract TaskDataNode vmethod4324();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected abstract TaskDataNode vmethod4323();

   @ObfuscatedName("y")
   protected abstract int vmethod4326();

   @ObfuscatedName("g")
   protected abstract void vmethod4344(int[] var1, int var2, int var3);

   @ObfuscatedName("u")
   protected abstract void vmethod4328(int var1);

   @ObfuscatedName("ae")
   int vmethod2480() {
      return 255;
   }

   @ObfuscatedName("fj")
   final void method2484(int[] var1, int var2, int var3) {
      if(this.field1603) {
         this.vmethod4344(var1, var2, var3);
      } else {
         this.vmethod4328(var3);
      }

   }
}
