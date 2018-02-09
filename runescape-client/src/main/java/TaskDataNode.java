import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("w")
   volatile boolean field1628;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   TaskDataNode field1627;
   @ObfuscatedName("u")
   int field1625;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("data")
   AbstractIntegerNode0 data;

   protected TaskDataNode() {
      this.field1628 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected abstract TaskDataNode vmethod4311();

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected abstract TaskDataNode vmethod4312();

   @ObfuscatedName("d")
   protected abstract int vmethod4313();

   @ObfuscatedName("z")
   protected abstract void vmethod4314(int[] var1, int var2, int var3);

   @ObfuscatedName("c")
   protected abstract void vmethod4315(int var1);

   @ObfuscatedName("aa")
   int vmethod2558() {
      return 255;
   }

   @ObfuscatedName("fj")
   final void method2561(int[] var1, int var2, int var3) {
      if(this.field1628) {
         this.vmethod4314(var1, var2, var3);
      } else {
         this.vmethod4315(var3);
      }

   }
}
