import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   TaskDataNode field1627;
   @ObfuscatedName("k")
   int field1626;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("data")
   AbstractIntegerNode0 data;
   @ObfuscatedName("w")
   volatile boolean field1628;

   protected TaskDataNode() {
      this.field1628 = true;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected abstract TaskDataNode vmethod4354();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected abstract TaskDataNode vmethod4356();

   @ObfuscatedName("x")
   protected abstract int vmethod4363();

   @ObfuscatedName("p")
   protected abstract void vmethod4357(int[] var1, int var2, int var3);

   @ObfuscatedName("c")
   protected abstract void vmethod4367(int var1);

   @ObfuscatedName("aw")
   int vmethod2489() {
      return 255;
   }

   @ObfuscatedName("er")
   final void method2473(int[] var1, int var2, int var3) {
      if(this.field1628) {
         this.vmethod4357(var1, var2, var3);
      } else {
         this.vmethod4367(var3);
      }

   }
}
