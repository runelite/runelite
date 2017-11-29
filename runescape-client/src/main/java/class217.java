import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class217 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1109817733
   )
   public final int field2683;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 217662459
   )
   public final int field2682;
   @ObfuscatedName("k")
   public final int[] field2681;
   @ObfuscatedName("z")
   public final int[] field2684;

   class217(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2683 = var1;
      this.field2682 = var2;
      this.field2681 = var3;
      this.field2684 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-41"
   )
   public boolean method4095(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2684.length) {
         int var3 = this.field2684[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2681[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILho;I)I",
      garbageValue = "1258986084"
   )
   public static int method4099(int var0, class226 var1) {
      return var1.field2874 + (var0 + 40000 << 8);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lid;II)Z",
      garbageValue = "-1786279784"
   )
   public static boolean method4094(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         class115.decodeSprite(var2);
         return true;
      }
   }
}
