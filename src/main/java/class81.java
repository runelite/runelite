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

@ObfuscatedName("ce")
public final class class81 extends class77 {
   @ObfuscatedName("e")
   Component field1397;

   @ObfuscatedName("e")
   final void vmethod1885(int var1, int var2, Component var3) {
      super.field1366 = var1;
      super.field1362 = var2;
      super.field1361 = new int[1 + var1 * var2];
      DataBufferInt var4 = new DataBufferInt(super.field1361, super.field1361.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1366, super.field1362), var4, (Point)null);
      super.field1360 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1397 = var3;
      this.method1674();
   }

   @ObfuscatedName("w")
   public final void vmethod1886(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1360, var2, var3, this.field1397);
   }

   @ObfuscatedName("f")
   public final void vmethod1897(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1360, 0, 0, this.field1397);
      var1.setClip(var6);
   }
}
