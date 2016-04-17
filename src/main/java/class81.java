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

@ObfuscatedName("cv")
public final class class81 extends class77 {
   @ObfuscatedName("a")
   Component field1427;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "0"
   )
   public final void vmethod1970(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1396, var2, var3, this.field1427);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "91"
   )
   final void vmethod1971(int var1, int var2, Component var3) {
      super.field1394 = var1;
      super.field1395 = var2;
      super.field1393 = new int[var1 * var2 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field1393, super.field1393.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1394, super.field1395), var4, (Point)null);
      super.field1396 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1427 = var3;
      this.method1782();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1669287626"
   )
   public final void vmethod1972(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1396, 0, 0, this.field1427);
      var1.setClip(var6);
   }
}
