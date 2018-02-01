import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("w")
   volatile boolean field1598;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   TaskDataNode field1599;
   @ObfuscatedName("l")
   int field1601;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   @Export("data")
   AbstractIntegerNode0 data;

   protected TaskDataNode() {
      this.field1598 = true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected abstract TaskDataNode vmethod4155();

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected abstract TaskDataNode vmethod4141();

   @ObfuscatedName("r")
   protected abstract int vmethod4158();

   @ObfuscatedName("m")
   protected abstract void vmethod4145(int[] var1, int var2, int var3);

   @ObfuscatedName("o")
   protected abstract void vmethod4144(int var1);

   @ObfuscatedName("aq")
   int vmethod2452() {
      return 255;
   }

   @ObfuscatedName("eh")
   final void method2451(int[] var1, int var2, int var3) {
      if(this.field1598) {
         this.vmethod4145(var1, var2, var3);
      } else {
         this.vmethod4144(var3);
      }

   }
}
