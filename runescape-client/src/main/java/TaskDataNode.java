import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("w")
   volatile boolean field1628;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   TaskDataNode field1630;
   @ObfuscatedName("i")
   int field1629;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   AbstractIntegerNode0 field1631;

   protected TaskDataNode() {
      this.field1628 = true;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected abstract TaskDataNode vmethod4096();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected abstract TaskDataNode vmethod4097();

   @ObfuscatedName("b")
   protected abstract int vmethod4109();

   @ObfuscatedName("e")
   protected abstract void vmethod4099(int[] var1, int var2, int var3);

   @ObfuscatedName("u")
   protected abstract void vmethod4100(int var1);

   @ObfuscatedName("bq")
   int vmethod2352() {
      return 255;
   }

   @ObfuscatedName("fo")
   final void method2356(int[] var1, int var2, int var3) {
      if(this.field1628) {
         this.vmethod4099(var1, var2, var3);
      } else {
         this.vmethod4100(var3);
      }

   }
}
