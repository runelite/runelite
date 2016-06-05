import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public abstract class class125 {
   @ObfuscatedName("i")
   static boolean field2047 = false;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-102"
   )
   abstract byte[] vmethod2753();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "812924816"
   )
   abstract void vmethod2754(byte[] var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;S)V",
      garbageValue = "708"
   )
   static final void method2764(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field287 || (class5.field83[0][var1][var2] & 2) != 0 || (class5.field83[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field84) {
            class5.field84 = var0;
         }

         class40 var8 = class49.method980(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field954;
            var10 = var8.field923;
         } else {
            var9 = var8.field923;
            var10 = var8.field954;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.field100[var0];
         int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var3 << 14) + var1 + (var2 << 7);
         if(var8.field924 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field944 == 1) {
            var20 += 256;
         }

         if(var8.method791()) {
            class24.method574(var0, var1, var2, var8, var4);
         }

         Object var27;
         if(var5 == 22) {
            if(!client.field287 || var8.field924 != 0 || var8.field931 == 1 || var8.field952) {
               if(var8.field927 == -1 && null == var8.field955) {
                  var27 = var8.method788(22, var4, var15, var17, var16, var18);
               } else {
                  var27 = new class12(var3, 22, var4, var0, var1, var2, var8.field927, true, (class85)null);
               }

               var6.method1896(var0, var1, var2, var16, (class85)var27, var19, var20);
               if(var8.field931 == 1 && null != var7) {
                  var7.method2356(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field927 == -1 && null == var8.field955) {
                     var27 = var8.method788(var5, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class12(var3, var5, var4, var0, var1, var2, var8.field927, true, (class85)null);
                  }

                  var6.method1880(var0, var1, var2, var16, 1, 1, (class85)var27, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class102.field1774[var0][var1][var2] |= 2340;
                  }

                  if(var8.field931 != 0 && null != var7) {
                     var7.method2363(var1, var2, var9, var10, var8.field937);
                  }

               } else if(var5 == 0) {
                  if(var8.field927 == -1 && var8.field955 == null) {
                     var27 = var8.method788(0, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class12(var3, 0, var4, var0, var1, var2, var8.field927, true, (class85)null);
                  }

                  var6.method2038(var0, var1, var2, var16, (class85)var27, (class85)null, class5.field90[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field945) {
                        class5.field92[var0][var1][var2] = 50;
                        class5.field92[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field936) {
                        class102.field1774[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field945) {
                        class5.field92[var0][var1][var2 + 1] = 50;
                        class5.field92[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field936) {
                        class102.field1774[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field945) {
                        class5.field92[var0][1 + var1][var2] = 50;
                        class5.field92[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field936) {
                        class102.field1774[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field945) {
                        class5.field92[var0][var1][var2] = 50;
                        class5.field92[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field936) {
                        class102.field1774[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field931 != 0 && var7 != null) {
                     var7.method2359(var1, var2, var5, var4, var8.field937);
                  }

                  if(var8.field938 != 16) {
                     var6.method1886(var0, var1, var2, var8.field938);
                  }

               } else if(var5 == 1) {
                  if(var8.field927 == -1 && var8.field955 == null) {
                     var27 = var8.method788(1, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class12(var3, 1, var4, var0, var1, var2, var8.field927, true, (class85)null);
                  }

                  var6.method2038(var0, var1, var2, var16, (class85)var27, (class85)null, class5.field91[var4], 0, var19, var20);
                  if(var8.field945) {
                     if(var4 == 0) {
                        class5.field92[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class5.field92[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class5.field92[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class5.field92[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field931 != 0 && null != var7) {
                     var7.method2359(var1, var2, var5, var4, var8.field937);
                  }

               } else {
                  int var21;
                  Object var23;
                  if(var5 == 2) {
                     var21 = var4 + 1 & 3;
                     Object var26;
                     if(var8.field927 == -1 && null == var8.field955) {
                        var26 = var8.method788(2, 4 + var4, var15, var17, var16, var18);
                        var23 = var8.method788(2, var21, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field927, true, (class85)null);
                        var23 = new class12(var3, 2, var21, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method2038(var0, var1, var2, var16, (class85)var26, (class85)var23, class5.field90[var4], class5.field90[var21], var19, var20);
                     if(var8.field936) {
                        if(var4 == 0) {
                           class102.field1774[var0][var1][var2] |= 585;
                           class102.field1774[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class102.field1774[var0][var1][var2 + 1] |= 1170;
                           class102.field1774[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class102.field1774[var0][1 + var1][var2] |= 585;
                           class102.field1774[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class102.field1774[var0][var1][var2] |= 1170;
                           class102.field1774[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field931 != 0 && null != var7) {
                        var7.method2359(var1, var2, var5, var4, var8.field937);
                     }

                     if(var8.field938 != 16) {
                        var6.method1886(var0, var1, var2, var8.field938);
                     }

                  } else if(var5 == 3) {
                     if(var8.field927 == -1 && var8.field955 == null) {
                        var27 = var8.method788(3, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 3, var4, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method2038(var0, var1, var2, var16, (class85)var27, (class85)null, class5.field91[var4], 0, var19, var20);
                     if(var8.field945) {
                        if(var4 == 0) {
                           class5.field92[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class5.field92[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class5.field92[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class5.field92[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field931 != 0 && null != var7) {
                        var7.method2359(var1, var2, var5, var4, var8.field937);
                     }

                  } else if(var5 == 9) {
                     if(var8.field927 == -1 && var8.field955 == null) {
                        var27 = var8.method788(var5, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, var5, var4, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method1880(var0, var1, var2, var16, 1, 1, (class85)var27, 0, var19, var20);
                     if(var8.field931 != 0 && null != var7) {
                        var7.method2363(var1, var2, var9, var10, var8.field937);
                     }

                     if(var8.field938 != 16) {
                        var6.method1886(var0, var1, var2, var8.field938);
                     }

                  } else if(var5 == 4) {
                     if(var8.field927 == -1 && null == var8.field955) {
                        var27 = var8.method788(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method2022(var0, var1, var2, var16, (class85)var27, (class85)null, class5.field90[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var21 = 16;
                     var22 = var6.method1990(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class49.method980(var22 >> 14 & 32767).field938;
                     }

                     if(var8.field927 == -1 && var8.field955 == null) {
                        var23 = var8.method788(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method2022(var0, var1, var2, var16, (class85)var23, (class85)null, class5.field90[var4], 0, var21 * class5.field85[var4], var21 * class5.field93[var4], var19, var20);
                  } else if(var5 == 6) {
                     var21 = 8;
                     var22 = var6.method1990(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class49.method980(var22 >> 14 & 32767).field938 / 2;
                     }

                     if(var8.field927 == -1 && null == var8.field955) {
                        var23 = var8.method788(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method2022(var0, var1, var2, var16, (class85)var23, (class85)null, 256, var4, var21 * class5.field82[var4], var21 * class5.field95[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field927 == -1 && var8.field955 == null) {
                        var27 = var8.method788(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method2022(var0, var1, var2, var16, (class85)var27, (class85)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var21 = 8;
                     var22 = var6.method1990(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class49.method980(var22 >> 14 & 32767).field938 / 2;
                     }

                     int var25 = 2 + var4 & 3;
                     Object var29;
                     if(var8.field927 == -1 && var8.field955 == null) {
                        var23 = var8.method788(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method788(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field927, true, (class85)null);
                        var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field927, true, (class85)null);
                     }

                     var6.method2022(var0, var1, var2, var16, (class85)var23, (class85)var29, 256, var4, class5.field82[var4] * var21, var21 * class5.field95[var4], var19, var20);
                  }
               }
            } else {
               if(var8.field927 == -1 && null == var8.field955) {
                  var27 = var8.method788(10, var4, var15, var17, var16, var18);
               } else {
                  var27 = new class12(var3, 10, var4, var0, var1, var2, var8.field927, true, (class85)null);
               }

               if(null != var27 && var6.method1880(var0, var1, var2, var16, var9, var10, (class85)var27, var5 == 11?256:0, var19, var20) && var8.field945) {
                  var22 = 15;
                  if(var27 instanceof class105) {
                     var22 = ((class105)var27).method2260() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var28 = 0; var28 <= var9; ++var28) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class5.field92[var0][var28 + var1][var24 + var2]) {
                           class5.field92[var0][var1 + var28][var2 + var24] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field931 != 0 && null != var7) {
                  var7.method2363(var1, var2, var9, var10, var8.field937);
               }

            }
         }
      }
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-2095594894"
   )
   static final String[] method2765(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "20"
   )
   static final int method2766(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (15731 * var2 * var2 + 789221) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
