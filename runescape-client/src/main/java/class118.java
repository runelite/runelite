import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public abstract class class118 extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   class118 field1631;
   @ObfuscatedName("h")
   int field1629;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class121 field1630;
   @ObfuscatedName("y")
   volatile boolean field1628;

   protected class118() {
      this.field1628 = true;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected abstract class118 vmethod3931();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected abstract class118 vmethod3946();

   @ObfuscatedName("t")
   protected abstract int vmethod3925();

   @ObfuscatedName("k")
   protected abstract void vmethod3926(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void vmethod3927(int var1);

   @ObfuscatedName("ap")
   int vmethod2311() {
      return 255;
   }

   @ObfuscatedName("ex")
   final void method2296(int[] var1, int var2, int var3) {
      if(this.field1628) {
         this.vmethod3926(var1, var2, var3);
      } else {
         this.vmethod3927(var3);
      }

   }
}
