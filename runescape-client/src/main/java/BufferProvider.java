import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 642884911
   )
   @Export("width")
   public int width;
   @ObfuscatedName("k")
   @Export("image")
   public Image image;
   @ObfuscatedName("l")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 735009983
   )
   @Export("height")
   int height;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-636025927"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1899256578"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "454515581"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   public final void method4171() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}
