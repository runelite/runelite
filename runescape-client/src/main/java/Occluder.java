import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -147950691
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1219553899
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1503927691
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1314117851
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 356342551
   )
   @Export("type")
   int type;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -283447731
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1596509319
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1622757191
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1938720047
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 376326159
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -898667259
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 379234141
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1581183463
   )
   int field2059;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 272072733
   )
   int field2060;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 487892989
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -680820287
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1153191711
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -867147689
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;Ljk;B)V",
      garbageValue = "-81"
   )
   public static void method3162(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class281.field3577 = var0;
      TotalQuantityComparator.field304 = var1;
      class281.field3564 = var2;
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(I)Llp;",
      garbageValue = "-1397848199"
   )
   static RenderOverview method3163() {
      return class248.renderOverview;
   }
}
