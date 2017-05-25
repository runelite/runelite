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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("MainBufferProvider")
public final class MainBufferProvider extends BufferProvider {
   @ObfuscatedName("h")
   Image field679;
   @ObfuscatedName("i")
   Component field680;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2011124489"
   )
   final void method827(Component var1) {
      this.field680 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "128721490"
   )
   public final void vmethod5084(int var1, int var2, int var3, int var4) {
      this.drawSub(this.field680.getGraphics(), var1, var2, var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1113058415"
   )
   public final void vmethod5083(int var1, int var2) {
      this.draw(this.field680.getGraphics(), var1, var2);
   }

   MainBufferProvider(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var1 * var2 + 1];
      DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, (Point)null);
      this.field679 = new BufferedImage(var5, var6, false, new Hashtable());
      this.method827(var3);
      this.method5082();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "843531689"
   )
   @Export("draw")
   final void draw(Graphics var1, int var2, int var3) {
      try {
         var1.drawImage(this.field679, var2, var3, this.field680);
      } catch (Exception var5) {
         this.field680.repaint();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1531151163"
   )
   @Export("drawSub")
   final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      try {
         Shape var6 = var1.getClip();
         var1.clipRect(var2, var3, var4, var5);
         var1.drawImage(this.field679, 0, 0, this.field680);
         var1.setClip(var6);
      } catch (Exception var7) {
         this.field680.repaint();
      }

   }
}
