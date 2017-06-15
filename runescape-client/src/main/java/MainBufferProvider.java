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
   @ObfuscatedName("p")
   Component field689;
   @ObfuscatedName("m")
   @Export("image")
   Image image;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1923710324"
   )
   final void method776(Component var1) {
      this.field689 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "290843664"
   )
   public final void vmethod4897(int var1, int var2) {
      this.draw(this.field689.getGraphics(), var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   public final void vmethod4896(int var1, int var2, int var3, int var4) {
      this.drawSub(this.field689.getGraphics(), var1, var2, var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "-50"
   )
   @Export("draw")
   @Hook("draw")
   final void draw(Graphics var1, int var2, int var3) {
      try {
         var1.drawImage(this.image, var2, var3, this.field689);
      } catch (Exception var5) {
         this.field689.repaint();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "-12600"
   )
   @Export("drawSub")
   final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      try {
         Shape var6 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.image, 0, 0, this.field689);
         var1.setClip(var6);
      } catch (Exception var7) {
         this.field689.repaint();
      }

   }

   MainBufferProvider(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var1 * var2 + 1];
      DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, (Point)null);
      this.image = new BufferedImage(var5, var6, false, new Hashtable());
      this.method776(var3);
      this.method4898();
   }
}
