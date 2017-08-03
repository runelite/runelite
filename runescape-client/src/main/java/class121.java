import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public abstract class class121 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1708;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class124 field1706;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   class121 field1709;
   @ObfuscatedName("k")
   int field1707;

   protected class121() {
      this.field1708 = true;
   }

   @ObfuscatedName("i")
   protected abstract void vmethod3897(int[] var1, int var2, int var3);

   @ObfuscatedName("g")
   protected abstract void vmethod3898(int var1);

   @ObfuscatedName("ec")
   final void method2356(int[] var1, int var2, int var3) {
      if(this.field1708) {
         this.vmethod3897(var1, var2, var3);
      } else {
         this.vmethod3898(var3);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected abstract class121 vmethod3895();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected abstract class121 vmethod3913();

   @ObfuscatedName("bi")
   int vmethod2352() {
      return 255;
   }

   @ObfuscatedName("t")
   protected abstract int vmethod3916();
}
