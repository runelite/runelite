import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class89 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1698358973
   )
   int field1397;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2127826993
   )
   int field1398;
   @ObfuscatedName("f")
   String field1400;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1649171323
   )
   int field1401;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -888421841
   )
   int field1402;

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1070537652"
   )
   static void method1695() {
      Client.menuOptionCount = 0;
      Client.field1062 = -1;
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-39"
   )
   static final void method1696(int var0, int var1, int var2, int var3) {
      Client.field1008 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class96.field1499;
      int[] var7 = class96.field1501;

      int var8;
      for(var8 = 0; var8 < Client.field952 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(Client.field1044 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.npcIndices[var8 - var6]];
         }

         class2.method7((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class2.method7(Client.cachedPlayers[Client.field1044], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field1008; ++var8) {
         int var18 = Client.field1010[var8];
         int var10 = Client.field1105[var8];
         int var11 = Client.field1038[var8];
         int var12 = Client.field1012[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var19 = 0; var19 < var8; ++var19) {
               if(var10 + 2 > Client.field1105[var19] - Client.field1012[var19] && var10 - var12 < Client.field1105[var19] + 2 && var18 - var11 < Client.field1038[var19] + Client.field1010[var19] && var11 + var18 > Client.field1010[var19] - Client.field1038[var19] && Client.field1105[var19] - Client.field1012[var19] < var10) {
                  var10 = Client.field1105[var19] - Client.field1012[var19];
                  var13 = true;
               }
            }
         }

         Client.field1020 = Client.field1010[var8];
         Client.field1163 = Client.field1105[var8] = var10;
         String var14 = Client.field968[var8];
         if(Client.field1078 == 0) {
            int var15 = 16776960;
            if(Client.field982[var8] < 6) {
               var15 = Client.field1063[Client.field982[var8]];
            }

            if(Client.field982[var8] == 6) {
               var15 = Client.field1019 % 20 < 10?16711680:16776960;
            }

            if(Client.field982[var8] == 7) {
               var15 = Client.field1019 % 20 < 10?255:'\uffff';
            }

            if(Client.field982[var8] == 8) {
               var15 = Client.field1019 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field982[var8] == 9) {
               var16 = 150 - Client.field1085[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field982[var8] == 10) {
               var16 = 150 - Client.field1085[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field982[var8] == 11) {
               var16 = 150 - Client.field1085[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field1017[var8] == 0) {
               class241.field3288.method4825(var14, Client.field1020 + var0, Client.field1163 + var1, var15, 0);
            }

            if(Client.field1017[var8] == 1) {
               class241.field3288.method4790(var14, var0 + Client.field1020, Client.field1163 + var1, var15, 0, Client.field1019);
            }

            if(Client.field1017[var8] == 2) {
               class241.field3288.method4788(var14, Client.field1020 + var0, Client.field1163 + var1, var15, 0, Client.field1019);
            }

            if(Client.field1017[var8] == 3) {
               class241.field3288.method4821(var14, var0 + Client.field1020, var1 + Client.field1163, var15, 0, Client.field1019, 150 - Client.field1085[var8]);
            }

            if(Client.field1017[var8] == 4) {
               var16 = (150 - Client.field1085[var8]) * (class241.field3288.method4780(var14) + 100) / 150;
               Rasterizer2D.method4962(Client.field1020 + var0 - 50, var1, var0 + Client.field1020 + 50, var3 + var1);
               class241.field3288.method4785(var14, var0 + Client.field1020 + 50 - var16, var1 + Client.field1163, var15, 0);
               Rasterizer2D.method4961(var0, var1, var2 + var0, var3 + var1);
            }

            if(Client.field1017[var8] == 5) {
               var16 = 150 - Client.field1085[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.method4962(var0, Client.field1163 + var1 - class241.field3288.field3652 - 1, var2 + var0, var1 + Client.field1163 + 5);
               class241.field3288.method4825(var14, var0 + Client.field1020, Client.field1163 + var1 + var17, var15, 0);
               Rasterizer2D.method4961(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            class241.field3288.method4825(var14, var0 + Client.field1020, Client.field1163 + var1, 16776960, 0);
         }
      }

   }
}
