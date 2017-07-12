import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("gq")
   @Export("hitmarks")
   static SpritePixels[] hitmarks;
   @ObfuscatedName("w")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -979731957
   )
   @Export("world")
   int world;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -812906933
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("s")
   boolean field824;
   @ObfuscatedName("r")
   boolean field825;
   @ObfuscatedName("i")
   @Export("name")
   String name;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "0"
   )
   public static void method1118(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class155.field2257, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "995731057"
   )
   static final void method1119(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != WallObject.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class2.region.method2692(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class2.region.method2794(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class2.region.method2694(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class2.region.method2695(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class2.region.method2696(var0, var2, var3, var7);
            int var12 = var7 >> 14 & 32767;
            int var13 = var11 & 31;
            int var14 = var11 >> 6 & 3;
            ObjectComposition var15;
            if(var1 == 0) {
               class2.region.method2693(var0, var2, var3);
               var15 = class251.getObjectDefinition(var12);
               if(var15.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var13, var14, var15.field3456);
               }
            }

            if(var1 == 1) {
               class2.region.method2812(var0, var2, var3);
            }

            if(var1 == 2) {
               class2.region.method2685(var0, var2, var3);
               var15 = class251.getObjectDefinition(var12);
               if(var15.sizeX + var2 > 103 || var3 + var15.sizeX > 103 || var15.sizeY + var2 > 103 || var3 + var15.sizeY > 103) {
                  return;
               }

               if(var15.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var15.sizeX, var15.sizeY, var14, var15.field3456);
               }
            }

            if(var1 == 3) {
               class2.region.method2686(var0, var2, var3);
               var15 = class251.getObjectDefinition(var12);
               if(var15.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var33 = class2.region;
            CollisionData var34 = Client.collisionMaps[var0];
            ObjectComposition var35 = class251.getObjectDefinition(var4);
            int var16;
            int var36;
            if(var5 != 1 && var5 != 3) {
               var36 = var35.sizeX;
               var16 = var35.sizeY;
            } else {
               var36 = var35.sizeY;
               var16 = var35.sizeX;
            }

            int var17;
            int var18;
            if(var36 + var2 <= 104) {
               var17 = (var36 >> 1) + var2;
               var18 = var2 + (var36 + 1 >> 1);
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

            int[][] var21 = class61.tileHeights[var11];
            int var22 = var21[var17][var20] + var21[var17][var19] + var21[var18][var19] + var21[var18][var20] >> 2;
            int var23 = (var2 << 7) + (var36 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
            if(var35.field3488 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var35.field3451 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var35.animationId == -1 && var35.impostorIds == null) {
                  var27 = var35.method4518(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
               }

               var33.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var35.interactType == 1) {
                  var34.block(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method4518(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.method2679(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var35.interactType != 0) {
                     var34.addObject(var2, var3, var36, var16, var35.field3456);
                  }
               } else if(var6 == 0) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method4518(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field775[var5], 0, var25, var26);
                  if(var35.interactType != 0) {
                     var34.addWall(var2, var3, var6, var5, var35.field3456);
                  }
               } else if(var6 == 1) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method4518(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field776[var5], 0, var25, var26);
                  if(var35.interactType != 0) {
                     var34.addWall(var2, var3, var6, var5, var35.field3456);
                  }
               } else {
                  Object var28;
                  int var29;
                  if(var6 == 2) {
                     var29 = var5 + 1 & 3;
                     Object var30;
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var30 = var35.method4518(2, var5 + 4, var21, var23, var22, var24);
                        var28 = var35.method4518(2, var29, var21, var23, var22, var24);
                     } else {
                        var30 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        var28 = new DynamicObject(var4, 2, var29, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.addBoundary(var0, var2, var3, var22, (Renderable)var30, (Renderable)var28, class61.field775[var5], class61.field775[var29], var25, var26);
                     if(var35.interactType != 0) {
                        var34.addWall(var2, var3, var6, var5, var35.field3456);
                     }
                  } else if(var6 == 3) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method4518(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field776[var5], 0, var25, var26);
                     if(var35.interactType != 0) {
                        var34.addWall(var2, var3, var6, var5, var35.field3456);
                     }
                  } else if(var6 == 9) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method4518(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method2679(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var35.interactType != 0) {
                        var34.addObject(var2, var3, var36, var16, var35.field3456);
                     }
                  } else if(var6 == 4) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method4518(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field775[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var37;
                     if(var6 == 5) {
                        var29 = 16;
                        var37 = var33.method2692(var0, var2, var3);
                        if(var37 != 0) {
                           var29 = class251.getObjectDefinition(var37 >> 14 & 32767).field3462;
                        }

                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var28 = var35.method4518(4, var5, var21, var23, var22, var24);
                        } else {
                           var28 = new DynamicObject(var4, 4, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var28, (Renderable)null, class61.field775[var5], 0, class61.field777[var5] * var29, class61.field778[var5] * var29, var25, var26);
                     } else if(var6 == 6) {
                        var29 = 8;
                        var37 = var33.method2692(var0, var2, var3);
                        if(var37 != 0) {
                           var29 = class251.getObjectDefinition(var37 >> 14 & 32767).field3462 / 2;
                        }

                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var28 = var35.method4518(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var28 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var28, (Renderable)null, 256, var5, class61.field772[var5] * var29, class61.field786[var5] * var29, var25, var26);
                     } else if(var6 == 7) {
                        var37 = var5 + 2 & 3;
                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var27 = var35.method4518(4, var37 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var37 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var37, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var29 = 8;
                        var37 = var33.method2692(var0, var2, var3);
                        if(var37 != 0) {
                           var29 = class251.getObjectDefinition(var37 >> 14 & 32767).field3462 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var32;
                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var28 = var35.method4518(4, var5 + 4, var21, var23, var22, var24);
                           var32 = var35.method4518(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var28 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                           var32 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var28, (Renderable)var32, 256, var5, class61.field772[var5] * var29, class61.field786[var5] * var29, var25, var26);
                     }
                  }
               }
            } else {
               if(var35.animationId == -1 && var35.impostorIds == null) {
                  var27 = var35.method4518(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var33.method2679(var0, var2, var3, var22, var36, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var35.interactType != 0) {
                  var34.addObject(var2, var3, var36, var16, var35.field3456);
               }
            }
         }
      }

   }
}
