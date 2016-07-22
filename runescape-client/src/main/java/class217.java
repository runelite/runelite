import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class217 {
   @ObfuscatedName("pi")
   static class137 field3196;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -2518772429720772909L
   )
   public final long field3197;
   @ObfuscatedName("e")
   public final class223 field3198;
   @ObfuscatedName("ak")
   static class171 field3199;
   @ObfuscatedName("g")
   String field3200;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -582058121
   )
   public final int field3201;
   @ObfuscatedName("o")
   String field3202;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1160358045"
   )
   public String method4027() {
      return this.field3200;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1973792254"
   )
   public String method4031() {
      return this.field3202;
   }

   class217(class122 var1, byte var2, int var3) {
      this.field3202 = var1.method2580();
      this.field3200 = var1.method2580();
      this.field3201 = var1.method2706();
      this.field3197 = var1.method2578();
      int var4 = var1.method2577();
      int var5 = var1.method2577();
      this.field3198 = new class223();
      this.field3198.method4068(2);
      this.field3198.method4069(var2);
      this.field3198.field3217 = var4;
      this.field3198.field3220 = var5;
      this.field3198.field3221 = 0;
      this.field3198.field3219 = 0;
      this.field3198.field3218 = var3;
   }
}
