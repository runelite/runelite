import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class3 implements Comparator {
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 1647805835
   )
   static int field43;

   public int compare(Object var1, Object var2) {
      return this.method30((class2)var1, (class2)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "2022042167"
   )
   int method30(class2 var1, class2 var2) {
      return var1.field23.totalQuantity < var2.field23.totalQuantity?-1:(var2.field23.totalQuantity == var1.field23.totalQuantity?0:1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Lclass216;",
      garbageValue = "-51"
   )
   public static class216[] method31() {
      return new class216[]{class216.field3167, class216.field3165, class216.field3169};
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "1902105261"
   )
   static void method34(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2733;
      synchronized(class183.field2733) {
         for(class180 var5 = (class180)class183.field2733.method2330(); null != var5; var5 = (class180)class183.field2733.method2346()) {
            if(var5.hash == (long)var0 && var1 == var5.field2702 && var5.field2704 == 0) {
               var3 = var5.field2701;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3275(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2171(var0);
         var2.method3275(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1558638756"
   )
   static void method37(int var0, int var1, int var2) {
      if(Client.field532 != 0 && var1 != 0 && Client.field505 < 50) {
         Client.field565[Client.field505] = var0;
         Client.field502[Client.field505] = var1;
         Client.field537[Client.field505] = var2;
         Client.field420[Client.field505] = null;
         Client.field538[Client.field505] = 0;
         ++Client.field505;
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "65"
   )
   static String method38(int var0) {
      return Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static final void method39(int var0) {
      short var1 = 256;
      class41.field824 += 128 * var0;
      int var2;
      if(class41.field824 > class36.field771.length) {
         class41.field824 -= class36.field771.length;
         var2 = (int)(Math.random() * 12.0D);
         XItemContainer.method146(class41.field811[var2]);
      }

      var2 = 0;
      int var3 = 128 * var0;
      int var4 = 128 * (var1 - var0);

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class203.field3076[var3 + var2] - var0 * class36.field771[class41.field824 + var2 & class36.field771.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class203.field3076[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class203.field3076[var6 + var7] = 255;
            } else {
               class203.field3076[var7 + var6] = 0;
            }
         }
      }

      if(class41.field829 > 0) {
         class41.field829 -= 4 * var0;
      }

      if(class41.field823 > 0) {
         class41.field823 -= 4 * var0;
      }

      if(class41.field829 == 0 && class41.field823 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class41.field829 = 1024;
         }

         if(var5 == 1) {
            class41.field823 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class41.field820[var5] = class41.field820[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class41.field820[var5] = (int)(Math.sin((double)class41.field827 / 14.0D) * 16.0D + Math.sin((double)class41.field827 / 15.0D) * 14.0D + Math.sin((double)class41.field827 / 16.0D) * 12.0D);
         ++class41.field827;
      }

      class41.field838 += var0;
      var5 = ((Client.gameCycle & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class41.field838 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class203.field3076[(var8 << 7) + var7] = 192;
         }

         class41.field838 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class203.field3076[var5 + var8 + var9];
               }

               if(var9 - (1 + var5) >= 0) {
                  var7 -= class203.field3076[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  FrameMap.field1470[var9 + var8] = var7 / (1 + 2 * var5);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += FrameMap.field1470[var5 * 128 + var6 + var9];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= FrameMap.field1470[var9 + var6 - 128 * (1 + var5)];
               }

               if(var8 >= 0) {
                  class203.field3076[var6 + var9] = var7 / (1 + 2 * var5);
               }
            }
         }
      }

   }
}
