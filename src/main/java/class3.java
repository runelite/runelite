import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WidgetNode")
public class class3 extends class207 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 163613459
   )
   @Export("id")
   int field56;
   @ObfuscatedName("z")
   static String field58;
   @ObfuscatedName("f")
   boolean field59 = false;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2132755355
   )
   int field62;

   @ObfuscatedName("a")
   public static void method45(class166 var0, class166 var1) {
      class44.field1031 = var0;
      class44.field1026 = var1;
      class44.field1027 = class44.field1031.method3273(3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-11615552"
   )
   static final void method46(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field78[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field86[0][var5][var4] = class5.field86[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.field86[0][var5][var4] = class5.field86[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field86[0][var5][var4] = class5.field86[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class5.field86[0][var5][var4] = class5.field86[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1049102541"
   )
   static final void method47(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field297 && class48.field1078 != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(0 == var1) {
            var7 = class77.field1396.method1948(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class77.field1396.method1949(var0, var2, var3);
         }

         if(2 == var1) {
            var7 = class77.field1396.method1950(var0, var2, var3);
         }

         if(3 == var1) {
            var7 = class77.field1396.method1951(var0, var2, var3);
         }

         int var11;
         if(0 != var7) {
            var11 = class77.field1396.method2087(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            class40 var12;
            if(0 == var1) {
               class77.field1396.method1939(var0, var2, var3);
               var12 = class156.method3176(var13);
               if(0 != var12.field925) {
                  client.field359[var0].method2397(var2, var3, var14, var15, var12.field941);
               }
            }

            if(var1 == 1) {
               class77.field1396.method1940(var0, var2, var3);
            }

            if(var1 == 2) {
               class77.field1396.method1941(var0, var2, var3);
               var12 = class156.method3176(var13);
               if(var12.field938 + var2 > 103 || var3 + var12.field938 > 103 || var12.field939 + var2 > 103 || var3 + var12.field939 > 103) {
                  return;
               }

               if(var12.field925 != 0) {
                  client.field359[var0].method2410(var2, var3, var12.field938, var12.field939, var15, var12.field941);
               }
            }

            if(3 == var1) {
               class77.field1396.method1942(var0, var2, var3);
               var12 = class156.method3176(var13);
               if(var12.field925 == 1) {
                  client.field359[var0].method2405(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field90[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class15.method196(var0, var11, var2, var3, var4, var5, var6, class77.field1396, client.field359[var0]);
         }
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass172;IIZB)V",
      garbageValue = "101"
   )
   static void method48(class172 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2752;
      int var5 = var0.field2759;
      if(var0.field2750 == 0) {
         var0.field2752 = var0.field2783;
      } else if(var0.field2750 == 1) {
         var0.field2752 = var1 - var0.field2783;
      } else if(var0.field2750 == 2) {
         var0.field2752 = var1 * var0.field2783 >> 14;
      }

      if(var0.field2751 == 0) {
         var0.field2759 = var0.field2755;
      } else if(1 == var0.field2751) {
         var0.field2759 = var2 - var0.field2755;
      } else if(var0.field2751 == 2) {
         var0.field2759 = var0.field2755 * var2 >> 14;
      }

      if(4 == var0.field2750) {
         var0.field2752 = var0.field2760 * var0.field2759 / var0.field2761;
      }

      if(4 == var0.field2751) {
         var0.field2759 = var0.field2761 * var0.field2752 / var0.field2760;
      }

      if(client.field463 && var0.field2764 == 0) {
         if(var0.field2759 < 5 && var0.field2752 < 5) {
            var0.field2759 = 5;
            var0.field2752 = 5;
         } else {
            if(var0.field2759 <= 0) {
               var0.field2759 = 5;
            }

            if(var0.field2752 <= 0) {
               var0.field2752 = 5;
            }
         }
      }

      if(1337 == var0.field2747) {
         client.field465 = var0;
      }

      if(var3 && var0.field2799 != null && (var0.field2752 != var4 || var5 != var0.field2759)) {
         class0 var6 = new class0();
         var6.field6 = var0;
         var6.field8 = var0.field2799;
         client.field292.method3855(var6);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1932334802"
   )
   static void method49() {
      for(class23 var0 = (class23)class23.field606.method3860(); null != var0; var0 = (class23)class23.field606.method3861()) {
         if(var0.field614 != null) {
            class40.field973.method1153(var0.field614);
            var0.field614 = null;
         }

         if(var0.field608 != null) {
            class40.field973.method1153(var0.field608);
            var0.field608 = null;
         }
      }

      class23.field606.method3854();
   }

   @ObfuscatedName("e")
   static boolean method50(class121 var0, int var1) {
      int var2 = var0.method2750(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2750(1) != 0) {
            method50(var0, var1);
         }

         var3 = var0.method2750(6);
         var4 = var0.method2750(6);
         boolean var11 = var0.method2750(1) == 1;
         if(var11) {
            class32.field766[++class32.field765 - 1] = var1;
         }

         if(null != client.field415[var1]) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field415[var1] = new class2();
            var12.field48 = var1;
            if(null != class32.field757[var1]) {
               var12.method19(class32.field757[var1]);
            }

            var12.field862 = class32.field763[var1];
            var12.field837 = class32.field758[var1];
            var7 = class32.field773[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field831[0] = class32.field756[var1];
            var12.field47 = (byte)var8;
            var12.method39((var9 << 6) + var3 - class147.field2214, (var10 << 6) + var4 - class17.field257);
            var12.field49 = false;
            return true;
         }
      } else if(1 == var2) {
         var3 = var0.method2750(2);
         var4 = class32.field773[var1];
         class32.field773[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2750(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field773[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(0 == var5) {
               --var8;
               --var9;
            }

            if(1 == var5) {
               --var9;
            }

            if(2 == var5) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(4 == var5) {
               ++var8;
            }

            if(5 == var5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class32.field773[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method2750(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field773[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var6 & 255;
            class32.field773[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method51(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class124.field2034) {
            try {
               class117 var1 = new class117();
               var1.vmethod2803(var0);
               return var1;
            } catch (Throwable var2) {
               class124.field2034 = true;
            }
         }

         return var0;
      }
   }
}
