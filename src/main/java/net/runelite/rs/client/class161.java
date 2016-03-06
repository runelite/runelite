package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fx")
public final class class161 {
   @ObfuscatedName("bi")
   static class167 field2652;
   @ObfuscatedName("mz")
   static byte field2653;
   @ObfuscatedName("j")
   public static final char[] field2655 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("av")
   static final void method3146(int var0, int var1) {
      if(class130.field2065 != var0 || class105.field1878 != var1) {
         class130.field2065 = var0;
         class105.field1878 = var1;
         client.method556(25);
         class10.method128("Loading - please wait.", true);
         int var2 = class98.field1683;
         int var3 = class92.field1598;
         class98.field1683 = (var0 - 6) * 8;
         class92.field1598 = (var1 - 6) * 8;
         int var4 = class98.field1683 - var2;
         int var5 = class92.field1598 - var3;
         var2 = class98.field1683;
         var3 = class92.field1598;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field324[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field864[var8] -= var4;
                  var7.field817[var8] -= var5;
               }

               var7.field839 -= 128 * var4;
               var7.field848 -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var18 = client.field410[var6];
            if(null != var18) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var18.field864[var8] -= var4;
                  var18.field817[var8] -= var5;
               }

               var18.field839 -= 128 * var4;
               var18.field848 -= var5 * 128;
            }
         }

         byte var17 = 0;
         byte var19 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var17 = 103;
            var19 = -1;
            var20 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var17; var12 != var19; var12 += var20) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field420[var16][var12][var13] = client.field420[var16][var14][var15];
                  } else {
                     client.field420[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field409.method3773(); var21 != null; var21 = (class16)client.field409.method3772()) {
            var21.field230 -= var4;
            var21.field235 -= var5;
            if(var21.field230 < 0 || var21.field235 < 0 || var21.field230 >= 104 || var21.field235 >= 104) {
               var21.method3853();
            }
         }

         if(0 != client.field296) {
            client.field296 -= var4;
            client.field319 -= var5;
         }

         client.field530 = 0;
         client.field528 = false;
         client.field517 = 1;
         client.field423.method3767();
         client.field422.method3767();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field346[var13].method2341();
         }

      }
   }

   @ObfuscatedName("di")
   static final void method3147(class172 var0, int var1, int var2, int var3) {
      class38.method764();
      class174 var4 = var0.method3360(false);
      if(var4 != null) {
         class79.method1778(var1, var2, var4.field2903 + var1, var4.field2900 + var2);
         if(client.field524 != 2 && client.field524 != 5) {
            int var5 = client.field374 + client.field522 & 2047;
            int var6 = 48 + class148.field2249.field839 / 32;
            int var7 = 464 - class148.field2249.field848 / 32;
            class42.field1002.method1699(var1, var2, var4.field2903, var4.field2900, var6, var7, var5, client.field359 + 256, var4.field2902, var4.field2899);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < client.field518; ++var8) {
               var9 = 2 + client.field519[var8] * 4 - class148.field2249.field839 / 32;
               var10 = client.field563[var8] * 4 + 2 - class148.field2249.field848 / 32;
               class38.method763(var1, var2, var9, var10, client.field395[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  class198 var19 = client.field420[class75.field1386][var8][var9];
                  if(null != var19) {
                     var11 = 2 + 4 * var8 - class148.field2249.field839 / 32;
                     var12 = 2 + var9 * 4 - class148.field2249.field848 / 32;
                     class38.method763(var1, var2, var11, var12, class42.field1005[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < client.field561; ++var8) {
               class34 var17 = client.field324[client.field326[var8]];
               if(null != var17 && var17.vmethod753()) {
                  class39 var20 = var17.field779;
                  if(var20 != null && null != var20.field909) {
                     var20 = var20.method789();
                  }

                  if(var20 != null && var20.field900 && var20.field883) {
                     var11 = var17.field839 / 32 - class148.field2249.field839 / 32;
                     var12 = var17.field848 / 32 - class148.field2249.field848 / 32;
                     class38.method763(var1, var2, var11, var12, class42.field1005[1], var4);
                  }
               }
            }

            var8 = class32.field749;
            int[] var18 = class32.field755;

            for(var10 = 0; var10 < var8; ++var10) {
               class2 var21 = client.field410[var18[var10]];
               if(null != var21 && var21.vmethod753() && !var21.field54 && var21 != class148.field2249) {
                  var12 = var21.field839 / 32 - class148.field2249.field839 / 32;
                  int var13 = var21.field848 / 32 - class148.field2249.field848 / 32;
                  boolean var14 = false;
                  if(class132.method2791(var21.field48, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class10.field163; ++var16) {
                     if(var21.field48.equals(class135.field2103[var16].field626)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var24 = false;
                  if(class148.field2249.field53 != 0 && 0 != var21.field53 && var21.field53 == class148.field2249.field53) {
                     var24 = true;
                  }

                  if(var14) {
                     class38.method763(var1, var2, var12, var13, class42.field1005[3], var4);
                  } else if(var24) {
                     class38.method763(var1, var2, var12, var13, class42.field1005[4], var4);
                  } else if(var15) {
                     class38.method763(var1, var2, var12, var13, class42.field1005[5], var4);
                  } else {
                     class38.method763(var1, var2, var12, var13, class42.field1005[2], var4);
                  }
               }
            }

            if(0 != client.field351 && client.field394 % 20 < 10) {
               if(client.field351 == 1 && client.field306 >= 0 && client.field306 < client.field324.length) {
                  class34 var22 = client.field324[client.field306];
                  if(null != var22) {
                     var11 = var22.field839 / 32 - class148.field2249.field839 / 32;
                     var12 = var22.field848 / 32 - class148.field2249.field848 / 32;
                     class74.method1596(var1, var2, var11, var12, client.field364[1], var4);
                  }
               }

               if(2 == client.field351) {
                  var10 = client.field438 * 4 - class98.field1683 * 4 + 2 - class148.field2249.field839 / 32;
                  var11 = client.field309 * 4 - class92.field1598 * 4 + 2 - class148.field2249.field848 / 32;
                  class74.method1596(var1, var2, var10, var11, client.field364[1], var4);
               }

               if(10 == client.field351 && client.field307 >= 0 && client.field307 < client.field410.length) {
                  class2 var23 = client.field410[client.field307];
                  if(null != var23) {
                     var11 = var23.field839 / 32 - class148.field2249.field839 / 32;
                     var12 = var23.field848 / 32 - class148.field2249.field848 / 32;
                     class74.method1596(var1, var2, var11, var12, client.field364[1], var4);
                  }
               }
            }

            if(0 != client.field296) {
               var10 = 2 + client.field296 * 4 - class148.field2249.field839 / 32;
               var11 = 2 + client.field319 * 4 - class148.field2249.field848 / 32;
               class38.method763(var1, var2, var10, var11, client.field364[0], var4);
            }

            if(!class148.field2249.field54) {
               class79.method1776(var1 + var4.field2903 / 2 - 1, var2 + var4.field2900 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            class79.method1771(var1, var2, 0, var4.field2902, var4.field2899);
         }

         client.field497[var3] = true;
      }
   }
}
