import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -215634617
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1565585389
   )
   int field2435;
   @ObfuscatedName("m")
   @Export("mm")
   int[] mm;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1584457303
   )
   int field2438;
   @ObfuscatedName("f")
   @Export("randResult")
   int[] randResult;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 877136013
   )
   int field2440;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 945640097
   )
   public static int field2442;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1943149585
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "128"
   )
   @Export("nextInt")
   final int nextInt() {
      if(--this.valuesRemaining + 1 == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   ISAACCipher(int[] var1) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3416();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   final void method3416() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.randResult[var1];
         var3 += this.randResult[var1 + 1];
         var4 += this.randResult[var1 + 2];
         var5 += this.randResult[var1 + 3];
         var6 += this.randResult[var1 + 4];
         var7 += this.randResult[var1 + 5];
         var8 += this.randResult[var1 + 6];
         var9 += this.randResult[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[var1 + 1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[var1 + 3];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[var1 + 5];
         var8 += this.mm[var1 + 6];
         var9 += this.mm[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-464063705"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2435 += ++this.field2440;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2438 ^= this.field2438 << 13;
            } else {
               this.field2438 ^= this.field2438 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2438 ^= this.field2438 << 2;
         } else {
            this.field2438 ^= this.field2438 >>> 16;
         }

         this.field2438 += this.mm[var1 + 128 & 255];
         int var3;
         this.mm[var1] = var3 = this.field2438 + this.mm[(var2 & 1020) >> 2] + this.field2435;
         this.randResult[var1] = this.field2435 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-2096139608"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4961(var2, var3, var4, var5);
      class136.method2594();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && Client.field1089 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1119] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field1119] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field1119] = var10.width;
               Client.widgetBoundsHeight[Client.field1119] = var10.height;
               var11 = ++Client.field1119 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2701 = Client.gameCycle;
            if(!var10.hasScript || !Ignore.method1079(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field1189 == -1) {
                        Client.field1189 = var10.spriteId;
                        Client.field1181 = var10.field2688;
                     }

                     if(Client.field1188.isFemale) {
                        var10.spriteId = Client.field1189;
                     } else {
                        var10.spriteId = Client.field1181;
                     }
                  } else if(var12 == 325) {
                     if(Client.field1189 == -1) {
                        Client.field1189 = var10.spriteId;
                        Client.field1181 = var10.field2688;
                     }

                     if(Client.field1188.isFemale) {
                        var10.spriteId = Client.field1181;
                     } else {
                        var10.spriteId = Client.field1189;
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

               var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field1089 == var10) {
                  if(var1 != -1412584499 && !var10.field2730) {
                     GraphicsObject.field1366 = var0;
                     class163.field2323 = var6;
                     class45.field583 = var7;
                     continue;
                  }

                  if(Client.field1100 && Client.field927) {
                     var15 = class59.field729;
                     var16 = class59.field715;
                     var15 -= Client.field1091;
                     var16 -= Client.field1092;
                     if(var15 < Client.field1095) {
                        var15 = Client.field1095;
                     }

                     if(var15 + var10.width > Client.field973.width + Client.field1095) {
                        var15 = Client.field1095 + Client.field973.width - var10.width;
                     }

                     if(var16 < Client.field1096) {
                        var16 = Client.field1096;
                     }

                     if(var10.height + var16 > Client.field1096 + Client.field973.height) {
                        var16 = Client.field1096 + Client.field973.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2730) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var22;
               int var52;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var52 = var10.width + var12;
                  var22 = var10.height + var13;
                  if(var52 < var12) {
                     var19 = var52;
                     var52 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var52;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var52 < var4?var52:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.width + var12;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var26;
                  int var27;
                  int var31;
                  int var47;
                  int var51;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field928) {
                           var13 += 15;
                           WidgetNode.font_p12full.method4809("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var72 = Runtime.getRuntime();
                           var20 = (int)((var72.totalMemory() - var72.freeMemory()) / 1024L);
                           var52 = 16776960;
                           if(var20 > '耀' && Client.field918) {
                              var52 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field918) {
                              var52 = 16711680;
                           }

                           WidgetNode.font_p12full.method4809("Mem:" + var20 + "k", var10.width + var12, var13, var52, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1064 = var12;
                        Client.field1060 = var13;
                        class266.method4878(var12, var13, var10.width, var10.height);
                        Client.field1121[var10.boundsIndex] = true;
                        Rasterizer2D.method4961(var2, var3, var4, var5);
                        continue;
                     }

                     class210 var71;
                     if(var10.contentType == 1338) {
                        class24.method202();
                        var71 = var10.method4053(false);
                        if(var71 != null) {
                           Rasterizer2D.method4961(var12, var13, var12 + var71.field2610, var71.field2605 + var13);
                           if(Client.field1016 != 2 && Client.field1016 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var52 = class168.localPlayer.x / 32 + 48;
                              var22 = 464 - class168.localPlayer.y / 32;
                              TextureProvider.field1787.method5108(var12, var13, var71.field2610, var71.field2605, var52, var22, var20, Client.mapScaleDelta + 256, var71.field2607, var71.field2606);

                              for(var23 = 0; var23 < Client.field1145; ++var23) {
                                 var24 = Client.field1114[var23] * 4 + 2 - class168.localPlayer.x / 32;
                                 var47 = Client.field1065[var23] * 4 + 2 - class168.localPlayer.y / 32;
                                 XGrandExchangeOffer.method135(var12, var13, var24, var47, Client.field1148[var23], var71);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field952; ++var23) {
                                       NPC var69 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var69 != null && var69.vmethod1669()) {
                                          NPCComposition var58 = var69.composition;
                                          if(var58 != null && var58.configs != null) {
                                             var58 = var58.method4685();
                                          }

                                          if(var58 != null && var58.isMinimapVisible && var58.field3591) {
                                             var26 = var69.x / 32 - class168.localPlayer.x / 32;
                                             var27 = var69.y / 32 - class168.localPlayer.y / 32;
                                             XGrandExchangeOffer.method135(var12, var13, var26, var27, Frames.field2151[1], var71);
                                          }
                                       }
                                    }

                                    var23 = class96.field1499;
                                    int[] var70 = class96.field1501;

                                    for(var47 = 0; var47 < var23; ++var47) {
                                       Player var46 = Client.cachedPlayers[var70[var47]];
                                       if(var46 != null && var46.vmethod1669() && !var46.hidden && class168.localPlayer != var46) {
                                          var27 = var46.x / 32 - class168.localPlayer.x / 32;
                                          var51 = var46.y / 32 - class168.localPlayer.y / 32;
                                          boolean var63 = false;
                                          if(class7.method29(var46.name, true)) {
                                             var63 = true;
                                          }

                                          boolean var62 = false;

                                          for(var31 = 0; var31 < class24.clanChatCount; ++var31) {
                                             if(var46.name.equals(class2.clanMembers[var31].username)) {
                                                var62 = true;
                                                break;
                                             }
                                          }

                                          boolean var64 = false;
                                          if(class168.localPlayer.team != 0 && var46.team != 0 && class168.localPlayer.team == var46.team) {
                                             var64 = true;
                                          }

                                          if(var63) {
                                             XGrandExchangeOffer.method135(var12, var13, var27, var51, Frames.field2151[3], var71);
                                          } else if(var64) {
                                             XGrandExchangeOffer.method135(var12, var13, var27, var51, Frames.field2151[4], var71);
                                          } else if(var62) {
                                             XGrandExchangeOffer.method135(var12, var13, var27, var51, Frames.field2151[5], var71);
                                          } else {
                                             XGrandExchangeOffer.method135(var12, var13, var27, var51, Frames.field2151[2], var71);
                                          }
                                       }
                                    }

                                    if(Client.field930 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field930 == 1 && Client.field931 >= 0 && Client.field931 < Client.cachedNPCs.length) {
                                          NPC var59 = Client.cachedNPCs[Client.field931];
                                          if(var59 != null) {
                                             var26 = var59.x / 32 - class168.localPlayer.x / 32;
                                             var27 = var59.y / 32 - class168.localPlayer.y / 32;
                                             GameObject.method2904(var12, var13, var26, var27, World.field1310[1], var71);
                                          }
                                       }

                                       if(Client.field930 == 2) {
                                          var47 = Client.hintArrowX * 4 - class61.baseX * 4 + 2 - class168.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - class23.baseY * 4 + 2 - class168.localPlayer.y / 32;
                                          GameObject.method2904(var12, var13, var47, var26, World.field1310[1], var71);
                                       }

                                       if(Client.field930 == 10 && Client.field1166 >= 0 && Client.field1166 < Client.cachedPlayers.length) {
                                          Player var60 = Client.cachedPlayers[Client.field1166];
                                          if(var60 != null) {
                                             var26 = var60.x / 32 - class168.localPlayer.x / 32;
                                             var27 = var60.y / 32 - class168.localPlayer.y / 32;
                                             GameObject.method2904(var12, var13, var26, var27, World.field1310[1], var71);
                                          }
                                       }
                                    }

                                    if(Client.detinationX != 0) {
                                       var47 = Client.detinationX * 4 + 2 - class168.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - class168.localPlayer.y / 32;
                                       XGrandExchangeOffer.method135(var12, var13, var47, var26, World.field1310[0], var71);
                                    }

                                    if(!class168.localPlayer.hidden) {
                                       Rasterizer2D.method5040(var12 + var71.field2610 / 2 - 1, var71.field2605 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var25 = Client.groundItemDeque[class92.plane][var23][var24];
                                    if(var25 != null) {
                                       var26 = var23 * 4 + 2 - class168.localPlayer.x / 32;
                                       var27 = var24 * 4 + 2 - class168.localPlayer.y / 32;
                                       XGrandExchangeOffer.method135(var12, var13, var26, var27, Frames.field2151[0], var71);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4984(var12, var13, 0, var71.field2607, var71.field2606);
                           }

                           Client.field1122[var11] = true;
                        }

                        Rasterizer2D.method4961(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var71 = var10.method4053(false);
                        if(var71 != null) {
                           if(Client.field1016 < 3) {
                              ChatLineBuffer.field1558.method5108(var12, var13, var71.field2610, var71.field2605, 25, 25, Client.mapAngle, 256, var71.field2607, var71.field2606);
                           } else {
                              Rasterizer2D.method4984(var12, var13, 0, var71.field2607, var71.field2606);
                           }
                        }

                        Rasterizer2D.method4961(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        FaceNormal.field2146.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        FaceNormal.field2146.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && Ignore.method1079(var10) && class83.field1354 != var10) {
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

                     WidgetNode var49 = (WidgetNode)Client.componentTable.method3545((long)var10.id);
                     if(var49 != null) {
                        class22.method190(var49.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4961(var2, var3, var4, var5);
                     class136.method2594();
                  }

                  if(Client.isResized || Client.field1123[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class71.method1081(var10.width + var12, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2782; ++var20) {
                              for(var52 = 0; var52 < var10.originalWidth; ++var52) {
                                 var22 = var52 * (var10.paddingX + 32) + var12;
                                 var23 = (var10.paddingY + 32) * var20 + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2656[var19];
                                    var23 += var10.field2721[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2722 != null && var19 < 20) {
                                       SpritePixels var68 = var10.method4039(var19);
                                       if(var68 != null) {
                                          var68.method5097(var22, var23);
                                       } else if(Widget.field2650) {
                                          CombatInfo1.method1515(var10);
                                       }
                                    }
                                 } else {
                                    boolean var61 = false;
                                    boolean var66 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class98.field1529 && var19 == Client.field1028) {
                                       SpritePixels var54;
                                       if(Client.itemSelectionState == 1 && Client.selectedItemIndex == var19 && Frames.field2152 == var10.id) {
                                          var54 = VertexNormal.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var54 = VertexNormal.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var54 != null) {
                                          if(var10 == class98.field1529 && var19 == Client.field1028) {
                                             var24 = class59.field729 - Client.field1029;
                                             var47 = class59.field715 - Client.field996;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var47 < 5 && var47 > -5) {
                                                var47 = 0;
                                             }

                                             if(Client.field1033 < 5) {
                                                var24 = 0;
                                                var47 = 0;
                                             }

                                             var54.method5103(var22 + var24, var47 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var23 + var47 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var47) * Client.field990 / 3;
                                                   if(var29 > Client.field990 * 10) {
                                                      var29 = Client.field990 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field996 += var29;
                                                   CombatInfo1.method1515(var28);
                                                }

                                                if(var47 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = Client.field990 * (var47 + var23 + 32 - Rasterizer2D.drawingAreaRight) / 3;
                                                   if(var29 > Client.field990 * 10) {
                                                      var29 = Client.field990 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field996 -= var29;
                                                   CombatInfo1.method1515(var28);
                                                }
                                             }
                                          } else if(class268.field3681 == var10 && var19 == Client.field1027) {
                                             var54.method5103(var22, var23, 128);
                                          } else {
                                             var54.method5097(var22, var23);
                                          }
                                       } else {
                                          CombatInfo1.method1515(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(WorldMapType2.method512(var10)) {
                              var19 = var10.field2775;
                              if(var10 == class83.field1354 && var10.field2746 != 0) {
                                 var19 = var10.field2746;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class83.field1354 && var10.field2764 != 0) {
                                 var19 = var10.field2764;
                              }
                           }

                           if(var10.field2745) {
                              switch(var10.field2668.field3763) {
                              case 1:
                                 Rasterizer2D.method4970(var12, var13, var10.width, var10.height, var10.textColor, var10.field2775, 256 - (var10.opacity & 255), 256 - (var10.field2684 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4971(var12, var13, var10.width, var10.height, var10.textColor, var10.field2775, 256 - (var10.opacity & 255), 256 - (var10.field2684 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4972(var12, var13, var10.width, var10.height, var10.textColor, var10.field2775, 256 - (var10.opacity & 255), 256 - (var10.field2684 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5022(var12, var13, var10.width, var10.height, var10.textColor, var10.field2775, 256 - (var10.opacity & 255), 256 - (var10.field2684 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method5040(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method5026(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4976(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method5039(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var65;
                           if(var10.type == 4) {
                              var65 = var10.method4019();
                              if(var65 == null) {
                                 if(Widget.field2650) {
                                    CombatInfo1.method1515(var10);
                                 }
                              } else {
                                 String var57 = var10.text;
                                 if(WorldMapType2.method512(var10)) {
                                    var20 = var10.field2775;
                                    if(var10 == class83.field1354 && var10.field2746 != 0) {
                                       var20 = var10.field2746;
                                    }

                                    if(var10.field2713.length() > 0) {
                                       var57 = var10.field2713;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class83.field1354 && var10.field2764 != 0) {
                                       var20 = var10.field2764;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var73 = ItemComposition.getItemDefinition(var10.itemId);
                                    var57 = var73.name;
                                    if(var57 == null) {
                                       var57 = "null";
                                    }

                                    if((var73.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var57 = class60.method996(16748608) + var57 + "</col>" + " " + 'x' + class9.method60(var10.itemQuantity);
                                    }
                                 }

                                 if(Client.field1147 == var10) {
                                    Object var10000 = null;
                                    var57 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var57 = XClanMember.method1124(var57, var10);
                                 }

                                 var65.method4792(var57, var12, var13, var10.width, var10.height, var20, var10.field2717?0:-1, var10.field2715, var10.field2714, var10.field2669);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var67;
                              if(!var10.hasScript) {
                                 var67 = var10.method4015(WorldMapType2.method512(var10));
                                 if(var67 != null) {
                                    var67.method5097(var12, var13);
                                 } else if(Widget.field2650) {
                                    CombatInfo1.method1515(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var67 = VertexNormal.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2710, false);
                                 } else {
                                    var67 = var10.method4015(false);
                                 }

                                 if(var67 == null) {
                                    if(Widget.field2650) {
                                       CombatInfo1.method1515(var10);
                                    }
                                 } else {
                                    var20 = var67.maxWidth;
                                    var52 = var67.maxHeight;
                                    if(!var10.field2690) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2642 != 0) {
                                          var67.method5088(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2642, var22);
                                       } else if(var14 != 0) {
                                          var67.method5105(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var10.height == var52) {
                                          var67.method5097(var12, var13);
                                       } else {
                                          var67.method5099(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4962(var12, var13, var12 + var10.width, var10.height + var13);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var10.height + (var52 - 1)) / var52;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var47 = 0; var47 < var23; ++var47) {
                                             if(var10.field2642 != 0) {
                                                var67.method5088(var20 / 2 + var24 * var20 + var12, var52 / 2 + var52 * var47 + var13, var10.field2642, 4096);
                                             } else if(var14 != 0) {
                                                var67.method5103(var12 + var20 * var24, var52 * var47 + var13, 256 - (var14 & 255));
                                             } else {
                                                var67.method5097(var12 + var20 * var24, var47 * var52 + var13);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4961(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var53;
                              if(var10.type == 6) {
                                 boolean var56 = WorldMapType2.method512(var10);
                                 if(var56) {
                                    var20 = var10.field2666;
                                 } else {
                                    var20 = var10.field2699;
                                 }

                                 Model var55 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var53 = ItemComposition.getItemDefinition(var10.itemId);
                                    if(var53 != null) {
                                       var53 = var53.method4603(var10.itemQuantity);
                                       var55 = var53.getModel(1);
                                       if(var55 != null) {
                                          var55.method2515();
                                          var22 = var55.modelHeight / 2;
                                       } else {
                                          CombatInfo1.method1515(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var55 = Client.field1188.method3978((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var55 = class168.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var55 = var10.method4018((Sequence)null, -1, var56, class168.localPlayer.composition);
                                    if(var55 == null && Widget.field2650) {
                                       CombatInfo1.method1515(var10);
                                    }
                                 } else {
                                    Sequence var75 = class169.getAnimation(var20);
                                    var55 = var10.method4018(var75, var10.field2774, var56, class168.localPlayer.composition);
                                    if(var55 == null && Widget.field2650) {
                                       CombatInfo1.method1515(var10);
                                    }
                                 }

                                 class136.method2597(var10.width / 2 + var12, var13 + var10.height / 2);
                                 var23 = var10.field2706 * class136.SINE[var10.rotationX] >> 16;
                                 var24 = var10.field2706 * class136.COSINE[var10.rotationX] >> 16;
                                 if(var55 != null) {
                                    if(!var10.hasScript) {
                                       var55.method2528(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var55.method2515();
                                       if(var10.field2709) {
                                          var55.method2529(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2680, var10.field2702 + var23 + var22, var10.field2702 + var24, var10.field2706);
                                       } else {
                                          var55.method2528(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2680, var10.field2702 + var23 + var22, var10.field2702 + var24);
                                       }
                                    }
                                 }

                                 class136.method2596();
                              } else {
                                 if(var10.type == 7) {
                                    var65 = var10.method4019();
                                    if(var65 == null) {
                                       if(Widget.field2650) {
                                          CombatInfo1.method1515(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var52 = 0; var52 < var10.field2782; ++var52) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var53 = ItemComposition.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var48;
                                             if(var53.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = class60.method996(16748608) + var53.name + "</col>";
                                             } else {
                                                var48 = class60.method996(16748608) + var53.name + "</col>" + " " + 'x' + class9.method60(var10.itemQuantities[var20]);
                                             }

                                             var47 = (var10.paddingX + 115) * var22 + var12;
                                             var26 = var13 + var52 * (var10.paddingY + 12);
                                             if(var10.field2715 == 0) {
                                                var65.method4785(var48, var47, var26, var10.textColor, var10.field2717?0:-1);
                                             } else if(var10.field2715 == 1) {
                                                var65.method4825(var48, var10.width / 2 + var47, var26, var10.textColor, var10.field2717?0:-1);
                                             } else {
                                                var65.method4809(var48, var10.width + var47 - 1, var26, var10.textColor, var10.field2717?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == Preferences.field1319 && Client.field1094 == Client.field1118) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var21 = WidgetNode.font_p12full;
                                    String var50 = var10.text;

                                    String var74;
                                    for(var50 = XClanMember.method1124(var50, var10); var50.length() > 0; var20 += var21.field3652 + 1) {
                                       var24 = var50.indexOf("<br>");
                                       if(var24 != -1) {
                                          var74 = var50.substring(0, var24);
                                          var50 = var50.substring(var24 + 4);
                                       } else {
                                          var74 = var50;
                                          var50 = "";
                                       }

                                       var47 = var21.method4780(var74);
                                       if(var47 > var19) {
                                          var19 = var47;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var47 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var47 + var20 > var5) {
                                       var47 = var5 - var20;
                                    }

                                    Rasterizer2D.method5040(var24, var47, var19, var20, 16777120);
                                    Rasterizer2D.method4976(var24, var47, var19, var20, 0);
                                    var50 = var10.text;
                                    var26 = var21.field3652 + var47 + 2;

                                    for(var50 = XClanMember.method1124(var50, var10); var50.length() > 0; var26 += var21.field3652 + 1) {
                                       var27 = var50.indexOf("<br>");
                                       if(var27 != -1) {
                                          var74 = var50.substring(0, var27);
                                          var50 = var50.substring(var27 + 4);
                                       } else {
                                          var74 = var50;
                                          var50 = "";
                                       }

                                       var21.method4785(var74, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2686) {
                                       var19 = var12;
                                       var20 = var10.height + var13;
                                       var52 = var10.width + var12;
                                       var22 = var13;
                                    } else {
                                       var19 = var12;
                                       var20 = var13;
                                       var52 = var12 + var10.width;
                                       var22 = var10.height + var13;
                                    }

                                    if(var10.field2685 == 1) {
                                       Rasterizer2D.method4969(var19, var20, var52, var22, var10.textColor);
                                    } else {
                                       var47 = var10.textColor;
                                       var26 = var10.field2685;
                                       var27 = var52 - var19;
                                       var51 = var22 - var20;
                                       var29 = var27 >= 0?var27:-var27;
                                       int var30 = var51 >= 0?var51:-var51;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          int var32 = (var27 << 16) / var31;
                                          int var33 = (var51 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          int var34 = var33 * var26 >> 17;
                                          int var35 = var26 * var33 + 1 >> 17;
                                          int var36 = var26 * var32 >> 17;
                                          int var37 = var32 * var26 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.field3754;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var38 = var23 + var34;
                                          int var39 = var23 - var35;
                                          int var40 = var27 + var23 - var35;
                                          int var41 = var23 + var27 + var34;
                                          int var42 = var36 + var24;
                                          int var43 = var24 - var37;
                                          int var44 = var24 + var51 - var37;
                                          int var45 = var51 + var24 + var36;
                                          class136.setRasterClippingEnabled(var38, var39, var40);
                                          class136.rasterFlat(var42, var43, var44, var38, var39, var40, var47);
                                          class136.setRasterClippingEnabled(var38, var40, var41);
                                          class136.rasterFlat(var42, var44, var45, var38, var40, var41, var47);
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1271125321"
   )
   public static void method3423(int var0) {
      if(var0 != -1) {
         if(FileOnDisk.validInterfaces[var0]) {
            Widget.field2736.method4138(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               FileOnDisk.validInterfaces[var0] = false;
            }
         }
      }
   }
}
