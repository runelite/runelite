import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("d")
   @Export("image")
   public Image image;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -255137587
   )
   @Export("width")
   public int width;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2063529473
   )
   @Export("height")
   int height;
   @ObfuscatedName("g")
   @Export("pixels")
   public int[] pixels;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1463526776"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1491362525"
   )
   public final void method4062() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1403873771"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "-82"
   )
   public abstract void draw(Graphics var1, int var2, int var3);
}
