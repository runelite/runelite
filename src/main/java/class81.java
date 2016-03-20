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

@ObfuscatedName("cc")
public final class class81 extends class77 {
   @ObfuscatedName("a")
   Component field1424;

   @ObfuscatedName("a")
   final void vmethod1893(int var1, int var2, Component var3) {
      super.field1395 = var1;
      super.field1389 = var2;
      super.field1394 = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field1394, super.field1394.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1395, super.field1389), var4, (Point)null);
      super.field1392 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1424 = var3;
      this.method1723();
   }

   @ObfuscatedName("f")
   public final void vmethod1895(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1392, 0, 0, this.field1424);
      var1.setClip(var6);
   }

   @ObfuscatedName("r")
   public final void vmethod1900(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1392, var2, var3, this.field1424);
   }
}
