import java.awt.Component;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("de")
public abstract class class112 {
   @ObfuscatedName("p")
   static String field1776;
   @ObfuscatedName("qm")
   protected static java.awt.Frame field1777;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1376163365"
   )
   public abstract void vmethod2035(Component var1);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1116236959"
   )
   public abstract int vmethod2036();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1548616269"
   )
   public abstract void vmethod2044(Component var1);

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1745941172"
   )
   static final boolean method2049() {
      if(class6.field46 == null) {
         return false;
      } else {
         int var2;
         String var19;
         try {
            int var0 = class6.field46.method2014();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class6.field46.method2015(Client.field332.payload, 0, 1);
               Client.field332.offset = 0;
               Client.packetOpcode = Client.field332.method2968();
               Client.field523 = class212.field3126[Client.packetOpcode];
               --var0;
            }

            if(Client.field523 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class6.field46.method2015(Client.field332.payload, 0, 1);
               Client.field523 = Client.field332.payload[0] & 255;
               --var0;
            }

            if(Client.field523 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class6.field46.method2015(Client.field332.payload, 0, 2);
               Client.field332.offset = 0;
               Client.field523 = Client.field332.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field523) {
               return false;
            }

            Client.field332.offset = 0;
            class6.field46.method2015(Client.field332.payload, 0, Client.field523);
            Client.field335 = 0;
            Client.field339 = Client.field410;
            Client.field410 = Client.field337;
            Client.field337 = Client.packetOpcode;
            if(Client.packetOpcode == 72) {
               Client.field332.offset += 28;
               if(Client.field332.method2772()) {
                  class33.method677(Client.field332, Client.field332.offset - 28);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var1;
            int var3;
            WidgetNode var45;
            if(Client.packetOpcode == 219) {
               var1 = Client.field332.method2770();
               var2 = Client.field332.method2720();
               var3 = Client.field332.method2892();
               var45 = (WidgetNode)Client.componentTable.method2299((long)var2);
               if(var45 != null) {
                  class44.method783(var45, var45.id != var1);
               }

               class13.method164(var2, var1, var3);
               Client.packetOpcode = -1;
               return true;
            }

            int var5;
            int var17;
            int var43;
            int var49;
            int var56;
            if(Client.packetOpcode == 136) {
               var1 = Client.field523 + Client.field332.offset;
               var2 = Client.field332.readUnsignedShort();
               var3 = Client.field332.readUnsignedShort();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  method2051(false);
                  class20.method194(Client.widgetRoot);
                  class22.method207(Client.widgetRoot);

                  for(var56 = 0; var56 < 100; ++var56) {
                     Client.field308[var56] = true;
                  }
               }

               WidgetNode var48;
               for(; var3-- > 0; var48.field181 = true) {
                  var56 = Client.field332.method2731();
                  var5 = Client.field332.readUnsignedShort();
                  var43 = Client.field332.readUnsignedByte();
                  var48 = (WidgetNode)Client.componentTable.method2299((long)var56);
                  if(null != var48 && var5 != var48.id) {
                     class44.method783(var48, true);
                     var48 = null;
                  }

                  if(null == var48) {
                     var48 = class13.method164(var56, var5, var43);
                  }
               }

               for(var45 = (WidgetNode)Client.componentTable.method2296(); var45 != null; var45 = (WidgetNode)Client.componentTable.method2300()) {
                  if(var45.field181) {
                     var45.field181 = false;
                  } else {
                     class44.method783(var45, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field332.offset < var1) {
                  var56 = Client.field332.method2731();
                  var5 = Client.field332.readUnsignedShort();
                  var43 = Client.field332.readUnsignedShort();
                  var17 = Client.field332.method2731();

                  for(var49 = var5; var49 <= var43; ++var49) {
                     long var52 = ((long)var56 << 32) + (long)var49;
                     Client.widgetFlags.method2291(new class133(var17), var52);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var59;
            if(Client.packetOpcode == 33) {
               var1 = Client.field332.method2770();
               var2 = Client.field332.method2855();
               var59 = class174.method3178(var2);
               if(var59.modelType != 1 || var1 != var59.modelId) {
                  var59.modelType = 1;
                  var59.modelId = var1;
                  class97.method1886(var59);
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var6;
            long var10;
            String var22;
            long var55;
            long var66;
            if(Client.packetOpcode == 147) {
               var19 = Client.field332.method2780();
               var55 = Client.field332.method2732();
               var66 = (long)Client.field332.readUnsignedShort();
               var6 = (long)Client.field332.read24BitInt();
               class177[] var61 = new class177[]{class177.field2672, class177.field2673, class177.field2669, class177.field2671, class177.field2676, class177.field2668};
               class177 var63 = (class177)FileOnDisk.method1390(var61, Client.field332.readUnsignedByte());
               var10 = var6 + (var66 << 32);
               boolean var12 = false;

               for(int var13 = 0; var13 < 100; ++var13) {
                  if(var10 == Client.field541[var13]) {
                     var12 = true;
                     break;
                  }
               }

               if(var63.field2677 && XItemContainer.method150(var19)) {
                  var12 = true;
               }

               if(!var12 && Client.field542 == 0) {
                  Client.field541[Client.field506] = var10;
                  Client.field506 = (Client.field506 + 1) % 100;
                  class159 var14 = Client.field332;
                  var22 = class114.method2157(var14, 32767);
                  String var15 = class209.method3783(Widget.method3158(var22));
                  if(var63.field2675 != -1) {
                     class119.addChatMessage(9, class13.method166(var63.field2675) + var19, var15, class137.method2417(var55));
                  } else {
                     class119.addChatMessage(9, var19, var15, class137.method2417(var55));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var16;
            boolean var50;
            String var57;
            String var70;
            if(Client.packetOpcode == 139) {
               while(Client.field332.offset < Client.field523) {
                  var50 = Client.field332.readUnsignedByte() == 1;
                  var70 = Client.field332.method2780();
                  var57 = Client.field332.method2780();
                  var56 = Client.field332.readUnsignedShort();
                  var5 = Client.field332.readUnsignedByte();
                  var43 = Client.field332.readUnsignedByte();
                  boolean var58 = (var43 & 2) != 0;
                  boolean var51 = (var43 & 1) != 0;
                  if(var56 > 0) {
                     Client.field332.method2780();
                     Client.field332.readUnsignedByte();
                     Client.field332.method2731();
                  }

                  Client.field332.method2780();

                  for(int var9 = 0; var9 < Client.friendCount; ++var9) {
                     Friend var24 = Client.friends[var9];
                     if(!var50) {
                        if(var70.equals(var24.name)) {
                           if(var56 != var24.world) {
                              boolean var54 = true;

                              for(class16 var71 = (class16)Client.field478.method2383(); null != var71; var71 = (class16)Client.field478.method2384()) {
                                 if(var71.field174.equals(var70)) {
                                    if(var56 != 0 && var71.field176 == 0) {
                                       var71.method2395();
                                       var54 = false;
                                    } else if(var56 == 0 && var71.field176 != 0) {
                                       var71.method2395();
                                       var54 = false;
                                    }
                                 }
                              }

                              if(var54) {
                                 Client.field478.method2387(new class16(var70, var56));
                              }

                              var24.world = var56;
                           }

                           var24.previousName = var57;
                           var24.rank = var5;
                           var24.field159 = var58;
                           var24.field154 = var51;
                           var70 = null;
                           break;
                        }
                     } else if(var57.equals(var24.name)) {
                        var24.name = var70;
                        var24.previousName = var57;
                        var70 = null;
                        break;
                     }
                  }

                  if(var70 != null && Client.friendCount < 400) {
                     Friend var21 = new Friend();
                     Client.friends[Client.friendCount] = var21;
                     var21.name = var70;
                     var21.previousName = var57;
                     var21.world = var56;
                     var21.rank = var5;
                     var21.field159 = var58;
                     var21.field154 = var51;
                     ++Client.friendCount;
                  }
               }

               Client.field312 = 2;
               Client.field477 = Client.field469;
               var50 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var50 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var16 = false;
                     Friend var86 = Client.friends[var3];
                     Friend var83 = Client.friends[var3 + 1];
                     if(var86.world != Client.world && var83.world == Client.world) {
                        var16 = true;
                     }

                     if(!var16 && var86.world == 0 && var83.world != 0) {
                        var16 = true;
                     }

                     if(!var16 && !var86.field159 && var83.field159) {
                        var16 = true;
                     }

                     if(!var16 && !var86.field154 && var83.field154) {
                        var16 = true;
                     }

                     if(var16) {
                        Friend var47 = Client.friends[var3];
                        Client.friends[var3] = Client.friends[var3 + 1];
                        Client.friends[1 + var3] = var47;
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

            if(Client.packetOpcode == 73) {
               Ignore.method188();
               var1 = Client.field332.method2753();
               var2 = Client.field332.method2753();
               var3 = Client.field332.method2720();
               Client.skillExperiences[var2] = var3;
               Client.boostedSkillLevels[var2] = var1;
               Client.realSkillLevels[var2] = 1;

               for(var56 = 0; var56 < 98; ++var56) {
                  if(var3 >= class172.field2355[var56]) {
                     Client.realSkillLevels[var2] = 2 + var56;
                  }
               }

               Client.field326[++Client.field557 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 108) {
               var1 = Client.field332.readUnsignedByte();
               if(Client.field332.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field332.offset += 18;
               } else {
                  --Client.field332.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field332, false);
               }

               Client.field466 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 15) {
               var1 = Client.field332.method2753();
               var2 = Client.field332.method2892();
               var57 = Client.field332.method2780();
               if(var1 >= 1 && var1 <= 8) {
                  if(var57.equalsIgnoreCase("null")) {
                     var57 = null;
                  }

                  Client.field413[var1 - 1] = var57;
                  Client.field373[var1 - 1] = var2 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 154) {
               var1 = Client.field332.readUnsignedShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               class114.method2155(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 101) {
               var1 = Client.field332.method2766();
               var2 = Client.field332.readUnsignedShort();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(Client.field521 != 0 && var2 != -1) {
                  WallObject.method1843(Friend.field160, var2, 0, Client.field521, false);
                  Client.field493 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 241) {
               var19 = Client.field332.method2780();
               Object[] var74 = new Object[var19.length() + 1];

               for(var3 = var19.length() - 1; var3 >= 0; --var3) {
                  if(var19.charAt(var3) == 115) {
                     var74[var3 + 1] = Client.field332.method2780();
                  } else {
                     var74[var3 + 1] = new Integer(Client.field332.method2731());
                  }
               }

               var74[0] = new Integer(Client.field332.method2731());
               class18 var75 = new class18();
               var75.field203 = var74;
               class13.method165(var75);
               Client.packetOpcode = -1;
               return true;
            }

            long var8;
            if(Client.packetOpcode == 168) {
               var19 = Client.field332.method2780();
               var55 = (long)Client.field332.readUnsignedShort();
               var66 = (long)Client.field332.read24BitInt();
               class177[] var81 = new class177[]{class177.field2672, class177.field2673, class177.field2669, class177.field2671, class177.field2676, class177.field2668};
               class177 var46 = (class177)FileOnDisk.method1390(var81, Client.field332.readUnsignedByte());
               var8 = var66 + (var55 << 32);
               boolean var53 = false;

               for(int var11 = 0; var11 < 100; ++var11) {
                  if(Client.field541[var11] == var8) {
                     var53 = true;
                     break;
                  }
               }

               if(XItemContainer.method150(var19)) {
                  var53 = true;
               }

               if(!var53 && Client.field542 == 0) {
                  Client.field541[Client.field506] = var8;
                  Client.field506 = (1 + Client.field506) % 100;
                  class159 var25 = Client.field332;
                  String var28 = class114.method2157(var25, 32767);
                  var22 = class209.method3783(Widget.method3158(var28));
                  byte var29;
                  if(var46.field2680) {
                     var29 = 7;
                  } else {
                     var29 = 3;
                  }

                  if(var46.field2675 != -1) {
                     class16.method183(var29, class13.method166(var46.field2675) + var19, var22);
                  } else {
                     class16.method183(var29, var19, var22);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 37) {
               var1 = Client.field332.method2770();
               XItemContainer var72 = (XItemContainer)XItemContainer.itemContainers.method2299((long)var1);
               if(var72 != null) {
                  var72.unlink();
               }

               Client.field472[++Client.field473 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 51) {
               class8.method92(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 23) {
               var1 = Client.field332.method2751();
               var2 = Client.field332.method2855();
               var59 = class174.method3178(var2);
               if(null != var59 && var59.type == 0) {
                  if(var1 > var59.scrollHeight - var59.height) {
                     var1 = var59.scrollHeight - var59.height;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var1 != var59.scrollY) {
                     var59.scrollY = var1;
                     class97.method1886(var59);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 87) {
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

            if(Client.packetOpcode == 233) {
               Client.field305 = Client.field332.readUnsignedShort() * 30;
               Client.field481 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 244) {
               Client.field352 = Client.field332.readUnsignedByte();
               Client.field503 = Client.field332.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 218) {
               var2 = Client.field332.readUnsignedByte();
               class216[] var73 = class205.method3731();
               var56 = 0;

               class216 var64;
               while(true) {
                  if(var56 >= var73.length) {
                     var64 = null;
                     break;
                  }

                  class216 var85 = var73[var56];
                  if(var85.field3164 == var2) {
                     var64 = var85;
                     break;
                  }

                  ++var56;
               }

               class20.field222 = var64;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 120) {
               var1 = Client.field332.method2855();
               var2 = Client.field332.method2870();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = Client.field332.method2731();
               var56 = Client.field332.method2770();
               if(var56 == '\uffff') {
                  var56 = -1;
               }

               for(var5 = var56; var5 <= var2; ++var5) {
                  var6 = (long)var5 + ((long)var3 << 32);
                  Node var20 = Client.widgetFlags.method2299(var6);
                  if(var20 != null) {
                     var20.unlink();
                  }

                  Client.widgetFlags.method2291(new class133(var1), var6);
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var40;
            String var42;
            if(Client.packetOpcode == 74) {
               while(Client.field332.offset < Client.field523) {
                  var1 = Client.field332.readUnsignedByte();
                  var40 = (var1 & 1) == 1;
                  var57 = Client.field332.method2780();
                  var42 = Client.field332.method2780();
                  Client.field332.method2780();

                  for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                     Ignore var80 = Client.ignores[var5];
                     if(var40) {
                        if(var42.equals(var80.name)) {
                           var80.name = var57;
                           var80.previousName = var42;
                           var57 = null;
                           break;
                        }
                     } else if(var57.equals(var80.name)) {
                        var80.name = var57;
                        var80.previousName = var42;
                        var57 = null;
                        break;
                     }
                  }

                  if(null != var57 && Client.ignoreCount < 400) {
                     Ignore var84 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var84;
                     var84.name = var57;
                     var84.previousName = var42;
                     ++Client.ignoreCount;
                  }
               }

               Client.field477 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 193) {
               var1 = Client.field332.method2770();
               var2 = Client.field332.method2855();
               class165.settings[var1] = var2;
               if(class165.widgetSettings[var1] != var2) {
                  class165.widgetSettings[var1] = var2;
               }

               class10.method143(var1);
               Client.field470[++Client.field471 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 215) {
               Client.field306 = Client.field332.readUnsignedByte();
               if(Client.field306 == 1) {
                  Client.field307 = Client.field332.readUnsignedShort();
               }

               if(Client.field306 >= 2 && Client.field306 <= 6) {
                  if(Client.field306 == 2) {
                     Client.field430 = 64;
                     Client.field313 = 64;
                  }

                  if(Client.field306 == 3) {
                     Client.field430 = 0;
                     Client.field313 = 64;
                  }

                  if(Client.field306 == 4) {
                     Client.field430 = 128;
                     Client.field313 = 64;
                  }

                  if(Client.field306 == 5) {
                     Client.field430 = 64;
                     Client.field313 = 0;
                  }

                  if(Client.field306 == 6) {
                     Client.field430 = 64;
                     Client.field313 = 128;
                  }

                  Client.field306 = 2;
                  Client.field333 = Client.field332.readUnsignedShort();
                  Client.field364 = Client.field332.readUnsignedShort();
                  Client.field311 = Client.field332.readUnsignedByte();
               }

               if(Client.field306 == 10) {
                  Client.field357 = Client.field332.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 251) {
               var1 = Client.field332.readUnsignedByte();
               var2 = Client.field332.readUnsignedByte();
               var3 = Client.field332.readUnsignedByte();
               var56 = Client.field332.readUnsignedByte();
               Client.field533[var1] = true;
               Client.field534[var1] = var2;
               Client.field535[var1] = var3;
               Client.field367[var1] = var56;
               Client.field537[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var4;
            if(Client.packetOpcode == 83) {
               var1 = Client.field332.method2731();
               var2 = Client.field332.method2855();
               var3 = Client.field332.method2751();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = class174.method3178(var2);
               ItemComposition var82;
               if(!var4.field2204) {
                  if(var3 == -1) {
                     var4.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var82 = class137.getItemDefinition(var3);
                  var4.modelType = 4;
                  var4.modelId = var3;
                  var4.rotationX = var82.field2973;
                  var4.rotationZ = var82.field2977;
                  var4.field2261 = var82.field2954 * 100 / var1;
                  class97.method1886(var4);
               } else {
                  var4.item = var3;
                  var4.stackSize = var1;
                  var82 = class137.getItemDefinition(var3);
                  var4.rotationX = var82.field2973;
                  var4.rotationZ = var82.field2977;
                  var4.rotationY = var82.field2942;
                  var4.field2291 = var82.field2958;
                  var4.field2257 = var82.field2959;
                  var4.field2261 = var82.field2954;
                  if(var82.isStackable == 1) {
                     var4.field2211 = 1;
                  } else {
                     var4.field2211 = 2;
                  }

                  if(var4.field2252 > 0) {
                     var4.field2261 = var4.field2261 * 32 / var4.field2252;
                  } else if(var4.field2218 > 0) {
                     var4.field2261 = var4.field2261 * 32 / var4.field2218;
                  }

                  class97.method1886(var4);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 115) {
               var1 = Client.field332.method2731();
               var2 = Client.field332.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var59 = class174.method3178(var1);
               } else {
                  var59 = null;
               }

               for(; Client.field332.offset < Client.field523; class41.method745(var2, var56, var5 - 1, var43)) {
                  var56 = Client.field332.method2842();
                  var5 = Client.field332.readUnsignedShort();
                  var43 = 0;
                  if(var5 != 0) {
                     var43 = Client.field332.readUnsignedByte();
                     if(var43 == 255) {
                        var43 = Client.field332.method2731();
                     }
                  }

                  if(var59 != null && var56 >= 0 && var56 < var59.itemIds.length) {
                     var59.itemIds[var56] = var5;
                     var59.itemQuantities[var56] = var43;
                  }
               }

               if(null != var59) {
                  class97.method1886(var59);
               }

               Ignore.method188();
               Client.field472[++Client.field473 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var77;
            if(Client.packetOpcode == 89) {
               var1 = Client.field332.method2871();
               var2 = Client.field332.method2731();
               WidgetNode var67 = (WidgetNode)Client.componentTable.method2299((long)var2);
               var45 = (WidgetNode)Client.componentTable.method2299((long)var1);
               if(var45 != null) {
                  class44.method783(var45, var67 == null || var45.id != var67.id);
               }

               if(null != var67) {
                  var67.unlink();
                  Client.componentTable.method2291(var67, (long)var1);
               }

               var77 = class174.method3178(var2);
               if(null != var77) {
                  class97.method1886(var77);
               }

               var77 = class174.method3178(var1);
               if(var77 != null) {
                  class97.method1886(var77);
                  Renderable.method1833(Widget.widgets[var77.id >>> 16], var77, true);
               }

               if(Client.widgetRoot != -1) {
                  XGrandExchangeOffer.method45(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 40) {
               var19 = Client.field332.method2780();
               field1776 = var19;

               try {
                  var70 = Client.field540.getParameter(class214.field3155.field3157);
                  var57 = Client.field540.getParameter(class214.field3156.field3157);
                  var42 = var70 + "settings=" + var19 + "; version=1; path=/; domain=" + var57;
                  if(var19.length() == 0) {
                     var42 = var42 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var42 = var42 + "; Expires=" + class40.method733(class114.method2154() + 94608000000L) + "; Max-Age=" + 94608000L;
                  }

                  Client var78 = Client.field540;
                  String var79 = "document.cookie=\"" + var42 + "\"";
                  JSObject.getWindow(var78).eval(var79);
               } catch (Throwable var31) {
                  ;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 58) {
               class38.xteaChanged(true);
               Client.field332.method2968();
               var1 = Client.field332.readUnsignedShort();
               class37.method721(Client.field332, var1);
               Client.packetOpcode = -1;
               return true;
            }

            Widget var69;
            if(Client.packetOpcode == 143) {
               var1 = Client.field332.method2720();
               var69 = class174.method3178(var1);

               for(var3 = 0; var3 < var69.itemIds.length; ++var3) {
                  var69.itemIds[var3] = -1;
                  var69.itemIds[var3] = 0;
               }

               class97.method1886(var69);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 63) {
               WidgetNode.field182 = Client.field332.readUnsignedByte();
               class97.field1633 = Client.field332.method2753();

               while(Client.field332.offset < Client.field523) {
                  Client.packetOpcode = Client.field332.readUnsignedByte();
                  class16.method180();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 69) {
               World var62 = new World();
               var62.address = Client.field332.method2780();
               var62.id = Client.field332.readUnsignedShort();
               var2 = Client.field332.method2731();
               var62.mask = var2;
               class20.setGameState(45);
               class6.field46.method2027();
               class6.field46 = null;
               class104.selectWorld(var62);
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 50) {
               class174.method3179();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 34) {
               Client.field554 = true;
               class57.field1059 = Client.field332.readUnsignedByte();
               ChatMessages.field928 = Client.field332.readUnsignedByte();
               class45.field901 = Client.field332.readUnsignedShort();
               FileOnDisk.field1197 = Client.field332.readUnsignedByte();
               class9.field73 = Client.field332.readUnsignedByte();
               if(class9.field73 >= 100) {
                  class110.cameraX = 64 + class57.field1059 * 128;
                  class16.cameraY = 64 + ChatMessages.field928 * 128;
                  class189.cameraZ = ChatLineBuffer.method896(class110.cameraX, class16.cameraY, class63.plane) - class45.field901;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 118) {
               var19 = Client.field332.method2780();
               class159 var65 = Client.field332;
               var70 = class114.method2157(var65, 32767);
               var42 = class209.method3783(Widget.method3158(var70));
               class16.method183(6, var19, var42);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 235) {
               var1 = Client.field332.method2720();
               var2 = Client.field332.method2751();
               var3 = Client.field332.readUnsignedShort();
               var56 = Client.field332.method2770();
               var77 = class174.method3178(var1);
               if(var77.rotationX != var3 || var56 != var77.rotationZ || var77.field2261 != var2) {
                  var77.rotationX = var3;
                  var77.rotationZ = var56;
                  var77.field2261 = var2;
                  class97.method1886(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 229) {
               var1 = Client.field332.readUnsignedShort();
               var2 = Client.field332.readUnsignedByte();
               var3 = Client.field332.readUnsignedShort();
               if(Client.field524 != 0 && var2 != 0 && Client.field526 < 50) {
                  Client.field527[Client.field526] = var1;
                  Client.field351[Client.field526] = var2;
                  Client.field529[Client.field526] = var3;
                  Client.field531[Client.field526] = null;
                  Client.field349[Client.field526] = 0;
                  ++Client.field526;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 95) {
               var1 = Client.field332.method2855();
               var70 = Client.field332.method2780();
               var59 = class174.method3178(var1);
               if(!var70.equals(var59.text)) {
                  var59.text = var70;
                  class97.method1886(var59);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 150) {
               Client.field554 = true;
               Actor.field620 = Client.field332.readUnsignedByte();
               class139.field1941 = Client.field332.readUnsignedByte();
               Projectile.field887 = Client.field332.readUnsignedShort();
               class13.field148 = Client.field332.readUnsignedByte();
               class161.field2151 = Client.field332.readUnsignedByte();
               if(class161.field2151 >= 100) {
                  var1 = 64 + Actor.field620 * 128;
                  var2 = 64 + class139.field1941 * 128;
                  var3 = ChatLineBuffer.method896(var1, var2, class63.plane) - Projectile.field887;
                  var56 = var1 - class110.cameraX;
                  var5 = var3 - class189.cameraZ;
                  var43 = var2 - class16.cameraY;
                  var17 = (int)Math.sqrt((double)(var43 * var43 + var56 * var56));
                  WidgetNode.cameraPitch = (int)(Math.atan2((double)var5, (double)var17) * 325.949D) & 2047;
                  class60.cameraYaw = (int)(Math.atan2((double)var56, (double)var43) * -325.949D) & 2047;
                  if(WidgetNode.cameraPitch < 128) {
                     WidgetNode.cameraPitch = 128;
                  }

                  if(WidgetNode.cameraPitch > 383) {
                     WidgetNode.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 214) {
               var1 = Client.field332.method2871();
               World.field678 = Tile.field1346.method1920(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 239) {
               class8.method92(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 148) {
               var1 = Client.field332.method2751();
               var2 = Client.field332.method2720();
               var59 = class174.method3178(var2);
               if(var59.modelType != 2 || var1 != var59.modelId) {
                  var59.modelType = 2;
                  var59.modelId = var1;
                  class97.method1886(var59);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 32) {
               Ignore.method188();
               Client.energy = Client.field332.readUnsignedByte();
               Client.field481 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 45) {
               var50 = Client.field332.readUnsignedByte() == 1;
               var2 = Client.field332.method2855();
               var59 = class174.method3178(var2);
               if(var59.isHidden != var50) {
                  var59.isHidden = var50;
                  class97.method1886(var59);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 197) {
               var50 = Client.field332.readUnsignedByte() == 1;
               if(var50) {
                  Friend.field156 = class114.method2154() - Client.field332.method2732();
                  class109.field1748 = new class1(Client.field332, true);
               } else {
                  class109.field1748 = null;
               }

               Client.field480 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 64) {
               var1 = Client.field332.method2720();
               var69 = class174.method3178(var1);
               var69.modelType = 3;
               var69.modelId = class5.localPlayer.composition.method3061();
               class97.method1886(var69);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 14) {
               var1 = Client.field332.method2731();
               var2 = Client.field332.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var59 = class174.method3178(var1);
               } else {
                  var59 = null;
               }

               if(var59 != null) {
                  for(var56 = 0; var56 < var59.itemIds.length; ++var56) {
                     var59.itemIds[var56] = 0;
                     var59.itemQuantities[var56] = 0;
                  }
               }

               class11.method144(var2);
               var56 = Client.field332.readUnsignedShort();

               for(var5 = 0; var5 < var56; ++var5) {
                  var43 = Client.field332.method2753();
                  if(var43 == 255) {
                     var43 = Client.field332.method2731();
                  }

                  var17 = Client.field332.readUnsignedShort();
                  if(null != var59 && var5 < var59.itemIds.length) {
                     var59.itemIds[var5] = var17;
                     var59.itemQuantities[var5] = var43;
                  }

                  class41.method745(var2, var5, var17 - 1, var43);
               }

               if(var59 != null) {
                  class97.method1886(var59);
               }

               Ignore.method188();
               Client.field472[++Client.field473 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var44;
            if(Client.packetOpcode == 123) {
               var19 = Client.field332.method2780();
               var2 = Client.field332.readUnsignedShort();
               byte var39 = Client.field332.readByte();
               var16 = false;
               if(var39 == -128) {
                  var16 = true;
               }

               if(var16) {
                  if(class177.field2678 == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var44 = false;

                  for(var5 = 0; var5 < class177.field2678 && (!class110.clanMembers[var5].username.equals(var19) || class110.clanMembers[var5].world != var2); ++var5) {
                     ;
                  }

                  if(var5 < class177.field2678) {
                     while(var5 < class177.field2678 - 1) {
                        class110.clanMembers[var5] = class110.clanMembers[1 + var5];
                        ++var5;
                     }

                     --class177.field2678;
                     class110.clanMembers[class177.field2678] = null;
                  }
               } else {
                  Client.field332.method2780();
                  XClanMember var76 = new XClanMember();
                  var76.username = var19;
                  var76.field278 = class162.method3013(var76.username, Friend.field155);
                  var76.world = var2;
                  var76.rank = var39;

                  for(var43 = class177.field2678 - 1; var43 >= 0; --var43) {
                     var17 = class110.clanMembers[var43].field278.compareTo(var76.field278);
                     if(var17 == 0) {
                        class110.clanMembers[var43].world = var2;
                        class110.clanMembers[var43].rank = var39;
                        if(var19.equals(class5.localPlayer.name)) {
                           XGrandExchangeOffer.field34 = var39;
                        }

                        Client.field338 = Client.field469;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var17 < 0) {
                        break;
                     }
                  }

                  if(class177.field2678 >= class110.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var17 = class177.field2678 - 1; var17 > var43; --var17) {
                     class110.clanMembers[1 + var17] = class110.clanMembers[var17];
                  }

                  if(class177.field2678 == 0) {
                     class110.clanMembers = new XClanMember[100];
                  }

                  class110.clanMembers[1 + var43] = var76;
                  ++class177.field2678;
                  if(var19.equals(class5.localPlayer.name)) {
                     XGrandExchangeOffer.field34 = var39;
                  }
               }

               Client.field338 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 85) {
               class195.method3470();

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               class41.method764(Client.field332);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 68) {
               var1 = Client.field332.method2871();
               var2 = Client.field332.method2821();
               var59 = class174.method3178(var1);
               if(var2 != var59.field2254 || var2 == -1) {
                  var59.field2254 = var2;
                  var59.field2329 = 0;
                  var59.field2226 = 0;
                  class97.method1886(var59);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 75) {
               var1 = Client.field332.method2770();
               Client.widgetRoot = var1;
               method2051(false);
               class20.method194(var1);
               class22.method207(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field308[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 77 || Client.packetOpcode == 236 || Client.packetOpcode == 93 || Client.packetOpcode == 209 || Client.packetOpcode == 240 || Client.packetOpcode == 96 || Client.packetOpcode == 195 || Client.packetOpcode == 228 || Client.packetOpcode == 238 || Client.packetOpcode == 105) {
               class16.method180();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 42) {
               var1 = Client.field332.method2720();
               var2 = Client.field332.method2870();
               var3 = var2 >> 10 & 31;
               var56 = var2 >> 5 & 31;
               var5 = var2 & 31;
               var43 = (var5 << 3) + (var56 << 11) + (var3 << 19);
               Widget var7 = class174.method3178(var1);
               if(var7.textColor != var43) {
                  var7.textColor = var43;
                  class97.method1886(var7);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 21) {
               Client.field554 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field533[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 129) {
               for(var1 = 0; var1 < class150.field2057; ++var1) {
                  class187 var68 = class177.method3187(var1);
                  if(null != var68) {
                     class165.settings[var1] = 0;
                     class165.widgetSettings[var1] = 0;
                  }
               }

               Ignore.method188();
               Client.field471 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 127) {
               var1 = Client.field332.method2842();
               var40 = Client.field332.readUnsignedByte() == 1;
               var57 = "";
               var16 = false;
               if(var40) {
                  var57 = Client.field332.method2780();
                  if(XItemContainer.method150(var57)) {
                     var16 = true;
                  }
               }

               String var26 = Client.field332.method2780();
               if(!var16) {
                  class16.method183(var1, var57, var26);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 10) {
               Client.field338 = Client.field469;
               if(Client.field523 == 0) {
                  Client.field290 = null;
                  Client.clanChatOwner = null;
                  class177.field2678 = 0;
                  class110.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.clanChatOwner = Client.field332.method2780();
               long var37 = Client.field332.method2732();
               Client.field290 = Ignore.method189(var37);
               class165.field2177 = Client.field332.readByte();
               var3 = Client.field332.readUnsignedByte();
               if(var3 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               class177.field2678 = var3;
               XClanMember[] var41 = new XClanMember[100];

               for(var5 = 0; var5 < class177.field2678; ++var5) {
                  var41[var5] = new XClanMember();
                  var41[var5].username = Client.field332.method2780();
                  var41[var5].field278 = class162.method3013(var41[var5].username, Friend.field155);
                  var41[var5].world = Client.field332.readUnsignedShort();
                  var41[var5].rank = Client.field332.readByte();
                  Client.field332.method2780();
                  if(var41[var5].username.equals(class5.localPlayer.name)) {
                     XGrandExchangeOffer.field34 = var41[var5].rank;
                  }
               }

               var44 = false;
               var17 = class177.field2678;

               while(var17 > 0) {
                  var44 = true;
                  --var17;

                  for(var49 = 0; var49 < var17; ++var49) {
                     if(var41[var49].field278.compareTo(var41[var49 + 1].field278) > 0) {
                        XClanMember var27 = var41[var49];
                        var41[var49] = var41[1 + var49];
                        var41[1 + var49] = var27;
                        var44 = false;
                     }
                  }

                  if(var44) {
                     break;
                  }
               }

               class110.clanMembers = var41;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 4) {
               var1 = Client.field332.method2729();
               var2 = Client.field332.method2871();
               var3 = Client.field332.method2927();
               var4 = class174.method3178(var2);
               if(var1 != var4.field2216 || var4.field2217 != var3 || var4.field2212 != 0 || var4.field2236 != 0) {
                  var4.field2216 = var1;
                  var4.field2217 = var3;
                  var4.field2212 = 0;
                  var4.field2236 = 0;
                  class97.method1886(var4);
                  class8.method94(var4);
                  if(var4.type == 0) {
                     Renderable.method1833(Widget.widgets[var2 >> 16], var4, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 82) {
               class38.xteaChanged(false);
               Client.field332.method2968();
               var1 = Client.field332.readUnsignedShort();
               class37.method721(Client.field332, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 119) {
               var1 = Client.field332.readUnsignedShort();
               byte var36 = Client.field332.method2869();
               class165.settings[var1] = var36;
               if(var36 != class165.widgetSettings[var1]) {
                  class165.widgetSettings[var1] = var36;
               }

               class10.method143(var1);
               Client.field470[++Client.field471 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 183) {
               var1 = Client.field332.method2731();
               var2 = Client.field332.method2731();
               if(Ignore.field208 == null || !Ignore.field208.isValid()) {
                  try {
                     Iterator var18 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var18.hasNext()) {
                        GarbageCollectorMXBean var38 = (GarbageCollectorMXBean)var18.next();
                        if(var38.isValid()) {
                           Ignore.field208 = var38;
                           Client.field294 = -1L;
                           Client.field561 = -1L;
                        }
                     }
                  } catch (Throwable var32) {
                     ;
                  }
               }

               long var35 = class114.method2154();
               var5 = -1;
               if(null != Ignore.field208) {
                  var6 = Ignore.field208.getCollectionTime();
                  if(Client.field561 != -1L) {
                     var8 = var6 - Client.field561;
                     var10 = var35 - Client.field294;
                     if(var10 != 0L) {
                        var5 = (int)(100L * var8 / var10);
                     }
                  }

                  Client.field561 = var6;
                  Client.field294 = var35;
               }

               Client.field330.method2967(183);
               Client.field330.method2714(var1);
               Client.field330.method2769(var2);
               Client.field330.method2752(var5);
               Client.field330.method2752(GameEngine.field1782);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 107) {
               if(Client.widgetRoot != -1) {
                  XGrandExchangeOffer.method45(Client.widgetRoot, 0);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               class195.method3468(Client.field332, Client.field523);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 116) {
               Client.field520 = Client.field332.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 97) {
               class97.field1633 = Client.field332.method2755();
               WidgetNode.field182 = Client.field332.method2753();

               for(var1 = class97.field1633; var1 < class97.field1633 + 8; ++var1) {
                  for(var2 = WidgetNode.field182; var2 < WidgetNode.field182 + 8; ++var2) {
                     if(null != Client.groundItemDeque[class63.plane][var1][var2]) {
                        Client.groundItemDeque[class63.plane][var1][var2] = null;
                        class161.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class25 var60 = (class25)Client.field300.method2349(); var60 != null; var60 = (class25)Client.field300.method2351()) {
                  if(var60.field584 >= class97.field1633 && var60.field584 < 8 + class97.field1633 && var60.field573 >= WidgetNode.field182 && var60.field573 < WidgetNode.field182 + 8 && class63.plane == var60.field575) {
                     var60.field577 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 142) {
               class97.field1633 = Client.field332.readUnsignedByte();
               WidgetNode.field182 = Client.field332.method2753();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 28) {
               Ignore.method188();
               Client.weight = Client.field332.method2729();
               Client.field481 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 165) {
               Client.flagX = Client.field332.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field332.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 205) {
               Client.field312 = 1;
               Client.field477 = Client.field469;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 2) {
               var1 = Client.field332.method2731();
               var2 = Client.field332.readUnsignedShort();
               var3 = Client.field332.method2870();
               var4 = class174.method3178(var1);
               var4.field2263 = var3 + (var2 << 16);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 184) {
               var1 = Client.field332.method2731();
               WidgetNode var23 = (WidgetNode)Client.componentTable.method2299((long)var1);
               if(var23 != null) {
                  class44.method783(var23, true);
               }

               if(null != Client.field448) {
                  class97.method1886(Client.field448);
                  Client.field448 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 36) {
               class37.method721(Client.field332, Client.field523);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 71) {
               for(var1 = 0; var1 < class165.widgetSettings.length; ++var1) {
                  if(class165.widgetSettings[var1] != class165.settings[var1]) {
                     class165.widgetSettings[var1] = class165.settings[var1];
                     class10.method143(var1);
                     Client.field470[++Client.field471 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            FaceNormal.method1844("" + Client.packetOpcode + "," + Client.field410 + "," + Client.field339 + "," + Client.field523, (Throwable)null);
            class174.method3179();
         } catch (IOException var33) {
            WallObject.method1842();
         } catch (Exception var34) {
            var19 = "" + Client.packetOpcode + "," + Client.field410 + "," + Client.field339 + "," + Client.field523 + "," + (class5.localPlayer.pathX[0] + class107.baseX) + "," + (class5.localPlayer.pathY[0] + XClanMember.baseY) + ",";

            for(var2 = 0; var2 < Client.field523 && var2 < 50; ++var2) {
               var19 = var19 + Client.field332.payload[var2] + ",";
            }

            FaceNormal.method1844(var19, var34);
            class174.method3179();
         }

         return true;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-670113202"
   )
   public static int method2050(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1456484980"
   )
   static final void method2051(boolean var0) {
      int var1 = Client.widgetRoot;
      int var2 = TextureProvider.field1200;
      int var3 = class94.field1584;
      if(class2.method25(var1)) {
         DecorativeObject.method1877(Widget.widgets[var1], -1, var2, var3, var0);
      }

   }
}
