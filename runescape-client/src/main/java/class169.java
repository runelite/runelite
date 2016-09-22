import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class169 {
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1033249211"
   )
   static final void method3301(String var0, int var1) {
      Client.field323.method2801(36);
      Client.field323.method2513(ChatMessages.method229(var0) + 1);
      Client.field323.method2519(var0);
      Client.field323.method2513(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-614428390"
   )
   public static void method3304(class170 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3324(var1);
      int var6 = var0.method3313(var5, var2);
      class50.method1046(var0, var5, var6, var3, var4);
   }
}
