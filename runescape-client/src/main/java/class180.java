import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class180 {
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 2079525945
   )
   static int field2946;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1478962176"
   )
   static final void method3519(int var0) {
      short var1 = 256;
      class33.field739 += 128 * var0;
      int var2;
      if(class33.field739 > ChatLineBuffer.field685.length) {
         class33.field739 -= ChatLineBuffer.field685.length;
         var2 = (int)(Math.random() * 12.0D);
         class50.method1017(class33.field723[var2]);
      }

      var2 = 0;
      int var3 = 128 * var0;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class33.field736[var2 + var3] - ChatLineBuffer.field685[class33.field739 + var2 & ChatLineBuffer.field685.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class33.field736[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class33.field736[var6 + var7] = 255;
            } else {
               class33.field736[var7 + var6] = 0;
            }
         }
      }

      if(class33.field734 > 0) {
         class33.field734 -= var0 * 4;
      }

      if(class33.field735 > 0) {
         class33.field735 -= var0 * 4;
      }

      if(class33.field734 == 0 && class33.field735 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class33.field734 = 1024;
         }

         if(var5 == 1) {
            class33.field735 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class33.field737[var5] = class33.field737[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class33.field737[var5] = (int)(Math.sin((double)class33.field738 / 14.0D) * 16.0D + Math.sin((double)class33.field738 / 15.0D) * 14.0D + Math.sin((double)class33.field738 / 16.0D) * 12.0D);
         ++class33.field738;
      }

      class33.field732 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class33.field732 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class33.field736[(var8 << 7) + var7] = 192;
         }

         class33.field732 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = 128 * var6;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class33.field736[var5 + var9 + var8];
               }

               if(var9 - (1 + var5) >= 0) {
                  var7 -= class33.field736[var8 + var9 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class220.field3209[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = 128 * var8;
               if(var5 + var8 < var1) {
                  var7 += class220.field3209[var6 + var9 + 128 * var5];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class220.field3209[var9 + var6 - 128 * (1 + var5)];
               }

               if(var8 >= 0) {
                  class33.field736[var9 + var6] = var7 / (2 * var5 + 1);
               }
            }
         }
      }

   }
}
