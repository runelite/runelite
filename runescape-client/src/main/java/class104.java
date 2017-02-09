import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class104 {
   @ObfuscatedName("r")
   static File field1691;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 160919181
   )
   public static int field1692;
   @ObfuscatedName("s")
   public static class72 field1693 = null;
   @ObfuscatedName("g")
   public static class72 field1694 = null;
   @ObfuscatedName("i")
   public static class72 field1695 = null;
   @ObfuscatedName("p")
   public static String[] field1697;
   @ObfuscatedName("ek")
   static ModIcon[] field1699;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-3"
   )
   static int method1975(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return null != class112.field1762 && class112.field1762.hash == var2?1 + CombatInfoListHolder.field749.offset * 99 / (CombatInfoListHolder.field749.payload.length - class112.field1762.field2686):0;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1663445791"
   )
   static final void method1983(int var0, int var1, int var2, int var3) {
      Client.field371 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class45.field901;
      int[] var7 = class45.field902;

      int var8;
      for(var8 = 0; var8 < Client.field317 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(Client.field407 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field554[var8 - var6]];
         }

         class65.method1187((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class65.method1187(Client.cachedPlayers[Client.field407], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field371; ++var8) {
         int var18 = Client.field373[var8];
         int var10 = Client.field374[var8];
         int var11 = Client.field376[var8];
         int var12 = Client.field519[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > Client.field374[var14] - Client.field519[var14] && var10 - var12 < Client.field374[var14] + 2 && var18 - var11 < Client.field373[var14] + Client.field376[var14] && var11 + var18 > Client.field373[var14] - Client.field376[var14] && Client.field374[var14] - Client.field519[var14] < var10) {
                  var10 = Client.field374[var14] - Client.field519[var14];
                  var13 = true;
               }
            }
         }

         Client.field383 = Client.field373[var8];
         Client.field384 = Client.field374[var8] = var10;
         String var19 = Client.field380[var8];
         if(Client.field439 == 0) {
            int var15 = 16776960;
            if(Client.field377[var8] < 6) {
               var15 = Client.field498[Client.field377[var8]];
            }

            if(Client.field377[var8] == 6) {
               var15 = Client.field451 % 20 < 10?16711680:16776960;
            }

            if(Client.field377[var8] == 7) {
               var15 = Client.field451 % 20 < 10?255:'\uffff';
            }

            if(Client.field377[var8] == 8) {
               var15 = Client.field451 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field377[var8] == 9) {
               var16 = 150 - Client.field379[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field377[var8] == 10) {
               var16 = 150 - Client.field379[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - 5 * (var16 - 100);
               }
            }

            if(Client.field377[var8] == 11) {
               var16 = 150 - Client.field379[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = '\uff00' + 327685 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field378[var8] == 0) {
               class16.field176.method3874(var19, var0 + Client.field383, var1 + Client.field384, var15, 0);
            }

            if(Client.field378[var8] == 1) {
               class16.field176.method3876(var19, Client.field383 + var0, var1 + Client.field384, var15, 0, Client.field451);
            }

            if(Client.field378[var8] == 2) {
               class16.field176.method3871(var19, var0 + Client.field383, var1 + Client.field384, var15, 0, Client.field451);
            }

            if(Client.field378[var8] == 3) {
               class16.field176.method3878(var19, Client.field383 + var0, Client.field384 + var1, var15, 0, Client.field451, 150 - Client.field379[var8]);
            }

            if(Client.field378[var8] == 4) {
               var16 = (150 - Client.field379[var8]) * (class16.field176.method3884(var19) + 100) / 150;
               Rasterizer2D.method3974(Client.field383 + var0 - 50, var1, Client.field383 + var0 + 50, var1 + var3);
               class16.field176.method3919(var19, var0 + Client.field383 + 50 - var16, Client.field384 + var1, var15, 0);
               Rasterizer2D.method3973(var0, var1, var2 + var0, var3 + var1);
            }

            if(Client.field378[var8] == 5) {
               var16 = 150 - Client.field379[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.method3974(var0, Client.field384 + var1 - class16.field176.field3086 - 1, var0 + var2, 5 + var1 + Client.field384);
               class16.field176.method3874(var19, var0 + Client.field383, var17 + Client.field384 + var1, var15, 0);
               Rasterizer2D.method3973(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class16.field176.method3874(var19, var0 + Client.field383, var1 + Client.field384, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1700459910"
   )
   public static int method1989(int var0) {
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

      return var1 + var0;
   }

   class104() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-113"
   )
   static void method1991(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class181 var4 = (class181)class185.field2741.method2331(var2);
      if(var4 != null) {
         class185.field2729.method2290(var4);
      }
   }
}
