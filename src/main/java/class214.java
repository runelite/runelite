import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hn")
public class class214 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 5850702340937648831L
   )
   public final long field3154;
   @ObfuscatedName("t")
   public final class220 field3156;
   @ObfuscatedName("p")
   String field3157;
   @ObfuscatedName("e")
   String field3158;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2038622679
   )
   public final int field3160;

   class214(class119 var1, byte var2, int var3) {
      this.field3157 = var1.method2683();
      this.field3158 = var1.method2683();
      this.field3160 = var1.method2508();
      this.field3154 = var1.method2512();
      int var4 = var1.method2511();
      int var5 = var1.method2511();
      this.field3156 = new class220();
      this.field3156.method4002(2);
      this.field3156.method3998(var2);
      this.field3156.field3173 = var4;
      this.field3156.field3174 = var5;
      this.field3156.field3171 = 0;
      this.field3156.field3176 = 0;
      this.field3156.field3172 = var3;
   }

   @ObfuscatedName("x")
   public String method3963() {
      return this.field3158;
   }

   @ObfuscatedName("w")
   public String method3964() {
      return this.field3157;
   }
}
