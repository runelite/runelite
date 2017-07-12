import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class1 {
   @ObfuscatedName("i")
   static final class1 field12;
   @ObfuscatedName("w")
   static final class1 field1;
   @ObfuscatedName("a")
   static final class1 field2;
   @ObfuscatedName("t")
   static final class1 field3;
   @ObfuscatedName("s")
   static final class1 field4;
   @ObfuscatedName("r")
   static final class1 field7;
   @ObfuscatedName("v")
   static final class1 field6;
   @ObfuscatedName("cy")
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2104836075
   )
   final int field0;

   static {
      field12 = new class1(6);
      field1 = new class1(3);
      field2 = new class1(4);
      field3 = new class1(5);
      field4 = new class1(1);
      field7 = new class1(0);
      field6 = new class1(2);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "6"
   )
   class1(int var1) {
      this.field0 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2085047510"
   )
   static void method3() {
      FileOnDisk var0 = null;

      try {
         var0 = class22.getPreferencesFile("", Client.field1207.field3203, true);
         Buffer var1 = class8.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "819949076"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.worldServersDownload == null) {
            World.worldServersDownload = new class77(GameEngine.taskManager, new URL(WorldMapType1.field443));
         } else {
            byte[] var0 = World.worldServersDownload.method1530();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.worldCount = var1.readUnsignedShort();
               World.worldList = new World[World.worldCount];

               World var3;
               for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class9.method48(World.worldList, 0, World.worldList.length - 1, World.field1312, World.field1318);
               World.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-2032702023"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = Player.method1179(var0, Client.field928);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(Player.method1179(var3.name, Client.field928))) {
               return true;
            }

            if(var1.equalsIgnoreCase(Player.method1179(var3.previousName, Client.field928))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1759114909"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.readByteOb1();
         var2 = Client.secretPacketBuffer2.readByteOb1();
         int var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class28.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class28.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         RSCanvas.mapRegions = new int[var3];
         WorldMapType3.field394 = new int[var3];
         class45.landRegionFielIds = new int[var3];
         ISAACCipher.field2429 = new byte[var3][];
         class14.field290 = new byte[var3][];
         boolean var15 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var15 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  RSCanvas.mapRegions[var3] = var7;
                  WorldMapType3.field394[var3] = Frames.indexMaps.getFile("m" + var5 + "_" + var6);
                  class45.landRegionFielIds[var3] = Frames.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class112.method2095(var2, var1, true);
      } else {
         var1 = Client.secretPacketBuffer2.readUnsignedShortOb1();
         var2 = Client.secretPacketBuffer2.readByteOb1();
         boolean var14 = Client.secretPacketBuffer2.method3292() == 1;
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field988[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field988[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         class28.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class28.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         RSCanvas.mapRegions = new int[var4];
         WorldMapType3.field394 = new int[var4];
         class45.landRegionFielIds = new int[var4];
         ISAACCipher.field2429 = new byte[var4][];
         class14.field290 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field988[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(RSCanvas.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        RSCanvas.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        WorldMapType3.field394[var4] = Frames.indexMaps.getFile("m" + var12 + "_" + var13);
                        class45.landRegionFielIds[var4] = Frames.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class112.method2095(var2, var1, !var14);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1040582916"
   )
   static void method0() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1369057479"
   )
   static final void method5(Actor var0) {
      if(var0.field1291 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1265) {
               var0.interacting = -1;
               var0.field1265 = false;
            }
         }

         if(var0.field1266 != -1 && (var0.queueSize == 0 || var0.field1275 > 0)) {
            var0.orientation = var0.field1266;
            var0.field1266 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1265) {
            var0.interacting = -1;
            var0.field1265 = false;
         }

         if(var4 != 0) {
            ++var0.field1252;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1291;
               var6 = true;
               if(var4 < var0.field1291 || var4 > 2048 - var0.field1291) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1252 > 25 || var6)) {
                  if(var0.field1290 != -1) {
                     var0.poseAnimation = var0.field1290;
                  } else {
                     var0.poseAnimation = var0.field1246;
                  }
               }
            } else {
               var0.angle += var0.field1291;
               var6 = true;
               if(var4 < var0.field1291 || var4 > 2048 - var0.field1291) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1252 > 25 || var6)) {
                  if(var0.field1245 != -1) {
                     var0.poseAnimation = var0.field1245;
                  } else {
                     var0.poseAnimation = var0.field1246;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1252 = 0;
         }

      }
   }
}
