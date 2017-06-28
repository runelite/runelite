import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class23 {
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1653174405
   )
   static int field367;

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "735988100"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class220.field2817.method824();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field938 = 0;
            Client.field939 = 0;
         }

         if(var0 != 20 && var0 != 40 && class222.field2846 != null) {
            class222.field2846.close();
            class222.field2846 = null;
         }

         if(Client.gameState == 25) {
            Client.field1113 = 0;
            Client.field1117 = 0;
            Client.field961 = 1;
            Client.field1127 = 0;
            Client.field1023 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class123.method2261(FileOnDisk.field1763, WorldMapType3.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class123.method2261(FileOnDisk.field1763, WorldMapType3.indexSprites, false, 4);
            } else if(class92.field1422) {
               class92.field1415 = null;
               class92.field1447 = null;
               class35.field503 = null;
               class37.field519 = null;
               class92.field1419 = null;
               class92.field1416 = null;
               class92.field1423 = null;
               class21.field351 = null;
               FrameMap.field2055 = null;
               class230.field3188 = null;
               class92.field1418 = null;
               class47.field613 = null;
               WorldMapData.field471 = null;
               Signlink.field2253 = null;
               class48.field629 = null;
               class43.field583 = null;
               XClanMember.field897 = null;
               class277.field3736 = null;
               class14.field296 = null;
               Script.field1536 = null;
               class10.field268 = null;
               class170.field2360 = null;
               class203.field2517 = 1;
               class203.field2518 = null;
               class203.field2519 = -1;
               class29.field438 = -1;
               class182.field2455 = 0;
               class88.field1384 = false;
               CollisionData.field2304 = 2;
               class169.method3002(true);
               class92.field1422 = false;
            }
         } else {
            class123.method2261(FileOnDisk.field1763, WorldMapType3.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }

   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1553017474"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.readUnsignedShort();
         int var7 = Client.secretPacketBuffer2.readUnsignedShortOb1();
         var2 = Client.secretPacketBuffer2.readUnsignedShort();
         class36.xteaKeys = new int[var2][4];

         for(var3 = 0; var3 < var2; ++var3) {
            for(var4 = 0; var4 < 4; ++var4) {
               class36.xteaKeys[var3][var4] = Client.secretPacketBuffer2.readInt();
            }
         }

         class13.mapRegions = new int[var2];
         WallObject.field2143 = new int[var2];
         class168.field2352 = new int[var2];
         WidgetNode.field814 = new byte[var2][];
         class40.field554 = new byte[var2][];
         boolean var8 = false;
         if((var7 / 8 == 48 || var7 / 8 == 49) && var1 / 8 == 48) {
            var8 = true;
         }

         if(var7 / 8 == 48 && var1 / 8 == 148) {
            var8 = true;
         }

         var2 = 0;

         for(var4 = (var7 - 6) / 8; var4 <= (var7 + 6) / 8; ++var4) {
            for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
               var6 = (var4 << 8) + var5;
               if(!var8 || var5 != 49 && var5 != 149 && var5 != 147 && var4 != 50 && (var4 != 49 || var5 != 47)) {
                  class13.mapRegions[var2] = var6;
                  WallObject.field2143[var2] = class177.indexMaps.method4055("m" + var4 + "_" + var5);
                  class168.field2352[var2] = class177.indexMaps.method4055("l" + var4 + "_" + var5);
                  ++var2;
               }
            }
         }

         class2.method5(var7, var1, true);
      } else {
         var1 = Client.secretPacketBuffer2.readShortLE();
         boolean var14 = Client.secretPacketBuffer2.readByteOb1() == 1;
         var2 = Client.secretPacketBuffer2.readShortLE();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.method3291();

         int var15;
         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var15 = Client.secretPacketBuffer2.method3290(1);
                  if(var15 == 1) {
                     Client.field967[var4][var5][var6] = Client.secretPacketBuffer2.method3290(26);
                  } else {
                     Client.field967[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.method3292();
         class36.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class36.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         class13.mapRegions = new int[var3];
         WallObject.field2143 = new int[var3];
         class168.field2352 = new int[var3];
         WidgetNode.field814 = new byte[var3][];
         class40.field554 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var15 = Client.field967[var4][var5][var6];
                  if(var15 != -1) {
                     int var9 = var15 >> 14 & 1023;
                     int var10 = var15 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var3; ++var12) {
                        if(var11 == class13.mapRegions[var12]) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class13.mapRegions[var3] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        WallObject.field2143[var3] = class177.indexMaps.method4055("m" + var12 + "_" + var13);
                        class168.field2352[var3] = class177.indexMaps.method4055("l" + var12 + "_" + var13);
                        ++var3;
                     }
                  }
               }
            }
         }

         class2.method5(var2, var1, !var14);
      }

   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2048750341"
   )
   static void method189(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(84);
      Client.secretPacketBuffer1.method3057(var0);
      Client.secretPacketBuffer1.putShortLE(var1);
   }
}
