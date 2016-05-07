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

@ObfuscatedName("ci")
public final class class81 extends class77 {
   @ObfuscatedName("s")
   Component field1433;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "0"
   )
   final void vmethod1852(int var1, int var2, Component var3) {
      super.field1397 = var1;
      super.field1398 = var2;
      super.field1401 = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field1401, super.field1401.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1397, super.field1398), var4, (Point)null);
      super.field1400 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1433 = var3;
      this.method1646();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   public final void vmethod1857(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1400, var2, var3, this.field1433);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "128"
   )
   public final void vmethod1858(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1400, 0, 0, this.field1433);
      var1.setClip(var6);
   }
}
