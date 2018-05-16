import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class274 {
   @ObfuscatedName("ay")
   static int[] field3569;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)[Lik;",
      garbageValue = "-20"
   )
   public static Permission[] method5249() {
      return new Permission[]{Permission.field3139, Permission.field3140, Permission.field3137, Permission.field3145, Permission.field3135, Permission.field3138};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "479413406"
   )
   static void method5248() {
      if(class78.Login_isUsernameRemembered && class78.username != null && class78.username.length() > 0) {
         class78.currentLoginField = 1;
      } else {
         class78.currentLoginField = 0;
      }

   }
}
