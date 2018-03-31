import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -676852977
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2072900197
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 437112655
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -226363807
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2042015417
   )
   @Export("type")
   int type;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1016989277
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -279581517
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -808054181
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1005482455
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 41157783
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1791148741
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1724035419
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 459398303
   )
   int field2071;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -915263915
   )
   int field2068;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 679644417
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2005106235
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -889154915
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1036950935
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-66"
   )
   public static int method3095(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }
}
