import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1329892511
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1606333247
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -860923379
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -86285207
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 262140159
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 737228437
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -604076057
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 754706703
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1334738467
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1495885479
   )
   @Export("height")
   int height;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1548847697
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2044543599
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1867691603
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1220026247"
   )
   public static void method2924() {
      VarPlayerType.varplayers.reset();
   }
}
