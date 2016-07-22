import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("WidgetNode")
public class class3 extends class211 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1949849475
   )
   int field64;
   @ObfuscatedName("e")
   boolean field65 = false;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1615508449
   )
   @Export("id")
   int field66;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIIIIII)V",
      garbageValue = "661828623"
   )
   static final void method35(class176 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field354) {
         client.field505 = 32;
      } else {
         client.field505 = 0;
      }

      client.field354 = false;
      int var7;
      if(class143.field2216 == 1 || !class17.field235 && class143.field2216 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2817 -= 4;
            class92.method2164(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.field2817 += 4;
            class92.method2164(var0);
         } else if(var5 >= var1 - client.field505 && var5 < client.field505 + 16 + var1 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2817 = (var4 - var3) * var8 / var9;
            class92.method2164(var0);
            client.field354 = true;
         }
      }

      if(client.field468 != 0) {
         var7 = var0.field2926;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var3 + var2) {
            var0.field2817 += client.field468 * 45;
            class92.method2164(var0);
         }
      }

   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "23"
   )
   static final void method36(int var0) {
      class4.method44();
      class106.method2365();
      int var1 = class4.method41(var0).field1234;
      if(var1 != 0) {
         int var2 = class179.field2949[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class94.method2167(0.9D);
               ((class98)class94.field1657).method2250(0.9D);
            }

            if(var2 == 2) {
               class94.method2167(0.8D);
               ((class98)class94.field1657).method2250(0.8D);
            }

            if(var2 == 3) {
               class94.method2167(0.7D);
               ((class98)class94.field1657).method2250(0.7D);
            }

            if(var2 == 4) {
               class94.method2167(0.6D);
               ((class98)class94.field1657).method2250(0.6D);
            }

            class55.field1180.method3814();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != client.field507) {
               if(client.field507 == 0 && client.field443 != -1) {
                  class153.method3190(class38.field814, client.field443, 0, var3, false);
                  client.field532 = false;
               } else if(var3 == 0) {
                  class46.method969();
                  client.field532 = false;
               } else {
                  class80.method1774(var3);
               }

               client.field507 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               client.field510 = 127;
            }

            if(var2 == 1) {
               client.field510 = 96;
            }

            if(var2 == 2) {
               client.field510 = 64;
            }

            if(var2 == 3) {
               client.field510 = 32;
            }

            if(var2 == 4) {
               client.field510 = 0;
            }
         }

         if(var1 == 5) {
            client.field528 = var2;
         }

         if(var1 == 6) {
            client.field429 = var2;
         }

         if(var1 == 9) {
            client.field433 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field511 = 127;
            }

            if(var2 == 1) {
               client.field511 = 96;
            }

            if(var2 == 2) {
               client.field511 = 64;
            }

            if(var2 == 3) {
               client.field511 = 32;
            }

            if(var2 == 4) {
               client.field511 = 0;
            }
         }

         if(var1 == 17) {
            client.field463 = var2 & '\uffff';
         }

         if(var1 == 18) {
            client.field298 = (class21)class5.method77(class8.method117(), var2);
            if(client.field298 == null) {
               client.field298 = class21.field570;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               client.field344 = -1;
            } else {
               client.field344 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            client.field355 = (class21)class5.method77(class8.method117(), var2);
            if(client.field355 == null) {
               client.field355 = class21.field570;
            }
         }

      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass39;IB)V",
      garbageValue = "33"
   )
   static final void method37(class39 var0, int var1) {
      class41.method820(var0.field864, var0.field831, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)Lclass81;",
      garbageValue = "-64"
   )
   @Export("createSprite")
   public static final class81 method38(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var4 << 40);
      class81 var8;
      if(!var5) {
         var8 = (class81)class55.field1180.method3817(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class55 var9 = class4.method42(var0);
      if(var1 > 1 && null != var9.field1211) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1208[var11] && var9.field1208[var11] != 0) {
               var10 = var9.field1211[var11];
            }
         }

         if(var10 != -1) {
            var9 = class4.method42(var10);
         }
      }

      class108 var22 = var9.method1151(1);
      if(var22 == null) {
         return null;
      } else {
         class81 var21 = null;
         if(var9.field1214 != -1) {
            var21 = method38(var9.field1213, 10, 1, 0, 0, true);
            if(var21 == null) {
               return null;
            }
         } else if(var9.field1179 != -1) {
            var21 = method38(var9.field1222, var1, var2, var3, 0, false);
            if(var21 == null) {
               return null;
            }
         } else if(var9.field1225 != -1) {
            var21 = method38(var9.field1224, var1, 0, 0, 0, false);
            if(var21 == null) {
               return null;
            }
         }

         int[] var12 = class82.field1492;
         int var13 = class82.field1488;
         int var14 = class82.field1489;
         int[] var15 = new int[4];
         class82.method1877(var15);
         var8 = new class81(36, 32);
         class82.method1873(var8.field1486, 36, 32);
         class82.method1923();
         class94.method2166();
         class94.method2169(16, 16);
         class94.field1647 = false;
         if(var9.field1225 != -1) {
            var21.method1800(0, 0);
         }

         int var16 = var9.field1188;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class94.field1660[var9.field1216] >> 16;
         int var18 = var16 * class94.field1661[var9.field1216] >> 16;
         var22.method2385();
         var22.method2420(0, var9.field1190, var9.field1189, var9.field1216, var9.field1192, var9.field1193 + var22.field1536 / 2 + var17, var9.field1193 + var18);
         if(var9.field1179 != -1) {
            var21.method1800(0, 0);
         }

         if(var2 >= 1) {
            var8.method1796(1);
         }

         if(var2 >= 2) {
            var8.method1796(16777215);
         }

         if(var3 != 0) {
            var8.method1821(var3);
         }

         class82.method1873(var8.field1486, 36, 32);
         if(var9.field1214 != -1) {
            var21.method1800(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.field1194 == 1) {
            class227 var19 = class80.field1473;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4099(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            class55.field1180.method3823(var8, var6);
         }

         class82.method1873(var12, var13, var14);
         class82.method1884(var15);
         class94.method2166();
         class94.field1647 = true;
         return var8;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1407578149"
   )
   static void method39(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class27 var8 = class219.field3210[var6];
         class219.field3210[var6] = class219.field3210[var1];
         class219.field3210[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            class27 var11 = class219.field3210[var9];
            int var12 = class147.method3089(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class147.method3089(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               class27 var14 = class219.field3210[var9];
               class219.field3210[var9] = class219.field3210[var7];
               class219.field3210[var7++] = var14;
            }
         }

         class219.field3210[var1] = class219.field3210[var7];
         class219.field3210[var7] = var8;
         method39(var0, var7 - 1, var2, var3, var4, var5);
         method39(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2119319163"
   )
   static void method40() {
      class15.field204 = new class199(32);
   }
}
