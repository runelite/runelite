import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   static IndexedSprite[] field1271;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   static class263 field1269;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexData field1272;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 750936155
   )
   int field1273;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1011520493
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -970602777
   )
   @Export("health")
   int health;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1425275867
   )
   int field1270;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1273 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1270 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-131843799"
   )
   void method1546(int var1, int var2, int var3, int var4) {
      this.field1273 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1270 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lix;",
      garbageValue = "1098357471"
   )
   public static class255 method1547(int var0) {
      class255 var1 = (class255)class255.field3419.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class255.field3411.getConfigData(32, var0);
         var1 = new class255();
         if(var2 != null) {
            var1.method4501(new Buffer(var2));
         }

         class255.field3419.put(var1, (long)var0);
         return var1;
      }
   }
}
