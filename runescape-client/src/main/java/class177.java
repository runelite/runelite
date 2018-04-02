import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class177 {
   @ObfuscatedName("o")
   static int[][] field2274;
   @ObfuscatedName("j")
   static int[][] field2275;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -546794847
   )
   static int field2277;
   @ObfuscatedName("p")
   static int[] field2272;
   @ObfuscatedName("w")
   static int[] field2276;

   static {
      field2274 = new int[128][128];
      field2275 = new int[128][128];
      field2272 = new int[4096];
      field2276 = new int[4096];
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1907804011"
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
         Client.field958 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FaceNormal.method3078(ClientPacket.field2422, Client.field902.field1475);
         var8.packetBuffer.method3648(BaseVarType.baseY + var1);
         var8.packetBuffer.method3619(class49.selectedItemIndex);
         var8.packetBuffer.method3670(Client.field900);
         var8.packetBuffer.method3648(MessageNode.field813);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3554(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(var0 + PacketNode.baseX);
         Client.field902.method2036(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field958 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FaceNormal.method3078(ClientPacket.field2420, Client.field902.field1475);
         var8.packetBuffer.method3554(Client.field1012);
         var8.packetBuffer.method3619(var3 >> 14 & 32767);
         var8.packetBuffer.method3563(SoundTaskDataProvider.field623);
         var8.packetBuffer.method3648(var0 + PacketNode.baseX);
         var8.packetBuffer.method3690(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(BaseVarType.baseY + var1);
         Client.field902.method2036(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field958 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FaceNormal.method3078(ClientPacket.field2419, Client.field902.field1475);
         var8.packetBuffer.method3648(var0 + PacketNode.baseX);
         var8.packetBuffer.method3648(var3 >> 14 & 32767);
         var8.packetBuffer.method3619(BaseVarType.baseY + var1);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         Client.field902.method2036(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field958 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FaceNormal.method3078(ClientPacket.field2381, Client.field902.field1475);
         var8.packetBuffer.putShort(var0 + PacketNode.baseX);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3648(BaseVarType.baseY + var1);
         var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
         Client.field902.method2036(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field958 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FaceNormal.method3078(ClientPacket.field2415, Client.field902.field1475);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3648(var0 + PacketNode.baseX);
         var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(BaseVarType.baseY + var1);
         Client.field902.method2036(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field958 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = FaceNormal.method3078(ClientPacket.field2448, Client.field902.field1475);
         var8.packetBuffer.putShort(BaseVarType.baseY + var1);
         var8.packetBuffer.method3554(var0 + PacketNode.baseX);
         var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3648(var3 >> 14 & 32767);
         Client.field902.method2036(var8);
      } else {
         PacketNode var9;
         NPC var18;
         if(var2 == 7) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = FaceNormal.method3078(ClientPacket.field2452, Client.field902.field1475);
               var9.packetBuffer.method3648(class49.selectedItemIndex);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3670(Client.field900);
               var9.packetBuffer.putShort(MessageNode.field813);
               var9.packetBuffer.putShort(var3);
               Client.field902.method2036(var9);
            }
         } else if(var2 == 8) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = FaceNormal.method3078(ClientPacket.field2392, Client.field902.field1475);
               var9.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3670(SoundTaskDataProvider.field623);
               var9.packetBuffer.method3619(Client.field1012);
               var9.packetBuffer.method3554(var3);
               Client.field902.method2036(var9);
            }
         } else if(var2 == 9) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = FaceNormal.method3078(ClientPacket.field2472, Client.field902.field1475);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
               Client.field902.method2036(var9);
            }
         } else if(var2 == 10) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = FaceNormal.method3078(ClientPacket.field2404, Client.field902.field1475);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3648(var3);
               Client.field902.method2036(var9);
            }
         } else if(var2 == 11) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = FaceNormal.method3078(ClientPacket.field2406, Client.field902.field1475);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3648(var3);
               Client.field902.method2036(var9);
            }
         } else if(var2 == 12) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = FaceNormal.method3078(ClientPacket.field2387, Client.field902.field1475);
               var9.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3619(var3);
               Client.field902.method2036(var9);
            }
         } else if(var2 == 13) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = FaceNormal.method3078(ClientPacket.field2418, Client.field902.field1475);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3619(var3);
               Client.field902.method2036(var9);
            }
         } else {
            Player var20;
            if(var2 == 14) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field958 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = FaceNormal.method3078(ClientPacket.field2426, Client.field902.field1475);
                  var9.packetBuffer.method3677(Client.field900);
                  var9.packetBuffer.method3648(class49.selectedItemIndex);
                  var9.packetBuffer.method3554(MessageNode.field813);
                  var9.packetBuffer.method3619(var3);
                  var9.packetBuffer.method3690(KeyFocusListener.keyPressed[82]?1:0);
                  Client.field902.method2036(var9);
               }
            } else if(var2 == 15) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field958 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = FaceNormal.method3078(ClientPacket.field2446, Client.field902.field1475);
                  var9.packetBuffer.putShort(var3);
                  var9.packetBuffer.method3670(SoundTaskDataProvider.field623);
                  var9.packetBuffer.putShort(Client.field1012);
                  var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                  Client.field902.method2036(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FaceNormal.method3078(ClientPacket.field2372, Client.field902.field1475);
               var8.packetBuffer.method3648(class49.selectedItemIndex);
               var8.packetBuffer.method3554(var0 + PacketNode.baseX);
               var8.packetBuffer.method3619(var3);
               var8.packetBuffer.method3619(BaseVarType.baseY + var1);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3677(Client.field900);
               var8.packetBuffer.method3619(MessageNode.field813);
               Client.field902.method2036(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FaceNormal.method3078(ClientPacket.field2460, Client.field902.field1475);
               var8.packetBuffer.method3563(SoundTaskDataProvider.field623);
               var8.packetBuffer.putShort(Client.field1012);
               var8.packetBuffer.method3648(var0 + PacketNode.baseX);
               var8.packetBuffer.method3648(BaseVarType.baseY + var1);
               var8.packetBuffer.method3648(var3);
               var8.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
               Client.field902.method2036(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FaceNormal.method3078(ClientPacket.field2388, Client.field902.field1475);
               var8.packetBuffer.method3648(var0 + PacketNode.baseX);
               var8.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(BaseVarType.baseY + var1);
               var8.packetBuffer.method3554(var3);
               Client.field902.method2036(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FaceNormal.method3078(ClientPacket.field2447, Client.field902.field1475);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3619(BaseVarType.baseY + var1);
               var8.packetBuffer.method3648(var0 + PacketNode.baseX);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               Client.field902.method2036(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FaceNormal.method3078(ClientPacket.field2458, Client.field902.field1475);
               var8.packetBuffer.method3648(var0 + PacketNode.baseX);
               var8.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3648(var3);
               var8.packetBuffer.putShort(BaseVarType.baseY + var1);
               Client.field902.method2036(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FaceNormal.method3078(ClientPacket.field2456, Client.field902.field1475);
               var8.packetBuffer.method3648(var0 + PacketNode.baseX);
               var8.packetBuffer.method3690(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3554(BaseVarType.baseY + var1);
               var8.packetBuffer.putShort(var3);
               Client.field902.method2036(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field958 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = FaceNormal.method3078(ClientPacket.field2375, Client.field902.field1475);
               var8.packetBuffer.putShort(BaseVarType.baseY + var1);
               var8.packetBuffer.method3619(var3);
               var8.packetBuffer.putShort(var0 + PacketNode.baseX);
               var8.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
               Client.field902.method2036(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class308.region.method3061();
               } else {
                  class308.region.method3046(class237.plane, var0, var1, true);
               }
            } else {
               PacketNode var17;
               Widget var22;
               if(var2 == 24) {
                  var22 = class3.getWidget(var1);
                  boolean var16 = true;
                  if(var22.contentType > 0) {
                     var16 = class240.method4437(var22);
                  }

                  if(var16) {
                     var17 = FaceNormal.method3078(ClientPacket.field2421, Client.field902.field1475);
                     var17.packetBuffer.putInt(var1);
                     Client.field902.method2036(var17);
                  }
               } else {
                  if(var2 == 25) {
                     var22 = ClientPacket.getWidgetChild(var1, var0);
                     if(var22 != null) {
                        class3.method4();
                        int var12 = class45.getWidgetClickMask(var22);
                        int var11 = var12 >> 11 & 63;
                        class18.method156(var1, var0, var11, var22.itemId);
                        Client.itemSelectionState = 0;
                        int var15 = class45.getWidgetClickMask(var22);
                        int var14 = var15 >> 11 & 63;
                        String var13;
                        if(var14 == 0) {
                           var13 = null;
                        } else if(var22.targetVerb != null && var22.targetVerb.trim().length() != 0) {
                           var13 = var22.targetVerb;
                        } else {
                           var13 = null;
                        }

                        Client.field956 = var13;
                        if(Client.field956 == null) {
                           Client.field956 = "Null";
                        }

                        if(var22.hasScript) {
                           Client.field1015 = var22.opBase + class173.getColTags(16777215);
                        } else {
                           Client.field1015 = class173.getColTags(65280) + var22.spellName + class173.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     var8 = FaceNormal.method3078(ClientPacket.field2403, Client.field902.field1475);
                     Client.field902.method2036(var8);

                     for(WidgetNode var19 = (WidgetNode)Client.componentTable.first(); var19 != null; var19 = (WidgetNode)Client.componentTable.next()) {
                        if(var19.owner == 0 || var19.owner == 3) {
                           class44.closeWidget(var19, true);
                        }
                     }

                     if(Client.field1102 != null) {
                        WorldMapType1.method274(Client.field1102);
                        Client.field1102 = null;
                     }
                  } else {
                     int var10;
                     Widget var21;
                     if(var2 == 28) {
                        var8 = FaceNormal.method3078(ClientPacket.field2421, Client.field902.field1475);
                        var8.packetBuffer.putInt(var1);
                        Client.field902.method2036(var8);
                        var21 = class3.getWidget(var1);
                        if(var21.dynamicValues != null && var21.dynamicValues[0][0] == 5) {
                           var10 = var21.dynamicValues[0][1];
                           class237.clientVarps[var10] = 1 - class237.clientVarps[var10];
                           class93.method1950(var10);
                        }
                     } else if(var2 == 29) {
                        var8 = FaceNormal.method3078(ClientPacket.field2421, Client.field902.field1475);
                        var8.packetBuffer.putInt(var1);
                        Client.field902.method2036(var8);
                        var21 = class3.getWidget(var1);
                        if(var21.dynamicValues != null && var21.dynamicValues[0][0] == 5) {
                           var10 = var21.dynamicValues[0][1];
                           if(class237.clientVarps[var10] != var21.field2928[0]) {
                              class237.clientVarps[var10] = var21.field2928[0];
                              class93.method1950(var10);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1102 == null) {
                           DynamicObject.method2019(var1, var0);
                           Client.field1102 = ClientPacket.getWidgetChild(var1, var0);
                           WorldMapType1.method274(Client.field1102);
                        }
                     } else if(var2 == 31) {
                        var8 = FaceNormal.method3078(ClientPacket.field2423, Client.field902.field1475);
                        var8.packetBuffer.method3648(var3);
                        var8.packetBuffer.method3648(class49.selectedItemIndex);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3563(Client.field900);
                        var8.packetBuffer.method3619(MessageNode.field813);
                        var8.packetBuffer.method3554(var0);
                        Client.field902.method2036(var8);
                        Client.mouseCrosshair = 0;
                        class64.field750 = class3.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = FaceNormal.method3078(ClientPacket.field2461, Client.field902.field1475);
                        var8.packetBuffer.method3619(var3);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3648(var0);
                        var8.packetBuffer.putInt(SoundTaskDataProvider.field623);
                        var8.packetBuffer.method3554(Client.field1012);
                        Client.field902.method2036(var8);
                        Client.mouseCrosshair = 0;
                        class64.field750 = class3.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = FaceNormal.method3078(ClientPacket.field2466, Client.field902.field1475);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3563(var1);
                        var8.packetBuffer.putShort(var3);
                        Client.field902.method2036(var8);
                        Client.mouseCrosshair = 0;
                        class64.field750 = class3.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = FaceNormal.method3078(ClientPacket.field2430, Client.field902.field1475);
                        var8.packetBuffer.method3677(var1);
                        var8.packetBuffer.method3648(var0);
                        var8.packetBuffer.putShort(var3);
                        Client.field902.method2036(var8);
                        Client.mouseCrosshair = 0;
                        class64.field750 = class3.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = FaceNormal.method3078(ClientPacket.field2391, Client.field902.field1475);
                        var8.packetBuffer.method3648(var0);
                        var8.packetBuffer.method3619(var3);
                        var8.packetBuffer.method3563(var1);
                        Client.field902.method2036(var8);
                        Client.mouseCrosshair = 0;
                        class64.field750 = class3.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = FaceNormal.method3078(ClientPacket.field2376, Client.field902.field1475);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3563(var1);
                        var8.packetBuffer.method3554(var0);
                        Client.field902.method2036(var8);
                        Client.mouseCrosshair = 0;
                        class64.field750 = class3.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = FaceNormal.method3078(ClientPacket.field2409, Client.field902.field1475);
                        var8.packetBuffer.method3554(var3);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.putInt(var1);
                        Client.field902.method2036(var8);
                        Client.mouseCrosshair = 0;
                        class64.field750 = class3.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           class3.method4();
                           var22 = class3.getWidget(var1);
                           Client.itemSelectionState = 1;
                           class49.selectedItemIndex = var0;
                           Client.field900 = var1;
                           MessageNode.field813 = var3;
                           WorldMapType1.method274(var22);
                           Client.lastSelectedItemName = class173.getColTags(16748608) + GameObject.getItemDefinition(var3).name + class173.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = FaceNormal.method3078(ClientPacket.field2378, Client.field902.field1475);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.method3554(var3);
                           Client.field902.method2036(var8);
                           Client.mouseCrosshair = 0;
                           class64.field750 = class3.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = FaceNormal.method3078(ClientPacket.field2410, Client.field902.field1475);
                           var8.packetBuffer.method3563(var1);
                           var8.packetBuffer.method3554(var3);
                           var8.packetBuffer.method3648(var0);
                           Client.field902.method2036(var8);
                           Client.mouseCrosshair = 0;
                           class64.field750 = class3.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = FaceNormal.method3078(ClientPacket.field2436, Client.field902.field1475);
                           var8.packetBuffer.method3648(var3);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.method3619(var0);
                           Client.field902.method2036(var8);
                           Client.mouseCrosshair = 0;
                           class64.field750 = class3.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = FaceNormal.method3078(ClientPacket.field2437, Client.field902.field1475);
                           var8.packetBuffer.method3648(var3);
                           var8.packetBuffer.method3563(var1);
                           var8.packetBuffer.method3554(var0);
                           Client.field902.method2036(var8);
                           Client.mouseCrosshair = 0;
                           class64.field750 = class3.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = FaceNormal.method3078(ClientPacket.field2432, Client.field902.field1475);
                           var8.packetBuffer.method3619(var0);
                           var8.packetBuffer.method3677(var1);
                           var8.packetBuffer.method3554(var3);
                           Client.field902.method2036(var8);
                           Client.mouseCrosshair = 0;
                           class64.field750 = class3.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2431, Client.field902.field1475);
                              var9.packetBuffer.method3648(var3);
                              var9.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 == 45) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2402, Client.field902.field1475);
                              var9.packetBuffer.method3554(var3);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 == 46) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2405, Client.field902.field1475);
                              var9.packetBuffer.method3648(var3);
                              var9.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 == 47) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2468, Client.field902.field1475);
                              var9.packetBuffer.method3554(var3);
                              var9.packetBuffer.method3690(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 == 48) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2393, Client.field902.field1475);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3690(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 == 49) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2377, Client.field902.field1475);
                              var9.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 == 50) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2435, Client.field902.field1475);
                              var9.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3619(var3);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 == 51) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = FaceNormal.method3078(ClientPacket.field2469, Client.field902.field1475);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3554(var3);
                              Client.field902.method2036(var9);
                           }
                        } else if(var2 != 1007 && var2 != 57) {
                           if(var2 == 58) {
                              var22 = ClientPacket.getWidgetChild(var1, var0);
                              if(var22 != null) {
                                 var9 = FaceNormal.method3078(ClientPacket.field2438, Client.field902.field1475);
                                 var9.packetBuffer.method3554(var22.itemId);
                                 var9.packetBuffer.putInt(SoundTaskDataProvider.field623);
                                 var9.packetBuffer.method3554(Client.field1012);
                                 var9.packetBuffer.method3563(var1);
                                 var9.packetBuffer.method3554(Client.field1013);
                                 var9.packetBuffer.method3648(var0);
                                 Client.field902.method2036(var9);
                              }
                           } else if(var2 == 1001) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var8 = FaceNormal.method3078(ClientPacket.field2442, Client.field902.field1475);
                              var8.packetBuffer.putShort(BaseVarType.baseY + var1);
                              var8.packetBuffer.method3648(var3 >> 14 & 32767);
                              var8.packetBuffer.method3648(var0 + PacketNode.baseX);
                              var8.packetBuffer.method3544(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field902.method2036(var8);
                           } else if(var2 == 1002) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              var8 = FaceNormal.method3078(ClientPacket.field2429, Client.field902.field1475);
                              var8.packetBuffer.method3554(var3 >> 14 & 32767);
                              Client.field902.method2036(var8);
                           } else if(var2 == 1003) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              var18 = Client.cachedNPCs[var3];
                              if(var18 != null) {
                                 NPCComposition var23 = var18.composition;
                                 if(var23.configs != null) {
                                    var23 = var23.transform();
                                 }

                                 if(var23 != null) {
                                    var17 = FaceNormal.method3078(ClientPacket.field2471, Client.field902.field1475);
                                    var17.packetBuffer.method3648(var23.id);
                                    Client.field902.method2036(var17);
                                 }
                              }
                           } else if(var2 == 1004) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field958 = 0;
                              var8 = FaceNormal.method3078(ClientPacket.field2443, Client.field902.field1475);
                              var8.packetBuffer.method3554(var3);
                              Client.field902.method2036(var8);
                           } else if(var2 == 1005) {
                              var22 = class3.getWidget(var1);
                              if(var22 != null && var22.itemQuantities[var0] >= 100000) {
                                 class189.sendGameMessage(27, "", var22.itemQuantities[var0] + " x " + GameObject.getItemDefinition(var3).name);
                              } else {
                                 var9 = FaceNormal.method3078(ClientPacket.field2443, Client.field902.field1475);
                                 var9.packetBuffer.method3554(var3);
                                 Client.field902.method2036(var9);
                              }

                              Client.mouseCrosshair = 0;
                              class64.field750 = class3.getWidget(var1);
                              Client.pressedItemIndex = var0;
                           } else if(var2 == 1010 || var2 == 1008 || var2 == 1009 || var2 == 1011 || var2 == 1012) {
                              ScriptState.renderOverview.onMapClicked(var2, var3, new Coordinates(var0), new Coordinates(var1));
                           }
                        } else {
                           var22 = ClientPacket.getWidgetChild(var1, var0);
                           if(var22 != null) {
                              BuildType.method4537(var3, var1, var0, var22.itemId, var5);
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
         WorldMapType1.method274(class3.getWidget(Client.field900));
      }

      if(Client.spellSelected) {
         class3.method4();
      }

      if(class64.field750 != null && Client.mouseCrosshair == 0) {
         WorldMapType1.method274(class64.field750);
      }

   }
}
