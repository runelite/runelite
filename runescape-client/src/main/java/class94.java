import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class94 {
   @ObfuscatedName("e")
   static byte[] field1476;
   @ObfuscatedName("p")
   static byte[] field1477;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lfg;"
   )
   static Buffer[] field1478;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 596344085
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("r")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1602588739
   )
   static int field1474;
   @ObfuscatedName("v")
   static int[] field1482;
   @ObfuscatedName("t")
   static int[] field1483;
   @ObfuscatedName("y")
   static int[] field1475;
   @ObfuscatedName("o")
   static int[] field1481;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1893576507
   )
   static int field1486;
   @ObfuscatedName("u")
   static int[] field1487;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   static Buffer field1488;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1389387385
   )
   public static int field1491;

   static {
      field1476 = new byte[2048];
      field1477 = new byte[2048];
      field1478 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1474 = 0;
      field1482 = new int[2048];
      field1483 = new int[2048];
      field1475 = new int[2048];
      field1481 = new int[2048];
      field1486 = 0;
      field1487 = new int[2048];
      field1488 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "-656194536"
   )
   public static void method1859(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      class181.field2452 = VarPlayerType.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "535343937"
   )
   public static boolean method1858(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
