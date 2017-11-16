import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -554470679
   )
   static int field1209;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1377194971
   )
   static int field1208;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1518985687
   )
   int field1207;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1707602189
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1963748325
   )
   @Export("health")
   int health;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1321647439
   )
   int field1210;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1207 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1210 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "23"
   )
   void method1514(int var1, int var2, int var3, int var4) {
      this.field1207 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1210 = var4;
   }
}
