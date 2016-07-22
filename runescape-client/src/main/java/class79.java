import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class79 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 413090023
   )
   static int field1456;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2114189273
   )
   static int field1457;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -486789191
   )
   static int field1458;
   @ObfuscatedName("o")
   static int[] field1459;
   @ObfuscatedName("g")
   static int[] field1460;
   @ObfuscatedName("r")
   static int[] field1462;
   @ObfuscatedName("l")
   static int[] field1463;
   @ObfuscatedName("dh")
   static byte[][] field1466;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-183056090"
   )
   static final int method1748() {
      if(class12.field162.field127) {
         return class51.field1119;
      } else {
         int var0 = class15.method163(class9.field144, class59.field1256, class51.field1119);
         return var0 - class24.field622 < 800 && (class5.field78[class51.field1119][class9.field144 >> 7][class59.field1256 >> 7] & 4) != 0?class51.field1119:3;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-1991315532"
   )
   public static int method1763(byte[] var0, int var1) {
      return class129.method2868(var0, 0, var1);
   }
}
