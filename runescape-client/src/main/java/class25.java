import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class25 {
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1714735191
   )
   static int field358;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1459656127
   )
   int field357;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   Coordinates field359;

   @ObfuscatedSignature(
      signature = "(ILhq;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field357 = var1;
      this.field359 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;Lik;Lhp;I)Z",
      garbageValue = "2102143341"
   )
   public static boolean method201(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class211 var3) {
      class210.field2600 = var0;
      class289.field3810 = var1;
      class210.field2597 = var2;
      class210.field2596 = var3;
      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711680"
   )
   public static void method202() {
      CombatInfo2.field3416.reset();
      CombatInfo2.spriteCache.reset();
   }
}
