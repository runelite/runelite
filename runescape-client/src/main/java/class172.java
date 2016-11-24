import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class172 {
   @ObfuscatedName("m")
   public static int[] field2362 = new int[99];
   @ObfuscatedName("bn")
   static class184 field2363;
   @ObfuscatedName("d")
   public static final boolean[] field2364 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("w")
   public static class182 field2367;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1667254305"
   )
   public static void method3301(class182 var0) {
      class195.field2864 = var0;
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2362[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "20"
   )
   static final void method3302(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field288 && class166.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class157.region.method1766(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class157.region.method1767(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class157.region.method1768(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class157.region.method1744(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class157.region.method1881(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class157.region.method1757(var0, var2, var3);
               var12 = class15.getObjectDefinition(var34);
               if(var12.field2908 != 0) {
                  Client.collisionMaps[var0].method2318(var2, var3, var35, var36, var12.field2909);
               }
            }

            if(var1 == 1) {
               class157.region.method1758(var0, var2, var3);
            }

            if(var1 == 2) {
               class157.region.method1759(var0, var2, var3);
               var12 = class15.getObjectDefinition(var34);
               if(var12.field2903 + var2 > 103 || var12.field2903 + var3 > 103 || var2 + var12.field2907 > 103 || var12.field2907 + var3 > 103) {
                  return;
               }

               if(var12.field2908 != 0) {
                  Client.collisionMaps[var0].method2309(var2, var3, var12.field2903, var12.field2907, var36, var12.field2909);
               }
            }

            if(var1 == 3) {
               class157.region.method1760(var0, var2, var3);
               var12 = class15.getObjectDefinition(var34);
               if(var12.field2908 == 1) {
                  Client.collisionMaps[var0].method2303(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class11.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class157.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class15.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field2903;
               var16 = var14.field2907;
            } else {
               var15 = var14.field2907;
               var16 = var14.field2903;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = (1 + var15 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class11.tileHeights[var11];
            int var22 = var21[var18][var19] + var21[var17][var19] + var21[var17][var20] + var21[var18][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.field2910 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field2931 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field2914 == -1 && var14.impostorIds == null) {
                  var27 = var14.method3652(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 22, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field2908 == 1) {
                  var13.method2306(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field2914 == -1 && var14.impostorIds == null) {
                     var27 = var14.method3652(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, var6, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                  }

                  var37.method1750(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field2908 != 0) {
                     var13.method2333(var2, var3, var15, var16, var14.field2909);
                  }
               } else if(var6 == 0) {
                  if(var14.field2914 == -1 && null == var14.impostorIds) {
                     var27 = var14.method3652(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 0, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                  }

                  var37.method1748(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field108[var5], 0, var25, var26);
                  if(var14.field2908 != 0) {
                     var13.method2326(var2, var3, var6, var5, var14.field2909);
                  }
               } else if(var6 == 1) {
                  if(var14.field2914 == -1 && null == var14.impostorIds) {
                     var27 = var14.method3652(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 1, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                  }

                  var37.method1748(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field109[var5], 0, var25, var26);
                  if(var14.field2908 != 0) {
                     var13.method2326(var2, var3, var6, var5, var14.field2909);
                  }
               } else {
                  Object var29;
                  int var33;
                  if(var6 == 2) {
                     var33 = var5 + 1 & 3;
                     Object var32;
                     if(var14.field2914 == -1 && var14.impostorIds == null) {
                        var32 = var14.method3652(2, 4 + var5, var21, var23, var22, var24);
                        var29 = var14.method3652(2, var33, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 2, var5 + 4, var11, var2, var3, var14.field2914, true, (Renderable)null);
                        var29 = new class49(var4, 2, var33, var11, var2, var3, var14.field2914, true, (Renderable)null);
                     }

                     var37.method1748(var0, var2, var3, var22, (Renderable)var32, (Renderable)var29, class11.field108[var5], class11.field108[var33], var25, var26);
                     if(var14.field2908 != 0) {
                        var13.method2326(var2, var3, var6, var5, var14.field2909);
                     }
                  } else if(var6 == 3) {
                     if(var14.field2914 == -1 && var14.impostorIds == null) {
                        var27 = var14.method3652(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 3, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                     }

                     var37.method1748(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field109[var5], 0, var25, var26);
                     if(var14.field2908 != 0) {
                        var13.method2326(var2, var3, var6, var5, var14.field2909);
                     }
                  } else if(var6 == 9) {
                     if(var14.field2914 == -1 && null == var14.impostorIds) {
                        var27 = var14.method3652(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, var6, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                     }

                     var37.method1750(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field2908 != 0) {
                        var13.method2333(var2, var3, var15, var16, var14.field2909);
                     }
                  } else if(var6 == 4) {
                     if(var14.field2914 == -1 && null == var14.impostorIds) {
                        var27 = var14.method3652(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 4, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                     }

                     var37.method1749(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field108[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var33 = 16;
                        var28 = var37.method1766(var0, var2, var3);
                        if(var28 != 0) {
                           var33 = class15.getObjectDefinition(var28 >> 14 & 32767).field2915;
                        }

                        if(var14.field2914 == -1 && null == var14.impostorIds) {
                           var29 = var14.method3652(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                        }

                        var37.method1749(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class11.field108[var5], 0, class11.field117[var5] * var33, var33 * class11.field116[var5], var25, var26);
                     } else if(var6 == 6) {
                        var33 = 8;
                        var28 = var37.method1766(var0, var2, var3);
                        if(var28 != 0) {
                           var33 = class15.getObjectDefinition(var28 >> 14 & 32767).field2915 / 2;
                        }

                        if(var14.field2914 == -1 && null == var14.impostorIds) {
                           var29 = var14.method3652(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, 4 + var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
                        }

                        var37.method1749(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var33 * class11.field112[var5], class11.field113[var5] * var33, var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.field2914 == -1 && var14.impostorIds == null) {
                           var27 = var14.method3652(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class49(var4, 4, 4 + var28, var11, var2, var3, var14.field2914, true, (Renderable)null);
                        }

                        var37.method1749(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var33 = 8;
                        var28 = var37.method1766(var0, var2, var3);
                        if(var28 != 0) {
                           var33 = class15.getObjectDefinition(var28 >> 14 & 32767).field2915 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field2914 == -1 && var14.impostorIds == null) {
                           var29 = var14.method3652(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method3652(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.field2914, true, (Renderable)null);
                           var30 = new class49(var4, 4, 4 + var31, var11, var2, var3, var14.field2914, true, (Renderable)null);
                        }

                        var37.method1749(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var33 * class11.field112[var5], class11.field113[var5] * var33, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field2914 == -1 && null == var14.impostorIds) {
                  var27 = var14.method3652(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 10, var5, var11, var2, var3, var14.field2914, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method1750(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2908 != 0) {
                  var13.method2333(var2, var3, var15, var16, var14.field2909);
               }
            }
         }
      }

   }
}
