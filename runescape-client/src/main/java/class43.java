import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class43 {
   @ObfuscatedName("v")
   int[][] field565;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -129373971
   )
   int field566;
   @ObfuscatedName("y")
   int[][] field567;
   @ObfuscatedName("b")
   int[][] field569;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -792352917
   )
   int field571;
   @ObfuscatedName("e")
   int[][] field574;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILFloorUnderlayDefinition;I)V",
      garbageValue = "-871835980"
   )
   void method599(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var1 + var3 >= 0 && var2 + var3 >= 0) {
            if(var1 - var3 <= this.field571 && var2 - var3 <= this.field566) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field571, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field566, var2 + var3);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field574[var9][var10] += var4.field3337 * 256 / var4.field3342;
                     this.field565[var9][var10] += var4.field3341;
                     this.field569[var9][var10] += var4.field3343;
                     ++this.field567[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "64"
   )
   class43(int var1, int var2) {
      this.field571 = var1;
      this.field566 = var2;
      this.field574 = new int[var1][var2];
      this.field565 = new int[var1][var2];
      this.field569 = new int[var1][var2];
      this.field567 = new int[var1][var2];
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "124"
   )
   static void method602(int var0, int var1, int var2) {
      if(Client.field1168 != 0 && var1 != 0 && Client.field1061 < 50) {
         Client.field1171[Client.field1061] = var0;
         Client.field1018[Client.field1061] = var1;
         Client.field1028[Client.field1061] = var2;
         Client.field1008[Client.field1061] = null;
         Client.field956[Client.field1061] = 0;
         ++Client.field1061;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "32767"
   )
   int method603(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field571 && var2 < this.field566) {
         if(this.field569[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field574[var1][var2] / this.field567[var1][var2];
            int var4 = this.field565[var1][var2] / this.field567[var1][var2];
            int var5 = this.field569[var1][var2] / this.field567[var1][var2];
            return class54.method778((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }
}
