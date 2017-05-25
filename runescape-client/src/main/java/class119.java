import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
public abstract class class119 extends Node {
   @ObfuscatedName("e")
   volatile boolean field1703;
   @ObfuscatedName("m")
   int field1704;
   @ObfuscatedName("d")
   class122 field1705;
   @ObfuscatedName("j")
   class119 field1706;

   @ObfuscatedName("ao")
   int vmethod2322() {
      return 255;
   }

   @ObfuscatedName("v")
   protected abstract class119 vmethod3944();

   @ObfuscatedName("t")
   protected abstract class119 vmethod3945();

   @ObfuscatedName("l")
   protected abstract void vmethod3949(int[] var1, int var2, int var3);

   @ObfuscatedName("p")
   protected abstract int vmethod3946();

   @ObfuscatedName("ed")
   final void method2330(int[] var1, int var2, int var3) {
      if(this.field1703) {
         this.vmethod3949(var1, var2, var3);
      } else {
         this.vmethod3969(var3);
      }

   }

   protected class119() {
      this.field1703 = true;
   }

   @ObfuscatedName("k")
   protected abstract void vmethod3969(int var1);
}
