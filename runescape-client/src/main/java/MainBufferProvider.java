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
   @ObfuscatedName("b")
   Component field638;
   @ObfuscatedName("s")
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
      this.method777(var3);
      this.setRaster();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1734940192"
   )
   final void method777(Component var1) {
      this.field638 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "10"
   )
   public final void vmethod5065(int var1, int var2) {
      this.draw(this.field638.getGraphics(), var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-959174772"
   )
   public final void vmethod5068(int var1, int var2, int var3, int var4) {
      this.drawSub(this.field638.getGraphics(), var1, var2, var3, var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "127"
   )
   @Export("draw")
   @Hook("draw")
   final void draw(Graphics var1, int var2, int var3) {
      try {
         var1.drawImage(this.image, var2, var3, this.field638);
      } catch (Exception var5) {
         this.field638.repaint();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-48"
   )
   @Export("drawSub")
   final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      try {
         Shape var6 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.image, 0, 0, this.field638);
         var1.setClip(var6);
      } catch (Exception var7) {
         this.field638.repaint();
      }

   }
}
