import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("u")
   static int[] field300;
   @ObfuscatedName("fi")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("d")
   @Export("progress")
   byte progress;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1503472637
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 365532737
   )
   @Export("price")
   public int price;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1193573597
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -615003827
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1945748161
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfr;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-820037752"
   )
   @Export("status")
   public int status() {
      return this.progress & 7;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "26162"
   )
   @Export("type")
   public int type() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1414391986"
   )
   void method111(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method112(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "120"
   )
   static int method119(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class87.getWidget(class82.intStack[--GrandExchangeEvents.intStackSize]);
      } else {
         var3 = var2?class54.field636:class82.field1265;
      }

      class40.method556(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class82.intStack[--GrandExchangeEvents.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class181.localPlayer.composition.method4141();
            return 1;
         } else {
            return 2;
         }
      } else {
         GrandExchangeEvents.intStackSize -= 2;
         int var4 = class82.intStack[GrandExchangeEvents.intStackSize];
         int var5 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = WorldMapType2.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2773 = var6.offsetX2d;
         var3.field2774 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2782 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2782 = 1;
         } else {
            var3.field2782 = 2;
         }

         if(var3.field2779 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2779;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "24"
   )
   public static boolean method116() {
      return class210.field2598 != 0?true:class210.field2595.method3948();
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "163269538"
   )
   static final void method132(Widget var0, int var1, int var2) {
      if(Client.field1088 == 0 || Client.field1088 == 3) {
         if(MouseInput.mouseLastButton == 1 || !Client.field956 && MouseInput.mouseLastButton == 4) {
            class217 var3 = var0.method4181(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4095(var4, var5)) {
               var4 -= var3.field2683 / 2;
               var5 -= var3.field2682 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var5 * var7 + var4 * var8 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = var9 + class181.localPlayer.x >> 7;
               int var12 = class181.localPlayer.y - var10 >> 7;
               PacketNode var13 = class218.method4105(ClientPacket.field2360, Client.field916.field1470);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.putShort(var11 + IndexDataBase.baseX);
               var13.packetBuffer.putShortLE(var12 + Occluder.baseY);
               var13.packetBuffer.putByte(KeyFocusListener.field606[82]?(KeyFocusListener.field606[81]?2:1):0);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(class181.localPlayer.x);
               var13.packetBuffer.putShort(class181.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field916.method1925(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1559293962"
   )
   static final void method117(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         AbstractByteBuffer.crossSprites[Client.field963 / 100].drawAt(Client.field1064 - 8, Client.field962 - 8);
      }

      if(Client.cursorState == 2) {
         AbstractByteBuffer.crossSprites[Client.field963 / 100 + 4].drawAt(Client.field1064 - 8, Client.field962 - 8);
      }

      Varcs.method1881();
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1174639354"
   )
   static final void method118() {
      PacketBuffer var0 = Client.field916.packetBuffer;
      var0.bitAccess();
      int var1 = var0.getBits(8);
      int var2;
      if(var1 < Client.npcIndexesCount) {
         for(var2 = var1; var2 < Client.npcIndexesCount; ++var2) {
            Client.field978[++Client.field932 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = var0.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
               var4.npcCycle = Client.gameCycle;
            } else {
               int var6 = var0.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                  var4.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1742(var7, (byte)1);
                     var8 = var0.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1742(var7, (byte)2);
                     var8 = var0.getBits(3);
                     var4.method1742(var8, (byte)2);
                     int var9 = var0.getBits(1);
                     if(var9 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field978[++Client.field932 - 1] = var3;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Ljd;IIII)V",
      garbageValue = "1570646061"
   )
   static final void method135(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3627) {
               if(!var0.field3648 || Client.field1082 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = class181.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = ISAACCipher.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = ISAACCipher.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = ISAACCipher.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = ISAACCipher.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = ISAACCipher.getColTags(65280);
                     } else if(var9 > 6) {
                        var6 = ISAACCipher.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = ISAACCipher.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = ISAACCipher.getColTags(12648192);
                     } else {
                        var6 = ISAACCipher.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3648 && Client.field1060) {
                     RSCanvas.addMenuEntry("Examine", ISAACCipher.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     RSCanvas.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + ISAACCipher.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class156.field2161 & 2) == 2) {
                        RSCanvas.addMenuEntry(Client.lastSelectedSpellActionName, Client.lastSelectedSpellName + " " + "->" + " " + ISAACCipher.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3648 && Client.field1060?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.numberMenuOptions) {
                        var11 = GroundObject.prependIndices(var11);
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var10 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var10 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var10 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var10 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var10 + 13;
                              }

                              RSCanvas.addMenuEntry(var11[var7], ISAACCipher.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.npcAttackOption != AttackOption.AttackOption_hidden) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > class181.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 RSCanvas.addMenuEntry(var11[var7], ISAACCipher.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3648 || !Client.field1060) {
                        RSCanvas.addMenuEntry("Examine", ISAACCipher.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "([Lhx;II)V",
      garbageValue = "-1667220074"
   )
   static final void method130(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method130(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  GrandExchangeEvent.method88(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2831 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.field2831;
               GrandExchangeEvent.method95(var5);
            }

            if(var1 == 1 && var3.field2861 != null) {
               if(var3.index >= 0) {
                  Widget var6 = class87.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.field2861;
               GrandExchangeEvent.method95(var5);
            }
         }
      }

   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "8"
   )
   static final void method131(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field976 == 1) && Client.ignoreCount < 400) {
            String var2 = GraphicsObject.cleanUsername(var0, class236.jagexLoginType);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = GraphicsObject.cleanUsername(var4.name, class236.jagexLoginType);
                  if(var5 != null && var5.equals(var2)) {
                     class54.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = GraphicsObject.cleanUsername(var4.previousName, class236.jagexLoginType);
                     if(var6 != null && var6.equals(var2)) {
                        class54.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var8 = Client.friends[var3];
                  var5 = GraphicsObject.cleanUsername(var8.name, class236.jagexLoginType);
                  if(var5 != null && var5.equals(var2)) {
                     class54.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var8.previousName != null) {
                     var6 = GraphicsObject.cleanUsername(var8.previousName, class236.jagexLoginType);
                     if(var6 != null && var6.equals(var2)) {
                        class54.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(GraphicsObject.cleanUsername(class181.localPlayer.name, class236.jagexLoginType).equals(var2)) {
                  class54.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  PacketNode var7 = class218.method4105(ClientPacket.field2305, Client.field916.field1470);
                  var7.packetBuffer.putByte(AbstractSoundSystem.getLength(var0));
                  var7.packetBuffer.putString(var0);
                  Client.field916.method1925(var7);
               }
            }
         } else {
            class54.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
