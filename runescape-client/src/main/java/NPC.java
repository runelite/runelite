import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("v")
   static int[] field808;
   @ObfuscatedName("a")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("en")
   static SpritePixels field811;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "744831752"
   )
   final void method750(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && Friend.getAnimation(super.animation).field1017 == 1) {
         super.animation = -1;
      }

      if(super.field893 < 9) {
         ++super.field893;
      }

      for(int var5 = super.field893; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field896[var5] = super.field896[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field896[0] = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "4"
   )
   public static boolean method751(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1853658170"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Friend.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && null != var1?null:Friend.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method822(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2347();
            super.field840 = var3.modelHeight;
            if(super.graphic != -1 && super.field877 != -1) {
               Model var4 = class49.method1029(super.graphic).method940(super.field877);
               if(null != var4) {
                  var4.method2334(0, -super.field880, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field915 == 1) {
               var3.field1908 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "506388399"
   )
   final boolean vmethod785() {
      return this.composition != null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "44"
   )
   static final boolean method758(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class23.method585(var0)) {
         return true;
      } else {
         char[] var1 = class167.field2722;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var3 == var0) {
               return true;
            }
         }

         var1 = class167.field2723;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1886388393"
   )
   final void method762(int var1, int var2, boolean var3) {
      if(super.animation != -1 && Friend.getAnimation(super.animation).field1017 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field893 < 9) {
               ++super.field893;
            }

            for(int var6 = super.field893; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field896[var6] = super.field896[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field896[0] = 1;
            return;
         }
      }

      super.field893 = 0;
      super.field898 = 0;
      super.field897 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field843 * 64 + 128 * super.pathX[0];
      super.y = super.pathY[0] * 128 + super.field843 * 64;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)LModIcon;",
      garbageValue = "1937272979"
   )
   static ModIcon method763(class170 var0, int var1, int var2) {
      if(!class126.method2817(var0, var1, var2)) {
         return null;
      } else {
         ModIcon var4 = new ModIcon();
         var4.width = class79.field1460;
         var4.originalHeight = class79.field1456;
         var4.offsetX = class79.field1462[0];
         var4.offsetY = class79.field1458[0];
         var4.originalWidth = class59.field1268[0];
         var4.height = class79.field1461[0];
         var4.palette = class132.field2126;
         var4.pixels = class8.field139[0];
         class35.method747();
         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass156;",
      garbageValue = "55"
   )
   public static class156 method764(int var0) {
      class156[] var1 = Renderable.method1945();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class156 var3 = var1[var2];
         if(var0 == var3.field2340) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-610130063"
   )
   static final void method766() {
      if(Client.field381 > 1) {
         --Client.field381;
      }

      if(Client.field333 > 0) {
         --Client.field333;
      }

      if(Client.field334) {
         Client.field334 = false;
         class151.method3162();
      } else {
         if(!Client.isMenuOpen) {
            Client.menuOptions[0] = "Cancel";
            Client.menuTargets[0] = "";
            Client.menuTypes[0] = 1006;
            Client.menuOptionCount = 1;
         }

         int var0;
         boolean var1;
         int var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int var25;
         int var56;
         long var59;
         int var77;
         int var80;
         Widget var84;
         for(var0 = 0; var0 < 100; ++var0) {
            if(BufferProvider.field1475 == null) {
               var1 = false;
            } else {
               label3011: {
                  String var28;
                  try {
                     var2 = BufferProvider.field1475.method3021();
                     if(var2 == 0) {
                        var1 = false;
                        break label3011;
                     }

                     if(Client.packetOpcode == -1) {
                        BufferProvider.field1475.method3035(Client.field325.payload, 0, 1);
                        Client.field325.offset = 0;
                        Client.packetOpcode = Client.field325.method2793();
                        Client.field326 = class191.field3104[Client.packetOpcode];
                        --var2;
                     }

                     if(Client.field326 == -1) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label3011;
                        }

                        BufferProvider.field1475.method3035(Client.field325.payload, 0, 1);
                        Client.field326 = Client.field325.payload[0] & 255;
                        --var2;
                     }

                     if(Client.field326 == -2) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label3011;
                        }

                        BufferProvider.field1475.method3035(Client.field325.payload, 0, 2);
                        Client.field325.offset = 0;
                        Client.field326 = Client.field325.method2717();
                        var2 -= 2;
                     }

                     if(var2 < Client.field326) {
                        var1 = false;
                        break label3011;
                     }

                     Client.field325.offset = 0;
                     BufferProvider.field1475.method3035(Client.field325.payload, 0, Client.field326);
                     Client.field328 = 0;
                     Client.field434 = Client.field331;
                     Client.field331 = Client.field330 * -1;
                     Client.field330 = Client.packetOpcode * -1;
                     int var70;
                     WidgetNode var76;
                     if(Client.packetOpcode == 162) {
                        var3 = Client.field325.offset + Client.field326;
                        var4 = Client.field325.method2717();
                        var5 = Client.field325.method2717();
                        if(Client.widgetRoot != var4) {
                           Client.widgetRoot = var4;
                           class47.method989(Client.widgetRoot, class159.field2374, class92.field1643, false);
                           WidgetNode.method43(Client.widgetRoot);
                           class40.method802(Client.widgetRoot);

                           for(var6 = 0; var6 < 100; ++var6) {
                              Client.field374[var6] = true;
                           }
                        }

                        WidgetNode var61;
                        for(; var5-- > 0; var61.field60 = true) {
                           var6 = Client.field325.method2533();
                           var7 = Client.field325.method2717();
                           var56 = Client.field325.method2528();
                           var61 = (WidgetNode)Client.componentTable.method3817((long)var6);
                           if(null != var61 && var7 != var61.id) {
                              TextureProvider.method2217(var61, true);
                              var61 = null;
                           }

                           if(var61 == null) {
                              WidgetNode var65 = new WidgetNode();
                              var65.id = var7;
                              var65.field61 = var56;
                              Client.componentTable.method3823(var65, (long)var6);
                              WidgetNode.method43(var7);
                              Widget var68 = class24.method600(var6);
                              class53.method1101(var68);
                              if(Client.field444 != null) {
                                 class53.method1101(Client.field444);
                                 Client.field444 = null;
                              }

                              Friend.method191();
                              class10.method136(Widget.widgets[var6 >> 16], var68, false);
                              class40.method802(var7);
                              if(Client.widgetRoot != -1) {
                                 var70 = Client.widgetRoot;
                                 if(class93.method2114(var70)) {
                                    ItemComposition.method1119(Widget.widgets[var70], 1);
                                 }
                              }

                              var61 = var65;
                           }
                        }

                        for(var76 = (WidgetNode)Client.componentTable.method3820(); null != var76; var76 = (WidgetNode)Client.componentTable.method3827()) {
                           if(var76.field60) {
                              var76.field60 = false;
                           } else {
                              TextureProvider.method2217(var76, true);
                           }
                        }

                        Client.widgetFlags = new XHashTable(512);

                        while(Client.field325.offset < var3) {
                           var6 = Client.field325.method2533();
                           var7 = Client.field325.method2717();
                           var56 = Client.field325.method2717();
                           var77 = Client.field325.method2533();

                           for(var80 = var7; var80 <= var56; ++var80) {
                              long var81 = ((long)var6 << 32) + (long)var80;
                              Client.widgetFlags.method3823(new class204(var77), var81);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 214) {
                        var3 = Client.field325.method2533();
                        WidgetNode var94 = (WidgetNode)Client.componentTable.method3817((long)var3);
                        if(null != var94) {
                           TextureProvider.method2217(var94, true);
                        }

                        if(Client.field444 != null) {
                           class53.method1101(Client.field444);
                           Client.field444 = null;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 229) {
                        var3 = Client.field325.method2731();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        class161.method3211(var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 231) {
                        var3 = Client.field325.method2570();
                        var4 = Client.field325.method2731();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        class124.method2780(var4, var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     String var82;
                     if(Client.packetOpcode == 55) {
                        var3 = Client.field325.method2556();
                        var82 = Client.field325.method2530();
                        var5 = Client.field325.method2557();
                        if(var5 >= 1 && var5 <= 8) {
                           if(var82.equalsIgnoreCase("null")) {
                              var82 = null;
                           }

                           Client.field409[var5 - 1] = var82;
                           Client.field514[var5 - 1] = var3 == 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     Widget var85;
                     if(Client.packetOpcode == 117) {
                        var3 = Client.field325.method2533();
                        var4 = Client.field325.method2717();
                        if(var3 < -70000) {
                           var4 += '耀';
                        }

                        if(var3 >= 0) {
                           var85 = class24.method600(var3);
                        } else {
                           var85 = null;
                        }

                        GameEngine.method3132(var4);
                        var6 = Client.field325.method2717();

                        for(var7 = 0; var7 < var6; ++var7) {
                           var56 = Client.field325.method2528();
                           if(var56 == 255) {
                              var56 = Client.field325.method2576();
                           }

                           var77 = Client.field325.method2566();
                           if(var85 != null && var7 < var85.itemIds.length) {
                              var85.itemIds[var7] = var77;
                              var85.itemQuantities[var7] = var56;
                           }

                           Client.method555(var4, var7, var77 - 1, var56);
                        }

                        if(var85 != null) {
                           class53.method1101(var85);
                        }

                        SecondaryBufferProvider.method1683();
                        Client.field468[++Client.field314 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 63) {
                        var3 = Client.field325.method2526();
                        var84 = class24.method600(var3);

                        for(var5 = 0; var5 < var84.itemIds.length; ++var5) {
                           var84.itemIds[var5] = -1;
                           var84.itemIds[var5] = 0;
                        }

                        class53.method1101(var84);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     boolean var54;
                     if(Client.packetOpcode == 244) {
                        var54 = Client.field325.method2528() == 1;
                        if(var54) {
                           class1.field28 = class5.method63() - Client.field325.method2534();
                           class18.field260 = new class224(Client.field325, true);
                        } else {
                           class18.field260 = null;
                        }

                        Client.field476 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 175) {
                        var3 = Client.field325.method2717();
                        var4 = Client.field325.method2533();
                        var85 = class24.method600(var4);
                        if(var85.modelType != 1 || var3 != var85.modelId) {
                           var85.modelType = 1;
                           var85.modelId = var3;
                           class53.method1101(var85);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 166 || Client.packetOpcode == 43 || Client.packetOpcode == 227 || Client.packetOpcode == 97 || Client.packetOpcode == 159 || Client.packetOpcode == 5 || Client.packetOpcode == 151 || Client.packetOpcode == 90 || Client.packetOpcode == 246 || Client.packetOpcode == 74) {
                        Sequence.method933();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 12) {
                        var3 = Client.field325.method2565();
                        XItemContainer var87 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var3);
                        if(null != var87) {
                           var87.unlink();
                        }

                        Client.field468[++Client.field314 - 1 & 31] = var3 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 203) {
                        World var103 = new World();
                        var103.address = Client.field325.method2530();
                        var103.id = Client.field325.method2717();
                        var4 = Client.field325.method2533();
                        var103.mask = var4;
                        XItemContainer.setGameState(45);
                        BufferProvider.field1475.method3039();
                        BufferProvider.field1475 = null;
                        class110.selectWorld(var103);
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3011;
                     }

                     if(Client.packetOpcode == 94) {
                        Client.flagX = Client.field325.method2528();
                        if(Client.flagX == 255) {
                           Client.flagX = 0;
                        }

                        Client.flagY = Client.field325.method2528();
                        if(Client.flagY == 255) {
                           Client.flagY = 0;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     boolean var53;
                     if(Client.packetOpcode == 92) {
                        var3 = Client.field325.method2526();
                        var53 = Client.field325.method2555() == 1;
                        var85 = class24.method600(var3);
                        if(var53 != var85.isHidden) {
                           var85.isHidden = var53;
                           class53.method1101(var85);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 4) {
                        class40.method803();

                        for(var3 = 0; var3 < 2048; ++var3) {
                           Client.cachedPlayers[var3] = null;
                        }

                        class144.method3013(Client.field325);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 233) {
                        for(var3 = 0; var3 < Client.cachedPlayers.length; ++var3) {
                           if(null != Client.cachedPlayers[var3]) {
                              Client.cachedPlayers[var3].animation = -1;
                           }
                        }

                        for(var3 = 0; var3 < Client.cachedNPCs.length; ++var3) {
                           if(null != Client.cachedNPCs[var3]) {
                              Client.cachedNPCs[var3].animation = -1;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     String var74;
                     if(Client.packetOpcode == 87) {
                        var28 = Client.field325.method2530();
                        class125 var112 = Client.field325;

                        try {
                           var7 = var112.method2710();
                           if(var7 > 32767) {
                              var7 = 32767;
                           }

                           byte[] var101 = new byte[var7];
                           var112.offset += class225.field3229.method2455(var112.payload, var112.offset, var101, 0, var7);
                           String var60 = class166.method3283(var101, 0, var7);
                           var74 = var60;
                        } catch (Exception var46) {
                           var74 = "Cabbage";
                        }

                        var74 = class226.method4069(class24.method590(var74));
                        class10.sendGameMessage(6, var28, var74);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 150) {
                        var3 = Client.field325.method2565();
                        var4 = Client.field325.method2576();
                        var5 = var3 >> 10 & 31;
                        var6 = var3 >> 5 & 31;
                        var7 = var3 & 31;
                        var56 = (var7 << 3) + (var5 << 19) + (var6 << 11);
                        Widget var58 = class24.method600(var4);
                        if(var58.textColor != var56) {
                           var58.textColor = var56;
                           class53.method1101(var58);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 17) {
                        class132.method2867(Client.field325.method2530());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 34) {
                        var3 = Client.field325.method2717();
                        Client.widgetRoot = var3;
                        class47.method989(Client.widgetRoot, class159.field2374, class92.field1643, false);
                        WidgetNode.method43(var3);
                        class40.method802(Client.widgetRoot);

                        for(var4 = 0; var4 < 100; ++var4) {
                           Client.field374[var4] = true;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 106) {
                        Renderable.field1544 = class107.method2315(Client.field325.method2528());
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     boolean var55;
                     boolean var64;
                     if(Client.packetOpcode == 111) {
                        var28 = Client.field325.method2530();
                        var4 = Client.field325.method2717();
                        byte var66 = Client.field325.method2529();
                        var55 = false;
                        if(var66 == -128) {
                           var55 = true;
                        }

                        if(var55) {
                           if(class133.field2138 == 0) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3011;
                           }

                           var64 = false;

                           for(var7 = 0; var7 < class133.field2138 && (!class175.clanMembers[var7].username.equals(var28) || var4 != class175.clanMembers[var7].world); ++var7) {
                              ;
                           }

                           if(var7 < class133.field2138) {
                              while(var7 < class133.field2138 - 1) {
                                 class175.clanMembers[var7] = class175.clanMembers[var7 + 1];
                                 ++var7;
                              }

                              --class133.field2138;
                              class175.clanMembers[class133.field2138] = null;
                           }
                        } else {
                           Client.field325.method2530();
                           XClanMember var111 = new XClanMember();
                           var111.username = var28;
                           var111.field635 = Frames.method2312(var111.username, Client.field283);
                           var111.world = var4;
                           var111.rank = var66;

                           for(var56 = class133.field2138 - 1; var56 >= 0; --var56) {
                              var77 = class175.clanMembers[var56].field635.compareTo(var111.field635);
                              if(var77 == 0) {
                                 class175.clanMembers[var56].world = var4;
                                 class175.clanMembers[var56].rank = var66;
                                 if(var28.equals(WidgetNode.localPlayer.name)) {
                                    class79.field1459 = var66;
                                 }

                                 Client.field474 = Client.field465;
                                 Client.packetOpcode = -1;
                                 var1 = true;
                                 break label3011;
                              }

                              if(var77 < 0) {
                                 break;
                              }
                           }

                           if(class133.field2138 >= class175.clanMembers.length) {
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3011;
                           }

                           for(var77 = class133.field2138 - 1; var77 > var56; --var77) {
                              class175.clanMembers[1 + var77] = class175.clanMembers[var77];
                           }

                           if(class133.field2138 == 0) {
                              class175.clanMembers = new XClanMember[100];
                           }

                           class175.clanMembers[1 + var56] = var111;
                           ++class133.field2138;
                           if(var28.equals(WidgetNode.localPlayer.name)) {
                              class79.field1459 = var66;
                           }
                        }

                        Client.field474 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 1) {
                        class127.xteaChanged(false);
                        Client.field325.method2793();
                        var3 = Client.field325.method2717();
                        class16.method183(Client.field325, var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 193) {
                        var3 = Client.field325.method2568();
                        var4 = Client.field325.method2574();
                        var85 = class24.method600(var4);
                        if(var3 != var85.field2938 || var3 == -1) {
                           var85.field2938 = var3;
                           var85.field2862 = 0;
                           var85.field2825 = 0;
                           class53.method1101(var85);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 76) {
                        class16.field226 = Client.field325.method2555();
                        Client.field345 = Client.field325.method2557();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 205) {
                        SecondaryBufferProvider.method1683();
                        Client.weight = Client.field325.method2618();
                        Client.field477 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     Widget var75;
                     if(Client.packetOpcode == 186) {
                        var3 = Client.field325.method2526();
                        var4 = Client.field325.method2567();
                        var5 = Client.field325.method2567();
                        var75 = class24.method600(var3);
                        if(var4 != var75.field2830 || var5 != var75.field2896 || var75.field2866 != 0 || var75.field2822 != 0) {
                           var75.field2830 = var4;
                           var75.field2896 = var5;
                           var75.field2866 = 0;
                           var75.field2822 = 0;
                           class53.method1101(var75);
                           Player.method38(var75);
                           if(var75.type == 0) {
                              class10.method136(Widget.widgets[var3 >> 16], var75, false);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     Widget var102;
                     if(Client.packetOpcode == 29) {
                        var3 = Client.field325.method2565();
                        var4 = Client.field325.method2526();
                        var5 = Client.field325.method2731();
                        var6 = Client.field325.method2566();
                        var102 = class24.method600(var4);
                        if(var3 != var102.rotationX || var102.rotationZ != var6 || var5 != var102.field2870) {
                           var102.rotationX = var3;
                           var102.rotationZ = var6;
                           var102.field2870 = var5;
                           class53.method1101(var102);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 49) {
                        class16.field226 = Client.field325.method2557();
                        Client.field345 = Client.field325.method2528();

                        for(var3 = class16.field226; var3 < class16.field226 + 8; ++var3) {
                           for(var4 = Client.field345; var4 < Client.field345 + 8; ++var4) {
                              if(Client.groundItemDeque[Item.plane][var3][var4] != null) {
                                 Client.groundItemDeque[Item.plane][var3][var4] = null;
                                 class9.groundItemSpawned(var3, var4);
                              }
                           }
                        }

                        for(class16 var95 = (class16)Client.field425.method3854(); var95 != null; var95 = (class16)Client.field425.method3869()) {
                           if(var95.field218 >= class16.field226 && var95.field218 < 8 + class16.field226 && var95.field219 >= Client.field345 && var95.field219 < Client.field345 + 8 && Item.plane == var95.field232) {
                              var95.field224 = 0;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 123) {
                        for(var3 = 0; var3 < class56.field1234; ++var3) {
                           class56 var86 = PlayerComposition.method3517(var3);
                           if(var86 != null) {
                              class179.settings[var3] = 0;
                              class179.widgetSettings[var3] = 0;
                           }
                        }

                        SecondaryBufferProvider.method1683();
                        Client.field467 += 32;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 82) {
                        var3 = Client.field325.method2731();
                        var4 = Client.field325.method2526();
                        class179.settings[var3] = var4;
                        if(var4 != class179.widgetSettings[var3]) {
                           class179.widgetSettings[var3] = var4;
                        }

                        class35.method748(var3);
                        Client.field348[++Client.field467 - 1 & 31] = var3;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 234) {
                        var3 = Client.field325.method2526();
                        class16.field228 = class126.field2103.method2919(var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 26) {
                        Client.field474 = Client.field465;
                        if(Client.field326 == 0) {
                           Client.field507 = null;
                           Client.field286 = null;
                           class133.field2138 = 0;
                           class175.clanMembers = null;
                           Client.packetOpcode = -1;
                           var1 = true;
                        } else {
                           Client.field286 = Client.field325.method2530();
                           long var69 = Client.field325.method2534();
                           Client.field507 = class13.method168(var69);
                           VertexNormal.field1722 = Client.field325.method2529();
                           var5 = Client.field325.method2528();
                           if(var5 == 255) {
                              Client.packetOpcode = -1;
                              var1 = true;
                           } else {
                              class133.field2138 = var5;
                              XClanMember[] var78 = new XClanMember[100];

                              for(var7 = 0; var7 < class133.field2138; ++var7) {
                                 var78[var7] = new XClanMember();
                                 var78[var7].username = Client.field325.method2530();
                                 var78[var7].field635 = Frames.method2312(var78[var7].username, Client.field283);
                                 var78[var7].world = Client.field325.method2717();
                                 var78[var7].rank = Client.field325.method2529();
                                 Client.field325.method2530();
                                 if(var78[var7].username.equals(WidgetNode.localPlayer.name)) {
                                    class79.field1459 = var78[var7].rank;
                                 }
                              }

                              var64 = false;
                              var77 = class133.field2138;

                              while(var77 > 0) {
                                 var64 = true;
                                 --var77;

                                 for(var80 = 0; var80 < var77; ++var80) {
                                    if(var78[var80].field635.compareTo(var78[1 + var80].field635) > 0) {
                                       XClanMember var99 = var78[var80];
                                       var78[var80] = var78[var80 + 1];
                                       var78[var80 + 1] = var99;
                                       var64 = false;
                                    }
                                 }

                                 if(var64) {
                                    break;
                                 }
                              }

                              class175.clanMembers = var78;
                              Client.packetOpcode = -1;
                              var1 = true;
                           }
                        }
                        break label3011;
                     }

                     if(Client.packetOpcode == 2) {
                        if(Client.widgetRoot != -1) {
                           var3 = Client.widgetRoot;
                           if(class93.method2114(var3)) {
                              ItemComposition.method1119(Widget.widgets[var3], 0);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 178) {
                        Client.field528 = false;

                        for(var3 = 0; var3 < 5; ++var3) {
                           Client.field539[var3] = false;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 98) {
                        Client.field528 = true;
                        class158.field2360 = Client.field325.method2528();
                        class43.field1001 = Client.field325.method2528();
                        class109.field1955 = Client.field325.method2717();
                        Item.field709 = Client.field325.method2528();
                        class56.field1238 = Client.field325.method2528();
                        if(class56.field1238 >= 100) {
                           class165.cameraX = 64 + class158.field2360 * 128;
                           class9.cameraY = 64 + class43.field1001 * 128;
                           class125.cameraZ = class116.method2462(class165.cameraX, class9.cameraY, Item.plane) - class109.field1955;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 18) {
                        class79.method1713(Client.field325, Client.field326);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 154) {
                        Client.field498 = Client.field325.method2528();
                        Client.field499 = Client.field325.method2528();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 31) {
                        class144.method3015(true);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 195) {
                        Client.field469 = 1;
                        Client.field473 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     String var88;
                     if(Client.packetOpcode == 236) {
                        var3 = Client.field325.method2710();
                        var53 = Client.field325.method2528() == 1;
                        var88 = "";
                        var55 = false;
                        if(var53) {
                           var88 = Client.field325.method2530();
                           if(SecondaryBufferProvider.method1676(var88)) {
                              var55 = true;
                           }
                        }

                        String var109 = Client.field325.method2530();
                        if(!var55) {
                           class10.sendGameMessage(var3, var88, var109);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 62) {
                        var3 = Client.field325.method2533();
                        var4 = Client.field325.method2576();
                        var5 = Client.field325.method2565();
                        if(var5 == '\uffff') {
                           var5 = -1;
                        }

                        var75 = class24.method600(var4);
                        ItemComposition var104;
                        if(!var75.field2815) {
                           if(var5 == -1) {
                              var75.modelType = 0;
                              Client.packetOpcode = -1;
                              var1 = true;
                              break label3011;
                           }

                           var104 = MessageNode.getItemDefinition(var5);
                           var75.modelType = 4;
                           var75.modelId = var5;
                           var75.rotationX = var104.field1215;
                           var75.rotationZ = var104.field1193;
                           var75.field2870 = var104.field1232 * 100 / var3;
                           class53.method1101(var75);
                        } else {
                           var75.item = var5;
                           var75.stackSize = var3;
                           var104 = MessageNode.getItemDefinition(var5);
                           var75.rotationX = var104.field1215;
                           var75.rotationZ = var104.field1193;
                           var75.rotationY = var104.field1194;
                           var75.field2865 = var104.field1177;
                           var75.field2843 = var104.field1216;
                           var75.field2870 = var104.field1232;
                           if(var104.isStackable == 1) {
                              var75.field2874 = 1;
                           } else {
                              var75.field2874 = 2;
                           }

                           if(var75.field2847 > 0) {
                              var75.field2870 = var75.field2870 * 32 / var75.field2847;
                           } else if(var75.field2827 > 0) {
                              var75.field2870 = var75.field2870 * 32 / var75.field2827;
                           }

                           class53.method1101(var75);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 30) {
                        Client.field528 = true;
                        Client.field448 = Client.field325.method2528();
                        class40.field903 = Client.field325.method2528();
                        class0.field15 = Client.field325.method2717();
                        class0.field12 = Client.field325.method2528();
                        class13.field199 = Client.field325.method2528();
                        if(class13.field199 >= 100) {
                           var3 = Client.field448 * 128 + 64;
                           var4 = 64 + class40.field903 * 128;
                           var5 = class116.method2462(var3, var4, Item.plane) - class0.field15;
                           var6 = var3 - class165.cameraX;
                           var7 = var5 - class125.cameraZ;
                           var56 = var4 - class9.cameraY;
                           var77 = (int)Math.sqrt((double)(var56 * var56 + var6 * var6));
                           class18.cameraPitch = (int)(Math.atan2((double)var7, (double)var77) * 325.949D) & 2047;
                           class33.cameraYaw = (int)(Math.atan2((double)var6, (double)var56) * -325.949D) & 2047;
                           if(class18.cameraPitch < 128) {
                              class18.cameraPitch = 128;
                           }

                           if(class18.cameraPitch > 383) {
                              class18.cameraPitch = 383;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 109) {
                        for(var3 = 0; var3 < class179.widgetSettings.length; ++var3) {
                           if(class179.widgetSettings[var3] != class179.settings[var3]) {
                              class179.widgetSettings[var3] = class179.settings[var3];
                              class35.method748(var3);
                              Client.field348[++Client.field467 - 1 & 31] = var3;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 70) {
                        Client.field404 = Client.field325.method2528();
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 124) {
                        Client.field381 = Client.field325.method2717() * 30;
                        Client.field477 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 183) {
                        var3 = Client.field325.method2731();
                        var4 = Client.field325.method2576();
                        var85 = class24.method600(var4);
                        if(var85.modelType != 2 || var85.modelId != var3) {
                           var85.modelType = 2;
                           var85.modelId = var3;
                           class53.method1101(var85);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 138) {
                        byte var63 = Client.field325.method2624();
                        var4 = Client.field325.method2717();
                        class179.settings[var4] = var63;
                        if(class179.widgetSettings[var4] != var63) {
                           class179.widgetSettings[var4] = var63;
                        }

                        class35.method748(var4);
                        Client.field348[++Client.field467 - 1 & 31] = var4;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 108) {
                        var3 = Client.field325.method2533();
                        var4 = Client.field325.method2717();
                        if(var3 < -70000) {
                           var4 += '耀';
                        }

                        if(var3 >= 0) {
                           var85 = class24.method600(var3);
                        } else {
                           var85 = null;
                        }

                        for(; Client.field325.offset < Client.field326; Client.method555(var4, var6, var7 - 1, var56)) {
                           var6 = Client.field325.method2710();
                           var7 = Client.field325.method2717();
                           var56 = 0;
                           if(var7 != 0) {
                              var56 = Client.field325.method2528();
                              if(var56 == 255) {
                                 var56 = Client.field325.method2533();
                              }
                           }

                           if(var85 != null && var6 >= 0 && var6 < var85.itemIds.length) {
                              var85.itemIds[var6] = var7;
                              var85.itemQuantities[var6] = var56;
                           }
                        }

                        if(null != var85) {
                           class53.method1101(var85);
                        }

                        SecondaryBufferProvider.method1683();
                        Client.field468[++Client.field314 - 1 & 31] = var4 & 32767;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     String var18;
                     int var19;
                     long var24;
                     long var67;
                     if(Client.packetOpcode == 16) {
                        var28 = Client.field325.method2530();
                        var59 = (long)Client.field325.method2717();
                        var67 = (long)Client.field325.method2532();
                        class155[] var96 = new class155[]{class155.field2329, class155.field2328, class155.field2330, class155.field2337, class155.field2331};
                        class155 var57 = (class155)class54.method1117(var96, Client.field325.method2528());
                        var24 = var67 + (var59 << 32);
                        boolean var107 = false;

                        for(var70 = 0; var70 < 100; ++var70) {
                           if(Client.field501[var70] == var24) {
                              var107 = true;
                              break;
                           }
                        }

                        if(SecondaryBufferProvider.method1676(var28)) {
                           var107 = true;
                        }

                        if(!var107 && Client.field401 == 0) {
                           Client.field501[Client.field502] = var24;
                           Client.field502 = (Client.field502 + 1) % 100;
                           class125 var71 = Client.field325;

                           String var15;
                           try {
                              int var16 = var71.method2710();
                              if(var16 > 32767) {
                                 var16 = 32767;
                              }

                              byte[] var73 = new byte[var16];
                              var71.offset += class225.field3229.method2455(var71.payload, var71.offset, var73, 0, var16);
                              var18 = class166.method3283(var73, 0, var16);
                              var15 = var18;
                           } catch (Exception var45) {
                              var15 = "Cabbage";
                           }

                           var15 = class226.method4069(class24.method590(var15));
                           byte var72;
                           if(var57.field2335) {
                              var72 = 7;
                           } else {
                              var72 = 3;
                           }

                           if(var57.field2334 != -1) {
                              var19 = var57.field2334;
                              var18 = "<img=" + var19 + ">";
                              class10.sendGameMessage(var72, var18 + var28, var15);
                           } else {
                              class10.sendGameMessage(var72, var28, var15);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     long var8;
                     long var31;
                     if(Client.packetOpcode == 141) {
                        var28 = Client.field325.method2530();
                        var59 = Client.field325.method2534();
                        var67 = (long)Client.field325.method2717();
                        var8 = (long)Client.field325.method2532();
                        class155[] var62 = new class155[]{class155.field2329, class155.field2328, class155.field2330, class155.field2337, class155.field2331};
                        class155 var11 = (class155)class54.method1117(var62, Client.field325.method2528());
                        var31 = (var67 << 32) + var8;
                        boolean var35 = false;

                        for(int var36 = 0; var36 < 100; ++var36) {
                           if(var31 == Client.field501[var36]) {
                              var35 = true;
                              break;
                           }
                        }

                        if(var11.field2336 && SecondaryBufferProvider.method1676(var28)) {
                           var35 = true;
                        }

                        if(!var35 && Client.field401 == 0) {
                           Client.field501[Client.field502] = var31;
                           Client.field502 = (1 + Client.field502) % 100;
                           class125 var32 = Client.field325;

                           String var17;
                           try {
                              int var37 = var32.method2710();
                              if(var37 > 32767) {
                                 var37 = 32767;
                              }

                              byte[] var38 = new byte[var37];
                              var32.offset += class225.field3229.method2455(var32.payload, var32.offset, var38, 0, var37);
                              String var20 = class166.method3283(var38, 0, var37);
                              var17 = var20;
                           } catch (Exception var44) {
                              var17 = "Cabbage";
                           }

                           var17 = class226.method4069(class24.method590(var17));
                           if(var11.field2334 != -1) {
                              var19 = var11.field2334;
                              var18 = "<img=" + var19 + ">";
                              class217.addChatMessage(9, var18 + var28, var17, class10.method138(var59));
                           } else {
                              class217.addChatMessage(9, var28, var17, class10.method138(var59));
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 105) {
                        var3 = Client.field325.method2526();
                        var4 = Client.field325.method2526();
                        WidgetNode var91 = (WidgetNode)Client.componentTable.method3817((long)var4);
                        var76 = (WidgetNode)Client.componentTable.method3817((long)var3);
                        if(var76 != null) {
                           TextureProvider.method2217(var76, var91 == null || var91.id != var76.id);
                        }

                        if(var91 != null) {
                           var91.unlink();
                           Client.componentTable.method3823(var91, (long)var3);
                        }

                        var102 = class24.method600(var4);
                        if(var102 != null) {
                           class53.method1101(var102);
                        }

                        var102 = class24.method600(var3);
                        if(var102 != null) {
                           class53.method1101(var102);
                           class10.method136(Widget.widgets[var102.id >>> 16], var102, true);
                        }

                        if(Client.widgetRoot != -1) {
                           var56 = Client.widgetRoot;
                           if(class93.method2114(var56)) {
                              ItemComposition.method1119(Widget.widgets[var56], 1);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 230) {
                        var3 = Client.field325.method2526();
                        var84 = class24.method600(var3);
                        var84.modelType = 3;
                        var84.modelId = WidgetNode.localPlayer.composition.method3526();
                        class53.method1101(var84);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 187) {
                        var3 = Client.field325.method2528();
                        var4 = Client.field325.method2533();
                        var5 = Client.field325.method2565();
                        var76 = (WidgetNode)Client.componentTable.method3817((long)var4);
                        if(var76 != null) {
                           TextureProvider.method2217(var76, var5 != var76.id);
                        }

                        WidgetNode var100 = new WidgetNode();
                        var100.id = var5;
                        var100.field61 = var3;
                        Client.componentTable.method3823(var100, (long)var4);
                        WidgetNode.method43(var5);
                        Widget var92 = class24.method600(var4);
                        class53.method1101(var92);
                        if(Client.field444 != null) {
                           class53.method1101(Client.field444);
                           Client.field444 = null;
                        }

                        Friend.method191();
                        class10.method136(Widget.widgets[var4 >> 16], var92, false);
                        class40.method802(var5);
                        if(Client.widgetRoot != -1) {
                           var77 = Client.widgetRoot;
                           if(class93.method2114(var77)) {
                              ItemComposition.method1119(Widget.widgets[var77], 1);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 72) {
                        var3 = Client.field325.method2528();
                        var4 = Client.field325.method2528();
                        var5 = Client.field325.method2528();
                        var6 = Client.field325.method2528();
                        Client.field539[var3] = true;
                        Client.field531[var3] = var4;
                        Client.field481[var3] = var5;
                        Client.field533[var3] = var6;
                        Client.field534[var3] = 0;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 21) {
                        var3 = Client.field325.method2717();
                        var4 = Client.field325.method2528();
                        var5 = Client.field325.method2717();
                        if(Client.field520 != 0 && var4 != 0 && Client.field522 < 50) {
                           Client.field523[Client.field522] = var3;
                           Client.field428[Client.field522] = var4;
                           Client.field471[Client.field522] = var5;
                           Client.field432[Client.field522] = null;
                           Client.field526[Client.field522] = 0;
                           ++Client.field522;
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     Object[] var26;
                     if(Client.packetOpcode == 160) {
                        while(Client.field325.offset < Client.field326) {
                           var54 = Client.field325.method2528() == 1;
                           var82 = Client.field325.method2530();
                           var88 = Client.field325.method2530();
                           var6 = Client.field325.method2717();
                           var7 = Client.field325.method2528();
                           var56 = Client.field325.method2528();
                           boolean var23 = (var56 & 2) != 0;
                           boolean var79 = (var56 & 1) != 0;
                           if(var6 > 0) {
                              Client.field325.method2530();
                              Client.field325.method2528();
                              Client.field325.method2533();
                           }

                           Client.field325.method2530();

                           for(var25 = 0; var25 < Client.friendCount; ++var25) {
                              Friend var12 = Client.friends[var25];
                              if(!var54) {
                                 if(var82.equals(var12.name)) {
                                    if(var6 != var12.world) {
                                       boolean var13 = true;

                                       for(class40 var14 = (class40)Client.field551.method3809(); var14 != null; var14 = (class40)Client.field551.method3810()) {
                                          if(var14.field901.equals(var82)) {
                                             if(var6 != 0 && var14.field900 == 0) {
                                                var14.method3962();
                                                var13 = false;
                                             } else if(var6 == 0 && var14.field900 != 0) {
                                                var14.method3962();
                                                var13 = false;
                                             }
                                          }
                                       }

                                       if(var13) {
                                          Client.field551.method3807(new class40(var82, var6));
                                       }

                                       var12.world = var6;
                                    }

                                    var12.previousName = var88;
                                    var12.rank = var7;
                                    var12.field240 = var23;
                                    var12.field241 = var79;
                                    var26 = null;
                                    break;
                                 }
                              } else if(var88.equals(var12.name)) {
                                 var12.name = var82;
                                 var12.previousName = var88;
                                 var26 = null;
                                 break;
                              }
                           }
                        }

                        Client.field469 = 2;
                        Client.field473 = Client.field465;
                        var54 = false;
                        var4 = Client.friendCount;

                        while(var4 > 0) {
                           var54 = true;
                           --var4;

                           for(var5 = 0; var5 < var4; ++var5) {
                              var55 = false;
                              Friend var30 = Client.friends[var5];
                              Friend var90 = Client.friends[1 + var5];
                              if(var30.world != Client.world && var90.world == Client.world) {
                                 var55 = true;
                              }

                              if(!var55 && var30.world == 0 && var90.world != 0) {
                                 var55 = true;
                              }

                              if(!var55 && !var30.field240 && var90.field240) {
                                 var55 = true;
                              }

                              if(!var55 && !var30.field241 && var90.field241) {
                                 var55 = true;
                              }

                              if(var55) {
                                 Friend var9 = Client.friends[var5];
                                 Client.friends[var5] = Client.friends[1 + var5];
                                 Client.friends[1 + var5] = var9;
                                 var54 = false;
                              }
                           }

                           if(var54) {
                              break;
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 78) {
                        var3 = Client.field325.method2717();
                        var4 = Client.field325.method2731();
                        var5 = Client.field325.method2576();
                        var75 = class24.method600(var5);
                        var75.field2872 = var3 + (var4 << 16);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     Iterator var27;
                     if(Client.packetOpcode == 224) {
                        while(Client.field325.offset < Client.field326) {
                           var3 = Client.field325.method2528();
                           var53 = (var3 & 1) == 1;
                           var88 = Client.field325.method2530();
                           var74 = Client.field325.method2530();
                           Client.field325.method2530();

                           for(var7 = 0; var7 < Client.ignoreCount; ++var7) {
                              Ignore var29 = Client.ignores[var7];
                              if(var53) {
                                 if(var74.equals(var29.name)) {
                                    var29.name = var88;
                                    var29.previousName = var74;
                                    var27 = null;
                                    break;
                                 }
                              } else if(var88.equals(var29.name)) {
                                 var29.name = var88;
                                 var29.previousName = var74;
                                 var27 = null;
                                 break;
                              }
                           }
                        }

                        Client.field473 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 120) {
                        class16.method183(Client.field325, Client.field326);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 216) {
                        var3 = Client.field325.method2565();
                        var4 = Client.field325.method2533();
                        var85 = class24.method600(var4);
                        if(null != var85 && var85.type == 0) {
                           if(var3 > var85.scrollHeight - var85.height) {
                              var3 = var85.scrollHeight - var85.height;
                           }

                           if(var3 < 0) {
                              var3 = 0;
                           }

                           if(var3 != var85.scrollY) {
                              var85.scrollY = var3;
                              class53.method1101(var85);
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 194) {
                        Client.field298 = Client.field325.method2528();
                        if(Client.field298 == 1) {
                           Client.field299 = Client.field325.method2717();
                        }

                        if(Client.field298 >= 2 && Client.field298 <= 6) {
                           if(Client.field298 == 2) {
                              Client.field304 = 64;
                              Client.field532 = 64;
                           }

                           if(Client.field298 == 3) {
                              Client.field304 = 0;
                              Client.field532 = 64;
                           }

                           if(Client.field298 == 4) {
                              Client.field304 = 128;
                              Client.field532 = 64;
                           }

                           if(Client.field298 == 5) {
                              Client.field304 = 64;
                              Client.field532 = 0;
                           }

                           if(Client.field298 == 6) {
                              Client.field304 = 64;
                              Client.field532 = 128;
                           }

                           Client.field298 = 2;
                           Client.field301 = Client.field325.method2717();
                           Client.field302 = Client.field325.method2717();
                           Client.field303 = Client.field325.method2528();
                        }

                        if(Client.field298 == 10) {
                           Client.field300 = Client.field325.method2717();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 173) {
                        Client.field325.offset += 28;
                        if(Client.field325.method2625()) {
                           class125 var89 = Client.field325;
                           var4 = Client.field325.offset - 28;
                           if(null != class152.field2299) {
                              try {
                                 class152.field2299.method4209(0L);
                                 class152.field2299.method4214(var89.payload, var4, 24);
                              } catch (Exception var43) {
                                 ;
                              }
                           }
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 210) {
                        var3 = Client.field325.method2574();
                        var4 = Client.field325.method2566();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        var5 = Client.field325.method2574();
                        var6 = Client.field325.method2566();
                        if(var6 == '\uffff') {
                           var6 = -1;
                        }

                        for(var7 = var6; var7 <= var4; ++var7) {
                           var8 = ((long)var5 << 32) + (long)var7;
                           Node var10 = Client.widgetFlags.method3817(var8);
                           if(null != var10) {
                              var10.unlink();
                           }

                           Client.widgetFlags.method3823(new class204(var3), var8);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 115) {
                        var3 = Client.field325.method2528();
                        if(Client.field325.method2528() == 0) {
                           Client.grandExchangeOffers[var3] = new XGrandExchangeOffer();
                           Client.field325.offset += 18;
                        } else {
                           --Client.field325.offset;
                           Client.grandExchangeOffers[var3] = new XGrandExchangeOffer(Client.field325, false);
                        }

                        Client.field433 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 36) {
                        var3 = Client.field325.method2526();
                        var82 = Client.field325.method2530();
                        var85 = class24.method600(var3);
                        if(!var82.equals(var85.text)) {
                           var85.text = var82;
                           class53.method1101(var85);
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 38) {
                        class137.method2908();
                        Client.packetOpcode = -1;
                        var1 = false;
                        break label3011;
                     }

                     if(Client.packetOpcode == 248) {
                        var28 = Client.field325.method2530();
                        var26 = new Object[var28.length() + 1];

                        for(var5 = var28.length() - 1; var5 >= 0; --var5) {
                           if(var28.charAt(var5) == 115) {
                              var26[var5 + 1] = Client.field325.method2530();
                           } else {
                              var26[var5 + 1] = new Integer(Client.field325.method2533());
                           }
                        }

                        var26[0] = new Integer(Client.field325.method2533());
                        class0 var83 = new class0();
                        var83.field7 = var26;
                        class1.method9(var83, 200000);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 61) {
                        class16.field226 = Client.field325.method2555();
                        Client.field345 = Client.field325.method2555();

                        while(Client.field325.offset < Client.field326) {
                           Client.packetOpcode = Client.field325.method2528();
                           Sequence.method933();
                        }

                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 189) {
                        SecondaryBufferProvider.method1683();
                        Client.energy = Client.field325.method2528();
                        Client.field477 = Client.field465;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 51) {
                        class127.xteaChanged(true);
                        Client.field325.method2793();
                        var3 = Client.field325.method2717();
                        class16.method183(Client.field325, var3);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 184) {
                        var3 = Client.field325.method2533();
                        var4 = Client.field325.method2533();
                        if(null == class20.field575 || !class20.field575.isValid()) {
                           try {
                              var27 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var27.hasNext()) {
                                 GarbageCollectorMXBean var22 = (GarbageCollectorMXBean)var27.next();
                                 if(var22.isValid()) {
                                    class20.field575 = var22;
                                    Client.field559 = -1L;
                                    Client.field408 = -1L;
                                 }
                              }
                           } catch (Throwable var48) {
                              ;
                           }
                        }

                        long var52 = class5.method63();
                        var7 = -1;
                        if(class20.field575 != null) {
                           var8 = class20.field575.getCollectionTime();
                           if(-1L != Client.field408) {
                              var24 = var8 - Client.field408;
                              var31 = var52 - Client.field559;
                              if(0L != var31) {
                                 var7 = (int)(var24 * 100L / var31);
                              }
                           }

                           Client.field408 = var8;
                           Client.field559 = var52;
                        }

                        Client.field323.method2801(242);
                        Client.field323.method2564(var3);
                        Client.field323.method2600(var4);
                        Client.field323.method2558(var7);
                        Client.field323.method2558(GameEngine.FPS);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 84) {
                        SecondaryBufferProvider.method1683();
                        var3 = Client.field325.method2556();
                        var4 = Client.field325.method2574();
                        var5 = Client.field325.method2556();
                        Client.skillExperiences[var3] = var4;
                        Client.boostedSkillLevels[var3] = var5;
                        Client.realSkillLevels[var3] = 1;

                        for(var6 = 0; var6 < 98; ++var6) {
                           if(var4 >= class158.field2361[var6]) {
                              Client.realSkillLevels[var3] = var6 + 2;
                           }
                        }

                        Client.field494[++Client.field527 - 1 & 31] = var3;
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     if(Client.packetOpcode == 191) {
                        class144.method3015(false);
                        Client.packetOpcode = -1;
                        var1 = true;
                        break label3011;
                     }

                     class128.method2843("" + Client.packetOpcode + "," + Client.field331 + "," + Client.field434 + "," + Client.field326, (Throwable)null);
                     class137.method2908();
                  } catch (IOException var49) {
                     class151.method3162();
                  } catch (Exception var50) {
                     var28 = "" + Client.packetOpcode + "," + Client.field331 + "," + Client.field434 + "," + Client.field326 + "," + (class9.baseX + WidgetNode.localPlayer.pathX[0]) + "," + (KitDefinition.baseY + WidgetNode.localPlayer.pathY[0]) + ",";

                     for(var4 = 0; var4 < Client.field326 && var4 < 50; ++var4) {
                        var28 = var28 + Client.field325.payload[var4] + ",";
                     }

                     class128.method2843(var28, var50);
                     class137.method2908();
                  }

                  var1 = true;
               }
            }

            if(!var1) {
               break;
            }
         }

         if(Client.gameState == 30) {
            while(class168.method3300()) {
               Client.field323.method2801(218);
               Client.field323.method2513(0);
               var0 = Client.field323.offset;
               class11.method158(Client.field323);
               Client.field323.method2523(Client.field323.offset - var0);
            }

            Object var40 = class165.field2714.field187;
            int var93;
            synchronized(class165.field2714.field187) {
               if(!Client.field278) {
                  class165.field2714.field196 = 0;
               } else if(class143.field2227 != 0 || class165.field2714.field196 >= 40) {
                  Client.field323.method2801(116);
                  Client.field323.method2513(0);
                  var93 = Client.field323.offset;
                  var2 = 0;

                  for(var3 = 0; var3 < class165.field2714.field196 && Client.field323.offset - var93 < 240; ++var3) {
                     ++var2;
                     var4 = class165.field2714.field190[var3];
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 502) {
                        var4 = 502;
                     }

                     var5 = class165.field2714.field189[var3];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 764) {
                        var5 = 764;
                     }

                     var6 = var5 + var4 * 765;
                     if(class165.field2714.field190[var3] == -1 && class165.field2714.field189[var3] == -1) {
                        var5 = -1;
                        var4 = -1;
                        var6 = 524287;
                     }

                     if(var5 == Client.field292 && Client.field293 == var4) {
                        if(Client.field294 < 2047) {
                           ++Client.field294;
                        }
                     } else {
                        var7 = var5 - Client.field292;
                        Client.field292 = var5;
                        var56 = var4 - Client.field293;
                        Client.field293 = var4;
                        if(Client.field294 < 8 && var7 >= -32 && var7 <= 31 && var56 >= -32 && var56 <= 31) {
                           var7 += 32;
                           var56 += 32;
                           Client.field323.method2514(var56 + (var7 << 6) + (Client.field294 << 12));
                           Client.field294 = 0;
                        } else if(Client.field294 < 8) {
                           Client.field323.method2743(var6 + (Client.field294 << 19) + 8388608);
                           Client.field294 = 0;
                        } else {
                           Client.field323.method2600(var6 + -1073741824 + (Client.field294 << 19));
                           Client.field294 = 0;
                        }
                     }
                  }

                  Client.field323.method2523(Client.field323.offset - var93);
                  if(var2 >= class165.field2714.field196) {
                     class165.field2714.field196 = 0;
                  } else {
                     class165.field2714.field196 -= var2;

                     for(var3 = 0; var3 < class165.field2714.field196; ++var3) {
                        class165.field2714.field189[var3] = class165.field2714.field189[var2 + var3];
                        class165.field2714.field190[var3] = class165.field2714.field190[var3 + var2];
                     }
                  }
               }
            }

            if(class143.field2227 == 1 || !class24.field626 && class143.field2227 == 4 || class143.field2227 == 2) {
               long var51 = (class143.field2230 - Client.field291) / 50L;
               if(var51 > 4095L) {
                  var51 = 4095L;
               }

               Client.field291 = class143.field2230;
               var2 = class143.field2226;
               if(var2 < 0) {
                  var2 = 0;
               } else if(var2 > class92.field1643) {
                  var2 = class92.field1643;
               }

               var3 = class143.field2223;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class159.field2374) {
                  var3 = class159.field2374;
               }

               var4 = (int)var51;
               Client.field323.method2801(61);
               Client.field323.method2514((class143.field2227 == 2?1:0) + (var4 << 1));
               Client.field323.method2514(var3);
               Client.field323.method2514(var2);
            }

            if(class140.field2174 > 0) {
               Client.field323.method2801(54);
               Client.field323.method2514(0);
               var0 = Client.field323.offset;
               long var97 = class5.method63();

               for(var3 = 0; var3 < class140.field2174; ++var3) {
                  var59 = var97 - Client.field506;
                  if(var59 > 16777215L) {
                     var59 = 16777215L;
                  }

                  Client.field506 = var97;
                  Client.field323.method2536((int)var59);
                  Client.field323.method2554(class140.field2196[var3]);
               }

               Client.field323.method2578(Client.field323.offset - var0);
            }

            if(Client.field373 > 0) {
               --Client.field373;
            }

            if(class140.field2190[96] || class140.field2190[97] || class140.field2190[98] || class140.field2190[99]) {
               Client.field446 = true;
            }

            if(Client.field446 && Client.field373 <= 0) {
               Client.field373 = 20;
               Client.field446 = false;
               Client.field323.method2801(215);
               Client.field323.method2514(Client.field366);
               Client.field323.method2562(Client.mapAngle);
            }

            if(XClanMember.field632 && !Client.field295) {
               Client.field295 = true;
               Client.field323.method2801(86);
               Client.field323.method2513(1);
            }

            if(!XClanMember.field632 && Client.field295) {
               Client.field295 = false;
               Client.field323.method2801(86);
               Client.field323.method2513(0);
            }

            class153.method3185();
            if(Client.gameState == 30) {
               for(class16 var116 = (class16)Client.field425.method3854(); var116 != null; var116 = (class16)Client.field425.method3869()) {
                  if(var116.field224 > 0) {
                     --var116.field224;
                  }

                  ObjectComposition var98;
                  if(var116.field224 == 0) {
                     if(var116.field220 >= 0) {
                        var2 = var116.field220;
                        var3 = var116.field222;
                        var98 = class165.getObjectDefinition(var2);
                        if(var3 == 11) {
                           var3 = 10;
                        }

                        if(var3 >= 5 && var3 <= 8) {
                           var3 = 4;
                        }

                        var1 = var98.method840(var3);
                        if(!var1) {
                           continue;
                        }
                     }

                     class11.method145(var116.field232, var116.field217, var116.field218, var116.field219, var116.field220, var116.field221, var116.field222);
                     var116.unlink();
                  } else {
                     if(var116.field227 > 0) {
                        --var116.field227;
                     }

                     if(var116.field227 == 0 && var116.field218 >= 1 && var116.field219 >= 1 && var116.field218 <= 102 && var116.field219 <= 102) {
                        if(var116.field223 >= 0) {
                           var2 = var116.field223;
                           var3 = var116.field225;
                           var98 = class165.getObjectDefinition(var2);
                           if(var3 == 11) {
                              var3 = 10;
                           }

                           if(var3 >= 5 && var3 <= 8) {
                              var3 = 4;
                           }

                           var1 = var98.method840(var3);
                           if(!var1) {
                              continue;
                           }
                        }

                        class11.method145(var116.field232, var116.field217, var116.field218, var116.field219, var116.field223, var116.field231, var116.field225);
                        var116.field227 = -1;
                        if(var116.field223 == var116.field220 && var116.field220 == -1) {
                           var116.unlink();
                        } else if(var116.field223 == var116.field220 && var116.field231 == var116.field221 && var116.field225 == var116.field222) {
                           var116.unlink();
                        }
                     }
                  }
               }

               class119.method2479();
               ++Client.field328;
               if(Client.field328 > 750) {
                  class151.method3162();
               } else {
                  var0 = class34.field779;
                  int[] var41 = class34.field780;

                  for(var2 = 0; var2 < var0; ++var2) {
                     Player var105 = Client.cachedPlayers[var41[var2]];
                     if(null != var105) {
                        class127.method2819(var105, 1);
                     }
                  }

                  for(var0 = 0; var0 < Client.field319; ++var0) {
                     var93 = Client.field320[var0];
                     NPC var39 = Client.cachedNPCs[var93];
                     if(var39 != null) {
                        class127.method2819(var39, var39.composition.field915);
                     }
                  }

                  XItemContainer.method179();
                  ++Client.field358;
                  if(Client.field393 != 0) {
                     Client.field392 += 20;
                     if(Client.field392 >= 400) {
                        Client.field393 = 0;
                     }
                  }

                  if(null != class35.field801) {
                     ++Client.field455;
                     if(Client.field455 >= 15) {
                        class53.method1101(class35.field801);
                        class35.field801 = null;
                     }
                  }

                  Widget var118 = class40.field906;
                  Widget var119 = class107.field1865;
                  class40.field906 = null;
                  class107.field1865 = null;
                  Client.field457 = null;
                  Client.field461 = false;
                  Client.field458 = false;
                  Client.field503 = 0;

                  while(XClanMember.method602() && Client.field503 < 128) {
                     if(Client.field351 >= 2 && class140.field2190[82] && class117.field2047 == 66) {
                        String var114 = class124.method2776();
                        FaceNormal.field1539.setContents(new StringSelection(var114), (ClipboardOwner)null);
                     } else {
                        Client.field505[Client.field503] = class117.field2047;
                        Client.field410[Client.field503] = class24.field615;
                        ++Client.field503;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     var2 = Client.widgetRoot;
                     var3 = class159.field2374;
                     var4 = class92.field1643;
                     if(class93.method2114(var2)) {
                        class59.method1277(Widget.widgets[var2], -1, 0, 0, var3, var4, 0, 0);
                     }
                  }

                  ++Client.field465;

                  while(true) {
                     Widget var108;
                     class0 var115;
                     do {
                        var115 = (class0)Client.field480.method3852();
                        if(var115 == null) {
                           while(true) {
                              do {
                                 var115 = (class0)Client.field516.method3852();
                                 if(null == var115) {
                                    while(true) {
                                       do {
                                          var115 = (class0)Client.field479.method3852();
                                          if(var115 == null) {
                                             class1.method5();
                                             if(null != Client.field453) {
                                                class49.method1028();
                                             }

                                             if(null != class26.field650) {
                                                class53.method1101(class26.field650);
                                                ++Client.field515;
                                                if(class143.field2220 == 0) {
                                                   if(Client.field440) {
                                                      if(ItemComposition.field1217 == class26.field650 && Client.field504 != Client.field396) {
                                                         Widget var117 = class26.field650;
                                                         byte var106 = 0;
                                                         if(Client.field400 == 1 && var117.contentType == 206) {
                                                            var106 = 1;
                                                         }

                                                         if(var117.itemIds[Client.field504] <= 0) {
                                                            var106 = 0;
                                                         }

                                                         if(class193.method3775(GameEngine.method3133(var117))) {
                                                            var4 = Client.field396;
                                                            var5 = Client.field504;
                                                            var117.itemIds[var5] = var117.itemIds[var4];
                                                            var117.itemQuantities[var5] = var117.itemQuantities[var4];
                                                            var117.itemIds[var4] = -1;
                                                            var117.itemQuantities[var4] = 0;
                                                         } else if(var106 == 1) {
                                                            var4 = Client.field396;
                                                            var5 = Client.field504;

                                                            while(var4 != var5) {
                                                               if(var4 > var5) {
                                                                  var117.method3440(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var5) {
                                                                  var117.method3440(var4 + 1, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var117.method3440(Client.field504, Client.field396);
                                                         }

                                                         Client.field323.method2801(52);
                                                         Client.field323.method2572(class26.field650.id);
                                                         Client.field323.method2513(var106);
                                                         Client.field323.method2563(Client.field396);
                                                         Client.field323.method2563(Client.field504);
                                                      }
                                                   } else if((Client.field341 == 1 || class0.method2(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
                                                      class50.method1044(Client.field450, Client.field398);
                                                   } else if(Client.menuOptionCount > 0) {
                                                      class92.method2112(Client.field450, Client.field398);
                                                   }

                                                   Client.field455 = 10;
                                                   class143.field2227 = 0;
                                                   class26.field650 = null;
                                                } else if(Client.field515 >= 5 && (class143.field2225 > 5 + Client.field450 || class143.field2225 < Client.field450 - 5 || class143.field2222 > 5 + Client.field398 || class143.field2222 < Client.field398 - 5)) {
                                                   Client.field440 = true;
                                                }
                                             }

                                             if(Region.field1560 != -1) {
                                                var2 = Region.field1560;
                                                var3 = Region.field1585;
                                                Client.field323.method2801(250);
                                                Client.field323.method2513(5);
                                                Client.field323.method2711(var3 + KitDefinition.baseY);
                                                Client.field323.method2558(class140.field2190[82]?(class140.field2190[81]?2:1):0);
                                                Client.field323.method2711(class9.baseX + var2);
                                                Region.field1560 = -1;
                                                Client.field521 = class143.field2223;
                                                Client.field394 = class143.field2226;
                                                Client.field393 = 1;
                                                Client.field392 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var3;
                                             }

                                             if(var118 != class40.field906) {
                                                if(null != var118) {
                                                   class53.method1101(var118);
                                                }

                                                if(class40.field906 != null) {
                                                   class53.method1101(class40.field906);
                                                }
                                             }

                                             if(class107.field1865 != var119 && Client.field565 == Client.field431) {
                                                if(null != var119) {
                                                   class53.method1101(var119);
                                                }

                                                if(class107.field1865 != null) {
                                                   class53.method1101(class107.field1865);
                                                }
                                             }

                                             if(class107.field1865 != null) {
                                                if(Client.field431 < Client.field565) {
                                                   ++Client.field431;
                                                   if(Client.field565 == Client.field431) {
                                                      class53.method1101(class107.field1865);
                                                   }
                                                }
                                             } else if(Client.field431 > 0) {
                                                --Client.field431;
                                             }

                                             var2 = Client.field525 + WidgetNode.localPlayer.x;
                                             var3 = Client.field352 + WidgetNode.localPlayer.y;
                                             if(class8.field137 - var2 < -500 || class8.field137 - var2 > 500 || class35.field807 - var3 < -500 || class35.field807 - var3 > 500) {
                                                class8.field137 = var2;
                                                class35.field807 = var3;
                                             }

                                             if(class8.field137 != var2) {
                                                class8.field137 += (var2 - class8.field137) / 16;
                                             }

                                             if(class35.field807 != var3) {
                                                class35.field807 += (var3 - class35.field807) / 16;
                                             }

                                             if(class143.field2220 == 4 && class24.field626) {
                                                var4 = class143.field2222 - Client.field371;
                                                Client.field369 = var4 * 2;
                                                Client.field371 = var4 != -1 && var4 != 1?(Client.field371 + class143.field2222) / 2:class143.field2222;
                                                var5 = Client.field370 - class143.field2225;
                                                Client.field495 = var5 * 2;
                                                Client.field370 = var5 != -1 && var5 != 1?(class143.field2225 + Client.field370) / 2:class143.field2225;
                                             } else {
                                                if(class140.field2190[96]) {
                                                   Client.field495 += (-24 - Client.field495) / 2;
                                                } else if(class140.field2190[97]) {
                                                   Client.field495 += (24 - Client.field495) / 2;
                                                } else {
                                                   Client.field495 /= 2;
                                                }

                                                if(class140.field2190[98]) {
                                                   Client.field369 += (12 - Client.field369) / 2;
                                                } else if(class140.field2190[99]) {
                                                   Client.field369 += (-12 - Client.field369) / 2;
                                                } else {
                                                   Client.field369 /= 2;
                                                }

                                                Client.field371 = class143.field2222;
                                                Client.field370 = class143.field2225;
                                             }

                                             Client.mapAngle = Client.mapAngle + Client.field495 / 2 & 2047;
                                             Client.field366 += Client.field369 / 2;
                                             if(Client.field366 < 128) {
                                                Client.field366 = 128;
                                             }

                                             if(Client.field366 > 383) {
                                                Client.field366 = 383;
                                             }

                                             var4 = class8.field137 >> 7;
                                             var5 = class35.field807 >> 7;
                                             var6 = class116.method2462(class8.field137, class35.field807, Item.plane);
                                             var7 = 0;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var56 = var4 - 4; var56 <= 4 + var4; ++var56) {
                                                   for(var77 = var5 - 4; var77 <= 4 + var5; ++var77) {
                                                      var80 = Item.plane;
                                                      if(var80 < 3 && (class5.tileSettings[1][var56][var77] & 2) == 2) {
                                                         ++var80;
                                                      }

                                                      var25 = var6 - class5.tileHeights[var80][var56][var77];
                                                      if(var25 > var7) {
                                                         var7 = var25;
                                                      }
                                                   }
                                                }
                                             }

                                             var56 = 192 * var7;
                                             if(var56 > 98048) {
                                                var56 = 98048;
                                             }

                                             if(var56 < '耀') {
                                                var56 = '耀';
                                             }

                                             if(var56 > Client.field375) {
                                                Client.field375 += (var56 - Client.field375) / 24;
                                             } else if(var56 < Client.field375) {
                                                Client.field375 += (var56 - Client.field375) / 80;
                                             }

                                             if(Client.field528) {
                                                var2 = 64 + class158.field2360 * 128;
                                                var3 = class43.field1001 * 128 + 64;
                                                var4 = class116.method2462(var2, var3, Item.plane) - class109.field1955;
                                                if(class165.cameraX < var2) {
                                                   class165.cameraX += (var2 - class165.cameraX) * class56.field1238 / 1000 + Item.field709;
                                                   if(class165.cameraX > var2) {
                                                      class165.cameraX = var2;
                                                   }
                                                }

                                                if(class165.cameraX > var2) {
                                                   class165.cameraX -= (class165.cameraX - var2) * class56.field1238 / 1000 + Item.field709;
                                                   if(class165.cameraX < var2) {
                                                      class165.cameraX = var2;
                                                   }
                                                }

                                                if(class125.cameraZ < var4) {
                                                   class125.cameraZ += Item.field709 + class56.field1238 * (var4 - class125.cameraZ) / 1000;
                                                   if(class125.cameraZ > var4) {
                                                      class125.cameraZ = var4;
                                                   }
                                                }

                                                if(class125.cameraZ > var4) {
                                                   class125.cameraZ -= (class125.cameraZ - var4) * class56.field1238 / 1000 + Item.field709;
                                                   if(class125.cameraZ < var4) {
                                                      class125.cameraZ = var4;
                                                   }
                                                }

                                                if(class9.cameraY < var3) {
                                                   class9.cameraY += (var3 - class9.cameraY) * class56.field1238 / 1000 + Item.field709;
                                                   if(class9.cameraY > var3) {
                                                      class9.cameraY = var3;
                                                   }
                                                }

                                                if(class9.cameraY > var3) {
                                                   class9.cameraY -= Item.field709 + (class9.cameraY - var3) * class56.field1238 / 1000;
                                                   if(class9.cameraY < var3) {
                                                      class9.cameraY = var3;
                                                   }
                                                }

                                                var2 = Client.field448 * 128 + 64;
                                                var3 = 64 + class40.field903 * 128;
                                                var4 = class116.method2462(var2, var3, Item.plane) - class0.field15;
                                                var5 = var2 - class165.cameraX;
                                                var6 = var4 - class125.cameraZ;
                                                var7 = var3 - class9.cameraY;
                                                var56 = (int)Math.sqrt((double)(var5 * var5 + var7 * var7));
                                                var77 = (int)(Math.atan2((double)var6, (double)var56) * 325.949D) & 2047;
                                                var80 = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                                                if(var77 < 128) {
                                                   var77 = 128;
                                                }

                                                if(var77 > 383) {
                                                   var77 = 383;
                                                }

                                                if(class18.cameraPitch < var77) {
                                                   class18.cameraPitch += class0.field12 + (var77 - class18.cameraPitch) * class13.field199 / 1000;
                                                   if(class18.cameraPitch > var77) {
                                                      class18.cameraPitch = var77;
                                                   }
                                                }

                                                if(class18.cameraPitch > var77) {
                                                   class18.cameraPitch -= class0.field12 + (class18.cameraPitch - var77) * class13.field199 / 1000;
                                                   if(class18.cameraPitch < var77) {
                                                      class18.cameraPitch = var77;
                                                   }
                                                }

                                                var25 = var80 - class33.cameraYaw;
                                                if(var25 > 1024) {
                                                   var25 -= 2048;
                                                }

                                                if(var25 < -1024) {
                                                   var25 += 2048;
                                                }

                                                if(var25 > 0) {
                                                   class33.cameraYaw += class0.field12 + var25 * class13.field199 / 1000;
                                                   class33.cameraYaw &= 2047;
                                                }

                                                if(var25 < 0) {
                                                   class33.cameraYaw -= -var25 * class13.field199 / 1000 + class0.field12;
                                                   class33.cameraYaw &= 2047;
                                                }

                                                int var113 = var80 - class33.cameraYaw;
                                                if(var113 > 1024) {
                                                   var113 -= 2048;
                                                }

                                                if(var113 < -1024) {
                                                   var113 += 2048;
                                                }

                                                if(var113 < 0 && var25 > 0 || var113 > 0 && var25 < 0) {
                                                   class33.cameraYaw = var80;
                                                }
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field534[var2];
                                             }

                                             Friend.chatMessages.method200();
                                             var2 = class112.method2443();
                                             var3 = class128.method2842();
                                             if(var2 > 15000 && var3 > 15000) {
                                                Client.field333 = 250;
                                                class143.mouseIdleTicks = 14500;
                                                Client.field323.method2801(8);
                                             }

                                             ++Client.field568;
                                             if(Client.field568 > 500) {
                                                Client.field568 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.field525 += Client.field347;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.field352 += Client.field349;
                                                }

                                                if((var4 & 4) == 4) {
                                                   Client.field350 += Client.field483;
                                                }
                                             }

                                             if(Client.field525 < -50) {
                                                Client.field347 = 2;
                                             }

                                             if(Client.field525 > 50) {
                                                Client.field347 = -2;
                                             }

                                             if(Client.field352 < -55) {
                                                Client.field349 = 2;
                                             }

                                             if(Client.field352 > 55) {
                                                Client.field349 = -2;
                                             }

                                             if(Client.field350 < -40) {
                                                Client.field483 = 1;
                                             }

                                             if(Client.field350 > 40) {
                                                Client.field483 = -1;
                                             }

                                             ++Client.field357;
                                             if(Client.field357 > 500) {
                                                Client.field357 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.mapScale += Client.field354;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field356;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field354 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field354 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field356 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field356 = -1;
                                             }

                                             for(class40 var110 = (class40)Client.field551.method3809(); null != var110; var110 = (class40)Client.field551.method3810()) {
                                                if((long)var110.field902 < class5.method63() / 1000L - 5L) {
                                                   if(var110.field900 > 0) {
                                                      class10.sendGameMessage(5, "", var110.field901 + " has logged in.");
                                                   }

                                                   if(var110.field900 == 0) {
                                                      class10.sendGameMessage(5, "", var110.field901 + " has logged out.");
                                                   }

                                                   var110.method3962();
                                                }
                                             }

                                             ++Client.field329;
                                             if(Client.field329 > 50) {
                                                Client.field323.method2801(148);
                                             }

                                             try {
                                                if(BufferProvider.field1475 != null && Client.field323.offset > 0) {
                                                   BufferProvider.field1475.method3025(Client.field323.payload, 0, Client.field323.offset);
                                                   Client.field323.offset = 0;
                                                   Client.field329 = 0;
                                                }
                                             } catch (IOException var42) {
                                                class151.method3162();
                                             }

                                             return;
                                          }

                                          var108 = var115.field2;
                                          if(var108.index < 0) {
                                             break;
                                          }

                                          var84 = class24.method600(var108.parentId);
                                       } while(null == var84 || var84.children == null || var108.index >= var84.children.length || var84.children[var108.index] != var108);

                                       class1.method9(var115, 200000);
                                    }
                                 }

                                 var108 = var115.field2;
                                 if(var108.index < 0) {
                                    break;
                                 }

                                 var84 = class24.method600(var108.parentId);
                              } while(null == var84 || var84.children == null || var108.index >= var84.children.length || var84.children[var108.index] != var108);

                              class1.method9(var115, 200000);
                           }
                        }

                        var108 = var115.field2;
                        if(var108.index < 0) {
                           break;
                        }

                        var84 = class24.method600(var108.parentId);
                     } while(null == var84 || null == var84.children || var108.index >= var84.children.length || var108 != var84.children[var108.index]);

                     class1.method9(var115, 200000);
                  }
               }
            }
         }
      }
   }
}
