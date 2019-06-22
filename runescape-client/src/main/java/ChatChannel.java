import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("ChatChannel")
public class ChatChannel {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lbm;"
   )
   @Export("messages")
   Message[] messages;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 612486877
   )
   @Export("count")
   int count;

   ChatChannel() {
      this.messages = new Message[100];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbm;",
      garbageValue = "463993373"
   )
   @Export("addMessage")
   Message addMessage(int var1, String var2, String var3, String var4) {
      Message var5 = this.messages[99];

      for(int var6 = this.count; var6 > 0; --var6) {
         if(var6 != 100) {
            this.messages[var6] = this.messages[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new Message(var1, var2, var4, var3);
      } else {
         var5.remove();
         var5.removeDual();
         var5.set(var1, var2, var4, var3);
      }

      this.messages[0] = var5;
      if(this.count < 100) {
         ++this.count;
      }

      return var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lbm;",
      garbageValue = "-195254780"
   )
   @Export("getMessage")
   Message getMessage(int var1) {
      return var1 >= 0 && var1 < this.count?this.messages[var1]:null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1274923506"
   )
   @Export("size")
   int size() {
      return this.count;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1857344803"
   )
   public static boolean method2238(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(Lbz;I)V",
      garbageValue = "911583338"
   )
   static final void method2225(Actor var0) {
      var0.__ay = false;
      SequenceDefinition var1;
      if(var0.movementSequence != -1) {
         var1 = WorldMapAreaData.getSequenceDefinition(var0.movementSequence);
         if(var1 != null && var1.frameIds != null) {
            ++var0.movementFrameCycle;
            if(var0.movementFrame < var1.frameIds.length && var0.movementFrameCycle > var1.frameLengths[var0.movementFrame]) {
               var0.movementFrameCycle = 1;
               ++var0.movementFrame;
               Script.method2201(var1, var0.movementFrame, var0.x, var0.y);
            }

            if(var0.movementFrame >= var1.frameIds.length) {
               var0.movementFrameCycle = 0;
               var0.movementFrame = 0;
               Script.method2201(var1, var0.movementFrame, var0.x, var0.y);
            }
         } else {
            var0.movementSequence = -1;
         }
      }

      if(var0.spotAnimation != -1 && Client.cycle >= var0.__bt) {
         if(var0.spotAnimationFrame < 0) {
            var0.spotAnimationFrame = 0;
         }

         int var2 = class50.getSpotAnimationDefinition(var0.spotAnimation).sequence;
         if(var2 != -1) {
            SequenceDefinition var3 = WorldMapAreaData.getSequenceDefinition(var2);
            if(var3 != null && var3.frameIds != null) {
               ++var0.spotAnimationFrameCycle;
               if(var0.spotAnimationFrame < var3.frameIds.length && var0.spotAnimationFrameCycle > var3.frameLengths[var0.spotAnimationFrame]) {
                  var0.spotAnimationFrameCycle = 1;
                  ++var0.spotAnimationFrame;
                  Script.method2201(var3, var0.spotAnimationFrame, var0.x, var0.y);
               }

               if(var0.spotAnimationFrame >= var3.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var3.frameIds.length)) {
                  var0.spotAnimation = -1;
               }
            } else {
               var0.spotAnimation = -1;
            }
         } else {
            var0.spotAnimation = -1;
         }
      }

      if(var0.sequence != -1 && var0.sequenceDelay <= 1) {
         var1 = WorldMapAreaData.getSequenceDefinition(var0.sequence);
         if(var1.__j == 1 && var0.__ch > 0 && var0.__bw <= Client.cycle && var0.__cr < Client.cycle) {
            var0.sequenceDelay = 1;
            return;
         }
      }

      if(var0.sequence != -1 && var0.sequenceDelay == 0) {
         var1 = WorldMapAreaData.getSequenceDefinition(var0.sequence);
         if(var1 != null && var1.frameIds != null) {
            ++var0.sequenceFrameCycle;
            if(var0.sequenceFrame < var1.frameIds.length && var0.sequenceFrameCycle > var1.frameLengths[var0.sequenceFrame]) {
               var0.sequenceFrameCycle = 1;
               ++var0.sequenceFrame;
               Script.method2201(var1, var0.sequenceFrame, var0.x, var0.y);
            }

            if(var0.sequenceFrame >= var1.frameIds.length) {
               var0.sequenceFrame -= var1.frameCount;
               ++var0.__bj;
               if(var0.__bj >= var1.__z) {
                  var0.sequence = -1;
               } else if(var0.sequenceFrame >= 0 && var0.sequenceFrame < var1.frameIds.length) {
                  Script.method2201(var1, var0.sequenceFrame, var0.x, var0.y);
               } else {
                  var0.sequence = -1;
               }
            }

            var0.__ay = var1.__k;
         } else {
            var0.sequence = -1;
         }
      }

      if(var0.sequenceDelay > 0) {
         --var0.sequenceDelay;
      }

   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Lho;IIB)V",
      garbageValue = "94"
   )
   static final void method2237(Widget var0, int var1, int var2) {
      if(var0.buttonType == 1) {
         Tiles.method1106(var0.buttonText, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.buttonType == 2 && !Client.isSpellSelected) {
         var3 = class198.method3745(var0);
         if(var3 != null) {
            Tiles.method1106(var3, BufferedFile.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.buttonType == 3) {
         Tiles.method1106("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.buttonType == 4) {
         Tiles.method1106(var0.buttonText, "", 28, 0, 0, var0.id);
      }

      if(var0.buttonType == 5) {
         Tiles.method1106(var0.buttonText, "", 29, 0, 0, var0.id);
      }

      if(var0.buttonType == 6 && Client.__client_mo == null) {
         Tiles.method1106(var0.buttonText, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var6;
      if(var0.type == 2) {
         var6 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var7 = (var0.paddingX + 32) * var5;
               int var8 = (var0.paddingY + 32) * var4;
               if(var6 < 20) {
                  var7 += var0.inventoryXOffsets[var6];
                  var8 += var0.inventoryYOffsets[var6];
               }

               if(var1 >= var7 && var2 >= var8 && var1 < var7 + 32 && var2 < var8 + 32) {
                  Client.dragItemSlotDestination = var6;
                  UserComparator6.__fg_jh = var0;
                  if(var0.itemIds[var6] > 0) {
                     ItemDefinition var9 = Skills.getItemDefinition(var0.itemIds[var6] - 1);
                     if(Client.isItemSelected == 1 && WorldMapAreaData.method708(class1.getWidgetClickMask(var0))) {
                        if(var0.id != ServerPacket.selectedItemWidget || var6 != HealthBarDefinition.selectedItemSlot) {
                           Tiles.method1106("Use", Client.selectedItemName + " -> " + BufferedFile.colorStartTag(16748608) + var9.name, 31, var9.id, var6, var0.id);
                        }
                     } else if(Client.isSpellSelected && WorldMapAreaData.method708(class1.getWidgetClickMask(var0))) {
                        if((FloorDecoration.selectedSpellFlags & 16) == 16) {
                           Tiles.method1106(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + BufferedFile.colorStartTag(16748608) + var9.name, 32, var9.id, var6, var0.id);
                        }
                     } else {
                        String[] var10 = var9.inventoryActions;
                        int var11 = -1;
                        if(Client.shiftClickDrop && WorldMapEvent.method779()) {
                           var11 = var9.getShiftClickIndex();
                        }

                        int var12;
                        if(WorldMapAreaData.method708(class1.getWidgetClickMask(var0))) {
                           for(var12 = 4; var12 >= 3; --var12) {
                              if(var11 != var12) {
                                 AccessFile.method2726(var0, var9, var6, var12, false);
                              }
                           }
                        }

                        if(SecureRandomFuture.method2101(class1.getWidgetClickMask(var0))) {
                           Tiles.method1106("Use", BufferedFile.colorStartTag(16748608) + var9.name, 38, var9.id, var6, var0.id);
                        }

                        if(WorldMapAreaData.method708(class1.getWidgetClickMask(var0))) {
                           for(var12 = 2; var12 >= 0; --var12) {
                              if(var12 != var11) {
                                 AccessFile.method2726(var0, var9, var6, var12, false);
                              }
                           }

                           if(var11 >= 0) {
                              AccessFile.method2726(var0, var9, var6, var11, true);
                           }
                        }

                        var10 = var0.itemActions;
                        if(var10 != null) {
                           for(var12 = 4; var12 >= 0; --var12) {
                              if(var10[var12] != null) {
                                 byte var13 = 0;
                                 if(var12 == 0) {
                                    var13 = 39;
                                 }

                                 if(var12 == 1) {
                                    var13 = 40;
                                 }

                                 if(var12 == 2) {
                                    var13 = 41;
                                 }

                                 if(var12 == 3) {
                                    var13 = 42;
                                 }

                                 if(var12 == 4) {
                                    var13 = 43;
                                 }

                                 Tiles.method1106(var10[var12], BufferedFile.colorStartTag(16748608) + var9.name, var13, var9.id, var6, var0.id);
                              }
                           }
                        }

                        Tiles.method1106("Examine", BufferedFile.colorStartTag(16748608) + var9.name, 1005, var9.id, var6, var0.id);
                     }
                  }
               }

               ++var6;
            }
         }
      }

      if(var0.isIf3) {
         if(Client.isSpellSelected) {
            if(WorldComparator.method58(class1.getWidgetClickMask(var0)) && (FloorDecoration.selectedSpellFlags & 32) == 32) {
               Tiles.method1106(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + var0.dataText, 58, 0, var0.childIndex, var0.id);
            }
         } else {
            String var14;
            for(var6 = 9; var6 >= 5; --var6) {
               var14 = GameShell.method1060(var0, var6);
               if(var14 != null) {
                  Tiles.method1106(var14, var0.dataText, 1007, var6 + 1, var0.childIndex, var0.id);
               }
            }

            var3 = class198.method3745(var0);
            if(var3 != null) {
               Tiles.method1106(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               var14 = GameShell.method1060(var0, var4);
               if(var14 != null) {
                  class16.insertMenuItem(var14, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.__fz);
               }
            }

            var5 = class1.getWidgetClickMask(var0);
            boolean var15 = (var5 & 1) != 0;
            if(var15) {
               Tiles.method1106("Continue", "", 30, 0, var0.childIndex, var0.id);
            }
         }
      }

   }
}
