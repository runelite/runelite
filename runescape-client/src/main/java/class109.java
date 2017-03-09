import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public abstract class class109 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   public abstract void vmethod2107();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "531304005"
   )
   abstract int vmethod2108(int var1, int var2);

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "434098296"
   )
   static final void method2114(int var0, int var1, int var2, int var3) {
      Client.field352 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class45.field934;
      int[] var7 = class45.field925;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field351; ++var8) {
         Object var18;
         if(var8 < var6) {
            var18 = Client.cachedPlayers[var7[var8]];
            if(Client.field407 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var18 = Client.cachedNPCs[Client.field570[var8 - var6]];
         }

         PlayerComposition.method3184((Actor)var18, var8, var0, var1, var2, var3);
      }

      if(var4) {
         PlayerComposition.method3184(Client.cachedPlayers[Client.field407], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field352; ++var8) {
         int var9 = Client.field485[var8];
         int var10 = Client.field493[var8];
         int var11 = Client.field370[var8];
         int var12 = Client.field410[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > Client.field493[var14] - Client.field410[var14] && var10 - var12 < Client.field493[var14] + 2 && var9 - var11 < Client.field485[var14] + Client.field370[var14] && var9 + var11 > Client.field485[var14] - Client.field370[var14] && Client.field493[var14] - Client.field410[var14] < var10) {
                  var10 = Client.field493[var14] - Client.field410[var14];
                  var13 = true;
               }
            }
         }

         Client.field355 = Client.field485[var8];
         Client.field339 = Client.field493[var8] = var10;
         String var19 = Client.field501[var8];
         if(Client.field475 == 0) {
            int var15 = 16776960;
            if(Client.field412[var8] < 6) {
               var15 = Client.field464[Client.field412[var8]];
            }

            if(Client.field412[var8] == 6) {
               var15 = Client.field534 % 20 < 10?16711680:16776960;
            }

            if(Client.field412[var8] == 7) {
               var15 = Client.field534 % 20 < 10?255:'\uffff';
            }

            if(Client.field412[var8] == 8) {
               var15 = Client.field534 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field412[var8] == 9) {
               var16 = 150 - Client.field459[var8];
               if(var16 < 50) {
                  var15 = 1280 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field412[var8] == 10) {
               var16 = 150 - Client.field459[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field412[var8] == 11) {
               var16 = 150 - Client.field459[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = 327685 * (var16 - 50) + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field413[var8] == 0) {
               BufferProvider.field3198.method3964(var19, var0 + Client.field355, Client.field339 + var1, var15, 0);
            }

            if(Client.field413[var8] == 1) {
               BufferProvider.field3198.method3925(var19, var0 + Client.field355, Client.field339 + var1, var15, 0, Client.field534);
            }

            if(Client.field413[var8] == 2) {
               BufferProvider.field3198.method3887(var19, Client.field355 + var0, var1 + Client.field339, var15, 0, Client.field534);
            }

            if(Client.field413[var8] == 3) {
               BufferProvider.field3198.method3888(var19, Client.field355 + var0, Client.field339 + var1, var15, 0, Client.field534, 150 - Client.field459[var8]);
            }

            if(Client.field413[var8] == 4) {
               var16 = (150 - Client.field459[var8]) * (BufferProvider.field3198.method3876(var19) + 100) / 150;
               Rasterizer2D.method3999(var0 + Client.field355 - 50, var1, 50 + Client.field355 + var0, var3 + var1);
               BufferProvider.field3198.method3881(var19, 50 + Client.field355 + var0 - var16, var1 + Client.field339, var15, 0);
               Rasterizer2D.method4016(var0, var1, var2 + var0, var3 + var1);
            }

            if(Client.field413[var8] == 5) {
               var16 = 150 - Client.field459[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.method3999(var0, var1 + Client.field339 - BufferProvider.field3198.field3120 - 1, var2 + var0, 5 + var1 + Client.field339);
               BufferProvider.field3198.method3964(var19, var0 + Client.field355, var17 + var1 + Client.field339, var15, 0);
               Rasterizer2D.method4016(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            BufferProvider.field3198.method3964(var19, Client.field355 + var0, var1 + Client.field339, 16776960, 0);
         }
      }

   }
}
