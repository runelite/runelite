import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("e")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1825108045
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -522456183
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1787592147
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 139363643
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1294809135
   )
   @Export("type")
   int type;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2060308147
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1461944691
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -769188835
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1174650487
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1928026031
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1034637679
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1093880599
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2045093277
   )
   int field2034;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -144694769
   )
   int field2021;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1797779067
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1469918773
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -156880351
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -516533993
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Ljo;",
      garbageValue = "14"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-479018673"
   )
   public static boolean method3070(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lie;IB)Z",
      garbageValue = "-24"
   )
   static boolean method3068(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         FloorUnderlayDefinition.decodeSprite(var2);
         return true;
      }
   }
}
