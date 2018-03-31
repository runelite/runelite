import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("o")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1927789777
   )
   @Export("width")
   public int width;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 920466167
   )
   @Export("height")
   public int height;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1667435857"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "383662295"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-905436369"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljm;III)Lla;",
      garbageValue = "1724582313"
   )
   public static SpritePixels method5831(IndexDataBase var0, int var1, int var2) {
      return !class288.method5204(var0, var1, var2)?null:WorldMapDecorationType.method4517();
   }
}
