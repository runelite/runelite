import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 863366545
   )
   static int field1599;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -682442109
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 395044863
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1025301365
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -492344197
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1146347875
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -385228995
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1334207617
   )
   int field1607;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1770954363
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -937308341
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2038649809
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 642149875
   )
   int field1611;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -752551285
   )
   @Export("height")
   int height;
   @ObfuscatedName("ak")
   static int[] field1613;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1895360773
   )
   @Export("plane")
   int plane;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-925499995"
   )
   static int method1895(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2091[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
