import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("TaskDataNode")
public abstract class TaskDataNode extends Node {
   @ObfuscatedName("w")
   volatile boolean field1614;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   TaskDataNode field1612;
   @ObfuscatedName("i")
   int field1611;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   AbstractIntegerNode0 field1613;

   protected TaskDataNode() {
      this.field1614 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected abstract TaskDataNode vmethod4041();

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected abstract TaskDataNode vmethod4040();

   @ObfuscatedName("f")
   protected abstract int vmethod4045();

   @ObfuscatedName("g")
   protected abstract void vmethod4062(int[] var1, int var2, int var3);

   @ObfuscatedName("c")
   protected abstract void vmethod4046(int var1);

   @ObfuscatedName("aa")
   int vmethod2290() {
      return 255;
   }

   @ObfuscatedName("fp")
   final void method2289(int[] var1, int var2, int var3) {
      if(this.field1614) {
         this.vmethod4062(var1, var2, var3);
      } else {
         this.vmethod4046(var3);
      }

   }
}
