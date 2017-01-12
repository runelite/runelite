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
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1662906089
   )
   @Export("height")
   int height;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -262303787
   )
   @Export("width")
   public int width;
   @ObfuscatedName("x")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("f")
   @Export("image")
   public Image image;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-593792580"
   )
   public final void method4046() {
      class219.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "49"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1846076808"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "119912113"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);
}
