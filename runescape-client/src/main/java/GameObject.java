import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1582265761
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -95353139
   )
   @Export("height")
   int height;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -931394199
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1349051947
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1513008315
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -676003621
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1848891115
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1360912861
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1108067955
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1059063627
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -35435741
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1892082625
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1620091341
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-1933045476"
   )
   public static void method2964(String var0, boolean var1, boolean var2) {
      class40.method537(var0, var1, "openjs", var2);
   }
}
