import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ev")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 255863557
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1632090643
   )
   @Export("y")
   int y;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -678068409
   )
   @Export("z")
   int z;
}
