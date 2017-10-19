import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 313549463
   )
   int field2204;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -144723857
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("w")
   long[] field2209;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 670672845
   )
   int field2207;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 5532409806969849003L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1626940207
   )
   int field2206;

   MilliTimer() {
      this.field2209 = new long[10];
      this.field2204 = 256;
      this.sleepTime = 1;
      this.field2207 = 0;
      this.milliTime = class174.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2209[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1716430231"
   )
   public int vmethod3025(int var1, int var2) {
      int var3 = this.field2204;
      int var4 = this.sleepTime;
      this.field2204 = 300;
      this.sleepTime = 1;
      this.milliTime = class174.currentTimeMs();
      if(0L == this.field2209[this.field2206]) {
         this.field2204 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2209[this.field2206]) {
         this.field2204 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2209[this.field2206]));
      }

      if(this.field2204 < 25) {
         this.field2204 = 25;
      }

      if(this.field2204 > 256) {
         this.field2204 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2209[this.field2206]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2209[this.field2206] = this.milliTime;
      this.field2206 = (this.field2206 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2209[var5]) {
               this.field2209[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class94.method1823((long)this.sleepTime);

      for(var5 = 0; this.field2207 < 256; this.field2207 += this.field2204) {
         ++var5;
      }

      this.field2207 &= 255;
      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-120"
   )
   public void vmethod3029() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2209[var1] = 0L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-1255969959"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "50987591"
   )
   public static int method2964(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lky;",
      garbageValue = "-801923417"
   )
   static SpritePixels[] method2965() {
      SpritePixels[] var0 = new SpritePixels[class287.field3805];

      for(int var1 = 0; var1 < class287.field3805; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class287.field3809;
         var2.maxHeight = class287.field3807;
         var2.offsetX = class287.field3808[var1];
         var2.offsetY = class21.offsetsY[var1];
         var2.width = class287.field3806[var1];
         var2.height = class56.field700[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = class227.spritePixels[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class114.field1675[var4[var5] & 255];
         }
      }

      class249.method4493();
      return var0;
   }
}
