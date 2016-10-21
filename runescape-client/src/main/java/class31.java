import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public final class class31 extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -140276247
   )
   int field694 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 845488461
   )
   int field695;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -183832535
   )
   int field696;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1550767261
   )
   int field698;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 444055067
   )
   int field699;
   @ObfuscatedName("m")
   Sequence field700;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -810632935
   )
   int field701 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1431068179
   )
   int field702;
   @ObfuscatedName("w")
   boolean field703 = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1962901933
   )
   int field706;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-85"
   )
   static char method672(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1259360373"
   )
   public static void method673(Component var0) {
      var0.removeKeyListener(class140.keyboard);
      var0.removeFocusListener(class140.keyboard);
      class140.field2168 = -1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "3"
   )
   protected final Model getModel() {
      class45 var1 = GameEngine.method3084(this.field696);
      Model var2;
      if(!this.field703) {
         var2 = var1.method921(this.field701);
      } else {
         var2 = var1.method921(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIIS)V",
      garbageValue = "31431"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1895(var2, var3, var4, var5);
      class94.method2132();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && Client.field452 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field482] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field482] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field482] = var10.width;
               Client.widgetBoundsHeight[Client.field482] = var10.height;
               var11 = ++Client.field482 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2920 = Client.gameCycle;
            if(!var10.field2787 || !class178.method3504(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field464 == -1) {
                        Client.field464 = var10.textureId;
                        Client.field554 = var10.field2824;
                     }

                     if(Client.field305.isFemale) {
                        var10.textureId = Client.field464;
                     } else {
                        var10.textureId = Client.field554;
                     }
                  } else if(var12 == 325) {
                     if(Client.field464 == -1) {
                        Client.field464 = var10.textureId;
                        Client.field554 = var10.field2824;
                     }

                     if(Client.field305.isFemale) {
                        var10.textureId = Client.field554;
                     } else {
                        var10.textureId = Client.field464;
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
               if(var10 == Client.field452) {
                  if(var1 != -1412584499 && !var10.field2866) {
                     class9.field158 = var0;
                     ChatMessages.field272 = var6;
                     class125.field2077 = var7;
                     continue;
                  }

                  if(Client.field463 && Client.field396) {
                     var15 = class143.field2192;
                     var16 = class143.field2199;
                     var15 -= Client.field521;
                     var16 -= Client.field455;
                     if(var15 < Client.field400) {
                        var15 = Client.field400;
                     }

                     if(var10.width + var15 > Client.field400 + Client.field453.width) {
                        var15 = Client.field453.width + Client.field400 - var10.width;
                     }

                     if(var16 < Client.field459) {
                        var16 = Client.field459;
                     }

                     if(var10.height + var16 > Client.field453.height + Client.field459) {
                        var16 = Client.field459 + Client.field453.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2866) {
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
                  var21 = var12 + var10.width;
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
                  var19 = var10.width + var12;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2787 || var15 < var17 && var16 < var18) {
                  int var26;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var39;
                  int var41;
                  int var42;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field296) {
                           var13 += 15;
                           class112.field1962.method4098("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var56 = Runtime.getRuntime();
                           var20 = (int)((var56.totalMemory() - var56.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field286) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field286) {
                              var21 = 16711680;
                           }

                           class112.field1962.method4098("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field428 = var12;
                        Client.field500 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field386;
                        class22.method584(class35.field779);
                        boolean var50 = false;
                        if(Client.field471 >= 0) {
                           var42 = class34.field763;
                           int[] var25 = class34.field758;

                           for(var26 = 0; var26 < var42; ++var26) {
                              if(Client.field471 == var25[var26]) {
                                 var50 = true;
                                 break;
                              }
                           }
                        }

                        if(var50) {
                           class22.method584(class35.field785);
                        }

                        class35.method738(true);
                        class22.method584(var50?class35.field777:class35.field778);
                        class35.method738(false);

                        for(Projectile var48 = (Projectile)Client.projectiles.method3890(); var48 != null; var48 = (Projectile)Client.projectiles.method3892()) {
                           if(XItemContainer.plane == var48.floor && Client.gameCycle <= var48.field106) {
                              if(Client.gameCycle >= var48.startTime) {
                                 if(var48.interacting > 0) {
                                    NPC var45 = Client.cachedNPCs[var48.interacting - 1];
                                    if(var45 != null && var45.x >= 0 && var45.x < 13312 && var45.y >= 0 && var45.y < 13312) {
                                       var48.method82(var45.x, var45.y, Renderable.method1960(var45.x, var45.y, var48.floor) - var48.field104, Client.gameCycle);
                                    }
                                 }

                                 if(var48.interacting < 0) {
                                    var26 = -var48.interacting - 1;
                                    Player var46;
                                    if(Client.localInteractingIndex == var26) {
                                       var46 = class34.localPlayer;
                                    } else {
                                       var46 = Client.cachedPlayers[var26];
                                    }

                                    if(var46 != null && var46.x >= 0 && var46.x < 13312 && var46.y >= 0 && var46.y < 13312) {
                                       var48.method82(var46.x, var46.y, Renderable.method1960(var46.x, var46.y, var48.floor) - var48.field104, Client.gameCycle);
                                    }
                                 }

                                 var48.method88(Client.field358);
                                 class9.region.method2020(XItemContainer.plane, (int)var48.x, (int)var48.velocityZ, (int)var48.z, 60, var48, var48.field119, -1, false);
                              }
                           } else {
                              var48.unlink();
                           }
                        }

                        for(class31 var49 = (class31)Client.field415.method3890(); var49 != null; var49 = (class31)Client.field415.method3892()) {
                           if(XItemContainer.plane == var49.field706 && !var49.field703) {
                              if(Client.gameCycle >= var49.field702) {
                                 var49.method682(Client.field358);
                                 if(var49.field703) {
                                    var49.unlink();
                                 } else {
                                    class9.region.method2020(var49.field706, var49.field695, var49.field698, var49.field699, 60, var49, 0, -1, false);
                                 }
                              }
                           } else {
                              var49.unlink();
                           }
                        }

                        class32.method685(var12, var13, var21, var22, true);
                        var19 = Client.field541;
                        var20 = Client.field547;
                        var21 = Client.camera2;
                        var22 = Client.camera3;
                        class82.method1895(var19, var20, var19 + var21, var22 + var20);
                        class94.method2132();
                        if(!Client.field562) {
                           var42 = Client.field365;
                           if(Client.field374 / 256 > var42) {
                              var42 = Client.field374 / 256;
                           }

                           if(Client.field439[4] && Client.field530[4] + 128 > var42) {
                              var42 = Client.field530[4] + 128;
                           }

                           var39 = Client.mapAngle + Client.field350 & 2047;
                           class124.method2765(TextureProvider.field1683, Renderable.method1960(class34.localPlayer.x, class34.localPlayer.y, XItemContainer.plane) - Client.field371, class18.field264, var42, var39, 600 + var42 * 3);
                        }

                        if(!Client.field562) {
                           var42 = class32.method686();
                        } else {
                           var42 = class9.method112();
                        }

                        var39 = class139.cameraX;
                        var26 = class172.cameraZ;
                        var41 = class77.cameraY;
                        var28 = class144.cameraPitch;
                        var29 = Frames.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field439[var30]) {
                              var31 = (int)(Math.random() * (double)(Client.field467[var30] * 2 + 1) - (double)Client.field467[var30] + Math.sin((double)Client.field422[var30] / 100.0D * (double)Client.field532[var30]) * (double)Client.field530[var30]);
                              if(var30 == 0) {
                                 class139.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 class172.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 class77.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 Frames.cameraYaw = var31 + Frames.cameraYaw & 2047;
                              }

                              if(var30 == 4) {
                                 class144.cameraPitch += var31;
                                 if(class144.cameraPitch < 128) {
                                    class144.cameraPitch = 128;
                                 }

                                 if(class144.cameraPitch > 383) {
                                    class144.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = class143.field2192;
                        var31 = class143.field2199;
                        if(class143.field2198 != 0) {
                           var30 = class143.field2197;
                           var31 = class143.field2207;
                        }

                        if(var30 >= var19 && var30 < var21 + var19 && var31 >= var20 && var31 < var22 + var20) {
                           Model.field1859 = true;
                           Model.field1917 = 0;
                           Model.field1908 = var30 - var19;
                           Model.field1920 = var31 - var20;
                        } else {
                           Model.field1859 = false;
                           Model.field1917 = 0;
                        }

                        class49.method1012();
                        class82.method1861(var19, var20, var21, var22, 0);
                        class49.method1012();
                        var32 = class94.field1631;
                        class94.field1631 = Client.scale;
                        class9.region.method2002(class139.cameraX, class172.cameraZ, class77.cameraY, class144.cameraPitch, Frames.cameraYaw, var42);
                        class94.field1631 = var32;
                        class49.method1012();
                        class9.region.method1978();
                        class179.method3509(var19, var20, var21, var22);
                        class34.method729(var19, var20);
                        ((TextureProvider)class94.field1642).method2213(Client.field358);
                        class14.method162(var19, var20, var21, var22);
                        class139.cameraX = var39;
                        class172.cameraZ = var26;
                        class77.cameraY = var41;
                        class144.cameraPitch = var28;
                        Frames.cameraYaw = var29;
                        if(Client.field527 && class8.method99(true, false) == 0) {
                           Client.field527 = false;
                        }

                        if(Client.field527) {
                           class82.method1861(var19, var20, var21, var22, 0);
                           class12.method145("Loading - please wait.", false);
                        }

                        Client.field526[var10.boundsIndex] = true;
                        class82.method1895(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class119.method2477(var10, var12, var13, var11);
                        class82.method1895(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class178 var55 = var10.method3474(false);
                        if(null != var55) {
                           if(Client.field369 < 3) {
                              ObjectComposition.field954.method1783(var12, var13, var55.field2930, var55.field2931, 25, 25, Client.mapAngle, 256, var55.field2933, var55.field2932);
                           } else {
                              class82.method1859(var12, var13, 0, var55.field2933, var55.field2932);
                           }
                        }

                        class82.method1895(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2787 && class178.method3504(var10) && class113.field1973 != var10) {
                        continue;
                     }

                     if(!var10.field2787) {
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

                     WidgetNode var37 = (WidgetNode)Client.componentTable.method3849((long)var10.id);
                     if(null != var37) {
                        var20 = var37.id;
                        if(!class171.method3404(var20)) {
                           if(var11 != -1) {
                              Client.field526[var11] = true;
                           } else {
                              for(var21 = 0; var21 < 100; ++var21) {
                                 Client.field526[var21] = true;
                              }
                           }
                        } else {
                           class9.field158 = null;
                           gameDraw(Widget.widgets[var20], -1, var15, var16, var17, var18, var12, var13, var11);
                           if(null != class9.field158) {
                              gameDraw(class9.field158, -1412584499, var15, var16, var17, var18, ChatMessages.field272, class125.field2077, var11);
                              class9.field158 = null;
                           }
                        }
                     }

                     class82.method1895(var2, var3, var4, var5);
                     class94.method2132();
                  }

                  if(Client.isResized || Client.field486[var11] || Client.field307 > 1) {
                     int var23;
                     if(var10.type == 0 && !var10.field2787 && var10.scrollHeight > var10.height) {
                        var19 = var10.width + var12;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class8.field150[0].method1913(var19, var13);
                        class8.field150[1].method1913(var19, var21 + var13 - 16);
                        class82.method1861(var19, var13 + 16, 16, var21 - 32, Client.field359 * 2301979);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var42 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        class82.method1861(var19, var42 + var13 + 16, 16, var23, Client.field360 * 5063219);
                        class82.method1856(var19, 16 + var13 + var42, var23, Client.field362);
                        class82.method1856(1 + var19, var42 + var13 + 16, var23, Client.field362);
                        class82.method1854(var19, var13 + 16 + var42, 16, Client.field362);
                        class82.method1854(var19, var13 + 17 + var42, 16, Client.field362);
                        class82.method1856(15 + var19, var13 + 16 + var42, var23, Client.field361 * 3353893);
                        class82.method1856(14 + var19, 17 + var13 + var42, var23 - 1, Client.field361 * 3353893);
                        class82.method1854(var19, 15 + var13 + var42 + var23, 16, Client.field361 * 3353893);
                        class82.method1854(1 + var19, var23 + var42 + 14 + var13, 15, Client.field361 * 3353893);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2800; ++var20) {
                              for(var21 = 0; var21 < var10.field2799; ++var21) {
                                 var22 = var12 + (32 + var10.field2825) * var21;
                                 var23 = var20 * (var10.field2922 + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2856[var19];
                                    var23 += var10.field2857[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2858 && var19 < 20) {
                                       SpritePixels var47 = var10.method3447(var19);
                                       if(null != var47) {
                                          var47.method1763(var22, var23);
                                       } else if(Widget.field2786) {
                                          MessageNode.method750(var10);
                                       }
                                    }
                                 } else {
                                    boolean var61 = false;
                                    boolean var57 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == Projectile.field124 && Client.field395 == var19) {
                                       SpritePixels var27;
                                       if(Client.field432 == 1 && class52.field1128 == var19 && class62.field1263 == var10.id) {
                                          var27 = class53.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class53.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == Projectile.field124 && var19 == Client.field395) {
                                             var42 = class143.field2192 - Client.field393;
                                             var39 = class143.field2199 - Client.field417;
                                             if(var42 < 5 && var42 > -5) {
                                                var42 = 0;
                                             }

                                             if(var39 < 5 && var39 > -5) {
                                                var39 = 0;
                                             }

                                             if(Client.field402 < 5) {
                                                var42 = 0;
                                                var39 = 0;
                                             }

                                             var27.method1768(var42 + var22, var23 + var39, 128);
                                             if(var1 != -1) {
                                                Widget var38 = var0[var1 & '\uffff'];
                                                if(var39 + var23 < class82.field1466 && var38.scrollY > 0) {
                                                   var29 = Client.field358 * (class82.field1466 - var23 - var39) / 3;
                                                   if(var29 > Client.field358 * 10) {
                                                      var29 = Client.field358 * 10;
                                                   }

                                                   if(var29 > var38.scrollY) {
                                                      var29 = var38.scrollY;
                                                   }

                                                   var38.scrollY -= var29;
                                                   Client.field417 += var29;
                                                   MessageNode.method750(var38);
                                                }

                                                if(var23 + var39 + 32 > class82.field1463 && var38.scrollY < var38.scrollHeight - var38.height) {
                                                   var29 = Client.field358 * (32 + var39 + var23 - class82.field1463) / 3;
                                                   if(var29 > Client.field358 * 10) {
                                                      var29 = Client.field358 * 10;
                                                   }

                                                   if(var29 > var38.scrollHeight - var38.height - var38.scrollY) {
                                                      var29 = var38.scrollHeight - var38.height - var38.scrollY;
                                                   }

                                                   var38.scrollY += var29;
                                                   Client.field417 -= var29;
                                                   MessageNode.method750(var38);
                                                }
                                             }
                                          } else if(class79.field1439 == var10 && var19 == Client.field394) {
                                             var27.method1768(var22, var23, 128);
                                          } else {
                                             var27.method1763(var22, var23);
                                          }
                                       } else {
                                          MessageNode.method750(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class33.method717(var10)) {
                              var19 = var10.field2814;
                              if(class113.field1973 == var10 && var10.field2816 != 0) {
                                 var19 = var10.field2816;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class113.field1973 && var10.field2853 != 0) {
                                 var19 = var10.field2853;
                              }
                           }

                           if(var10.field2831) {
                              switch(var10.field2818.field1484) {
                              case 1:
                                 class82.method1847(var12, var13, var10.width, var10.height, var10.textColor, var10.field2814, 256 - (var10.opacity & 255), 256 - (var10.field2782 & 255));
                                 break;
                              case 2:
                                 class82.method1848(var12, var13, var10.width, var10.height, var10.textColor, var10.field2814, 256 - (var10.opacity & 255), 256 - (var10.field2782 & 255));
                                 break;
                              case 3:
                                 class82.method1890(var12, var13, var10.width, var10.height, var10.textColor, var10.field2814, 256 - (var10.opacity & 255), 256 - (var10.field2782 & 255));
                                 break;
                              case 4:
                                 class82.method1908(var12, var13, var10.width, var10.height, var10.textColor, var10.field2814, 256 - (var10.opacity & 255), 256 - (var10.field2782 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1861(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    class82.method1845(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1852(var12, var13, var10.width, var10.height, var19);
                           } else {
                              class82.method1853(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var52;
                           if(var10.type == 4) {
                              var52 = var10.method3470();
                              if(null == var52) {
                                 if(Widget.field2786) {
                                    MessageNode.method750(var10);
                                 }
                              } else {
                                 String var60 = var10.text;
                                 if(class33.method717(var10)) {
                                    var20 = var10.field2814;
                                    if(class113.field1973 == var10 && var10.field2816 != 0) {
                                       var20 = var10.field2816;
                                    }

                                    if(var10.field2849.length() > 0) {
                                       var60 = var10.field2849;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(class113.field1973 == var10 && var10.field2853 != 0) {
                                       var20 = var10.field2853;
                                    }
                                 }

                                 if(var10.field2787 && var10.item != -1) {
                                    ItemComposition var58 = class45.getItemDefinition(var10.item);
                                    var60 = var58.name;
                                    if(null == var60) {
                                       var60 = "null";
                                    }

                                    if((var58.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var60 = class92.method2126(16748608) + var60 + "</col>" + " " + 'x' + class5.method63(var10.stackSize);
                                    }
                                 }

                                 if(Client.field443 == var10) {
                                    Object var10000 = null;
                                    var60 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2787) {
                                    var60 = class116.method2461(var60, var10);
                                 }

                                 var52.method4125(var60, var12, var13, var10.width, var10.height, var20, var10.field2863?0:-1, var10.field2851, var10.field2829, var10.field2898);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var53;
                              if(!var10.field2787) {
                                 var53 = var10.method3492(class33.method717(var10));
                                 if(null != var53) {
                                    var53.method1763(var12, var13);
                                 } else if(Widget.field2786) {
                                    MessageNode.method750(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var53 = class53.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2846, false);
                                 } else {
                                    var53 = var10.method3492(false);
                                 }

                                 if(null == var53) {
                                    if(Widget.field2786) {
                                       MessageNode.method750(var10);
                                    }
                                 } else {
                                    var20 = var53.field1462;
                                    var21 = var53.field1457;
                                    if(!var10.field2900) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2778 != 0) {
                                          var53.method1775(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2778, var22);
                                       } else if(var14 != 0) {
                                          var53.method1825(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var53.method1763(var12, var13);
                                       } else {
                                          var53.method1765(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class82.method1887(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var42 = 0; var42 < var22; ++var42) {
                                          for(var39 = 0; var39 < var23; ++var39) {
                                             if(var10.field2778 != 0) {
                                                var53.method1775(var20 / 2 + var20 * var42 + var12, var13 + var21 * var39 + var21 / 2, var10.field2778, 4096);
                                             } else if(var14 != 0) {
                                                var53.method1768(var12 + var20 * var42, var13 + var21 * var39, 256 - (var14 & 255));
                                             } else {
                                                var53.method1763(var12 + var20 * var42, var39 * var21 + var13);
                                             }
                                          }
                                       }

                                       class82.method1895(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var36;
                              if(var10.type == 6) {
                                 boolean var44 = class33.method717(var10);
                                 if(var44) {
                                    var20 = var10.field2836;
                                 } else {
                                    var20 = var10.field2835;
                                 }

                                 Model var59 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var36 = class45.getItemDefinition(var10.item);
                                    if(null != var36) {
                                       var36 = var36.method1111(var10.stackSize);
                                       var59 = var36.getModel(1);
                                       if(var59 != null) {
                                          var59.method2377();
                                          var22 = var59.modelHeight / 2;
                                       } else {
                                          MessageNode.method750(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var59 = Client.field305.method3545((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var59 = class34.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var59 = var10.method3448((Sequence)null, -1, var44, class34.localPlayer.composition);
                                    if(null == var59 && Widget.field2786) {
                                       MessageNode.method750(var10);
                                    }
                                 } else {
                                    Sequence var54 = class62.getAnimation(var20);
                                    var59 = var10.method3448(var54, var10.field2910, var44, class34.localPlayer.composition);
                                    if(var59 == null && Widget.field2786) {
                                       MessageNode.method750(var10);
                                    }
                                 }

                                 class94.method2135(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = class94.field1635[var10.rotationX] * var10.field2842 >> 16;
                                 var42 = var10.field2842 * class94.field1646[var10.rotationX] >> 16;
                                 if(var59 != null) {
                                    if(!var10.field2787) {
                                       var59.method2334(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var42);
                                    } else {
                                       var59.method2377();
                                       if(var10.field2845) {
                                          var59.method2320(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2837, var10.field2860 + var23 + var22, var42 + var10.field2860, var10.field2842);
                                       } else {
                                          var59.method2334(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2837, var10.field2860 + var23 + var22, var42 + var10.field2860);
                                       }
                                    }
                                 }

                                 class94.method2162();
                              } else {
                                 if(var10.type == 7) {
                                    var52 = var10.method3470();
                                    if(var52 == null) {
                                       if(Widget.field2786) {
                                          MessageNode.method750(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2800; ++var21) {
                                       for(var22 = 0; var22 < var10.field2799; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var36 = class45.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var36.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = class92.method2126(16748608) + var36.name + "</col>";
                                             } else {
                                                var24 = class92.method2126(16748608) + var36.name + "</col>" + " " + 'x' + class5.method63(var10.itemQuantities[var20]);
                                             }

                                             var39 = var12 + var22 * (var10.field2825 + 115);
                                             var26 = var13 + (var10.field2922 + 12) * var21;
                                             if(var10.field2851 == 0) {
                                                var52.method4096(var24, var39, var26, var10.textColor, var10.field2863?0:-1);
                                             } else if(var10.field2851 == 1) {
                                                var52.method4099(var24, var39 + var10.width / 2, var26, var10.textColor, var10.field2863?0:-1);
                                             } else {
                                                var52.method4098(var24, var39 + var10.width - 1, var26, var10.textColor, var10.field2863?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == DecorativeObject.field1672 && Client.field458 == Client.field403) {
                                    var19 = 0;
                                    var20 = 0;
                                    class227 var43 = class112.field1962;
                                    String var40 = var10.text;

                                    String var51;
                                    for(var40 = class116.method2461(var40, var10); var40.length() > 0; var20 += 1 + var43.field3245) {
                                       var42 = var40.indexOf("<br>");
                                       if(var42 != -1) {
                                          var51 = var40.substring(0, var42);
                                          var40 = var40.substring(var42 + 4);
                                       } else {
                                          var51 = var40;
                                          var40 = "";
                                       }

                                       var39 = var43.method4091(var51);
                                       if(var39 > var19) {
                                          var19 = var39;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var42 = var10.width + var12 - 5 - var19;
                                    var39 = var13 + var10.height + 5;
                                    if(var42 < var12 + 5) {
                                       var42 = 5 + var12;
                                    }

                                    if(var19 + var42 > var4) {
                                       var42 = var4 - var19;
                                    }

                                    if(var39 + var20 > var5) {
                                       var39 = var5 - var20;
                                    }

                                    class82.method1861(var42, var39, var19, var20, 16777120);
                                    class82.method1852(var42, var39, var19, var20, 0);
                                    var40 = var10.text;
                                    var26 = 2 + var39 + var43.field3245;

                                    for(var40 = class116.method2461(var40, var10); var40.length() > 0; var26 += var43.field3245 + 1) {
                                       var41 = var40.indexOf("<br>");
                                       if(var41 != -1) {
                                          var51 = var40.substring(0, var41);
                                          var40 = var40.substring(4 + var41);
                                       } else {
                                          var51 = var40;
                                          var40 = "";
                                       }

                                       var43.method4096(var51, 3 + var42, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2821 == 1) {
                                       if(var10.field2822) {
                                          var19 = var12;
                                          var20 = var10.height + var13;
                                          var21 = var10.width + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.width;
                                          var22 = var13 + var10.height;
                                       }

                                       class82.method1858(var19, var20, var21, var22, var10.textColor);
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

                                          var42 = var10.field2821 * var23 >> 17;
                                          var39 = var23 * var10.field2821 + 1 >> 17;
                                          var26 = var10.field2821 * var22 >> 17;
                                          var41 = 1 + var22 * var10.field2821 >> 17;
                                          var28 = var42 + var12;
                                          var29 = var12 - var39;
                                          var30 = var10.width + var12 - var39;
                                          var31 = var10.width + var12 + var42;
                                          var32 = var13 + var26;
                                          int var33 = var13 - var41;
                                          int var34 = var10.height + var13 - var41;
                                          int var35 = var10.height + var13 + var26;
                                          class94.setRasterClippingEnabled(var28, var29, var30);
                                          class94.rasterFlat(var32, var33, var34, var28, var29, var30, var10.textColor);
                                          class94.setRasterClippingEnabled(var28, var30, var31);
                                          class94.rasterFlat(var32, var34, var35, var28, var30, var31, var10.textColor);
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
      signature = "(Lclass125;B)V",
      garbageValue = "40"
   )
   static final void method680(class125 var0) {
      int var1 = 0;
      var0.method2770();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class34.field763; ++var2) {
         var3 = class34.field758[var2];
         if((class34.field759[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class34.field759[var3] = (byte)(class34.field759[var3] | 2);
            } else {
               var4 = var0.method2771(1);
               if(var4 == 0) {
                  var1 = class21.method576(var0);
                  class34.field759[var3] = (byte)(class34.field759[var3] | 2);
               } else {
                  TextureProvider.method2218(var0, var3);
               }
            }
         }
      }

      var0.method2778();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2770();

         for(var2 = 0; var2 < class34.field763; ++var2) {
            var3 = class34.field758[var2];
            if((class34.field759[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class34.field759[var3] = (byte)(class34.field759[var3] | 2);
               } else {
                  var4 = var0.method2771(1);
                  if(var4 == 0) {
                     var1 = class21.method576(var0);
                     class34.field759[var3] = (byte)(class34.field759[var3] | 2);
                  } else {
                     TextureProvider.method2218(var0, var3);
                  }
               }
            }
         }

         var0.method2778();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2770();

            for(var2 = 0; var2 < class34.field764; ++var2) {
               var3 = class34.field765[var2];
               if((class34.field759[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class34.field759[var3] = (byte)(class34.field759[var3] | 2);
                  } else {
                     var4 = var0.method2771(1);
                     if(var4 == 0) {
                        var1 = class21.method576(var0);
                        class34.field759[var3] = (byte)(class34.field759[var3] | 2);
                     } else if(WidgetNode.method45(var0, var3)) {
                        class34.field759[var3] = (byte)(class34.field759[var3] | 2);
                     }
                  }
               }
            }

            var0.method2778();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2770();

               for(var2 = 0; var2 < class34.field764; ++var2) {
                  var3 = class34.field765[var2];
                  if((class34.field759[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class34.field759[var3] = (byte)(class34.field759[var3] | 2);
                     } else {
                        var4 = var0.method2771(1);
                        if(var4 == 0) {
                           var1 = class21.method576(var0);
                           class34.field759[var3] = (byte)(class34.field759[var3] | 2);
                        } else if(WidgetNode.method45(var0, var3)) {
                           class34.field759[var3] = (byte)(class34.field759[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2778();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class34.field763 = 0;
                  class34.field764 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class34.field759[var2] = (byte)(class34.field759[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class34.field758[++class34.field763 - 1] = var2;
                     } else {
                        class34.field765[++class34.field764 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1423763083"
   )
   public static String method681(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = VertexNormal.method2230(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1895006603"
   )
   final void method682(int var1) {
      if(!this.field703) {
         this.field694 += var1;

         while(this.field694 > this.field700.field994[this.field701]) {
            this.field694 -= this.field700.field994[this.field701];
            ++this.field701;
            if(this.field701 >= this.field700.field992.length) {
               this.field703 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "891231985"
   )
   static void method683(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class175 var4 = (class175)class174.field2756.method3849(var2);
      if(null != var4) {
         class174.field2758.method3955(var4);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1130234904"
   )
   public static int method684(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class56.method1169(var0.charAt(var3));
      }

      return var2;
   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field696 = var1;
      this.field706 = var2;
      this.field695 = var3;
      this.field698 = var4;
      this.field699 = var5;
      this.field702 = var7 + var6;
      int var8 = GameEngine.method3084(this.field696).field1023;
      if(var8 != -1) {
         this.field703 = false;
         this.field700 = class62.getAnimation(var8);
      } else {
         this.field703 = true;
      }

   }
}
