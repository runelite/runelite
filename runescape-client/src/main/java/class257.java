import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("iy")
public enum class257 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3549(0, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3544(1, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3546(2, 2);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -350945325
   )
   public final int field3547;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1561767397
   )
   final int field3548;

   class257(int var3, int var4) {
      this.field3547 = var3;
      this.field3548 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field3548;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "9"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 1) {
         Client.field1019 = var6;
         Client.field1020 = var7;
         Client.cursorState = 2;
         Client.field1171 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_OBSTACLE);
         Client.secretPacketBuffer1.method3263(KeyFocusListener.field655[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3365(Friend.field819);
         Client.secretPacketBuffer1.putShort(Varcs.baseY + var1);
         Client.secretPacketBuffer1.putShort(var0 + WallObject.baseX);
         Client.secretPacketBuffer1.method3270(class39.selectedItemIndex);
         Client.secretPacketBuffer1.method3282(class25.field371);
      } else if(var2 == 2) {
         Client.field1019 = var6;
         Client.field1020 = var7;
         Client.cursorState = 2;
         Client.field1171 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_189);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + WallObject.baseX);
            Client.secretPacketBuffer1.runeliteWriteInt(class25.field372);
            Client.secretPacketBuffer1.runeliteWriteInt(Client.field1069);
            Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
         } else {
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3270(var0 + WallObject.baseX);
            Client.secretPacketBuffer1.method3279(class25.field372);
            Client.secretPacketBuffer1.method3270(Client.field1069);
            Client.secretPacketBuffer1.method3270(Varcs.baseY + var1);
         }

         Client.secretPacketBuffer1.method3263(KeyFocusListener.field655[82]?1:0);
      } else if(var2 == 3) {
         Client.field1019 = var6;
         Client.field1020 = var7;
         Client.cursorState = 2;
         Client.field1171 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIRST_OBSTACLE_ACTION);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + WallObject.baseX);
         } else {
            Client.secretPacketBuffer1.method3270(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3365(var0 + WallObject.baseX);
         }

         Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
         Client.secretPacketBuffer1.method3270(Varcs.baseY + var1);
      } else if(var2 == 4) {
         Client.field1019 = var6;
         Client.field1020 = var7;
         Client.cursorState = 2;
         Client.field1171 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SECOND_OBSTACLE_ACTION);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
         } else {
            Client.secretPacketBuffer1.putShortLE(Varcs.baseY + var1);
         }

         Client.secretPacketBuffer1.method3263(KeyFocusListener.field655[82]?1:0);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3365(var0 + WallObject.baseX);
      } else if(var2 == 5) {
         Client.field1019 = var6;
         Client.field1020 = var7;
         Client.cursorState = 2;
         Client.field1171 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_THIRD_OBSTACLE_ACTION);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
            Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
         } else {
            Client.secretPacketBuffer1.method3365(Varcs.baseY + var1);
            Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
         }

         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var0 + WallObject.baseX);
      } else if(var2 == 6) {
         Client.field1019 = var6;
         Client.field1020 = var7;
         Client.cursorState = 2;
         Client.field1171 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_167);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + WallObject.baseX);
         } else {
            Client.secretPacketBuffer1.method3365(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3365(Varcs.baseY + var1);
            Client.secretPacketBuffer1.putShortLE(var0 + WallObject.baseX);
         }

         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
      } else {
         NPC var8;
         if(var2 == 7) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_MOB);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(class25.field371);
               } else {
                  Client.secretPacketBuffer1.method3279(class25.field371);
               }

               Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3365(Friend.field819);
               Client.secretPacketBuffer1.method3365(class39.selectedItemIndex);
            }
         } else if(var2 == 8) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_MOB);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.method3365(var3);
               Client.secretPacketBuffer1.method3365(Client.field1069);
               Client.secretPacketBuffer1.method3280(class25.field372);
            }
         } else if(var2 == 9) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIRST_MOB_ACTION);
               Client.secretPacketBuffer1.method3261(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.method3365(var3);
            }
         } else if(var2 == 10) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ATTACK_NPC);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  Client.secretPacketBuffer1.putShort(var3);
               }

               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
            }
         } else if(var2 == 11) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_THIRD_MOB_ACTION);
               Client.secretPacketBuffer1.method3263(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.method3365(var3);
            }
         } else if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FOURTH_MOB_ACTION);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  Client.secretPacketBuffer1.method3365(var3);
               }

               Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
            }
         } else if(var2 == 13) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIFTH_MOB_ACTION);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.method3365(var3);
            }
         } else {
            Player var15;
            if(var2 == 14) {
               var15 = Client.cachedPlayers[var3];
               if(var15 != null) {
                  Client.field1019 = var6;
                  Client.field1020 = var7;
                  Client.cursorState = 2;
                  Client.field1171 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_PLAYER);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(class39.selectedItemIndex);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                     Client.secretPacketBuffer1.runeliteWriteInt(class25.field371);
                  } else {
                     Client.secretPacketBuffer1.putShort(class39.selectedItemIndex);
                     Client.secretPacketBuffer1.putShort(var3);
                     Client.secretPacketBuffer1.method3279(class25.field371);
                  }

                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
                  Client.secretPacketBuffer1.method3365(Friend.field819);
               }
            } else if(var2 == 15) {
               var15 = Client.cachedPlayers[var3];
               if(var15 != null) {
                  Client.field1019 = var6;
                  Client.field1020 = var7;
                  Client.cursorState = 2;
                  Client.field1171 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_PLAYER);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(Client.field1069);
                     Client.secretPacketBuffer1.runeliteWriteInt(class25.field372);
                  } else {
                     Client.secretPacketBuffer1.putShortLE(Client.field1069);
                     Client.secretPacketBuffer1.putInt(class25.field372);
                  }

                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
                  Client.secretPacketBuffer1.method3365(var3);
               }
            } else if(var2 == 16) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_1);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  Client.secretPacketBuffer1.runeliteWriteInt(class25.field371);
                  Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + WallObject.baseX);
               } else {
                  Client.secretPacketBuffer1.method3270(var3);
                  Client.secretPacketBuffer1.method3279(class25.field371);
                  Client.secretPacketBuffer1.putShortLE(Varcs.baseY + var1);
                  Client.secretPacketBuffer1.method3365(var0 + WallObject.baseX);
               }

               Client.secretPacketBuffer1.method3263(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.putShort(class39.selectedItemIndex);
               Client.secretPacketBuffer1.putShort(Friend.field819);
            } else if(var2 == 17) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_FLOORITEM);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
                  Client.secretPacketBuffer1.runeliteWriteInt(Client.field1069);
                  Client.secretPacketBuffer1.runeliteWriteInt(class25.field372);
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + WallObject.baseX);
               } else {
                  Client.secretPacketBuffer1.putShortLE(Varcs.baseY + var1);
                  Client.secretPacketBuffer1.method3365(Client.field1069);
                  Client.secretPacketBuffer1.putInt(class25.field372);
                  Client.secretPacketBuffer1.putShort(var0 + WallObject.baseX);
               }

               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.method3365(var3);
            } else if(var2 == 18) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_21);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + WallObject.baseX);
               } else {
                  Client.secretPacketBuffer1.method3270(var0 + WallObject.baseX);
               }

               Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3365(Varcs.baseY + var1);
            } else if(var2 == 19) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_11);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
               } else {
                  Client.secretPacketBuffer1.putShort(Varcs.baseY + var1);
               }

               Client.secretPacketBuffer1.method3263(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.method3365(var3);
               Client.secretPacketBuffer1.method3270(var0 + WallObject.baseX);
            } else if(var2 == 20) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TAKE_ITEM);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + WallObject.baseX);
               } else {
                  Client.secretPacketBuffer1.method3270(Varcs.baseY + var1);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.method3270(var0 + WallObject.baseX);
               }

               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
            } else if(var2 == 21) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_193);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
               } else {
                  Client.secretPacketBuffer1.method3365(var3);
                  Client.secretPacketBuffer1.putShortLE(Varcs.baseY + var1);
               }

               Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.method3270(var0 + WallObject.baseX);
            } else if(var2 == 22) {
               Client.field1019 = var6;
               Client.field1020 = var7;
               Client.cursorState = 2;
               Client.field1171 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_205);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  Client.secretPacketBuffer1.putShortLE(var3);
               }

               Client.secretPacketBuffer1.method3261(KeyFocusListener.field655[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(Varcs.baseY + var1);
               Client.secretPacketBuffer1.putShortLE(var0 + WallObject.baseX);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class8.region.method2916();
               } else {
                  class8.region.method2794(class5.plane, var0, var1, true);
               }
            } else {
               Widget var16;
               if(var2 == 24) {
                  var16 = PacketBuffer.method3528(var1);
                  boolean var9 = true;
                  if(var16.contentType > 0) {
                     var9 = class276.method5021(var16);
                  }

                  if(var9) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                     if(Client.RUNELITE_PACKET) {
                        Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     } else {
                        Client.secretPacketBuffer1.putInt(var1);
                     }
                  }
               } else {
                  if(var2 == 25) {
                     var16 = class5.method18(var1, var0);
                     if(var16 != null) {
                        class89.method1783();
                        Ignore.method1146(var1, var0, class1.method2(class244.getWidgetConfig(var16)), var16.itemId);
                        Client.itemSelectionState = 0;
                        Client.field1071 = class34.method483(var16);
                        if(Client.field1071 == null) {
                           Client.field1071 = "Null";
                        }

                        if(var16.hasScript) {
                           Client.field948 = var16.name + class60.getColTags(16777215);
                        } else {
                           Client.field948 = class60.getColTags('\uff00') + var16.field2774 + class60.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     IndexData.method4316();
                  } else {
                     int var14;
                     Widget var10000;
                     if(var2 == 28) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           var10000 = PacketBuffer.method3528(var1);
                        } else {
                           Client.secretPacketBuffer1.putInt(var1);
                           var10000 = PacketBuffer.method3528(var1);
                        }

                        var16 = var10000;
                        if(var16.dynamicValues != null && var16.dynamicValues[0][0] == 5) {
                           var14 = var16.dynamicValues[0][1];
                           class211.widgetSettings[var14] = 1 - class211.widgetSettings[var14];
                           WidgetNode.method1139(var14);
                        }
                     } else if(var2 == 29) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           var10000 = PacketBuffer.method3528(var1);
                        } else {
                           Client.secretPacketBuffer1.putInt(var1);
                           var10000 = PacketBuffer.method3528(var1);
                        }

                        var16 = var10000;
                        if(var16.dynamicValues != null && var16.dynamicValues[0][0] == 5) {
                           var14 = var16.dynamicValues[0][1];
                           if(class211.widgetSettings[var14] != var16.field2687[0]) {
                              class211.widgetSettings[var14] = var16.field2687[0];
                              WidgetNode.method1139(var14);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1077 == null) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADVANCE_DIALOGUE);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           } else {
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.method3365(var0);
                           }

                           Client.field1077 = class5.method18(var1, var0);
                           class25.method172(Client.field1077);
                        }
                     } else if(var2 == 31) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_ITEM);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(class25.field371);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(Friend.field819);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(class39.selectedItemIndex);
                        } else {
                           Client.secretPacketBuffer1.method3279(class25.field371);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.method3270(var3);
                           Client.secretPacketBuffer1.method3365(Friend.field819);
                           Client.secretPacketBuffer1.method3282(var1);
                           Client.secretPacketBuffer1.putShortLE(class39.selectedItemIndex);
                        }

                        Client.field1023 = 0;
                        SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                        Client.field1024 = var0;
                     } else if(var2 == 32) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_BAG);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(class25.field372);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(Client.field1069);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.method3270(var3);
                           Client.secretPacketBuffer1.method3280(class25.field372);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.method3270(Client.field1069);
                           Client.secretPacketBuffer1.method3282(var1);
                        }

                        Client.field1023 = 0;
                        SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                        Client.field1024 = var0;
                     } else if(var2 == 33) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIRST_ITEM_ACTION);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                        } else {
                           Client.secretPacketBuffer1.method3282(var1);
                           Client.secretPacketBuffer1.putShortLE(var3);
                           Client.secretPacketBuffer1.method3365(var0);
                        }

                        Client.field1023 = 0;
                        SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                        Client.field1024 = var0;
                     } else if(var2 == 34) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EQUIP_BAG_ITEM);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                        } else {
                           Client.secretPacketBuffer1.putShort(var3);
                           Client.secretPacketBuffer1.method3282(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                        }

                        Client.field1023 = 0;
                        SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                        Client.field1024 = var0;
                     } else if(var2 == 35) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_THIRD_ITEM_ACTION);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.method3365(var3);
                           Client.secretPacketBuffer1.putShortLE(var0);
                           Client.secretPacketBuffer1.method3279(var1);
                        }

                        Client.field1023 = 0;
                        SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                        Client.field1024 = var0;
                     } else if(var2 == 36) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FOURTH_ITEM_ACTION);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.method3365(var0);
                           Client.secretPacketBuffer1.putShortLE(var3);
                           Client.secretPacketBuffer1.method3282(var1);
                        }

                        Client.field1023 = 0;
                        SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                        Client.field1024 = var0;
                     } else if(var2 == 37) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DROP_ITEM);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                        } else {
                           Client.secretPacketBuffer1.method3270(var0);
                           Client.secretPacketBuffer1.method3279(var1);
                           Client.secretPacketBuffer1.method3365(var3);
                        }

                        Client.field1023 = 0;
                        SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                        Client.field1024 = var0;
                     } else {
                        if(var2 == 38) {
                           class89.method1783();
                           var16 = PacketBuffer.method3528(var1);
                           Client.itemSelectionState = 1;
                           class39.selectedItemIndex = var0;
                           class25.field371 = var1;
                           Friend.field819 = var3;
                           class25.method172(var16);
                           Client.field1067 = class60.getColTags(16748608) + class46.getItemDefinition(var3).name + class60.getColTags(16777215);
                           if(Client.field1067 == null) {
                              Client.field1067 = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_44);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           } else {
                              Client.secretPacketBuffer1.putShort(var3);
                              Client.secretPacketBuffer1.method3270(var0);
                              Client.secretPacketBuffer1.method3282(var1);
                           }

                           Client.field1023 = 0;
                           SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                           Client.field1024 = var0;
                        } else if(var2 == 40) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_202);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           } else {
                              Client.secretPacketBuffer1.method3280(var1);
                              Client.secretPacketBuffer1.method3270(var3);
                              Client.secretPacketBuffer1.putShortLE(var0);
                           }

                           Client.field1023 = 0;
                           SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                           Client.field1024 = var0;
                        } else if(var2 == 41) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_102);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           } else {
                              Client.secretPacketBuffer1.method3270(var0);
                              Client.secretPacketBuffer1.putShortLE(var3);
                              Client.secretPacketBuffer1.method3282(var1);
                           }

                           Client.field1023 = 0;
                           SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                           Client.field1024 = var0;
                        } else if(var2 == 42) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_241);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           } else {
                              Client.secretPacketBuffer1.putShortLE(var3);
                              Client.secretPacketBuffer1.method3282(var1);
                              Client.secretPacketBuffer1.method3365(var0);
                           }

                           Client.field1023 = 0;
                           SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                           Client.field1024 = var0;
                        } else if(var2 == 43) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_42);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           } else {
                              Client.secretPacketBuffer1.method3282(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShortLE(var3);
                           }

                           Client.field1023 = 0;
                           SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                           Client.field1024 = var0;
                        } else if(var2 == 44) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_166);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
                              Client.secretPacketBuffer1.method3365(var3);
                           }
                        } else if(var2 == 45) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_231);
                              Client.secretPacketBuffer1.method3261(KeyFocusListener.field655[82]?1:0);
                              Client.secretPacketBuffer1.method3270(var3);
                           }
                        } else if(var2 == 46) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FOLLOW_PLAYER);
                              Client.secretPacketBuffer1.method3261(KeyFocusListener.field655[82]?1:0);
                              Client.secretPacketBuffer1.putShortLE(var3);
                           }
                        } else if(var2 == 47) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TRADE_PLAYER);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              } else {
                                 Client.secretPacketBuffer1.method3270(var3);
                              }

                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
                           }
                        } else if(var2 == 48) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_214);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              } else {
                                 Client.secretPacketBuffer1.putShortLE(var3);
                              }

                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
                           }
                        } else if(var2 == 49) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_5);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
                              Client.secretPacketBuffer1.method3270(var3);
                           }
                        } else if(var2 == 50) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_4);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field655[82]?1:0);
                              Client.secretPacketBuffer1.method3270(var3);
                           }
                        } else if(var2 == 51) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.field1019 = var6;
                              Client.field1020 = var7;
                              Client.cursorState = 2;
                              Client.field1171 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_REPORT_PLAYER);
                              Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
                              Client.secretPacketBuffer1.method3365(var3);
                           }
                        } else {
                           label1076: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var16 = class5.method18(var1, var0);
                                    if(var16 != null) {
                                       Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_253);
                                       if(Client.RUNELITE_PACKET) {
                                          Client.secretPacketBuffer1.runeliteWriteInt(Client.field1070);
                                          Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                          Client.secretPacketBuffer1.runeliteWriteInt(var16.itemId);
                                          Client.secretPacketBuffer1.runeliteWriteInt(Client.field1069);
                                          Client.secretPacketBuffer1.runeliteWriteInt(class25.field372);
                                          Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                       } else {
                                          Client.secretPacketBuffer1.method3270(Client.field1070);
                                          Client.secretPacketBuffer1.putInt(var1);
                                          Client.secretPacketBuffer1.method3270(var16.itemId);
                                          Client.secretPacketBuffer1.method3270(Client.field1069);
                                          Client.secretPacketBuffer1.method3282(class25.field372);
                                          Client.secretPacketBuffer1.putShortLE(var0);
                                       }
                                    }
                                    break label1076;
                                 }

                                 if(var2 == 1001) {
                                    Client.field1019 = var6;
                                    Client.field1020 = var7;
                                    Client.cursorState = 2;
                                    Client.field1171 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_111);
                                    if(Client.RUNELITE_PACKET) {
                                       Client.secretPacketBuffer1.runeliteWriteInt(Varcs.baseY + var1);
                                    } else {
                                       Client.secretPacketBuffer1.method3365(Varcs.baseY + var1);
                                    }

                                    Client.secretPacketBuffer1.putByte(KeyFocusListener.field655[82]?1:0);
                                    Client.secretPacketBuffer1.method3365(var3 >> 14 & 32767);
                                    Client.secretPacketBuffer1.method3365(var0 + WallObject.baseX);
                                    break label1076;
                                 }

                                 if(var2 == 1002) {
                                    Client.field1019 = var6;
                                    Client.field1020 = var7;
                                    Client.cursorState = 2;
                                    Client.field1171 = 0;
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_OBSTACLE);
                                    if(Client.RUNELITE_PACKET) {
                                       Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
                                    } else {
                                       Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
                                    }
                                    break label1076;
                                 }

                                 if(var2 == 1003) {
                                    Client.field1019 = var6;
                                    Client.field1020 = var7;
                                    Client.cursorState = 2;
                                    Client.field1171 = 0;
                                    var8 = Client.cachedNPCs[var3];
                                    if(var8 != null) {
                                       NPCComposition var12 = var8.composition;
                                       if(var12.configs != null) {
                                          var12 = var12.transform();
                                       }

                                       if(var12 != null) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_NPC);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var12.id);
                                          } else {
                                             Client.secretPacketBuffer1.putShort(var12.id);
                                          }
                                       }
                                    }
                                    break label1076;
                                 }

                                 if(var2 == 1004) {
                                    Client.field1019 = var6;
                                    Client.field1020 = var7;
                                    Client.cursorState = 2;
                                    Client.field1171 = 0;
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_ITEM);
                                    if(Client.RUNELITE_PACKET) {
                                       Client.secretPacketBuffer1.runeliteWriteInt(var3);
                                    } else {
                                       Client.secretPacketBuffer1.method3365(var3);
                                    }
                                    break label1076;
                                 }

                                 if(var2 == 1005) {
                                    var16 = PacketBuffer.method3528(var1);
                                    if(var16 != null && var16.itemQuantities[var0] >= 100000) {
                                       MessageNode.sendGameMessage(27, "", var16.itemQuantities[var0] + " x " + class46.getItemDefinition(var3).name);
                                    } else {
                                       Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_ITEM);
                                       if(Client.RUNELITE_PACKET) {
                                          Client.secretPacketBuffer1.runeliteWriteInt(var3);
                                       } else {
                                          Client.secretPacketBuffer1.method3365(var3);
                                       }
                                    }

                                    Client.field1023 = 0;
                                    SceneTilePaint.field2031 = PacketBuffer.method3528(var1);
                                    Client.field1024 = var0;
                                    break label1076;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1009 || var2 == 1010 || var2 == 1008 || var2 == 1011 || var2 == 1012) {
                                       GameObject.renderOverview.method5323(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label1076;
                                 }
                              }

                              var16 = class5.method18(var1, var0);
                              if(var16 != null) {
                                 var14 = var16.itemId;
                                 Widget var10 = class5.method18(var1, var0);
                                 if(var10 != null) {
                                    if(var10.field2758 != null) {
                                       ScriptEvent var11 = new ScriptEvent();
                                       var11.widget = var10;
                                       var11.field849 = var3;
                                       var11.field852 = var5;
                                       var11.field846 = var10.field2758;
                                       CollisionData.method3128(var11);
                                    }

                                    boolean var13 = true;
                                    if(var10.contentType > 0) {
                                       var13 = class276.method5021(var10);
                                    }

                                    if(var13 && class110.method2171(class244.getWidgetConfig(var10), var3 - 1)) {
                                       if(var3 == 1) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_77);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 2) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_60);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 3) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_135);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 4) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_246);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 5) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_152);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 6) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_177);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 7) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_244);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 8) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_109);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 9) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_142);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
                                          }
                                       }

                                       if(var3 == 10) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_195);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                             Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                          } else {
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var14);
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

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         class25.method172(PacketBuffer.method3528(class25.field371));
      }

      if(Client.spellSelected) {
         class89.method1783();
      }

      if(SceneTilePaint.field2031 != null && Client.field1023 == 0) {
         class25.method172(SceneTilePaint.field2031);
      }

   }
}
