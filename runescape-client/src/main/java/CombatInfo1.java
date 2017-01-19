import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1483852815
   )
   @Export("health")
   int health;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1978123991
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1352577285
   )
   int field669;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1398839199
   )
   int field670;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1304478587"
   )
   void method592(int var1, int var2, int var3, int var4) {
      this.field670 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field669 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "-580416078"
   )
   static void method594(class18 var0) {
      class112.method2046(var0, 200000);
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field670 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field669 = var4;
   }
}
