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

@ObfuscatedName("cw")
public final class class81 extends class77 {
   @ObfuscatedName("j")
   Component field1415;

   @ObfuscatedName("m")
   public final void vmethod1895(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1382, var2, var3, this.field1415);
   }

   @ObfuscatedName("j")
   public final void vmethod1896(int var1, int var2, Component var3) {
      super.field1381 = var1;
      super.field1380 = var2;
      super.field1387 = new int[1 + var2 * var1];
      DataBufferInt var4 = new DataBufferInt(super.field1387, super.field1387.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.field1381, super.field1380), var4, (Point)null);
      super.field1382 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1415 = var3;
      this.method1713();
   }

   @ObfuscatedName("f")
   public final void vmethod1897(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1382, 0, 0, this.field1415);
      var1.setClip(var6);
   }
}
