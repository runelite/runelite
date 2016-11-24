import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("w")
   @Export("image")
   public Image image;
   @ObfuscatedName("d")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1791533333
   )
   @Export("height")
   int height;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1805400153
   )
   @Export("width")
   public int width;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-38"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1063163087"
   )
   public final void method4112() {
      class219.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1512190862"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-40"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);
}
