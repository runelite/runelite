import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1468611489
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -894773671
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1268436161
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 968404233
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1391435219
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -793414107
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1125865599
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 450121641
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1194065509
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1584045217
   )
   int field1724;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1893314819
   )
   int field1725;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1242855477
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("as")
   static int[] field1727;
   @ObfuscatedName("po")
   static Clipboard field1729;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2057954863
   )
   @Export("height")
   int height;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SB)V",
      garbageValue = "-103"
   )
   public static void method2242(String[] var0, short[] var1) {
      class137.method2910(var0, var1, 0, var0.length - 1);
   }
}
