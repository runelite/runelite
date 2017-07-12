import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class211 {
   @ObfuscatedName("w")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("a")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("i")
   static int[] field2613;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1200693931"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field770) {
            class61.field770 = var0;
         }

         ObjectComposition var8 = class251.getObjectDefinition(var3);
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
            var13 = var2 + (var10 >> 1);
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var12][var13] + var15[var11][var13] + var15[var11][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3488 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3451 == 1) {
            var20 += 256;
         }

         int var21;
         int var22;
         if(var8.method4524()) {
            class82 var23 = new class82();
            var23.field1339 = var0;
            var23.field1340 = var1 * 128;
            var23.field1341 = var2 * 128;
            var21 = var8.sizeX;
            var22 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var21 = var8.sizeY;
               var22 = var8.sizeX;
            }

            var23.field1352 = (var21 + var1) * 128;
            var23.field1343 = (var22 + var2) * 128;
            var23.field1338 = var8.ambientSoundId;
            var23.field1344 = var8.field3491 * 128;
            var23.field1347 = var8.field3492;
            var23.field1348 = var8.field3493;
            var23.field1353 = var8.field3494;
            if(var8.impostorIds != null) {
               var23.field1345 = var8;
               var23.method1617();
            }

            class82.field1349.addFront(var23);
            if(var23.field1353 != null) {
               var23.field1350 = var23.field1347 + (int)(Math.random() * (double)(var23.field1348 - var23.field1347));
            }
         }

         Object var28;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3488 != 0 || var8.interactType == 1 || var8.field3474) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var28 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var28 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var28, var19, var20);
               if(var8.interactType == 1 && var7 != null) {
                  var7.block(var1, var2);
               }
            }
         } else {
            int var24;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2679(var0, var1, var2, var16, 1, 1, (Renderable)var28, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class39.field555[var0][var1][var2] |= 2340;
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3456);
                  }
               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field775[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        class61.field771[var0][var1][var2] = 50;
                        class61.field771[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class39.field555[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        class61.field771[var0][var1][var2 + 1] = 50;
                        class61.field771[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class39.field555[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        class61.field771[var0][var1 + 1][var2] = 50;
                        class61.field771[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class39.field555[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        class61.field771[var0][var1][var2] = 50;
                        class61.field771[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        class39.field555[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3456);
                  }

                  if(var8.field3462 != 16) {
                     var6.method2845(var0, var1, var2, var8.field3462);
                  }
               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field776[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class61.field771[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class61.field771[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class61.field771[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class61.field771[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3456);
                  }
               } else {
                  Object var25;
                  if(var5 == 2) {
                     var24 = var4 + 1 & 3;
                     Object var26;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var26 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                        var25 = var8.getModel(2, var24, var15, var17, var16, var18);
                     } else {
                        var26 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var25 = new DynamicObject(var3, 2, var24, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var26, (Renderable)var25, class61.field775[var4], class61.field775[var24], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           class39.field555[var0][var1][var2] |= 585;
                           class39.field555[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class39.field555[var0][var1][var2 + 1] |= 1170;
                           class39.field555[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class39.field555[var0][var1 + 1][var2] |= 585;
                           class39.field555[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class39.field555[var0][var1][var2] |= 1170;
                           class39.field555[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3456);
                     }

                     if(var8.field3462 != 16) {
                        var6.method2845(var0, var1, var2, var8.field3462);
                     }
                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field776[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class61.field771[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class61.field771[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class61.field771[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class61.field771[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3456);
                     }
                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2679(var0, var1, var2, var16, 1, 1, (Renderable)var28, 0, var19, var20);
                     if(var8.interactType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.field3456);
                     }

                     if(var8.field3462 != 16) {
                        var6.method2845(var0, var1, var2, var8.field3462);
                     }
                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field775[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var24 = 16;
                     var21 = var6.method2692(var0, var1, var2);
                     if(var21 != 0) {
                        var24 = class251.getObjectDefinition(var21 >> 14 & 32767).field3462;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var25 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var25 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, class61.field775[var4], 0, var24 * class61.field777[var4], var24 * class61.field778[var4], var19, var20);
                  } else if(var5 == 6) {
                     var24 = 8;
                     var21 = var6.method2692(var0, var1, var2);
                     if(var21 != 0) {
                        var24 = class251.getObjectDefinition(var21 >> 14 & 32767).field3462 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var25 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, 256, var4, var24 * class61.field772[var4], var24 * class61.field786[var4], var19, var20);
                  } else if(var5 == 7) {
                     var21 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var21 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var21 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var21, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var24 = 8;
                     var21 = var6.method2692(var0, var1, var2);
                     if(var21 != 0) {
                        var24 = class251.getObjectDefinition(var21 >> 14 & 32767).field3462 / 2;
                     }

                     int var29 = var4 + 2 & 3;
                     Object var27;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var25 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                        var27 = var8.getModel(4, var29 + 4, var15, var17, var16, var18);
                     } else {
                        var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var27 = new DynamicObject(var3, 4, var29 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)var27, 256, var4, var24 * class61.field772[var4], var24 * class61.field786[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var28 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var28 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var28 != null && var6.method2679(var0, var1, var2, var16, var9, var10, (Renderable)var28, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var21 = 15;
                  if(var28 instanceof Model) {
                     var21 = ((Model)var28).method2553() / 4;
                     if(var21 > 30) {
                        var21 = 30;
                     }
                  }

                  for(var22 = 0; var22 <= var9; ++var22) {
                     for(var24 = 0; var24 <= var10; ++var24) {
                        if(var21 > class61.field771[var0][var22 + var1][var24 + var2]) {
                           class61.field771[var0][var22 + var1][var24 + var2] = (byte)var21;
                        }
                     }
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3456);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LInvType;",
      garbageValue = "1972520542"
   )
   public static InvType method3908(int var0) {
      InvType var1 = (InvType)InvType.field3286.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3285.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.field3286.put(var1, (long)var0);
         return var1;
      }
   }

   static {
      field2613 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2613[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
