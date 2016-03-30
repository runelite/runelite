import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("am")
public class class27 {
   @ObfuscatedName("x")
   class35[] field674 = new class35[100];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 64435663
   )
   int field675;
   @ObfuscatedName("qs")
   protected static class133 field679;

   @ObfuscatedName("w")
   class35 method647(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field674[99];

      for(int var6 = this.field675; var6 > 0; --var6) {
         if(100 != var6) {
            this.field674[var6] = this.field674[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3935();
         var5.method3909();
         var5.method750(var1, var2, var4, var3);
      }

      this.field674[0] = var5;
      if(this.field675 < 100) {
         ++this.field675;
      }

      return var5;
   }

   @ObfuscatedName("x")
   class35 method649(int var1) {
      return var1 >= 0 && var1 < this.field675?this.field674[var1]:null;
   }

   @ObfuscatedName("t")
   int method650() {
      return this.field675;
   }
}
