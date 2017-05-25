import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public final class class60 {
   @ObfuscatedName("w")
   static String field735;
   @ObfuscatedName("m")
   static String[] field736;
   @ObfuscatedName("p")
   static ScheduledExecutorService field737;
   @ObfuscatedName("i")
   public static IndexDataBase field738;

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1232402371"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.method3245();
         int var2 = Client.secretPacketBuffer2.method3236();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class22.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class22.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         RSCanvas.mapRegions = new int[var3];
         class168.field2317 = new int[var3];
         class100.field1545 = new int[var3];
         class32.field461 = new byte[var3][];
         class50.field619 = new byte[var3][];
         boolean var15 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var15 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  RSCanvas.mapRegions[var3] = var7;
                  class168.field2317[var3] = class34.indexMaps.method4189("m" + var5 + "_" + var6);
                  class100.field1545[var3] = class34.indexMaps.method4189("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         ScriptState.method1081(var1, var2, true);
      } else {
         var1 = Client.secretPacketBuffer2.readUnsignedShort();
         boolean var14 = Client.secretPacketBuffer2.method3260() == 1;
         var3 = Client.secretPacketBuffer2.method3236();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.method3469();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.method3470(1);
                  if(var8 == 1) {
                     Client.field1076[var5][var6][var7] = Client.secretPacketBuffer2.method3470(26);
                  } else {
                     Client.field1076[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.method3466();
         class22.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class22.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         RSCanvas.mapRegions = new int[var4];
         class168.field2317 = new int[var4];
         class100.field1545 = new int[var4];
         class32.field461 = new byte[var4][];
         class50.field619 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field1076[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = var10 / 8 + (var9 / 8 << 8);

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(var11 == RSCanvas.mapRegions[var12]) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        RSCanvas.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        class168.field2317[var4] = class34.indexMaps.method4189("m" + var12 + "_" + var13);
                        class100.field1545[var4] = class34.indexMaps.method4189("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         ScriptState.method1081(var1, var3, !var14);
      }

   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "915891397"
   )
   static final void method1034() {
      int var0 = Client.field1061 + XGrandExchangeOffer.localPlayer.x;
      int var1 = Client.field956 + XGrandExchangeOffer.localPlayer.y;
      if(class34.field487 - var0 < -500 || class34.field487 - var0 > 500 || class31.field439 - var1 < -500 || class31.field439 - var1 > 500) {
         class34.field487 = var0;
         class31.field439 = var1;
      }

      if(var0 != class34.field487) {
         class34.field487 += (var0 - class34.field487) / 16;
      }

      if(var1 != class31.field439) {
         class31.field439 += (var1 - class31.field439) / 16;
      }

      int var2;
      int var3;
      if(class59.field732 == 4 && class149.field2178) {
         var2 = class59.field722 - Client.field1004;
         Client.field1029 = var2 * 2;
         Client.field1004 = var2 != -1 && var2 != 1?(Client.field1004 + class59.field722) / 2:class59.field722;
         var3 = Client.field977 - class59.field721;
         Client.field975 = var3 * 2;
         Client.field977 = var3 != -1 && var3 != 1?(class59.field721 + Client.field977) / 2:class59.field721;
      } else {
         if(class50.field624[96]) {
            Client.field975 += (-24 - Client.field975) / 2;
         } else if(class50.field624[97]) {
            Client.field975 += (24 - Client.field975) / 2;
         } else {
            Client.field975 /= 2;
         }

         if(class50.field624[98]) {
            Client.field1029 += (12 - Client.field1029) / 2;
         } else if(class50.field624[99]) {
            Client.field1029 += (-12 - Client.field1029) / 2;
         } else {
            Client.field1029 /= 2;
         }

         Client.field1004 = class59.field722;
         Client.field977 = class59.field721;
      }

      Client.mapAngle = Client.field975 / 2 + Client.mapAngle & 2047;
      Client.field973 += Client.field1029 / 2;
      if(Client.field973 < 128) {
         Client.field973 = 128;
      }

      if(Client.field973 > 383) {
         Client.field973 = 383;
      }

      var2 = class34.field487 >> 7;
      var3 = class31.field439 >> 7;
      int var4 = Ignore.method1119(class34.field487, class31.field439, Sequence.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = Sequence.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field982) {
         Client.field982 += (var6 - Client.field982) / 24;
      } else if(var6 < Client.field982) {
         Client.field982 += (var6 - Client.field982) / 80;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-266316709"
   )
   public static boolean method1035(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-631784440"
   )
   static void method1036() {
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.field936 = -1;
      Client.field1164 = -1;
      Client.field1070 = -1;
      Client.field978 = -1;
      Client.packetLength = 0;
      Client.field937 = 0;
      Client.field906 = 0;
      RSCanvas.method776();
      Client.field1017 = 0;
      Client.flagX = 0;

      int var2;
      for(var2 = 0; var2 < 2048; ++var2) {
         Client.cachedPlayers[var2] = null;
      }

      XGrandExchangeOffer.localPlayer = null;

      for(var2 = 0; var2 < Client.cachedNPCs.length; ++var2) {
         NPC var3 = Client.cachedNPCs[var2];
         if(var3 != null) {
            var3.interacting = -1;
            var3.field1249 = false;
         }
      }

      class208.method3967();
      class12.setGameState(30);

      for(var2 = 0; var2 < 100; ++var2) {
         Client.field1095[var2] = true;
      }

      Client.secretPacketBuffer1.putOpcode(149);
      PacketBuffer var0 = Client.secretPacketBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretPacketBuffer1.putShort(class261.field3626);
      Client.secretPacketBuffer1.putShort(class19.field320);
   }
}
