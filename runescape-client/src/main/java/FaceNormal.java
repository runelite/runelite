import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "[Llm;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -903145617
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1111326717
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 283455973
   )
   @Export("z")
   int z;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "335"
   )
   public static void method3052() {
      Area.areaSpriteCache.reset();
   }
}
