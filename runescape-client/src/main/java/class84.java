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
public final class class84 extends class80 {
   @ObfuscatedName("e")
   Component field1492;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "2003148099"
   )
   @Export("init")
   public final void vmethod1966(int var1, int var2, Component var3) {
      super.field1459 = var1;
      super.field1461 = var2;
      super.field1464 = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.field1464, super.field1464.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1459, super.field1461), var4, (Point)null);
      super.field1462 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1492 = var3;
      this.method1776();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "30"
   )
   @Export("drawSub")
   public final void vmethod1968(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1462, 0, 0, this.field1492);
      var1.setClip(var6);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "462088111"
   )
   @Export("draw")
   public final void vmethod1975(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1462, var2, var3, this.field1492);
   }
}
