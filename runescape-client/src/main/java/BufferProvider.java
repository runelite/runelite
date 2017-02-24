import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("d")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -406521835
   )
   @Export("height")
   int height;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1623651349
   )
   @Export("width")
   public int width;
   @ObfuscatedName("j")
   @Export("image")
   public Image image;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1372728796"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-529215329"
   )
   public final void method4085() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1953981379"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "870035480"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);
}
