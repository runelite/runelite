import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1133397743
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -697797747
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 783847723
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1557819591
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 811325617
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 593470229
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1192761677
   )
   @Export("height")
   int height;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1818568899
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1979637029
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1274671015
   )
   int field1632;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 833860229
   )
   int field1633;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -244495817
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -305977055
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -171823269
   )
   static int field1636;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1325216786"
   )
   public static int method1984() {
      return class105.keyboardIdleTicks;
   }
}
