import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
public abstract class class119 extends Node {
   @ObfuscatedName("s")
   class122 field1723;
   @ObfuscatedName("b")
   int field1724;
   @ObfuscatedName("r")
   class119 field1725;
   @ObfuscatedName("v")
   volatile boolean field1726;

   @ObfuscatedName("c")
   protected abstract class119 vmethod3907();

   @ObfuscatedName("fm")
   final void method2301(int[] var1, int var2, int var3) {
      if(this.field1726) {
         this.vmethod3909(var1, var2, var3);
      } else {
         this.vmethod3910(var3);
      }

   }

   @ObfuscatedName("z")
   protected abstract int vmethod3908();

   protected class119() {
      this.field1726 = true;
   }

   @ObfuscatedName("e")
   protected abstract void vmethod3910(int var1);

   @ObfuscatedName("ag")
   int vmethod2306() {
      return 255;
   }

   @ObfuscatedName("h")
   protected abstract void vmethod3909(int[] var1, int var2, int var3);

   @ObfuscatedName("m")
   protected abstract class119 vmethod3906();
}
