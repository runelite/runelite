import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("qh")
   static short[] field1746;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2062123111
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1891188751
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 572666947
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 549994423
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -973522319
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1435519779"
   )
   public static void method2639() {
      Widget.field2872.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2735.reset();
   }
}
