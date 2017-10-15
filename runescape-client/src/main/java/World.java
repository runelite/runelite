import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("World")
public class World {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1075048531
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1686865209
   )
   static int field1284;
   @ObfuscatedName("g")
   static int[] field1285;
   @ObfuscatedName("v")
   static int[] field1280;
   @ObfuscatedName("q")
   @Export("offsetsY")
   public static int[] offsetsY;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("listFetcher")
   static class148 listFetcher;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1785058991
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1299938273
   )
   @Export("index")
   int index;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1241508147
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("u")
   @Export("address")
   String address;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1697174487
   )
   @Export("id")
   int id;
   @ObfuscatedName("b")
   @Export("activity")
   String activity;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1669984009
   )
   @Export("location")
   int location;

   static {
      worldCount = 0;
      field1284 = 0;
      field1285 = new int[]{1, 1, 1, 1};
      field1280 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "466130480"
   )
   boolean method1638() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-18679"
   )
   boolean method1635() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-55"
   )
   boolean method1617() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   boolean method1615() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   boolean method1631() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "220"
   )
   boolean method1614() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIILem;Lfq;I)V",
      garbageValue = "688590191"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field773) {
            class61.field773 = var0;
         }

         ObjectComposition var8 = Occluder.getObjectDefinition(var3);
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
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3439 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3478 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method4633()) {
            class80 var21 = new class80();
            var21.field1312 = var0;
            var21.field1311 = var1 * 128;
            var21.field1326 = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var21.field1319 = 128 * (var22 + var1);
            var21.field1316 = 128 * (var23 + var2);
            var21.field1318 = var8.ambientSoundId;
            var21.field1317 = var8.field3483 * 128;
            var21.field1320 = var8.field3445;
            var21.field1321 = var8.field3470;
            var21.field1322 = var8.field3486;
            if(var8.impostorIds != null) {
               var21.field1325 = var8;
               var21.method1657();
            }

            class80.field1324.addFront(var21);
            if(var21.field1322 != null) {
               var21.field1323 = var21.field1320 + (int)(Math.random() * (double)(var21.field1321 - var21.field1320));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3439 != 0 || var8.interactType == 1 || var8.field3476) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.interactType == 1 && var7 != null) {
                  var7.block(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2767(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class168.field2350[var0][var1][var2] |= 2340;
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3456);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field783[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class174.field2411[var0][var1][var2] = 50;
                     class174.field2411[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class168.field2350[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class174.field2411[var0][var1][var2 + 1] = 50;
                     class174.field2411[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class168.field2350[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class174.field2411[var0][var1 + 1][var2] = 50;
                     class174.field2411[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class168.field2350[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class174.field2411[var0][var1][var2] = 50;
                     class174.field2411[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     class168.field2350[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addWall(var1, var2, var5, var4, var8.field3456);
               }

               if(var8.field3462 != 16) {
                  var6.method2834(var0, var1, var2, var8.field3462);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field771[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class174.field2411[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class174.field2411[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class174.field2411[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class174.field2411[var0][var1][var2] = 50;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addWall(var1, var2, var5, var4, var8.field3456);
               }

            } else {
               int var26;
               Object var28;
               if(var5 == 2) {
                  var26 = var4 + 1 & 3;
                  Object var27;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.getModel(2, var26, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var28 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field783[var4], class61.field783[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        class168.field2350[var0][var1][var2] |= 585;
                        class168.field2350[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class168.field2350[var0][var1][1 + var2] |= 1170;
                        class168.field2350[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class168.field2350[var0][var1 + 1][var2] |= 585;
                        class168.field2350[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class168.field2350[var0][var1][var2] |= 1170;
                        class168.field2350[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3456);
                  }

                  if(var8.field3462 != 16) {
                     var6.method2834(var0, var1, var2, var8.field3462);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field771[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class174.field2411[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class174.field2411[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class174.field2411[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class174.field2411[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3456);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2767(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3456);
                  }

                  if(var8.field3462 != 16) {
                     var6.method2834(var0, var1, var2, var8.field3462);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field783[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2848(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Occluder.getObjectDefinition(var22 >> 14 & 32767).field3462;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field783[var4], 0, var26 * class61.field782[var4], var26 * class61.field770[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2848(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Occluder.getObjectDefinition(var22 >> 14 & 32767).field3462 / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field774[var4], var26 * class61.field775[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method2848(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Occluder.getObjectDefinition(var22 >> 14 & 32767).field3462 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.getModel(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field774[var4], var26 * class61.field775[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2767(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2596() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class174.field2411[var0][var23 + var1][var24 + var2]) {
                        class174.field2411[var0][var23 + var1][var24 + var2] = (byte)var22;
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
