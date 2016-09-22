import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class150 extends class136 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 4542790369875822217L
   )
   long field2288 = System.nanoTime();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2077774028"
   )
   public void vmethod3147() {
      this.field2288 = System.nanoTime();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1886051607"
   )
   int vmethod3149(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2288 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      Item.method681(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2288 < var7); this.field2288 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2288 < var7) {
         this.field2288 = var7;
      }

      return var9;
   }
}
