import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = 646541439
   )
   static int field1207;
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static MachineInfo field1203;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1142309639
   )
   int field1205;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 20090089
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2029892367
   )
   @Export("health")
   int health;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1771396945
   )
   int field1206;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1205 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1206 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   void method1633(int var1, int var2, int var3, int var4) {
      this.field1205 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1206 = var4;
   }
}
