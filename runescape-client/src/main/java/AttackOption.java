import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1657086489
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   static void method1855() {
      class83.chatLineMap.clear();
      class83.messages.clear();
      class83.field1205.clear();
      class83.field1208 = 0;
   }
}
