import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public final class class166 {
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2060996572"
   )
   static final boolean method3350() {
      if(null == class40.field904) {
         return false;
      } else {
         int var0;
         String var1;
         try {
            int var2 = class40.field904.method3141();
            if(var2 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class40.field904.method3132(Client.field339.payload, 0, 1);
               Client.field339.offset = 0;
               Client.packetOpcode = Client.field339.method2898();
               Client.field340 = class191.field3098[Client.packetOpcode];
               --var2;
            }

            if(Client.field340 == -1) {
               if(var2 <= 0) {
                  return false;
               }

               class40.field904.method3132(Client.field339.payload, 0, 1);
               Client.field340 = Client.field339.payload[0] & 255;
               --var2;
            }

            if(Client.field340 == -2) {
               if(var2 <= 1) {
                  return false;
               }

               class40.field904.method3132(Client.field339.payload, 0, 2);
               Client.field339.offset = 0;
               Client.field340 = Client.field339.method2635();
               var2 -= 2;
            }

            if(var2 < Client.field340) {
               return false;
            }

            Client.field339.offset = 0;
            class40.field904.method3132(Client.field339.payload, 0, Client.field340);
            Client.field378 = 0;
            Client.field311 = Client.field345;
            Client.field345 = Client.field344 * -1;
            Client.field344 = Client.packetOpcode * -1;
            int var3;
            if(Client.packetOpcode == 192) {
               KitDefinition.field1064 = Client.field339.method2837();
               class4.field72 = Client.field339.method2837();

               for(var3 = class4.field72; var3 < 8 + class4.field72; ++var3) {
                  for(var0 = KitDefinition.field1064; var0 < 8 + KitDefinition.field1064; ++var0) {
                     if(null != Client.groundItemDeque[VertexNormal.plane][var3][var0]) {
                        Client.groundItemDeque[VertexNormal.plane][var3][var0] = null;
                        class144.groundItemSpawned(var3, var0);
                     }
                  }
               }

               for(class16 var50 = (class16)Client.field427.method3980(); null != var50; var50 = (class16)Client.field427.method3970()) {
                  if(var50.field238 >= class4.field72 && var50.field238 < class4.field72 + 8 && var50.field231 >= KitDefinition.field1064 && var50.field231 < 8 + KitDefinition.field1064 && VertexNormal.plane == var50.field239) {
                     var50.field237 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 141) {
               Client.field312 = Client.field339.method2749() * 30;
               Client.field490 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            int var4;
            Widget var5;
            if(Client.packetOpcode == 71) {
               var3 = Client.field339.method2678();
               var5 = class134.method2983(var3);

               for(var4 = 0; var4 < var5.itemIds.length; ++var4) {
                  var5.itemIds[var4] = -1;
                  var5.itemIds[var4] = 0;
               }

               class79.method1777(var5);
               Client.packetOpcode = -1;
               return true;
            }

            int var6;
            Widget var7;
            if(Client.packetOpcode == 128) {
               var3 = Client.field339.method2803();
               var0 = Client.field339.method2803();
               var4 = Client.field339.method2680();
               var6 = Client.field339.method2803();
               var7 = class134.method2983(var4);
               if(var7.rotationX != var0 || var3 != var7.rotationZ || var6 != var7.field2933) {
                  var7.rotationX = var0;
                  var7.rotationZ = var3;
                  var7.field2933 = var6;
                  class79.method1777(var7);
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var8;
            if(Client.packetOpcode == 52) {
               var3 = Client.field339.method2837();
               var8 = Client.field339.method2663();
               var4 = Client.field339.method2662();
               if(var3 >= 1 && var3 <= 8) {
                  if(var8.equalsIgnoreCase("null")) {
                     var8 = null;
                  }

                  Client.field422[var3 - 1] = var8;
                  Client.field423[var3 - 1] = var4 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 119) {
               Client.field562 = 1;
               Client.field385 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 105 || Client.packetOpcode == 15 || Client.packetOpcode == 38 || Client.packetOpcode == 205 || Client.packetOpcode == 199 || Client.packetOpcode == 249 || Client.packetOpcode == 152 || Client.packetOpcode == 24 || Client.packetOpcode == 33 || Client.packetOpcode == 19) {
               Projectile.method104();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 59) {
               class9.method125();
               var3 = Client.field339.method2620();
               var0 = Client.field339.method2662();
               var4 = Client.field339.method2837();
               Client.skillExperiences[var0] = var3;
               Client.boostedSkillLevels[var0] = var4;
               Client.realSkillLevels[var0] = 1;

               for(var6 = 0; var6 < 98; ++var6) {
                  if(var3 >= class158.field2358[var6]) {
                     Client.realSkillLevels[var0] = var6 + 2;
                  }
               }

               Client.field483[++Client.field328 - 1 & 31] = var0;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var9;
            if(Client.packetOpcode == 64) {
               var3 = Client.field339.method2674();
               var0 = Client.field339.method2680();
               var4 = Client.field339.method2636();
               var9 = class134.method2983(var0);
               if(var4 != var9.field2816 || var9.field2941 != var3 || var9.field2812 != 0 || var9.field2925 != 0) {
                  var9.field2816 = var4;
                  var9.field2941 = var3;
                  var9.field2812 = 0;
                  var9.field2925 = 0;
                  class79.method1777(var9);
                  class8.method117(var9);
                  if(var9.type == 0) {
                     class53.method1145(Widget.widgets[var0 >> 16], var9, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 121) {
               Client.field542 = true;
               WidgetNode.field63 = Client.field339.method2633();
               ItemLayer.field1756 = Client.field339.method2633();
               class77.field1443 = Client.field339.method2635();
               class165.field2706 = Client.field339.method2633();
               class152.field2303 = Client.field339.method2633();
               if(class152.field2303 >= 100) {
                  class151.cameraX = WidgetNode.field63 * 128 + 64;
                  GroundObject.cameraY = 64 + ItemLayer.field1756 * 128;
                  class8.cameraZ = class127.method2936(class151.cameraX, GroundObject.cameraY, VertexNormal.plane) - class77.field1443;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 227) {
               method3366(true);
               Client.packetOpcode = -1;
               return true;
            }

            int var10;
            Object var11;
            int var12;
            int var13;
            Widget var14;
            if(Client.packetOpcode == 130) {
               var3 = Client.field339.method2620();
               var0 = Client.field339.method2635();
               if(var3 < -70000) {
                  var0 += '耀';
               }

               if(var3 >= 0) {
                  var14 = class134.method2983(var3);
               } else {
                  var14 = null;
               }

               var11 = null;
               class134.method2977(var0);
               var6 = Client.field339.method2635();

               for(var12 = 0; var12 < var6; ++var12) {
                  var13 = Client.field339.method2635();
                  var10 = Client.field339.method2633();
                  if(var10 == 255) {
                     var10 = Client.field339.method2620();
                  }

                  if(var14 != null && var12 < var14.itemIds.length) {
                     var14.itemIds[var12] = var13;
                     var14.itemQuantities[var12] = var10;
                  }

                  class34.method754(var0, var12, var13 - 1, var10);
               }

               if(var14 != null) {
                  class79.method1777(var14);
               }

               class9.method125();
               Client.field481[++Client.field482 - 1 & 31] = var0 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 43) {
               var3 = Client.field339.method2620();
               var5 = class134.method2983(var3);
               var5.modelType = 3;
               var5.modelId = WidgetNode.localPlayer.composition.method3642();
               class79.method1777(var5);
               Client.packetOpcode = -1;
               return true;
            }

            int var15;
            long var16;
            WidgetNode var18;
            if(Client.packetOpcode == 44) {
               var3 = Client.field339.offset + Client.field340;
               var0 = Client.field339.method2635();
               var4 = Client.field339.method2635();
               if(Client.widgetRoot != var0) {
                  Client.widgetRoot = var0;
                  var6 = Client.widgetRoot;
                  var12 = class189.field3056;
                  var13 = Actor.field892;
                  if(class14.method179(var6)) {
                     class0.method2(Widget.widgets[var6], -1, var12, var13, false);
                  }

                  WidgetNode.method43(Client.widgetRoot);
                  ItemLayer.method2291(Client.widgetRoot);

                  for(var6 = 0; var6 < 100; ++var6) {
                     Client.field498[var6] = true;
                  }
               }

               WidgetNode var51;
               for(; var4-- > 0; var51.field61 = true) {
                  var6 = Client.field339.method2620();
                  var12 = Client.field339.method2635();
                  var13 = Client.field339.method2633();
                  var51 = (WidgetNode)Client.componentTable.method3936((long)var6);
                  if(null != var51 && var51.id != var12) {
                     class145.method3130(var51, true);
                     var51 = null;
                  }

                  if(null == var51) {
                     var51 = WidgetNode.method42(var6, var12, var13);
                  }
               }

               for(var18 = (WidgetNode)Client.componentTable.method3939(); null != var18; var18 = (WidgetNode)Client.componentTable.method3935()) {
                  if(var18.field61) {
                     var18.field61 = false;
                  } else {
                     class145.method3130(var18, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field339.offset < var3) {
                  var6 = Client.field339.method2620();
                  var12 = Client.field339.method2635();
                  var13 = Client.field339.method2635();
                  var10 = Client.field339.method2620();

                  for(var15 = var12; var15 <= var13; ++var15) {
                     var16 = (long)var15 + ((long)var6 << 32);
                     Client.widgetFlags.method3940(new class204(var10), var16);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 138) {
               class9.method125();
               Client.energy = Client.field339.method2633();
               Client.field490 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 80) {
               Widget.method3561(Client.field339, Client.field340);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 161) {
               var3 = Client.field339.method2635();
               var0 = Client.field339.method2633();
               var4 = Client.field339.method2635();
               if(Client.field403 != 0 && var0 != 0 && Client.field536 < 50) {
                  Client.field319[Client.field536] = var3;
                  Client.field538[Client.field536] = var0;
                  Client.field539[Client.field536] = var4;
                  Client.field541[Client.field536] = null;
                  Client.field528[Client.field536] = 0;
                  ++Client.field536;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 158) {
               Client.field313 = Client.field339.method2633();
               if(Client.field313 == 1) {
                  Client.field314 = Client.field339.method2635();
               }

               if(Client.field313 >= 2 && Client.field313 <= 6) {
                  if(Client.field313 == 2) {
                     Client.field375 = 64;
                     Client.field384 = 64;
                  }

                  if(Client.field313 == 3) {
                     Client.field375 = 0;
                     Client.field384 = 64;
                  }

                  if(Client.field313 == 4) {
                     Client.field375 = 128;
                     Client.field384 = 64;
                  }

                  if(Client.field313 == 5) {
                     Client.field375 = 64;
                     Client.field384 = 0;
                  }

                  if(Client.field313 == 6) {
                     Client.field375 = 64;
                     Client.field384 = 128;
                  }

                  Client.field313 = 2;
                  Client.field316 = Client.field339.method2635();
                  Client.field317 = Client.field339.method2635();
                  Client.field517 = Client.field339.method2633();
               }

               if(Client.field313 == 10) {
                  Client.field315 = Client.field339.method2635();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 6) {
               var1 = Client.field339.method2663();
               var0 = Client.field339.method2680();
               var14 = class134.method2983(var0);
               if(!var1.equals(var14.text)) {
                  var14.text = var1;
                  class79.method1777(var14);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 34) {
               Player.xteaChanged(false);
               Client.field339.method2898();
               var3 = Client.field339.method2635();
               Widget.method3561(Client.field339, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 104) {
               Client.field542 = false;

               for(var3 = 0; var3 < 5; ++var3) {
                  Client.field331[var3] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            Iterator var19;
            boolean var20;
            String var21;
            String var22;
            if(Client.packetOpcode == 222) {
               for(; Client.field339.offset < Client.field340; var11 = null) {
                  var3 = Client.field339.method2633();
                  var20 = (var3 & 1) == 1;
                  var22 = Client.field339.method2663();
                  var21 = Client.field339.method2663();
                  Client.field339.method2663();

                  for(var12 = 0; var12 < Client.ignoreCount; ++var12) {
                     Ignore var53 = Client.ignores[var12];
                     if(var20) {
                        if(var21.equals(var53.name)) {
                           var53.name = var22;
                           var53.previousName = var21;
                           var19 = null;
                           break;
                        }
                     } else if(var22.equals(var53.name)) {
                        var53.name = var22;
                        var53.previousName = var21;
                        var19 = null;
                        break;
                     }
                  }
               }

               Client.field385 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 183) {
               var1 = Client.field339.method2663();
               Object[] var52 = new Object[var1.length() + 1];

               for(var4 = var1.length() - 1; var4 >= 0; --var4) {
                  if(var1.charAt(var4) == 115) {
                     var52[1 + var4] = Client.field339.method2663();
                  } else {
                     var52[1 + var4] = new Integer(Client.field339.method2620());
                  }
               }

               var52[0] = new Integer(Client.field339.method2620());
               class0 var59 = new class0();
               var59.field8 = var52;
               class16.method203(var59);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 39) {
               method3366(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 77) {
               var3 = Client.field339.method2670();
               Ignore.method111(var3);
               Client.field481[++Client.field482 - 1 & 31] = var3 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 174) {
               var3 = Client.field339.method2620();
               var0 = Client.field339.method2635();
               var14 = class134.method2983(var3);
               if(null != var14 && var14.type == 0) {
                  if(var0 > var14.scrollHeight - var14.height) {
                     var0 = var14.scrollHeight - var14.height;
                  }

                  if(var0 < 0) {
                     var0 = 0;
                  }

                  if(var0 != var14.scrollY) {
                     var14.scrollY = var0;
                     class79.method1777(var14);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var23;
            if(Client.packetOpcode == 241) {
               var23 = Client.field339.method2633() == 1;
               if(var23) {
                  World.field677 = class56.method1249() - Client.field339.method2649();
                  class162.field2659 = new class224(Client.field339, true);
               } else {
                  class162.field2659 = null;
               }

               Client.field416 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 118) {
               if(Client.widgetRoot != -1) {
                  var3 = Client.widgetRoot;
                  if(class14.method179(var3)) {
                     class9.method134(Widget.widgets[var3], 0);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var24;
            if(Client.packetOpcode == 17) {
               var3 = Client.field339.method2646();
               var20 = Client.field339.method2633() == 1;
               var22 = "";
               var24 = false;
               if(var20) {
                  var22 = Client.field339.method2663();
                  if(class107.method2395(var22)) {
                     var24 = true;
                  }
               }

               String var54 = Client.field339.method2663();
               if(!var24) {
                  SecondaryBufferProvider.sendGameMessage(var3, var22, var54);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 31) {
               var3 = Client.field339.method2633();
               if(Client.field339.method2633() == 0) {
                  Client.grandExchangeOffers[var3] = new XGrandExchangeOffer();
                  Client.field339.offset += 18;
               } else {
                  --Client.field339.offset;
                  Client.grandExchangeOffers[var3] = new XGrandExchangeOffer(Client.field339, false);
               }

               Client.field488 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var25;
            if(Client.packetOpcode == 123) {
               var1 = Client.field339.method2663();
               var0 = Client.field339.method2635();
               byte var58 = Client.field339.method2634();
               var24 = false;
               if(var58 == -128) {
                  var24 = true;
               }

               if(var24) {
                  if(Client.field522 == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var25 = false;

                  for(var12 = 0; var12 < Client.field522 && (!class4.clanMembers[var12].username.equals(var1) || class4.clanMembers[var12].world != var0); ++var12) {
                     ;
                  }

                  if(var12 < Client.field522) {
                     while(var12 < Client.field522 - 1) {
                        class4.clanMembers[var12] = class4.clanMembers[var12 + 1];
                        ++var12;
                     }

                     --Client.field522;
                     class4.clanMembers[Client.field522] = null;
                  }
               } else {
                  Client.field339.method2663();
                  XClanMember var56 = new XClanMember();
                  var56.username = var1;
                  var56.field639 = class156.method3300(var56.username, Client.field518);
                  var56.world = var0;
                  var56.rank = var58;

                  for(var13 = Client.field522 - 1; var13 >= 0; --var13) {
                     var10 = class4.clanMembers[var13].field639.compareTo(var56.field639);
                     if(var10 == 0) {
                        class4.clanMembers[var13].world = var0;
                        class4.clanMembers[var13].rank = var58;
                        if(var1.equals(WidgetNode.localPlayer.name)) {
                           Item.field710 = var58;
                        }

                        Client.field487 = Client.field478;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var10 < 0) {
                        break;
                     }
                  }

                  if(Client.field522 >= class4.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var10 = Client.field522 - 1; var10 > var13; --var10) {
                     class4.clanMembers[1 + var10] = class4.clanMembers[var10];
                  }

                  if(Client.field522 == 0) {
                     class4.clanMembers = new XClanMember[100];
                  }

                  class4.clanMembers[1 + var13] = var56;
                  ++Client.field522;
                  if(var1.equals(WidgetNode.localPlayer.name)) {
                     Item.field710 = var58;
                  }
               }

               Client.field487 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 48) {
               var3 = Client.field339.method2620();
               var0 = Client.field339.method2635();
               if(var3 < -70000) {
                  var0 += '耀';
               }

               if(var3 >= 0) {
                  var14 = class134.method2983(var3);
               } else {
                  var14 = null;
               }

               for(; Client.field339.offset < Client.field340; class34.method754(var0, var6, var12 - 1, var13)) {
                  var6 = Client.field339.method2646();
                  var12 = Client.field339.method2635();
                  var13 = 0;
                  if(var12 != 0) {
                     var13 = Client.field339.method2633();
                     if(var13 == 255) {
                        var13 = Client.field339.method2620();
                     }
                  }

                  if(var14 != null && var6 >= 0 && var6 < var14.itemIds.length) {
                     var14.itemIds[var6] = var12;
                     var14.itemQuantities[var6] = var13;
                  }
               }

               if(var14 != null) {
                  class79.method1777(var14);
               }

               class9.method125();
               Client.field481[++Client.field482 - 1 & 31] = var0 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 21) {
               class4.field72 = Client.field339.method2837();
               KitDefinition.field1064 = Client.field339.method2837();

               while(Client.field339.offset < Client.field340) {
                  Client.packetOpcode = Client.field339.method2633();
                  Projectile.method104();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 29) {
               var3 = Client.field339.method2636();
               var0 = Client.field339.method2620();
               var14 = class134.method2983(var0);
               if(var3 != var14.field2854 || var3 == -1) {
                  var14.field2854 = var3;
                  var14.field2929 = 0;
                  var14.field2930 = 0;
                  class79.method1777(var14);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 86) {
               class129.method2964();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 76) {
               var3 = Client.field339.method2749();
               var0 = Client.field339.method2799();
               var14 = class134.method2983(var0);
               if(var14.modelType != 2 || var14.modelId != var3) {
                  var14.modelType = 2;
                  var14.modelId = var3;
                  class79.method1777(var14);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 57) {
               var0 = Client.field339.method2633();
               class133[] var57 = new class133[]{class133.field2110, class133.field2108, class133.field2107};
               class133[] var27 = var57;
               var12 = 0;

               class133 var61;
               while(true) {
                  if(var12 >= var27.length) {
                     var61 = null;
                     break;
                  }

                  class133 var60 = var27[var12];
                  if(var0 == var60.field2109) {
                     var61 = var60;
                     break;
                  }

                  ++var12;
               }

               ChatLineBuffer.field706 = var61;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 106) {
               var3 = Client.field339.method2635();
               Client.widgetRoot = var3;
               var0 = Client.widgetRoot;
               var4 = class189.field3056;
               var6 = Actor.field892;
               if(class14.method179(var0)) {
                  class0.method2(Widget.widgets[var0], -1, var4, var6, false);
               }

               WidgetNode.method43(var3);
               ItemLayer.method2291(Client.widgetRoot);

               for(var0 = 0; var0 < 100; ++var0) {
                  Client.field498[var0] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 233) {
               World var55 = new World();
               var55.address = Client.field339.method2663();
               var55.id = Client.field339.method2635();
               var0 = Client.field339.method2620();
               var55.mask = var0;
               class138.setGameState(45);
               class40.field904.method3131();
               class40.field904 = null;
               class157.selectWorld(var55);
               Client.packetOpcode = -1;
               return false;
            }

            long var26;
            boolean var28;
            long var29;
            long var31;
            class125 var65;
            int var76;
            if(Client.packetOpcode == 14) {
               var1 = Client.field339.method2663();
               var31 = Client.field339.method2649();
               var29 = (long)Client.field339.method2635();
               var26 = (long)Client.field339.method2637();
               class155 var63 = (class155)class85.method1971(class128.method2954(), Client.field339.method2633());
               var16 = var26 + (var29 << 32);
               var28 = false;

               for(int var83 = 0; var83 < 100; ++var83) {
                  if(Client.field514[var83] == var16) {
                     var28 = true;
                     break;
                  }
               }

               if(var63.field2330 && class107.method2395(var1)) {
                  var28 = true;
               }

               if(!var28 && Client.field564 == 0) {
                  Client.field514[Client.field515] = var16;
                  Client.field515 = (Client.field515 + 1) % 100;
                  var65 = Client.field339;

                  String var72;
                  try {
                     var76 = var65.method2646();
                     if(var76 > 32767) {
                        var76 = 32767;
                     }

                     byte[] var85 = new byte[var76];
                     var65.offset += class225.field3227.method2558(var65.payload, var65.offset, var85, 0, var76);
                     String var88 = NPC.method763(var85, 0, var76);
                     var72 = var88;
                  } catch (Exception var46) {
                     var72 = "Cabbage";
                  }

                  var72 = class226.method4169(class43.method906(var72));
                  if(var63.field2325 != -1) {
                     Projectile.addChatMessage(9, XClanMember.method615(var63.field2325) + var1, var72, class33.method701(var31));
                  } else {
                     Projectile.addChatMessage(9, var1, var72, class33.method701(var31));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 194) {
               var3 = Client.field339.method2803();
               var0 = Client.field339.method2620();
               var4 = var3 >> 10 & 31;
               var6 = var3 >> 5 & 31;
               var12 = var3 & 31;
               var13 = (var12 << 3) + (var6 << 11) + (var4 << 19);
               Widget var62 = class134.method2983(var0);
               if(var13 != var62.textColor) {
                  var62.textColor = var13;
                  class79.method1777(var62);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 25) {
               var3 = Client.field339.method2620();
               FrameMap.field1834 = class125.field2070.method3046(var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 155) {
               class141.method3076(Client.field339.method2663());
               Client.packetOpcode = -1;
               return true;
            }

            class56 var33;
            if(Client.packetOpcode == 242) {
               while(true) {
                  while(Client.field339.offset < Client.field340) {
                     var23 = Client.field339.method2633() == 1;
                     var8 = Client.field339.method2663();
                     var22 = Client.field339.method2663();
                     var6 = Client.field339.method2635();
                     var12 = Client.field339.method2633();
                     var13 = Client.field339.method2633();
                     boolean var80 = (var13 & 2) != 0;
                     boolean var68 = (var13 & 1) != 0;
                     if(var6 > 0) {
                        Client.field339.method2663();
                        Client.field339.method2633();
                        Client.field339.method2620();
                     }

                     Client.field339.method2663();

                     for(var76 = 0; var76 < Client.friendCount; ++var76) {
                        Friend var84 = Client.friends[var76];
                        if(!var23) {
                           if(var8.equals(var84.name)) {
                              if(var6 != var84.world) {
                                 var28 = true;
                                 class40 var87 = (class40)Client.field351.method3928();

                                 while(true) {
                                    if(null == var87) {
                                       if(var28) {
                                          Client.field351.method3926(new class40(var8, var6));
                                       }

                                       var84.world = var6;
                                       break;
                                    }

                                    if(var87.field895.equals(var8)) {
                                       if(var6 != 0 && var87.field896 == 0) {
                                          var87.method4063();
                                          var28 = false;
                                       } else if(var6 == 0 && var87.field896 != 0) {
                                          var87.method4063();
                                          var28 = false;
                                       }
                                    }

                                    var87 = (class40)Client.field351.method3933();
                                 }
                              }

                              var84.previousName = var22;
                              var84.rank = var12;
                              var84.field249 = var80;
                              var84.field252 = var68;
                              var33 = null;
                              break;
                           }
                        } else if(var22.equals(var84.name)) {
                           var84.name = var8;
                           var84.previousName = var22;
                           var33 = null;
                           break;
                        }
                     }
                  }

                  Client.field562 = 2;
                  Client.field385 = Client.field478;
                  var23 = false;
                  var0 = Client.friendCount;

                  while(var0 > 0) {
                     var23 = true;
                     --var0;

                     for(var4 = 0; var4 < var0; ++var4) {
                        var24 = false;
                        Friend var81 = Client.friends[var4];
                        Friend var70 = Client.friends[var4 + 1];
                        if(var81.world != Client.world && var70.world == Client.world) {
                           var24 = true;
                        }

                        if(!var24 && var81.world == 0 && var70.world != 0) {
                           var24 = true;
                        }

                        if(!var24 && !var81.field249 && var70.field249) {
                           var24 = true;
                        }

                        if(!var24 && !var81.field252 && var70.field252) {
                           var24 = true;
                        }

                        if(var24) {
                           Friend var79 = Client.friends[var4];
                           Client.friends[var4] = Client.friends[1 + var4];
                           Client.friends[var4 + 1] = var79;
                           var23 = false;
                        }
                     }

                     if(var23) {
                        break;
                     }
                  }

                  Client.packetOpcode = -1;
                  return true;
               }
            }

            WidgetNode var69;
            if(Client.packetOpcode == 10) {
               var3 = Client.field339.method2799();
               var0 = Client.field339.method2799();
               var69 = (WidgetNode)Client.componentTable.method3936((long)var3);
               var18 = (WidgetNode)Client.componentTable.method3936((long)var0);
               if(null != var18) {
                  class145.method3130(var18, null == var69 || var18.id != var69.id);
               }

               if(null != var69) {
                  var69.unlink();
                  Client.componentTable.method3940(var69, (long)var0);
               }

               var7 = class134.method2983(var3);
               if(null != var7) {
                  class79.method1777(var7);
               }

               var7 = class134.method2983(var0);
               if(var7 != null) {
                  class79.method1777(var7);
                  class53.method1145(Widget.widgets[var7.id >>> 16], var7, true);
               }

               if(Client.widgetRoot != -1) {
                  var13 = Client.widgetRoot;
                  if(class14.method179(var13)) {
                     class9.method134(Widget.widgets[var13], 1);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 193) {
               var3 = Client.field339.method2633();
               var0 = Client.field339.method2633();
               var4 = Client.field339.method2633();
               var6 = Client.field339.method2633();
               Client.field331[var3] = true;
               Client.field544[var3] = var0;
               Client.field393[var3] = var4;
               Client.field546[var3] = var6;
               Client.field547[var3] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 136) {
               var1 = Client.field339.method2663();
               var65 = Client.field339;

               try {
                  var12 = var65.method2646();
                  if(var12 > 32767) {
                     var12 = 32767;
                  }

                  byte[] var67 = new byte[var12];
                  var65.offset += class225.field3227.method2558(var65.payload, var65.offset, var67, 0, var12);
                  String var74 = NPC.method763(var67, 0, var12);
                  var21 = var74;
               } catch (Exception var45) {
                  var21 = "Cabbage";
               }

               var21 = class226.method4169(class43.method906(var21));
               SecondaryBufferProvider.sendGameMessage(6, var1, var21);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 202) {
               var3 = Client.field339.method2749();
               var0 = Client.field339.method2678();
               var4 = Client.field339.method2749();
               var9 = class134.method2983(var0);
               var9.field2863 = (var4 << 16) + var3;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 145) {
               Projectile.method97();

               for(var3 = 0; var3 < 2048; ++var3) {
                  Client.cachedPlayers[var3] = null;
               }

               Item.method685(Client.field339);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 66) {
               for(var3 = 0; var3 < Client.cachedPlayers.length; ++var3) {
                  if(null != Client.cachedPlayers[var3]) {
                     Client.cachedPlayers[var3].animation = -1;
                  }
               }

               for(var3 = 0; var3 < Client.cachedNPCs.length; ++var3) {
                  if(Client.cachedNPCs[var3] != null) {
                     Client.cachedNPCs[var3].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 98) {
               Client.field530 = Client.field339.method2633();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 3) {
               var1 = Client.field339.method2663();
               var31 = (long)Client.field339.method2635();
               var29 = (long)Client.field339.method2637();
               class155 var77 = (class155)class85.method1971(class128.method2954(), Client.field339.method2633());
               long var35 = var29 + (var31 << 32);
               boolean var78 = false;

               for(int var82 = 0; var82 < 100; ++var82) {
                  if(var35 == Client.field514[var82]) {
                     var78 = true;
                     break;
                  }
               }

               if(class107.method2395(var1)) {
                  var78 = true;
               }

               if(!var78 && Client.field564 == 0) {
                  Client.field514[Client.field515] = var35;
                  Client.field515 = (Client.field515 + 1) % 100;
                  class125 var86 = Client.field339;

                  String var39;
                  try {
                     int var40 = var86.method2646();
                     if(var40 > 32767) {
                        var40 = 32767;
                     }

                     byte[] var41 = new byte[var40];
                     var86.offset += class225.field3227.method2558(var86.payload, var86.offset, var41, 0, var40);
                     String var42 = NPC.method763(var41, 0, var40);
                     var39 = var42;
                  } catch (Exception var44) {
                     var39 = "Cabbage";
                  }

                  var39 = class226.method4169(class43.method906(var39));
                  byte var89;
                  if(var77.field2329) {
                     var89 = 7;
                  } else {
                     var89 = 3;
                  }

                  if(var77.field2325 != -1) {
                     SecondaryBufferProvider.sendGameMessage(var89, XClanMember.method615(var77.field2325) + var1, var39);
                  } else {
                     SecondaryBufferProvider.sendGameMessage(var89, var1, var39);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 162) {
               Client.flagX = Client.field339.method2633();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field339.method2633();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 244) {
               var3 = Client.field339.method2803();
               var0 = Client.field339.method2799();
               var14 = class134.method2983(var0);
               if(var14.modelType != 1 || var3 != var14.modelId) {
                  var14.modelType = 1;
                  var14.modelId = var3;
                  class79.method1777(var14);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 143) {
               var3 = Client.field339.method2670();
               byte var75 = Client.field339.method2634();
               class179.settings[var3] = var75;
               if(var75 != class179.widgetSettings[var3]) {
                  class179.widgetSettings[var3] = var75;
               }

               ClassInfo.method4080(var3);
               Client.field479[++Client.field366 - 1 & 31] = var3;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 28) {
               for(var3 = 0; var3 < class179.widgetSettings.length; ++var3) {
                  if(class179.settings[var3] != class179.widgetSettings[var3]) {
                     class179.widgetSettings[var3] = class179.settings[var3];
                     ClassInfo.method4080(var3);
                     Client.field479[++Client.field366 - 1 & 31] = var3;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 75) {
               var3 = Client.field339.method2633();
               var0 = Client.field339.method2678();
               var4 = Client.field339.method2749();
               var18 = (WidgetNode)Client.componentTable.method3936((long)var0);
               if(null != var18) {
                  class145.method3130(var18, var18.id != var4);
               }

               WidgetNode.method42(var0, var4, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 211) {
               var3 = Client.field339.method2678();
               var0 = Client.field339.method2680();
               var4 = Client.field339.method2803();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var9 = class134.method2983(var0);
               ItemComposition var71;
               if(!var9.field2855) {
                  if(var4 == -1) {
                     var9.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var71 = class1.getItemDefinition(var4);
                  var9.modelType = 4;
                  var9.modelId = var4;
                  var9.rotationX = var71.field1188;
                  var9.rotationZ = var71.field1193;
                  var9.field2933 = var71.field1191 * 100 / var3;
                  class79.method1777(var9);
               } else {
                  var9.item = var4;
                  var9.stackSize = var3;
                  var71 = class1.getItemDefinition(var4);
                  var9.rotationX = var71.field1188;
                  var9.rotationZ = var71.field1193;
                  var9.rotationY = var71.field1194;
                  var9.field2856 = var71.field1179;
                  var9.field2857 = var71.field1196;
                  var9.field2933 = var71.field1191;
                  if(var71.isStackable == 1) {
                     var9.field2865 = 1;
                  } else {
                     var9.field2865 = 2;
                  }

                  if(var9.field2862 > 0) {
                     var9.field2933 = var9.field2933 * 32 / var9.field2862;
                  } else if(var9.field2818 > 0) {
                     var9.field2933 = var9.field2933 * 32 / var9.field2818;
                  }

                  class79.method1777(var9);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 68) {
               class9.method125();
               Client.weight = Client.field339.method2636();
               Client.field490 = Client.field478;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 180) {
               var3 = Client.field339.method2670();
               var0 = Client.field339.method2620();
               class179.settings[var3] = var0;
               if(class179.widgetSettings[var3] != var0) {
                  class179.widgetSettings[var3] = var0;
               }

               ClassInfo.method4080(var3);
               Client.field479[++Client.field366 - 1 & 31] = var3;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 13) {
               var3 = Client.field339.method2620();
               var69 = (WidgetNode)Client.componentTable.method3936((long)var3);
               if(null != var69) {
                  class145.method3130(var69, true);
               }

               if(null != Client.field376) {
                  class79.method1777(Client.field376);
                  Client.field376 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var64;
            if(Client.packetOpcode == 41) {
               Client.field487 = Client.field478;
               if(Client.field340 == 0) {
                  Client.field363 = null;
                  Client.field521 = null;
                  Client.field522 = 0;
                  class4.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.field521 = Client.field339.method2663();
               var64 = Client.field339.method2649();
               Client.field363 = class132.method2974(var64);
               class178.field2952 = Client.field339.method2634();
               var4 = Client.field339.method2633();
               if(var4 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.field522 = var4;
               XClanMember[] var73 = new XClanMember[100];

               for(var12 = 0; var12 < Client.field522; ++var12) {
                  var73[var12] = new XClanMember();
                  var73[var12].username = Client.field339.method2663();
                  var73[var12].field639 = class156.method3300(var73[var12].username, Client.field518);
                  var73[var12].world = Client.field339.method2635();
                  var73[var12].rank = Client.field339.method2634();
                  Client.field339.method2663();
                  if(var73[var12].username.equals(WidgetNode.localPlayer.name)) {
                     Item.field710 = var73[var12].rank;
                  }
               }

               var25 = false;
               var10 = Client.field522;

               while(var10 > 0) {
                  var25 = true;
                  --var10;

                  for(var15 = 0; var15 < var10; ++var15) {
                     if(var73[var15].field639.compareTo(var73[1 + var15].field639) > 0) {
                        XClanMember var37 = var73[var15];
                        var73[var15] = var73[var15 + 1];
                        var73[1 + var15] = var37;
                        var25 = false;
                     }
                  }

                  if(var25) {
                     break;
                  }
               }

               class4.clanMembers = var73;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 135) {
               Client.field511 = Client.field339.method2633();
               Client.field379 = Client.field339.method2633();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 234) {
               var3 = Client.field339.method2620();
               var20 = Client.field339.method2633() == 1;
               var14 = class134.method2983(var3);
               if(var20 != var14.isHidden) {
                  var14.isHidden = var20;
                  class79.method1777(var14);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 243) {
               class151.method3273(Client.field339, Client.field340);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 115) {
               Client.field542 = true;
               class33.field751 = Client.field339.method2633();
               class85.field1514 = Client.field339.method2633();
               class133.field2106 = Client.field339.method2635();
               DecorativeObject.field1687 = Client.field339.method2633();
               ChatMessages.field275 = Client.field339.method2633();
               if(ChatMessages.field275 >= 100) {
                  var3 = 64 + class33.field751 * 128;
                  var0 = 64 + class85.field1514 * 128;
                  var4 = class127.method2936(var3, var0, VertexNormal.plane) - class133.field2106;
                  var6 = var3 - class151.cameraX;
                  var12 = var4 - class8.cameraZ;
                  var13 = var0 - GroundObject.cameraY;
                  var10 = (int)Math.sqrt((double)(var13 * var13 + var6 * var6));
                  ItemLayer.cameraPitch = (int)(Math.atan2((double)var12, (double)var10) * 325.949D) & 2047;
                  class59.cameraYaw = (int)(Math.atan2((double)var6, (double)var13) * -325.949D) & 2047;
                  if(ItemLayer.cameraPitch < 128) {
                     ItemLayer.cameraPitch = 128;
                  }

                  if(ItemLayer.cameraPitch > 383) {
                     ItemLayer.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 109) {
               class4.field72 = Client.field339.method2633();
               KitDefinition.field1064 = Client.field339.method2837();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 177) {
               var3 = Client.field339.method2799();
               var0 = Client.field339.method2670();
               if(var0 == '\uffff') {
                  var0 = -1;
               }

               var4 = Client.field339.method2680();
               var6 = Client.field339.method2635();
               if(var6 == '\uffff') {
                  var6 = -1;
               }

               for(var12 = var6; var12 <= var0; ++var12) {
                  var26 = (long)var12 + ((long)var4 << 32);
                  Node var66 = Client.widgetFlags.method3936(var26);
                  if(null != var66) {
                     var66.unlink();
                  }

                  Client.widgetFlags.method3940(new class204(var3), var26);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 209) {
               Player.xteaChanged(true);
               Client.field339.method2898();
               var3 = Client.field339.method2635();
               Widget.method3561(Client.field339, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 53) {
               Client.field339.offset += 28;
               if(Client.field339.method2656()) {
                  var65 = Client.field339;
                  var0 = Client.field339.offset - 28;
                  if(class152.field2301 != null) {
                     try {
                        class152.field2301.method4293(0L);
                        class152.field2301.method4298(var65.payload, var0, 24);
                     } catch (Exception var43) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 56) {
               for(var3 = 0; var3 < class56.field1233; ++var3) {
                  var33 = GameEngine.method3242(var3);
                  if(null != var33) {
                     class179.settings[var3] = 0;
                     class179.widgetSettings[var3] = 0;
                  }
               }

               class9.method125();
               Client.field366 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 30) {
               var3 = Client.field339.method2620();
               var0 = Client.field339.method2620();
               if(class107.field1853 == null || !class107.field1853.isValid()) {
                  try {
                     var19 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var19.hasNext()) {
                        GarbageCollectorMXBean var34 = (GarbageCollectorMXBean)var19.next();
                        if(var34.isValid()) {
                           class107.field1853 = var34;
                           Client.field572 = -1L;
                           Client.field571 = -1L;
                        }
                     }
                  } catch (Throwable var47) {
                     ;
                  }
               }

               var64 = class56.method1249();
               var12 = -1;
               if(class107.field1853 != null) {
                  var26 = class107.field1853.getCollectionTime();
                  if(-1L != Client.field571) {
                     long var36 = var26 - Client.field571;
                     long var38 = var64 - Client.field572;
                     if(0L != var38) {
                        var12 = (int)(100L * var36 / var38);
                     }
                  }

                  Client.field571 = var26;
                  Client.field572 = var64;
               }

               Client.field337.method2903(40);
               Client.field337.method2728(var3);
               Client.field337.method2675(var0);
               Client.field337.method2657(var12);
               Client.field337.method2783(GameEngine.FPS);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 219) {
               var3 = Client.field339.method2749();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               if(var3 == -1 && !Client.field533) {
                  class49.method1056();
               } else if(var3 != -1 && Client.field457 != var3 && Client.field294 != 0 && !Client.field533) {
                  class167.method3374(2, class188.field3051, var3, 0, Client.field294, false);
               }

               Client.field457 = var3;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 12) {
               var3 = Client.field339.method2834();
               var0 = Client.field339.method2803();
               if(var0 == '\uffff') {
                  var0 = -1;
               }

               if(Client.field294 != 0 && var0 != -1) {
                  class180.method3615(class0.field12, var0, 0, Client.field294, false);
                  Client.field533 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            class13.method176("" + Client.packetOpcode + "," + Client.field345 + "," + Client.field311 + "," + Client.field340, (Throwable)null);
            class129.method2964();
         } catch (IOException var48) {
            ItemLayer.method2289();
         } catch (Exception var49) {
            var1 = "" + Client.packetOpcode + "," + Client.field345 + "," + Client.field311 + "," + Client.field340 + "," + (WidgetNode.localPlayer.pathX[0] + class0.baseX) + "," + (class21.baseY + WidgetNode.localPlayer.pathY[0]) + ",";

            for(var0 = 0; var0 < Client.field340 && var0 < 50; ++var0) {
               var1 = var1 + Client.field339.payload[var0] + ",";
            }

            class13.method176(var1, var49);
            class129.method2964();
         }

         return true;
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "484254733"
   )
   static final void method3366(boolean var0) {
      Client.field419 = 0;
      Client.field454 = 0;
      RSCanvas.method3079();

      int var1;
      while(Client.field339.method2895(Client.field340) >= 27) {
         var1 = Client.field339.method2907(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(Client.cachedNPCs[var1] == null) {
            Client.cachedNPCs[var1] = new NPC();
            var2 = true;
         }

         NPC var3 = Client.cachedNPCs[var1];
         Client.field334[++Client.field486 - 1] = var1;
         var3.field880 = Client.gameCycle;
         int var4 = Client.field339.method2907(1);
         if(var4 == 1) {
            Client.field336[++Client.field454 - 1] = var1;
         }

         int var5 = Client.field358[Client.field339.method2907(3)];
         if(var2) {
            var3.field882 = var3.angle = var5;
         }

         int var6 = Client.field339.method2907(1);
         var3.composition = class16.getNpcDefinition(Client.field339.method2907(14));
         int var7;
         if(var0) {
            var7 = Client.field339.method2907(8);
            if(var7 > 127) {
               var7 -= 256;
            }
         } else {
            var7 = Client.field339.method2907(5);
            if(var7 > 15) {
               var7 -= 32;
            }
         }

         int var8;
         if(var0) {
            var8 = Client.field339.method2907(8);
            if(var8 > 127) {
               var8 -= 256;
            }
         } else {
            var8 = Client.field339.method2907(5);
            if(var8 > 15) {
               var8 -= 32;
            }
         }

         var3.field877 = var3.composition.field913;
         var3.field846 = var3.composition.field936;
         if(var3.field846 == 0) {
            var3.angle = 0;
         }

         var3.field879 = var3.composition.field919;
         var3.field840 = var3.composition.field917;
         var3.field841 = var3.composition.field932;
         var3.field831 = var3.composition.field922;
         var3.idlePoseAnimation = var3.composition.field931;
         var3.field866 = var3.composition.field928;
         var3.field853 = var3.composition.field923;
         var3.method770(WidgetNode.localPlayer.pathX[0] + var8, WidgetNode.localPlayer.pathY[0] + var7, var6 == 1);
      }

      Client.field339.method2900();
      class32.method700();

      for(var1 = 0; var1 < Client.field419; ++var1) {
         int var9 = Client.field388[var1];
         if(Client.gameCycle != Client.cachedNPCs[var9].field880) {
            Client.cachedNPCs[var9].composition = null;
            Client.cachedNPCs[var9] = null;
         }
      }

      if(Client.field340 != Client.field339.offset) {
         throw new RuntimeException(Client.field339.offset + "," + Client.field340);
      } else {
         for(var1 = 0; var1 < Client.field486; ++var1) {
            if(Client.cachedNPCs[Client.field334[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field486);
            }
         }

      }
   }
}
