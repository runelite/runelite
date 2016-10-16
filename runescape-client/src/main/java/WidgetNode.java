import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("y")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1893998141
   )
   int field54;
   @ObfuscatedName("t")
   boolean field56 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1060734991
   )
   @Export("id")
   int id;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;S)V",
      garbageValue = "30189"
   )
   static final void method40(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var1 + var7 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var1 + var7][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               GameObject.method2179(var10, var7, var1 + var8, var2 + var9, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "0"
   )
   static final void method41(int var0, int var1, int var2, int var3, int var4) {
      class166.field2699[0].method1871(var0, var1);
      class166.field2699[1].method1871(var0, var3 + var1 - 16);
      class82.method1801(var0, 16 + var1, 16, var3 - 32, Client.field347);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = var2 * (var3 - 32 - var5) / (var4 - var3);
      class82.method1801(var0, var6 + 16 + var1, 16, var5, Client.field397);
      class82.method1833(var0, 16 + var1 + var6, var5, Client.field369);
      class82.method1833(var0 + 1, var6 + 16 + var1, var5, Client.field369);
      class82.method1809(var0, var1 + 16 + var6, 16, Client.field369);
      class82.method1809(var0, var6 + 17 + var1, 16, Client.field369);
      class82.method1833(var0 + 15, 16 + var1 + var6, var5, Client.field349);
      class82.method1833(14 + var0, 17 + var1 + var6, var5 - 1, Client.field349);
      class82.method1809(var0, var5 + var6 + var1 + 15, 16, Client.field349);
      class82.method1809(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field349);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1969370056"
   )
   static final boolean method42() {
      if(class32.field695 == null) {
         return false;
      } else {
         int var2;
         String var21;
         try {
            int var0 = class32.field695.method2988();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class32.field695.method2996(Client.field312.payload, 0, 1);
               Client.field312.offset = 0;
               Client.packetOpcode = Client.field312.method2749();
               Client.field313 = class191.field3095[Client.packetOpcode];
               --var0;
            }

            if(Client.field313 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class32.field695.method2996(Client.field312.payload, 0, 1);
               Client.field313 = Client.field312.payload[0] & 255;
               --var0;
            }

            if(Client.field313 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class32.field695.method2996(Client.field312.payload, 0, 2);
               Client.field312.offset = 0;
               Client.field313 = Client.field312.method2668();
               var0 -= 2;
            }

            if(var0 < Client.field313) {
               return false;
            }

            Client.field312.offset = 0;
            class32.field695.method2996(Client.field312.payload, 0, Client.field313);
            Client.field272 = 0;
            Client.field319 = Client.field318;
            Client.field318 = Client.field345;
            Client.field345 = Client.packetOpcode;
            int var1;
            if(Client.packetOpcode == 18) {
               var1 = Client.field312.method2668();
               class9.method123(var1);
               Client.field456[++Client.field457 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 142) {
               for(var1 = 0; var1 < class179.widgetSettings.length; ++var1) {
                  if(class179.settings[var1] != class179.widgetSettings[var1]) {
                     class179.widgetSettings[var1] = class179.settings[var1];
                     class20.method539(var1);
                     Client.field472[++Client.field455 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var6;
            int var13;
            int var15;
            long var63;
            long var64;
            long var72;
            String var80;
            if(Client.packetOpcode == 251) {
               var21 = Client.field312.method2503();
               var63 = Client.field312.method2487();
               var64 = (long)Client.field312.method2668();
               var6 = (long)Client.field312.method2485();
               class155[] var61 = new class155[]{class155.field2309, class155.field2305, class155.field2307, class155.field2306, class155.field2308};
               class155 var69 = (class155)SecondaryBufferProvider.method1646(var61, Client.field312.method2481());
               var72 = var6 + (var64 << 32);
               boolean var77 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if(var72 == Client.field489[var13]) {
                     var77 = true;
                     break;
                  }
               }

               if(var69.field2312 && class38.method764(var21)) {
                  var77 = true;
               }

               if(!var77 && Client.field426 == 0) {
                  Client.field489[Client.field276] = var72;
                  Client.field276 = (Client.field276 + 1) % 100;
                  String var83 = class226.method4053(class181.method3473(class162.method3165(Client.field312)));
                  if(var69.field2304 != -1) {
                     var15 = var69.field2304;
                     var80 = "<img=" + var15 + ">";
                     class49.addChatMessage(9, var80 + var21, var83, class126.method2787(var63));
                  } else {
                     class49.addChatMessage(9, var21, var83, class126.method2787(var63));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 245) {
               World var91 = new World();
               var91.address = Client.field312.method2503();
               var91.id = Client.field312.method2668();
               var2 = Client.field312.method2526();
               var91.mask = var2;
               class112.setGameState(45);
               class32.field695.method2986();
               class32.field695 = null;
               class22.selectWorld(var91);
               Client.packetOpcode = -1;
               return false;
            }

            Widget var55;
            WidgetNode var90;
            if(Client.packetOpcode == 19) {
               var1 = Client.field312.method2677();
               var2 = Client.field312.method2677();
               WidgetNode var78 = (WidgetNode)Client.componentTable.method3775((long)var1);
               var90 = (WidgetNode)Client.componentTable.method3775((long)var2);
               if(null != var90) {
                  class14.method169(var90, var78 == null || var78.id != var90.id);
               }

               if(var78 != null) {
                  var78.unlink();
                  Client.componentTable.method3776(var78, (long)var2);
               }

               var55 = class92.method2078(var1);
               if(null != var55) {
                  class32.method685(var55);
               }

               var55 = class92.method2078(var2);
               if(var55 != null) {
                  class32.method685(var55);
                  Projectile.method99(Widget.widgets[var55.id >>> 16], var55, true);
               }

               if(Client.widgetRoot != -1) {
                  class32.method684(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var4;
            int var25;
            int var52;
            int var87;
            if(Client.packetOpcode == 88) {
               var1 = Client.field312.method2644();
               var2 = Client.field312.method2668();
               var87 = var2 >> 10 & 31;
               var4 = var2 >> 5 & 31;
               var25 = var2 & 31;
               var52 = (var25 << 3) + (var4 << 11) + (var87 << 19);
               Widget var70 = class92.method2078(var1);
               if(var70.textColor != var52) {
                  var70.textColor = var52;
                  class32.method685(var70);
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var27;
            String var51;
            String var89;
            String var92;
            if(Client.packetOpcode == 27) {
               var21 = Client.field312.method2503();
               Client.field273 = var21;

               try {
                  var92 = Client.field389.getParameter(class193.field3116.field3119);
                  var51 = Client.field389.getParameter(class193.field3113.field3119);
                  var89 = var92 + "settings=" + var21 + "; version=1; path=/; domain=" + var51;
                  if(var21.length() == 0) {
                     var89 = var89 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var89 = var89 + "; Expires=" + class221.method3973(class113.method2394() + 94608000000L) + "; Max-Age=" + 94608000L;
                  }

                  Client var57 = Client.field389;
                  var27 = "document.cookie=\"" + var89 + "\"";
                  JSObject.getWindow(var57).eval(var27);
               } catch (Throwable var36) {
                  ;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 169) {
               var1 = Client.field312.method2508();
               var2 = Client.field312.method2528();
               var87 = Client.field312.method2658();
               var90 = (WidgetNode)Client.componentTable.method3775((long)var2);
               if(var90 != null) {
                  class14.method169(var90, var87 != var90.id);
               }

               class171.method3341(var2, var87, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 135) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(Client.cachedPlayers[var1] != null) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(Client.cachedNPCs[var1] != null) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 190) {
               var1 = Client.field312.method2668();
               var2 = Client.field312.method2481();
               var87 = Client.field312.method2668();
               if(Client.field508 != 0 && var2 != 0 && Client.field510 < 50) {
                  Client.field511[Client.field510] = var1;
                  Client.field315[Client.field510] = var2;
                  Client.field482[Client.field510] = var87;
                  Client.field515[Client.field510] = null;
                  Client.field514[Client.field510] = 0;
                  ++Client.field510;
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var81;
            if(Client.packetOpcode == 123) {
               var81 = Client.field312.method2481() == 1;
               if(var81) {
                  class33.field735 = class113.method2394() - Client.field312.method2487();
                  class117.field2004 = new class224(Client.field312, true);
               } else {
                  class117.field2004 = null;
               }

               Client.field464 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var74;
            boolean var79;
            if(Client.packetOpcode == 230) {
               var1 = Client.field312.method2654();
               var74 = Client.field312.method2481() == 1;
               var51 = "";
               var79 = false;
               if(var74) {
                  var51 = Client.field312.method2503();
                  if(class38.method764(var51)) {
                     var79 = true;
                  }
               }

               String var56 = Client.field312.method2503();
               if(!var79) {
                  Player.sendGameMessage(var1, var51, var56);
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var47;
            if(Client.packetOpcode == 11) {
               var1 = Client.field312.method2677();
               var74 = Client.field312.method2510() == 1;
               var47 = class92.method2078(var1);
               if(var74 != var47.isHidden) {
                  var47.isHidden = var74;
                  class32.method685(var47);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 132) {
               Client.field537 = Client.field312.method2481();
               Client.field487 = Client.field312.method2481();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 43) {
               class190.method3733(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 44) {
               var1 = Client.field312.method2658();
               var2 = Client.field312.method2644();
               var87 = Client.field312.method2658();
               var4 = Client.field312.method2516();
               var55 = class92.method2078(var2);
               if(var55.rotationX != var4 || var1 != var55.rotationZ || var55.field2852 != var87) {
                  var55.rotationX = var4;
                  var55.rotationZ = var1;
                  var55.field2852 = var87;
                  class32.method685(var55);
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var96;
            if(Client.packetOpcode == 143) {
               var1 = Client.field312.method2677();
               var96 = class92.method2078(var1);
               var96.modelType = 3;
               var96.modelId = TextureProvider.localPlayer.composition.method3495();
               class32.method685(var96);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 185) {
               Client.field516 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field517[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 98) {
               Client.field362 = Client.field312.method2508();
               class59.field1237 = Client.field312.method2510();

               for(var1 = class59.field1237; var1 < class59.field1237 + 8; ++var1) {
                  for(var2 = Client.field362; var2 < Client.field362 + 8; ++var2) {
                     if(null != Client.groundItemDeque[class59.plane][var1][var2]) {
                        Client.groundItemDeque[class59.plane][var1][var2] = null;
                        class116.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class16 var88 = (class16)Client.field401.method3808(); null != var88; var88 = (class16)Client.field401.method3810()) {
                  if(var88.field209 >= class59.field1237 && var88.field209 < class59.field1237 + 8 && var88.field221 >= Client.field362 && var88.field221 < Client.field362 + 8 && class59.plane == var88.field215) {
                     var88.field211 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 107) {
               var1 = Client.field312.method2554();
               var2 = Client.field312.method2508();
               var51 = Client.field312.method2503();
               if(var1 >= 1 && var1 <= 8) {
                  if(var51.equalsIgnoreCase("null")) {
                     var51 = null;
                  }

                  Client.field396[var1 - 1] = var51;
                  Client.field513[var1 - 1] = var2 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 127) {
               var1 = Client.field312.method2516();
               var2 = Client.field312.method2677();
               class179.settings[var1] = var2;
               if(class179.widgetSettings[var1] != var2) {
                  class179.widgetSettings[var1] = var2;
               }

               class20.method539(var1);
               Client.field472[++Client.field455 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 66) {
               Client.flagX = Client.field312.method2481();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field312.method2481();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 166) {
               class130.method2821();
               Client.weight = Client.field312.method2474();
               Client.field332 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var106;
            if(Client.packetOpcode == 99) {
               while(Client.field312.offset < Client.field313) {
                  var81 = Client.field312.method2481() == 1;
                  var92 = Client.field312.method2503();
                  var51 = Client.field312.method2503();
                  var4 = Client.field312.method2668();
                  var25 = Client.field312.method2481();
                  var52 = Client.field312.method2481();
                  boolean var109 = (var52 & 2) != 0;
                  var106 = (var52 & 1) != 0;
                  if(var4 > 0) {
                     Client.field312.method2503();
                     Client.field312.method2481();
                     Client.field312.method2526();
                  }

                  Client.field312.method2503();

                  for(int var103 = 0; var103 < Client.friendCount; ++var103) {
                     Friend var105 = Client.friends[var103];
                     if(!var81) {
                        if(var92.equals(var105.name)) {
                           if(var4 != var105.world) {
                              boolean var75 = true;

                              for(class40 var107 = (class40)Client.field538.method3768(); null != var107; var107 = (class40)Client.field538.method3770()) {
                                 if(var107.field863.equals(var92)) {
                                    if(var4 != 0 && var107.field865 == 0) {
                                       var107.method3916();
                                       var75 = false;
                                    } else if(var4 == 0 && var107.field865 != 0) {
                                       var107.method3916();
                                       var75 = false;
                                    }
                                 }
                              }

                              if(var75) {
                                 Client.field538.method3767(new class40(var92, var4));
                              }

                              var105.world = var4;
                           }

                           var105.previousName = var51;
                           var105.rank = var25;
                           var105.field223 = var109;
                           var105.field233 = var106;
                           var92 = null;
                           break;
                        }
                     } else if(var51.equals(var105.name)) {
                        var105.name = var92;
                        var105.previousName = var51;
                        var92 = null;
                        break;
                     }
                  }

                  if(var92 != null && Client.friendCount < 400) {
                     Friend var67 = new Friend();
                     Client.friends[Client.friendCount] = var67;
                     var67.name = var92;
                     var67.previousName = var51;
                     var67.world = var4;
                     var67.rank = var25;
                     var67.field223 = var109;
                     var67.field233 = var106;
                     ++Client.friendCount;
                  }
               }

               Client.field536 = 2;
               Client.field461 = Client.field453;
               var81 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var81 = true;
                  --var2;

                  for(var87 = 0; var87 < var2; ++var87) {
                     var79 = false;
                     Friend var53 = Client.friends[var87];
                     Friend var101 = Client.friends[1 + var87];
                     if(Client.world != var53.world && var101.world == Client.world) {
                        var79 = true;
                     }

                     if(!var79 && var53.world == 0 && var101.world != 0) {
                        var79 = true;
                     }

                     if(!var79 && !var53.field223 && var101.field223) {
                        var79 = true;
                     }

                     if(!var79 && !var53.field233 && var101.field233) {
                        var79 = true;
                     }

                     if(var79) {
                        Friend var68 = Client.friends[var87];
                        Client.friends[var87] = Client.friends[1 + var87];
                        Client.friends[var87 + 1] = var68;
                        var81 = false;
                     }
                  }

                  if(var81) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 56) {
               var1 = Client.field312.method2668();
               var2 = Client.field312.method2677();
               var47 = class92.method2078(var2);
               if(var47.modelType != 2 || var1 != var47.modelId) {
                  var47.modelType = 2;
                  var47.modelId = var1;
                  class32.method685(var47);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 113) {
               class130.method2821();
               var1 = Client.field312.method2526();
               var2 = Client.field312.method2508();
               var87 = Client.field312.method2510();
               Client.skillExperiences[var87] = var1;
               Client.boostedSkillLevels[var87] = var2;
               Client.realSkillLevels[var87] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var1 >= class158.field2339[var4]) {
                     Client.realSkillLevels[var87] = 2 + var4;
                  }
               }

               Client.field321[++Client.field459 - 1 & 31] = var87;
               Client.packetOpcode = -1;
               return true;
            }

            int var28;
            if(Client.packetOpcode == 69) {
               Client.field516 = true;
               class51.field1099 = Client.field312.method2481();
               class8.field127 = Client.field312.method2481();
               class4.field63 = Client.field312.method2668();
               class191.field3082 = Client.field312.method2481();
               class112.field1939 = Client.field312.method2481();
               if(class112.field1939 >= 100) {
                  var1 = 64 + class51.field1099 * 128;
                  var2 = 64 + class8.field127 * 128;
                  var87 = class79.method1656(var1, var2, class59.plane) - class4.field63;
                  var4 = var1 - class13.cameraX;
                  var25 = var87 - Ignore.cameraZ;
                  var52 = var2 - class154.cameraY;
                  var28 = (int)Math.sqrt((double)(var4 * var4 + var52 * var52));
                  class125.cameraPitch = (int)(Math.atan2((double)var25, (double)var28) * 325.949D) & 2047;
                  class166.cameraYaw = (int)(Math.atan2((double)var4, (double)var52) * -325.949D) & 2047;
                  if(class125.cameraPitch < 128) {
                     class125.cameraPitch = 128;
                  }

                  if(class125.cameraPitch > 383) {
                     class125.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var29;
            if(Client.packetOpcode == 183) {
               var1 = Client.field313 + Client.field312.offset;
               var2 = Client.field312.method2668();
               var87 = Client.field312.method2668();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  class11.method135(Client.widgetRoot, class50.field1069, class139.field2143, false);
                  ObjectComposition.method856(Client.widgetRoot);
                  class129.method2805(Client.widgetRoot);

                  for(var4 = 0; var4 < 100; ++var4) {
                     Client.field379[var4] = true;
                  }
               }

               WidgetNode var62;
               for(; var87-- > 0; var62.field56 = true) {
                  var4 = Client.field312.method2526();
                  var25 = Client.field312.method2668();
                  var52 = Client.field312.method2481();
                  var62 = (WidgetNode)Client.componentTable.method3775((long)var4);
                  if(var62 != null && var25 != var62.id) {
                     class14.method169(var62, true);
                     var62 = null;
                  }

                  if(null == var62) {
                     var62 = class171.method3341(var4, var25, var52);
                  }
               }

               for(var90 = (WidgetNode)Client.componentTable.method3780(); var90 != null; var90 = (WidgetNode)Client.componentTable.method3785()) {
                  if(var90.field56) {
                     var90.field56 = false;
                  } else {
                     class14.method169(var90, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field312.offset < var1) {
                  var4 = Client.field312.method2526();
                  var25 = Client.field312.method2668();
                  var52 = Client.field312.method2668();
                  var28 = Client.field312.method2526();

                  for(var29 = var25; var29 <= var52; ++var29) {
                     long var30 = (long)var29 + ((long)var4 << 32);
                     Client.widgetFlags.method3776(new class204(var28), var30);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 119) {
               class130.method2821();
               Client.energy = Client.field312.method2481();
               Client.field332 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 49) {
               for(var1 = 0; var1 < class232.field3277; ++var1) {
                  class56 var99 = class125.method2774(var1);
                  if(var99 != null) {
                     class179.settings[var1] = 0;
                     class179.widgetSettings[var1] = 0;
                  }
               }

               class130.method2821();
               Client.field455 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            class125 var93;
            Player var97;
            if(Client.packetOpcode == 20) {
               class152.xteaChanged(true);
               Client.field312.method2749();
               var1 = Client.field312.method2668();
               var93 = Client.field312;
               var87 = var93.offset;
               class34.field750 = 0;
               var4 = 0;
               var93.method2750();

               for(var25 = 0; var25 < class34.field743; ++var25) {
                  var52 = class34.field739[var25];
                  if((class34.field740[var52] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else {
                           class33.method689(var93, var52);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var93.method2750();

               for(var25 = 0; var25 < class34.field743; ++var25) {
                  var52 = class34.field739[var25];
                  if((class34.field740[var52] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else {
                           class33.method689(var93, var52);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var93.method2750();

               for(var25 = 0; var25 < class34.field745; ++var25) {
                  var52 = class34.field754[var25];
                  if((class34.field740[var52] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else if(class16.method186(var93, var52)) {
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var93.method2750();

               for(var25 = 0; var25 < class34.field745; ++var25) {
                  var52 = class34.field754[var25];
                  if((class34.field740[var52] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else if(class16.method186(var93, var52)) {
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class34.field743 = 0;
               class34.field745 = 0;

               for(var25 = 1; var25 < 2048; ++var25) {
                  class34.field740[var25] = (byte)(class34.field740[var25] >> 1);
                  var97 = Client.cachedPlayers[var25];
                  if(var97 != null) {
                     class34.field739[++class34.field743 - 1] = var25;
                  } else {
                     class34.field754[++class34.field745 - 1] = var25;
                  }
               }

               Player.method38(var93);
               if(var93.offset - var87 != var1) {
                  throw new RuntimeException(var93.offset - var87 + " " + var1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 209) {
               class59.field1237 = Client.field312.method2510();
               Client.field362 = Client.field312.method2554();

               while(Client.field312.offset < Client.field313) {
                  Client.packetOpcode = Client.field312.method2481();
                  GameEngine.method3014();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 60) {
               var1 = Client.field312.method2677();
               class54.field1129 = class8.field121.method2879(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 253) {
               var1 = Client.field312.method2677();
               var96 = class92.method2078(var1);

               for(var87 = 0; var87 < var96.itemIds.length; ++var87) {
                  var96.itemIds[var87] = -1;
                  var96.itemIds[var87] = 0;
               }

               class32.method685(var96);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 213) {
               var21 = Client.field312.method2503();
               Object[] var94 = new Object[var21.length() + 1];

               for(var87 = var21.length() - 1; var87 >= 0; --var87) {
                  if(var21.charAt(var87) == 115) {
                     var94[1 + var87] = Client.field312.method2503();
                  } else {
                     var94[1 + var87] = new Integer(Client.field312.method2526());
                  }
               }

               var94[0] = new Integer(Client.field312.method2526());
               class0 var71 = new class0();
               var71.field5 = var94;
               MessageNode.method754(var71);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 51) {
               Client.field312.offset += 28;
               if(Client.field312.method2502()) {
                  class138.method2872(Client.field312, Client.field312.offset - 28);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 241) {
               var21 = Client.field312.method2503();
               var2 = Client.field312.method2668();
               byte var95 = Client.field312.method2601();
               var79 = false;
               if(var95 == -128) {
                  var79 = true;
               }

               if(var79) {
                  if(NPC.field764 == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  boolean var110 = false;

                  for(var25 = 0; var25 < NPC.field764 && (!Frames.clanMembers[var25].username.equals(var21) || var2 != Frames.clanMembers[var25].world); ++var25) {
                     ;
                  }

                  if(var25 < NPC.field764) {
                     while(var25 < NPC.field764 - 1) {
                        Frames.clanMembers[var25] = Frames.clanMembers[var25 + 1];
                        ++var25;
                     }

                     --NPC.field764;
                     Frames.clanMembers[NPC.field764] = null;
                  }
               } else {
                  Client.field312.method2503();
                  XClanMember var50 = new XClanMember();
                  var50.username = var21;
                  var50.field609 = XItemContainer.method178(var50.username, Client.field518);
                  var50.world = var2;
                  var50.rank = var95;

                  for(var52 = NPC.field764 - 1; var52 >= 0; --var52) {
                     var28 = Frames.clanMembers[var52].field609.compareTo(var50.field609);
                     if(var28 == 0) {
                        Frames.clanMembers[var52].world = var2;
                        Frames.clanMembers[var52].rank = var95;
                        if(var21.equals(TextureProvider.localPlayer.name)) {
                           class0.field11 = var95;
                        }

                        Client.field462 = Client.field453;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var28 < 0) {
                        break;
                     }
                  }

                  if(NPC.field764 >= Frames.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var28 = NPC.field764 - 1; var28 > var52; --var28) {
                     Frames.clanMembers[var28 + 1] = Frames.clanMembers[var28];
                  }

                  if(NPC.field764 == 0) {
                     Frames.clanMembers = new XClanMember[100];
                  }

                  Frames.clanMembers[1 + var52] = var50;
                  ++NPC.field764;
                  if(var21.equals(TextureProvider.localPlayer.name)) {
                     class0.field11 = var95;
                  }
               }

               Client.field462 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 33) {
               var1 = Client.field312.method2481();
               var2 = Client.field312.method2481();
               var87 = Client.field312.method2481();
               var4 = Client.field312.method2481();
               Client.field517[var1] = true;
               Client.field526[var1] = var2;
               Client.field519[var1] = var87;
               Client.field355[var1] = var4;
               Client.field521[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 63) {
               Client.field362 = Client.field312.method2508();
               class59.field1237 = Client.field312.method2481();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 237) {
               Client.field290 = Client.field312.method2516() * 30;
               Client.field332 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 85) {
               class152.xteaChanged(false);
               Client.field312.method2749();
               var1 = Client.field312.method2668();
               var93 = Client.field312;
               var87 = var93.offset;
               class34.field750 = 0;
               var4 = 0;
               var93.method2750();

               for(var25 = 0; var25 < class34.field743; ++var25) {
                  var52 = class34.field739[var25];
                  if((class34.field740[var52] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else {
                           class33.method689(var93, var52);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var93.method2750();

               for(var25 = 0; var25 < class34.field743; ++var25) {
                  var52 = class34.field739[var25];
                  if((class34.field740[var52] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else {
                           class33.method689(var93, var52);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var93.method2750();

               for(var25 = 0; var25 < class34.field745; ++var25) {
                  var52 = class34.field754[var25];
                  if((class34.field740[var52] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else if(class16.method186(var93, var52)) {
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var93.method2750();

               for(var25 = 0; var25 < class34.field745; ++var25) {
                  var52 = class34.field754[var25];
                  if((class34.field740[var52] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var93.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var93);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else if(class16.method186(var93, var52)) {
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        }
                     }
                  }
               }

               var93.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class34.field743 = 0;
               class34.field745 = 0;

               for(var25 = 1; var25 < 2048; ++var25) {
                  class34.field740[var25] = (byte)(class34.field740[var25] >> 1);
                  var97 = Client.cachedPlayers[var25];
                  if(null != var97) {
                     class34.field739[++class34.field743 - 1] = var25;
                  } else {
                     class34.field754[++class34.field745 - 1] = var25;
                  }
               }

               Player.method38(var93);
               if(var93.offset - var87 != var1) {
                  throw new RuntimeException(var93.offset - var87 + " " + var1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 145) {
               class26.method604();

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               Ignore.method105(Client.field312);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 201) {
               var1 = Client.field312.method2474();
               var2 = Client.field312.method2526();
               var47 = class92.method2078(var2);
               if(var1 != var47.field2845 || var1 == -1) {
                  var47.field2845 = var1;
                  var47.field2811 = 0;
                  var47.field2921 = 0;
                  class32.method685(var47);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 206) {
               while(Client.field312.offset < Client.field313) {
                  var1 = Client.field312.method2481();
                  var74 = (var1 & 1) == 1;
                  var51 = Client.field312.method2503();
                  var89 = Client.field312.method2503();
                  Client.field312.method2503();

                  for(var25 = 0; var25 < Client.ignoreCount; ++var25) {
                     Ignore var100 = Client.ignores[var25];
                     if(var74) {
                        if(var89.equals(var100.name)) {
                           var100.name = var51;
                           var100.previousName = var89;
                           var51 = null;
                           break;
                        }
                     } else if(var51.equals(var100.name)) {
                        var100.name = var51;
                        var100.previousName = var89;
                        var51 = null;
                        break;
                     }
                  }

                  if(var51 != null && Client.ignoreCount < 400) {
                     Ignore var49 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var49;
                     var49.name = var51;
                     var49.previousName = var89;
                     ++Client.ignoreCount;
                  }
               }

               Client.field461 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 22) {
               if(Client.widgetRoot != -1) {
                  var1 = Client.widgetRoot;
                  if(class174.method3393(var1)) {
                     class112.method2393(Widget.widgets[var1], 0);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 219) {
               class190.method3733(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 92) {
               Client.field310 = Client.field312.method2481();
               if(Client.field310 == 1) {
                  Client.field285 = Client.field312.method2668();
               }

               if(Client.field310 >= 2 && Client.field310 <= 6) {
                  if(Client.field310 == 2) {
                     Client.field286 = 64;
                     Client.field350 = 64;
                  }

                  if(Client.field310 == 3) {
                     Client.field286 = 0;
                     Client.field350 = 64;
                  }

                  if(Client.field310 == 4) {
                     Client.field286 = 128;
                     Client.field350 = 64;
                  }

                  if(Client.field310 == 5) {
                     Client.field286 = 64;
                     Client.field350 = 0;
                  }

                  if(Client.field310 == 6) {
                     Client.field286 = 64;
                     Client.field350 = 128;
                  }

                  Client.field310 = 2;
                  Client.field287 = Client.field312.method2668();
                  Client.field433 = Client.field312.method2668();
                  Client.field550 = Client.field312.method2481();
               }

               if(Client.field310 == 10) {
                  Client.field417 = Client.field312.method2668();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 5) {
               var1 = Client.field312.method2516();
               var2 = Client.field312.method2644();
               var47 = class92.method2078(var2);
               if(var47.modelType != 1 || var1 != var47.modelId) {
                  var47.modelType = 1;
                  var47.modelId = var1;
                  class32.method685(var47);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 71) {
               var1 = Client.field312.method2516();
               Client.widgetRoot = var1;
               class11.method135(Client.widgetRoot, class50.field1069, class139.field2143, false);
               ObjectComposition.method856(var1);
               class129.method2805(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field379[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var86;
            if(Client.packetOpcode == 9) {
               var1 = Client.field312.method2644();
               var2 = Client.field312.method2517();
               var87 = Client.field312.method2517();
               var86 = class92.method2078(var1);
               var86.field2859 = var87 + (var2 << 16);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 232) {
               var2 = Client.field312.method2481();
               class133[] var59 = class85.method1888();
               var4 = 0;

               class133 var84;
               while(true) {
                  if(var4 >= var59.length) {
                     var84 = null;
                     break;
                  }

                  class133 var48 = var59[var4];
                  if(var48.field2098 == var2) {
                     var84 = var48;
                     break;
                  }

                  ++var4;
               }

               class212.field3169 = var84;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 214) {
               var1 = Client.field312.method2658();
               var2 = Client.field312.method2528();
               var47 = class92.method2078(var2);
               if(null != var47 && var47.type == 0) {
                  if(var1 > var47.scrollHeight - var47.height) {
                     var1 = var47.scrollHeight - var47.height;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var47.scrollY != var1) {
                     var47.scrollY = var1;
                     class32.method685(var47);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 87) {
               Client.field326 = Client.field312.method2481();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 62) {
               Client.field516 = true;
               class22.field575 = Client.field312.method2481();
               class54.field1138 = Client.field312.method2481();
               class9.field148 = Client.field312.method2668();
               class0.field12 = Client.field312.method2481();
               class1.field23 = Client.field312.method2481();
               if(class1.field23 >= 100) {
                  class13.cameraX = class22.field575 * 128 + 64;
                  class154.cameraY = 64 + class54.field1138 * 128;
                  Ignore.cameraZ = class79.method1656(class13.cameraX, class154.cameraY, class59.plane) - class9.field148;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 121) {
               class152.method3138();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 110 || Client.packetOpcode == 249 || Client.packetOpcode == 186 || Client.packetOpcode == 109 || Client.packetOpcode == 68 || Client.packetOpcode == 41 || Client.packetOpcode == 17 || Client.packetOpcode == 53 || Client.packetOpcode == 250 || Client.packetOpcode == 35) {
               GameEngine.method3014();
               Client.packetOpcode = -1;
               return true;
            }

            int var10;
            int var11;
            if(Client.packetOpcode == 247) {
               Client.field462 = Client.field453;
               if(Client.field313 == 0) {
                  Client.field495 = null;
                  Client.field496 = null;
                  NPC.field764 = 0;
                  Frames.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.field496 = Client.field312.method2503();
               long var54 = Client.field312.method2487();
               var64 = var54;
               if(var54 > 0L && var54 < 6582952005840035281L) {
                  if(0L == var54 % 37L) {
                     var51 = null;
                  } else {
                     var52 = 0;

                     for(long var102 = var54; 0L != var102; var102 /= 37L) {
                        ++var52;
                     }

                     StringBuilder var65 = new StringBuilder(var52);

                     while(var64 != 0L) {
                        var72 = var64;
                        var64 /= 37L;
                        var65.append(class165.field2695[(int)(var72 - var64 * 37L)]);
                     }

                     var51 = var65.reverse().toString();
                  }
               } else {
                  var51 = null;
               }

               Client.field495 = var51;
               class45.field993 = Client.field312.method2601();
               var52 = Client.field312.method2481();
               if(var52 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               NPC.field764 = var52;
               XClanMember[] var60 = new XClanMember[100];

               for(var29 = 0; var29 < NPC.field764; ++var29) {
                  var60[var29] = new XClanMember();
                  var60[var29].username = Client.field312.method2503();
                  var60[var29].field609 = XItemContainer.method178(var60[var29].username, Client.field518);
                  var60[var29].world = Client.field312.method2668();
                  var60[var29].rank = Client.field312.method2601();
                  Client.field312.method2503();
                  if(var60[var29].username.equals(TextureProvider.localPlayer.name)) {
                     class0.field11 = var60[var29].rank;
                  }
               }

               var106 = false;
               var10 = NPC.field764;

               while(var10 > 0) {
                  var106 = true;
                  --var10;

                  for(var11 = 0; var11 < var10; ++var11) {
                     if(var60[var11].field609.compareTo(var60[var11 + 1].field609) > 0) {
                        XClanMember var66 = var60[var11];
                        var60[var11] = var60[1 + var11];
                        var60[var11 + 1] = var66;
                        var106 = false;
                     }
                  }

                  if(var106) {
                     break;
                  }
               }

               Frames.clanMembers = var60;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 117) {
               var1 = Client.field312.method2528();
               var92 = Client.field312.method2503();
               var47 = class92.method2078(var1);
               if(!var92.equals(var47.text)) {
                  var47.text = var92;
                  class32.method685(var47);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 161) {
               var1 = Client.field312.method2668();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field312.method2644();
               var87 = Client.field312.method2644();
               var86 = class92.method2078(var2);
               ItemComposition var5;
               if(!var86.field2797) {
                  if(var1 == -1) {
                     var86.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var5 = class174.getItemDefinition(var1);
                  var86.modelType = 4;
                  var86.modelId = var1;
                  var86.rotationX = var5.field1183;
                  var86.rotationZ = var5.field1157;
                  var86.field2852 = var5.field1151 * 100 / var87;
                  class32.method685(var86);
               } else {
                  var86.item = var1;
                  var86.stackSize = var87;
                  var5 = class174.getItemDefinition(var1);
                  var86.rotationX = var5.field1183;
                  var86.rotationZ = var5.field1157;
                  var86.rotationY = var5.field1159;
                  var86.field2787 = var5.field1155;
                  var86.field2847 = var5.field1186;
                  var86.field2852 = var5.field1151;
                  if(var5.isStackable == 1) {
                     var86.field2856 = 1;
                  } else {
                     var86.field2856 = 2;
                  }

                  if(var86.field2853 > 0) {
                     var86.field2852 = var86.field2852 * 32 / var86.field2853;
                  } else if(var86.field2805 > 0) {
                     var86.field2852 = var86.field2852 * 32 / var86.field2805;
                  }

                  class32.method685(var86);
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var104;
            if(Client.packetOpcode == 171) {
               var21 = Client.field312.method2503();
               var63 = (long)Client.field312.method2668();
               var64 = (long)Client.field312.method2485();
               class155[] var98 = new class155[]{class155.field2309, class155.field2305, class155.field2307, class155.field2306, class155.field2308};
               class155 var58 = (class155)SecondaryBufferProvider.method1646(var98, Client.field312.method2481());
               var104 = (var63 << 32) + var64;
               boolean var73 = false;

               for(var11 = 0; var11 < 100; ++var11) {
                  if(var104 == Client.field489[var11]) {
                     var73 = true;
                     break;
                  }
               }

               if(class38.method764(var21)) {
                  var73 = true;
               }

               if(!var73 && Client.field426 == 0) {
                  Client.field489[Client.field276] = var104;
                  Client.field276 = (1 + Client.field276) % 100;
                  String var108 = class226.method4053(class181.method3473(class162.method3165(Client.field312)));
                  byte var76;
                  if(var58.field2314) {
                     var76 = 7;
                  } else {
                     var76 = 3;
                  }

                  if(var58.field2304 != -1) {
                     var15 = var58.field2304;
                     var80 = "<img=" + var15 + ">";
                     Player.sendGameMessage(var76, var80 + var21, var108);
                  } else {
                     Player.sendGameMessage(var76, var21, var108);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 153) {
               var1 = Client.field312.method2677();
               var2 = Client.field312.method2516();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var87 = Client.field312.method2658();
               if(var87 == '\uffff') {
                  var87 = -1;
               }

               var4 = Client.field312.method2526();

               for(var25 = var2; var25 <= var87; ++var25) {
                  var6 = ((long)var1 << 32) + (long)var25;
                  Node var8 = Client.widgetFlags.method3775(var6);
                  if(var8 != null) {
                     var8.unlink();
                  }

                  Client.widgetFlags.method3776(new class204(var4), var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 231) {
               var1 = Client.field312.method2520();
               var2 = Client.field312.method2677();
               var87 = Client.field312.method2519();
               var86 = class92.method2078(var2);
               if(var86.field2807 != var87 || var1 != var86.field2808 || var86.field2803 != 0 || var86.field2804 != 0) {
                  var86.field2807 = var87;
                  var86.field2808 = var1;
                  var86.field2803 = 0;
                  var86.field2804 = 0;
                  class32.method685(var86);
                  class53.method1060(var86);
                  if(var86.type == 0) {
                     Projectile.method99(Widget.widgets[var2 >> 16], var86, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 199) {
               var21 = Client.field312.method2503();
               var92 = class226.method4053(class181.method3473(class162.method3165(Client.field312)));
               Player.sendGameMessage(6, var21, var92);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 136) {
               var1 = Client.field312.method2668();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               class134.method2842(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 216) {
               var1 = Client.field312.method2573();
               var2 = Client.field312.method2658();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(Client.field424 != 0 && var2 != -1) {
                  class50.method1001(Buffer.field2033, var2, 0, Client.field424, false);
                  Client.field507 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 114) {
               var1 = Client.field312.method2526();
               WidgetNode var26 = (WidgetNode)Client.componentTable.method3775((long)var1);
               if(var26 != null) {
                  class14.method169(var26, true);
               }

               if(null != Client.field432) {
                  class32.method685(Client.field432);
                  Client.field432 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 197) {
               var1 = Client.field312.method2526();
               var2 = Client.field312.method2668();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var47 = class92.method2078(var1);
               } else {
                  var47 = null;
               }

               for(; Client.field312.offset < Client.field313; World.method653(var2, var4, var25 - 1, var52)) {
                  var4 = Client.field312.method2654();
                  var25 = Client.field312.method2668();
                  var52 = 0;
                  if(var25 != 0) {
                     var52 = Client.field312.method2481();
                     if(var52 == 255) {
                        var52 = Client.field312.method2526();
                     }
                  }

                  if(var47 != null && var4 >= 0 && var4 < var47.itemIds.length) {
                     var47.itemIds[var4] = var25;
                     var47.itemQuantities[var4] = var52;
                  }
               }

               if(null != var47) {
                  class32.method685(var47);
               }

               class130.method2821();
               Client.field456[++Client.field457 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 125) {
               Client.field536 = 1;
               Client.field461 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 93) {
               byte var45 = Client.field312.method2511();
               var2 = Client.field312.method2668();
               class179.settings[var2] = var45;
               if(class179.widgetSettings[var2] != var45) {
                  class179.widgetSettings[var2] = var45;
               }

               class20.method539(var2);
               Client.field472[++Client.field455 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 67) {
               var1 = Client.field312.method2526();
               var2 = Client.field312.method2668();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var47 = class92.method2078(var1);
               } else {
                  var47 = null;
               }

               if(null != var47) {
                  for(var4 = 0; var4 < var47.itemIds.length; ++var4) {
                     var47.itemIds[var4] = 0;
                     var47.itemQuantities[var4] = 0;
                  }
               }

               XItemContainer var85 = (XItemContainer)XItemContainer.itemContainers.method3775((long)var2);
               if(var85 != null) {
                  for(var25 = 0; var25 < var85.itemIds.length; ++var25) {
                     var85.itemIds[var25] = -1;
                     var85.stackSizes[var25] = 0;
                  }
               }

               var4 = Client.field312.method2668();

               for(var25 = 0; var25 < var4; ++var25) {
                  var52 = Client.field312.method2510();
                  if(var52 == 255) {
                     var52 = Client.field312.method2644();
                  }

                  var28 = Client.field312.method2668();
                  if(var47 != null && var25 < var47.itemIds.length) {
                     var47.itemIds[var25] = var28;
                     var47.itemQuantities[var25] = var52;
                  }

                  World.method653(var2, var25, var28 - 1, var52);
               }

               if(null != var47) {
                  class32.method685(var47);
               }

               class130.method2821();
               Client.field456[++Client.field457 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            class125 var82;
            if(Client.packetOpcode == 100) {
               var82 = Client.field312;
               var2 = Client.field313;
               var87 = var82.offset;
               class34.field750 = 0;
               var4 = 0;
               var82.method2750();

               for(var25 = 0; var25 < class34.field743; ++var25) {
                  var52 = class34.field739[var25];
                  if((class34.field740[var52] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var82.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var82);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else {
                           class33.method689(var82, var52);
                        }
                     }
                  }
               }

               var82.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var82.method2750();

               for(var25 = 0; var25 < class34.field743; ++var25) {
                  var52 = class34.field739[var25];
                  if((class34.field740[var52] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var82.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var82);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else {
                           class33.method689(var82, var52);
                        }
                     }
                  }
               }

               var82.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var82.method2750();

               for(var25 = 0; var25 < class34.field745; ++var25) {
                  var52 = class34.field754[var25];
                  if((class34.field740[var52] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var82.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var82);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else if(class16.method186(var82, var52)) {
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        }
                     }
                  }
               }

               var82.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var82.method2750();

               for(var25 = 0; var25 < class34.field745; ++var25) {
                  var52 = class34.field754[var25];
                  if((class34.field740[var52] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                     } else {
                        var28 = var82.method2762(1);
                        if(var28 == 0) {
                           var4 = class43.method874(var82);
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        } else if(class16.method186(var82, var52)) {
                           class34.field740[var52] = (byte)(class34.field740[var52] | 2);
                        }
                     }
                  }
               }

               var82.method2751();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class34.field743 = 0;
               class34.field745 = 0;

               for(var25 = 1; var25 < 2048; ++var25) {
                  class34.field740[var25] = (byte)(class34.field740[var25] >> 1);
                  var97 = Client.cachedPlayers[var25];
                  if(null != var97) {
                     class34.field739[++class34.field743 - 1] = var25;
                  } else {
                     class34.field754[++class34.field745 - 1] = var25;
                  }
               }

               Player.method38(var82);
               if(var2 != var82.offset - var87) {
                  throw new RuntimeException(var82.offset - var87 + " " + var2);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 32) {
               var1 = Client.field312.method2481();
               if(Client.field312.method2481() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field312.offset += 18;
               } else {
                  --Client.field312.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field312, false);
               }

               Client.field284 = Client.field453;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 72) {
               var1 = Client.field312.method2526();
               var2 = Client.field312.method2526();
               if(null == class172.field2755 || !class172.field2755.isValid()) {
                  try {
                     Iterator var46 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var46.hasNext()) {
                        GarbageCollectorMXBean var23 = (GarbageCollectorMXBean)var46.next();
                        if(var23.isValid()) {
                           class172.field2755 = var23;
                           Client.field546 = -1L;
                           Client.field545 = -1L;
                        }
                     }
                  } catch (Throwable var42) {
                     ;
                  }
               }

               long var24 = class113.method2394();
               var25 = -1;
               if(null != class172.field2755) {
                  var6 = class172.field2755.getCollectionTime();
                  if(-1L != Client.field545) {
                     var104 = var6 - Client.field545;
                     var72 = var24 - Client.field546;
                     if(0L != var72) {
                        var25 = (int)(100L * var104 / var72);
                     }
                  }

                  Client.field545 = var6;
                  Client.field546 = var24;
               }

               Client.field300.method2748(106);
               Client.field300.method2642(var1);
               Client.field300.method2524(var2);
               Client.field300.method2505(GameEngine.FPS);
               Client.field300.method2611(var25);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 54) {
               var82 = Client.field312;
               var2 = Client.field313;
               ClassInfo var3 = new ClassInfo();
               var3.field3171 = var82.method2481();
               var3.field3173 = var82.method2526();
               var3.field3172 = new int[var3.field3171];
               var3.field3176 = new int[var3.field3171];
               var3.fields = new Field[var3.field3171];
               var3.field3175 = new int[var3.field3171];
               var3.methods = new Method[var3.field3171];
               var3.args = new byte[var3.field3171][][];

               for(var4 = 0; var4 < var3.field3171; ++var4) {
                  try {
                     var25 = var82.method2481();
                     String var7;
                     if(var25 != 0 && var25 != 1 && var25 != 2) {
                        if(var25 == 3 || var25 == 4) {
                           var27 = var82.method2503();
                           var7 = var82.method2503();
                           var29 = var82.method2481();
                           String[] var9 = new String[var29];

                           for(var10 = 0; var10 < var29; ++var10) {
                              var9[var10] = var82.method2503();
                           }

                           String var31 = var82.method2503();
                           byte[][] var33 = new byte[var29][];
                           if(var25 == 3) {
                              for(int var12 = 0; var12 < var29; ++var12) {
                                 var13 = var82.method2526();
                                 var33[var12] = new byte[var13];
                                 var82.method2492(var33[var12], 0, var13);
                              }
                           }

                           var3.field3172[var4] = var25;
                           Class[] var32 = new Class[var29];

                           for(var13 = 0; var13 < var29; ++var13) {
                              var32[var13] = XClanMember.method591(var9[var13]);
                           }

                           Class var22 = XClanMember.method591(var31);
                           if(XClanMember.method591(var27).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var14 = XClanMember.method591(var27).getDeclaredMethods();
                           Method[] var34 = var14;

                           for(int var16 = 0; var16 < var34.length; ++var16) {
                              Method var17 = var34[var16];
                              if(var17.getName().equals(var7)) {
                                 Class[] var18 = var17.getParameterTypes();
                                 if(var32.length == var18.length) {
                                    boolean var19 = true;

                                    for(int var20 = 0; var20 < var32.length; ++var20) {
                                       if(var32[var20] != var18[var20]) {
                                          var19 = false;
                                          break;
                                       }
                                    }

                                    if(var19 && var22 == var17.getReturnType()) {
                                       var3.methods[var4] = var17;
                                    }
                                 }
                              }
                           }

                           var3.args[var4] = var33;
                        }
                     } else {
                        var27 = var82.method2503();
                        var7 = var82.method2503();
                        var29 = 0;
                        if(var25 == 1) {
                           var29 = var82.method2526();
                        }

                        var3.field3172[var4] = var25;
                        var3.field3175[var4] = var29;
                        if(XClanMember.method591(var27).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var3.fields[var4] = XClanMember.method591(var27).getDeclaredField(var7);
                     }
                  } catch (ClassNotFoundException var37) {
                     var3.field3176[var4] = -1;
                  } catch (SecurityException var38) {
                     var3.field3176[var4] = -2;
                  } catch (NullPointerException var39) {
                     var3.field3176[var4] = -3;
                  } catch (Exception var40) {
                     var3.field3176[var4] = -4;
                  } catch (Throwable var41) {
                     var3.field3176[var4] = -5;
                  }
               }

               class214.field3181.method3847(var3);
               Client.packetOpcode = -1;
               return true;
            }

            class144.method2970("" + Client.packetOpcode + "," + Client.field318 + "," + Client.field319 + "," + Client.field313, (Throwable)null);
            class152.method3138();
         } catch (IOException var43) {
            if(Client.field548 > 0) {
               class152.method3138();
            } else {
               class112.setGameState(40);
               class75.field1394 = class32.field695;
               class32.field695 = null;
            }
         } catch (Exception var44) {
            var21 = "" + Client.packetOpcode + "," + Client.field318 + "," + Client.field319 + "," + Client.field313 + "," + (TextureProvider.localPlayer.pathX[0] + class23.baseX) + "," + (TextureProvider.localPlayer.pathY[0] + class8.baseY) + ",";

            for(var2 = 0; var2 < Client.field313 && var2 < 50; ++var2) {
               var21 = var21 + Client.field312.payload[var2] + ",";
            }

            class144.method2970(var21, var44);
            class152.method3138();
         }

         return true;
      }
   }
}
