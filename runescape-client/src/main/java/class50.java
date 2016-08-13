import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class50 extends CacheableNode {
   @ObfuscatedName("g")
   public static NodeCache field1117 = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1737875485
   )
   public int field1119;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1857654723
   )
   public int field1120;
   @ObfuscatedName("eg")
   static SpritePixels[] field1121;
   @ObfuscatedName("m")
   static Widget field1122;
   @ObfuscatedName("ch")
   static class149 field1123;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 349225909
   )
   public int field1124;
   @ObfuscatedName("l")
   public static class170 field1125;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "409075097"
   )
   void method1060(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1119 = var1.method2635();
         this.field1120 = var1.method2633();
         this.field1124 = var1.method2633();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-9"
   )
   public static int method1067(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-49"
   )
   public static void method1068(boolean var0) {
      if(ItemComposition.isMembersWorld != var0) {
         ItemComposition.field1186.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ItemComposition.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "15"
   )
   public void method1075(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1060(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)Z",
      garbageValue = "-121"
   )
   static boolean method1076(class125 var0, int var1) {
      int var2 = var0.method2907(2);
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(var2 == 0) {
         if(var0.method2907(1) != 0) {
            method1076(var0, var1);
         }

         var3 = var0.method2907(6);
         var4 = var0.method2907(6);
         boolean var11 = var0.method2907(1) == 1;
         if(var11) {
            class34.field779[++class34.field785 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var12 = Client.cachedPlayers[var1] = new Player();
            var12.field53 = var1;
            if(class34.field791[var1] != null) {
               var12.method29(class34.field791[var1]);
            }

            var12.field882 = class34.field788[var1];
            var12.interacting = class34.field780[var1];
            var5 = class34.field790[var1];
            var6 = var5 >> 28;
            var7 = var5 >> 14 & 255;
            var8 = var5 & 255;
            var12.field888[0] = class34.field781[var1];
            var12.field52 = (byte)var6;
            var12.method19((var7 << 6) + var3 - class0.baseX, (var8 << 6) + var4 - class21.baseY);
            var12.field45 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2907(2);
         var4 = class34.field790[var1];
         class34.field790[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var9;
         int var10;
         if(var2 == 2) {
            var3 = var0.method2907(5);
            var4 = var3 >> 3;
            var9 = var3 & 7;
            var10 = class34.field790[var1];
            var5 = (var10 >> 28) + var4 & 3;
            var6 = var10 >> 14 & 255;
            var7 = var10 & 255;
            if(var9 == 0) {
               --var6;
               --var7;
            }

            if(var9 == 1) {
               --var7;
            }

            if(var9 == 2) {
               ++var6;
               --var7;
            }

            if(var9 == 3) {
               --var6;
            }

            if(var9 == 4) {
               ++var6;
            }

            if(var9 == 5) {
               --var6;
               ++var7;
            }

            if(var9 == 6) {
               ++var7;
            }

            if(var9 == 7) {
               ++var6;
               ++var7;
            }

            class34.field790[var1] = (var5 << 28) + (var6 << 14) + var7;
            return false;
         } else {
            var3 = var0.method2907(18);
            var4 = var3 >> 16;
            var9 = var3 >> 8 & 255;
            var10 = var3 & 255;
            var5 = class34.field790[var1];
            var6 = (var5 >> 28) + var4 & 3;
            var7 = var9 + (var5 >> 14) & 255;
            var8 = var5 + var10 & 255;
            class34.field790[var1] = var8 + (var7 << 14) + (var6 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-849204031"
   )
   static void method1077(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class151.method3265(var1, var2);
      if(var5 != null) {
         if(var5.field2907 != null) {
            class0 var6 = new class0();
            var6.field2 = var5;
            var6.field14 = var0;
            var6.field0 = var4;
            var6.field8 = var5.field2907;
            class16.method203(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = class126.method2917(var5);
         }

         if(var10) {
            int var7 = Player.method39(var5);
            int var8 = var0 - 1;
            boolean var9 = (var7 >> var8 + 1 & 1) != 0;
            if(var9) {
               if(var0 == 1) {
                  Client.field337.method2903(181);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 2) {
                  Client.field337.method2903(136);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 3) {
                  Client.field337.method2903(114);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 4) {
                  Client.field337.method2903(149);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 5) {
                  Client.field337.method2903(96);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 6) {
                  Client.field337.method2903(157);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 7) {
                  Client.field337.method2903(110);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 8) {
                  Client.field337.method2903(109);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 9) {
                  Client.field337.method2903(143);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }

               if(var0 == 10) {
                  Client.field337.method2903(212);
                  Client.field337.method2728(var1);
                  Client.field337.method2619(var2);
                  Client.field337.method2619(var3);
               }
            }
         }
      }

   }
}
