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

@ObfuscatedName("bj")
@Implements("MainBufferProvider")
public final class MainBufferProvider extends BufferProvider {
   @ObfuscatedName("m")
   Component field656;
   @ObfuscatedName("p")
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
      this.method894(var3);
      this.setRaster();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1008299691"
   )
   final void method894(Component var1) {
      this.field656 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "97"
   )
   public final void vmethod5235(int var1, int var2) {
      this.draw(this.field656.getGraphics(), var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   public final void vmethod5233(int var1, int var2, int var3, int var4) {
      this.drawSub(this.field656.getGraphics(), var1, var2, var3, var4);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "5"
   )
   @Export("draw")
   @Hook("draw")
   final void draw(Graphics var1, int var2, int var3) {
      try {
         var1.drawImage(this.image, var2, var3, this.field656);
      } catch (Exception var5) {
         this.field656.repaint();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-75"
   )
   @Export("drawSub")
   final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      try {
         Shape var6 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.image, 0, 0, this.field656);
         var1.setClip(var6);
      } catch (Exception var7) {
         this.field656.repaint();
      }

   }
}
