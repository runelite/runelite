import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1056255967
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -594595681
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 414439451
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -272588949
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -982928651
   )
   @Export("type")
   int type;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1663289561
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1060161977
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 456325405
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -62430139
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -39616601
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -879608465
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 357701387
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1817392473
   )
   int field2061;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -775752639
   )
   int field2072;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -712735129
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -630875917
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 129962779
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1366677633
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgd;III)I",
      garbageValue = "1407630225"
   )
   static int method2998(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }
}
