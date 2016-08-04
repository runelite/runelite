import java.awt.Component;
import java.awt.Graphics;
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

@ObfuscatedName("ch")
@Implements("MainBufferProvider")
public final class class84 extends class80 {
   @ObfuscatedName("l")
   Component field1504;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-75"
   )
   @Export("drawSub")
   public final void vmethod1963(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1475, 0, 0, this.field1504);
      var1.setClip(var6);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "42"
   )
   @Export("init")
   public final void vmethod1964(int var1, int var2, Component var3) {
      super.field1470 = var1;
      super.field1472 = var2;
      super.field1474 = new int[1 + var2 * var1];
      DataBufferInt var4 = new DataBufferInt(super.field1474, super.field1474.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1470, super.field1472), var4, (Point)null);
      super.field1475 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1504 = var3;
      this.method1787();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1769215131"
   )
   @Export("draw")
   public final void vmethod1965(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1475, var2, var3, this.field1504);
   }
}
