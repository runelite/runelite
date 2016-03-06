package net.runelite.rs.client;
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

@ObfuscatedName("cg")
public final class class81 extends class77 {
   @ObfuscatedName("j")
   Component field1437;

   @ObfuscatedName("j")
   final void vmethod1841(int var1, int var2, Component var3) {
      super.field1400 = var1;
      super.field1401 = var2;
      super.field1402 = new int[1 + var2 * var1];
      DataBufferInt var4 = new DataBufferInt(super.field1402, super.field1402.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1400, super.field1401), var4, (Point)null);
      super.field1399 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1437 = var3;
      this.method1667();
   }

   @ObfuscatedName("l")
   public final void vmethod1842(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1399, var2, var3, this.field1437);
   }

   @ObfuscatedName("a")
   public final void vmethod1847(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1399, 0, 0, this.field1437);
      var1.setClip(var6);
   }
}
