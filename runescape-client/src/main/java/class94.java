import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public final class class94 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2136138085
   )
   int field1576;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1591471945
   )
   int field1577;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 3710697
   )
   int field1578;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1177079767
   )
   int field1579;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2144663189
   )
   int field1580;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -275474125
   )
   int field1581;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -120996337
   )
   int field1582;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -104024155
   )
   int field1583;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -526392233
   )
   int field1584;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1229948895
   )
   int field1585;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -253213027
   )
   int field1586;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 439088219
   )
   int field1587;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2093246279
   )
   int field1588;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1271875297
   )
   int field1589;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -447147155
   )
   int field1590;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -658732735
   )
   int field1591;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1659072737
   )
   int field1592;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2098147187
   )
   int field1593;
   @ObfuscatedName("bg")
   static class184 field1595;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-2014618143"
   )
   static void method1912(Sequence var0, int var1, int var2, int var3) {
      if(Client.field370 < 50 && Client.field518 != 0) {
         if(var0.field3052 != null && var1 < var0.field3052.length) {
            int var4 = var0.field3052[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field520[Client.field370] = var5;
               Client.field521[Client.field370] = var6;
               Client.field522[Client.field370] = 0;
               Client.field302[Client.field370] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field523[Client.field370] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field370;
            }
         }
      }
   }
}
