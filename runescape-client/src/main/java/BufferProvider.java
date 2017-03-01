import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("y")
   @Export("image")
   public Image image;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 366257329
   )
   @Export("width")
   public int width;
   @ObfuscatedName("bt")
   @Export("host")
   static String host;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 980167831
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @Export("pixels")
   public int[] pixels;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "73630336"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1396617588"
   )
   public final void method4098() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "891005987"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-656201964"
   )
   public abstract void draw(Graphics var1, int var2, int var3);
}
