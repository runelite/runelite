import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
public abstract class class119 extends Node {
   @ObfuscatedName("w")
   volatile boolean field1707;
   @ObfuscatedName("f")
   class122 field1706;
   @ObfuscatedName("o")
   class119 field1705;
   @ObfuscatedName("x")
   int field1704;

   protected class119() {
      this.field1707 = true;
   }

   @ObfuscatedName("w")
   protected abstract void vmethod3872(int[] var1, int var2, int var3);

   @ObfuscatedName("m")
   protected abstract void vmethod3869(int var1);

   @ObfuscatedName("fw")
   final void method2294(int[] var1, int var2, int var3) {
      if(this.field1707) {
         this.vmethod3872(var1, var2, var3);
      } else {
         this.vmethod3869(var3);
      }

   }

   @ObfuscatedName("l")
   protected abstract class119 vmethod3882();

   @ObfuscatedName("e")
   protected abstract class119 vmethod3883();

   @ObfuscatedName("al")
   int vmethod2292() {
      return 255;
   }

   @ObfuscatedName("s")
   protected abstract int vmethod3871();
}
