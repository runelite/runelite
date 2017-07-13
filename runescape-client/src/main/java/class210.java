import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class210 extends CacheableNode {
   @ObfuscatedName("r")
   public final int[] field2602;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 258254517
   )
   public final int field2600;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2132605013
   )
   public final int field2599;
   @ObfuscatedName("n")
   public final int[] field2601;

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2600 = var1;
      this.field2599 = var2;
      this.field2601 = var3;
      this.field2602 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean method3908(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2602.length) {
         int var3 = this.field2602[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2601[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "601873716"
   )
   static ModIcon[] method3911() {
      ModIcon[] var0 = new ModIcon[class286.field3794];

      for(int var1 = 0; var1 < class286.field3794; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class286.field3793;
         var2.originalHeight = class286.field3792;
         var2.offsetX = class286.field3795[var1];
         var2.offsetY = class31.offsetsY[var1];
         var2.originalWidth = class286.field3797[var1];
         var2.height = class90.field1405[var1];
         var2.palette = class286.field3796;
         var2.pixels = class177.spritePixels[var1];
      }

      class18.method138();
      return var0;
   }
}
