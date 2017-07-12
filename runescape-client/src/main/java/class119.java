import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dq")
public abstract class class119 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1725;
   @ObfuscatedName("n")
   class122 field1726;
   @ObfuscatedName("b")
   class119 field1727;
   @ObfuscatedName("f")
   int field1728;

   protected class119() {
      this.field1725 = true;
   }

   @ObfuscatedName("j")
   protected abstract void vmethod3889(int[] var1, int var2, int var3);

   @ObfuscatedName("e")
   protected abstract void vmethod3885(int var1);

   @ObfuscatedName("eh")
   final void method2295(int[] var1, int var2, int var3) {
      if(this.field1725) {
         this.vmethod3889(var1, var2, var3);
      } else {
         this.vmethod3885(var3);
      }

   }

   @ObfuscatedName("v")
   protected abstract class119 vmethod3865();

   @ObfuscatedName("r")
   protected abstract class119 vmethod3864();

   @ObfuscatedName("al")
   int vmethod2291() {
      return 255;
   }

   @ObfuscatedName("y")
   protected abstract int vmethod3888();
}
