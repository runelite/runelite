import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 684786807
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1599053765
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1082276195
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -377924657
   )
   @Export("health")
   int health;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 312802039
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "459558858"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }
}
