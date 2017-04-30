import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public abstract class class68 extends Node {
   @ObfuscatedName("a")
   class71 field1122;
   @ObfuscatedName("i")
   int field1123;
   @ObfuscatedName("j")
   class68 field1124;
   @ObfuscatedName("w")
   volatile boolean field1125;

   @ObfuscatedName("ei")
   final void method1360(int[] var1, int var2, int var3) {
      if(this.field1125) {
         this.vmethod3093(var1, var2, var3);
      } else {
         this.vmethod3094(var3);
      }

   }

   @ObfuscatedName("al")
   int vmethod1361() {
      return 255;
   }

   @ObfuscatedName("u")
   protected abstract class68 vmethod3091();

   @ObfuscatedName("w")
   protected abstract int vmethod3097();

   @ObfuscatedName("r")
   protected abstract void vmethod3093(int[] var1, int var2, int var3);

   @ObfuscatedName("k")
   protected abstract void vmethod3094(int var1);

   protected class68() {
      this.field1125 = true;
   }

   @ObfuscatedName("p")
   protected abstract class68 vmethod3102();
}
