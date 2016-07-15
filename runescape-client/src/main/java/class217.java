import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class217 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -9059662616743621037L
   )
   public final long field3192;
   @ObfuscatedName("c")
   public final class223 field3194;
   @ObfuscatedName("h")
   String field3195;
   @ObfuscatedName("r")
   String field3196;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -182406389
   )
   public final int field3197;

   class217(class122 var1, byte var2, int var3) {
      this.field3195 = var1.method2617();
      this.field3196 = var1.method2617();
      this.field3197 = var1.method2612();
      this.field3192 = var1.method2615();
      int var4 = var1.method2614();
      int var5 = var1.method2614();
      this.field3194 = new class223();
      this.field3194.method4084(2);
      this.field3194.method4090(var2);
      this.field3194.field3215 = var4;
      this.field3194.field3213 = var5;
      this.field3194.field3217 = 0;
      this.field3194.field3218 = 0;
      this.field3194.field3214 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1633751934"
   )
   public String method4035() {
      return this.field3195;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1821719300"
   )
   public String method4037() {
      return this.field3196;
   }
}
