import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("r")
   @Export("image")
   public Image image;
   @ObfuscatedName("i")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -247355405
   )
   @Export("height")
   int height;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -911386969
   )
   @Export("width")
   public int width;
   @ObfuscatedName("m")
   static byte[][] field3199;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-15"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1744897673"
   )
   public final void method4072() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "6166627"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "106"
   )
   public abstract void draw(Graphics var1, int var2, int var3);
}
