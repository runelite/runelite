import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hx")
public class class214 {
   @ObfuscatedName("f")
   public final class220 field3146;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 8222344070006396279L
   )
   public final long field3147;
   @ObfuscatedName("s")
   String field3148;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1067212417
   )
   public final int field3149;
   @ObfuscatedName("p")
   String field3150;

   class214(class119 var1, byte var2, int var3) {
      this.field3148 = var1.method2531();
      this.field3150 = var1.method2531();
      this.field3149 = var1.method2700();
      this.field3147 = var1.method2529();
      int var4 = var1.method2528();
      int var5 = var1.method2528();
      this.field3146 = new class220();
      this.field3146.method3993(2);
      this.field3146.method3982(var2);
      this.field3146.field3167 = var4;
      this.field3146.field3170 = var5;
      this.field3146.field3171 = 0;
      this.field3146.field3168 = 0;
      this.field3146.field3169 = var3;
   }

   @ObfuscatedName("e")
   public String method3939() {
      return this.field3148;
   }

   @ObfuscatedName("w")
   public String method3940() {
      return this.field3150;
   }
}
