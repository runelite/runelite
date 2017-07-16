import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public final class class60 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2023007013
   )
   static int field737;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-1516135467"
   )
   public static int method1036(CharSequence var0, int var1) {
      return class267.parseInt(var0, var1, true);
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "-97"
   )
   static final void method1034(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         Signlink.method2953(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1198 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIILem;Lfv;I)V",
      garbageValue = "1829593573"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field747) {
            class61.field747 = var0;
         }

         ObjectComposition var8 = PlayerComposition.getObjectDefinition(var3);
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
            var11 = var1 + (var9 >> 1);
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3453 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3474 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method4475()) {
            class82 var21 = new class82();
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
            var21.field1319 = (var23 + var2) * 128;
            var21.field1318 = var8.ambientSoundId;
            var21.field1316 = var8.field3457 * 128;
            var21.field1320 = var8.field3480;
            var21.field1317 = var8.field3481;
            var21.field1325 = var8.field3478;
            if(var8.impostorIds != null) {
               var21.field1311 = var8;
               var21.method1576();
            }

            class82.field1322.addFront(var21);
            if(var21.field1325 != null) {
               var21.field1323 = var21.field1320 + (int)(Math.random() * (double)(var21.field1317 - var21.field1320));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3453 != 0 || var8.interactType == 1 || var8.field3472) {
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

               var6.method2808(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class9.field249[var0][var1][var2] |= 2340;
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3452);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field749[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class61.field750[var0][var1][var2] = 50;
                     class61.field750[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class9.field249[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class61.field750[var0][var1][var2 + 1] = 50;
                     class61.field750[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class9.field249[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class61.field750[var0][var1 + 1][var2] = 50;
                     class61.field750[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class9.field249[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class61.field750[var0][var1][var2] = 50;
                     class61.field750[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     class9.field249[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addWall(var1, var2, var5, var4, var8.field3452);
               }

               if(var8.field3458 != 16) {
                  var6.method2682(var0, var1, var2, var8.field3458);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field756[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class61.field750[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class61.field750[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class61.field750[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class61.field750[var0][var1][var2] = 50;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addWall(var1, var2, var5, var4, var8.field3452);
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

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field749[var4], class61.field749[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        class9.field249[var0][var1][var2] |= 585;
                        class9.field249[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class9.field249[var0][var1][1 + var2] |= 1170;
                        class9.field249[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class9.field249[var0][var1 + 1][var2] |= 585;
                        class9.field249[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class9.field249[var0][var1][var2] |= 1170;
                        class9.field249[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3452);
                  }

                  if(var8.field3458 != 16) {
                     var6.method2682(var0, var1, var2, var8.field3458);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field756[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class61.field750[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class61.field750[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class61.field750[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class61.field750[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3452);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2808(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3452);
                  }

                  if(var8.field3458 != 16) {
                     var6.method2682(var0, var1, var2, var8.field3458);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field749[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2688(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = PlayerComposition.getObjectDefinition(var22 >> 14 & 32767).field3458;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field749[var4], 0, var26 * class61.field748[var4], var26 * class61.field752[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2688(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = PlayerComposition.getObjectDefinition(var22 >> 14 & 32767).field3458 / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field757[var4], var26 * class61.field758[var4], var19, var20);
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
                  var22 = var6.method2688(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = PlayerComposition.getObjectDefinition(var22 >> 14 & 32767).field3458 / 2;
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

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field757[var4], var26 * class61.field758[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2808(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2522() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class61.field750[var0][var23 + var1][var24 + var2]) {
                        class61.field750[var0][var23 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.interactType != 0 && var7 != null) {
               var7.addObject(var1, var2, var9, var10, var8.field3452);
            }

         }
      }
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Lhy;II)Ljava/lang/String;",
      garbageValue = "1921831222"
   )
   static String method1033(Widget var0, int var1) {
      return !class90.method1692(class46.getWidgetConfig(var0), var1) && var0.field2753 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
