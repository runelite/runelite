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

@ObfuscatedName("ci")
public final class class81 extends class77 {
   @ObfuscatedName("w")
   Component field1428;

   @ObfuscatedName("w")
   final void vmethod1869(int var1, int var2, Component var3) {
      super.field1396 = var1;
      super.field1397 = var2;
      super.field1395 = new int[1 + var2 * var1];
      DataBufferInt var4 = new DataBufferInt(super.field1395, super.field1395.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1396, super.field1397), var4, (Point)null);
      super.field1398 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1428 = var3;
      this.method1670();
   }

   @ObfuscatedName("x")
   public final void vmethod1870(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1398, var2, var3, this.field1428);
   }

   @ObfuscatedName("t")
   public final void vmethod1871(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1398, 0, 0, this.field1428);
      var1.setClip(var6);
   }
}
