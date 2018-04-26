import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   public static final FontName field3885;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   public static final FontName field3886;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   public static final FontName field3882;
   @ObfuscatedName("s")
   final String field3888;
   @ObfuscatedName("y")
   String field3889;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3885 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3886 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3882 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3888 = var1;
      this.field3889 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "16912274"
   )
   static int method5547(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
         ChatPlayer.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class171.intStackSize -= 2;
         class163.method3290(class265.localPlayer, class81.intStack[class171.intStackSize], class81.intStack[class171.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         Signlink.method3323();
         return 1;
      } else {
         int var15;
         PacketNode var17;
         if(var0 == 3104) {
            var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
            var15 = 0;
            boolean var16 = ClanMemberManager.method5518(var3, 10, true);
            if(var16) {
               var15 = Item.method2020(var3);
            }

            var17 = AbstractSoundSystem.method2350(ClientPacket.field2396, Client.field911.field1460);
            var17.packetBuffer.putInt(var15);
            Client.field911.method2135(var17);
            return 1;
         } else {
            PacketNode var19;
            if(var0 == 3105) {
               var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
               var19 = AbstractSoundSystem.method2350(ClientPacket.field2411, Client.field911.field1460);
               var19.packetBuffer.putByte(var3.length() + 1);
               var19.packetBuffer.putString(var3);
               Client.field911.method2135(var19);
               return 1;
            } else if(var0 == 3106) {
               var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
               var19 = AbstractSoundSystem.method2350(ClientPacket.field2379, Client.field911.field1460);
               var19.packetBuffer.putByte(var3.length() + 1);
               var19.packetBuffer.putString(var3);
               Client.field911.method2135(var19);
               return 1;
            } else {
               int var5;
               String var12;
               int var13;
               if(var0 != 3107) {
                  if(var0 == 3108) {
                     class171.intStackSize -= 3;
                     var13 = class81.intStack[class171.intStackSize];
                     var15 = class81.intStack[class171.intStackSize + 1];
                     var5 = class81.intStack[class171.intStackSize + 2];
                     Widget var18 = UnitPriceComparator.getWidget(var5);
                     PacketBuffer.method3863(var18, var13, var15);
                     return 1;
                  } else if(var0 == 3109) {
                     class171.intStackSize -= 2;
                     var13 = class81.intStack[class171.intStackSize];
                     var15 = class81.intStack[class171.intStackSize + 1];
                     Widget var20 = var2?class49.field604:class81.field1270;
                     PacketBuffer.method3863(var20, var13, var15);
                     return 1;
                  } else if(var0 == 3110) {
                     Occluder.middleMouseMovesCamera = class81.intStack[--class171.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3111) {
                     class81.intStack[++class171.intStackSize - 1] = Client.preferences.hideRoofs?1:0;
                     return 1;
                  } else if(var0 == 3112) {
                     Client.preferences.hideRoofs = class81.intStack[--class171.intStackSize] == 1;
                     Widget.method4541();
                     return 1;
                  } else if(var0 == 3113) {
                     var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                     boolean var4 = class81.intStack[--class171.intStackSize] == 1;
                     RunException.method3308(var3, var4, false);
                     return 1;
                  } else if(var0 == 3115) {
                     var13 = class81.intStack[--class171.intStackSize];
                     var19 = AbstractSoundSystem.method2350(ClientPacket.field2407, Client.field911.field1460);
                     var19.packetBuffer.putShort(var13);
                     Client.field911.method2135(var19);
                     return 1;
                  } else if(var0 == 3116) {
                     var13 = class81.intStack[--class171.intStackSize];
                     class81.scriptStringStackSize -= 2;
                     var12 = class81.scriptStringStack[class81.scriptStringStackSize];
                     String var14 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
                     if(var12.length() > 500) {
                        return 1;
                     } else if(var14.length() > 500) {
                        return 1;
                     } else {
                        var17 = AbstractSoundSystem.method2350(ClientPacket.field2416, Client.field911.field1460);
                        var17.packetBuffer.putShort(1 + class95.getLength(var12) + class95.getLength(var14));
                        var17.packetBuffer.putString(var12);
                        var17.packetBuffer.method3624(var13);
                        var17.packetBuffer.putString(var14);
                        Client.field911.method2135(var17);
                        return 1;
                     }
                  } else if(var0 == 3117) {
                     Client.field1079 = class81.intStack[--class171.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3118) {
                     Client.field1112 = class81.intStack[--class171.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3119) {
                     Client.field928 = class81.intStack[--class171.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3120) {
                     if(class81.intStack[--class171.intStackSize] == 1) {
                        Client.playerNameMask |= 1;
                     } else {
                        Client.playerNameMask &= -2;
                     }

                     return 1;
                  } else if(var0 == 3121) {
                     if(class81.intStack[--class171.intStackSize] == 1) {
                        Client.playerNameMask |= 2;
                     } else {
                        Client.playerNameMask &= -3;
                     }

                     return 1;
                  } else if(var0 == 3122) {
                     if(class81.intStack[--class171.intStackSize] == 1) {
                        Client.playerNameMask |= 4;
                     } else {
                        Client.playerNameMask &= -5;
                     }

                     return 1;
                  } else if(var0 == 3123) {
                     if(class81.intStack[--class171.intStackSize] == 1) {
                        Client.playerNameMask |= 8;
                     } else {
                        Client.playerNameMask &= -9;
                     }

                     return 1;
                  } else if(var0 == 3124) {
                     Client.playerNameMask = 0;
                     return 1;
                  } else if(var0 == 3125) {
                     Client.field997 = class81.intStack[--class171.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3126) {
                     Client.field964 = class81.intStack[--class171.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3127) {
                     TotalQuantityComparator.method102(class81.intStack[--class171.intStackSize] == 1);
                     return 1;
                  } else if(var0 == 3128) {
                     class81.intStack[++class171.intStackSize - 1] = SoundTaskDataProvider.method830()?1:0;
                     return 1;
                  } else if(var0 == 3129) {
                     class171.intStackSize -= 2;
                     Client.field931 = class81.intStack[class171.intStackSize];
                     Client.field858 = class81.intStack[class171.intStackSize + 1];
                     return 1;
                  } else if(var0 == 3130) {
                     class171.intStackSize -= 2;
                     return 1;
                  } else if(var0 == 3131) {
                     --class171.intStackSize;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var13 = class81.intStack[--class171.intStackSize];
                  var12 = class81.scriptStringStack[--class81.scriptStringStackSize];
                  var5 = class93.playerIndexesCount;
                  int[] var6 = class93.playerIndices;
                  boolean var7 = false;
                  Name var8 = new Name(var12, DecorativeObject.loginType);

                  for(int var9 = 0; var9 < var5; ++var9) {
                     Player var10 = Client.cachedPlayers[var6[var9]];
                     if(var10 != null && var10 != class265.localPlayer && var10.name != null && var10.name.equals(var8)) {
                        PacketNode var11;
                        if(var13 == 1) {
                           var11 = AbstractSoundSystem.method2350(ClientPacket.field2429, Client.field911.field1460);
                           var11.packetBuffer.putShort(var6[var9]);
                           var11.packetBuffer.method3670(0);
                           Client.field911.method2135(var11);
                        } else if(var13 == 4) {
                           var11 = AbstractSoundSystem.method2350(ClientPacket.field2381, Client.field911.field1460);
                           var11.packetBuffer.method3670(0);
                           var11.packetBuffer.method3633(var6[var9]);
                           Client.field911.method2135(var11);
                        } else if(var13 == 6) {
                           var11 = AbstractSoundSystem.method2350(ClientPacket.field2375, Client.field911.field1460);
                           var11.packetBuffer.putShort(var6[var9]);
                           var11.packetBuffer.method3624(0);
                           Client.field911.method2135(var11);
                        } else if(var13 == 7) {
                           var11 = AbstractSoundSystem.method2350(ClientPacket.field2421, Client.field911.field1460);
                           var11.packetBuffer.method3716(0);
                           var11.packetBuffer.method3632(var6[var9]);
                           Client.field911.method2135(var11);
                        }

                        var7 = true;
                        break;
                     }
                  }

                  if(!var7) {
                     ChatPlayer.sendGameMessage(4, "", "Unable to find " + var12);
                  }

                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1479863102"
   )
   static void method5545() {
      if(Client.spellSelected) {
         Widget var0 = class44.getWidgetChild(BoundingBox3D.field261, Client.field1008);
         if(var0 != null && var0.onTargetLeaveListener != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.onTargetLeaveListener;
            class71.method1203(var1);
         }

         Client.spellSelected = false;
         TotalQuantityComparator.method100(var0);
      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "([Liz;IIIIIIIIB)V",
      garbageValue = "113"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.draggedWidget)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.widgetCount] = var10.relativeX + var6;
               Client.widgetPositionY[Client.widgetCount] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.widgetCount] = var10.width;
               Client.widgetBoundsHeight[Client.widgetCount] = var10.height;
               var11 = ++Client.widgetCount - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !MapIconReference.method762(var10)) {
               if(var10.contentType > 0) {
                  class88.method1969(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.draggedWidget) {
                  if(var1 != -1412584499 && !var10.dragRenderBehavior) {
                     GameSocket.field2246 = var0;
                     class36.field496 = var6;
                     class308.field3880 = var7;
                     continue;
                  }

                  if(Client.draggingWidget && Client.field1028) {
                     var15 = MouseInput.mouseLastX;
                     var16 = MouseInput.mouseLastY;
                     var15 -= Client.field1025;
                     var16 -= Client.field892;
                     if(var15 < Client.field1029) {
                        var15 = Client.field1029;
                     }

                     if(var15 + var10.width > Client.field1029 + Client.field1024.width) {
                        var15 = Client.field1029 + Client.field1024.width - var10.width;
                     }

                     if(var16 < Client.field954) {
                        var16 = Client.field954;
                     }

                     if(var16 + var10.height > Client.field954 + Client.field1024.height) {
                        var16 = Client.field954 + Client.field1024.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.dragRenderBehavior) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var46;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var46 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var46 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var46 > var2?var46:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var46 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var46 < var4?var46:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var23;
                  int var25;
                  int var26;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var47;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class249.font_p12full.method5562("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var56 = Runtime.getRuntime();
                           var20 = (int)((var56.totalMemory() - var56.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 327680 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class249.font_p12full.method5562("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1000 = var12;
                        Client.field1001 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field1093;
                        class95.method2095();
                        if(Client.field928) {
                           class36.method541(class265.localPlayer, false);
                        }

                        WorldMapDecoration.method278();
                        TotalQuantityComparator.method107(true);
                        var23 = class93.playerIndexesCount;
                        int[] var58 = class93.playerIndices;

                        for(var25 = 0; var25 < var23; ++var25) {
                           if(var58[var25] != Client.field978 && var58[var25] != Client.localInteractingIndex) {
                              class36.method541(Client.cachedPlayers[var58[var25]], true);
                           }
                        }

                        TotalQuantityComparator.method107(false);
                        class25.method189();
                        class55.method847();
                        class1.method2(var12, var13, var21, var22, true);
                        var46 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportWidth;
                        var22 = Client.viewportHeight;
                        Rasterizer2D.setDrawRegion(var46, var20, var46 + var21, var22 + var20);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field1094) {
                           var23 = Client.cameraPitchTarget;
                           if(Client.field937 / 256 > var23) {
                              var23 = Client.field937 / 256;
                           }

                           if(Client.field860[4] && Client.field966[4] + 128 > var23) {
                              var23 = Client.field966[4] + 128;
                           }

                           var47 = Client.mapAngle & 2047;
                           OwnWorldComparator.method1260(Size.field367, AttackOption.field1333, class236.field2783, var23, var47, var23 * 3 + 600);
                        }

                        if(!Client.field1094) {
                           var23 = class255.method4626();
                        } else {
                           if(Client.preferences.hideRoofs) {
                              var47 = ScriptVarType.plane;
                           } else {
                              var25 = GrandExchangeEvent.getTileHeight(UrlRequest.cameraX, Signlink.cameraY, ScriptVarType.plane);
                              if(var25 - class86.cameraZ < 800 && (class62.tileSettings[ScriptVarType.plane][UrlRequest.cameraX >> 7][Signlink.cameraY >> 7] & 4) != 0) {
                                 var47 = ScriptVarType.plane;
                              } else {
                                 var47 = 3;
                              }
                           }

                           var23 = var47;
                        }

                        var47 = UrlRequest.cameraX;
                        var25 = class86.cameraZ;
                        var26 = Signlink.cameraY;
                        var27 = class18.cameraPitch;
                        var28 = class33.cameraYaw;

                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field860[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field1043[var29] * 2 + 1) - (double)Client.field1043[var29] + Math.sin((double)Client.field1099[var29] * ((double)Client.field991[var29] / 100.0D)) * (double)Client.field966[var29]);
                              if(var29 == 0) {
                                 UrlRequest.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 class86.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 Signlink.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 class33.cameraYaw = var30 + class33.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 class18.cameraPitch += var30;
                                 if(class18.cameraPitch < 128) {
                                    class18.cameraPitch = 128;
                                 }

                                 if(class18.cameraPitch > 383) {
                                    class18.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var29 = MouseInput.mouseLastX;
                        var30 = MouseInput.mouseLastY;
                        if(MouseInput.mouseLastButton != 0) {
                           var29 = MouseInput.mouseLastPressedX;
                           var30 = MouseInput.mouseLastPressedY;
                        }

                        if(var29 >= var46 && var29 < var46 + var21 && var30 >= var20 && var30 < var22 + var20) {
                           class191.method3569(var29 - var46, var30 - var20);
                        } else {
                           class62.method1117();
                        }

                        class36.method545();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var46, var20, var21, var22, 0);
                        class36.method545();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        GameSocket.region.drawRegion(UrlRequest.cameraX, class86.cameraZ, Signlink.cameraY, class18.cameraPitch, class33.cameraYaw, var23);
                        PendingSpawn.method1701();
                        Graphics3D.Rasterizer3D_zoom = var31;
                        class36.method545();
                        GameSocket.region.clearEntities();
                        TotalQuantityComparator.method105(var46, var20, var21, var22);
                        class3.method7(var46, var20);
                        ((TextureProvider)Graphics3D.textureLoader).checkTextures(Client.field913);
                        FaceNormal.method3143(var46, var20, var21, var22);
                        UrlRequest.cameraX = var47;
                        class86.cameraZ = var25;
                        Signlink.cameraY = var26;
                        class18.cameraPitch = var27;
                        class33.cameraYaw = var28;
                        if(Client.field995 && CollisionData.method3491(true, false) == 0) {
                           Client.field995 = false;
                        }

                        if(Client.field995) {
                           Rasterizer2D.Rasterizer2D_fillRectangle(var46, var20, var21, var22, 0);
                           class5.method16("Loading - please wait.", false);
                        }

                        Client.field1055[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class18.method151(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class236 var55 = var10.method4542(false);
                        if(var55 != null) {
                           if(Client.field1082 < 3) {
                              WorldMapManager.compass.method5932(var12, var13, var55.field2780, var55.field2782, 25, 25, Client.mapAngle, 256, var55.field2779, var55.field2781);
                           } else {
                              Rasterizer2D.method5818(var12, var13, 0, var55.field2779, var55.field2781);
                           }
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class196.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class196.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && MapIconReference.method762(var10) && var10 != GameCanvas.field642) {
                        continue;
                     }

                     if(!var10.hasScript) {
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

                     WidgetNode var19 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var19 != null) {
                        class276.method4980(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field1101[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class163.method3303(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var46 = 0;

                           for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var21 * (var10.paddingX + 32) + var12;
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var46 < 20) {
                                    var22 += var10.xSprites[var46];
                                    var23 += var10.field2890[var46];
                                 }

                                 if(var10.itemIds[var46] <= 0) {
                                    if(var10.field2819 != null && var46 < 20) {
                                       SpritePixels var57 = var10.method4575(var46);
                                       if(var57 != null) {
                                          var57.drawAt(var22, var23);
                                       } else if(Widget.field2934) {
                                          TotalQuantityComparator.method100(var10);
                                       }
                                    }
                                 } else {
                                    boolean var62 = false;
                                    boolean var59 = false;
                                    var26 = var10.itemIds[var46] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == KeyFocusListener.field635 && var46 == Client.field959) {
                                       SpritePixels var51;
                                       if(Client.itemSelectionState == 1 && var46 == class243.selectedItemIndex && var10.id == Client.field1005) {
                                          var51 = class2.createSprite(var26, var10.itemQuantities[var46], 2, 0, 2, false);
                                       } else {
                                          var51 = class2.createSprite(var26, var10.itemQuantities[var46], 1, 3153952, 2, false);
                                       }

                                       if(var51 != null) {
                                          if(var10 == KeyFocusListener.field635 && var46 == Client.field959) {
                                             var47 = MouseInput.mouseLastX - Client.field960;
                                             var25 = MouseInput.mouseLastY - Client.field961;
                                             if(var47 < 5 && var47 > -5) {
                                                var47 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.itemPressedDuration < 5) {
                                                var47 = 0;
                                                var25 = 0;
                                             }

                                             var51.drawAtOpacity(var47 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var52 = var0[var1 & 65535];
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var52.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field913 / 3;
                                                   if(var29 > Client.field913 * 10) {
                                                      var29 = Client.field913 * 10;
                                                   }

                                                   if(var29 > var52.scrollY) {
                                                      var29 = var52.scrollY;
                                                   }

                                                   var52.scrollY -= var29;
                                                   Client.field961 += var29;
                                                   TotalQuantityComparator.method100(var52);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var52.scrollY < var52.scrollHeight - var52.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field913 / 3;
                                                   if(var29 > Client.field913 * 10) {
                                                      var29 = Client.field913 * 10;
                                                   }

                                                   if(var29 > var52.scrollHeight - var52.height - var52.scrollY) {
                                                      var29 = var52.scrollHeight - var52.height - var52.scrollY;
                                                   }

                                                   var52.scrollY += var29;
                                                   Client.field961 -= var29;
                                                   TotalQuantityComparator.method100(var52);
                                                }
                                             }
                                          } else if(var10 == BoundingBox2D.field241 && var46 == Client.pressedItemIndex) {
                                             var51.drawAtOpacity(var22, var23, 128);
                                          } else {
                                             var51.drawAt(var22, var23);
                                          }
                                       } else {
                                          TotalQuantityComparator.method100(var10);
                                       }
                                    }
                                 }

                                 ++var46;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(UrlRequest.method3182(var10)) {
                              var46 = var10.field2847;
                              if(var10 == GameCanvas.field642 && var10.field2849 != 0) {
                                 var46 = var10.field2849;
                              }
                           } else {
                              var46 = var10.textColor;
                              if(var10 == GameCanvas.field642 && var10.field2841 != 0) {
                                 var46 = var10.field2841;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2854.field3975) {
                              case 1:
                                 Rasterizer2D.method5807(var12, var13, var10.width, var10.height, var10.textColor, var10.field2847, 256 - (var10.opacity & 255), 256 - (var10.field2853 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5856(var12, var13, var10.width, var10.height, var10.textColor, var10.field2847, 256 - (var10.opacity & 255), 256 - (var10.field2853 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5806(var12, var13, var10.width, var10.height, var10.textColor, var10.field2847, 256 - (var10.opacity & 255), 256 - (var10.field2853 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5836(var12, var13, var10.width, var10.height, var10.textColor, var10.field2847, 256 - (var10.opacity & 255), 256 - (var10.field2853 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var46);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var46);
                           } else {
                              Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                           }
                        } else {
                           Font var53;
                           if(var10.type == 4) {
                              var53 = var10.getFont();
                              if(var53 == null) {
                                 if(Widget.field2934) {
                                    TotalQuantityComparator.method100(var10);
                                 }
                              } else {
                                 String var64 = var10.text;
                                 if(UrlRequest.method3182(var10)) {
                                    var20 = var10.field2847;
                                    if(var10 == GameCanvas.field642 && var10.field2849 != 0) {
                                       var20 = var10.field2849;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var64 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == GameCanvas.field642 && var10.field2841 != 0) {
                                       var20 = var10.field2841;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var65 = NetWriter.getItemDefinition(var10.itemId);
                                    var64 = var65.name;
                                    if(var64 == null) {
                                       var64 = "null";
                                    }

                                    if((var65.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var64 = DynamicObject.getColTags(16748608) + var64 + "</col>" + " " + 'x' + class291.method5269(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1017) {
                                    var64 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var64 = class1.method3(var64, var10);
                                 }

                                 var53.method5574(var64, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2870, var10.field2947, var10.field2883);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var54;
                              if(!var10.hasScript) {
                                 var54 = var10.method4539(UrlRequest.method3182(var10));
                                 if(var54 != null) {
                                    var54.drawAt(var12, var13);
                                 } else if(Widget.field2934) {
                                    TotalQuantityComparator.method100(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var54 = class2.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2879, false);
                                 } else {
                                    var54 = var10.method4539(false);
                                 }

                                 if(var54 == null) {
                                    if(Widget.field2934) {
                                       TotalQuantityComparator.method100(var10);
                                    }
                                 } else {
                                    var20 = var54.maxWidth;
                                    var21 = var54.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var54.method6004(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var54.method5923(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var54.drawAt(var12, var13);
                                       } else {
                                          var54.method5987(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var47 = 0; var47 < var22; ++var47) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var54.method6004(var20 / 2 + var12 + var20 * var47, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var54.drawAtOpacity(var12 + var20 * var47, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var54.drawAt(var12 + var47 * var20, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var50;
                              if(var10.type == 6) {
                                 boolean var61 = UrlRequest.method3182(var10);
                                 if(var61) {
                                    var20 = var10.field2869;
                                 } else {
                                    var20 = var10.field2868;
                                 }

                                 Model var60 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var50 = NetWriter.getItemDefinition(var10.itemId);
                                    if(var50 != null) {
                                       var50 = var50.method5135(var10.itemQuantity);
                                       var60 = var50.getModel(1);
                                       if(var60 != null) {
                                          var60.calculateBoundsCylinder();
                                          var22 = var60.modelHeight / 2;
                                       } else {
                                          TotalQuantityComparator.method100(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var60 = Client.field1113.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var60 = class265.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var60 = var10.getModel((Sequence)null, -1, var61, class265.localPlayer.composition);
                                    if(var60 == null && Widget.field2934) {
                                       TotalQuantityComparator.method100(var10);
                                    }
                                 } else {
                                    Sequence var66 = NPC.getAnimation(var20);
                                    var60 = var10.getModel(var66, var10.field2943, var61, class265.localPlayer.composition);
                                    if(var60 == null && Widget.field2934) {
                                       TotalQuantityComparator.method100(var10);
                                    }
                                 }

                                 Graphics3D.method2880(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var47 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var60 != null) {
                                    if(!var10.hasScript) {
                                       var60.method2781(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var47);
                                    } else {
                                       var60.calculateBoundsCylinder();
                                       if(var10.field2878) {
                                          var60.method2831(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var22 + var23 + var10.offsetY2d, var47 + var10.offsetY2d, var10.modelZoom);
                                       } else {
                                          var60.method2781(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var22 + var23 + var10.offsetY2d, var47 + var10.offsetY2d);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var53 = var10.getFont();
                                    if(var53 == null) {
                                       if(Widget.field2934) {
                                          TotalQuantityComparator.method100(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var50 = NetWriter.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var50.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = DynamicObject.getColTags(16748608) + var50.name + "</col>";
                                             } else {
                                                var24 = DynamicObject.getColTags(16748608) + var50.name + "</col>" + " " + 'x' + class291.method5269(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = var21 * (var10.paddingY + 12) + var13;
                                             if(var10.field2870 == 0) {
                                                var53.method5630(var24, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2870 == 1) {
                                                var53.drawTextCentered(var24, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var53.method5562(var24, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == FrameMap.field1950 && Client.field915 == Client.field1072) {
                                    var46 = 0;
                                    var20 = 0;
                                    Font var48 = class249.font_p12full;
                                    String var49 = var10.text;

                                    String var63;
                                    for(var49 = class1.method3(var49, var10); var49.length() > 0; var20 = var20 + var48.verticalSpace + 1) {
                                       var47 = var49.indexOf("<br>");
                                       if(var47 != -1) {
                                          var63 = var49.substring(0, var47);
                                          var49 = var49.substring(var47 + 4);
                                       } else {
                                          var63 = var49;
                                          var49 = "";
                                       }

                                       var25 = var48.getTextWidth(var63);
                                       if(var25 > var46) {
                                          var46 = var25;
                                       }
                                    }

                                    var46 += 6;
                                    var20 += 7;
                                    var47 = var12 + var10.width - 5 - var46;
                                    var25 = var13 + var10.height + 5;
                                    if(var47 < var12 + 5) {
                                       var47 = var12 + 5;
                                    }

                                    if(var47 + var46 > var4) {
                                       var47 = var4 - var46;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var47, var25, var46, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var47, var25, var46, var20, 0);
                                    var49 = var10.text;
                                    var26 = var25 + var48.verticalSpace + 2;

                                    for(var49 = class1.method3(var49, var10); var49.length() > 0; var26 = var26 + var48.verticalSpace + 1) {
                                       var27 = var49.indexOf("<br>");
                                       if(var27 != -1) {
                                          var63 = var49.substring(0, var27);
                                          var49 = var49.substring(var27 + 4);
                                       } else {
                                          var63 = var49;
                                          var49 = "";
                                       }

                                       var48.method5630(var63, var47 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2830) {
                                       var46 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var46 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.lineWidth == 1) {
                                       Rasterizer2D.drawLine(var46, var20, var21, var22, var10.textColor);
                                    } else {
                                       var25 = var10.textColor;
                                       var26 = var10.lineWidth;
                                       var27 = var21 - var46;
                                       var28 = var22 - var20;
                                       var29 = var27 >= 0?var27:-var27;
                                       var30 = var28 >= 0?var28:-var28;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          int var32 = (var27 << 16) / var31;
                                          int var33 = (var28 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          int var34 = var33 * var26 >> 17;
                                          int var35 = var33 * var26 + 1 >> 17;
                                          int var36 = var26 * var32 >> 17;
                                          int var37 = var32 * var26 + 1 >> 17;
                                          var23 = var46 - Rasterizer2D.draw_region_x;
                                          var47 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var38 = var34 + var23;
                                          int var39 = var23 - var35;
                                          int var40 = var23 + var27 - var35;
                                          int var41 = var34 + var27 + var23;
                                          int var42 = var47 + var36;
                                          int var43 = var47 - var37;
                                          int var44 = var28 + var47 - var37;
                                          int var45 = var47 + var28 + var36;
                                          Graphics3D.setRasterClippingEnabled(var38, var39, var40);
                                          Graphics3D.rasterFlat(var42, var43, var44, var38, var39, var40, var25);
                                          Graphics3D.setRasterClippingEnabled(var38, var40, var41);
                                          Graphics3D.rasterFlat(var42, var44, var45, var38, var40, var41, var25);
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
}
