import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("eo")
public class class142 extends Node {
   @ObfuscatedName("c")
   short[] field1996 = new short[128];
   @ObfuscatedName("h")
   class137[] field1997 = new class137[128];
   @ObfuscatedName("k")
   int[] field1999 = new int[128];
   @ObfuscatedName("w")
   byte[] field2000 = new byte[128];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -646845533
   )
   int field2001;
   @ObfuscatedName("u")
   byte[] field2002 = new byte[128];
   @ObfuscatedName("j")
   class55[] field2003 = new class55[128];
   @ObfuscatedName("d")
   byte[] field2005 = new byte[128];

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[IB)Z",
      garbageValue = "-52"
   )
   boolean method2707(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field1999[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1219(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1217(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2003[var7] = var6;
                  this.field1999[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "838437305"
   )
   void method2708() {
      this.field1999 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "-1615253977"
   )
   public static Overlay method2711(int var0) {
      Overlay var1 = (Overlay)Overlay.field3050.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class231.field3298.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method3749(new Buffer(var2), var0);
         }

         var1.method3743();
         Overlay.field3050.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)[LSpritePixels;",
      garbageValue = "50"
   )
   public static SpritePixels[] method2715(class182 var0, String var1, String var2) {
      int var3 = var0.method3321(var1);
      int var4 = var0.method3322(var3, var2);
      return class150.method2804(var0, var3, var4);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-101"
   )
   static final boolean method2717() {
      if(class1.field15 == null) {
         return false;
      } else {
         int var2;
         String var25;
         try {
            int var0 = class1.field15.method2116();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class1.field15.method2119(Client.field357.payload, 0, 1);
               Client.field357.offset = 0;
               Client.packetOpcode = Client.field357.readOpcode();
               Client.field358 = class212.field3135[Client.packetOpcode];
               --var0;
            }

            if(Client.field358 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class1.field15.method2119(Client.field357.payload, 0, 1);
               Client.field358 = Client.field357.payload[0] & 255;
               --var0;
            }

            if(Client.field358 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class1.field15.method2119(Client.field357.payload, 0, 2);
               Client.field357.offset = 0;
               Client.field358 = Client.field357.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field358) {
               return false;
            }

            Client.field357.offset = 0;
            class1.field15.method2119(Client.field357.payload, 0, Client.field358);
            Client.field360 = 0;
            Client.field364 = Client.field363;
            Client.field363 = Client.field483;
            Client.field483 = Client.packetOpcode;
            if(Client.packetOpcode == 209) {
               MessageNode.field261 = Client.field357.method2860();
               class172.field2337 = Client.field357.method2860();
               Client.packetOpcode = -1;
               return true;
            }

            int var1;
            Widget var3;
            if(Client.packetOpcode == 21) {
               var1 = Client.field357.method3006();
               var2 = Client.field357.method2869();
               var3 = World.method670(var1);
               if(var3.modelType != 1 || var3.modelId != var2) {
                  var3.modelType = 1;
                  var3.modelId = var2;
                  class2.method36(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var4;
            int var5;
            int var6;
            int var7;
            int var21;
            if(Client.packetOpcode == 25) {
               Client.field440 = true;
               class104.field1701 = Client.field357.readUnsignedByte();
               FaceNormal.field1578 = Client.field357.readUnsignedByte();
               Ignore.field240 = Client.field357.readUnsignedShort();
               class97.field1646 = Client.field357.readUnsignedByte();
               XGrandExchangeOffer.field47 = Client.field357.readUnsignedByte();
               if(XGrandExchangeOffer.field47 >= 100) {
                  var1 = 64 + class104.field1701 * 128;
                  var2 = FaceNormal.field1578 * 128 + 64;
                  var21 = class1.method21(var1, var2, class31.plane) - Ignore.field240;
                  var4 = var1 - class65.cameraX;
                  var5 = var21 - class8.cameraZ;
                  var6 = var2 - CombatInfoListHolder.cameraY;
                  var7 = (int)Math.sqrt((double)(var4 * var4 + var6 * var6));
                  class25.cameraPitch = (int)(Math.atan2((double)var5, (double)var7) * 325.949D) & 2047;
                  class108.cameraYaw = (int)(Math.atan2((double)var4, (double)var6) * -325.949D) & 2047;
                  if(class25.cameraPitch < 128) {
                     class25.cameraPitch = 128;
                  }

                  if(class25.cameraPitch > 383) {
                     class25.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 88) {
               var1 = Client.field357.readUnsignedShort();
               var2 = Client.field357.readUnsignedByte();
               var21 = Client.field357.readUnsignedShort();
               method2719(var1, var2, var21);
               Client.packetOpcode = -1;
               return true;
            }

            boolean var75;
            if(Client.packetOpcode == 80) {
               var75 = Client.field357.readUnsignedByte() == 1;
               if(var75) {
                  class177.field2662 = class99.method2005() - Client.field357.readLong();
                  class104.field1702 = new class1(Client.field357, true);
               } else {
                  class104.field1702 = null;
               }

               Client.field509 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 41) {
               var1 = Client.field357.readLittleEndianShort();
               var2 = Client.field357.readInt();
               class165.settings[var1] = var2;
               if(class165.widgetSettings[var1] != var2) {
                  class165.widgetSettings[var1] = var2;
               }

               Player.method263(var1);
               Client.field499[++Client.field500 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var22;
            if(Client.packetOpcode == 68) {
               var1 = Client.field357.readUnsignedShort();
               var2 = Client.field357.readUnsignedShort();
               var21 = Client.field357.method3006();
               var22 = World.method670(var21);
               var22.field2242 = var1 + (var2 << 16);
               Client.packetOpcode = -1;
               return true;
            }

            int var8;
            WidgetNode var77;
            if(Client.packetOpcode == 24) {
               var1 = Client.field358 + Client.field357.offset;
               var2 = Client.field357.readUnsignedShort();
               var21 = Client.field357.readUnsignedShort();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  class94.method1978(false);
                  class195.method3577(Client.widgetRoot);
                  class44.method889(Client.widgetRoot);

                  for(var4 = 0; var4 < 100; ++var4) {
                     Client.field518[var4] = true;
                  }
               }

               WidgetNode var84;
               for(; var21-- > 0; var84.field211 = true) {
                  var4 = Client.field357.readInt();
                  var5 = Client.field357.readUnsignedShort();
                  var6 = Client.field357.readUnsignedByte();
                  var84 = (WidgetNode)Client.componentTable.method2405((long)var4);
                  if(var84 != null && var84.id != var5) {
                     XGrandExchangeOffer.method65(var84, true);
                     var84 = null;
                  }

                  if(var84 == null) {
                     var84 = class18.method211(var4, var5, var6);
                  }
               }

               for(var77 = (WidgetNode)Client.componentTable.method2391(); var77 != null; var77 = (WidgetNode)Client.componentTable.method2392()) {
                  if(var77.field211) {
                     var77.field211 = false;
                  } else {
                     XGrandExchangeOffer.method65(var77, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field357.offset < var1) {
                  var4 = Client.field357.readInt();
                  var5 = Client.field357.readUnsignedShort();
                  var6 = Client.field357.readUnsignedShort();
                  var7 = Client.field357.readInt();

                  for(var8 = var5; var8 <= var6; ++var8) {
                     long var9 = (long)var8 + ((long)var4 << 32);
                     Client.widgetFlags.method2403(new class133(var7), var9);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var24;
            boolean var59;
            NPC var66;
            NPC var83;
            if(Client.packetOpcode == 210) {
               Client.field436 = 0;
               Client.field353 = 0;
               Client.field357.method3085();
               var1 = Client.field357.method3097(8);
               if(var1 < Client.field351) {
                  for(var2 = var1; var2 < Client.field351; ++var2) {
                     Client.field437[++Client.field436 - 1] = Client.field570[var2];
                  }
               }

               if(var1 > Client.field351) {
                  throw new RuntimeException("");
               }

               Client.field351 = 0;

               for(var2 = 0; var2 < var1; ++var2) {
                  var21 = Client.field570[var2];
                  var83 = Client.cachedNPCs[var21];
                  var5 = Client.field357.method3097(1);
                  if(var5 == 0) {
                     Client.field570[++Client.field351 - 1] = var21;
                     var83.field648 = Client.gameCycle;
                  } else {
                     var6 = Client.field357.method3097(2);
                     if(var6 == 0) {
                        Client.field570[++Client.field351 - 1] = var21;
                        var83.field648 = Client.gameCycle;
                        Client.field430[++Client.field353 - 1] = var21;
                     } else if(var6 == 1) {
                        Client.field570[++Client.field351 - 1] = var21;
                        var83.field648 = Client.gameCycle;
                        var7 = Client.field357.method3097(3);
                        var83.method779(var7, (byte)1);
                        var8 = Client.field357.method3097(1);
                        if(var8 == 1) {
                           Client.field430[++Client.field353 - 1] = var21;
                        }
                     } else if(var6 == 2) {
                        Client.field570[++Client.field351 - 1] = var21;
                        var83.field648 = Client.gameCycle;
                        var7 = Client.field357.method3097(3);
                        var83.method779(var7, (byte)2);
                        var8 = Client.field357.method3097(3);
                        var83.method779(var8, (byte)2);
                        var24 = Client.field357.method3097(1);
                        if(var24 == 1) {
                           Client.field430[++Client.field353 - 1] = var21;
                        }
                     } else if(var6 == 3) {
                        Client.field437[++Client.field436 - 1] = var21;
                     }
                  }
               }

               while(Client.field357.method3080(Client.field358) >= 27) {
                  var1 = Client.field357.method3097(15);
                  if(var1 == 32767) {
                     break;
                  }

                  var59 = false;
                  if(Client.cachedNPCs[var1] == null) {
                     Client.cachedNPCs[var1] = new NPC();
                     var59 = true;
                  }

                  var66 = Client.cachedNPCs[var1];
                  Client.field570[++Client.field351 - 1] = var1;
                  var66.field648 = Client.gameCycle;
                  var4 = Client.field357.method3097(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }

                  var5 = Client.field441[Client.field357.method3097(3)];
                  if(var59) {
                     var66.field676 = var66.angle = var5;
                  }

                  var66.composition = VertexNormal.getNpcDefinition(Client.field357.method3097(14));
                  var6 = Client.field357.method3097(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }

                  var7 = Client.field357.method3097(1);
                  if(var7 == 1) {
                     Client.field430[++Client.field353 - 1] = var1;
                  }

                  var8 = Client.field357.method3097(1);
                  var66.field672 = var66.composition.field3008;
                  var66.field678 = var66.composition.field3031;
                  if(var66.field678 == 0) {
                     var66.angle = 0;
                  }

                  var66.field667 = var66.composition.field3033;
                  var66.field634 = var66.composition.field3015;
                  var66.field635 = var66.composition.field3005;
                  var66.field668 = var66.composition.field3017;
                  var66.idlePoseAnimation = var66.composition.field3011;
                  var66.field684 = var66.composition.field3038;
                  var66.field632 = var66.composition.field3019;
                  var66.method783(var4 + class22.localPlayer.pathX[0], class22.localPlayer.pathY[0] + var6, var8 == 1);
               }

               Client.field357.method3082();
               CombatInfo2.method3555();

               for(var1 = 0; var1 < Client.field436; ++var1) {
                  var2 = Client.field437[var1];
                  if(Client.gameCycle != Client.cachedNPCs[var2].field648) {
                     Client.cachedNPCs[var2].composition = null;
                     Client.cachedNPCs[var2] = null;
                  }
               }

               if(Client.field358 != Client.field357.offset) {
                  throw new RuntimeException(Client.field357.offset + "," + Client.field358);
               }

               for(var1 = 0; var1 < Client.field351; ++var1) {
                  if(Client.cachedNPCs[Client.field570[var1]] == null) {
                     throw new RuntimeException(var1 + "," + Client.field351);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 118) {
               Client.field357.offset += 28;
               if(Client.field357.method2885()) {
                  class22.method237(Client.field357, Client.field357.offset - 28);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 14) {
               Client.field549 = Client.field357.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 223) {
               class13.method198();
               Client.weight = Client.field357.readShort();
               Client.field510 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 156) {
               var1 = Client.field357.readInt();
               var2 = Client.field357.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var3 = World.method670(var1);
               } else {
                  var3 = null;
               }

               if(var3 != null) {
                  for(var4 = 0; var4 < var3.itemIds.length; ++var4) {
                     var3.itemIds[var4] = 0;
                     var3.itemQuantities[var4] = 0;
                  }
               }

               class155.method3046(var2);
               var4 = Client.field357.readUnsignedShort();

               for(var5 = 0; var5 < var4; ++var5) {
                  var6 = Client.field357.method2858();
                  if(var6 == 255) {
                     var6 = Client.field357.readInt();
                  }

                  var7 = Client.field357.readLittleEndianShort();
                  if(null != var3 && var5 < var3.itemIds.length) {
                     var3.itemIds[var5] = var7;
                     var3.itemQuantities[var5] = var6;
                  }

                  class101.method2017(var2, var5, var7 - 1, var6);
               }

               if(null != var3) {
                  class2.method36(var3);
               }

               class13.method198();
               Client.interfaceItemTriggers[++Client.field502 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 47) {
               var1 = Client.field357.method2869();
               CombatInfoListHolder.method775(var1);
               Client.interfaceItemTriggers[++Client.field502 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 106) {
               for(var1 = 0; var1 < class165.widgetSettings.length; ++var1) {
                  if(class165.settings[var1] != class165.widgetSettings[var1]) {
                     class165.widgetSettings[var1] = class165.settings[var1];
                     Player.method263(var1);
                     Client.field499[++Client.field500 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var26;
            long var28;
            long var31;
            if(Client.packetOpcode == 237) {
               var25 = Client.field357.readString();
               var26 = (long)Client.field357.readUnsignedShort();
               var28 = (long)Client.field357.read24BitInt();
               class177[] var95 = new class177[]{class177.field2655, class177.field2659, class177.field2653, class177.field2652, class177.field2657, class177.field2654};
               class177 var82 = (class177)class5.method77(var95, Client.field357.readUnsignedByte());
               var31 = var28 + (var26 << 32);
               boolean var70 = false;

               for(int var72 = 0; var72 < 100; ++var72) {
                  if(var31 == Client.field555[var72]) {
                     var70 = true;
                     break;
                  }
               }

               if(GameEngine.method2242(var25)) {
                  var70 = true;
               }

               if(!var70 && Client.field432 == 0) {
                  Client.field555[Client.field535] = var31;
                  Client.field535 = (Client.field535 + 1) % 100;
                  String var96 = FontTypeFace.method3880(XGrandExchangeOffer.method64(class174.method3270(Client.field357)));
                  byte var74;
                  if(var82.field2661) {
                     var74 = 7;
                  } else {
                     var74 = 3;
                  }

                  if(var82.field2658 != -1) {
                     class30.sendGameMessage(var74, class112.method2140(var82.field2658) + var25, var96);
                  } else {
                     class30.sendGameMessage(var74, var25, var96);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 201) {
               var1 = Client.field357.readUnsignedShort();
               var2 = Client.field357.method3006();
               var3 = World.method670(var2);
               if(null != var3 && var3.type == 0) {
                  if(var1 > var3.scrollHeight - var3.height) {
                     var1 = var3.scrollHeight - var3.height;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var3.scrollY != var1) {
                     var3.scrollY = var1;
                     class2.method36(var3);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            String var60;
            boolean var62;
            String var98;
            if(Client.packetOpcode == 221) {
               while(Client.field357.offset < Client.field358) {
                  var75 = Client.field357.readUnsignedByte() == 1;
                  var98 = Client.field357.readString();
                  var60 = Client.field357.readString();
                  var4 = Client.field357.readUnsignedShort();
                  var5 = Client.field357.readUnsignedByte();
                  var6 = Client.field357.readUnsignedByte();
                  boolean var67 = (var6 & 2) != 0;
                  boolean var71 = (var6 & 1) != 0;
                  if(var4 > 0) {
                     Client.field357.readString();
                     Client.field357.readUnsignedByte();
                     Client.field357.readInt();
                  }

                  Client.field357.readString();

                  for(var24 = 0; var24 < Client.friendCount; ++var24) {
                     Friend var99 = Client.friends[var24];
                     if(!var75) {
                        if(var98.equals(var99.name)) {
                           if(var4 != var99.world) {
                              boolean var11 = true;

                              for(class16 var102 = (class16)Client.field583.method2479(); null != var102; var102 = (class16)Client.field583.method2481()) {
                                 if(var102.field202.equals(var98)) {
                                    if(var4 != 0 && var102.field201 == 0) {
                                       var102.method2491();
                                       var11 = false;
                                    } else if(var4 == 0 && var102.field201 != 0) {
                                       var102.method2491();
                                       var11 = false;
                                    }
                                 }
                              }

                              if(var11) {
                                 Client.field583.method2480(new class16(var98, var4));
                              }

                              var99.world = var4;
                           }

                           var99.previousName = var60;
                           var99.rank = var5;
                           var99.field174 = var67;
                           var99.field172 = var71;
                           var98 = null;
                           break;
                        }
                     } else if(var60.equals(var99.name)) {
                        var99.name = var98;
                        var99.previousName = var60;
                        var98 = null;
                        break;
                     }
                  }

                  if(var98 != null && Client.friendCount < 400) {
                     Friend var105 = new Friend();
                     Client.friends[Client.friendCount] = var105;
                     var105.name = var98;
                     var105.previousName = var60;
                     var105.world = var4;
                     var105.rank = var5;
                     var105.field174 = var67;
                     var105.field172 = var71;
                     ++Client.friendCount;
                  }
               }

               Client.field375 = 2;
               Client.field506 = Client.field498;
               var75 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var75 = true;
                  --var2;

                  for(var21 = 0; var21 < var2; ++var21) {
                     var62 = false;
                     Friend var110 = Client.friends[var21];
                     Friend var94 = Client.friends[var21 + 1];
                     if(var110.world != Client.world && Client.world == var94.world) {
                        var62 = true;
                     }

                     if(!var62 && var110.world == 0 && var94.world != 0) {
                        var62 = true;
                     }

                     if(!var62 && !var110.field174 && var94.field174) {
                        var62 = true;
                     }

                     if(!var62 && !var110.field172 && var94.field172) {
                        var62 = true;
                     }

                     if(var62) {
                        Friend var80 = Client.friends[var21];
                        Client.friends[var21] = Client.friends[var21 + 1];
                        Client.friends[1 + var21] = var80;
                        var75 = false;
                     }
                  }

                  if(var75) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 208) {
               World var90 = new World();
               var90.address = Client.field357.readString();
               var90.id = Client.field357.readUnsignedShort();
               var2 = Client.field357.readInt();
               var90.mask = var2;
               class187.setGameState(45);
               class1.field15.method2115();
               class1.field15 = null;
               ItemLayer.method1518(var90);
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 49) {
               Client.field307 = Client.field357.readUnsignedByte();
               Client.field532 = Client.field357.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 28) {
               var1 = Client.field357.readUnsignedShort();
               Client.widgetRoot = var1;
               class94.method1978(false);
               class195.method3577(var1);
               class44.method889(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field518[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 206) {
               Client.field440 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field508[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 92) {
               var2 = Client.field357.readUnsignedByte();
               class216[] var68 = new class216[]{class216.field3178, class216.field3181, class216.field3179};
               class216[] var85 = var68;
               var5 = 0;

               class216 var89;
               while(true) {
                  if(var5 >= var85.length) {
                     var89 = null;
                     break;
                  }

                  class216 var93 = var85[var5];
                  if(var2 == var93.field3180) {
                     var89 = var93;
                     break;
                  }

                  ++var5;
               }

               class107.field1740 = var89;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 195) {
               var1 = Client.field357.readLittleEndianShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               if(var1 == -1 && !Client.field552) {
                  class138.field1919.method2536();
                  class138.field1920 = 1;
                  class138.field1916 = null;
               } else if(var1 != -1 && Client.field445 != var1 && Client.field550 != 0 && !Client.field552) {
                  class184 var103 = class3.field39;
                  var21 = Client.field550;
                  class138.field1920 = 1;
                  class138.field1916 = var103;
                  class138.field1922 = var1;
                  class8.field86 = 0;
                  Ignore.field245 = var21;
                  class138.field1923 = false;
                  XClanMember.field302 = 2;
               }

               Client.field445 = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 60) {
               var1 = Client.field357.method2872();
               var2 = Client.field357.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(Client.field550 != 0 && var2 != -1) {
                  class40.method821(class1.field12, var2, 0, Client.field550, false);
                  Client.field552 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 168 || Client.packetOpcode == 23 || Client.packetOpcode == 97 || Client.packetOpcode == 232 || Client.packetOpcode == 73 || Client.packetOpcode == 251 || Client.packetOpcode == 143 || Client.packetOpcode == 29 || Client.packetOpcode == 186 || Client.packetOpcode == 117) {
               XItemContainer.method189();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 61) {
               var1 = Client.field357.method2997();
               var98 = Client.field357.readString();
               var21 = Client.field357.readUnsignedByte();
               if(var21 >= 1 && var21 <= 8) {
                  if(var98.equalsIgnoreCase("null")) {
                     var98 = null;
                  }

                  Client.playerOptions[var21 - 1] = var98;
                  Client.playerOptionsPriority[var21 - 1] = var1 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 129) {
               Client.field440 = true;
               class103.field1685 = Client.field357.readUnsignedByte();
               class204.field3090 = Client.field357.readUnsignedByte();
               ObjectComposition.field2945 = Client.field357.readUnsignedShort();
               class47.field950 = Client.field357.readUnsignedByte();
               class9.field100 = Client.field357.readUnsignedByte();
               if(class9.field100 >= 100) {
                  class65.cameraX = 64 + class103.field1685 * 128;
                  CombatInfoListHolder.cameraY = class204.field3090 * 128 + 64;
                  class8.cameraZ = class1.method21(class65.cameraX, CombatInfoListHolder.cameraY, class31.plane) - ObjectComposition.field2945;
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var107;
            if(Client.packetOpcode == 217) {
               var1 = Client.field357.method2869();
               var2 = Client.field357.method2869();
               var21 = Client.field357.readLittleEndianShort();
               var4 = Client.field357.method2876();
               var107 = World.method670(var4);
               if(var107.rotationX != var1 || var107.rotationZ != var2 || var107.field2240 != var21) {
                  var107.rotationX = var1;
                  var107.rotationZ = var2;
                  var107.field2240 = var21;
                  class2.method36(var107);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 43) {
               Client.field436 = 0;
               Client.field353 = 0;
               Client.field357.method3085();
               var1 = Client.field357.method3097(8);
               if(var1 < Client.field351) {
                  for(var2 = var1; var2 < Client.field351; ++var2) {
                     Client.field437[++Client.field436 - 1] = Client.field570[var2];
                  }
               }

               if(var1 > Client.field351) {
                  throw new RuntimeException("");
               }

               Client.field351 = 0;

               for(var2 = 0; var2 < var1; ++var2) {
                  var21 = Client.field570[var2];
                  var83 = Client.cachedNPCs[var21];
                  var5 = Client.field357.method3097(1);
                  if(var5 == 0) {
                     Client.field570[++Client.field351 - 1] = var21;
                     var83.field648 = Client.gameCycle;
                  } else {
                     var6 = Client.field357.method3097(2);
                     if(var6 == 0) {
                        Client.field570[++Client.field351 - 1] = var21;
                        var83.field648 = Client.gameCycle;
                        Client.field430[++Client.field353 - 1] = var21;
                     } else if(var6 == 1) {
                        Client.field570[++Client.field351 - 1] = var21;
                        var83.field648 = Client.gameCycle;
                        var7 = Client.field357.method3097(3);
                        var83.method779(var7, (byte)1);
                        var8 = Client.field357.method3097(1);
                        if(var8 == 1) {
                           Client.field430[++Client.field353 - 1] = var21;
                        }
                     } else if(var6 == 2) {
                        Client.field570[++Client.field351 - 1] = var21;
                        var83.field648 = Client.gameCycle;
                        var7 = Client.field357.method3097(3);
                        var83.method779(var7, (byte)2);
                        var8 = Client.field357.method3097(3);
                        var83.method779(var8, (byte)2);
                        var24 = Client.field357.method3097(1);
                        if(var24 == 1) {
                           Client.field430[++Client.field353 - 1] = var21;
                        }
                     } else if(var6 == 3) {
                        Client.field437[++Client.field436 - 1] = var21;
                     }
                  }
               }

               while(Client.field357.method3080(Client.field358) >= 27) {
                  var1 = Client.field357.method3097(15);
                  if(var1 == 32767) {
                     break;
                  }

                  var59 = false;
                  if(null == Client.cachedNPCs[var1]) {
                     Client.cachedNPCs[var1] = new NPC();
                     var59 = true;
                  }

                  var66 = Client.cachedNPCs[var1];
                  Client.field570[++Client.field351 - 1] = var1;
                  var66.field648 = Client.gameCycle;
                  var4 = Client.field357.method3097(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }

                  var5 = Client.field441[Client.field357.method3097(3)];
                  if(var59) {
                     var66.field676 = var66.angle = var5;
                  }

                  var66.composition = VertexNormal.getNpcDefinition(Client.field357.method3097(14));
                  var6 = Client.field357.method3097(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }

                  var7 = Client.field357.method3097(1);
                  if(var7 == 1) {
                     Client.field430[++Client.field353 - 1] = var1;
                  }

                  var8 = Client.field357.method3097(1);
                  var66.field672 = var66.composition.field3008;
                  var66.field678 = var66.composition.field3031;
                  if(var66.field678 == 0) {
                     var66.angle = 0;
                  }

                  var66.field667 = var66.composition.field3033;
                  var66.field634 = var66.composition.field3015;
                  var66.field635 = var66.composition.field3005;
                  var66.field668 = var66.composition.field3017;
                  var66.idlePoseAnimation = var66.composition.field3011;
                  var66.field684 = var66.composition.field3038;
                  var66.field632 = var66.composition.field3019;
                  var66.method783(class22.localPlayer.pathX[0] + var4, class22.localPlayer.pathY[0] + var6, var8 == 1);
               }

               Client.field357.method3082();
               CombatInfo2.method3555();

               for(var1 = 0; var1 < Client.field436; ++var1) {
                  var2 = Client.field437[var1];
                  if(Client.gameCycle != Client.cachedNPCs[var2].field648) {
                     Client.cachedNPCs[var2].composition = null;
                     Client.cachedNPCs[var2] = null;
                  }
               }

               if(Client.field357.offset != Client.field358) {
                  throw new RuntimeException(Client.field357.offset + "," + Client.field358);
               }

               for(var1 = 0; var1 < Client.field351; ++var1) {
                  if(Client.cachedNPCs[Client.field570[var1]] == null) {
                     throw new RuntimeException(var1 + "," + Client.field351);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 202) {
               var1 = Client.field357.readUnsignedByte();
               var2 = Client.field357.readUnsignedByte();
               var21 = Client.field357.readUnsignedByte();
               var4 = Client.field357.readUnsignedByte();
               Client.field508[var1] = true;
               Client.field563[var1] = var2;
               Client.field564[var1] = var21;
               Client.field354[var1] = var4;
               Client.field566[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var61;
            if(Client.packetOpcode == 155) {
               var25 = Client.field357.readString();
               var2 = Client.field357.readUnsignedShort();
               byte var86 = Client.field357.readByte();
               var62 = false;
               if(var86 == -128) {
                  var62 = true;
               }

               if(var62) {
                  if(class9.clanChatCount == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var61 = false;

                  for(var5 = 0; var5 < class9.clanChatCount && (!class137.clanMembers[var5].username.equals(var25) || class137.clanMembers[var5].world != var2); ++var5) {
                     ;
                  }

                  if(var5 < class9.clanChatCount) {
                     while(var5 < class9.clanChatCount - 1) {
                        class137.clanMembers[var5] = class137.clanMembers[1 + var5];
                        ++var5;
                     }

                     --class9.clanChatCount;
                     class137.clanMembers[class9.clanChatCount] = null;
                  }
               } else {
                  Client.field357.readString();
                  XClanMember var109 = new XClanMember();
                  var109.username = var25;
                  var109.field304 = GroundObject.method1598(var109.username, class165.field2155);
                  var109.world = var2;
                  var109.rank = var86;

                  for(var6 = class9.clanChatCount - 1; var6 >= 0; --var6) {
                     var7 = class137.clanMembers[var6].field304.compareTo(var109.field304);
                     if(var7 == 0) {
                        class137.clanMembers[var6].world = var2;
                        class137.clanMembers[var6].rank = var86;
                        if(var25.equals(class22.localPlayer.name)) {
                           class9.field103 = var86;
                        }

                        Client.field507 = Client.field498;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(class9.clanChatCount >= class137.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var7 = class9.clanChatCount - 1; var7 > var6; --var7) {
                     class137.clanMembers[var7 + 1] = class137.clanMembers[var7];
                  }

                  if(class9.clanChatCount == 0) {
                     class137.clanMembers = new XClanMember[100];
                  }

                  class137.clanMembers[1 + var6] = var109;
                  ++class9.clanChatCount;
                  if(var25.equals(class22.localPlayer.name)) {
                     class9.field103 = var86;
                  }
               }

               Client.field507 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 121) {
               VertexNormal.method1692();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 170) {
               class172.field2337 = Client.field357.readUnsignedByte();
               MessageNode.field261 = Client.field357.readUnsignedByte();

               for(var1 = class172.field2337; var1 < 8 + class172.field2337; ++var1) {
                  for(var2 = MessageNode.field261; var2 < MessageNode.field261 + 8; ++var2) {
                     if(Client.groundItemDeque[class31.plane][var1][var2] != null) {
                        Client.groundItemDeque[class31.plane][var1][var2] = null;
                        XGrandExchangeOffer.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class25 var88 = (class25)Client.field444.method2448(); null != var88; var88 = (class25)Client.field444.method2445()) {
                  if(var88.field598 >= class172.field2337 && var88.field598 < 8 + class172.field2337 && var88.field600 >= MessageNode.field261 && var88.field600 < 8 + MessageNode.field261 && var88.field599 == class31.plane) {
                     var88.field596 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 247) {
               var25 = Client.field357.readString();
               Object[] var101 = new Object[var25.length() + 1];

               for(var21 = var25.length() - 1; var21 >= 0; --var21) {
                  if(var25.charAt(var21) == 115) {
                     var101[1 + var21] = Client.field357.readString();
                  } else {
                     var101[var21 + 1] = new Integer(Client.field357.readInt());
                  }
               }

               var101[0] = new Integer(Client.field357.readInt());
               class18 var65 = new class18();
               var65.field232 = var101;
               Frames.method1963(var65);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 122) {
               var1 = Client.field357.readLittleEndianShort();
               byte var69 = Client.field357.method2897();
               class165.settings[var1] = var69;
               if(var69 != class165.widgetSettings[var1]) {
                  class165.widgetSettings[var1] = var69;
               }

               Player.method263(var1);
               Client.field499[++Client.field500 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 179) {
               var1 = Client.field357.method3013();
               var59 = Client.field357.readUnsignedByte() == 1;
               var60 = "";
               var62 = false;
               if(var59) {
                  var60 = Client.field357.readString();
                  if(GameEngine.method2242(var60)) {
                     var62 = true;
                  }
               }

               String var108 = Client.field357.readString();
               if(!var62) {
                  class30.sendGameMessage(var1, var60, var108);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 72) {
               var25 = Client.field357.readString();
               var98 = FontTypeFace.method3880(XGrandExchangeOffer.method64(class174.method3270(Client.field357)));
               class30.sendGameMessage(6, var25, var98);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 242) {
               var1 = Client.field357.method2868();
               var2 = Client.field357.method2870();
               var3 = World.method670(var1);
               if(var3.field2233 != var2 || var2 == -1) {
                  var3.field2233 = var2;
                  var3.field2308 = 0;
                  var3.field2213 = 0;
                  class2.method36(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var41;
            long var43;
            if(Client.packetOpcode == 65) {
               var1 = Client.field357.readInt();
               var2 = Client.field357.readInt();
               if(class39.field832 == null || !class39.field832.isValid()) {
                  try {
                     Iterator var64 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var64.hasNext()) {
                        GarbageCollectorMXBean var81 = (GarbageCollectorMXBean)var64.next();
                        if(var81.isValid()) {
                           class39.field832 = var81;
                           Client.field591 = -1L;
                           Client.field366 = -1L;
                        }
                     }
                  } catch (Throwable var55) {
                     ;
                  }
               }

               long var39 = class99.method2005();
               var5 = -1;
               if(null != class39.field832) {
                  var41 = class39.field832.getCollectionTime();
                  if(-1L != Client.field366) {
                     var31 = var41 - Client.field366;
                     var43 = var39 - Client.field591;
                     if(0L != var43) {
                        var5 = (int)(var31 * 100L / var43);
                     }
                  }

                  Client.field366 = var41;
                  Client.field591 = var39;
               }

               Client.field309.putOpcode(178);
               Client.field309.putInt(var1);
               Client.field309.method2874(var2);
               Client.field309.method2962(GameEngine.FPS);
               Client.field309.method2962(var5);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 226) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(null != Client.cachedPlayers[var1]) {
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

            if(Client.packetOpcode == 167) {
               FrameMap.xteaChanged(false);
               Client.field357.readOpcode();
               var1 = Client.field357.readUnsignedShort();
               class18.method209(Client.field357, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 119) {
               var1 = Client.field357.readInt();
               var2 = Client.field357.method3006();
               WidgetNode var63 = (WidgetNode)Client.componentTable.method2405((long)var2);
               var77 = (WidgetNode)Client.componentTable.method2405((long)var1);
               if(var77 != null) {
                  XGrandExchangeOffer.method65(var77, null == var63 || var77.id != var63.id);
               }

               if(null != var63) {
                  var63.unlink();
                  Client.componentTable.method2403(var63, (long)var1);
               }

               var107 = World.method670(var2);
               if(null != var107) {
                  class2.method36(var107);
               }

               var107 = World.method670(var1);
               if(var107 != null) {
                  class2.method36(var107);
                  class107.method2100(Widget.widgets[var107.id >>> 16], var107, true);
               }

               if(Client.widgetRoot != -1) {
                  var6 = Client.widgetRoot;
                  if(class44.method892(var6)) {
                     CombatInfo1.method628(Widget.widgets[var6], 1);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 81) {
               for(var1 = 0; var1 < class187.field2768; ++var1) {
                  class187 var100 = class108.method2103(var1);
                  if(null != var100) {
                     class165.settings[var1] = 0;
                     class165.widgetSettings[var1] = 0;
                  }
               }

               class13.method198();
               Client.field500 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var97;
            if(Client.packetOpcode == 133) {
               var1 = Client.field357.readInt();
               var97 = World.method670(var1);

               for(var21 = 0; var21 < var97.itemIds.length; ++var21) {
                  var97.itemIds[var21] = -1;
                  var97.itemIds[var21] = 0;
               }

               class2.method36(var97);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 86) {
               var1 = Client.field357.readUnsignedByte();
               if(Client.field357.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field357.offset += 18;
               } else {
                  --Client.field357.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field357, false);
               }

               Client.field545 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 151) {
               class13.method198();
               Client.energy = Client.field357.readUnsignedByte();
               Client.field510 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               Spotanim.method3484();

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               Ignore.method216(Client.field357);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 166) {
               while(Client.field357.offset < Client.field358) {
                  var1 = Client.field357.readUnsignedByte();
                  var59 = (var1 & 1) == 1;
                  var60 = Client.field357.readString();
                  String var78 = Client.field357.readString();
                  Client.field357.readString();

                  for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                     Ignore var92 = Client.ignores[var5];
                     if(var59) {
                        if(var78.equals(var92.name)) {
                           var92.name = var60;
                           var92.previousName = var78;
                           var60 = null;
                           break;
                        }
                     } else if(var60.equals(var92.name)) {
                        var92.name = var60;
                        var92.previousName = var78;
                        var60 = null;
                        break;
                     }
                  }

                  if(null != var60 && Client.ignoreCount < 400) {
                     Ignore var106 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var106;
                     var106.name = var60;
                     var106.previousName = var78;
                     ++Client.ignoreCount;
                  }
               }

               Client.field506 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            int var13;
            if(Client.packetOpcode == 238) {
               var25 = Client.field357.readString();
               var26 = Client.field357.readLong();
               var28 = (long)Client.field357.readUnsignedShort();
               var41 = (long)Client.field357.read24BitInt();
               class177[] var111 = new class177[]{class177.field2655, class177.field2659, class177.field2653, class177.field2652, class177.field2657, class177.field2654};
               class177 var104 = (class177)class5.method77(var111, Client.field357.readUnsignedByte());
               var43 = (var28 << 32) + var41;
               boolean var73 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if(Client.field555[var13] == var43) {
                     var73 = true;
                     break;
                  }
               }

               if(var104.field2660 && GameEngine.method2242(var25)) {
                  var73 = true;
               }

               if(!var73 && Client.field432 == 0) {
                  Client.field555[Client.field535] = var43;
                  Client.field535 = (Client.field535 + 1) % 100;
                  String var112 = FontTypeFace.method3880(XGrandExchangeOffer.method64(class174.method3270(Client.field357)));
                  if(var104.field2658 != -1) {
                     class8.addChatMessage(9, class112.method2140(var104.field2658) + var25, var112, class167.method3196(var26));
                  } else {
                     class8.addChatMessage(9, var25, var112, class167.method3196(var26));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 51) {
               var1 = Client.field357.method2868();
               var98 = Client.field357.readString();
               var3 = World.method670(var1);
               if(!var98.equals(var3.text)) {
                  var3.text = var98;
                  class2.method36(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 204) {
               var1 = Client.field357.method2876();
               var97 = World.method670(var1);
               var97.modelType = 3;
               var97.modelId = class22.localPlayer.composition.method3168();
               class2.method36(var97);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 140) {
               var1 = Client.field357.readLittleEndianShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field357.method2876();
               var21 = Client.field357.readInt();
               var4 = Client.field357.readUnsignedShort();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               for(var5 = var4; var5 <= var1; ++var5) {
                  var41 = ((long)var2 << 32) + (long)var5;
                  Node var45 = Client.widgetFlags.method2405(var41);
                  if(var45 != null) {
                     var45.unlink();
                  }

                  Client.widgetFlags.method2403(new class133(var21), var41);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 77) {
               FrameMap.xteaChanged(true);
               Client.field357.readOpcode();
               var1 = Client.field357.readUnsignedShort();
               class18.method209(Client.field357, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 176) {
               var1 = Client.field357.readInt();
               WidgetNode var34 = (WidgetNode)Client.componentTable.method2405((long)var1);
               if(var34 != null) {
                  XGrandExchangeOffer.method65(var34, true);
               }

               if(null != Client.field477) {
                  class2.method36(Client.field477);
                  Client.field477 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 32) {
               Client.field375 = 1;
               Client.field506 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 99) {
               Client.flagX = Client.field357.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field357.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 190) {
               class13.method198();
               var1 = Client.field357.method3006();
               var2 = Client.field357.method2860();
               var21 = Client.field357.method2858();
               Client.skillExperiences[var21] = var1;
               Client.boostedSkillLevels[var21] = var2;
               Client.realSkillLevels[var21] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var1 >= class172.field2333[var4]) {
                     Client.realSkillLevels[var21] = var4 + 2;
                  }
               }

               Client.field516[++Client.field504 - 1 & 31] = var21;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 76) {
               var1 = Client.field357.readUnsignedShort();
               var2 = Client.field357.readUnsignedByte();
               var21 = Client.field357.method2868();
               var77 = (WidgetNode)Client.componentTable.method2405((long)var21);
               if(var77 != null) {
                  XGrandExchangeOffer.method65(var77, var77.id != var1);
               }

               class18.method211(var21, var1, var2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 136) {
               Client.field507 = Client.field498;
               if(Client.field358 == 0) {
                  Client.field540 = null;
                  Client.clanChatOwner = null;
                  class9.clanChatCount = 0;
                  class137.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.clanChatOwner = Client.field357.readString();
               long var47 = Client.field357.readLong();
               Client.field540 = ChatLineBuffer.method980(var47);
               class107.field1746 = Client.field357.readByte();
               var21 = Client.field357.readUnsignedByte();
               if(var21 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               class9.clanChatCount = var21;
               XClanMember[] var76 = new XClanMember[100];

               for(var5 = 0; var5 < class9.clanChatCount; ++var5) {
                  var76[var5] = new XClanMember();
                  var76[var5].username = Client.field357.readString();
                  var76[var5].field304 = GroundObject.method1598(var76[var5].username, class165.field2155);
                  var76[var5].world = Client.field357.readUnsignedShort();
                  var76[var5].rank = Client.field357.readByte();
                  Client.field357.readString();
                  if(var76[var5].username.equals(class22.localPlayer.name)) {
                     class9.field103 = var76[var5].rank;
                  }
               }

               var61 = false;
               var7 = class9.clanChatCount;

               while(var7 > 0) {
                  var61 = true;
                  --var7;

                  for(var8 = 0; var8 < var7; ++var8) {
                     if(var76[var8].field304.compareTo(var76[1 + var8].field304) > 0) {
                        XClanMember var91 = var76[var8];
                        var76[var8] = var76[var8 + 1];
                        var76[var8 + 1] = var91;
                        var61 = false;
                     }
                  }

                  if(var61) {
                     break;
                  }
               }

               class137.clanMembers = var76;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 8) {
               class172.field2337 = Client.field357.method2860();
               MessageNode.field261 = Client.field357.method2858();

               while(Client.field357.offset < Client.field358) {
                  Client.packetOpcode = Client.field357.readUnsignedByte();
                  XItemContainer.method189();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 89) {
               class18.method209(Client.field357, Client.field358);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 132) {
               var1 = Client.field357.method2949();
               var2 = Client.field357.method2876();
               var3 = World.method670(var2);
               if(var3.modelType != 2 || var3.modelId != var1) {
                  var3.modelType = 2;
                  var3.modelId = var1;
                  class2.method36(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 127) {
               Player.method274(Client.field357.readString());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 161) {
               Client.field458 = Client.field357.readUnsignedByte();
               if(Client.field458 == 1) {
                  Client.field329 = Client.field357.readUnsignedShort();
               }

               if(Client.field458 >= 2 && Client.field458 <= 6) {
                  if(Client.field458 == 2) {
                     Client.field334 = 64;
                     Client.field335 = 64;
                  }

                  if(Client.field458 == 3) {
                     Client.field334 = 0;
                     Client.field335 = 64;
                  }

                  if(Client.field458 == 4) {
                     Client.field334 = 128;
                     Client.field335 = 64;
                  }

                  if(Client.field458 == 5) {
                     Client.field334 = 64;
                     Client.field335 = 0;
                  }

                  if(Client.field458 == 6) {
                     Client.field334 = 64;
                     Client.field335 = 128;
                  }

                  Client.field458 = 2;
                  Client.field331 = Client.field357.readUnsignedShort();
                  Client.field332 = Client.field357.readUnsignedShort();
                  Client.field333 = Client.field357.readUnsignedByte();
               }

               if(Client.field458 == 10) {
                  Client.field362 = Client.field357.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 178) {
               var1 = Client.field357.method2868();
               class105.field1733 = class72.field1193.method2024(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 2) {
               var1 = Client.field357.method2868();
               var2 = Client.field357.readLittleEndianShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var21 = Client.field357.method3006();
               var22 = World.method670(var1);
               ItemComposition var38;
               if(!var22.hasScript) {
                  if(var2 == -1) {
                     var22.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var38 = class154.getItemDefinition(var2);
                  var22.modelType = 4;
                  var22.modelId = var2;
                  var22.rotationX = var38.xan2d;
                  var22.rotationZ = var38.yan2d;
                  var22.field2240 = var38.zoom2d * 100 / var21;
                  class2.method36(var22);
               } else {
                  var22.item = var2;
                  var22.stackSize = var21;
                  var38 = class154.getItemDefinition(var2);
                  var22.rotationX = var38.xan2d;
                  var22.rotationZ = var38.yan2d;
                  var22.rotationY = var38.zan2d;
                  var22.field2235 = var38.offsetX2d;
                  var22.field2236 = var38.offsetY2d;
                  var22.field2240 = var38.zoom2d;
                  if(var38.isStackable == 1) {
                     var22.field2244 = 1;
                  } else {
                     var22.field2244 = 2;
                  }

                  if(var22.field2179 > 0) {
                     var22.field2240 = var22.field2240 * 32 / var22.field2179;
                  } else if(var22.originalWidth > 0) {
                     var22.field2240 = var22.field2240 * 32 / var22.originalWidth;
                  }

                  class2.method36(var22);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 124) {
               if(Client.widgetRoot != -1) {
                  var1 = Client.widgetRoot;
                  if(class44.method892(var1)) {
                     CombatInfo1.method628(Widget.widgets[var1], 0);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 158) {
               CipherBuffer var87 = Client.field357;
               var2 = Client.field358;
               ClassInfo var58 = new ClassInfo();
               var58.field3240 = var87.readUnsignedByte();
               var58.field3238 = var87.readInt();
               var58.field3239 = new int[var58.field3240];
               var58.field3241 = new int[var58.field3240];
               var58.fields = new Field[var58.field3240];
               var58.field3243 = new int[var58.field3240];
               var58.methods = new Method[var58.field3240];
               var58.args = new byte[var58.field3240][][];

               for(var4 = 0; var4 < var58.field3240; ++var4) {
                  try {
                     var5 = var87.readUnsignedByte();
                     String var30;
                     String var79;
                     if(var5 != 0 && var5 != 1 && var5 != 2) {
                        if(var5 == 3 || var5 == 4) {
                           var30 = var87.readString();
                           var79 = var87.readString();
                           var8 = var87.readUnsignedByte();
                           String[] var37 = new String[var8];

                           for(int var10 = 0; var10 < var8; ++var10) {
                              var37[var10] = var87.readString();
                           }

                           String var35 = var87.readString();
                           byte[][] var33 = new byte[var8][];
                           if(var5 == 3) {
                              for(int var12 = 0; var12 < var8; ++var12) {
                                 var13 = var87.readInt();
                                 var33[var12] = new byte[var13];
                                 var87.readBytes(var33[var12], 0, var13);
                              }
                           }

                           var58.field3239[var4] = var5;
                           Class[] var36 = new Class[var8];

                           for(var13 = 0; var13 < var8; ++var13) {
                              var36[var13] = class143.method2748(var37[var13]);
                           }

                           Class var46 = class143.method2748(var35);
                           if(class143.method2748(var30).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var14 = class143.method2748(var30).getDeclaredMethods();
                           Method[] var15 = var14;

                           for(int var16 = 0; var16 < var15.length; ++var16) {
                              Method var17 = var15[var16];
                              if(Reflection.getMethodName(var17).equals(var79)) {
                                 Class[] var18 = Reflection.getParameterTypes(var17);
                                 if(var36.length == var18.length) {
                                    boolean var19 = true;

                                    for(int var20 = 0; var20 < var36.length; ++var20) {
                                       if(var18[var20] != var36[var20]) {
                                          var19 = false;
                                          break;
                                       }
                                    }

                                    if(var19 && var46 == var17.getReturnType()) {
                                       var58.methods[var4] = var17;
                                    }
                                 }
                              }
                           }

                           var58.args[var4] = var33;
                        }
                     } else {
                        var30 = var87.readString();
                        var79 = var87.readString();
                        var8 = 0;
                        if(var5 == 1) {
                           var8 = var87.readInt();
                        }

                        var58.field3239[var4] = var5;
                        var58.field3243[var4] = var8;
                        if(class143.method2748(var30).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var58.fields[var4] = Reflection.findField(class143.method2748(var30), var79);
                     }
                  } catch (ClassNotFoundException var50) {
                     var58.field3241[var4] = -1;
                  } catch (SecurityException var51) {
                     var58.field3241[var4] = -2;
                  } catch (NullPointerException var52) {
                     var58.field3241[var4] = -3;
                  } catch (Exception var53) {
                     var58.field3241[var4] = -4;
                  } catch (Throwable var54) {
                     var58.field3241[var4] = -5;
                  }
               }

               class227.field3248.method2424(var58);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 31) {
               Client.field327 = Client.field357.readUnsignedShort() * 30;
               Client.field510 = Client.field498;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 194) {
               var1 = Client.field357.method3006();
               var59 = Client.field357.method2997() == 1;
               var3 = World.method670(var1);
               if(var59 != var3.isHidden) {
                  var3.isHidden = var59;
                  class2.method36(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 123) {
               var1 = Client.field357.readInt();
               var2 = Client.field357.method2869();
               var21 = var2 >> 10 & 31;
               var4 = var2 >> 5 & 31;
               var5 = var2 & 31;
               var6 = (var5 << 3) + (var4 << 11) + (var21 << 19);
               Widget var23 = World.method670(var1);
               if(var23.textColor != var6) {
                  var23.textColor = var6;
                  class2.method36(var23);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 79) {
               var1 = Client.field357.readInt();
               var2 = Client.field357.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var3 = World.method670(var1);
               } else {
                  var3 = null;
               }

               for(; Client.field357.offset < Client.field358; class101.method2017(var2, var4, var5 - 1, var6)) {
                  var4 = Client.field357.method3013();
                  var5 = Client.field357.readUnsignedShort();
                  var6 = 0;
                  if(var5 != 0) {
                     var6 = Client.field357.readUnsignedByte();
                     if(var6 == 255) {
                        var6 = Client.field357.readInt();
                     }
                  }

                  if(var3 != null && var4 >= 0 && var4 < var3.itemIds.length) {
                     var3.itemIds[var4] = var5;
                     var3.itemQuantities[var4] = var6;
                  }
               }

               if(var3 != null) {
                  class2.method36(var3);
               }

               class13.method198();
               Client.interfaceItemTriggers[++Client.field502 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 56) {
               var1 = Client.field357.method2868();
               var2 = Client.field357.readShort();
               var21 = Client.field357.readShort();
               var22 = World.method670(var1);
               if(var22.originalX != var21 || var22.originalY != var2 || var22.field2191 != 0 || var22.field2192 != 0) {
                  var22.originalX = var21;
                  var22.originalY = var2;
                  var22.field2191 = 0;
                  var22.field2192 = 0;
                  class2.method36(var22);
                  class26.method605(var22);
                  if(var22.type == 0) {
                     class107.method2100(Widget.widgets[var1 >> 16], var22, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            class31.method703("" + Client.packetOpcode + "," + Client.field363 + "," + Client.field364 + "," + Client.field358, (Throwable)null);
            VertexNormal.method1692();
         } catch (IOException var56) {
            class16.method203();
         } catch (Exception var57) {
            var25 = "" + Client.packetOpcode + "," + Client.field363 + "," + Client.field364 + "," + Client.field358 + "," + (class22.localPlayer.pathX[0] + CombatInfoListHolder.baseX) + "," + (class3.baseY + class22.localPlayer.pathY[0]) + ",";

            for(var2 = 0; var2 < Client.field358 && var2 < 50; ++var2) {
               var25 = var25 + Client.field357.payload[var2] + ",";
            }

            class31.method703(var25, var57);
            VertexNormal.method1692();
         }

         return true;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "112"
   )
   static void method2719(int var0, int var1, int var2) {
      if(Client.field553 != 0 && var1 != 0 && Client.field419 < 50) {
         Client.field556[Client.field419] = var0;
         Client.field557[Client.field419] = var1;
         Client.field558[Client.field419] = var2;
         Client.field560[Client.field419] = null;
         Client.field559[Client.field419] = 0;
         ++Client.field419;
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass15;I)V",
      garbageValue = "-454708941"
   )
   static final void method2721(class15 var0) {
      if(Client.flagX == class22.localPlayer.x >> 7 && Client.flagY == class22.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class45.field934;
      int[] var2 = class45.field925;
      int var3 = var1;
      if(var0 == class15.field184 || var0 == class15.field199) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class15.field184 == var0) {
            var5 = class22.localPlayer;
            var6 = class22.localPlayer.field276 << 14;
         } else if(class15.field199 == var0) {
            var5 = Client.cachedPlayers[Client.field407];
            var6 = Client.field407 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class15.field200 && Client.field407 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod782() && !var5.field290) {
            var5.field294 = false;
            if((Client.field439 && var1 > 50 || var1 > 200) && class15.field184 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field294 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field292) {
                  var5.field294 = false;
                  var5.field277 = class1.method21(var5.x, var5.y, class31.plane);
                  Friend.region.method1866(class31.plane, var5.x, var5.y, var5.field277, 60, var5, var5.angle, var6, var5.field270, var5.field285, var5.field286, var5.field287);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field534 == Client.field373[var7][var8]) {
                        continue;
                     }

                     Client.field373[var7][var8] = Client.field534;
                  }

                  var5.field277 = class1.method21(var5.x, var5.y, class31.plane);
                  Friend.region.method1765(class31.plane, var5.x, var5.y, var5.field277, 60, var5, var5.angle, var6, var5.field628);
               }
            }
         }
      }

   }

   class142(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var2.offset + var3] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.readByte();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var2.offset + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.readByte();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var39 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var39[1] = 1;
         int var41 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var40 = var2.readUnsignedByte();
            if(var40 == 0) {
               var41 = var12++;
            } else {
               if(var40 <= var41) {
                  --var40;
               }

               var41 = var40;
            }

            var39[var14] = (byte)var41;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class137();
         int var42 = var2.readUnsignedByte();
         if(var42 > 0) {
            var15.field1910 = new byte[2 * var42];
         }

         var42 = var2.readUnsignedByte();
         if(var42 > 0) {
            var15.field1904 = new byte[2 + 2 * var42];
            var15.field1904[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var44 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.readByte();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1996[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1996[var20] = (short)(this.field1996[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2847();
         }

         this.field1996[var23] = (short)(this.field1996[var23] + ((var22 - 1 & 2) << 14));
         this.field1999[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1999[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2002[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var43 = 0; var43 < 128; ++var43) {
         if(this.field1999[var43] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2000[var43] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1999[var26] != 0) {
            if(var20 == 0) {
               var25 = var13[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1997[var26] = var25;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field1999[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2005[var27] = (byte)var26;
         --var20;
      }

      this.field2001 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1910) {
            for(var29 = 1; var29 < var28.field1910.length; var29 += 2) {
               var28.field1910[var29] = var2.readByte();
            }
         }

         if(var28.field1904 != null) {
            for(var29 = 3; var29 < var28.field1904.length - 2; var29 += 2) {
               var28.field1904[var29] = var2.readByte();
            }
         }
      }

      if(var44 != null) {
         for(var27 = 1; var27 < var44.length; var27 += 2) {
            var44[var27] = var2.readByte();
         }
      }

      if(null != var16) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1904) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1904.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field1904[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1910) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1910.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1910[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var46;
      byte var48;
      if(var44 != null) {
         var19 = var2.readUnsignedByte();
         var44[0] = (byte)var19;

         for(var27 = 2; var27 < var44.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var44[var27] = (byte)var19;
         }

         var48 = var44[0];
         byte var38 = var44[1];

         for(var29 = 0; var29 < var48; ++var29) {
            this.field2005[var29] = (byte)(32 + var38 * this.field2005[var29] >> 6);
         }

         for(var29 = 2; var29 < var44.length; var29 += 2) {
            var30 = var44[var29];
            byte var31 = var44[1 + var29];
            var32 = var38 * (var30 - var48) + (var30 - var48) / 2;

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2005[var33] = (byte)(this.field2005[var33] * var34 + 32 >> 6);
               var32 += var31 - var38;
            }

            var48 = var30;
            var38 = var31;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            this.field2005[var46] = (byte)(var38 * this.field2005[var46] + 32 >> 6);
         }

         var15 = null;
      }

      if(var16 != null) {
         var19 = var2.readUnsignedByte();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var16[var27] = (byte)var19;
         }

         var48 = var16[0];
         int var49 = var16[1] << 1;

         for(var29 = 0; var29 < var48; ++var29) {
            var46 = (this.field2000[var29] & 255) + var49;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2000[var29] = (byte)var46;
         }

         int var47;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var47 = var16[var29 + 1] << 1;
            var32 = var49 * (var30 - var48) + (var30 - var48) / 2;

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = (this.field2000[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2000[var33] = (byte)var37;
               var32 += var47 - var49;
            }

            var48 = var30;
            var49 = var47;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            var47 = (this.field2000[var46] & 255) + var49;
            if(var47 < 0) {
               var47 = 0;
            }

            if(var47 > 128) {
               var47 = 128;
            }

            this.field2000[var46] = (byte)var47;
         }

         Object var45 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1905 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1910 != null) {
            var28.field1914 = var2.readUnsignedByte();
         }

         if(var28.field1904 != null) {
            var28.field1907 = var2.readUnsignedByte();
         }

         if(var28.field1905 > 0) {
            var28.field1908 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1911 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1911 > 0) {
            var28.field1909 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1909 > 0) {
            var28.field1906 = var2.readUnsignedByte();
         }
      }

   }
}
