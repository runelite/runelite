import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class178 extends CacheableNode {
   @ObfuscatedName("e")
   public final int[] field2946;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 527935703
   )
   public final int field2947;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -210871733
   )
   public final int field2948;
   @ObfuscatedName("g")
   public final int[] field2951;
   @ObfuscatedName("me")
   static SpritePixels field2953;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1463996082"
   )
   public boolean method3475(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2951.length) {
         int var3 = this.field2951[var2];
         if(var1 >= var3 && var1 <= this.field2946[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "838685821"
   )
   public static void method3476() {
      PlayerComposition.field2979.reset();
   }

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2948 = var1;
      this.field2947 = var2;
      this.field2946 = var3;
      this.field2951 = var4;
   }
}
