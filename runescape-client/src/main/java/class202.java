import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class202 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -870879683
   )
   static int field2502;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2125719237
   )
   int field2503;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 957768341
   )
   int field2504;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 513233297
   )
   int field2505;
   @ObfuscatedName("m")
   byte[] field2506;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -906407971
   )
   int field2507;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -401040363
   )
   int field2508;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -735578761
   )
   int field2509;
   @ObfuscatedName("p")
   byte[] field2510;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 443871467
   )
   int field2511;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "78"
   )
   static void method3563(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field1284[var5]) {
            var2[var4] = World.field1284[var5];
            var3[var4] = World.field1283[var5];
            ++var4;
         }
      }

      World.field1284 = var2;
      World.field1283 = var3;
      Player.method1092(World.worldList, 0, World.worldList.length - 1, World.field1284, World.field1283);
   }
}
