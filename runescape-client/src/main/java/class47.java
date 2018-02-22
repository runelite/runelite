import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class47 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1163775563
   )
   public int field556;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public Coordinates field554;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public Coordinates field553;

   @ObfuscatedSignature(
      signature = "(ILhp;Lhp;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field556 = var1;
      this.field554 = var2;
      this.field553 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "116"
   )
   public static boolean method730(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("q")
   public static String method728(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class302.field3794[(int)(var6 - 37L * var0)];
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgu;I)I",
      garbageValue = "1473701162"
   )
   static int method731(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "10854"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class45.method681();
      ++Client.field863.field1440;
      if(Client.field863.field1440 >= 50 || var0) {
         Client.field863.field1440 = 0;
         if(!Client.socketError && Client.field863.getSocket() != null) {
            PacketNode var1 = class61.method1076(ClientPacket.field2385, Client.field863.field1434);
            Client.field863.method2039(var1);

            try {
               Client.field863.method2057();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "100"
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
         Client.field911 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class61.method1076(ClientPacket.field2354, Client.field863.field1434);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.writeShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(class195.field2555);
         var8.packetBuffer.method3641(var0 + ScriptState.baseX);
         var8.packetBuffer.writeShortLE(GameObject.selectedItemIndex);
         var8.packetBuffer.method3779(MouseInput.field670);
         var8.packetBuffer.putShort(WorldMapType1.baseY + var1);
         Client.field863.method2039(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field911 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class61.method1076(ClientPacket.field2368, Client.field863.field1434);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(WorldMapType1.baseY + var1);
         var8.packetBuffer.putShort(var0 + ScriptState.baseX);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.writeIntLE16(Client.field959);
         var8.packetBuffer.method3591(MouseRecorder.field761);
         Client.field863.method2039(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field911 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class61.method1076(ClientPacket.field2430, Client.field863.field1434);
         var8.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(WorldMapType1.baseY + var1);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(var0 + ScriptState.baseX);
         Client.field863.method2039(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field911 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class61.method1076(ClientPacket.field2423, Client.field863.field1434);
         var8.packetBuffer.writeShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.writeShortLE(WorldMapType1.baseY + var1);
         var8.packetBuffer.putShort(var0 + ScriptState.baseX);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         Client.field863.method2039(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field911 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class61.method1076(ClientPacket.field2417, Client.field863.field1434);
         var8.packetBuffer.method3573(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3641(WorldMapType1.baseY + var1);
         var8.packetBuffer.writeIntLE16(var0 + ScriptState.baseX);
         var8.packetBuffer.method3641(var3 >> 14 & 32767);
         Client.field863.method2039(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field911 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class61.method1076(ClientPacket.field2422, Client.field863.field1434);
         var8.packetBuffer.writeShortLE(WorldMapType1.baseY + var1);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.writeShortLE(var0 + ScriptState.baseX);
         Client.field863.method2039(var8);
      } else {
         PacketNode var9;
         NPC var15;
         if(var2 == 7) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class61.method1076(ClientPacket.field2406, Client.field863.field1434);
               var9.packetBuffer.writeShortLE(class195.field2555);
               var9.packetBuffer.method3624(MouseInput.field670);
               var9.packetBuffer.writeShortLE(var3);
               var9.packetBuffer.method3573(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeShortLE(GameObject.selectedItemIndex);
               Client.field863.method2039(var9);
            }
         } else if(var2 == 8) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class61.method1076(ClientPacket.field2378, Client.field863.field1434);
               var9.packetBuffer.method3779(MouseRecorder.field761);
               var9.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.writeIntLE16(Client.field959);
               Client.field863.method2039(var9);
            }
         } else if(var2 == 9) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class61.method1076(ClientPacket.field2376, Client.field863.field1434);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field863.method2039(var9);
            }
         } else if(var2 == 10) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class61.method1076(ClientPacket.field2370, Client.field863.field1434);
               var9.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeIntLE16(var3);
               Client.field863.method2039(var9);
            }
         } else if(var2 == 11) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class61.method1076(ClientPacket.field2347, Client.field863.field1434);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3641(var3);
               Client.field863.method2039(var9);
            }
         } else if(var2 == 12) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class61.method1076(ClientPacket.field2343, Client.field863.field1434);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeShortLE(var3);
               Client.field863.method2039(var9);
            }
         } else if(var2 == 13) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class61.method1076(ClientPacket.field2359, Client.field863.field1434);
               var9.packetBuffer.writeIntLE16(var3);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               Client.field863.method2039(var9);
            }
         } else {
            Player var18;
            if(var2 == 14) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field911 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class61.method1076(ClientPacket.field2360, Client.field863.field1434);
                  var9.packetBuffer.method3779(MouseInput.field670);
                  var9.packetBuffer.writeShortLE(GameObject.selectedItemIndex);
                  var9.packetBuffer.method3641(var3);
                  var9.packetBuffer.method3573(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.putShort(class195.field2555);
                  Client.field863.method2039(var9);
               }
            } else if(var2 == 15) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field911 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class61.method1076(ClientPacket.field2425, Client.field863.field1434);
                  var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.writeIntLE16(var3);
                  var9.packetBuffer.writeIntLE16(Client.field959);
                  var9.packetBuffer.putInt(MouseRecorder.field761);
                  Client.field863.method2039(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class61.method1076(ClientPacket.field2399, Client.field863.field1434);
               var8.packetBuffer.putShort(GameObject.selectedItemIndex);
               var8.packetBuffer.method3591(MouseInput.field670);
               var8.packetBuffer.writeShortLE(var0 + ScriptState.baseX);
               var8.packetBuffer.writeIntLE16(WorldMapType1.baseY + var1);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(class195.field2555);
               var8.packetBuffer.writeIntLE16(var3);
               Client.field863.method2039(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class61.method1076(ClientPacket.field2339, Client.field863.field1434);
               var8.packetBuffer.writeShortLE(var3);
               var8.packetBuffer.putInt(MouseRecorder.field761);
               var8.packetBuffer.writeShortLE(Client.field959);
               var8.packetBuffer.putShort(var0 + ScriptState.baseX);
               var8.packetBuffer.method3641(WorldMapType1.baseY + var1);
               var8.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
               Client.field863.method2039(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class61.method1076(ClientPacket.field2362, Client.field863.field1434);
               var8.packetBuffer.writeIntLE16(var3);
               var8.packetBuffer.putShort(WorldMapType1.baseY + var1);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3641(var0 + ScriptState.baseX);
               Client.field863.method2039(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class61.method1076(ClientPacket.field2404, Client.field863.field1434);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(WorldMapType1.baseY + var1);
               var8.packetBuffer.putShort(var0 + ScriptState.baseX);
               var8.packetBuffer.putShort(var3);
               Client.field863.method2039(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class61.method1076(ClientPacket.field2420, Client.field863.field1434);
               var8.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3641(var3);
               var8.packetBuffer.method3641(WorldMapType1.baseY + var1);
               var8.packetBuffer.writeShortLE(var0 + ScriptState.baseX);
               Client.field863.method2039(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class61.method1076(ClientPacket.field2381, Client.field863.field1434);
               var8.packetBuffer.method3573(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(var3);
               var8.packetBuffer.method3641(WorldMapType1.baseY + var1);
               var8.packetBuffer.writeIntLE16(var0 + ScriptState.baseX);
               Client.field863.method2039(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field911 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class61.method1076(ClientPacket.field2369, Client.field863.field1434);
               var8.packetBuffer.method3641(var3);
               var8.packetBuffer.method3641(var0 + ScriptState.baseX);
               var8.packetBuffer.method3573(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(WorldMapType1.baseY + var1);
               Client.field863.method2039(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  GameObject.region.method2921();
               } else {
                  GameObject.region.method2972(class230.plane, var0, var1, true);
               }
            } else {
               PacketNode var13;
               Widget var20;
               if(var2 == 24) {
                  var20 = NetWriter.getWidget(var1);
                  boolean var14 = true;
                  if(var20.contentType > 0) {
                     var14 = class29.method271(var20);
                  }

                  if(var14) {
                     var13 = class61.method1076(ClientPacket.field2372, Client.field863.field1434);
                     var13.packetBuffer.putInt(var1);
                     Client.field863.method2039(var13);
                  }
               } else {
                  int var10;
                  if(var2 == 25) {
                     var20 = class201.getWidgetChild(var1, var0);
                     if(var20 != null) {
                        NameableContainer.method5318();
                        int var19 = class89.method1879(class230.getWidgetConfig(var20));
                        var10 = var20.itemId;
                        Widget var11 = class201.getWidgetChild(var1, var0);
                        if(var11 != null && var11.field2868 != null) {
                           ScriptEvent var12 = new ScriptEvent();
                           var12.widget = var11;
                           var12.objs = var11.field2868;
                           class194.method3791(var12);
                        }

                        Client.field960 = var10;
                        Client.spellSelected = true;
                        MouseRecorder.field761 = var1;
                        Client.field959 = var0;
                        Size.field340 = var19;
                        ScriptEvent.method1132(var11);
                        Client.itemSelectionState = 0;
                        String var16;
                        if(class89.method1879(class230.getWidgetConfig(var20)) == 0) {
                           var16 = null;
                        } else if(var20.selectedAction != null && var20.selectedAction.trim().length() != 0) {
                           var16 = var20.selectedAction;
                        } else {
                           var16 = null;
                        }

                        Client.field961 = var16;
                        if(Client.field961 == null) {
                           Client.field961 = "Null";
                        }

                        if(var20.hasScript) {
                           Client.field962 = var20.name + BoundingBox3D.getColTags(16777215);
                        } else {
                           Client.field962 = BoundingBox3D.getColTags(65280) + var20.spellName + BoundingBox3D.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     MilliTimer.method3192();
                  } else {
                     Widget var17;
                     if(var2 == 28) {
                        var8 = class61.method1076(ClientPacket.field2372, Client.field863.field1434);
                        var8.packetBuffer.putInt(var1);
                        Client.field863.method2039(var8);
                        var17 = NetWriter.getWidget(var1);
                        if(var17.dynamicValues != null && var17.dynamicValues[0][0] == 5) {
                           var10 = var17.dynamicValues[0][1];
                           class231.widgetSettings[var10] = 1 - class231.widgetSettings[var10];
                           AbstractSoundSystem.method2232(var10);
                        }
                     } else if(var2 == 29) {
                        var8 = class61.method1076(ClientPacket.field2372, Client.field863.field1434);
                        var8.packetBuffer.putInt(var1);
                        Client.field863.method2039(var8);
                        var17 = NetWriter.getWidget(var1);
                        if(var17.dynamicValues != null && var17.dynamicValues[0][0] == 5) {
                           var10 = var17.dynamicValues[0][1];
                           if(class231.widgetSettings[var10] != var17.field2891[0]) {
                              class231.widgetSettings[var10] = var17.field2891[0];
                              AbstractSoundSystem.method2232(var10);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field930 == null) {
                           var8 = class61.method1076(ClientPacket.field2412, Client.field863.field1434);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3779(var1);
                           Client.field863.method2039(var8);
                           Client.field930 = class201.getWidgetChild(var1, var0);
                           ScriptEvent.method1132(Client.field930);
                        }
                     } else if(var2 == 31) {
                        var8 = class61.method1076(ClientPacket.field2383, Client.field863.field1434);
                        var8.packetBuffer.method3779(MouseInput.field670);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.putShort(class195.field2555);
                        var8.packetBuffer.writeShortLE(GameObject.selectedItemIndex);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field863.method2039(var8);
                        Client.mouseCrosshair = 0;
                        UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = class61.method1076(ClientPacket.field2344, Client.field863.field1434);
                        var8.packetBuffer.putShort(Client.field959);
                        var8.packetBuffer.writeIntLE16(var3);
                        var8.packetBuffer.method3624(MouseRecorder.field761);
                        var8.packetBuffer.method3779(var1);
                        var8.packetBuffer.writeShortLE(var0);
                        Client.field863.method2039(var8);
                        Client.mouseCrosshair = 0;
                        UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = class61.method1076(ClientPacket.field2431, Client.field863.field1434);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3591(var1);
                        var8.packetBuffer.putShort(var3);
                        Client.field863.method2039(var8);
                        Client.mouseCrosshair = 0;
                        UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = class61.method1076(ClientPacket.field2352, Client.field863.field1434);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.writeIntLE16(var0);
                        var8.packetBuffer.method3624(var1);
                        Client.field863.method2039(var8);
                        Client.mouseCrosshair = 0;
                        UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = class61.method1076(ClientPacket.field2358, Client.field863.field1434);
                        var8.packetBuffer.method3591(var1);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3641(var0);
                        Client.field863.method2039(var8);
                        Client.mouseCrosshair = 0;
                        UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = class61.method1076(ClientPacket.field2375, Client.field863.field1434);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3591(var1);
                        Client.field863.method2039(var8);
                        Client.mouseCrosshair = 0;
                        UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = class61.method1076(ClientPacket.field2401, Client.field863.field1434);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3624(var1);
                        var8.packetBuffer.putShort(var3);
                        Client.field863.method2039(var8);
                        Client.mouseCrosshair = 0;
                        UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           NameableContainer.method5318();
                           var20 = NetWriter.getWidget(var1);
                           Client.itemSelectionState = 1;
                           GameObject.selectedItemIndex = var0;
                           MouseInput.field670 = var1;
                           class195.field2555 = var3;
                           ScriptEvent.method1132(var20);
                           Client.lastSelectedItemName = BoundingBox3D.getColTags(16748608) + ContextMenuRow.getItemDefinition(var3).name + BoundingBox3D.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = class61.method1076(ClientPacket.field2361, Client.field863.field1434);
                           var8.packetBuffer.method3779(var1);
                           var8.packetBuffer.writeShortLE(var0);
                           var8.packetBuffer.method3641(var3);
                           Client.field863.method2039(var8);
                           Client.mouseCrosshair = 0;
                           UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = class61.method1076(ClientPacket.field2380, Client.field863.field1434);
                           var8.packetBuffer.method3624(var1);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.putShort(var0);
                           Client.field863.method2039(var8);
                           Client.mouseCrosshair = 0;
                           UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = class61.method1076(ClientPacket.field2386, Client.field863.field1434);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.method3641(var3);
                           var8.packetBuffer.method3641(var0);
                           Client.field863.method2039(var8);
                           Client.mouseCrosshair = 0;
                           UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = class61.method1076(ClientPacket.field2392, Client.field863.field1434);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3624(var1);
                           Client.field863.method2039(var8);
                           Client.mouseCrosshair = 0;
                           UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = class61.method1076(ClientPacket.field2341, Client.field863.field1434);
                           var8.packetBuffer.writeShortLE(var3);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3591(var1);
                           Client.field863.method2039(var8);
                           Client.mouseCrosshair = 0;
                           UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2408, Client.field863.field1434);
                              var9.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field863.method2039(var9);
                           }
                        } else if(var2 == 45) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2384, Client.field863.field1434);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field863.method2039(var9);
                           }
                        } else if(var2 == 46) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2413, Client.field863.field1434);
                              var9.packetBuffer.method3573(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              Client.field863.method2039(var9);
                           }
                        } else if(var2 == 47) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2388, Client.field863.field1434);
                              var9.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              Client.field863.method2039(var9);
                           }
                        } else if(var2 == 48) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2371, Client.field863.field1434);
                              var9.packetBuffer.writeIntLE16(var3);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field863.method2039(var9);
                           }
                        } else if(var2 == 49) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2338, Client.field863.field1434);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field863.method2039(var9);
                           }
                        } else if(var2 == 50) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2389, Client.field863.field1434);
                              var9.packetBuffer.writeIntLE16(var3);
                              var9.packetBuffer.method3573(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field863.method2039(var9);
                           }
                        } else if(var2 == 51) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field911 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class61.method1076(ClientPacket.field2357, Client.field863.field1434);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3574(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field863.method2039(var9);
                           }
                        } else {
                           label1060: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var20 = class201.getWidgetChild(var1, var0);
                                    if(var20 != null) {
                                       var9 = class61.method1076(ClientPacket.field2365, Client.field863.field1434);
                                       var9.packetBuffer.method3641(Client.field960);
                                       var9.packetBuffer.writeShortLE(Client.field959);
                                       var9.packetBuffer.method3591(MouseRecorder.field761);
                                       var9.packetBuffer.method3591(var1);
                                       var9.packetBuffer.method3641(var20.itemId);
                                       var9.packetBuffer.writeIntLE16(var0);
                                       Client.field863.method2039(var9);
                                    }
                                    break label1060;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field911 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = class61.method1076(ClientPacket.field2395, Client.field863.field1434);
                                    var8.packetBuffer.writeIntLE16(var0 + ScriptState.baseX);
                                    var8.packetBuffer.putShort(var3 >> 14 & 32767);
                                    var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.method3641(WorldMapType1.baseY + var1);
                                    Client.field863.method2039(var8);
                                    break label1060;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field911 = 0;
                                    var8 = class61.method1076(ClientPacket.field2432, Client.field863.field1434);
                                    var8.packetBuffer.method3641(var3 >> 14 & 32767);
                                    Client.field863.method2039(var8);
                                    break label1060;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field911 = 0;
                                    var15 = Client.cachedNPCs[var3];
                                    if(var15 != null) {
                                       NPCComposition var21 = var15.composition;
                                       if(var21.configs != null) {
                                          var21 = var21.transform();
                                       }

                                       if(var21 != null) {
                                          var13 = class61.method1076(ClientPacket.field2407, Client.field863.field1434);
                                          var13.packetBuffer.method3641(var21.id);
                                          Client.field863.method2039(var13);
                                       }
                                    }
                                    break label1060;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field911 = 0;
                                    var8 = class61.method1076(ClientPacket.field2366, Client.field863.field1434);
                                    var8.packetBuffer.writeIntLE16(var3);
                                    Client.field863.method2039(var8);
                                    break label1060;
                                 }

                                 if(var2 == 1005) {
                                    var20 = NetWriter.getWidget(var1);
                                    if(var20 != null && var20.itemQuantities[var0] >= 100000) {
                                       class149.sendGameMessage(27, "", var20.itemQuantities[var0] + " x " + ContextMenuRow.getItemDefinition(var3).name);
                                    } else {
                                       var9 = class61.method1076(ClientPacket.field2366, Client.field863.field1434);
                                       var9.packetBuffer.writeIntLE16(var3);
                                       Client.field863.method2039(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    UnitPriceComparator.field298 = NetWriter.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label1060;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1011 || var2 == 1009 || var2 == 1010 || var2 == 1008 || var2 == 1012) {
                                       BoundingBox3D.renderOverview.method6015(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label1060;
                                 }
                              }

                              var20 = class201.getWidgetChild(var1, var0);
                              if(var20 != null) {
                                 PacketNode.method3448(var3, var1, var0, var20.itemId, var5);
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
         ScriptEvent.method1132(NetWriter.getWidget(MouseInput.field670));
      }

      if(Client.spellSelected) {
         NameableContainer.method5318();
      }

      if(UnitPriceComparator.field298 != null && Client.mouseCrosshair == 0) {
         ScriptEvent.method1132(UnitPriceComparator.field298);
      }

   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lim;I)Ljava/lang/String;",
      garbageValue = "1836280907"
   )
   static String method733(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = ScriptState.method1104(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lim;IIII)V",
      garbageValue = "-575375707"
   )
   static final void method734(Widget var0, int var1, int var2, int var3) {
      class45.method681();
      class230 var4 = var0.method4429(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2732 + var1, var2 + var4.field2730);
         if(Client.field834 != 2 && Client.field834 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = OwnWorldComparator.localPlayer.x / 32 + 48;
            int var7 = 464 - OwnWorldComparator.localPlayer.y / 32;
            class131.minimapSprite.method5821(var1, var2, var4.field2732, var4.field2730, var6, var7, var5, 256, var4.field2733, var4.field2731);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1030; ++var8) {
               var9 = Client.field850[var8] * 4 + 2 - OwnWorldComparator.localPlayer.x / 32;
               var10 = Client.field1037[var8] * 4 + 2 - OwnWorldComparator.localPlayer.y / 32;
               class21.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var15 = Client.groundItemDeque[class230.plane][var8][var9];
                  if(var15 != null) {
                     var11 = var8 * 4 + 2 - OwnWorldComparator.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - OwnWorldComparator.localPlayer.y / 32;
                     class21.drawDot(var1, var2, var11, var12, class263.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var16 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var16 != null && var16.hasConfig()) {
                  NPCComposition var18 = var16.composition;
                  if(var18 != null && var18.configs != null) {
                     var18 = var18.transform();
                  }

                  if(var18 != null && var18.isMinimapVisible && var18.field3660) {
                     var11 = var16.x / 32 - OwnWorldComparator.localPlayer.x / 32;
                     var12 = var16.y / 32 - OwnWorldComparator.localPlayer.y / 32;
                     class21.drawDot(var1, var2, var11, var12, class263.mapDots[1], var4);
                  }
               }
            }

            var8 = class92.playerIndexesCount;
            int[] var19 = class92.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var17 = Client.cachedPlayers[var19[var10]];
               if(var17 != null && var17.hasConfig() && !var17.hidden && var17 != OwnWorldComparator.localPlayer) {
                  var12 = var17.x / 32 - OwnWorldComparator.localPlayer.x / 32;
                  int var13 = var17.y / 32 - OwnWorldComparator.localPlayer.y / 32;
                  boolean var14 = false;
                  if(OwnWorldComparator.localPlayer.team != 0 && var17.team != 0 && var17.team == OwnWorldComparator.localPlayer.team) {
                     var14 = true;
                  }

                  if(var17.isFriend()) {
                     class21.drawDot(var1, var2, var12, var13, class263.mapDots[3], var4);
                  } else if(var14) {
                     class21.drawDot(var1, var2, var12, var13, class263.mapDots[4], var4);
                  } else if(var17.isClanMember()) {
                     class21.drawDot(var1, var2, var12, var13, class263.mapDots[5], var4);
                  } else {
                     class21.drawDot(var1, var2, var12, var13, class263.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var20 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var20 != null) {
                     var11 = var20.x / 32 - OwnWorldComparator.localPlayer.x / 32;
                     var12 = var20.y / 32 - OwnWorldComparator.localPlayer.y / 32;
                     class19.worldToMinimap(var1, var2, var11, var12, class35.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - ScriptState.baseX * 4 + 2 - OwnWorldComparator.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - WorldMapType1.baseY * 4 + 2 - OwnWorldComparator.localPlayer.y / 32;
                  class19.worldToMinimap(var1, var2, var10, var11, class35.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var21 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var21 != null) {
                     var11 = var21.x / 32 - OwnWorldComparator.localPlayer.x / 32;
                     var12 = var21.y / 32 - OwnWorldComparator.localPlayer.y / 32;
                     class19.worldToMinimap(var1, var2, var11, var12, class35.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - OwnWorldComparator.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - OwnWorldComparator.localPlayer.y / 32;
               class21.drawDot(var1, var2, var10, var11, class35.mapMarkers[0], var4);
            }

            if(!OwnWorldComparator.localPlayer.hidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.field2732 / 2 + var1 - 1, var4.field2730 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5689(var1, var2, 0, var4.field2733, var4.field2731);
         }

         Client.field820[var3] = true;
      }
   }
}
