import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ej")
public class class147 extends class133 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 7972711993628300363L
   )
   long field2217 = System.nanoTime();

   @ObfuscatedName("e")
   public void vmethod3115() {
      this.field2217 = System.nanoTime();
   }

   @ObfuscatedName("w")
   int vmethod3116(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2217 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class130.method2818(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2217 < var7); this.field2217 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2217 < var7) {
         this.field2217 = var7;
      }

      return var9;
   }
}
