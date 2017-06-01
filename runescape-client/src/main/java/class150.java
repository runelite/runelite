import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class150 extends class158 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 4882155417758306549L
   )
   long field2222;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   public void vmethod2971() {
      this.field2222 = System.nanoTime();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-472854462"
   )
   public int vmethod2972(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2222 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class4.method9(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2222 < var7); this.field2222 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2222 < var7) {
         this.field2222 = var7;
      }

      return var9;
   }

   public class150() {
      this.field2222 = System.nanoTime();
   }
}
