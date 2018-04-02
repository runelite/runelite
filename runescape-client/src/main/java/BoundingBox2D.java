import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1546245765
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1442306253
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 768200023
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1880251377
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1912374301
   )
   @Export("color")
   final int color;

   BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-254890889"
   )
   final void vmethod63() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljf;",
      garbageValue = "73"
   )
   public static class281 method49(int var0) {
      class281 var1 = (class281)class281.field3566.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class281.field3576.getConfigData(32, var0);
         var1 = new class281();
         if(var2 != null) {
            var1.method4977(new Buffer(var2));
         }

         class281.field3566.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lgg;",
      garbageValue = "-2114697654"
   )
   public static PacketNode method44() {
      PacketNode var0;
      if(PacketNode.field2496 == 0) {
         var0 = new PacketNode();
      } else {
         var0 = PacketNode.packetBufferNodes[--PacketNode.field2496];
      }

      var0.clientPacket = null;
      var0.field2492 = 0;
      var0.packetBuffer = new PacketBuffer(5000);
      return var0;
   }
}
