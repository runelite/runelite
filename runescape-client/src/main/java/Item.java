import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2022815601
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1628923779
   )
   @Export("id")
   int id;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -513986365
   )
   static int field891;

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1737367256"
   )
   static final void method811(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field278 && var0 != class48.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class65.region.method1733(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class65.region.method1734(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class65.region.method1840(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class65.region.method1736(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class65.region.method1737(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class65.region.method1724(var0, var2, var3);
               var12 = class156.getObjectDefinition(var34);
               if(var12.field2901 != 0) {
                  Client.collisionMaps[var0].method2268(var2, var3, var35, var36, var12.field2876);
               }
            }

            if(var1 == 1) {
               class65.region.method1725(var0, var2, var3);
            }

            if(var1 == 2) {
               class65.region.method1726(var0, var2, var3);
               var12 = class156.getObjectDefinition(var34);
               if(var2 + var12.sizeX > 103 || var12.sizeX + var3 > 103 || var2 + var12.sizeY > 103 || var12.sizeY + var3 > 103) {
                  return;
               }

               if(var12.field2901 != 0) {
                  Client.collisionMaps[var0].method2249(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field2876);
               }
            }

            if(var1 == 3) {
               class65.region.method1727(var0, var2, var3);
               var12 = class156.getObjectDefinition(var34);
               if(var12.field2901 == 1) {
                  Client.collisionMaps[var0].method2248(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class11.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class65.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class156.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.sizeX;
               var16 = var14.sizeY;
            } else {
               var15 = var14.sizeY;
               var16 = var14.sizeX;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = (var15 + 1 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = 1 + var2;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = var3 + (1 + var16 >> 1);
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class11.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var17][var19] + var21[var18][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
            if(var14.field2910 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field2914 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && null == var14.impostorIds) {
                  var27 = var14.method3604(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field2901 == 1) {
                  var13.method2270(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var27 = var14.method3604(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1756(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field2901 != 0) {
                     var13.method2239(var2, var3, var15, var16, var14.field2876);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method3604(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1715(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field107[var5], 0, var25, var26);
                  if(var14.field2901 != 0) {
                     var13.method2245(var2, var3, var6, var5, var14.field2876);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var27 = var14.method3604(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1715(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field116[var5], 0, var25, var26);
                  if(var14.field2901 != 0) {
                     var13.method2245(var2, var3, var6, var5, var14.field2876);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var28 = var14.method3604(2, 4 + var5, var21, var23, var22, var24);
                        var29 = var14.method3604(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new class49(var4, 2, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class49(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1715(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class11.field107[var5], class11.field107[var32], var25, var26);
                     if(var14.field2901 != 0) {
                        var13.method2245(var2, var3, var6, var5, var14.field2876);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var27 = var14.method3604(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1715(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field116[var5], 0, var25, var26);
                     if(var14.field2901 != 0) {
                        var13.method2245(var2, var3, var6, var5, var14.field2876);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method3604(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1756(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field2901 != 0) {
                        var13.method2239(var2, var3, var15, var16, var14.field2876);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var27 = var14.method3604(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1716(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class11.field107[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method1733(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class156.getObjectDefinition(var33 >> 14 & 32767).field2898;
                        }

                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3604(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1716(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class11.field107[var5], 0, class11.field103[var5] * var32, var32 * class11.field104[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method1733(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class156.getObjectDefinition(var33 >> 14 & 32767).field2898 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3604(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1716(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, class11.field105[var5] * var32, class11.field98[var5] * var32, var25, var26);
                     } else if(var6 == 7) {
                        var33 = 2 + var5 & 3;
                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var27 = var14.method3604(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class49(var4, 4, 4 + var33, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1716(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method1733(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class156.getObjectDefinition(var33 >> 14 & 32767).field2898 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3604(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method3604(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class49(var4, 4, 4 + var31, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1716(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class11.field105[var5], var32 * class11.field98[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method3604(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(null != var27) {
                  var37.method1756(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2901 != 0) {
                  var13.method2239(var2, var3, var15, var16, var14.field2876);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "637530507"
   )
   protected final Model getModel() {
      return PlayerComposition.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   static void method816(int var0) {
      for(class133 var1 = (class133)Client.widgetFlags.method2334(); var1 != null; var1 = (class133)Client.widgetFlags.method2335()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }
}
