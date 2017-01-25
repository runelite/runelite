import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("a")
   @Export("sender")
   String sender;
   @ObfuscatedName("h")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -574231303
   )
   @Export("id")
   int id = Player.method219();
   @ObfuscatedName("g")
   @Export("value")
   String value;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 861985693
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1719763097
   )
   @Export("type")
   int type;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "14"
   )
   void method176(int var1, String var2, String var3, String var4) {
      this.id = Player.method219();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "38679632"
   )
   static final void method177(int var0, int var1) {
      if(GroundObject.field1301 != var0 || WidgetNode.field200 != var1) {
         GroundObject.field1301 = var0;
         WidgetNode.field200 = var1;
         class103.setGameState(25);
         class36.method714("Loading - please wait.", true);
         int var2 = class22.baseX;
         int var3 = class103.baseY;
         class22.baseX = (var0 - 6) * 8;
         class103.baseY = (var1 - 6) * 8;
         int var4 = class22.baseX - var2;
         int var5 = class103.baseY - var3;
         var2 = class22.baseX;
         var3 = class103.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= 128 * var4;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var19; var12 != var18; var12 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var12][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class25 var17 = (class25)Client.field359.method2330(); null != var17; var17 = (class25)Client.field359.method2346()) {
            var17.field579 -= var4;
            var17.field583 -= var5;
            if(var17.field579 < 0 || var17.field583 < 0 || var17.field579 >= 104 || var17.field583 >= 104) {
               var17.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field505 = 0;
         Client.field499 = false;
         Client.field369 = -1;
         Client.field426.method2324();
         Client.projectiles.method2324();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2179();
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass159;ILPlayer;II)V",
      garbageValue = "-403019868"
   )
   static final void method180(class159 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method2824(var6, 0, var5);
         class45.field893[var1] = var7;
         var2.method212(var7);
      }

      int var18;
      if((var3 & 128) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var18 = var0.readUnsignedByte();
         class20.method172(var2, var5, var18);
      }

      if((var3 & 16) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 2) != 0) {
         var2.overhead = var0.method2911();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            Player.sendGameMessage(2, var2.name, var2.overhead);
         } else if(XItemContainer.localPlayer == var2) {
            Player.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field625 = false;
         var2.field621 = 0;
         var2.field622 = 0;
         var2.field649 = 150;
      }

      int var8;
      int var9;
      if((var3 & 32) != 0) {
         var5 = var0.readUnsignedByte();
         int var10;
         int var11;
         int var19;
         if(var5 > 0) {
            for(var18 = 0; var18 < var5; ++var18) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var19 = var0.method2735();
               if(var19 == 32767) {
                  var19 = var0.method2735();
                  var9 = var0.method2735();
                  var8 = var0.method2735();
                  var10 = var0.method2735();
               } else if(var19 != 32766) {
                  var9 = var0.method2735();
               } else {
                  var19 = -1;
               }

               var11 = var0.method2735();
               var2.method577(var19, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var18 = var0.readUnsignedByte();
         if(var18 > 0) {
            for(var19 = 0; var19 < var18; ++var19) {
               var8 = var0.method2735();
               var9 = var0.method2735();
               if(var9 != 32767) {
                  var10 = var0.method2735();
                  var11 = var0.readUnsignedByte();
                  int var12 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method578(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method580(var8);
               }
            }
         }
      }

      if((var3 & 4) != 0) {
         var2.field632 = var0.readUnsignedShort();
         if(var2.field658 == 0) {
            var2.field655 = var2.field632;
            var2.field632 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.readUnsignedShort();
         class177 var25 = (class177)class72.method1368(class7.method91(), var0.readUnsignedByte());
         boolean var28 = var0.readUnsignedByte() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && null != var2.composition) {
            boolean var27 = false;
            if(var25.field2677 && class119.method2222(var2.name)) {
               var27 = true;
            }

            if(!var27 && Client.field383 == 0 && !var2.field257) {
               class45.field903.offset = 0;
               var0.method2824(class45.field903.payload, 0, var8);
               class45.field903.offset = 0;
               Buffer var20 = class45.field903;

               String var13;
               int var14;
               String var16;
               try {
                  var14 = var20.method2735();
                  if(var14 > 32767) {
                     var14 = 32767;
                  }

                  byte[] var15 = new byte[var14];
                  var20.offset += class210.field3121.method2648(var20.payload, var20.offset, var15, 0, var14);
                  var16 = Friend.method152(var15, 0, var14);
                  var13 = var16;
               } catch (Exception var24) {
                  var13 = "Cabbage";
               }

               var13 = FontTypeFace.method3726(class115.method2169(var13));
               var2.overhead = var13.trim();
               var2.field621 = var5 >> 8;
               var2.field622 = var5 & 255;
               var2.field649 = 150;
               var2.field625 = var28;
               var2.inSequence = XItemContainer.localPlayer != var2 && var25.field2677 && Client.field512 != "" && var13.toLowerCase().indexOf(Client.field512) == -1;
               if(var25.field2676) {
                  var14 = var28?91:1;
               } else {
                  var14 = var28?90:2;
               }

               if(var25.field2675 != -1) {
                  int var17 = var25.field2675;
                  var16 = "<img=" + var17 + ">";
                  Player.sendGameMessage(var14, var16 + var2.name, var13);
               } else {
                  Player.sendGameMessage(var14, var2.name, var13);
               }
            }
         }

         var0.offset = var9 + var8;
      }

      if((var3 & 512) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.method2727();
         var2.field631 = var5 >> 16;
         var2.field604 = Client.gameCycle + (var5 & '\uffff');
         var2.field642 = 0;
         var2.field643 = 0;
         if(var2.field604 > Client.gameCycle) {
            var2.field642 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field606 = var0.readByte();
         var2.field650 = var0.readByte();
         var2.field657 = var0.readByte();
         var2.field620 = var0.readByte();
         var2.field661 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field651 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field652 = var0.readUnsignedShort();
         if(var2.field279) {
            var2.field606 += var2.field280;
            var2.field650 += var2.field281;
            var2.field657 += var2.field280;
            var2.field620 += var2.field281;
            var2.field658 = 0;
         } else {
            var2.field606 += var2.pathX[0];
            var2.field650 += var2.pathY[0];
            var2.field657 += var2.pathX[0];
            var2.field620 += var2.pathY[0];
            var2.field658 = 1;
         }

         var2.field663 = 0;
      }

      if((var3 & 2048) != 0) {
         class45.field892[var1] = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 256) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.method2911();
         }
      }

      if(var2.field279) {
         if(var4 == 127) {
            var2.method198(var2.field280, var2.field281);
         } else {
            byte var26;
            if(var4 != -1) {
               var26 = var4;
            } else {
               var26 = class45.field892[var1];
            }

            var2.method197(var2.field280, var2.field281, var26);
         }
      }

   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1085025123"
   )
   static final String method181(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + Actor.method574('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + Actor.method574(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + Actor.method574(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1859583191"
   )
   static final void method182(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2289 || class170.method3147(var9) != 0 || Client.field465 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !class13.method149(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var9.width + var10;
               var19 = var9.height + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field464 == var9) {
               Client.field472 = true;
               Client.field576 = var10;
               Client.field474 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1810;
               var17 = class115.field1803;
               if(class115.field1807 != 0) {
                  var16 = class115.field1809;
                  var17 = class115.field1796;
               }

               int var20;
               int var22;
               int var23;
               int var24;
               int var25;
               int var29;
               int var32;
               int var36;
               int var52;
               if(var9.contentType == 1337) {
                  if(!Client.field302 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field412 == 0 && !Client.field446) {
                        class214.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var20 = 0; var20 < Model.field1414; ++var20) {
                        var32 = Model.field1386[var20];
                        var22 = var32 & 127;
                        var23 = var32 >> 7 & 127;
                        var24 = var32 >> 29 & 3;
                        var25 = var32 >> 14 & 32767;
                        if(var32 != var19) {
                           var19 = var32;
                           if(var24 == 2 && class0.region.method1730(class118.plane, var22, var23, var32) >= 0) {
                              ObjectComposition var51 = class143.getObjectDefinition(var25);
                              if(var51.impostorIds != null) {
                                 var51 = var51.getImpostor();
                              }

                              if(var51 == null) {
                                 continue;
                              }

                              if(Client.field412 == 1) {
                                 class214.addMenuEntry("Use", Client.field322 + " " + "->" + " " + Actor.method574('\uffff') + var51.name, 1, var32, var22, var23);
                              } else if(Client.field446) {
                                 if((NPC.field760 & 4) == 4) {
                                    class214.addMenuEntry(Client.field449, Client.field450 + " " + "->" + " " + Actor.method574('\uffff') + var51.name, 2, var32, var22, var23);
                                 }
                              } else {
                                 String[] var27 = var51.actions;
                                 if(Client.field462) {
                                    var27 = class11.method133(var27);
                                 }

                                 if(null != var27) {
                                    for(var52 = 4; var52 >= 0; --var52) {
                                       if(var27[var52] != null) {
                                          short var56 = 0;
                                          if(var52 == 0) {
                                             var56 = 3;
                                          }

                                          if(var52 == 1) {
                                             var56 = 4;
                                          }

                                          if(var52 == 2) {
                                             var56 = 5;
                                          }

                                          if(var52 == 3) {
                                             var56 = 6;
                                          }

                                          if(var52 == 4) {
                                             var56 = 1001;
                                          }

                                          class214.addMenuEntry(var27[var52], Actor.method574('\uffff') + var51.name, var56, var32, var22, var23);
                                       }
                                    }
                                 }

                                 class214.addMenuEntry("Examine", Actor.method574('\uffff') + var51.name, 1002, var51.field2942 << 14, var22, var23);
                              }
                           }

                           Player var30;
                           NPC var35;
                           int[] var58;
                           if(var24 == 1) {
                              NPC var53 = Client.cachedNPCs[var25];
                              if(null == var53) {
                                 continue;
                              }

                              if(var53.composition.field3010 == 1 && (var53.x & 127) == 64 && (var53.y & 127) == 64) {
                                 for(var36 = 0; var36 < Client.field332; ++var36) {
                                    var35 = Client.cachedNPCs[Client.field333[var36]];
                                    if(var35 != null && var53 != var35 && var35.composition.field3010 == 1 && var35.x == var53.x && var53.y == var35.y) {
                                       class174.method3152(var35.composition, Client.field333[var36], var22, var23);
                                    }
                                 }

                                 var36 = class45.field894;
                                 var58 = class45.field896;

                                 for(var29 = 0; var29 < var36; ++var29) {
                                    var30 = Client.cachedPlayers[var58[var29]];
                                    if(null != var30 && var53.x == var30.x && var30.y == var53.y) {
                                       class2.method24(var30, var58[var29], var22, var23);
                                    }
                                 }
                              }

                              class174.method3152(var53.composition, var25, var22, var23);
                           }

                           if(var24 == 0) {
                              Player var54 = Client.cachedPlayers[var25];
                              if(null == var54) {
                                 continue;
                              }

                              if((var54.x & 127) == 64 && (var54.y & 127) == 64) {
                                 for(var36 = 0; var36 < Client.field332; ++var36) {
                                    var35 = Client.cachedNPCs[Client.field333[var36]];
                                    if(var35 != null && var35.composition.field3010 == 1 && var54.x == var35.x && var35.y == var54.y) {
                                       class174.method3152(var35.composition, Client.field333[var36], var22, var23);
                                    }
                                 }

                                 var36 = class45.field894;
                                 var58 = class45.field896;

                                 for(var29 = 0; var29 < var36; ++var29) {
                                    var30 = Client.cachedPlayers[var58[var29]];
                                    if(null != var30 && var54 != var30 && var30.x == var54.x && var30.y == var54.y) {
                                       class2.method24(var30, var58[var29], var22, var23);
                                    }
                                 }
                              }

                              if(var25 != Client.field292) {
                                 class2.method24(var54, var25, var22, var23);
                              } else {
                                 var18 = var32;
                              }
                           }

                           if(var24 == 3) {
                              Deque var55 = Client.groundItemDeque[class118.plane][var22][var23];
                              if(var55 != null) {
                                 for(Item var50 = (Item)var55.method2331(); var50 != null; var50 = (Item)var55.method2335()) {
                                    ItemComposition var59 = NPC.getItemDefinition(var50.id);
                                    if(Client.field412 == 1) {
                                       class214.addMenuEntry("Use", Client.field322 + " " + "->" + " " + Actor.method574(16748608) + var59.name, 16, var50.id, var22, var23);
                                    } else if(Client.field446) {
                                       if((NPC.field760 & 1) == 1) {
                                          class214.addMenuEntry(Client.field449, Client.field450 + " " + "->" + " " + Actor.method574(16748608) + var59.name, 17, var50.id, var22, var23);
                                       }
                                    } else {
                                       String[] var40 = var59.groundActions;
                                       if(Client.field462) {
                                          var40 = class11.method133(var40);
                                       }

                                       for(int var62 = 4; var62 >= 0; --var62) {
                                          if(null != var40 && var40[var62] != null) {
                                             byte var31 = 0;
                                             if(var62 == 0) {
                                                var31 = 18;
                                             }

                                             if(var62 == 1) {
                                                var31 = 19;
                                             }

                                             if(var62 == 2) {
                                                var31 = 20;
                                             }

                                             if(var62 == 3) {
                                                var31 = 21;
                                             }

                                             if(var62 == 4) {
                                                var31 = 22;
                                             }

                                             class214.addMenuEntry(var40[var62], Actor.method574(16748608) + var59.name, var31, var50.id, var22, var23);
                                          } else if(var62 == 2) {
                                             class214.addMenuEntry("Take", Actor.method574(16748608) + var59.name, 20, var50.id, var22, var23);
                                          }
                                       }

                                       class214.addMenuEntry("Examine", Actor.method574(16748608) + var59.name, 1004, var50.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var20 = var18 & 127;
                        var32 = var18 >> 7 & 127;
                        Player var61 = Client.cachedPlayers[Client.field292];
                        class2.method24(var61, Client.field292, var20, var32);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  CombatInfoListHolder.method691(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2212 == 1) {
                        class214.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var37;
                     if(var9.field2212 == 2 && !Client.field446) {
                        if(class94.method1857(class170.method3147(var9)) == 0) {
                           var37 = null;
                        } else if(var9.field2323 != null && var9.field2323.trim().length() != 0) {
                           var37 = var9.field2323;
                        } else {
                           var37 = null;
                        }

                        if(var37 != null) {
                           class214.addMenuEntry(var37, Actor.method574('\uff00') + var9.field2325, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2212 == 3) {
                        class214.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2212 == 4) {
                        class214.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2212 == 5) {
                        class214.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2212 == 6 && Client.field455 == null) {
                        class214.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     if(var9.type == 2) {
                        var20 = 0;

                        for(var32 = 0; var32 < var9.height; ++var32) {
                           for(var22 = 0; var22 < var9.width; ++var22) {
                              var23 = (32 + var9.field2275) * var22;
                              var24 = var32 * (var9.field2276 + 32);
                              if(var20 < 20) {
                                 var23 += var9.field2277[var20];
                                 var24 += var9.field2278[var20];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < var23 + 32 && var19 < var24 + 32) {
                                 Client.field409 = var20;
                                 class179.field2694 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    ItemComposition var38 = NPC.getItemDefinition(var9.itemIds[var20] - 1);
                                    if(Client.field412 == 1 && class7.method92(class170.method3147(var9))) {
                                       if(class107.field1734 != var9.id || ItemLayer.field1216 != var20) {
                                          class214.addMenuEntry("Use", Client.field322 + " " + "->" + " " + Actor.method574(16748608) + var38.name, 31, var38.id, var20, var9.id);
                                       }
                                    } else if(Client.field446 && class7.method92(class170.method3147(var9))) {
                                       if((NPC.field760 & 16) == 16) {
                                          class214.addMenuEntry(Client.field449, Client.field450 + " " + "->" + " " + Actor.method574(16748608) + var38.name, 32, var38.id, var20, var9.id);
                                       }
                                    } else {
                                       String[] var26 = var38.inventoryActions;
                                       if(Client.field462) {
                                          var26 = class11.method133(var26);
                                       }

                                       if(class7.method92(class170.method3147(var9))) {
                                          for(var36 = 4; var36 >= 3; --var36) {
                                             if(var26 != null && null != var26[var36]) {
                                                byte var28;
                                                if(var36 == 3) {
                                                   var28 = 36;
                                                } else {
                                                   var28 = 37;
                                                }

                                                class214.addMenuEntry(var26[var36], Actor.method574(16748608) + var38.name, var28, var38.id, var20, var9.id);
                                             } else if(var36 == 4) {
                                                class214.addMenuEntry("Drop", Actor.method574(16748608) + var38.name, 37, var38.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       var52 = class170.method3147(var9);
                                       boolean var60 = (var52 >> 31 & 1) != 0;
                                       if(var60) {
                                          class214.addMenuEntry("Use", Actor.method574(16748608) + var38.name, 38, var38.id, var20, var9.id);
                                       }

                                       Object var10000 = null;
                                       byte var39;
                                       if(class7.method92(class170.method3147(var9)) && var26 != null) {
                                          for(var29 = 2; var29 >= 0; --var29) {
                                             if(null != var26[var29]) {
                                                var39 = 0;
                                                if(var29 == 0) {
                                                   var39 = 33;
                                                }

                                                if(var29 == 1) {
                                                   var39 = 34;
                                                }

                                                if(var29 == 2) {
                                                   var39 = 35;
                                                }

                                                class214.addMenuEntry(var26[var29], Actor.method574(16748608) + var38.name, var39, var38.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       var26 = var9.field2335;
                                       if(Client.field462) {
                                          var26 = class11.method133(var26);
                                       }

                                       if(null != var26) {
                                          for(var29 = 4; var29 >= 0; --var29) {
                                             if(var26[var29] != null) {
                                                var39 = 0;
                                                if(var29 == 0) {
                                                   var39 = 39;
                                                }

                                                if(var29 == 1) {
                                                   var39 = 40;
                                                }

                                                if(var29 == 2) {
                                                   var39 = 41;
                                                }

                                                if(var29 == 3) {
                                                   var39 = 42;
                                                }

                                                if(var29 == 4) {
                                                   var39 = 43;
                                                }

                                                class214.addMenuEntry(var26[var29], Actor.method574(16748608) + var38.name, var39, var38.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       class214.addMenuEntry("Examine", Actor.method574(16748608) + var38.name, 1005, var38.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.hasScript) {
                        if(Client.field446) {
                           if(class101.method1905(class170.method3147(var9)) && (NPC.field760 & 32) == 32) {
                              class214.addMenuEntry(Client.field449, Client.field450 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           for(var20 = 9; var20 >= 5; --var20) {
                              var23 = class170.method3147(var9);
                              boolean var48 = (var23 >> 1 + var20 & 1) != 0;
                              String var21;
                              if(!var48 && var9.field2309 == null) {
                                 var21 = null;
                              } else if(null != var9.actions && var9.actions.length > var20 && null != var9.actions[var20] && var9.actions[var20].trim().length() != 0) {
                                 var21 = var9.actions[var20];
                              } else {
                                 var21 = null;
                              }

                              if(null != var21) {
                                 class214.addMenuEntry(var21, var9.name, 1007, var20 + 1, var9.index, var9.id);
                              }
                           }

                           if(class94.method1857(class170.method3147(var9)) == 0) {
                              var37 = null;
                           } else if(null != var9.field2323 && var9.field2323.trim().length() != 0) {
                              var37 = var9.field2323;
                           } else {
                              var37 = null;
                           }

                           if(null != var37) {
                              class214.addMenuEntry(var37, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var22 = 4; var22 >= 0; --var22) {
                              var25 = class170.method3147(var9);
                              boolean var49 = (var25 >> 1 + var22 & 1) != 0;
                              String var42;
                              if(!var49 && null == var9.field2309) {
                                 var42 = null;
                              } else if(var9.actions != null && var9.actions.length > var22 && null != var9.actions[var22] && var9.actions[var22].trim().length() != 0) {
                                 var42 = var9.actions[var22];
                              } else {
                                 var42 = null;
                              }

                              if(null != var42) {
                                 class214.addMenuEntry(var42, var9.name, 57, var22 + 1, var9.index, var9.id);
                              }
                           }

                           if(World.method636(class170.method3147(var9))) {
                              class214.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class13.method149(var9) && class215.field3163 != var9) {
                        continue;
                     }

                     method182(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method182(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var34 = (WidgetNode)Client.componentTable.method2274((long)var9.id);
                     if(null != var34) {
                        if(var34.field193 == 0 && class115.field1810 >= var12 && class115.field1803 >= var13 && class115.field1810 < var14 && class115.field1803 < var15 && !Client.isMenuOpen && !Client.field461) {
                           for(class18 var43 = (class18)Client.field417.method2330(); null != var43; var43 = (class18)Client.field417.method2346()) {
                              if(var43.field203) {
                                 var43.unlink();
                                 var43.field204.field2334 = false;
                              }
                           }

                           if(class6.field72 == 0) {
                              Client.field464 = null;
                              Client.field465 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        Item.method774(var34.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     class18 var57;
                     if(!var9.field2342) {
                        if(var9.field2220 && class115.field1810 >= var12 && class115.field1803 >= var13 && class115.field1810 < var14 && class115.field1803 < var15) {
                           for(var57 = (class18)Client.field417.method2330(); var57 != null; var57 = (class18)Client.field417.method2346()) {
                              if(var57.field203 && var57.field205 == var57.field204.field2343) {
                                 var57.unlink();
                              }
                           }
                        }
                     } else if(class115.field1810 >= var12 && class115.field1803 >= var13 && class115.field1810 < var14 && class115.field1803 < var15) {
                        for(var57 = (class18)Client.field417.method2330(); var57 != null; var57 = (class18)Client.field417.method2346()) {
                           if(var57.field203) {
                              var57.unlink();
                              var57.field204.field2334 = false;
                           }
                        }

                        if(class6.field72 == 0) {
                           Client.field464 = null;
                           Client.field465 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var44;
                     if(class115.field1810 >= var12 && class115.field1803 >= var13 && class115.field1810 < var14 && class115.field1803 < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var45 = false;
                     if((class115.field1801 == 1 || !class10.field110 && class115.field1801 == 4) && var44) {
                        var45 = true;
                     }

                     boolean var46 = false;
                     if((class115.field1807 == 1 || !class10.field110 && class115.field1807 == 4) && class115.field1809 >= var12 && class115.field1796 >= var13 && class115.field1809 < var14 && class115.field1796 < var15) {
                        var46 = true;
                     }

                     if(var46) {
                        class184.method3297(var9, class115.field1809 - var10, class115.field1796 - var11);
                     }

                     if(Client.field464 != null && Client.field464 != var9 && var44 && class85.method1653(class170.method3147(var9))) {
                        Client.field468 = var9;
                     }

                     if(var9 == Client.field465) {
                        Client.field429 = true;
                        Client.field408 = var10;
                        Client.field310 = var11;
                     }

                     if(var9.field2289) {
                        class18 var47;
                        if(var44 && Client.field380 != 0 && var9.field2343 != null) {
                           var47 = new class18();
                           var47.field203 = true;
                           var47.field204 = var9;
                           var47.field206 = Client.field380;
                           var47.field205 = var9.field2343;
                           Client.field417.method2333(var47);
                        }

                        if(null != Client.field464 || null != class38.field786 || Client.isMenuOpen) {
                           var46 = false;
                           var45 = false;
                           var44 = false;
                        }

                        if(!var9.field2239 && var46) {
                           var9.field2239 = true;
                           if(var9.field2258 != null) {
                              var47 = new class18();
                              var47.field203 = true;
                              var47.field204 = var9;
                              var47.field209 = class115.field1809 - var10;
                              var47.field206 = class115.field1796 - var11;
                              var47.field205 = var9.field2258;
                              Client.field417.method2333(var47);
                           }
                        }

                        if(var9.field2239 && var45 && null != var9.field2292) {
                           var47 = new class18();
                           var47.field203 = true;
                           var47.field204 = var9;
                           var47.field209 = class115.field1810 - var10;
                           var47.field206 = class115.field1803 - var11;
                           var47.field205 = var9.field2292;
                           Client.field417.method2333(var47);
                        }

                        if(var9.field2239 && !var45) {
                           var9.field2239 = false;
                           if(var9.field2252 != null) {
                              var47 = new class18();
                              var47.field203 = true;
                              var47.field204 = var9;
                              var47.field209 = class115.field1810 - var10;
                              var47.field206 = class115.field1803 - var11;
                              var47.field205 = var9.field2252;
                              Client.field388.method2333(var47);
                           }
                        }

                        if(var45 && var9.field2294 != null) {
                           var47 = new class18();
                           var47.field203 = true;
                           var47.field204 = var9;
                           var47.field209 = class115.field1810 - var10;
                           var47.field206 = class115.field1803 - var11;
                           var47.field205 = var9.field2294;
                           Client.field417.method2333(var47);
                        }

                        if(!var9.field2334 && var44) {
                           var9.field2334 = true;
                           if(var9.field2295 != null) {
                              var47 = new class18();
                              var47.field203 = true;
                              var47.field204 = var9;
                              var47.field209 = class115.field1810 - var10;
                              var47.field206 = class115.field1803 - var11;
                              var47.field205 = var9.field2295;
                              Client.field417.method2333(var47);
                           }
                        }

                        if(var9.field2334 && var44 && null != var9.field2296) {
                           var47 = new class18();
                           var47.field203 = true;
                           var47.field204 = var9;
                           var47.field209 = class115.field1810 - var10;
                           var47.field206 = class115.field1803 - var11;
                           var47.field205 = var9.field2296;
                           Client.field417.method2333(var47);
                        }

                        if(var9.field2334 && !var44) {
                           var9.field2334 = false;
                           if(var9.field2328 != null) {
                              var47 = new class18();
                              var47.field203 = true;
                              var47.field204 = var9;
                              var47.field209 = class115.field1810 - var10;
                              var47.field206 = class115.field1803 - var11;
                              var47.field205 = var9.field2328;
                              Client.field388.method2333(var47);
                           }
                        }

                        if(null != var9.field2308) {
                           var47 = new class18();
                           var47.field204 = var9;
                           var47.field205 = var9.field2308;
                           Client.field492.method2333(var47);
                        }

                        class18 var33;
                        if(null != var9.field2302 && Client.field478 > var9.field2211) {
                           if(null != var9.field2293 && Client.field478 - var9.field2211 <= 32) {
                              label1375:
                              for(var32 = var9.field2211; var32 < Client.field478; ++var32) {
                                 var22 = Client.field477[var32 & 31];

                                 for(var23 = 0; var23 < var9.field2293.length; ++var23) {
                                    if(var9.field2293[var23] == var22) {
                                       var33 = new class18();
                                       var33.field204 = var9;
                                       var33.field205 = var9.field2302;
                                       Client.field417.method2333(var33);
                                       break label1375;
                                    }
                                 }
                              }
                           } else {
                              var47 = new class18();
                              var47.field204 = var9;
                              var47.field205 = var9.field2302;
                              Client.field417.method2333(var47);
                           }

                           var9.field2211 = Client.field478;
                        }

                        if(null != var9.field2248 && Client.field457 > var9.field2338) {
                           if(null != var9.field2305 && Client.field457 - var9.field2338 <= 32) {
                              label1351:
                              for(var32 = var9.field2338; var32 < Client.field457; ++var32) {
                                 var22 = Client.interfaceItemTriggers[var32 & 31];

                                 for(var23 = 0; var23 < var9.field2305.length; ++var23) {
                                    if(var9.field2305[var23] == var22) {
                                       var33 = new class18();
                                       var33.field204 = var9;
                                       var33.field205 = var9.field2248;
                                       Client.field417.method2333(var33);
                                       break label1351;
                                    }
                                 }
                              }
                           } else {
                              var47 = new class18();
                              var47.field204 = var9;
                              var47.field205 = var9.field2248;
                              Client.field417.method2333(var47);
                           }

                           var9.field2338 = Client.field457;
                        }

                        if(null != var9.field2306 && Client.field482 > var9.field2339) {
                           if(var9.field2307 != null && Client.field482 - var9.field2339 <= 32) {
                              label1327:
                              for(var32 = var9.field2339; var32 < Client.field482; ++var32) {
                                 var22 = Client.field481[var32 & 31];

                                 for(var23 = 0; var23 < var9.field2307.length; ++var23) {
                                    if(var22 == var9.field2307[var23]) {
                                       var33 = new class18();
                                       var33.field204 = var9;
                                       var33.field205 = var9.field2306;
                                       Client.field417.method2333(var33);
                                       break label1327;
                                    }
                                 }
                              }
                           } else {
                              var47 = new class18();
                              var47.field204 = var9;
                              var47.field205 = var9.field2306;
                              Client.field417.method2333(var47);
                           }

                           var9.field2339 = Client.field482;
                        }

                        if(Client.field357 > var9.field2336 && null != var9.field2311) {
                           var47 = new class18();
                           var47.field204 = var9;
                           var47.field205 = var9.field2311;
                           Client.field417.method2333(var47);
                        }

                        if(Client.field484 > var9.field2336 && var9.field2337 != null) {
                           var47 = new class18();
                           var47.field204 = var9;
                           var47.field205 = var9.field2337;
                           Client.field417.method2333(var47);
                        }

                        if(Client.field485 > var9.field2336 && null != var9.field2314) {
                           var47 = new class18();
                           var47.field204 = var9;
                           var47.field205 = var9.field2314;
                           Client.field417.method2333(var47);
                        }

                        if(Client.field427 > var9.field2336 && var9.field2319 != null) {
                           var47 = new class18();
                           var47.field204 = var9;
                           var47.field205 = var9.field2319;
                           Client.field417.method2333(var47);
                        }

                        if(Client.field487 > var9.field2336 && null != var9.field2320) {
                           var47 = new class18();
                           var47.field204 = var9;
                           var47.field205 = var9.field2320;
                           Client.field417.method2333(var47);
                        }

                        if(Client.field488 > var9.field2336 && var9.field2315 != null) {
                           var47 = new class18();
                           var47.field204 = var9;
                           var47.field205 = var9.field2315;
                           Client.field417.method2333(var47);
                        }

                        var9.field2336 = Client.field358;
                        if(null != var9.field2201) {
                           for(var32 = 0; var32 < Client.field515; ++var32) {
                              class18 var41 = new class18();
                              var41.field204 = var9;
                              var41.field214 = Client.field494[var32];
                              var41.field207 = Client.field516[var32];
                              var41.field205 = var9.field2201;
                              Client.field417.method2333(var41);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && null == Client.field464 && null == class38.field786 && !Client.isMenuOpen) {
                     if((var9.field2255 >= 0 || var9.field2341 != 0) && class115.field1810 >= var12 && class115.field1803 >= var13 && class115.field1810 < var14 && class115.field1803 < var15) {
                        if(var9.field2255 >= 0) {
                           class215.field3163 = var0[var9.field2255];
                        } else {
                           class215.field3163 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1810 >= var12 && class115.field1803 >= var13 && class115.field1810 < var14 && class115.field1803 < var15) {
                        XItemContainer.field130 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class0.method5(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, class115.field1810, class115.field1803);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-968433056"
   )
   static int method183(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method859();
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;B)Ljava/lang/String;",
      garbageValue = "23"
   )
   static String method184(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         String var4;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var7 = var0.indexOf("%" + var2);
               if(var7 == -1) {
                  break;
               }

               var4 = var0.substring(0, var7);
               int var6 = class11.method132(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var7 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(class85.field1457 != null) {
               int var8 = class85.field1457.field1665;
               var4 = (var8 >> 24 & 255) + "." + (var8 >> 16 & 255) + "." + (var8 >> 8 & 255) + "." + (var8 & 255);
               var3 = var4;
               if(class85.field1457.field1666 != null) {
                  var3 = (String)class85.field1457.field1666;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1381135831"
   )
   static final void method185(int var0) {
      if(class109.method1999(var0)) {
         GameObject.method1864(Widget.widgets[var0], -1);
      }
   }
}
