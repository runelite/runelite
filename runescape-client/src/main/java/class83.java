import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class83 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   static SpritePixels field1322;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static IndexedSprite field1324;
   @ObfuscatedName("g")
   volatile byte[] field1320;
   @ObfuscatedName("n")
   volatile boolean field1321;
   @ObfuscatedName("e")
   final URL field1323;

   class83(URL var1) {
      this.field1323 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-903877803"
   )
   boolean method1622() {
      return this.field1321;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1624072630"
   )
   byte[] method1623() {
      return this.field1320;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-831112243"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 50) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(253);
            Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.method3208(var3);
         }
      }

      NPC var16;
      if(var2 == 8) {
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(176);
            Client.secretPacketBuffer1.putShortLE(Client.field1058);
            Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.secretPacketBuffer1.putLEShortA(class22.field347);
         }
      }

      if(var2 == 48) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(162);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
         }
      }

      if(var2 == 46) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(186);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
         }
      }

      if(var2 == 42) {
         Client.secretPacketBuffer1.putOpcode(116);
         Client.secretPacketBuffer1.putInt(var1);
         Client.secretPacketBuffer1.putShortLE(var0);
         Client.secretPacketBuffer1.putShortLE(var3);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 18) {
         Client.field1029 = var6;
         Client.field1010 = var7;
         Client.cursorState = 2;
         Client.field1011 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(138);
         Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.method3208(ScriptEvent.baseY + var1);
         Client.secretPacketBuffer1.putLEInt(var0 + class25.baseX);
      }

      if(var2 == 12) {
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(181);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3201(KeyFocusListener.field631[82]?1:0);
         }
      }

      int var9;
      Widget var18;
      if(var2 == 28) {
         Client.secretPacketBuffer1.putOpcode(216);
         Client.secretPacketBuffer1.putInt(var1);
         var18 = class266.method4862(var1);
         if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
            var9 = var18.dynamicValues[0][1];
            class212.widgetSettings[var9] = 1 - class212.widgetSettings[var9];
            class5.method10(var9);
         }
      }

      if(var2 == 40) {
         Client.secretPacketBuffer1.putOpcode(143);
         Client.secretPacketBuffer1.method3208(var3);
         Client.secretPacketBuffer1.putLEShortA(var1);
         Client.secretPacketBuffer1.putLEInt(var0);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 49) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(217);
            Client.secretPacketBuffer1.method3208(var3);
            Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
         }
      }

      if(var2 == 39) {
         Client.secretPacketBuffer1.putOpcode(77);
         Client.secretPacketBuffer1.putLEShortA(var1);
         Client.secretPacketBuffer1.putLEInt(var3);
         Client.secretPacketBuffer1.putShort(var0);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 30 && Client.field1066 == null) {
         class3.method2(var1, var0);
         Client.field1066 = class24.method183(var1, var0);
         class255.method4531(Client.field1066);
      }

      if(var2 == 16) {
         Client.field1029 = var6;
         Client.field1010 = var7;
         Client.cursorState = 2;
         Client.field1011 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(163);
         Client.secretPacketBuffer1.method3208(WallObject.field2113);
         Client.secretPacketBuffer1.method3208(var0 + class25.baseX);
         Client.secretPacketBuffer1.putByte(KeyFocusListener.field631[82]?1:0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.method3208(ScriptEvent.baseY + var1);
         Client.secretPacketBuffer1.putShort(class31.selectedItemIndex);
         Client.secretPacketBuffer1.putLEShortA(class10.field261);
      }

      if(var2 == 43) {
         Client.secretPacketBuffer1.putOpcode(211);
         Client.secretPacketBuffer1.putShortLE(var3);
         Client.secretPacketBuffer1.putInt(var1);
         Client.secretPacketBuffer1.method3208(var0);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 22) {
         Client.field1029 = var6;
         Client.field1010 = var7;
         Client.cursorState = 2;
         Client.field1011 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(32);
         Client.secretPacketBuffer1.method3208(var3);
         Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
         Client.secretPacketBuffer1.putShort(var0 + class25.baseX);
         Client.secretPacketBuffer1.method3201(KeyFocusListener.field631[82]?1:0);
      }

      if(var2 == 44) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(56);
            Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var3);
         }
      }

      if(var2 == 35) {
         Client.secretPacketBuffer1.putOpcode(19);
         Client.secretPacketBuffer1.putInt(var1);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.putLEInt(var0);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 10) {
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(121);
            Client.secretPacketBuffer1.method3208(var3);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field631[82]?1:0);
         }
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(213);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putLEInt(var3);
         }
      }

      if(var2 == 13) {
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(148);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.secretPacketBuffer1.method3201(KeyFocusListener.field631[82]?1:0);
         }
      }

      if(var2 == 24) {
         var18 = class266.method4862(var1);
         boolean var17 = true;
         if(var18.contentType > 0) {
            var17 = class36.method498(var18);
         }

         if(var17) {
            Client.secretPacketBuffer1.putOpcode(216);
            Client.secretPacketBuffer1.putInt(var1);
         }
      }

      if(var2 == 34) {
         Client.secretPacketBuffer1.putOpcode(65);
         Client.secretPacketBuffer1.method3208(var3);
         Client.secretPacketBuffer1.method3208(var0);
         Client.secretPacketBuffer1.putLEShortA(var1);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 45) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(170);
            Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var3);
         }
      }

      if(var2 == 6) {
         Client.field1029 = var6;
         Client.field1010 = var7;
         Client.cursorState = 2;
         Client.field1011 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(220);
         Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
         Client.secretPacketBuffer1.putLEInt(var0 + class25.baseX);
      }

      if(var2 == 19) {
         Client.field1029 = var6;
         Client.field1010 = var7;
         Client.cursorState = 2;
         Client.field1011 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(237);
         Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.putLEInt(var0 + class25.baseX);
         Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
      }

      if(var2 == 41) {
         Client.secretPacketBuffer1.putOpcode(128);
         Client.secretPacketBuffer1.putShortLE(var0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.putInt(var1);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 1003) {
         Client.field1029 = var6;
         Client.field1010 = var7;
         Client.cursorState = 2;
         Client.field1011 = 0;
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            NPCComposition var15 = var16.composition;
            if(var15.configs != null) {
               var15 = var15.transform();
            }

            if(var15 != null) {
               Client.secretPacketBuffer1.putOpcode(35);
               Client.secretPacketBuffer1.method3208(var15.id);
            }
         }
      }

      if(var2 == 1) {
         Client.field1029 = var6;
         Client.field1010 = var7;
         Client.cursorState = 2;
         Client.field1011 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(8);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShortLE(WallObject.field2113);
         Client.secretPacketBuffer1.putShort(var0 + class25.baseX);
         Client.secretPacketBuffer1.method3208(ScriptEvent.baseY + var1);
         Client.secretPacketBuffer1.putShortLE(class31.selectedItemIndex);
         Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
         Client.secretPacketBuffer1.method3219(class10.field261);
      }

      if(var2 == 36) {
         Client.secretPacketBuffer1.putOpcode(129);
         Client.secretPacketBuffer1.method3177(var1);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.putShortLE(var0);
         Client.field1156 = 0;
         class227.field3110 = class266.method4862(var1);
         Client.field957 = var0;
      }

      if(var2 == 57 || var2 == 1007) {
         var18 = class24.method183(var1, var0);
         if(var18 != null) {
            WorldMapData.method342(var3, var1, var0, var18.itemId, var5);
         }
      }

      if(var2 == 14) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(55);
            Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(WallObject.field2113);
            Client.secretPacketBuffer1.putShortLE(class31.selectedItemIndex);
            Client.secretPacketBuffer1.method3177(class10.field261);
            Client.secretPacketBuffer1.putShort(var3);
         }
      }

      if(var2 == 23) {
         if(Client.isMenuOpen) {
            class84.region.method2838();
         } else {
            class84.region.method2747(class29.plane, var0, var1, true);
         }
      }

      if(var2 == 38) {
         class226.method4085();
         var18 = class266.method4862(var1);
         Client.itemSelectionState = 1;
         class31.selectedItemIndex = var0;
         class10.field261 = var1;
         WallObject.field2113 = var3;
         class255.method4531(var18);
         Client.field1056 = RSSocket.getColTags(16748608) + ClassInfo.getItemDefinition(var3).name + RSSocket.getColTags(16777215);
         if(Client.field1056 == null) {
            Client.field1056 = "null";
         }

      } else {
         if(var2 == 37) {
            Client.secretPacketBuffer1.putOpcode(189);
            Client.secretPacketBuffer1.putLEShortA(var1);
            Client.secretPacketBuffer1.putShortLE(var0);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.field1156 = 0;
            class227.field3110 = class266.method4862(var1);
            Client.field957 = var0;
         }

         if(var2 == 17) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(22);
            Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
            Client.secretPacketBuffer1.method3219(class22.field347);
            Client.secretPacketBuffer1.putLEInt(Client.field1058);
            Client.secretPacketBuffer1.putLEInt(var0 + class25.baseX);
         }

         if(var2 == 9) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.field1029 = var6;
               Client.field1010 = var7;
               Client.cursorState = 2;
               Client.field1011 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(61);
               Client.secretPacketBuffer1.putLEInt(var3);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field631[82]?1:0);
            }
         }

         if(var2 == 31) {
            Client.secretPacketBuffer1.putOpcode(108);
            Client.secretPacketBuffer1.method3208(WallObject.field2113);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3208(class31.selectedItemIndex);
            Client.secretPacketBuffer1.putLEShortA(var1);
            Client.secretPacketBuffer1.method3219(class10.field261);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field1156 = 0;
            class227.field3110 = class266.method4862(var1);
            Client.field957 = var0;
         }

         if(var2 == 1001) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(31);
            Client.secretPacketBuffer1.putShortLE(var0 + class25.baseX);
            Client.secretPacketBuffer1.method3201(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putLEInt(ScriptEvent.baseY + var1);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         }

         if(var2 == 33) {
            Client.secretPacketBuffer1.putOpcode(173);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.method3177(var1);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field1156 = 0;
            class227.field3110 = class266.method4862(var1);
            Client.field957 = var0;
         }

         if(var2 == 26) {
            class34.method462();
         }

         if(var2 == 58) {
            var18 = class24.method183(var1, var0);
            if(var18 != null) {
               Client.secretPacketBuffer1.putOpcode(11);
               Client.secretPacketBuffer1.putLEInt(Client.field920);
               Client.secretPacketBuffer1.putLEInt(Client.field1058);
               Client.secretPacketBuffer1.putShortLE(var18.itemId);
               Client.secretPacketBuffer1.putShortLE(var0);
               Client.secretPacketBuffer1.putInt(class22.field347);
               Client.secretPacketBuffer1.putInt(var1);
            }
         }

         if(var2 == 1004) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.secretPacketBuffer1.putOpcode(96);
            Client.secretPacketBuffer1.putLEInt(var3);
         }

         if(var2 == 32) {
            Client.secretPacketBuffer1.putOpcode(161);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.putShortLE(var0);
            Client.secretPacketBuffer1.method3219(class22.field347);
            Client.secretPacketBuffer1.putLEInt(Client.field1058);
            Client.secretPacketBuffer1.putInt(var1);
            Client.field1156 = 0;
            class227.field3110 = class266.method4862(var1);
            Client.field957 = var0;
         }

         if(var2 == 20) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(254);
            Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
            Client.secretPacketBuffer1.putLEInt(var0 + class25.baseX);
            Client.secretPacketBuffer1.putShort(var3);
         }

         if(var2 == 21) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(206);
            Client.secretPacketBuffer1.method3208(var0 + class25.baseX);
            Client.secretPacketBuffer1.method3208(ScriptEvent.baseY + var1);
            Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3);
         }

         if(var2 == 1005) {
            var18 = class266.method4862(var1);
            if(var18 != null && var18.itemQuantities[var0] >= 100000) {
               WorldMapType3.sendGameMessage(27, "", var18.itemQuantities[var0] + " x " + ClassInfo.getItemDefinition(var3).name);
            } else {
               Client.secretPacketBuffer1.putOpcode(96);
               Client.secretPacketBuffer1.putLEInt(var3);
            }

            Client.field1156 = 0;
            class227.field3110 = class266.method4862(var1);
            Client.field957 = var0;
         }

         if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
            BaseVarType.renderOverview.method5276(var2, var3, new Coordinates(var0), new Coordinates(var1));
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field1029 = var6;
               Client.field1010 = var7;
               Client.cursorState = 2;
               Client.field1011 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(29);
               Client.secretPacketBuffer1.method3276(KeyFocusListener.field631[82]?1:0);
               Client.secretPacketBuffer1.putLEInt(var3);
            }
         }

         if(var2 == 7) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.field1029 = var6;
               Client.field1010 = var7;
               Client.cursorState = 2;
               Client.field1011 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(100);
               Client.secretPacketBuffer1.putLEInt(class31.selectedItemIndex);
               Client.secretPacketBuffer1.putLEInt(WallObject.field2113);
               Client.secretPacketBuffer1.method3201(KeyFocusListener.field631[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.putInt(class10.field261);
            }
         }

         if(var2 == 4) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(119);
            Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShortLE(var0 + class25.baseX);
         }

         if(var2 == 2) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(25);
            Client.secretPacketBuffer1.method3208(Client.field1058);
            Client.secretPacketBuffer1.method3208(ScriptEvent.baseY + var1);
            Client.secretPacketBuffer1.putShort(var0 + class25.baseX);
            Client.secretPacketBuffer1.method3201(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.method3208(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3177(class22.field347);
         }

         if(var2 == 5) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(238);
            Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
            Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3201(KeyFocusListener.field631[82]?1:0);
            Client.secretPacketBuffer1.putShort(var0 + class25.baseX);
         }

         if(var2 == 11) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.field1029 = var6;
               Client.field1010 = var7;
               Client.cursorState = 2;
               Client.field1011 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(37);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field631[82]?1:0);
            }
         }

         if(var2 == 1002) {
            Client.field1029 = var6;
            Client.field1010 = var7;
            Client.cursorState = 2;
            Client.field1011 = 0;
            Client.secretPacketBuffer1.putOpcode(231);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         }

         if(var2 == 25) {
            var18 = class24.method183(var1, var0);
            if(var18 != null) {
               class226.method4085();
               int var10 = class15.getWidgetConfig(var18);
               var9 = var10 >> 11 & 63;
               int var12 = var18.itemId;
               Widget var13 = class24.method183(var1, var0);
               if(var13 != null && var13.field2714 != null) {
                  ScriptEvent var14 = new ScriptEvent();
                  var14.widget = var13;
                  var14.field849 = var13.field2714;
                  PendingSpawn.method1525(var14);
               }

               Client.field920 = var12;
               Client.spellSelected = true;
               class22.field347 = var1;
               Client.field1058 = var0;
               class1.field4 = var9;
               class255.method4531(var13);
               Client.itemSelectionState = 0;
               Client.field997 = class72.method1123(var18);
               if(Client.field997 == null) {
                  Client.field997 = "Null";
               }

               if(var18.hasScript) {
                  Client.field1061 = var18.name + RSSocket.getColTags(16777215);
               } else {
                  Client.field1061 = RSSocket.getColTags('\uff00') + var18.field2652 + RSSocket.getColTags(16777215);
               }
            }

         } else {
            if(var2 == 15) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field1029 = var6;
                  Client.field1010 = var7;
                  Client.cursorState = 2;
                  Client.field1011 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(125);
                  Client.secretPacketBuffer1.putLEShortA(class22.field347);
                  Client.secretPacketBuffer1.putLEInt(var3);
                  Client.secretPacketBuffer1.method3208(Client.field1058);
                  Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?1:0);
               }
            }

            if(var2 == 3) {
               Client.field1029 = var6;
               Client.field1010 = var7;
               Client.cursorState = 2;
               Client.field1011 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(13);
               Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.putShort(var0 + class25.baseX);
               Client.secretPacketBuffer1.putShortLE(ScriptEvent.baseY + var1);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field631[82]?1:0);
            }

            if(var2 == 29) {
               Client.secretPacketBuffer1.putOpcode(216);
               Client.secretPacketBuffer1.putInt(var1);
               var18 = class266.method4862(var1);
               if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                  var9 = var18.dynamicValues[0][1];
                  if(class212.widgetSettings[var9] != var18.field2734[0]) {
                     class212.widgetSettings[var9] = var18.field2734[0];
                     class5.method10(var9);
                  }
               }
            }

            if(Client.itemSelectionState != 0) {
               Client.itemSelectionState = 0;
               class255.method4531(class266.method4862(class10.field261));
            }

            if(Client.spellSelected) {
               class226.method4085();
            }

            if(class227.field3110 != null && Client.field1156 == 0) {
               class255.method4531(class227.field3110);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1523291113"
   )
   static int method1621(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class99.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1902();
   }
}
