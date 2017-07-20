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

@ObfuscatedName("bl")
@Implements("MainBufferProvider")
public final class MainBufferProvider extends BufferProvider {
   @ObfuscatedName("o")
   @Export("image")
   Image image;
   @ObfuscatedName("c")
   Component field685;

   MainBufferProvider(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, (Point)null);
      this.image = new BufferedImage(var5, var6, false, new Hashtable());
      this.method790(var3);
      this.setRaster();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "0"
   )
   @Export("drawSub")
   final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      try {
         Shape var6 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.image, 0, 0, this.field685);
         var1.setClip(var6);
      } catch (Exception var7) {
         this.field685.repaint();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1762052399"
   )
   @Export("draw")
   @Hook("draw")
   final void draw(Graphics var1, int var2, int var3) {
      try {
         var1.drawImage(this.image, var2, var3, this.field685);
      } catch (Exception var5) {
         this.field685.repaint();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1840969706"
   )
   final void method790(Component var1) {
      this.field685 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "61"
   )
   public final void vmethod4917(int var1, int var2) {
      this.draw(this.field685.getGraphics(), var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   public final void vmethod4910(int var1, int var2, int var3, int var4) {
      this.drawSub(this.field685.getGraphics(), var1, var2, var3, var4);
   }
}
