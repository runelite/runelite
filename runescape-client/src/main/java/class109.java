import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public abstract class class109 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "558296171"
   )
   abstract void vmethod2132();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1258551841"
   )
   abstract int vmethod2133(int var1, int var2);

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "95"
   )
   static final boolean method2135() {
      if(null == XGrandExchangeOffer.field30) {
         return false;
      } else {
         int var2;
         String var15;
         try {
            int var0 = XGrandExchangeOffer.field30.method2138();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 1);
               Client.field334.offset = 0;
               Client.packetOpcode = Client.field334.method3158();
               Client.field335 = class212.field3151[Client.packetOpcode];
               --var0;
            }

            if(Client.field335 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 1);
               Client.field335 = Client.field334.payload[0] & 255;
               --var0;
            }

            if(Client.field335 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, 2);
               Client.field334.offset = 0;
               Client.field335 = Client.field334.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field335) {
               return false;
            }

            Client.field334.offset = 0;
            XGrandExchangeOffer.field30.method2143(Client.field334.payload, 0, Client.field335);
            Client.field337 = 0;
            Client.field341 = Client.field340;
            Client.field340 = Client.field345 * -1;
            Client.field345 = Client.packetOpcode * -1;
            int var1;
            Widget var3;
            if(Client.packetOpcode == 224) {
               var1 = Client.field334.method3045();
               var2 = Client.field334.method2922();
               var3 = ChatLineBuffer.method993(var1);
               if(var3.modelType != 1 || var3.modelId != var2) {
                  var3.modelType = 1;
                  var3.modelId = var2;
                  ChatLineBuffer.method996(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 164) {
               Client.flagX = Client.field334.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field334.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var5;
            int var6;
            int var51;
            int var53;
            if(Client.packetOpcode == 3) {
               var1 = Client.field334.readInt();
               var2 = Client.field334.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var3 = ChatLineBuffer.method993(var1);
               } else {
                  var3 = null;
               }

               if(var3 != null) {
                  for(var51 = 0; var51 < var3.itemIds.length; ++var51) {
                     var3.itemIds[var51] = 0;
                     var3.itemQuantities[var51] = 0;
                  }
               }

               class179.method3344(var2);
               var51 = Client.field334.readUnsignedShort();

               for(var5 = 0; var5 < var51; ++var5) {
                  var6 = Client.field334.method2923();
                  var53 = Client.field334.method2992();
                  if(var53 == 255) {
                     var53 = Client.field334.method2931();
                  }

                  if(var3 != null && var5 < var3.itemIds.length) {
                     var3.itemIds[var5] = var6;
                     var3.itemQuantities[var5] = var53;
                  }

                  class9.method112(var2, var5, var6 - 1, var53);
               }

               if(null != var3) {
                  ChatLineBuffer.method996(var3);
               }

               class146.method2815();
               Client.interfaceItemTriggers[++Client.field478 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 42) {
               class26.field596 = Client.field334.method2913();
               class7.field60 = Client.field334.method2913();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 97) {
               class146.method2815();
               Client.weight = Client.field334.readShort();
               Client.field486 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var50;
            if(Client.packetOpcode == 120) {
               var50 = Client.field334.readUnsignedByte() == 1;
               if(var50) {
                  class88.field1542 = WallObject.method1985() - Client.field334.method2892();
                  Renderable.field1549 = new class1(Client.field334, true);
               } else {
                  Renderable.field1549 = null;
               }

               Client.field485 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 107) {
               class33.method776(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 115) {
               var1 = Client.field334.method2924();
               byte var67 = Client.field334.method2972();
               class165.settings[var1] = var67;
               if(class165.widgetSettings[var1] != var67) {
                  class165.widgetSettings[var1] = var67;
               }

               class139.method2577(var1);
               Client.field496[++Client.field476 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 90) {
               var1 = Client.field334.method2922();
               class15.method192(var1);
               Client.interfaceItemTriggers[++Client.field478 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            int var17;
            if(Client.packetOpcode == 177) {
               var15 = Client.field334.readString();
               Object[] var78 = new Object[var15.length() + 1];

               for(var17 = var15.length() - 1; var17 >= 0; --var17) {
                  if(var15.charAt(var17) == 115) {
                     var78[var17 + 1] = Client.field334.readString();
                  } else {
                     var78[1 + var17] = new Integer(Client.field334.readInt());
                  }
               }

               var78[0] = new Integer(Client.field334.readInt());
               class18 var62 = new class18();
               var62.field196 = var78;
               class40.method828(var62);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 69) {
               for(var1 = 0; var1 < class165.widgetSettings.length; ++var1) {
                  if(class165.settings[var1] != class165.widgetSettings[var1]) {
                     class165.widgetSettings[var1] = class165.settings[var1];
                     class139.method2577(var1);
                     Client.field496[++Client.field476 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 173) {
               class26.field596 = Client.field334.method2992();
               class7.field60 = Client.field334.method2992();

               for(var1 = class7.field60; var1 < 8 + class7.field60; ++var1) {
                  for(var2 = class26.field596; var2 < class26.field596 + 8; ++var2) {
                     if(Client.groundItemDeque[CollisionData.plane][var1][var2] != null) {
                        Client.groundItemDeque[CollisionData.plane][var1][var2] = null;
                        class110.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class25 var69 = (class25)Client.field392.method2503(); null != var69; var69 = (class25)Client.field392.method2492()) {
                  if(var69.field577 >= class7.field60 && var69.field577 < class7.field60 + 8 && var69.field578 >= class26.field596 && var69.field578 < 8 + class26.field596 && CollisionData.plane == var69.field581) {
                     var69.field575 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 27 || Client.packetOpcode == 19 || Client.packetOpcode == 232 || Client.packetOpcode == 22 || Client.packetOpcode == 200 || Client.packetOpcode == 78 || Client.packetOpcode == 137 || Client.packetOpcode == 37 || Client.packetOpcode == 151 || Client.packetOpcode == 13) {
               TextureProvider.method1541();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 134) {
               class146.method2815();
               var1 = Client.field334.method2914();
               var2 = Client.field334.method2914();
               var17 = Client.field334.readInt();
               Client.skillExperiences[var2] = var17;
               Client.boostedSkillLevels[var2] = var1;
               Client.realSkillLevels[var2] = 1;

               for(var51 = 0; var51 < 98; ++var51) {
                  if(var17 >= class172.field2354[var51]) {
                     Client.realSkillLevels[var2] = 2 + var51;
                  }
               }

               Client.field479[++Client.field480 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 241) {
               Client.field459 = true;
               class167.field2182 = Client.field334.readUnsignedByte();
               class195.field2870 = Client.field334.readUnsignedByte();
               Item.field893 = Client.field334.readUnsignedShort();
               Ignore.field203 = Client.field334.readUnsignedByte();
               class38.field801 = Client.field334.readUnsignedByte();
               if(class38.field801 >= 100) {
                  var1 = 64 + class167.field2182 * 128;
                  var2 = 64 + class195.field2870 * 128;
                  var17 = class25.method615(var1, var2, CollisionData.plane) - Item.field893;
                  var51 = var1 - FaceNormal.cameraX;
                  var5 = var17 - class45.cameraZ;
                  var6 = var2 - ChatLineBuffer.cameraY;
                  var53 = (int)Math.sqrt((double)(var6 * var6 + var51 * var51));
                  class10.cameraPitch = (int)(Math.atan2((double)var5, (double)var53) * 325.949D) & 2047;
                  Projectile.cameraYaw = (int)(Math.atan2((double)var51, (double)var6) * -325.949D) & 2047;
                  if(class10.cameraPitch < 128) {
                     class10.cameraPitch = 128;
                  }

                  if(class10.cameraPitch > 383) {
                     class10.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 99) {
               var1 = Client.field334.method3045();
               var2 = Client.field334.method2924();
               var17 = var2 >> 10 & 31;
               var51 = var2 >> 5 & 31;
               var5 = var2 & 31;
               var6 = (var51 << 11) + (var17 << 19) + (var5 << 3);
               Widget var79 = ChatLineBuffer.method993(var1);
               if(var79.textColor != var6) {
                  var79.textColor = var6;
                  ChatLineBuffer.method996(var79);
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var4;
            if(Client.packetOpcode == 254) {
               var15 = Client.field334.readString();
               var2 = Client.field334.readUnsignedShort();
               byte var89 = Client.field334.readByte();
               var4 = false;
               if(var89 == -128) {
                  var4 = true;
               }

               if(var4) {
                  if(class119.clanChatCount == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  boolean var56 = false;

                  for(var5 = 0; var5 < class119.clanChatCount && (!Friend.clanMembers[var5].username.equals(var15) || var2 != Friend.clanMembers[var5].world); ++var5) {
                     ;
                  }

                  if(var5 < class119.clanChatCount) {
                     while(var5 < class119.clanChatCount - 1) {
                        Friend.clanMembers[var5] = Friend.clanMembers[1 + var5];
                        ++var5;
                     }

                     --class119.clanChatCount;
                     Friend.clanMembers[class119.clanChatCount] = null;
                  }
               } else {
                  Client.field334.readString();
                  XClanMember var87 = new XClanMember();
                  var87.username = var15;
                  var87.field275 = class60.method1229(var87.username, class149.field2037);
                  var87.world = var2;
                  var87.rank = var89;

                  for(var6 = class119.clanChatCount - 1; var6 >= 0; --var6) {
                     var53 = Friend.clanMembers[var6].field275.compareTo(var87.field275);
                     if(var53 == 0) {
                        Friend.clanMembers[var6].world = var2;
                        Friend.clanMembers[var6].rank = var89;
                        if(var15.equals(WidgetNode.localPlayer.name)) {
                           Client.field518 = var89;
                        }

                        Client.field483 = Client.field505;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var53 < 0) {
                        break;
                     }
                  }

                  if(class119.clanChatCount >= Friend.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var53 = class119.clanChatCount - 1; var53 > var6; --var53) {
                     Friend.clanMembers[var53 + 1] = Friend.clanMembers[var53];
                  }

                  if(class119.clanChatCount == 0) {
                     Friend.clanMembers = new XClanMember[100];
                  }

                  Friend.clanMembers[var6 + 1] = var87;
                  ++class119.clanChatCount;
                  if(var15.equals(WidgetNode.localPlayer.name)) {
                     Client.field518 = var89;
                  }
               }

               Client.field483 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            WidgetNode var83;
            if(Client.packetOpcode == 88) {
               var1 = Client.field334.readUnsignedByte();
               var2 = Client.field334.method2922();
               var17 = Client.field334.method2931();
               var83 = (WidgetNode)Client.componentTable.method2437((long)var17);
               if(null != var83) {
                  class18.method203(var83, var83.id != var2);
               }

               WidgetNode var85 = new WidgetNode();
               var85.id = var2;
               var85.field176 = var1;
               Client.componentTable.method2438(var85, (long)var17);
               class88.method1968(var2);
               Widget var88 = ChatLineBuffer.method993(var17);
               ChatLineBuffer.method996(var88);
               if(null != Client.field543) {
                  ChatLineBuffer.method996(Client.field543);
                  Client.field543 = null;
               }

               class63.method1239();
               Script.method973(class231.widgets[var17 >> 16], var88, false);
               class114.method2299(var2);
               if(Client.widgetRoot != -1) {
                  class104.method2090(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 102) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(Client.cachedPlayers[var1] != null) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(null != Client.cachedNPCs[var1]) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var16;
            if(Client.packetOpcode == 233) {
               var15 = Client.field334.readString();
               var16 = FontTypeFace.method3949(Varbit.method3615(ChatMessages.method955(Client.field334)));
               class88.sendGameMessage(6, var15, var16);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 160) {
               var1 = Client.field334.method2924();
               Client.widgetRoot = var1;
               class143.method2789(Client.widgetRoot, RSCanvas.field1756, class65.field1128, false);
               class88.method1968(var1);
               class114.method2299(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field494[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 24) {
               for(var1 = 0; var1 < class187.field2780; ++var1) {
                  class187 var75 = class142.method2762(var1);
                  if(var75 != null) {
                     class165.settings[var1] = 0;
                     class165.widgetSettings[var1] = 0;
                  }
               }

               class146.method2815();
               Client.field476 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 248) {
               class18.method200(Client.field334, Client.field335);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 207) {
               Client.field498 = Client.field334.method2924() * 30;
               Client.field486 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 155) {
               if(Client.widgetRoot != -1) {
                  class104.method2090(Client.widgetRoot, 0);
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var81;
            if(Client.packetOpcode == 237) {
               var1 = Client.field334.method3045();
               var2 = Client.field334.readInt();
               var17 = Client.field334.readUnsignedShort();
               if(var17 == '\uffff') {
                  var17 = -1;
               }

               var81 = ChatLineBuffer.method993(var2);
               ItemComposition var82;
               if(!var81.hasScript) {
                  if(var17 == -1) {
                     var81.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var82 = ChatLineBuffer.getItemDefinition(var17);
                  var81.modelType = 4;
                  var81.modelId = var17;
                  var81.rotationX = var82.xan2d;
                  var81.rotationZ = var82.yan2d;
                  var81.field2260 = var82.zoom2d * 100 / var1;
                  ChatLineBuffer.method996(var81);
               } else {
                  var81.item = var17;
                  var81.stackSize = var1;
                  var82 = ChatLineBuffer.getItemDefinition(var17);
                  var81.rotationX = var82.xan2d;
                  var81.rotationZ = var82.yan2d;
                  var81.rotationY = var82.zan2d;
                  var81.field2255 = var82.offsetX2d;
                  var81.field2256 = var82.offsetY2d;
                  var81.field2260 = var82.zoom2d;
                  if(var82.isStackable == 1) {
                     var81.field2229 = 1;
                  } else {
                     var81.field2229 = 2;
                  }

                  if(var81.field2318 > 0) {
                     var81.field2260 = var81.field2260 * 32 / var81.field2318;
                  } else if(var81.originalWidth > 0) {
                     var81.field2260 = var81.field2260 * 32 / var81.originalWidth;
                  }

                  ChatLineBuffer.method996(var81);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 198) {
               var1 = Client.field334.readInt();
               WidgetNode var73 = (WidgetNode)Client.componentTable.method2437((long)var1);
               if(var73 != null) {
                  class18.method203(var73, true);
               }

               if(null != Client.field543) {
                  ChatLineBuffer.method996(Client.field543);
                  Client.field543 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 253) {
               Client.field526 = Client.field334.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 41) {
               class211.method3996(Client.field334, Client.field335);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 18) {
               Client.field507 = Client.field334.readUnsignedByte();
               Client.field445 = Client.field334.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 188) {
               class33.method773();
               Client.packetOpcode = -1;
               return false;
            }

            long var22;
            if(Client.packetOpcode == 70) {
               var1 = Client.field334.method3045();
               var2 = Client.field334.method2922();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var17 = Client.field334.method2923();
               if(var17 == '\uffff') {
                  var17 = -1;
               }

               var51 = Client.field334.method2932();

               for(var5 = var17; var5 <= var2; ++var5) {
                  var22 = ((long)var51 << 32) + (long)var5;
                  Node var55 = Client.widgetFlags.method2437(var22);
                  if(var55 != null) {
                     var55.unlink();
                  }

                  Client.widgetFlags.method2438(new class133(var1), var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 216) {
               var1 = Client.field334.readUnsignedByte();
               var16 = Client.field334.readString();
               var17 = Client.field334.method2914();
               if(var1 >= 1 && var1 <= 8) {
                  if(var16.equalsIgnoreCase("null")) {
                     var16 = null;
                  }

                  Client.playerOptions[var1 - 1] = var16;
                  Client.playerOptionsPriority[var1 - 1] = var17 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 53) {
               class16.method195(Client.field334.readString());
               Client.packetOpcode = -1;
               return true;
            }

            boolean var52;
            if(Client.packetOpcode == 28) {
               var1 = Client.field334.method2932();
               var52 = Client.field334.method2992() == 1;
               var3 = ChatLineBuffer.method993(var1);
               if(var52 != var3.isHidden) {
                  var3.isHidden = var52;
                  ChatLineBuffer.method996(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 235) {
               World var68 = new World();
               var68.address = Client.field334.readString();
               var68.id = Client.field334.readUnsignedShort();
               var2 = Client.field334.readInt();
               var68.mask = var2;
               World.setGameState(45);
               XGrandExchangeOffer.field30.method2139();
               XGrandExchangeOffer.field30 = null;
               Frames.method1994(var68);
               Client.packetOpcode = -1;
               return false;
            }

            Widget var77;
            if(Client.packetOpcode == 239) {
               var1 = Client.field334.method2922();
               var2 = Client.field334.method2931();
               var17 = Client.field334.method2923();
               var51 = Client.field334.readUnsignedShort();
               var77 = ChatLineBuffer.method993(var2);
               if(var17 != var77.rotationX || var77.rotationZ != var1 || var51 != var77.field2260) {
                  var77.rotationX = var17;
                  var77.rotationZ = var1;
                  var77.field2260 = var51;
                  ChatLineBuffer.method996(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 68) {
               Client.field558 = 1;
               Client.field482 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 210) {
               var1 = Client.field334.readInt();
               var2 = Client.field334.readShort();
               var3 = ChatLineBuffer.method993(var1);
               if(var3.field2233 != var2 || var2 == -1) {
                  var3.field2233 = var2;
                  var3.field2328 = 0;
                  var3.field2329 = 0;
                  ChatLineBuffer.method996(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var24;
            long var25;
            if(Client.packetOpcode == 108) {
               var1 = Client.field334.offset + Client.field335;
               var2 = Client.field334.readUnsignedShort();
               var17 = Client.field334.readUnsignedShort();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  class143.method2789(Client.widgetRoot, RSCanvas.field1756, class65.field1128, false);
                  class88.method1968(Client.widgetRoot);
                  class114.method2299(Client.widgetRoot);

                  for(var51 = 0; var51 < 100; ++var51) {
                     Client.field494[var51] = true;
                  }
               }

               WidgetNode var72;
               for(; var17-- > 0; var72.field179 = true) {
                  var51 = Client.field334.readInt();
                  var5 = Client.field334.readUnsignedShort();
                  var6 = Client.field334.readUnsignedByte();
                  var72 = (WidgetNode)Client.componentTable.method2437((long)var51);
                  if(var72 != null && var5 != var72.id) {
                     class18.method203(var72, true);
                     var72 = null;
                  }

                  if(var72 == null) {
                     WidgetNode var60 = new WidgetNode();
                     var60.id = var5;
                     var60.field176 = var6;
                     Client.componentTable.method2438(var60, (long)var51);
                     class88.method1968(var5);
                     Widget var63 = ChatLineBuffer.method993(var51);
                     ChatLineBuffer.method996(var63);
                     if(null != Client.field543) {
                        ChatLineBuffer.method996(Client.field543);
                        Client.field543 = null;
                     }

                     class63.method1239();
                     Script.method973(class231.widgets[var51 >> 16], var63, false);
                     class114.method2299(var5);
                     if(Client.widgetRoot != -1) {
                        class104.method2090(Client.widgetRoot, 1);
                     }

                     var72 = var60;
                  }
               }

               for(var83 = (WidgetNode)Client.componentTable.method2440(); null != var83; var83 = (WidgetNode)Client.componentTable.method2441()) {
                  if(var83.field179) {
                     var83.field179 = false;
                  } else {
                     class18.method203(var83, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field334.offset < var1) {
                  var51 = Client.field334.readInt();
                  var5 = Client.field334.readUnsignedShort();
                  var6 = Client.field334.readUnsignedShort();
                  var53 = Client.field334.readInt();

                  for(var24 = var5; var24 <= var6; ++var24) {
                     var25 = ((long)var51 << 32) + (long)var24;
                     Client.widgetFlags.method2438(new class133(var53), var25);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 29) {
               var1 = Client.field334.readInt();
               var2 = Client.field334.readInt();
               WidgetNode var58 = (WidgetNode)Client.componentTable.method2437((long)var2);
               var83 = (WidgetNode)Client.componentTable.method2437((long)var1);
               if(var83 != null) {
                  class18.method203(var83, null == var58 || var83.id != var58.id);
               }

               if(var58 != null) {
                  var58.unlink();
                  Client.componentTable.method2438(var58, (long)var1);
               }

               var77 = ChatLineBuffer.method993(var2);
               if(var77 != null) {
                  ChatLineBuffer.method996(var77);
               }

               var77 = ChatLineBuffer.method993(var1);
               if(null != var77) {
                  ChatLineBuffer.method996(var77);
                  Script.method973(class231.widgets[var77.id >>> 16], var77, true);
               }

               if(Client.widgetRoot != -1) {
                  class104.method2090(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 221) {
               var1 = Client.field334.readUnsignedShort();
               var2 = Client.field334.readUnsignedByte();
               var17 = Client.field334.readUnsignedShort();
               if(Client.field530 != 0 && var2 != 0 && Client.field532 < 50) {
                  Client.field533[Client.field532] = var1;
                  Client.field534[Client.field532] = var2;
                  Client.field535[Client.field532] = var17;
                  Client.field537[Client.field532] = null;
                  Client.field536[Client.field532] = 0;
                  ++Client.field532;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 75) {
               class146.method2815();
               Client.energy = Client.field334.readUnsignedByte();
               Client.field486 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 179) {
               var1 = Client.field334.method2923();
               var2 = Client.field334.readInt();
               var3 = ChatLineBuffer.method993(var2);
               if(var3.modelType != 2 || var1 != var3.modelId) {
                  var3.modelType = 2;
                  var3.modelId = var1;
                  ChatLineBuffer.method996(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 132) {
               var1 = Client.field334.method2931();
               class85.field1466 = class114.field1793.method2057(var1);
               Client.packetOpcode = -1;
               return true;
            }

            Widget var70;
            if(Client.packetOpcode == 215) {
               var1 = Client.field334.method2932();
               var70 = ChatLineBuffer.method993(var1);

               for(var17 = 0; var17 < var70.itemIds.length; ++var17) {
                  var70.itemIds[var17] = -1;
                  var70.itemIds[var17] = 0;
               }

               ChatLineBuffer.method996(var70);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 161) {
               Client.method610();

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               CombatInfoListHolder.method778(Client.field334);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 193) {
               class36.xteaChanged(false);
               Client.field334.method3158();
               var1 = Client.field334.readUnsignedShort();
               class18.method200(Client.field334, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 110) {
               var1 = Client.field334.method2932();
               var70 = ChatLineBuffer.method993(var1);
               var70.modelType = 3;
               var70.modelId = WidgetNode.localPlayer.composition.method3244();
               ChatLineBuffer.method996(var70);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 190) {
               var1 = Client.field334.readUnsignedByte();
               var2 = Client.field334.readUnsignedByte();
               var17 = Client.field334.readUnsignedByte();
               var51 = Client.field334.readUnsignedByte();
               Client.field539[var1] = true;
               Client.field540[var1] = var2;
               Client.field541[var1] = var17;
               Client.field542[var1] = var51;
               Client.field292[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 73) {
               class26.field596 = Client.field334.method2914();
               class7.field60 = Client.field334.method2992();

               while(Client.field334.offset < Client.field335) {
                  Client.packetOpcode = Client.field334.readUnsignedByte();
                  TextureProvider.method1541();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 106) {
               var1 = Client.field334.method2931();
               var2 = Client.field334.method2924();
               class165.settings[var2] = var1;
               if(var1 != class165.widgetSettings[var2]) {
                  class165.widgetSettings[var2] = var1;
               }

               class139.method2577(var2);
               Client.field496[++Client.field476 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 159) {
               var1 = Client.field334.method3045();
               var16 = Client.field334.readString();
               var3 = ChatLineBuffer.method993(var1);
               if(!var16.equals(var3.text)) {
                  var3.text = var16;
                  ChatLineBuffer.method996(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 45) {
               var1 = Client.field334.readUnsignedByte();
               if(Client.field334.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field334.offset += 18;
               } else {
                  --Client.field334.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field334, false);
               }

               Client.field288 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 62) {
               var1 = Client.field334.method2932();
               var2 = Client.field334.method2939();
               var17 = Client.field334.method2925();
               var81 = ChatLineBuffer.method993(var1);
               if(var17 != var81.originalX || var2 != var81.originalY || var81.field2211 != 0 || var81.field2212 != 0) {
                  var81.originalX = var17;
                  var81.originalY = var2;
                  var81.field2211 = 0;
                  var81.field2212 = 0;
                  ChatLineBuffer.method996(var81);
                  class175.method3332(var81);
                  if(var81.type == 0) {
                     Script.method973(class231.widgets[var1 >> 16], var81, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var13;
            int var14;
            long var27;
            long var29;
            long var31;
            int var34;
            if(Client.packetOpcode == 243) {
               var15 = Client.field334.readString();
               var27 = (long)Client.field334.readUnsignedShort();
               var29 = (long)Client.field334.read24BitInt();
               class177 var86 = (class177)Ignore.method207(class0.method12(), Client.field334.readUnsignedByte());
               var31 = (var27 << 32) + var29;
               boolean var91 = false;

               for(var34 = 0; var34 < 100; ++var34) {
                  if(Client.field510[var34] == var31) {
                     var91 = true;
                     break;
                  }
               }

               if(Friend.method189(var15)) {
                  var91 = true;
               }

               if(!var91 && Client.field408 == 0) {
                  Client.field510[Client.field511] = var31;
                  Client.field511 = (Client.field511 + 1) % 100;
                  String var61 = FontTypeFace.method3949(Varbit.method3615(ChatMessages.method955(Client.field334)));
                  byte var65;
                  if(var86.field2669) {
                     var65 = 7;
                  } else {
                     var65 = 3;
                  }

                  if(var86.field2665 != -1) {
                     var14 = var86.field2665;
                     var13 = "<img=" + var14 + ">";
                     class88.sendGameMessage(var65, var13 + var15, var61);
                  } else {
                     class88.sendGameMessage(var65, var15, var61);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var64;
            if(Client.packetOpcode == 153) {
               var15 = Client.field334.readString();
               var27 = Client.field334.method2892();
               var29 = (long)Client.field334.readUnsignedShort();
               var22 = (long)Client.field334.read24BitInt();
               class177 var8 = (class177)Ignore.method207(class0.method12(), Client.field334.readUnsignedByte());
               var25 = var22 + (var29 << 32);
               var64 = false;

               for(int var12 = 0; var12 < 100; ++var12) {
                  if(Client.field510[var12] == var25) {
                     var64 = true;
                     break;
                  }
               }

               if(var8.field2670 && Friend.method189(var15)) {
                  var64 = true;
               }

               if(!var64 && Client.field408 == 0) {
                  Client.field510[Client.field511] = var25;
                  Client.field511 = (1 + Client.field511) % 100;
                  String var92 = FontTypeFace.method3949(Varbit.method3615(ChatMessages.method955(Client.field334)));
                  if(var8.field2665 != -1) {
                     var14 = var8.field2665;
                     var13 = "<img=" + var14 + ">";
                     CombatInfo1.addChatMessage(9, var13 + var15, var92, class99.method2037(var27));
                  } else {
                     CombatInfo1.addChatMessage(9, var15, var92, class99.method2037(var27));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 146) {
               Client.field459 = true;
               class157.field2116 = Client.field334.readUnsignedByte();
               class118.field1849 = Client.field334.readUnsignedByte();
               class6.field43 = Client.field334.readUnsignedShort();
               class13.field130 = Client.field334.readUnsignedByte();
               Overlay.field3052 = Client.field334.readUnsignedByte();
               if(Overlay.field3052 >= 100) {
                  FaceNormal.cameraX = class157.field2116 * 128 + 64;
                  ChatLineBuffer.cameraY = class118.field1849 * 128 + 64;
                  class45.cameraZ = class25.method615(FaceNormal.cameraX, ChatLineBuffer.cameraY, CollisionData.plane) - class6.field43;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 175) {
               ItemComposition.field3003 = class40.method829(Client.field334.readUnsignedByte());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 6) {
               var1 = Client.field334.method2923();
               var2 = Client.field334.readUnsignedShort();
               var17 = Client.field334.method2932();
               var81 = ChatLineBuffer.method993(var17);
               var81.field2324 = (var2 << 16) + var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 114) {
               class36.xteaChanged(true);
               Client.field334.method3158();
               var1 = Client.field334.readUnsignedShort();
               class18.method200(Client.field334, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 138) {
               var1 = Client.field334.readInt();
               var2 = Client.field334.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var3 = ChatLineBuffer.method993(var1);
               } else {
                  var3 = null;
               }

               for(; Client.field334.offset < Client.field335; class9.method112(var2, var51, var5 - 1, var6)) {
                  var51 = Client.field334.method3039();
                  var5 = Client.field334.readUnsignedShort();
                  var6 = 0;
                  if(var5 != 0) {
                     var6 = Client.field334.readUnsignedByte();
                     if(var6 == 255) {
                        var6 = Client.field334.readInt();
                     }
                  }

                  if(null != var3 && var51 >= 0 && var51 < var3.itemIds.length) {
                     var3.itemIds[var51] = var5;
                     var3.itemQuantities[var51] = var6;
                  }
               }

               if(var3 != null) {
                  ChatLineBuffer.method996(var3);
               }

               class146.method2815();
               Client.interfaceItemTriggers[++Client.field478 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 63) {
               class33.method776(false);
               Client.packetOpcode = -1;
               return true;
            }

            long var40;
            if(Client.packetOpcode == 180) {
               var1 = Client.field334.readInt();
               var2 = Client.field334.readInt();
               if(class99.field1652 == null || !class99.field1652.isValid()) {
                  try {
                     Iterator var54 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var54.hasNext()) {
                        GarbageCollectorMXBean var80 = (GarbageCollectorMXBean)var54.next();
                        if(var80.isValid()) {
                           class99.field1652 = var80;
                           Client.field568 = -1L;
                           Client.field567 = -1L;
                        }
                     }
                  } catch (Throwable var46) {
                     ;
                  }
               }

               long var36 = WallObject.method1985();
               var5 = -1;
               if(class99.field1652 != null) {
                  var22 = class99.field1652.getCollectionTime();
                  if(-1L != Client.field567) {
                     long var38 = var22 - Client.field567;
                     var40 = var36 - Client.field568;
                     if(var40 != 0L) {
                        var5 = (int)(var38 * 100L / var40);
                     }
                  }

                  Client.field567 = var22;
                  Client.field568 = var36;
               }

               Client.field332.method3144(59);
               Client.field332.method2930(var1);
               Client.field332.method2899(var2);
               Client.field332.method3091(var5);
               Client.field332.method3091(GameEngine.FPS);
               Client.packetOpcode = -1;
               return true;
            }

            String var49;
            boolean var90;
            if(Client.packetOpcode == 240) {
               while(Client.field334.offset < Client.field335) {
                  var50 = Client.field334.readUnsignedByte() == 1;
                  var16 = Client.field334.readString();
                  var49 = Client.field334.readString();
                  var51 = Client.field334.readUnsignedShort();
                  var5 = Client.field334.readUnsignedByte();
                  var6 = Client.field334.readUnsignedByte();
                  boolean var7 = (var6 & 2) != 0;
                  var90 = (var6 & 1) != 0;
                  if(var51 > 0) {
                     Client.field334.readString();
                     Client.field334.readUnsignedByte();
                     Client.field334.readInt();
                  }

                  Client.field334.readString();

                  for(int var33 = 0; var33 < Client.friendCount; ++var33) {
                     Friend var10 = Client.friends[var33];
                     if(!var50) {
                        if(var16.equals(var10.name)) {
                           if(var51 != var10.world) {
                              var64 = true;

                              for(class16 var35 = (class16)Client.field560.method2516(); null != var35; var35 = (class16)Client.field560.method2520()) {
                                 if(var35.field166.equals(var16)) {
                                    if(var51 != 0 && var35.field173 == 0) {
                                       var35.method2525();
                                       var64 = false;
                                    } else if(var51 == 0 && var35.field173 != 0) {
                                       var35.method2525();
                                       var64 = false;
                                    }
                                 }
                              }

                              if(var64) {
                                 Client.field560.method2515(new class16(var16, var51));
                              }

                              var10.world = var51;
                           }

                           var10.previousName = var49;
                           var10.rank = var5;
                           var10.field141 = var7;
                           var10.field142 = var90;
                           var16 = null;
                           break;
                        }
                     } else if(var49.equals(var10.name)) {
                        var10.name = var16;
                        var10.previousName = var49;
                        var16 = null;
                        break;
                     }
                  }

                  if(null != var16 && Client.friendCount < 400) {
                     Friend var59 = new Friend();
                     Client.friends[Client.friendCount] = var59;
                     var59.name = var16;
                     var59.previousName = var49;
                     var59.world = var51;
                     var59.rank = var5;
                     var59.field141 = var7;
                     var59.field142 = var90;
                     ++Client.friendCount;
                  }
               }

               Client.field558 = 2;
               Client.field482 = Client.field505;
               var50 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var50 = true;
                  --var2;

                  for(var17 = 0; var17 < var2; ++var17) {
                     var4 = false;
                     Friend var76 = Client.friends[var17];
                     Friend var84 = Client.friends[1 + var17];
                     if(var76.world != Client.world && Client.world == var84.world) {
                        var4 = true;
                     }

                     if(!var4 && var76.world == 0 && var84.world != 0) {
                        var4 = true;
                     }

                     if(!var4 && !var76.field141 && var84.field141) {
                        var4 = true;
                     }

                     if(!var4 && !var76.field142 && var84.field142) {
                        var4 = true;
                     }

                     if(var4) {
                        Friend var71 = Client.friends[var17];
                        Client.friends[var17] = Client.friends[1 + var17];
                        Client.friends[var17 + 1] = var71;
                        var50 = false;
                     }
                  }

                  if(var50) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 71) {
               Client.field304 = Client.field334.readUnsignedByte();
               if(Client.field304 == 1) {
                  Client.field305 = Client.field334.readUnsignedShort();
               }

               if(Client.field304 >= 2 && Client.field304 <= 6) {
                  if(Client.field304 == 2) {
                     Client.field310 = 64;
                     Client.field311 = 64;
                  }

                  if(Client.field304 == 3) {
                     Client.field310 = 0;
                     Client.field311 = 64;
                  }

                  if(Client.field304 == 4) {
                     Client.field310 = 128;
                     Client.field311 = 64;
                  }

                  if(Client.field304 == 5) {
                     Client.field310 = 64;
                     Client.field311 = 0;
                  }

                  if(Client.field304 == 6) {
                     Client.field310 = 64;
                     Client.field311 = 128;
                  }

                  Client.field304 = 2;
                  Client.field295 = Client.field334.readUnsignedShort();
                  Client.field382 = Client.field334.readUnsignedShort();
                  Client.field346 = Client.field334.readUnsignedByte();
               }

               if(Client.field304 == 10) {
                  Client.field562 = Client.field334.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 57) {
               while(Client.field334.offset < Client.field335) {
                  var1 = Client.field334.readUnsignedByte();
                  var52 = (var1 & 1) == 1;
                  var49 = Client.field334.readString();
                  String var20 = Client.field334.readString();
                  Client.field334.readString();

                  for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                     Ignore var21 = Client.ignores[var5];
                     if(var52) {
                        if(var20.equals(var21.name)) {
                           var21.name = var49;
                           var21.previousName = var20;
                           var49 = null;
                           break;
                        }
                     } else if(var49.equals(var21.name)) {
                        var21.name = var49;
                        var21.previousName = var20;
                        var49 = null;
                        break;
                     }
                  }

                  if(null != var49 && Client.ignoreCount < 400) {
                     Ignore var74 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var74;
                     var74.name = var49;
                     var74.previousName = var20;
                     ++Client.ignoreCount;
                  }
               }

               Client.field482 = Client.field505;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 208) {
               var1 = Client.field334.method3039();
               var52 = Client.field334.readUnsignedByte() == 1;
               var49 = "";
               var4 = false;
               if(var52) {
                  var49 = Client.field334.readString();
                  if(Friend.method189(var49)) {
                     var4 = true;
                  }
               }

               String var19 = Client.field334.readString();
               if(!var4) {
                  class88.sendGameMessage(var1, var49, var19);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 234) {
               var1 = Client.field334.method2923();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               class161.method3178(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 33) {
               var1 = Client.field334.readUnsignedShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field334.method2927();
               if(Client.field544 != 0 && var1 != -1) {
                  class44.method892(WidgetNode.field175, var1, 0, Client.field544, false);
                  Client.field439 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 124) {
               Client.field334.offset += 28;
               if(Client.field334.method2909()) {
                  class159 var66 = Client.field334;
                  var2 = Client.field334.offset - 28;
                  class97.method2026(var66.payload, var2);
                  if(class104.field1689 != null) {
                     try {
                        class104.field1689.method1464(0L);
                        class104.field1689.method1481(var66.payload, var2, 24);
                     } catch (Exception var45) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 55) {
               Client.field483 = Client.field505;
               if(Client.field335 == 0) {
                  Client.field516 = null;
                  Client.clanChatOwner = null;
                  class119.clanChatCount = 0;
                  Friend.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.clanChatOwner = Client.field334.readString();
               long var42 = Client.field334.method2892();
               var29 = var42;
               if(var42 > 0L && var42 < 6582952005840035281L) {
                  if(0L == var42 % 37L) {
                     var49 = null;
                  } else {
                     var6 = 0;

                     for(var31 = var42; 0L != var31; var31 /= 37L) {
                        ++var6;
                     }

                     StringBuilder var9 = new StringBuilder(var6);

                     while(var29 != 0L) {
                        var40 = var29;
                        var29 /= 37L;
                        var9.append(class205.field3095[(int)(var40 - 37L * var29)]);
                     }

                     var49 = var9.reverse().toString();
                  }
               } else {
                  var49 = null;
               }

               Client.field516 = var49;
               class32.field737 = Client.field334.readByte();
               var6 = Client.field334.readUnsignedByte();
               if(var6 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               class119.clanChatCount = var6;
               XClanMember[] var18 = new XClanMember[100];

               for(var24 = 0; var24 < class119.clanChatCount; ++var24) {
                  var18[var24] = new XClanMember();
                  var18[var24].username = Client.field334.readString();
                  var18[var24].field275 = class60.method1229(var18[var24].username, class149.field2037);
                  var18[var24].world = Client.field334.readUnsignedShort();
                  var18[var24].rank = Client.field334.readByte();
                  Client.field334.readString();
                  if(var18[var24].username.equals(WidgetNode.localPlayer.name)) {
                     Client.field518 = var18[var24].rank;
                  }
               }

               var90 = false;
               var34 = class119.clanChatCount;

               while(var34 > 0) {
                  var90 = true;
                  --var34;

                  for(int var11 = 0; var11 < var34; ++var11) {
                     if(var18[var11].field275.compareTo(var18[var11 + 1].field275) > 0) {
                        XClanMember var57 = var18[var11];
                        var18[var11] = var18[var11 + 1];
                        var18[var11 + 1] = var57;
                        var90 = false;
                     }
                  }

                  if(var90) {
                     break;
                  }
               }

               Friend.clanMembers = var18;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 219) {
               Client.field459 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field539[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 34) {
               var1 = Client.field334.method2932();
               var2 = Client.field334.method2922();
               var3 = ChatLineBuffer.method993(var1);
               if(null != var3 && var3.type == 0) {
                  if(var2 > var3.scrollHeight - var3.height) {
                     var2 = var3.scrollHeight - var3.height;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var2 != var3.scrollY) {
                     var3.scrollY = var2;
                     ChatLineBuffer.method996(var3);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            class97.method2025("" + Client.packetOpcode + "," + Client.field340 + "," + Client.field341 + "," + Client.field335, (Throwable)null);
            class33.method773();
         } catch (IOException var47) {
            if(Client.field342 > 0) {
               class33.method773();
            } else {
               World.setGameState(40);
               class22.field236 = XGrandExchangeOffer.field30;
               XGrandExchangeOffer.field30 = null;
            }
         } catch (Exception var48) {
            var15 = "" + Client.packetOpcode + "," + Client.field340 + "," + Client.field341 + "," + Client.field335 + "," + (WidgetNode.localPlayer.pathX[0] + Player.baseX) + "," + (SecondaryBufferProvider.baseY + WidgetNode.localPlayer.pathY[0]) + ",";

            for(var2 = 0; var2 < Client.field335 && var2 < 50; ++var2) {
               var15 = var15 + Client.field334.payload[var2] + ",";
            }

            class97.method2025(var15, var48);
            class33.method773();
         }

         return true;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1953698982"
   )
   public static boolean method2136(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
