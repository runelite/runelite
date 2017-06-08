import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -516067043
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -379456477
   )
   @Export("health")
   int health;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 9673805
   )
   int field1291;
   @ObfuscatedName("x")
   public static Font field1292;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2147104019
   )
   int field1293;

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "1723308517"
   )
   static void method1515(Widget var0) {
      if(Client.field1067 == var0.field2701) {
         Client.field1121[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2069503585"
   )
   void method1517(int var1, int var2, int var3, int var4) {
      this.field1293 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1291 = var4;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1293 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1291 = var4;
   }
}
