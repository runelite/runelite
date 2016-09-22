import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class14 {
   @ObfuscatedName("v")
   int[] field203;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 129038285
   )
   int field204 = -1;
   @ObfuscatedName("r")
   String[] field206;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -2006896331
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("ea")
   static SpritePixels[] field209;
   @ObfuscatedName("a")
   class23 field210;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;B)V",
      garbageValue = "50"
   )
   static final void method170(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field285 || (class5.tileSettings[0][var1][var2] & 2) != 0 || (class5.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field83) {
            class5.field83 = var0;
         }

         ObjectComposition var8 = class165.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field963;
            var10 = var8.field964;
         } else {
            var9 = var8.field964;
            var10 = var8.field963;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + (var2 << 7) + var1 + (var3 << 14);
         if(var8.field967 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field988 == 1) {
            var20 += 256;
         }

         int var22;
         int var27;
         if(var8.method847()) {
            class24 var21 = new class24();
            var21.field610 = var0;
            var21.field620 = var1 * 128;
            var21.field612 = var2 * 128;
            var22 = var8.field963;
            var27 = var8.field964;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field964;
               var27 = var8.field963;
            }

            var21.field613 = (var22 + var1) * 128;
            var21.field614 = (var27 + var2) * 128;
            var21.field616 = var8.field960;
            var21.field625 = var8.field968 * 128;
            var21.field618 = var8.field992;
            var21.field611 = var8.field947;
            var21.field622 = var8.field976;
            if(var8.impostorIds != null) {
               var21.field623 = var8;
               var21.method596();
            }

            class24.field629.method3849(var21);
            if(null != var21.field622) {
               var21.field621 = var21.field618 + (int)(Math.random() * (double)(var21.field611 - var21.field618));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field285 || var8.field967 != 0 || var8.field965 == 1 || var8.field986) {
               if(var8.field989 == -1 && null == var8.impostorIds) {
                  var30 = var8.method842(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 22, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field965 == 1 && null != var7) {
                  var7.method2414(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.field989 == -1 && var8.impostorIds == null) {
                  var30 = var8.method842(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, var5, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
               }

               var6.method1958(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class22.field590[var0][var1][var2] |= 2340;
               }

               if(var8.field965 != 0 && var7 != null) {
                  var7.method2412(var1, var2, var9, var10, var8.field966);
               }

            } else if(var5 == 0) {
               if(var8.field989 == -1 && null == var8.impostorIds) {
                  var30 = var8.method842(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 0, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
               }

               var6.method1956(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field82[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field979) {
                     class137.field2149[var0][var1][var2] = 50;
                     class137.field2149[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field962) {
                     class22.field590[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field979) {
                     class137.field2149[var0][var1][var2 + 1] = 50;
                     class137.field2149[var0][1 + var1][var2 + 1] = 50;
                  }

                  if(var8.field962) {
                     class22.field590[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field979) {
                     class137.field2149[var0][var1 + 1][var2] = 50;
                     class137.field2149[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field962) {
                     class22.field590[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field979) {
                     class137.field2149[var0][var1][var2] = 50;
                     class137.field2149[var0][1 + var1][var2] = 50;
                  }

                  if(var8.field962) {
                     class22.field590[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field965 != 0 && null != var7) {
                  var7.method2411(var1, var2, var5, var4, var8.field966);
               }

               if(var8.field972 != 16) {
                  var6.method2095(var0, var1, var2, var8.field972);
               }

            } else if(var5 == 1) {
               if(var8.field989 == -1 && var8.impostorIds == null) {
                  var30 = var8.method842(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class12(var3, 1, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
               }

               var6.method1956(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field91[var4], 0, var19, var20);
               if(var8.field979) {
                  if(var4 == 0) {
                     class137.field2149[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class137.field2149[var0][var1 + 1][1 + var2] = 50;
                  } else if(var4 == 2) {
                     class137.field2149[var0][1 + var1][var2] = 50;
                  } else if(var4 == 3) {
                     class137.field2149[var0][var1][var2] = 50;
                  }
               }

               if(var8.field965 != 0 && var7 != null) {
                  var7.method2411(var1, var2, var5, var4, var8.field966);
               }

            } else {
               Object var23;
               int var26;
               if(var5 == 2) {
                  var26 = var4 + 1 & 3;
                  Object var28;
                  if(var8.field989 == -1 && null == var8.impostorIds) {
                     var28 = var8.method842(2, 4 + var4, var15, var17, var16, var18);
                     var23 = var8.method842(2, var26, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 2, var4 + 4, var0, var1, var2, var8.field989, true, (Renderable)null);
                     var23 = new class12(var3, 2, var26, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method1956(var0, var1, var2, var16, (Renderable)var28, (Renderable)var23, class5.field82[var4], class5.field82[var26], var19, var20);
                  if(var8.field962) {
                     if(var4 == 0) {
                        class22.field590[var0][var1][var2] |= 585;
                        class22.field590[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class22.field590[var0][var1][var2 + 1] |= 1170;
                        class22.field590[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class22.field590[var0][1 + var1][var2] |= 585;
                        class22.field590[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class22.field590[var0][var1][var2] |= 1170;
                        class22.field590[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field965 != 0 && null != var7) {
                     var7.method2411(var1, var2, var5, var4, var8.field966);
                  }

                  if(var8.field972 != 16) {
                     var6.method2095(var0, var1, var2, var8.field972);
                  }

               } else if(var5 == 3) {
                  if(var8.field989 == -1 && null == var8.impostorIds) {
                     var30 = var8.method842(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 3, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method1956(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field91[var4], 0, var19, var20);
                  if(var8.field979) {
                     if(var4 == 0) {
                        class137.field2149[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class137.field2149[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class137.field2149[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class137.field2149[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field965 != 0 && var7 != null) {
                     var7.method2411(var1, var2, var5, var4, var8.field966);
                  }

               } else if(var5 == 9) {
                  if(var8.field989 == -1 && var8.impostorIds == null) {
                     var30 = var8.method842(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, var5, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method1958(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field965 != 0 && null != var7) {
                     var7.method2412(var1, var2, var9, var10, var8.field966);
                  }

                  if(var8.field972 != 16) {
                     var6.method2095(var0, var1, var2, var8.field972);
                  }

               } else if(var5 == 4) {
                  if(var8.field989 == -1 && null == var8.impostorIds) {
                     var30 = var8.method842(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 4, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method2077(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class5.field82[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2022(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class165.getObjectDefinition(var22 >> 14 & 32767).field972;
                  }

                  if(var8.field989 == -1 && null == var8.impostorIds) {
                     var23 = var8.method842(4, var4, var15, var17, var16, var18);
                  } else {
                     var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method2077(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class5.field82[var4], 0, var26 * class5.field78[var4], var26 * class5.field85[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2022(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class165.getObjectDefinition(var22 >> 14 & 32767).field972 / 2;
                  }

                  if(var8.field989 == -1 && null == var8.impostorIds) {
                     var23 = var8.method842(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method2077(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var26 * class5.field86[var4], class5.field76[var4] * var26, var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.field989 == -1 && var8.impostorIds == null) {
                     var30 = var8.method842(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method2077(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method2022(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class165.getObjectDefinition(var22 >> 14 & 32767).field972 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.field989 == -1 && var8.impostorIds == null) {
                     var23 = var8.method842(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.method842(4, 4 + var25, var15, var17, var16, var18);
                  } else {
                     var23 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field989, true, (Renderable)null);
                     var29 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field989, true, (Renderable)null);
                  }

                  var6.method2077(var0, var1, var2, var16, (Renderable)var23, (Renderable)var29, 256, var4, var26 * class5.field86[var4], var26 * class5.field76[var4], var19, var20);
               }
            }
         } else {
            if(var8.field989 == -1 && null == var8.impostorIds) {
               var30 = var8.method842(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class12(var3, 10, var4, var0, var1, var2, var8.field989, true, (Renderable)null);
            }

            if(null != var30 && var6.method1958(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field979) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2327() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var27 = 0; var27 <= var9; ++var27) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class137.field2149[var0][var1 + var27][var24 + var2]) {
                        class137.field2149[var0][var1 + var27][var2 + var24] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field965 != 0 && null != var7) {
               var7.method2412(var1, var2, var9, var10, var8.field966);
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1062022309"
   )
   static final void method171() {
      class48.field1072.reset();
      class43.field999.reset();
      Sequence.method928();
      ObjectComposition.field950.reset();
      ObjectComposition.field980.reset();
      ObjectComposition.field952.reset();
      ObjectComposition.field959.reset();
      class24.method601();
      ItemComposition.field1181.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class1.method11();
      class45.field1047.reset();
      class45.field1032.reset();
      WidgetNode.method44();
      class33.method722();
      Ignore.method109();
      class49.field1099.reset();
      class49.field1093.reset();
      class4.method46();
      Widget.field2817.reset();
      Widget.field2907.reset();
      Widget.field2931.reset();
      Widget.field2813.reset();
      ((TextureProvider)class94.field1672).method2205();
      class23.field608.reset();
      class144.field2240.method3322();
      class50.field1121.method3322();
      class35.field796.method3322();
      class47.field1065.method3322();
      class1.field18.method3322();
      class8.field140.method3322();
      class9.field147.method3322();
      ItemComposition.field1230.method3322();
      class128.field2118.method3322();
      Client.field311.method3322();
      class85.field1506.method3322();
      class190.field3083.method3322();
   }
}
