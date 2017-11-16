import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class33 {
   @ObfuscatedName("b")
   String field438;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1868994899
   )
   int field432;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1261893445
   )
   int field437;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   class24 field435;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILv;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field438 = var1;
      this.field432 = var2;
      this.field437 = var3;
      this.field435 = var4;
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "575718167"
   )
   static final void method324(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class28.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Client.region.method2714(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Client.region.method2740(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Client.region.method2716(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Client.region.method2717(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Client.region.method2718(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Client.region.method2705(var0, var2, var3);
               var12 = ClientPacket.getObjectDefinition(var34);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var35, var36, var12.field3504);
               }
            }

            if(var1 == 1) {
               Client.region.method2706(var0, var2, var3);
            }

            if(var1 == 2) {
               Client.region.method2707(var0, var2, var3);
               var12 = ClientPacket.getObjectDefinition(var34);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field3504);
               }
            }

            if(var1 == 3) {
               Client.region.method2802(var0, var2, var3);
               var12 = ClientPacket.getObjectDefinition(var34);
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

            Region var37 = Client.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = ClientPacket.getObjectDefinition(var4);
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
            int var22 = var21[var18][var20] + var21[var17][var19] + var21[var18][var19] + var21[var17][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.field3486 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field3521 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4545(22, var5, var21, var23, var22, var24);
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
                     var27 = var14.method4545(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2698(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addObject(var2, var3, var15, var16, var14.field3504);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4545(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field709[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addWall(var2, var3, var6, var5, var14.field3504);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4545(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field710[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addWall(var2, var3, var6, var5, var14.field3504);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method4545(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method4545(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class61.field709[var5], class61.field709[var32], var25, var26);
                     if(var14.interactType != 0) {
                        var13.addWall(var2, var3, var6, var5, var14.field3504);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4545(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field710[var5], 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.addWall(var2, var3, var6, var5, var14.field3504);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4545(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2698(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.addObject(var2, var3, var15, var16, var14.field3504);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4545(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field709[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method2714(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = ClientPacket.getObjectDefinition(var33 >> 14 & 32767).field3515;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4545(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class61.field709[var5], 0, var32 * class61.field704[var5], var32 * class61.field721[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method2714(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = ClientPacket.getObjectDefinition(var33 >> 14 & 32767).field3515 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4545(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class61.field713[var5], var32 * class61.field714[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method4545(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method2714(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = ClientPacket.getObjectDefinition(var33 >> 14 & 32767).field3515 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4545(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method4545(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class61.field713[var5], var32 * class61.field714[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4545(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2698(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.interactType != 0) {
                  var13.addObject(var2, var3, var15, var16, var14.field3504);
               }
            }
         }
      }

   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-1869725286"
   )
   static final void method323(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            Client.field943[Client.menuOptionCount] = var6;
            ++Client.menuOptionCount;
         }

      }
   }
}
