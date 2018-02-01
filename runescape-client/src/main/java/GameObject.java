import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1523401203
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1635298889
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1604885259
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -877815521
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1530507619
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1907947299
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -409330677
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1134602301
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -978379505
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1841684787
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 479487297
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2125664963
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 58575933
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;I)V",
      garbageValue = "73855304"
   )
   public static void method3020(IndexDataBase var0) {
      class263.field3455 = var0;
   }
}
