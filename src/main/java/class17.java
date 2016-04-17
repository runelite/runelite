import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2082641021
   )
   @Export("world")
   int field256;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1086402293
   )
   int field257;
   @ObfuscatedName("y")
   boolean field258;
   @ObfuscatedName("at")
   static class146 field260;
   @ObfuscatedName("a")
   @Export("name")
   String field261;
   @ObfuscatedName("w")
   @Export("previousName")
   String field262;
   @ObfuscatedName("k")
   boolean field263;
   @ObfuscatedName("r")
   public static short[] field264;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -53972307
   )
   static int field266;
   @ObfuscatedName("eo")
   static class78 field268;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2115097567"
   )
   static final int method217(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var1 / 32 << 7) + (var0 / 4 << 10);
      return var3;
   }

   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method218(String var0, boolean var1) {
      String var2 = "https://";
      if(client.field352 == 1) {
         var0 = var0 + "-wtrc";
      } else if(2 == client.field352) {
         var0 = var0 + "-wtqa";
      } else if(client.field352 == 3) {
         var0 = var0 + "-wtwip";
      } else if(5 == client.field352) {
         var0 = var0 + "-wti";
      } else if(client.field352 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class14.field220 != null) {
         var3 = "/p=" + class14.field220;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field372 + "/a=" + class23.field611 + var3 + "/";
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-862026655"
   )
   static final void method219(int var0) {
      int[] var1 = class94.field1610.field1411;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 2048 * (103 - var3) + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if(0 == (class5.field82[var0][var5][var3] & 24)) {
               class30.field717.method2099(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class5.field82[1 + var0][var5][var3] & 8) != 0) {
               class30.field717.method2099(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class94.field1610.method1849();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if(0 == (class5.field82[var0][var6][var5] & 24)) {
               class154.method3259(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && 0 != (class5.field82[1 + var0][var6][var5] & 8)) {
               class154.method3259(1 + var0, var6, var5, var3, var4);
            }
         }
      }

      client.field524 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class30.field717.method2037(class42.field1002, var5, var6);
            if(0 != var7) {
               var7 = var7 >> 14 & 32767;
               int var8 = class133.method2969(var7).field951;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(22 != var8 && 29 != var8 && var8 != 34 && var8 != 36 && var8 != 46 && 47 != var8 && var8 != 48) {
                     int[][] var13 = client.field361[class42.field1002].field1896;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && 0 == (var13[var9][var10 - 1] & 19136770)) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && 0 == (var13[var9][var10 + 1] & 19136800)) {
                           ++var10;
                        }
                     }
                  }

                  client.field527[client.field524] = class122.field2014[var8];
                  client.field307[client.field524] = var9;
                  client.field565[client.field524] = var10;
                  ++client.field524;
               }
            }
         }
      }

      class28.field695.method1782();
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   static final boolean method220(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field437[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return 1007 == var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "180"
   )
   static final void method221() {
      short var0 = 256;
      int var1;
      if(class31.field733 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field733 > 768) {
               class34.field786[var1] = class114.method2546(class43.field1019[var1], class29.field699[var1], 1024 - class31.field733);
            } else if(class31.field733 > 256) {
               class34.field786[var1] = class29.field699[var1];
            } else {
               class34.field786[var1] = class114.method2546(class29.field699[var1], class43.field1019[var1], 256 - class31.field733);
            }
         }
      } else if(class31.field734 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field734 > 768) {
               class34.field786[var1] = class114.method2546(class43.field1019[var1], class31.field732[var1], 1024 - class31.field734);
            } else if(class31.field734 > 256) {
               class34.field786[var1] = class31.field732[var1];
            } else {
               class34.field786[var1] = class114.method2546(class31.field732[var1], class43.field1019[var1], 256 - class31.field734);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class34.field786[var1] = class43.field1019[var1];
         }
      }

      class79.method1889(class31.field723, 9, class31.field723 + 128, 7 + var0);
      class31.field727.method1796(class31.field723, 0);
      class79.method1888();
      var1 = 0;
      int var2 = class31.field723 + class28.field695.field1394 * 9;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field731[var3] * (var0 - var3) / var0;
         var5 = 22 + var4;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class26.field676[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class34.field786[var7];
               var10 = class28.field695.field1393[var2];
               class28.field695.field1393[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + ((var7 & '\uff00') * var8 + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class28.field695.field1394 - 128;
      }

      class79.method1889(765 + class31.field723 - 128, 9, 765 + class31.field723, 7 + var0);
      class31.field728.method1796(class31.field723 + 382, 0);
      class79.method1888();
      var1 = 0;
      var2 = class31.field723 + 637 + class28.field695.field1394 * 9 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field731[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class26.field676[var1++];
            if(0 != var7) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class34.field786[var7];
               var10 = class28.field695.field1393[var2];
               class28.field695.field1393[var2++] = (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) + (var9 * (var10 & '\uff00') + (var7 & '\uff00') * var8 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class28.field695.field1394 - var5 - var4;
      }

   }
}
