import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("w")
   @Export("image")
   public Image image;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1400969369
   )
   @Export("width")
   public int width;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 880527275
   )
   @Export("height")
   int height;
   @ObfuscatedName("y")
   @Export("pixels")
   public int[] pixels;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "0"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-75"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "115"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   public final void method4046() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "1701695852"
   )
   static SpritePixels[] method4055() {
      SpritePixels[] var0 = new SpritePixels[class225.field3216];

      for(int var1 = 0; var1 < class225.field3216; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class225.field3212;
         var2.maxHeight = class225.field3213;
         var2.offsetX = class163.field2287[var1];
         var2.offsetY = class225.field3214[var1];
         var2.width = class47.field932[var1];
         var2.height = class225.field3211[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = class225.field3218[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class225.field3215[var4[var5] & 255];
         }
      }

      class221.method4056();
      return var0;
   }
}
