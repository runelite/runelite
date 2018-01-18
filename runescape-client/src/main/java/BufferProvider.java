import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("y")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1852809795
   )
   @Export("width")
   public int width;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 116038231
   )
   @Export("height")
   public int height;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1348763863"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-128"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1860461639"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lil;Ljava/lang/String;Ljava/lang/String;B)[Lkm;",
      garbageValue = "-121"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return AbstractSoundSystem.method2112(var0, var3, var4);
   }
}
