import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("MainBufferProvider")
public final class MainBufferProvider extends BufferProvider {
   @ObfuscatedName("d")
   Component field657;
   @ObfuscatedName("x")
   @Export("image")
   Image image;

   MainBufferProvider(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, (Point)null);
      this.image = new BufferedImage(var5, var6, false, new Hashtable());
      this.method838(var3);
      this.setRaster();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   final void method838(Component var1) {
      this.field657 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1675289646"
   )
   public final void vmethod5222(int var1, int var2) {
      this.draw(this.field657.getGraphics(), var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1986712912"
   )
   public final void vmethod5225(int var1, int var2, int var3, int var4) {
      this.drawSub(this.field657.getGraphics(), var1, var2, var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1496008765"
   )
   @Export("draw")
   @Hook("draw")
   final void draw(Graphics var1, int var2, int var3) {
      try {
         var1.drawImage(this.image, var2, var3, this.field657);
      } catch (Exception var5) {
         this.field657.repaint();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "1282376478"
   )
   @Export("drawSub")
   final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      try {
         Shape var6 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.image, 0, 0, this.field657);
         var1.setClip(var6);
      } catch (Exception var7) {
         this.field657.repaint();
      }

   }
}
