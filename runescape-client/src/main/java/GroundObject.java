import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "Lby;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2069998175
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2068966877
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1414255563
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 219715917
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2074372609
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1093760864"
   )
   public static void method2699() {
      Widget.field2885.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2751.reset();
   }
}
