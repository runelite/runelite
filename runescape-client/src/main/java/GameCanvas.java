import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("at")
   protected static boolean field643;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("fonts")
   static Fonts fonts;
   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field642;
   @ObfuscatedName("g")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-667309145"
   )
   static void method835() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3386 == 0) {
            IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
            IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3386 = 600;
      }
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-76"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1080 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = AbstractSoundSystem.method2350(ClientPacket.field2393, Client.field911.field1460);
         var8.packetBuffer.putShort(MapIconReference.baseY + var1);
         var8.packetBuffer.method3634(class243.selectedItemIndex);
         var8.packetBuffer.method3634(var3 >> 14 & 32767);
         var8.packetBuffer.method3644(Client.field1005);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3633(var0 + ClientPacket.baseX);
         var8.packetBuffer.method3633(class160.field2146);
         Client.field911.method2135(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1080 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = AbstractSoundSystem.method2350(ClientPacket.field2382, Client.field911.field1460);
         var8.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(MapIconReference.baseY + var1);
         var8.packetBuffer.method3644(BoundingBox3D.field261);
         var8.packetBuffer.method3632(var0 + ClientPacket.baseX);
         var8.packetBuffer.method3634(Client.field1008);
         Client.field911.method2135(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1080 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = AbstractSoundSystem.method2350(ClientPacket.field2427, Client.field911.field1460);
         var8.packetBuffer.method3634(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(MapIconReference.baseY + var1);
         var8.packetBuffer.putShort(var0 + ClientPacket.baseX);
         var8.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
         Client.field911.method2135(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1080 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = AbstractSoundSystem.method2350(ClientPacket.field2369, Client.field911.field1460);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3634(var0 + ClientPacket.baseX);
         var8.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3633(MapIconReference.baseY + var1);
         Client.field911.method2135(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1080 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = AbstractSoundSystem.method2350(ClientPacket.field2441, Client.field911.field1460);
         var8.packetBuffer.method3632(var0 + ClientPacket.baseX);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(MapIconReference.baseY + var1);
         var8.packetBuffer.method3670(KeyFocusListener.keyPressed[82]?1:0);
         Client.field911.method2135(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field1080 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = AbstractSoundSystem.method2350(ClientPacket.field2450, Client.field911.field1460);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var0 + ClientPacket.baseX);
         var8.packetBuffer.method3632(MapIconReference.baseY + var1);
         var8.packetBuffer.method3634(var3 >> 14 & 32767);
         Client.field911.method2135(var8);
      } else {
         PacketNode var9;
         NPC var13;
         if(var2 == 7) {
            var13 = Client.cachedNPCs[var3];
            if(var13 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = AbstractSoundSystem.method2350(ClientPacket.field2406, Client.field911.field1460);
               var9.packetBuffer.method3634(class243.selectedItemIndex);
               var9.packetBuffer.method3634(var3);
               var9.packetBuffer.method3632(class160.field2146);
               var9.packetBuffer.method3644(Client.field1005);
               var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
               Client.field911.method2135(var9);
            }
         } else if(var2 == 8) {
            var13 = Client.cachedNPCs[var3];
            if(var13 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = AbstractSoundSystem.method2350(ClientPacket.field2401, Client.field911.field1460);
               var9.packetBuffer.method3632(var3);
               var9.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3736(BoundingBox3D.field261);
               var9.packetBuffer.method3633(Client.field1008);
               Client.field911.method2135(var9);
            }
         } else if(var2 == 9) {
            var13 = Client.cachedNPCs[var3];
            if(var13 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = AbstractSoundSystem.method2350(ClientPacket.field2420, Client.field911.field1460);
               var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3633(var3);
               Client.field911.method2135(var9);
            }
         } else if(var2 == 10) {
            var13 = Client.cachedNPCs[var3];
            if(var13 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = AbstractSoundSystem.method2350(ClientPacket.field2408, Client.field911.field1460);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
               Client.field911.method2135(var9);
            }
         } else if(var2 == 11) {
            var13 = Client.cachedNPCs[var3];
            if(var13 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = AbstractSoundSystem.method2350(ClientPacket.field2395, Client.field911.field1460);
               var9.packetBuffer.method3632(var3);
               var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
               Client.field911.method2135(var9);
            }
         } else if(var2 == 12) {
            var13 = Client.cachedNPCs[var3];
            if(var13 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = AbstractSoundSystem.method2350(ClientPacket.field2417, Client.field911.field1460);
               var9.packetBuffer.method3634(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field911.method2135(var9);
            }
         } else if(var2 == 13) {
            var13 = Client.cachedNPCs[var3];
            if(var13 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = AbstractSoundSystem.method2350(ClientPacket.field2425, Client.field911.field1460);
               var9.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3634(var3);
               Client.field911.method2135(var9);
            }
         } else {
            Player var15;
            if(var2 == 14) {
               var15 = Client.cachedPlayers[var3];
               if(var15 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field1080 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = AbstractSoundSystem.method2350(ClientPacket.field2443, Client.field911.field1460);
                  var9.packetBuffer.putInt(Client.field1005);
                  var9.packetBuffer.putShort(class243.selectedItemIndex);
                  var9.packetBuffer.putShort(var3);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3633(class160.field2146);
                  Client.field911.method2135(var9);
               }
            } else if(var2 == 15) {
               var15 = Client.cachedPlayers[var3];
               if(var15 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field1080 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = AbstractSoundSystem.method2350(ClientPacket.field2430, Client.field911.field1460);
                  var9.packetBuffer.putShort(Client.field1008);
                  var9.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3644(BoundingBox3D.field261);
                  var9.packetBuffer.putShort(var3);
                  Client.field911.method2135(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = AbstractSoundSystem.method2350(ClientPacket.field2432, Client.field911.field1460);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3632(class160.field2146);
               var8.packetBuffer.method3736(Client.field1005);
               var8.packetBuffer.method3632(MapIconReference.baseY + var1);
               var8.packetBuffer.method3632(var0 + ClientPacket.baseX);
               var8.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3633(class243.selectedItemIndex);
               Client.field911.method2135(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = AbstractSoundSystem.method2350(ClientPacket.field2438, Client.field911.field1460);
               var8.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3736(BoundingBox3D.field261);
               var8.packetBuffer.method3632(var0 + ClientPacket.baseX);
               var8.packetBuffer.method3632(MapIconReference.baseY + var1);
               var8.packetBuffer.method3633(var3);
               var8.packetBuffer.putShort(Client.field1008);
               Client.field911.method2135(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = AbstractSoundSystem.method2350(ClientPacket.field2364, Client.field911.field1460);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3634(MapIconReference.baseY + var1);
               var8.packetBuffer.putShort(var0 + ClientPacket.baseX);
               Client.field911.method2135(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = AbstractSoundSystem.method2350(ClientPacket.field2398, Client.field911.field1460);
               var8.packetBuffer.putShort(MapIconReference.baseY + var1);
               var8.packetBuffer.method3634(var0 + ClientPacket.baseX);
               var8.packetBuffer.method3633(var3);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field911.method2135(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = AbstractSoundSystem.method2350(ClientPacket.field2442, Client.field911.field1460);
               var8.packetBuffer.method3632(MapIconReference.baseY + var1);
               var8.packetBuffer.method3633(var0 + ClientPacket.baseX);
               var8.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3633(var3);
               Client.field911.method2135(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = AbstractSoundSystem.method2350(ClientPacket.field2426, Client.field911.field1460);
               var8.packetBuffer.method3634(MapIconReference.baseY + var1);
               var8.packetBuffer.method3634(var3);
               var8.packetBuffer.method3633(var0 + ClientPacket.baseX);
               var8.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
               Client.field911.method2135(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field1080 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = AbstractSoundSystem.method2350(ClientPacket.field2413, Client.field911.field1460);
               var8.packetBuffer.method3632(var0 + ClientPacket.baseX);
               var8.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(MapIconReference.baseY + var1);
               var8.packetBuffer.method3633(var3);
               Client.field911.method2135(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  GameSocket.region.method2984();
               } else {
                  GameSocket.region.method2983(ScriptVarType.plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var16;
               if(var2 == 24) {
                  var16 = UnitPriceComparator.getWidget(var1);
                  boolean var12 = true;
                  if(var16.contentType > 0) {
                     var12 = NetWriter.method2140(var16);
                  }

                  if(var12) {
                     var10 = AbstractSoundSystem.method2350(ClientPacket.field2424, Client.field911.field1460);
                     var10.packetBuffer.putInt(var1);
                     Client.field911.method2135(var10);
                  }
               } else {
                  if(var2 == 25) {
                     var16 = class44.getWidgetChild(var1, var0);
                     if(var16 != null) {
                        FontName.method5545();
                        VerticalAlignment.method4830(var1, var0, class163.method3286(class1.getWidgetClickMask(var16)), var16.itemId);
                        Client.itemSelectionState = 0;
                        String var18;
                        if(class163.method3286(class1.getWidgetClickMask(var16)) == 0) {
                           var18 = null;
                        } else if(var16.targetVerb != null && var16.targetVerb.trim().length() != 0) {
                           var18 = var16.targetVerb;
                        } else {
                           var18 = null;
                        }

                        Client.field1010 = var18;
                        if(Client.field1010 == null) {
                           Client.field1010 = "Null";
                        }

                        if(var16.hasScript) {
                           Client.field1063 = var16.opBase + DynamicObject.getColTags(16777215);
                        } else {
                           Client.field1063 = DynamicObject.getColTags(65280) + var16.spellName + DynamicObject.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     Signlink.method3323();
                  } else {
                     int var11;
                     Widget var14;
                     if(var2 == 28) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2424, Client.field911.field1460);
                        var8.packetBuffer.putInt(var1);
                        Client.field911.method2135(var8);
                        var14 = UnitPriceComparator.getWidget(var1);
                        if(var14.dynamicValues != null && var14.dynamicValues[0][0] == 5) {
                           var11 = var14.dynamicValues[0][1];
                           class237.clientVarps[var11] = 1 - class237.clientVarps[var11];
                           DynamicObject.method2113(var11);
                        }
                     } else if(var2 == 29) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2424, Client.field911.field1460);
                        var8.packetBuffer.putInt(var1);
                        Client.field911.method2135(var8);
                        var14 = UnitPriceComparator.getWidget(var1);
                        if(var14.dynamicValues != null && var14.dynamicValues[0][0] == 5) {
                           var11 = var14.dynamicValues[0][1];
                           if(class237.clientVarps[var11] != var14.field2935[0]) {
                              class237.clientVarps[var11] = var14.field2935[0];
                              DynamicObject.method2113(var11);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1017 == null) {
                           var8 = AbstractSoundSystem.method2350(ClientPacket.field2431, Client.field911.field1460);
                           var8.packetBuffer.method3634(var0);
                           var8.packetBuffer.method3644(var1);
                           Client.field911.method2135(var8);
                           Client.field1017 = class44.getWidgetChild(var1, var0);
                           TotalQuantityComparator.method100(Client.field1017);
                        }
                     } else if(var2 == 31) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2456, Client.field911.field1460);
                        var8.packetBuffer.method3634(class160.field2146);
                        var8.packetBuffer.putInt(Client.field1005);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3633(class243.selectedItemIndex);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3633(var0);
                        Client.field911.method2135(var8);
                        Client.mouseCrosshair = 0;
                        BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2436, Client.field911.field1460);
                        var8.packetBuffer.method3644(BoundingBox3D.field261);
                        var8.packetBuffer.method3633(var3);
                        var8.packetBuffer.method3632(Client.field1008);
                        var8.packetBuffer.method3736(var1);
                        var8.packetBuffer.method3632(var0);
                        Client.field911.method2135(var8);
                        Client.mouseCrosshair = 0;
                        BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2378, Client.field911.field1460);
                        var8.packetBuffer.method3634(var3);
                        var8.packetBuffer.method3643(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field911.method2135(var8);
                        Client.mouseCrosshair = 0;
                        BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2459, Client.field911.field1460);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3633(var0);
                        var8.packetBuffer.putShort(var3);
                        Client.field911.method2135(var8);
                        Client.mouseCrosshair = 0;
                        BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2376, Client.field911.field1460);
                        var8.packetBuffer.method3633(var0);
                        var8.packetBuffer.method3736(var1);
                        var8.packetBuffer.putShort(var3);
                        Client.field911.method2135(var8);
                        Client.mouseCrosshair = 0;
                        BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2454, Client.field911.field1460);
                        var8.packetBuffer.method3643(var1);
                        var8.packetBuffer.method3633(var0);
                        var8.packetBuffer.method3634(var3);
                        Client.field911.method2135(var8);
                        Client.mouseCrosshair = 0;
                        BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = AbstractSoundSystem.method2350(ClientPacket.field2391, Client.field911.field1460);
                        var8.packetBuffer.method3634(var3);
                        var8.packetBuffer.method3634(var0);
                        var8.packetBuffer.method3643(var1);
                        Client.field911.method2135(var8);
                        Client.mouseCrosshair = 0;
                        BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           FontName.method5545();
                           var16 = UnitPriceComparator.getWidget(var1);
                           Client.itemSelectionState = 1;
                           class243.selectedItemIndex = var0;
                           Client.field1005 = var1;
                           class160.field2146 = var3;
                           TotalQuantityComparator.method100(var16);
                           Client.lastSelectedItemName = DynamicObject.getColTags(16748608) + NetWriter.getItemDefinition(var3).name + DynamicObject.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = AbstractSoundSystem.method2350(ClientPacket.field2446, Client.field911.field1460);
                           var8.packetBuffer.method3632(var3);
                           var8.packetBuffer.method3633(var0);
                           var8.packetBuffer.method3644(var1);
                           Client.field911.method2135(var8);
                           Client.mouseCrosshair = 0;
                           BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = AbstractSoundSystem.method2350(ClientPacket.field2414, Client.field911.field1460);
                           var8.packetBuffer.method3632(var0);
                           var8.packetBuffer.method3634(var3);
                           var8.packetBuffer.method3736(var1);
                           Client.field911.method2135(var8);
                           Client.mouseCrosshair = 0;
                           BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = AbstractSoundSystem.method2350(ClientPacket.field2372, Client.field911.field1460);
                           var8.packetBuffer.method3643(var1);
                           var8.packetBuffer.method3634(var0);
                           var8.packetBuffer.method3634(var3);
                           Client.field911.method2135(var8);
                           Client.mouseCrosshair = 0;
                           BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = AbstractSoundSystem.method2350(ClientPacket.field2392, Client.field911.field1460);
                           var8.packetBuffer.method3632(var3);
                           var8.packetBuffer.method3643(var1);
                           var8.packetBuffer.putShort(var0);
                           Client.field911.method2135(var8);
                           Client.mouseCrosshair = 0;
                           BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = AbstractSoundSystem.method2350(ClientPacket.field2428, Client.field911.field1460);
                           var8.packetBuffer.method3632(var0);
                           var8.packetBuffer.method3634(var3);
                           var8.packetBuffer.method3644(var1);
                           Client.field911.method2135(var8);
                           Client.mouseCrosshair = 0;
                           BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2429, Client.field911.field1460);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3670(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 == 45) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2444, Client.field911.field1460);
                              var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3632(var3);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 == 46) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2368, Client.field911.field1460);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3632(var3);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 == 47) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2381, Client.field911.field1460);
                              var9.packetBuffer.method3670(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3633(var3);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 == 48) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2423, Client.field911.field1460);
                              var9.packetBuffer.method3634(var3);
                              var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 == 49) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2375, Client.field911.field1460);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 == 50) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2421, Client.field911.field1460);
                              var9.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3632(var3);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 == 51) {
                           var15 = Client.cachedPlayers[var3];
                           if(var15 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = AbstractSoundSystem.method2350(ClientPacket.field2384, Client.field911.field1460);
                              var9.packetBuffer.method3634(var3);
                              var9.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field911.method2135(var9);
                           }
                        } else if(var2 != 1007 && var2 != 57) {
                           if(var2 == 58) {
                              var16 = class44.getWidgetChild(var1, var0);
                              if(var16 != null) {
                                 var9 = AbstractSoundSystem.method2350(ClientPacket.field2377, Client.field911.field1460);
                                 var9.packetBuffer.method3634(Client.field1009);
                                 var9.packetBuffer.method3632(var0);
                                 var9.packetBuffer.method3736(var1);
                                 var9.packetBuffer.method3634(var16.itemId);
                                 var9.packetBuffer.method3633(Client.field1008);
                                 var9.packetBuffer.method3643(BoundingBox3D.field261);
                                 Client.field911.method2135(var9);
                              }
                           } else if(var2 == 1001) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var8 = AbstractSoundSystem.method2350(ClientPacket.field2434, Client.field911.field1460);
                              var8.packetBuffer.method3632(MapIconReference.baseY + var1);
                              var8.packetBuffer.putShort(var3 >> 14 & 32767);
                              var8.packetBuffer.method3716(KeyFocusListener.keyPressed[82]?1:0);
                              var8.packetBuffer.method3632(var0 + ClientPacket.baseX);
                              Client.field911.method2135(var8);
                           } else if(var2 == 1002) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              var8 = AbstractSoundSystem.method2350(ClientPacket.field2439, Client.field911.field1460);
                              var8.packetBuffer.method3633(var3 >> 14 & 32767);
                              Client.field911.method2135(var8);
                           } else if(var2 == 1003) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              var13 = Client.cachedNPCs[var3];
                              if(var13 != null) {
                                 NPCComposition var17 = var13.composition;
                                 if(var17.configs != null) {
                                    var17 = var17.transform();
                                 }

                                 if(var17 != null) {
                                    var10 = AbstractSoundSystem.method2350(ClientPacket.field2367, Client.field911.field1460);
                                    var10.packetBuffer.putShort(var17.id);
                                    Client.field911.method2135(var10);
                                 }
                              }
                           } else if(var2 == 1004) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field1080 = 0;
                              var8 = AbstractSoundSystem.method2350(ClientPacket.field2448, Client.field911.field1460);
                              var8.packetBuffer.method3633(var3);
                              Client.field911.method2135(var8);
                           } else if(var2 == 1005) {
                              var16 = UnitPriceComparator.getWidget(var1);
                              if(var16 != null && var16.itemQuantities[var0] >= 100000) {
                                 ChatPlayer.sendGameMessage(27, "", var16.itemQuantities[var0] + " x " + NetWriter.getItemDefinition(var3).name);
                              } else {
                                 var9 = AbstractSoundSystem.method2350(ClientPacket.field2448, Client.field911.field1460);
                                 var9.packetBuffer.method3633(var3);
                                 Client.field911.method2135(var9);
                              }

                              Client.mouseCrosshair = 0;
                              BoundingBox2D.field241 = UnitPriceComparator.getWidget(var1);
                              Client.pressedItemIndex = var0;
                           } else if(var2 == 1009 || var2 == 1008 || var2 == 1011 || var2 == 1012 || var2 == 1010) {
                              class196.renderOverview.onMapClicked(var2, var3, new Coordinates(var0), new Coordinates(var1));
                           }
                        } else {
                           var16 = class44.getWidgetChild(var1, var0);
                           if(var16 != null) {
                              MapIconReference.method760(var3, var1, var0, var16.itemId, var5);
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
         TotalQuantityComparator.method100(UnitPriceComparator.getWidget(Client.field1005));
      }

      if(Client.spellSelected) {
         FontName.method5545();
      }

      if(BoundingBox2D.field241 != null && Client.mouseCrosshair == 0) {
         TotalQuantityComparator.method100(BoundingBox2D.field241);
      }

   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "1670837525"
   )
   static final String method843(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?DynamicObject.getColTags(16711680):(var2 < -6?DynamicObject.getColTags(16723968):(var2 < -3?DynamicObject.getColTags(16740352):(var2 < 0?DynamicObject.getColTags(16756736):(var2 > 9?DynamicObject.getColTags(65280):(var2 > 6?DynamicObject.getColTags(4259584):(var2 > 3?DynamicObject.getColTags(8453888):(var2 > 0?DynamicObject.getColTags(12648192):DynamicObject.getColTags(16776960))))))));
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Liz;III)V",
      garbageValue = "1473824455"
   )
   static final void method842(Widget var0, int var1, int var2) {
      if(var0.field2924 == 1) {
         class150.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2924 == 2 && !Client.spellSelected) {
         if(class163.method3286(class1.getWidgetClickMask(var0)) == 0) {
            var3 = null;
         } else if(var0.targetVerb != null && var0.targetVerb.trim().length() != 0) {
            var3 = var0.targetVerb;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class150.addMenuEntry(var3, DynamicObject.getColTags(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2924 == 3) {
         class150.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2924 == 4) {
         class150.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2924 == 5) {
         class150.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2924 == 6 && Client.field1017 == null) {
         class150.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var5;
      int var13;
      if(var0.type == 2) {
         var13 = 0;

         for(int var14 = 0; var14 < var0.height; ++var14) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var14;
               if(var13 < 20) {
                  var6 += var0.xSprites[var13];
                  var7 += var0.field2890[var13];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field962 = var13;
                  FileOnDisk.field1676 = var0;
                  if(var0.itemIds[var13] > 0) {
                     ItemComposition var8 = NetWriter.getItemDefinition(var0.itemIds[var13] - 1);
                     if(Client.itemSelectionState == 1 && class199.method3845(class1.getWidgetClickMask(var0))) {
                        if(var0.id != Client.field1005 || var13 != class243.selectedItemIndex) {
                           class150.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + DynamicObject.getColTags(16748608) + var8.name, 31, var8.id, var13, var0.id);
                        }
                     } else if(Client.spellSelected && class199.method3845(class1.getWidgetClickMask(var0))) {
                        if((class49.field605 & 16) == 16) {
                           class150.addMenuEntry(Client.field1010, Client.field1063 + " " + "->" + " " + DynamicObject.getColTags(16748608) + var8.name, 32, var8.id, var13, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        int var10 = -1;
                        if(Client.field1079) {
                           boolean var11 = Client.field998 || KeyFocusListener.keyPressed[81];
                           if(var11) {
                              var10 = var8.getShiftClickActionIndex();
                           }
                        }

                        int var16;
                        if(class199.method3845(class1.getWidgetClickMask(var0))) {
                           for(var16 = 4; var16 >= 3; --var16) {
                              if(var10 != var16) {
                                 class61.method1096(var0, var8, var13, var16, false);
                              }
                           }
                        }

                        if(MapLabel.method375(class1.getWidgetClickMask(var0))) {
                           class150.addMenuEntry("Use", DynamicObject.getColTags(16748608) + var8.name, 38, var8.id, var13, var0.id);
                        }

                        if(class199.method3845(class1.getWidgetClickMask(var0))) {
                           for(var16 = 2; var16 >= 0; --var16) {
                              if(var16 != var10) {
                                 class61.method1096(var0, var8, var13, var16, false);
                              }
                           }

                           if(var10 >= 0) {
                              class61.method1096(var0, var8, var13, var10, true);
                           }
                        }

                        var9 = var0.configActions;
                        if(var9 != null) {
                           for(var16 = 4; var16 >= 0; --var16) {
                              if(var9[var16] != null) {
                                 byte var12 = 0;
                                 if(var16 == 0) {
                                    var12 = 39;
                                 }

                                 if(var16 == 1) {
                                    var12 = 40;
                                 }

                                 if(var16 == 2) {
                                    var12 = 41;
                                 }

                                 if(var16 == 3) {
                                    var12 = 42;
                                 }

                                 if(var16 == 4) {
                                    var12 = 43;
                                 }

                                 class150.addMenuEntry(var9[var16], DynamicObject.getColTags(16748608) + var8.name, var12, var8.id, var13, var0.id);
                              }
                           }
                        }

                        class150.addMenuEntry("Examine", DynamicObject.getColTags(16748608) + var8.name, 1005, var8.id, var13, var0.id);
                     }
                  }
               }

               ++var13;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(class191.method3570(class1.getWidgetClickMask(var0)) && (class49.field605 & 32) == 32) {
               class150.addMenuEntry(Client.field1010, Client.field1063 + " " + "->" + " " + var0.opBase, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var13 = 9; var13 >= 5; --var13) {
               String var4 = OwnWorldComparator.method1256(var0, var13);
               if(var4 != null) {
                  class150.addMenuEntry(var4, var0.opBase, 1007, var13 + 1, var0.index, var0.id);
               }
            }

            if(class163.method3286(class1.getWidgetClickMask(var0)) == 0) {
               var3 = null;
            } else if(var0.targetVerb != null && var0.targetVerb.trim().length() != 0) {
               var3 = var0.targetVerb;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class150.addMenuEntry(var3, var0.opBase, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var15 = OwnWorldComparator.method1256(var0, var5);
               if(var15 != null) {
                  class150.addMenuEntry(var15, var0.opBase, 57, var5 + 1, var0.index, var0.id);
               }
            }

            if(GZipDecompressor.method3535(class1.getWidgetClickMask(var0))) {
               class150.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
