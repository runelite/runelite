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

@ObfuscatedName("cf")
@Implements("MainBufferProvider")
public final class class81 extends class77 {
   @ObfuscatedName("t")
   Component field1430;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   @Export("draw")
   public final void vmethod1829(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1395, var2, var3, this.field1430);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1610060208"
   )
   @Export("drawSub")
   public final void vmethod1830(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1395, 0, 0, this.field1430);
      var1.setClip(var6);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-789686150"
   )
   @Export("init")
   final void vmethod1838(int var1, int var2, Component var3) {
      super.field1402 = var1;
      super.field1396 = var2;
      super.field1401 = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field1401, super.field1401.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1402, super.field1396), var4, (Point)null);
      super.field1395 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1430 = var3;
      this.method1658();
   }
}
