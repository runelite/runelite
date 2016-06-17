import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class214 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2014931379
   )
   public final int field3147;
   @ObfuscatedName("j")
   public final class220 field3148;
   @ObfuscatedName("d")
   String field3149;
   @ObfuscatedName("x")
   String field3150;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -777915117119718883L
   )
   public final long field3151;

   class214(class119 var1, byte var2, int var3) {
      this.field3149 = var1.method2522();
      this.field3150 = var1.method2522();
      this.field3147 = var1.method2516();
      this.field3151 = var1.method2699();
      int var4 = var1.method2519();
      int var5 = var1.method2519();
      this.field3148 = new class220();
      this.field3148.method3999(2);
      this.field3148.method4000(var2);
      this.field3148.field3172 = var4;
      this.field3148.field3175 = var5;
      this.field3148.field3174 = 0;
      this.field3148.field3177 = 0;
      this.field3148.field3173 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1787810471"
   )
   public String method3946() {
      return this.field3149;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "24"
   )
   public String method3949() {
      return this.field3150;
   }
}
