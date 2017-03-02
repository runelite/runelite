import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1403460093
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1281203977
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 619331319
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("t")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("k")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("h")
   @Export("top")
   Renderable top;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -883341971
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -65650597
   )
   @Export("height")
   int height;

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1496556658"
   )
   static final void method1516(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class65.method1224(var0, var1, class156.plane) - var2;
         var0 -= class206.cameraX;
         var3 -= class112.cameraZ;
         var1 -= class22.cameraY;
         int var4 = class84.field1435[FaceNormal.cameraPitch];
         int var5 = class84.field1432[FaceNormal.cameraPitch];
         int var6 = class84.field1435[Friend.cameraYaw];
         int var7 = class84.field1432[Friend.cameraYaw];
         int var8 = var7 * var0 + var1 * var6 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.field390 = var0 * Client.scale / var1 + Client.camera2 / 2;
            Client.field391 = var8 * Client.scale / var1 + Client.camera3 / 2;
         } else {
            Client.field390 = -1;
            Client.field391 = -1;
         }

      } else {
         Client.field390 = -1;
         Client.field391 = -1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1082549425"
   )
   static final void method1517(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field404 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field109) {
            class10.field109 = var0;
         }

         ObjectComposition var8 = class196.getObjectDefinition(var3);
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
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field2922 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2943 == 1) {
            var20 += 256;
         }

         if(var8.method3690()) {
            class6.method97(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field404 || var8.field2922 != 0 || var8.field2914 == 1 || var8.field2935) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var21 = var8.method3685(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field2914 == 1 && null != var7) {
                  var7.method2320(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var21 = var8.method3685(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1766(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class149.field2027[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2914 != 0 && var7 != null) {
                     var7.method2318(var1, var2, var9, var10, var8.field2915);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3685(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1881(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field88[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2904) {
                        Item.field884[var0][var1][var2] = 50;
                        Item.field884[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field2919) {
                        class149.field2027[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2904) {
                        Item.field884[var0][var1][1 + var2] = 50;
                        Item.field884[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field2919) {
                        class149.field2027[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2904) {
                        Item.field884[var0][1 + var1][var2] = 50;
                        Item.field884[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field2919) {
                        class149.field2027[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2904) {
                        Item.field884[var0][var1][var2] = 50;
                        Item.field884[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2919) {
                        class149.field2027[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2914 != 0 && var7 != null) {
                     var7.method2317(var1, var2, var5, var4, var8.field2915);
                  }

                  if(var8.field2924 != 16) {
                     var6.method1848(var0, var1, var2, var8.field2924);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var21 = var8.method3685(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1881(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field96[var4], 0, var19, var20);
                  if(var8.field2904) {
                     if(var4 == 0) {
                        Item.field884[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        Item.field884[var0][var1 + 1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        Item.field884[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        Item.field884[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2914 != 0 && null != var7) {
                     var7.method2317(var1, var2, var5, var4, var8.field2915);
                  }

               } else {
                  Object var27;
                  int var29;
                  if(var5 == 2) {
                     var29 = 1 + var4 & 3;
                     Object var26;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var26 = var8.method3685(2, 4 + var4, var15, var17, var16, var18);
                        var27 = var8.method3685(2, var29, var15, var17, var16, var18);
                     } else {
                        var26 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var27 = new class49(var3, 2, var29, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1881(var0, var1, var2, var16, (Renderable)var26, (Renderable)var27, class10.field88[var4], class10.field88[var29], var19, var20);
                     if(var8.field2919) {
                        if(var4 == 0) {
                           class149.field2027[var0][var1][var2] |= 585;
                           class149.field2027[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class149.field2027[var0][var1][var2 + 1] |= 1170;
                           class149.field2027[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class149.field2027[var0][var1 + 1][var2] |= 585;
                           class149.field2027[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class149.field2027[var0][var1][var2] |= 1170;
                           class149.field2027[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2914 != 0 && null != var7) {
                        var7.method2317(var1, var2, var5, var4, var8.field2915);
                     }

                     if(var8.field2924 != 16) {
                        var6.method1848(var0, var1, var2, var8.field2924);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3685(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1881(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field96[var4], 0, var19, var20);
                     if(var8.field2904) {
                        if(var4 == 0) {
                           Item.field884[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           Item.field884[var0][1 + var1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           Item.field884[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           Item.field884[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2914 != 0 && null != var7) {
                        var7.method2317(var1, var2, var5, var4, var8.field2915);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3685(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1766(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field2914 != 0 && null != var7) {
                        var7.method2318(var1, var2, var9, var10, var8.field2915);
                     }

                     if(var8.field2924 != 16) {
                        var6.method1848(var0, var1, var2, var8.field2924);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3685(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1765(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field88[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var29 = 16;
                     var22 = var6.method1825(var0, var1, var2);
                     if(var22 != 0) {
                        var29 = class196.getObjectDefinition(var22 >> 14 & 32767).field2924;
                     }

                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var27 = var8.method3685(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1765(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field88[var4], 0, var29 * class10.field90[var4], class10.field99[var4] * var29, var19, var20);
                  } else if(var5 == 6) {
                     var29 = 8;
                     var22 = var6.method1825(var0, var1, var2);
                     if(var22 != 0) {
                        var29 = class196.getObjectDefinition(var22 >> 14 & 32767).field2924 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.method3685(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1765(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var4, class10.field97[var4] * var29, class10.field100[var4] * var29, var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3685(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, 4 + var22, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1765(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var29 = 8;
                     var22 = var6.method1825(var0, var1, var2);
                     if(var22 != 0) {
                        var29 = class196.getObjectDefinition(var22 >> 14 & 32767).field2924 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var28;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var27 = var8.method3685(4, var4 + 4, var15, var17, var16, var18);
                        var28 = var8.method3685(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var28 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1765(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, 256, var4, var29 * class10.field97[var4], var29 * class10.field100[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var21 = var8.method3685(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method1766(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field2904) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method1683() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > Item.field884[var0][var23 + var1][var2 + var24]) {
                           Item.field884[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2914 != 0 && null != var7) {
                  var7.method2318(var1, var2, var9, var10, var8.field2915);
               }

            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;B)V",
      garbageValue = "-7"
   )
   static final void method1518(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var2 + var9 < 103 && var10 + var3 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var9 + var2][var10 + var3] &= -16777217;
            }
         }
      }

      Buffer var28 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(var19 == 0) {
                     var16 = var17;
                  } else if(var19 == 1) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  int var22 = var2 + var16;
                  int var25 = var11 & 7;
                  int var26 = var12 & 7;
                  int var27 = var7 & 3;
                  int var24;
                  if(var27 == 0) {
                     var24 = var26;
                  } else if(var27 == 1) {
                     var24 = 7 - var25;
                  } else if(var27 == 2) {
                     var24 = 7 - var26;
                  } else {
                     var24 = var25;
                  }

                  class9.method117(var28, var1, var22, var3 + var24, 0, 0, var7);
               } else {
                  class9.method117(var28, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "571817364"
   )
   static final void method1519(int var0, int var1) {
      if(Renderable.field1528 != var0 || class156.field2107 != var1) {
         Renderable.field1528 = var0;
         class156.field2107 = var1;
         GameObject.setGameState(25);
         XGrandExchangeOffer.method65("Loading - please wait.", true);
         int var2 = MessageNode.baseX;
         int var3 = class2.baseY;
         MessageNode.baseX = (var0 - 6) * 8;
         class2.baseY = (var1 - 6) * 8;
         int var4 = MessageNode.baseX - var2;
         int var5 = class2.baseY - var3;
         var2 = MessageNode.baseX;
         var3 = class2.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= 128 * var4;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var17 != var18; var17 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var17;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var17][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class25 var12 = (class25)Client.field467.method2472(); null != var12; var12 = (class25)Client.field467.method2479()) {
            var12.field573 -= var4;
            var12.field583 -= var5;
            if(var12.field573 < 0 || var12.field583 < 0 || var12.field573 >= 104 || var12.field583 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field527 = 0;
         Client.field332 = false;
         Client.field514 = -1;
         Client.field418.method2467();
         Client.projectiles.method2467();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2316();
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "-2103966156"
   )
   static World method1520() {
      return World.field681 < World.field676?World.worldList[++World.field681 - 1]:null;
   }
}
