import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static Buffer field2154;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 944799741
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 909095651
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1241766575
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -519047511
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1546219947
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1715717349
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 983419613
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1580295459
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2125707219
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1127690729
   )
   @Export("height")
   int height;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 910652283
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 663162621
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1066154637
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "959025532"
   )
   public static int method2836(CharSequence var0) {
      return class162.parseInt(var0, 10, true);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "53"
   )
   static final boolean method2835(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
