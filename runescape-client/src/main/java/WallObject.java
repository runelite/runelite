import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("bi")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1834799053
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1922798305
   )
   int field1536;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2145554239
   )
   int field1537;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1124172865
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 143809805
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1714412415
   )
   int field1541;
   @ObfuscatedName("cw")
   static Font field1542;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 321206561
   )
   public static int field1543;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1509029749
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("u")
   @Export("renderable2")
   public Renderable renderable2;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "1390816580"
   )
   public static int method1904(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;B)V",
      garbageValue = "1"
   )
   public static void method1905(IndexDataBase var0) {
      class191.field2797 = var0;
   }

   WallObject() {
      this.hash = 0;
      this.field1541 = 0;
   }
}
