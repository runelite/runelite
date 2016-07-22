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

@ObfuscatedName("cr")
@Implements("MainBufferProvider")
public final class class84 extends class80 {
   @ObfuscatedName("m")
   Component field1502;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "85277585"
   )
   @Export("draw")
   public final void vmethod1959(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1470, var2, var3, this.field1502);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "10294"
   )
   @Export("drawSub")
   public final void vmethod1960(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1470, 0, 0, this.field1502);
      var1.setClip(var6);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-60"
   )
   @Export("init")
   final void vmethod1969(int var1, int var2, Component var3) {
      super.field1468 = var1;
      super.field1469 = var2;
      super.field1467 = new int[var1 * var2 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field1467, super.field1467.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1468, super.field1469), var4, (Point)null);
      super.field1470 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1502 = var3;
      this.method1782();
   }
}
