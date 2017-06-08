import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class43 {
   @ObfuscatedName("f")
   int[][] field565;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1639347541
   )
   int field566;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -483750905
   )
   int field567;
   @ObfuscatedName("j")
   int[][] field568;
   @ObfuscatedName("x")
   static int[] field569;
   @ObfuscatedName("m")
   int[][] field570;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -35063535
   )
   static int field571;
   @ObfuscatedName("i")
   int[][] field572;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILFloorUnderlayDefinition;I)V",
      garbageValue = "-1432679522"
   )
   void method602(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var1 + var3 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field567 && var2 - var3 <= this.field566) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field567, var1 + var3);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field566, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field572[var9][var10] += var4.field3346 * 256 / var4.field3349;
                     this.field568[var9][var10] += var4.field3347;
                     this.field565[var9][var10] += var4.field3348;
                     ++this.field570[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1486120223"
   )
   int method603(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field567 && var2 < this.field566) {
         if(this.field565[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field572[var1][var2] / this.field570[var1][var2];
            int var4 = this.field568[var1][var2] / this.field570[var1][var2];
            int var5 = this.field565[var1][var2] / this.field570[var1][var2];
            return class88.method1693((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "64"
   )
   class43(int var1, int var2) {
      this.field567 = var1;
      this.field566 = var2;
      this.field572 = new int[var1][var2];
      this.field568 = new int[var1][var2];
      this.field565 = new int[var1][var2];
      this.field570 = new int[var1][var2];
   }
}
