import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class221 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1407317283
   )
   public final int field2721;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -368889047
   )
   public final int field2718;
   @ObfuscatedName("y")
   public final int[] field2719;
   @ObfuscatedName("r")
   public final int[] field2720;

   class221(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2721 = var1;
      this.field2718 = var2;
      this.field2719 = var3;
      this.field2720 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1271288654"
   )
   public boolean method4141(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2720.length) {
         int var3 = this.field2720[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2719[var2]) {
            return true;
         }
      }

      return false;
   }
}
