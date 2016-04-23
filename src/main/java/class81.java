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
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public final class class81 extends class77 {
   @ObfuscatedName("j")
   Component field1409;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "40"
   )
   public final void vmethod1871(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1380, 0, 0, this.field1409);
      var1.setClip(var6);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1018784558"
   )
   public final void vmethod1872(int var1, int var2, Component var3) {
      super.field1373 = var1;
      super.field1374 = var2;
      super.field1376 = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field1376, super.field1376.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1373, super.field1374), var4, (Point)null);
      super.field1380 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1409 = var3;
      this.method1678();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   public final void vmethod1873(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1380, var2, var3, this.field1409);
   }
}
