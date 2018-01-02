import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("bs")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("a")
   long[] field2098;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 536322751
   )
   int field2097;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -291367241
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 9158307521041611221L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 585784011
   )
   int field2100;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -404996279
   )
   int field2101;

   public MilliTimer() {
      this.field2098 = new long[10];
      this.field2097 = 256;
      this.sleepTime = 1;
      this.field2100 = 0;
      this.milliTime = Preferences.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2098[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-515402785"
   )
   public void vmethod3074() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2098[var1] = 0L;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "501278963"
   )
   public int vmethod3075(int var1, int var2) {
      int var3 = this.field2097;
      int var4 = this.sleepTime;
      this.field2097 = 300;
      this.sleepTime = 1;
      this.milliTime = Preferences.currentTimeMs();
      if(0L == this.field2098[this.field2101]) {
         this.field2097 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2098[this.field2101]) {
         this.field2097 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2098[this.field2101]));
      }

      if(this.field2097 < 25) {
         this.field2097 = 25;
      }

      if(this.field2097 > 256) {
         this.field2097 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2098[this.field2101]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2098[this.field2101] = this.milliTime;
      this.field2101 = (this.field2101 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2098[var5]) {
               this.field2098[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      World.method1500((long)this.sleepTime);

      for(var5 = 0; this.field2100 < 256; this.field2100 += this.field2097) {
         ++var5;
      }

      this.field2100 &= 255;
      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Lkg;",
      garbageValue = "-26"
   )
   public static IndexedSprite method2946() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class299.field3864;
      var0.originalHeight = class299.field3868;
      var0.offsetX = class299.field3867[0];
      var0.offsetY = class299.offsetsY[0];
      var0.originalWidth = Item.field1387[0];
      var0.height = class276.field3727[0];
      var0.palette = FaceNormal.field2025;
      var0.pixels = Bounds.spritePixels[0];
      ContextMenuRow.resetCachedStaticSpriteData();
      return var0;
   }
}
