import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class34 {
   @ObfuscatedName("r")
   static Buffer field774 = new Buffer(new byte[5000]);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1410603511
   )
   static int field775 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1617775397
   )
   static int field776 = 0;
   @ObfuscatedName("g")
   static byte[] field777 = new byte[2048];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 783372137
   )
   static int field779 = 0;
   @ObfuscatedName("y")
   static int[] field780 = new int[2048];
   @ObfuscatedName("m")
   static int[] field782 = new int[2048];
   @ObfuscatedName("j")
   static int[] field783 = new int[2048];
   @ObfuscatedName("n")
   static Buffer[] field784 = new Buffer[2048];
   @ObfuscatedName("e")
   static byte[] field785 = new byte[2048];
   @ObfuscatedName("d")
   static int[] field786 = new int[2048];
   @ObfuscatedName("v")
   static int[] field787 = new int[2048];
   @ObfuscatedName("s")
   static int[] field788 = new int[2048];
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 415859429
   )
   static int field789;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1705677026"
   )
   static final int method727(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) + (var2 * (var1 & 16711935) + (var0 & 16711935) * var3 & -16711936) >> 8;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-462804510"
   )
   static final void method736(int var0) {
      short var1 = 256;
      class33.field757 += var0 * 128;
      int var2;
      if(class33.field757 > SecondaryBufferProvider.field1434.length) {
         class33.field757 -= SecondaryBufferProvider.field1434.length;
         var2 = (int)(Math.random() * 12.0D);
         Actor.method800(class33.field744[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = Frames.field1832[var3 + var2] - var0 * SecondaryBufferProvider.field1434[class33.field757 + var2 & SecondaryBufferProvider.field1434.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         Frames.field1832[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               Frames.field1832[var7 + var6] = 255;
            } else {
               Frames.field1832[var7 + var6] = 0;
            }
         }
      }

      if(class33.field750 > 0) {
         class33.field750 -= var0 * 4;
      }

      if(class33.field751 > 0) {
         class33.field751 -= var0 * 4;
      }

      if(class33.field750 == 0 && class33.field751 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class33.field750 = 1024;
         }

         if(var5 == 1) {
            class33.field751 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class33.field768[var5] = class33.field768[var5 + var0];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class33.field768[var5] = (int)(Math.sin((double)class33.field759 / 14.0D) * 16.0D + Math.sin((double)class33.field759 / 15.0D) * 14.0D + Math.sin((double)class33.field759 / 16.0D) * 12.0D);
         ++class33.field759;
      }

      class33.field753 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class33.field753 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            Frames.field1832[(var8 << 7) + var7] = 192;
         }

         class33.field753 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = 128 * var6;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += Frames.field1832[var5 + var9 + var8];
               }

               if(var9 - (1 + var5) >= 0) {
                  var7 -= Frames.field1832[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  GameObject.field1727[var8 + var9] = var7 / (1 + 2 * var5);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = 128 * var8;
               if(var8 + var5 < var1) {
                  var7 += GameObject.field1727[var9 + var6 + 128 * var5];
               }

               if(var8 - (1 + var5) >= 0) {
                  var7 -= GameObject.field1727[var6 + var9 - (1 + var5) * 128];
               }

               if(var8 >= 0) {
                  Frames.field1832[var9 + var6] = var7 / (1 + 2 * var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2091645472"
   )
   public static synchronized long method738() {
      long var0 = System.currentTimeMillis();
      if(var0 < class221.field3220) {
         class118.field2024 += class221.field3220 - var0;
      }

      class221.field3220 = var0;
      return var0 + class118.field2024;
   }
}
