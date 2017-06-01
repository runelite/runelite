import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public final class class84 extends Renderable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -862972969
   )
   int field1374;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1958282403
   )
   int field1375;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -66116251
   )
   int field1376;
   @ObfuscatedName("y")
   Sequence field1377;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1404233475
   )
   int field1378;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 843235373
   )
   int field1379;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1175436237
   )
   int field1381;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1596438467
   )
   int field1382;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1348324049
   )
   int field1383;
   @ObfuscatedName("n")
   boolean field1386;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1022915821"
   )
   final void method1662(int var1) {
      if(!this.field1386) {
         this.field1383 += var1;

         while(this.field1383 > this.field1377.frameLenghts[this.field1381]) {
            this.field1383 -= this.field1377.frameLenghts[this.field1381];
            ++this.field1381;
            if(this.field1381 >= this.field1377.frameIDs.length) {
               this.field1386 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2096882887"
   )
   protected final Model getModel() {
      Spotanim var1 = CombatInfo1.method1542(this.field1375);
      Model var2;
      if(!this.field1386) {
         var2 = var1.method4341(this.field1381);
      } else {
         var2 = var1.method4341(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-1338343046"
   )
   public static ModIcon method1666(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4125(var1);
      int var4 = var0.method4126(var3, var2);
      ModIcon var5;
      if(!class7.method28(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var7 = new ModIcon();
         var7.width = class286.field3790;
         var7.originalHeight = class286.field3792;
         var7.offsetX = class286.field3793[0];
         var7.offsetY = class266.field3657[0];
         var7.originalWidth = class233.field3205[0];
         var7.height = ScriptState.field779[0];
         var7.palette = class4.field33;
         var7.pixels = IndexFile.field2307[0];
         class251.method4451();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;S)V",
      garbageValue = "20016"
   )
   static final void method1667(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field1046 || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field757) {
            class61.field757 = var0;
         }

         ObjectComposition var8 = class226.getObjectDefinition(var3);
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
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3451 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3472 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method4537()) {
            class82 var21 = new class82();
            var21.field1345 = var0;
            var21.field1349 = var1 * 128;
            var21.field1342 = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var21.field1344 = (var1 + var22) * 128;
            var21.field1351 = (var2 + var23) * 128;
            var21.field1347 = var8.ambientSoundId;
            var21.field1346 = var8.field3477 * 128;
            var21.field1340 = var8.field3478;
            var21.field1350 = var8.field3459;
            var21.field1343 = var8.field3480;
            if(var8.impostorIds != null) {
               var21.field1354 = var8;
               var21.method1597();
            }

            class82.field1348.method3571(var21);
            if(var21.field1343 != null) {
               var21.field1352 = var21.field1340 + (int)(Math.random() * (double)(var21.field1350 - var21.field1340));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field1046 || var8.field3451 != 0 || var8.field3471 == 1 || var8.field3470) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4547(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class100(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field3471 == 1 && var7 != null) {
                  var7.method3050(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4547(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class100(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2735(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class47.field607[var0][var1][var2] |= 2340;
               }

               if(var8.field3471 != 0 && var7 != null) {
                  var7.method3024(var1, var2, var9, var10, var8.field3450);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4547(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class100(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2682(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field771[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field3457) {
                     class47.field605[var0][var1][var2] = 50;
                     class47.field605[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field3437) {
                     class47.field607[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field3457) {
                     class47.field605[var0][var1][var2 + 1] = 50;
                     class47.field605[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field3437) {
                     class47.field607[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field3457) {
                     class47.field605[var0][var1 + 1][var2] = 50;
                     class47.field605[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field3437) {
                     class47.field607[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field3457) {
                     class47.field605[var0][var1][var2] = 50;
                     class47.field605[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field3437) {
                     class47.field607[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field3471 != 0 && var7 != null) {
                  var7.method3021(var1, var2, var5, var4, var8.field3450);
               }

               if(var8.field3435 != 16) {
                  var6.method2748(var0, var1, var2, var8.field3435);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4547(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class100(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2682(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field767[var4], 0, var19, var20);
               if(var8.field3457) {
                  if(var4 == 0) {
                     class47.field605[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class47.field605[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class47.field605[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class47.field605[var0][var1][var2] = 50;
                  }
               }

               if(var8.field3471 != 0 && var7 != null) {
                  var7.method3021(var1, var2, var5, var4, var8.field3450);
               }

            } else {
               Object var26;
               int var27;
               if(var5 == 2) {
                  var27 = var4 + 1 & 3;
                  Object var28;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.method4547(2, var4 + 4, var15, var17, var16, var18);
                     var26 = var8.method4547(2, var27, var15, var17, var16, var18);
                  } else {
                     var28 = new class100(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var26 = new class100(var3, 2, var27, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2682(var0, var1, var2, var16, (Renderable)var28, (Renderable)var26, class61.field771[var4], class61.field771[var27], var19, var20);
                  if(var8.field3437) {
                     if(var4 == 0) {
                        class47.field607[var0][var1][var2] |= 585;
                        class47.field607[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class47.field607[var0][var1][var2 + 1] |= 1170;
                        class47.field607[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class47.field607[var0][var1 + 1][var2] |= 585;
                        class47.field607[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class47.field607[var0][var1][var2] |= 1170;
                        class47.field607[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field3471 != 0 && var7 != null) {
                     var7.method3021(var1, var2, var5, var4, var8.field3450);
                  }

                  if(var8.field3435 != 16) {
                     var6.method2748(var0, var1, var2, var8.field3435);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4547(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class100(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2682(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field767[var4], 0, var19, var20);
                  if(var8.field3457) {
                     if(var4 == 0) {
                        class47.field605[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class47.field605[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class47.field605[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class47.field605[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field3471 != 0 && var7 != null) {
                     var7.method3021(var1, var2, var5, var4, var8.field3450);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4547(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class100(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2735(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field3471 != 0 && var7 != null) {
                     var7.method3024(var1, var2, var9, var10, var8.field3450);
                  }

                  if(var8.field3435 != 16) {
                     var6.method2748(var0, var1, var2, var8.field3435);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4547(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class100(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2820(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field771[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var27 = 16;
                  var22 = var6.method2704(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class226.getObjectDefinition(var22 >> 14 & 32767).field3435;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var26 = var8.method4547(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class100(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2820(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class61.field771[var4], 0, var27 * class61.field760[var4], class61.field758[var4] * var27, var19, var20);
               } else if(var5 == 6) {
                  var27 = 8;
                  var22 = var6.method2704(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class226.getObjectDefinition(var22 >> 14 & 32767).field3435 / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var26 = var8.method4547(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var26 = new class100(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2820(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, 256, var4, var27 * class61.field770[var4], class61.field766[var4] * var27, var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4547(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new class100(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2820(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var27 = 8;
                  var22 = var6.method2704(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class226.getObjectDefinition(var22 >> 14 & 32767).field3435 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var26 = var8.method4547(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.method4547(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var26 = new class100(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var29 = new class100(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2820(var0, var1, var2, var16, (Renderable)var26, (Renderable)var29, 256, var4, class61.field770[var4] * var27, class61.field766[var4] * var27, var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.method4547(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class100(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2735(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field3457) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2498() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class47.field605[var0][var23 + var1][var2 + var24]) {
                        class47.field605[var0][var23 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field3471 != 0 && var7 != null) {
               var7.method3024(var1, var2, var9, var10, var8.field3450);
            }

         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1441631703"
   )
   public static void method1668(int var0) {
      class203.field2514 = 1;
      class203.field2513 = null;
      class203.field2515 = -1;
      class157.field2280 = -1;
      class151.field2229 = 0;
      class87.field1404 = false;
      ChatMessages.field1527 = var0;
   }

   class84(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1381 = 0;
      this.field1383 = 0;
      this.field1386 = false;
      this.field1375 = var1;
      this.field1374 = var2;
      this.field1376 = var3;
      this.field1378 = var4;
      this.field1379 = var5;
      this.field1382 = var7 + var6;
      int var8 = CombatInfo1.method1542(this.field1375).field3326;
      if(var8 != -1) {
         this.field1386 = false;
         this.field1377 = class227.getAnimation(var8);
      } else {
         this.field1386 = true;
      }

   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1259277238"
   )
   static final void method1669() {
      if(Client.field982 > 0) {
         class66.method1077();
      } else {
         class249.setGameState(40);
         Player.field917 = ScriptState.rssocket;
         ScriptState.rssocket = null;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-554323469"
   )
   public static boolean method1670(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
