import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class178 extends class207 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -591306313
   )
   public final int field2950;
   @ObfuscatedName("r")
   public final int[] field2951;
   @ObfuscatedName("mk")
   static byte field2952;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 434504629
   )
   public final int field2953;
   @ObfuscatedName("e")
   public final int[] field2954;

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2953 = var1;
      this.field2950 = var2;
      this.field2951 = var3;
      this.field2954 = var4;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-107"
   )
   public boolean method3599(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2954.length) {
         int var3 = this.field2954[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2951[var2]) {
            return true;
         }
      }

      return false;
   }
}
