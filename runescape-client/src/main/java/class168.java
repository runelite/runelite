import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class168 {
   @ObfuscatedName("bn")
   static class171 field2705;
   @ObfuscatedName("h")
   static Client field2706;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 869283985630093213L
   )
   public static long field2707;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1142539231
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("i")
   static final char[] field2709 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;IIB)Lclass59;",
      garbageValue = "-11"
   )
   public static final class59 method3267(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1239 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1234 = new int[256 * (class222.field3221?2:1)];
            var4.field1230 = var3;
            var4.vmethod1563(var1);
            var4.field1238 = (var3 & -1024) + 1024;
            if(var4.field1238 > 16384) {
               var4.field1238 = 16384;
            }

            var4.vmethod1549(var4.field1238);
            if(class59.field1231 > 0 && null == class59.field1240) {
               class59.field1240 = new class75();
               class59.field1240.field1410 = var0;
               var0.method2920(class59.field1240, class59.field1231);
            }

            if(class59.field1240 != null) {
               if(null != class59.field1240.field1409[var2]) {
                  throw new IllegalArgumentException();
               }

               class59.field1240.field1409[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "39"
   )
   static final void method3274(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field304 && class173.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class128.region.method1978(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class128.region.method1979(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class128.region.method1980(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class128.region.method2052(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class128.region.method1995(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class128.region.method1969(var0, var2, var3);
               var12 = class9.getObjectDefinition(var34);
               if(var12.field961 != 0) {
                  Client.collisionMaps[var0].method2425(var2, var3, var35, var36, var12.field962);
               }
            }

            if(var1 == 1) {
               class128.region.method1970(var0, var2, var3);
            }

            if(var1 == 2) {
               class128.region.method1971(var0, var2, var3);
               var12 = class9.getObjectDefinition(var34);
               if(var2 + var12.field959 > 103 || var3 + var12.field959 > 103 || var2 + var12.field960 > 103 || var3 + var12.field960 > 103) {
                  return;
               }

               if(var12.field961 != 0) {
                  Client.collisionMaps[var0].method2426(var2, var3, var12.field959, var12.field960, var36, var12.field962);
               }
            }

            if(var1 == 3) {
               class128.region.method2069(var0, var2, var3);
               var12 = class9.getObjectDefinition(var34);
               if(var12.field961 == 1) {
                  Client.collisionMaps[var0].method2428(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class128.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class9.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field959;
               var16 = var14.field960;
            } else {
               var15 = var14.field960;
               var16 = var14.field959;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = (var15 + 1 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = 1 + var2;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (1 + var16 >> 1);
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var18][var19] + var21[var17][var19] + var21[var17][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = 1073741824 + (var3 << 7) + var2 + (var4 << 14);
            if(var14.field963 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field984 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field955 == -1 && null == var14.impostorIds) {
                  var27 = var14.method845(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field961 == 1) {
                  var13.method2423(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field955 == -1 && null == var14.impostorIds) {
                     var27 = var14.method845(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                  }

                  var37.method1962(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field961 != 0) {
                     var13.method2420(var2, var3, var15, var16, var14.field962);
                  }
               } else if(var6 == 0) {
                  if(var14.field955 == -1 && var14.impostorIds == null) {
                     var27 = var14.method845(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                  }

                  var37.method1960(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field105[var5], 0, var25, var26);
                  if(var14.field961 != 0) {
                     var13.method2439(var2, var3, var6, var5, var14.field962);
                  }
               } else if(var6 == 1) {
                  if(var14.field955 == -1 && null == var14.impostorIds) {
                     var27 = var14.method845(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                  }

                  var37.method1960(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field97[var5], 0, var25, var26);
                  if(var14.field961 != 0) {
                     var13.method2439(var2, var3, var6, var5, var14.field962);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = 1 + var5 & 3;
                     Object var33;
                     if(var14.field955 == -1 && var14.impostorIds == null) {
                        var33 = var14.method845(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method845(2, var32, var21, var23, var22, var24);
                     } else {
                        var33 = new class12(var4, 2, var5 + 4, var11, var2, var3, var14.field955, true, (Renderable)null);
                        var29 = new class12(var4, 2, var32, var11, var2, var3, var14.field955, true, (Renderable)null);
                     }

                     var37.method1960(var0, var2, var3, var22, (Renderable)var33, (Renderable)var29, class5.field105[var5], class5.field105[var32], var25, var26);
                     if(var14.field961 != 0) {
                        var13.method2439(var2, var3, var6, var5, var14.field962);
                     }
                  } else if(var6 == 3) {
                     if(var14.field955 == -1 && null == var14.impostorIds) {
                        var27 = var14.method845(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                     }

                     var37.method1960(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field97[var5], 0, var25, var26);
                     if(var14.field961 != 0) {
                        var13.method2439(var2, var3, var6, var5, var14.field962);
                     }
                  } else if(var6 == 9) {
                     if(var14.field955 == -1 && null == var14.impostorIds) {
                        var27 = var14.method845(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                     }

                     var37.method1962(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field961 != 0) {
                        var13.method2420(var2, var3, var15, var16, var14.field962);
                     }
                  } else if(var6 == 4) {
                     if(var14.field955 == -1 && null == var14.impostorIds) {
                        var27 = var14.method845(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                     }

                     var37.method1961(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field105[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var32 = 16;
                        var28 = var37.method1978(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class9.getObjectDefinition(var28 >> 14 & 32767).field944;
                        }

                        if(var14.field955 == -1 && var14.impostorIds == null) {
                           var29 = var14.method845(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                        }

                        var37.method1961(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class5.field105[var5], 0, var32 * class5.field98[var5], var32 * class5.field99[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var28 = var37.method1978(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class9.getObjectDefinition(var28 >> 14 & 32767).field944 / 2;
                        }

                        if(var14.field955 == -1 && var14.impostorIds == null) {
                           var29 = var14.method845(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                        }

                        var37.method1961(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class5.field100[var5], class5.field101[var5] * var32, var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.field955 == -1 && null == var14.impostorIds) {
                           var27 = var14.method845(4, 4 + var28, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, 4 + var28, var11, var2, var3, var14.field955, true, (Renderable)null);
                        }

                        var37.method1961(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var28 = var37.method1978(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class9.getObjectDefinition(var28 >> 14 & 32767).field944 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.field955 == -1 && null == var14.impostorIds) {
                           var29 = var14.method845(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method845(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field955, true, (Renderable)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field955, true, (Renderable)null);
                        }

                        var37.method1961(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class5.field100[var5] * var32, var32 * class5.field101[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field955 == -1 && null == var14.impostorIds) {
                  var27 = var14.method845(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field955, true, (Renderable)null);
               }

               if(null != var27) {
                  var37.method1962(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field961 != 0) {
                  var13.method2420(var2, var3, var15, var16, var14.field962);
               }
            }
         }
      }

   }
}
