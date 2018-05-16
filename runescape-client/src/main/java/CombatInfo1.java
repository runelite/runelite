import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field944;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -840135193
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2000565355
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2113659133
   )
   @Export("health")
   int health;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1324315633
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-789024602"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1790686135"
   )
   static final void method1601(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class50.field449[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class50.tileHeights[0][var5][var4] = class50.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class50.tileHeights[0][var5][var4] = class50.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class50.tileHeights[0][var5][var4] = class50.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class50.tileHeights[0][var5][var4] = class50.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
