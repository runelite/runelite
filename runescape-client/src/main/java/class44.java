import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class44 {
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -2057153965
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 648272895
   )
   int field569;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -438353643
   )
   int field566;
   @ObfuscatedName("n")
   int[][] field572;
   @ObfuscatedName("r")
   int[][] field568;
   @ObfuscatedName("e")
   int[][] field565;
   @ObfuscatedName("y")
   int[][] field570;

   class44(int var1, int var2) {
      this.field569 = var1;
      this.field566 = var2;
      this.field572 = new int[var1][var2];
      this.field568 = new int[var1][var2];
      this.field565 = new int[var1][var2];
      this.field570 = new int[var1][var2];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILjy;B)V",
      garbageValue = "0"
   )
   void method626(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field569 && var2 - var3 <= this.field566) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field569, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field566, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field572[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field568[var9][var10] += var4.saturation;
                     this.field565[var9][var10] += var4.lightness;
                     ++this.field570[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-38"
   )
   int method628(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field569 && var2 < this.field566) {
         if(this.field565[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field572[var1][var2] / this.field570[var1][var2];
            int var4 = this.field568[var1][var2] / this.field570[var1][var2];
            int var5 = this.field565[var1][var2] / this.field570[var1][var2];
            return GraphicsObject.method1845((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   static final void method629() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if(Client.field927 == 0) {
         var0 = TotalQuantityComparator.localPlayer.x;
         var1 = TotalQuantityComparator.localPlayer.y;
         if(WorldMapType1.field443 - var0 < -500 || WorldMapType1.field443 - var0 > 500 || class171.field2218 - var1 < -500 || class171.field2218 - var1 > 500) {
            WorldMapType1.field443 = var0;
            class171.field2218 = var1;
         }

         if(var0 != WorldMapType1.field443) {
            WorldMapType1.field443 += (var0 - WorldMapType1.field443) / 16;
         }

         if(var1 != class171.field2218) {
            class171.field2218 += (var1 - class171.field2218) / 16;
         }

         var2 = WorldMapType1.field443 >> 7;
         var3 = class171.field2218 >> 7;
         var4 = class35.getTileHeight(WorldMapType1.field443, class171.field2218, class36.plane);
         var5 = 0;
         int var6;
         if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = class36.plane;
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

         if(var6 > Client.field936) {
            Client.field936 += (var6 - Client.field936) / 24;
         } else if(var6 < Client.field936) {
            Client.field936 += (var6 - Client.field936) / 80;
         }

         MapLabel.field476 = class35.getTileHeight(TotalQuantityComparator.localPlayer.x, TotalQuantityComparator.localPlayer.y, class36.plane) - Client.field928;
      } else if(Client.field927 == 1) {
         if(Client.field933 && TotalQuantityComparator.localPlayer != null) {
            var0 = TotalQuantityComparator.localPlayer.pathX[0];
            var1 = TotalQuantityComparator.localPlayer.pathY[0];
            if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               WorldMapType1.field443 = TotalQuantityComparator.localPlayer.x;
               MapLabel.field476 = class35.getTileHeight(TotalQuantityComparator.localPlayer.x, TotalQuantityComparator.localPlayer.y, class36.plane) - Client.field928;
               class171.field2218 = TotalQuantityComparator.localPlayer.y;
               Client.field933 = false;
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
            var2 = KeyFocusListener.keyPressed[81]?128:64;
            Client.field897 = var10;
            Client.field931 = var11;
         }

         if(Client.field892 < var2) {
            Client.field892 += var2 / 8;
            if(Client.field892 > var2) {
               Client.field892 = var2;
            }
         } else if(Client.field892 > var2) {
            Client.field892 = Client.field892 * 9 / 10;
         }

         if(Client.field892 > 0) {
            var3 = Client.field892 / 16;
            if(Client.field897 >= 0) {
               var0 = Client.field897 - IndexDataBase.cameraYaw & 2047;
               var4 = Graphics3D.SINE[var0];
               var5 = Graphics3D.COSINE[var0];
               WorldMapType1.field443 += var3 * var4 / 65536;
               class171.field2218 += var5 * var3 / 65536;
            }

            if(Client.field931 != 0) {
               MapLabel.field476 += var3 * Client.field931;
               if(MapLabel.field476 > 0) {
                  MapLabel.field476 = 0;
               }
            }
         } else {
            Client.field897 = -1;
            Client.field931 = -1;
         }

         if(KeyFocusListener.keyPressed[13]) {
            BaseVarType.method12();
         }
      }

      if(MouseInput.mouseCurrentButton == 4 && Enum.middleMouseMovesCamera) {
         var0 = MouseInput.mouseLastY - Client.field926;
         Client.field1096 = var0 * 2;
         Client.field926 = var0 != -1 && var0 != 1?(MouseInput.mouseLastY + Client.field926) / 2:MouseInput.mouseLastY;
         var1 = Client.field925 - MouseInput.mouseLastX;
         Client.field923 = var1 * 2;
         Client.field925 = var1 != -1 && var1 != 1?(MouseInput.mouseLastX + Client.field925) / 2:MouseInput.mouseLastX;
      } else {
         if(KeyFocusListener.keyPressed[96]) {
            Client.field923 += (-24 - Client.field923) / 2;
         } else if(KeyFocusListener.keyPressed[97]) {
            Client.field923 += (24 - Client.field923) / 2;
         } else {
            Client.field923 /= 2;
         }

         if(KeyFocusListener.keyPressed[98]) {
            Client.field1096 += (12 - Client.field1096) / 2;
         } else if(KeyFocusListener.keyPressed[99]) {
            Client.field1096 += (-12 - Client.field1096) / 2;
         } else {
            Client.field1096 /= 2;
         }

         Client.field926 = MouseInput.mouseLastY;
         Client.field925 = MouseInput.mouseLastX;
      }

      Client.mapAngle = Client.field923 / 2 + Client.mapAngle & 2047;
      Client.cameraPitchTarget += Client.field1096 / 2;
      if(Client.cameraPitchTarget < 128) {
         Client.cameraPitchTarget = 128;
      }

      if(Client.cameraPitchTarget > 383) {
         Client.cameraPitchTarget = 383;
      }

   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-302618462"
   )
   static String method625(String var0) {
      Permission[] var1 = class241.method4552();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Permission var3 = var1[var2];
         if(var3.field3338 != -1 && var0.startsWith(GameCanvas.method796(var3.field3338))) {
            var0 = var0.substring(6 + Integer.toString(var3.field3338).length());
            break;
         }
      }

      return var0;
   }
}
