import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class57 {
   @ObfuscatedName("t")
   static Applet field635;
   @ObfuscatedName("q")
   static String field636;

   static {
      field635 = null;
      field636 = "";
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-918295086"
   )
   static final void method883(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != Ignore.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class38.region.method2987(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class38.region.method2940(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class38.region.method2885(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class38.region.method3005(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class38.region.getObjectFlags(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class38.region.removeBoundaryObject(var0, var2, var3);
               var12 = Spotanim.getObjectDefinition(var34);
               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var35, var36, var12.blocksProjectile);
               }
            }

            if(var1 == 1) {
               class38.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               class38.region.method2882(var0, var2, var3);
               var12 = Spotanim.getObjectDefinition(var34);
               if(var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                  return;
               }

               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var36, var12.blocksProjectile);
               }
            }

            if(var1 == 3) {
               class38.region.removeFloorDecoration(var0, var2, var3);
               var12 = Spotanim.getObjectDefinition(var34);
               if(var12.clipType == 1) {
                  Client.collisionMaps[var0].method3405(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class62.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class38.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = Spotanim.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.width;
               var16 = var14.length;
            } else {
               var15 = var14.length;
               var16 = var14.width;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (var15 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class62.tileHeights[var11];
            int var22 = var21[var17][var20] + var21[var17][var19] + var21[var18][var19] + var21[var18][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.int1 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.supportItems == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method5024(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.clipType == 1) {
                  var13.method3388(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method5024(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2876(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.clipType != 0) {
                     var13.addObject(var2, var3, var15, var16, var14.blocksProjectile);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method5024(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field713[var5], 0, var25, var26);
                  if(var14.clipType != 0) {
                     var13.method3416(var2, var3, var6, var5, var14.blocksProjectile);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method5024(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field715[var5], 0, var25, var26);
                  if(var14.clipType != 0) {
                     var13.method3416(var2, var3, var6, var5, var14.blocksProjectile);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method5024(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method5024(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class62.field713[var5], class62.field713[var32], var25, var26);
                     if(var14.clipType != 0) {
                        var13.method3416(var2, var3, var6, var5, var14.blocksProjectile);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method5024(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field715[var5], 0, var25, var26);
                     if(var14.clipType != 0) {
                        var13.method3416(var2, var3, var6, var5, var14.blocksProjectile);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method5024(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2876(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.clipType != 0) {
                        var13.addObject(var2, var3, var15, var16, var14.blocksProjectile);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method5024(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class62.field713[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method2987(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = Spotanim.getObjectDefinition(var33 >> 14 & 32767).decorDisplacement;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method5024(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class62.field713[var5], 0, var32 * class62.field722[var5], var32 * class62.field716[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method2987(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = Spotanim.getObjectDefinition(var33 >> 14 & 32767).decorDisplacement / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method5024(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class62.field717[var5], var32 * class62.field718[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method5024(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method2987(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = Spotanim.getObjectDefinition(var33 >> 14 & 32767).decorDisplacement / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method5024(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method5024(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class62.field717[var5], var32 * class62.field718[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method5024(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2876(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.clipType != 0) {
                  var13.addObject(var2, var3, var15, var16, var14.blocksProjectile);
               }
            }
         }
      }

   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Lig;B)Z",
      garbageValue = "-3"
   )
   static final boolean method887(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class110.method2292(var0, var1);
            int var3 = var0.field2931[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
