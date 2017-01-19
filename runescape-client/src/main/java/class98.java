import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class98 extends class109 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -2759279036599790975L
   )
   long field1643 = System.nanoTime();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-386451580"
   )
   public void vmethod1992() {
      this.field1643 = System.nanoTime();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1247412707"
   )
   int vmethod1991(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field1643 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      Projectile.method757(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1643 < var7); this.field1643 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1643 < var7) {
         this.field1643 = var7;
      }

      return var9;
   }
}
