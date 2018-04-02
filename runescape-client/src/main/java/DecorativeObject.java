import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -741509819
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 27940365
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1351166039
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1505419439
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1448452761
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2067639295
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1364887827
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2129795425
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1116667243
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   public static void method3096() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1058550691"
   )
   static byte[] method3097(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
