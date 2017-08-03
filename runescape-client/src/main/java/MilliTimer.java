import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 928034911
   )
   int field2181;
   @ObfuscatedName("d")
   long[] field2188;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1510286127
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1413644211
   )
   int field2180;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 2842453288054123903L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 888392585
   )
   int field2185;

   MilliTimer() {
      this.field2188 = new long[10];
      this.field2181 = 256;
      this.sleepTime = 1;
      this.field2180 = 0;
      this.milliTime = BuildType.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2188[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1055561234"
   )
   public int vmethod3006(int var1, int var2) {
      int var3 = this.field2181;
      int var4 = this.sleepTime;
      this.field2181 = 300;
      this.sleepTime = 1;
      this.milliTime = BuildType.currentTimeMs();
      if(this.field2188[this.field2185] == 0L) {
         this.field2181 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2188[this.field2185]) {
         this.field2181 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2188[this.field2185]));
      }

      if(this.field2181 < 25) {
         this.field2181 = 25;
      }

      if(this.field2181 > 256) {
         this.field2181 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2188[this.field2185]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2188[this.field2185] = this.milliTime;
      this.field2185 = (this.field2185 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2188[var5]) {
               this.field2188[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      GroundObject.method2492((long)this.sleepTime);

      for(var5 = 0; this.field2180 < 256; this.field2180 += this.field2181) {
         ++var5;
      }

      this.field2180 &= 255;
      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   public void vmethod3003() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2188[var1] = 0L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1024244094"
   )
   public static int method2938(int var0) {
      return var0 >> 11 & 63;
   }
}
