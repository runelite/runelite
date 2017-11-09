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
   public static ServerPacket[] method3001() {
      return new ServerPacket[]{ServerPacket.field2275, ServerPacket.field2221, ServerPacket.field2222, ServerPacket.field2223, ServerPacket.field2224, ServerPacket.field2225, ServerPacket.field2269, ServerPacket.field2278, ServerPacket.field2241, ServerPacket.field2229, ServerPacket.field2230, ServerPacket.field2233, ServerPacket.field2234, ServerPacket.field2290, ServerPacket.field2228, ServerPacket.field2261, ServerPacket.field2227, ServerPacket.field2237, ServerPacket.field2238, ServerPacket.field2235, ServerPacket.field2295, ServerPacket.field2285, ServerPacket.field2242, ServerPacket.field2243, ServerPacket.field2244, ServerPacket.field2245, ServerPacket.field2246, ServerPacket.field2247, ServerPacket.field2248, ServerPacket.field2260, ServerPacket.field2250, ServerPacket.field2251, ServerPacket.field2252, ServerPacket.field2253, ServerPacket.field2254, ServerPacket.field2280, ServerPacket.field2282, ServerPacket.field2257, ServerPacket.field2258, ServerPacket.field2259, ServerPacket.field2226, ServerPacket.field2289, ServerPacket.field2262, ServerPacket.field2263, ServerPacket.field2264, ServerPacket.field2265, ServerPacket.field2281, ServerPacket.field2266, ServerPacket.field2255, ServerPacket.field2267, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2272, ServerPacket.field2232, ServerPacket.field2274, ServerPacket.field2236, ServerPacket.field2276, ServerPacket.field2277, ServerPacket.field2240, ServerPacket.field2231, ServerPacket.field2279, ServerPacket.field2220, ServerPacket.field2239, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2286, ServerPacket.field2256, ServerPacket.field2287, ServerPacket.field2288, ServerPacket.field2273, ServerPacket.field2268, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2293, ServerPacket.field2294, ServerPacket.field2249, ServerPacket.field2296, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2299, ServerPacket.field2300, ServerPacket.field2301, ServerPacket.field2302};
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
