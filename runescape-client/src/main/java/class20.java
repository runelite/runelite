import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class20 extends class211 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1309296437
   )
   int field577;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -198715103
   )
   int field578;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -554880233
   )
   int field579;
   @ObfuscatedName("by")
   static class171 field581;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2103373921
   )
   int field583;
   @ObfuscatedName("bf")
   static FontMetrics field584;
   @ObfuscatedName("nm")
   static class58 field585;

   class20(int var1, int var2, int var3, int var4) {
      this.field583 = var1;
      this.field578 = var2;
      this.field579 = var3;
      this.field577 = var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIB)V",
      garbageValue = "6"
   )
   static void method568(class2 var0, int var1, int var2) {
      if(var1 == var0.field863 && var1 != -1) {
         int var3 = class22.method585(var1).field1031;
         if(var3 == 1) {
            var0.field836 = 0;
            var0.field848 = 0;
            var0.field864 = var2;
            var0.field867 = 0;
         }

         if(var3 == 2) {
            var0.field867 = 0;
         }
      } else if(var1 == -1 || var0.field863 == -1 || class22.method585(var1).field1023 >= class22.method585(var0.field863).field1023) {
         var0.field863 = var1;
         var0.field836 = 0;
         var0.field848 = 0;
         var0.field864 = var2;
         var0.field867 = 0;
         var0.field839 = var0.field849;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;B)V",
      garbageValue = "-76"
   )
   public static void method570(class170 var0, class170 var1) {
      class49.field1106 = var0;
      class49.field1101 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-850471339"
   )
   void method571(int var1, int var2, int var3, int var4) {
      this.field583 = var1;
      this.field578 = var2;
      this.field579 = var3;
      this.field577 = var4;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "611743624"
   )
   static final void method572(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field301 && var0 != class99.field1701) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class136.field2126.method1998(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class136.field2126.method2018(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class136.field2126.method2019(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class136.field2126.method2014(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class136.field2126.method2081(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            class42 var12;
            if(var1 == 0) {
               class136.field2126.method2008(var0, var2, var3);
               var12 = class160.method3312(var34);
               if(var12.field998 != 0) {
                  client.field354[var0].method2495(var2, var3, var35, var36, var12.field961);
               }
            }

            if(var1 == 1) {
               class136.field2126.method2009(var0, var2, var3);
            }

            if(var1 == 2) {
               class136.field2126.method2010(var0, var2, var3);
               var12 = class160.method3312(var34);
               if(var2 + var12.field960 > 103 || var12.field960 + var3 > 103 || var12.field970 + var2 > 103 || var3 + var12.field970 > 103) {
                  return;
               }

               if(var12.field998 != 0) {
                  client.field354[var0].method2501(var2, var3, var12.field960, var12.field970, var36, var12.field961);
               }
            }

            if(var1 == 3) {
               class136.field2126.method2100(var0, var2, var3);
               var12 = class160.method3312(var34);
               if(var12.field998 == 1) {
                  client.field354[var0].method2503(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field80[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class89 var37 = class136.field2126;
            class111 var13 = client.field354[var0];
            class42 var14 = class160.method3312(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field960;
               var16 = var14.field970;
            } else {
               var15 = var14.field970;
               var16 = var14.field960;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (1 + var16 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class5.field85[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var17][var19] + var21[var18][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = 1073741824 + var2 + (var3 << 7) + (var4 << 14);
            if(var14.field944 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field985 == 1) {
               var26 += 256;
            }

            Object var32;
            if(var6 == 22) {
               if(var14.field968 == -1 && null == var14.field986) {
                  var32 = var14.method852(22, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class12(var4, 22, var5, var11, var2, var3, var14.field968, true, (class88)null);
               }

               var37.method2043(var0, var2, var3, var22, (class88)var32, var25, var26);
               if(var14.field998 == 1) {
                  var13.method2513(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field968 == -1 && null == var14.field986) {
                     var32 = var14.method852(var6, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class12(var4, var6, var5, var11, var2, var3, var14.field968, true, (class88)null);
                  }

                  var37.method2002(var0, var2, var3, var22, 1, 1, (class88)var32, 0, var25, var26);
                  if(var14.field998 != 0) {
                     var13.method2506(var2, var3, var15, var16, var14.field961);
                  }
               } else if(var6 == 0) {
                  if(var14.field968 == -1 && null == var14.field986) {
                     var32 = var14.method852(0, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class12(var4, 0, var5, var11, var2, var3, var14.field968, true, (class88)null);
                  }

                  var37.method2000(var0, var2, var3, var22, (class88)var32, (class88)null, class5.field90[var5], 0, var25, var26);
                  if(var14.field998 != 0) {
                     var13.method2517(var2, var3, var6, var5, var14.field961);
                  }
               } else if(var6 == 1) {
                  if(var14.field968 == -1 && var14.field986 == null) {
                     var32 = var14.method852(1, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class12(var4, 1, var5, var11, var2, var3, var14.field968, true, (class88)null);
                  }

                  var37.method2000(var0, var2, var3, var22, (class88)var32, (class88)null, class5.field91[var5], 0, var25, var26);
                  if(var14.field998 != 0) {
                     var13.method2517(var2, var3, var6, var5, var14.field961);
                  }
               } else {
                  int var27;
                  Object var29;
                  if(var6 == 2) {
                     var27 = var5 + 1 & 3;
                     Object var33;
                     if(var14.field968 == -1 && null == var14.field986) {
                        var33 = var14.method852(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method852(2, var27, var21, var23, var22, var24);
                     } else {
                        var33 = new class12(var4, 2, var5 + 4, var11, var2, var3, var14.field968, true, (class88)null);
                        var29 = new class12(var4, 2, var27, var11, var2, var3, var14.field968, true, (class88)null);
                     }

                     var37.method2000(var0, var2, var3, var22, (class88)var33, (class88)var29, class5.field90[var5], class5.field90[var27], var25, var26);
                     if(var14.field998 != 0) {
                        var13.method2517(var2, var3, var6, var5, var14.field961);
                     }
                  } else if(var6 == 3) {
                     if(var14.field968 == -1 && var14.field986 == null) {
                        var32 = var14.method852(3, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class12(var4, 3, var5, var11, var2, var3, var14.field968, true, (class88)null);
                     }

                     var37.method2000(var0, var2, var3, var22, (class88)var32, (class88)null, class5.field91[var5], 0, var25, var26);
                     if(var14.field998 != 0) {
                        var13.method2517(var2, var3, var6, var5, var14.field961);
                     }
                  } else if(var6 == 9) {
                     if(var14.field968 == -1 && null == var14.field986) {
                        var32 = var14.method852(var6, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class12(var4, var6, var5, var11, var2, var3, var14.field968, true, (class88)null);
                     }

                     var37.method2002(var0, var2, var3, var22, 1, 1, (class88)var32, 0, var25, var26);
                     if(var14.field998 != 0) {
                        var13.method2506(var2, var3, var15, var16, var14.field961);
                     }
                  } else if(var6 == 4) {
                     if(var14.field968 == -1 && var14.field986 == null) {
                        var32 = var14.method852(4, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class12(var4, 4, var5, var11, var2, var3, var14.field968, true, (class88)null);
                     }

                     var37.method2001(var0, var2, var3, var22, (class88)var32, (class88)null, class5.field90[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var27 = 16;
                        var28 = var37.method1998(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class160.method3312(var28 >> 14 & 32767).field969;
                        }

                        if(var14.field968 == -1 && null == var14.field986) {
                           var29 = var14.method852(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field968, true, (class88)null);
                        }

                        var37.method2001(var0, var2, var3, var22, (class88)var29, (class88)null, class5.field90[var5], 0, var27 * class5.field92[var5], var27 * class5.field98[var5], var25, var26);
                     } else if(var6 == 6) {
                        var27 = 8;
                        var28 = var37.method1998(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class160.method3312(var28 >> 14 & 32767).field969 / 2;
                        }

                        if(var14.field968 == -1 && null == var14.field986) {
                           var29 = var14.method852(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field968, true, (class88)null);
                        }

                        var37.method2001(var0, var2, var3, var22, (class88)var29, (class88)null, 256, var5, var27 * class5.field94[var5], class5.field93[var5] * var27, var25, var26);
                     } else if(var6 == 7) {
                        var28 = 2 + var5 & 3;
                        if(var14.field968 == -1 && null == var14.field986) {
                           var32 = var14.method852(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var32 = new class12(var4, 4, 4 + var28, var11, var2, var3, var14.field968, true, (class88)null);
                        }

                        var37.method2001(var0, var2, var3, var22, (class88)var32, (class88)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var27 = 8;
                        var28 = var37.method1998(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class160.method3312(var28 >> 14 & 32767).field969 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field968 == -1 && var14.field986 == null) {
                           var29 = var14.method852(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method852(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field968, true, (class88)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field968, true, (class88)null);
                        }

                        var37.method2001(var0, var2, var3, var22, (class88)var29, (class88)var30, 256, var5, var27 * class5.field94[var5], class5.field93[var5] * var27, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field968 == -1 && var14.field986 == null) {
                  var32 = var14.method852(10, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class12(var4, 10, var5, var11, var2, var3, var14.field968, true, (class88)null);
               }

               if(var32 != null) {
                  var37.method2002(var0, var2, var3, var22, var15, var16, (class88)var32, var6 == 11?256:0, var25, var26);
               }

               if(var14.field998 != 0) {
                  var13.method2506(var2, var3, var15, var16, var14.field961);
               }
            }
         }
      }

   }
}
