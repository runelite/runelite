import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cv")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 827260873
   )
   @Export("z")
   int z;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -51785355
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 124344315
   )
   @Export("x")
   int x;
}
