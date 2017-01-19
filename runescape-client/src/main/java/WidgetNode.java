import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 828742945
   )
   int field193;
   @ObfuscatedName("f")
   boolean field194 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -615390513
   )
   @Export("id")
   int id;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 227585393
   )
   static int field200;
   @ObfuscatedName("bo")
   static class184 field201;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1165101590"
   )
   static void method158() {
      Client.field336.offset = 0;
      Client.field352.offset = 0;
      Client.packetOpcode = -1;
      Client.field480 = -1;
      Client.field552 = -1;
      Client.field345 = -1;
      Client.field339 = 0;
      Client.field517 = 0;
      Client.field534 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field347 = 0;
      Client.flagX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      XItemContainer.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(null != var1) {
            var1.interacting = -1;
            var1.field664 = false;
         }
      }

      XItemContainer.itemContainers = new XHashTable(32);
      class103.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field497[var0] = true;
      }

      Client.field336.method2963(104);
      Client.field336.method2708(Tile.method1515());
      Client.field336.method2709(class16.field186);
      Client.field336.method2709(ChatMessages.field907);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "0"
   )
   static final void method159(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field299 && var0 != class118.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class0.region.method1684(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class0.region.method1685(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class0.region.method1686(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class0.region.method1668(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class0.region.method1730(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class0.region.method1675(var0, var2, var3);
               var12 = class143.getObjectDefinition(var34);
               if(var12.field2916 != 0) {
                  Client.collisionMaps[var0].method2213(var2, var3, var35, var36, var12.field2933);
               }
            }

            if(var1 == 1) {
               class0.region.method1672(var0, var2, var3);
            }

            if(var1 == 2) {
               class0.region.method1677(var0, var2, var3);
               var12 = class143.getObjectDefinition(var34);
               if(var12.sizeX + var2 > 103 || var3 + var12.sizeX > 103 || var12.sizeY + var2 > 103 || var12.sizeY + var3 > 103) {
                  return;
               }

               if(var12.field2916 != 0) {
                  Client.collisionMaps[var0].method2186(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field2933);
               }
            }

            if(var1 == 3) {
               class0.region.method1722(var0, var2, var3);
               var12 = class143.getObjectDefinition(var34);
               if(var12.field2916 == 1) {
                  Client.collisionMaps[var0].method2182(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class0.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class143.getObjectDefinition(var4);
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
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = var2 + (1 + var15 >> 1);
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

            int[][] var21 = class10.tileHeights[var11];
            int var22 = var21[var17][var19] + var21[var18][var19] + var21[var17][var20] + var21[var18][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(var14.field2910 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field2939 == 1) {
               var26 += 256;
            }

            Object var33;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var33 = var14.method3488(22, var5, var21, var23, var22, var24);
               } else {
                  var33 = new class49(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var33, var25, var26);
               if(var14.field2916 == 1) {
                  var13.method2180(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var33 = var14.method3488(var6, var5, var21, var23, var22, var24);
                  } else {
                     var33 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1810(var0, var2, var3, var22, 1, 1, (Renderable)var33, 0, var25, var26);
                  if(var14.field2916 != 0) {
                     var13.method2181(var2, var3, var15, var16, var14.field2933);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var33 = var14.method3488(0, var5, var21, var23, var22, var24);
                  } else {
                     var33 = new class49(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1700(var0, var2, var3, var22, (Renderable)var33, (Renderable)null, class10.field100[var5], 0, var25, var26);
                  if(var14.field2916 != 0) {
                     var13.method2185(var2, var3, var6, var5, var14.field2933);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var33 = var14.method3488(1, var5, var21, var23, var22, var24);
                  } else {
                     var33 = new class49(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1700(var0, var2, var3, var22, (Renderable)var33, (Renderable)null, class10.field101[var5], 0, var25, var26);
                  if(var14.field2916 != 0) {
                     var13.method2185(var2, var3, var6, var5, var14.field2933);
                  }
               } else {
                  int var27;
                  Object var29;
                  if(var6 == 2) {
                     var27 = var5 + 1 & 3;
                     Object var32;
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var32 = var14.method3488(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method3488(2, var27, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 2, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class49(var4, 2, var27, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1700(var0, var2, var3, var22, (Renderable)var32, (Renderable)var29, class10.field100[var5], class10.field100[var27], var25, var26);
                     if(var14.field2916 != 0) {
                        var13.method2185(var2, var3, var6, var5, var14.field2933);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var33 = var14.method3488(3, var5, var21, var23, var22, var24);
                     } else {
                        var33 = new class49(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1700(var0, var2, var3, var22, (Renderable)var33, (Renderable)null, class10.field101[var5], 0, var25, var26);
                     if(var14.field2916 != 0) {
                        var13.method2185(var2, var3, var6, var5, var14.field2933);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && null == var14.impostorIds) {
                        var33 = var14.method3488(var6, var5, var21, var23, var22, var24);
                     } else {
                        var33 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1810(var0, var2, var3, var22, 1, 1, (Renderable)var33, 0, var25, var26);
                     if(var14.field2916 != 0) {
                        var13.method2181(var2, var3, var15, var16, var14.field2933);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var33 = var14.method3488(4, var5, var21, var23, var22, var24);
                     } else {
                        var33 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1667(var0, var2, var3, var22, (Renderable)var33, (Renderable)null, class10.field100[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var27 = 16;
                        var28 = var37.method1684(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class143.getObjectDefinition(var28 >> 14 & 32767).field2923;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3488(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1667(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class10.field100[var5], 0, class10.field102[var5] * var27, var27 * class10.field103[var5], var25, var26);
                     } else if(var6 == 6) {
                        var27 = 8;
                        var28 = var37.method1684(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class143.getObjectDefinition(var28 >> 14 & 32767).field2923 / 2;
                        }

                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3488(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1667(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, class10.field104[var5] * var27, class10.field98[var5] * var27, var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var33 = var14.method3488(4, 4 + var28, var21, var23, var22, var24);
                        } else {
                           var33 = new class49(var4, 4, var28 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1667(var0, var2, var3, var22, (Renderable)var33, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var27 = 8;
                        var28 = var37.method1684(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = class143.getObjectDefinition(var28 >> 14 & 32767).field2923 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3488(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method3488(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class49(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1667(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var27 * class10.field104[var5], var27 * class10.field98[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var33 = var14.method3488(10, var5, var21, var23, var22, var24);
               } else {
                  var33 = new class49(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var33 != null) {
                  var37.method1810(var0, var2, var3, var22, var15, var16, (Renderable)var33, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2916 != 0) {
                  var13.method2181(var2, var3, var15, var16, var14.field2933);
               }
            }
         }
      }

   }
}
