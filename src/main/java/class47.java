import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class47 extends class204 {
   @ObfuscatedName("w")
   public static class193 field1073 = new class193(64);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1513730991
   )
   public int field1074;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -382668047
   )
   public int field1075;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1527946221
   )
   public int field1076;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-166676801"
   )
   public void method1071(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(var2 == 0) {
            return;
         }

         this.method1072(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;IS)V",
      garbageValue = "21733"
   )
   void method1072(class119 var1, int var2) {
      if(1 == var2) {
         this.field1074 = var1.method2615();
         this.field1075 = var1.method2613();
         this.field1076 = var1.method2613();
      }

   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-95"
   )
   static final void method1079(int var0) {
      if(class9.method161(var0)) {
         class173[] var1 = class173.field2886[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class173 var3 = var1[var2];
            if(var3 != null) {
               var3.field2771 = 0;
               var3.field2856 = 0;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;I)V",
      garbageValue = "-1760332640"
   )
   static final void method1083(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field302 || 0 != (class5.field82[0][var1][var2] & 2) || 0 == (class5.field82[var0][var1][var2] & 16)) {
         if(var0 < class5.field87) {
            class5.field87 = var0;
         }

         class40 var8 = class133.method2969(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field938;
            var10 = var8.field939;
         } else {
            var9 = var8.field939;
            var10 = var8.field938;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.field94[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var3 << 14) + var1 + (var2 << 7);
         if(0 == var8.field942) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field963 == 1) {
            var20 += 256;
         }

         if(var8.method900()) {
            class11.method175(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(22 == var5) {
            if(!client.field302 || var8.field942 != 0 || var8.field940 == 1 || var8.field961) {
               if(var8.field959 == -1 && null == var8.field925) {
                  var21 = var8.method895(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 22, var4, var0, var1, var2, var8.field959, true, (class85)null);
               }

               var6.method2014(var0, var1, var2, var16, (class85)var21, var19, var20);
               if(var8.field940 == 1 && null != var7) {
                  var7.method2492(var1, var2);
               }

            }
         } else {
            int var22;
            if(10 != var5 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field959 == -1 && null == var8.field925) {
                     var21 = var8.method895(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2055(var0, var1, var2, var16, 1, 1, (class85)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class4.field77[var0][var1][var2] |= 2340;
                  }

                  if(var8.field940 != 0 && null != var7) {
                     var7.method2490(var1, var2, var9, var10, var8.field941);
                  }

               } else if(var5 == 0) {
                  if(-1 == var8.field959 && var8.field925 == null) {
                     var21 = var8.method895(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 0, var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2016(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field88[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field954) {
                        class41.field985[var0][var1][var2] = 50;
                        class41.field985[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field945) {
                        class4.field77[var0][var1][var2] |= 585;
                     }
                  } else if(1 == var4) {
                     if(var8.field954) {
                        class41.field985[var0][var1][1 + var2] = 50;
                        class41.field985[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field945) {
                        class4.field77[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field954) {
                        class41.field985[var0][var1 + 1][var2] = 50;
                        class41.field985[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field945) {
                        class4.field77[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field954) {
                        class41.field985[var0][var1][var2] = 50;
                        class41.field985[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field945) {
                        class4.field77[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field940 != 0 && null != var7) {
                     var7.method2489(var1, var2, var5, var4, var8.field941);
                  }

                  if(var8.field947 != 16) {
                     var6.method2086(var0, var1, var2, var8.field947);
                  }

               } else if(var5 == 1) {
                  if(-1 == var8.field959 && null == var8.field925) {
                     var21 = var8.method895(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 1, var4, var0, var1, var2, var8.field959, true, (class85)null);
                  }

                  var6.method2016(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field89[var4], 0, var19, var20);
                  if(var8.field954) {
                     if(0 == var4) {
                        class41.field985[var0][var1][var2 + 1] = 50;
                     } else if(1 == var4) {
                        class41.field985[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class41.field985[var0][var1 + 1][var2] = 50;
                     } else if(3 == var4) {
                        class41.field985[var0][var1][var2] = 50;
                     }
                  }

                  if(0 != var8.field940 && null != var7) {
                     var7.method2489(var1, var2, var5, var4, var8.field941);
                  }

               } else {
                  int var26;
                  Object var27;
                  if(2 == var5) {
                     var26 = 1 + var4 & 3;
                     Object var28;
                     if(-1 == var8.field959 && var8.field925 == null) {
                        var28 = var8.method895(2, var4 + 4, var15, var17, var16, var18);
                        var27 = var8.method895(2, var26, var15, var17, var16, var18);
                     } else {
                        var28 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field959, true, (class85)null);
                        var27 = new class12(var3, 2, var26, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2016(var0, var1, var2, var16, (class85)var28, (class85)var27, class5.field88[var4], class5.field88[var26], var19, var20);
                     if(var8.field945) {
                        if(0 == var4) {
                           class4.field77[var0][var1][var2] |= 585;
                           class4.field77[var0][var1][1 + var2] |= 1170;
                        } else if(1 == var4) {
                           class4.field77[var0][var1][var2 + 1] |= 1170;
                           class4.field77[var0][1 + var1][var2] |= 585;
                        } else if(2 == var4) {
                           class4.field77[var0][1 + var1][var2] |= 585;
                           class4.field77[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class4.field77[var0][var1][var2] |= 1170;
                           class4.field77[var0][var1][var2] |= 585;
                        }
                     }

                     if(0 != var8.field940 && null != var7) {
                        var7.method2489(var1, var2, var5, var4, var8.field941);
                     }

                     if(var8.field947 != 16) {
                        var6.method2086(var0, var1, var2, var8.field947);
                     }

                  } else if(3 == var5) {
                     if(var8.field959 == -1 && null == var8.field925) {
                        var21 = var8.method895(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 3, var4, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2016(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field89[var4], 0, var19, var20);
                     if(var8.field954) {
                        if(0 == var4) {
                           class41.field985[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class41.field985[var0][var1 + 1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class41.field985[var0][1 + var1][var2] = 50;
                        } else if(var4 == 3) {
                           class41.field985[var0][var1][var2] = 50;
                        }
                     }

                     if(0 != var8.field940 && var7 != null) {
                        var7.method2489(var1, var2, var5, var4, var8.field941);
                     }

                  } else if(var5 == 9) {
                     if(var8.field959 == -1 && var8.field925 == null) {
                        var21 = var8.method895(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2055(var0, var1, var2, var16, 1, 1, (class85)var21, 0, var19, var20);
                     if(0 != var8.field940 && var7 != null) {
                        var7.method2490(var1, var2, var9, var10, var8.field941);
                     }

                     if(16 != var8.field947) {
                        var6.method2086(var0, var1, var2, var8.field947);
                     }

                  } else if(var5 == 4) {
                     if(-1 == var8.field959 && var8.field925 == null) {
                        var21 = var8.method895(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var4, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2017(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field88[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method2034(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class133.method2969(var22 >> 14 & 32767).field947;
                     }

                     if(var8.field959 == -1 && var8.field925 == null) {
                        var27 = var8.method895(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2017(var0, var1, var2, var16, (class85)var27, (class85)null, class5.field88[var4], 0, var26 * class5.field90[var4], class5.field91[var4] * var26, var19, var20);
                  } else if(6 == var5) {
                     var26 = 8;
                     var22 = var6.method2034(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class133.method2969(var22 >> 14 & 32767).field947 / 2;
                     }

                     if(-1 == var8.field959 && var8.field925 == null) {
                        var27 = var8.method895(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2017(var0, var1, var2, var16, (class85)var27, (class85)null, 256, var4, class5.field92[var4] * var26, class5.field83[var4] * var26, var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field959 == -1 && null == var8.field925) {
                        var21 = var8.method895(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2017(var0, var1, var2, var16, (class85)var21, (class85)null, 256, var22, 0, 0, var19, var20);
                  } else if(8 == var5) {
                     var26 = 8;
                     var22 = var6.method2034(var0, var1, var2);
                     if(0 != var22) {
                        var26 = class133.method2969(var22 >> 14 & 32767).field947 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(-1 == var8.field959 && null == var8.field925) {
                        var27 = var8.method895(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method895(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field959, true, (class85)null);
                        var29 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field959, true, (class85)null);
                     }

                     var6.method2017(var0, var1, var2, var16, (class85)var27, (class85)var29, 256, var4, class5.field92[var4] * var26, class5.field83[var4] * var26, var19, var20);
                  }
               }
            } else {
               if(-1 == var8.field959 && var8.field925 == null) {
                  var21 = var8.method895(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 10, var4, var0, var1, var2, var8.field959, true, (class85)null);
               }

               if(var21 != null && var6.method2055(var0, var1, var2, var16, var9, var10, (class85)var21, var5 == 11?256:0, var19, var20) && var8.field954) {
                  var22 = 15;
                  if(var21 instanceof class105) {
                     var22 = ((class105)var21).method2426() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class41.field985[var0][var1 + var23][var2 + var24]) {
                           class41.field985[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(0 != var8.field940 && null != var7) {
                  var7.method2490(var1, var2, var9, var10, var8.field941);
               }

            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "111"
   )
   public static String method1084(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(0 != var6) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2654[var6 - 128];
               if(0 == var7) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method1085(boolean var0) {
      class0.method6(client.field452, class37.field876, class98.field1671, var0);
   }
}
