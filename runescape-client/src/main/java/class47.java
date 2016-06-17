import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class47 extends class204 {
   @ObfuscatedName("g")
   public static class193 field1042 = new class193(64);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2035397295
   )
   public int field1043;
   @ObfuscatedName("b")
   public static class167 field1044;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 919405445
   )
   public int field1045;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1445467953
   )
   public int field1047;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "1"
   )
   static final void method972(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class44.field1021.method4030(var0, 250);
      int var6 = class44.field1021.method4031(var0, 250) * 13;
      class79.method1865(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 0);
      class79.method1852(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class44.field1021.method4036(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class168.method3374(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2);

      try {
         Graphics var7 = class46.field1040.getGraphics();
         class48.field1049.vmethod1887(var7, 0, 0);
      } catch (Exception var8) {
         class46.field1040.repaint();
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-3"
   )
   static final void method974(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field383 && var0 != class144.field2193) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class150.field2230.method1951(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class150.field2230.method1952(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class150.field2230.method1953(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class150.field2230.method1954(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class150.field2230.method1955(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               class150.field2230.method1942(var0, var2, var3);
               var12 = class172.method3399(var34);
               if(var12.field917 != 0) {
                  client.field291[var0].method2397(var2, var3, var35, var36, var12.field918);
               }
            }

            if(var1 == 1) {
               class150.field2230.method1943(var0, var2, var3);
            }

            if(var1 == 2) {
               class150.field2230.method1986(var0, var2, var3);
               var12 = class172.method3399(var34);
               if(var12.field915 + var2 > 103 || var3 + var12.field915 > 103 || var12.field904 + var2 > 103 || var12.field904 + var3 > 103) {
                  return;
               }

               if(var12.field917 != 0) {
                  client.field291[var0].method2398(var2, var3, var12.field915, var12.field904, var36, var12.field918);
               }
            }

            if(var1 == 3) {
               class150.field2230.method1980(var0, var2, var3);
               var12 = class172.method3399(var34);
               if(var12.field917 == 1) {
                  client.field291[var0].method2400(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field69[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class86 var37 = class150.field2230;
            class108 var13 = client.field291[var0];
            class40 var14 = class172.method3399(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field915;
               var16 = var14.field904;
            } else {
               var15 = var14.field904;
               var16 = var14.field915;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = (var16 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.field83[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var17][var19] + var21[var18][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var4 << 14) + (var3 << 7) + var2 + 1073741824;
            if(var14.field919 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field940 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field945 == -1 && var14.field949 == null) {
                  var27 = var14.method801(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field945, true, (class85)null);
               }

               var37.method1931(var0, var2, var3, var22, (class85)var27, var25, var26);
               if(var14.field917 == 1) {
                  var13.method2395(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field945 == -1 && var14.field949 == null) {
                     var27 = var14.method801(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field945, true, (class85)null);
                  }

                  var37.method1945(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                  if(var14.field917 != 0) {
                     var13.method2393(var2, var3, var15, var16, var14.field918);
                  }
               } else if(var6 == 0) {
                  if(var14.field945 == -1 && null == var14.field949) {
                     var27 = var14.method801(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field945, true, (class85)null);
                  }

                  var37.method1933(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field75[var5], 0, var25, var26);
                  if(var14.field917 != 0) {
                     var13.method2392(var2, var3, var6, var5, var14.field918);
                  }
               } else if(var6 == 1) {
                  if(var14.field945 == -1 && var14.field949 == null) {
                     var27 = var14.method801(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field945, true, (class85)null);
                  }

                  var37.method1933(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field68[var5], 0, var25, var26);
                  if(var14.field917 != 0) {
                     var13.method2392(var2, var3, var6, var5, var14.field918);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = 1 + var5 & 3;
                     Object var33;
                     if(var14.field945 == -1 && var14.field949 == null) {
                        var33 = var14.method801(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method801(2, var32, var21, var23, var22, var24);
                     } else {
                        var33 = new class12(var4, 2, 4 + var5, var11, var2, var3, var14.field945, true, (class85)null);
                        var29 = new class12(var4, 2, var32, var11, var2, var3, var14.field945, true, (class85)null);
                     }

                     var37.method1933(var0, var2, var3, var22, (class85)var33, (class85)var29, class5.field75[var5], class5.field75[var32], var25, var26);
                     if(var14.field917 != 0) {
                        var13.method2392(var2, var3, var6, var5, var14.field918);
                     }
                  } else if(var6 == 3) {
                     if(var14.field945 == -1 && null == var14.field949) {
                        var27 = var14.method801(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field945, true, (class85)null);
                     }

                     var37.method1933(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field68[var5], 0, var25, var26);
                     if(var14.field917 != 0) {
                        var13.method2392(var2, var3, var6, var5, var14.field918);
                     }
                  } else if(var6 == 9) {
                     if(var14.field945 == -1 && var14.field949 == null) {
                        var27 = var14.method801(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field945, true, (class85)null);
                     }

                     var37.method1945(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                     if(var14.field917 != 0) {
                        var13.method2393(var2, var3, var15, var16, var14.field918);
                     }
                  } else if(var6 == 4) {
                     if(var14.field945 == -1 && null == var14.field949) {
                        var27 = var14.method801(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field945, true, (class85)null);
                     }

                     var37.method2053(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field75[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var32 = 16;
                        var28 = var37.method1951(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class172.method3399(var28 >> 14 & 32767).field908;
                        }

                        if(var14.field945 == -1 && var14.field949 == null) {
                           var29 = var14.method801(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field945, true, (class85)null);
                        }

                        var37.method2053(var0, var2, var3, var22, (class85)var29, (class85)null, class5.field75[var5], 0, var32 * class5.field88[var5], class5.field77[var5] * var32, var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var28 = var37.method1951(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class172.method3399(var28 >> 14 & 32767).field908 / 2;
                        }

                        if(var14.field945 == -1 && null == var14.field949) {
                           var29 = var14.method801(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field945, true, (class85)null);
                        }

                        var37.method2053(var0, var2, var3, var22, (class85)var29, (class85)null, 256, var5, var32 * class5.field76[var5], class5.field80[var5] * var32, var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.field945 == -1 && null == var14.field949) {
                           var27 = var14.method801(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, 4 + var28, var11, var2, var3, var14.field945, true, (class85)null);
                        }

                        var37.method2053(var0, var2, var3, var22, (class85)var27, (class85)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var28 = var37.method1951(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class172.method3399(var28 >> 14 & 32767).field908 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field945 == -1 && var14.field949 == null) {
                           var29 = var14.method801(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method801(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field945, true, (class85)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field945, true, (class85)null);
                        }

                        var37.method2053(var0, var2, var3, var22, (class85)var29, (class85)var30, 256, var5, var32 * class5.field76[var5], class5.field80[var5] * var32, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field945 == -1 && null == var14.field949) {
                  var27 = var14.method801(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field945, true, (class85)null);
               }

               if(var27 != null) {
                  var37.method1945(var0, var2, var3, var22, var15, var16, (class85)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field917 != 0) {
                  var13.method2393(var2, var3, var15, var16, var14.field918);
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-99"
   )
   public void method976(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method983(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-5"
   )
   void method983(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1043 = var1.method2516();
         this.field1045 = var1.method2514();
         this.field1047 = var1.method2514();
      }

   }
}
