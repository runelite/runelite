import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   @Export("INTEGER")
   INTEGER(1, 0, Integer.class, new class2()),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   @Export("LONG")
   LONG(0, 1, Long.class, new class3()),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 366527293
   )
   static int field26;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -26102371
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -100019199
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lt;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)[Lji;",
      garbageValue = "-16"
   )
   static VerticalAlignment[] method12() {
      return new VerticalAlignment[]{VerticalAlignment.field3439, VerticalAlignment.field3438, VerticalAlignment.field3437};
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "12691"
   )
   static final void method13(int var0, int var1, int var2, int var3, int var4) {
      class38.scrollbarSprites[0].method5806(var0, var1);
      class38.scrollbarSprites[1].method5806(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field911);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field1042);
      Rasterizer2D.method5707(var0, var6 + var1 + 16, var5, Client.field914);
      Rasterizer2D.method5707(var0 + 1, var6 + var1 + 16, var5, Client.field914);
      Rasterizer2D.method5718(var0, var6 + var1 + 16, 16, Client.field914);
      Rasterizer2D.method5718(var0, var6 + var1 + 17, 16, Client.field914);
      Rasterizer2D.method5707(var0 + 15, var6 + var1 + 16, var5, Client.field907);
      Rasterizer2D.method5707(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field907);
      Rasterizer2D.method5718(var0, var6 + var5 + var1 + 15, 16, Client.field907);
      Rasterizer2D.method5718(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field907);
   }
}
