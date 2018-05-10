import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("pl")
   @ObfuscatedSignature(
      signature = "Lcc;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -881463437
   )
   static int field19;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -842420131
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 2380918939930674867L
   )
   public final long field10;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("b")
   @Export("string1")
   String string1;
   @ObfuscatedName("f")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgy;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field10 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method52(2);
      this.grandExchangeOffer.method36(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "255"
   )
   public String method16() {
      return this.string1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-1"
   )
   public String method17() {
      return this.string2;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(ZLge;B)V",
      garbageValue = "0"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.field713 = 0;
      Client.pendingNpcFlagsCount = 0;
      PacketBuffer var2 = Client.field739.packetBuffer;
      var2.bitAccess();
      int var3 = var2.getBits(8);
      int var4;
      if(var3 < Client.npcIndexesCount) {
         for(var4 = var3; var4 < Client.npcIndexesCount; ++var4) {
            Client.field714[++Client.field713 - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         int var5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         for(var4 = 0; var4 < var3; ++var4) {
            var5 = Client.npcIndices[var4];
            NPC var6 = Client.cachedNPCs[var5];
            var7 = var2.getBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
               var6.npcCycle = Client.gameCycle;
            } else {
               var8 = var2.getBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
               } else if(var8 == 1) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  var9 = var2.getBits(3);
                  var6.method1824(var9, (byte)1);
                  var10 = var2.getBits(1);
                  if(var10 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                  }
               } else if(var8 == 2) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  var9 = var2.getBits(3);
                  var6.method1824(var9, (byte)2);
                  var10 = var2.getBits(3);
                  var6.method1824(var10, (byte)2);
                  var11 = var2.getBits(1);
                  if(var11 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                  }
               } else if(var8 == 3) {
                  Client.field714[++Client.field713 - 1] = var5;
               }
            }
         }

         Frames.method3096(var0, var1);

         int var14;
         for(var14 = 0; var14 < Client.pendingNpcFlagsCount; ++var14) {
            var3 = Client.pendingNpcFlagsIndices[var14];
            NPC var15 = Client.cachedNPCs[var3];
            var5 = var1.readUnsignedByte();
            if((var5 & 2) != 0) {
               var15.interacting = var1.method3784();
               if(var15.interacting == 65535) {
                  var15.interacting = -1;
               }
            }

            int var16;
            if((var5 & 32) != 0) {
               var16 = var1.method3597();
               int var12;
               if(var16 > 0) {
                  for(var7 = 0; var7 < var16; ++var7) {
                     var9 = -1;
                     var10 = -1;
                     var11 = -1;
                     var8 = var1.getUSmart();
                     if(var8 == 32767) {
                        var8 = var1.getUSmart();
                        var10 = var1.getUSmart();
                        var9 = var1.getUSmart();
                        var11 = var1.getUSmart();
                     } else if(var8 != 32766) {
                        var10 = var1.getUSmart();
                     } else {
                        var8 = -1;
                     }

                     var12 = var1.getUSmart();
                     var15.applyActorHitsplat(var8, var10, var9, var11, Client.gameCycle, var12);
                  }
               }

               var7 = var1.method3553();
               if(var7 > 0) {
                  for(var8 = 0; var8 < var7; ++var8) {
                     var9 = var1.getUSmart();
                     var10 = var1.getUSmart();
                     if(var10 != 32767) {
                        var11 = var1.getUSmart();
                        var12 = var1.method3553();
                        int var13 = var10 > 0?var1.method3553():var12;
                        var15.setCombatInfo(var9, Client.gameCycle, var10, var11, var12, var13);
                     } else {
                        var15.method1579(var9);
                     }
                  }
               }
            }

            if((var5 & 8) != 0) {
               var16 = var1.readUnsignedShort();
               var7 = var1.method3784();
               var8 = var15.x - (var16 - class178.baseX - class178.baseX) * 64;
               var9 = var15.y - (var7 - CombatInfoListHolder.baseY - CombatInfoListHolder.baseY) * 64;
               if(var8 != 0 || var9 != 0) {
                  var15.field897 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
               }
            }

            if((var5 & 16) != 0) {
               var15.graphic = var1.readUnsignedShort();
               var16 = var1.method3618();
               var15.field924 = var16 >> 16;
               var15.graphicsDelay = (var16 & 65535) + Client.gameCycle;
               var15.spotAnimFrame = 0;
               var15.spotAnimFrameCycle = 0;
               if(var15.graphicsDelay > Client.gameCycle) {
                  var15.spotAnimFrame = -1;
               }

               if(var15.graphic == 65535) {
                  var15.graphic = -1;
               }
            }

            if((var5 & 4) != 0) {
               var16 = var1.method3676();
               if(var16 == 65535) {
                  var16 = -1;
               }

               var7 = var1.method3597();
               if(var16 == var15.animation && var16 != -1) {
                  var8 = class137.getAnimation(var16).replyMode;
                  if(var8 == 1) {
                     var15.actionFrame = 0;
                     var15.actionFrameCycle = 0;
                     var15.actionAnimationDisable = var7;
                     var15.field919 = 0;
                  }

                  if(var8 == 2) {
                     var15.field919 = 0;
                  }
               } else if(var16 == -1 || var15.animation == -1 || class137.getAnimation(var16).forcedPriority >= class137.getAnimation(var15.animation).forcedPriority) {
                  var15.animation = var16;
                  var15.actionFrame = 0;
                  var15.actionFrameCycle = 0;
                  var15.actionAnimationDisable = var7;
                  var15.field919 = 0;
                  var15.field942 = var15.queueSize;
               }
            }

            if((var5 & 64) != 0) {
               var15.composition = class59.getNpcDefinition(var1.readUnsignedShort());
               var15.field885 = var15.composition.size;
               var15.field929 = var15.composition.rotation;
               var15.field890 = var15.composition.walkingAnimation;
               var15.field891 = var15.composition.rotate180Animation;
               var15.field882 = var15.composition.rotate90RightAnimation;
               var15.field893 = var15.composition.rotate90LeftAnimation;
               var15.idlePoseAnimation = var15.composition.standingAnimation;
               var15.field892 = var15.composition.field3509;
               var15.field889 = var15.composition.field3499;
            }

            if((var5 & 1) != 0) {
               var15.overhead = var1.readString();
               var15.overheadTextCyclesRemaining = 100;
            }
         }

         for(var14 = 0; var14 < Client.field713; ++var14) {
            var3 = Client.field714[var14];
            if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
               Client.cachedNPCs[var3].composition = null;
               Client.cachedNPCs[var3] = null;
            }
         }

         if(var1.offset != Client.field739.packetLength) {
            throw new RuntimeException(var1.offset + "," + Client.field739.packetLength);
         } else {
            for(var14 = 0; var14 < Client.npcIndexesCount; ++var14) {
               if(Client.cachedNPCs[Client.npcIndices[var14]] == null) {
                  throw new RuntimeException(var14 + "," + Client.npcIndexesCount);
               }
            }

         }
      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "([Lhl;IIIIIIII)V",
      garbageValue = "-59285692"
   )
   static final void method25(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.hasListener || AbstractSoundSystem.getWidgetClickMask(var9) != 0 || var9 == Client.field639 || var9.contentType == 1338) && var9.parentId == var1) {
            if(var9.hasScript) {
               boolean var10 = var9.isHidden;
               if(var10) {
                  continue;
               }
            }

            int var35 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var35;
               var17 = var11;
               int var18 = var35 + var9.width;
               int var19 = var11 + var9.height;
               if(var18 < var35) {
                  var16 = var18;
                  var18 = var35;
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
               var16 = var35 + var9.width;
               var17 = var11 + var9.height;
               var12 = var35 > var2?var35:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.draggedWidget) {
               Client.field860 = true;
               Client.field772 = var35;
               Client.field773 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.mouseLastX;
               var17 = MouseInput.mouseLastY;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var36 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field603 && !Client.isMenuOpen && var36) {
                     BuildType.method4609(var16, var17, var12, var13);
                  }
               } else {
                  int var20;
                  int var22;
                  int var23;
                  int var32;
                  if(var9.contentType == 1338) {
                     if((Client.field822 == 0 || Client.field822 == 3) && (MouseInput.mouseLastButton == 1 || !class8.middleMouseMovesCamera && MouseInput.mouseLastButton == 4)) {
                        class224 var40 = var9.method4561(true);
                        if(var40 != null) {
                           var20 = MouseInput.mouseLastPressedX - var35;
                           var32 = MouseInput.mouseLastPressedY - var11;
                           if(var40.method4459(var20, var32)) {
                              var20 -= var40.field2570 / 2;
                              var32 -= var40.field2575 / 2;
                              var22 = Client.mapAngle & 2047;
                              var23 = Graphics3D.SINE[var22];
                              int var34 = Graphics3D.COSINE[var22];
                              int var25 = var34 * var20 + var32 * var23 >> 11;
                              int var26 = var32 * var34 - var23 * var20 >> 11;
                              int var27 = var25 + MilliTimer.localPlayer.x >> 7;
                              int var28 = MilliTimer.localPlayer.y - var26 >> 7;
                              PacketNode var29 = DecorativeObject.method3115(ClientPacket.field2243, Client.field739.field1250);
                              var29.packetBuffer.putByte(18);
                              var29.packetBuffer.method3605(var27 + class178.baseX);
                              var29.packetBuffer.method3707(var28 + CombatInfoListHolder.baseY);
                              var29.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                              var29.packetBuffer.putByte(var20);
                              var29.packetBuffer.putByte(var32);
                              var29.packetBuffer.putShort(Client.mapAngle);
                              var29.packetBuffer.putByte(57);
                              var29.packetBuffer.putByte(0);
                              var29.packetBuffer.putByte(0);
                              var29.packetBuffer.putByte(89);
                              var29.packetBuffer.putShort(MilliTimer.localPlayer.x);
                              var29.packetBuffer.putShort(MilliTimer.localPlayer.y);
                              var29.packetBuffer.putByte(63);
                              Client.field739.method2019(var29);
                              Client.destinationX = var27;
                              Client.destinationY = var28;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        Preferences.renderOverview.method6162(MouseInput.mouseLastX, MouseInput.mouseLastY, var36, var35, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var36) {
                        if(var9.contentType == 1400) {
                           Preferences.renderOverview.method6216(var35, var11, var9.width, var9.height, var16, var17);
                        } else {
                           MouseInput.method1014(var9, var16 - var35, var17 - var11);
                        }
                     }

                     boolean var37;
                     if(var9.type == 0) {
                        if(!var9.hasScript) {
                           var37 = var9.isHidden;
                           if(var37 && var9 != class37.field329) {
                              continue;
                           }
                        }

                        method25(var0, var9.id, var12, var13, var14, var15, var35 - var9.scrollX, var11 - var9.scrollY);
                        if(var9.children != null) {
                           method25(var9.children, var9.id, var12, var13, var14, var15, var35 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var30 = (WidgetNode)Client.componentTable.get((long)var9.id);
                        if(var30 != null) {
                           if(var30.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen) {
                              for(ScriptEvent var31 = (ScriptEvent)Client.field755.getFront(); var31 != null; var31 = (ScriptEvent)Client.field755.getNext()) {
                                 if(var31.boolean1) {
                                    var31.unlink();
                                    var31.source.field2749 = false;
                                 }
                              }

                              if(DecorativeObject.field1860 == 0) {
                                 Client.draggedWidget = null;
                                 Client.field639 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Actor.method1597();
                              }
                           }

                           var20 = var30.id;
                           if(GameCanvas.loadWidget(var20)) {
                              method25(Widget.widgets[var20], -1, var12, var13, var14, var15, var35, var11);
                           }
                        }
                     }

                     if(var9.hasScript) {
                        ScriptEvent var39;
                        if(!var9.noClickThrough) {
                           if(var9.noScrollThrough && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                              for(var39 = (ScriptEvent)Client.field755.getFront(); var39 != null; var39 = (ScriptEvent)Client.field755.getNext()) {
                                 if(var39.boolean1 && var39.source.onScrollWheelListener == var39.params) {
                                    var39.unlink();
                                 }
                              }
                           }
                        } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var39 = (ScriptEvent)Client.field755.getFront(); var39 != null; var39 = (ScriptEvent)Client.field755.getNext()) {
                              if(var39.boolean1) {
                                 var39.unlink();
                                 var39.source.field2749 = false;
                              }
                           }

                           if(DecorativeObject.field1860 == 0) {
                              Client.draggedWidget = null;
                              Client.field639 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Actor.method1597();
                           }
                        }

                        if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           var36 = true;
                        } else {
                           var36 = false;
                        }

                        var37 = false;
                        if((MouseInput.mouseCurrentButton == 1 || !class8.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var36) {
                           var37 = true;
                        }

                        boolean var38 = false;
                        if((MouseInput.mouseLastButton == 1 || !class8.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                           var38 = true;
                        }

                        if(var38) {
                           class35.method685(var9, MouseInput.mouseLastPressedX - var35, MouseInput.mouseLastPressedY - var11);
                        }

                        if(var9.contentType == 1400) {
                           Preferences.renderOverview.method6051(var16, var17, var36 & var37, var36 & var38);
                        }

                        if(Client.draggedWidget != null && var9 != Client.draggedWidget && var36 && DecorativeObject.method3114(AbstractSoundSystem.getWidgetClickMask(var9))) {
                           Client.draggedOnWidget = var9;
                        }

                        if(var9 == Client.field639) {
                           Client.field594 = true;
                           Client.field769 = var35;
                           Client.field770 = var11;
                        }

                        if(var9.hasListener) {
                           ScriptEvent var21;
                           if(var36 && Client.mouseWheelRotation != 0 && var9.onScrollWheelListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.source = var9;
                              var21.mouseY = Client.mouseWheelRotation;
                              var21.params = var9.onScrollWheelListener;
                              Client.field755.addFront(var21);
                           }

                           if(Client.draggedWidget != null || class49.field442 != null || Client.isMenuOpen) {
                              var38 = false;
                              var37 = false;
                              var36 = false;
                           }

                           if(!var9.field2682 && var38) {
                              var9.field2682 = true;
                              if(var9.onClickListener != null) {
                                 var21 = new ScriptEvent();
                                 var21.boolean1 = true;
                                 var21.source = var9;
                                 var21.mouseX = MouseInput.mouseLastPressedX - var35;
                                 var21.mouseY = MouseInput.mouseLastPressedY - var11;
                                 var21.params = var9.onClickListener;
                                 Client.field755.addFront(var21);
                              }
                           }

                           if(var9.field2682 && var37 && var9.onClickRepeatListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.source = var9;
                              var21.mouseX = MouseInput.mouseLastX - var35;
                              var21.mouseY = MouseInput.mouseLastY - var11;
                              var21.params = var9.onClickRepeatListener;
                              Client.field755.addFront(var21);
                           }

                           if(var9.field2682 && !var37) {
                              var9.field2682 = false;
                              if(var9.onReleaseListener != null) {
                                 var21 = new ScriptEvent();
                                 var21.boolean1 = true;
                                 var21.source = var9;
                                 var21.mouseX = MouseInput.mouseLastX - var35;
                                 var21.mouseY = MouseInput.mouseLastY - var11;
                                 var21.params = var9.onReleaseListener;
                                 Client.field791.addFront(var21);
                              }
                           }

                           if(var37 && var9.onHoldListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.source = var9;
                              var21.mouseX = MouseInput.mouseLastX - var35;
                              var21.mouseY = MouseInput.mouseLastY - var11;
                              var21.params = var9.onHoldListener;
                              Client.field755.addFront(var21);
                           }

                           if(!var9.field2749 && var36) {
                              var9.field2749 = true;
                              if(var9.onMouseOverListener != null) {
                                 var21 = new ScriptEvent();
                                 var21.boolean1 = true;
                                 var21.source = var9;
                                 var21.mouseX = MouseInput.mouseLastX - var35;
                                 var21.mouseY = MouseInput.mouseLastY - var11;
                                 var21.params = var9.onMouseOverListener;
                                 Client.field755.addFront(var21);
                              }
                           }

                           if(var9.field2749 && var36 && var9.onMouseRepeatListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.source = var9;
                              var21.mouseX = MouseInput.mouseLastX - var35;
                              var21.mouseY = MouseInput.mouseLastY - var11;
                              var21.params = var9.onMouseRepeatListener;
                              Client.field755.addFront(var21);
                           }

                           if(var9.field2749 && !var36) {
                              var9.field2749 = false;
                              if(var9.onMouseLeaveListener != null) {
                                 var21 = new ScriptEvent();
                                 var21.boolean1 = true;
                                 var21.source = var9;
                                 var21.mouseX = MouseInput.mouseLastX - var35;
                                 var21.mouseY = MouseInput.mouseLastY - var11;
                                 var21.params = var9.onMouseLeaveListener;
                                 Client.field791.addFront(var21);
                              }
                           }

                           if(var9.onTimerListener != null) {
                              var21 = new ScriptEvent();
                              var21.source = var9;
                              var21.params = var9.onTimerListener;
                              Client.field790.addFront(var21);
                           }

                           ScriptEvent var24;
                           if(var9.onVarTransmitListener != null && Client.pendingVarbitCount > var9.field2752) {
                              if(var9.varTransmitTriggers != null && Client.pendingVarbitCount - var9.field2752 <= 32) {
                                 label796:
                                 for(var32 = var9.field2752; var32 < Client.pendingVarbitCount; ++var32) {
                                    var22 = Client.pendingVarbitChanges[var32 & 31];

                                    for(var23 = 0; var23 < var9.varTransmitTriggers.length; ++var23) {
                                       if(var22 == var9.varTransmitTriggers[var23]) {
                                          var24 = new ScriptEvent();
                                          var24.source = var9;
                                          var24.params = var9.onVarTransmitListener;
                                          Client.field755.addFront(var24);
                                          break label796;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new ScriptEvent();
                                 var21.source = var9;
                                 var21.params = var9.onVarTransmitListener;
                                 Client.field755.addFront(var21);
                              }

                              var9.field2752 = Client.pendingVarbitCount;
                           }

                           if(var9.onInvTransmitListener != null && Client.field779 > var9.field2753) {
                              if(var9.invTransmitTriggers != null && Client.field779 - var9.field2753 <= 32) {
                                 label772:
                                 for(var32 = var9.field2753; var32 < Client.field779; ++var32) {
                                    var22 = Client.interfaceItemTriggers[var32 & 31];

                                    for(var23 = 0; var23 < var9.invTransmitTriggers.length; ++var23) {
                                       if(var22 == var9.invTransmitTriggers[var23]) {
                                          var24 = new ScriptEvent();
                                          var24.source = var9;
                                          var24.params = var9.onInvTransmitListener;
                                          Client.field755.addFront(var24);
                                          break label772;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new ScriptEvent();
                                 var21.source = var9;
                                 var21.params = var9.onInvTransmitListener;
                                 Client.field755.addFront(var21);
                              }

                              var9.field2753 = Client.field779;
                           }

                           if(var9.onStatTransmitListener != null && Client.changedSkillsCount > var9.field2725) {
                              if(var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2725 <= 32) {
                                 label748:
                                 for(var32 = var9.field2725; var32 < Client.changedSkillsCount; ++var32) {
                                    var22 = Client.changedSkills[var32 & 31];

                                    for(var23 = 0; var23 < var9.statTransmitTriggers.length; ++var23) {
                                       if(var22 == var9.statTransmitTriggers[var23]) {
                                          var24 = new ScriptEvent();
                                          var24.source = var9;
                                          var24.params = var9.onStatTransmitListener;
                                          Client.field755.addFront(var24);
                                          break label748;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new ScriptEvent();
                                 var21.source = var9;
                                 var21.params = var9.onStatTransmitListener;
                                 Client.field755.addFront(var21);
                              }

                              var9.field2725 = Client.changedSkillsCount;
                           }

                           if(Client.chatCycle > var9.field2733 && var9.onChatTransmitListener != null) {
                              var21 = new ScriptEvent();
                              var21.source = var9;
                              var21.params = var9.onChatTransmitListener;
                              Client.field755.addFront(var21);
                           }

                           if(Client.field742 > var9.field2733 && var9.onFriendTransmitListener != null) {
                              var21 = new ScriptEvent();
                              var21.source = var9;
                              var21.params = var9.onFriendTransmitListener;
                              Client.field755.addFront(var21);
                           }

                           if(Client.field784 > var9.field2733 && var9.onClanTransmitListener != null) {
                              var21 = new ScriptEvent();
                              var21.source = var9;
                              var21.params = var9.onClanTransmitListener;
                              Client.field755.addFront(var21);
                           }

                           if(Client.field785 > var9.field2733 && var9.onStockTransmitListener != null) {
                              var21 = new ScriptEvent();
                              var21.source = var9;
                              var21.params = var9.onStockTransmitListener;
                              Client.field755.addFront(var21);
                           }

                           if(Client.field789 > var9.field2733 && var9.onCamFinishedListener != null) {
                              var21 = new ScriptEvent();
                              var21.source = var9;
                              var21.params = var9.onCamFinishedListener;
                              Client.field755.addFront(var21);
                           }

                           if(Client.field787 > var9.field2733 && var9.onMiscTransmitListener != null) {
                              var21 = new ScriptEvent();
                              var21.source = var9;
                              var21.params = var9.onMiscTransmitListener;
                              Client.field755.addFront(var21);
                           }

                           var9.field2733 = Client.cycleCntr;
                           if(var9.onKeyListener != null) {
                              for(var32 = 0; var32 < Client.field845; ++var32) {
                                 ScriptEvent var33 = new ScriptEvent();
                                 var33.source = var9;
                                 var33.typedKeyCode = Client.field865[var32];
                                 var33.typedKeyChar = Client.field812[var32];
                                 var33.params = var9.onKeyListener;
                                 Client.field755.addFront(var33);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && Client.draggedWidget == null && class49.field442 == null && !Client.isMenuOpen) {
                        if((var9.field2739 >= 0 || var9.field2650 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           if(var9.field2739 >= 0) {
                              class37.field329 = var0[var9.field2739];
                           } else {
                              class37.field329 = var9;
                           }
                        }

                        if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           class7.field42 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           FileSystem.method4618(var9, var35 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.mouseLastX, MouseInput.mouseLastY);
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
