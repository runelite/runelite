import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class214 {
   @ObfuscatedName("d")
   public static final short[] field2609;
   @ObfuscatedName("q")
   public static final short[][] field2610;
   @ObfuscatedName("x")
   public static final short[] field2611;
   @ObfuscatedName("y")
   public static final short[][] field2613;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field2615;

   static {
      field2609 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
      field2610 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127}};
      field2611 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
      field2613 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-48286894"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 4) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(249);
         Client.secretPacketBuffer1.putShortLE(class17.baseY + var1);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putLEInt(var0 + class33.baseX);
         Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
      }

      if(var2 == 31) {
         Client.secretPacketBuffer1.putOpcode(241);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.method3331(class35.selectedItemIndex);
         Client.secretPacketBuffer1.putLEShortA(var1);
         Client.secretPacketBuffer1.putInt(class44.field548);
         Client.secretPacketBuffer1.method3331(class34.field450);
         Client.secretPacketBuffer1.putShortLE(var0);
         Client.field994 = 0;
         class27.field374 = WallObject.method2901(var1);
         Client.field995 = var0;
      }

      NPC var8;
      if(var2 == 13) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(151);
            Client.secretPacketBuffer1.method3226(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var3);
         }
      }

      Player var16;
      if(var2 == 50) {
         var16 = Client.cachedPlayers[var3];
         if(var16 != null) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(142);
            Client.secretPacketBuffer1.method3331(var3);
            Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
         }
      }

      if(var2 == 30 && Client.field895 == null) {
         Client.secretPacketBuffer1.putOpcode(161);
         Client.secretPacketBuffer1.putLEInt(var0);
         Client.secretPacketBuffer1.putLEShortA(var1);
         Client.field895 = GZipDecompressor.method3133(var1, var0);
         class48.method732(Client.field895);
      }

      if(var2 == 18) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(0);
         Client.secretPacketBuffer1.putShort(class17.baseY + var1);
         Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var0 + class33.baseX);
         Client.secretPacketBuffer1.putShort(var3);
      }

      if(var2 == 23) {
         if(Client.isMenuOpen) {
            class51.region.method2794();
         } else {
            class51.region.method2723(class8.plane, var0, var1, true);
         }
      }

      if(var2 == 1004) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.secretPacketBuffer1.putOpcode(7);
         Client.secretPacketBuffer1.method3331(var3);
      }

      if(var2 == 1002) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.secretPacketBuffer1.putOpcode(89);
         Client.secretPacketBuffer1.method3331(var3 >> 14 & 32767);
      }

      if(var2 == 37) {
         Client.secretPacketBuffer1.putOpcode(212);
         Client.secretPacketBuffer1.putShort(var0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.putLEShortA(var1);
         Client.field994 = 0;
         class27.field374 = WallObject.method2901(var1);
         Client.field995 = var0;
      }

      if(var2 == 10) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(224);
            Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putLEInt(var3);
         }
      }

      if(var2 == 44) {
         var16 = Client.cachedPlayers[var3];
         if(var16 != null) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(222);
            Client.secretPacketBuffer1.method3226(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var3);
         }
      }

      if(var2 == 3) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(166);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShort(class17.baseY + var1);
         Client.secretPacketBuffer1.putByte(KeyFocusListener.field604[82]?1:0);
         Client.secretPacketBuffer1.putShort(var0 + class33.baseX);
      }

      if(var2 == 7) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(149);
            Client.secretPacketBuffer1.putInt(class44.field548);
            Client.secretPacketBuffer1.method3331(var3);
            Client.secretPacketBuffer1.putLEInt(class34.field450);
            Client.secretPacketBuffer1.method3331(class35.selectedItemIndex);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field604[82]?1:0);
         }
      }

      if(var2 == 14) {
         var16 = Client.cachedPlayers[var3];
         if(var16 != null) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(150);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.secretPacketBuffer1.putShort(class35.selectedItemIndex);
            Client.secretPacketBuffer1.putLEInt(class34.field450);
            Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putInt(class44.field548);
         }
      }

      if(var2 == 16) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(164);
         Client.secretPacketBuffer1.putLEInt(class17.baseY + var1);
         Client.secretPacketBuffer1.method3241(class44.field548);
         Client.secretPacketBuffer1.putLEInt(var3);
         Client.secretPacketBuffer1.putShort(var0 + class33.baseX);
         Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
         Client.secretPacketBuffer1.putLEInt(class35.selectedItemIndex);
         Client.secretPacketBuffer1.putShortLE(class34.field450);
      }

      if(var2 == 45) {
         var16 = Client.cachedPlayers[var3];
         if(var16 != null) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(185);
            Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var3);
         }
      }

      Widget var18;
      if(var2 == 1005) {
         var18 = WallObject.method2901(var1);
         if(var18 != null && var18.itemQuantities[var0] >= 100000) {
            class202.sendGameMessage(27, "", var18.itemQuantities[var0] + " x " + Friend.getItemDefinition(var3).name);
         } else {
            Client.secretPacketBuffer1.putOpcode(7);
            Client.secretPacketBuffer1.method3331(var3);
         }

         Client.field994 = 0;
         class27.field374 = WallObject.method2901(var1);
         Client.field995 = var0;
      }

      if(var2 == 19) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(81);
         Client.secretPacketBuffer1.putByte(KeyFocusListener.field604[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(class17.baseY + var1);
         Client.secretPacketBuffer1.putShortLE(var0 + class33.baseX);
         Client.secretPacketBuffer1.method3331(var3);
      }

      if(var2 == 41) {
         Client.secretPacketBuffer1.putOpcode(72);
         Client.secretPacketBuffer1.putShortLE(var3);
         Client.secretPacketBuffer1.putShortLE(var0);
         Client.secretPacketBuffer1.method3240(var1);
         Client.field994 = 0;
         class27.field374 = WallObject.method2901(var1);
         Client.field995 = var0;
      }

      if(var2 == 6) {
         Client.field1056 = var6;
         Client.field1084 = var7;
         Client.cursorState = 2;
         Client.field1134 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(253);
         Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
         Client.secretPacketBuffer1.putShort(class17.baseY + var1);
         Client.secretPacketBuffer1.method3331(var0 + class33.baseX);
         Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
      }

      int var9;
      if(var2 == 57 || var2 == 1007) {
         var18 = GZipDecompressor.method3133(var1, var0);
         if(var18 != null) {
            var9 = var18.itemId;
            Widget var10 = GZipDecompressor.method3133(var1, var0);
            if(var10 != null) {
               if(var10.field2729 != null) {
                  ScriptEvent var11 = new ScriptEvent();
                  var11.widget = var10;
                  var11.field822 = var3;
                  var11.field826 = var5;
                  var11.field818 = var10.field2729;
                  Ignore.method1126(var11);
               }

               boolean var13 = true;
               if(var10.contentType > 0) {
                  var13 = Player.method1156(var10);
               }

               if(var13 && class149.method2924(class169.getWidgetConfig(var10), var3 - 1)) {
                  if(var3 == 1) {
                     Client.secretPacketBuffer1.putOpcode(206);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 2) {
                     Client.secretPacketBuffer1.putOpcode(183);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 3) {
                     Client.secretPacketBuffer1.putOpcode(79);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 4) {
                     Client.secretPacketBuffer1.putOpcode(158);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 5) {
                     Client.secretPacketBuffer1.putOpcode(5);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 6) {
                     Client.secretPacketBuffer1.putOpcode(196);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 7) {
                     Client.secretPacketBuffer1.putOpcode(125);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 8) {
                     Client.secretPacketBuffer1.putOpcode(195);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 9) {
                     Client.secretPacketBuffer1.putOpcode(204);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 10) {
                     Client.secretPacketBuffer1.putOpcode(67);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }
               }
            }
         }
      }

      if(var2 == 38) {
         GZipDecompressor.method3131();
         var18 = WallObject.method2901(var1);
         Client.itemSelectionState = 1;
         class35.selectedItemIndex = var0;
         class44.field548 = var1;
         class34.field450 = var3;
         class48.method732(var18);
         Client.field1037 = CacheFile.getColTags(16748608) + Friend.getItemDefinition(var3).name + CacheFile.getColTags(16777215);
         if(Client.field1037 == null) {
            Client.field1037 = "null";
         }

      } else {
         if(var2 == 39) {
            Client.secretPacketBuffer1.putOpcode(180);
            Client.secretPacketBuffer1.putLEInt(var0);
            Client.secretPacketBuffer1.method3331(var3);
            Client.secretPacketBuffer1.method3241(var1);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 1001) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(30);
            Client.secretPacketBuffer1.putLEInt(class17.baseY + var1);
            Client.secretPacketBuffer1.method3331(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putLEInt(var0 + class33.baseX);
            Client.secretPacketBuffer1.method3226(KeyFocusListener.field604[82]?1:0);
         }

         if(var2 == 46) {
            var16 = Client.cachedPlayers[var3];
            if(var16 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(234);
               Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
               Client.secretPacketBuffer1.method3331(var3);
            }
         }

         if(var2 == 28) {
            Client.secretPacketBuffer1.putOpcode(250);
            Client.secretPacketBuffer1.putInt(var1);
            var18 = WallObject.method2901(var1);
            if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
               var9 = var18.dynamicValues[0][1];
               class211.widgetSettings[var9] = 1 - class211.widgetSettings[var9];
               WidgetNode.method1114(var9);
            }
         }

         if(var2 == 22) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(182);
            Client.secretPacketBuffer1.putLEInt(class17.baseY + var1);
            Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var0 + class33.baseX);
            Client.secretPacketBuffer1.method3331(var3);
         }

         if(var2 == 42) {
            Client.secretPacketBuffer1.putOpcode(100);
            Client.secretPacketBuffer1.method3331(var3);
            Client.secretPacketBuffer1.putShortLE(var0);
            Client.secretPacketBuffer1.method3240(var1);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 1) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(12);
            Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3331(var0 + class33.baseX);
            Client.secretPacketBuffer1.putShort(class35.selectedItemIndex);
            Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(class34.field450);
            Client.secretPacketBuffer1.putShortLE(class17.baseY + var1);
            Client.secretPacketBuffer1.method3240(class44.field548);
         }

         if(var2 == 35) {
            Client.secretPacketBuffer1.putOpcode(141);
            Client.secretPacketBuffer1.method3331(var0);
            Client.secretPacketBuffer1.putLEShortA(var1);
            Client.secretPacketBuffer1.method3331(var3);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 20) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(101);
            Client.secretPacketBuffer1.method3331(class17.baseY + var1);
            Client.secretPacketBuffer1.putShortLE(var0 + class33.baseX);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
         }

         if(var2 == 33) {
            Client.secretPacketBuffer1.putOpcode(128);
            Client.secretPacketBuffer1.putLEInt(var0);
            Client.secretPacketBuffer1.method3241(var1);
            Client.secretPacketBuffer1.method3331(var3);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
            class7.renderOverview.method5201(var2, var3, new Coordinates(var0), new Coordinates(var1));
         }

         if(var2 == 24) {
            var18 = WallObject.method2901(var1);
            boolean var17 = true;
            if(var18.contentType > 0) {
               var17 = Player.method1156(var18);
            }

            if(var17) {
               Client.secretPacketBuffer1.putOpcode(250);
               Client.secretPacketBuffer1.putInt(var1);
            }
         }

         if(var2 == 11) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(40);
               Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
               Client.secretPacketBuffer1.method3331(var3);
            }
         }

         if(var2 == 32) {
            Client.secretPacketBuffer1.putOpcode(37);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.method3241(var1);
            Client.secretPacketBuffer1.putShortLE(Client.field1039);
            Client.secretPacketBuffer1.method3240(class224.field2825);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 43) {
            Client.secretPacketBuffer1.putOpcode(228);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.method3240(var1);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 8) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(233);
               Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
               Client.secretPacketBuffer1.method3241(class224.field2825);
               Client.secretPacketBuffer1.putShortLE(Client.field1039);
               Client.secretPacketBuffer1.putShortLE(var3);
            }
         }

         if(var2 == 47) {
            var16 = Client.cachedPlayers[var3];
            if(var16 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(44);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
            }
         }

         if(var2 == 49) {
            var16 = Client.cachedPlayers[var3];
            if(var16 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(83);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3226(KeyFocusListener.field604[82]?1:0);
            }
         }

         if(var2 == 48) {
            var16 = Client.cachedPlayers[var3];
            if(var16 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(223);
               Client.secretPacketBuffer1.method3226(KeyFocusListener.field604[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
            }
         }

         if(var2 == 1003) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               NPCComposition var14 = var8.composition;
               if(var14.configs != null) {
                  var14 = var14.transform();
               }

               if(var14 != null) {
                  Client.secretPacketBuffer1.putOpcode(26);
                  Client.secretPacketBuffer1.method3331(var14.id);
               }
            }
         }

         if(var2 == 26) {
            class177.method3424();
         }

         if(var2 == 34) {
            Client.secretPacketBuffer1.putOpcode(179);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3331(var3);
            Client.secretPacketBuffer1.putLEInt(var0);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 15) {
            var16 = Client.cachedPlayers[var3];
            if(var16 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(93);
               Client.secretPacketBuffer1.putLEInt(var3);
               Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
               Client.secretPacketBuffer1.method3241(class224.field2825);
               Client.secretPacketBuffer1.putShortLE(Client.field1039);
            }
         }

         if(var2 == 21) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(201);
            Client.secretPacketBuffer1.putShortLE(class17.baseY + var1);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShort(var0 + class33.baseX);
         }

         if(var2 == 40) {
            Client.secretPacketBuffer1.putOpcode(32);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 9) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(114);
               Client.secretPacketBuffer1.method3331(var3);
               Client.secretPacketBuffer1.method3226(KeyFocusListener.field604[82]?1:0);
            }
         }

         if(var2 == 5) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(240);
            Client.secretPacketBuffer1.putShort(var0 + class33.baseX);
            Client.secretPacketBuffer1.method3331(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3331(class17.baseY + var1);
            Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
         }

         if(var2 == 2) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(138);
            Client.secretPacketBuffer1.putShortLE(Client.field1039);
            Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putInt(class224.field2825);
            Client.secretPacketBuffer1.putShortLE(class17.baseY + var1);
            Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.putShortLE(var0 + class33.baseX);
         }

         if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1056 = var6;
               Client.field1084 = var7;
               Client.cursorState = 2;
               Client.field1134 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(145);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
            }
         }

         if(var2 == 36) {
            Client.secretPacketBuffer1.putOpcode(252);
            Client.secretPacketBuffer1.method3331(var3);
            Client.secretPacketBuffer1.method3331(var0);
            Client.secretPacketBuffer1.putInt(var1);
            Client.field994 = 0;
            class27.field374 = WallObject.method2901(var1);
            Client.field995 = var0;
         }

         if(var2 == 17) {
            Client.field1056 = var6;
            Client.field1084 = var7;
            Client.cursorState = 2;
            Client.field1134 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(255);
            Client.secretPacketBuffer1.method3227(KeyFocusListener.field604[82]?1:0);
            Client.secretPacketBuffer1.method3331(Client.field1039);
            Client.secretPacketBuffer1.putShort(var0 + class33.baseX);
            Client.secretPacketBuffer1.putLEShortA(class224.field2825);
            Client.secretPacketBuffer1.putShortLE(var3);
            Client.secretPacketBuffer1.putLEInt(class17.baseY + var1);
         }

         if(var2 == 58) {
            var18 = GZipDecompressor.method3133(var1, var0);
            if(var18 != null) {
               Client.secretPacketBuffer1.putOpcode(116);
               Client.secretPacketBuffer1.putShortLE(var18.itemId);
               Client.secretPacketBuffer1.putShort(Client.field1039);
               Client.secretPacketBuffer1.putShortLE(Client.field1040);
               Client.secretPacketBuffer1.putInt(class224.field2825);
               Client.secretPacketBuffer1.putInt(var1);
               Client.secretPacketBuffer1.method3331(var0);
            }
         }

         if(var2 == 25) {
            var18 = GZipDecompressor.method3133(var1, var0);
            if(var18 != null) {
               GZipDecompressor.method3131();
               var9 = MilliTimer.method2938(class169.getWidgetConfig(var18));
               int var15 = var18.itemId;
               Widget var19 = GZipDecompressor.method3133(var1, var0);
               if(var19 != null && var19.field2720 != null) {
                  ScriptEvent var12 = new ScriptEvent();
                  var12.widget = var19;
                  var12.field818 = var19.field2720;
                  Ignore.method1126(var12);
               }

               Client.field1040 = var15;
               Client.spellSelected = true;
               class224.field2825 = var1;
               Client.field1039 = var0;
               class96.field1481 = var9;
               class48.method732(var19);
               Client.itemSelectionState = 0;
               Client.field972 = KeyFocusListener.method760(var18);
               if(Client.field972 == null) {
                  Client.field972 = "Null";
               }

               if(var18.hasScript) {
                  Client.field1042 = var18.name + CacheFile.getColTags(16777215);
               } else {
                  Client.field1042 = CacheFile.getColTags('\uff00') + var18.field2621 + CacheFile.getColTags(16777215);
               }
            }

         } else {
            if(var2 == 29) {
               Client.secretPacketBuffer1.putOpcode(250);
               Client.secretPacketBuffer1.putInt(var1);
               var18 = WallObject.method2901(var1);
               if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                  var9 = var18.dynamicValues[0][1];
                  if(class211.widgetSettings[var9] != var18.field2743[0]) {
                     class211.widgetSettings[var9] = var18.field2743[0];
                     WidgetNode.method1114(var9);
                  }
               }
            }

            if(var2 == 51) {
               var16 = Client.cachedPlayers[var3];
               if(var16 != null) {
                  Client.field1056 = var6;
                  Client.field1084 = var7;
                  Client.cursorState = 2;
                  Client.field1134 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(192);
                  Client.secretPacketBuffer1.method3225(KeyFocusListener.field604[82]?1:0);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            }

            if(Client.itemSelectionState != 0) {
               Client.itemSelectionState = 0;
               class48.method732(WallObject.method2901(class44.field548));
            }

            if(Client.spellSelected) {
               GZipDecompressor.method3131();
            }

            if(class27.field374 != null && Client.field994 == 0) {
               class48.method732(class27.field374);
            }

         }
      }
   }
}
