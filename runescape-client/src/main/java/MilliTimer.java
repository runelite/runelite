import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1338212991
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 425198859
   )
   static int field2223;
   @ObfuscatedName("i")
   long[] field2224;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -328335958128952751L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1293963245
   )
   int field2226;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1935282031
   )
   int field2227;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -391261729
   )
   int field2228;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public void vmethod2965() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2224[var1] = 0L;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-70"
   )
   public int vmethod2964(int var1, int var2) {
      int var3 = this.field2226;
      int var4 = this.sleepTime;
      this.field2226 = 300;
      this.sleepTime = 1;
      this.milliTime = DState.currentTimeMs();
      if(0L == this.field2224[this.field2227]) {
         this.field2226 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2224[this.field2227]) {
         this.field2226 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2224[this.field2227]));
      }

      if(this.field2226 < 25) {
         this.field2226 = 25;
      }

      if(this.field2226 > 256) {
         this.field2226 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2224[this.field2227]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2224[this.field2227] = this.milliTime;
      this.field2227 = (this.field2227 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2224[var5]) {
               this.field2224[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      XItemContainer.method1113((long)this.sleepTime);

      for(var5 = 0; this.field2228 < 256; this.field2228 += this.field2226) {
         ++var5;
      }

      this.field2228 &= 255;
      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;S)V",
      garbageValue = "6282"
   )
   public static void method2912(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   public MilliTimer() {
      this.field2224 = new long[10];
      this.field2226 = 256;
      this.sleepTime = 1;
      this.field2228 = 0;
      this.milliTime = DState.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2224[var1] = this.milliTime;
      }

   }
}
