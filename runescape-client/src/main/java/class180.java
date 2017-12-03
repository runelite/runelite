import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class180 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;B)V",
      garbageValue = "-18"
   )
   public static void method3232(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3452 = var0;
      class188.field2537 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILhi;I)I",
      garbageValue = "-138887515"
   )
   public static int method3231(int var0, class230 var1) {
      return (var0 + 40000 << 8) + var1.field2905;
   }
}
