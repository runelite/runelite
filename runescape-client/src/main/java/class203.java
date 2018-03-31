import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class203 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   static IndexedSprite field2605;

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1363821788"
   )
   static final void method3842() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if(Client.field930 == 0) {
         var0 = WorldComparator.localPlayer.x;
         var1 = WorldComparator.localPlayer.y;
         if(class190.field2522 - var0 < -500 || class190.field2522 - var0 > 500 || NetWriter.field1474 - var1 < -500 || NetWriter.field1474 - var1 > 500) {
            class190.field2522 = var0;
            NetWriter.field1474 = var1;
         }

         if(var0 != class190.field2522) {
            class190.field2522 += (var0 - class190.field2522) / 16;
         }

         if(var1 != NetWriter.field1474) {
            NetWriter.field1474 += (var1 - NetWriter.field1474) / 16;
         }

         var2 = class190.field2522 >> 7;
         var3 = NetWriter.field1474 >> 7;
         var4 = class5.getTileHeight(class190.field2522, NetWriter.field1474, class237.plane);
         var5 = 0;
         int var6;
         if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = class237.plane;
                  if(var8 < 3 && (class62.tileSettings[1][var6][var7] & 2) == 2) {
                     ++var8;
                  }

                  int var9 = var4 - class62.tileHeights[var8][var6][var7];
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

         if(var6 < 32768) {
            var6 = 32768;
         }

         if(var6 > Client.field941) {
            Client.field941 += (var6 - Client.field941) / 24;
         } else if(var6 < Client.field941) {
            Client.field941 += (var6 - Client.field941) / 80;
         }

         Area.field3457 = class5.getTileHeight(WorldComparator.localPlayer.x, WorldComparator.localPlayer.y, class237.plane) - Client.field931;
      } else if(Client.field930 == 1) {
         if(Client.field938 && WorldComparator.localPlayer != null) {
            var0 = WorldComparator.localPlayer.pathX[0];
            var1 = WorldComparator.localPlayer.pathY[0];
            if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               class190.field2522 = WorldComparator.localPlayer.x;
               var2 = class5.getTileHeight(WorldComparator.localPlayer.x, WorldComparator.localPlayer.y, class237.plane) - Client.field931;
               if(var2 < Area.field3457) {
                  Area.field3457 = var2;
               }

               NetWriter.field1474 = WorldComparator.localPlayer.y;
               Client.field938 = false;
            }
         }

         short var10 = -1;
         if(KeyFocusListener.keyPressed[33]) {
            var10 = 0;
         } else if(KeyFocusListener.keyPressed[49]) {
            var10 = 1024;
         }

         if(KeyFocusListener.keyPressed[48]) {
            if(var10 == 0) {
               var10 = 1792;
            } else if(var10 == 1024) {
               var10 = 1280;
            } else {
               var10 = 1536;
            }
         } else if(KeyFocusListener.keyPressed[50]) {
            if(var10 == 0) {
               var10 = 256;
            } else if(var10 == 1024) {
               var10 = 768;
            } else {
               var10 = 512;
            }
         }

         byte var11 = 0;
         if(KeyFocusListener.keyPressed[35]) {
            var11 = -1;
         } else if(KeyFocusListener.keyPressed[51]) {
            var11 = 1;
         }

         var2 = 0;
         if(var10 >= 0 || var11 != 0) {
            var2 = KeyFocusListener.keyPressed[81]?Client.field936:Client.field935;
            var2 *= 16;
            Client.field933 = var10;
            Client.field934 = var11;
         }

         if(Client.field932 < var2) {
            Client.field932 += var2 / 8;
            if(Client.field932 > var2) {
               Client.field932 = var2;
            }
         } else if(Client.field932 > var2) {
            Client.field932 = Client.field932 * 9 / 10;
         }

         if(Client.field932 > 0) {
            var3 = Client.field932 / 16;
            if(Client.field933 >= 0) {
               var0 = Client.field933 - ClientPacket.cameraYaw & 2047;
               var4 = Graphics3D.SINE[var0];
               var5 = Graphics3D.COSINE[var0];
               class190.field2522 += var4 * var3 / 65536;
               NetWriter.field1474 += var3 * var5 / 65536;
            }

            if(Client.field934 != 0) {
               Area.field3457 += var3 * Client.field934;
               if(Area.field3457 > 0) {
                  Area.field3457 = 0;
               }
            }
         } else {
            Client.field933 = -1;
            Client.field934 = -1;
         }

         if(KeyFocusListener.keyPressed[13]) {
            FaceNormal.method3076();
         }
      }

      if(MouseInput.mouseCurrentButton == 4 && WorldMapData.middleMouseMovesCamera) {
         var0 = MouseInput.mouseLastY - Client.field929;
         Client.field1116 = var0 * 2;
         Client.field929 = var0 != -1 && var0 != 1?(Client.field929 + MouseInput.mouseLastY) / 2:MouseInput.mouseLastY;
         var1 = Client.field928 - MouseInput.mouseLastX;
         Client.field913 = var1 * 2;
         Client.field928 = var1 != -1 && var1 != 1?(Client.field928 + MouseInput.mouseLastX) / 2:MouseInput.mouseLastX;
      } else {
         if(KeyFocusListener.keyPressed[96]) {
            Client.field913 += (-24 - Client.field913) / 2;
         } else if(KeyFocusListener.keyPressed[97]) {
            Client.field913 += (24 - Client.field913) / 2;
         } else {
            Client.field913 /= 2;
         }

         if(KeyFocusListener.keyPressed[98]) {
            Client.field1116 += (12 - Client.field1116) / 2;
         } else if(KeyFocusListener.keyPressed[99]) {
            Client.field1116 += (-12 - Client.field1116) / 2;
         } else {
            Client.field1116 /= 2;
         }

         Client.field929 = MouseInput.mouseLastY;
         Client.field928 = MouseInput.mouseLastX;
      }

      Client.mapAngle = Client.field913 / 2 + Client.mapAngle & 2047;
      Client.cameraPitchTarget += Client.field1116 / 2;
      if(Client.cameraPitchTarget < 128) {
         Client.cameraPitchTarget = 128;
      }

      if(Client.cameraPitchTarget > 383) {
         Client.cameraPitchTarget = 383;
      }

   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2014625215"
   )
   static final void method3843() {
      PacketNode var0 = FaceNormal.method3078(ClientPacket.field2417, Client.field902.field1475);
      var0.packetBuffer.putByte(0);
      Client.field902.method2036(var0);
   }
}
