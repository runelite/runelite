import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("y")
public class class15 {
   @ObfuscatedName("q")
   public static Buffer field154;
   @ObfuscatedName("l")
   static final class15 field155 = new class15();
   @ObfuscatedName("i")
   static final class15 field156 = new class15();
   @ObfuscatedName("ah")
   static class110 field159;
   @ObfuscatedName("t")
   static final class15 field160 = new class15();
   @ObfuscatedName("b")
   static final class15 field161 = new class15();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "166035778"
   )
   static void method189(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method189(var0, var1, var2, var5 - 1);
         method189(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "2025394346"
   )
   static void method190(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2203 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2203 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2203 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.field2204 == 0) {
         var0.height = var0.field2208;
      } else if(var0.field2204 == 1) {
         var0.height = var2 - var0.field2208;
      } else if(var0.field2204 == 2) {
         var0.height = var0.field2208 * var2 >> 14;
      }

      if(var0.field2203 == 4) {
         var0.width = var0.height * var0.field2213 / var0.field2214;
      }

      if(var0.field2204 == 4) {
         var0.height = var0.width * var0.field2214 / var0.field2213;
      }

      if(Client.field455 && var0.type == 0) {
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
         Client.field457 = var0;
      }

      if(var3 && null != var0.field2305 && (var4 != var0.width || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field185 = var0;
         var6.field197 = var0.field2305;
         Client.field484.method2468(var6);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1871261066"
   )
   static final void method191() {
      if(Client.field504 > 1) {
         --Client.field504;
      }

      if(Client.field337 > 0) {
         --Client.field337;
      }

      if(Client.field338) {
         Client.field338 = false;
         class7.method109();
      } else {
         if(!Client.isMenuOpen) {
            FloorUnderlayDefinition.method3569();
         }

         int var0;
         int var2;
         int var4;
         int var6;
         String var18;
         long var19;
         int var24;
         int var25;
         int var26;
         int var37;
         int var43;
         int var61;
         boolean var63;
         Widget var104;
         int var107;
         int var109;
         for(var0 = 0; var0 < 100; ++var0) {
            boolean var1;
            if(null == class5.field46) {
               var1 = false;
            } else {
               label3196: {
                  try {
                     var2 = class5.field46.method2131();
                     if(var2 == 0) {
                        var1 = false;
                        break label3196;
                     }

                     if(Client.packetOpcode == -1) {
                        class5.field46.method2113(Client.field329.payload, 0, 1);
                        Client.field329.offset = 0;
                        Client.packetOpcode = Client.field329.method3122();
                        Client.field330 = class212.field3144[Client.packetOpcode];
                        --var2;
                     }

                     if(Client.field330 == -1) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label3196;
                        }

                        class5.field46.method2113(Client.field329.payload, 0, 1);
                        Client.field330 = Client.field329.payload[0] & 255;
                        --var2;
                     }

                     if(Client.field330 == -2) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label3196;
                        }

                        class5.field46.method2113(Client.field329.payload, 0, 2);
                        Client.field329.offset = 0;
                        Client.field330 = Client.field329.readUnsignedShort();
                        var2 -= 2;
                     }

                     if(var2 < Client.field330) {
                        var1 = false;
                        break label3196;
                     }

                     Client.field329.offset = 0;
                     class5.field46.method2113(Client.field329.payload, 0, Client.field330);
                     Client.field385 = 0;
                     Client.field310 = Client.field288;
                     Client.field288 = Client.field540 * -1;
                     Client.field540 = Client.packetOpcode * -1;
                     String var5;
                     boolean var62;
                     if(Client.packetOpcode == 55) {
                        var61 = Client.field329.method2991();
                        var63 = Client.field329.readUnsignedByte() == 1;
                        var5 = "";
                        var62 = false;
                        if(var63) {
                           var5 = Client.field329.readString();
                           if(class5.method82(var5)) {
                              var62 = true;
                           }
                        }

                        String var73 = Client.field329.readString();
                        if(!var62) {
                           class140.sendGameMessage(var61, var5, var73);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     Widget var69;
                     WidgetNode var89;
                     if(Client.packetOpcode == 34) {
                        var61 = Client.field329.method3015();
                        var4 = Client.field329.method2901();
                        WidgetNode var83 = (WidgetNode)Client.componentTable.method2428((long)var4);
                        var89 = (WidgetNode)Client.componentTable.method2428((long)var61);
                        if(var89 != null) {
                           class30.method683(var89, var83 == null || var83.id != var89.id);
                        }

                        if(null != var83) {
                           var83.unlink();
                           Client.componentTable.method2425(var83, (long)var61);
                        }

                        var69 = class140.method2681(var4);
                        if(null != var69) {
                           Frames.method1960(var69);
                        }

                        var69 = class140.method2681(var61);
                        if(null != var69) {
                           Frames.method1960(var69);
                           CombatInfo1.method646(Widget.widgets[var69.id >>> 16], var69, true);
                        }

                        if(Client.widgetRoot != -1) {
                           class88.method1936(Client.widgetRoot, 1);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     long var8;
                     long var12;
                     long var21;
                     if(Client.packetOpcode == 66) {
                        var18 = Client.field329.readString();
                        var19 = Client.field329.method2947();
                        var21 = (long)Client.field329.readUnsignedShort();
                        var8 = (long)Client.field329.read24BitInt();
                        class177[] var75 = new class177[]{class177.field2658, class177.field2661, class177.field2668, class177.field2657, class177.field2663, class177.field2664};
                        class177 var79 = (class177)class37.method801(var75, Client.field329.readUnsignedByte());
                        var12 = (var21 << 32) + var8;
                        boolean var86 = false;

                        for(int var15 = 0; var15 < 100; ++var15) {
                           if(Client.field339[var15] == var12) {
                              var86 = true;
                              break;
                           }
                        }

                        if(var79.field2670 && class5.method82(var18)) {
                           var86 = true;
                        }

                        if(!var86 && Client.field336 == 0) {
                           Client.field339[Client.field378] = var12;
                           Client.field378 = (Client.field378 + 1) % 100;
                           String var23 = FontTypeFace.method3973(class156.method3091(class182.method3425(Client.field329)));
                           if(var79.field2660 != -1) {
                              class138.addChatMessage(9, class25.method614(var79.field2660) + var18, var23, class162.method3174(var19));
                           } else {
                              class138.addChatMessage(9, var18, var23, class162.method3174(var19));
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 152) {
                        var61 = Client.field329.method3020();
                        TextureProvider.method1515(var61);
                        Client.interfaceItemTriggers[++Client.field474 - 1 & 31] = var61 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 215) {
                        class40.xteaChanged(false);
                        Client.field329.method3122();
                        var61 = Client.field329.readUnsignedShort();
                        class160.method3159(Client.field329, var61);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 91) {
                        var61 = Client.field329.readUnsignedShort();
                        var4 = Client.field329.readUnsignedByte();
                        var24 = Client.field329.readUnsignedShort();
                        if(Client.field525 != 0 && var4 != 0 && Client.field527 < 50) {
                           Client.field552[Client.field527] = var61;
                           Client.field529[Client.field527] = var4;
                           Client.field530[Client.field527] = var24;
                           Client.field351[Client.field527] = null;
                           Client.field531[Client.field527] = 0;
                           ++Client.field527;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 234) {
                        var18 = Client.field329.readString();
                        Object[] var111 = new Object[var18.length() + 1];

                        for(var24 = var18.length() - 1; var24 >= 0; --var24) {
                           if(var18.charAt(var24) == 115) {
                              var111[1 + var24] = Client.field329.readString();
                           } else {
                              var111[var24 + 1] = new Integer(Client.field329.readInt());
                           }
                        }

                        var111[0] = new Integer(Client.field329.readInt());
                        class18 var82 = new class18();
                        var82.field197 = var111;
                        class97.method1988(var82);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 154) {
                        for(var61 = 0; var61 < Client.cachedPlayers.length; ++var61) {
                           if(Client.cachedPlayers[var61] != null) {
                              Client.cachedPlayers[var61].animation = -1;
                           }
                        }

                        for(var61 = 0; var61 < Client.cachedNPCs.length; ++var61) {
                           if(null != Client.cachedNPCs[var61]) {
                              Client.cachedNPCs[var61].animation = -1;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 219) {
                        class38.method808(true);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     boolean var3;
                     if(Client.packetOpcode == 103) {
                        var3 = Client.field329.readUnsignedByte() == 1;
                        if(var3) {
                           class36.field766 = ChatMessages.method935() - Client.field329.method2947();
                           class143.field2002 = new class1(Client.field329, true);
                        } else {
                           class143.field2002 = null;
                        }

                        Client.field481 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 222) {
                        WidgetNode.method200();
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3196;
                     }

                     if(Client.packetOpcode == 228) {
                        var61 = Client.field329.method3015();
                        var4 = Client.field329.method3057();
                        class165.field2154[var4] = var61;
                        if(class165.widgetSettings[var4] != var61) {
                           class165.widgetSettings[var4] = var61;
                        }

                        CombatInfoListHolder.method777(var4);
                        Client.field471[++Client.field569 - 1 & 31] = var4;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     Widget var65;
                     if(Client.packetOpcode == 80) {
                        var61 = Client.field329.method3015();
                        var63 = Client.field329.readUnsignedByte() == 1;
                        var65 = class140.method2681(var61);
                        if(var63 != var65.isHidden) {
                           var65.isHidden = var63;
                           Frames.method1960(var65);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 153) {
                        var61 = Client.field329.method2901();
                        var4 = Client.field329.readUnsignedShort();
                        var24 = Client.field329.readUnsignedShort();
                        var6 = Client.field329.method3057();
                        var69 = class140.method2681(var61);
                        if(var69.rotationX != var6 || var69.rotationZ != var4 || var69.field2238 != var24) {
                           var69.rotationX = var6;
                           var69.rotationZ = var4;
                           var69.field2238 = var24;
                           Frames.method1960(var69);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 11) {
                        Client.field300 = Client.field329.readUnsignedByte();
                        if(Client.field300 == 1) {
                           Client.field301 = Client.field329.readUnsignedShort();
                        }

                        if(Client.field300 >= 2 && Client.field300 <= 6) {
                           if(Client.field300 == 2) {
                              Client.field306 = 64;
                              Client.field307 = 64;
                           }

                           if(Client.field300 == 3) {
                              Client.field306 = 0;
                              Client.field307 = 64;
                           }

                           if(Client.field300 == 4) {
                              Client.field306 = 128;
                              Client.field307 = 64;
                           }

                           if(Client.field300 == 5) {
                              Client.field306 = 64;
                              Client.field307 = 0;
                           }

                           if(Client.field300 == 6) {
                              Client.field306 = 64;
                              Client.field307 = 128;
                           }

                           Client.field300 = 2;
                           Client.field536 = Client.field329.readUnsignedShort();
                           Client.field315 = Client.field329.readUnsignedShort();
                           Client.field387 = Client.field329.readUnsignedByte();
                        }

                        if(Client.field300 == 10) {
                           Client.field311 = Client.field329.readUnsignedShort();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 24) {
                        var18 = Client.field329.readString();
                        var4 = Client.field329.method2941();
                        var65 = class140.method2681(var4);
                        if(!var18.equals(var65.text)) {
                           var65.text = var18;
                           Frames.method1960(var65);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 22) {
                        var61 = Client.field329.readInt();
                        WidgetNode var110 = (WidgetNode)Client.componentTable.method2428((long)var61);
                        if(null != var110) {
                           class30.method683(var110, true);
                        }

                        if(Client.field546 != null) {
                           Frames.method1960(Client.field546);
                           Client.field546 = null;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 245) {
                        var61 = Client.field329.method2901();
                        var104 = class140.method2681(var61);
                        var104.modelType = 3;
                        var104.modelId = class9.localPlayer.composition.method3231();
                        Frames.method1960(var104);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 110) {
                        Friend.method187();
                        Client.energy = Client.field329.readUnsignedByte();
                        Client.field482 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 160) {
                        Friend.method187();
                        var61 = Client.field329.readUnsignedByte();
                        var4 = Client.field329.method2901();
                        var24 = Client.field329.readUnsignedByte();
                        Client.skillExperiences[var24] = var4;
                        Client.boostedSkillLevels[var24] = var61;
                        Client.realSkillLevels[var24] = 1;

                        for(var6 = 0; var6 < 98; ++var6) {
                           if(var4 >= class172.field2352[var6]) {
                              Client.realSkillLevels[var24] = 2 + var6;
                           }
                        }

                        Client.field475[++Client.field476 - 1 & 31] = var24;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 236) {
                        Client.field452 = Client.field329.readUnsignedByte();
                        Client.field381 = Client.field329.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 14) {
                        Client.flagX = Client.field329.readUnsignedByte();
                        if(Client.flagX == 255) {
                           Client.flagX = 0;
                        }

                        Client.flagY = Client.field329.readUnsignedByte();
                        if(Client.flagY == 255) {
                           Client.flagY = 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 121) {
                        class2.method26();

                        for(var61 = 0; var61 < 2048; ++var61) {
                           Client.cachedPlayers[var61] = null;
                        }

                        Ignore.method207(Client.field329);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 174) {
                        Renderable.field1530 = Client.field329.method2884();
                        CombatInfo2.field2845 = Client.field329.readUnsignedByte();

                        for(var61 = Renderable.field1530; var61 < Renderable.field1530 + 8; ++var61) {
                           for(var4 = CombatInfo2.field2845; var4 < 8 + CombatInfo2.field2845; ++var4) {
                              if(null != Client.groundItemDeque[class156.plane][var61][var4]) {
                                 Client.groundItemDeque[class156.plane][var61][var4] = null;
                                 Script.groundItemSpawned(var61, var4);
                              }
                           }
                        }

                        for(class25 var94 = (class25)Client.field467.method2472(); null != var94; var94 = (class25)Client.field467.method2479()) {
                           if(var94.field573 >= Renderable.field1530 && var94.field573 < 8 + Renderable.field1530 && var94.field583 >= CombatInfo2.field2845 && var94.field583 < 8 + CombatInfo2.field2845 && class156.plane == var94.field587) {
                              var94.field581 = 0;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     String var27;
                     String var88;
                     if(Client.packetOpcode == 242) {
                        var18 = Client.field329.readString();
                        MessageNode.field226 = var18;

                        try {
                           var27 = Client.field279.getParameter(class214.field3168.field3162);
                           var5 = Client.field279.getParameter(class214.field3169.field3162);
                           var88 = var27 + "settings=" + var18 + "; version=1; path=/; domain=" + var5;
                           if(var18.length() == 0) {
                              var88 = var88 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                           } else {
                              var88 = var88 + "; Expires=" + CombatInfoListHolder.method767(ChatMessages.method935() + 94608000000L) + "; Max-Age=" + 94608000L;
                           }

                           Client var68 = Client.field279;
                           String var106 = "document.cookie=\"" + var88 + "\"";
                           JSObject.getWindow(var68).eval(var106);
                        } catch (Throwable var55) {
                           ;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 156) {
                        class13.field141 = class45.method890(Client.field329.readUnsignedByte());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 10) {
                        byte var87 = Client.field329.method2841();
                        var4 = Client.field329.method2894();
                        class165.field2154[var4] = var87;
                        if(class165.widgetSettings[var4] != var87) {
                           class165.widgetSettings[var4] = var87;
                        }

                        CombatInfoListHolder.method777(var4);
                        Client.field471[++Client.field569 - 1 & 31] = var4;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     Widget var17;
                     if(Client.packetOpcode == 85) {
                        var61 = Client.field329.method2895();
                        var4 = Client.field329.method2941();
                        var24 = Client.field329.method2895();
                        var17 = class140.method2681(var4);
                        if(var17.originalX != var24 || var61 != var17.originalY || var17.field2201 != 0 || var17.field2202 != 0) {
                           var17.originalX = var24;
                           var17.originalY = var61;
                           var17.field2201 = 0;
                           var17.field2202 = 0;
                           Frames.method1960(var17);
                           class39.method815(var17);
                           if(var17.type == 0) {
                              CombatInfo1.method646(Widget.widgets[var4 >> 16], var17, false);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 235) {
                        Client.field329.offset += 28;
                        if(Client.field329.method3026()) {
                           class159 var93 = Client.field329;
                           var4 = Client.field329.offset - 28;
                           byte[] var80 = var93.payload;
                           if(null == Client.field321) {
                              Client.field321 = new byte[24];
                           }

                           class163.method3179(var80, var4, Client.field321, 0, 24);
                           if(null != class104.field1681) {
                              try {
                                 class104.field1681.method1436(0L);
                                 class104.field1681.method1461(var93.payload, var4, 24);
                              } catch (Exception var54) {
                                 ;
                              }
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 12) {
                        var61 = Client.field329.readUnsignedByte();
                        var4 = Client.field329.readUnsignedByte();
                        var24 = Client.field329.readUnsignedByte();
                        var6 = Client.field329.readUnsignedByte();
                        Client.field478[var61] = true;
                        Client.field535[var61] = var4;
                        Client.field303[var61] = var24;
                        Client.field537[var61] = var6;
                        Client.field538[var61] = 0;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 199) {
                        var61 = Client.field329.method2941();
                        var4 = Client.field329.method3020();
                        var24 = var4 >> 10 & 31;
                        var6 = var4 >> 5 & 31;
                        var25 = var4 & 31;
                        var26 = (var25 << 3) + (var24 << 19) + (var6 << 11);
                        Widget var77 = class140.method2681(var61);
                        if(var77.textColor != var26) {
                           var77.textColor = var26;
                           Frames.method1960(var77);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 54) {
                        var61 = Client.field329.method3057();
                        var4 = Client.field329.readInt();
                        var24 = Client.field329.method3057();
                        var17 = class140.method2681(var4);
                        var17.field2252 = (var61 << 16) + var24;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 164) {
                        class38.method808(false);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 71) {
                        var61 = Client.field329.readUnsignedByte();
                        var27 = Client.field329.readString();
                        var24 = Client.field329.method2884();
                        if(var24 >= 1 && var24 <= 8) {
                           if(var27.equalsIgnoreCase("null")) {
                              var27 = null;
                           }

                           Client.playerOptions[var24 - 1] = var27;
                           Client.playerOptionsPriority[var24 - 1] = var61 == 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 60) {
                        Renderable.field1530 = Client.field329.readUnsignedByte();
                        CombatInfo2.field2845 = Client.field329.method2884();

                        while(Client.field329.offset < Client.field330) {
                           Client.packetOpcode = Client.field329.readUnsignedByte();
                           class3.method42();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 68) {
                        var61 = Client.field329.method2941();
                        var4 = Client.field329.method2895();
                        var65 = class140.method2681(var61);
                        if(var65.field2243 != var4 || var4 == -1) {
                           var65.field2243 = var4;
                           var65.field2318 = 0;
                           var65.field2303 = 0;
                           Frames.method1960(var65);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 17) {
                        Friend.method187();
                        Client.weight = Client.field329.readShort();
                        Client.field482 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 15) {
                        var61 = Client.field329.readInt();
                        class157.field2116 = class25.field579.method2017(var61);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 171) {
                        for(var61 = 0; var61 < class165.widgetSettings.length; ++var61) {
                           if(class165.widgetSettings[var61] != class165.field2154[var61]) {
                              class165.widgetSettings[var61] = class165.field2154[var61];
                              CombatInfoListHolder.method777(var61);
                              Client.field471[++Client.field569 - 1 & 31] = var61;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 149) {
                        var61 = Client.field329.method2894();
                        if(var61 == '\uffff') {
                           var61 = -1;
                        }

                        if(var61 == -1 && !Client.field401) {
                           World.method681();
                        } else if(var61 != -1 && var61 != Client.field523 && Client.field522 != 0 && !Client.field401) {
                           class25.method613(2, XItemContainer.field122, var61, 0, Client.field522, false);
                        }

                        Client.field523 = var61;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 47) {
                        var61 = Client.field329.read24BitInt();
                        var4 = Client.field329.readUnsignedShort();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        class31.method706(var4, var61);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 217) {
                        var61 = Client.field329.method3020();
                        Client.widgetRoot = var61;
                        class39.method814(false);
                        CombatInfo1.method647(var61);
                        class57.method1116(Client.widgetRoot);

                        for(var4 = 0; var4 < 100; ++var4) {
                           Client.field490[var4] = true;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 29) {
                        var61 = Client.field329.method2894();
                        if(var61 == '\uffff') {
                           var61 = -1;
                        }

                        var4 = Client.field329.method3057();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        var24 = Client.field329.readInt();
                        var6 = Client.field329.readInt();

                        for(var25 = var4; var25 <= var61; ++var25) {
                           var8 = ((long)var6 << 32) + (long)var25;
                           Node var10 = Client.widgetFlags.method2428(var8);
                           if(var10 != null) {
                              var10.unlink();
                           }

                           Client.widgetFlags.method2425(new class133(var24), var8);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 104) {
                        XItemContainer.method180(Client.field329, Client.field330);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 254) {
                        Client.field553 = 1;
                        Client.field285 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 13) {
                        if(Client.widgetRoot != -1) {
                           class88.method1936(Client.widgetRoot, 0);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 101) {
                        var61 = Client.field329.readInt();
                        var4 = Client.field329.readUnsignedShort();
                        if(var61 < -70000) {
                           var4 += '耀';
                        }

                        if(var61 >= 0) {
                           var65 = class140.method2681(var61);
                        } else {
                           var65 = null;
                        }

                        for(; Client.field329.offset < Client.field330; class3.method43(var4, var6, var25 - 1, var26)) {
                           var6 = Client.field329.method2991();
                           var25 = Client.field329.readUnsignedShort();
                           var26 = 0;
                           if(var25 != 0) {
                              var26 = Client.field329.readUnsignedByte();
                              if(var26 == 255) {
                                 var26 = Client.field329.readInt();
                              }
                           }

                           if(var65 != null && var6 >= 0 && var6 < var65.itemIds.length) {
                              var65.itemIds[var6] = var25;
                              var65.itemQuantities[var6] = var26;
                           }
                        }

                        if(null != var65) {
                           Frames.method1960(var65);
                        }

                        Friend.method187();
                        Client.interfaceItemTriggers[++Client.field474 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 99) {
                        Client.field332 = true;
                        Script.field937 = Client.field329.readUnsignedByte();
                        class1.field10 = Client.field329.readUnsignedByte();
                        CombatInfoListHolder.field753 = Client.field329.readUnsignedShort();
                        class99.field1640 = Client.field329.readUnsignedByte();
                        class10.field104 = Client.field329.readUnsignedByte();
                        if(class10.field104 >= 100) {
                           var61 = 64 + Script.field937 * 128;
                           var4 = 64 + class1.field10 * 128;
                           var24 = class65.method1224(var61, var4, class156.plane) - CombatInfoListHolder.field753;
                           var6 = var61 - class206.cameraX;
                           var25 = var24 - class112.cameraZ;
                           var26 = var4 - class22.cameraY;
                           var107 = (int)Math.sqrt((double)(var26 * var26 + var6 * var6));
                           FaceNormal.cameraPitch = (int)(Math.atan2((double)var25, (double)var107) * 325.949D) & 2047;
                           Friend.cameraYaw = (int)(Math.atan2((double)var6, (double)var26) * -325.949D) & 2047;
                           if(FaceNormal.cameraPitch < 128) {
                              FaceNormal.cameraPitch = 128;
                           }

                           if(FaceNormal.cameraPitch > 383) {
                              FaceNormal.cameraPitch = 383;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 58) {
                        var18 = Client.field329.readString();
                        var27 = FontTypeFace.method3973(class156.method3091(class182.method3425(Client.field329)));
                        class140.sendGameMessage(6, var18, var27);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 229) {
                        var61 = Client.field329.method2901();
                        var104 = class140.method2681(var61);

                        for(var24 = 0; var24 < var104.itemIds.length; ++var24) {
                           var104.itemIds[var24] = -1;
                           var104.itemIds[var24] = 0;
                        }

                        Frames.method1960(var104);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 255) {
                        for(var61 = 0; var61 < class187.field2768; ++var61) {
                           class187 var101 = class110.method2137(var61);
                           if(null != var101) {
                              class165.field2154[var61] = 0;
                              class165.widgetSettings[var61] = 0;
                           }
                        }

                        Friend.method187();
                        Client.field569 += 32;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 146) {
                        Client.field504 = Client.field329.method3020() * 30;
                        Client.field482 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 180) {
                        var61 = Client.field329.offset + Client.field330;
                        var4 = Client.field329.readUnsignedShort();
                        var24 = Client.field329.readUnsignedShort();
                        if(Client.widgetRoot != var4) {
                           Client.widgetRoot = var4;
                           class39.method814(false);
                           CombatInfo1.method647(Client.widgetRoot);
                           class57.method1116(Client.widgetRoot);

                           for(var6 = 0; var6 < 100; ++var6) {
                              Client.field490[var6] = true;
                           }
                        }

                        WidgetNode var74;
                        for(; var24-- > 0; var74.field178 = true) {
                           var6 = Client.field329.readInt();
                           var25 = Client.field329.readUnsignedShort();
                           var26 = Client.field329.readUnsignedByte();
                           var74 = (WidgetNode)Client.componentTable.method2428((long)var6);
                           if(var74 != null && var74.id != var25) {
                              class30.method683(var74, true);
                              var74 = null;
                           }

                           if(null == var74) {
                              var74 = XItemContainer.method179(var6, var25, var26);
                           }
                        }

                        for(var89 = (WidgetNode)Client.componentTable.method2423(); null != var89; var89 = (WidgetNode)Client.componentTable.method2424()) {
                           if(var89.field178) {
                              var89.field178 = false;
                           } else {
                              class30.method683(var89, true);
                           }
                        }

                        Client.widgetFlags = new XHashTable(512);

                        while(Client.field329.offset < var61) {
                           var6 = Client.field329.readInt();
                           var25 = Client.field329.readUnsignedShort();
                           var26 = Client.field329.readUnsignedShort();
                           var107 = Client.field329.readInt();

                           for(var109 = var25; var109 <= var26; ++var109) {
                              long var31 = ((long)var6 << 32) + (long)var109;
                              Client.widgetFlags.method2425(new class133(var107), var31);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 155) {
                        var61 = Client.field329.readInt();
                        var4 = Client.field329.readUnsignedShort();
                        if(var61 < -70000) {
                           var4 += '耀';
                        }

                        if(var61 >= 0) {
                           var65 = class140.method2681(var61);
                        } else {
                           var65 = null;
                        }

                        if(null != var65) {
                           for(var6 = 0; var6 < var65.itemIds.length; ++var6) {
                              var65.itemIds[var6] = 0;
                              var65.itemQuantities[var6] = 0;
                           }
                        }

                        XItemContainer var91 = (XItemContainer)XItemContainer.itemContainers.method2428((long)var4);
                        if(null != var91) {
                           for(var25 = 0; var25 < var91.itemIds.length; ++var25) {
                              var91.itemIds[var25] = -1;
                              var91.stackSizes[var25] = 0;
                           }
                        }

                        var6 = Client.field329.readUnsignedShort();

                        for(var25 = 0; var25 < var6; ++var25) {
                           var26 = Client.field329.method2894();
                           var107 = Client.field329.method2884();
                           if(var107 == 255) {
                              var107 = Client.field329.method2901();
                           }

                           if(null != var65 && var25 < var65.itemIds.length) {
                              var65.itemIds[var25] = var26;
                              var65.itemQuantities[var25] = var107;
                           }

                           class3.method43(var4, var25, var26 - 1, var107);
                        }

                        if(var65 != null) {
                           Frames.method1960(var65);
                        }

                        Friend.method187();
                        Client.interfaceItemTriggers[++Client.field474 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 188 || Client.packetOpcode == 94 || Client.packetOpcode == 114 || Client.packetOpcode == 251 || Client.packetOpcode == 193 || Client.packetOpcode == 136 || Client.packetOpcode == 206 || Client.packetOpcode == 37 || Client.packetOpcode == 97 || Client.packetOpcode == 21) {
                        class3.method42();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     long var35;
                     if(Client.packetOpcode == 9) {
                        var61 = Client.field329.readInt();
                        var4 = Client.field329.readInt();
                        if(class188.field2774 == null || !class188.field2774.isValid()) {
                           try {
                              Iterator var70 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var70.hasNext()) {
                                 GarbageCollectorMXBean var90 = (GarbageCollectorMXBean)var70.next();
                                 if(var90.isValid()) {
                                    class188.field2774 = var90;
                                    Client.field503 = -1L;
                                    Client.field331 = -1L;
                                 }
                              }
                           } catch (Throwable var57) {
                              ;
                           }
                        }

                        long var33 = ChatMessages.method935();
                        var25 = -1;
                        if(null != class188.field2774) {
                           var8 = class188.field2774.getCollectionTime();
                           if(Client.field331 != -1L) {
                              var35 = var8 - Client.field331;
                              var12 = var33 - Client.field503;
                              if(0L != var12) {
                                 var25 = (int)(100L * var35 / var12);
                              }
                           }

                           Client.field331 = var8;
                           Client.field503 = var33;
                        }

                        Client.field327.method3124(37);
                        Client.field327.method2960(GameEngine.FPS);
                        Client.field327.method2899(var61);
                        Client.field327.method2844(var4);
                        Client.field327.method2880(var25);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 212) {
                        class40.xteaChanged(true);
                        Client.field329.method3122();
                        var61 = Client.field329.readUnsignedShort();
                        class160.method3159(Client.field329, var61);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 83) {
                        Client.field332 = false;

                        for(var61 = 0; var61 < 5; ++var61) {
                           Client.field478[var61] = false;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 26) {
                        var61 = Client.field329.method3015();
                        var4 = Client.field329.method3057();
                        var65 = class140.method2681(var61);
                        if(null != var65 && var65.type == 0) {
                           if(var4 > var65.scrollHeight - var65.height) {
                              var4 = var65.scrollHeight - var65.height;
                           }

                           if(var4 < 0) {
                              var4 = 0;
                           }

                           if(var65.scrollY != var4) {
                              var65.scrollY = var4;
                              Frames.method1960(var65);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 35) {
                        class160.method3159(Client.field329, Client.field330);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 143) {
                        var61 = Client.field329.method2894();
                        var4 = Client.field329.method2901();
                        var65 = class140.method2681(var4);
                        if(var65.modelType != 2 || var65.modelId != var61) {
                           var65.modelType = 2;
                           var65.modelId = var61;
                           Frames.method1960(var65);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 112) {
                        var61 = Client.field329.readUnsignedShort();
                        var4 = Client.field329.method2901();
                        var65 = class140.method2681(var4);
                        if(var65.modelType != 1 || var65.modelId != var61) {
                           var65.modelType = 1;
                           var65.modelId = var61;
                           Frames.method1960(var65);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     int var84;
                     if(Client.packetOpcode == 108) {
                        var18 = Client.field329.readString();
                        var19 = (long)Client.field329.readUnsignedShort();
                        var21 = (long)Client.field329.read24BitInt();
                        class177[] var105 = new class177[]{class177.field2658, class177.field2661, class177.field2668, class177.field2657, class177.field2663, class177.field2664};
                        class177 var72 = (class177)class37.method801(var105, Client.field329.readUnsignedByte());
                        var35 = (var19 << 32) + var21;
                        boolean var115 = false;

                        for(var84 = 0; var84 < 100; ++var84) {
                           if(var35 == Client.field339[var84]) {
                              var115 = true;
                              break;
                           }
                        }

                        if(class5.method82(var18)) {
                           var115 = true;
                        }

                        if(!var115 && Client.field336 == 0) {
                           Client.field339[Client.field378] = var35;
                           Client.field378 = (Client.field378 + 1) % 100;
                           String var38 = FontTypeFace.method3973(class156.method3091(class182.method3425(Client.field329)));
                           byte var14;
                           if(var72.field2659) {
                              var14 = 7;
                           } else {
                              var14 = 3;
                           }

                           if(var72.field2660 != -1) {
                              class140.sendGameMessage(var14, class25.method614(var72.field2660) + var18, var38);
                           } else {
                              class140.sendGameMessage(var14, var18, var38);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 134) {
                        var61 = Client.field329.readUnsignedByte();
                        if(Client.field329.readUnsignedByte() == 0) {
                           Client.grandExchangeOffers[var61] = new XGrandExchangeOffer();
                           Client.field329.offset += 18;
                        } else {
                           --Client.field329.offset;
                           Client.grandExchangeOffers[var61] = new XGrandExchangeOffer(Client.field329, false);
                        }

                        Client.field480 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 124) {
                        World var92 = new World();
                        var92.address = Client.field329.readString();
                        var92.id = Client.field329.readUnsignedShort();
                        var4 = Client.field329.readInt();
                        var92.mask = var4;
                        GameObject.setGameState(45);
                        class5.field46.method2109();
                        class5.field46 = null;
                        Friend.method185(var92);
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3196;
                     }

                     if(Client.packetOpcode == 200) {
                        Renderable.field1530 = Client.field329.method2907();
                        CombatInfo2.field2845 = Client.field329.method2907();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 4) {
                        var61 = Client.field329.method3020();
                        var4 = Client.field329.method2901();
                        var24 = Client.field329.method2885();
                        var89 = (WidgetNode)Client.componentTable.method2428((long)var4);
                        if(null != var89) {
                           class30.method683(var89, var61 != var89.id);
                        }

                        XItemContainer.method179(var4, var61, var24);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 33) {
                        while(Client.field329.offset < Client.field330) {
                           var61 = Client.field329.readUnsignedByte();
                           var63 = (var61 & 1) == 1;
                           var5 = Client.field329.readString();
                           var88 = Client.field329.readString();
                           Client.field329.readString();

                           for(var25 = 0; var25 < Client.ignoreCount; ++var25) {
                              Ignore var102 = Client.ignores[var25];
                              if(var63) {
                                 if(var88.equals(var102.name)) {
                                    var102.name = var5;
                                    var102.previousName = var88;
                                    var5 = null;
                                    break;
                                 }
                              } else if(var5.equals(var102.name)) {
                                 var102.name = var5;
                                 var102.previousName = var88;
                                 var5 = null;
                                 break;
                              }
                           }

                           if(var5 != null && Client.ignoreCount < 400) {
                              Ignore var67 = new Ignore();
                              Client.ignores[Client.ignoreCount] = var67;
                              var67.name = var5;
                              var67.previousName = var88;
                              ++Client.ignoreCount;
                           }
                        }

                        Client.field285 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 106) {
                        Client.field558 = Client.field329.readUnsignedByte();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 151) {
                        var18 = Client.field329.readString();
                        var4 = Client.field329.readUnsignedShort();
                        byte var99 = Client.field329.readByte();
                        var62 = false;
                        if(var99 == -128) {
                           var62 = true;
                        }

                        if(var62) {
                           if(class1.clanChatCount == 0) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3196;
                           }

                           boolean var100 = false;

                           for(var25 = 0; var25 < class1.clanChatCount && (!ObjectComposition.clanMembers[var25].username.equals(var18) || var4 != ObjectComposition.clanMembers[var25].world); ++var25) {
                              ;
                           }

                           if(var25 < class1.clanChatCount) {
                              while(var25 < class1.clanChatCount - 1) {
                                 ObjectComposition.clanMembers[var25] = ObjectComposition.clanMembers[1 + var25];
                                 ++var25;
                              }

                              --class1.clanChatCount;
                              ObjectComposition.clanMembers[class1.clanChatCount] = null;
                           }
                        } else {
                           Client.field329.readString();
                           XClanMember var66 = new XClanMember();
                           var66.username = var18;
                           var66.field277 = class9.method122(var66.username, Client.field286);
                           var66.world = var4;
                           var66.rank = var99;

                           for(var26 = class1.clanChatCount - 1; var26 >= 0; --var26) {
                              var107 = ObjectComposition.clanMembers[var26].field277.compareTo(var66.field277);
                              if(var107 == 0) {
                                 ObjectComposition.clanMembers[var26].world = var4;
                                 ObjectComposition.clanMembers[var26].rank = var99;
                                 if(var18.equals(class9.localPlayer.name)) {
                                    class180.field2700 = var99;
                                 }

                                 Client.field513 = Client.field470;
                                 Client.packetOpcode = -1;
                                 var1 = true;
                                 break label3196;
                              }

                              if(var107 < 0) {
                                 break;
                              }
                           }

                           if(class1.clanChatCount >= ObjectComposition.clanMembers.length) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3196;
                           }

                           for(var107 = class1.clanChatCount - 1; var107 > var26; --var107) {
                              ObjectComposition.clanMembers[1 + var107] = ObjectComposition.clanMembers[var107];
                           }

                           if(class1.clanChatCount == 0) {
                              ObjectComposition.clanMembers = new XClanMember[100];
                           }

                           ObjectComposition.clanMembers[1 + var26] = var66;
                           ++class1.clanChatCount;
                           if(var18.equals(class9.localPlayer.name)) {
                              class180.field2700 = var99;
                           }
                        }

                        Client.field513 = Client.field470;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     boolean var30;
                     if(Client.packetOpcode == 126) {
                        Client.field513 = Client.field470;
                        if(Client.field330 == 0) {
                           Client.field512 = null;
                           Client.clanChatOwner = null;
                           class1.clanChatCount = 0;
                           ObjectComposition.clanMembers = null;
                           Client.packetOpcode = -1;
                           var1 = true;
                        } else {
                           Client.clanChatOwner = Client.field329.readString();
                           long var39 = Client.field329.method2947();
                           var21 = var39;
                           if(var39 > 0L && var39 < 6582952005840035281L) {
                              if(var39 % 37L == 0L) {
                                 var5 = null;
                              } else {
                                 var26 = 0;

                                 for(long var41 = var39; var41 != 0L; var41 /= 37L) {
                                    ++var26;
                                 }

                                 StringBuilder var76 = new StringBuilder(var26);

                                 while(0L != var21) {
                                    var12 = var21;
                                    var21 /= 37L;
                                    var76.append(class205.field3086[(int)(var12 - 37L * var21)]);
                                 }

                                 var5 = var76.reverse().toString();
                              }
                           } else {
                              var5 = null;
                           }

                           Client.field512 = var5;
                           class57.field1026 = Client.field329.readByte();
                           var26 = Client.field329.readUnsignedByte();
                           if(var26 == 255) {
                              Client.packetOpcode = -1;
                              var1 = true;
                           } else {
                              class1.clanChatCount = var26;
                              XClanMember[] var71 = new XClanMember[100];

                              for(var109 = 0; var109 < class1.clanChatCount; ++var109) {
                                 var71[var109] = new XClanMember();
                                 var71[var109].username = Client.field329.readString();
                                 var71[var109].field277 = class9.method122(var71[var109].username, Client.field286);
                                 var71[var109].world = Client.field329.readUnsignedShort();
                                 var71[var109].rank = Client.field329.readByte();
                                 Client.field329.readString();
                                 if(var71[var109].username.equals(class9.localPlayer.name)) {
                                    class180.field2700 = var71[var109].rank;
                                 }
                              }

                              var30 = false;
                              var37 = class1.clanChatCount;

                              while(var37 > 0) {
                                 var30 = true;
                                 --var37;

                                 for(var84 = 0; var84 < var37; ++var84) {
                                    if(var71[var84].field277.compareTo(var71[var84 + 1].field277) > 0) {
                                       XClanMember var78 = var71[var84];
                                       var71[var84] = var71[var84 + 1];
                                       var71[var84 + 1] = var78;
                                       var30 = false;
                                    }
                                 }

                                 if(var30) {
                                    break;
                                 }
                              }

                              ObjectComposition.clanMembers = var71;
                              Client.packetOpcode = -1;
                              var1 = true;
                           }
                        }
                        break label3196;
                     }

                     if(Client.packetOpcode == 252) {
                        Client.field332 = true;
                        class145.field2010 = Client.field329.readUnsignedByte();
                        FileOnDisk.field1174 = Client.field329.readUnsignedByte();
                        class114.field1788 = Client.field329.readUnsignedShort();
                        Renderable.field1531 = Client.field329.readUnsignedByte();
                        class149.field2026 = Client.field329.readUnsignedByte();
                        if(class149.field2026 >= 100) {
                           class206.cameraX = 64 + class145.field2010 * 128;
                           class22.cameraY = 64 + FileOnDisk.field1174 * 128;
                           class112.cameraZ = class65.method1224(class206.cameraX, class22.cameraY, class156.plane) - class114.field1788;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 3) {
                        var61 = Client.field329.method3015();
                        var4 = Client.field329.readUnsignedShort();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        var24 = Client.field329.method2901();
                        var17 = class140.method2681(var24);
                        ItemComposition var64;
                        if(!var17.hasScript) {
                           if(var4 == -1) {
                              var17.modelType = 0;
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3196;
                           }

                           var64 = class168.getItemDefinition(var4);
                           var17.modelType = 4;
                           var17.modelId = var4;
                           var17.rotationX = var64.xan2d;
                           var17.rotationZ = var64.yan2d;
                           var17.field2238 = var64.zoom2d * 100 / var61;
                           Frames.method1960(var17);
                        } else {
                           var17.item = var4;
                           var17.stackSize = var61;
                           var64 = class168.getItemDefinition(var4);
                           var17.rotationX = var64.xan2d;
                           var17.rotationZ = var64.yan2d;
                           var17.rotationY = var64.zan2d;
                           var17.field2245 = var64.offsetX2d;
                           var17.field2246 = var64.offsetY2d;
                           var17.field2238 = var64.zoom2d;
                           if(var64.isStackable == 1) {
                              var17.field2254 = 1;
                           } else {
                              var17.field2254 = 2;
                           }

                           if(var17.field2251 > 0) {
                              var17.field2238 = var17.field2238 * 32 / var17.field2251;
                           } else if(var17.originalWidth > 0) {
                              var17.field2238 = var17.field2238 * 32 / var17.originalWidth;
                           }

                           Frames.method1960(var17);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     if(Client.packetOpcode == 117) {
                        while(Client.field329.offset < Client.field330) {
                           var3 = Client.field329.readUnsignedByte() == 1;
                           var27 = Client.field329.readString();
                           var5 = Client.field329.readString();
                           var6 = Client.field329.readUnsignedShort();
                           var25 = Client.field329.readUnsignedByte();
                           var26 = Client.field329.readUnsignedByte();
                           boolean var29 = (var26 & 2) != 0;
                           var30 = (var26 & 1) != 0;
                           if(var6 > 0) {
                              Client.field329.readString();
                              Client.field329.readUnsignedByte();
                              Client.field329.readInt();
                           }

                           Client.field329.readString();

                           for(var43 = 0; var43 < Client.friendCount; ++var43) {
                              Friend var44 = Client.friends[var43];
                              if(!var3) {
                                 if(var27.equals(var44.name)) {
                                    if(var44.world != var6) {
                                       boolean var13 = true;

                                       for(class16 var45 = (class16)Client.field312.method2500(); null != var45; var45 = (class16)Client.field312.method2505()) {
                                          if(var45.field167.equals(var27)) {
                                             if(var6 != 0 && var45.field166 == 0) {
                                                var45.method2510();
                                                var13 = false;
                                             } else if(var6 == 0 && var45.field166 != 0) {
                                                var45.method2510();
                                                var13 = false;
                                             }
                                          }
                                       }

                                       if(var13) {
                                          Client.field312.method2499(new class16(var27, var6));
                                       }

                                       var44.world = var6;
                                    }

                                    var44.previousName = var5;
                                    var44.rank = var25;
                                    var44.field144 = var29;
                                    var44.field147 = var30;
                                    var27 = null;
                                    break;
                                 }
                              } else if(var5.equals(var44.name)) {
                                 var44.name = var27;
                                 var44.previousName = var5;
                                 var27 = null;
                                 break;
                              }
                           }

                           if(var27 != null && Client.friendCount < 400) {
                              Friend var11 = new Friend();
                              Client.friends[Client.friendCount] = var11;
                              var11.name = var27;
                              var11.previousName = var5;
                              var11.world = var6;
                              var11.rank = var25;
                              var11.field144 = var29;
                              var11.field147 = var30;
                              ++Client.friendCount;
                           }
                        }

                        Client.field553 = 2;
                        Client.field285 = Client.field470;
                        var3 = false;
                        var4 = Client.friendCount;

                        while(var4 > 0) {
                           var3 = true;
                           --var4;

                           for(var24 = 0; var24 < var4; ++var24) {
                              var62 = false;
                              Friend var7 = Client.friends[var24];
                              Friend var28 = Client.friends[var24 + 1];
                              if(var7.world != Client.world && Client.world == var28.world) {
                                 var62 = true;
                              }

                              if(!var62 && var7.world == 0 && var28.world != 0) {
                                 var62 = true;
                              }

                              if(!var62 && !var7.field144 && var28.field144) {
                                 var62 = true;
                              }

                              if(!var62 && !var7.field147 && var28.field147) {
                                 var62 = true;
                              }

                              if(var62) {
                                 Friend var9 = Client.friends[var24];
                                 Client.friends[var24] = Client.friends[var24 + 1];
                                 Client.friends[1 + var24] = var9;
                                 var3 = false;
                              }
                           }

                           if(var3) {
                              break;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3196;
                     }

                     FaceNormal.method1950("" + Client.packetOpcode + "," + Client.field288 + "," + Client.field310 + "," + Client.field330, (Throwable)null);
                     WidgetNode.method200();
                  } catch (IOException var58) {
                     class7.method109();
                  } catch (Exception var59) {
                     var18 = "" + Client.packetOpcode + "," + Client.field288 + "," + Client.field310 + "," + Client.field330 + "," + (MessageNode.baseX + class9.localPlayer.pathX[0]) + "," + (class2.baseY + class9.localPlayer.pathY[0]) + ",";

                     for(var4 = 0; var4 < Client.field330 && var4 < 50; ++var4) {
                        var18 = var18 + Client.field329.payload[var4] + ",";
                     }

                     FaceNormal.method1950(var18, var59);
                     WidgetNode.method200();
                  }

                  var1 = true;
               }
            }

            if(!var1) {
               break;
            }
         }

         if(Client.gameState == 30) {
            while(class37.method802()) {
               Client.field327.method3124(227);
               Client.field327.method3010(0);
               var0 = Client.field327.offset;
               class207.method3954(Client.field327);
               Client.field327.method2853(Client.field327.offset - var0);
            }

            Object var47 = GameObject.field1621.field206;
            int var108;
            synchronized(GameObject.field1621.field206) {
               if(!Client.field280) {
                  GameObject.field1621.field207 = 0;
               } else if(class115.field1796 != 0 || GameObject.field1621.field207 >= 40) {
                  Client.field327.method3124(127);
                  Client.field327.method3010(0);
                  var108 = Client.field327.offset;
                  var2 = 0;

                  for(var61 = 0; var61 < GameObject.field1621.field207 && Client.field327.offset - var108 < 240; ++var61) {
                     ++var2;
                     var4 = GameObject.field1621.field209[var61];
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 502) {
                        var4 = 502;
                     }

                     var24 = GameObject.field1621.field212[var61];
                     if(var24 < 0) {
                        var24 = 0;
                     } else if(var24 > 764) {
                        var24 = 764;
                     }

                     var6 = var24 + var4 * 765;
                     if(GameObject.field1621.field209[var61] == -1 && GameObject.field1621.field212[var61] == -1) {
                        var24 = -1;
                        var4 = -1;
                        var6 = 524287;
                     }

                     if(Client.field294 == var24 && var4 == Client.field346) {
                        if(Client.field296 < 2047) {
                           ++Client.field296;
                        }
                     } else {
                        var25 = var24 - Client.field294;
                        Client.field294 = var24;
                        var26 = var4 - Client.field346;
                        Client.field346 = var4;
                        if(Client.field296 < 8 && var25 >= -32 && var25 <= 31 && var26 >= -32 && var26 <= 31) {
                           var25 += 32;
                           var26 += 32;
                           Client.field327.method2842((var25 << 6) + (Client.field296 << 12) + var26);
                           Client.field296 = 0;
                        } else if(Client.field296 < 8) {
                           Client.field327.method2862((Client.field296 << 19) + 8388608 + var6);
                           Client.field296 = 0;
                        } else {
                           Client.field327.method2844(var6 + (Client.field296 << 19) + -1073741824);
                           Client.field296 = 0;
                        }
                     }
                  }

                  Client.field327.method2853(Client.field327.offset - var108);
                  if(var2 >= GameObject.field1621.field207) {
                     GameObject.field1621.field207 = 0;
                  } else {
                     GameObject.field1621.field207 -= var2;

                     for(var61 = 0; var61 < GameObject.field1621.field207; ++var61) {
                        GameObject.field1621.field212[var61] = GameObject.field1621.field212[var61 + var2];
                        GameObject.field1621.field209[var61] = GameObject.field1621.field209[var2 + var61];
                     }
                  }
               }
            }

            if(class115.field1796 == 1 || !class36.field769 && class115.field1796 == 4 || class115.field1796 == 2) {
               long var48 = (class115.field1810 - Client.field293) / 50L;
               if(var48 > 4095L) {
                  var48 = 4095L;
               }

               Client.field293 = class115.field1810;
               var2 = class115.field1798;
               if(var2 < 0) {
                  var2 = 0;
               } else if(var2 > class20.field216) {
                  var2 = class20.field216;
               }

               var61 = class115.field1808;
               if(var61 < 0) {
                  var61 = 0;
               } else if(var61 > class2.field21) {
                  var61 = class2.field21;
               }

               var4 = (int)var48;
               Client.field327.method3124(117);
               Client.field327.method2842((class115.field1796 == 2?1:0) + (var4 << 1));
               Client.field327.method2842(var61);
               Client.field327.method2842(var2);
            }

            if(class105.field1707 > 0) {
               Client.field327.method3124(107);
               Client.field327.method2842(0);
               var0 = Client.field327.offset;
               long var50 = ChatMessages.method935();

               for(var61 = 0; var61 < class105.field1707; ++var61) {
                  var19 = var50 - Client.field511;
                  if(var19 > 16777215L) {
                     var19 = 16777215L;
                  }

                  Client.field511 = var50;
                  Client.field327.method2896((int)var19);
                  Client.field327.method3048(class105.field1709[var61]);
               }

               Client.field327.method2852(Client.field327.offset - var0);
            }

            if(Client.field375 > 0) {
               --Client.field375;
            }

            if(class105.field1700[96] || class105.field1700[97] || class105.field1700[98] || class105.field1700[99]) {
               Client.field426 = true;
            }

            if(Client.field426 && Client.field375 <= 0) {
               Client.field375 = 20;
               Client.field426 = false;
               Client.field327.method3124(2);
               Client.field327.method2887(Client.mapAngle);
               Client.field327.method2842(Client.field368);
            }

            if(class85.field1447 && !Client.field297) {
               Client.field297 = true;
               Client.field327.method3124(173);
               Client.field327.method3010(1);
            }

            if(!class85.field1447 && Client.field297) {
               Client.field297 = false;
               Client.field327.method3124(173);
               Client.field327.method3010(0);
            }

            if(Client.field514 != class156.plane) {
               Client.field514 = class156.plane;
               class2.method28(class156.plane);
            }

            if(Client.gameState == 30) {
               class108.method2099();

               for(var0 = 0; var0 < Client.field527; ++var0) {
                  --Client.field530[var0];
                  if(Client.field530[var0] >= -10) {
                     class53 var52 = Client.field351[var0];
                     if(var52 == null) {
                        Object var122 = null;
                        var52 = class53.method1046(class1.field13, Client.field552[var0], 0);
                        if(null == var52) {
                           continue;
                        }

                        Client.field530[var0] += var52.method1049();
                        Client.field351[var0] = var52;
                     }

                     if(Client.field530[var0] < 0) {
                        if(Client.field531[var0] != 0) {
                           var61 = (Client.field531[var0] & 255) * 128;
                           var4 = Client.field531[var0] >> 16 & 255;
                           var24 = var4 * 128 + 64 - class9.localPlayer.x;
                           if(var24 < 0) {
                              var24 = -var24;
                           }

                           var6 = Client.field531[var0] >> 8 & 255;
                           var25 = var6 * 128 + 64 - class9.localPlayer.y;
                           if(var25 < 0) {
                              var25 = -var25;
                           }

                           var26 = var25 + var24 - 128;
                           if(var26 > var61) {
                              Client.field530[var0] = -100;
                              continue;
                           }

                           if(var26 < 0) {
                              var26 = 0;
                           }

                           var2 = Client.field526 * (var61 - var26) / var61;
                        } else {
                           var2 = Client.field525;
                        }

                        if(var2 > 0) {
                           class55 var95 = var52.method1052().method1087(class119.field1853);
                           class66 var112 = class66.method1236(var95, 100, var2);
                           var112.method1239(Client.field529[var0] - 1);
                           class16.field168.method993(var112);
                        }

                        Client.field530[var0] = -100;
                     }
                  } else {
                     --Client.field527;

                     for(var108 = var0; var108 < Client.field527; ++var108) {
                        Client.field552[var108] = Client.field552[1 + var108];
                        Client.field351[var108] = Client.field351[1 + var108];
                        Client.field529[var108] = Client.field529[var108 + 1];
                        Client.field530[var108] = Client.field530[var108 + 1];
                        Client.field531[var108] = Client.field531[var108 + 1];
                     }

                     --var0;
                  }
               }

               if(Client.field401) {
                  boolean var60;
                  if(class138.field1915 != 0) {
                     var60 = true;
                  } else {
                     var60 = class39.field800.method2565();
                  }

                  if(!var60) {
                     if(Client.field522 != 0 && Client.field523 != -1) {
                        GameEngine.method2168(XItemContainer.field122, Client.field523, 0, Client.field522, false);
                     }

                     Client.field401 = false;
                  }
               }

               ++Client.field385;
               if(Client.field385 > 750) {
                  class7.method109();
               } else {
                  var0 = class45.field907;
                  int[] var120 = class45.field900;

                  for(var2 = 0; var2 < var0; ++var2) {
                     Player var96 = Client.cachedPlayers[var120[var2]];
                     if(null != var96) {
                        class5.method83(var96, 1);
                     }
                  }

                  NPC.method794();
                  int[] var117 = class45.field900;

                  for(var108 = 0; var108 < class45.field907; ++var108) {
                     Player var46 = Client.cachedPlayers[var117[var108]];
                     if(null != var46 && var46.field606 > 0) {
                        --var46.field606;
                        if(var46.field606 == 0) {
                           var46.overhead = null;
                        }
                     }
                  }

                  for(var108 = 0; var108 < Client.field323; ++var108) {
                     var2 = Client.field324[var108];
                     NPC var97 = Client.cachedNPCs[var2];
                     if(null != var97 && var97.field606 > 0) {
                        --var97.field606;
                        if(var97.field606 == 0) {
                           var97.overhead = null;
                        }
                     }
                  }

                  ++Client.field477;
                  if(Client.field326 != 0) {
                     Client.field394 += 20;
                     if(Client.field394 >= 400) {
                        Client.field326 = 0;
                     }
                  }

                  if(null != class101.field1644) {
                     ++Client.field396;
                     if(Client.field396 >= 15) {
                        Frames.method1960(class101.field1644);
                        class101.field1644 = null;
                     }
                  }

                  Widget var119 = class45.field896;
                  Widget var121 = Ignore.field201;
                  class45.field896 = null;
                  Ignore.field201 = null;
                  Client.field563 = null;
                  Client.field419 = false;
                  Client.field463 = false;
                  Client.field508 = 0;

                  while(class38.method809() && Client.field508 < 128) {
                     if(Client.field370 >= 2 && class105.field1700[82] && class20.field211 == 66) {
                        var18 = "";

                        MessageNode var85;
                        for(Iterator var113 = class47.field924.iterator(); var113.hasNext(); var18 = var18 + var85.name + ':' + var85.value + '\n') {
                           var85 = (MessageNode)var113.next();
                        }

                        class146.field2014.setContents(new StringSelection(var18), (ClipboardOwner)null);
                     } else {
                        Client.field510[Client.field508] = class20.field211;
                        Client.field509[Client.field508] = class3.field32;
                        ++Client.field508;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     class108.method2098(Client.widgetRoot, 0, 0, class2.field21, class20.field216, 0, 0);
                  }

                  ++Client.field470;

                  while(true) {
                     Widget var98;
                     class18 var116;
                     do {
                        var116 = (class18)Client.field485.method2481();
                        if(var116 == null) {
                           while(true) {
                              do {
                                 var116 = (class18)Client.field486.method2481();
                                 if(var116 == null) {
                                    while(true) {
                                       do {
                                          var116 = (class18)Client.field484.method2481();
                                          if(var116 == null) {
                                             class1.method14();
                                             if(Client.field458 != null) {
                                                Frames.method1960(Client.field458);
                                                ++class138.field1919;
                                                if(Client.field419 && Client.field463) {
                                                   var2 = class115.field1802;
                                                   var61 = class115.field1801;
                                                   var2 -= Client.field460;
                                                   var61 -= Client.field461;
                                                   if(var2 < Client.field506) {
                                                      var2 = Client.field506;
                                                   }

                                                   if(var2 + Client.field458.width > Client.field459.width + Client.field506) {
                                                      var2 = Client.field459.width + Client.field506 - Client.field458.width;
                                                   }

                                                   if(var61 < Client.field465) {
                                                      var61 = Client.field465;
                                                   }

                                                   if(Client.field458.height + var61 > Client.field465 + Client.field459.height) {
                                                      var61 = Client.field459.height + Client.field465 - Client.field458.height;
                                                   }

                                                   var4 = var2 - Client.field424;
                                                   var24 = var61 - Client.field468;
                                                   var6 = Client.field458.field2272;
                                                   if(class138.field1919 > Client.field458.field2212 && (var4 > var6 || var4 < -var6 || var24 > var6 || var24 < -var6)) {
                                                      Client.field469 = true;
                                                   }

                                                   var25 = Client.field459.scrollX + (var2 - Client.field506);
                                                   var26 = Client.field459.scrollY + (var61 - Client.field465);
                                                   class18 var81;
                                                   if(null != Client.field458.field2285 && Client.field469) {
                                                      var81 = new class18();
                                                      var81.field185 = Client.field458;
                                                      var81.field196 = var25;
                                                      var81.field189 = var26;
                                                      var81.field197 = Client.field458.field2285;
                                                      class97.method1988(var81);
                                                   }

                                                   if(class115.field1809 == 0) {
                                                      if(Client.field469) {
                                                         if(Client.field458.field2314 != null) {
                                                            var81 = new class18();
                                                            var81.field185 = Client.field458;
                                                            var81.field196 = var25;
                                                            var81.field189 = var26;
                                                            var81.field188 = Client.field563;
                                                            var81.field197 = Client.field458.field2314;
                                                            class97.method1988(var81);
                                                         }

                                                         if(Client.field563 != null && class72.method1465(Client.field458) != null) {
                                                            Client.field327.method3124(91);
                                                            Client.field327.method2889(Client.field458.item);
                                                            Client.field327.method3008(Client.field458.id);
                                                            Client.field327.method2844(Client.field563.id);
                                                            Client.field327.method2842(Client.field563.item);
                                                            Client.field327.method2890(Client.field563.index);
                                                            Client.field327.method2889(Client.field458.index);
                                                         }
                                                      } else {
                                                         var107 = class7.method110();
                                                         if(Client.menuOptionCount <= 2 || (Client.field422 != 1 || class41.method833()) && !class72.method1464(var107)) {
                                                            if(Client.menuOptionCount > 0) {
                                                               class60.method1205(Client.field424 + Client.field460, Client.field461 + Client.field468);
                                                            }
                                                         } else {
                                                            class168.method3260(Client.field424 + Client.field460, Client.field461 + Client.field468);
                                                         }
                                                      }

                                                      Client.field458 = null;
                                                   }
                                                } else if(class138.field1919 > 1) {
                                                   Client.field458 = null;
                                                }
                                             }

                                             if(class5.field50 != null) {
                                                Frames.method1960(class5.field50);
                                                ++Client.field403;
                                                if(class115.field1809 == 0) {
                                                   if(Client.field402) {
                                                      if(WallObject.field1534 == class5.field50 && Client.field398 != Client.field284) {
                                                         Widget var118 = class5.field50;
                                                         byte var103 = 0;
                                                         if(Client.field448 == 1 && var118.contentType == 206) {
                                                            var103 = 1;
                                                         }

                                                         if(var118.itemIds[Client.field284] <= 0) {
                                                            var103 = 0;
                                                         }

                                                         var24 = class8.method112(var118);
                                                         var63 = (var24 >> 29 & 1) != 0;
                                                         if(var63) {
                                                            var6 = Client.field398;
                                                            var25 = Client.field284;
                                                            var118.itemIds[var25] = var118.itemIds[var6];
                                                            var118.itemQuantities[var25] = var118.itemQuantities[var6];
                                                            var118.itemIds[var6] = -1;
                                                            var118.itemQuantities[var6] = 0;
                                                         } else if(var103 == 1) {
                                                            var6 = Client.field398;
                                                            var25 = Client.field284;

                                                            while(var6 != var25) {
                                                               if(var6 > var25) {
                                                                  var118.method3283(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var25) {
                                                                  var118.method3283(1 + var6, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var118.method3283(Client.field284, Client.field398);
                                                         }

                                                         Client.field327.method3124(132);
                                                         Client.field327.method2890(Client.field284);
                                                         Client.field327.method2890(Client.field398);
                                                         Client.field327.method2844(class5.field50.id);
                                                         Client.field327.method3010(var103);
                                                      }
                                                   } else {
                                                      var2 = class7.method110();
                                                      if(Client.menuOptionCount > 2 && (Client.field422 == 1 && !class41.method833() || class72.method1464(var2))) {
                                                         class168.method3260(Client.field399, Client.field491);
                                                      } else if(Client.menuOptionCount > 0) {
                                                         class60.method1205(Client.field399, Client.field491);
                                                      }
                                                   }

                                                   Client.field396 = 10;
                                                   class115.field1796 = 0;
                                                   class5.field50 = null;
                                                } else if(Client.field403 >= 5 && (class115.field1802 > 5 + Client.field399 || class115.field1802 < Client.field399 - 5 || class115.field1801 > Client.field491 + 5 || class115.field1801 < Client.field491 - 5)) {
                                                   Client.field402 = true;
                                                }
                                             }

                                             if(Region.method1893()) {
                                                var2 = Region.field1462;
                                                var61 = Region.field1517;
                                                Client.field327.method3124(129);
                                                Client.field327.method3010(5);
                                                Client.field327.method2887(var61 + class2.baseY);
                                                Client.field327.method3048(class105.field1700[82]?(class105.field1700[81]?2:1):0);
                                                Client.field327.method2889(var2 + MessageNode.baseX);
                                                Region.method1795();
                                                Client.field392 = class115.field1808;
                                                Client.field524 = class115.field1798;
                                                Client.field326 = 1;
                                                Client.field394 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var61;
                                             }

                                             if(class45.field896 != var119) {
                                                if(null != var119) {
                                                   Frames.method1960(var119);
                                                }

                                                if(null != class45.field896) {
                                                   Frames.method1960(class45.field896);
                                                }
                                             }

                                             if(Ignore.field201 != var121 && Client.field507 == Client.field436) {
                                                if(null != var121) {
                                                   Frames.method1960(var121);
                                                }

                                                if(Ignore.field201 != null) {
                                                   Frames.method1960(Ignore.field201);
                                                }
                                             }

                                             if(Ignore.field201 != null) {
                                                if(Client.field436 < Client.field507) {
                                                   ++Client.field436;
                                                   if(Client.field436 == Client.field507) {
                                                      Frames.method1960(Ignore.field201);
                                                   }
                                                }
                                             } else if(Client.field436 > 0) {
                                                --Client.field436;
                                             }

                                             var2 = Client.field349 + class9.localPlayer.x;
                                             var61 = Client.field449 + class9.localPlayer.y;
                                             if(Overlay.field3057 - var2 < -500 || Overlay.field3057 - var2 > 500 || class40.field812 - var61 < -500 || class40.field812 - var61 > 500) {
                                                Overlay.field3057 = var2;
                                                class40.field812 = var61;
                                             }

                                             if(var2 != Overlay.field3057) {
                                                Overlay.field3057 += (var2 - Overlay.field3057) / 16;
                                             }

                                             if(class40.field812 != var61) {
                                                class40.field812 += (var61 - class40.field812) / 16;
                                             }

                                             if(class115.field1809 == 4 && class36.field769) {
                                                var4 = class115.field1801 - Client.field373;
                                                Client.field371 = var4 * 2;
                                                Client.field373 = var4 != -1 && var4 != 1?(class115.field1801 + Client.field373) / 2:class115.field1801;
                                                var24 = Client.field560 - class115.field1802;
                                                Client.field472 = var24 * 2;
                                                Client.field560 = var24 != -1 && var24 != 1?(class115.field1802 + Client.field560) / 2:class115.field1802;
                                             } else {
                                                if(class105.field1700[96]) {
                                                   Client.field472 += (-24 - Client.field472) / 2;
                                                } else if(class105.field1700[97]) {
                                                   Client.field472 += (24 - Client.field472) / 2;
                                                } else {
                                                   Client.field472 /= 2;
                                                }

                                                if(class105.field1700[98]) {
                                                   Client.field371 += (12 - Client.field371) / 2;
                                                } else if(class105.field1700[99]) {
                                                   Client.field371 += (-12 - Client.field371) / 2;
                                                } else {
                                                   Client.field371 /= 2;
                                                }

                                                Client.field373 = class115.field1801;
                                                Client.field560 = class115.field1802;
                                             }

                                             Client.mapAngle = Client.field472 / 2 + Client.mapAngle & 2047;
                                             Client.field368 += Client.field371 / 2;
                                             if(Client.field368 < 128) {
                                                Client.field368 = 128;
                                             }

                                             if(Client.field368 > 383) {
                                                Client.field368 = 383;
                                             }

                                             var4 = Overlay.field3057 >> 7;
                                             var24 = class40.field812 >> 7;
                                             var6 = class65.method1224(Overlay.field3057, class40.field812, class156.plane);
                                             var25 = 0;
                                             if(var4 > 3 && var24 > 3 && var4 < 100 && var24 < 100) {
                                                for(var26 = var4 - 4; var26 <= 4 + var4; ++var26) {
                                                   for(var107 = var24 - 4; var107 <= 4 + var24; ++var107) {
                                                      var109 = class156.plane;
                                                      if(var109 < 3 && (class10.tileSettings[1][var26][var107] & 2) == 2) {
                                                         ++var109;
                                                      }

                                                      var43 = var6 - class10.tileHeights[var109][var26][var107];
                                                      if(var43 > var25) {
                                                         var25 = var43;
                                                      }
                                                   }
                                                }
                                             }

                                             var26 = var25 * 192;
                                             if(var26 > 98048) {
                                                var26 = 98048;
                                             }

                                             if(var26 < '耀') {
                                                var26 = '耀';
                                             }

                                             if(var26 > Client.field377) {
                                                Client.field377 += (var26 - Client.field377) / 24;
                                             } else if(var26 < Client.field377) {
                                                Client.field377 += (var26 - Client.field377) / 80;
                                             }

                                             if(Client.field332) {
                                                var2 = class145.field2010 * 128 + 64;
                                                var61 = FileOnDisk.field1174 * 128 + 64;
                                                var4 = class65.method1224(var2, var61, class156.plane) - class114.field1788;
                                                if(class206.cameraX < var2) {
                                                   class206.cameraX += class149.field2026 * (var2 - class206.cameraX) / 1000 + Renderable.field1531;
                                                   if(class206.cameraX > var2) {
                                                      class206.cameraX = var2;
                                                   }
                                                }

                                                if(class206.cameraX > var2) {
                                                   class206.cameraX -= class149.field2026 * (class206.cameraX - var2) / 1000 + Renderable.field1531;
                                                   if(class206.cameraX < var2) {
                                                      class206.cameraX = var2;
                                                   }
                                                }

                                                if(class112.cameraZ < var4) {
                                                   class112.cameraZ += (var4 - class112.cameraZ) * class149.field2026 / 1000 + Renderable.field1531;
                                                   if(class112.cameraZ > var4) {
                                                      class112.cameraZ = var4;
                                                   }
                                                }

                                                if(class112.cameraZ > var4) {
                                                   class112.cameraZ -= Renderable.field1531 + (class112.cameraZ - var4) * class149.field2026 / 1000;
                                                   if(class112.cameraZ < var4) {
                                                      class112.cameraZ = var4;
                                                   }
                                                }

                                                if(class22.cameraY < var61) {
                                                   class22.cameraY += (var61 - class22.cameraY) * class149.field2026 / 1000 + Renderable.field1531;
                                                   if(class22.cameraY > var61) {
                                                      class22.cameraY = var61;
                                                   }
                                                }

                                                if(class22.cameraY > var61) {
                                                   class22.cameraY -= class149.field2026 * (class22.cameraY - var61) / 1000 + Renderable.field1531;
                                                   if(class22.cameraY < var61) {
                                                      class22.cameraY = var61;
                                                   }
                                                }

                                                var2 = Script.field937 * 128 + 64;
                                                var61 = class1.field10 * 128 + 64;
                                                var4 = class65.method1224(var2, var61, class156.plane) - CombatInfoListHolder.field753;
                                                var24 = var2 - class206.cameraX;
                                                var6 = var4 - class112.cameraZ;
                                                var25 = var61 - class22.cameraY;
                                                var26 = (int)Math.sqrt((double)(var24 * var24 + var25 * var25));
                                                var107 = (int)(Math.atan2((double)var6, (double)var26) * 325.949D) & 2047;
                                                var109 = (int)(Math.atan2((double)var24, (double)var25) * -325.949D) & 2047;
                                                if(var107 < 128) {
                                                   var107 = 128;
                                                }

                                                if(var107 > 383) {
                                                   var107 = 383;
                                                }

                                                if(FaceNormal.cameraPitch < var107) {
                                                   FaceNormal.cameraPitch += class10.field104 * (var107 - FaceNormal.cameraPitch) / 1000 + class99.field1640;
                                                   if(FaceNormal.cameraPitch > var107) {
                                                      FaceNormal.cameraPitch = var107;
                                                   }
                                                }

                                                if(FaceNormal.cameraPitch > var107) {
                                                   FaceNormal.cameraPitch -= class99.field1640 + class10.field104 * (FaceNormal.cameraPitch - var107) / 1000;
                                                   if(FaceNormal.cameraPitch < var107) {
                                                      FaceNormal.cameraPitch = var107;
                                                   }
                                                }

                                                var43 = var109 - Friend.cameraYaw;
                                                if(var43 > 1024) {
                                                   var43 -= 2048;
                                                }

                                                if(var43 < -1024) {
                                                   var43 += 2048;
                                                }

                                                if(var43 > 0) {
                                                   Friend.cameraYaw += class10.field104 * var43 / 1000 + class99.field1640;
                                                   Friend.cameraYaw &= 2047;
                                                }

                                                if(var43 < 0) {
                                                   Friend.cameraYaw -= class10.field104 * -var43 / 1000 + class99.field1640;
                                                   Friend.cameraYaw &= 2047;
                                                }

                                                var37 = var109 - Friend.cameraYaw;
                                                if(var37 > 1024) {
                                                   var37 -= 2048;
                                                }

                                                if(var37 < -1024) {
                                                   var37 += 2048;
                                                }

                                                if(var37 < 0 && var43 > 0 || var37 > 0 && var43 < 0) {
                                                   Friend.cameraYaw = var109;
                                                }
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field538[var2];
                                             }

                                             class9.chatMessages.method912();
                                             var2 = class110.method2135();
                                             var61 = ScriptState.method165();
                                             if(var2 > 15000 && var61 > 15000) {
                                                Client.field337 = 250;
                                                FileOnDisk.method1485(14500);
                                                Client.field327.method3124(219);
                                             }

                                             ++Client.field355;
                                             if(Client.field355 > 500) {
                                                Client.field355 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.field349 += Client.field479;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.field449 += Client.field352;
                                                }

                                                if((var4 & 4) == 4) {
                                                   Client.field353 += Client.field304;
                                                }
                                             }

                                             if(Client.field349 < -50) {
                                                Client.field479 = 2;
                                             }

                                             if(Client.field349 > 50) {
                                                Client.field479 = -2;
                                             }

                                             if(Client.field449 < -55) {
                                                Client.field352 = 2;
                                             }

                                             if(Client.field449 > 55) {
                                                Client.field352 = -2;
                                             }

                                             if(Client.field353 < -40) {
                                                Client.field304 = 1;
                                             }

                                             if(Client.field353 > 40) {
                                                Client.field304 = -1;
                                             }

                                             ++Client.field369;
                                             if(Client.field369 > 500) {
                                                Client.field369 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.mapScale += Client.field357;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field528;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field357 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field357 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field528 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field528 = -1;
                                             }

                                             for(class16 var114 = (class16)Client.field312.method2500(); var114 != null; var114 = (class16)Client.field312.method2505()) {
                                                if((long)var114.field176 < ChatMessages.method935() / 1000L - 5L) {
                                                   if(var114.field166 > 0) {
                                                      class140.sendGameMessage(5, "", var114.field167 + " has logged in.");
                                                   }

                                                   if(var114.field166 == 0) {
                                                      class140.sendGameMessage(5, "", var114.field167 + " has logged out.");
                                                   }

                                                   var114.method2510();
                                                }
                                             }

                                             ++Client.field333;
                                             if(Client.field333 > 50) {
                                                Client.field327.method3124(108);
                                             }

                                             try {
                                                if(null != class5.field46 && Client.field327.offset > 0) {
                                                   class5.field46.method2114(Client.field327.payload, 0, Client.field327.offset);
                                                   Client.field327.offset = 0;
                                                   Client.field333 = 0;
                                                }
                                             } catch (IOException var53) {
                                                class7.method109();
                                             }

                                             return;
                                          }

                                          var98 = var116.field185;
                                          if(var98.index < 0) {
                                             break;
                                          }

                                          var104 = class140.method2681(var98.parentId);
                                       } while(var104 == null || null == var104.children || var98.index >= var104.children.length || var98 != var104.children[var98.index]);

                                       class97.method1988(var116);
                                    }
                                 }

                                 var98 = var116.field185;
                                 if(var98.index < 0) {
                                    break;
                                 }

                                 var104 = class140.method2681(var98.parentId);
                              } while(null == var104 || var104.children == null || var98.index >= var104.children.length || var98 != var104.children[var98.index]);

                              class97.method1988(var116);
                           }
                        }

                        var98 = var116.field185;
                        if(var98.index < 0) {
                           break;
                        }

                        var104 = class140.method2681(var98.parentId);
                     } while(var104 == null || var104.children == null || var98.index >= var104.children.length || var98 != var104.children[var98.index]);

                     class97.method1988(var116);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-748036130"
   )
   static void method192(Sequence var0, int var1, int var2, int var3) {
      if(Client.field527 < 50 && Client.field526 != 0) {
         if(var0.field3058 != null && var1 < var0.field3058.length) {
            int var4 = var0.field3058[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field552[Client.field527] = var5;
               Client.field529[Client.field527] = var6;
               Client.field530[Client.field527] = 0;
               Client.field351[Client.field527] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field531[Client.field527] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field527;
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1875989363"
   )
   static int method193(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class140.method2681(class32.field729[--class101.field1648]);
      } else {
         var3 = var2?class32.field719:class185.field2760;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class32.field729[--class101.field1648] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3270(var4, class32.scriptStringStack[--World.scriptStringStackSize]);
            return 1;
         } else {
            --World.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class101.field1648 -= 2;
         var4 = class32.field729[class101.field1648];
         int var5 = class32.field729[class101.field1648 + 1];
         var3.parent = CollisionData.method2322(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2274 = class32.field729[--class101.field1648] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2272 = class32.field729[--class101.field1648];
         return 1;
      } else if(var0 == 1304) {
         var3.field2212 = class32.field729[--class101.field1648];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class32.scriptStringStack[--World.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.field2275 = class32.scriptStringStack[--World.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
