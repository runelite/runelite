import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 52797281
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1236815505
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 577972675
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -317251493
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 73104115
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1590374683
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1959418487
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -534047403
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -617185365
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1047053791
   )
   @Export("height")
   int height;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2097931131
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1175394327
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1922564039
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }
}
