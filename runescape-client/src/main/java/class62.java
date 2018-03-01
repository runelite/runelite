import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public final class class62 {
   @ObfuscatedName("d")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("z")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1360362405
   )
   static int field736;
   @ObfuscatedName("e")
   static byte[][][] field744;
   @ObfuscatedName("y")
   static byte[][][] field734;
   @ObfuscatedName("k")
   static byte[][][] field739;
   @ObfuscatedName("s")
   static byte[][][] field740;
   @ObfuscatedName("p")
   static int[][] field741;
   @ObfuscatedName("u")
   static int[][][] field738;
   @ObfuscatedName("b")
   static final int[] field743;
   @ObfuscatedName("c")
   static final int[] field749;
   @ObfuscatedName("j")
   static final int[] field745;
   @ObfuscatedName("l")
   static final int[] field746;
   @ObfuscatedName("g")
   static final int[] field747;
   @ObfuscatedName("w")
   static final int[] field748;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -766173067
   )
   static int field742;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -611449387
   )
   static int field750;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 1574323673
   )
   static int field751;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field736 = 99;
      field743 = new int[]{1, 2, 4, 8};
      field749 = new int[]{16, 32, 64, 128};
      field745 = new int[]{1, 0, -1, 0};
      field746 = new int[]{0, -1, 0, 1};
      field747 = new int[]{1, -1, -1, 1};
      field748 = new int[]{-1, -1, 1, 1};
      field742 = (int)(Math.random() * 17.0D) - 8;
      field750 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("z")
   public static String method1058(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class316.field3914[(int)(var6 - var0 * 37L)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-2114558412"
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
         Client.field953 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class31.method285(ClientPacket.field2381, Client.field899.field1470);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3746(MapIcon.selectedItemIndex);
         var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3754(Script.field1438);
         var8.packetBuffer.putShort(var0 + WorldMapType1.baseX);
         var8.packetBuffer.method3626(class71.field820);
         var8.packetBuffer.method3746(Enum.baseY + var1);
         Client.field899.method2082(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field953 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class31.method285(ClientPacket.field2394, Client.field899.field1470);
         var8.packetBuffer.method3754(Enum.baseY + var1);
         var8.packetBuffer.method3754(Client.field1042);
         var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3746(var3 >> 14 & 32767);
         var8.packetBuffer.method3790(WidgetNode.field785);
         var8.packetBuffer.putShort(var0 + WorldMapType1.baseX);
         Client.field899.method2082(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field953 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class31.method285(ClientPacket.field2440, Client.field899.field1470);
         var8.packetBuffer.method3754(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(Enum.baseY + var1);
         var8.packetBuffer.method3616(var0 + WorldMapType1.baseX);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         Client.field899.method2082(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field953 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class31.method285(ClientPacket.field2387, Client.field899.field1470);
         var8.packetBuffer.method3746(var0 + WorldMapType1.baseX);
         var8.packetBuffer.method3746(Enum.baseY + var1);
         var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3754(var3 >> 14 & 32767);
         Client.field899.method2082(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field953 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class31.method285(ClientPacket.field2454, Client.field899.field1470);
         var8.packetBuffer.method3754(var3 >> 14 & 32767);
         var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3746(var0 + WorldMapType1.baseX);
         var8.packetBuffer.method3746(Enum.baseY + var1);
         Client.field899.method2082(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field953 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class31.method285(ClientPacket.field2403, Client.field899.field1470);
         var8.packetBuffer.method3754(var0 + WorldMapType1.baseX);
         var8.packetBuffer.method3746(Enum.baseY + var1);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3754(var3 >> 14 & 32767);
         Client.field899.method2082(var8);
      } else {
         PacketNode var9;
         NPC var17;
         if(var2 == 7) {
            var17 = Client.cachedNPCs[var3];
            if(var17 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class31.method285(ClientPacket.field2382, Client.field899.field1470);
               var9.packetBuffer.method3626(class71.field820);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3616(MapIcon.selectedItemIndex);
               var9.packetBuffer.method3754(Script.field1438);
               Client.field899.method2082(var9);
            }
         } else if(var2 == 8) {
            var17 = Client.cachedNPCs[var3];
            if(var17 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class31.method285(ClientPacket.field2390, Client.field899.field1470);
               var9.packetBuffer.method3626(WidgetNode.field785);
               var9.packetBuffer.method3616(Client.field1042);
               var9.packetBuffer.method3754(var3);
               var9.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
               Client.field899.method2082(var9);
            }
         } else if(var2 == 9) {
            var17 = Client.cachedNPCs[var3];
            if(var17 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class31.method285(ClientPacket.field2397, Client.field899.field1470);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3746(var3);
               Client.field899.method2082(var9);
            }
         } else if(var2 == 10) {
            var17 = Client.cachedNPCs[var3];
            if(var17 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class31.method285(ClientPacket.field2412, Client.field899.field1470);
               var9.packetBuffer.method3607(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               Client.field899.method2082(var9);
            }
         } else if(var2 == 11) {
            var17 = Client.cachedNPCs[var3];
            if(var17 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class31.method285(ClientPacket.field2465, Client.field899.field1470);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3754(var3);
               Client.field899.method2082(var9);
            }
         } else if(var2 == 12) {
            var17 = Client.cachedNPCs[var3];
            if(var17 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class31.method285(ClientPacket.field2417, Client.field899.field1470);
               var9.packetBuffer.method3616(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field899.method2082(var9);
            }
         } else if(var2 == 13) {
            var17 = Client.cachedNPCs[var3];
            if(var17 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class31.method285(ClientPacket.field2408, Client.field899.field1470);
               var9.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3754(var3);
               Client.field899.method2082(var9);
            }
         } else {
            Player var20;
            if(var2 == 14) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field953 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class31.method285(ClientPacket.field2462, Client.field899.field1470);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3746(var3);
                  var9.packetBuffer.method3754(MapIcon.selectedItemIndex);
                  var9.packetBuffer.method3790(class71.field820);
                  var9.packetBuffer.method3746(Script.field1438);
                  Client.field899.method2082(var9);
               }
            } else if(var2 == 15) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field953 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class31.method285(ClientPacket.field2443, Client.field899.field1470);
                  var9.packetBuffer.putInt(WidgetNode.field785);
                  var9.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3616(var3);
                  var9.packetBuffer.method3746(Client.field1042);
                  Client.field899.method2082(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class31.method285(ClientPacket.field2378, Client.field899.field1470);
               var8.packetBuffer.method3616(var3);
               var8.packetBuffer.method3746(Script.field1438);
               var8.packetBuffer.method3754(Enum.baseY + var1);
               var8.packetBuffer.method3746(MapIcon.selectedItemIndex);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(var0 + WorldMapType1.baseX);
               var8.packetBuffer.putInt(class71.field820);
               Client.field899.method2082(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class31.method285(ClientPacket.field2420, Client.field899.field1470);
               var8.packetBuffer.method3626(WidgetNode.field785);
               var8.packetBuffer.method3746(Client.field1042);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3746(Enum.baseY + var1);
               var8.packetBuffer.method3746(var3);
               var8.packetBuffer.method3616(var0 + WorldMapType1.baseX);
               Client.field899.method2082(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class31.method285(ClientPacket.field2428, Client.field899.field1470);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3746(var0 + WorldMapType1.baseX);
               var8.packetBuffer.method3616(Enum.baseY + var1);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field899.method2082(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class31.method285(ClientPacket.field2419, Client.field899.field1470);
               var8.packetBuffer.putShort(var0 + WorldMapType1.baseX);
               var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3616(Enum.baseY + var1);
               Client.field899.method2082(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class31.method285(ClientPacket.field2400, Client.field899.field1470);
               var8.packetBuffer.method3616(var3);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3746(var0 + WorldMapType1.baseX);
               var8.packetBuffer.method3746(Enum.baseY + var1);
               Client.field899.method2082(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class31.method285(ClientPacket.field2392, Client.field899.field1470);
               var8.packetBuffer.method3746(var0 + WorldMapType1.baseX);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3754(var3);
               var8.packetBuffer.method3754(Enum.baseY + var1);
               Client.field899.method2082(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field953 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class31.method285(ClientPacket.field2467, Client.field899.field1470);
               var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3754(var0 + WorldMapType1.baseX);
               var8.packetBuffer.putShort(Enum.baseY + var1);
               var8.packetBuffer.method3754(var3);
               Client.field899.method2082(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class86.region.method2970();
               } else {
                  class86.region.method2969(class36.plane, var0, var1, true);
               }
            } else {
               PacketNode var14;
               Widget var23;
               if(var2 == 24) {
                  var23 = class5.getWidget(var1);
                  boolean var13 = true;
                  if(var23.contentType > 0) {
                     var13 = class1.method2(var23);
                  }

                  if(var13) {
                     var14 = class31.method285(ClientPacket.field2432, Client.field899.field1470);
                     var14.packetBuffer.putInt(var1);
                     Client.field899.method2082(var14);
                  }
               } else {
                  if(var2 == 25) {
                     var23 = class197.getWidgetChild(var1, var0);
                     if(var23 != null) {
                        class240.method4546();
                        int var12 = class85.getWidgetConfig(var23);
                        int var18 = var12 >> 11 & 63;
                        class3.method9(var1, var0, var18, var23.itemId);
                        Client.itemSelectionState = 0;
                        Client.field1097 = class170.method3340(var23);
                        if(Client.field1097 == null) {
                           Client.field1097 = "Null";
                        }

                        if(var23.hasScript) {
                           Client.field941 = var23.name + IndexFile.getColTags(16777215);
                        } else {
                           Client.field941 = IndexFile.getColTags(65280) + var23.spellName + IndexFile.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     class29.method250();
                  } else {
                     int var10;
                     Widget var19;
                     if(var2 == 28) {
                        var8 = class31.method285(ClientPacket.field2432, Client.field899.field1470);
                        var8.packetBuffer.putInt(var1);
                        Client.field899.method2082(var8);
                        var19 = class5.getWidget(var1);
                        if(var19.dynamicValues != null && var19.dynamicValues[0][0] == 5) {
                           var10 = var19.dynamicValues[0][1];
                           class237.widgetSettings[var10] = 1 - class237.widgetSettings[var10];
                           class149.method3193(var10);
                        }
                     } else if(var2 == 29) {
                        var8 = class31.method285(ClientPacket.field2432, Client.field899.field1470);
                        var8.packetBuffer.putInt(var1);
                        Client.field899.method2082(var8);
                        var19 = class5.getWidget(var1);
                        if(var19.dynamicValues != null && var19.dynamicValues[0][0] == 5) {
                           var10 = var19.dynamicValues[0][1];
                           if(class237.widgetSettings[var10] != var19.field2939[0]) {
                              class237.widgetSettings[var10] = var19.field2939[0];
                              class149.method3193(var10);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1014 == null) {
                           class61.method1023(var1, var0);
                           Client.field1014 = class197.getWidgetChild(var1, var0);
                           class171.method3363(Client.field1014);
                        }
                     } else if(var2 == 31) {
                        var8 = class31.method285(ClientPacket.field2435, Client.field899.field1470);
                        var8.packetBuffer.method3790(var1);
                        var8.packetBuffer.putShort(MapIcon.selectedItemIndex);
                        var8.packetBuffer.method3746(var3);
                        var8.packetBuffer.method3746(Script.field1438);
                        var8.packetBuffer.method3746(var0);
                        var8.packetBuffer.method3790(class71.field820);
                        Client.field899.method2082(var8);
                        Client.mouseCrosshair = 0;
                        MapLabel.field477 = class5.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = class31.method285(ClientPacket.field2459, Client.field899.field1470);
                        var8.packetBuffer.method3746(var0);
                        var8.packetBuffer.method3746(Client.field1042);
                        var8.packetBuffer.method3625(var1);
                        var8.packetBuffer.method3746(var3);
                        var8.packetBuffer.putInt(WidgetNode.field785);
                        Client.field899.method2082(var8);
                        Client.mouseCrosshair = 0;
                        MapLabel.field477 = class5.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = class31.method285(ClientPacket.field2438, Client.field899.field1470);
                        var8.packetBuffer.method3616(var3);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3625(var1);
                        Client.field899.method2082(var8);
                        Client.mouseCrosshair = 0;
                        MapLabel.field477 = class5.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = class31.method285(ClientPacket.field2398, Client.field899.field1470);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3754(var0);
                        var8.packetBuffer.method3616(var3);
                        Client.field899.method2082(var8);
                        Client.mouseCrosshair = 0;
                        MapLabel.field477 = class5.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = class31.method285(ClientPacket.field2429, Client.field899.field1470);
                        var8.packetBuffer.method3616(var3);
                        var8.packetBuffer.method3746(var0);
                        var8.packetBuffer.method3625(var1);
                        Client.field899.method2082(var8);
                        Client.mouseCrosshair = 0;
                        MapLabel.field477 = class5.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = class31.method285(ClientPacket.field2410, Client.field899.field1470);
                        var8.packetBuffer.method3625(var1);
                        var8.packetBuffer.method3754(var3);
                        var8.packetBuffer.method3616(var0);
                        Client.field899.method2082(var8);
                        Client.mouseCrosshair = 0;
                        MapLabel.field477 = class5.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = class31.method285(ClientPacket.field2442, Client.field899.field1470);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3754(var0);
                        var8.packetBuffer.method3625(var1);
                        Client.field899.method2082(var8);
                        Client.mouseCrosshair = 0;
                        MapLabel.field477 = class5.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           class240.method4546();
                           var23 = class5.getWidget(var1);
                           Client.itemSelectionState = 1;
                           MapIcon.selectedItemIndex = var0;
                           class71.field820 = var1;
                           Script.field1438 = var3;
                           class171.method3363(var23);
                           Client.lastSelectedItemName = IndexFile.getColTags(16748608) + class251.getItemDefinition(var3).name + IndexFile.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = class31.method285(ClientPacket.field2401, Client.field899.field1470);
                           var8.packetBuffer.method3625(var1);
                           var8.packetBuffer.method3616(var0);
                           var8.packetBuffer.method3616(var3);
                           Client.field899.method2082(var8);
                           Client.mouseCrosshair = 0;
                           MapLabel.field477 = class5.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = class31.method285(ClientPacket.field2461, Client.field899.field1470);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.method3754(var3);
                           var8.packetBuffer.method3754(var0);
                           Client.field899.method2082(var8);
                           Client.mouseCrosshair = 0;
                           MapLabel.field477 = class5.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = class31.method285(ClientPacket.field2463, Client.field899.field1470);
                           var8.packetBuffer.method3746(var0);
                           var8.packetBuffer.method3626(var1);
                           var8.packetBuffer.method3746(var3);
                           Client.field899.method2082(var8);
                           Client.mouseCrosshair = 0;
                           MapLabel.field477 = class5.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = class31.method285(ClientPacket.field2385, Client.field899.field1470);
                           var8.packetBuffer.method3746(var3);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3626(var1);
                           Client.field899.method2082(var8);
                           Client.mouseCrosshair = 0;
                           MapLabel.field477 = class5.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = class31.method285(ClientPacket.field2452, Client.field899.field1470);
                           var8.packetBuffer.method3616(var0);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.putInt(var1);
                           Client.field899.method2082(var8);
                           Client.mouseCrosshair = 0;
                           MapLabel.field477 = class5.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2450, Client.field899.field1470);
                              var9.packetBuffer.method3607(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3754(var3);
                              Client.field899.method2082(var9);
                           }
                        } else if(var2 == 45) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2396, Client.field899.field1470);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3746(var3);
                              Client.field899.method2082(var9);
                           }
                        } else if(var2 == 46) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2458, Client.field899.field1470);
                              var9.packetBuffer.method3754(var3);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field899.method2082(var9);
                           }
                        } else if(var2 == 47) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2441, Client.field899.field1470);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field899.method2082(var9);
                           }
                        } else if(var2 == 48) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2416, Client.field899.field1470);
                              var9.packetBuffer.method3607(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3754(var3);
                              Client.field899.method2082(var9);
                           }
                        } else if(var2 == 49) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2413, Client.field899.field1470);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field899.method2082(var9);
                           }
                        } else if(var2 == 50) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2456, Client.field899.field1470);
                              var9.packetBuffer.method3607(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3754(var3);
                              Client.field899.method2082(var9);
                           }
                        } else if(var2 == 51) {
                           var20 = Client.cachedPlayers[var3];
                           if(var20 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field953 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class31.method285(ClientPacket.field2425, Client.field899.field1470);
                              var9.packetBuffer.method3616(var3);
                              var9.packetBuffer.method3607(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field899.method2082(var9);
                           }
                        } else {
                           label857: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var23 = class197.getWidgetChild(var1, var0);
                                    if(var23 != null) {
                                       var9 = class31.method285(ClientPacket.field2437, Client.field899.field1470);
                                       var9.packetBuffer.method3754(Client.field1007);
                                       var9.packetBuffer.putShort(var0);
                                       var9.packetBuffer.putInt(WidgetNode.field785);
                                       var9.packetBuffer.putShort(Client.field1042);
                                       var9.packetBuffer.putShort(var23.itemId);
                                       var9.packetBuffer.method3626(var1);
                                       Client.field899.method2082(var9);
                                    }
                                    break label857;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field953 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = class31.method285(ClientPacket.field2436, Client.field899.field1470);
                                    var8.packetBuffer.method3607(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.putShort(Enum.baseY + var1);
                                    var8.packetBuffer.method3754(var0 + WorldMapType1.baseX);
                                    var8.packetBuffer.putShort(var3 >> 14 & 32767);
                                    Client.field899.method2082(var8);
                                    break label857;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field953 = 0;
                                    var8 = class31.method285(ClientPacket.field2383, Client.field899.field1470);
                                    var8.packetBuffer.putShort(var3 >> 14 & 32767);
                                    Client.field899.method2082(var8);
                                    break label857;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field953 = 0;
                                    var17 = Client.cachedNPCs[var3];
                                    if(var17 != null) {
                                       NPCComposition var24 = var17.composition;
                                       if(var24.configs != null) {
                                          var24 = var24.transform();
                                       }

                                       if(var24 != null) {
                                          var14 = class31.method285(ClientPacket.field2469, Client.field899.field1470);
                                          var14.packetBuffer.method3616(var24.id);
                                          Client.field899.method2082(var14);
                                       }
                                    }
                                    break label857;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field953 = 0;
                                    var8 = class31.method285(ClientPacket.field2409, Client.field899.field1470);
                                    var8.packetBuffer.putShort(var3);
                                    Client.field899.method2082(var8);
                                    break label857;
                                 }

                                 if(var2 == 1005) {
                                    var23 = class5.getWidget(var1);
                                    if(var23 != null && var23.itemQuantities[var0] >= 100000) {
                                       class19.sendGameMessage(27, "", var23.itemQuantities[var0] + " x " + class251.getItemDefinition(var3).name);
                                    } else {
                                       var9 = class31.method285(ClientPacket.field2409, Client.field899.field1470);
                                       var9.packetBuffer.putShort(var3);
                                       Client.field899.method2082(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    MapLabel.field477 = class5.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label857;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1011 || var2 == 1010 || var2 == 1009 || var2 == 1008 || var2 == 1012) {
                                       class248.renderOverview.method6122(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label857;
                                 }
                              }

                              var23 = class197.getWidgetChild(var1, var0);
                              if(var23 != null) {
                                 int var21 = var23.itemId;
                                 Widget var22 = class197.getWidgetChild(var1, var0);
                                 if(var22 != null) {
                                    if(var22.field2925 != null) {
                                       ScriptEvent var15 = new ScriptEvent();
                                       var15.widget = var22;
                                       var15.field798 = var3;
                                       var15.string = var5;
                                       var15.objs = var22.field2925;
                                       GameCanvas.method800(var15);
                                    }

                                    boolean var11 = true;
                                    if(var22.contentType > 0) {
                                       var11 = class1.method2(var22);
                                    }

                                    if(var11 && class196.method3828(class85.getWidgetConfig(var22), var3 - 1)) {
                                       PacketNode var16;
                                       if(var3 == 1) {
                                          var16 = class31.method285(ClientPacket.field2449, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 2) {
                                          var16 = class31.method285(ClientPacket.field2471, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 3) {
                                          var16 = class31.method285(ClientPacket.field2439, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 4) {
                                          var16 = class31.method285(ClientPacket.field2433, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 5) {
                                          var16 = class31.method285(ClientPacket.field2466, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 6) {
                                          var16 = class31.method285(ClientPacket.field2444, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 7) {
                                          var16 = class31.method285(ClientPacket.field2406, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 8) {
                                          var16 = class31.method285(ClientPacket.field2395, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 9) {
                                          var16 = class31.method285(ClientPacket.field2446, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
                                       }

                                       if(var3 == 10) {
                                          var16 = class31.method285(ClientPacket.field2453, Client.field899.field1470);
                                          var16.packetBuffer.putInt(var1);
                                          var16.packetBuffer.putShort(var0);
                                          var16.packetBuffer.putShort(var21);
                                          Client.field899.method2082(var16);
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
         class171.method3363(class5.getWidget(class71.field820));
      }

      if(Client.spellSelected) {
         class240.method4546();
      }

      if(MapLabel.field477 != null && Client.mouseCrosshair == 0) {
         class171.method3363(MapLabel.field477);
      }

   }
}
