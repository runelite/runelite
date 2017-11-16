import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1775032785
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1420739951
   )
   @Export("height")
   int height;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -862745741
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1418457301
   )
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -224023803
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2003070571
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1013359005
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -549741375
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1844064793
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 555698787
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 455893997
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1324168645
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -665735877
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-737675861"
   )
   static int method2897(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
