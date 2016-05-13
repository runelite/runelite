import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class11 {
   @ObfuscatedName("j")
   static final class198 field167 = new class198(1024);
   @ObfuscatedName("s")
   @Export("chatLineMap")
   static final Map field168 = new HashMap();
   @ObfuscatedName("g")
   static int[] field169;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1704934205
   )
   static int field170 = 0;
   @ObfuscatedName("p")
   static final class200 field171 = new class200();
   @ObfuscatedName("dn")
   static int[] field172;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "0"
   )
   static final void method137(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field554 + (client.field534 - client.field554) * var5 / 100;
      int var7 = 512 * var6 * var3 / (334 * var2);
      int var8;
      int var9;
      short var10;
      if(var7 < client.field401) {
         var10 = client.field401;
         var6 = 334 * var10 * var2 / (var3 * 512);
         if(var6 > client.field538) {
            var6 = client.field538;
            var8 = 512 * var6 * var3 / (334 * var10);
            var9 = (var2 - var8) / 2;
            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field540) {
         var10 = client.field540;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if(var6 < client.field323) {
            var6 = client.field323;
            var8 = var10 * var2 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = (client.field536 - client.field533) * var5 / 100 + client.field533;
      client.field555 = var8 * var6 * var3 / 85504 << 1;
      if(var2 != client.field472 || client.field383 != var3) {
         int[] var11 = new int[9];

         for(int var12 = 0; var12 < 9; ++var12) {
            int var13 = 32 * var12 + 128 + 15;
            int var14 = 600 + var13 * 3;
            int var15 = class91.field1596[var13];
            var11[var12] = var14 * var15 >> 16;
         }

         class86.method2002(var11, 500, 800, var2, var3);
      }

      client.field398 = var0;
      client.field542 = var1;
      client.field472 = var2;
      client.field383 = var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method138(boolean var0) {
      for(int var1 = 0; var1 < client.field317; ++var1) {
         class34 var2 = client.field515[client.field318[var1]];
         int var3 = 536870912 + (client.field318[var1] << 14);
         if(null != var2 && var2.vmethod727() && var2.field782.field907 == var0 && var2.field782.method739()) {
            int var4 = var2.field823 >> 7;
            int var5 = var2.field813 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field872 == 1 && (var2.field823 & 127) == 64 && 64 == (var2.field813 & 127)) {
                  if(client.field275 == client.field552[var4][var5]) {
                     continue;
                  }

                  client.field552[var4][var5] = client.field275;
               }

               if(!var2.field782.field915) {
                  var3 -= Integer.MIN_VALUE;
               }

               client.field339.method1906(class21.field581, var2.field823, var2.field813, class107.method2369(var2.field823 + (var2.field872 * 64 - 64), var2.field813 + (var2.field872 * 64 - 64), class21.field581), var2.field872 * 64 - 64 + 60, var2, var2.field814, var3, var2.field815);
            }
         }
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1651487880"
   )
   static final void method140() {
      class72.method1552();
      if(class25.field626 == null && null == client.field450) {
         int var4 = class140.field2159;
         int var0;
         int var1;
         int var2;
         int var3;
         int var5;
         int var6;
         if(client.field418) {
            if(1 != var4 && (class89.field1563 || var4 != 4)) {
               var5 = class140.field2162;
               var0 = class140.field2163;
               if(var5 < class39.field882 - 10 || var5 > 10 + class39.field882 + class172.field2749 || var0 < class7.field136 - 10 || var0 > 10 + class0.field0 + class7.field136) {
                  client.field418 = false;
                  class4.method41(class39.field882, class7.field136, class172.field2749, class0.field0);
               }
            }

            if(1 == var4 || !class89.field1563 && 4 == var4) {
               var5 = class39.field882;
               var0 = class7.field136;
               var1 = class172.field2749;
               int var11 = class140.field2169;
               int var12 = class140.field2170;
               var6 = -1;

               for(var2 = 0; var2 < client.field496; ++var2) {
                  var3 = 31 + var0 + 15 * (client.field496 - 1 - var2);
                  if(var11 > var5 && var11 < var1 + var5 && var12 > var3 - 13 && var12 < 3 + var3) {
                     var6 = var2;
                  }
               }

               if(-1 != var6) {
                  class151.method3122(var6);
               }

               client.field418 = false;
               class4.method41(class39.field882, class7.field136, class172.field2749, class0.field0);
            }

            return;
         }

         label204: {
            if((1 == var4 || !class89.field1563 && 4 == var4) && client.field496 > 0) {
               var5 = client.field422[client.field496 - 1];
               if(var5 == 39 || var5 == 40 || var5 == 41 || var5 == 42 || var5 == 43 || 33 == var5 || var5 == 34 || 35 == var5 || var5 == 36 || var5 == 37 || var5 == 38 || var5 == 1005) {
                  var0 = client.field420[client.field496 - 1];
                  var1 = client.field421[client.field496 - 1];
                  class173 var7 = class29.method645(var1);
                  var6 = class48.method962(var7);
                  boolean var8 = 0 != (var6 >> 28 & 1);
                  if(var8) {
                     break label204;
                  }

                  class178 var9 = (class178)null;
                  if(class45.method934(class48.method962(var7))) {
                     break label204;
                  }
               }
            }

            if((var4 == 1 || !class89.field1563 && 4 == var4) && (client.field545 == 1 && client.field496 > 2 || class33.method692(client.field496 - 1))) {
               var4 = 2;
            }

            if((1 == var4 || !class89.field1563 && var4 == 4) && client.field496 > 0) {
               class151.method3122(client.field496 - 1);
            }

            if(var4 == 2 && client.field496 > 0) {
               class39.method772(class140.field2169, class140.field2170);
            }

            return;
         }

         if(null != class25.field626 && !client.field397 && client.field545 != 1 && !class33.method692(client.field496 - 1) && client.field496 > 0) {
            var2 = client.field394;
            var3 = client.field395;
            class30 var10 = class16.field231;
            class13.method171(var10.field713, var10.field704, var10.field705, var10.field711, var10.field703, var10.field703, var2, var3);
            class16.field231 = null;
         }

         client.field397 = false;
         client.field417 = 0;
         if(class25.field626 != null) {
            class34.method701(class25.field626);
         }

         class25.field626 = class29.method645(var1);
         client.field359 = var0;
         client.field394 = class140.field2169;
         client.field395 = class140.field2170;
         if(client.field496 > 0) {
            class48.method973(client.field496 - 1);
         }

         class34.method701(class25.field626);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)[Lclass78;",
      garbageValue = "-287161123"
   )
   public static class78[] method152(class167 var0, String var1, String var2) {
      int var3 = var0.method3253(var1);
      int var4 = var0.method3254(var3, var2);
      class78[] var5;
      if(!class35.method714(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class87.method2064();
      }

      return var5;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "1998678148"
   )
   static final void method153(class37 var0) {
      int var1 = var0.field857 - client.field335;
      int var2 = var0.field853 * 128 + var0.field872 * 64;
      int var3 = var0.field872 * 64 + var0.field818 * 128;
      var0.field823 += (var2 - var0.field823) / var1;
      var0.field813 += (var3 - var0.field813) / var1;
      var0.field869 = 0;
      var0.field862 = var0.field836;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIILclass86;Lclass108;I)V",
      garbageValue = "-447266336"
   )
   static final void method154(int var0, int var1, int var2, int var3, int var4, int var5, int var6, class86 var7, class108 var8) {
      class40 var9 = class9.method120(var4);
      int var10;
      int var11;
      if(1 != var5 && 3 != var5) {
         var10 = var9.field939;
         var11 = var9.field966;
      } else {
         var10 = var9.field966;
         var11 = var9.field939;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = (1 + var10 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = 1 + var2;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = (var11 >> 1) + var3;
         var15 = (var11 + 1 >> 1) + var3;
      } else {
         var14 = var3;
         var15 = 1 + var3;
      }

      int[][] var16 = class5.field93[var1];
      int var17 = var16[var12][var15] + var16[var12][var14] + var16[var13][var14] + var16[var13][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var11 << 6) + (var3 << 7);
      int var20 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
      if(var9.field943 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = var6 + (var5 << 6);
      if(var9.field964 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(-1 == var9.field955 && null == var9.field965) {
            var22 = var9.method780(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 22, var5, var1, var2, var3, var9.field955, true, (class85)null);
         }

         var7.method2058(var0, var2, var3, var17, (class85)var22, var20, var21);
         if(1 == var9.field941) {
            var8.method2390(var2, var3);
         }
      } else if(10 != var6 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.field955 == -1 && null == var9.field965) {
               var22 = var9.method780(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field955, true, (class85)null);
            }

            var7.method1905(var0, var2, var3, var17, 1, 1, (class85)var22, 0, var20, var21);
            if(var9.field941 != 0) {
               var8.method2377(var2, var3, var10, var11, var9.field963);
            }
         } else if(0 == var6) {
            if(-1 == var9.field955 && null == var9.field965) {
               var22 = var9.method780(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 0, var5, var1, var2, var3, var9.field955, true, (class85)null);
            }

            var7.method1903(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field87[var5], 0, var20, var21);
            if(0 != var9.field941) {
               var8.method2376(var2, var3, var6, var5, var9.field963);
            }
         } else if(var6 == 1) {
            if(-1 == var9.field955 && null == var9.field965) {
               var22 = var9.method780(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 1, var5, var1, var2, var3, var9.field955, true, (class85)null);
            }

            var7.method1903(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field88[var5], 0, var20, var21);
            if(var9.field941 != 0) {
               var8.method2376(var2, var3, var6, var5, var9.field963);
            }
         } else {
            Object var23;
            int var24;
            if(var6 == 2) {
               var24 = var5 + 1 & 3;
               Object var25;
               if(-1 == var9.field955 && var9.field965 == null) {
                  var25 = var9.method780(2, 4 + var5, var16, var18, var17, var19);
                  var23 = var9.method780(2, var24, var16, var18, var17, var19);
               } else {
                  var25 = new class12(var4, 2, var5 + 4, var1, var2, var3, var9.field955, true, (class85)null);
                  var23 = new class12(var4, 2, var24, var1, var2, var3, var9.field955, true, (class85)null);
               }

               var7.method1903(var0, var2, var3, var17, (class85)var25, (class85)var23, class5.field87[var5], class5.field87[var24], var20, var21);
               if(var9.field941 != 0) {
                  var8.method2376(var2, var3, var6, var5, var9.field963);
               }
            } else if(3 == var6) {
               if(-1 == var9.field955 && var9.field965 == null) {
                  var22 = var9.method780(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 3, var5, var1, var2, var3, var9.field955, true, (class85)null);
               }

               var7.method1903(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field88[var5], 0, var20, var21);
               if(0 != var9.field941) {
                  var8.method2376(var2, var3, var6, var5, var9.field963);
               }
            } else if(9 == var6) {
               if(var9.field955 == -1 && null == var9.field965) {
                  var22 = var9.method780(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field955, true, (class85)null);
               }

               var7.method1905(var0, var2, var3, var17, 1, 1, (class85)var22, 0, var20, var21);
               if(0 != var9.field941) {
                  var8.method2377(var2, var3, var10, var11, var9.field963);
               }
            } else if(4 == var6) {
               if(-1 == var9.field955 && var9.field965 == null) {
                  var22 = var9.method780(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 4, var5, var1, var2, var3, var9.field955, true, (class85)null);
               }

               var7.method1904(var0, var2, var3, var17, (class85)var22, (class85)null, class5.field87[var5], 0, 0, 0, var20, var21);
            } else {
               int var28;
               if(var6 == 5) {
                  var24 = 16;
                  var28 = var7.method1964(var0, var2, var3);
                  if(var28 != 0) {
                     var24 = class9.method120(var28 >> 14 & 32767).field946;
                  }

                  if(var9.field955 == -1 && var9.field965 == null) {
                     var23 = var9.method780(4, var5, var16, var18, var17, var19);
                  } else {
                     var23 = new class12(var4, 4, var5, var1, var2, var3, var9.field955, true, (class85)null);
                  }

                  var7.method1904(var0, var2, var3, var17, (class85)var23, (class85)null, class5.field87[var5], 0, class5.field89[var5] * var24, class5.field85[var5] * var24, var20, var21);
               } else if(var6 == 6) {
                  var24 = 8;
                  var28 = var7.method1964(var0, var2, var3);
                  if(var28 != 0) {
                     var24 = class9.method120(var28 >> 14 & 32767).field946 / 2;
                  }

                  if(var9.field955 == -1 && null == var9.field965) {
                     var23 = var9.method780(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var23 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field955, true, (class85)null);
                  }

                  var7.method1904(var0, var2, var3, var17, (class85)var23, (class85)null, 256, var5, class5.field91[var5] * var24, var24 * class5.field92[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = 2 + var5 & 3;
                  if(-1 == var9.field955 && null == var9.field965) {
                     var22 = var9.method780(4, 4 + var28, var16, var18, var17, var19);
                  } else {
                     var22 = new class12(var4, 4, var28 + 4, var1, var2, var3, var9.field955, true, (class85)null);
                  }

                  var7.method1904(var0, var2, var3, var17, (class85)var22, (class85)null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var24 = 8;
                  var28 = var7.method1964(var0, var2, var3);
                  if(var28 != 0) {
                     var24 = class9.method120(var28 >> 14 & 32767).field946 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var27;
                  if(-1 == var9.field955 && var9.field965 == null) {
                     var23 = var9.method780(4, 4 + var5, var16, var18, var17, var19);
                     var27 = var9.method780(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var23 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field955, true, (class85)null);
                     var27 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field955, true, (class85)null);
                  }

                  var7.method1904(var0, var2, var3, var17, (class85)var23, (class85)var27, 256, var5, var24 * class5.field91[var5], class5.field92[var5] * var24, var20, var21);
               }
            }
         }
      } else {
         if(-1 == var9.field955 && var9.field965 == null) {
            var22 = var9.method780(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 10, var5, var1, var2, var3, var9.field955, true, (class85)null);
         }

         if(var22 != null) {
            var7.method1905(var0, var2, var3, var17, var10, var11, (class85)var22, 11 == var6?256:0, var20, var21);
         }

         if(0 != var9.field941) {
            var8.method2377(var2, var3, var10, var11, var9.field963);
         }
      }

   }
}
