import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   TaskDataNode field1624;
   @ObfuscatedName("f")
   int field1622;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   @Export("data")
   AbstractIntegerNode0 data;
   @ObfuscatedName("v")
   volatile boolean field1621;

   protected TaskDataNode() {
      this.field1621 = true;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected abstract TaskDataNode vmethod4437();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected abstract TaskDataNode vmethod4424();

   @ObfuscatedName("y")
   protected abstract int vmethod4425();

   @ObfuscatedName("c")
   protected abstract void vmethod4441(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void vmethod4426(int var1);

   @ObfuscatedName("bo")
   int vmethod2570() {
      return 255;
   }

   @ObfuscatedName("fv")
   final void method2573(int[] var1, int var2, int var3) {
      if(this.field1621) {
         this.vmethod4441(var1, var2, var3);
      } else {
         this.vmethod4426(var3);
      }

   }
}
