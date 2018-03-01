import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("rv")
   @ObfuscatedGetter(
      intValue = 1160041041
   )
   static int field1333;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -790784423
   )
   public static int field1331;
   @ObfuscatedName("g")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2029305209
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.id;
   }
}
