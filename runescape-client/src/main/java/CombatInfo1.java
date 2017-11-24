import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 255167129
   )
   int field1206;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -890855621
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1138941551
   )
   @Export("health")
   int health;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1743110791
   )
   int field1208;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1206 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1208 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-313935265"
   )
   void method1591(int var1, int var2, int var3, int var4) {
      this.field1206 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1208 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   public static void method1590() {
      class289.field3806 = new CombatInfoList();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1457515005"
   )
   static final int method1592(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
