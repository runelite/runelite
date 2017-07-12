import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("ai")
   static java.awt.Font field1507;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 353866017
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1177587853
   )
   @Export("id")
   int id;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1914243094"
   )
   protected final Model getModel() {
      return AbstractByteBuffer.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-28501253"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 3) {
         Client.field1190 = var6;
         Client.field1034 = var7;
         Client.cursorState = 2;
         Client.field967 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(250);
         Client.secretPacketBuffer1.putShort(var0 + KeyFocusListener.baseX);
         Client.secretPacketBuffer1.putShortOb2(class266.baseY + var1);
         Client.secretPacketBuffer1.putLEShortA(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
      }

      if(var2 == 26) {
         class112.method2097();
      }

      NPC var8;
      if(var2 == 8) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(92);
            Client.secretPacketBuffer1.putIntOb1(var3);
            Client.secretPacketBuffer1.putInt(class208.field2598);
            Client.secretPacketBuffer1.putIntOb1(Client.field1158);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
         }
      }

      Player var9;
      if(var2 == 44) {
         var9 = Client.cachedPlayers[var3];
         if(var9 != null) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(68);
            Client.secretPacketBuffer1.putShortOb2(var3);
            Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
         }
      }

      Widget var10;
      if(var2 == 57 || var2 == 1007) {
         var10 = class202.method3650(var1, var0);
         if(var10 != null) {
            class60.method1052(var3, var1, var0, var10.itemId, var5);
         }
      }

      if(var2 == 5) {
         Client.field1190 = var6;
         Client.field1034 = var7;
         Client.cursorState = 2;
         Client.field967 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(229);
         Client.secretPacketBuffer1.putShort(var0 + KeyFocusListener.baseX);
         Client.secretPacketBuffer1.putLEShortA(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putIntOb1(class266.baseY + var1);
         Client.secretPacketBuffer1.method3167(KeyFocusListener.field659[82]?1:0);
      }

      if(var2 == 7) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(157);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
            Client.secretPacketBuffer1.putLEShortA(var3);
            Client.secretPacketBuffer1.method3233(class40.field571);
            Client.secretPacketBuffer1.putLEShortA(IndexDataBase.field3221);
            Client.secretPacketBuffer1.putShort(FileSystem.selectedItemIndex);
         }
      }

      if(var2 == 40) {
         Client.secretPacketBuffer1.putOpcode(108);
         Client.secretPacketBuffer1.putIntOb1(var0);
         Client.secretPacketBuffer1.putLEShortA(var3);
         Client.secretPacketBuffer1.method3233(var1);
         Client.field997 = 0;
         Buffer.field2405 = PacketBuffer.method3403(var1);
         Client.field1114 = var0;
      }

      if(var2 == 16) {
         Client.field1190 = var6;
         Client.field1034 = var7;
         Client.cursorState = 2;
         Client.field967 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(210);
         Client.secretPacketBuffer1.putShortOb2(IndexDataBase.field3221);
         Client.secretPacketBuffer1.putLEShortA(FileSystem.selectedItemIndex);
         Client.secretPacketBuffer1.putShort(class266.baseY + var1);
         Client.secretPacketBuffer1.putIntOb1(var0 + KeyFocusListener.baseX);
         Client.secretPacketBuffer1.putLEInt(class40.field571);
         Client.secretPacketBuffer1.putIntOb1(var3);
         Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
      }

      if(var2 == 1005) {
         var10 = PacketBuffer.method3403(var1);
         if(var10 != null && var10.itemQuantities[var0] >= 100000) {
            class152.sendGameMessage(27, "", var10.itemQuantities[var0] + " x " + AbstractByteBuffer.getItemDefinition(var3).name);
         } else {
            Client.secretPacketBuffer1.putOpcode(72);
            Client.secretPacketBuffer1.putLEShortA(var3);
         }

         Client.field997 = 0;
         Buffer.field2405 = PacketBuffer.method3403(var1);
         Client.field1114 = var0;
      }

      if(var2 == 15) {
         var9 = Client.cachedPlayers[var3];
         if(var9 != null) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(173);
            Client.secretPacketBuffer1.putLEInt(class208.field2598);
            Client.secretPacketBuffer1.putLEShortA(var3);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
            Client.secretPacketBuffer1.putShort(Client.field1158);
         }
      }

      if(var2 == 33) {
         Client.secretPacketBuffer1.putOpcode(8);
         Client.secretPacketBuffer1.method3233(var1);
         Client.secretPacketBuffer1.putLEShortA(var3);
         Client.secretPacketBuffer1.putIntOb1(var0);
         Client.field997 = 0;
         Buffer.field2405 = PacketBuffer.method3403(var1);
         Client.field1114 = var0;
      }

      if(var2 == 34) {
         Client.secretPacketBuffer1.putOpcode(198);
         Client.secretPacketBuffer1.putIntOb1(var3);
         Client.secretPacketBuffer1.putLEInt(var1);
         Client.secretPacketBuffer1.putLEShortA(var0);
         Client.field997 = 0;
         Buffer.field2405 = PacketBuffer.method3403(var1);
         Client.field1114 = var0;
      }

      if(var2 == 1001) {
         Client.field1190 = var6;
         Client.field1034 = var7;
         Client.cursorState = 2;
         Client.field967 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(45);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3167(KeyFocusListener.field659[82]?1:0);
         Client.secretPacketBuffer1.putIntOb1(var0 + KeyFocusListener.baseX);
         Client.secretPacketBuffer1.putShort(class266.baseY + var1);
      }

      if(var2 == 2) {
         Client.field1190 = var6;
         Client.field1034 = var7;
         Client.cursorState = 2;
         Client.field967 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(187);
         Client.secretPacketBuffer1.putLEShortA(class266.baseY + var1);
         Client.secretPacketBuffer1.putShort(Client.field1158);
         Client.secretPacketBuffer1.putInt(class208.field2598);
         Client.secretPacketBuffer1.putIntOb1(var0 + KeyFocusListener.baseX);
         Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
         Client.secretPacketBuffer1.putIntOb1(var3 >> 14 & 32767);
      }

      if(var2 == 24) {
         var10 = PacketBuffer.method3403(var1);
         boolean var11 = true;
         if(var10.contentType > 0) {
            var11 = class7.method39(var10);
         }

         if(var11) {
            Client.secretPacketBuffer1.putOpcode(53);
            Client.secretPacketBuffer1.putInt(var1);
         }
      }

      if(var2 == 38) {
         class51.method791();
         var10 = PacketBuffer.method3403(var1);
         Client.itemSelectionState = 1;
         FileSystem.selectedItemIndex = var0;
         class40.field571 = var1;
         IndexDataBase.field3221 = var3;
         class88.method1714(var10);
         Client.selectedItemName = class220.getColTags(16748608) + AbstractByteBuffer.getItemDefinition(var3).name + class220.getColTags(16777215);
         if(Client.selectedItemName == null) {
            Client.selectedItemName = "null";
         }
      } else {
         if(var2 == 37) {
            Client.secretPacketBuffer1.putOpcode(44);
            Client.secretPacketBuffer1.method3233(var1);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field997 = 0;
            Buffer.field2405 = PacketBuffer.method3403(var1);
            Client.field1114 = var0;
         }

         if(var2 == 1002) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.secretPacketBuffer1.putOpcode(75);
            Client.secretPacketBuffer1.putLEShortA(var3 >> 14 & 32767);
         }

         int var14;
         if(var2 == 29) {
            Client.secretPacketBuffer1.putOpcode(53);
            Client.secretPacketBuffer1.putInt(var1);
            var10 = PacketBuffer.method3403(var1);
            if(var10.dynamicValues != null && var10.dynamicValues[0][0] == 5) {
               var14 = var10.dynamicValues[0][1];
               if(class211.widgetSettings[var14] != var10.field2645[0]) {
                  class211.widgetSettings[var14] = var10.field2645[0];
                  Preferences.method1614(var14);
               }
            }
         }

         if(var2 == 17) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(149);
            Client.secretPacketBuffer1.method3233(class208.field2598);
            Client.secretPacketBuffer1.putLEShortA(Client.field1158);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3265(KeyFocusListener.field659[82]?1:0);
            Client.secretPacketBuffer1.putIntOb1(var0 + KeyFocusListener.baseX);
            Client.secretPacketBuffer1.putLEShortA(class266.baseY + var1);
         }

         if(var2 == 23) {
            if(Client.isMenuOpen) {
               class2.region.method2672();
            } else {
               class2.region.method2703(WallObject.plane, var0, var1, true);
            }
         }

         if(var2 == 9) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(36);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putIntOb1(var3);
            }
         }

         if(var2 == 49) {
            var9 = Client.cachedPlayers[var3];
            if(var9 != null) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(186);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
            }
         }

         if(var2 == 18) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(233);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
            Client.secretPacketBuffer1.putShortOb2(class266.baseY + var1);
            Client.secretPacketBuffer1.putShortOb2(var0 + KeyFocusListener.baseX);
         }

         if(var2 == 4) {
            Client.field1190 = var6;
            Client.field1034 = var7;
            Client.cursorState = 2;
            Client.field967 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(196);
            Client.secretPacketBuffer1.putIntOb1(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShort(var0 + KeyFocusListener.baseX);
            Client.secretPacketBuffer1.putLEShortA(class266.baseY + var1);
            Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
         }

         if(var2 == 10) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(165);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.method3167(KeyFocusListener.field659[82]?1:0);
            }
         }

         if(var2 == 25) {
            var10 = class202.method3650(var1, var0);
            if(var10 != null) {
               class51.method791();
               int var12 = WorldMapType3.getWidgetConfig(var10);
               int var13 = var12 >> 11 & 63;
               class91.method1729(var1, var0, var13, var10.itemId);
               Client.itemSelectionState = 0;
               Client.field1078 = class162.method3041(var10);
               if(Client.field1078 == null) {
                  Client.field1078 = "Null";
               }

               if(var10.hasScript) {
                  Client.field1159 = var10.name + class220.getColTags(16777215);
               } else {
                  Client.field1159 = class220.getColTags('\uff00') + var10.field2766 + class220.getColTags(16777215);
               }
            }
         } else {
            if(var2 == 43) {
               Client.secretPacketBuffer1.putOpcode(166);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3257(var1);
               Client.secretPacketBuffer1.putShortOb2(var0);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 50) {
               var9 = Client.cachedPlayers[var3];
               if(var9 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(204);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
                  Client.secretPacketBuffer1.putLEShortA(var3);
               }
            }

            if(var2 == 19) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(118);
               Client.secretPacketBuffer1.putLEShortA(class266.baseY + var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putShortOb2(var0 + KeyFocusListener.baseX);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
            }

            if(var2 == 1) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(230);
               Client.secretPacketBuffer1.putIntOb1(IndexDataBase.field3221);
               Client.secretPacketBuffer1.method3233(class40.field571);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShort(class266.baseY + var1);
               Client.secretPacketBuffer1.putShort(var0 + KeyFocusListener.baseX);
               Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.putLEShortA(FileSystem.selectedItemIndex);
            }

            if(var2 == 1003) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  NPCComposition var15 = var8.composition;
                  if(var15.configs != null) {
                     var15 = var15.transform();
                  }

                  if(var15 != null) {
                     Client.secretPacketBuffer1.putOpcode(120);
                     Client.secretPacketBuffer1.putShort(var15.id);
                  }
               }
            }

            if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
               class43.renderOverview.method5230(var2, var3, new Coordinates(var0), new Coordinates(var1));
            }

            if(var2 == 45) {
               var9 = Client.cachedPlayers[var3];
               if(var9 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(227);
                  Client.secretPacketBuffer1.putIntOb1(var3);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
               }
            }

            if(var2 == 39) {
               Client.secretPacketBuffer1.putOpcode(122);
               Client.secretPacketBuffer1.putIntOb1(var0);
               Client.secretPacketBuffer1.putInt(var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 21) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(5);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShort(class266.baseY + var1);
               Client.secretPacketBuffer1.putIntOb1(var0 + KeyFocusListener.baseX);
            }

            if(var2 == 22) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(231);
               Client.secretPacketBuffer1.putShort(var0 + KeyFocusListener.baseX);
               Client.secretPacketBuffer1.putShort(class266.baseY + var1);
               Client.secretPacketBuffer1.putLEShortA(var3);
               Client.secretPacketBuffer1.method3167(KeyFocusListener.field659[82]?1:0);
            }

            if(var2 == 47) {
               var9 = Client.cachedPlayers[var3];
               if(var9 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(191);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
               }
            }

            if(var2 == 31) {
               Client.secretPacketBuffer1.putOpcode(29);
               Client.secretPacketBuffer1.method3257(var1);
               Client.secretPacketBuffer1.putLEInt(class40.field571);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.putLEShortA(var0);
               Client.secretPacketBuffer1.putShort(FileSystem.selectedItemIndex);
               Client.secretPacketBuffer1.putShort(IndexDataBase.field3221);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 28) {
               Client.secretPacketBuffer1.putOpcode(53);
               Client.secretPacketBuffer1.putInt(var1);
               var10 = PacketBuffer.method3403(var1);
               if(var10.dynamicValues != null && var10.dynamicValues[0][0] == 5) {
                  var14 = var10.dynamicValues[0][1];
                  class211.widgetSettings[var14] = 1 - class211.widgetSettings[var14];
                  Preferences.method1614(var14);
               }
            }

            if(var2 == 35) {
               Client.secretPacketBuffer1.putOpcode(183);
               Client.secretPacketBuffer1.putInt(var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putLEShortA(var0);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 42) {
               Client.secretPacketBuffer1.putOpcode(129);
               Client.secretPacketBuffer1.putIntOb1(var0);
               Client.secretPacketBuffer1.putInt(var1);
               Client.secretPacketBuffer1.putIntOb1(var3);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 11) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(86);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
               }
            }

            if(var2 == 12) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(97);
                  Client.secretPacketBuffer1.method3167(KeyFocusListener.field659[82]?1:0);
                  Client.secretPacketBuffer1.putIntOb1(var3);
               }
            }

            if(var2 == 51) {
               var9 = Client.cachedPlayers[var3];
               if(var9 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(113);
                  Client.secretPacketBuffer1.putIntOb1(var3);
                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
               }
            }

            if(var2 == 13) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(246);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
                  Client.secretPacketBuffer1.putLEShortA(var3);
               }
            }

            if(var2 == 48) {
               var9 = Client.cachedPlayers[var3];
               if(var9 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(37);
                  Client.secretPacketBuffer1.putShortOb2(var3);
                  Client.secretPacketBuffer1.method3167(KeyFocusListener.field659[82]?1:0);
               }
            }

            if(var2 == 46) {
               var9 = Client.cachedPlayers[var3];
               if(var9 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(28);
                  Client.secretPacketBuffer1.putLEShortA(var3);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
               }
            }

            if(var2 == 41) {
               Client.secretPacketBuffer1.putOpcode(251);
               Client.secretPacketBuffer1.method3233(var1);
               Client.secretPacketBuffer1.putShortOb2(var0);
               Client.secretPacketBuffer1.putShort(var3);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 1004) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.secretPacketBuffer1.putOpcode(72);
               Client.secretPacketBuffer1.putLEShortA(var3);
            }

            if(var2 == 58) {
               var10 = class202.method3650(var1, var0);
               if(var10 != null) {
                  Client.secretPacketBuffer1.putOpcode(99);
                  Client.secretPacketBuffer1.method3233(class208.field2598);
                  Client.secretPacketBuffer1.putIntOb1(Client.field1084);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putIntOb1(Client.field1158);
                  Client.secretPacketBuffer1.putShort(var0);
                  Client.secretPacketBuffer1.putShort(var10.itemId);
               }
            }

            if(var2 == 32) {
               Client.secretPacketBuffer1.putOpcode(158);
               Client.secretPacketBuffer1.putShort(var0);
               Client.secretPacketBuffer1.putLEShortA(var3);
               Client.secretPacketBuffer1.putInt(var1);
               Client.secretPacketBuffer1.putInt(class208.field2598);
               Client.secretPacketBuffer1.putIntOb1(Client.field1158);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 14) {
               var9 = Client.cachedPlayers[var3];
               if(var9 != null) {
                  Client.field1190 = var6;
                  Client.field1034 = var7;
                  Client.cursorState = 2;
                  Client.field967 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(39);
                  Client.secretPacketBuffer1.putLEShortA(var3);
                  Client.secretPacketBuffer1.method3233(class40.field571);
                  Client.secretPacketBuffer1.putShortOb2(IndexDataBase.field3221);
                  Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
                  Client.secretPacketBuffer1.putShort(FileSystem.selectedItemIndex);
               }
            }

            if(var2 == 20) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(168);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShortOb2(class266.baseY + var1);
               Client.secretPacketBuffer1.putLEShortA(var0 + KeyFocusListener.baseX);
               Client.secretPacketBuffer1.putIntOb1(var3);
            }

            if(var2 == 36) {
               Client.secretPacketBuffer1.putOpcode(160);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putLEInt(var1);
               Client.secretPacketBuffer1.putShort(var0);
               Client.field997 = 0;
               Buffer.field2405 = PacketBuffer.method3403(var1);
               Client.field1114 = var0;
            }

            if(var2 == 30 && Client.field1091 == null) {
               MouseInput.method1017(var1, var0);
               Client.field1091 = class202.method3650(var1, var0);
               class88.method1714(Client.field1091);
            }

            if(var2 == 6) {
               Client.field1190 = var6;
               Client.field1034 = var7;
               Client.cursorState = 2;
               Client.field967 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(38);
               Client.secretPacketBuffer1.putShort(class266.baseY + var1);
               Client.secretPacketBuffer1.putShortOb2(var0 + KeyFocusListener.baseX);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putLEShortA(var3 >> 14 & 32767);
            }

            if(Client.itemSelectionState != 0) {
               Client.itemSelectionState = 0;
               class88.method1714(PacketBuffer.method3403(class40.field571));
            }

            if(Client.spellSelected) {
               class51.method791();
            }

            if(Buffer.field2405 != null && Client.field997 == 0) {
               class88.method1714(Buffer.field2405);
            }
         }
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1923688719"
   )
   static final void method1773(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field1180 - Client.field1179) / 100 + Client.field1179;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if(var7 < Client.field1185) {
         var10 = Client.field1185;
         var6 = var2 * var10 * 334 / (var3 * 512);
         if(var6 > Client.field1184) {
            var6 = Client.field1184;
            var8 = var3 * var6 * 512 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4983(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4983(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1186) {
         var10 = Client.field1186;
         var6 = var2 * var10 * 334 / (var3 * 512);
         if(var6 < Client.field1166) {
            var6 = Client.field1166;
            var8 = var2 * var10 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4983(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4983(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = var5 * (Client.field1182 - Client.field1126) / 100 + Client.field1126;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var11 = new int[9];

         for(int var12 = 0; var12 < 9; ++var12) {
            int var13 = var12 * 32 + 128 + 15;
            int var14 = var13 * 3 + 600;
            int var15 = Graphics3D.SINE[var13];
            var11[var12] = var15 * var14 >> 16;
         }

         Region.method2701(var11, 500, 800, var2, var3);
      }

      Client.field1187 = var0;
      Client.field1188 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
