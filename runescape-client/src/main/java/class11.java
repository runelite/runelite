import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class11 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final class11 field267;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final class11 field265;

   static {
      field267 = new class11();
      field265 = new class11();
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1654486696"
   )
   static final void method56(int var0, int var1, int var2, int var3) {
      Client.field995 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class97.field1493;
      int[] var7 = class97.field1494;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field952; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field1031) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.npcIndices[var8 - var6]];
         }

         class64.method1086((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class64.method1086(Client.cachedPlayers[Client.field1031], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field995; ++var8) {
         int var18 = Client.field1032[var8];
         int var10 = Client.field998[var8];
         int var11 = Client.field1000[var8];
         int var12 = Client.field1064[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > Client.field998[var14] - Client.field1064[var14] && var10 - var12 < Client.field998[var14] + 2 && var18 - var11 < Client.field1000[var14] + Client.field1032[var14] && var11 + var18 > Client.field1032[var14] - Client.field1000[var14] && Client.field998[var14] - Client.field1064[var14] < var10) {
                  var10 = Client.field998[var14] - Client.field1064[var14];
                  var13 = true;
               }
            }
         }

         Client.screenY = Client.field1032[var8];
         Client.screenX = Client.field998[var8] = var10;
         String var19 = Client.field1004[var8];
         if(Client.field1023 == 0) {
            int var15 = 16776960;
            if(Client.field1001[var8] < 6) {
               var15 = Client.field1118[Client.field1001[var8]];
            }

            if(Client.field1001[var8] == 6) {
               var15 = Client.field1006 % 20 < 10?16711680:16776960;
            }

            if(Client.field1001[var8] == 7) {
               var15 = Client.field1006 % 20 < 10?255:'\uffff';
            }

            if(Client.field1001[var8] == 8) {
               var15 = Client.field1006 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field1001[var8] == 9) {
               var16 = 150 - Client.field1003[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field1001[var8] == 10) {
               var16 = 150 - Client.field1003[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 5;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field1001[var8] == 11) {
               var16 = 150 - Client.field1003[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field1002[var8] == 0) {
               class28.field406.method4779(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0);
            }

            if(Client.field1002[var8] == 1) {
               class28.field406.method4781(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0, Client.field1006);
            }

            if(Client.field1002[var8] == 2) {
               class28.field406.method4782(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0, Client.field1006);
            }

            if(Client.field1002[var8] == 3) {
               class28.field406.method4844(var19, var0 + Client.screenY, Client.screenX + var1, var15, 0, Client.field1006, 150 - Client.field1003[var8]);
            }

            if(Client.field1002[var8] == 4) {
               var16 = (150 - Client.field1003[var8]) * (class28.field406.method4771(var19) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, var0 + Client.screenY + 50, var3 + var1);
               class28.field406.method4776(var19, var0 + Client.screenY + 50 - var16, Client.screenX + var1, var15, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field1002[var8] == 5) {
               var16 = 150 - Client.field1003[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - class28.field406.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
               class28.field406.method4779(var19, var0 + Client.screenY, var17 + Client.screenX + var1, var15, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class28.field406.method4779(var19, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
         }
      }

   }
}
