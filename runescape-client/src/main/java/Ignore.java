import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -1408049517
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("m")
   @Export("name")
   String name;
   @ObfuscatedName("p")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1254226454"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.field956 = var6;
         Client.field957 = var7;
         Client.cursorState = 2;
         Client.field937 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Actor.method1628(ClientPacket.field2333, Client.field952.field1478);
         var8.packetBuffer.method3340(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(GameEngine.selectedItemIndex);
         var8.packetBuffer.method3340(ItemLayer.baseY + var1);
         var8.packetBuffer.putInt(class5.field33);
         var8.packetBuffer.method3403(KeyFocusListener.field618[82]?1:0);
         var8.packetBuffer.method3319(var0 + ItemLayer.baseX);
         var8.packetBuffer.method3319(KeyFocusListener.field624);
         Client.field952.method1951(var8);
      } else if(var2 == 2) {
         Client.field956 = var6;
         Client.field957 = var7;
         Client.cursorState = 2;
         Client.field937 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Actor.method1628(ClientPacket.field2348, Client.field952.field1478);
         var8.packetBuffer.putShort(var0 + ItemLayer.baseX);
         var8.packetBuffer.putShortLE(ItemLayer.baseY + var1);
         var8.packetBuffer.putByte(KeyFocusListener.field618[82]?1:0);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.putInt(class11.field267);
         var8.packetBuffer.putShortLE(Client.field1005);
         Client.field952.method1951(var8);
      } else if(var2 == 3) {
         Client.field956 = var6;
         Client.field957 = var7;
         Client.cursorState = 2;
         Client.field937 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Actor.method1628(ClientPacket.field2340, Client.field952.field1478);
         var8.packetBuffer.putShortLE(var0 + ItemLayer.baseX);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(ItemLayer.baseY + var1);
         var8.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
         Client.field952.method1951(var8);
      } else if(var2 == 4) {
         Client.field956 = var6;
         Client.field957 = var7;
         Client.cursorState = 2;
         Client.field937 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Actor.method1628(ClientPacket.field2366, Client.field952.field1478);
         var8.packetBuffer.method3319(var0 + ItemLayer.baseX);
         var8.packetBuffer.method3319(ItemLayer.baseY + var1);
         var8.packetBuffer.putByte(KeyFocusListener.field618[82]?1:0);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         Client.field952.method1951(var8);
      } else if(var2 == 5) {
         Client.field956 = var6;
         Client.field957 = var7;
         Client.cursorState = 2;
         Client.field937 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Actor.method1628(ClientPacket.field2349, Client.field952.field1478);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.method3374(KeyFocusListener.field618[82]?1:0);
         var8.packetBuffer.method3340(ItemLayer.baseY + var1);
         var8.packetBuffer.putShortLE(var0 + ItemLayer.baseX);
         Client.field952.method1951(var8);
      } else if(var2 == 6) {
         Client.field956 = var6;
         Client.field957 = var7;
         Client.cursorState = 2;
         Client.field937 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = Actor.method1628(ClientPacket.field2377, Client.field952.field1478);
         var8.packetBuffer.putShortLE(ItemLayer.baseY + var1);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.method3319(var0 + ItemLayer.baseX);
         var8.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
         Client.field952.method1951(var8);
      } else {
         PacketNode var9;
         NPC var15;
         if(var2 == 7) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Actor.method1628(ClientPacket.field2389, Client.field952.field1478);
               var9.packetBuffer.putShort(GameEngine.selectedItemIndex);
               var9.packetBuffer.method3340(KeyFocusListener.field624);
               var9.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
               var9.packetBuffer.putInt(class5.field33);
               var9.packetBuffer.method3340(var3);
               Client.field952.method1951(var9);
            }
         } else if(var2 == 8) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Actor.method1628(ClientPacket.field2341, Client.field952.field1478);
               var9.packetBuffer.method3340(var3);
               var9.packetBuffer.method3446(class11.field267);
               var9.packetBuffer.method3340(Client.field1005);
               var9.packetBuffer.method3374(KeyFocusListener.field618[82]?1:0);
               Client.field952.method1951(var9);
            }
         } else if(var2 == 9) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Actor.method1628(ClientPacket.field2393, Client.field952.field1478);
               var9.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
               var9.packetBuffer.method3340(var3);
               Client.field952.method1951(var9);
            }
         } else if(var2 == 10) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Actor.method1628(ClientPacket.field2337, Client.field952.field1478);
               var9.packetBuffer.method3340(var3);
               var9.packetBuffer.method3403(KeyFocusListener.field618[82]?1:0);
               Client.field952.method1951(var9);
            }
         } else if(var2 == 11) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Actor.method1628(ClientPacket.field2338, Client.field952.field1478);
               var9.packetBuffer.putShortLE(var3);
               var9.packetBuffer.method3374(KeyFocusListener.field618[82]?1:0);
               Client.field952.method1951(var9);
            }
         } else if(var2 == 12) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Actor.method1628(ClientPacket.field2317, Client.field952.field1478);
               var9.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
               var9.packetBuffer.putShort(var3);
               Client.field952.method1951(var9);
            }
         } else if(var2 == 13) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Actor.method1628(ClientPacket.field2314, Client.field952.field1478);
               var9.packetBuffer.putByte(KeyFocusListener.field618[82]?1:0);
               var9.packetBuffer.method3340(var3);
               Client.field952.method1951(var9);
            }
         } else {
            Player var17;
            if(var2 == 14) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field956 = var6;
                  Client.field957 = var7;
                  Client.cursorState = 2;
                  Client.field937 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = Actor.method1628(ClientPacket.field2344, Client.field952.field1478);
                  var9.packetBuffer.method3319(KeyFocusListener.field624);
                  var9.packetBuffer.putShortLE(var3);
                  var9.packetBuffer.method3340(GameEngine.selectedItemIndex);
                  var9.packetBuffer.method3446(class5.field33);
                  var9.packetBuffer.putByte(KeyFocusListener.field618[82]?1:0);
                  Client.field952.method1951(var9);
               }
            } else if(var2 == 15) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field956 = var6;
                  Client.field957 = var7;
                  Client.cursorState = 2;
                  Client.field937 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = Actor.method1628(ClientPacket.field2358, Client.field952.field1478);
                  var9.packetBuffer.method3446(class11.field267);
                  var9.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
                  var9.packetBuffer.putShort(var3);
                  var9.packetBuffer.putShort(Client.field1005);
                  Client.field952.method1951(var9);
               }
            } else if(var2 == 16) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Actor.method1628(ClientPacket.field2335, Client.field952.field1478);
               var8.packetBuffer.method3374(KeyFocusListener.field618[82]?1:0);
               var8.packetBuffer.method3446(class5.field33);
               var8.packetBuffer.method3340(var0 + ItemLayer.baseX);
               var8.packetBuffer.method3340(var3);
               var8.packetBuffer.method3319(ItemLayer.baseY + var1);
               var8.packetBuffer.method3340(GameEngine.selectedItemIndex);
               var8.packetBuffer.method3319(KeyFocusListener.field624);
               Client.field952.method1951(var8);
            } else if(var2 == 17) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Actor.method1628(ClientPacket.field2334, Client.field952.field1478);
               var8.packetBuffer.putShortLE(ItemLayer.baseY + var1);
               var8.packetBuffer.method3340(var0 + ItemLayer.baseX);
               var8.packetBuffer.method3319(Client.field1005);
               var8.packetBuffer.method3289(class11.field267);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
               Client.field952.method1951(var8);
            } else if(var2 == 18) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Actor.method1628(ClientPacket.field2329, Client.field952.field1478);
               var8.packetBuffer.method3340(var0 + ItemLayer.baseX);
               var8.packetBuffer.putShortLE(ItemLayer.baseY + var1);
               var8.packetBuffer.putByte(KeyFocusListener.field618[82]?1:0);
               var8.packetBuffer.method3319(var3);
               Client.field952.method1951(var8);
            } else if(var2 == 19) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Actor.method1628(ClientPacket.field2320, Client.field952.field1478);
               var8.packetBuffer.method3340(var3);
               var8.packetBuffer.method3319(var0 + ItemLayer.baseX);
               var8.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
               var8.packetBuffer.method3319(ItemLayer.baseY + var1);
               Client.field952.method1951(var8);
            } else if(var2 == 20) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Actor.method1628(ClientPacket.field2331, Client.field952.field1478);
               var8.packetBuffer.putShortLE(ItemLayer.baseY + var1);
               var8.packetBuffer.method3319(var0 + ItemLayer.baseX);
               var8.packetBuffer.method3319(var3);
               var8.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
               Client.field952.method1951(var8);
            } else if(var2 == 21) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Actor.method1628(ClientPacket.field2332, Client.field952.field1478);
               var8.packetBuffer.putByte(KeyFocusListener.field618[82]?1:0);
               var8.packetBuffer.method3340(ItemLayer.baseY + var1);
               var8.packetBuffer.putShort(var0 + ItemLayer.baseX);
               var8.packetBuffer.method3319(var3);
               Client.field952.method1951(var8);
            } else if(var2 == 22) {
               Client.field956 = var6;
               Client.field957 = var7;
               Client.cursorState = 2;
               Client.field937 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = Actor.method1628(ClientPacket.field2325, Client.field952.field1478);
               var8.packetBuffer.method3319(var3);
               var8.packetBuffer.method3374(KeyFocusListener.field618[82]?1:0);
               var8.packetBuffer.putShortLE(var0 + ItemLayer.baseX);
               var8.packetBuffer.method3340(ItemLayer.baseY + var1);
               Client.field952.method1951(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class56.region.method2819();
               } else {
                  class56.region.method2818(plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var20;
               if(var2 == 24) {
                  var20 = PendingSpawn.method1612(var1);
                  boolean var14 = true;
                  if(var20.contentType > 0) {
                     var14 = method1167(var20);
                  }

                  if(var14) {
                     var10 = Actor.method1628(ClientPacket.field2380, Client.field952.field1478);
                     var10.packetBuffer.putInt(var1);
                     Client.field952.method1951(var10);
                  }
               } else {
                  int var13;
                  if(var2 == 25) {
                     var20 = class189.method3613(var1, var0);
                     if(var20 != null) {
                        Player.method1208();
                        int var19 = GraphicsObject.method1747(Preferences.getWidgetConfig(var20));
                        var13 = var20.itemId;
                        Widget var11 = class189.method3613(var1, var0);
                        if(var11 != null && var11.field2831 != null) {
                           ScriptEvent var12 = new ScriptEvent();
                           var12.widget = var11;
                           var12.field791 = var11.field2831;
                           class111.method2177(var12);
                        }

                        Client.field1006 = var13;
                        Client.spellSelected = true;
                        class11.field267 = var1;
                        Client.field1005 = var0;
                        class228.field2902 = var19;
                        WorldMapData.method394(var11);
                        Client.itemSelectionState = 0;
                        Client.field1007 = Timer.method3094(var20);
                        if(Client.field1007 == null) {
                           Client.field1007 = "Null";
                        }

                        if(var20.hasScript) {
                           Client.field1008 = var20.name + WallObject.getColTags(16777215);
                        } else {
                           Client.field1008 = WallObject.getColTags(65280) + var20.field2842 + WallObject.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     var8 = Actor.method1628(ClientPacket.field2374, Client.field952.field1478);
                     Client.field952.method1951(var8);

                     for(WidgetNode var16 = (WidgetNode)Client.componentTable.method3721(); var16 != null; var16 = (WidgetNode)Client.componentTable.method3728()) {
                        if(var16.owner == 0 || var16.owner == 3) {
                           Frames.method2984(var16, true);
                        }
                     }

                     if(Client.field1013 != null) {
                        WorldMapData.method394(Client.field1013);
                        Client.field1013 = null;
                     }
                  } else {
                     Widget var18;
                     if(var2 == 28) {
                        var8 = Actor.method1628(ClientPacket.field2380, Client.field952.field1478);
                        var8.packetBuffer.putInt(var1);
                        Client.field952.method1951(var8);
                        var18 = PendingSpawn.method1612(var1);
                        if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                           var13 = var18.dynamicValues[0][1];
                           class218.widgetSettings[var13] = 1 - class218.widgetSettings[var13];
                           DynamicObject.method1934(var13);
                        }
                     } else if(var2 == 29) {
                        var8 = Actor.method1628(ClientPacket.field2380, Client.field952.field1478);
                        var8.packetBuffer.putInt(var1);
                        Client.field952.method1951(var8);
                        var18 = PendingSpawn.method1612(var1);
                        if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                           var13 = var18.dynamicValues[0][1];
                           if(class218.widgetSettings[var13] != var18.field2716[0]) {
                              class218.widgetSettings[var13] = var18.field2716[0];
                              DynamicObject.method1934(var13);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1013 == null) {
                           class35.method541(var1, var0);
                           Client.field1013 = class189.method3613(var1, var0);
                           WorldMapData.method394(Client.field1013);
                        }
                     } else if(var2 == 31) {
                        var8 = Actor.method1628(ClientPacket.field2373, Client.field952.field1478);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3319(var3);
                        var8.packetBuffer.putShortLE(KeyFocusListener.field624);
                        var8.packetBuffer.putShort(GameEngine.selectedItemIndex);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3295(class5.field33);
                        Client.field952.method1951(var8);
                        Client.field1066 = 0;
                        class169.field2420 = PendingSpawn.method1612(var1);
                        Client.field961 = var0;
                     } else if(var2 == 32) {
                        var8 = Actor.method1628(ClientPacket.field2365, Client.field952.field1478);
                        var8.packetBuffer.method3446(class11.field267);
                        var8.packetBuffer.method3319(var3);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.putShort(Client.field1005);
                        var8.packetBuffer.putInt(var1);
                        Client.field952.method1951(var8);
                        Client.field1066 = 0;
                        class169.field2420 = PendingSpawn.method1612(var1);
                        Client.field961 = var0;
                     } else if(var2 == 33) {
                        var8 = Actor.method1628(ClientPacket.field2360, Client.field952.field1478);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.method3446(var1);
                        var8.packetBuffer.method3340(var0);
                        Client.field952.method1951(var8);
                        Client.field1066 = 0;
                        class169.field2420 = PendingSpawn.method1612(var1);
                        Client.field961 = var0;
                     } else if(var2 == 34) {
                        var8 = Actor.method1628(ClientPacket.field2361, Client.field952.field1478);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.putShort(var0);
                        Client.field952.method1951(var8);
                        Client.field1066 = 0;
                        class169.field2420 = PendingSpawn.method1612(var1);
                        Client.field961 = var0;
                     } else if(var2 == 35) {
                        var8 = Actor.method1628(ClientPacket.field2362, Client.field952.field1478);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3319(var0);
                        var8.packetBuffer.method3446(var1);
                        Client.field952.method1951(var8);
                        Client.field1066 = 0;
                        class169.field2420 = PendingSpawn.method1612(var1);
                        Client.field961 = var0;
                     } else if(var2 == 36) {
                        var8 = Actor.method1628(ClientPacket.field2363, Client.field952.field1478);
                        var8.packetBuffer.method3295(var1);
                        var8.packetBuffer.method3319(var3);
                        var8.packetBuffer.method3340(var0);
                        Client.field952.method1951(var8);
                        Client.field1066 = 0;
                        class169.field2420 = PendingSpawn.method1612(var1);
                        Client.field961 = var0;
                     } else if(var2 == 37) {
                        var8 = Actor.method1628(ClientPacket.field2364, Client.field952.field1478);
                        var8.packetBuffer.method3340(var3);
                        var8.packetBuffer.method3295(var1);
                        var8.packetBuffer.method3340(var0);
                        Client.field952.method1951(var8);
                        Client.field1066 = 0;
                        class169.field2420 = PendingSpawn.method1612(var1);
                        Client.field961 = var0;
                     } else {
                        if(var2 == 38) {
                           Player.method1208();
                           var20 = PendingSpawn.method1612(var1);
                           Client.itemSelectionState = 1;
                           GameEngine.selectedItemIndex = var0;
                           class5.field33 = var1;
                           KeyFocusListener.field624 = var3;
                           WorldMapData.method394(var20);
                           Client.field1118 = WallObject.getColTags(16748608) + class250.getItemDefinition(var3).name + WallObject.getColTags(16777215);
                           if(Client.field1118 == null) {
                              Client.field1118 = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = Actor.method1628(ClientPacket.field2359, Client.field952.field1478);
                           var8.packetBuffer.method3340(var3);
                           var8.packetBuffer.method3319(var0);
                           var8.packetBuffer.method3295(var1);
                           Client.field952.method1951(var8);
                           Client.field1066 = 0;
                           class169.field2420 = PendingSpawn.method1612(var1);
                           Client.field961 = var0;
                        } else if(var2 == 40) {
                           var8 = Actor.method1628(ClientPacket.field2368, Client.field952.field1478);
                           var8.packetBuffer.putShortLE(var0);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.putShortLE(var3);
                           Client.field952.method1951(var8);
                           Client.field1066 = 0;
                           class169.field2420 = PendingSpawn.method1612(var1);
                           Client.field961 = var0;
                        } else if(var2 == 41) {
                           var8 = Actor.method1628(ClientPacket.field2369, Client.field952.field1478);
                           var8.packetBuffer.method3340(var3);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3446(var1);
                           Client.field952.method1951(var8);
                           Client.field1066 = 0;
                           class169.field2420 = PendingSpawn.method1612(var1);
                           Client.field961 = var0;
                        } else if(var2 == 42) {
                           var8 = Actor.method1628(ClientPacket.field2370, Client.field952.field1478);
                           var8.packetBuffer.putShortLE(var3);
                           var8.packetBuffer.putShortLE(var0);
                           var8.packetBuffer.method3446(var1);
                           Client.field952.method1951(var8);
                           Client.field1066 = 0;
                           class169.field2420 = PendingSpawn.method1612(var1);
                           Client.field961 = var0;
                        } else if(var2 == 43) {
                           var8 = Actor.method1628(ClientPacket.field2371, Client.field952.field1478);
                           var8.packetBuffer.method3446(var1);
                           var8.packetBuffer.method3319(var3);
                           var8.packetBuffer.putShortLE(var0);
                           Client.field952.method1951(var8);
                           Client.field1066 = 0;
                           class169.field2420 = PendingSpawn.method1612(var1);
                           Client.field961 = var0;
                        } else if(var2 == 44) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2350, Client.field952.field1478);
                              var9.packetBuffer.method3403(KeyFocusListener.field618[82]?1:0);
                              var9.packetBuffer.putShortLE(var3);
                              Client.field952.method1951(var9);
                           }
                        } else if(var2 == 45) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2378, Client.field952.field1478);
                              var9.packetBuffer.method3319(var3);
                              var9.packetBuffer.method3374(KeyFocusListener.field618[82]?1:0);
                              Client.field952.method1951(var9);
                           }
                        } else if(var2 == 46) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2352, Client.field952.field1478);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3403(KeyFocusListener.field618[82]?1:0);
                              Client.field952.method1951(var9);
                           }
                        } else if(var2 == 47) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2343, Client.field952.field1478);
                              var9.packetBuffer.method3319(var3);
                              var9.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
                              Client.field952.method1951(var9);
                           }
                        } else if(var2 == 48) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2395, Client.field952.field1478);
                              var9.packetBuffer.method3403(KeyFocusListener.field618[82]?1:0);
                              var9.packetBuffer.method3340(var3);
                              Client.field952.method1951(var9);
                           }
                        } else if(var2 == 49) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2355, Client.field952.field1478);
                              var9.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
                              var9.packetBuffer.method3319(var3);
                              Client.field952.method1951(var9);
                           }
                        } else if(var2 == 50) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2356, Client.field952.field1478);
                              var9.packetBuffer.method3374(KeyFocusListener.field618[82]?1:0);
                              var9.packetBuffer.putShortLE(var3);
                              Client.field952.method1951(var9);
                           }
                        } else if(var2 == 51) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field956 = var6;
                              Client.field957 = var7;
                              Client.cursorState = 2;
                              Client.field937 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Actor.method1628(ClientPacket.field2305, Client.field952.field1478);
                              var9.packetBuffer.putByte(KeyFocusListener.field618[82]?1:0);
                              var9.packetBuffer.method3340(var3);
                              Client.field952.method1951(var9);
                           }
                        } else {
                           label807: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var20 = class189.method3613(var1, var0);
                                    if(var20 != null) {
                                       var9 = Actor.method1628(ClientPacket.field2318, Client.field952.field1478);
                                       var9.packetBuffer.method3446(class11.field267);
                                       var9.packetBuffer.putShort(Client.field1006);
                                       var9.packetBuffer.putShort(var20.itemId);
                                       var9.packetBuffer.method3340(var0);
                                       var9.packetBuffer.putShort(Client.field1005);
                                       var9.packetBuffer.method3289(var1);
                                       Client.field952.method1951(var9);
                                    }
                                    break label807;
                                 }

                                 if(var2 == 1001) {
                                    Client.field956 = var6;
                                    Client.field957 = var7;
                                    Client.cursorState = 2;
                                    Client.field937 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = Actor.method1628(ClientPacket.field2347, Client.field952.field1478);
                                    var8.packetBuffer.putShort(var3 >> 14 & 32767);
                                    var8.packetBuffer.method3311(KeyFocusListener.field618[82]?1:0);
                                    var8.packetBuffer.putShort(var0 + ItemLayer.baseX);
                                    var8.packetBuffer.method3319(ItemLayer.baseY + var1);
                                    Client.field952.method1951(var8);
                                    break label807;
                                 }

                                 if(var2 == 1002) {
                                    Client.field956 = var6;
                                    Client.field957 = var7;
                                    Client.cursorState = 2;
                                    Client.field937 = 0;
                                    var8 = Actor.method1628(ClientPacket.field2316, Client.field952.field1478);
                                    var8.packetBuffer.method3340(var3 >> 14 & 32767);
                                    Client.field952.method1951(var8);
                                    break label807;
                                 }

                                 if(var2 == 1003) {
                                    Client.field956 = var6;
                                    Client.field957 = var7;
                                    Client.cursorState = 2;
                                    Client.field937 = 0;
                                    var15 = Client.cachedNPCs[var3];
                                    if(var15 != null) {
                                       NPCComposition var21 = var15.composition;
                                       if(var21.configs != null) {
                                          var21 = var21.transform();
                                       }

                                       if(var21 != null) {
                                          var10 = Actor.method1628(ClientPacket.field2385, Client.field952.field1478);
                                          var10.packetBuffer.method3340(var21.id);
                                          Client.field952.method1951(var10);
                                       }
                                    }
                                    break label807;
                                 }

                                 if(var2 == 1004) {
                                    Client.field956 = var6;
                                    Client.field957 = var7;
                                    Client.cursorState = 2;
                                    Client.field937 = 0;
                                    var8 = Actor.method1628(ClientPacket.field2328, Client.field952.field1478);
                                    var8.packetBuffer.method3319(var3);
                                    Client.field952.method1951(var8);
                                    break label807;
                                 }

                                 if(var2 == 1005) {
                                    var20 = PendingSpawn.method1612(var1);
                                    if(var20 != null && var20.itemQuantities[var0] >= 100000) {
                                       class96.sendGameMessage(27, "", var20.itemQuantities[var0] + " x " + class250.getItemDefinition(var3).name);
                                    } else {
                                       var9 = Actor.method1628(ClientPacket.field2328, Client.field952.field1478);
                                       var9.packetBuffer.method3319(var3);
                                       Client.field952.method1951(var9);
                                    }

                                    Client.field1066 = 0;
                                    class169.field2420 = PendingSpawn.method1612(var1);
                                    Client.field961 = var0;
                                    break label807;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1009 || var2 == 1011 || var2 == 1010 || var2 == 1008 || var2 == 1012) {
                                       Client.renderOverview.method5464(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label807;
                                 }
                              }

                              var20 = class189.method3613(var1, var0);
                              if(var20 != null) {
                                 class27.method234(var3, var1, var0, var20.itemId, var5);
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
         WorldMapData.method394(PendingSpawn.method1612(class5.field33));
      }

      if(Client.spellSelected) {
         Player.method1208();
      }

      if(class169.field2420 != null && Client.field1066 == 0) {
         WorldMapData.method394(class169.field2420);
      }

   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Lhk;S)Z",
      garbageValue = "21377"
   )
   static final boolean method1167(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field912 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1122.method4135(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1122.method4112(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1122.method4119(false);
         }

         if(var1 == 325) {
            Client.field1122.method4119(true);
         }

         if(var1 == 326) {
            PacketNode var4 = Actor.method1628(ClientPacket.field2384, Client.field952.field1478);
            Client.field1122.method4143(var4.packetBuffer);
            Client.field952.method1951(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
