import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("listFetcher")
   static class148 listFetcher;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   public static Track1 field863;
   @ObfuscatedName("w")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1600892671"
   )
   static void method1103() {
      if(class90.field1439 && class90.username != null && class90.username.length() > 0) {
         class90.field1422 = 1;
      } else {
         class90.field1422 = 0;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "1136607996"
   )
   static int method1101(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
      } else {
         var3 = var2?class251.field3392:class164.field2314;
      }

      if(var0 == 1927) {
         if(class81.field1337 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2661 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field849 = var3.field2661;
            var4.field854 = class81.field1337 + 1;
            Client.field1113.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(I)Lkk;",
      garbageValue = "-1709423928"
   )
   static RenderOverview method1102() {
      return Client.renderOverview;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1975058231"
   )
   static void method1100() {
      if(class66.localPlayer.x >> 7 == Client.destinationX && class66.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "1"
   )
   static final void method1099(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class46.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class3.region.method2775(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class3.region.method2749(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class3.region.method2850(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class3.region.method2746(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class3.region.method2747(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class3.region.method2734(var0, var2, var3);
               var12 = CollisionData.getObjectDefinition(var34);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var35, var36, var12.field3453);
               }
            }

            if(var1 == 1) {
               class3.region.method2735(var0, var2, var3);
            }

            if(var1 == 2) {
               class3.region.method2736(var0, var2, var3);
               var12 = CollisionData.getObjectDefinition(var34);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field3453);
               }
            }

            if(var1 == 3) {
               class3.region.method2737(var0, var2, var3);
               var12 = CollisionData.getObjectDefinition(var34);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class3.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = CollisionData.getObjectDefinition(var4);
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

            int[][] var21 = class61.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var18][var19] + var21[var17][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.field3454 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field3475 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4606(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.interactType == 1) {
                  var13.block(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4606(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2727(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addObject(var2, var3, var15, var16, var14.field3453);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4606(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field774[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addWall(var2, var3, var6, var5, var14.field3453);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4606(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field785[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addWall(var2, var3, var6, var5, var14.field3453);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method4606(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method4606(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class61.field774[var5], class61.field774[var32], var25, var26);
                     if(var14.interactType != 0) {
                        var13.addWall(var2, var3, var6, var5, var14.field3453);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4606(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field785[var5], 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.addWall(var2, var3, var6, var5, var14.field3453);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4606(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2727(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.addObject(var2, var3, var15, var16, var14.field3453);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4606(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field774[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method2775(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = CollisionData.getObjectDefinition(var33 >> 14 & 32767).field3474;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4606(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class61.field774[var5], 0, var32 * class61.field776[var5], var32 * class61.field780[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method2775(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = CollisionData.getObjectDefinition(var33 >> 14 & 32767).field3474 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4606(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class61.field768[var5], var32 * class61.field775[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method4606(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method2775(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = CollisionData.getObjectDefinition(var33 >> 14 & 32767).field3474 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4606(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method4606(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class61.field768[var5], var32 * class61.field775[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4606(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2727(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.interactType != 0) {
                  var13.addObject(var2, var3, var15, var16, var14.field3453);
               }
            }
         }
      }

   }
}
