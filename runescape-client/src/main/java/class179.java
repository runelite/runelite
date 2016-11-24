import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class179 implements class165 {
   @ObfuscatedName("w")
   public static final class179 field2690 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("d")
   public static final class179 field2691 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("m")
   public static final class179 field2692 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("h")
   public static final class179 field2693 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -642635507
   )
   final int field2694;
   @ObfuscatedName("n")
   public static final class179 field2695 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("c")
   public final String field2696;
   @ObfuscatedName("r")
   public static final class179 field2697 = new class179("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass187;",
      garbageValue = "0"
   )
   public static class187 method3314(int var0) {
      class187 var1 = (class187)class187.field2774.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class187.field2775.method3329(16, var0);
         var1 = new class187();
         if(var2 != null) {
            var1.method3477(new Buffer(var2));
         }

         class187.field2774.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1689281815"
   )
   public int vmethod4132() {
      return this.field2694;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2696 = var1;
      this.field2694 = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass190;",
      garbageValue = "967419578"
   )
   public static class190 method3320(int var0) {
      class190 var1 = (class190)class190.field2796.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class190.field2807.method3329(13, var0);
         var1 = new class190();
         var1.field2798 = var0;
         if(var2 != null) {
            var1.method3526(new Buffer(var2));
         }

         class190.field2796.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIIB)V",
      garbageValue = "1"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class219.method4041(var2, var3, var4, var5);
      class84.method1666();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(null != var10 && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field383)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field488] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field488] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field488] = var10.width;
               Client.widgetBoundsHeight[Client.field488] = var10.height;
               var11 = ++Client.field488 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2201 = Client.gameCycle;
            if(!var10.field2068 || !class33.method715(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field558 == -1) {
                        Client.field558 = var10.textureId;
                        Client.field560 = var10.field2060;
                     }

                     if(Client.field415.isFemale) {
                        var10.textureId = Client.field558;
                     } else {
                        var10.textureId = Client.field560;
                     }
                  } else if(var12 == 325) {
                     if(Client.field558 == -1) {
                        Client.field558 = var10.textureId;
                        Client.field560 = var10.field2060;
                     }

                     if(Client.field415.isFemale) {
                        var10.textureId = Client.field560;
                     } else {
                        var10.textureId = Client.field558;
                     }
                  } else if(var12 == 327) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 0;
                  } else if(var12 == 328) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 1;
                  }
               }

               var12 = var6 + var10.relativeX;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field383) {
                  if(var1 != -1412584499 && !var10.field2147) {
                     ChatLineBuffer.field963 = var0;
                     class178.field2685 = var6;
                     class25.field576 = var7;
                     continue;
                  }

                  if(Client.field469 && Client.field462) {
                     var15 = class115.field1811;
                     var16 = class115.field1810;
                     var15 -= Client.field507;
                     var16 -= Client.field461;
                     if(var15 < Client.field464) {
                        var15 = Client.field464;
                     }

                     if(var15 + var10.width > Client.field464 + Client.field340.width) {
                        var15 = Client.field464 + Client.field340.width - var10.width;
                     }

                     if(var16 < Client.field465) {
                        var16 = Client.field465;
                     }

                     if(var16 + var10.height > Client.field340.height + Client.field465) {
                        var16 = Client.field465 + Client.field340.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2147) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var36;
               int var40;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var36 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var40 = var13 + var10.height;
                  if(var21 < var12) {
                     var36 = var21;
                     var21 = var12;
                  }

                  if(var40 < var13) {
                     var20 = var40;
                     var40 = var13;
                  }

                  ++var21;
                  ++var40;
                  var15 = var36 > var2?var36:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var40 < var5?var40:var5;
               } else {
                  var36 = var12 + var10.width;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var36 < var4?var36:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2068 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var27;
                  int var31;
                  int var42;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field563) {
                           var13 += 15;
                           XGrandExchangeOffer.field45.method3934("Fps:" + GameEngine.field1775, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var48 = Runtime.getRuntime();
                           var20 = (int)((var48.totalMemory() - var48.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field288) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field288) {
                              var21 = 16711680;
                           }

                           XGrandExchangeOffer.field45.method3934("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field407 = var12;
                        Client.field435 = var13;
                        class189.method3497(var12, var13, var10.width, var10.height);
                        Client.field490[var10.boundsIndex] = true;
                        class219.method4041(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class13.method185();
                        class145 var47 = var10.method2846(false);
                        if(null != var47) {
                           class219.method4041(var12, var13, var47.field2028 + var12, var13 + var47.field2020);
                           if(Client.field521 != 2 && Client.field521 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var21 = 48 + class40.localPlayer.x / 32;
                              var40 = 464 - class40.localPlayer.y / 32;
                              Projectile.field879.method4216(var12, var13, var47.field2028, var47.field2020, var21, var40, var20, Client.mapScaleDelta + 256, var47.field2023, var47.field2022);

                              for(var23 = 0; var23 < Client.field515; ++var23) {
                                 var24 = 4 * Client.field393[var23] + 2 - class40.localPlayer.x / 32;
                                 var25 = 4 * Client.field428[var23] + 2 - class40.localPlayer.y / 32;
                                 class40.method785(var12, var13, var24, var25, Client.field518[var23], var47);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field326; ++var23) {
                                       NPC var61 = Client.cachedNPCs[Client.field559[var23]];
                                       if(var61 != null && var61.vmethod746()) {
                                          NPCComposition var63 = var61.composition;
                                          if(null != var63 && var63.field3022 != null) {
                                             var63 = var63.method3770();
                                          }

                                          if(var63 != null && var63.isMinimapVisible && var63.field3024) {
                                             var26 = var61.x / 32 - class40.localPlayer.x / 32;
                                             var27 = var61.y / 32 - class40.localPlayer.y / 32;
                                             class40.method785(var12, var13, var26, var27, class9.field87[1], var47);
                                          }
                                       }
                                    }

                                    var23 = class45.field897;
                                    int[] var62 = class45.field902;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var41 = Client.cachedPlayers[var62[var25]];
                                       if(null != var41 && var41.vmethod746() && !var41.field263 && class40.localPlayer != var41) {
                                          var27 = var41.x / 32 - class40.localPlayer.x / 32;
                                          var42 = var41.y / 32 - class40.localPlayer.y / 32;
                                          boolean var54 = false;
                                          if(class22.method221(var41.name, true)) {
                                             var54 = true;
                                          }

                                          boolean var52 = false;

                                          for(var31 = 0; var31 < class60.field1072; ++var31) {
                                             if(var41.name.equals(class164.clanMembers[var31].username)) {
                                                var52 = true;
                                                break;
                                             }
                                          }

                                          boolean var53 = false;
                                          if(class40.localPlayer.team != 0 && var41.team != 0 && class40.localPlayer.team == var41.team) {
                                             var53 = true;
                                          }

                                          if(var54) {
                                             class40.method785(var12, var13, var27, var42, class9.field87[3], var47);
                                          } else if(var53) {
                                             class40.method785(var12, var13, var27, var42, class9.field87[4], var47);
                                          } else if(var52) {
                                             class40.method785(var12, var13, var27, var42, class9.field87[5], var47);
                                          } else {
                                             class40.method785(var12, var13, var27, var42, class9.field87[2], var47);
                                          }
                                       }
                                    }

                                    if(Client.field302 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field302 == 1 && Client.field303 >= 0 && Client.field303 < Client.cachedNPCs.length) {
                                          NPC var64 = Client.cachedNPCs[Client.field303];
                                          if(var64 != null) {
                                             var26 = var64.x / 32 - class40.localPlayer.x / 32;
                                             var27 = var64.y / 32 - class40.localPlayer.y / 32;
                                             MessageNode.method220(var12, var13, var26, var27, XGrandExchangeOffer.field47[1], var47);
                                          }
                                       }

                                       if(Client.field302 == 2) {
                                          var25 = Client.field305 * 4 - class16.baseX * 4 + 2 - class40.localPlayer.x / 32;
                                          var26 = Client.field306 * 4 - Client.baseY * 4 + 2 - class40.localPlayer.y / 32;
                                          MessageNode.method220(var12, var13, var25, var26, XGrandExchangeOffer.field47[1], var47);
                                       }

                                       if(Client.field302 == 10 && Client.field304 >= 0 && Client.field304 < Client.cachedPlayers.length) {
                                          Player var65 = Client.cachedPlayers[Client.field304];
                                          if(null != var65) {
                                             var26 = var65.x / 32 - class40.localPlayer.x / 32;
                                             var27 = var65.y / 32 - class40.localPlayer.y / 32;
                                             MessageNode.method220(var12, var13, var26, var27, XGrandExchangeOffer.field47[1], var47);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var25 = 2 + Client.flagX * 4 - class40.localPlayer.x / 32;
                                       var26 = 2 + Client.flagY * 4 - class40.localPlayer.y / 32;
                                       class40.method785(var12, var13, var25, var26, XGrandExchangeOffer.field47[0], var47);
                                    }

                                    if(!class40.localPlayer.field263) {
                                       class219.method4071(var12 + var47.field2028 / 2 - 1, var13 + var47.field2020 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var43 = Client.groundItemDeque[class166.plane][var23][var24];
                                    if(var43 != null) {
                                       var26 = 2 + var23 * 4 - class40.localPlayer.x / 32;
                                       var27 = 2 + 4 * var24 - class40.localPlayer.y / 32;
                                       class40.method785(var12, var13, var26, var27, class9.field87[0], var47);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class219.method4060(var12, var13, 0, var47.field2023, var47.field2022);
                           }

                           Client.field491[var11] = true;
                        }

                        class219.method4041(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class187.method3484(var10, var12, var13, var11);
                        class219.method4041(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2068 && class33.method715(var10) && class39.field802 != var10) {
                        continue;
                     }

                     if(!var10.field2068) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method2405((long)var10.id);
                     if(null != var19) {
                        class1.method20(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class219.method4041(var2, var3, var4, var5);
                     class84.method1666();
                  }

                  if(Client.isResized || Client.field492[var11] || Client.field497 > 1) {
                     if(var10.type == 0 && !var10.field2068 && var10.scrollHeight > var10.height) {
                        var36 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var40 = var10.scrollHeight;
                        class171.field2357[0].method4146(var36, var13);
                        class171.field2357[1].method4146(var36, var13 + var21 - 16);
                        class219.method4071(var36, var13 + 16, 16, var21 - 32, Client.field341);
                        var23 = var21 * (var21 - 32) / var40;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = (var21 - 32 - var23) * var20 / (var40 - var21);
                        class219.method4071(var36, var24 + var13 + 16, 16, var23, Client.field365);
                        class219.method4091(var36, var24 + 16 + var13, var23, Client.field327);
                        class219.method4091(1 + var36, var24 + 16 + var13, var23, Client.field327);
                        class219.method4055(var36, var24 + var13 + 16, 16, Client.field327);
                        class219.method4055(var36, var24 + var13 + 17, 16, Client.field327);
                        class219.method4091(15 + var36, var24 + 16 + var13, var23, Client.field531);
                        class219.method4091(var36 + 14, var24 + 17 + var13, var23 - 1, Client.field531);
                        class219.method4055(var36, var13 + 15 + var24 + var23, 16, Client.field531);
                        class219.method4055(1 + var36, var24 + 14 + var13 + var23, 15, Client.field531);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var36 = 0;

                           for(var20 = 0; var20 < var10.field2081; ++var20) {
                              for(var21 = 0; var21 < var10.field2144; ++var21) {
                                 var40 = var21 * (32 + var10.field2135) + var12;
                                 var23 = var13 + (var10.field2136 + 32) * var20;
                                 if(var36 < 20) {
                                    var40 += var10.field2137[var36];
                                    var23 += var10.field2129[var36];
                                 }

                                 if(var10.itemIds[var36] <= 0) {
                                    if(null != var10.field2139 && var36 < 20) {
                                       SpritePixels var60 = var10.method2844(var36);
                                       if(var60 != null) {
                                          var60.method4192(var40, var23);
                                       } else if(Widget.field2067) {
                                          Tile.method1577(var10);
                                       }
                                    }
                                 } else {
                                    boolean var50 = false;
                                    boolean var51 = false;
                                    var26 = var10.itemIds[var36] - 1;
                                    if(32 + var40 > var2 && var40 < var4 && 32 + var23 > var3 && var23 < var5 || class163.field2313 == var10 && Client.field401 == var36) {
                                       SpritePixels var44;
                                       if(Client.field438 == 1 && class85.field1448 == var36 && var10.id == class156.field2238) {
                                          var44 = class5.createSprite(var26, var10.itemQuantities[var36], 2, 0, 2, false);
                                       } else {
                                          var44 = class5.createSprite(var26, var10.itemQuantities[var36], 1, 3153952, 2, false);
                                       }

                                       if(var44 != null) {
                                          if(class163.field2313 == var10 && var36 == Client.field401) {
                                             var24 = class115.field1811 - Client.field402;
                                             var25 = class115.field1810 - Client.field403;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field406 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var44.method4198(var24 + var40, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class219.field3168 && var28.scrollY > 0) {
                                                   var29 = Client.field517 * (class219.field3168 - var23 - var25) / 3;
                                                   if(var29 > Client.field517 * 10) {
                                                      var29 = Client.field517 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field403 += var29;
                                                   Tile.method1577(var28);
                                                }

                                                if(var25 + var23 + 32 > class219.field3169 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = Client.field517 * (var23 + var25 + 32 - class219.field3169) / 3;
                                                   if(var29 > Client.field517 * 10) {
                                                      var29 = Client.field517 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field403 -= var29;
                                                   Tile.method1577(var28);
                                                }
                                             }
                                          } else if(GameObject.field1614 == var10 && Client.field552 == var36) {
                                             var44.method4198(var40, var23, 128);
                                          } else {
                                             var44.method4192(var40, var23);
                                          }
                                       } else {
                                          Tile.method1577(var10);
                                       }
                                    }
                                 }

                                 ++var36;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class16.method198(var10)) {
                              var36 = var10.field2095;
                              if(var10 == class39.field802 && var10.field2097 != 0) {
                                 var36 = var10.field2097;
                              }
                           } else {
                              var36 = var10.textColor;
                              if(class39.field802 == var10 && var10.field2096 != 0) {
                                 var36 = var10.field2096;
                              }
                           }

                           if(var10.field2098) {
                              switch(var10.field2065.field3178) {
                              case 1:
                                 class219.method4048(var12, var13, var10.width, var10.height, var10.textColor, var10.field2095, 256 - (var10.opacity & 255), 256 - (var10.field2145 & 255));
                                 break;
                              case 2:
                                 class219.method4100(var12, var13, var10.width, var10.height, var10.textColor, var10.field2095, 256 - (var10.opacity & 255), 256 - (var10.field2145 & 255));
                                 break;
                              case 3:
                                 class219.method4094(var12, var13, var10.width, var10.height, var10.textColor, var10.field2095, 256 - (var10.opacity & 255), 256 - (var10.field2145 & 255));
                                 break;
                              case 4:
                                 class219.method4051(var12, var13, var10.width, var10.height, var10.textColor, var10.field2095, 256 - (var10.opacity & 255), 256 - (var10.field2145 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class219.method4071(var12, var13, var10.width, var10.height, var36);
                                 } else {
                                    class219.method4046(var12, var13, var10.width, var10.height, var36, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class219.method4053(var12, var13, var10.width, var10.height, var36);
                           } else {
                              class219.method4054(var12, var13, var10.width, var10.height, var36, 256 - (var14 & 255));
                           }
                        } else {
                           class208 var45;
                           if(var10.type == 4) {
                              var45 = var10.method2843();
                              if(var45 == null) {
                                 if(Widget.field2067) {
                                    Tile.method1577(var10);
                                 }
                              } else {
                                 String var59 = var10.text;
                                 if(class16.method198(var10)) {
                                    var20 = var10.field2095;
                                    if(class39.field802 == var10 && var10.field2097 != 0) {
                                       var20 = var10.field2097;
                                    }

                                    if(var10.field2130.length() > 0) {
                                       var59 = var10.field2130;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class39.field802 && var10.field2096 != 0) {
                                       var20 = var10.field2096;
                                    }
                                 }

                                 if(var10.field2068 && var10.item != -1) {
                                    ItemComposition var49 = class18.getItemDefinition(var10.item);
                                    var59 = var49.name;
                                    if(var59 == null) {
                                       var59 = "null";
                                    }

                                    if((var49.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var59 = class13.method182(16748608) + var59 + "</col>" + " " + 'x' + class145.method2788(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field449) {
                                    Object var10000 = null;
                                    var59 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2068) {
                                    var59 = class72.method1406(var59, var10);
                                 }

                                 var45.method3921(var59, var12, var13, var10.width, var10.height, var20, var10.field2173?0:-1, var10.field2132, var10.field2070, var10.field2086);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var46;
                              if(!var10.field2068) {
                                 var46 = var10.method2842(class16.method198(var10));
                                 if(null != var46) {
                                    var46.method4192(var12, var13);
                                 } else if(Widget.field2067) {
                                    Tile.method1577(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var46 = class5.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2127, false);
                                 } else {
                                    var46 = var10.method2842(false);
                                 }

                                 if(var46 == null) {
                                    if(Widget.field2067) {
                                       Tile.method1577(var10);
                                    }
                                 } else {
                                    var20 = var46.field3205;
                                    var21 = var46.field3203;
                                    if(!var10.field2107) {
                                       var40 = var10.width * 4096 / var20;
                                       if(var10.field2106 != 0) {
                                          var46.method4237(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2106, var40);
                                       } else if(var14 != 0) {
                                          var46.method4200(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var46.method4192(var12, var13);
                                       } else {
                                          var46.method4266(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class219.method4068(var12, var13, var10.width + var12, var10.height + var13);
                                       var40 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var10.height + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var40; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2106 != 0) {
                                                var46.method4237(var20 / 2 + var24 * var20 + var12, var13 + var21 * var25 + var21 / 2, var10.field2106, 4096);
                                             } else if(var14 != 0) {
                                                var46.method4198(var20 * var24 + var12, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var46.method4192(var24 * var20 + var12, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       class219.method4041(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var37;
                              if(var10.type == 6) {
                                 boolean var57 = class16.method198(var10);
                                 if(var57) {
                                    var20 = var10.field2117;
                                 } else {
                                    var20 = var10.field2116;
                                 }

                                 Model var56 = null;
                                 var40 = 0;
                                 if(var10.item != -1) {
                                    var37 = class18.getItemDefinition(var10.item);
                                    if(null != var37) {
                                       var37 = var37.method3716(var10.stackSize);
                                       var56 = var37.getModel(1);
                                       if(null != var56) {
                                          var56.method1584();
                                          var40 = var56.modelHeight / 2;
                                       } else {
                                          Tile.method1577(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var56 = Client.field415.method2799((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var56 = class40.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var56 = var10.method2845((Sequence)null, -1, var57, class40.localPlayer.composition);
                                    if(var56 == null && Widget.field2067) {
                                       Tile.method1577(var10);
                                    }
                                 } else {
                                    Sequence var58 = class9.getAnimation(var20);
                                    var56 = var10.method2845(var58, var10.field2057, var57, class40.localPlayer.composition);
                                    if(null == var56 && Widget.field2067) {
                                       Tile.method1577(var10);
                                    }
                                 }

                                 class84.method1669(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = class84.field1444[var10.rotationX] * var10.field2134 >> 16;
                                 var24 = var10.field2134 * class84.field1445[var10.rotationX] >> 16;
                                 if(null != var56) {
                                    if(!var10.field2068) {
                                       var56.method1596(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var56.method1584();
                                       if(var10.field2140) {
                                          var56.method1597(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2131, var40 + var23 + var10.field2119, var10.field2119 + var24, var10.field2134);
                                       } else {
                                          var56.method1596(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2131, var10.field2119 + var40 + var23, var24 + var10.field2119);
                                       }
                                    }
                                 }

                                 class84.method1731();
                              } else {
                                 if(var10.type == 7) {
                                    var45 = var10.method2843();
                                    if(var45 == null) {
                                       if(Widget.field2067) {
                                          Tile.method1577(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2081; ++var21) {
                                       for(var40 = 0; var40 < var10.field2144; ++var40) {
                                          if(var10.itemIds[var20] > 0) {
                                             var37 = class18.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var39;
                                             if(var37.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var39 = class13.method182(16748608) + var37.name + "</col>";
                                             } else {
                                                var39 = class13.method182(16748608) + var37.name + "</col>" + " " + 'x' + class145.method2788(var10.itemQuantities[var20]);
                                             }

                                             var25 = (115 + var10.field2135) * var40 + var12;
                                             var26 = (var10.field2136 + 12) * var21 + var13;
                                             if(var10.field2132 == 0) {
                                                var45.method3920(var39, var25, var26, var10.textColor, var10.field2173?0:-1);
                                             } else if(var10.field2132 == 1) {
                                                var45.method3907(var39, var10.width / 2 + var25, var26, var10.textColor, var10.field2173?0:-1);
                                             } else {
                                                var45.method3934(var39, var25 + var10.width - 1, var26, var10.textColor, var10.field2173?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && class105.field1723 == var10 && Client.field436 == Client.field424) {
                                    var36 = 0;
                                    var20 = 0;
                                    class208 var38 = XGrandExchangeOffer.field45;
                                    String var22 = var10.text;

                                    String var55;
                                    for(var22 = class72.method1406(var22, var10); var22.length() > 0; var20 += var38.field3091 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var55 = var22.substring(0, var24);
                                          var22 = var22.substring(var24 + 4);
                                       } else {
                                          var55 = var22;
                                          var22 = "";
                                       }

                                       var25 = var38.method3912(var55);
                                       if(var25 > var36) {
                                          var36 = var25;
                                       }
                                    }

                                    var36 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var36;
                                    var25 = var13 + var10.height + 5;
                                    if(var24 < 5 + var12) {
                                       var24 = 5 + var12;
                                    }

                                    if(var36 + var24 > var4) {
                                       var24 = var4 - var36;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class219.method4071(var24, var25, var36, var20, 16777120);
                                    class219.method4053(var24, var25, var36, var20, 0);
                                    var22 = var10.text;
                                    var26 = 2 + var38.field3091 + var25;

                                    for(var22 = class72.method1406(var22, var10); var22.length() > 0; var26 += 1 + var38.field3091) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var55 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var55 = var22;
                                          var22 = "";
                                       }

                                       var38.method3920(var55, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2102 == 1) {
                                       if(var10.field2103) {
                                          var36 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var10.width + var12;
                                          var40 = var13;
                                       } else {
                                          var36 = var12;
                                          var20 = var13;
                                          var21 = var10.width + var12;
                                          var40 = var10.height + var13;
                                       }

                                       class219.method4059(var36, var20, var21, var40, var10.textColor);
                                    } else {
                                       var36 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var36;
                                       if(var36 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var40 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var40) {
                                             var40 = -var40;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2102 >> 17;
                                          var25 = 1 + var10.field2102 * var23 >> 17;
                                          var26 = var40 * var10.field2102 >> 17;
                                          var27 = 1 + var40 * var10.field2102 >> 17;
                                          var42 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.width - var25;
                                          var31 = var24 + var10.width + var12;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var27;
                                          int var34 = var10.height + var13 - var27;
                                          int var35 = var26 + var13 + var10.height;
                                          class84.setRasterClippingEnabled(var42, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var42, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var42, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var42, var30, var31, var10.textColor);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)V",
      garbageValue = "0"
   )
   public static void method3323(class182 var0, class182 var1) {
      NPCComposition.field2999 = var0;
      NPCComposition.field2993 = var1;
   }
}
