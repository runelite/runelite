import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field1914;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -658244633
   )
   static int field1912;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -925840547
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 850042175
   )
   @Export("y")
   int y;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -237349833
   )
   @Export("z")
   int z;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 875150227
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lea;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-843819694"
   )
   static final void method2665(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class222.preferences.hideRoofs = !class222.preferences.hideRoofs;
         World.method1616();
         if(class222.preferences.hideRoofs) {
            Preferences.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            Preferences.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.drawBoundingBoxes3D) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = class11.BoundingBox3DDrawMode_all;
            } else if(class11.BoundingBox3DDrawMode_all == class7.boundingBox3DDrawMode) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = class11.BoundingBox3DDrawMode_mouseOver;
            } else {
               class7.drawBoundingBoxes3D = false;
            }
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            MouseInput.method1025();
         }

         if(var0.equalsIgnoreCase("cs")) {
            Preferences.sendGameMessage(99, "", "" + Client.field918);
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode var1 = class235.method4272(ClientPacket.field2418, Client.field915.field1462);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field915.method1898(var1);
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-2068726791"
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
         Client.field964 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class235.method4272(ClientPacket.field2401, Client.field915.field1462);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShortLE(class22.field335);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(var0 + class175.baseX);
         var8.packetBuffer.writeIntLE16(class22.selectedItemIndex);
         var8.packetBuffer.writeShortLE(class33.field448);
         var8.packetBuffer.putShort(GraphicsObject.baseY + var1);
         Client.field915.method1898(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field964 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class235.method4272(ClientPacket.field2396, Client.field915.field1462);
         var8.packetBuffer.writeShortLE(SoundTaskDataProvider.field623);
         var8.packetBuffer.putShort(Client.field917);
         var8.packetBuffer.writeIntLE(var0 + class175.baseX);
         var8.packetBuffer.putShort(GraphicsObject.baseY + var1);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         Client.field915.method1898(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field964 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class235.method4272(ClientPacket.field2352, Client.field915.field1462);
         var8.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.writeIntLE(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(var0 + class175.baseX);
         var8.packetBuffer.putShortLE(GraphicsObject.baseY + var1);
         Client.field915.method1898(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field964 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class235.method4272(ClientPacket.field2394, Client.field915.field1462);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.writeIntLE16(var0 + class175.baseX);
         var8.packetBuffer.writeIntLE(GraphicsObject.baseY + var1);
         var8.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
         Client.field915.method1898(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field964 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class235.method4272(ClientPacket.field2370, Client.field915.field1462);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShortLE(GraphicsObject.baseY + var1);
         var8.packetBuffer.writeIntLE(var0 + class175.baseX);
         Client.field915.method1898(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field964 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class235.method4272(ClientPacket.field2390, Client.field915.field1462);
         var8.packetBuffer.putShortLE(GraphicsObject.baseY + var1);
         var8.packetBuffer.writeIntLE(var0 + class175.baseX);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
         Client.field915.method1898(var8);
      } else {
         PacketNode var9;
         NPC var19;
         if(var2 == 7) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class235.method4272(ClientPacket.field2359, Client.field915.field1462);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShortLE(class22.field335);
               var9.packetBuffer.method3381(class33.field448);
               var9.packetBuffer.writeIntLE(class22.selectedItemIndex);
               var9.packetBuffer.putShort(var3);
               Client.field915.method1898(var9);
            }
         } else if(var2 == 8) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class235.method4272(ClientPacket.field2380, Client.field915.field1462);
               var9.packetBuffer.writeIntLE(var3);
               var9.packetBuffer.putShortLE(Client.field917);
               var9.packetBuffer.method3381(SoundTaskDataProvider.field623);
               var9.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
               Client.field915.method1898(var9);
            }
         } else if(var2 == 9) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class235.method4272(ClientPacket.field2423, Client.field915.field1462);
               var9.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               Client.field915.method1898(var9);
            }
         } else if(var2 == 10) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class235.method4272(ClientPacket.field2391, Client.field915.field1462);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
               Client.field915.method1898(var9);
            }
         } else if(var2 == 11) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class235.method4272(ClientPacket.field2342, Client.field915.field1462);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShortLE(var3);
               Client.field915.method1898(var9);
            }
         } else if(var2 == 12) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class235.method4272(ClientPacket.field2389, Client.field915.field1462);
               var9.packetBuffer.putShortLE(var3);
               var9.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
               Client.field915.method1898(var9);
            }
         } else if(var2 == 13) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class235.method4272(ClientPacket.field2375, Client.field915.field1462);
               var9.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShortLE(var3);
               Client.field915.method1898(var9);
            }
         } else {
            Player var21;
            if(var2 == 14) {
               var21 = Client.cachedPlayers[var3];
               if(var21 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field964 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class235.method4272(ClientPacket.field2399, Client.field915.field1462);
                  var9.packetBuffer.writeIntLE16(class22.field335);
                  var9.packetBuffer.putShort(class22.selectedItemIndex);
                  var9.packetBuffer.writeIntLE16(var3);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.putInt(class33.field448);
                  Client.field915.method1898(var9);
               }
            } else if(var2 == 15) {
               var21 = Client.cachedPlayers[var3];
               if(var21 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field964 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class235.method4272(ClientPacket.field2383, Client.field915.field1462);
                  var9.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.writeIntLE16(Client.field917);
                  var9.packetBuffer.method3381(SoundTaskDataProvider.field623);
                  var9.packetBuffer.putShortLE(var3);
                  Client.field915.method1898(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class235.method4272(ClientPacket.field2338, Client.field915.field1462);
               var8.packetBuffer.writeShortLE(class33.field448);
               var8.packetBuffer.putShort(GraphicsObject.baseY + var1);
               var8.packetBuffer.putShortLE(var3);
               var8.packetBuffer.writeIntLE16(class22.field335);
               var8.packetBuffer.writeIntLE16(var0 + class175.baseX);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShortLE(class22.selectedItemIndex);
               Client.field915.method1898(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class235.method4272(ClientPacket.field2336, Client.field915.field1462);
               var8.packetBuffer.method3381(SoundTaskDataProvider.field623);
               var8.packetBuffer.putShort(GraphicsObject.baseY + var1);
               var8.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(Client.field917);
               var8.packetBuffer.writeIntLE(var0 + class175.baseX);
               var8.packetBuffer.writeIntLE(var3);
               Client.field915.method1898(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class235.method4272(ClientPacket.field2335, Client.field915.field1462);
               var8.packetBuffer.putShortLE(GraphicsObject.baseY + var1);
               var8.packetBuffer.putShort(var0 + class175.baseX);
               var8.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(var3);
               Client.field915.method1898(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class235.method4272(ClientPacket.field2402, Client.field915.field1462);
               var8.packetBuffer.writeIntLE16(var0 + class175.baseX);
               var8.packetBuffer.writeIntLE(GraphicsObject.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3362(KeyFocusListener.keyPressed[82]?1:0);
               Client.field915.method1898(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class235.method4272(ClientPacket.field2421, Client.field915.field1462);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(var3);
               var8.packetBuffer.putShort(GraphicsObject.baseY + var1);
               var8.packetBuffer.writeIntLE16(var0 + class175.baseX);
               Client.field915.method1898(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class235.method4272(ClientPacket.field2367, Client.field915.field1462);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.putShort(var0 + class175.baseX);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(GraphicsObject.baseY + var1);
               Client.field915.method1898(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field964 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class235.method4272(ClientPacket.field2414, Client.field915.field1462);
               var8.packetBuffer.writeIntLE(var0 + class175.baseX);
               var8.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(GraphicsObject.baseY + var1);
               var8.packetBuffer.writeIntLE(var3);
               Client.field915.method1898(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class45.region.method2784();
               } else {
                  class45.region.method2772(class7.plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var24;
               if(var2 == 24) {
                  var24 = UrlRequester.getWidget(var1);
                  boolean var17 = true;
                  if(var24.contentType > 0) {
                     var17 = ContextMenuRow.method1743(var24);
                  }

                  if(var17) {
                     var10 = class235.method4272(ClientPacket.field2403, Client.field915.field1462);
                     var10.packetBuffer.putInt(var1);
                     Client.field915.method1898(var10);
                  }
               } else {
                  int var16;
                  if(var2 == 25) {
                     var24 = ScriptVarType.getWidgetChild(var1, var0);
                     if(var24 != null) {
                        class72.method1129();
                        var16 = GraphicsObject.getWidgetConfig(var24);
                        int var26 = var16 >> 11 & 63;
                        int var12 = var24.itemId;
                        Widget var13 = ScriptVarType.getWidgetChild(var1, var0);
                        if(var13 != null && var13.field2836 != null) {
                           ScriptEvent var14 = new ScriptEvent();
                           var14.widget = var13;
                           var14.objs = var13.field2836;
                           Preferences.method1633(var14);
                        }

                        Client.field909 = var12;
                        Client.spellSelected = true;
                        SoundTaskDataProvider.field623 = var1;
                        Client.field917 = var0;
                        MouseRecorder.field817 = var26;
                        class28.method220(var13);
                        Client.itemSelectionState = 0;
                        int var15 = GraphicsObject.getWidgetConfig(var24);
                        int var18 = var15 >> 11 & 63;
                        String var23;
                        if(var18 == 0) {
                           var23 = null;
                        } else if(var24.selectedAction != null && var24.selectedAction.trim().length() != 0) {
                           var23 = var24.selectedAction;
                        } else {
                           var23 = null;
                        }

                        Client.field1013 = var23;
                        if(Client.field1013 == null) {
                           Client.field1013 = "Null";
                        }

                        if(var24.hasScript) {
                           Client.field1014 = var24.name + class54.getColTags(16777215);
                        } else {
                           Client.field1014 = class54.getColTags(65280) + var24.spellName + class54.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     var8 = class235.method4272(ClientPacket.field2355, Client.field915.field1462);
                     Client.field915.method1898(var8);

                     for(WidgetNode var20 = (WidgetNode)Client.componentTable.first(); var20 != null; var20 = (WidgetNode)Client.componentTable.next()) {
                        if(var20.owner == 0 || var20.owner == 3) {
                           class19.method138(var20, true);
                        }
                     }

                     if(Client.field1019 != null) {
                        class28.method220(Client.field1019);
                        Client.field1019 = null;
                     }
                  } else {
                     Widget var22;
                     if(var2 == 28) {
                        var8 = class235.method4272(ClientPacket.field2403, Client.field915.field1462);
                        var8.packetBuffer.putInt(var1);
                        Client.field915.method1898(var8);
                        var22 = UrlRequester.getWidget(var1);
                        if(var22.dynamicValues != null && var22.dynamicValues[0][0] == 5) {
                           var16 = var22.dynamicValues[0][1];
                           class222.widgetSettings[var16] = 1 - class222.widgetSettings[var16];
                           class7.method34(var16);
                        }
                     } else if(var2 == 29) {
                        var8 = class235.method4272(ClientPacket.field2403, Client.field915.field1462);
                        var8.packetBuffer.putInt(var1);
                        Client.field915.method1898(var8);
                        var22 = UrlRequester.getWidget(var1);
                        if(var22.dynamicValues != null && var22.dynamicValues[0][0] == 5) {
                           var16 = var22.dynamicValues[0][1];
                           if(class222.widgetSettings[var16] != var22.field2841[0]) {
                              class222.widgetSettings[var16] = var22.field2841[0];
                              class7.method34(var16);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1019 == null) {
                           var8 = class235.method4272(ClientPacket.field2354, Client.field915.field1462);
                           var8.packetBuffer.writeIntLE(var0);
                           var8.packetBuffer.writeShortLE(var1);
                           Client.field915.method1898(var8);
                           Client.field1019 = ScriptVarType.getWidgetChild(var1, var0);
                           class28.method220(Client.field1019);
                        }
                     } else if(var2 == 31) {
                        var8 = class235.method4272(ClientPacket.field2413, Client.field915.field1462);
                        var8.packetBuffer.writeIntLE(class22.selectedItemIndex);
                        var8.packetBuffer.writeShortLE(class33.field448);
                        var8.packetBuffer.putShort(class22.field335);
                        var8.packetBuffer.writeIntLE16(var3);
                        var8.packetBuffer.writeIntLE16(var0);
                        var8.packetBuffer.writeShortLE(var1);
                        Client.field915.method1898(var8);
                        Client.mouseCrosshair = 0;
                        WorldMapData.field438 = UrlRequester.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = class235.method4272(ClientPacket.field2366, Client.field915.field1462);
                        var8.packetBuffer.writeShortLE(var1);
                        var8.packetBuffer.writeIntLE(Client.field917);
                        var8.packetBuffer.writeShortLE(SoundTaskDataProvider.field623);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.writeIntLE16(var0);
                        Client.field915.method1898(var8);
                        Client.mouseCrosshair = 0;
                        WorldMapData.field438 = UrlRequester.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = class235.method4272(ClientPacket.field2419, Client.field915.field1462);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.method3379(var1);
                        var8.packetBuffer.writeIntLE16(var0);
                        Client.field915.method1898(var8);
                        Client.mouseCrosshair = 0;
                        WorldMapData.field438 = UrlRequester.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = class235.method4272(ClientPacket.field2425, Client.field915.field1462);
                        var8.packetBuffer.writeIntLE16(var3);
                        var8.packetBuffer.method3381(var1);
                        var8.packetBuffer.writeIntLE16(var0);
                        Client.field915.method1898(var8);
                        Client.mouseCrosshair = 0;
                        WorldMapData.field438 = UrlRequester.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = class235.method4272(ClientPacket.field2332, Client.field915.field1462);
                        var8.packetBuffer.writeShortLE(var1);
                        var8.packetBuffer.writeIntLE16(var0);
                        var8.packetBuffer.putShort(var3);
                        Client.field915.method1898(var8);
                        Client.mouseCrosshair = 0;
                        WorldMapData.field438 = UrlRequester.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = class235.method4272(ClientPacket.field2388, Client.field915.field1462);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.writeShortLE(var1);
                        Client.field915.method1898(var8);
                        Client.mouseCrosshair = 0;
                        WorldMapData.field438 = UrlRequester.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = class235.method4272(ClientPacket.field2344, Client.field915.field1462);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.putInt(var1);
                        Client.field915.method1898(var8);
                        Client.mouseCrosshair = 0;
                        WorldMapData.field438 = UrlRequester.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           class72.method1129();
                           var24 = UrlRequester.getWidget(var1);
                           Client.itemSelectionState = 1;
                           class22.selectedItemIndex = var0;
                           class33.field448 = var1;
                           class22.field335 = var3;
                           class28.method220(var24);
                           Client.lastSelectedItemName = class54.getColTags(16748608) + class115.getItemDefinition(var3).name + class54.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = class235.method4272(ClientPacket.field2381, Client.field915.field1462);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.putShort(var0);
                           Client.field915.method1898(var8);
                           Client.mouseCrosshair = 0;
                           WorldMapData.field438 = UrlRequester.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = class235.method4272(ClientPacket.field2397, Client.field915.field1462);
                           var8.packetBuffer.writeIntLE16(var3);
                           var8.packetBuffer.putShortLE(var0);
                           var8.packetBuffer.method3379(var1);
                           Client.field915.method1898(var8);
                           Client.mouseCrosshair = 0;
                           WorldMapData.field438 = UrlRequester.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = class235.method4272(ClientPacket.field2351, Client.field915.field1462);
                           var8.packetBuffer.putShortLE(var3);
                           var8.packetBuffer.writeIntLE(var0);
                           var8.packetBuffer.writeShortLE(var1);
                           Client.field915.method1898(var8);
                           Client.mouseCrosshair = 0;
                           WorldMapData.field438 = UrlRequester.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = class235.method4272(ClientPacket.field2372, Client.field915.field1462);
                           var8.packetBuffer.putShortLE(var0);
                           var8.packetBuffer.writeIntLE16(var3);
                           var8.packetBuffer.method3381(var1);
                           Client.field915.method1898(var8);
                           Client.mouseCrosshair = 0;
                           WorldMapData.field438 = UrlRequester.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = class235.method4272(ClientPacket.field2364, Client.field915.field1462);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.putShortLE(var3);
                           var8.packetBuffer.method3381(var1);
                           Client.field915.method1898(var8);
                           Client.mouseCrosshair = 0;
                           WorldMapData.field438 = UrlRequester.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2357, Client.field915.field1462);
                              var9.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field915.method1898(var9);
                           }
                        } else if(var2 == 45) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2350, Client.field915.field1462);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field915.method1898(var9);
                           }
                        } else if(var2 == 46) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2377, Client.field915.field1462);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field915.method1898(var9);
                           }
                        } else if(var2 == 47) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2349, Client.field915.field1462);
                              var9.packetBuffer.writeIntLE(var3);
                              var9.packetBuffer.method3362(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field915.method1898(var9);
                           }
                        } else if(var2 == 48) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2410, Client.field915.field1462);
                              var9.packetBuffer.writeIntLE16(var3);
                              var9.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field915.method1898(var9);
                           }
                        } else if(var2 == 49) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2393, Client.field915.field1462);
                              var9.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field915.method1898(var9);
                           }
                        } else if(var2 == 50) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2376, Client.field915.field1462);
                              var9.packetBuffer.method3360(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeIntLE(var3);
                              Client.field915.method1898(var9);
                           }
                        } else if(var2 == 51) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field964 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class235.method4272(ClientPacket.field2382, Client.field915.field1462);
                              var9.packetBuffer.method3362(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShortLE(var3);
                              Client.field915.method1898(var9);
                           }
                        } else {
                           label936: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var24 = ScriptVarType.getWidgetChild(var1, var0);
                                    if(var24 != null) {
                                       var9 = class235.method4272(ClientPacket.field2343, Client.field915.field1462);
                                       var9.packetBuffer.writeShortLE(var1);
                                       var9.packetBuffer.putShort(var24.itemId);
                                       var9.packetBuffer.writeShortLE(SoundTaskDataProvider.field623);
                                       var9.packetBuffer.writeIntLE16(var0);
                                       var9.packetBuffer.writeIntLE16(Client.field917);
                                       var9.packetBuffer.putShortLE(Client.field909);
                                       Client.field915.method1898(var9);
                                    }
                                    break label936;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field964 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = class235.method4272(ClientPacket.field2356, Client.field915.field1462);
                                    var8.packetBuffer.writeIntLE(var0 + class175.baseX);
                                    var8.packetBuffer.writeIntLE(var3 >> 14 & 32767);
                                    var8.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.putShortLE(GraphicsObject.baseY + var1);
                                    Client.field915.method1898(var8);
                                    break label936;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field964 = 0;
                                    var8 = class235.method4272(ClientPacket.field2358, Client.field915.field1462);
                                    var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
                                    Client.field915.method1898(var8);
                                    break label936;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field964 = 0;
                                    var19 = Client.cachedNPCs[var3];
                                    if(var19 != null) {
                                       NPCComposition var25 = var19.composition;
                                       if(var25.configs != null) {
                                          var25 = var25.transform();
                                       }

                                       if(var25 != null) {
                                          var10 = class235.method4272(ClientPacket.field2368, Client.field915.field1462);
                                          var10.packetBuffer.writeIntLE(var25.id);
                                          Client.field915.method1898(var10);
                                       }
                                    }
                                    break label936;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field964 = 0;
                                    var8 = class235.method4272(ClientPacket.field2337, Client.field915.field1462);
                                    var8.packetBuffer.writeIntLE16(var3);
                                    Client.field915.method1898(var8);
                                    break label936;
                                 }

                                 if(var2 == 1005) {
                                    var24 = UrlRequester.getWidget(var1);
                                    if(var24 != null && var24.itemQuantities[var0] >= 100000) {
                                       Preferences.sendGameMessage(27, "", var24.itemQuantities[var0] + " x " + class115.getItemDefinition(var3).name);
                                    } else {
                                       var9 = class235.method4272(ClientPacket.field2337, Client.field915.field1462);
                                       var9.packetBuffer.writeIntLE16(var3);
                                       Client.field915.method1898(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    WorldMapData.field438 = UrlRequester.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label936;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1010 || var2 == 1009 || var2 == 1011 || var2 == 1008 || var2 == 1012) {
                                       TextureProvider.renderOverview.method5476(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label936;
                                 }
                              }

                              var24 = ScriptVarType.getWidgetChild(var1, var0);
                              if(var24 != null) {
                                 class86.method1734(var3, var1, var0, var24.itemId, var5);
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
         class28.method220(UrlRequester.getWidget(class33.field448));
      }

      if(Client.spellSelected) {
         class72.method1129();
      }

      if(WorldMapData.field438 != null && Client.mouseCrosshair == 0) {
         class28.method220(WorldMapData.field438);
      }

   }
}
