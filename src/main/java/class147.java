import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class147 extends class133 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -6909766964322307839L
   )
   long field2200 = System.nanoTime();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-708326601"
   )
   int vmethod3089(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2200 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class14.method170(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2200 < var7); this.field2200 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2200 < var7) {
         this.field2200 = var7;
      }

      return var9;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void vmethod3090() {
      this.field2200 = System.nanoTime();
   }
}
