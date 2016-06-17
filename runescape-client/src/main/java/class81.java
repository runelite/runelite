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

@ObfuscatedName("cs")
@Implements("MainBufferProvider")
public final class class81 extends class77 {
   @ObfuscatedName("b")
   Component field1396;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "1568651033"
   )
   @Export("init")
   public final void vmethod1878(int var1, int var2, Component var3) {
      super.field1363 = var1;
      super.field1364 = var2;
      super.field1368 = new int[1 + var1 * var2];
      DataBufferInt var4 = new DataBufferInt(super.field1368, super.field1368.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1363, super.field1364), var4, (Point)null);
      super.field1362 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1396 = var3;
      this.method1685();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "2144576879"
   )
   @Export("drawSub")
   public final void vmethod1879(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1362, 0, 0, this.field1396);
      var1.setClip(var6);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "0"
   )
   @Export("draw")
   public final void vmethod1887(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1362, var2, var3, this.field1396);
   }
}
