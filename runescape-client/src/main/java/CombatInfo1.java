import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -833582695
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -189311435
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1388541921
   )
   @Export("health")
   int health;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1958781031
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-556137649"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1483104103"
   )
   public static void method1606() {
      class279.field3550.reset();
   }
}
