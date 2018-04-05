import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   static class169 field2069;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -614564121
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 859558247
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2062664837
   )
   @Export("z")
   int z;
}
