import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("ParamDefinition")
public class ParamDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("ParamDefinition_archive")
   public static AbstractArchive ParamDefinition_archive;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("ParamDefinition_cached")
   static EvictingDualNodeHashTable ParamDefinition_cached;
   @ObfuscatedName("q")
   @Export("type")
   char type;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1133042753
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("o")
   @Export("defaultStr")
   public String defaultStr;
   @ObfuscatedName("u")
   @Export("autoDisable")
   boolean autoDisable;

   ParamDefinition() {
      this.autoDisable = true;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   @Export("postDecode")
   void postDecode() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-975533635"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while (true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "1664350313"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.type = class14.method171(var1.readByte());
      } else if (var2 == 2) {
         this.defaultInt = var1.readInt();
      } else if (var2 == 4) {
         this.autoDisable = false;
      } else if (var2 == 5) {
         this.defaultStr = var1.readStringCp1252NullTerminated();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1897943299"
   )
   @Export("isString")
   public boolean isString() {
      return this.type == 's';
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-904254947"
   )
   @Export("addPendingSpawnToScene")
   static final void addPendingSpawnToScene(int plane, int objectType, int x, int y, int id, int orientation, int var6) {
      if (x >= 1 && y >= 1 && x <= 102 && y <= 102) {
         if (Client.isLowDetail && plane != SoundSystem.plane) {
            return;
         }

         long var7 = 0L;
         boolean var9 = true;
         boolean var10 = false;
         boolean var11 = false;
         if (objectType == 0) {
            var7 = class65.scene.getBoundaryObjectTag(plane, x, y);
         }

         if (objectType == 1) {
            var7 = class65.scene.getWallDecorationTag(plane, x, y);
         }

         if (objectType == 2) {
            var7 = class65.scene.getGameObjectTag(plane, x, y);
         }

         if (objectType == 3) {
            var7 = class65.scene.getFloorDecorationTag(plane, x, y);
         }

         int var12;
         if (0L != var7) {
            var12 = class65.scene.getObjectFlags(plane, x, y, var7);
            int var13 = HitSplatDefinition.method4972(var7);
            int var14 = var12 & 31;
            int var15 = var12 >> 6 & 3;
            ObjectDefinition var16;
            if (objectType == 0) {
               class65.scene.removeBoundaryObject(plane, x, y);
               var16 = class50.getObjectDefinition(var13);
               if (var16.interactType != 0) {
                  Client.collisionMaps[plane].method95(x, y, var14, var15, var16.boolean1);
               }
            }

            if (objectType == 1) {
               class65.scene.removeWallDecoration(plane, x, y);
            }

            if (objectType == 2) {
               class65.scene.method288(plane, x, y);
               var16 = class50.getObjectDefinition(var13);
               if (x + var16.sizeX > 103 || y + var16.sizeX > 103 || x + var16.sizeY > 103 || y + var16.sizeY > 103) {
                  return;
               }

               if (var16.interactType != 0) {
                  Client.collisionMaps[plane].method96(x, y, var16.sizeX, var16.sizeY, var15, var16.boolean1);
               }
            }

            if (objectType == 3) {
               class65.scene.removeFloorDecoration(plane, x, y);
               var16 = class50.getObjectDefinition(var13);
               if (var16.interactType == 1) {
                  Client.collisionMaps[plane].method98(x, y);
               }
            }
         }

         if (id >= 0) {
            var12 = plane;
            if (plane < 3 && (Tiles.Tiles_renderFlags[1][x][y] & 2) == 2) {
               var12 = plane + 1;
            }

            Scene var36 = class65.scene;
            CollisionMap var37 = Client.collisionMaps[plane];
            ObjectDefinition var38 = class50.getObjectDefinition(id);
            int var17;
            int var39;
            if (orientation != 1 && orientation != 3) {
               var17 = var38.sizeX;
               var39 = var38.sizeY;
            } else {
               var17 = var38.sizeY;
               var39 = var38.sizeX;
            }

            int var18;
            int var19;
            if (var17 + x <= 104) {
               var18 = (var17 >> 1) + x;
               var19 = x + (var17 + 1 >> 1);
            } else {
               var18 = x;
               var19 = x + 1;
            }

            int var20;
            int var21;
            if (y + var39 <= 104) {
               var20 = y + (var39 >> 1);
               var21 = y + (var39 + 1 >> 1);
            } else {
               var20 = y;
               var21 = y + 1;
            }

            int[][] var22 = Tiles.Tiles_heights[var12];
            int var23 = var22[var18][var21] + var22[var19][var20] + var22[var18][var20] + var22[var19][var21] >> 2;
            int var24 = (x << 7) + (var17 << 6);
            int var25 = (y << 7) + (var39 << 6);
            long var26 = FontName.calculateTag(x, y, 2, var38.int1 == 0, id);
            int var28 = (orientation << 6) + var6;
            if (var38.int3 == 1) {
               var28 += 256;
            }

            Object var29;
            if (var6 == 22) {
               if (var38.animationId == -1 && var38.transforms == null) {
                  var29 = var38.getModel(22, orientation, var22, var24, var23, var25);
               } else {
                  var29 = new DynamicObject(id, 22, orientation, var12, x, y, var38.animationId, true, (Entity)null);
               }

               var36.newFloorDecoration(plane, x, y, var23, (Entity)var29, var26, var28);
               if (var38.interactType == 1) {
                  var37.method93(x, y);
               }
            } else if (var6 != 10 && var6 != 11) {
               if (var6 >= 12) {
                  if (var38.animationId == -1 && var38.transforms == null) {
                     var29 = var38.getModel(var6, orientation, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(id, var6, orientation, var12, x, y, var38.animationId, true, (Entity)null);
                  }

                  var36.method284(plane, x, y, var23, 1, 1, (Entity)var29, 0, var26, var28);
                  if (var38.interactType != 0) {
                     var37.method91(x, y, var17, var39, var38.boolean1);
                  }
               } else if (var6 == 0) {
                  if (var38.animationId == -1 && var38.transforms == null) {
                     var29 = var38.getModel(0, orientation, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(id, 0, orientation, var12, x, y, var38.animationId, true, (Entity)null);
                  }

                  var36.newBoundaryObject(plane, x, y, var23, (Entity)var29, (Entity)null, Tiles.field911[orientation], 0, var26, var28);
                  if (var38.interactType != 0) {
                     var37.method90(x, y, var6, orientation, var38.boolean1);
                  }
               } else if (var6 == 1) {
                  if (var38.animationId == -1 && var38.transforms == null) {
                     var29 = var38.getModel(1, orientation, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(id, 1, orientation, var12, x, y, var38.animationId, true, (Entity)null);
                  }

                  var36.newBoundaryObject(plane, x, y, var23, (Entity)var29, (Entity)null, Tiles.field912[orientation], 0, var26, var28);
                  if (var38.interactType != 0) {
                     var37.method90(x, y, var6, orientation, var38.boolean1);
                  }
               } else {
                  int var30;
                  Object var31;
                  if (var6 == 2) {
                     var30 = orientation + 1 & 3;
                     Object var32;
                     if (var38.animationId == -1 && var38.transforms == null) {
                        var31 = var38.getModel(2, orientation + 4, var22, var24, var23, var25);
                        var32 = var38.getModel(2, var30, var22, var24, var23, var25);
                     } else {
                        var31 = new DynamicObject(id, 2, orientation + 4, var12, x, y, var38.animationId, true, (Entity)null);
                        var32 = new DynamicObject(id, 2, var30, var12, x, y, var38.animationId, true, (Entity)null);
                     }

                     var36.newBoundaryObject(plane, x, y, var23, (Entity)var31, (Entity)var32, Tiles.field911[orientation], Tiles.field911[var30], var26, var28);
                     if (var38.interactType != 0) {
                        var37.method90(x, y, var6, orientation, var38.boolean1);
                     }
                  } else if (var6 == 3) {
                     if (var38.animationId == -1 && var38.transforms == null) {
                        var29 = var38.getModel(3, orientation, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(id, 3, orientation, var12, x, y, var38.animationId, true, (Entity)null);
                     }

                     var36.newBoundaryObject(plane, x, y, var23, (Entity)var29, (Entity)null, Tiles.field912[orientation], 0, var26, var28);
                     if (var38.interactType != 0) {
                        var37.method90(x, y, var6, orientation, var38.boolean1);
                     }
                  } else if (var6 == 9) {
                     if (var38.animationId == -1 && var38.transforms == null) {
                        var29 = var38.getModel(var6, orientation, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(id, var6, orientation, var12, x, y, var38.animationId, true, (Entity)null);
                     }

                     var36.method284(plane, x, y, var23, 1, 1, (Entity)var29, 0, var26, var28);
                     if (var38.interactType != 0) {
                        var37.method91(x, y, var17, var39, var38.boolean1);
                     }
                  } else if (var6 == 4) {
                     if (var38.animationId == -1 && var38.transforms == null) {
                        var29 = var38.getModel(4, orientation, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(id, 4, orientation, var12, x, y, var38.animationId, true, (Entity)null);
                     }

                     var36.newWallDecoration(plane, x, y, var23, (Entity)var29, (Entity)null, Tiles.field911[orientation], 0, 0, 0, var26, var28);
                  } else {
                     long var40;
                     if (var6 == 5) {
                        var30 = 16;
                        var40 = var36.getBoundaryObjectTag(plane, x, y);
                        if (var40 != 0L) {
                           var30 = class50.getObjectDefinition(HitSplatDefinition.method4972(var40)).int2;
                        }

                        if (var38.animationId == -1 && var38.transforms == null) {
                           var31 = var38.getModel(4, orientation, var22, var24, var23, var25);
                        } else {
                           var31 = new DynamicObject(id, 4, orientation, var12, x, y, var38.animationId, true, (Entity)null);
                        }

                        var36.newWallDecoration(plane, x, y, var23, (Entity)var31, (Entity)null, Tiles.field911[orientation], 0, var30 * Tiles.field913[orientation], var30 * Tiles.field914[orientation], var26, var28);
                     } else if (var6 == 6) {
                        var30 = 8;
                        var40 = var36.getBoundaryObjectTag(plane, x, y);
                        if (var40 != 0L) {
                           var30 = class50.getObjectDefinition(HitSplatDefinition.method4972(var40)).int2 / 2;
                        }

                        if (var38.animationId == -1 && var38.transforms == null) {
                           var31 = var38.getModel(4, orientation + 4, var22, var24, var23, var25);
                        } else {
                           var31 = new DynamicObject(id, 4, orientation + 4, var12, x, y, var38.animationId, true, (Entity)null);
                        }

                        var36.newWallDecoration(plane, x, y, var23, (Entity)var31, (Entity)null, 256, orientation, var30 * Tiles.field915[orientation], var30 * Tiles.field916[orientation], var26, var28);
                     } else {
                        int var34;
                        if (var6 == 7) {
                           var34 = orientation + 2 & 3;
                           if (var38.animationId == -1 && var38.transforms == null) {
                              var29 = var38.getModel(4, var34 + 4, var22, var24, var23, var25);
                           } else {
                              var29 = new DynamicObject(id, 4, var34 + 4, var12, x, y, var38.animationId, true, (Entity)null);
                           }

                           var36.newWallDecoration(plane, x, y, var23, (Entity)var29, (Entity)null, 256, var34, 0, 0, var26, var28);
                        } else if (var6 == 8) {
                           var30 = 8;
                           var40 = var36.getBoundaryObjectTag(plane, x, y);
                           if (var40 != 0L) {
                              var30 = class50.getObjectDefinition(HitSplatDefinition.method4972(var40)).int2 / 2;
                           }

                           var34 = orientation + 2 & 3;
                           Object var35;
                           if (var38.animationId == -1 && var38.transforms == null) {
                              var31 = var38.getModel(4, orientation + 4, var22, var24, var23, var25);
                              var35 = var38.getModel(4, var34 + 4, var22, var24, var23, var25);
                           } else {
                              var31 = new DynamicObject(id, 4, orientation + 4, var12, x, y, var38.animationId, true, (Entity)null);
                              var35 = new DynamicObject(id, 4, var34 + 4, var12, x, y, var38.animationId, true, (Entity)null);
                           }

                           var36.newWallDecoration(plane, x, y, var23, (Entity)var31, (Entity)var35, 256, orientation, var30 * Tiles.field915[orientation], var30 * Tiles.field916[orientation], var26, var28);
                        }
                     }
                  }
               }
            } else {
               if (var38.animationId == -1 && var38.transforms == null) {
                  var29 = var38.getModel(10, orientation, var22, var24, var23, var25);
               } else {
                  var29 = new DynamicObject(id, 10, orientation, var12, x, y, var38.animationId, true, (Entity)null);
               }

               if (var29 != null) {
                  var36.method284(plane, x, y, var23, var17, var39, (Entity)var29, var6 == 11 ? 256 : 0, var26, var28);
               }

               if (var38.interactType != 0) {
                  var37.method91(x, y, var17, var39, var38.boolean1);
               }
            }
         }
      }

   }

   static {
      ParamDefinition_cached = new EvictingDualNodeHashTable(64);
   }
}
