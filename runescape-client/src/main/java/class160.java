import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public final class class160 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1847121947
   )
   int field2140;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 587570591
   )
   int field2143;
   @ObfuscatedName("k")
   int[] field2144 = new int[256];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1462439403
   )
   int field2145;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2136603717
   )
   int field2146;
   @ObfuscatedName("u")
   int[] field2147 = new int[256];

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2144[var2] = var1[var2];
      }

      this.method2990();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   final int method2983() {
      if(--this.field2143 + 1 == 0) {
         this.method2992();
         this.field2143 = 255;
      }

      return this.field2144[this.field2143];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "106"
   )
   final void method2990() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2144[var1];
         var3 += this.field2144[1 + var1];
         var4 += this.field2144[2 + var1];
         var5 += this.field2144[3 + var1];
         var6 += this.field2144[4 + var1];
         var7 += this.field2144[var1 + 5];
         var8 += this.field2144[6 + var1];
         var9 += this.field2144[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2147[var1] = var2;
         this.field2147[1 + var1] = var3;
         this.field2147[2 + var1] = var4;
         this.field2147[var1 + 3] = var5;
         this.field2147[var1 + 4] = var6;
         this.field2147[5 + var1] = var7;
         this.field2147[var1 + 6] = var8;
         this.field2147[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2147[var1];
         var3 += this.field2147[var1 + 1];
         var4 += this.field2147[var1 + 2];
         var5 += this.field2147[3 + var1];
         var6 += this.field2147[4 + var1];
         var7 += this.field2147[5 + var1];
         var8 += this.field2147[var1 + 6];
         var9 += this.field2147[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2147[var1] = var2;
         this.field2147[var1 + 1] = var3;
         this.field2147[2 + var1] = var4;
         this.field2147[var1 + 3] = var5;
         this.field2147[4 + var1] = var6;
         this.field2147[var1 + 5] = var7;
         this.field2147[var1 + 6] = var8;
         this.field2147[7 + var1] = var9;
      }

      this.method2992();
      this.field2143 = 256;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   final void method2992() {
      this.field2146 += ++this.field2140;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2147[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2145 ^= this.field2145 << 13;
            } else {
               this.field2145 ^= this.field2145 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2145 ^= this.field2145 << 2;
         } else {
            this.field2145 ^= this.field2145 >>> 16;
         }

         this.field2145 += this.field2147[128 + var1 & 255];
         int var3;
         this.field2147[var1] = var3 = this.field2147[(var2 & 1020) >> 2] + this.field2145 + this.field2146;
         this.field2144[var1] = this.field2146 = this.field2147[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "118298355"
   )
   static final void method2994() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[1 + var1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[1 + var1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[1 + var1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[1 + var1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[1 + var1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[1 + var1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1047808466"
   )
   static final boolean method2995() {
      if(class30.field698 == null) {
         return false;
      } else {
         int var2;
         String var21;
         try {
            int var0 = class30.field698.method2007();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               class30.field698.method2005(Client.field352.payload, 0, 1);
               Client.field352.offset = 0;
               Client.packetOpcode = Client.field352.method2964();
               Client.field339 = class212.field3139[Client.packetOpcode];
               --var0;
            }

            if(Client.field339 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class30.field698.method2005(Client.field352.payload, 0, 1);
               Client.field339 = Client.field352.payload[0] & 255;
               --var0;
            }

            if(Client.field339 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class30.field698.method2005(Client.field352.payload, 0, 2);
               Client.field352.offset = 0;
               Client.field339 = Client.field352.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field339) {
               return false;
            }

            Client.field352.offset = 0;
            class30.field698.method2005(Client.field352.payload, 0, Client.field339);
            Client.field517 = 0;
            Client.field345 = Client.field552;
            Client.field552 = Client.field480;
            Client.field480 = Client.packetOpcode;
            int var43;
            if(Client.packetOpcode == 159) {
               var43 = Client.field352.method2759();
               byte var73 = Client.field352.readByte();
               class165.settings[var43] = var73;
               if(class165.widgetSettings[var43] != var73) {
                  class165.widgetSettings[var43] = var73;
               }

               class2.method26(var43);
               Client.field477[++Client.field478 - 1 & 31] = var43;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 102) {
               XItemContainer.method136(Client.field352, Client.field339);
               Client.packetOpcode = -1;
               return true;
            }

            int var3;
            int var5;
            int var54;
            boolean var60;
            int var61;
            if(Client.packetOpcode == 212) {
               Client.field485 = Client.field358;
               if(Client.field339 == 0) {
                  Client.field519 = null;
                  Client.clanChatOwner = null;
                  class162.clanChatCount = 0;
                  class57.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.clanChatOwner = Client.field352.method2911();
               long var82 = Client.field352.method2728();
               Client.field519 = class203.method3654(var82);
               class149.field2046 = Client.field352.readByte();
               var3 = Client.field352.readUnsignedByte();
               if(var3 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               class162.clanChatCount = var3;
               XClanMember[] var65 = new XClanMember[100];

               for(var5 = 0; var5 < class162.clanChatCount; ++var5) {
                  var65[var5] = new XClanMember();
                  var65[var5].username = Client.field352.method2911();
                  var65[var5].field284 = class137.method2397(var65[var5].username, class1.field15);
                  var65[var5].world = Client.field352.readUnsignedShort();
                  var65[var5].rank = Client.field352.readByte();
                  Client.field352.method2911();
                  if(var65[var5].username.equals(XItemContainer.localPlayer.name)) {
                     class10.field109 = var65[var5].rank;
                  }
               }

               var60 = false;
               var54 = class162.clanChatCount;

               while(var54 > 0) {
                  var60 = true;
                  --var54;

                  for(var61 = 0; var61 < var54; ++var61) {
                     if(var65[var61].field284.compareTo(var65[var61 + 1].field284) > 0) {
                        XClanMember var59 = var65[var61];
                        var65[var61] = var65[1 + var61];
                        var65[var61 + 1] = var59;
                        var60 = false;
                     }
                  }

                  if(var60) {
                     break;
                  }
               }

               class57.clanMembers = var65;
               Client.packetOpcode = -1;
               return true;
            }

            int var19;
            if(Client.packetOpcode == 189) {
               var2 = Client.field352.readUnsignedByte();
               class216[] var108 = class3.method31();
               var19 = 0;

               class216 var104;
               while(true) {
                  if(var19 >= var108.length) {
                     var104 = null;
                     break;
                  }

                  class216 var89 = var108[var19];
                  if(var89.field3168 == var2) {
                     var104 = var89;
                     break;
                  }

                  ++var19;
               }

               class32.field731 = var104;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var75;
            if(Client.packetOpcode == 110) {
               var43 = Client.field352.method2757();
               var2 = Client.field352.method2727();
               var75 = class108.method1988(var2);
               if(var75.modelType != 1 || var75.modelId != var43) {
                  var75.modelType = 1;
                  var75.modelId = var43;
                  class204.method3671(var75);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 220) {
               class25.field587 = Client.field352.method2751();
               class138.field1924 = Client.field352.method2915();
               Client.packetOpcode = -1;
               return true;
            }

            Widget var92;
            if(Client.packetOpcode == 137) {
               var43 = Client.field352.method2826();
               var92 = class108.method1988(var43);
               var92.modelType = 3;
               var92.modelId = XItemContainer.localPlayer.composition.method3049();
               class204.method3671(var92);
               Client.packetOpcode = -1;
               return true;
            }

            boolean var1;
            if(Client.packetOpcode == 12) {
               var1 = Client.field352.readUnsignedByte() == 1;
               if(var1) {
                  XItemContainer.field133 = class2.method27() - Client.field352.method2728();
                  class15.field167 = new class1(Client.field352, true);
               } else {
                  class15.field167 = null;
               }

               Client.field487 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            String var18;
            String var44;
            boolean var48;
            if(Client.packetOpcode == 154) {
               while(Client.field352.offset < Client.field339) {
                  var43 = Client.field352.readUnsignedByte();
                  var48 = (var43 & 1) == 1;
                  var18 = Client.field352.method2911();
                  var44 = Client.field352.method2911();
                  Client.field352.method2911();

                  for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                     Ignore var57 = Client.ignores[var5];
                     if(var48) {
                        if(var44.equals(var57.name)) {
                           var57.name = var18;
                           var57.previousName = var44;
                           var18 = null;
                           break;
                        }
                     } else if(var18.equals(var57.name)) {
                        var57.name = var18;
                        var57.previousName = var44;
                        var18 = null;
                        break;
                     }
                  }

                  if(var18 != null && Client.ignoreCount < 400) {
                     Ignore var88 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var88;
                     var88.name = var18;
                     var88.previousName = var44;
                     ++Client.ignoreCount;
                  }
               }

               Client.field484 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 199) {
               World var103 = new World();
               var103.address = Client.field352.method2911();
               var103.id = Client.field352.readUnsignedShort();
               var2 = Client.field352.method2727();
               var103.mask = var2;
               class103.setGameState(45);
               class30.field698.method2006();
               class30.field698 = null;
               if(var103.method621() != Client.isMembers) {
                  Client.isMembers = var103.method621();
                  boolean var69 = var103.method621();
                  if(ItemComposition.isMembersWorld != var69) {
                     ItemComposition.field2986.reset();
                     ItemComposition.itemModelCache.reset();
                     ItemComposition.itemSpriteCache.reset();
                     ItemComposition.isMembersWorld = var69;
                  }
               }

               class178.host = var103.address;
               Client.world = var103.id;
               Client.flags = var103.mask;
               class0.field6 = Client.field297 == 0?'ꩊ':var103.id + '鱀';
               CombatInfo2.field2843 = Client.field297 == 0?443:var103.id + '썐';
               class26.field602 = class0.field6;
               Client.packetOpcode = -1;
               return false;
            }

            long var101;
            if(Client.packetOpcode == 247) {
               var43 = Client.field352.method2758();
               if(var43 == '\uffff') {
                  var43 = -1;
               }

               var2 = Client.field352.method2759();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = Client.field352.method2740();
               var19 = Client.field352.method2826();

               for(var5 = var2; var5 <= var43; ++var5) {
                  var101 = ((long)var3 << 32) + (long)var5;
                  Node var100 = Client.widgetFlags.method2274(var101);
                  if(var100 != null) {
                     var100.unlink();
                  }

                  Client.widgetFlags.method2282(new class133(var19), var101);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 71) {
               var43 = Client.field352.method2727();
               var2 = Client.field352.method2727();
               if(class139.field1948 == null || !class139.field1948.isValid()) {
                  try {
                     Iterator var96 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var96.hasNext()) {
                        GarbageCollectorMXBean var64 = (GarbageCollectorMXBean)var96.next();
                        if(var64.isValid()) {
                           class139.field1948 = var64;
                           Client.field424 = -1L;
                           Client.field569 = -1L;
                        }
                     }
                  } catch (Throwable var40) {
                     ;
                  }
               }

               long var68 = class2.method27();
               var5 = -1;
               if(class139.field1948 != null) {
                  var101 = class139.field1948.getCollectionTime();
                  if(Client.field569 != -1L) {
                     long var62 = var101 - Client.field569;
                     long var66 = var68 - Client.field424;
                     if(0L != var66) {
                        var5 = (int)(100L * var62 / var66);
                     }
                  }

                  Client.field569 = var101;
                  Client.field424 = var68;
               }

               Client.field336.method2963(50);
               Client.field336.method2766(var43);
               Client.field336.method2764(var2);
               Client.field336.method2833(var5);
               Client.field336.method2708(GameEngine.FPS);
               Client.packetOpcode = -1;
               return true;
            }

            int var23;
            if(Client.packetOpcode == 5) {
               Client.field499 = true;
               class164.field2171 = Client.field352.readUnsignedByte();
               class180.field2705 = Client.field352.readUnsignedByte();
               class48.field942 = Client.field352.readUnsignedShort();
               class6.field69 = Client.field352.readUnsignedByte();
               class183.field2735 = Client.field352.readUnsignedByte();
               if(class183.field2735 >= 100) {
                  var43 = class164.field2171 * 128 + 64;
                  var2 = class180.field2705 * 128 + 64;
                  var3 = XClanMember.method223(var43, var2, class118.plane) - class48.field942;
                  var19 = var43 - XItemContainer.cameraX;
                  var5 = var3 - class11.cameraZ;
                  var23 = var2 - class20.cameraY;
                  var54 = (int)Math.sqrt((double)(var19 * var19 + var23 * var23));
                  class13.cameraPitch = (int)(Math.atan2((double)var5, (double)var54) * 325.949D) & 2047;
                  class105.cameraYaw = (int)(Math.atan2((double)var19, (double)var23) * -325.949D) & 2047;
                  if(class13.cameraPitch < 128) {
                     class13.cameraPitch = 128;
                  }

                  if(class13.cameraPitch > 383) {
                     class13.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 83) {
               var21 = Client.field352.method2911();
               Object[] var99 = new Object[var21.length() + 1];

               for(var3 = var21.length() - 1; var3 >= 0; --var3) {
                  if(var21.charAt(var3) == 115) {
                     var99[var3 + 1] = Client.field352.method2911();
                  } else {
                     var99[1 + var3] = new Integer(Client.field352.method2727());
                  }
               }

               var99[0] = new Integer(Client.field352.method2727());
               class18 var93 = new class18();
               var93.field205 = var99;
               CombatInfo1.method594(var93);
               Client.packetOpcode = -1;
               return true;
            }

            WidgetNode var47;
            Widget var78;
            if(Client.packetOpcode == 80) {
               var43 = Client.field352.method2826();
               var2 = Client.field352.method2727();
               WidgetNode var91 = (WidgetNode)Client.componentTable.method2274((long)var2);
               var47 = (WidgetNode)Client.componentTable.method2274((long)var43);
               if(var47 != null) {
                  WallObject.method1832(var47, var91 == null || var91.id != var47.id);
               }

               if(null != var91) {
                  var91.unlink();
                  Client.componentTable.method2282(var91, (long)var43);
               }

               var78 = class108.method1988(var2);
               if(var78 != null) {
                  class204.method3671(var78);
               }

               var78 = class108.method1988(var43);
               if(null != var78) {
                  class204.method3671(var78);
                  class1.method14(Widget.widgets[var78.id >>> 16], var78, true);
               }

               if(Client.widgetRoot != -1) {
                  class9.method95(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 10) {
               class45.field894 = 0;

               for(var43 = 0; var43 < 2048; ++var43) {
                  class45.field893[var43] = null;
                  class45.field892[var43] = 1;
               }

               for(var43 = 0; var43 < 2048; ++var43) {
                  Client.cachedPlayers[var43] = null;
               }

               class103.method1933(Client.field352);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 119) {
               for(var43 = 0; var43 < Client.cachedPlayers.length; ++var43) {
                  if(null != Client.cachedPlayers[var43]) {
                     Client.cachedPlayers[var43].animation = -1;
                  }
               }

               for(var43 = 0; var43 < Client.cachedNPCs.length; ++var43) {
                  if(null != Client.cachedNPCs[var43]) {
                     Client.cachedNPCs[var43].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 204) {
               var43 = Client.field352.method2758();
               if(var43 == '\uffff') {
                  var43 = -1;
               }

               class16.method156(var43);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 134) {
               var43 = Client.field352.method2857();
               var2 = Client.field352.method2757();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(Client.field529 != 0 && var2 != -1) {
                  WallObject.method1833(Client.field325, var2, 0, Client.field529, false);
                  Client.field531 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 195) {
               Client.field506 = 1;
               Client.field484 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 78) {
               var43 = Client.field352.readUnsignedByte();
               var2 = Client.field352.readUnsignedByte();
               var3 = Client.field352.readUnsignedByte();
               var19 = Client.field352.readUnsignedByte();
               Client.field541[var43] = true;
               Client.field495[var43] = var2;
               Client.field543[var43] = var3;
               Client.field544[var43] = var19;
               Client.field545[var43] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 227) {
               var43 = Client.field352.readUnsignedByte();
               if(Client.field352.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var43] = new XGrandExchangeOffer();
                  Client.field352.offset += 18;
               } else {
                  --Client.field352.offset;
                  Client.grandExchangeOffers[var43] = new XGrandExchangeOffer(Client.field352, false);
               }

               Client.field427 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            int var9;
            int var10;
            int var12;
            int var13;
            int var15;
            String var22;
            long var56;
            int var70;
            String var81;
            if(Client.packetOpcode == 216) {
               var21 = Client.field352.method2911();
               class155.field2116 = var21;

               try {
                  var22 = class227.field3230.getParameter(class214.field3158.field3152);
                  var18 = class227.field3230.getParameter(class214.field3159.field3152);
                  var44 = var22 + "settings=" + var21 + "; version=1; path=/; domain=" + var18;
                  if(var21.length() == 0) {
                     var44 = var44 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var81 = var44 + "; Expires=";
                     var56 = class2.method27() + 94608000000L;
                     class162.field2158.setTime(new Date(var56));
                     var9 = class162.field2158.get(7);
                     var10 = class162.field2158.get(5);
                     var70 = class162.field2158.get(2);
                     var12 = class162.field2158.get(1);
                     var13 = class162.field2158.get(11);
                     int var14 = class162.field2158.get(12);
                     var15 = class162.field2158.get(13);
                     String var55 = class162.field2159[var9 - 1] + ", " + var10 / 10 + var10 % 10 + "-" + class162.field2160[0][var70] + "-" + var12 + " " + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + ":" + var15 / 10 + var15 % 10 + " GMT";
                     var44 = var81 + var55 + "; Max-Age=" + 94608000L;
                  }

                  class100.method1889(class227.field3230, "document.cookie=\"" + var44 + "\"");
               } catch (Throwable var39) {
                  ;
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var4;
            if(Client.packetOpcode == 163) {
               var43 = Client.field352.method2760();
               var2 = Client.field352.method2761();
               var3 = Client.field352.method2727();
               var4 = class108.method1988(var3);
               if(var43 != var4.originalX || var2 != var4.originalY || var4.field2214 != 0 || var4.field2215 != 0) {
                  var4.originalX = var43;
                  var4.originalY = var2;
                  var4.field2214 = 0;
                  var4.field2215 = 0;
                  class204.method3671(var4);
                  class101.method1903(var4);
                  if(var4.type == 0) {
                     class1.method14(Widget.widgets[var3 >> 16], var4, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 245) {
               var43 = Client.field352.method2727();
               WidgetNode var94 = (WidgetNode)Client.componentTable.method2274((long)var43);
               if(var94 != null) {
                  WallObject.method1832(var94, true);
               }

               if(null != Client.field455) {
                  class204.method3671(Client.field455);
                  Client.field455 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 27) {
               Client.field499 = true;
               class189.field2793 = Client.field352.readUnsignedByte();
               class5.field57 = Client.field352.readUnsignedByte();
               Renderable.field1544 = Client.field352.readUnsignedShort();
               class5.field59 = Client.field352.readUnsignedByte();
               class0.field3 = Client.field352.readUnsignedByte();
               if(class0.field3 >= 100) {
                  XItemContainer.cameraX = class189.field2793 * 128 + 64;
                  class20.cameraY = class5.field57 * 128 + 64;
                  class11.cameraZ = XClanMember.method223(XItemContainer.cameraX, class20.cameraY, class118.plane) - Renderable.field1544;
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var67;
            Widget var102;
            if(Client.packetOpcode == 120) {
               var43 = Client.field352.offset + Client.field339;
               var2 = Client.field352.readUnsignedShort();
               var3 = Client.field352.readUnsignedShort();
               if(Client.widgetRoot != var2) {
                  Client.widgetRoot = var2;
                  Item.method770(false);
                  var19 = Client.widgetRoot;
                  if(class109.method1999(var19)) {
                     Widget[] var83 = Widget.widgets[var19];

                     for(var23 = 0; var23 < var83.length; ++var23) {
                        var102 = var83[var23];
                        if(null != var102) {
                           var102.field2331 = 0;
                           var102.field2332 = 0;
                        }
                     }
                  }

                  class139.method2545(Client.widgetRoot);

                  for(var5 = 0; var5 < 100; ++var5) {
                     Client.field497[var5] = true;
                  }
               }

               WidgetNode var105;
               for(; var3-- > 0; var105.field194 = true) {
                  var19 = Client.field352.method2727();
                  var5 = Client.field352.readUnsignedShort();
                  var23 = Client.field352.readUnsignedByte();
                  var105 = (WidgetNode)Client.componentTable.method2274((long)var19);
                  if(var105 != null && var5 != var105.id) {
                     WallObject.method1832(var105, true);
                     var105 = null;
                  }

                  if(null == var105) {
                     WidgetNode var110 = new WidgetNode();
                     var110.id = var5;
                     var110.field193 = var23;
                     Client.componentTable.method2282(var110, (long)var19);
                     if(class109.method1999(var5)) {
                        Widget[] var111 = Widget.widgets[var5];

                        for(var70 = 0; var70 < var111.length; ++var70) {
                           Widget var114 = var111[var70];
                           if(null != var114) {
                              var114.field2331 = 0;
                              var114.field2332 = 0;
                           }
                        }
                     }

                     Widget var112 = class108.method1988(var19);
                     class204.method3671(var112);
                     if(Client.field455 != null) {
                        class204.method3671(Client.field455);
                        Client.field455 = null;
                     }

                     class63.method1107();
                     class1.method14(Widget.widgets[var19 >> 16], var112, false);
                     class139.method2545(var5);
                     if(Client.widgetRoot != -1) {
                        class9.method95(Client.widgetRoot, 1);
                     }

                     var105 = var110;
                  }
               }

               for(var47 = (WidgetNode)Client.componentTable.method2283(); null != var47; var47 = (WidgetNode)Client.componentTable.method2277()) {
                  if(var47.field194) {
                     var47.field194 = false;
                  } else {
                     WallObject.method1832(var47, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field352.offset < var43) {
                  var19 = Client.field352.method2727();
                  var5 = Client.field352.readUnsignedShort();
                  var23 = Client.field352.readUnsignedShort();
                  var54 = Client.field352.method2727();

                  for(var61 = var5; var61 <= var23; ++var61) {
                     var67 = ((long)var19 << 32) + (long)var61;
                     Client.widgetFlags.method2282(new class133(var54), var67);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 166) {
               var43 = Client.field352.method2727();
               class85.field1457 = class22.field252.method1913(var43);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 217) {
               var43 = Client.field352.method2727();
               var92 = class108.method1988(var43);

               for(var3 = 0; var3 < var92.itemIds.length; ++var3) {
                  var92.itemIds[var3] = -1;
                  var92.itemIds[var3] = 0;
               }

               class204.method3671(var92);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 135) {
               NPCComposition.method3583();
               Client.weight = Client.field352.readShort();
               Client.field488 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var76;
            if(Client.packetOpcode == 32) {
               var43 = Client.field352.method2735();
               var48 = Client.field352.readUnsignedByte() == 1;
               var18 = "";
               var76 = false;
               if(var48) {
                  var18 = Client.field352.method2911();
                  if(class119.method2222(var18)) {
                     var76 = true;
                  }
               }

               var81 = Client.field352.method2911();
               if(!var76) {
                  Player.sendGameMessage(var43, var18, var81);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 186) {
               for(var43 = 0; var43 < class165.widgetSettings.length; ++var43) {
                  if(class165.widgetSettings[var43] != class165.settings[var43]) {
                     class165.widgetSettings[var43] = class165.settings[var43];
                     class2.method26(var43);
                     Client.field477[++Client.field478 - 1 & 31] = var43;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 191) {
               var21 = Client.field352.method2911();
               var2 = Client.field352.readUnsignedShort();
               byte var58 = Client.field352.readByte();
               var76 = false;
               if(var58 == -128) {
                  var76 = true;
               }

               if(var76) {
                  if(class162.clanChatCount == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var60 = false;

                  for(var5 = 0; var5 < class162.clanChatCount && (!class57.clanMembers[var5].username.equals(var21) || var2 != class57.clanMembers[var5].world); ++var5) {
                     ;
                  }

                  if(var5 < class162.clanChatCount) {
                     while(var5 < class162.clanChatCount - 1) {
                        class57.clanMembers[var5] = class57.clanMembers[var5 + 1];
                        ++var5;
                     }

                     --class162.clanChatCount;
                     class57.clanMembers[class162.clanChatCount] = null;
                  }
               } else {
                  Client.field352.method2911();
                  XClanMember var80 = new XClanMember();
                  var80.username = var21;
                  var80.field284 = class137.method2397(var80.username, class1.field15);
                  var80.world = var2;
                  var80.rank = var58;

                  for(var23 = class162.clanChatCount - 1; var23 >= 0; --var23) {
                     var54 = class57.clanMembers[var23].field284.compareTo(var80.field284);
                     if(var54 == 0) {
                        class57.clanMembers[var23].world = var2;
                        class57.clanMembers[var23].rank = var58;
                        if(var21.equals(XItemContainer.localPlayer.name)) {
                           class10.field109 = var58;
                        }

                        Client.field485 = Client.field358;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var54 < 0) {
                        break;
                     }
                  }

                  if(class162.clanChatCount >= class57.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var54 = class162.clanChatCount - 1; var54 > var23; --var54) {
                     class57.clanMembers[1 + var54] = class57.clanMembers[var54];
                  }

                  if(class162.clanChatCount == 0) {
                     class57.clanMembers = new XClanMember[100];
                  }

                  class57.clanMembers[1 + var23] = var80;
                  ++class162.clanChatCount;
                  if(var21.equals(XItemContainer.localPlayer.name)) {
                     class10.field109 = var58;
                  }
               }

               Client.field485 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var11;
            String var31;
            int var32;
            long var46;
            long var85;
            if(Client.packetOpcode == 202) {
               var21 = Client.field352.method2911();
               var46 = Client.field352.method2728();
               var85 = (long)Client.field352.readUnsignedShort();
               var101 = (long)Client.field352.read24BitInt();
               class177 var97 = (class177)class72.method1368(class7.method91(), Client.field352.readUnsignedByte());
               var67 = var101 + (var85 << 32);
               var11 = false;

               for(var12 = 0; var12 < 100; ++var12) {
                  if(Client.field513[var12] == var67) {
                     var11 = true;
                     break;
                  }
               }

               if(var97.field2677 && class119.method2222(var21)) {
                  var11 = true;
               }

               if(!var11 && Client.field383 == 0) {
                  Client.field513[Client.field453] = var67;
                  Client.field453 = (Client.field453 + 1) % 100;
                  class159 var29 = Client.field352;

                  String var115;
                  try {
                     var15 = var29.method2735();
                     if(var15 > 32767) {
                        var15 = 32767;
                     }

                     byte[] var16 = new byte[var15];
                     var29.offset += class210.field3121.method2648(var29.payload, var29.offset, var16, 0, var15);
                     String var17 = Friend.method152(var16, 0, var15);
                     var115 = var17;
                  } catch (Exception var38) {
                     var115 = "Cabbage";
                  }

                  var115 = FontTypeFace.method3726(class115.method2169(var115));
                  if(var97.field2675 != -1) {
                     var32 = var97.field2675;
                     var31 = "<img=" + var32 + ">";
                     class202.addChatMessage(9, var31 + var21, var115, class142.method2609(var46));
                  } else {
                     class202.addChatMessage(9, var21, var115, class142.method2609(var46));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 127) {
               var21 = Client.field352.method2911();
               var2 = Client.field352.method2763();
               var3 = Client.field352.method2763();
               if(var3 >= 1 && var3 <= 8) {
                  if(var21.equalsIgnoreCase("null")) {
                     var21 = null;
                  }

                  Client.playerOptions[var3 - 1] = var21;
                  Client.playerOptionsPriority[var3 - 1] = var2 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 193) {
               var43 = Client.field352.method2767();
               var2 = Client.field352.method2758();
               var3 = var2 >> 10 & 31;
               var19 = var2 >> 5 & 31;
               var5 = var2 & 31;
               var23 = (var5 << 3) + (var3 << 19) + (var19 << 11);
               var102 = class108.method1988(var43);
               if(var102.textColor != var23) {
                  var102.textColor = var23;
                  class204.method3671(var102);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 48) {
               CombatInfoListHolder.method692();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 143) {
               var43 = Client.field352.readUnsignedShort();
               var2 = Client.field352.method2740();
               var75 = class108.method1988(var2);
               if(var75 != null && var75.type == 0) {
                  if(var43 > var75.scrollHeight - var75.height) {
                     var43 = var75.scrollHeight - var75.height;
                  }

                  if(var43 < 0) {
                     var43 = 0;
                  }

                  if(var43 != var75.scrollY) {
                     var75.scrollY = var43;
                     class204.method3671(var75);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 17) {
               World.xteaChanged(false);
               Client.field352.method2964();
               var43 = Client.field352.readUnsignedShort();
               class47.method840(Client.field352, var43);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 96) {
               World.xteaChanged(true);
               Client.field352.method2964();
               var43 = Client.field352.readUnsignedShort();
               class47.method840(Client.field352, var43);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 187) {
               var43 = Client.field352.method2758();
               class101.method1904(var43);
               Client.interfaceItemTriggers[++Client.field457 - 1 & 31] = var43 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 87) {
               Client.field352.offset += 28;
               if(Client.field352.method2745()) {
                  class159 var86 = Client.field352;
                  var2 = Client.field352.offset - 28;
                  if(null != class104.field1684) {
                     try {
                        class104.field1684.method1348(0L);
                        class104.field1684.method1350(var86.payload, var2, 24);
                     } catch (Exception var37) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 60) {
               class25.field587 = Client.field352.method2915();
               class138.field1924 = Client.field352.method2915();

               for(var43 = class25.field587; var43 < class25.field587 + 8; ++var43) {
                  for(var2 = class138.field1924; var2 < class138.field1924 + 8; ++var2) {
                     if(null != Client.groundItemDeque[class118.plane][var43][var2]) {
                        Client.groundItemDeque[class118.plane][var43][var2] = null;
                        ItemComposition.groundItemSpawned(var43, var2);
                     }
                  }
               }

               for(class25 var84 = (class25)Client.field359.method2330(); var84 != null; var84 = (class25)Client.field359.method2346()) {
                  if(var84.field579 >= class25.field587 && var84.field579 < class25.field587 + 8 && var84.field583 >= class138.field1924 && var84.field583 < 8 + class138.field1924 && class118.plane == var84.field584) {
                     var84.field588 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 98) {
               var43 = Client.field352.method2760();
               var2 = Client.field352.method2727();
               var75 = class108.method1988(var2);
               if(var75.field2256 != var43 || var43 == -1) {
                  var75.field2256 = var43;
                  var75.field2331 = 0;
                  var75.field2332 = 0;
                  class204.method3671(var75);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 88) {
               class138.field1924 = Client.field352.method2915();
               class25.field587 = Client.field352.method2751();

               while(Client.field352.offset < Client.field339) {
                  Client.packetOpcode = Client.field352.readUnsignedByte();
                  class60.method1078();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 103) {
               var43 = Client.field352.method2759();
               var2 = Client.field352.method2727();
               var75 = class108.method1988(var2);
               if(var75.modelType != 2 || var75.modelId != var43) {
                  var75.modelType = 2;
                  var75.modelId = var43;
                  class204.method3671(var75);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 157) {
               Client.flagX = Client.field352.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field352.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 14) {
               NPCComposition.method3583();
               Client.energy = Client.field352.readUnsignedByte();
               Client.field488 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            int[] var109;
            if(Client.packetOpcode == 13) {
               var43 = Client.field352.method2727();
               var2 = Client.field352.readUnsignedShort();
               if(var43 < -70000) {
                  var2 += '耀';
               }

               if(var43 >= 0) {
                  var75 = class108.method1988(var43);
               } else {
                  var75 = null;
               }

               if(var75 != null) {
                  for(var19 = 0; var19 < var75.itemIds.length; ++var19) {
                     var75.itemIds[var19] = 0;
                     var75.itemQuantities[var19] = 0;
                  }
               }

               XItemContainer var51 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var2);
               if(null != var51) {
                  for(var5 = 0; var5 < var51.itemIds.length; ++var5) {
                     var51.itemIds[var5] = -1;
                     var51.stackSizes[var5] = 0;
                  }
               }

               var19 = Client.field352.readUnsignedShort();

               for(var5 = 0; var5 < var19; ++var5) {
                  var23 = Client.field352.method2758();
                  var54 = Client.field352.method2751();
                  if(var54 == 255) {
                     var54 = Client.field352.method2826();
                  }

                  if(null != var75 && var5 < var75.itemIds.length) {
                     var75.itemIds[var5] = var23;
                     var75.itemQuantities[var5] = var54;
                  }

                  var61 = var23 - 1;
                  XItemContainer var107 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var2);
                  if(null == var107) {
                     var107 = new XItemContainer();
                     XItemContainer.itemContainers.method2282(var107, (long)var2);
                  }

                  if(var107.itemIds.length <= var5) {
                     var109 = new int[1 + var5];
                     int[] var116 = new int[var5 + 1];

                     for(var12 = 0; var12 < var107.itemIds.length; ++var12) {
                        var109[var12] = var107.itemIds[var12];
                        var116[var12] = var107.stackSizes[var12];
                     }

                     for(var12 = var107.itemIds.length; var12 < var5; ++var12) {
                        var109[var12] = -1;
                        var116[var12] = 0;
                     }

                     var107.itemIds = var109;
                     var107.stackSizes = var116;
                  }

                  var107.itemIds[var5] = var61;
                  var107.stackSizes[var5] = var54;
               }

               if(var75 != null) {
                  class204.method3671(var75);
               }

               NPCComposition.method3583();
               Client.interfaceItemTriggers[++Client.field457 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 30) {
               class47.method840(Client.field352, Client.field339);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 70) {
               class16.method157(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 144) {
               var43 = Client.field352.method2757();
               var2 = Client.field352.method2740();
               var3 = Client.field352.method2759();
               var4 = class108.method1988(var2);
               var4.field2312 = (var3 << 16) + var43;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 215) {
               NPCComposition.method3583();
               var43 = Client.field352.method2763();
               var2 = Client.field352.method2751();
               var3 = Client.field352.method2767();
               Client.skillExperiences[var2] = var3;
               Client.boostedSkillLevels[var2] = var43;
               Client.realSkillLevels[var2] = 1;

               for(var19 = 0; var19 < 98; ++var19) {
                  if(var3 >= class172.field2359[var19]) {
                     Client.realSkillLevels[var2] = 2 + var19;
                  }
               }

               Client.field481[++Client.field482 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 82) {
               var43 = Client.field352.readUnsignedShort();
               var2 = Client.field352.method2751();
               var3 = Client.field352.method2727();
               var47 = (WidgetNode)Client.componentTable.method2274((long)var3);
               if(var47 != null) {
                  WallObject.method1832(var47, var43 != var47.id);
               }

               WidgetNode var79 = new WidgetNode();
               var79.id = var43;
               var79.field193 = var2;
               Client.componentTable.method2282(var79, (long)var3);
               if(class109.method1999(var43)) {
                  Widget[] var52 = Widget.widgets[var43];

                  for(var54 = 0; var54 < var52.length; ++var54) {
                     Widget var95 = var52[var54];
                     if(var95 != null) {
                        var95.field2331 = 0;
                        var95.field2332 = 0;
                     }
                  }
               }

               Widget var53 = class108.method1988(var3);
               class204.method3671(var53);
               if(Client.field455 != null) {
                  class204.method3671(Client.field455);
                  Client.field455 = null;
               }

               class63.method1107();
               class1.method14(Widget.widgets[var3 >> 16], var53, false);
               class139.method2545(var43);
               if(Client.widgetRoot != -1) {
                  class9.method95(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 229) {
               Client.field534 = Client.field352.method2758() * 30;
               Client.field488 = Client.field358;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 241) {
               var43 = Client.field352.method2727();
               var2 = Client.field352.method2759();
               class165.settings[var2] = var43;
               if(class165.widgetSettings[var2] != var43) {
                  class165.widgetSettings[var2] = var43;
               }

               class2.method26(var2);
               Client.field477[++Client.field478 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 73) {
               var21 = Client.field352.method2911();
               var2 = Client.field352.method2740();
               var75 = class108.method1988(var2);
               if(!var21.equals(var75.text)) {
                  var75.text = var21;
                  class204.method3671(var75);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 54) {
               var43 = Client.field352.readUnsignedShort();
               var2 = Client.field352.method2759();
               var3 = Client.field352.method2740();
               var19 = Client.field352.method2757();
               var78 = class108.method1988(var3);
               if(var78.rotationX != var43 || var2 != var78.rotationZ || var19 != var78.field2263) {
                  var78.rotationX = var43;
                  var78.rotationZ = var2;
                  var78.field2263 = var19;
                  class204.method3671(var78);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 138) {
               Client.field311 = Client.field352.readUnsignedByte();
               if(Client.field311 == 1) {
                  Client.field312 = Client.field352.readUnsignedShort();
               }

               if(Client.field311 >= 2 && Client.field311 <= 6) {
                  if(Client.field311 == 2) {
                     Client.field317 = 64;
                     Client.field318 = 64;
                  }

                  if(Client.field311 == 3) {
                     Client.field317 = 0;
                     Client.field318 = 64;
                  }

                  if(Client.field311 == 4) {
                     Client.field317 = 128;
                     Client.field318 = 64;
                  }

                  if(Client.field311 == 5) {
                     Client.field317 = 64;
                     Client.field318 = 0;
                  }

                  if(Client.field311 == 6) {
                     Client.field317 = 64;
                     Client.field318 = 128;
                  }

                  Client.field311 = 2;
                  Client.field314 = Client.field352.readUnsignedShort();
                  Client.field315 = Client.field352.readUnsignedShort();
                  Client.field316 = Client.field352.readUnsignedByte();
               }

               if(Client.field311 == 10) {
                  Client.field313 = Client.field352.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 21 || Client.packetOpcode == 100 || Client.packetOpcode == 233 || Client.packetOpcode == 207 || Client.packetOpcode == 69 || Client.packetOpcode == 167 || Client.packetOpcode == 52 || Client.packetOpcode == 169 || Client.packetOpcode == 198 || Client.packetOpcode == 94) {
               class60.method1078();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 20) {
               Client.field510 = Client.field352.readUnsignedByte();
               Client.field514 = Client.field352.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 112) {
               Client.field347 = Client.field352.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 86) {
               var43 = Client.field352.method2740();
               var48 = Client.field352.method2763() == 1;
               var75 = class108.method1988(var43);
               if(var48 != var75.isHidden) {
                  var75.isHidden = var48;
                  class204.method3671(var75);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 246) {
               class16.method157(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 145) {
               var21 = Client.field352.method2911();
               var46 = (long)Client.field352.readUnsignedShort();
               var85 = (long)Client.field352.read24BitInt();
               class177 var50 = (class177)class72.method1368(class7.method91(), Client.field352.readUnsignedByte());
               var56 = (var46 << 32) + var85;
               boolean var63 = false;

               for(var10 = 0; var10 < 100; ++var10) {
                  if(Client.field513[var10] == var56) {
                     var63 = true;
                     break;
                  }
               }

               if(class119.method2222(var21)) {
                  var63 = true;
               }

               if(!var63 && Client.field383 == 0) {
                  Client.field513[Client.field453] = var56;
                  Client.field453 = (1 + Client.field453) % 100;
                  class159 var33 = Client.field352;

                  String var113;
                  try {
                     var13 = var33.method2735();
                     if(var13 > 32767) {
                        var13 = 32767;
                     }

                     byte[] var30 = new byte[var13];
                     var33.offset += class210.field3121.method2648(var33.payload, var33.offset, var30, 0, var13);
                     var31 = Friend.method152(var30, 0, var13);
                     var113 = var31;
                  } catch (Exception var36) {
                     var113 = "Cabbage";
                  }

                  var113 = FontTypeFace.method3726(class115.method2169(var113));
                  byte var71;
                  if(var50.field2676) {
                     var71 = 7;
                  } else {
                     var71 = 3;
                  }

                  if(var50.field2675 != -1) {
                     var32 = var50.field2675;
                     var31 = "<img=" + var32 + ">";
                     Player.sendGameMessage(var71, var31 + var21, var113);
                  } else {
                     Player.sendGameMessage(var71, var21, var113);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 139) {
               var43 = Client.field352.method2727();
               var2 = Client.field352.readUnsignedShort();
               if(var43 < -70000) {
                  var2 += '耀';
               }

               if(var43 >= 0) {
                  var75 = class108.method1988(var43);
               } else {
                  var75 = null;
               }

               while(Client.field352.offset < Client.field339) {
                  var19 = Client.field352.method2735();
                  var5 = Client.field352.readUnsignedShort();
                  var23 = 0;
                  if(var5 != 0) {
                     var23 = Client.field352.readUnsignedByte();
                     if(var23 == 255) {
                        var23 = Client.field352.method2727();
                     }
                  }

                  if(null != var75 && var19 >= 0 && var19 < var75.itemIds.length) {
                     var75.itemIds[var19] = var5;
                     var75.itemQuantities[var19] = var23;
                  }

                  var54 = var5 - 1;
                  XItemContainer var24 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var2);
                  if(null == var24) {
                     var24 = new XItemContainer();
                     XItemContainer.itemContainers.method2282(var24, (long)var2);
                  }

                  if(var24.itemIds.length <= var19) {
                     int[] var106 = new int[var19 + 1];
                     var109 = new int[1 + var19];

                     for(var70 = 0; var70 < var24.itemIds.length; ++var70) {
                        var106[var70] = var24.itemIds[var70];
                        var109[var70] = var24.stackSizes[var70];
                     }

                     for(var70 = var24.itemIds.length; var70 < var19; ++var70) {
                        var106[var70] = -1;
                        var109[var70] = 0;
                     }

                     var24.itemIds = var106;
                     var24.stackSizes = var109;
                  }

                  var24.itemIds[var19] = var54;
                  var24.stackSizes[var19] = var23;
               }

               if(var75 != null) {
                  class204.method3671(var75);
               }

               NPCComposition.method3583();
               Client.interfaceItemTriggers[++Client.field457 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 225) {
               Client.field499 = false;

               for(var43 = 0; var43 < 5; ++var43) {
                  Client.field541[var43] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 176) {
               var43 = Client.field352.readUnsignedShort();
               var2 = Client.field352.readUnsignedByte();
               var3 = Client.field352.readUnsignedShort();
               class3.method37(var43, var2, var3);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 92) {
               var43 = Client.field352.method2757();
               Client.widgetRoot = var43;
               Item.method770(false);
               if(class109.method1999(var43)) {
                  Widget[] var90 = Widget.widgets[var43];

                  for(var3 = 0; var3 < var90.length; ++var3) {
                     var4 = var90[var3];
                     if(var4 != null) {
                        var4.field2331 = 0;
                        var4.field2332 = 0;
                     }
                  }
               }

               class139.method2545(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field497[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 11) {
               for(var43 = 0; var43 < class170.field2346; ++var43) {
                  class187 var74 = (class187)class187.field2780.get((long)var43);
                  class187 var87;
                  if(null != var74) {
                     var87 = var74;
                  } else {
                     byte[] var45 = class187.field2777.getConfigData(16, var43);
                     var74 = new class187();
                     if(null != var45) {
                        var74.method3334(new Buffer(var45));
                     }

                     class187.field2780.put(var74, (long)var43);
                     var87 = var74;
                  }

                  if(var87 != null) {
                     class165.settings[var43] = 0;
                     class165.widgetSettings[var43] = 0;
                  }
               }

               NPCComposition.method3583();
               Client.field478 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 75) {
               var21 = Client.field352.method2911();
               class159 var72 = Client.field352;

               try {
                  var5 = var72.method2735();
                  if(var5 > 32767) {
                     var5 = 32767;
                  }

                  byte[] var49 = new byte[var5];
                  var72.offset += class210.field3121.method2648(var72.payload, var72.offset, var49, 0, var5);
                  String var98 = Friend.method152(var49, 0, var5);
                  var44 = var98;
               } catch (Exception var35) {
                  var44 = "Cabbage";
               }

               var44 = FontTypeFace.method3726(class115.method2169(var44));
               Player.sendGameMessage(6, var21, var44);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 7) {
               if(Client.widgetRoot != -1) {
                  class9.method95(Client.widgetRoot, 0);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 183) {
               var43 = Client.field352.method2767();
               var2 = Client.field352.method2740();
               var3 = Client.field352.method2758();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = class108.method1988(var43);
               ItemComposition var77;
               if(!var4.hasScript) {
                  if(var3 == -1) {
                     var4.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var77 = NPC.getItemDefinition(var3);
                  var4.modelType = 4;
                  var4.modelId = var3;
                  var4.rotationX = var77.xan2d;
                  var4.rotationZ = var77.yan2d;
                  var4.field2263 = var77.zoom2d * 100 / var2;
                  class204.method3671(var4);
               } else {
                  var4.item = var3;
                  var4.stackSize = var2;
                  var77 = NPC.getItemDefinition(var3);
                  var4.rotationX = var77.xan2d;
                  var4.rotationZ = var77.yan2d;
                  var4.rotationY = var77.zan2d;
                  var4.field2297 = var77.offsetX2d;
                  var4.field2259 = var77.offsetY2d;
                  var4.field2263 = var77.zoom2d;
                  if(var77.isStackable == 1) {
                     var4.field2267 = 1;
                  } else {
                     var4.field2267 = 2;
                  }

                  if(var4.field2265 > 0) {
                     var4.field2263 = var4.field2263 * 32 / var4.field2265;
                  } else if(var4.originalWidth > 0) {
                     var4.field2263 = var4.field2263 * 32 / var4.originalWidth;
                  }

                  class204.method3671(var4);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               while(Client.field352.offset < Client.field339) {
                  var1 = Client.field352.readUnsignedByte() == 1;
                  var22 = Client.field352.method2911();
                  var18 = Client.field352.method2911();
                  var19 = Client.field352.readUnsignedShort();
                  var5 = Client.field352.readUnsignedByte();
                  var23 = Client.field352.readUnsignedByte();
                  boolean var7 = (var23 & 2) != 0;
                  boolean var8 = (var23 & 1) != 0;
                  if(var19 > 0) {
                     Client.field352.method2911();
                     Client.field352.readUnsignedByte();
                     Client.field352.method2727();
                  }

                  Client.field352.method2911();

                  for(var9 = 0; var9 < Client.friendCount; ++var9) {
                     Friend var27 = Client.friends[var9];
                     if(!var1) {
                        if(var22.equals(var27.name)) {
                           if(var19 != var27.world) {
                              var11 = true;

                              for(class16 var28 = (class16)Client.field562.method2367(); var28 != null; var28 = (class16)Client.field562.method2368()) {
                                 if(var28.field182.equals(var22)) {
                                    if(var19 != 0 && var28.field183 == 0) {
                                       var28.method2373();
                                       var11 = false;
                                    } else if(var19 == 0 && var28.field183 != 0) {
                                       var28.method2373();
                                       var11 = false;
                                    }
                                 }
                              }

                              if(var11) {
                                 Client.field562.method2366(new class16(var22, var19));
                              }

                              var27.world = var19;
                           }

                           var27.previousName = var18;
                           var27.rank = var5;
                           var27.field161 = var7;
                           var27.field166 = var8;
                           var22 = null;
                           break;
                        }
                     } else if(var18.equals(var27.name)) {
                        var27.name = var22;
                        var27.previousName = var18;
                        var22 = null;
                        break;
                     }
                  }

                  if(null != var22 && Client.friendCount < 400) {
                     Friend var26 = new Friend();
                     Client.friends[Client.friendCount] = var26;
                     var26.name = var22;
                     var26.previousName = var18;
                     var26.world = var19;
                     var26.rank = var5;
                     var26.field161 = var7;
                     var26.field166 = var8;
                     ++Client.friendCount;
                  }
               }

               Client.field506 = 2;
               Client.field484 = Client.field358;
               var1 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var1 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var76 = false;
                     Friend var20 = Client.friends[var3];
                     Friend var6 = Client.friends[var3 + 1];
                     if(Client.world != var20.world && Client.world == var6.world) {
                        var76 = true;
                     }

                     if(!var76 && var20.world == 0 && var6.world != 0) {
                        var76 = true;
                     }

                     if(!var76 && !var20.field161 && var6.field161) {
                        var76 = true;
                     }

                     if(!var76 && !var20.field166 && var6.field166) {
                        var76 = true;
                     }

                     if(var76) {
                        Friend var25 = Client.friends[var3];
                        Client.friends[var3] = Client.friends[1 + var3];
                        Client.friends[var3 + 1] = var25;
                        var1 = false;
                     }
                  }

                  if(var1) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            NPC.method695("" + Client.packetOpcode + "," + Client.field552 + "," + Client.field345 + "," + Client.field339, (Throwable)null);
            CombatInfoListHolder.method692();
         } catch (IOException var41) {
            class105.method1961();
         } catch (Exception var42) {
            var21 = "" + Client.packetOpcode + "," + Client.field552 + "," + Client.field345 + "," + Client.field339 + "," + (XItemContainer.localPlayer.pathX[0] + class22.baseX) + "," + (class103.baseY + XItemContainer.localPlayer.pathY[0]) + ",";

            for(var2 = 0; var2 < Client.field339 && var2 < 50; ++var2) {
               var21 = var21 + Client.field352.payload[var2] + ",";
            }

            NPC.method695(var21, var42);
            CombatInfoListHolder.method692();
         }

         return true;
      }
   }
}
