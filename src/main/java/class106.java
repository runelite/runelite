import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class106 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -395073871
   )
   public static int field1876;
   @ObfuscatedName("t")
   public static int[][] field1877 = new int[128][128];
   @ObfuscatedName("p")
   public static int[][] field1878 = new int[128][128];
   @ObfuscatedName("v")
   public static int[] field1879 = new int[4096];
   @ObfuscatedName("c")
   public static int[] field1881 = new int[4096];
   @ObfuscatedName("f")
   static int[] field1883;
   @ObfuscatedName("y")
   static class167 field1885;

   @ObfuscatedName("x")
   public static String method2377(class119 var0) {
      return class47.method1025(var0, 32767);
   }

   @ObfuscatedName("w")
   public static final boolean method2378(int var0, int var1, class107 var2, class108 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      field1877[var6][var7] = 99;
      field1878[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      field1881[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      field1879[var10001] = var1;
      int[][] var12 = var3.field1894;

      while(var11 != var18) {
         var4 = field1881[var11];
         var5 = field1879[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1902;
         int var14 = var5 - var3.field1903;
         if(var2.vmethod2389(var4, var5)) {
            field1876 = var4;
            class131.field2071 = var5;
            return true;
         }

         int var15 = field1878[var16][var17] + 1;
         if(var16 > 0 && 0 == field1877[var16 - 1][var17] && (var12[var13 - 1][var14] & 19136776) == 0) {
            field1881[var18] = var4 - 1;
            field1879[var18] = var5;
            var18 = var18 + 1 & 4095;
            field1877[var16 - 1][var17] = 2;
            field1878[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && 0 == field1877[1 + var16][var17] && 0 == (var12[var13 + 1][var14] & 19136896)) {
            field1881[var18] = 1 + var4;
            field1879[var18] = var5;
            var18 = 1 + var18 & 4095;
            field1877[var16 + 1][var17] = 8;
            field1878[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && field1877[var16][var17 - 1] == 0 && 0 == (var12[var13][var14 - 1] & 19136770)) {
            field1881[var18] = var4;
            field1879[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            field1877[var16][var17 - 1] = 1;
            field1878[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && field1877[var16][var17 + 1] == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            field1881[var18] = var4;
            field1879[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            field1877[var16][var17 + 1] = 4;
            field1878[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && field1877[var16 - 1][var17 - 1] == 0 && 0 == (var12[var13 - 1][var14 - 1] & 19136782) && 0 == (var12[var13 - 1][var14] & 19136776) && 0 == (var12[var13][var14 - 1] & 19136770)) {
            field1881[var18] = var4 - 1;
            field1879[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            field1877[var16 - 1][var17 - 1] = 3;
            field1878[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && 0 == field1877[1 + var16][var17 - 1] && 0 == (var12[var13 + 1][var14 - 1] & 19136899) && 0 == (var12[var13 + 1][var14] & 19136896) && 0 == (var12[var13][var14 - 1] & 19136770)) {
            field1881[var18] = 1 + var4;
            field1879[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            field1877[1 + var16][var17 - 1] = 9;
            field1878[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && 0 == field1877[var16 - 1][1 + var17] && 0 == (var12[var13 - 1][var14 + 1] & 19136824) && 0 == (var12[var13 - 1][var14] & 19136776) && 0 == (var12[var13][1 + var14] & 19136800)) {
            field1881[var18] = var4 - 1;
            field1879[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            field1877[var16 - 1][var17 + 1] = 6;
            field1878[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && field1877[var16 + 1][var17 + 1] == 0 && 0 == (var12[1 + var13][1 + var14] & 19136992) && (var12[var13 + 1][var14] & 19136896) == 0 && 0 == (var12[var13][var14 + 1] & 19136800)) {
            field1881[var18] = 1 + var4;
            field1879[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            field1877[var16 + 1][1 + var17] = 12;
            field1878[var16 + 1][var17 + 1] = var15;
         }
      }

      field1876 = var4;
      class131.field2071 = var5;
      return false;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIII)V",
      garbageValue = "-29531999"
   )
   static final void method2379(class37 var0, int var1, int var2, int var3) {
      if(null != var0 && var0.vmethod781()) {
         if(var0 instanceof class34) {
            class39 var4 = ((class34)var0).field781;
            if(null != var4.field915) {
               var4 = var4.method793();
            }

            if(null == var4) {
               return;
            }
         }

         int var8 = class32.field751;
         int[] var5 = class32.field757;
         int var6;
         if(var1 < var8) {
            var6 = 30;
            class2 var7 = (class2)var0;
            if(var7.field43) {
               return;
            }

            if(-1 != var7.field39 || -1 != var7.field55) {
               class103.method2284(var0, var0.field867 + 15);
               if(client.field400 > -1) {
                  if(-1 != var7.field39) {
                     class44.field1044[var7.field39].method1699(var2 + client.field400 - 12, var3 + client.field401 - var6);
                     var6 += 25;
                  }

                  if(-1 != var7.field55) {
                     class2.field40[var7.field55].method1699(client.field400 + var2 - 12, var3 + client.field401 - var6);
                     var6 += 25;
                  }
               }
            }

            if(var1 >= 0 && 10 == client.field313 && var5[var1] == client.field406) {
               class103.method2284(var0, var0.field867 + 15);
               if(client.field400 > -1) {
                  class165.field2682[1].method1699(var2 + client.field400 - 12, var3 + client.field401 - var6);
               }
            }
         } else {
            class39 var10 = ((class34)var0).field781;
            if(null != var10.field915) {
               var10 = var10.method793();
            }

            if(var10.field913 >= 0 && var10.field913 < class2.field40.length) {
               class103.method2284(var0, var0.field867 + 15);
               if(client.field400 > -1) {
                  class2.field40[var10.field913].method1699(var2 + client.field400 - 12, client.field401 + var3 - 30);
               }
            }

            if(client.field313 == 1 && client.field447 == client.field333[var1 - var8] && client.field305 % 20 < 10) {
               class103.method2284(var0, var0.field867 + 15);
               if(client.field400 > -1) {
                  class165.field2682[0].method1699(client.field400 + var2 - 12, var3 + client.field401 - 28);
               }
            }
         }

         if(var0.field831 != null && (var1 >= var8 || !var0.field833 && (4 == client.field512 || !var0.field832 && (0 == client.field512 || 3 == client.field512 || 1 == client.field512 && class130.method2834(((class2)var0).field59, false))))) {
            class103.method2284(var0, var0.field867);
            if(client.field400 > -1 && client.field340 < client.field389) {
               client.field393[client.field340] = class89.field1561.method4032(var0.field831) / 2;
               client.field392[client.field340] = class89.field1561.field3194;
               client.field471[client.field340] = client.field400;
               client.field391[client.field340] = client.field401;
               client.field376[client.field340] = var0.field835;
               client.field567[client.field340] = var0.field871;
               client.field531[client.field340] = var0.field834;
               client.field397[client.field340] = var0.field831;
               ++client.field340;
            }
         }

         if(var0.field840 > client.field305) {
            class103.method2284(var0, var0.field867 + 15);
            if(client.field400 > -1) {
               if(var1 < var8) {
                  var6 = 30;
               } else {
                  class39 var9 = ((class34)var0).field781;
                  var6 = var9.field921;
               }

               int var11 = var6 * var0.field841 / var0.field848;
               if(var11 > var6) {
                  var11 = var6;
               } else if(var11 == 0 && var0.field841 > 0) {
                  var11 = 1;
               }

               class79.method1800(var2 + client.field400 - var6 / 2, var3 + client.field401 - 3, var11, 5, '\uff00');
               class79.method1800(client.field400 + var2 - var6 / 2 + var11, client.field401 + var3 - 3, var6 - var11, 5, 16711680);
            }
         }

         for(var6 = 0; var6 < 4; ++var6) {
            if(var0.field839[var6] > client.field305) {
               class103.method2284(var0, var0.field867 / 2);
               if(client.field400 > -1) {
                  if(1 == var6) {
                     client.field401 -= 20;
                  }

                  if(var6 == 2) {
                     client.field400 -= 15;
                     client.field401 -= 10;
                  }

                  if(var6 == 3) {
                     client.field400 += 15;
                     client.field401 -= 10;
                  }

                  class84.field1462[var0.field838[var6]].method1699(var2 + client.field400 - 12, var3 + client.field401 - 12);
                  class104.field1807.method4039(Integer.toString(var0.field865[var6]), client.field400 + var2 - 1, 3 + var3 + client.field401, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("v")
   public static class224 method2386(class167 var0, class167 var1, String var2, String var3) {
      int var4 = var0.method3303(var2);
      int var5 = var0.method3289(var4, var3);
      return class43.method951(var0, var1, var4, var5);
   }
}
