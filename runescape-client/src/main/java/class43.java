import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class43 {
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field569;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1969386109
   )
   int field570;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2053940433
   )
   int field563;
   @ObfuscatedName("g")
   int[][] field571;
   @ObfuscatedName("w")
   int[][] field566;
   @ObfuscatedName("y")
   int[][] field562;
   @ObfuscatedName("k")
   int[][] field568;

   class43(int var1, int var2) {
      this.field570 = var1;
      this.field563 = var2;
      this.field571 = new int[var1][var2];
      this.field562 = new int[var1][var2];
      this.field566 = new int[var1][var2];
      this.field568 = new int[var1][var2];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1670154534"
   )
   int method609(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field570 && var2 < this.field563) {
         if(this.field566[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field571[var1][var2] / this.field568[var1][var2];
            int var4 = this.field562[var1][var2] / this.field568[var1][var2];
            int var5 = this.field566[var1][var2] / this.field568[var1][var2];
            return AbstractSoundSystem.method2082((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILif;I)V",
      garbageValue = "1179248750"
   )
   void method611(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field570 && var2 - var3 <= this.field563) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field570, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field563, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field571[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field562[var9][var10] += var4.saturation;
                     this.field566[var9][var10] += var4.lightness;
                     ++this.field568[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;Lit;I)V",
      garbageValue = "-1778129077"
   )
   public static void method608(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class255.field3411 = var0;
      class255.field3413 = var1;
      class255.field3403 = var2;
   }
}
