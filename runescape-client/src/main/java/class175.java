import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class175 extends class204 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1693306819
   )
   public final int field2917;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1046451177
   )
   public final int field2918;
   @ObfuscatedName("h")
   public final int[] field2920;
   @ObfuscatedName("g")
   public final int[] field2922;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1045921810"
   )
   public boolean method3413(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2920.length) {
         int var3 = this.field2920[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2922[var2]) {
            return true;
         }
      }

      return false;
   }

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2918 = var1;
      this.field2917 = var2;
      this.field2922 = var3;
      this.field2920 = var4;
   }
}
