import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class179 {
   @ObfuscatedName("f")
   public static int[] field2938 = new int[32];
   @ObfuscatedName("e")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("n")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2938[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "1630240207"
   )
   static String method3508(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "240534948"
   )
   static final void method3509(int var0, int var1, int var2, int var3) {
      Client.field382 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class34.field763;
      int[] var7 = class34.field758;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field321; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field471) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field405[var8 - var6]];
         }

         class51.method1068((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class51.method1068(Client.cachedPlayers[Client.field471], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field382; ++var8) {
         int var19 = Client.field377[var8];
         int var10 = Client.field378[var8];
         int var11 = Client.field380[var8];
         int var12 = Client.field553[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > Client.field378[var14] - Client.field553[var14] && var10 - var12 < 2 + Client.field378[var14] && var19 - var11 < Client.field380[var14] + Client.field377[var14] && var11 + var19 > Client.field377[var14] - Client.field380[var14] && Client.field378[var14] - Client.field553[var14] < var10) {
                  var10 = Client.field378[var14] - Client.field553[var14];
                  var13 = true;
               }
            }
         }

         Client.field387 = Client.field377[var8];
         Client.field388 = Client.field378[var8] = var10;
         String var18 = Client.field384[var8];
         if(Client.field441 == 0) {
            int var15 = 16776960;
            if(Client.field518[var8] < 6) {
               var15 = Client.field300[Client.field518[var8]];
            }

            if(Client.field518[var8] == 6) {
               var15 = Client.field386 % 20 < 10?16711680:16776960;
            }

            if(Client.field518[var8] == 7) {
               var15 = Client.field386 % 20 < 10?255:'\uffff';
            }

            if(Client.field518[var8] == 8) {
               var15 = Client.field386 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field518[var8] == 9) {
               var16 = 150 - Client.field383[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 1280 * var16;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 5 * (var16 - 100) + '\uff00';
               }
            }

            if(Client.field518[var8] == 10) {
               var16 = 150 - Client.field383[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 5;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - 5 * (var16 - 100);
               }
            }

            if(Client.field518[var8] == 11) {
               var16 = 150 - Client.field383[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field284[var8] == 0) {
               class79.field1434.method4099(var18, var0 + Client.field387, Client.field388 + var1, var15, 0);
            }

            if(Client.field284[var8] == 1) {
               class79.field1434.method4101(var18, var0 + Client.field387, var1 + Client.field388, var15, 0, Client.field386);
            }

            if(Client.field284[var8] == 2) {
               class79.field1434.method4102(var18, Client.field387 + var0, var1 + Client.field388, var15, 0, Client.field386);
            }

            if(Client.field284[var8] == 3) {
               class79.field1434.method4103(var18, var0 + Client.field387, var1 + Client.field388, var15, 0, Client.field386, 150 - Client.field383[var8]);
            }

            if(Client.field284[var8] == 4) {
               var16 = (150 - Client.field383[var8]) * (class79.field1434.method4091(var18) + 100) / 150;
               class82.method1887(var0 + Client.field387 - 50, var1, var0 + Client.field387 + 50, var1 + var3);
               class79.field1434.method4096(var18, 50 + Client.field387 + var0 - var16, var1 + Client.field388, var15, 0);
               class82.method1895(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field284[var8] == 5) {
               var16 = 150 - Client.field383[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class82.method1887(var0, Client.field388 + var1 - class79.field1434.field3245 - 1, var2 + var0, var1 + Client.field388 + 5);
               class79.field1434.method4099(var18, var0 + Client.field387, var17 + var1 + Client.field388, var15, 0);
               class82.method1895(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            class79.field1434.method4099(var18, var0 + Client.field387, var1 + Client.field388, 16776960, 0);
         }
      }

   }
}
