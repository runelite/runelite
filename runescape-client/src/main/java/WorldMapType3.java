import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("n")
   static int[] field375;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1929825721
   )
   int field376;
   @ObfuscatedName("gw")
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 406760701
   )
   int field378;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -277253347
   )
   int field379;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 111775487
   )
   int field380;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1165511583
   )
   int field381;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2036443715
   )
   int field382;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -685150377
   )
   int field383;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -877150765
   )
   int field384;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -872985685
   )
   int field385;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 455148139
   )
   int field386;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 976793285
   )
   int field387;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1547866705
   )
   int field388;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 1601098389
   )
   @Export("spellTargetFlags")
   static int spellTargetFlags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1316061621
   )
   int field391;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2142025145
   )
   int field392;
   @ObfuscatedName("bz")
   static class71 field393;
   @ObfuscatedName("ft")
   static int[] field394;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "1583523620"
   )
   public static int method169(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "98017718"
   )
   public void vmethod753(WorldMapData var1) {
      if(var1.field467 > this.field379) {
         var1.field467 = this.field379;
      }

      if(var1.field468 < this.field379) {
         var1.field468 = this.field379;
      }

      if(var1.field472 > this.field380) {
         var1.field472 = this.field380;
      }

      if(var1.field466 < this.field380) {
         var1.field466 = this.field380;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1509988890"
   )
   public int[] vmethod730(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field385 * 8 - this.field392 * 8 + this.field379 * 64 - this.field386 * 64 + var2, this.field381 * 8 - this.field382 * 8 + var3 + (this.field380 * 64 - this.field388 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-2079571098"
   )
   public Coordinates vmethod731(int var1, int var2) {
      if(!this.vmethod754(var1, var2)) {
         return null;
      } else {
         int var3 = this.field392 * 8 - this.field385 * 8 + this.field386 * 64 - this.field379 * 64 + var1;
         int var4 = this.field382 * 8 - this.field381 * 8 + this.field388 * 64 - this.field380 * 64 + var2;
         return new Coordinates(this.field391, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "618655756"
   )
   public void vmethod732(Buffer var1) {
      this.field391 = var1.readUnsignedByte();
      this.field376 = var1.readUnsignedByte();
      this.field386 = var1.readUnsignedShort();
      this.field392 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedByte();
      this.field388 = var1.readUnsignedShort();
      this.field382 = var1.readUnsignedByte();
      this.field384 = var1.readUnsignedByte();
      this.field379 = var1.readUnsignedShort();
      this.field385 = var1.readUnsignedByte();
      this.field387 = var1.readUnsignedByte();
      this.field380 = var1.readUnsignedShort();
      this.field381 = var1.readUnsignedByte();
      this.field378 = var1.readUnsignedByte();
      this.method188();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "998947175"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field391 && var1 < this.field391 + this.field376?var2 >= (this.field386 << 6) + (this.field392 << 3) && var2 <= (this.field386 << 6) + (this.field383 << 3) + 7 && var3 >= (this.field388 << 6) + (this.field382 << 3) && var3 <= (this.field388 << 6) + (this.field384 << 3) + 7:false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-3898"
   )
   void method188() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "202348652"
   )
   public boolean vmethod754(int var1, int var2) {
      return var1 >= (this.field379 << 6) + (this.field385 << 3) && var1 <= (this.field379 << 6) + (this.field387 << 3) + 7 && var2 >= (this.field380 << 6) + (this.field381 << 3) && var2 <= (this.field380 << 6) + (this.field378 << 3) + 7;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "1711452901"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      WidgetConfig var1 = (WidgetConfig)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.config:var0.config;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIB)V",
      garbageValue = "71"
   )
   static final void method200(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.hasConfig()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.transform();
            }

            if(var6 == null) {
               return;
            }
         }

         int var75 = class96.field1521;
         int[] var7 = class96.field1531;
         int var8 = 3;
         int var9;
         int var10;
         int var11;
         int var22;
         int var23;
         if(!var0.combatInfoList.method3550()) {
            GraphicsObject.characterToScreen(var0, var0.field1288 + 15);

            for(CombatInfoListHolder var12 = (CombatInfoListHolder)var0.combatInfoList.method3547(); var12 != null; var12 = (CombatInfoListHolder)var0.combatInfoList.method3558()) {
               CombatInfo1 var13 = var12.method1686(Client.gameCycle);
               if(var13 == null) {
                  if(var12.method1688()) {
                     var12.unlink();
                  }
               } else {
                  CombatInfo2 var14 = var12.combatInfo2;
                  SpritePixels var15 = var14.method4410();
                  SpritePixels var16 = var14.method4405();
                  int var17 = 0;
                  if(var15 != null && var16 != null) {
                     if(var14.field3386 * 2 < var16.width) {
                        var17 = var14.field3386;
                     }

                     var9 = var16.width - var17 * 2;
                  } else {
                     var9 = var14.healthScale;
                  }

                  int var18 = 255;
                  boolean var19 = true;
                  int var20 = Client.gameCycle - var13.field1298;
                  int var21 = var9 * var13.health / var14.healthScale;
                  if(var13.field1301 > var20) {
                     var22 = var14.field3381 == 0?0:var14.field3381 * (var20 / var14.field3381);
                     var10 = var9 * var13.healthRatio / var14.healthScale;
                     var23 = (var21 - var10) * var22 / var13.field1301 + var10;
                  } else {
                     var23 = var21;
                     var22 = var14.field3382 + var13.field1301 - var20;
                     if(var14.field3378 >= 0) {
                        var18 = (var22 << 8) / (var14.field3382 - var14.field3378);
                     }
                  }

                  if(var13.health > 0 && var23 < 1) {
                     var23 = 1;
                  }

                  var22 = var2 + Client.screenY - (var9 >> 1);
                  var10 = var3 + Client.screenX - var8;
                  if(var15 != null && var16 != null) {
                     var22 -= var17;
                     if(var23 == var9) {
                        var23 += var17 * 2;
                     } else {
                        var23 += var17;
                     }

                     var11 = var15.height;
                     var8 += var11;
                     if(var18 >= 0 && var18 < 255) {
                        var15.method5057(var22, var10, var18);
                        Rasterizer2D.setInnerDrawRegion(var22, var10, var23 + var22, var11 + var10);
                        var16.method5057(var22, var10, var18);
                     } else {
                        var15.method5042(var22, var10);
                        Rasterizer2D.setInnerDrawRegion(var22, var10, var23 + var22, var11 + var10);
                        var16.method5042(var22, var10);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method4983(var22, var10, var23, 5, '\uff00');
                        Rasterizer2D.method4983(var23 + var22, var10, var9 - var23, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var75) {
            Player var78 = (Player)var0;
            if(var78.hidden) {
               return;
            }

            if(var78.skullIcon != -1 || var78.overheadIcon != -1) {
               GraphicsObject.characterToScreen(var0, var0.field1288 + 15);
               if(Client.screenY > -1) {
                  if(var78.skullIcon != -1) {
                     class182.mapfunctions[var78.skullIcon].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var78.overheadIcon != -1) {
                     Friend.hitmarks[var78.overheadIcon].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field943 == 10 && var7[var1] == Client.field1183) {
               GraphicsObject.characterToScreen(var0, var0.field1288 + 15);
               if(Client.screenY > -1) {
                  class43.pkIcons[1].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var76 = ((NPC)var0).composition;
            if(var76.configs != null) {
               var76 = var76.transform();
            }

            if(var76.field3583 >= 0 && var76.field3583 < Friend.hitmarks.length) {
               GraphicsObject.characterToScreen(var0, var0.field1288 + 15);
               if(Client.screenY > -1) {
                  Friend.hitmarks[var76.field3583].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.field943 == 1 && Client.npcIndices[var1 - var75] == Client.field944 && Client.gameCycle % 20 < 10) {
               GraphicsObject.characterToScreen(var0, var0.field1288 + 15);
               if(Client.screenY > -1) {
                  class43.pkIcons[0].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.inSequence && (Client.field1143 == 4 || !var0.field1284 && (Client.field1143 == 0 || Client.field1143 == 3 || Client.field1143 == 1 && class25.isFriended(((Player)var0).name, false))))) {
            GraphicsObject.characterToScreen(var0, var0.field1288);
            if(Client.screenY > -1 && Client.field1046 < Client.field1020) {
               Client.field1024[Client.field1046] = World.field1322.method4773(var0.overhead) / 2;
               Client.field1009[Client.field1046] = World.field1322.verticalSpace;
               Client.field1021[Client.field1046] = Client.screenY;
               Client.field1022[Client.field1046] = Client.screenX;
               Client.field938[Client.field1046] = var0.field1255;
               Client.field1151[Client.field1046] = var0.field1256;
               Client.field1027[Client.field1046] = var0.field1264;
               Client.field1028[Client.field1046] = var0.overhead;
               ++Client.field1046;
            }
         }

         for(int var79 = 0; var79 < 4; ++var79) {
            int var77 = var0.hitsplatCycles[var79];
            int var80 = var0.field1294[var79];
            class254 var81 = null;
            int var82 = 0;
            if(var80 >= 0) {
               if(var77 <= Client.gameCycle) {
                  continue;
               }

               var81 = class164.method3059(var0.field1294[var79]);
               var82 = var81.field3428;
               if(var81 != null && var81.field3439 != null) {
                  var81 = var81.method4483();
                  if(var81 == null) {
                     var0.hitsplatCycles[var79] = -1;
                     continue;
                  }
               }
            } else if(var77 < 0) {
               continue;
            }

            var9 = var0.field1261[var79];
            class254 var83 = null;
            if(var9 >= 0) {
               var83 = class164.method3059(var9);
               if(var83 != null && var83.field3439 != null) {
                  var83 = var83.method4483();
               }
            }

            if(var77 - var82 <= Client.gameCycle) {
               if(var81 == null) {
                  var0.hitsplatCycles[var79] = -1;
               } else {
                  GraphicsObject.characterToScreen(var0, var0.field1288 / 2);
                  if(Client.screenY > -1) {
                     if(var79 == 1) {
                        Client.screenX -= 20;
                     }

                     if(var79 == 2) {
                        Client.screenY -= 15;
                        Client.screenX -= 10;
                     }

                     if(var79 == 3) {
                        Client.screenY += 15;
                        Client.screenX -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var85 = null;
                     SpritePixels var86 = null;
                     SpritePixels var87 = null;
                     var10 = 0;
                     var11 = 0;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     SpritePixels var28 = null;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     int var32 = 0;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     var84 = var81.method4485();
                     int var41;
                     if(var84 != null) {
                        var10 = var84.width;
                        var41 = var84.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var24 = var84.offsetX;
                     }

                     var85 = var81.method4502();
                     if(var85 != null) {
                        var11 = var85.width;
                        var41 = var85.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var25 = var85.offsetX;
                     }

                     var86 = var81.method4507();
                     if(var86 != null) {
                        var22 = var86.width;
                        var41 = var86.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var26 = var86.offsetX;
                     }

                     var87 = var81.method4509();
                     if(var87 != null) {
                        var23 = var87.width;
                        var41 = var87.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var27 = var87.offsetX;
                     }

                     if(var83 != null) {
                        var28 = var83.method4485();
                        if(var28 != null) {
                           var32 = var28.width;
                           var41 = var28.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var36 = var28.offsetX;
                        }

                        var29 = var83.method4502();
                        if(var29 != null) {
                           var33 = var29.width;
                           var41 = var29.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var83.method4507();
                        if(var30 != null) {
                           var34 = var30.width;
                           var41 = var30.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var83.method4509();
                        if(var31 != null) {
                           var35 = var31.width;
                           var41 = var31.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var39 = var31.offsetX;
                        }
                     }

                     Font var42 = var81.method4506();
                     if(var42 == null) {
                        var42 = class45.field618;
                     }

                     Font var43;
                     if(var83 != null) {
                        var43 = var83.method4506();
                        if(var43 == null) {
                           var43 = class45.field618;
                        }
                     } else {
                        var43 = class45.field618;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var81.method4482(var0.hitsplatTypes[var79]);
                     int var48 = var42.method4773(var44);
                     if(var83 != null) {
                        var45 = var83.method4482(var0.field1273[var79]);
                        var47 = var43.method4773(var45);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var11 > 0) {
                        if(var86 == null && var87 == null) {
                           var49 = 1;
                        } else {
                           var49 = var48 / var11 + 1;
                        }
                     }

                     if(var83 != null && var33 > 0) {
                        if(var30 == null && var31 == null) {
                           var50 = 1;
                        } else {
                           var50 = var47 / var33 + 1;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if(var10 > 0) {
                        var51 += var10;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if(var22 > 0) {
                        var51 += var22;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if(var11 > 0) {
                        var56 = var11 * var49;
                        var51 += var56;
                        var55 += (var56 - var48) / 2;
                     } else {
                        var51 += var48;
                     }

                     var56 = var51;
                     if(var23 > 0) {
                        var51 += var23;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if(var83 != null) {
                        var51 += 2;
                        var57 = var51;
                        if(var32 > 0) {
                           var51 += var32;
                        }

                        var51 += 2;
                        var58 = var51;
                        if(var34 > 0) {
                           var51 += var34;
                        }

                        var59 = var51;
                        var61 = var51;
                        if(var33 > 0) {
                           var62 = var50 * var33;
                           var51 += var62;
                           var61 += (var62 - var47) / 2;
                        } else {
                           var51 += var47;
                        }

                        var60 = var51;
                        if(var35 > 0) {
                           var51 += var35;
                        }
                     }

                     var62 = var0.hitsplatCycles[var79] - Client.gameCycle;
                     int var63 = var81.field3433 - var81.field3433 * var62 / var81.field3428;
                     int var64 = var81.field3434 * var62 / var81.field3428 + -var81.field3434;
                     int var65 = var2 + Client.screenY - (var51 >> 1) + var63;
                     int var66 = var3 + Client.screenX - 12 + var64;
                     int var67 = var66;
                     int var68 = var40 + var66;
                     int var69 = var81.field3440 + var66 + 15;
                     int var70 = var69 - var42.minSpacing;
                     int var71 = var42.maxSpacing + var69;
                     if(var70 < var66) {
                        var67 = var70;
                     }

                     if(var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if(var83 != null) {
                        var72 = var83.field3440 + var66 + 15;
                        var73 = var72 - var43.minSpacing;
                        var74 = var43.maxSpacing + var72;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var81.field3435 >= 0) {
                        var73 = (var62 << 8) / (var81.field3428 - var81.field3435);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var84 != null) {
                           var84.method5057(var65 + var52 - var24, var66, var73);
                        }

                        if(var86 != null) {
                           var86.method5057(var53 + var65 - var26, var66, var73);
                        }

                        if(var85 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method5057(var65 + var54 - var25 + var74 * var11, var66, var73);
                           }
                        }

                        if(var87 != null) {
                           var87.method5057(var65 + var56 - var27, var66, var73);
                        }

                        var42.method4761(var44, var55 + var65, var69, var81.field3438, 0, var73);
                        if(var83 != null) {
                           if(var28 != null) {
                              var28.method5057(var57 + var65 - var36, var66, var73);
                           }

                           if(var30 != null) {
                              var30.method5057(var58 + var65 - var38, var66, var73);
                           }

                           if(var29 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method5057(var65 + var59 - var37 + var74 * var33, var66, var73);
                              }
                           }

                           if(var31 != null) {
                              var31.method5057(var65 + var60 - var39, var66, var73);
                           }

                           var43.method4761(var45, var65 + var61, var72, var83.field3438, 0, var73);
                        }
                     } else {
                        if(var84 != null) {
                           var84.method5042(var65 + var52 - var24, var66);
                        }

                        if(var86 != null) {
                           var86.method5042(var53 + var65 - var26, var66);
                        }

                        if(var85 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method5042(var65 + var54 - var25 + var74 * var11, var66);
                           }
                        }

                        if(var87 != null) {
                           var87.method5042(var65 + var56 - var27, var66);
                        }

                        var42.method4790(var44, var55 + var65, var69, var81.field3438 | -16777216, 0);
                        if(var83 != null) {
                           if(var28 != null) {
                              var28.method5042(var57 + var65 - var36, var66);
                           }

                           if(var30 != null) {
                              var30.method5042(var58 + var65 - var38, var66);
                           }

                           if(var29 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method5042(var65 + var59 - var37 + var74 * var33, var66);
                              }
                           }

                           if(var31 != null) {
                              var31.method5042(var65 + var60 - var39, var66);
                           }

                           var43.method4790(var45, var65 + var61, var72, var83.field3438 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "33"
   )
   static final void method201(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class61.field771[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-126907076"
   )
   static final void method202(int var0, int var1, int var2, boolean var3) {
      if(class66.loadWidget(var0)) {
         ScriptEvent.method1131(class46.widgets[var0], -1, var1, var2, var3);
      }

   }
}
