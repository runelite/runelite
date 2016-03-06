import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cw")
public final class class103 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1008386273
   )
   int field1781;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1419943171
   )
   int field1782;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2013654199
   )
   int field1783;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2126279311
   )
   int field1785;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -782033585
   )
   int field1786;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -335916017
   )
   int field1787;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -5985733
   )
   int field1788;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -544026571
   )
   int field1790;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -10164361
   )
   int field1791;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -640438917
   )
   int field1792;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 321318345
   )
   int field1793;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1090464447
   )
   int field1794;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2105147841
   )
   int field1795;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2042739431
   )
   int field1796;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -258262009
   )
   int field1797;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -499731217
   )
   int field1798;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1916380713
   )
   int field1799;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1961757689
   )
   int field1800;

   @ObfuscatedName("ae")
   static final void method2255(class37 var0, int var1, int var2, int var3) {
      if(null != var0 && var0.vmethod753()) {
         if(var0 instanceof class34) {
            class39 var4 = ((class34)var0).field779;
            if(var4.field909 != null) {
               var4 = var4.method789();
            }

            if(var4 == null) {
               return;
            }
         }

         int var8 = class32.field749;
         int[] var5 = class32.field755;
         int var6;
         if(var1 < var8) {
            var6 = 30;
            class2 var7 = (class2)var0;
            if(var7.field54) {
               return;
            }

            if(var7.field41 != -1 || var7.field36 != -1) {
               class183.method3663(var0, 15 + var0.field843);
               if(client.field358 * -1 > -1) {
                  if(var7.field41 != -1) {
                     class30.field695[var7.field41].method1706(client.field358 * -1 + var2 - 12, client.field396 * -1 + var3 - var6);
                     var6 += 25;
                  }

                  if(var7.field36 != -1) {
                     class4.field74[var7.field36].method1706(var2 + client.field358 * -1 - 12, var3 + client.field396 * -1 - var6);
                     var6 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field351 == 10 && var5[var1] == client.field307) {
               class183.method3663(var0, var0.field843 + 15);
               if(client.field358 * -1 > -1) {
                  class74.field1378[1].method1706(var2 + client.field358 * -1 - 12, client.field396 * -1 + var3 - var6);
               }
            }
         } else {
            class39 var10 = ((class34)var0).field779;
            if(null != var10.field909) {
               var10 = var10.method789();
            }

            if(var10.field903 >= 0 && var10.field903 < class4.field74.length) {
               class183.method3663(var0, 15 + var0.field843);
               if(client.field358 * -1 > -1) {
                  class4.field74[var10.field903].method1706(var2 + client.field358 * -1 - 12, client.field396 * -1 + var3 - 30);
               }
            }

            if(client.field351 == 1 && client.field306 == client.field326[var1 - var8] && client.field394 % 20 < 10) {
               class183.method3663(var0, 15 + var0.field843);
               if(client.field358 * -1 > -1) {
                  class74.field1378[0].method1706(var2 + client.field358 * -1 - 12, var3 + client.field396 * -1 - 28);
               }
            }
         }

         if(var0.field823 != null && (var1 >= var8 || !var0.field825 && (client.field506 == 4 || !var0.field842 && (0 == client.field506 || client.field506 == 3 || client.field506 == 1 && class132.method2791(((class2)var0).field48, false))))) {
            class183.method3663(var0, var0.field843);
            if(client.field358 * -1 > -1 && client.field383 < client.field384) {
               client.field388[client.field383] = class1.field28.method3962(var0.field823) / 2;
               client.field387[client.field383] = class1.field28.field3182;
               client.field478[client.field383] = client.field358 * -1;
               client.field356[client.field383] = client.field396 * -1;
               client.field389[client.field383] = var0.field859;
               client.field390[client.field383] = var0.field828;
               client.field391[client.field383] = var0.field826;
               client.field550[client.field383] = var0.field823;
               ++client.field383;
            }
         }

         if(var0.field849 > client.field394) {
            class183.method3663(var0, 15 + var0.field843);
            if(client.field358 * -1 > -1) {
               if(var1 < var8) {
                  var6 = 30;
               } else {
                  class39 var9 = ((class34)var0).field779;
                  var6 = var9.field915;
               }

               int var11 = var0.field812 * var6 / var0.field834;
               if(var11 > var6) {
                  var11 = var6;
               } else if(0 == var11 && var0.field812 > 0) {
                  var11 = 1;
               }

               class79.method1776(client.field358 * -1 + var2 - var6 / 2, var3 + client.field396 * -1 - 3, var11, 5, '\uff00');
               class79.method1776(var2 + client.field358 * -1 - var6 / 2 + var11, var3 + client.field396 * -1 - 3, var6 - var11, 5, 16711680);
            }
         }

         for(var6 = 0; var6 < 4; ++var6) {
            if(var0.field831[var6] > client.field394) {
               class183.method3663(var0, var0.field843 / 2);
               if(client.field358 * -1 > -1) {
                  if(var6 == 1) {
                     client.field396 -= -20;
                  }

                  if(var6 == 2) {
                     client.field358 -= -15;
                     client.field396 -= -10;
                  }

                  if(var6 == 3) {
                     client.field358 += -15;
                     client.field396 -= -10;
                  }

                  class18.field265[var0.field830[var6]].method1706(var2 + client.field358 * -1 - 12, var3 + client.field396 * -1 - 12);
                  class0.field4.method4039(Integer.toString(var0.field863[var6]), client.field358 * -1 + var2 - 1, 3 + client.field396 * -1 + var3, 16777215, 0);
               }
            }
         }

      }
   }
}
