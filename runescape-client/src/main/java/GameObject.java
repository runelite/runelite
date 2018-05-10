import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 275839015
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 668222039
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1206458065
   )
   @Export("height")
   int height;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1820642471
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1191748071
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 735631027
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -387468821
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1306674737
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1663945835
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2079010547
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -37820759
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -4805703617808557861L
   )
   @Export("hash")
   public long hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1655703577
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0L;
      this.flags = 0;
   }
}
