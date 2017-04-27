import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("t")
   @Export("image")
   public Image image;
   @ObfuscatedName("c")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 794665399
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -273697131
   )
   @Export("width")
   public int width;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1468205805"
   )
   public final void method4147() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "760519699"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "617664203"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "23"
   )
   abstract void init(int var1, int var2, Component var3);
}
