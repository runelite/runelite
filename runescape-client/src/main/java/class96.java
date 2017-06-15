import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class96 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2125302985
   )
   static int field1487;
   @ObfuscatedName("e")
   static byte[] field1489;
   @ObfuscatedName("c")
   static int[] field1490;
   @ObfuscatedName("j")
   static int[] field1491;
   @ObfuscatedName("q")
   static int[] field1492;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1285463447
   )
   static int field1493;
   @ObfuscatedName("t")
   static byte[] field1494;
   @ObfuscatedName("f")
   static int[] field1495;
   @ObfuscatedName("o")
   static int[] field1497;
   @ObfuscatedName("w")
   static Buffer[] field1498;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -633926399
   )
   static int field1499;
   @ObfuscatedName("a")
   static int[] field1500;
   @ObfuscatedName("g")
   static Buffer field1501;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "74"
   )
   public static int method1689(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   static {
      field1489 = new byte[2048];
      field1494 = new byte[2048];
      field1498 = new Buffer[2048];
      field1487 = 0;
      field1491 = new int[2048];
      field1499 = 0;
      field1495 = new int[2048];
      field1490 = new int[2048];
      field1497 = new int[2048];
      field1492 = new int[2048];
      field1493 = 0;
      field1500 = new int[2048];
      field1501 = new Buffer(new byte[5000]);
   }
}
