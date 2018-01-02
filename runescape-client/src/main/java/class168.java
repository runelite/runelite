import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.awt.Desktop.Action;
import java.net.URI;

@ObfuscatedName("fk")
public abstract class class168 {
   @ObfuscatedName("z")
   static byte[][][] field2226;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 493140873
   )
   public int field2223;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1725171261
   )
   public int field2224;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1554231193
   )
   public int field2225;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -301728285
   )
   public int field2227;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILfp;B)Z",
      garbageValue = "-63"
   )
   public abstract boolean vmethod3167(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "4"
   )
   @Export("handleCs2_3100")
   static int method3166(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class82.scriptStringStack[--class35.scriptStringStackSize];
         class25.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class82.intStackSize -= 2;
         class37.method509(UrlRequest.localPlayer, class82.intStack[class82.intStackSize], class82.intStack[class82.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         Widget.method4187();
         return 1;
      } else {
         PacketNode var14;
         int var19;
         if(var0 == 3104) {
            var3 = class82.scriptStringStack[--class35.scriptStringStackSize];
            var19 = 0;
            boolean var7 = false;
            boolean var8 = false;
            int var9 = 0;
            int var10 = var3.length();
            int var11 = 0;

            boolean var6;
            while(true) {
               if(var11 >= var10) {
                  var6 = var8;
                  break;
               }

               label271: {
                  char var12 = var3.charAt(var11);
                  if(var11 == 0) {
                     if(var12 == '-') {
                        var7 = true;
                        break label271;
                     }

                     if(var12 == '+') {
                        break label271;
                     }
                  }

                  int var20;
                  if(var12 >= '0' && var12 <= '9') {
                     var20 = var12 - '0';
                  } else if(var12 >= 'A' && var12 <= 'Z') {
                     var20 = var12 - '7';
                  } else {
                     if(var12 < 'a' || var12 > 'z') {
                        var6 = false;
                        break;
                     }

                     var20 = var12 - 'W';
                  }

                  if(var20 >= 10) {
                     var6 = false;
                     break;
                  }

                  if(var7) {
                     var20 = -var20;
                  }

                  int var13 = var9 * 10 + var20;
                  if(var9 != var13 / 10) {
                     var6 = false;
                     break;
                  }

                  var9 = var13;
                  var8 = true;
               }

               ++var11;
            }

            if(var6) {
               var19 = class228.method4195(var3);
            }

            var14 = FileSystem.method4252(ClientPacket.field2317, Client.field888.field1449);
            var14.packetBuffer.putInt(var19);
            Client.field888.method1862(var14);
            return 1;
         } else {
            PacketNode var22;
            if(var0 == 3105) {
               var3 = class82.scriptStringStack[--class35.scriptStringStackSize];
               var22 = FileSystem.method4252(ClientPacket.field2366, Client.field888.field1449);
               var22.packetBuffer.putByte(var3.length() + 1);
               var22.packetBuffer.putString(var3);
               Client.field888.method1862(var22);
               return 1;
            } else if(var0 == 3106) {
               var3 = class82.scriptStringStack[--class35.scriptStringStackSize];
               var22 = FileSystem.method4252(ClientPacket.field2363, Client.field888.field1449);
               var22.packetBuffer.putByte(var3.length() + 1);
               var22.packetBuffer.putString(var3);
               Client.field888.method1862(var22);
               return 1;
            } else {
               String var15;
               int var16;
               if(var0 == 3107) {
                  var16 = class82.intStack[--class82.intStackSize];
                  var15 = class82.scriptStringStack[--class35.scriptStringStackSize];
                  MessageNode.method1067(var16, var15);
                  return 1;
               } else if(var0 == 3108) {
                  class82.intStackSize -= 3;
                  var16 = class82.intStack[class82.intStackSize];
                  var19 = class82.intStack[class82.intStackSize + 1];
                  int var5 = class82.intStack[class82.intStackSize + 2];
                  Widget var21 = VertexNormal.getWidget(var5);
                  WorldMapData.method341(var21, var16, var19);
                  return 1;
               } else if(var0 == 3109) {
                  class82.intStackSize -= 2;
                  var16 = class82.intStack[class82.intStackSize];
                  var19 = class82.intStack[class82.intStackSize + 1];
                  Widget var23 = var2?class139.field2008:AttackOption.field1306;
                  WorldMapData.method341(var23, var16, var19);
                  return 1;
               } else if(var0 == 3110) {
                  class34.field455 = class82.intStack[--class82.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  class82.intStack[++class82.intStackSize - 1] = class2.preferences.hideRoofs?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  class2.preferences.hideRoofs = class82.intStack[--class82.intStackSize] == 1;
                  WorldComparator.method63();
                  return 1;
               } else if(var0 == 3113) {
                  var3 = class82.scriptStringStack[--class35.scriptStringStackSize];
                  boolean var4 = class82.intStack[--class82.intStackSize] == 1;
                  if(var4) {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var3));
                           return 1;
                        } catch (Exception var18) {
                           ;
                        }
                     }

                     if(class56.field621.startsWith("win")) {
                        class54.method766(var3, 0);
                     } else if(class56.field621.startsWith("mac")) {
                        class35.method492(var3, 1, "openjs");
                     } else {
                        class54.method766(var3, 2);
                     }
                  } else {
                     class54.method766(var3, 3);
                  }

                  return 1;
               } else if(var0 == 3115) {
                  var16 = class82.intStack[--class82.intStackSize];
                  var22 = FileSystem.method4252(ClientPacket.field2385, Client.field888.field1449);
                  var22.packetBuffer.putShort(var16);
                  Client.field888.method1862(var22);
                  return 1;
               } else if(var0 == 3116) {
                  var16 = class82.intStack[--class82.intStackSize];
                  class35.scriptStringStackSize -= 2;
                  var15 = class82.scriptStringStack[class35.scriptStringStackSize];
                  String var17 = class82.scriptStringStack[class35.scriptStringStackSize + 1];
                  if(var15.length() > 500) {
                     return 1;
                  } else if(var17.length() > 500) {
                     return 1;
                  } else {
                     var14 = FileSystem.method4252(ClientPacket.field2355, Client.field888.field1449);
                     var14.packetBuffer.putShort(1 + Ignore.getLength(var15) + Ignore.getLength(var17));
                     var14.packetBuffer.method3286(var16);
                     var14.packetBuffer.putString(var15);
                     var14.packetBuffer.putString(var17);
                     Client.field888.method1862(var14);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field976 = class82.intStack[--class82.intStackSize] == 1;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "-43"
   )
   @Export("cs2_3900s")
   static int method3165(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class56.grandExchangeEvents != null) {
                  class56.grandExchangeEvents.sort(GrandExchangeEvents.field270, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class56.grandExchangeEvents != null) {
                  class56.grandExchangeEvents.sort(GrandExchangeEvents.field271, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class82.intStackSize -= 2;
               var13 = class82.intStack[class82.intStackSize] == 1;
               boolean var4 = class82.intStack[class82.intStackSize + 1] == 1;
               if(class56.grandExchangeEvents != null) {
                  Client.field1103.field837 = var4;
                  class56.grandExchangeEvents.sort(Client.field1103, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class56.grandExchangeEvents != null) {
                  class56.grandExchangeEvents.sort(GrandExchangeEvents.field268, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class56.grandExchangeEvents != null) {
                  class56.grandExchangeEvents.sort(GrandExchangeEvents.field267, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class82.intStack[++class82.intStackSize - 1] = class56.grandExchangeEvents == null?0:class56.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class56.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class56.grandExchangeEvents.events.get(var3);
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var11.method72();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class56.grandExchangeEvents.events.get(var3);
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var11.method78();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class56.grandExchangeEvents.events.get(var3);
                  long var5 = Preferences.currentTimeMs() - class29.field392 - var11.field278;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class56.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class56.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class56.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
