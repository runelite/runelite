import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class3 implements class0 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1248675555
   )
   static int field18;

   @ObfuscatedName("q")
   public static String method6(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class316.field3924[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "807606546"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1088 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class33.method382(ClientPacket.field2353, Client.field1072.field1456);
         var8.packetBuffer.method3570(var0 + class38.baseX);
         var8.packetBuffer.method3519(var3 >> 14 & 32767);
         var8.packetBuffer.method3582(SoundTaskDataProvider.field619);
         var8.packetBuffer.putShort(BaseVarType.field26);
         var8.packetBuffer.method3619(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3573(class271.selectedItemIndex);
         var8.packetBuffer.method3573(PlayerComposition.baseY + var1);
         Client.field1072.method2073(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1088 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class33.method382(ClientPacket.field2356, Client.field1072.field1456);
         var8.packetBuffer.method3519(var3 >> 14 & 32767);
         var8.packetBuffer.method3519(var0 + class38.baseX);
         var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(Client.field1050);
         var8.packetBuffer.method3582(Resampler.field1597);
         var8.packetBuffer.method3573(PlayerComposition.baseY + var1);
         Client.field1072.method2073(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1088 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class33.method382(ClientPacket.field2370, Client.field1072.field1456);
         var8.packetBuffer.method3519(PlayerComposition.baseY + var1);
         var8.packetBuffer.method3570(var0 + class38.baseX);
         var8.packetBuffer.method3570(var3 >> 14 & 32767);
         var8.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
         Client.field1072.method2073(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1088 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class33.method382(ClientPacket.field2408, Client.field1072.field1456);
         var8.packetBuffer.putShort(var0 + class38.baseX);
         var8.packetBuffer.method3570(var3 >> 14 & 32767);
         var8.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3570(PlayerComposition.baseY + var1);
         Client.field1072.method2073(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1088 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class33.method382(ClientPacket.field2368, Client.field1072.field1456);
         var8.packetBuffer.method3519(var0 + class38.baseX);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3573(PlayerComposition.baseY + var1);
         var8.packetBuffer.method3573(var3 >> 14 & 32767);
         Client.field1072.method2073(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1088 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class33.method382(ClientPacket.field2401, Client.field1072.field1456);
         var8.packetBuffer.putShort(PlayerComposition.baseY + var1);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3573(var0 + class38.baseX);
         Client.field1072.method2073(var8);
      } else {
         PacketNode var9;
         NPC var19;
         if(var2 == 7) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class33.method382(ClientPacket.field2441, Client.field1072.field1456);
               var9.packetBuffer.method3582(SoundTaskDataProvider.field619);
               var9.packetBuffer.method3573(var3);
               var9.packetBuffer.method3519(BaseVarType.field26);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3570(class271.selectedItemIndex);
               Client.field1072.method2073(var9);
            }
         } else if(var2 == 8) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class33.method382(ClientPacket.field2383, Client.field1072.field1456);
               var9.packetBuffer.method3573(var3);
               var9.packetBuffer.method3570(Client.field1050);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3582(Resampler.field1597);
               Client.field1072.method2073(var9);
            }
         } else if(var2 == 9) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class33.method382(ClientPacket.field2434, Client.field1072.field1456);
               var9.packetBuffer.method3519(var3);
               var9.packetBuffer.method3619(KeyFocusListener.keyPressed[82]?1:0);
               Client.field1072.method2073(var9);
            }
         } else if(var2 == 10) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class33.method382(ClientPacket.field2382, Client.field1072.field1456);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field1072.method2073(var9);
            }
         } else if(var2 == 11) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class33.method382(ClientPacket.field2436, Client.field1072.field1456);
               var9.packetBuffer.method3573(var3);
               var9.packetBuffer.method3619(KeyFocusListener.keyPressed[82]?1:0);
               Client.field1072.method2073(var9);
            }
         } else if(var2 == 12) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class33.method382(ClientPacket.field2378, Client.field1072.field1456);
               var9.packetBuffer.method3619(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3570(var3);
               Client.field1072.method2073(var9);
            }
         } else if(var2 == 13) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class33.method382(ClientPacket.field2410, Client.field1072.field1456);
               var9.packetBuffer.method3573(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field1072.method2073(var9);
            }
         } else {
            Player var21;
            if(var2 == 14) {
               var21 = Client.cachedPlayers[var3];
               if(var21 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field1088 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class33.method382(ClientPacket.field2357, Client.field1072.field1456);
                  var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.putShort(class271.selectedItemIndex);
                  var9.packetBuffer.method3519(BaseVarType.field26);
                  var9.packetBuffer.method3584(SoundTaskDataProvider.field619);
                  var9.packetBuffer.method3519(var3);
                  Client.field1072.method2073(var9);
               }
            } else if(var2 == 15) {
               var21 = Client.cachedPlayers[var3];
               if(var21 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field1088 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class33.method382(ClientPacket.field2359, Client.field1072.field1456);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.putInt(Resampler.field1597);
                  var9.packetBuffer.method3573(Client.field1050);
                  var9.packetBuffer.method3573(var3);
                  Client.field1072.method2073(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class33.method382(ClientPacket.field2377, Client.field1072.field1456);
               var8.packetBuffer.method3573(class271.selectedItemIndex);
               var8.packetBuffer.method3570(PlayerComposition.baseY + var1);
               var8.packetBuffer.putInt(SoundTaskDataProvider.field619);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3570(var0 + class38.baseX);
               var8.packetBuffer.method3519(BaseVarType.field26);
               var8.packetBuffer.putShort(var3);
               Client.field1072.method2073(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class33.method382(ClientPacket.field2413, Client.field1072.field1456);
               var8.packetBuffer.method3519(PlayerComposition.baseY + var1);
               var8.packetBuffer.method3573(var0 + class38.baseX);
               var8.packetBuffer.putInt(Resampler.field1597);
               var8.packetBuffer.method3519(Client.field1050);
               var8.packetBuffer.method3573(var3);
               var8.packetBuffer.method3619(KeyFocusListener.keyPressed[82]?1:0);
               Client.field1072.method2073(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class33.method382(ClientPacket.field2385, Client.field1072.field1456);
               var8.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(PlayerComposition.baseY + var1);
               var8.packetBuffer.method3573(var0 + class38.baseX);
               var8.packetBuffer.putShort(var3);
               Client.field1072.method2073(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class33.method382(ClientPacket.field2443, Client.field1072.field1456);
               var8.packetBuffer.method3573(PlayerComposition.baseY + var1);
               var8.packetBuffer.method3570(var3);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3519(var0 + class38.baseX);
               Client.field1072.method2073(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class33.method382(ClientPacket.field2354, Client.field1072.field1456);
               var8.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3519(var3);
               var8.packetBuffer.method3519(PlayerComposition.baseY + var1);
               var8.packetBuffer.method3573(var0 + class38.baseX);
               Client.field1072.method2073(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class33.method382(ClientPacket.field2374, Client.field1072.field1456);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(PlayerComposition.baseY + var1);
               var8.packetBuffer.putShort(var0 + class38.baseX);
               var8.packetBuffer.method3573(var3);
               Client.field1072.method2073(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1088 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class33.method382(ClientPacket.field2411, Client.field1072.field1456);
               var8.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3570(var3);
               var8.packetBuffer.method3519(PlayerComposition.baseY + var1);
               var8.packetBuffer.method3519(var0 + class38.baseX);
               Client.field1072.method2073(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class38.region.method2904();
               } else {
                  class38.region.method2973(Ignore.plane, var0, var1, true);
               }
            } else {
               PacketNode var16;
               Widget var23;
               if(var2 == 24) {
                  var23 = GZipDecompressor.getWidget(var1);
                  boolean var15 = true;
                  if(var23.contentType > 0) {
                     var15 = WorldMapManager.method644(var23);
                  }

                  if(var15) {
                     var16 = class33.method382(ClientPacket.field2414, Client.field1072.field1456);
                     var16.packetBuffer.putInt(var1);
                     Client.field1072.method2073(var16);
                  }
               } else {
                  int var10;
                  int var24;
                  if(var2 == 25) {
                     var23 = CollisionData.getWidgetChild(var1, var0);
                     if(var23 != null) {
                        Fonts.method5482();
                        var10 = GrandExchangeEvent.getWidgetConfig(var23);
                        var24 = var10 >> 11 & 63;
                        int var12 = var23.itemId;
                        Widget var13 = CollisionData.getWidgetChild(var1, var0);
                        if(var13 != null && var13.field2908 != null) {
                           ScriptEvent var14 = new ScriptEvent();
                           var14.widget = var13;
                           var14.objs = var13.field2908;
                           class25.runScript(var14, 500000);
                        }

                        Client.field980 = var12;
                        Client.spellSelected = true;
                        Resampler.field1597 = var1;
                        Client.field1050 = var0;
                        class150.field2100 = var24;
                        GameEngine.method1053(var13);
                        Client.itemSelectionState = 0;
                        Client.field1006 = class21.method172(var23);
                        if(Client.field1006 == null) {
                           Client.field1006 = "Null";
                        }

                        if(var23.hasScript) {
                           Client.field1074 = var23.name + class37.getColTags(16777215);
                        } else {
                           Client.field1074 = class37.getColTags(65280) + var23.spellName + class37.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     var8 = class33.method382(ClientPacket.field2399, Client.field1072.field1456);
                     Client.field1072.method2073(var8);

                     for(WidgetNode var20 = (WidgetNode)Client.componentTable.first(); var20 != null; var20 = (WidgetNode)Client.componentTable.next()) {
                        if(var20.owner == 0 || var20.owner == 3) {
                           class93.closeWidget(var20, true);
                        }
                     }

                     if(Client.field1012 != null) {
                        GameEngine.method1053(Client.field1012);
                        Client.field1012 = null;
                     }
                  } else {
                     Widget var22;
                     if(var2 == 28) {
                        var8 = class33.method382(ClientPacket.field2414, Client.field1072.field1456);
                        var8.packetBuffer.putInt(var1);
                        Client.field1072.method2073(var8);
                        var22 = GZipDecompressor.getWidget(var1);
                        if(var22.dynamicValues != null && var22.dynamicValues[0][0] == 5) {
                           var10 = var22.dynamicValues[0][1];
                           class237.widgetSettings[var10] = 1 - class237.widgetSettings[var10];
                           class5.method14(var10);
                        }
                     } else if(var2 == 29) {
                        var8 = class33.method382(ClientPacket.field2414, Client.field1072.field1456);
                        var8.packetBuffer.putInt(var1);
                        Client.field1072.method2073(var8);
                        var22 = GZipDecompressor.getWidget(var1);
                        if(var22.dynamicValues != null && var22.dynamicValues[0][0] == 5) {
                           var10 = var22.dynamicValues[0][1];
                           if(class237.widgetSettings[var10] != var22.field2931[0]) {
                              class237.widgetSettings[var10] = var22.field2931[0];
                              class5.method14(var10);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1012 == null) {
                           class270.method4793(var1, var0);
                           Client.field1012 = CollisionData.getWidgetChild(var1, var0);
                           GameEngine.method1053(Client.field1012);
                        }
                     } else if(var2 == 31) {
                        var8 = class33.method382(ClientPacket.field2407, Client.field1072.field1456);
                        var8.packetBuffer.method3584(var1);
                        var8.packetBuffer.putShort(BaseVarType.field26);
                        var8.packetBuffer.putShort(class271.selectedItemIndex);
                        var8.packetBuffer.method3713(SoundTaskDataProvider.field619);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.putShort(var3);
                        Client.field1072.method2073(var8);
                        Client.mouseCrosshair = 0;
                        MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = class33.method382(ClientPacket.field2363, Client.field1072.field1456);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3570(var3);
                        var8.packetBuffer.method3519(var0);
                        var8.packetBuffer.putInt(Resampler.field1597);
                        var8.packetBuffer.method3570(Client.field1050);
                        Client.field1072.method2073(var8);
                        Client.mouseCrosshair = 0;
                        MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = class33.method382(ClientPacket.field2395, Client.field1072.field1456);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3584(var1);
                        var8.packetBuffer.method3570(var0);
                        Client.field1072.method2073(var8);
                        Client.mouseCrosshair = 0;
                        MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = class33.method382(ClientPacket.field2416, Client.field1072.field1456);
                        var8.packetBuffer.method3573(var3);
                        var8.packetBuffer.method3519(var0);
                        var8.packetBuffer.method3582(var1);
                        Client.field1072.method2073(var8);
                        Client.mouseCrosshair = 0;
                        MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = class33.method382(ClientPacket.field2366, Client.field1072.field1456);
                        var8.packetBuffer.method3582(var1);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3573(var0);
                        Client.field1072.method2073(var8);
                        Client.mouseCrosshair = 0;
                        MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = class33.method382(ClientPacket.field2421, Client.field1072.field1456);
                        var8.packetBuffer.method3519(var3);
                        var8.packetBuffer.method3713(var1);
                        var8.packetBuffer.method3573(var0);
                        Client.field1072.method2073(var8);
                        Client.mouseCrosshair = 0;
                        MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = class33.method382(ClientPacket.field2364, Client.field1072.field1456);
                        var8.packetBuffer.method3519(var3);
                        var8.packetBuffer.method3713(var1);
                        var8.packetBuffer.method3573(var0);
                        Client.field1072.method2073(var8);
                        Client.mouseCrosshair = 0;
                        MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           Fonts.method5482();
                           var23 = GZipDecompressor.getWidget(var1);
                           Client.itemSelectionState = 1;
                           class271.selectedItemIndex = var0;
                           SoundTaskDataProvider.field619 = var1;
                           BaseVarType.field26 = var3;
                           GameEngine.method1053(var23);
                           Client.lastSelectedItemName = class37.getColTags(16748608) + class81.getItemDefinition(var3).name + class37.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = class33.method382(ClientPacket.field2435, Client.field1072.field1456);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3570(var3);
                           var8.packetBuffer.method3582(var1);
                           Client.field1072.method2073(var8);
                           Client.mouseCrosshair = 0;
                           MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = class33.method382(ClientPacket.field2362, Client.field1072.field1456);
                           var8.packetBuffer.method3573(var3);
                           var8.packetBuffer.method3713(var1);
                           var8.packetBuffer.method3570(var0);
                           Client.field1072.method2073(var8);
                           Client.mouseCrosshair = 0;
                           MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = class33.method382(ClientPacket.field2371, Client.field1072.field1456);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.method3570(var0);
                           var8.packetBuffer.putInt(var1);
                           Client.field1072.method2073(var8);
                           Client.mouseCrosshair = 0;
                           MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = class33.method382(ClientPacket.field2365, Client.field1072.field1456);
                           var8.packetBuffer.method3570(var3);
                           var8.packetBuffer.method3582(var1);
                           var8.packetBuffer.method3519(var0);
                           Client.field1072.method2073(var8);
                           Client.mouseCrosshair = 0;
                           MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = class33.method382(ClientPacket.field2376, Client.field1072.field1456);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3573(var3);
                           var8.packetBuffer.method3582(var1);
                           Client.field1072.method2073(var8);
                           Client.mouseCrosshair = 0;
                           MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2446, Client.field1072.field1456);
                              var9.packetBuffer.method3619(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3573(var3);
                              Client.field1072.method2073(var9);
                           }
                        } else if(var2 == 45) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2402, Client.field1072.field1456);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field1072.method2073(var9);
                           }
                        } else if(var2 == 46) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2403, Client.field1072.field1456);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field1072.method2073(var9);
                           }
                        } else if(var2 == 47) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2360, Client.field1072.field1456);
                              var9.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3573(var3);
                              Client.field1072.method2073(var9);
                           }
                        } else if(var2 == 48) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2444, Client.field1072.field1456);
                              var9.packetBuffer.method3570(var3);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field1072.method2073(var9);
                           }
                        } else if(var2 == 49) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2350, Client.field1072.field1456);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field1072.method2073(var9);
                           }
                        } else if(var2 == 50) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2433, Client.field1072.field1456);
                              var9.packetBuffer.method3562(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3570(var3);
                              Client.field1072.method2073(var9);
                           }
                        } else if(var2 == 51) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1088 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class33.method382(ClientPacket.field2398, Client.field1072.field1456);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3519(var3);
                              Client.field1072.method2073(var9);
                           }
                        } else {
                           label1161: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var23 = CollisionData.getWidgetChild(var1, var0);
                                    if(var23 != null) {
                                       var9 = class33.method382(ClientPacket.field2381, Client.field1072.field1456);
                                       var9.packetBuffer.method3573(Client.field1050);
                                       var9.packetBuffer.method3570(var23.itemId);
                                       var9.packetBuffer.putShort(Client.field980);
                                       var9.packetBuffer.method3582(var1);
                                       var9.packetBuffer.method3582(Resampler.field1597);
                                       var9.packetBuffer.method3519(var0);
                                       Client.field1072.method2073(var9);
                                    }
                                    break label1161;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field1088 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = class33.method382(ClientPacket.field2429, Client.field1072.field1456);
                                    var8.packetBuffer.method3573(var3 >> 14 & 32767);
                                    var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.method3573(var0 + class38.baseX);
                                    var8.packetBuffer.putShort(PlayerComposition.baseY + var1);
                                    Client.field1072.method2073(var8);
                                    break label1161;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field1088 = 0;
                                    var8 = class33.method382(ClientPacket.field2393, Client.field1072.field1456);
                                    var8.packetBuffer.method3570(var3 >> 14 & 32767);
                                    Client.field1072.method2073(var8);
                                    break label1161;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field1088 = 0;
                                    var19 = Client.cachedNPCs[var3];
                                    if(var19 != null) {
                                       NPCComposition var26 = var19.composition;
                                       if(var26.configs != null) {
                                          var26 = var26.transform();
                                       }

                                       if(var26 != null) {
                                          var16 = class33.method382(ClientPacket.field2417, Client.field1072.field1456);
                                          var16.packetBuffer.method3570(var26.id);
                                          Client.field1072.method2073(var16);
                                       }
                                    }
                                    break label1161;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field1088 = 0;
                                    var8 = class33.method382(ClientPacket.field2392, Client.field1072.field1456);
                                    var8.packetBuffer.method3573(var3);
                                    Client.field1072.method2073(var8);
                                    break label1161;
                                 }

                                 if(var2 == 1005) {
                                    var23 = GZipDecompressor.getWidget(var1);
                                    if(var23 != null && var23.itemQuantities[var0] >= 100000) {
                                       TotalQuantityComparator.sendGameMessage(27, "", var23.itemQuantities[var0] + " x " + class81.getItemDefinition(var3).name);
                                    } else {
                                       var9 = class33.method382(ClientPacket.field2392, Client.field1072.field1456);
                                       var9.packetBuffer.method3573(var3);
                                       Client.field1072.method2073(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    MouseRecorder.field797 = GZipDecompressor.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label1161;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1010 || var2 == 1008 || var2 == 1009 || var2 == 1011 || var2 == 1012) {
                                       class251.renderOverview.onMapClicked(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label1161;
                                 }
                              }

                              var23 = CollisionData.getWidgetChild(var1, var0);
                              if(var23 != null) {
                                 var24 = var23.itemId;
                                 Widget var25 = CollisionData.getWidgetChild(var1, var0);
                                 if(var25 != null) {
                                    if(var25.field2917 != null) {
                                       ScriptEvent var17 = new ScriptEvent();
                                       var17.widget = var25;
                                       var17.field784 = var3;
                                       var17.string = var5;
                                       var17.objs = var25.field2917;
                                       class25.runScript(var17, 500000);
                                    }

                                    boolean var11 = true;
                                    if(var25.contentType > 0) {
                                       var11 = WorldMapManager.method644(var25);
                                    }

                                    if(var11 && class81.method1814(GrandExchangeEvent.getWidgetConfig(var25), var3 - 1)) {
                                       PacketNode var18;
                                       if(var3 == 1) {
                                          var18 = class33.method382(ClientPacket.field2380, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 2) {
                                          var18 = class33.method382(ClientPacket.field2420, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 3) {
                                          var18 = class33.method382(ClientPacket.field2375, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 4) {
                                          var18 = class33.method382(ClientPacket.field2391, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 5) {
                                          var18 = class33.method382(ClientPacket.field2419, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 6) {
                                          var18 = class33.method382(ClientPacket.field2379, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 7) {
                                          var18 = class33.method382(ClientPacket.field2367, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 8) {
                                          var18 = class33.method382(ClientPacket.field2426, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 9) {
                                          var18 = class33.method382(ClientPacket.field2355, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
                                       }

                                       if(var3 == 10) {
                                          var18 = class33.method382(ClientPacket.field2347, Client.field1072.field1456);
                                          var18.packetBuffer.putInt(var1);
                                          var18.packetBuffer.putShort(var0);
                                          var18.packetBuffer.putShort(var24);
                                          Client.field1072.method2073(var18);
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
         GameEngine.method1053(GZipDecompressor.getWidget(SoundTaskDataProvider.field619));
      }

      if(Client.spellSelected) {
         Fonts.method5482();
      }

      if(MouseRecorder.field797 != null && Client.mouseCrosshair == 0) {
         GameEngine.method1053(MouseRecorder.field797);
      }

   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(IIIILla;Liq;B)V",
      garbageValue = "-8"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2766 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class45.mapedge.method5860(var15 + (var0 + var5.field2766 / 2 - var17 / 2), var5.field2767 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         BoundingBox2D.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
