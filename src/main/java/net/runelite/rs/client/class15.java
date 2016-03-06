import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("y")
@Implements("XItemContainer")
public class class15 extends class207 {
   @ObfuscatedName("l")
   @Export("itemIds")
   int[] field223 = new int[]{-1};
   @ObfuscatedName("pz")
   static short[] field224;
   @ObfuscatedName("j")
   @Export("itemContainers")
   static class195 field225 = new class195(32);
   @ObfuscatedName("p")
   static class118 field228;
   @ObfuscatedName("a")
   @Export("stackSizes")
   int[] field229 = new int[]{0};

   @ObfuscatedName("f")
   public static int method179(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("aq")
   static final int method180() {
      if(class10.field169.field142) {
         return class75.field1386;
      } else {
         int var0 = class105.method2335(class142.field2197, class147.field2228, class75.field1386);
         return var0 - class36.field797 < 800 && 0 != (class5.field81[class75.field1386][class142.field2197 >> 7][class147.field2228 >> 7] & 4)?class75.field1386:3;
      }
   }

   @ObfuscatedName("bq")
   static final void method181(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field457 && var0 != class75.field1386) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class107.field1906.method1901(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class107.field1906.method1902(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class107.field1906.method1935(var0, var2, var3);
         }

         if(3 == var1) {
            var7 = class107.field1906.method2010(var0, var2, var3);
         }

         int var11;
         if(0 != var7) {
            var11 = class107.field1906.method1983(var0, var2, var3, var7);
            int var32 = var7 >> 14 & 32767;
            int var33 = var11 & 31;
            int var34 = var11 >> 6 & 3;
            class40 var12;
            if(0 == var1) {
               class107.field1906.method2008(var0, var2, var3);
               var12 = class48.method996(var32);
               if(0 != var12.field934) {
                  client.field346[var0].method2347(var2, var3, var33, var34, var12.field918);
               }
            }

            if(var1 == 1) {
               class107.field1906.method2028(var0, var2, var3);
            }

            if(2 == var1) {
               class107.field1906.method1977(var0, var2, var3);
               var12 = class48.method996(var32);
               if(var2 + var12.field932 > 103 || var12.field932 + var3 > 103 || var12.field933 + var2 > 103 || var12.field933 + var3 > 103) {
                  return;
               }

               if(0 != var12.field934) {
                  client.field346[var0].method2348(var2, var3, var12.field932, var12.field933, var34, var12.field918);
               }
            }

            if(var1 == 3) {
               class107.field1906.method1895(var0, var2, var3);
               var12 = class48.method996(var32);
               if(var12.field934 == 1) {
                  client.field346[var0].method2350(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field81[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class85 var35 = class107.field1906;
            class107 var13 = client.field346[var0];
            class40 var14 = class48.method996(var4);
            int var15;
            int var16;
            if(1 != var5 && var5 != 3) {
               var15 = var14.field932;
               var16 = var14.field933;
            } else {
               var15 = var14.field933;
               var16 = var14.field932;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = var2 + (var15 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = 1 + var2;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = (var16 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.field93[var11];
            int var22 = var21[var17][var19] + var21[var18][var19] + var21[var17][var20] + var21[var18][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
            if(var14.field936 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(1 == var14.field917) {
               var26 += 256;
            }

            Object var27;
            if(22 == var6) {
               if(-1 == var14.field949 && var14.field920 == null) {
                  var27 = var14.method805(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field949, true, (class84)null);
               }

               var35.method1881(var0, var2, var3, var22, (class84)var27, var25, var26);
               if(var14.field934 == 1) {
                  var13.method2345(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(-1 == var14.field949 && null == var14.field920) {
                     var27 = var14.method805(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field949, true, (class84)null);
                  }

                  var35.method1967(var0, var2, var3, var22, 1, 1, (class84)var27, 0, var25, var26);
                  if(var14.field934 != 0) {
                     var13.method2342(var2, var3, var15, var16, var14.field918);
                  }
               } else if(var6 == 0) {
                  if(var14.field949 == -1 && var14.field920 == null) {
                     var27 = var14.method805(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field949, true, (class84)null);
                  }

                  var35.method1876(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field88[var5], 0, var25, var26);
                  if(var14.field934 != 0) {
                     var13.method2365(var2, var3, var6, var5, var14.field918);
                  }
               } else if(var6 == 1) {
                  if(-1 == var14.field949 && var14.field920 == null) {
                     var27 = var14.method805(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field949, true, (class84)null);
                  }

                  var35.method1876(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field80[var5], 0, var25, var26);
                  if(var14.field934 != 0) {
                     var13.method2365(var2, var3, var6, var5, var14.field918);
                  }
               } else {
                  Object var29;
                  int var37;
                  if(2 == var6) {
                     var37 = 1 + var5 & 3;
                     Object var28;
                     if(var14.field949 == -1 && var14.field920 == null) {
                        var28 = var14.method805(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method805(2, var37, var21, var23, var22, var24);
                     } else {
                        var28 = new class12(var4, 2, 4 + var5, var11, var2, var3, var14.field949, true, (class84)null);
                        var29 = new class12(var4, 2, var37, var11, var2, var3, var14.field949, true, (class84)null);
                     }

                     var35.method1876(var0, var2, var3, var22, (class84)var28, (class84)var29, class5.field88[var5], class5.field88[var37], var25, var26);
                     if(0 != var14.field934) {
                        var13.method2365(var2, var3, var6, var5, var14.field918);
                     }
                  } else if(var6 == 3) {
                     if(-1 == var14.field949 && null == var14.field920) {
                        var27 = var14.method805(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field949, true, (class84)null);
                     }

                     var35.method1876(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field80[var5], 0, var25, var26);
                     if(var14.field934 != 0) {
                        var13.method2365(var2, var3, var6, var5, var14.field918);
                     }
                  } else if(9 == var6) {
                     if(var14.field949 == -1 && var14.field920 == null) {
                        var27 = var14.method805(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field949, true, (class84)null);
                     }

                     var35.method1967(var0, var2, var3, var22, 1, 1, (class84)var27, 0, var25, var26);
                     if(var14.field934 != 0) {
                        var13.method2342(var2, var3, var15, var16, var14.field918);
                     }
                  } else if(var6 == 4) {
                     if(-1 == var14.field949 && var14.field920 == null) {
                        var27 = var14.method805(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field949, true, (class84)null);
                     }

                     var35.method1884(var0, var2, var3, var22, (class84)var27, (class84)null, class5.field88[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var36;
                     if(var6 == 5) {
                        var37 = 16;
                        var36 = var35.method1901(var0, var2, var3);
                        if(var36 != 0) {
                           var37 = class48.method996(var36 >> 14 & 32767).field961;
                        }

                        if(var14.field949 == -1 && null == var14.field920) {
                           var29 = var14.method805(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field949, true, (class84)null);
                        }

                        var35.method1884(var0, var2, var3, var22, (class84)var29, (class84)null, class5.field88[var5], 0, var37 * class5.field103[var5], var37 * class5.field89[var5], var25, var26);
                     } else if(var6 == 6) {
                        var37 = 8;
                        var36 = var35.method1901(var0, var2, var3);
                        if(0 != var36) {
                           var37 = class48.method996(var36 >> 14 & 32767).field961 / 2;
                        }

                        if(-1 == var14.field949 && var14.field920 == null) {
                           var29 = var14.method805(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field949, true, (class84)null);
                        }

                        var35.method1884(var0, var2, var3, var22, (class84)var29, (class84)null, 256, var5, class5.field92[var5] * var37, class5.field101[var5] * var37, var25, var26);
                     } else if(7 == var6) {
                        var36 = var5 + 2 & 3;
                        if(-1 == var14.field949 && var14.field920 == null) {
                           var27 = var14.method805(4, 4 + var36, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, var36 + 4, var11, var2, var3, var14.field949, true, (class84)null);
                        }

                        var35.method1884(var0, var2, var3, var22, (class84)var27, (class84)null, 256, var36, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var37 = 8;
                        var36 = var35.method1901(var0, var2, var3);
                        if(0 != var36) {
                           var37 = class48.method996(var36 >> 14 & 32767).field961 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(-1 == var14.field949 && null == var14.field920) {
                           var29 = var14.method805(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method805(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field949, true, (class84)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field949, true, (class84)null);
                        }

                        var35.method1884(var0, var2, var3, var22, (class84)var29, (class84)var30, 256, var5, class5.field92[var5] * var37, class5.field101[var5] * var37, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field949 == -1 && null == var14.field920) {
                  var27 = var14.method805(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field949, true, (class84)null);
               }

               if(null != var27) {
                  var35.method1967(var0, var2, var3, var22, var15, var16, (class84)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field934 != 0) {
                  var13.method2342(var2, var3, var15, var16, var14.field918);
               }
            }
         }
      }

   }
}
