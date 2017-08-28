import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("bn")
public class class66 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   static final class66 field828;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   static final class66 field829;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   static final class66 field831;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   static final class66 field830;
   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   static SpritePixels[] field832;

   static {
      field828 = new class66();
      field829 = new class66();
      field831 = new class66();
      field830 = new class66();
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1225201533"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 1) {
         Client.field1038 = var6;
         Client.field995 = var7;
         Client.cursorState = 2;
         Client.field1040 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_OBSTACLE);
         Client.secretPacketBuffer1.method3273(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShort(class67.baseY + var1);
         Client.secretPacketBuffer1.method3288(class48.field626);
         Client.secretPacketBuffer1.method3273(class56.selectedItemIndex);
         Client.secretPacketBuffer1.method3280(var0 + class149.baseX);
         Client.secretPacketBuffer1.method3410(KeyFocusListener.field651[82]?1:0);
         Client.secretPacketBuffer1.method3280(class15.field302);
      } else if(var2 == 2) {
         Client.field1038 = var6;
         Client.field995 = var7;
         Client.cursorState = 2;
         Client.field1040 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_232);
         Client.secretPacketBuffer1.method3280(class67.baseY + var1);
         Client.secretPacketBuffer1.method3280(Client.field1087);
         Client.secretPacketBuffer1.method3410(KeyFocusListener.field651[82]?1:0);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3273(var0 + class149.baseX);
         Client.secretPacketBuffer1.method3288(BaseVarType.field26);
      } else if(var2 == 3) {
         Client.field1038 = var6;
         Client.field995 = var7;
         Client.cursorState = 2;
         Client.field1040 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIRST_OBSTACLE_ACTION);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3280(class67.baseY + var1);
         Client.secretPacketBuffer1.putShortLE(var0 + class149.baseX);
         Client.secretPacketBuffer1.method3311(KeyFocusListener.field651[82]?1:0);
      } else if(var2 == 4) {
         Client.field1038 = var6;
         Client.field995 = var7;
         Client.cursorState = 2;
         Client.field1040 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SECOND_OBSTACLE_ACTION);
         Client.secretPacketBuffer1.method3273(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShortLE(var0 + class149.baseX);
         Client.secretPacketBuffer1.method3410(KeyFocusListener.field651[82]?1:0);
         Client.secretPacketBuffer1.method3280(class67.baseY + var1);
      } else if(var2 == 5) {
         Client.field1038 = var6;
         Client.field995 = var7;
         Client.cursorState = 2;
         Client.field1040 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_THIRD_OBSTACLE_ACTION);
         Client.secretPacketBuffer1.putShortLE(var0 + class149.baseX);
         Client.secretPacketBuffer1.putShortLE(class67.baseY + var1);
         Client.secretPacketBuffer1.method3280(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3311(KeyFocusListener.field651[82]?1:0);
      } else if(var2 == 6) {
         Client.field1038 = var6;
         Client.field995 = var7;
         Client.cursorState = 2;
         Client.field1040 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_227);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3280(var0 + class149.baseX);
         Client.secretPacketBuffer1.putShortLE(class67.baseY + var1);
         Client.secretPacketBuffer1.method3311(KeyFocusListener.field651[82]?1:0);
      } else {
         NPC var8;
         if(var2 == 7) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_MOB);
               Client.secretPacketBuffer1.putShortLE(class56.selectedItemIndex);
               Client.secretPacketBuffer1.putShort(class15.field302);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3288(class48.field626);
            }
         } else if(var2 == 8) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_197);
               Client.secretPacketBuffer1.method3280(var3);
               Client.secretPacketBuffer1.method3273(Client.field1087);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.putLEShortA(BaseVarType.field26);
            }
         } else if(var2 == 9) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_151);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
            }
         } else if(var2 == 10) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_155);
               Client.secretPacketBuffer1.method3311(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.method3280(var3);
            }
         } else if(var2 == 11) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_76);
               Client.secretPacketBuffer1.method3273(var3);
               Client.secretPacketBuffer1.method3311(KeyFocusListener.field651[82]?1:0);
            }
         } else if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_70);
               Client.secretPacketBuffer1.method3280(var3);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
            }
         } else if(var2 == 13) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_41);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
            }
         } else {
            Player var17;
            if(var2 == 14) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field1038 = var6;
                  Client.field995 = var7;
                  Client.cursorState = 2;
                  Client.field1040 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_72);
                  Client.secretPacketBuffer1.method3280(class56.selectedItemIndex);
                  Client.secretPacketBuffer1.putInt(class48.field626);
                  Client.secretPacketBuffer1.method3410(KeyFocusListener.field651[82]?1:0);
                  Client.secretPacketBuffer1.putShortLE(class15.field302);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            } else if(var2 == 15) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field1038 = var6;
                  Client.field995 = var7;
                  Client.cursorState = 2;
                  Client.field1040 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_PLAYER);
                  Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
                  Client.secretPacketBuffer1.method3280(Client.field1087);
                  Client.secretPacketBuffer1.method3288(BaseVarType.field26);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            } else if(var2 == 16) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_235);
               Client.secretPacketBuffer1.putShortLE(class15.field302);
               Client.secretPacketBuffer1.method3410(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3273(var0 + class149.baseX);
               Client.secretPacketBuffer1.method3280(class56.selectedItemIndex);
               Client.secretPacketBuffer1.method3273(class67.baseY + var1);
               Client.secretPacketBuffer1.putInt(class48.field626);
            } else if(var2 == 17) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_FLOORITEM);
               Client.secretPacketBuffer1.putShort(class67.baseY + var1);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.method3288(BaseVarType.field26);
               Client.secretPacketBuffer1.method3280(Client.field1087);
               Client.secretPacketBuffer1.putShort(var0 + class149.baseX);
               Client.secretPacketBuffer1.putShort(var3);
            } else if(var2 == 18) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_67);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.method3273(var0 + class149.baseX);
               Client.secretPacketBuffer1.method3280(class67.baseY + var1);
            } else if(var2 == 19) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_43);
               Client.secretPacketBuffer1.method3410(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.putShortLE(var0 + class149.baseX);
               Client.secretPacketBuffer1.putShort(class67.baseY + var1);
            } else if(var2 == 20) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_125);
               Client.secretPacketBuffer1.method3273(var0 + class149.baseX);
               Client.secretPacketBuffer1.method3280(class67.baseY + var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
            } else if(var2 == 21) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_189);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3273(class67.baseY + var1);
               Client.secretPacketBuffer1.putShortLE(var0 + class149.baseX);
            } else if(var2 == 22) {
               Client.field1038 = var6;
               Client.field995 = var7;
               Client.cursorState = 2;
               Client.field1040 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_192);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field651[82]?1:0);
               Client.secretPacketBuffer1.putShort(class67.baseY + var1);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3273(var0 + class149.baseX);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  ScriptState.region.method2755();
               } else {
                  ScriptState.region.method2793(class27.plane, var0, var1, true);
               }
            } else {
               Widget var18;
               if(var2 == 24) {
                  var18 = GZipDecompressor.method3177(var1);
                  boolean var9 = true;
                  if(var18.contentType > 0) {
                     var9 = class165.method3153(var18);
                  }

                  if(var9) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                     Client.secretPacketBuffer1.putInt(var1);
                  }
               } else {
                  int var16;
                  if(var2 == 25) {
                     var18 = Varcs.method1849(var1, var0);
                     if(var18 != null) {
                        class95.method1814();
                        int var10 = Coordinates.getWidgetConfig(var18);
                        var16 = var10 >> 11 & 63;
                        int var12 = var18.itemId;
                        Widget var13 = Varcs.method1849(var1, var0);
                        if(var13 != null && var13.field2749 != null) {
                           ScriptEvent var14 = new ScriptEvent();
                           var14.widget = var13;
                           var14.field864 = var13.field2749;
                           class153.method3002(var14);
                        }

                        Client.field1016 = var12;
                        Client.spellSelected = true;
                        BaseVarType.field26 = var1;
                        Client.field1087 = var0;
                        class67.field845 = var16;
                        class7.method34(var13);
                        Client.itemSelectionState = 0;
                        Client.field1089 = AbstractByteBuffer.method3468(var18);
                        if(Client.field1089 == null) {
                           Client.field1089 = "Null";
                        }

                        if(var18.hasScript) {
                           Client.field1090 = var18.name + Friend.getColTags(16777215);
                        } else {
                           Client.field1090 = Friend.getColTags('\uff00') + var18.field2774 + Friend.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_174);

                     for(WidgetNode var19 = (WidgetNode)Client.componentTable.method3628(); var19 != null; var19 = (WidgetNode)Client.componentTable.method3625()) {
                        if(var19.owner == 0 || var19.owner == 3) {
                           MessageNode.method1143(var19, true);
                        }
                     }

                     if(Client.field1086 != null) {
                        class7.method34(Client.field1086);
                        Client.field1086 = null;
                     }
                  } else if(var2 == 28) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                     Client.secretPacketBuffer1.putInt(var1);
                     var18 = GZipDecompressor.method3177(var1);
                     if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                        var16 = var18.dynamicValues[0][1];
                        class212.widgetSettings[var16] = 1 - class212.widgetSettings[var16];
                        WorldMapType1.method301(var16);
                     }
                  } else if(var2 == 29) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                     Client.secretPacketBuffer1.putInt(var1);
                     var18 = GZipDecompressor.method3177(var1);
                     if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                        var16 = var18.dynamicValues[0][1];
                        if(class212.widgetSettings[var16] != var18.field2772[0]) {
                           class212.widgetSettings[var16] = var18.field2772[0];
                           WorldMapType1.method301(var16);
                        }
                     }
                  } else if(var2 == 30) {
                     if(Client.field1086 == null) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADVANCE_DIALOGUE);
                        Client.secretPacketBuffer1.putShortLE(var0);
                        Client.secretPacketBuffer1.putLEShortA(var1);
                        Client.field1086 = Varcs.method1849(var1, var0);
                        class7.method34(Client.field1086);
                     }
                  } else if(var2 == 31) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_233);
                     Client.secretPacketBuffer1.putShort(class56.selectedItemIndex);
                     Client.secretPacketBuffer1.method3288(var1);
                     Client.secretPacketBuffer1.method3280(var3);
                     Client.secretPacketBuffer1.putLEShortA(class48.field626);
                     Client.secretPacketBuffer1.putShort(class15.field302);
                     Client.secretPacketBuffer1.method3280(var0);
                     Client.field1042 = 0;
                     class262.field3618 = GZipDecompressor.method3177(var1);
                     Client.field1043 = var0;
                  } else if(var2 == 32) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_212);
                     Client.secretPacketBuffer1.method3273(var3);
                     Client.secretPacketBuffer1.method3280(Client.field1087);
                     Client.secretPacketBuffer1.method3288(BaseVarType.field26);
                     Client.secretPacketBuffer1.method3273(var0);
                     Client.secretPacketBuffer1.method3288(var1);
                     Client.field1042 = 0;
                     class262.field3618 = GZipDecompressor.method3177(var1);
                     Client.field1043 = var0;
                  } else if(var2 == 33) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_228);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.method3273(var3);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.field1042 = 0;
                     class262.field3618 = GZipDecompressor.method3177(var1);
                     Client.field1043 = var0;
                  } else if(var2 == 34) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_117);
                     Client.secretPacketBuffer1.method3280(var3);
                     Client.secretPacketBuffer1.putShortLE(var0);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.field1042 = 0;
                     class262.field3618 = GZipDecompressor.method3177(var1);
                     Client.field1043 = var0;
                  } else if(var2 == 35) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_19);
                     Client.secretPacketBuffer1.putShortLE(var0);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShortLE(var3);
                     Client.field1042 = 0;
                     class262.field3618 = GZipDecompressor.method3177(var1);
                     Client.field1043 = var0;
                  } else if(var2 == 36) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_242);
                     Client.secretPacketBuffer1.method3273(var3);
                     Client.secretPacketBuffer1.method3280(var0);
                     Client.secretPacketBuffer1.putLEShortA(var1);
                     Client.field1042 = 0;
                     class262.field3618 = GZipDecompressor.method3177(var1);
                     Client.field1043 = var0;
                  } else if(var2 == 37) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_244);
                     Client.secretPacketBuffer1.putLEShortA(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShortLE(var3);
                     Client.field1042 = 0;
                     class262.field3618 = GZipDecompressor.method3177(var1);
                     Client.field1043 = var0;
                  } else {
                     if(var2 == 38) {
                        class95.method1814();
                        var18 = GZipDecompressor.method3177(var1);
                        Client.itemSelectionState = 1;
                        class56.selectedItemIndex = var0;
                        class48.field626 = var1;
                        class15.field302 = var3;
                        class7.method34(var18);
                        Client.field1085 = Friend.getColTags(16748608) + class169.getItemDefinition(var3).name + Friend.getColTags(16777215);
                        if(Client.field1085 == null) {
                           Client.field1085 = "null";
                        }

                        return;
                     }

                     if(var2 == 39) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_161);
                        Client.secretPacketBuffer1.putLEShortA(var1);
                        Client.secretPacketBuffer1.method3280(var3);
                        Client.secretPacketBuffer1.method3280(var0);
                        Client.field1042 = 0;
                        class262.field3618 = GZipDecompressor.method3177(var1);
                        Client.field1043 = var0;
                     } else if(var2 == 40) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_25);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.method3273(var0);
                        Client.secretPacketBuffer1.putShort(var3);
                        Client.field1042 = 0;
                        class262.field3618 = GZipDecompressor.method3177(var1);
                        Client.field1043 = var0;
                     } else if(var2 == 41) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_169);
                        Client.secretPacketBuffer1.putShort(var3);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.method3369(var1);
                        Client.field1042 = 0;
                        class262.field3618 = GZipDecompressor.method3177(var1);
                        Client.field1043 = var0;
                     } else if(var2 == 42) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_119);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.method3280(var3);
                        Client.secretPacketBuffer1.method3280(var0);
                        Client.field1042 = 0;
                        class262.field3618 = GZipDecompressor.method3177(var1);
                        Client.field1043 = var0;
                     } else if(var2 == 43) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_247);
                        Client.secretPacketBuffer1.putShort(var3);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.method3273(var0);
                        Client.field1042 = 0;
                        class262.field3618 = GZipDecompressor.method3177(var1);
                        Client.field1043 = var0;
                     } else if(var2 == 44) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_73);
                           Client.secretPacketBuffer1.putByte(KeyFocusListener.field651[82]?1:0);
                           Client.secretPacketBuffer1.method3273(var3);
                        }
                     } else if(var2 == 45) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_116);
                           Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
                           Client.secretPacketBuffer1.method3273(var3);
                        }
                     } else if(var2 == 46) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_86);
                           Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
                           Client.secretPacketBuffer1.putShortLE(var3);
                        }
                     } else if(var2 == 47) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_170);
                           Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
                           Client.secretPacketBuffer1.putShortLE(var3);
                        }
                     } else if(var2 == 48) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_56);
                           Client.secretPacketBuffer1.method3280(var3);
                           Client.secretPacketBuffer1.method3311(KeyFocusListener.field651[82]?1:0);
                        }
                     } else if(var2 == 49) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_115);
                           Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
                           Client.secretPacketBuffer1.putShortLE(var3);
                        }
                     } else if(var2 == 50) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_65);
                           Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
                           Client.secretPacketBuffer1.method3273(var3);
                        }
                     } else if(var2 == 51) {
                        var17 = Client.cachedPlayers[var3];
                        if(var17 != null) {
                           Client.field1038 = var6;
                           Client.field995 = var7;
                           Client.cursorState = 2;
                           Client.field1040 = 0;
                           Client.destinationX = var0;
                           Client.destinationY = var1;
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_122);
                           Client.secretPacketBuffer1.putByte(KeyFocusListener.field651[82]?1:0);
                           Client.secretPacketBuffer1.method3273(var3);
                        }
                     } else {
                        label709: {
                           if(var2 != 57) {
                              if(var2 == 58) {
                                 var18 = Varcs.method1849(var1, var0);
                                 if(var18 != null) {
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_255);
                                    Client.secretPacketBuffer1.putShortLE(Client.field1087);
                                    Client.secretPacketBuffer1.putInt(var1);
                                    Client.secretPacketBuffer1.putShort(var18.itemId);
                                    Client.secretPacketBuffer1.putShort(Client.field1016);
                                    Client.secretPacketBuffer1.putShortLE(var0);
                                    Client.secretPacketBuffer1.method3288(BaseVarType.field26);
                                 }
                                 break label709;
                              }

                              if(var2 == 1001) {
                                 Client.field1038 = var6;
                                 Client.field995 = var7;
                                 Client.cursorState = 2;
                                 Client.field1040 = 0;
                                 Client.destinationX = var0;
                                 Client.destinationY = var1;
                                 Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_188);
                                 Client.secretPacketBuffer1.method3273(var3 >> 14 & 32767);
                                 Client.secretPacketBuffer1.method3280(class67.baseY + var1);
                                 Client.secretPacketBuffer1.putShortLE(var0 + class149.baseX);
                                 Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?1:0);
                                 break label709;
                              }

                              if(var2 == 1002) {
                                 Client.field1038 = var6;
                                 Client.field995 = var7;
                                 Client.cursorState = 2;
                                 Client.field1040 = 0;
                                 Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_OBSTACLE);
                                 Client.secretPacketBuffer1.method3280(var3 >> 14 & 32767);
                                 break label709;
                              }

                              if(var2 == 1003) {
                                 Client.field1038 = var6;
                                 Client.field995 = var7;
                                 Client.cursorState = 2;
                                 Client.field1040 = 0;
                                 var8 = Client.cachedNPCs[var3];
                                 if(var8 != null) {
                                    NPCComposition var15 = var8.composition;
                                    if(var15.configs != null) {
                                       var15 = var15.transform();
                                    }

                                    if(var15 != null) {
                                       Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_66);
                                       Client.secretPacketBuffer1.putShortLE(var15.id);
                                    }
                                 }
                                 break label709;
                              }

                              if(var2 == 1004) {
                                 Client.field1038 = var6;
                                 Client.field995 = var7;
                                 Client.cursorState = 2;
                                 Client.field1040 = 0;
                                 Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_220);
                                 Client.secretPacketBuffer1.method3273(var3);
                                 break label709;
                              }

                              if(var2 == 1005) {
                                 var18 = GZipDecompressor.method3177(var1);
                                 if(var18 != null && var18.itemQuantities[var0] >= 100000) {
                                    Client.sendGameMessage(27, "", var18.itemQuantities[var0] + " x " + class169.getItemDefinition(var3).name);
                                 } else {
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_220);
                                    Client.secretPacketBuffer1.method3273(var3);
                                 }

                                 Client.field1042 = 0;
                                 class262.field3618 = GZipDecompressor.method3177(var1);
                                 Client.field1043 = var0;
                                 break label709;
                              }

                              if(var2 != 1007) {
                                 if(var2 == 1010 || var2 == 1009 || var2 == 1008 || var2 == 1011 || var2 == 1012) {
                                    KeyFocusListener.renderOverview.method5180(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                 }
                                 break label709;
                              }
                           }

                           var18 = Varcs.method1849(var1, var0);
                           if(var18 != null) {
                              FrameMap.method2708(var3, var1, var0, var18.itemId, var5);
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
         class7.method34(GZipDecompressor.method3177(class48.field626));
      }

      if(Client.spellSelected) {
         class95.method1814();
      }

      if(class262.field3618 != null && Client.field1042 == 0) {
         class7.method34(class262.field3618);
      }

   }
}
