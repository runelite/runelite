import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1641706093
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 702952579
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1040395007
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2106319395
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1287797481
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("eo")
   static SpritePixels[] field1283;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1464645261
   )
   static int field1284;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "1270600036"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2825.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2828.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method3594(new Buffer(var2));
         }

         KitDefinition.field2825.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "81"
   )
   static final int method1601(int var0, int var1) {
      int var2 = class148.method2820(var0 - 1, var1 - 1) + class148.method2820(1 + var0, var1 - 1) + class148.method2820(var0 - 1, var1 + 1) + class148.method2820(1 + var0, 1 + var1);
      int var3 = class148.method2820(var0 - 1, var1) + class148.method2820(1 + var0, var1) + class148.method2820(var0, var1 - 1) + class148.method2820(var0, var1 + 1);
      int var4 = class148.method2820(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }
}
