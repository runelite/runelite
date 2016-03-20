import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ep")
public class class146 extends class132 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -7010702844904865449L
   )
   long field2207 = System.nanoTime();

   @ObfuscatedName("f")
   int vmethod3122(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2207 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class103.method2301(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2207 < var7); this.field2207 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2207 < var7) {
         this.field2207 = var7;
      }

      return var9;
   }

   @ObfuscatedName("r")
   void vmethod3128() {
      this.field2207 = System.nanoTime();
   }
}
