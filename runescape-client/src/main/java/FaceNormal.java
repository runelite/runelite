import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Llk;"
   )
   static IndexedSprite field2035;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 2040466383
   )
   static int field2034;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1737470861
   )
   static int field2033;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -602304493
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -39340705
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -705777011
   )
   @Export("z")
   int z;
}
