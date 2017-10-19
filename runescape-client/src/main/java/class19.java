import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class19 implements Comparator {
   @ObfuscatedName("n")
   static int[] field333;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(La;La;I)I",
      garbageValue = "632979022"
   )
   int method143(class14 var1, class14 var2) {
      return var1.field293 < var2.field293?-1:(var1.field293 == var2.field293?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method143((class14)var1, (class14)var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljh;Ljh;I)V",
      garbageValue = "-1735725105"
   )
   static void method144(Font var0, Font var1) {
      if(class11.field274 == null) {
         class11.field274 = SceneTilePaint.method2714(class3.indexSprites, "sl_back", "");
      }

      if(class9.field263 == null) {
         class9.field263 = class219.method4135(class3.indexSprites, "sl_flags", "");
      }

      if(class56.field697 == null) {
         class56.field697 = class219.method4135(class3.indexSprites, "sl_arrows", "");
      }

      if(WorldMapType1.field438 == null) {
         WorldMapType1.field438 = class219.method4135(class3.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method5045(class90.field1413, 23, 765, 480, 0);
      Rasterizer2D.method5052(class90.field1413, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method5052(class90.field1413 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4845("Select a world", class90.field1413 + 62, 15, 0, -1);
      if(WorldMapType1.field438 != null) {
         WorldMapType1.field438[1].method5147(class90.field1413 + 140, 1);
         var1.method4842("Members only world", class90.field1413 + 152, 10, 16777215, -1);
         WorldMapType1.field438[0].method5147(class90.field1413 + 140, 12);
         var1.method4842("Free world", class90.field1413 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class56.field697 != null) {
         int var2 = class90.field1413 + 280;
         if(World.field1286[0] == 0 && World.field1284[0] == 0) {
            class56.field697[2].method5147(var2, 4);
         } else {
            class56.field697[0].method5147(var2, 4);
         }

         if(World.field1286[0] == 0 && World.field1284[0] == 1) {
            class56.field697[3].method5147(var2 + 15, 4);
         } else {
            class56.field697[1].method5147(var2 + 15, 4);
         }

         var0.method4842("World", var2 + 32, 17, 16777215, -1);
         int var3 = class90.field1413 + 390;
         if(World.field1286[0] == 1 && World.field1284[0] == 0) {
            class56.field697[2].method5147(var3, 4);
         } else {
            class56.field697[0].method5147(var3, 4);
         }

         if(World.field1286[0] == 1 && World.field1284[0] == 1) {
            class56.field697[3].method5147(var3 + 15, 4);
         } else {
            class56.field697[1].method5147(var3 + 15, 4);
         }

         var0.method4842("Players", var3 + 32, 17, 16777215, -1);
         var4 = class90.field1413 + 500;
         if(World.field1286[0] == 2 && World.field1284[0] == 0) {
            class56.field697[2].method5147(var4, 4);
         } else {
            class56.field697[0].method5147(var4, 4);
         }

         if(World.field1286[0] == 2 && World.field1284[0] == 1) {
            class56.field697[3].method5147(var4 + 15, 4);
         } else {
            class56.field697[1].method5147(var4 + 15, 4);
         }

         var0.method4842("Location", var4 + 32, 17, 16777215, -1);
         var5 = class90.field1413 + 610;
         if(World.field1286[0] == 3 && World.field1284[0] == 0) {
            class56.field697[2].method5147(var5, 4);
         } else {
            class56.field697[0].method5147(var5, 4);
         }

         if(World.field1286[0] == 3 && World.field1284[0] == 1) {
            class56.field697[3].method5147(var5 + 15, 4);
         } else {
            class56.field697[1].method5147(var5 + 15, 4);
         }

         var0.method4842("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method5045(class90.field1413 + 708, 4, 50, 16, 0);
      var1.method4845("Cancel", class90.field1413 + 708 + 25, 16, 16777215, -1);
      class90.field1428 = -1;
      if(class11.field274 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.worldCount) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var4 * var21) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var22 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var21 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var5 * var22 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class90.field1413;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
            World var15 = class266.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method1551()) {
               if(var15.method1546()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1550()) {
               var19 = 16711680;
               if(var15.method1546()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1548()) {
               if(var15.method1546()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1546()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.field756 >= var11 && MouseInput.field741 >= var10 && MouseInput.field756 < var11 + var21 && MouseInput.field741 < var10 + var22 && var16) {
               class90.field1428 = var14;
               class11.field274[var18].method5177(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class11.field274[var18].method5172(var11, var10);
            }

            if(class9.field263 != null) {
               class9.field263[(var15.method1546()?8:0) + var15.location].method5147(var11 + 29, var10);
            }

            var0.method4845(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.method4845(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var7 + var22;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4848(class266.worldList[class90.field1428].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.method5045(MouseInput.field756 - var14 / 2, MouseInput.field741 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.field756 - var14 / 2, MouseInput.field741 + 20 + 5, var14, var20, 0);
            var1.method4845(class266.worldList[class90.field1428].activity, MouseInput.field756, MouseInput.field741 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
         }
      }

      GameEngine.field733.vmethod5121(0, 0);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1718891326"
   )
   static void method150() {
      if(class90.field1440) {
         class90.field1414 = null;
         World.field1293 = null;
         class90.field1415 = null;
         class90.field1427 = null;
         class8.field250 = null;
         class29.logoSprite = null;
         class252.titlemuteSprite = null;
         class90.field1417 = null;
         class29.field430 = null;
         class11.field274 = null;
         class9.field263 = null;
         class56.field697 = null;
         WorldMapType1.field438 = null;
         Buffer.field2391 = null;
         class294.field3916 = null;
         class17.field322 = null;
         class219.field2789 = null;
         Signlink.field2231 = null;
         Frames.field2125 = null;
         class164.field2312 = null;
         class90.field1425 = null;
         World.field1285 = null;
         class164.method3140(2);
         class34.sendConInfo(true);
         class90.field1440 = false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIILeu;Lfw;I)V",
      garbageValue = "-2095223213"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field770) {
            class61.field770 = var0;
         }

         ObjectComposition var8 = CollisionData.getObjectDefinition(var3);
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
         int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3454 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3475 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method4610()) {
            class80 var21 = new class80();
            var21.field1312 = var0;
            var21.field1313 = var1 * 128;
            var21.field1314 = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var21.field1315 = (var22 + var1) * 128;
            var21.field1316 = (var23 + var2) * 128;
            var21.field1318 = var8.ambientSoundId;
            var21.field1311 = var8.field3480 * 128;
            var21.field1320 = var8.field3443;
            var21.field1321 = var8.field3458;
            var21.field1319 = var8.field3483;
            if(var8.impostorIds != null) {
               var21.field1325 = var8;
               var21.method1601();
            }

            class80.field1323.addFront(var21);
            if(var21.field1319 != null) {
               var21.field1322 = var21.field1320 + (int)(Math.random() * (double)(var21.field1321 - var21.field1320));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3454 != 0 || var8.interactType == 1 || var8.field3473) {
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

               var6.method2727(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class268.field3673[var0][var1][var2] |= 2340;
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3453);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field774[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class7.field248[var0][var1][var2] = 50;
                     class7.field248[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class268.field3673[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class7.field248[var0][var1][var2 + 1] = 50;
                     class7.field248[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class268.field3673[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class7.field248[var0][var1 + 1][var2] = 50;
                     class7.field248[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class268.field3673[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class7.field248[var0][var1][var2] = 50;
                     class7.field248[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     class268.field3673[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addWall(var1, var2, var5, var4, var8.field3453);
               }

               if(var8.field3474 != 16) {
                  var6.method2733(var0, var1, var2, var8.field3474);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field785[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class7.field248[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class7.field248[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class7.field248[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class7.field248[var0][var1][var2] = 50;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addWall(var1, var2, var5, var4, var8.field3453);
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

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field774[var4], class61.field774[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        class268.field3673[var0][var1][var2] |= 585;
                        class268.field3673[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class268.field3673[var0][var1][var2 + 1] |= 1170;
                        class268.field3673[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class268.field3673[var0][var1 + 1][var2] |= 585;
                        class268.field3673[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class268.field3673[var0][var1][var2] |= 1170;
                        class268.field3673[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3453);
                  }

                  if(var8.field3474 != 16) {
                     var6.method2733(var0, var1, var2, var8.field3474);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field785[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class7.field248[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class7.field248[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class7.field248[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class7.field248[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3453);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2727(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3453);
                  }

                  if(var8.field3474 != 16) {
                     var6.method2733(var0, var1, var2, var8.field3474);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field774[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2775(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = CollisionData.getObjectDefinition(var22 >> 14 & 32767).field3474;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field774[var4], 0, var26 * class61.field776[var4], var26 * class61.field780[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2775(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = CollisionData.getObjectDefinition(var22 >> 14 & 32767).field3474 / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field768[var4], var26 * class61.field775[var4], var19, var20);
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
                  var22 = var6.method2775(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = CollisionData.getObjectDefinition(var22 >> 14 & 32767).field3474 / 2;
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

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field768[var4], var26 * class61.field775[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2727(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2595() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class7.field248[var0][var23 + var1][var24 + var2]) {
                        class7.field248[var0][var23 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.interactType != 0 && var7 != null) {
               var7.addObject(var1, var2, var9, var10, var8.field3453);
            }

         }
      }
   }
}
