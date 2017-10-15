import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("nw")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1358348553
   )
   static int field2140;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1175298727
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 9481335
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -184521319
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1696108751
   )
   @Export("type")
   int type;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -568920457
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -97707391
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1591277857
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1928932069
   )
   int field2152;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1658673257
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1747102443
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -941657009
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1706822655
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1731428905
   )
   int field2159;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1765323821
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -778408973
   )
   @Export("maxNormalY")
   int maxNormalY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1829017021
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1574635281
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1193920907
   )
   @Export("maxTIleX")
   int maxTIleX;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lic;",
      garbageValue = "7"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3456 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }
}
