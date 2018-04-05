import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("of")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = -681479473
   )
   static int field248;
   @ObfuscatedName("u")
   public static short[] field246;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 423493109
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1699475659
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -76157077
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1224011697
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 349392343
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "45976309"
   )
   public final void vmethod46() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Lga;",
      garbageValue = "-1823861162"
   )
   static LoginPacket[] method37() {
      return new LoginPacket[]{LoginPacket.field2485, LoginPacket.field2486, LoginPacket.field2483, LoginPacket.field2488};
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   static final void method36() {
      if(class71.soundSystem1 != null) {
         class71.soundSystem1.method2197();
      }

      if(class155.soundSystem0 != null) {
         class155.soundSystem0.method2197();
      }

   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-965946678"
   )
   static void method32() {
      if(Client.field960 == 1) {
         Client.field1061 = true;
      }

   }
}
