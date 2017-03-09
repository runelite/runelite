import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1471451735
   )
   @Export("width")
   public int width;
   @ObfuscatedName("j")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1966302835
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @Export("image")
   public Image image;
   @ObfuscatedName("ca")
   static Font field3198;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-975875046"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "-63"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-550155191"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "923656862"
   )
   public final void method4084() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}
