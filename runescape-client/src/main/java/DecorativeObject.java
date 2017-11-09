import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   public static Buffer field2078;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 13966817
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -384116185
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2074517245
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 320985049
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 781882327
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 39087531
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -63636409
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1720994237
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1459693829
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lfw;",
      garbageValue = "-1550218901"
   )
   public static class166[] method3001() {
      return new class166[]{class166.field2275, class166.field2221, class166.field2222, class166.field2223, class166.field2224, class166.field2225, class166.field2269, class166.field2278, class166.field2241, class166.field2229, class166.field2230, class166.field2233, class166.field2234, class166.field2290, class166.field2228, class166.field2261, class166.field2227, class166.field2237, class166.field2238, class166.field2235, class166.field2295, class166.field2285, class166.field2242, class166.field2243, class166.field2244, class166.field2245, class166.field2246, class166.field2247, class166.field2248, class166.field2260, class166.field2250, class166.field2251, class166.field2252, class166.field2253, class166.field2254, class166.field2280, class166.field2282, class166.field2257, class166.field2258, class166.field2259, class166.field2226, class166.field2289, class166.field2262, class166.field2263, class166.field2264, class166.field2265, class166.field2281, class166.field2266, class166.field2255, class166.field2267, class166.field2270, class166.field2271, class166.field2272, class166.field2232, class166.field2274, class166.field2236, class166.field2276, class166.field2277, class166.field2240, class166.field2231, class166.field2279, class166.field2220, class166.field2239, class166.field2283, class166.field2284, class166.field2286, class166.field2256, class166.field2287, class166.field2288, class166.field2273, class166.field2268, class166.field2291, class166.field2292, class166.field2293, class166.field2294, class166.field2249, class166.field2296, class166.field2297, class166.field2298, class166.field2299, class166.field2300, class166.field2301, class166.field2302};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "486962001"
   )
   static int method2999(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1941();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lic;",
      garbageValue = "2034055948"
   )
   static class246[] method3002() {
      return new class246[]{class246.field3335, class246.field3334, class246.field3337};
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "874898469"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class295.field3854 = var1.readUnsignedShort();
      class295.field3853 = new int[class295.field3854];
      class37.offsetsY = new int[class295.field3854];
      ItemContainer.field745 = new int[class295.field3854];
      class31.field428 = new int[class295.field3854];
      class295.spritePixels = new byte[class295.field3854][];
      var1.offset = var0.length - 7 - class295.field3854 * 8;
      class295.field3850 = var1.readUnsignedShort();
      class295.field3851 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class295.field3854; ++var3) {
         class295.field3853[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3854; ++var3) {
         class37.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3854; ++var3) {
         ItemContainer.field745[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3854; ++var3) {
         class31.field428[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class295.field3854 * 8 - (var2 - 1) * 3;
      class295.field3852 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class295.field3852[var3] = var1.read24BitInt();
         if(class295.field3852[var3] == 0) {
            class295.field3852[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class295.field3854; ++var3) {
         int var4 = ItemContainer.field745[var3];
         int var5 = class31.field428[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class295.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }
}
