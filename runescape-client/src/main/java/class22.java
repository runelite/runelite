import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class22 extends class28 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1910626575
   )
   static int field317;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexModels")
   static IndexData indexModels;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;Lfs;B)V",
      garbageValue = "-8"
   )
   void method155(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field472.field464) {
         throw new IllegalStateException("");
      } else {
         super.field388 = var2.readUnsignedByte();
         super.field380 = var2.readUnsignedByte();
         super.field386 = var2.readUnsignedShort();
         super.field376 = var2.readUnsignedShort();
         super.field385 = var2.readUnsignedShort();
         super.field378 = var2.readUnsignedShort();
         super.field380 = Math.min(super.field380, 4);
         super.field377 = new short[1][64][64];
         super.field382 = new short[super.field380][64][64];
         super.field383 = new byte[super.field380][64][64];
         super.field379 = new byte[super.field380][64][64];
         super.field384 = new class31[super.field380][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field462.field458) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field385 && var5 == super.field378) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method217(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field385 == super.field385 && super.field378 == var2.field378;
      }
   }

   public int hashCode() {
      return super.field385 | super.field378 << 8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIILeo;Lfy;B)V",
      garbageValue = "-82"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field705) {
            class61.field705 = var0;
         }

         ObjectComposition var8 = ClientPacket.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3486 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3521 == 1) {
            var20 += 256;
         }

         if(var8.method4539()) {
            class47.method664(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3486 != 0 || var8.interactType == 1 || var8.field3524) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.interactType == 1 && var7 != null) {
                  var7.block(var1, var2);
               }

            }
         } else {
            int var27;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2698(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class27.field368[var0][var1][var2] |= 2340;
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3504);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field709[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        class175.field2440[var0][var1][var2] = 50;
                        class175.field2440[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class27.field368[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        class175.field2440[var0][var1][var2 + 1] = 50;
                        class175.field2440[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class27.field368[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        class175.field2440[var0][var1 + 1][var2] = 50;
                        class175.field2440[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class27.field368[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        class175.field2440[var0][var1][var2] = 50;
                        class175.field2440[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        class27.field368[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3504);
                  }

                  if(var8.field3515 != 16) {
                     var6.method2704(var0, var1, var2, var8.field3515);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field710[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class175.field2440[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class175.field2440[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class175.field2440[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class175.field2440[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3504);
                  }

               } else {
                  Object var23;
                  int var26;
                  if(var5 == 2) {
                     var26 = var4 + 1 & 3;
                     Object var22;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var22 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                        var23 = var8.getModel(2, var26, var15, var17, var16, var18);
                     } else {
                        var22 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var23 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var22, (Renderable)var23, class61.field709[var4], class61.field709[var26], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           class27.field368[var0][var1][var2] |= 585;
                           class27.field368[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class27.field368[var0][var1][var2 + 1] |= 1170;
                           class27.field368[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class27.field368[var0][var1 + 1][var2] |= 585;
                           class27.field368[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class27.field368[var0][var1][var2] |= 1170;
                           class27.field368[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3504);
                     }

                     if(var8.field3515 != 16) {
                        var6.method2704(var0, var1, var2, var8.field3515);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field710[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class175.field2440[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class175.field2440[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class175.field2440[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class175.field2440[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3504);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2698(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.interactType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.field3504);
                     }

                     if(var8.field3515 != 16) {
                        var6.method2704(var0, var1, var2, var8.field3515);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field709[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var27 = var6.method2714(var0, var1, var2);
                     if(var27 != 0) {
                        var26 = ClientPacket.getObjectDefinition(var27 >> 14 & 32767).field3515;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class61.field709[var4], 0, var26 * class61.field704[var4], var26 * class61.field721[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var27 = var6.method2714(var0, var1, var2);
                     if(var27 != 0) {
                        var26 = ClientPacket.getObjectDefinition(var27 >> 14 & 32767).field3515 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var26 * class61.field713[var4], var26 * class61.field714[var4], var19, var20);
                  } else if(var5 == 7) {
                     var27 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var27 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var27, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var27 = var6.method2714(var0, var1, var2);
                     if(var27 != 0) {
                        var26 = ClientPacket.getObjectDefinition(var27 >> 14 & 32767).field3515 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.getModel(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var23, (Renderable)var29, 256, var4, var26 * class61.field713[var4], var26 * class61.field714[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2698(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var27 = 15;
                  if(var21 instanceof Model) {
                     var27 = ((Model)var21).method2513() / 4;
                     if(var27 > 30) {
                        var27 = 30;
                     }
                  }

                  for(int var28 = 0; var28 <= var9; ++var28) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var27 > class175.field2440[var0][var28 + var1][var24 + var2]) {
                           class175.field2440[var0][var28 + var1][var24 + var2] = (byte)var27;
                        }
                     }
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3504);
               }

            }
         }
      }
   }
}
