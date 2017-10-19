import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class11 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class11 field276;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   public static final class11 field275;
   @ObfuscatedName("oi")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   static class100 field278;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   static SpritePixels[] field274;

   static {
      field276 = new class11();
      field275 = new class11();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "154522386"
   )
   static int method60(int var0, int var1) {
      Overlay var2 = class18.method135(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var3;
         int var4;
         if(var2.texture >= 0) {
            var4 = Graphics3D.textureLoader.getAverageTextureRGB(var2.texture);
            byte var5 = 96;
            if(var4 == -2) {
               var3 = 12345678;
            } else {
               int var7;
               if(var4 == -1) {
                  if(var5 < 0) {
                     var5 = 0;
                  } else if(var5 > 127) {
                     var5 = 127;
                  }

                  var7 = 127 - var5;
                  var3 = var7;
               } else {
                  var7 = var5 * (var4 & 127) / 128;
                  if(var7 < 2) {
                     var7 = 2;
                  } else if(var7 > 126) {
                     var7 = 126;
                  }

                  var3 = var7 + (var4 & 65408);
               }
            }

            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var3 = ClanMember.method1139(var2.hue, var2.saturation, var2.lightness);
            var4 = class25.method189(var3, 96);
            return Graphics3D.colorPalette[var4] | -16777216;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "615015896"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class66.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field913 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class22.baseX * 411265;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class273.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class46.plane = var2.field908 = var4;
      if(class94.field1488[var1] != null) {
         var2.decodeApperance(class94.field1488[var1]);
      }

      class94.playerIndexesCount = 0;
      class94.playerIndices[++class94.playerIndexesCount - 1] = var1;
      class94.field1497[var1] = 0;
      class94.field1491 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class94.field1493[var7] = (var10 << 14) + var11 + (var9 << 28);
            class94.field1494[var7] = 0;
            class94.field1495[var7] = -1;
            class94.field1492[++class94.field1491 - 1] = var7;
            class94.field1497[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
