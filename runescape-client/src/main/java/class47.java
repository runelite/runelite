import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class47 extends class204 {
   @ObfuscatedName("lv")
   static class130 field1077;
   @ObfuscatedName("f")
   static class167 field1078;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 369365905
   )
   public int field1079;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 754595825
   )
   public int field1080;
   @ObfuscatedName("u")
   static class193 field1081 = new class193(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1978701891
   )
   public int field1083;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1296503486"
   )
   void method1023(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1083 = var1.method2556();
         this.field1079 = var1.method2554();
         this.field1080 = var1.method2554();
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-2042333111"
   )
   static void method1024(class173 var0) {
      class173 var1 = var0.field2773 == -1?null:class153.method3177(var0.field2773);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class30.field708;
         var3 = class153.field2274;
      } else {
         var2 = var1.field2769;
         var3 = var1.field2888;
      }

      class2.method42(var0, var2, var3, false);
      class98.method2265(var0, var2, var3);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "732308874"
   )
   static final void method1028() {
      for(int var0 = 0; var0 < client.field494; ++var0) {
         int var1 = client.field330[var0];
         class34 var2 = client.field328[var1];
         if(null != var2) {
            class6.method106(var2, var2.field782.field907);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIILclass86;Lclass108;I)V",
      garbageValue = "1949199035"
   )
   static final void method1036(int var0, int var1, int var2, int var3, int var4, int var5, int var6, class86 var7, class108 var8) {
      class40 var9 = class150.method3166(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.field945;
         var11 = var9.field937;
      } else {
         var10 = var9.field937;
         var11 = var9.field945;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = var2 + (var10 >> 1);
         var13 = (var10 + 1 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (1 + var11 >> 1);
      } else {
         var14 = var3;
         var15 = 1 + var3;
      }

      int[][] var16 = class5.field99[var1];
      int var17 = var16[var13][var15] + var16[var12][var15] + var16[var12][var14] + var16[var13][var14] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var11 << 6) + (var3 << 7);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.field955 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = var6 + (var5 << 6);
      if(var9.field976 == 1) {
         var21 += 256;
      }

      Object var27;
      if(var6 == 22) {
         if(var9.field959 == -1 && null == var9.field947) {
            var27 = var9.method847(22, var5, var16, var18, var17, var19);
         } else {
            var27 = new class12(var4, 22, var5, var1, var2, var3, var9.field959, true, (class85)null);
         }

         var7.method1981(var0, var2, var3, var17, (class85)var27, var20, var21);
         if(var9.field953 == 1) {
            var8.method2434(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.field959 == -1 && null == var9.field947) {
               var27 = var9.method847(var6, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, var6, var5, var1, var2, var3, var9.field959, true, (class85)null);
            }

            var7.method2135(var0, var2, var3, var17, 1, 1, (class85)var27, 0, var20, var21);
            if(var9.field953 != 0) {
               var8.method2462(var2, var3, var10, var11, var9.field954);
            }

         } else if(var6 == 0) {
            if(var9.field959 == -1 && null == var9.field947) {
               var27 = var9.method847(0, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, 0, var5, var1, var2, var3, var9.field959, true, (class85)null);
            }

            var7.method2071(var0, var2, var3, var17, (class85)var27, (class85)null, class5.field91[var5], 0, var20, var21);
            if(var9.field953 != 0) {
               var8.method2433(var2, var3, var6, var5, var9.field954);
            }

         } else if(var6 == 1) {
            if(var9.field959 == -1 && null == var9.field947) {
               var27 = var9.method847(1, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, 1, var5, var1, var2, var3, var9.field959, true, (class85)null);
            }

            var7.method2071(var0, var2, var3, var17, (class85)var27, (class85)null, class5.field92[var5], 0, var20, var21);
            if(var9.field953 != 0) {
               var8.method2433(var2, var3, var6, var5, var9.field954);
            }

         } else {
            int var22;
            Object var24;
            if(var6 == 2) {
               var22 = 1 + var5 & 3;
               Object var28;
               if(var9.field959 == -1 && null == var9.field947) {
                  var28 = var9.method847(2, 4 + var5, var16, var18, var17, var19);
                  var24 = var9.method847(2, var22, var16, var18, var17, var19);
               } else {
                  var28 = new class12(var4, 2, var5 + 4, var1, var2, var3, var9.field959, true, (class85)null);
                  var24 = new class12(var4, 2, var22, var1, var2, var3, var9.field959, true, (class85)null);
               }

               var7.method2071(var0, var2, var3, var17, (class85)var28, (class85)var24, class5.field91[var5], class5.field91[var22], var20, var21);
               if(var9.field953 != 0) {
                  var8.method2433(var2, var3, var6, var5, var9.field954);
               }

            } else if(var6 == 3) {
               if(var9.field959 == -1 && null == var9.field947) {
                  var27 = var9.method847(3, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, 3, var5, var1, var2, var3, var9.field959, true, (class85)null);
               }

               var7.method2071(var0, var2, var3, var17, (class85)var27, (class85)null, class5.field92[var5], 0, var20, var21);
               if(var9.field953 != 0) {
                  var8.method2433(var2, var3, var6, var5, var9.field954);
               }

            } else if(var6 == 9) {
               if(var9.field959 == -1 && var9.field947 == null) {
                  var27 = var9.method847(var6, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, var6, var5, var1, var2, var3, var9.field959, true, (class85)null);
               }

               var7.method2135(var0, var2, var3, var17, 1, 1, (class85)var27, 0, var20, var21);
               if(var9.field953 != 0) {
                  var8.method2462(var2, var3, var10, var11, var9.field954);
               }

            } else if(var6 == 4) {
               if(var9.field959 == -1 && null == var9.field947) {
                  var27 = var9.method847(4, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, 4, var5, var1, var2, var3, var9.field959, true, (class85)null);
               }

               var7.method2075(var0, var2, var3, var17, (class85)var27, (class85)null, class5.field91[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var22 = 16;
                  var23 = var7.method2001(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class150.method3166(var23 >> 14 & 32767).field960;
                  }

                  if(var9.field959 == -1 && var9.field947 == null) {
                     var24 = var9.method847(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5, var1, var2, var3, var9.field959, true, (class85)null);
                  }

                  var7.method2075(var0, var2, var3, var17, (class85)var24, (class85)null, class5.field91[var5], 0, class5.field93[var5] * var22, class5.field94[var5] * var22, var20, var21);
               } else if(var6 == 6) {
                  var22 = 8;
                  var23 = var7.method2001(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class150.method3166(var23 >> 14 & 32767).field960 / 2;
                  }

                  if(var9.field959 == -1 && var9.field947 == null) {
                     var24 = var9.method847(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5 + 4, var1, var2, var3, var9.field959, true, (class85)null);
                  }

                  var7.method2075(var0, var2, var3, var17, (class85)var24, (class85)null, 256, var5, class5.field95[var5] * var22, var22 * class5.field102[var5], var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.field959 == -1 && var9.field947 == null) {
                     var27 = var9.method847(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var27 = new class12(var4, 4, 4 + var23, var1, var2, var3, var9.field959, true, (class85)null);
                  }

                  var7.method2075(var0, var2, var3, var17, (class85)var27, (class85)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var22 = 8;
                  var23 = var7.method2001(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class150.method3166(var23 >> 14 & 32767).field960 / 2;
                  }

                  int var26 = 2 + var5 & 3;
                  Object var25;
                  if(var9.field959 == -1 && var9.field947 == null) {
                     var24 = var9.method847(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method847(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5 + 4, var1, var2, var3, var9.field959, true, (class85)null);
                     var25 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field959, true, (class85)null);
                  }

                  var7.method2075(var0, var2, var3, var17, (class85)var24, (class85)var25, 256, var5, var22 * class5.field95[var5], class5.field102[var5] * var22, var20, var21);
               }
            }
         }
      } else {
         if(var9.field959 == -1 && null == var9.field947) {
            var27 = var9.method847(10, var5, var16, var18, var17, var19);
         } else {
            var27 = new class12(var4, 10, var5, var1, var2, var3, var9.field959, true, (class85)null);
         }

         if(var27 != null) {
            var7.method2135(var0, var2, var3, var17, var10, var11, (class85)var27, var6 == 11?256:0, var20, var21);
         }

         if(var9.field953 != 0) {
            var8.method2462(var2, var3, var10, var11, var9.field954);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;S)V",
      garbageValue = "128"
   )
   void method1037(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method1023(var1, var2);
      }
   }
}
