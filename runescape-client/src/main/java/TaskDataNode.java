import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("w")
   volatile boolean field1660;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   TaskDataNode field1658;
   @ObfuscatedName("q")
   int field1659;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("data")
   AbstractIntegerNode0 data;

   protected TaskDataNode() {
      this.field1660 = true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected abstract TaskDataNode vmethod4330();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected abstract TaskDataNode vmethod4321();

   @ObfuscatedName("i")
   protected abstract int vmethod4314();

   @ObfuscatedName("u")
   protected abstract void vmethod4317(int[] var1, int var2, int var3);

   @ObfuscatedName("y")
   protected abstract void vmethod4319(int var1);

   @ObfuscatedName("ae")
   int vmethod2491() {
      return 255;
   }

   @ObfuscatedName("fn")
   final void method2495(int[] var1, int var2, int var3) {
      if(this.field1660) {
         this.vmethod4317(var1, var2, var3);
      } else {
         this.vmethod4319(var3);
      }

   }
}
