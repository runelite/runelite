import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1675273429
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2099552985
   )
   int field1259;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1178400491
   )
   @Export("health")
   int health;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2120657543
   )
   int field1261;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1259 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1261 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-72"
   )
   void method1547(int var1, int var2, int var3, int var4) {
      this.field1259 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1261 = var4;
   }
}
