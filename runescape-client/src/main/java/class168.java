import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class168 {
   @ObfuscatedName("m")
   static final char[] field2720 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "-77"
   )
   public static int method3292(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "66"
   )
   static final void method3293(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class122.method2739(var0)) {
         class20.field563 = null;
         class49.method1045(class176.field2814[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class20.field563 != null) {
            class49.method1045(class20.field563, -1412584499, var1, var2, var3, var4, class4.field68, client.field554, var7);
            class20.field563 = null;
         }

      } else {
         if(var7 != -1) {
            client.field460[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field460[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "987411858"
   )
   static final void method3294(class125 var0) {
      for(int var1 = 0; var1 < class34.field782; ++var1) {
         int var2 = class34.field783[var1];
         class2 var3 = client.field393[var2];
         int var4 = var0.method2556();
         if((var4 & 2) != 0) {
            var4 += var0.method2556() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 8) != 0) {
            var6 = var0.method2556();
            byte[] var7 = new byte[var6];
            class122 var8 = new class122(var7);
            var0.method2583(var7, 0, var6);
            class34.field775[var2] = var8;
            var3.method12(var8);
         }

         int var17;
         if((var4 & 64) != 0) {
            var6 = var0.method2706();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var17 = var0.method2556();
            class16.method179(var3, var6, var17);
         }

         if((var4 & 32) != 0) {
            var3.field856 = var0.method2706();
            if(var3.field856 == '\uffff') {
               var3.field856 = -1;
            }
         }

         if((var4 & 128) != 0) {
            var3.field843 = var0.method2580();
            if(var3.field843.charAt(0) == 126) {
               var3.field843 = var3.field843.substring(1);
               class59.method1304(2, var3.field43, var3.field843);
            } else if(var3 == class114.field2010) {
               class59.method1304(2, var3.field43, var3.field843);
            }

            var3.field844 = false;
            var3.field833 = 0;
            var3.field889 = 0;
            var3.field890 = 150;
         }

         int var9;
         int var10;
         int var13;
         if((var4 & 4) != 0) {
            var6 = var0.method2556();
            int var11;
            int var18;
            int var19;
            if(var6 > 0) {
               for(var17 = 0; var17 < var6; ++var17) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var18 = var0.method2585();
                  if(var18 == 32767) {
                     var18 = var0.method2585();
                     var10 = var0.method2585();
                     var9 = var0.method2585();
                     var11 = var0.method2585();
                  } else if(var18 != 32766) {
                     var10 = var0.method2585();
                  } else {
                     var18 = -1;
                  }

                  var19 = var0.method2585();
                  var3.method772(var18, var10, var9, var11, client.field282, var19);
               }
            }

            var17 = var0.method2556();
            if(var17 > 0) {
               for(var18 = 0; var18 < var17; ++var18) {
                  var9 = var0.method2585();
                  var10 = var0.method2585();
                  if(var10 != 32767) {
                     var11 = var0.method2585();
                     var19 = var0.method2556();
                     var13 = var10 > 0?var0.method2556():var19;
                     var3.method773(var9, client.field282, var10, var11, var19, var13);
                  } else {
                     var3.method774(var9);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var3.field867 = var0.method2706();
            if(var3.field875 == 0) {
               var3.field881 = var3.field867;
               var3.field867 = -1;
            }
         }

         if((var4 & 16) != 0) {
            var6 = var0.method2706();
            class155 var20 = (class155)class5.method77(class142.method3000(), var0.method2556());
            boolean var23 = var0.method2556() == 1;
            var9 = var0.method2556();
            var10 = var0.field2045;
            if(null != var3.field43 && var3.field50 != null) {
               boolean var22 = false;
               if(var20.field2319 && class53.method1118(var3.field43)) {
                  var22 = true;
               }

               if(!var22 && client.field392 == 0 && !var3.field56) {
                  class34.field786.field2045 = 0;
                  var0.method2583(class34.field786.field2047, 0, var9);
                  class34.field786.field2045 = 0;
                  String var12 = class226.method4098(class51.method1093(class224.method4081(class34.field786)));
                  var3.field843 = var12.trim();
                  var3.field833 = var6 >> 8;
                  var3.field889 = var6 & 255;
                  var3.field890 = 150;
                  var3.field844 = var23;
                  var3.field830 = class114.field2010 != var3 && var20.field2319 && "" != client.field490 && var12.toLowerCase().indexOf(client.field490) == -1;
                  if(var20.field2326) {
                     var13 = var23?91:1;
                  } else {
                     var13 = var23?90:2;
                  }

                  if(var20.field2323 != -1) {
                     int var16 = var20.field2323;
                     String var15 = "<img=" + var16 + ">";
                     class59.method1304(var13, var15 + var3.field43, var12);
                  } else {
                     class59.method1304(var13, var3.field43, var12);
                  }
               }
            }

            var0.field2045 = var9 + var10;
         }

         if((var4 & 4096) != 0) {
            var3.field834 = var0.method2706();
            var6 = var0.method2577();
            var3.field871 = var6 >> 16;
            var3.field870 = client.field282 + (var6 & '\uffff');
            var3.field868 = 0;
            var3.field869 = 0;
            if(var3.field870 > client.field282) {
               var3.field868 = -1;
            }

            if(var3.field834 == '\uffff') {
               var3.field834 = -1;
            }
         }

         if((var4 & 1024) != 0) {
            var3.field872 = var0.method2573();
            var3.field874 = var0.method2573();
            var3.field873 = var0.method2573();
            var3.field836 = var0.method2573();
            var3.field852 = var0.method2706() + client.field282;
            var3.field877 = var0.method2706() + client.field282;
            var3.field846 = var0.method2706();
            if(var3.field59) {
               var3.field872 += var3.field60;
               var3.field874 += var3.field61;
               var3.field873 += var3.field60;
               var3.field836 += var3.field61;
               var3.field875 = 0;
            } else {
               var3.field872 += var3.field885[0];
               var3.field874 += var3.field886[0];
               var3.field873 += var3.field885[0];
               var3.field836 += var3.field886[0];
               var3.field875 = 1;
            }

            var3.field851 = 0;
         }

         if((var4 & 2048) != 0) {
            class34.field773[var2] = var0.method2573();
         }

         if((var4 & 512) != 0) {
            var5 = var0.method2573();
         }

         if((var4 & 256) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.field58[var6] = var0.method2580();
            }
         }

         if(var3.field59) {
            if(var5 == 127) {
               var3.method17(var3.field60, var3.field61);
            } else {
               byte var21;
               if(var5 != -1) {
                  var21 = var5;
               } else {
                  var21 = class34.field773[var2];
               }

               var3.method16(var3.field60, var3.field61, var21);
            }
         }
      }

   }
}
