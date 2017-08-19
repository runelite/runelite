import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class262 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   public static final class262 field3611;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   public static final class262 field3612;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   public static final class262 field3614;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   public static final class262 field3613;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   public static final class262 field3609;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   public static final class262 field3610;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexData field3617;
   @ObfuscatedName("c")
   final String field3620;
   @ObfuscatedName("l")
   String field3608;

   static {
      field3612 = new class262("PLAIN11", "p11_full");
      field3609 = new class262("PLAIN12", "p12_full");
      field3610 = new class262("BOLD12", "b12_full");
      field3611 = new class262("VERDANA11", "verdana_11pt_regular");
      field3614 = new class262("VERDANA13", "verdana_13pt_regular");
      field3613 = new class262("VERDANA15", "verdana_15pt_regular");
   }

   class262(String var1, String var2) {
      this.field3620 = var1;
      this.field3608 = var2;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lhi;I)I",
      garbageValue = "140663505"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.config;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ldl;B)V",
      garbageValue = "6"
   )
   public static final void method4758(class104 var0) {
      class294.field3887 = var0;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "74"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 1) {
         Client.field1141 = var6;
         Client.field1033 = var7;
         Client.cursorState = 2;
         Client.field940 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(107);
         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
         Client.secretPacketBuffer1.putShort(class44.baseY + var1);
         Client.secretPacketBuffer1.method3215(class34.field499);
         Client.secretPacketBuffer1.method3312(MessageNode.selectedItemIndex);
         Client.secretPacketBuffer1.method3208(var0 + class47.baseX);
         Client.secretPacketBuffer1.method3312(PlayerComposition.field2626);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
      } else if(var2 == 2) {
         Client.field1141 = var6;
         Client.field1033 = var7;
         Client.cursorState = 2;
         Client.field940 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(126);
         Client.secretPacketBuffer1.putShort(var0 + class47.baseX);
         Client.secretPacketBuffer1.method3208(Client.field1082);
         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
         Client.secretPacketBuffer1.method3312(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShortLE(class44.baseY + var1);
         Client.secretPacketBuffer1.putInt(class29.field434);
      } else if(var2 == 3) {
         Client.field1141 = var6;
         Client.field1033 = var7;
         Client.cursorState = 2;
         Client.field940 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(45);
         Client.secretPacketBuffer1.putShortLE(class44.baseY + var1);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var0 + class47.baseX);
      } else if(var2 == 4) {
         Client.field1141 = var6;
         Client.field1033 = var7;
         Client.cursorState = 2;
         Client.field940 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(244);
         Client.secretPacketBuffer1.method3312(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
         Client.secretPacketBuffer1.putShort(var0 + class47.baseX);
         Client.secretPacketBuffer1.putShort(class44.baseY + var1);
      } else if(var2 == 5) {
         Client.field1141 = var6;
         Client.field1033 = var7;
         Client.cursorState = 2;
         Client.field940 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(144);
         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
         Client.secretPacketBuffer1.method3208(class44.baseY + var1);
         Client.secretPacketBuffer1.putShort(var0 + class47.baseX);
         Client.secretPacketBuffer1.method3208(var3 >> 14 & 32767);
      } else if(var2 == 6) {
         Client.field1141 = var6;
         Client.field1033 = var7;
         Client.cursorState = 2;
         Client.field940 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(124);
         Client.secretPacketBuffer1.method3262(KeyFocusListener.field642[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShort(class44.baseY + var1);
         Client.secretPacketBuffer1.method3312(var0 + class47.baseX);
      } else {
         NPC var8;
         if(var2 == 7) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(219);
               Client.secretPacketBuffer1.method3200(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.method3208(PlayerComposition.field2626);
               Client.secretPacketBuffer1.putInt(class34.field499);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3208(MessageNode.selectedItemIndex);
            }
         } else if(var2 == 8) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(208);
               Client.secretPacketBuffer1.method3200(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.putLEShortA(class29.field434);
               Client.secretPacketBuffer1.putShort(Client.field1082);
               Client.secretPacketBuffer1.method3208(var3);
            }
         } else if(var2 == 9) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(42);
               Client.secretPacketBuffer1.method3200(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
            }
         } else if(var2 == 10) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(220);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.method3312(var3);
            }
         } else if(var2 == 11) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(34);
               Client.secretPacketBuffer1.method3262(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.method3208(var3);
            }
         } else if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(22);
               Client.secretPacketBuffer1.method3200(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.method3312(var3);
            }
         } else if(var2 == 13) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(112);
               Client.secretPacketBuffer1.method3208(var3);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
            }
         } else {
            Player var19;
            if(var2 == 14) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field1141 = var6;
                  Client.field1033 = var7;
                  Client.cursorState = 2;
                  Client.field940 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(36);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.method3312(MessageNode.selectedItemIndex);
                  Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
                  Client.secretPacketBuffer1.method3173(class34.field499);
                  Client.secretPacketBuffer1.putShort(PlayerComposition.field2626);
               }
            } else if(var2 == 15) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field1141 = var6;
                  Client.field1033 = var7;
                  Client.cursorState = 2;
                  Client.field940 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(162);
                  Client.secretPacketBuffer1.putShortLE(var3);
                  Client.secretPacketBuffer1.putShort(Client.field1082);
                  Client.secretPacketBuffer1.method3215(class29.field434);
                  Client.secretPacketBuffer1.method3262(KeyFocusListener.field642[82]?1:0);
               }
            } else if(var2 == 16) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(43);
               Client.secretPacketBuffer1.putShortLE(MessageNode.selectedItemIndex);
               Client.secretPacketBuffer1.method3208(var0 + class47.baseX);
               Client.secretPacketBuffer1.method3262(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.method3208(var3);
               Client.secretPacketBuffer1.putShortLE(PlayerComposition.field2626);
               Client.secretPacketBuffer1.putShort(class44.baseY + var1);
               Client.secretPacketBuffer1.putInt(class34.field499);
            } else if(var2 == 17) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(201);
               Client.secretPacketBuffer1.method3312(class44.baseY + var1);
               Client.secretPacketBuffer1.putShort(Client.field1082);
               Client.secretPacketBuffer1.method3208(var0 + class47.baseX);
               Client.secretPacketBuffer1.method3312(var3);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.method3173(class29.field434);
            } else if(var2 == 18) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(60);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3312(class44.baseY + var1);
               Client.secretPacketBuffer1.putShort(var0 + class47.baseX);
            } else if(var2 == 19) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(52);
               Client.secretPacketBuffer1.method3312(class44.baseY + var1);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putShort(var0 + class47.baseX);
            } else if(var2 == 20) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(105);
               Client.secretPacketBuffer1.method3312(var0 + class47.baseX);
               Client.secretPacketBuffer1.method3208(var3);
               Client.secretPacketBuffer1.method3262(KeyFocusListener.field642[82]?1:0);
               Client.secretPacketBuffer1.putShort(class44.baseY + var1);
            } else if(var2 == 21) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(133);
               Client.secretPacketBuffer1.putShort(class44.baseY + var1);
               Client.secretPacketBuffer1.method3208(var0 + class47.baseX);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3262(KeyFocusListener.field642[82]?1:0);
            } else if(var2 == 22) {
               Client.field1141 = var6;
               Client.field1033 = var7;
               Client.cursorState = 2;
               Client.field940 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(55);
               Client.secretPacketBuffer1.method3208(var0 + class47.baseX);
               Client.secretPacketBuffer1.putShortLE(class44.baseY + var1);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field642[82]?1:0);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class36.region.method2740();
               } else {
                  class36.region.method2739(class35.plane, var0, var1, true);
               }
            } else {
               Widget var20;
               if(var2 == 24) {
                  var20 = class84.method1670(var1);
                  boolean var9 = true;
                  if(var20.contentType > 0) {
                     var9 = class39.method565(var20);
                  }

                  if(var9) {
                     Client.secretPacketBuffer1.putOpcode(98);
                     Client.secretPacketBuffer1.putInt(var1);
                  }
               } else {
                  if(var2 == 25) {
                     var20 = class205.method3812(var1, var0);
                     if(var20 != null) {
                        GrandExchangeOffer.method116();
                        int var22 = getWidgetConfig(var20);
                        int var21 = var22 >> 11 & 63;
                        class22.method180(var1, var0, var21, var20.itemId);
                        Client.itemSelectionState = 0;
                        Client.field993 = Renderable.method2895(var20);
                        if(Client.field993 == null) {
                           Client.field993 = "Null";
                        }

                        if(var20.hasScript) {
                           Client.field1085 = var20.name + Tile.getColTags(16777215);
                        } else {
                           Client.field1085 = Tile.getColTags('\uff00') + var20.field2765 + Tile.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     Actor.method1543();
                  } else {
                     int var18;
                     if(var2 == 28) {
                        Client.secretPacketBuffer1.putOpcode(98);
                        Client.secretPacketBuffer1.putInt(var1);
                        var20 = class84.method1670(var1);
                        if(var20.dynamicValues != null && var20.dynamicValues[0][0] == 5) {
                           var18 = var20.dynamicValues[0][1];
                           class212.widgetSettings[var18] = 1 - class212.widgetSettings[var18];
                           class12.method60(var18);
                        }
                     } else if(var2 == 29) {
                        Client.secretPacketBuffer1.putOpcode(98);
                        Client.secretPacketBuffer1.putInt(var1);
                        var20 = class84.method1670(var1);
                        if(var20.dynamicValues != null && var20.dynamicValues[0][0] == 5) {
                           var18 = var20.dynamicValues[0][1];
                           if(class212.widgetSettings[var18] != var20.field2763[0]) {
                              class212.widgetSettings[var18] = var20.field2763[0];
                              class12.method60(var18);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1090 == null) {
                           ScriptState.method1119(var1, var0);
                           Client.field1090 = class205.method3812(var1, var0);
                           class90.method1723(Client.field1090);
                        }
                     } else if(var2 == 31) {
                        Client.secretPacketBuffer1.putOpcode(227);
                        Client.secretPacketBuffer1.method3312(var0);
                        Client.secretPacketBuffer1.putShortLE(var3);
                        Client.secretPacketBuffer1.putShortLE(PlayerComposition.field2626);
                        Client.secretPacketBuffer1.putLEShortA(class34.field499);
                        Client.secretPacketBuffer1.method3173(var1);
                        Client.secretPacketBuffer1.method3312(MessageNode.selectedItemIndex);
                        Client.field1036 = 0;
                        class72.field879 = class84.method1670(var1);
                        Client.field1037 = var0;
                     } else if(var2 == 32) {
                        Client.secretPacketBuffer1.putOpcode(19);
                        Client.secretPacketBuffer1.method3312(Client.field1082);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.method3173(class29.field434);
                        Client.secretPacketBuffer1.method3173(var1);
                        Client.secretPacketBuffer1.method3208(var3);
                        Client.field1036 = 0;
                        class72.field879 = class84.method1670(var1);
                        Client.field1037 = var0;
                     } else if(var2 == 33) {
                        Client.secretPacketBuffer1.putOpcode(171);
                        Client.secretPacketBuffer1.method3215(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShortLE(var3);
                        Client.field1036 = 0;
                        class72.field879 = class84.method1670(var1);
                        Client.field1037 = var0;
                     } else if(var2 == 34) {
                        Client.secretPacketBuffer1.putOpcode(41);
                        Client.secretPacketBuffer1.method3208(var0);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.method3312(var3);
                        Client.field1036 = 0;
                        class72.field879 = class84.method1670(var1);
                        Client.field1037 = var0;
                     } else if(var2 == 35) {
                        Client.secretPacketBuffer1.putOpcode(134);
                        Client.secretPacketBuffer1.method3208(var3);
                        Client.secretPacketBuffer1.method3215(var1);
                        Client.secretPacketBuffer1.method3312(var0);
                        Client.field1036 = 0;
                        class72.field879 = class84.method1670(var1);
                        Client.field1037 = var0;
                     } else if(var2 == 36) {
                        Client.secretPacketBuffer1.putOpcode(29);
                        Client.secretPacketBuffer1.putShortLE(var3);
                        Client.secretPacketBuffer1.method3312(var0);
                        Client.secretPacketBuffer1.method3215(var1);
                        Client.field1036 = 0;
                        class72.field879 = class84.method1670(var1);
                        Client.field1037 = var0;
                     } else if(var2 == 37) {
                        Client.secretPacketBuffer1.putOpcode(202);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var3);
                        Client.secretPacketBuffer1.putShortLE(var0);
                        Client.field1036 = 0;
                        class72.field879 = class84.method1670(var1);
                        Client.field1037 = var0;
                     } else {
                        if(var2 == 38) {
                           GrandExchangeOffer.method116();
                           var20 = class84.method1670(var1);
                           Client.itemSelectionState = 1;
                           MessageNode.selectedItemIndex = var0;
                           class34.field499 = var1;
                           PlayerComposition.field2626 = var3;
                           class90.method1723(var20);
                           Client.field1084 = Tile.getColTags(16748608) + SoundTask.getItemDefinition(var3).name + Tile.getColTags(16777215);
                           if(Client.field1084 == null) {
                              Client.field1084 = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           Client.secretPacketBuffer1.putOpcode(87);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.method3173(var1);
                           Client.secretPacketBuffer1.method3208(var3);
                           Client.field1036 = 0;
                           class72.field879 = class84.method1670(var1);
                           Client.field1037 = var0;
                        } else if(var2 == 40) {
                           Client.secretPacketBuffer1.putOpcode(106);
                           Client.secretPacketBuffer1.method3208(var3);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.field1036 = 0;
                           class72.field879 = class84.method1670(var1);
                           Client.field1037 = var0;
                        } else if(var2 == 41) {
                           Client.secretPacketBuffer1.putOpcode(82);
                           Client.secretPacketBuffer1.putLEShortA(var1);
                           Client.secretPacketBuffer1.method3312(var3);
                           Client.secretPacketBuffer1.method3312(var0);
                           Client.field1036 = 0;
                           class72.field879 = class84.method1670(var1);
                           Client.field1037 = var0;
                        } else if(var2 == 42) {
                           Client.secretPacketBuffer1.putOpcode(198);
                           Client.secretPacketBuffer1.method3208(var0);
                           Client.secretPacketBuffer1.putInt(var1);
                           Client.secretPacketBuffer1.putShortLE(var3);
                           Client.field1036 = 0;
                           class72.field879 = class84.method1670(var1);
                           Client.field1037 = var0;
                        } else if(var2 == 43) {
                           Client.secretPacketBuffer1.putOpcode(66);
                           Client.secretPacketBuffer1.putShortLE(var3);
                           Client.secretPacketBuffer1.putLEShortA(var1);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.field1036 = 0;
                           class72.field879 = class84.method1670(var1);
                           Client.field1037 = var0;
                        } else if(var2 == 44) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(190);
                              Client.secretPacketBuffer1.method3208(var3);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
                           }
                        } else if(var2 == 45) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(120);
                              Client.secretPacketBuffer1.method3208(var3);
                              Client.secretPacketBuffer1.method3200(KeyFocusListener.field642[82]?1:0);
                           }
                        } else if(var2 == 46) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(176);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
                              Client.secretPacketBuffer1.putShortLE(var3);
                           }
                        } else if(var2 == 47) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(154);
                              Client.secretPacketBuffer1.method3312(var3);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
                           }
                        } else if(var2 == 48) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(223);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
                              Client.secretPacketBuffer1.putShort(var3);
                           }
                        } else if(var2 == 49) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(114);
                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?1:0);
                              Client.secretPacketBuffer1.putShortLE(var3);
                           }
                        } else if(var2 == 50) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(26);
                              Client.secretPacketBuffer1.method3262(KeyFocusListener.field642[82]?1:0);
                              Client.secretPacketBuffer1.method3208(var3);
                           }
                        } else if(var2 == 51) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.field1141 = var6;
                              Client.field1033 = var7;
                              Client.cursorState = 2;
                              Client.field940 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(185);
                              Client.secretPacketBuffer1.method3312(var3);
                              Client.secretPacketBuffer1.method3200(KeyFocusListener.field642[82]?1:0);
                           }
                        } else {
                           label797: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var20 = class205.method3812(var1, var0);
                                    if(var20 != null) {
                                       Client.secretPacketBuffer1.putOpcode(57);
                                       Client.secretPacketBuffer1.putShort(Client.field1083);
                                       Client.secretPacketBuffer1.putShort(Client.field1082);
                                       Client.secretPacketBuffer1.putInt(var1);
                                       Client.secretPacketBuffer1.method3312(var0);
                                       Client.secretPacketBuffer1.putInt(class29.field434);
                                       Client.secretPacketBuffer1.method3208(var20.itemId);
                                    }
                                    break label797;
                                 }

                                 if(var2 == 1001) {
                                    Client.field1141 = var6;
                                    Client.field1033 = var7;
                                    Client.cursorState = 2;
                                    Client.field940 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    Client.secretPacketBuffer1.putOpcode(4);
                                    Client.secretPacketBuffer1.method3312(var0 + class47.baseX);
                                    Client.secretPacketBuffer1.putByte(KeyFocusListener.field642[82]?1:0);
                                    Client.secretPacketBuffer1.putShortLE(class44.baseY + var1);
                                    Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
                                    break label797;
                                 }

                                 if(var2 == 1002) {
                                    Client.field1141 = var6;
                                    Client.field1033 = var7;
                                    Client.cursorState = 2;
                                    Client.field940 = 0;
                                    Client.secretPacketBuffer1.putOpcode(115);
                                    Client.secretPacketBuffer1.method3208(var3 >> 14 & 32767);
                                    break label797;
                                 }

                                 if(var2 == 1003) {
                                    Client.field1141 = var6;
                                    Client.field1033 = var7;
                                    Client.cursorState = 2;
                                    Client.field940 = 0;
                                    var8 = Client.cachedNPCs[var3];
                                    if(var8 != null) {
                                       NPCComposition var16 = var8.composition;
                                       if(var16.configs != null) {
                                          var16 = var16.transform();
                                       }

                                       if(var16 != null) {
                                          Client.secretPacketBuffer1.putOpcode(167);
                                          Client.secretPacketBuffer1.method3312(var16.id);
                                       }
                                    }
                                    break label797;
                                 }

                                 if(var2 == 1004) {
                                    Client.field1141 = var6;
                                    Client.field1033 = var7;
                                    Client.cursorState = 2;
                                    Client.field940 = 0;
                                    Client.secretPacketBuffer1.putOpcode(119);
                                    Client.secretPacketBuffer1.putShort(var3);
                                    break label797;
                                 }

                                 if(var2 == 1005) {
                                    var20 = class84.method1670(var1);
                                    if(var20 != null && var20.itemQuantities[var0] >= 100000) {
                                       NPC.sendGameMessage(27, "", var20.itemQuantities[var0] + " x " + SoundTask.getItemDefinition(var3).name);
                                    } else {
                                       Client.secretPacketBuffer1.putOpcode(119);
                                       Client.secretPacketBuffer1.putShort(var3);
                                    }

                                    Client.field1036 = 0;
                                    class72.field879 = class84.method1670(var1);
                                    Client.field1037 = var0;
                                    break label797;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1010 || var2 == 1009 || var2 == 1011 || var2 == 1008 || var2 == 1012) {
                                       class46.renderOverview.method5277(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label797;
                                 }
                              }

                              var20 = class205.method3812(var1, var0);
                              if(var20 != null) {
                                 var18 = var20.itemId;
                                 Widget var15 = class205.method3812(var1, var0);
                                 if(var15 != null) {
                                    if(var15.field2749 != null) {
                                       ScriptEvent var17 = new ScriptEvent();
                                       var17.widget = var15;
                                       var17.field859 = var3;
                                       var17.field854 = var5;
                                       var17.field856 = var15.field2749;
                                       Coordinates.method3942(var17);
                                    }

                                    boolean var11 = true;
                                    if(var15.contentType > 0) {
                                       var11 = class39.method565(var15);
                                    }

                                    if(var11) {
                                       int var13 = getWidgetConfig(var15);
                                       int var14 = var3 - 1;
                                       boolean var12 = (var13 >> var14 + 1 & 1) != 0;
                                       if(var12) {
                                          if(var3 == 1) {
                                             Client.secretPacketBuffer1.putOpcode(145);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 2) {
                                             Client.secretPacketBuffer1.putOpcode(242);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 3) {
                                             Client.secretPacketBuffer1.putOpcode(37);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 4) {
                                             Client.secretPacketBuffer1.putOpcode(197);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 5) {
                                             Client.secretPacketBuffer1.putOpcode(1);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 6) {
                                             Client.secretPacketBuffer1.putOpcode(62);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 7) {
                                             Client.secretPacketBuffer1.putOpcode(178);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 8) {
                                             Client.secretPacketBuffer1.putOpcode(166);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 9) {
                                             Client.secretPacketBuffer1.putOpcode(234);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
                                          }

                                          if(var3 == 10) {
                                             Client.secretPacketBuffer1.putOpcode(56);
                                             Client.secretPacketBuffer1.putInt(var1);
                                             Client.secretPacketBuffer1.putShort(var0);
                                             Client.secretPacketBuffer1.putShort(var18);
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
      }

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         class90.method1723(class84.method1670(class34.field499));
      }

      if(Client.spellSelected) {
         GrandExchangeOffer.method116();
      }

      if(class72.field879 != null && Client.field1036 == 0) {
         class90.method1723(class72.field879);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfo;II)V",
      garbageValue = "713013866"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class97.field1518[++class97.field1506 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field903 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class97.field1505[var1] = (var4.field918 << 28) + (class47.baseX + var4.pathX[0] >> 13 << 14) + (class44.baseY + var4.pathY[0] >> 13);
            if(var4.field1246 != -1) {
               class97.field1515[var1] = var4.field1246;
            } else {
               class97.field1515[var1] = var4.orientation;
            }

            class97.field1516[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               WorldMapType2.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field903 = true;
                  var4.field921 = var6;
                  var4.field922 = var7;
               } else {
                  var4.field903 = false;
                  var4.method1189(var6, var7, class97.field1508[var1]);
               }
            } else {
               var4.method1190(var6, var7);
               var4.field903 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1190(var6, var7);
               var4.field903 = false;
            } else if(var2) {
               var4.field903 = true;
               var4.field921 = var6;
               var4.field922 = var7;
            } else {
               var4.field903 = false;
               var4.method1189(var6, var7, class97.field1508[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field903 = true;
                     var4.field921 = var10;
                     var4.field922 = var11;
                  } else {
                     var4.field903 = false;
                     var4.method1189(var10, var11, class97.field1508[var1]);
                  }
               } else {
                  var4.method1190(var10, var11);
                  var4.field903 = false;
               }

               var4.field918 = (byte)(var7 + var4.field918 & 3);
               if(Client.localInteractingIndex == var1) {
                  class35.plane = var4.field918;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class47.baseX + var4.pathX[0] & 16383) - class47.baseX;
               var11 = (var9 + class44.baseY + var4.pathY[0] & 16383) - class44.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field903 = true;
                     var4.field921 = var10;
                     var4.field922 = var11;
                  } else {
                     var4.field903 = false;
                     var4.method1189(var10, var11, class97.field1508[var1]);
                  }
               } else {
                  var4.method1190(var10, var11);
                  var4.field903 = false;
               }

               var4.field918 = (byte)(var7 + var4.field918 & 3);
               if(Client.localInteractingIndex == var1) {
                  class35.plane = var4.field918;
               }

            }
         }
      }
   }
}
