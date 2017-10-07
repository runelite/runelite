import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public abstract class class117 extends Node {
   @ObfuscatedName("c")
   volatile boolean field1703;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   class120 field1705;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   class117 field1706;
   @ObfuscatedName("j")
   int field1704;

   protected class117() {
      this.field1703 = true;
   }

   @ObfuscatedName("v")
   protected abstract void vmethod4004(int[] var1, int var2, int var3);

   @ObfuscatedName("y")
   protected abstract void vmethod4023(int var1);

   @ObfuscatedName("fm")
   final void method2374(int[] var1, int var2, int var3) {
      if(this.field1703) {
         this.vmethod4004(var1, var2, var3);
      } else {
         this.vmethod4023(var3);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected abstract class117 vmethod4002();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected abstract class117 vmethod4025();

   @ObfuscatedName("ay")
   int vmethod2391() {
      return 255;
   }

   @ObfuscatedName("g")
   protected abstract int vmethod4007();
}
