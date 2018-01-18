import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class2 implements class0 {
   @ObfuscatedName("d")
   @Export("highMemory")
   public static boolean highMemory;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   static IndexedSprite field11;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -552382183
   )
   @Export("cameraYaw")
   static int cameraYaw;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILhg;B)I",
      garbageValue = "-21"
   )
   public static int method2(int var0, class230 var1) {
      return (var0 << 8) + var1.field2902;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2106226229"
   )
   static void method3(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1224[var5] != var0) {
            var2[var4] = World.field1224[var5];
            var3[var4] = World.field1223[var5];
            ++var4;
         }
      }

      World.field1224 = var2;
      World.field1223 = var3;
      GroundObject.method2558(World.worldList, 0, World.worldList.length - 1, World.field1224, World.field1223);
   }
}
