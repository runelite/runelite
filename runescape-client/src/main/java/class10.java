import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public final class class10 {
   @ObfuscatedName("k")
   static final int[] field84 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("i")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1475342201
   )
   static int field86 = 99;
   @ObfuscatedName("h")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -877817781
   )
   static int field88 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("z")
   static final int[] field90 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("g")
   static final int[] field92 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("b")
   static final int[] field93 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("w")
   static int[] field94;
   @ObfuscatedName("t")
   static final int[] field95 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -108398775
   )
   static int field97 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("x")
   static final int[] field101 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("f")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];

   class10() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1646003736"
   )
   static final void method105(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field506; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field425[var4] = true;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "1"
   )
   static final void method115(class15 var0) {
      if(Projectile.localPlayer.x >> 7 == Client.flagX && Client.flagY == Projectile.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class45.field923;
      int[] var2 = class45.field918;
      int var3 = var1;
      if(class15.field174 == var0 || class15.field167 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class15.field174 == var0) {
            var5 = Projectile.localPlayer;
            var6 = Projectile.localPlayer.field266 << 14;
         } else if(var0 == class15.field167) {
            var5 = Client.cachedPlayers[Client.field340];
            var6 = Client.field340 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class15.field169 == var0 && var2[var4] == Client.field340) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod738() && !var5.field265) {
            var5.field273 = false;
            if((Client.field306 && var1 > 50 || var1 > 200) && var0 != class15.field174 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field273 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field264) {
                  var5.field273 = false;
                  var5.field262 = class103.method2025(var5.x, var5.y, Sequence.plane);
                  CombatInfo1.region.method1748(Sequence.plane, var5.x, var5.y, var5.field262, 60, var5, var5.angle, var6, var5.field269, var5.field270, var5.field271, var5.field272);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field405[var7][var8] == Client.field337) {
                        continue;
                     }

                     Client.field405[var7][var8] = Client.field337;
                  }

                  var5.field262 = class103.method2025(var5.x, var5.y, Sequence.plane);
                  CombatInfo1.region.method1747(Sequence.plane, var5.x, var5.y, var5.field262, 60, var5, var5.angle, var6, var5.field621);
               }
            }
         }
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "119"
   )
   static final void method136(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field306 && var0 != Sequence.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = CombatInfo1.region.method1762(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = CombatInfo1.region.method1842(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = CombatInfo1.region.method1774(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = CombatInfo1.region.method1845(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = CombatInfo1.region.method1766(var0, var2, var3, var7);
            int var12 = var7 >> 14 & 32767;
            int var13 = var11 & 31;
            int var14 = var11 >> 6 & 3;
            ObjectComposition var15;
            if(var1 == 0) {
               CombatInfo1.region.method1916(var0, var2, var3);
               var15 = class140.getObjectDefinition(var12);
               if(var15.field2914 != 0) {
                  Client.collisionMaps[var0].method2322(var2, var3, var13, var14, var15.field2915);
               }
            }

            if(var1 == 1) {
               CombatInfo1.region.method1877(var0, var2, var3);
            }

            if(var1 == 2) {
               CombatInfo1.region.method1755(var0, var2, var3);
               var15 = class140.getObjectDefinition(var12);
               if(var15.sizeX + var2 > 103 || var15.sizeX + var3 > 103 || var15.sizeY + var2 > 103 || var15.sizeY + var3 > 103) {
                  return;
               }

               if(var15.field2914 != 0) {
                  Client.collisionMaps[var0].method2323(var2, var3, var15.sizeX, var15.sizeY, var14, var15.field2915);
               }
            }

            if(var1 == 3) {
               CombatInfo1.region.method1756(var0, var2, var3);
               var15 = class140.getObjectDefinition(var12);
               if(var15.field2914 == 1) {
                  Client.collisionMaps[var0].method2325(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var33 = CombatInfo1.region;
            CollisionData var34 = Client.collisionMaps[var0];
            ObjectComposition var35 = class140.getObjectDefinition(var4);
            int var16;
            int var36;
            if(var5 != 1 && var5 != 3) {
               var16 = var35.sizeX;
               var36 = var35.sizeY;
            } else {
               var16 = var35.sizeY;
               var36 = var35.sizeX;
            }

            int var17;
            int var18;
            if(var16 + var2 <= 104) {
               var17 = var2 + (var16 >> 1);
               var18 = var2 + (var16 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var36 + var3 <= 104) {
               var19 = var3 + (var36 >> 1);
               var20 = (var36 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var18][var19] + var21[var17][var19] + var21[var17][var20] >> 2;
            int var23 = (var2 << 7) + (var16 << 6);
            int var24 = (var3 << 7) + (var36 << 6);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(var35.field2916 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var35.field2937 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var35.animationId == -1 && var35.impostorIds == null) {
                  var27 = var35.method3644(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 22, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
               }

               var33.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var35.field2914 == 1) {
                  var34.method2320(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method3644(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, var6, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.method1749(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var35.field2914 != 0) {
                     var34.method2330(var2, var3, var16, var36, var35.field2915);
                  }
               } else if(var6 == 0) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method3644(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 0, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.method1876(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, field90[var5], 0, var25, var26);
                  if(var35.field2914 != 0) {
                     var34.method2317(var2, var3, var6, var5, var35.field2915);
                  }
               } else if(var6 == 1) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method3644(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 1, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.method1876(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, field101[var5], 0, var25, var26);
                  if(var35.field2914 != 0) {
                     var34.method2317(var2, var3, var6, var5, var35.field2915);
                  }
               } else {
                  int var28;
                  Object var29;
                  if(var6 == 2) {
                     var28 = var5 + 1 & 3;
                     Object var30;
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var30 = var35.method3644(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var35.method3644(2, var28, var21, var23, var22, var24);
                     } else {
                        var30 = new class49(var4, 2, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        var29 = new class49(var4, 2, var28, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method1876(var0, var2, var3, var22, (Renderable)var30, (Renderable)var29, field90[var5], field90[var28], var25, var26);
                     if(var35.field2914 != 0) {
                        var34.method2317(var2, var3, var6, var5, var35.field2915);
                     }
                  } else if(var6 == 3) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method3644(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 3, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method1876(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, field101[var5], 0, var25, var26);
                     if(var35.field2914 != 0) {
                        var34.method2317(var2, var3, var6, var5, var35.field2915);
                     }
                  } else if(var6 == 9) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method3644(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, var6, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method1749(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var35.field2914 != 0) {
                        var34.method2330(var2, var3, var16, var36, var35.field2915);
                     }
                  } else if(var6 == 4) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method3644(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 4, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method1745(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, field90[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var37;
                     if(var6 == 5) {
                        var28 = 16;
                        var37 = var33.method1762(var0, var2, var3);
                        if(var37 != 0) {
                           var28 = class140.getObjectDefinition(var37 >> 14 & 32767).field2899;
                        }

                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var29 = var35.method3644(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method1745(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, field90[var5], 0, field92[var5] * var28, field93[var5] * var28, var25, var26);
                     } else if(var6 == 6) {
                        var28 = 8;
                        var37 = var33.method1762(var0, var2, var3);
                        if(var37 != 0) {
                           var28 = class140.getObjectDefinition(var37 >> 14 & 32767).field2899 / 2;
                        }

                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var29 = var35.method3644(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method1745(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var28 * field84[var5], var28 * field95[var5], var25, var26);
                     } else if(var6 == 7) {
                        var37 = var5 + 2 & 3;
                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var27 = var35.method3644(4, var37 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class49(var4, 4, var37 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method1745(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var37, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var28 = 8;
                        var37 = var33.method1762(var0, var2, var3);
                        if(var37 != 0) {
                           var28 = class140.getObjectDefinition(var37 >> 14 & 32767).field2899 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var32;
                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var29 = var35.method3644(4, var5 + 4, var21, var23, var22, var24);
                           var32 = var35.method3644(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                           var32 = new class49(var4, 4, var31 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method1745(var0, var2, var3, var22, (Renderable)var29, (Renderable)var32, 256, var5, field84[var5] * var28, field95[var5] * var28, var25, var26);
                     }
                  }
               }
            } else {
               if(var35.animationId == -1 && var35.impostorIds == null) {
                  var27 = var35.method3644(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 10, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var33.method1749(var0, var2, var3, var22, var16, var36, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var35.field2914 != 0) {
                  var34.method2330(var2, var3, var16, var36, var35.field2915);
               }
            }
         }
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "671733003"
   )
   static boolean method137(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class187.method3483(var0, Ignore.field214);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class187.method3483(Client.friends[var3].name, Ignore.field214)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class187.method3483(Projectile.localPlayer.name, Ignore.field214))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "1449146829"
   )
   static final void method138(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < Friend.field159.length; ++var2) {
         Friend.field159[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         Friend.field159[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class9.field83[var5] = (Friend.field159[var5 + 128] + Friend.field159[var5 - 1] + Friend.field159[var5 + 1] + Friend.field159[var5 - 128]) / 4;
            }
         }

         int[] var6 = Friend.field159;
         Friend.field159 = class9.field83;
         class9.field83 = var6;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var8 = var0.offsetY + var3 + 16;
                  int var7 = var5 + (var8 << 7);
                  Friend.field159[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-20584"
   )
   public static void method139() {
      if(class103.field1700.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1724[186] = 57;
         class105.field1724[187] = 27;
         class105.field1724[188] = 71;
         class105.field1724[189] = 26;
         class105.field1724[190] = 72;
         class105.field1724[191] = 73;
         class105.field1724[192] = 58;
         class105.field1724[219] = 42;
         class105.field1724[220] = 74;
         class105.field1724[221] = 43;
         class105.field1724[222] = 59;
         class105.field1724[223] = 28;
      } else {
         class105.field1724[44] = 71;
         class105.field1724[45] = 26;
         class105.field1724[46] = 72;
         class105.field1724[47] = 73;
         class105.field1724[59] = 57;
         class105.field1724[61] = 27;
         class105.field1724[91] = 42;
         class105.field1724[92] = 74;
         class105.field1724[93] = 43;
         class105.field1724[192] = 28;
         class105.field1724[222] = 58;
         class105.field1724[520] = 59;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-4"
   )
   static int method140(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         int[] var6 = class32.field743;
         int var4 = ++class30.field713 - 1;
         int var5 = Client.isResized?2:1;
         var6[var4] = var5;
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class32.field743[--class30.field713];
            if(var3 == 1 || var3 == 2) {
               Client.field516 = 0L;
               if(var3 >= 2) {
                  Client.isResized = true;
               } else {
                  Client.isResized = false;
               }

               class139.method2680();
               if(Client.gameState >= 25) {
                  class94.method1950();
               }

               GameEngine.field1787 = true;
            }

            return 1;
         } else if(var0 == 5308) {
            class32.field743[++class30.field713 - 1] = class148.field2058.field714;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class32.field743[--class30.field713];
            if(var3 == 1 || var3 == 2) {
               class148.field2058.field714 = var3;
               class150.method2839();
            }

            return 1;
         }
      }
   }
}
