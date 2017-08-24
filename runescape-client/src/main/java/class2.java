import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class2 implements class0 {
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("q")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("b")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "632939174"
   )
   public static String method3(int var0, boolean var1) {
      return var1 && var0 >= 0?class216.method4024(var0, 10, var1):Integer.toString(var0);
   }
}
