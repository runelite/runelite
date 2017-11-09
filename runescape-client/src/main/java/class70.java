import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class70 implements Runnable {
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1367854117
   )
   static int field809;
   @ObfuscatedName("ns")
   static byte field805;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1408976181
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("m")
   boolean field803;
   @ObfuscatedName("p")
   Object field804;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2050628581
   )
   int field811;
   @ObfuscatedName("j")
   int[] field806;
   @ObfuscatedName("v")
   int[] field807;

   class70() {
      this.field803 = true;
      this.field804 = new Object();
      this.field811 = 0;
      this.field806 = new int[500];
      this.field807 = new int[500];
   }

   public void run() {
      for(; this.field803; class61.method1130(50L)) {
         Object var1 = this.field804;
         synchronized(this.field804) {
            if(this.field811 < 500) {
               this.field806[this.field811] = MouseInput.field704;
               this.field807[this.field811] = MouseInput.field708;
               ++this.field811;
            }
         }
      }

   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-207021908"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + var6 * class61.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] + class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
