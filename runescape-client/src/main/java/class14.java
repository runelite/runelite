import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class14 {
   @ObfuscatedName("lk")
   @ObfuscatedSignature(
      signature = "[Lhx;"
   )
   static Widget[] field271;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1281775737
   )
   public final int field277;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -8787998518662897405L
   )
   public final long field270;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   public final GrandExchangeOffer field276;
   @ObfuscatedName("g")
   String field272;
   @ObfuscatedName("x")
   String field273;

   @ObfuscatedSignature(
      signature = "(Lfs;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field272 = var1.readString();
      this.field273 = var1.readString();
      this.field277 = var1.readUnsignedShort();
      this.field270 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field276 = new GrandExchangeOffer();
      this.field276.method98(2);
      this.field276.method99(var2);
      this.field276.price = var4;
      this.field276.totalQuantity = var5;
      this.field276.quantitySold = 0;
      this.field276.spent = 0;
      this.field276.itemId = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "43"
   )
   public String method83() {
      return this.field272;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1608335275"
   )
   public String method84() {
      return this.field273;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1410390313"
   )
   static int method92(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field906 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-6790362"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.field954 = var6;
         Client.field955 = var7;
         Client.cursorState = 2;
         Client.field968 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class18.method133(ClientPacket.field2381, Client.field905.field1460);
         var8.packetBuffer.method3221(WorldMapType3.selectedItemIndex);
         var8.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
         var8.packetBuffer.method3219(Enum.field3458);
         var8.packetBuffer.putShort(ClanMember.baseY + var1);
         var8.packetBuffer.putInt(class268.field3677);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(var0 + class13.baseX);
         Client.field905.method1855(var8);
      } else if(var2 == 2) {
         Client.field954 = var6;
         Client.field955 = var7;
         Client.cursorState = 2;
         Client.field968 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class18.method133(ClientPacket.field2370, Client.field905.field1460);
         var8.packetBuffer.method3210(KeyFocusListener.field578[82]?1:0);
         var8.packetBuffer.method3221(var3 >> 14 & 32767);
         var8.packetBuffer.method3230(class47.field562);
         var8.packetBuffer.method3219(var0 + class13.baseX);
         var8.packetBuffer.putShortLE(Client.field1003);
         var8.packetBuffer.putShortLE(ClanMember.baseY + var1);
         Client.field905.method1855(var8);
      } else if(var2 == 3) {
         Client.field954 = var6;
         Client.field955 = var7;
         Client.cursorState = 2;
         Client.field968 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class18.method133(ClientPacket.field2318, Client.field905.field1460);
         var8.packetBuffer.putShort(ClanMember.baseY + var1);
         var8.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
         var8.packetBuffer.method3221(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(var0 + class13.baseX);
         Client.field905.method1855(var8);
      } else if(var2 == 4) {
         Client.field954 = var6;
         Client.field955 = var7;
         Client.cursorState = 2;
         Client.field968 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class18.method133(ClientPacket.field2326, Client.field905.field1460);
         var8.packetBuffer.method3219(ClanMember.baseY + var1);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3210(KeyFocusListener.field578[82]?1:0);
         var8.packetBuffer.method3221(var0 + class13.baseX);
         Client.field905.method1855(var8);
      } else if(var2 == 5) {
         Client.field954 = var6;
         Client.field955 = var7;
         Client.cursorState = 2;
         Client.field968 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class18.method133(ClientPacket.field2362, Client.field905.field1460);
         var8.packetBuffer.method3219(ClanMember.baseY + var1);
         var8.packetBuffer.putShort(var0 + class13.baseX);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
         Client.field905.method1855(var8);
      } else if(var2 == 6) {
         Client.field954 = var6;
         Client.field955 = var7;
         Client.cursorState = 2;
         Client.field968 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class18.method133(ClientPacket.field2339, Client.field905.field1460);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(var0 + class13.baseX);
         var8.packetBuffer.method3219(ClanMember.baseY + var1);
         var8.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
         Client.field905.method1855(var8);
      } else {
         PacketNode var9;
         NPC var19;
         if(var2 == 7) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class18.method133(ClientPacket.field2369, Client.field905.field1460);
               var9.packetBuffer.putShort(Enum.field3458);
               var9.packetBuffer.method3219(var3);
               var9.packetBuffer.method3221(WorldMapType3.selectedItemIndex);
               var9.packetBuffer.method3212(KeyFocusListener.field578[82]?1:0);
               var9.packetBuffer.method3230(class268.field3677);
               Client.field905.method1855(var9);
            }
         } else if(var2 == 8) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class18.method133(ClientPacket.field2372, Client.field905.field1460);
               var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
               var9.packetBuffer.method3219(Client.field1003);
               var9.packetBuffer.putInt(class47.field562);
               var9.packetBuffer.putShortLE(var3);
               Client.field905.method1855(var9);
            }
         } else if(var2 == 9) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class18.method133(ClientPacket.field2317, Client.field905.field1460);
               var9.packetBuffer.putShortLE(var3);
               var9.packetBuffer.method3212(KeyFocusListener.field578[82]?1:0);
               Client.field905.method1855(var9);
            }
         } else if(var2 == 10) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class18.method133(ClientPacket.field2349, Client.field905.field1460);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
               Client.field905.method1855(var9);
            }
         } else if(var2 == 11) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class18.method133(ClientPacket.field2304, Client.field905.field1460);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
               Client.field905.method1855(var9);
            }
         } else if(var2 == 12) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class18.method133(ClientPacket.field2325, Client.field905.field1460);
               var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
               var9.packetBuffer.method3221(var3);
               Client.field905.method1855(var9);
            }
         } else if(var2 == 13) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class18.method133(ClientPacket.field2342, Client.field905.field1460);
               var9.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
               var9.packetBuffer.method3221(var3);
               Client.field905.method1855(var9);
            }
         } else {
            Player var21;
            if(var2 == 14) {
               var21 = Client.cachedPlayers[var3];
               if(var21 != null) {
                  Client.field954 = var6;
                  Client.field955 = var7;
                  Client.cursorState = 2;
                  Client.field968 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class18.method133(ClientPacket.field2380, Client.field905.field1460);
                  var9.packetBuffer.method3219(Enum.field3458);
                  var9.packetBuffer.putShortLE(var3);
                  var9.packetBuffer.method3230(class268.field3677);
                  var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
                  var9.packetBuffer.putShort(WorldMapType3.selectedItemIndex);
                  Client.field905.method1855(var9);
               }
            } else if(var2 == 15) {
               var21 = Client.cachedPlayers[var3];
               if(var21 != null) {
                  Client.field954 = var6;
                  Client.field955 = var7;
                  Client.cursorState = 2;
                  Client.field968 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class18.method133(ClientPacket.field2351, Client.field905.field1460);
                  var9.packetBuffer.method3353(class47.field562);
                  var9.packetBuffer.putShort(var3);
                  var9.packetBuffer.method3221(Client.field1003);
                  var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
                  Client.field905.method1855(var9);
               }
            } else if(var2 == 16) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class18.method133(ClientPacket.field2300, Client.field905.field1460);
               var8.packetBuffer.method3210(KeyFocusListener.field578[82]?1:0);
               var8.packetBuffer.method3219(var0 + class13.baseX);
               var8.packetBuffer.method3221(var3);
               var8.packetBuffer.method3221(ClanMember.baseY + var1);
               var8.packetBuffer.method3219(WorldMapType3.selectedItemIndex);
               var8.packetBuffer.method3297(class268.field3677);
               var8.packetBuffer.putShortLE(Enum.field3458);
               Client.field905.method1855(var8);
            } else if(var2 == 17) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class18.method133(ClientPacket.field2377, Client.field905.field1460);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3212(KeyFocusListener.field578[82]?1:0);
               var8.packetBuffer.putShort(var0 + class13.baseX);
               var8.packetBuffer.method3219(Client.field1003);
               var8.packetBuffer.putShortLE(ClanMember.baseY + var1);
               var8.packetBuffer.method3230(class47.field562);
               Client.field905.method1855(var8);
            } else if(var2 == 18) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class18.method133(ClientPacket.field2322, Client.field905.field1460);
               var8.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
               var8.packetBuffer.method3221(var3);
               var8.packetBuffer.putShortLE(ClanMember.baseY + var1);
               var8.packetBuffer.putShortLE(var0 + class13.baseX);
               Client.field905.method1855(var8);
            } else if(var2 == 19) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class18.method133(ClientPacket.field2328, Client.field905.field1460);
               var8.packetBuffer.method3221(ClanMember.baseY + var1);
               var8.packetBuffer.method3221(var3);
               var8.packetBuffer.method3221(var0 + class13.baseX);
               var8.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
               Client.field905.method1855(var8);
            } else if(var2 == 20) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class18.method133(ClientPacket.field2333, Client.field905.field1460);
               var8.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
               var8.packetBuffer.method3221(var3);
               var8.packetBuffer.method3219(ClanMember.baseY + var1);
               var8.packetBuffer.putShort(var0 + class13.baseX);
               Client.field905.method1855(var8);
            } else if(var2 == 21) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class18.method133(ClientPacket.field2309, Client.field905.field1460);
               var8.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
               var8.packetBuffer.method3219(ClanMember.baseY + var1);
               var8.packetBuffer.method3219(var3);
               var8.packetBuffer.putShort(var0 + class13.baseX);
               Client.field905.method1855(var8);
            } else if(var2 == 22) {
               Client.field954 = var6;
               Client.field955 = var7;
               Client.cursorState = 2;
               Client.field968 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class18.method133(ClientPacket.field2366, Client.field905.field1460);
               var8.packetBuffer.putShortLE(var3);
               var8.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
               var8.packetBuffer.putShortLE(var0 + class13.baseX);
               var8.packetBuffer.method3219(ClanMember.baseY + var1);
               Client.field905.method1855(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  Client.region.method2726();
               } else {
                  Client.region.method2789(class28.plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var23;
               if(var2 == 24) {
                  var23 = class64.method1017(var1);
                  boolean var17 = true;
                  if(var23.contentType > 0) {
                     var17 = BaseVarType.method13(var23);
                  }

                  if(var17) {
                     var10 = class18.method133(ClientPacket.field2334, Client.field905.field1460);
                     var10.packetBuffer.putInt(var1);
                     Client.field905.method1855(var10);
                  }
               } else {
                  int var16;
                  if(var2 == 25) {
                     var23 = DecorativeObject.method2896(var1, var0);
                     if(var23 != null) {
                        ContextMenuRow.method1679();
                        var16 = class12.getWidgetConfig(var23);
                        int var25 = var16 >> 11 & 63;
                        int var12 = var23.itemId;
                        Widget var13 = DecorativeObject.method2896(var1, var0);
                        if(var13 != null && var13.field2735 != null) {
                           ScriptEvent var14 = new ScriptEvent();
                           var14.widget = var13;
                           var14.field785 = var13.field2735;
                           BaseVarType.method11(var14);
                        }

                        Client.field1004 = var12;
                        Client.spellSelected = true;
                        class47.field562 = var1;
                        Client.field1003 = var0;
                        class28.field387 = var25;
                        ScriptEvent.method1038(var13);
                        Client.itemSelectionState = 0;
                        int var15 = class12.getWidgetConfig(var23);
                        int var18 = var15 >> 11 & 63;
                        String var22;
                        if(var18 == 0) {
                           var22 = null;
                        } else if(var23.selectedAction != null && var23.selectedAction.trim().length() != 0) {
                           var22 = var23.selectedAction;
                        } else {
                           var22 = null;
                        }

                        Client.field1045 = var22;
                        if(Client.field1045 == null) {
                           Client.field1045 = "Null";
                        }

                        if(var23.hasScript) {
                           Client.field948 = var23.name + class222.getColTags(16777215);
                        } else {
                           Client.field948 = class222.getColTags(65280) + var23.field2797 + class222.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     class39.method509();
                  } else {
                     Widget var20;
                     if(var2 == 28) {
                        var8 = class18.method133(ClientPacket.field2334, Client.field905.field1460);
                        var8.packetBuffer.putInt(var1);
                        Client.field905.method1855(var8);
                        var20 = class64.method1017(var1);
                        if(var20.dynamicValues != null && var20.dynamicValues[0][0] == 5) {
                           var16 = var20.dynamicValues[0][1];
                           class218.widgetSettings[var16] = 1 - class218.widgetSettings[var16];
                           class36.method476(var16);
                        }
                     } else if(var2 == 29) {
                        var8 = class18.method133(ClientPacket.field2334, Client.field905.field1460);
                        var8.packetBuffer.putInt(var1);
                        Client.field905.method1855(var8);
                        var20 = class64.method1017(var1);
                        if(var20.dynamicValues != null && var20.dynamicValues[0][0] == 5) {
                           var16 = var20.dynamicValues[0][1];
                           if(class218.widgetSettings[var16] != var20.field2819[0]) {
                              class218.widgetSettings[var16] = var20.field2819[0];
                              class36.method476(var16);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field878 == null) {
                           class233.method4090(var1, var0);
                           Client.field878 = DecorativeObject.method2896(var1, var0);
                           ScriptEvent.method1038(Client.field878);
                        }
                     } else if(var2 == 31) {
                        var8 = class18.method133(ClientPacket.field2353, Client.field905.field1460);
                        var8.packetBuffer.putShortLE(WorldMapType3.selectedItemIndex);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.putInt(class268.field3677);
                        var8.packetBuffer.method3221(Enum.field3458);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShortLE(var3);
                        Client.field905.method1855(var8);
                        Client.field958 = 0;
                        class175.field2442 = class64.method1017(var1);
                        Client.field959 = var0;
                     } else if(var2 == 32) {
                        var8 = class18.method133(ClientPacket.field2368, Client.field905.field1460);
                        var8.packetBuffer.method3221(var0);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.putInt(class47.field562);
                        var8.packetBuffer.method3221(Client.field1003);
                        Client.field905.method1855(var8);
                        Client.field958 = 0;
                        class175.field2442 = class64.method1017(var1);
                        Client.field959 = var0;
                     } else if(var2 == 33) {
                        var8 = class18.method133(ClientPacket.field2312, Client.field905.field1460);
                        var8.packetBuffer.method3297(var1);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3219(var3);
                        Client.field905.method1855(var8);
                        Client.field958 = 0;
                        class175.field2442 = class64.method1017(var1);
                        Client.field959 = var0;
                     } else if(var2 == 34) {
                        var8 = class18.method133(ClientPacket.field2365, Client.field905.field1460);
                        var8.packetBuffer.method3219(var0);
                        var8.packetBuffer.method3219(var3);
                        var8.packetBuffer.putInt(var1);
                        Client.field905.method1855(var8);
                        Client.field958 = 0;
                        class175.field2442 = class64.method1017(var1);
                        Client.field959 = var0;
                     } else if(var2 == 35) {
                        var8 = class18.method133(ClientPacket.field2324, Client.field905.field1460);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3230(var1);
                        var8.packetBuffer.method3219(var3);
                        Client.field905.method1855(var8);
                        Client.field958 = 0;
                        class175.field2442 = class64.method1017(var1);
                        Client.field959 = var0;
                     } else if(var2 == 36) {
                        var8 = class18.method133(ClientPacket.field2344, Client.field905.field1460);
                        var8.packetBuffer.method3221(var3);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3297(var1);
                        Client.field905.method1855(var8);
                        Client.field958 = 0;
                        class175.field2442 = class64.method1017(var1);
                        Client.field959 = var0;
                     } else if(var2 == 37) {
                        var8 = class18.method133(ClientPacket.field2337, Client.field905.field1460);
                        var8.packetBuffer.method3219(var3);
                        var8.packetBuffer.method3219(var0);
                        var8.packetBuffer.method3297(var1);
                        Client.field905.method1855(var8);
                        Client.field958 = 0;
                        class175.field2442 = class64.method1017(var1);
                        Client.field959 = var0;
                     } else {
                        if(var2 == 38) {
                           ContextMenuRow.method1679();
                           var23 = class64.method1017(var1);
                           Client.itemSelectionState = 1;
                           WorldMapType3.selectedItemIndex = var0;
                           class268.field3677 = var1;
                           Enum.field3458 = var3;
                           ScriptEvent.method1038(var23);
                           Client.field1001 = class222.getColTags(16748608) + class139.getItemDefinition(var3).name + class222.getColTags(16777215);
                           if(Client.field1001 == null) {
                              Client.field1001 = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = class18.method133(ClientPacket.field2360, Client.field905.field1460);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.putShortLE(var0);
                           var8.packetBuffer.method3297(var1);
                           Client.field905.method1855(var8);
                           Client.field958 = 0;
                           class175.field2442 = class64.method1017(var1);
                           Client.field959 = var0;
                        } else if(var2 == 40) {
                           var8 = class18.method133(ClientPacket.field2374, Client.field905.field1460);
                           var8.packetBuffer.method3219(var3);
                           var8.packetBuffer.method3297(var1);
                           var8.packetBuffer.method3219(var0);
                           Client.field905.method1855(var8);
                           Client.field958 = 0;
                           class175.field2442 = class64.method1017(var1);
                           Client.field959 = var0;
                        } else if(var2 == 41) {
                           var8 = class18.method133(ClientPacket.field2310, Client.field905.field1460);
                           var8.packetBuffer.method3221(var3);
                           var8.packetBuffer.method3221(var0);
                           var8.packetBuffer.method3230(var1);
                           Client.field905.method1855(var8);
                           Client.field958 = 0;
                           class175.field2442 = class64.method1017(var1);
                           Client.field959 = var0;
                        } else if(var2 == 42) {
                           var8 = class18.method133(ClientPacket.field2371, Client.field905.field1460);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.method3221(var3);
                           var8.packetBuffer.method3219(var0);
                           Client.field905.method1855(var8);
                           Client.field958 = 0;
                           class175.field2442 = class64.method1017(var1);
                           Client.field959 = var0;
                        } else if(var2 == 43) {
                           var8 = class18.method133(ClientPacket.field2299, Client.field905.field1460);
                           var8.packetBuffer.method3221(var0);
                           var8.packetBuffer.method3221(var3);
                           var8.packetBuffer.method3230(var1);
                           Client.field905.method1855(var8);
                           Client.field958 = 0;
                           class175.field2442 = class64.method1017(var1);
                           Client.field959 = var0;
                        } else if(var2 == 44) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2350, Client.field905.field1460);
                              var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
                              var9.packetBuffer.putShortLE(var3);
                              Client.field905.method1855(var9);
                           }
                        } else if(var2 == 45) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2336, Client.field905.field1460);
                              var9.packetBuffer.putShortLE(var3);
                              var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
                              Client.field905.method1855(var9);
                           }
                        } else if(var2 == 46) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2382, Client.field905.field1460);
                              var9.packetBuffer.method3210(KeyFocusListener.field578[82]?1:0);
                              var9.packetBuffer.putShortLE(var3);
                              Client.field905.method1855(var9);
                           }
                        } else if(var2 == 47) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2298, Client.field905.field1460);
                              var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
                              var9.packetBuffer.putShortLE(var3);
                              Client.field905.method1855(var9);
                           }
                        } else if(var2 == 48) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2347, Client.field905.field1460);
                              var9.packetBuffer.method3221(var3);
                              var9.packetBuffer.method3212(KeyFocusListener.field578[82]?1:0);
                              Client.field905.method1855(var9);
                           }
                        } else if(var2 == 49) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2306, Client.field905.field1460);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
                              Client.field905.method1855(var9);
                           }
                        } else if(var2 == 50) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2384, Client.field905.field1460);
                              var9.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
                              var9.packetBuffer.putShortLE(var3);
                              Client.field905.method1855(var9);
                           }
                        } else if(var2 == 51) {
                           var21 = Client.cachedPlayers[var3];
                           if(var21 != null) {
                              Client.field954 = var6;
                              Client.field955 = var7;
                              Client.cursorState = 2;
                              Client.field968 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class18.method133(ClientPacket.field2323, Client.field905.field1460);
                              var9.packetBuffer.method3220(KeyFocusListener.field578[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field905.method1855(var9);
                           }
                        } else {
                           label697: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var23 = DecorativeObject.method2896(var1, var0);
                                    if(var23 != null) {
                                       var9 = class18.method133(ClientPacket.field2383, Client.field905.field1460);
                                       var9.packetBuffer.method3221(Client.field1003);
                                       var9.packetBuffer.method3219(var0);
                                       var9.packetBuffer.method3297(class47.field562);
                                       var9.packetBuffer.putShort(var23.itemId);
                                       var9.packetBuffer.putShortLE(Client.field1004);
                                       var9.packetBuffer.method3230(var1);
                                       Client.field905.method1855(var9);
                                    }
                                    break label697;
                                 }

                                 if(var2 == 1001) {
                                    Client.field954 = var6;
                                    Client.field955 = var7;
                                    Client.cursorState = 2;
                                    Client.field968 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = class18.method133(ClientPacket.field2393, Client.field905.field1460);
                                    var8.packetBuffer.method3219(var3 >> 14 & 32767);
                                    var8.packetBuffer.method3219(ClanMember.baseY + var1);
                                    var8.packetBuffer.method3221(var0 + class13.baseX);
                                    var8.packetBuffer.putByte(KeyFocusListener.field578[82]?1:0);
                                    Client.field905.method1855(var8);
                                    break label697;
                                 }

                                 if(var2 == 1002) {
                                    Client.field954 = var6;
                                    Client.field955 = var7;
                                    Client.cursorState = 2;
                                    Client.field968 = 0;
                                    var8 = class18.method133(ClientPacket.field2391, Client.field905.field1460);
                                    var8.packetBuffer.method3221(var3 >> 14 & 32767);
                                    Client.field905.method1855(var8);
                                    break label697;
                                 }

                                 if(var2 == 1003) {
                                    Client.field954 = var6;
                                    Client.field955 = var7;
                                    Client.cursorState = 2;
                                    Client.field968 = 0;
                                    var19 = Client.cachedNPCs[var3];
                                    if(var19 != null) {
                                       NPCComposition var24 = var19.composition;
                                       if(var24.configs != null) {
                                          var24 = var24.transform();
                                       }

                                       if(var24 != null) {
                                          var10 = class18.method133(ClientPacket.field2378, Client.field905.field1460);
                                          var10.packetBuffer.putShort(var24.id);
                                          Client.field905.method1855(var10);
                                       }
                                    }
                                    break label697;
                                 }

                                 if(var2 == 1004) {
                                    Client.field954 = var6;
                                    Client.field955 = var7;
                                    Client.cursorState = 2;
                                    Client.field968 = 0;
                                    var8 = class18.method133(ClientPacket.field2376, Client.field905.field1460);
                                    var8.packetBuffer.method3221(var3);
                                    Client.field905.method1855(var8);
                                    break label697;
                                 }

                                 if(var2 == 1005) {
                                    var23 = class64.method1017(var1);
                                    if(var23 != null && var23.itemQuantities[var0] >= 100000) {
                                       class3.sendGameMessage(27, "", var23.itemQuantities[var0] + " x " + class139.getItemDefinition(var3).name);
                                    } else {
                                       var9 = class18.method133(ClientPacket.field2376, Client.field905.field1460);
                                       var9.packetBuffer.method3221(var3);
                                       Client.field905.method1855(var9);
                                    }

                                    Client.field958 = 0;
                                    class175.field2442 = class64.method1017(var1);
                                    Client.field959 = var0;
                                    break label697;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1011 || var2 == 1010 || var2 == 1008 || var2 == 1009 || var2 == 1012) {
                                       ScriptState.renderOverview.method5289(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label697;
                                 }
                              }

                              var23 = DecorativeObject.method2896(var1, var0);
                              if(var23 != null) {
                                 VertexNormal.method2598(var3, var1, var0, var23.itemId, var5);
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
         ScriptEvent.method1038(class64.method1017(class268.field3677));
      }

      if(Client.spellSelected) {
         ContextMenuRow.method1679();
      }

      if(class175.field2442 != null && Client.field958 == 0) {
         ScriptEvent.method1038(class175.field2442);
      }

   }
}
