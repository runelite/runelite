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

@ObfuscatedName("cz")
@Implements("MainBufferProvider")
public final class class81 extends class77 {
   @ObfuscatedName("f")
   Component field1434;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-41"
   )
   @Export("init")
   public final void vmethod1929(int var1, int var2, Component var3) {
      super.field1402 = var1;
      super.field1404 = var2;
      super.field1406 = new int[1 + var2 * var1];
      DataBufferInt var4 = new DataBufferInt(super.field1406, super.field1406.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1402, super.field1404), var4, (Point)null);
      super.field1405 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1434 = var3;
      this.method1733();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1276226507"
   )
   @Export("drawSub")
   public final void vmethod1931(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1405, 0, 0, this.field1434);
      var1.setClip(var6);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1142358962"
   )
   @Export("draw")
   public final void vmethod1939(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1405, var2, var3, this.field1434);
   }
}
