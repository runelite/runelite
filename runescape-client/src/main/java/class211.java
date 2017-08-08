import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class211 extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 133339081
   )
   protected static int field2580;
   @ObfuscatedName("y")
   public final int[] field2581;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2020973705
   )
   public final int field2577;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -191729773
   )
   public final int field2578;
   @ObfuscatedName("g")
   public final int[] field2579;

   class211(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2577 = var1;
      this.field2578 = var2;
      this.field2579 = var3;
      this.field2581 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1923499807"
   )
   public boolean method3919(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2581.length) {
         int var3 = this.field2581[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2579[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "2012310958"
   )
   public static void method3920(IndexDataBase var0) {
      FloorUnderlayDefinition.underlay_ref = var0;
   }
}
