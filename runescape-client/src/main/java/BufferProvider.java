import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("a")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1503332087
   )
   @Export("width")
   public int width;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1176603385
   )
   @Export("height")
   public int height;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1929255166"
   )
   @Export("setRaster")
   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1632462844"
   )
   public abstract void vmethod4967(int var1, int var2);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-5"
   )
   public abstract void vmethod4971(int var1, int var2, int var3, int var4);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lii;II)Ljx;",
      garbageValue = "560785404"
   )
   public static IndexedSprite method4960(IndexDataBase var0, int var1) {
      if(!FrameMap.method2710(var0, var1)) {
         return null;
      } else {
         IndexedSprite var3 = new IndexedSprite();
         var3.width = class287.field3797;
         var3.originalHeight = class287.field3798;
         var3.offsetX = class271.field3679[0];
         var3.offsetY = class18.offsetsY[0];
         var3.originalWidth = class287.field3796[0];
         var3.height = class245.field3324[0];
         var3.palette = Varbit.field3387;
         var3.pixels = class274.spritePixels[0];
         Buffer.method3330();
         return var3;
      }
   }
}
