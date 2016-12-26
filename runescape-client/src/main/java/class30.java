import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class30 {
   @ObfuscatedName("n")
   LinkedHashMap field687 = new LinkedHashMap();
   @ObfuscatedName("f")
   boolean field689;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1707707053
   )
   static int field690 = 4;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 817745967
   )
   int field691 = 1;
   @ObfuscatedName("k")
   boolean field692;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1917799877
   )
   public static int field693;

   class30(Buffer var1) {
      if(null != var1 && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field690) {
            if(var1.readUnsignedByte() == 1) {
               this.field689 = true;
            }

            if(var2 > 1) {
               this.field692 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field691 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2844();
                  int var6 = var1.method2844();
                  this.field687.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method636(true);
         }
      } else {
         this.method636(true);
      }

   }

   class30() {
      this.method636(true);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "1049586152"
   )
   Buffer method626() {
      Buffer var1 = new Buffer(100);
      var1.method2932(field690);
      var1.method2932(this.field689?1:0);
      var1.method2932(this.field692?1:0);
      var1.method2932(this.field691);
      var1.method2932(this.field687.size());
      Iterator var2 = this.field687.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2748(((Integer)var3.getKey()).intValue());
         var1.method2748(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-65536"
   )
   public static int method632(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-761289143"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class219.method3889(var2, var3, var4, var5);
      class84.method1626();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field511)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field281] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field281] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field281] = var10.width;
               Client.widgetBoundsHeight[Client.field281] = var10.height;
               var11 = ++Client.field281 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2340 = Client.gameCycle;
            if(!var10.field2198 || !class221.method3975(var10)) {
               if(var10.contentType > 0) {
                  class13.method165(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field511) {
                  if(var1 != -1412584499 && !var10.field2286) {
                     class186.field2772 = var0;
                     class116.field1815 = var6;
                     Overlay.field3047 = var7;
                     continue;
                  }

                  if(Client.field470 && Client.field464) {
                     var15 = class115.field1794;
                     var16 = class115.field1797;
                     var15 -= Client.field461;
                     var16 -= Client.field462;
                     if(var15 < Client.field494) {
                        var15 = Client.field494;
                     }

                     if(var10.width + var15 > Client.field494 + Client.field460.width) {
                        var15 = Client.field460.width + Client.field494 - var10.width;
                     }

                     if(var16 < Client.field329) {
                        var16 = Client.field329;
                     }

                     if(var10.height + var16 > Client.field329 + Client.field460.height) {
                        var16 = Client.field329 + Client.field460.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2286) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var22 = var10.height + var13;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2198 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var26;
                  int var27;
                  int var28;
                  int var31;
                  int var37;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field469) {
                           var13 += 15;
                           class40.field821.method3781("Fps:" + GameEngine.field1764, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var59 = Runtime.getRuntime();
                           var20 = (int)((var59.totalMemory() - var59.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field289) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field289) {
                              var21 = 16711680;
                           }

                           class40.field821.method3781("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field435 = var12;
                        Client.field340 = var13;
                        class94.method1892(var12, var13, var10.width, var10.height);
                        Client.field524[var10.boundsIndex] = true;
                        class219.method3889(var2, var3, var4, var5);
                        continue;
                     }

                     class164 var58;
                     if(var10.contentType == 1338) {
                        class115.method2194();
                        var58 = var10.method3111(false);
                        if(null != var58) {
                           class219.method3889(var12, var13, var12 + var58.field2159, var58.field2167 + var13);
                           if(Client.field522 != 2 && Client.field522 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var21 = class39.localPlayer.x / 32 + 48;
                              var22 = 464 - class39.localPlayer.y / 32;
                              class159.field2131.method4036(var12, var13, var58.field2159, var58.field2167, var21, var22, var20, 256 + Client.mapScaleDelta, var58.field2161, var58.field2158);

                              for(var23 = 0; var23 < Client.field516; ++var23) {
                                 var24 = Client.field357[var23] * 4 + 2 - class39.localPlayer.x / 32;
                                 var37 = 2 + Client.field510[var23] * 4 - class39.localPlayer.y / 32;
                                 NPC.method675(var12, var13, var24, var37, Client.field519[var23], var58);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field322; ++var23) {
                                       NPC var62 = Client.cachedNPCs[Client.field323[var23]];
                                       if(null != var62 && var62.vmethod679()) {
                                          NPCComposition var46 = var62.composition;
                                          if(var46 != null && var46.field3028 != null) {
                                             var46 = var46.method3635();
                                          }

                                          if(null != var46 && var46.isMinimapVisible && var46.field3009) {
                                             var26 = var62.x / 32 - class39.localPlayer.x / 32;
                                             var27 = var62.y / 32 - class39.localPlayer.y / 32;
                                             NPC.method675(var12, var13, var26, var27, class13.field130[1], var58);
                                          }
                                       }
                                    }

                                    var23 = class45.field908;
                                    int[] var63 = class45.field903;

                                    for(var37 = 0; var37 < var23; ++var37) {
                                       Player var43 = Client.cachedPlayers[var63[var37]];
                                       if(null != var43 && var43.vmethod679() && !var43.field245 && var43 != class39.localPlayer) {
                                          var27 = var43.x / 32 - class39.localPlayer.x / 32;
                                          var28 = var43.y / 32 - class39.localPlayer.y / 32;
                                          boolean var52 = false;
                                          if(class119.method2252(var43.name, true)) {
                                             var52 = true;
                                          }

                                          boolean var50 = false;

                                          for(var31 = 0; var31 < class13.field136; ++var31) {
                                             if(var43.name.equals(class8.clanMembers[var31].username)) {
                                                var50 = true;
                                                break;
                                             }
                                          }

                                          boolean var51 = false;
                                          if(class39.localPlayer.team != 0 && var43.team != 0 && class39.localPlayer.team == var43.team) {
                                             var51 = true;
                                          }

                                          if(var52) {
                                             NPC.method675(var12, var13, var27, var28, class13.field130[3], var58);
                                          } else if(var51) {
                                             NPC.method675(var12, var13, var27, var28, class13.field130[4], var58);
                                          } else if(var50) {
                                             NPC.method675(var12, var13, var27, var28, class13.field130[5], var58);
                                          } else {
                                             NPC.method675(var12, var13, var27, var28, class13.field130[2], var58);
                                          }
                                       }
                                    }

                                    if(Client.field489 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field489 == 1 && Client.field302 >= 0 && Client.field302 < Client.cachedNPCs.length) {
                                          NPC var47 = Client.cachedNPCs[Client.field302];
                                          if(null != var47) {
                                             var26 = var47.x / 32 - class39.localPlayer.x / 32;
                                             var27 = var47.y / 32 - class39.localPlayer.y / 32;
                                             TextureProvider.method1444(var12, var13, var26, var27, class142.field1992[1], var58);
                                          }
                                       }

                                       if(Client.field489 == 2) {
                                          var37 = 2 + (Client.field304 * 4 - class15.baseX * 4) - class39.localPlayer.x / 32;
                                          var26 = Client.field402 * 4 - class20.baseY * 4 + 2 - class39.localPlayer.y / 32;
                                          TextureProvider.method1444(var12, var13, var37, var26, class142.field1992[1], var58);
                                       }

                                       if(Client.field489 == 10 && Client.field303 >= 0 && Client.field303 < Client.cachedPlayers.length) {
                                          Player var48 = Client.cachedPlayers[Client.field303];
                                          if(null != var48) {
                                             var26 = var48.x / 32 - class39.localPlayer.x / 32;
                                             var27 = var48.y / 32 - class39.localPlayer.y / 32;
                                             TextureProvider.method1444(var12, var13, var26, var27, class142.field1992[1], var58);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var37 = Client.flagX * 4 + 2 - class39.localPlayer.x / 32;
                                       var26 = 2 + Client.flagY * 4 - class39.localPlayer.y / 32;
                                       NPC.method675(var12, var13, var37, var26, class142.field1992[0], var58);
                                    }

                                    if(!class39.localPlayer.field245) {
                                       class219.method3910(var12 + var58.field2159 / 2 - 1, var13 + var58.field2167 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var25 = Client.groundItemDeque[class171.plane][var23][var24];
                                    if(null != var25) {
                                       var26 = 2 + 4 * var23 - class39.localPlayer.x / 32;
                                       var27 = var24 * 4 + 2 - class39.localPlayer.y / 32;
                                       NPC.method675(var12, var13, var26, var27, class13.field130[0], var58);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class219.method3908(var12, var13, 0, var58.field2161, var58.field2158);
                           }

                           Client.field560[var11] = true;
                        }

                        class219.method3889(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var58 = var10.method3111(false);
                        if(var58 != null) {
                           if(Client.field522 < 3) {
                              class178.field2678.method4036(var12, var13, var58.field2159, var58.field2167, 25, 25, Client.mapAngle, 256, var58.field2161, var58.field2158);
                           } else {
                              class219.method3908(var12, var13, 0, var58.field2161, var58.field2158);
                           }
                        }

                        class219.method3889(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2198 && class221.method3975(var10) && var10 != FaceNormal.field1558) {
                        continue;
                     }

                     if(!var10.field2198) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var38 = (WidgetNode)Client.componentTable.method2311((long)var10.id);
                     if(var38 != null) {
                        class63.method1133(var38.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class219.method3889(var2, var3, var4, var5);
                     class84.method1626();
                  }

                  if(Client.isResized || Client.field559[var11] || Client.field498 > 1) {
                     if(var10.type == 0 && !var10.field2198 && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class9.field81[0].method3979(var19, var13);
                        class9.field81[1].method3979(var19, var21 + var13 - 16);
                        class219.method3910(var19, var13 + 16, 16, var21 - 32, Client.field502);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        class219.method3910(var19, var24 + var13 + 16, 16, var23, Client.field507);
                        class219.method3905(var19, var24 + var13 + 16, var23, Client.field492);
                        class219.method3905(1 + var19, var24 + 16 + var13, var23, Client.field492);
                        class219.method3886(var19, var13 + 16 + var24, 16, Client.field492);
                        class219.method3886(var19, var24 + 17 + var13, 16, Client.field492);
                        class219.method3905(15 + var19, 16 + var13 + var24, var23, Client.field367);
                        class219.method3905(14 + var19, 17 + var13 + var24, var23 - 1, Client.field367);
                        class219.method3886(var19, var24 + var13 + 15 + var23, 16, Client.field367);
                        class219.method3886(var19 + 1, var24 + 14 + var13 + var23, 15, Client.field367);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2220; ++var20) {
                              for(var21 = 0; var21 < var10.field2219; ++var21) {
                                 var22 = var12 + (32 + var10.field2274) * var21;
                                 var23 = (var10.field2228 + 32) * var20 + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2261[var19];
                                    var23 += var10.field2277[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2278 && var19 < 20) {
                                       SpritePixels var61 = var10.method3117(var19);
                                       if(null != var61) {
                                          var61.method4032(var22, var23);
                                       } else if(Widget.field2206) {
                                          class94.method1890(var10);
                                       }
                                    }
                                 } else {
                                    boolean var49 = false;
                                    boolean var57 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || WallObject.field1550 == var10 && Client.field401 == var19) {
                                       SpritePixels var41;
                                       if(Client.field526 == 1 && var19 == class10.field103 && ObjectComposition.field2941 == var10.id) {
                                          var41 = class180.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var41 = class180.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var41 != null) {
                                          if(WallObject.field1550 == var10 && Client.field401 == var19) {
                                             var24 = class115.field1794 - Client.field484;
                                             var37 = class115.field1797 - Client.field403;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var37 < 5 && var37 > -5) {
                                                var37 = 0;
                                             }

                                             if(Client.field406 < 5) {
                                                var24 = 0;
                                                var37 = 0;
                                             }

                                             var41.method4038(var22 + var24, var23 + var37, 128);
                                             if(var1 != -1) {
                                                Widget var44 = var0[var1 & '\uffff'];
                                                if(var23 + var37 < class219.field3171 && var44.scrollY > 0) {
                                                   var29 = (class219.field3171 - var23 - var37) * Client.field364 / 3;
                                                   if(var29 > Client.field364 * 10) {
                                                      var29 = Client.field364 * 10;
                                                   }

                                                   if(var29 > var44.scrollY) {
                                                      var29 = var44.scrollY;
                                                   }

                                                   var44.scrollY -= var29;
                                                   Client.field403 += var29;
                                                   class94.method1890(var44);
                                                }

                                                if(32 + var23 + var37 > class219.field3177 && var44.scrollY < var44.scrollHeight - var44.height) {
                                                   var29 = (var37 + var23 + 32 - class219.field3177) * Client.field364 / 3;
                                                   if(var29 > Client.field364 * 10) {
                                                      var29 = Client.field364 * 10;
                                                   }

                                                   if(var29 > var44.scrollHeight - var44.height - var44.scrollY) {
                                                      var29 = var44.scrollHeight - var44.height - var44.scrollY;
                                                   }

                                                   var44.scrollY += var29;
                                                   Client.field403 -= var29;
                                                   class94.method1890(var44);
                                                }
                                             }
                                          } else if(var10 == class10.field107 && var19 == Client.field506) {
                                             var41.method4038(var22, var23, 128);
                                          } else {
                                             var41.method4032(var22, var23);
                                          }
                                       } else {
                                          class94.method1890(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class16.method176(var10)) {
                              var19 = var10.field2234;
                              if(FaceNormal.field1558 == var10 && var10.field2236 != 0) {
                                 var19 = var10.field2236;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == FaceNormal.field1558 && var10.field2235 != 0) {
                                 var19 = var10.field2235;
                              }
                           }

                           if(var10.field2237) {
                              switch(var10.field2204.field3187) {
                              case 1:
                                 class219.method3922(var12, var13, var10.width, var10.height, var10.textColor, var10.field2234, 256 - (var10.opacity & 255), 256 - (var10.field2270 & 255));
                                 break;
                              case 2:
                                 class219.method3902(var12, var13, var10.width, var10.height, var10.textColor, var10.field2234, 256 - (var10.opacity & 255), 256 - (var10.field2270 & 255));
                                 break;
                              case 3:
                                 class219.method3898(var12, var13, var10.width, var10.height, var10.textColor, var10.field2234, 256 - (var10.opacity & 255), 256 - (var10.field2270 & 255));
                                 break;
                              case 4:
                                 class219.method3899(var12, var13, var10.width, var10.height, var10.textColor, var10.field2234, 256 - (var10.opacity & 255), 256 - (var10.field2270 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class219.method3910(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    class219.method3894(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class219.method3932(var12, var13, var10.width, var10.height, var19);
                           } else {
                              class219.method3946(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class208 var53;
                           if(var10.type == 4) {
                              var53 = var10.method3119();
                              if(var53 == null) {
                                 if(Widget.field2206) {
                                    class94.method1890(var10);
                                 }
                              } else {
                                 String var60 = var10.text;
                                 if(class16.method176(var10)) {
                                    var20 = var10.field2234;
                                    if(FaceNormal.field1558 == var10 && var10.field2236 != 0) {
                                       var20 = var10.field2236;
                                    }

                                    if(var10.field2269.length() > 0) {
                                       var60 = var10.field2269;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(FaceNormal.field1558 == var10 && var10.field2235 != 0) {
                                       var20 = var10.field2235;
                                    }
                                 }

                                 if(var10.field2198 && var10.item != -1) {
                                    ItemComposition var55 = class7.getItemDefinition(var10.item);
                                    var60 = var55.name;
                                    if(var60 == null) {
                                       var60 = "null";
                                    }

                                    if((var55.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var60 = class155.method2949(16748608) + var60 + "</col>" + " " + 'x' + class115.method2195(var10.stackSize);
                                    }
                                 }

                                 if(Client.field450 == var10) {
                                    Object var10000 = null;
                                    var60 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2198) {
                                    var60 = FrameMap.method1688(var60, var10);
                                 }

                                 var53.method3773(var60, var12, var13, var10.width, var10.height, var20, var10.field2273?0:-1, var10.field2271, var10.field2202, var10.field2276);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var54;
                              if(!var10.field2198) {
                                 var54 = var10.method3107(class16.method176(var10));
                                 if(null != var54) {
                                    var54.method4032(var12, var13);
                                 } else if(Widget.field2206) {
                                    class94.method1890(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var54 = class180.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2266, false);
                                 } else {
                                    var54 = var10.method3107(false);
                                 }

                                 if(null == var54) {
                                    if(Widget.field2206) {
                                       class94.method1890(var10);
                                    }
                                 } else {
                                    var20 = var54.field3210;
                                    var21 = var54.field3208;
                                    if(!var10.field2246) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2245 != 0) {
                                          var54.method4045(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2245, var22);
                                       } else if(var14 != 0) {
                                          var54.method4084(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var54.method4032(var12, var13);
                                       } else {
                                          var54.method4043(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class219.method3890(var12, var13, var12 + var10.width, var10.height + var13);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var10.height + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var37 = 0; var37 < var23; ++var37) {
                                             if(var10.field2245 != 0) {
                                                var54.method4045(var20 / 2 + var12 + var24 * var20, var21 / 2 + var21 * var37 + var13, var10.field2245, 4096);
                                             } else if(var14 != 0) {
                                                var54.method4038(var12 + var20 * var24, var13 + var21 * var37, 256 - (var14 & 255));
                                             } else {
                                                var54.method4032(var20 * var24 + var12, var21 * var37 + var13);
                                             }
                                          }
                                       }

                                       class219.method3889(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var42;
                              if(var10.type == 6) {
                                 boolean var45 = class16.method176(var10);
                                 if(var45) {
                                    var20 = var10.field2256;
                                 } else {
                                    var20 = var10.field2255;
                                 }

                                 Model var56 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var42 = class7.getItemDefinition(var10.item);
                                    if(null != var42) {
                                       var42 = var42.method3590(var10.stackSize);
                                       var56 = var42.getModel(1);
                                       if(var56 != null) {
                                          var56.method1546();
                                          var22 = var56.modelHeight / 2;
                                       } else {
                                          class94.method1890(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var56 = Client.field284.method3063((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var56 = class39.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var56 = var10.method3110((Sequence)null, -1, var45, class39.localPlayer.composition);
                                    if(null == var56 && Widget.field2206) {
                                       class94.method1890(var10);
                                    }
                                 } else {
                                    Sequence var65 = GameEngine.getAnimation(var20);
                                    var56 = var10.method3110(var65, var10.field2330, var45, class39.localPlayer.composition);
                                    if(null == var56 && Widget.field2206) {
                                       class94.method1890(var10);
                                    }
                                 }

                                 class84.method1629(var10.width / 2 + var12, var13 + var10.height / 2);
                                 var23 = var10.field2262 * class84.field1453[var10.rotationX] >> 16;
                                 var24 = class84.field1454[var10.rotationX] * var10.field2262 >> 16;
                                 if(var56 != null) {
                                    if(!var10.field2198) {
                                       var56.method1556(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var56.method1546();
                                       if(var10.field2265) {
                                          var56.method1560(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2283, var10.field2258 + var23 + var22, var10.field2258 + var24, var10.field2262);
                                       } else {
                                          var56.method1556(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2283, var10.field2258 + var23 + var22, var24 + var10.field2258);
                                       }
                                    }
                                 }

                                 class84.method1670();
                              } else {
                                 if(var10.type == 7) {
                                    var53 = var10.method3119();
                                    if(null == var53) {
                                       if(Widget.field2206) {
                                          class94.method1890(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2220; ++var21) {
                                       for(var22 = 0; var22 < var10.field2219; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var42 = class7.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var40;
                                             if(var42.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var40 = class155.method2949(16748608) + var42.name + "</col>";
                                             } else {
                                                var40 = class155.method2949(16748608) + var42.name + "</col>" + " " + 'x' + class115.method2195(var10.itemQuantities[var20]);
                                             }

                                             var37 = (var10.field2274 + 115) * var22 + var12;
                                             var26 = var21 * (var10.field2228 + 12) + var13;
                                             if(var10.field2271 == 0) {
                                                var53.method3779(var40, var37, var26, var10.textColor, var10.field2273?0:-1);
                                             } else if(var10.field2271 == 1) {
                                                var53.method3782(var40, var10.width / 2 + var37, var26, var10.textColor, var10.field2273?0:-1);
                                             } else {
                                                var53.method3781(var40, var10.width + var37 - 1, var26, var10.textColor, var10.field2273?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && class10.field105 == var10 && Client.field437 == Client.field493) {
                                    var19 = 0;
                                    var20 = 0;
                                    class208 var39 = class40.field821;
                                    String var36 = var10.text;

                                    String var64;
                                    for(var36 = FrameMap.method1688(var36, var10); var36.length() > 0; var20 += var39.field3097 + 1) {
                                       var24 = var36.indexOf("<br>");
                                       if(var24 != -1) {
                                          var64 = var36.substring(0, var24);
                                          var36 = var36.substring(4 + var24);
                                       } else {
                                          var64 = var36;
                                          var36 = "";
                                       }

                                       var37 = var39.method3774(var64);
                                       if(var37 > var19) {
                                          var19 = var37;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var37 = 5 + var13 + var10.height;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var37 + var20 > var5) {
                                       var37 = var5 - var20;
                                    }

                                    class219.method3910(var24, var37, var19, var20, 16777120);
                                    class219.method3932(var24, var37, var19, var20, 0);
                                    var36 = var10.text;
                                    var26 = 2 + var39.field3097 + var37;

                                    for(var36 = FrameMap.method1688(var36, var10); var36.length() > 0; var26 += var39.field3097 + 1) {
                                       var27 = var36.indexOf("<br>");
                                       if(var27 != -1) {
                                          var64 = var36.substring(0, var27);
                                          var36 = var36.substring(var27 + 4);
                                       } else {
                                          var64 = var36;
                                          var36 = "";
                                       }

                                       var39.method3779(var64, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2239 == 1) {
                                       if(var10.field2242) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var10.width + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var10.width + var12;
                                          var22 = var13 + var10.height;
                                       }

                                       class219.method3907(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var10.field2239 * var23 >> 17;
                                          var37 = 1 + var10.field2239 * var23 >> 17;
                                          var26 = var10.field2239 * var22 >> 17;
                                          var27 = 1 + var22 * var10.field2239 >> 17;
                                          var28 = var24 + var12;
                                          var29 = var12 - var37;
                                          int var30 = var12 + var10.width - var37;
                                          var31 = var12 + var10.width + var24;
                                          int var32 = var26 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var10.height + var13 - var27;
                                          int var35 = var13 + var10.height + var26;
                                          class84.setRasterClippingEnabled(var28, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var28, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var28, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var28, var30, var31, var10.textColor);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "52"
   )
   void method636(boolean var1) {
   }
}
