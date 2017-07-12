import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("bz")
   static class71 field393;
   @ObfuscatedName("ft")
   static int[] field394;
   @ObfuscatedName("gw")
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("n")
   static int[] field375;
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
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -277253347
   )
   int field379;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -872985685
   )
   int field385;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1929825721
   )
   int field376;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 976793285
   )
   int field387;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 455148139
   )
   int field386;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2142025145
   )
   int field392;
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
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -685150377
   )
   int field383;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 406760701
   )
   int field378;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2036443715
   )
   int field382;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1547866705
   )
   int field388;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -877150765
   )
   int field384;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "202348652"
   )
   public boolean vmethod754(int var1, int var2) {
      return var1 >= (this.field379 << 6) + (this.field385 << 3) && var1 <= (this.field379 << 6) + (this.field387 << 3) + 7 && var2 >= (this.field380 << 6) + (this.field381 << 3) && var2 <= (this.field380 << 6) + (this.field378 << 3) + 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "998947175"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field391 && var1 < this.field391 + this.field376?var2 >= (this.field386 << 6) + (this.field392 << 3) && var2 <= (this.field386 << 6) + (this.field383 << 3) + 7 && var3 >= (this.field388 << 6) + (this.field382 << 3) && var3 <= (this.field388 << 6) + (this.field384 << 3) + 7:false;
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-3898"
   )
   void method188() {
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
               if(var0 == var5 && var5 > 0) {
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

         int var74 = class96.field1521;
         int[] var7 = class96.field1531;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3550()) {
            GraphicsObject.characterToScreen(var0, var0.field1288 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3547(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3558()) {
               CombatInfo1 var10 = var9.method1686(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1688()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4410();
                  SpritePixels var13 = var11.method4405();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3386 * 2 < var13.width) {
                        var15 = var11.field3386;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1298;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1301 > var18) {
                     var20 = var11.field3381 == 0?0:var11.field3381 * (var18 / var11.field3381);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = (var19 - var21) * var20 / var10.field1301 + var21;
                  } else {
                     var88 = var19;
                     var20 = var11.field3382 + var10.field1301 - var18;
                     if(var11.field3378 >= 0) {
                        var16 = (var20 << 8) / (var11.field3382 - var11.field3378);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenY - (var14 >> 1);
                  var21 = var3 + Client.screenX - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var14 == var88) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5057(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.method5057(var20, var21, var16);
                     } else {
                        var12.method5042(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.method5042(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method4983(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method4983(var88 + var20, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.hidden) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               GraphicsObject.characterToScreen(var0, var0.field1288 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     class182.mapfunctions[var85.skullIcon].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     Friend.hitmarks[var85.overheadIcon].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
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
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3583 >= 0 && var86.field3583 < Friend.hitmarks.length) {
               GraphicsObject.characterToScreen(var0, var0.field1288 + 15);
               if(Client.screenY > -1) {
                  Friend.hitmarks[var86.field3583].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.field943 == 1 && Client.npcIndices[var1 - var74] == Client.field944 && Client.gameCycle % 20 < 10) {
               GraphicsObject.characterToScreen(var0, var0.field1288 + 15);
               if(Client.screenY > -1) {
                  class43.pkIcons[0].method5042(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1143 == 4 || !var0.field1284 && (Client.field1143 == 0 || Client.field1143 == 3 || Client.field1143 == 1 && class25.isFriended(((Player)var0).name, false))))) {
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

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1294[var75];
            class254 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class164.method3059(var0.field1294[var75]);
               var78 = var87.field3428;
               if(var87 != null && var87.field3439 != null) {
                  var87 = var87.method4483();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1261[var75];
            class254 var79 = null;
            if(var14 >= 0) {
               var79 = class164.method3059(var14);
               if(var79 != null && var79.field3439 != null) {
                  var79 = var79.method4483();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  GraphicsObject.characterToScreen(var0, var0.field1288 / 2);
                  if(Client.screenY > -1) {
                     if(var75 == 1) {
                        Client.screenX -= 20;
                     }

                     if(var75 == 2) {
                        Client.screenY -= 15;
                        Client.screenX -= 10;
                     }

                     if(var75 == 3) {
                        Client.screenY += 15;
                        Client.screenX -= 10;
                     }

                     SpritePixels var80 = null;
                     SpritePixels var81 = null;
                     SpritePixels var82 = null;
                     SpritePixels var83 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var80 = var87.method4485();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4502();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4507();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4509();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4485();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4502();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4507();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4509();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4506();
                     if(var84 == null) {
                        var84 = class45.field618;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4506();
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
                     var44 = var87.method4482(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4773(var44);
                     if(var79 != null) {
                        var45 = var79.method4482(var0.field1273[var75]);
                        var47 = var43.method4773(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var82 == null && var83 == null) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var79 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var48 * var22;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var79 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.hitsplatCycles[var75] - Client.gameCycle;
                     int var62 = var87.field3433 - var61 * var87.field3433 / var87.field3428;
                     int var63 = var61 * var87.field3434 / var87.field3428 + -var87.field3434;
                     int var64 = var2 + Client.screenY - (var50 >> 1) + var62;
                     int var65 = var3 + Client.screenX - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field3440 + var65 + 15;
                     int var69 = var68 - var84.minSpacing;
                     int var70 = var68 + var84.maxSpacing;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var79 != null) {
                        var71 = var79.field3440 + var65 + 15;
                        var72 = var71 - var43.minSpacing;
                        var73 = var71 + var43.maxSpacing;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3435 >= 0) {
                        var72 = (var61 << 8) / (var87.field3428 - var87.field3435);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method5057(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method5057(var52 + var64 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5057(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method5057(var55 + var64 - var28, var65, var72);
                        }

                        var84.method4761(var44, var54 + var64, var68, var87.field3438, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5057(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5057(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5057(var34 * var73 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5057(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4761(var45, var64 + var60, var71, var79.field3438, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.method5042(var64 + var51 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.method5042(var64 + var52 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5042(var73 * var22 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.method5042(var55 + var64 - var28, var65);
                        }

                        var84.method4790(var44, var64 + var54, var68, var87.field3438 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5042(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5042(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5042(var73 * var34 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5042(var64 + var59 - var40, var65);
                           }

                           var43.method4790(var45, var64 + var60, var71, var79.field3438 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
