import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class43 {
   @ObfuscatedName("oi")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static SpritePixels field576;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -115459627
   )
   int field574;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1704135035
   )
   int field570;
   @ObfuscatedName("i")
   int[][] field571;
   @ObfuscatedName("g")
   int[][] field575;
   @ObfuscatedName("u")
   int[][] field573;
   @ObfuscatedName("m")
   int[][] field572;

   class43(int var1, int var2) {
      this.field574 = var1;
      this.field570 = var2;
      this.field571 = new int[var1][var2];
      this.field573 = new int[var1][var2];
      this.field575 = new int[var1][var2];
      this.field572 = new int[var1][var2];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "6609"
   )
   int method587(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field574 && var2 < this.field570) {
         if(this.field575[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field571[var1][var2] / this.field572[var1][var2];
            int var4 = this.field573[var1][var2] / this.field572[var1][var2];
            int var5 = this.field575[var1][var2] / this.field572[var1][var2];
            return class271.method4793((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILiy;I)V",
      garbageValue = "1061329979"
   )
   void method592(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field574 && var2 - var3 <= this.field570) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field574, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field570, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field571[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field573[var9][var10] += var4.saturation;
                     this.field575[var9][var10] += var4.lightness;
                     ++this.field572[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1356251449"
   )
   public static int method593(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[BLfz;I)V",
      garbageValue = "1327191770"
   )
   static void method594(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.field3171 = 0;
      var3.hash = (long)var0;
      var3.field3170 = var1;
      var3.index = var2;
      Deque var4 = class236.field3207;
      synchronized(class236.field3207) {
         class236.field3207.addFront(var3);
      }

      Object var9 = class236.field3203;
      synchronized(class236.field3203) {
         if(class236.field3205 == 0) {
            class19.field316 = new Thread(new class236());
            class19.field316.setDaemon(true);
            class19.field316.start();
            class19.field316.setPriority(5);
         }

         class236.field3205 = 600;
      }
   }
}
