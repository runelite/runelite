import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class214 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -7445379749963369773L
   )
   public final long field3156;
   @ObfuscatedName("g")
   static int[] field3157;
   @ObfuscatedName("m")
   public final class220 field3158;
   @ObfuscatedName("z")
   String field3159;
   @ObfuscatedName("x")
   String field3160;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1438771051
   )
   public final int field3162;

   class214(class119 var1, byte var2, int var3) {
      this.field3159 = var1.method2508();
      this.field3160 = var1.method2508();
      this.field3162 = var1.method2502();
      this.field3156 = var1.method2506();
      int var4 = var1.method2505();
      int var5 = var1.method2505();
      this.field3158 = new class220();
      this.field3158.method3984(2);
      this.field3158.method3973(var2);
      this.field3158.field3175 = var4;
      this.field3158.field3176 = var5;
      this.field3158.field3173 = 0;
      this.field3158.field3178 = 0;
      this.field3158.field3177 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-1"
   )
   public String method3918() {
      return this.field3160;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "6"
   )
   public String method3920() {
      return this.field3159;
   }
}
