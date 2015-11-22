package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ay")
public class class33 {
   @ObfuscatedName("z")
   public static class227[] field747;
   @ObfuscatedName("m")
   static final class33 field748 = new class33();
   @ObfuscatedName("aj")
   static class78[] field749;
   @ObfuscatedName("l")
   static final class33 field750 = new class33();
   @ObfuscatedName("ac")
   static boolean field752;
   @ObfuscatedName("j")
   static final class33 field753 = new class33();
   @ObfuscatedName("f")
   static final class33 field754 = new class33();
   @ObfuscatedName("i")
   static class80 field755;

   @ObfuscatedName("cz")
   static void method754(class172[] var0, class172 var1, boolean var2) {
      int var3 = var1.field2856 != 0?var1.field2856:var1.field2749;
      int var4 = 0 != var1.field2765?var1.field2765:var1.field2750;
      class93.method2183(var0, var1.field2734 * -1, var3, var4, var2);
      if(null != var1.field2806) {
         class93.method2183(var1.field2806, var1.field2734 * -1, var3, var4, var2);
      }

      class3 var5 = (class3)client.field304.method3836((long)(var1.field2734 * -1));
      if(var5 != null) {
         int var6 = var5.field63;
         if(class167.method3400(var6)) {
            class93.method2183(class172.field2857[var6], -1, var3, var4, var2);
         }
      }

      if(1337 == var1.field2738) {
         ;
      }

   }

   @ObfuscatedName("j")
   public static class40 method755(int var0) {
      class40 var1 = (class40)class40.field952.method3808((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class42.field990.method3352(6, var0);
         var1 = new class40();
         var1.field935 = var0;
         if(null != var2) {
            var1.method846(new class118(var2));
         }

         var1.method845();
         if(var1.field943) {
            var1.field921 = 0;
            var1.field922 = false;
         }

         class40.field952.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ak")
   static final void method756(int var0, int var1, int var2, int var3) {
      client.field385 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field733;
      int[] var7 = class32.field730;

      int var8;
      for(var8 = 0; var8 < var6 + client.field314; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field397[var7[var8]];
            if(var7[var8] == client.field406) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field313[client.field315[var8 - var6]];
         }

         class92.method2176((class37)var9, var8, var0, var1);
      }

      if(var4) {
         class92.method2176(client.field397[client.field406], var5, var0, var1);
      }

      for(var8 = 0; var8 < client.field385; ++var8) {
         int var18 = client.field372[var8];
         int var10 = client.field373[var8];
         int var11 = client.field375[var8];
         int var12 = client.field301[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > client.field373[var14] - client.field301[var14] && var10 - var12 < 2 + client.field373[var14] && var18 - var11 < client.field375[var14] + client.field372[var14] && var11 + var18 > client.field372[var14] - client.field375[var14] && client.field373[var14] - client.field301[var14] < var10) {
                  var10 = client.field373[var14] - client.field301[var14];
                  var13 = true;
               }
            }
         }

         client.field382 = client.field372[var8] * -1;
         client.field395 = (client.field373[var8] = var10) * -1;
         String var19 = client.field394[var8];
         if(client.field436 == 0) {
            int var15 = 16776960;
            if(client.field554[var8] < 6) {
               var15 = client.field380[client.field554[var8]];
            }

            if(client.field554[var8] == 6) {
               var15 = client.field381 % 20 < 10?16711680:16776960;
            }

            if(7 == client.field554[var8]) {
               var15 = client.field381 % 20 < 10?255:'\uffff';
            }

            if(client.field554[var8] == 8) {
               var15 = client.field381 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(client.field554[var8] == 9) {
               var16 = 150 - client.field352[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 1280 * var16;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = '\uff00' + 5 * (var16 - 100);
               }
            }

            if(10 == client.field554[var8]) {
               var16 = 150 - client.field352[var8];
               if(var16 < 50) {
                  var15 = 5 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - (var16 - 100) * 5;
               }
            }

            if(client.field554[var8] == 11) {
               var16 = 150 - client.field352[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(client.field377[var8] == 0) {
               class143.field2174.method4077(var19, var0 + client.field382 * -1, var1 + client.field395 * -1, var15, 0);
            }

            if(1 == client.field377[var8]) {
               class143.field2174.method4079(var19, var0 + client.field382 * -1, client.field395 * -1 + var1, var15, 0, client.field381);
            }

            if(2 == client.field377[var8]) {
               class143.field2174.method4152(var19, var0 + client.field382 * -1, var1 + client.field395 * -1, var15, 0, client.field381);
            }

            if(client.field377[var8] == 3) {
               class143.field2174.method4081(var19, var0 + client.field382 * -1, var1 + client.field395 * -1, var15, 0, client.field381, 150 - client.field352[var8]);
            }

            if(4 == client.field377[var8]) {
               var16 = (150 - client.field352[var8]) * (class143.field2174.method4161(var19) + 100) / 150;
               class79.method1817(var0 + client.field382 * -1 - 50, var1, 50 + client.field382 * -1 + var0, var1 + var3);
               class143.field2174.method4074(var19, var0 + client.field382 * -1 + 50 - var16, var1 + client.field395 * -1, var15, 0);
               class79.method1816(var0, var1, var0 + var2, var3 + var1);
            }

            if(5 == client.field377[var8]) {
               var16 = 150 - client.field352[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1817(var0, client.field395 * -1 + var1 - class143.field2174.field3182 - 1, var2 + var0, 5 + client.field395 * -1 + var1);
               class143.field2174.method4077(var19, var0 + client.field382 * -1, client.field395 * -1 + var1 + var17, var15, 0);
               class79.method1816(var0, var1, var2 + var0, var3 + var1);
            }
         } else {
            class143.field2174.method4077(var19, client.field382 * -1 + var0, client.field395 * -1 + var1, 16776960, 0);
         }
      }

   }
}
