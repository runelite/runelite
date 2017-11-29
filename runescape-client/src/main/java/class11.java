import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class11 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("BoundingBox3DDrawMode_mouseOver")
   public static final class11 BoundingBox3DDrawMode_mouseOver;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("BoundingBox3DDrawMode_all")
   public static final class11 BoundingBox3DDrawMode_all;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[Lhx;"
   )
   @Export("widgets")
   public static Widget[][] widgets;

   static {
      BoundingBox3DDrawMode_mouseOver = new class11();
      BoundingBox3DDrawMode_all = new class11();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "230751165"
   )
   static int method67(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else {
         int var4;
         PacketNode var5;
         int var6;
         if(var0 == 5001) {
            GrandExchangeEvents.intStackSize -= 3;
            Client.publicChatMode = class82.intStack[GrandExchangeEvents.intStackSize];
            var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
            class285[] var17 = class177.method3269();
            var6 = 0;

            class285 var23;
            while(true) {
               if(var6 >= var17.length) {
                  var23 = null;
                  break;
               }

               class285 var19 = var17[var6];
               if(var4 == var19.field3784) {
                  var23 = var19;
                  break;
               }

               ++var6;
            }

            class221.field2705 = var23;
            if(class221.field2705 == null) {
               class221.field2705 = class285.field3787;
            }

            Client.field986 = class82.intStack[GrandExchangeEvents.intStackSize + 2];
            var5 = class218.method4105(ClientPacket.field2327, Client.field916.field1470);
            var5.packetBuffer.putByte(Client.publicChatMode);
            var5.packetBuffer.putByte(class221.field2705.field3784);
            var5.packetBuffer.putByte(Client.field986);
            Client.field916.method1925(var5);
            return 1;
         } else {
            String var3;
            int var10;
            if(var0 == 5002) {
               var3 = class82.scriptStringStack[--class82.scriptStringStackSize];
               GrandExchangeEvents.intStackSize -= 2;
               var4 = class82.intStack[GrandExchangeEvents.intStackSize];
               var10 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
               PacketNode var11 = class218.method4105(ClientPacket.field2343, Client.field916.field1470);
               var11.packetBuffer.putByte(AbstractSoundSystem.getLength(var3) + 2);
               var11.packetBuffer.putString(var3);
               var11.packetBuffer.putByte(var4 - 1);
               var11.packetBuffer.putByte(var10);
               Client.field916.method1925(var11);
               return 1;
            } else {
               int var12;
               if(var0 == 5003) {
                  GrandExchangeEvents.intStackSize -= 2;
                  var12 = class82.intStack[GrandExchangeEvents.intStackSize];
                  var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
                  MessageNode var16 = PendingSpawn.method1573(var12, var4);
                  if(var16 != null) {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var16.id;
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var16.tick;
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var16.name != null?var16.name:"";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var16.sender != null?var16.sender:"";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var16.value != null?var16.value:"";
                  } else {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = -1;
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5004) {
                  var12 = class82.intStack[--GrandExchangeEvents.intStackSize];
                  MessageNode var22 = (MessageNode)class96.messages.get((long)var12);
                  if(var22 != null) {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var22.type;
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var22.tick;
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var22.name != null?var22.name:"";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var22.sender != null?var22.sender:"";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var22.value != null?var22.value:"";
                  } else {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = -1;
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5005) {
                  if(class221.field2705 == null) {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = class221.field2705.field3784;
                  }

                  return 1;
               } else if(var0 == 5008) {
                  var3 = class82.scriptStringStack[--class82.scriptStringStackSize];
                  var4 = class82.intStack[--GrandExchangeEvents.intStackSize];
                  String var15 = var3.toLowerCase();
                  byte var20 = 0;
                  if(var15.startsWith("yellow:")) {
                     var20 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var15.startsWith("red:")) {
                     var20 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var15.startsWith("green:")) {
                     var20 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var15.startsWith("cyan:")) {
                     var20 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var15.startsWith("purple:")) {
                     var20 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var15.startsWith("white:")) {
                     var20 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var15.startsWith("flash1:")) {
                     var20 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var15.startsWith("flash2:")) {
                     var20 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var15.startsWith("flash3:")) {
                     var20 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var15.startsWith("glow1:")) {
                     var20 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var15.startsWith("glow2:")) {
                     var20 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var15.startsWith("glow3:")) {
                     var20 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.languageId != 0) {
                     if(var15.startsWith("yellow:")) {
                        var20 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var15.startsWith("red:")) {
                        var20 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var15.startsWith("green:")) {
                        var20 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var15.startsWith("cyan:")) {
                        var20 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var15.startsWith("purple:")) {
                        var20 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var15.startsWith("white:")) {
                        var20 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var15.startsWith("flash1:")) {
                        var20 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var15.startsWith("flash2:")) {
                        var20 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var15.startsWith("flash3:")) {
                        var20 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var15.startsWith("glow1:")) {
                        var20 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var15.startsWith("glow2:")) {
                        var20 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var15.startsWith("glow3:")) {
                        var20 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var15 = var3.toLowerCase();
                  byte var14 = 0;
                  if(var15.startsWith("wave:")) {
                     var14 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var15.startsWith("wave2:")) {
                     var14 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var15.startsWith("shake:")) {
                     var14 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var15.startsWith("scroll:")) {
                     var14 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var15.startsWith("slide:")) {
                     var14 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.languageId != 0) {
                     if(var15.startsWith("wave:")) {
                        var14 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var15.startsWith("wave2:")) {
                        var14 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var15.startsWith("shake:")) {
                        var14 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var15.startsWith("scroll:")) {
                        var14 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var15.startsWith("slide:")) {
                        var14 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  PacketNode var8 = class218.method4105(ClientPacket.field2386, Client.field916.field1470);
                  var8.packetBuffer.putByte(0);
                  int var9 = var8.packetBuffer.offset;
                  var8.packetBuffer.putByte(var4);
                  var8.packetBuffer.putByte(var20);
                  var8.packetBuffer.putByte(var14);
                  class29.method244(var8.packetBuffer, var3);
                  var8.packetBuffer.method3293(var8.packetBuffer.offset - var9);
                  Client.field916.method1925(var8);
                  return 1;
               } else if(var0 == 5009) {
                  class82.scriptStringStackSize -= 2;
                  var3 = class82.scriptStringStack[class82.scriptStringStackSize];
                  String var21 = class82.scriptStringStack[class82.scriptStringStackSize + 1];
                  var5 = class218.method4105(ClientPacket.field2378, Client.field916.field1470);
                  var5.packetBuffer.putShort(0);
                  var6 = var5.packetBuffer.offset;
                  var5.packetBuffer.putString(var3);
                  class29.method244(var5.packetBuffer, var21);
                  var5.packetBuffer.method3498(var5.packetBuffer.offset - var6);
                  Client.field916.method1925(var5);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.field986;
                     return 1;
                  } else {
                     int[] var13;
                     if(var0 == 5017) {
                        var12 = class82.intStack[--GrandExchangeEvents.intStackSize];
                        var13 = class82.intStack;
                        var10 = ++GrandExchangeEvents.intStackSize - 1;
                        ChatLineBuffer var18 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var12));
                        if(var18 == null) {
                           var6 = 0;
                        } else {
                           var6 = var18.size();
                        }

                        var13[var10] = var6;
                        return 1;
                     } else if(var0 == 5018) {
                        var12 = class82.intStack[--GrandExchangeEvents.intStackSize];
                        class82.intStack[++GrandExchangeEvents.intStackSize - 1] = BoundingBox2D.method46(var12);
                        return 1;
                     } else if(var0 == 5019) {
                        var12 = class82.intStack[--GrandExchangeEvents.intStackSize];
                        var13 = class82.intStack;
                        var10 = ++GrandExchangeEvents.intStackSize - 1;
                        MessageNode var7 = (MessageNode)class96.messages.get((long)var12);
                        if(var7 == null) {
                           var6 = -1;
                        } else if(var7.next == class96.field1435.sentinel) {
                           var6 = -1;
                        } else {
                           var6 = ((MessageNode)var7.next).id;
                        }

                        var13[var10] = var6;
                        return 1;
                     } else if(var0 == 5020) {
                        var3 = class82.scriptStringStack[--class82.scriptStringStackSize];
                        KeyFocusListener.method774(var3);
                        return 1;
                     } else if(var0 == 5021) {
                        Client.field1072 = class82.scriptStringStack[--class82.scriptStringStackSize].toLowerCase().trim();
                        return 1;
                     } else if(var0 == 5022) {
                        class82.scriptStringStack[++class82.scriptStringStackSize - 1] = Client.field1072;
                        return 1;
                     } else {
                        return 2;
                     }
                  }
               } else {
                  if(class181.localPlayer != null && class181.localPlayer.name != null) {
                     var3 = class181.localPlayer.name;
                  } else {
                     var3 = "";
                  }

                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "2003631557"
   )
   static void method65(int var0, String var1) {
      int var2 = class94.playerIndexesCount;
      int[] var3 = class94.playerIndices;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != class181.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            PacketNode var7;
            if(var0 == 1) {
               var7 = class218.method4105(ClientPacket.field2368, Client.field916.field1470);
               var7.packetBuffer.method3322(0);
               var7.packetBuffer.putShort(var3[var5]);
               Client.field916.method1925(var7);
            } else if(var0 == 4) {
               var7 = class218.method4105(ClientPacket.field2380, Client.field916.field1470);
               var7.packetBuffer.putShort(var3[var5]);
               var7.packetBuffer.putByte(0);
               Client.field916.method1925(var7);
            } else if(var0 == 6) {
               var7 = class218.method4105(ClientPacket.field2323, Client.field916.field1470);
               var7.packetBuffer.putShortLE(var3[var5]);
               var7.packetBuffer.method3322(0);
               Client.field916.method1925(var7);
            } else if(var0 == 7) {
               var7 = class218.method4105(ClientPacket.field2354, Client.field916.field1470);
               var7.packetBuffer.method3307(0);
               var7.packetBuffer.putShortLE(var3[var5]);
               Client.field916.method1925(var7);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class54.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIZI)V",
      garbageValue = "-987492010"
   )
   static void method66(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            method64(var6, var2, var3, var4);
            SoundTask.method2177(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               NPCComposition.method4864(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lhx;IIZB)V",
      garbageValue = "1"
   )
   static void method64(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2731 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2731 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2731 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2736;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2736;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2736 >> 14;
      }

      if(var0.field2731 == 4) {
         var0.width = var0.field2741 * var0.height / var0.field2766;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2766 * var0.width / var0.field2741;
      }

      if(Client.field967 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1026 = var0;
      }

      if(var3 && var0.field2833 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.objs = var0.field2833;
         Client.field1010.addFront(var6);
      }

   }
}
