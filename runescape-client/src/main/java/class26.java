import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class26 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexDataBase field236;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)[Lbq;",
      garbageValue = "-32"
   )
   static AttackOption[] method471() {
      return new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_alwaysRightClick};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2073149876"
   )
   static final boolean method470(int var0, int var1) {
      ObjectComposition var2 = SoundTaskDataProvider.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method5049(var1);
   }
}
