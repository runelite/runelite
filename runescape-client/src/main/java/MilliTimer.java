import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("d")
   long[] field2155;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1663700145
   )
   int field2152;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1278153391
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -1938064053323512205L
   )
   long field2153;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -855840629
   )
   int field2156;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -241654783
   )
   int field2157;

   public MilliTimer() {
      this.field2155 = new long[10];
      this.field2152 = 256;
      this.sleepTime = 1;
      this.field2156 = 0;
      this.field2153 = PendingSpawn.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2155[var1] = this.field2153;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2072405029"
   )
   public void vmethod3369() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2155[var1] = 0L;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2142133773"
   )
   public int vmethod3370(int var1, int var2) {
      int var3 = this.field2152;
      int var4 = this.sleepTime;
      this.field2152 = 300;
      this.sleepTime = 1;
      this.field2153 = PendingSpawn.currentTimeMs();
      if(this.field2155[this.field2157] == 0L) {
         this.field2152 = var3;
         this.sleepTime = var4;
      } else if(this.field2153 > this.field2155[this.field2157]) {
         this.field2152 = (int)((long)(var1 * 2560) / (this.field2153 - this.field2155[this.field2157]));
      }

      if(this.field2152 < 25) {
         this.field2152 = 25;
      }

      if(this.field2152 > 256) {
         this.field2152 = 256;
         this.sleepTime = (int)((long)var1 - (this.field2153 - this.field2155[this.field2157]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2155[this.field2157] = this.field2153;
      this.field2157 = (this.field2157 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2155[var5]) {
               this.field2155[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      PacketBuffer.method3907((long)this.sleepTime);

      for(var5 = 0; this.field2156 < 256; this.field2156 += this.field2152) {
         ++var5;
      }

      this.field2156 &= 255;
      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;I)V",
      garbageValue = "1603173507"
   )
   public static void method3263(IndexDataBase var0) {
      class279.field3550 = var0;
   }
}
