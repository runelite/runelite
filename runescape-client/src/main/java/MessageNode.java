import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      longValue = -869836307230787507L
   )
   static long field875;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1674376203
   )
   static int field873;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1821066623
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -987006963
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1146217605
   )
   @Export("type")
   int type;
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("q")
   @Export("sender")
   String sender;
   @ObfuscatedName("s")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = Overlay.method4776();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-986497881"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = Overlay.method4776();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-422951170"
   )
   public static boolean method1155(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-265301435"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      WorldMapType2.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(Lbs;IIIIIS)V",
      garbageValue = "-16186"
   )
   static final void method1153(Actor var0, int var1, int var2, int var3, int var4, int var5) {
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

         int var74 = class94.playerIndexesCount;
         int[] var7 = class94.playerIndices;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3667()) {
            class72.characterToScreen(var0, var0.field1257 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3664(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3665()) {
               CombatInfo1 var10 = var9.method1738(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1739()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4490();
                  SpritePixels var13 = var11.method4504();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3367 * 2 < var13.width) {
                        var15 = var11.field3367;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1271;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1274 > var18) {
                     var20 = var11.field3370 == 0?0:var11.field3370 * (var18 / var11.field3370);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field1274 + var21;
                  } else {
                     var88 = var19;
                     var20 = var10.field1274 + var11.field3371 - var18;
                     if(var11.field3365 >= 0) {
                        var16 = (var20 << 8) / (var11.field3371 - var11.field3365);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenY - (var14 >> 1);
                  var21 = var3 + Client.screenX - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5181(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.method5181(var20, var21, var16);
                     } else {
                        var12.method5172(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var88 + var20, var22 + var21);
                        var13.method5172(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method5129(var20, var21, var88, 5, 65280);
                        Rasterizer2D.method5129(var88 + var20, var21, var14 - var88, 5, 16711680);
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
               class72.characterToScreen(var0, var0.field1257 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     FaceNormal.mapfunctions[var85.skullIcon].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class35.hitmarks[var85.overheadIcon].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field938 == 10 && var7[var1] == Client.field940) {
               class72.characterToScreen(var0, var0.field1257 + 15);
               if(Client.screenY > -1) {
                  class28.pkIcons[1].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3584 >= 0 && var86.field3584 < class35.hitmarks.length) {
               class72.characterToScreen(var0, var0.field1257 + 15);
               if(Client.screenY > -1) {
                  class35.hitmarks[var86.field3584].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.field938 == 1 && Client.npcIndices[var1 - var74] == Client.field939 && Client.gameCycle % 20 < 10) {
               class72.characterToScreen(var0, var0.field1257 + 15);
               if(Client.screenY > -1) {
                  class28.pkIcons[0].method5172(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1129 == 4 || !var0.field1221 && (Client.field1129 == 0 || Client.field1129 == 3 || Client.field1129 == 1 && class44.isFriended(((Player)var0).name, false))))) {
            class72.characterToScreen(var0, var0.field1257);
            if(Client.screenY > -1 && Client.field1005 < Client.field1006) {
               Client.field1083[Client.field1005] = Friend.field827.method4918(var0.overhead) / 2;
               Client.field1009[Client.field1005] = Friend.field827.verticalSpace;
               Client.field1007[Client.field1005] = Client.screenY;
               Client.field1008[Client.field1005] = Client.screenX;
               Client.field1011[Client.field1005] = var0.field1224;
               Client.field1012[Client.field1005] = var0.field1225;
               Client.field1066[Client.field1005] = var0.field1223;
               Client.field1133[Client.field1005] = var0.overhead;
               ++Client.field1005;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1245[var75];
            class254 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class93.method1843(var0.field1245[var75]);
               var78 = var87.field3422;
               if(var87 != null && var87.field3433 != null) {
                  var87 = var87.method4601();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1230[var75];
            class254 var79 = null;
            if(var14 >= 0) {
               var79 = class93.method1843(var14);
               if(var79 != null && var79.field3433 != null) {
                  var79 = var79.method4601();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  class72.characterToScreen(var0, var0.field1257 / 2);
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
                     var80 = var87.method4580();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4581();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4604();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4583();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4580();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4581();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4604();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4583();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4584();
                     if(var84 == null) {
                        var84 = class9.field257;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4584();
                        if(var43 == null) {
                           var43 = class9.field257;
                        }
                     } else {
                        var43 = class9.field257;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4605(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4918(var44);
                     if(var79 != null) {
                        var45 = var79.method4605(var0.field1231[var75]);
                        var47 = var43.method4918(var45);
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
                           var61 = var34 * var49;
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
                     int var62 = var87.field3436 - var61 * var87.field3436 / var87.field3422;
                     int var63 = var61 * var87.field3428 / var87.field3422 + -var87.field3428;
                     int var64 = var62 + (var2 + Client.screenY - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.screenX - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var65 + var87.field3432 + 15;
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
                        var71 = var65 + var79.field3432 + 15;
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
                     if(var87.field3429 >= 0) {
                        var72 = (var61 << 8) / (var87.field3422 - var87.field3429);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method5181(var51 + var64 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method5181(var52 + var64 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5181(var22 * var73 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method5181(var55 + var64 - var28, var65, var72);
                        }

                        var84.method4841(var44, var64 + var54, var68, var87.field3430, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5181(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5181(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5181(var34 * var73 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5181(var59 + var64 - var40, var65, var72);
                           }

                           var43.method4841(var45, var64 + var60, var71, var79.field3430, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.method5172(var51 + var64 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.method5172(var52 + var64 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5172(var22 * var73 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.method5172(var55 + var64 - var28, var65);
                        }

                        var84.method4840(var44, var54 + var64, var68, var87.field3430 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5172(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5172(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5172(var34 * var73 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5172(var59 + var64 - var40, var65);
                           }

                           var43.method4840(var45, var60 + var64, var71, var79.field3430 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Lhj;III)V",
      garbageValue = "452207901"
   )
   static final void method1156(Widget var0, int var1, int var2) {
      if(var0.field2661 == 1) {
         class10.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2661 == 2 && !Client.spellSelected) {
         var3 = class34.method483(var0);
         if(var3 != null) {
            class10.addMenuEntry(var3, class60.getColTags(65280) + var0.field2774, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2661 == 3) {
         class10.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2661 == 4) {
         class10.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2661 == 5) {
         class10.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2661 == 6 && Client.field1077 == null) {
         class10.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var13;
      if(var0.type == 2) {
         var13 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var13 < 20) {
                  var6 += var0.xSprites[var13];
                  var7 += var0.field2727[var13];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field1113 = var13;
                  Timer.field2270 = var0;
                  if(var0.itemIds[var13] > 0) {
                     ItemComposition var8 = class46.getItemDefinition(var0.itemIds[var13] - 1);
                     if(Client.itemSelectionState == 1 && class94.method1858(class244.getWidgetConfig(var0))) {
                        if(var0.id != class25.field371 || var13 != class39.selectedItemIndex) {
                           class10.addMenuEntry("Use", Client.field1067 + " " + "->" + " " + class60.getColTags(16748608) + var8.name, 31, var8.id, var13, var0.id);
                        }
                     } else if(Client.spellSelected && class94.method1858(class244.getWidgetConfig(var0))) {
                        if((WorldMapType1.field451 & 16) == 16) {
                           class10.addMenuEntry(Client.field1071, Client.field948 + " " + "->" + " " + class60.getColTags(16748608) + var8.name, 32, var8.id, var13, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.field978) {
                           var9 = DecorativeObject.method2966(var9);
                        }

                        int var10 = -1;
                        if(Client.field1184 && KeyFocusListener.field655[81]) {
                           var10 = var8.method4675();
                        }

                        int var11;
                        if(class94.method1858(class244.getWidgetConfig(var0))) {
                           for(var11 = 4; var11 >= 3; --var11) {
                              if(var11 != var10) {
                                 WallObject.method2937(var0, var8, var13, var11, false);
                              }
                           }
                        }

                        if(class33.method338(class244.getWidgetConfig(var0))) {
                           class10.addMenuEntry("Use", class60.getColTags(16748608) + var8.name, 38, var8.id, var13, var0.id);
                        }

                        if(class94.method1858(class244.getWidgetConfig(var0))) {
                           for(var11 = 2; var11 >= 0; --var11) {
                              if(var11 != var10) {
                                 WallObject.method2937(var0, var8, var13, var11, false);
                              }
                           }

                           if(var10 >= 0) {
                              WallObject.method2937(var0, var8, var13, var10, true);
                           }
                        }

                        var9 = var0.configActions;
                        if(Client.field978) {
                           var9 = DecorativeObject.method2966(var9);
                        }

                        if(var9 != null) {
                           for(var11 = 4; var11 >= 0; --var11) {
                              if(var9[var11] != null) {
                                 byte var12 = 0;
                                 if(var11 == 0) {
                                    var12 = 39;
                                 }

                                 if(var11 == 1) {
                                    var12 = 40;
                                 }

                                 if(var11 == 2) {
                                    var12 = 41;
                                 }

                                 if(var11 == 3) {
                                    var12 = 42;
                                 }

                                 if(var11 == 4) {
                                    var12 = 43;
                                 }

                                 class10.addMenuEntry(var9[var11], class60.getColTags(16748608) + var8.name, var12, var8.id, var13, var0.id);
                              }
                           }
                        }

                        class10.addMenuEntry("Examine", class60.getColTags(16748608) + var8.name, 1005, var8.id, var13, var0.id);
                     }
                  }
               }

               ++var13;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(class61.method1122(class244.getWidgetConfig(var0)) && (WorldMapType1.field451 & 32) == 32) {
               class10.addMenuEntry(Client.field1071, Client.field948 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var13 = 9; var13 >= 5; --var13) {
               String var14;
               if(!class110.method2171(class244.getWidgetConfig(var0), var13) && var0.field2758 == null) {
                  var14 = null;
               } else if(var0.actions != null && var0.actions.length > var13 && var0.actions[var13] != null && var0.actions[var13].trim().length() != 0) {
                  var14 = var0.actions[var13];
               } else {
                  var14 = null;
               }

               if(var14 != null) {
                  class10.addMenuEntry(var14, var0.name, 1007, var13 + 1, var0.index, var0.id);
               }
            }

            var3 = class34.method483(var0);
            if(var3 != null) {
               class10.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var15;
               if(!class110.method2171(class244.getWidgetConfig(var0), var4) && var0.field2758 == null) {
                  var15 = null;
               } else if(var0.actions != null && var0.actions.length > var4 && var0.actions[var4] != null && var0.actions[var4].trim().length() != 0) {
                  var15 = var0.actions[var4];
               } else {
                  var15 = null;
               }

               if(var15 != null) {
                  class10.addMenuEntry(var15, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            var5 = class244.getWidgetConfig(var0);
            boolean var17 = (var5 & 1) != 0;
            if(var17) {
               class10.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
