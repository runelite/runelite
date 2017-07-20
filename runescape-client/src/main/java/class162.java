import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class162 {
   @ObfuscatedName("i")
   public static int[][] field2262;
   @ObfuscatedName("u")
   public static int[][] field2265;
   @ObfuscatedName("x")
   public static int[] field2268;
   @ObfuscatedName("p")
   public static int[] field2269;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1680697415
   )
   public static int field2266;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -700219207
   )
   public static int field2267;

   static {
      field2262 = new int[128][128];
      field2265 = new int[128][128];
      field2268 = new int[4096];
      field2269 = new int[4096];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "2100997167"
   )
   @Export("parseInt")
   static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "861151126"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Widget var8;
      int var9;
      if(var2 == 57 || var2 == 1007) {
         var8 = CollisionData.method2946(var1, var0);
         if(var8 != null) {
            var9 = var8.itemId;
            Widget var10 = CollisionData.method2946(var1, var0);
            if(var10 != null) {
               if(var10.field2717 != null) {
                  ScriptEvent var11 = new ScriptEvent();
                  var11.widget = var10;
                  var11.field837 = var3;
                  var11.field838 = var5;
                  var11.field831 = var10.field2717;
                  Ignore.method1054(var11);
               }

               boolean var16 = true;
               if(var10.contentType > 0) {
                  var16 = class228.method3987(var10);
               }

               if(var16 && class98.method1779(class60.getWidgetConfig(var10), var3 - 1)) {
                  if(var3 == 1) {
                     Client.secretPacketBuffer1.putOpcode(166);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 2) {
                     Client.secretPacketBuffer1.putOpcode(47);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 3) {
                     Client.secretPacketBuffer1.putOpcode(74);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 4) {
                     Client.secretPacketBuffer1.putOpcode(187);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 5) {
                     Client.secretPacketBuffer1.putOpcode(169);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 6) {
                     Client.secretPacketBuffer1.putOpcode(188);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 7) {
                     Client.secretPacketBuffer1.putOpcode(164);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 8) {
                     Client.secretPacketBuffer1.putOpcode(103);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 9) {
                     Client.secretPacketBuffer1.putOpcode(79);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }

                  if(var3 == 10) {
                     Client.secretPacketBuffer1.putOpcode(27);
                     Client.secretPacketBuffer1.putInt(var1);
                     Client.secretPacketBuffer1.putShort(var0);
                     Client.secretPacketBuffer1.putShort(var9);
                  }
               }
            }
         }
      }

      if(var2 == 36) {
         Client.secretPacketBuffer1.putOpcode(120);
         Client.secretPacketBuffer1.method3167(var1);
         Client.secretPacketBuffer1.method3129(var0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.field1075 = 0;
         class12.field262 = class239.method4167(var1);
         Client.field1182 = var0;
      }

      Player var19;
      if(var2 == 51) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(56);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field636[82]?1:0);
         }
      }

      NPC var20;
      if(var2 == 9) {
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(75);
            Client.secretPacketBuffer1.putShortOb2(var3);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
         }
      }

      if(var2 == 32) {
         Client.secretPacketBuffer1.putOpcode(204);
         Client.secretPacketBuffer1.putLEInt(Client.field1055);
         Client.secretPacketBuffer1.method3167(class60.field747);
         Client.secretPacketBuffer1.putShortOb2(var0);
         Client.secretPacketBuffer1.method3129(var3);
         Client.secretPacketBuffer1.method3139(var1);
         Client.field1075 = 0;
         class12.field262 = class239.method4167(var1);
         Client.field1182 = var0;
      }

      if(var2 == 31) {
         Client.secretPacketBuffer1.putOpcode(198);
         Client.secretPacketBuffer1.method3139(var1);
         Client.secretPacketBuffer1.putShortOb2(var0);
         Client.secretPacketBuffer1.putLEInt(var3);
         Client.secretPacketBuffer1.method3167(class8.field232);
         Client.secretPacketBuffer1.putShort(class46.field595);
         Client.secretPacketBuffer1.putShortOb2(class25.selectedItemIndex);
         Client.field1075 = 0;
         class12.field262 = class239.method4167(var1);
         Client.field1182 = var0;
      }

      if(var2 == 1003) {
         Client.field1011 = var6;
         Client.field1012 = var7;
         Client.cursorState = 2;
         Client.field1013 = 0;
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            NPCComposition var17 = var20.composition;
            if(var17.configs != null) {
               var17 = var17.transform();
            }

            if(var17 != null) {
               Client.secretPacketBuffer1.putOpcode(205);
               Client.secretPacketBuffer1.method3129(var17.id);
            }
         }
      }

      if(var2 == 29) {
         Client.secretPacketBuffer1.putOpcode(186);
         Client.secretPacketBuffer1.putInt(var1);
         var8 = class239.method4167(var1);
         if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
            var9 = var8.dynamicValues[0][1];
            if(class211.widgetSettings[var9] != var8.field2641[0]) {
               class211.widgetSettings[var9] = var8.field2641[0];
               class164.method3010(var9);
            }
         }
      }

      if(var2 == 21) {
         Client.field1011 = var6;
         Client.field1012 = var7;
         Client.cursorState = 2;
         Client.field1013 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(110);
         Client.secretPacketBuffer1.putLEInt(var0 + class21.baseX);
         Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.putLEInt(class164.baseY + var1);
      }

      if(var2 == 20) {
         Client.field1011 = var6;
         Client.field1012 = var7;
         Client.cursorState = 2;
         Client.field1013 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(231);
         Client.secretPacketBuffer1.method3129(class164.baseY + var1);
         Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field636[82]?1:0);
         Client.secretPacketBuffer1.putShortOb2(var0 + class21.baseX);
         Client.secretPacketBuffer1.putShortOb2(var3);
      }

      if(var2 == 40) {
         Client.secretPacketBuffer1.putOpcode(152);
         Client.secretPacketBuffer1.putShortOb2(var3);
         Client.secretPacketBuffer1.putShortOb2(var0);
         Client.secretPacketBuffer1.method3139(var1);
         Client.field1075 = 0;
         class12.field262 = class239.method4167(var1);
         Client.field1182 = var0;
      }

      if(var2 == 42) {
         Client.secretPacketBuffer1.putOpcode(182);
         Client.secretPacketBuffer1.putLEInt(var0);
         Client.secretPacketBuffer1.putInt(var1);
         Client.secretPacketBuffer1.putLEInt(var3);
         Client.field1075 = 0;
         class12.field262 = class239.method4167(var1);
         Client.field1182 = var0;
      }

      if(var2 == 49) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(73);
            Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.method3129(var3);
         }
      }

      if(var2 == 1005) {
         var8 = class239.method4167(var1);
         if(var8 != null && var8.itemQuantities[var0] >= 100000) {
            Item.sendGameMessage(27, "", var8.itemQuantities[var0] + " x " + class10.getItemDefinition(var3).name);
         } else {
            Client.secretPacketBuffer1.putOpcode(238);
            Client.secretPacketBuffer1.putShortOb2(var3);
         }

         Client.field1075 = 0;
         class12.field262 = class239.method4167(var1);
         Client.field1182 = var0;
      }

      if(var2 == 24) {
         var8 = class239.method4167(var1);
         boolean var21 = true;
         if(var8.contentType > 0) {
            var21 = class228.method3987(var8);
         }

         if(var21) {
            Client.secretPacketBuffer1.putOpcode(186);
            Client.secretPacketBuffer1.putInt(var1);
         }
      }

      if(var2 == 48) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(55);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
         }
      }

      if(var2 == 11) {
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(137);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
         }
      }

      if(var2 == 39) {
         Client.secretPacketBuffer1.putOpcode(31);
         Client.secretPacketBuffer1.putLEShortA(var1);
         Client.secretPacketBuffer1.putShortOb2(var0);
         Client.secretPacketBuffer1.putShort(var3);
         Client.field1075 = 0;
         class12.field262 = class239.method4167(var1);
         Client.field1182 = var0;
      }

      if(var2 == 8) {
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(64);
            Client.secretPacketBuffer1.method3129(Client.field1055);
            Client.secretPacketBuffer1.method3139(class60.field747);
            Client.secretPacketBuffer1.method3120(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.putShortOb2(var3);
         }
      }

      if(var2 == 16) {
         Client.field1011 = var6;
         Client.field1012 = var7;
         Client.cursorState = 2;
         Client.field1013 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(141);
         Client.secretPacketBuffer1.method3129(class164.baseY + var1);
         Client.secretPacketBuffer1.method3129(var0 + class21.baseX);
         Client.secretPacketBuffer1.putLEInt(var3);
         Client.secretPacketBuffer1.putInt(class8.field232);
         Client.secretPacketBuffer1.putShortOb2(class25.selectedItemIndex);
         Client.secretPacketBuffer1.putShort(class46.field595);
         Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
      }

      if(var2 == 26) {
         class229.method3988();
      }

      if(var2 == 25) {
         var8 = CollisionData.method2946(var1, var0);
         if(var8 != null) {
            class2.method6();
            int var12 = class60.getWidgetConfig(var8);
            int var22 = var12 >> 11 & 63;
            Renderable.method2794(var1, var0, var22, var8.itemId);
            Client.itemSelectionState = 0;
            int var15 = class60.getWidgetConfig(var8);
            int var14 = var15 >> 11 & 63;
            String var13;
            if(var14 == 0) {
               var13 = null;
            } else if(var8.selectedAction != null && var8.selectedAction.trim().length() != 0) {
               var13 = var8.selectedAction;
            } else {
               var13 = null;
            }

            Client.field1062 = var13;
            if(Client.field1062 == null) {
               Client.field1062 = "Null";
            }

            if(var8.hasScript) {
               Client.field1063 = var8.name + class8.getColTags(16777215);
            } else {
               Client.field1063 = class8.getColTags('\uff00') + var8.field2733 + class8.getColTags(16777215);
            }
         }

      } else {
         if(var2 == 12) {
            var20 = Client.cachedNPCs[var3];
            if(var20 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(1);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
            }
         }

         if(var2 == 4) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(91);
            Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShort(var0 + class21.baseX);
            Client.secretPacketBuffer1.putShort(class164.baseY + var1);
         }

         if(var2 == 1002) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.secretPacketBuffer1.putOpcode(200);
            Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
         }

         if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
            Client.renderOverview.method5139(var2, var3, new Coordinates(var0), new Coordinates(var1));
         }

         if(var2 == 45) {
            var19 = Client.cachedPlayers[var3];
            if(var19 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(53);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field636[82]?1:0);
            }
         }

         if(var2 == 1001) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(115);
            Client.secretPacketBuffer1.putShort(var0 + class21.baseX);
            Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.putShortOb2(class164.baseY + var1);
         }

         if(var2 == 43) {
            Client.secretPacketBuffer1.putOpcode(134);
            Client.secretPacketBuffer1.method3129(var3);
            Client.secretPacketBuffer1.putLEInt(var0);
            Client.secretPacketBuffer1.putLEShortA(var1);
            Client.field1075 = 0;
            class12.field262 = class239.method4167(var1);
            Client.field1182 = var0;
         }

         if(var2 == 37) {
            Client.secretPacketBuffer1.putOpcode(13);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.field1075 = 0;
            class12.field262 = class239.method4167(var1);
            Client.field1182 = var0;
         }

         if(var2 == 58) {
            var8 = CollisionData.method2946(var1, var0);
            if(var8 != null) {
               Client.secretPacketBuffer1.putOpcode(127);
               Client.secretPacketBuffer1.putShort(var8.itemId);
               Client.secretPacketBuffer1.putShort(var0);
               Client.secretPacketBuffer1.putShortOb2(Client.field1061);
               Client.secretPacketBuffer1.method3167(class60.field747);
               Client.secretPacketBuffer1.putShortOb2(Client.field1055);
               Client.secretPacketBuffer1.putLEShortA(var1);
            }
         }

         if(var2 == 3) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(21);
            Client.secretPacketBuffer1.putShortOb2(var0 + class21.baseX);
            Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.method3129(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3129(class164.baseY + var1);
         }

         if(var2 == 6) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(131);
            Client.secretPacketBuffer1.putShortOb2(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putLEInt(var0 + class21.baseX);
            Client.secretPacketBuffer1.putShort(class164.baseY + var1);
            Client.secretPacketBuffer1.method3120(KeyFocusListener.field636[82]?1:0);
         }

         if(var2 == 13) {
            var20 = Client.cachedNPCs[var3];
            if(var20 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(227);
               Client.secretPacketBuffer1.method3120(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.putLEInt(var3);
            }
         }

         if(var2 == 44) {
            var19 = Client.cachedPlayers[var3];
            if(var19 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(139);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.putShortOb2(var3);
            }
         }

         if(var2 == 10) {
            var20 = Client.cachedNPCs[var3];
            if(var20 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(136);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.method3129(var3);
            }
         }

         if(var2 == 1) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(122);
            Client.secretPacketBuffer1.putShort(class25.selectedItemIndex);
            Client.secretPacketBuffer1.putLEInt(class46.field595);
            Client.secretPacketBuffer1.putShortOb2(var0 + class21.baseX);
            Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3129(class164.baseY + var1);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.putLEShortA(class8.field232);
         }

         if(var2 == 5) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(105);
            Client.secretPacketBuffer1.method3120(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.putShort(var0 + class21.baseX);
            Client.secretPacketBuffer1.method3129(class164.baseY + var1);
            Client.secretPacketBuffer1.putLEInt(var3 >> 14 & 32767);
         }

         if(var2 == 41) {
            Client.secretPacketBuffer1.putOpcode(147);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.putInt(var1);
            Client.field1075 = 0;
            class12.field262 = class239.method4167(var1);
            Client.field1182 = var0;
         }

         if(var2 == 17) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(100);
            Client.secretPacketBuffer1.method3120(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.putLEInt(class164.baseY + var1);
            Client.secretPacketBuffer1.putShortOb2(var3);
            Client.secretPacketBuffer1.putLEInt(var0 + class21.baseX);
            Client.secretPacketBuffer1.putShort(Client.field1055);
            Client.secretPacketBuffer1.method3139(class60.field747);
         }

         if(var2 == 15) {
            var19 = Client.cachedPlayers[var3];
            if(var19 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(30);
               Client.secretPacketBuffer1.method3139(class60.field747);
               Client.secretPacketBuffer1.method3120(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.putLEInt(var3);
               Client.secretPacketBuffer1.method3129(Client.field1055);
            }
         }

         if(var2 == 28) {
            Client.secretPacketBuffer1.putOpcode(186);
            Client.secretPacketBuffer1.putInt(var1);
            var8 = class239.method4167(var1);
            if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
               var9 = var8.dynamicValues[0][1];
               class211.widgetSettings[var9] = 1 - class211.widgetSettings[var9];
               class164.method3010(var9);
            }
         }

         if(var2 == 30 && Client.field1068 == null) {
            class64.method1034(var1, var0);
            Client.field1068 = CollisionData.method2946(var1, var0);
            class21.method156(Client.field1068);
         }

         if(var2 == 14) {
            var19 = Client.cachedPlayers[var3];
            if(var19 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(112);
               Client.secretPacketBuffer1.putLEInt(class46.field595);
               Client.secretPacketBuffer1.putShortOb2(class25.selectedItemIndex);
               Client.secretPacketBuffer1.method3129(var3);
               Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.method3167(class8.field232);
            }
         }

         if(var2 == 47) {
            var19 = Client.cachedPlayers[var3];
            if(var19 != null) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(184);
               Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
            }
         }

         if(var2 == 22) {
            Client.field1011 = var6;
            Client.field1012 = var7;
            Client.cursorState = 2;
            Client.field1013 = 0;
            Client.destinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(19);
            Client.secretPacketBuffer1.method3129(class164.baseY + var1);
            Client.secretPacketBuffer1.putLEInt(var3);
            Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
            Client.secretPacketBuffer1.putShort(var0 + class21.baseX);
         }

         if(var2 == 38) {
            class2.method6();
            var8 = class239.method4167(var1);
            Client.itemSelectionState = 1;
            class25.selectedItemIndex = var0;
            class8.field232 = var1;
            class46.field595 = var3;
            class21.method156(var8);
            Client.field1058 = class8.getColTags(16748608) + class10.getItemDefinition(var3).name + class8.getColTags(16777215);
            if(Client.field1058 == null) {
               Client.field1058 = "null";
            }

         } else {
            if(var2 == 1004) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.secretPacketBuffer1.putOpcode(238);
               Client.secretPacketBuffer1.putShortOb2(var3);
            }

            if(var2 == 18) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(190);
               Client.secretPacketBuffer1.method3129(var0 + class21.baseX);
               Client.secretPacketBuffer1.putShort(class164.baseY + var1);
               Client.secretPacketBuffer1.method3120(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
            }

            if(var2 == 7) {
               var20 = Client.cachedNPCs[var3];
               if(var20 != null) {
                  Client.field1011 = var6;
                  Client.field1012 = var7;
                  Client.cursorState = 2;
                  Client.field1013 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(8);
                  Client.secretPacketBuffer1.method3129(var3);
                  Client.secretPacketBuffer1.putLEShortA(class8.field232);
                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
                  Client.secretPacketBuffer1.method3129(class46.field595);
                  Client.secretPacketBuffer1.putShortOb2(class25.selectedItemIndex);
               }
            }

            if(var2 == 19) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(102);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.secretPacketBuffer1.method3129(class164.baseY + var1);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.putShort(var0 + class21.baseX);
            }

            if(var2 == 50) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field1011 = var6;
                  Client.field1012 = var7;
                  Client.cursorState = 2;
                  Client.field1013 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(118);
                  Client.secretPacketBuffer1.putLEInt(var3);
                  Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
               }
            }

            if(var2 == 35) {
               Client.secretPacketBuffer1.putOpcode(117);
               Client.secretPacketBuffer1.method3167(var1);
               Client.secretPacketBuffer1.putShortOb2(var0);
               Client.secretPacketBuffer1.putShortOb2(var3);
               Client.field1075 = 0;
               class12.field262 = class239.method4167(var1);
               Client.field1182 = var0;
            }

            if(var2 == 34) {
               Client.secretPacketBuffer1.putOpcode(167);
               Client.secretPacketBuffer1.putShort(var0);
               Client.secretPacketBuffer1.method3129(var3);
               Client.secretPacketBuffer1.method3139(var1);
               Client.field1075 = 0;
               class12.field262 = class239.method4167(var1);
               Client.field1182 = var0;
            }

            if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class19.region.method2655();
               } else {
                  class19.region.method2654(class10.plane, var0, var1, true);
               }
            }

            if(var2 == 33) {
               Client.secretPacketBuffer1.putOpcode(94);
               Client.secretPacketBuffer1.putInt(var1);
               Client.secretPacketBuffer1.putLEInt(var0);
               Client.secretPacketBuffer1.method3129(var3);
               Client.field1075 = 0;
               class12.field262 = class239.method4167(var1);
               Client.field1182 = var0;
            }

            if(var2 == 2) {
               Client.field1011 = var6;
               Client.field1012 = var7;
               Client.cursorState = 2;
               Client.field1013 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(99);
               Client.secretPacketBuffer1.putLEInt(Client.field1055);
               Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
               Client.secretPacketBuffer1.putShortOb2(var0 + class21.baseX);
               Client.secretPacketBuffer1.putInt(class60.field747);
               Client.secretPacketBuffer1.putLEInt(class164.baseY + var1);
            }

            if(var2 == 46) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field1011 = var6;
                  Client.field1012 = var7;
                  Client.cursorState = 2;
                  Client.field1013 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(0);
                  Client.secretPacketBuffer1.putLEInt(var3);
                  Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?1:0);
               }
            }

            if(Client.itemSelectionState != 0) {
               Client.itemSelectionState = 0;
               class21.method156(class239.method4167(class8.field232));
            }

            if(Client.spellSelected) {
               class2.method6();
            }

            if(class12.field262 != null && Client.field1075 == 0) {
               class21.method156(class12.field262);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2064533547"
   )
   public static void method2992() {
      class254.field3401.reset();
      class254.field3400.reset();
      class254.field3402.reset();
   }
}
