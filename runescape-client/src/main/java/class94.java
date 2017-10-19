import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class94 {
   @ObfuscatedName("q")
   static byte[] field1497;
   @ObfuscatedName("o")
   static byte[] field1487;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lfz;"
   )
   static Buffer[] field1488;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1448704133
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("p")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1321394161
   )
   static int field1491;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1498;
   @ObfuscatedName("d")
   static int[] field1492;
   @ObfuscatedName("x")
   static int[] field1493;
   @ObfuscatedName("z")
   static int[] field1494;
   @ObfuscatedName("n")
   static int[] field1495;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -939550357
   )
   static int field1496;
   @ObfuscatedName("t")
   static int[] field1486;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   static Buffer field1484;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -706811263
   )
   static int field1500;

   static {
      field1497 = new byte[2048];
      field1487 = new byte[2048];
      field1488 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1491 = 0;
      field1492 = new int[2048];
      field1493 = new int[2048];
      field1494 = new int[2048];
      field1495 = new int[2048];
      field1496 = 0;
      field1486 = new int[2048];
      field1484 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("w")
   public static final void method1823(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var8) {
               ;
            }
         }

      }
   }
}
