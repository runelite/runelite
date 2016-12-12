import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1907433425
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -521426357
   )
   int field661;
   @ObfuscatedName("p")
   static int[] field662;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1414056125
   )
   int field664;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -810870241
   )
   int field666;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "17"
   )
   void method588(int var1, int var2, int var3, int var4) {
      this.field661 = var1;
      this.healthRatio = var2;
      this.field666 = var3;
      this.field664 = var4;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field661 = var1;
      this.healthRatio = var2;
      this.field666 = var3;
      this.field664 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1958363218"
   )
   public static char method589(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }
}
