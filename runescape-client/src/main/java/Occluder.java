import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      longValue = -5649483118813195851L
   )
   static long field2064;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1709641349
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 26010827
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 388176747
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -325548867
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1790246649
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1711192843
   )
   @Export("type")
   int type;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2038221971
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1678727351
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1128470665
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 119608497
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -286043729
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1936543499
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 706392155
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1002900501
   )
   int field2057;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1615989265
   )
   int field2051;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -168912249
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1894433771
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1967201769
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -558137197
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgi;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-60557303"
   )
   static String method3016(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1625513218"
   )
   static final boolean method3015(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
