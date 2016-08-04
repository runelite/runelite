import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("ChatMessages")
public class class19 {
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -2064338507
   )
   static int field275;
   @ObfuscatedName("r")
   boolean[] field276;
   @ObfuscatedName("ia")
   static class176 field278;
   @ObfuscatedName("s")
   @Export("messages")
   String[] field279;
   @ObfuscatedName("k")
   boolean field280 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 8145679604000701241L
   )
   long field281;
   @ObfuscatedName("em")
   static class81[] field283;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 1472241741
   )
   static int field286;
   @ObfuscatedName("e")
   boolean[] field288;
   @ObfuscatedName("h")
   int[] field289;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-378871676"
   )
   String method219(int var1) {
      return this.field279[var1];
   }

   class19() {
      this.field289 = new int[class78.field1448.method3405(19)];
      this.field279 = new String[class78.field1448.method3405(15)];
      this.field276 = new boolean[this.field289.length];

      int var1;
      for(var1 = 0; var1 < this.field289.length; ++var1) {
         class47 var2 = class111.method2533(var1);
         this.field276[var1] = var2.field1071;
      }

      this.field288 = new boolean[this.field279.length];

      for(var1 = 0; var1 < this.field279.length; ++var1) {
         class53 var3 = class29.method679(var1);
         this.field288[var1] = var3.field1166;
      }

      for(var1 = 0; var1 < this.field289.length; ++var1) {
         this.field289[var1] = -1;
      }

      this.method222();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-955955899"
   )
   int method220(int var1) {
      return this.field289[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass230;",
      garbageValue = "-2124001515"
   )
   class230 method221(boolean var1) {
      return class114.method2540("2", client.field298.field2346, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method222() {
      class230 var1 = this.method221(false);

      label203: {
         try {
            byte[] var2 = new byte[(int)var1.method4273()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4274(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class122 var13 = new class122(var2);
            if(var13.field2051.length - var13.field2050 < 1) {
               return;
            }

            int var14 = var13.method2633();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method2635();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2635();
                  var9 = var13.method2620();
                  if(this.field276[var8]) {
                     this.field289[var8] = var9;
                  }
               }

               var7 = var13.method2635();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label203;
                  }

                  var9 = var13.method2635();
                  String var10 = var13.method2663();
                  if(this.field288[var9]) {
                     this.field279[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label203;
         } finally {
            try {
               var1.method4283();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field280 = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "119"
   )
   void method223() {
      int var1;
      for(var1 = 0; var1 < this.field289.length; ++var1) {
         if(!this.field276[var1]) {
            this.field289[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field279.length; ++var1) {
         if(!this.field288[var1]) {
            this.field279[var1] = null;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-34"
   )
   void method224(int var1, String var2) {
      this.field279[var1] = var2;
      if(this.field288[var1]) {
         this.field280 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "73"
   )
   void method225() {
      class230 var1 = this.method221(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field289.length; ++var4) {
            if(this.field276[var4] && this.field289[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field279.length; ++var5) {
            if(this.field288[var5] && null != this.field279[var5]) {
               var2 += 2 + class54.method1165(this.field279[var5]);
               ++var4;
            }
         }

         class122 var9 = new class122(var2);
         var9.method2783(1);
         var9.method2619(var3);

         int var6;
         for(var6 = 0; var6 < this.field289.length; ++var6) {
            if(this.field276[var6] && this.field289[var6] != -1) {
               var9.method2619(var6);
               var9.method2728(this.field289[var6]);
            }
         }

         var9.method2619(var4);

         for(var6 = 0; var6 < this.field279.length; ++var6) {
            if(this.field288[var6] && null != this.field279[var6]) {
               var9.method2619(var6);
               var9.method2703(this.field279[var6]);
            }
         }

         var1.method4275(var9.field2051, 0, var9.field2050);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4283();
         } catch (Exception var16) {
            ;
         }

      }

      this.field280 = false;
      this.field281 = class56.method1249();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1715716233"
   )
   static void method226() {
      if(class33.field754) {
         class33.field760 = null;
         class33.field763 = null;
         class33.field744 = null;
         class33.field745 = null;
         class33.field746 = null;
         class106.field1847 = null;
         class33.field747 = null;
         class47.field1075 = null;
         class22.field596 = null;
         class32.field731 = null;
         class174.field2789 = null;
         class33.field773 = null;
         class48.field1081 = null;
         class33.field774 = null;
         class153.field2310 = null;
         class18.field269 = null;
         class33.field750 = null;
         class138.field2141 = null;
         class26.field649 = null;
         class144.field2226 = null;
         class29.field699 = null;
         class182.field2970 = null;
         class34.method755(2);
         class161.method3314(true);
         class33.field754 = false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method227() {
      if(this.field280 && this.field281 < class56.method1249() - 60000L) {
         this.method225();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "101"
   )
   boolean method228() {
      return this.field280;
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1733580720"
   )
   static final String[] method241(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "921799473"
   )
   static final void method246(int var0, int var1, int var2, int var3) {
      ++client.field400;
      class172.method3515(class35.field796);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field425 >= 0) {
         var5 = class34.field783;
         int[] var6 = class34.field784;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == client.field425) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class172.method3515(class35.field800);
      }

      class16.method206(true);
      class172.method3515(var4?class35.field798:class35.field797);
      class16.method206(false);

      for(class6 var20 = (class6)client.field428.method3980(); null != var20; var20 = (class6)client.field428.method3970()) {
         if(class99.field1701 == var20.field101 && client.field305 <= var20.field124) {
            if(client.field305 >= var20.field100) {
               if(var20.field110 > 0) {
                  class36 var21 = client.field332[var20.field110 - 1];
                  if(null != var21 && var21.field875 >= 0 && var21.field875 < 13312 && var21.field832 >= 0 && var21.field832 < 13312) {
                     var20.method98(var21.field875, var21.field832, class127.method2936(var21.field875, var21.field832, var20.field101) - var20.field105, client.field305);
                  }
               }

               if(var20.field110 < 0) {
                  var7 = -var20.field110 - 1;
                  class2 var22;
                  if(client.field417 == var7) {
                     var22 = class3.field65;
                  } else {
                     var22 = client.field302[var7];
                  }

                  if(var22 != null && var22.field875 >= 0 && var22.field875 < 13312 && var22.field832 >= 0 && var22.field832 < 13312) {
                     var20.method98(var22.field875, var22.field832, class127.method2936(var22.field875, var22.field832, var20.field101) - var20.field105, client.field305);
                  }
               }

               var20.method94(client.field370);
               class136.field2126.method2003(class99.field1701, (int)var20.field112, (int)var20.field113, (int)var20.field114, 60, var20, var20.field120, -1, false);
            }
         } else {
            var20.method4067();
         }
      }

      class62.method1397();
      class110.method2487(var0, var1, var2, var3, true);
      var0 = client.field556;
      var1 = client.field557;
      var2 = client.field558;
      var3 = client.field559;
      class82.method1908(var0, var1, var0 + var2, var1 + var3);
      class94.method2183();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var19;
      if(!client.field542) {
         var5 = client.field462;
         if(client.field540 / 256 > var5) {
            var5 = client.field540 / 256;
         }

         if(client.field331[4] && 128 + client.field393[4] > var5) {
            var5 = client.field393[4] + 128;
         }

         var19 = client.field362 + client.field399 & 2047;
         var7 = class37.field817;
         var8 = class127.method2936(class3.field65.field875, class3.field65.field832, class99.field1701) - client.field338;
         var9 = class167.field2710;
         var10 = 3 * var5 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var19 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = class94.field1661[var11];
            var17 = class94.field1662[var11];
            var18 = var14 * var17 - var10 * var16 >> 16;
            var15 = var16 * var14 + var10 * var17 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class94.field1661[var12];
            var17 = class94.field1662[var12];
            var18 = var17 * var13 + var15 * var16 >> 16;
            var15 = var15 * var17 - var16 * var13 >> 16;
            var13 = var18;
         }

         class151.field2282 = var7 - var13;
         class8.field149 = var8 - var14;
         class96.field1670 = var9 - var15;
         class102.field1759 = var5;
         class59.field1255 = var19;
      }

      if(!client.field542) {
         if(class136.field2123.field143) {
            var19 = class99.field1701;
         } else {
            label470: {
               var7 = 3;
               if(class102.field1759 < 310) {
                  var8 = class151.field2282 >> 7;
                  var9 = class96.field1670 >> 7;
                  var10 = class3.field65.field875 >> 7;
                  var11 = class3.field65.field832 >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var19 = class99.field1701;
                     break label470;
                  }

                  if((class5.field80[class99.field1701][var8][var9] & 4) != 0) {
                     var7 = class99.field1701;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var10 != var8) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class5.field80[class99.field1701][var8][var9] & 4) != 0) {
                           var7 = class99.field1701;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class5.field80[class99.field1701][var8][var9] & 4) != 0) {
                              var7 = class99.field1701;
                           }
                        }
                     }
                  } else {
                     var14 = 65536 * var12 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class5.field80[class99.field1701][var8][var9] & 4) != 0) {
                           var7 = class99.field1701;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class5.field80[class99.field1701][var8][var9] & 4) != 0) {
                              var7 = class99.field1701;
                           }
                        }
                     }
                  }
               }

               if(class3.field65.field875 >= 0 && class3.field65.field832 >= 0 && class3.field65.field875 < 13312 && class3.field65.field832 < 13312) {
                  if((class5.field80[class99.field1701][class3.field65.field875 >> 7][class3.field65.field832 >> 7] & 4) != 0) {
                     var7 = class99.field1701;
                  }

                  var19 = var7;
               } else {
                  var19 = class99.field1701;
               }
            }
         }

         var5 = var19;
      } else {
         if(class136.field2123.field143) {
            var19 = class99.field1701;
         } else {
            var7 = class127.method2936(class151.field2282, class96.field1670, class99.field1701);
            if(var7 - class8.field149 < 800 && (class5.field80[class99.field1701][class151.field2282 >> 7][class96.field1670 >> 7] & 4) != 0) {
               var19 = class99.field1701;
            } else {
               var19 = 3;
            }
         }

         var5 = var19;
      }

      var19 = class151.field2282;
      var7 = class8.field149;
      var8 = class96.field1670;
      var9 = class102.field1759;
      var10 = class59.field1255;

      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field331[var11]) {
            var12 = (int)(Math.random() * (double)(2 * client.field544[var11] + 1) - (double)client.field544[var11] + Math.sin((double)client.field547[var11] * ((double)client.field546[var11] / 100.0D)) * (double)client.field393[var11]);
            if(var11 == 0) {
               class151.field2282 += var12;
            }

            if(var11 == 1) {
               class8.field149 += var12;
            }

            if(var11 == 2) {
               class96.field1670 += var12;
            }

            if(var11 == 3) {
               class59.field1255 = var12 + class59.field1255 & 2047;
            }

            if(var11 == 4) {
               class102.field1759 += var12;
               if(class102.field1759 < 128) {
                  class102.field1759 = 128;
               }

               if(class102.field1759 > 383) {
                  class102.field1759 = 383;
               }
            }
         }
      }

      var11 = class143.field2206;
      var12 = class143.field2209;
      if(class143.field2217 != 0) {
         var11 = class143.field2215;
         var12 = class143.field2216;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         class108.field1924 = true;
         class108.field1931 = 0;
         class108.field1875 = var11 - var0;
         class108.field1926 = var12 - var1;
      } else {
         class108.field1924 = false;
         class108.field1931 = 0;
      }

      class47.method1009();
      class82.method1907(var0, var1, var2, var3, 0);
      class47.method1009();
      var13 = class94.field1660;
      class94.field1660 = client.field392;
      class136.field2126.method2011(class151.field2282, class8.field149, class96.field1670, class102.field1759, class59.field1255, var5);
      class94.field1660 = var13;
      class47.method1009();
      class136.field2126.method2006();
      class31.method698(var0, var1, var2, var3);
      if(client.field313 == 2) {
         class35.method756(client.field375 + (client.field316 - class0.field11 << 7), (client.field317 - class21.field592 << 7) + client.field384, client.field517 * 2);
         if(client.field401 > -1 && client.field305 % 20 < 10) {
            class158.field2353[0].method1824(var0 + client.field401 - 12, client.field402 + var1 - 28);
         }
      }

      ((class98)class94.field1658).method2264(client.field370);
      if(client.field406 == 1) {
         class130.field2101[client.field537 / 100].method1824(client.field480 - 8, client.field404 - 8);
      }

      if(client.field406 == 2) {
         class130.field2101[client.field537 / 100 + 4].method1824(client.field480 - 8, client.field404 - 8);
      }

      class98.method2283();
      class151.field2282 = var19;
      class8.field149 = var7;
      class96.field1670 = var8;
      class102.field1759 = var9;
      class59.field1255 = var10;
      if(client.field304 && class172.method3513(true, false) == 0) {
         client.field304 = false;
      }

      if(client.field304) {
         class82.method1907(var0, var1, var2, var3, 0);
         class9.method131("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "-846244703"
   )
   static final void method253(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field229 == 0) {
         var1 = class136.field2126.method1998(var0.field239, var0.field238, var0.field231);
      }

      if(var0.field229 == 1) {
         var1 = class136.field2126.method2018(var0.field239, var0.field238, var0.field231);
      }

      if(var0.field229 == 2) {
         var1 = class136.field2126.method2019(var0.field239, var0.field238, var0.field231);
      }

      if(var0.field229 == 3) {
         var1 = class136.field2126.method2014(var0.field239, var0.field238, var0.field231);
      }

      if(var1 != 0) {
         int var5 = class136.field2126.method2081(var0.field239, var0.field238, var0.field231, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field232 = var2;
      var0.field228 = var3;
      var0.field233 = var4;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "375489337"
   )
   void method254(int var1, int var2) {
      this.field289[var1] = var2;
      if(this.field276[var1]) {
         this.field280 = true;
      }

   }
}
