import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("f")
public final class class16 extends class211 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -996474489
   )
   int field207;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1023944127
   )
   int field208;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1115257267
   )
   int field209;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1573392269
   )
   int field210;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1711318265
   )
   int field211;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 638141657
   )
   int field212;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -199512447
   )
   int field213;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1273249529
   )
   int field214;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -761631723
   )
   int field215;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1641066943
   )
   int field217 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1806063937
   )
   int field218;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1431002003
   )
   static int field219;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 757428303
   )
   int field221 = -1;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "-63857075"
   )
   static void method179(class2 var0, int var1, int var2) {
      if(var0.field884 == var1 && var1 != -1) {
         int var3 = class28.method646(var1).field1022;
         if(var3 == 1) {
            var0.field863 = 0;
            var0.field862 = 0;
            var0.field865 = var2;
            var0.field866 = 0;
         }

         if(var3 == 2) {
            var0.field866 = 0;
         }
      } else if(var1 == -1 || var0.field884 == -1 || class28.method646(var1).field1005 >= class28.method646(var0.field884).field1005) {
         var0.field884 = var1;
         var0.field863 = 0;
         var0.field862 = 0;
         var0.field865 = var2;
         var0.field866 = 0;
         var0.field851 = var0.field875;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass44;IIII)V",
      garbageValue = "-64182883"
   )
   static void method180(class44 var0, int var1, int var2, int var3) {
      if(client.field274 < 50 && client.field511 != 0) {
         if(null != var0.field1010 && var1 < var0.field1010.length) {
            int var4 = var0.field1010[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field513[client.field274] = var5;
               client.field346[client.field274] = var6;
               client.field434[client.field274] = 0;
               client.field450[client.field274] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field288[client.field274] = (var9 << 8) + (var8 << 16) + var7;
               ++client.field274;
            }
         }
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "783547440"
   )
   static void method181() {
      client var0 = client.field270;
      synchronized(client.field270) {
         Container var1 = client.field270.method3103();
         if(var1 != null) {
            class128.field2092 = Math.max(var1.getSize().width, class13.field176);
            class112.field1962 = Math.max(var1.getSize().height, class27.field662);
            if(class39.field835 == var1) {
               Insets var2 = class39.field835.getInsets();
               class128.field2092 -= var2.left + var2.right;
               class112.field1962 -= var2.bottom + var2.top;
            }

            if(class128.field2092 <= 0) {
               class128.field2092 = 1;
            }

            if(class112.field1962 <= 0) {
               class112.field1962 = 1;
            }

            int var9 = client.field360?2:1;
            if(var9 == 1) {
               class12.field174 = client.field485;
               class19.field264 = client.field486 * 503;
            } else {
               class12.field174 = Math.min(class128.field2092, 7680);
               class19.field264 = Math.min(class112.field1962, 2160);
            }

            class147.field2262 = (class128.field2092 - class12.field174) / 2;
            class147.field2263 = 0;
            class112.field1965.setSize(class12.field174, class19.field264);
            class78.field1454 = class49.method1043(class12.field174, class19.field264, class112.field1965);
            if(class39.field835 == var1) {
               Insets var3 = class39.field835.getInsets();
               class112.field1965.setLocation(class147.field2262 + var3.left, class147.field2263 + var3.top);
            } else {
               class112.field1965.setLocation(class147.field2262, class147.field2263);
            }

            int var10 = class12.field174;
            int var4 = class19.field264;
            if(class128.field2092 < var10) {
               var10 = class128.field2092;
            }

            if(class112.field1962 < var4) {
               var4 = class112.field1962;
            }

            if(null != class12.field162) {
               try {
                  client var5 = client.field270;
                  int var6 = client.field360?2:1;
                  Object[] var7 = new Object[]{Integer.valueOf(var6)};
                  JSObject.getWindow(var5).call("resize", var7);
               } catch (Throwable var12) {
                  ;
               }
            }

            if(client.field430 != -1) {
               var10 = client.field430;
               var4 = class12.field174;
               int var11 = class19.field264;
               if(class122.method2739(var10)) {
                  class6.method93(class176.field2814[var10], -1, var4, var11, true);
               }
            }

            class7.method102();
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILclass110;Lclass111;I)Z",
      garbageValue = "1933774005"
   )
   static final boolean method182(int var0, int var1, class110 var2, class111 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1936[var6][var7] = 99;
      class109.field1930[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1933[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1927[var10001] = var1;
      int[][] var12 = var3.field1954;

      while(var18 != var11) {
         var4 = class109.field1933[var11];
         var5 = class109.field1927[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1951;
         int var14 = var5 - var3.field1952;
         if(var2.vmethod2446(1, var4, var5, var3)) {
            class109.field1934 = var4;
            class109.field1932 = var5;
            return true;
         }

         int var15 = 1 + class109.field1930[var16][var17];
         if(var16 > 0 && class109.field1936[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class109.field1933[var18] = var4 - 1;
            class109.field1927[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1936[var16 - 1][var17] = 2;
            class109.field1930[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class109.field1936[1 + var16][var17] == 0 && (var12[1 + var13][var14] & 19136896) == 0) {
            class109.field1933[var18] = 1 + var4;
            class109.field1927[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1936[var16 + 1][var17] = 8;
            class109.field1930[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1936[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1933[var18] = var4;
            class109.field1927[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1936[var16][var17 - 1] = 1;
            class109.field1930[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class109.field1936[var16][1 + var17] == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1933[var18] = var4;
            class109.field1927[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1936[var16][var17 + 1] = 4;
            class109.field1930[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1936[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1933[var18] = var4 - 1;
            class109.field1927[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1936[var16 - 1][var17 - 1] = 3;
            class109.field1930[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class109.field1936[1 + var16][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1933[var18] = var4 + 1;
            class109.field1927[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1936[1 + var16][var17 - 1] = 9;
            class109.field1930[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class109.field1936[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1933[var18] = var4 - 1;
            class109.field1927[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1936[var16 - 1][var17 + 1] = 6;
            class109.field1930[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class109.field1936[var16 + 1][1 + var17] == 0 && (var12[1 + var13][1 + var14] & 19136992) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class109.field1933[var18] = var4 + 1;
            class109.field1927[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class109.field1936[var16 + 1][1 + var17] = 12;
            class109.field1930[var16 + 1][1 + var17] = var15;
         }
      }

      class109.field1934 = var4;
      class109.field1932 = var5;
      return false;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-23278"
   )
   static final int method183() {
      if(class12.field162.field127) {
         return class51.field1119;
      } else {
         int var0 = 3;
         if(class31.field717 < 310) {
            int var1 = class9.field144 >> 7;
            int var2 = class59.field1256 >> 7;
            int var3 = class114.field2010.field864 >> 7;
            int var4 = class114.field2010.field831 >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class51.field1119;
            }

            if((class5.field78[class51.field1119][var1][var2] & 4) != 0) {
               var0 = class51.field1119;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = 65536 * var6 / var5;
               var8 = '耀';

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class5.field78[class51.field1119][var1][var2] & 4) != 0) {
                     var0 = class51.field1119;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class5.field78[class51.field1119][var1][var2] & 4) != 0) {
                        var0 = class51.field1119;
                     }
                  }
               }
            } else {
               var7 = 65536 * var5 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class5.field78[class51.field1119][var1][var2] & 4) != 0) {
                     var0 = class51.field1119;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class5.field78[class51.field1119][var1][var2] & 4) != 0) {
                        var0 = class51.field1119;
                     }
                  }
               }
            }
         }

         if(class114.field2010.field864 >= 0 && class114.field2010.field831 >= 0 && class114.field2010.field864 < 13312 && class114.field2010.field831 < 13312) {
            if((class5.field78[class51.field1119][class114.field2010.field864 >> 7][class114.field2010.field831 >> 7] & 4) != 0) {
               var0 = class51.field1119;
            }

            return var0;
         } else {
            return class51.field1119;
         }
      }
   }
}
