import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("c")
   long[] field2163;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1212311813
   )
   int field2164;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 129880059
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 6835645320849853117L
   )
   long field2165;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2014396193
   )
   int field2166;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 187947181
   )
   int field2167;

   MilliTimer() {
      this.field2163 = new long[10];
      this.field2164 = 256;
      this.sleepTime = 1;
      this.field2166 = 0;
      this.field2165 = ScriptVarType.method28();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2163[var1] = this.field2165;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1752267901"
   )
   public void vmethod3302() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2163[var1] = 0L;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "112"
   )
   public int vmethod3312(int var1, int var2) {
      int var3 = this.field2164;
      int var4 = this.sleepTime;
      this.field2164 = 300;
      this.sleepTime = 1;
      this.field2165 = ScriptVarType.method28();
      if(0L == this.field2163[this.field2167]) {
         this.field2164 = var3;
         this.sleepTime = var4;
      } else if(this.field2165 > this.field2163[this.field2167]) {
         this.field2164 = (int)((long)(var1 * 2560) / (this.field2165 - this.field2163[this.field2167]));
      }

      if(this.field2164 < 25) {
         this.field2164 = 25;
      }

      if(this.field2164 > 256) {
         this.field2164 = 256;
         this.sleepTime = (int)((long)var1 - (this.field2165 - this.field2163[this.field2167]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2163[this.field2167] = this.field2165;
      this.field2167 = (this.field2167 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2163[var5] != 0L) {
               this.field2163[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class163.method3223((long)this.sleepTime);

      for(var5 = 0; this.field2166 < 256; this.field2166 += this.field2164) {
         ++var5;
      }

      this.field2166 &= 255;
      return var5;
   }
}
