import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1555597925
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("i")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2096401643
   )
   @Export("width")
   public int width;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 8398139
   )
   @Export("height")
   public int height;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-884846344"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "61"
   )
   public abstract void vmethod4917(int var1, int var2);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   public abstract void vmethod4910(int var1, int var2, int var3, int var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfv;S)V",
      garbageValue = "3934"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class226.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field901 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class21.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class164.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class10.plane = var2.field896 = var4;
      if(class96.field1475[var1] != null) {
         var2.decodeApperance(class96.field1475[var1]);
      }

      class96.field1469 = 0;
      class96.field1470[++class96.field1469 - 1] = var1;
      class96.field1466[var1] = 0;
      class96.field1476 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1473[var7] = (var10 << 14) + var11 + (var9 << 28);
            class96.field1474[var7] = 0;
            class96.field1471[var7] = -1;
            class96.field1472[++class96.field1476 - 1] = var7;
            class96.field1466[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
