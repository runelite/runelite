import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class144 extends class136 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2062534119
   )
   int field2217 = 256;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 957854003
   )
   int field2218 = 1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4910111762657690753L
   )
   long field2219 = class34.method738();
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -721487931
   )
   int field2220 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1512037911
   )
   int field2221;
   @ObfuscatedName("i")
   long[] field2222 = new long[10];

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2222[var1] = this.field2219;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   void vmethod3147() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2222[var1] = 0L;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-9037346"
   )
   int vmethod3148(int var1, int var2) {
      int var3 = this.field2217;
      int var4 = this.field2218;
      this.field2217 = 300;
      this.field2218 = 1;
      this.field2219 = class34.method738();
      if(0L == this.field2222[this.field2221]) {
         this.field2217 = var3;
         this.field2218 = var4;
      } else if(this.field2219 > this.field2222[this.field2221]) {
         this.field2217 = (int)((long)(var1 * 2560) / (this.field2219 - this.field2222[this.field2221]));
      }

      if(this.field2217 < 25) {
         this.field2217 = 25;
      }

      if(this.field2217 > 256) {
         this.field2217 = 256;
         this.field2218 = (int)((long)var1 - (this.field2219 - this.field2222[this.field2221]) / 10L);
      }

      if(this.field2218 > var1) {
         this.field2218 = var1;
      }

      this.field2222[this.field2221] = this.field2219;
      this.field2221 = (1 + this.field2221) % 10;
      int var5;
      if(this.field2218 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2222[var5] != 0L) {
               this.field2222[var5] += (long)this.field2218;
            }
         }
      }

      if(this.field2218 < var2) {
         this.field2218 = var2;
      }

      PlayerComposition.method3511((long)this.field2218);

      for(var5 = 0; this.field2220 < 256; this.field2220 += this.field2217) {
         ++var5;
      }

      this.field2220 &= 255;
      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "297493809"
   )
   public static void method3019(int var0, int var1) {
      class50 var2 = class192.method3770(var0);
      int var3 = var2.field1095;
      int var4 = var2.field1094;
      int var5 = var2.field1097;
      int var6 = class179.field2955[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class179.widgetSettings[var3] = class179.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-110"
   )
   public static int method3020(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1588961439"
   )
   static final void method3021(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field425; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field494[var4] = true;
         }
      }

   }
}
