import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class138 {
   @ObfuscatedName("em")
   static class78[] field2134;
   @ObfuscatedName("w")
   public static String field2135 = null;
   @ObfuscatedName("a")
   public static Applet field2137 = null;

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1450085911"
   )
   static final void method3042() {
      client.field338.method2873(157);

      for(class3 var0 = (class3)client.field453.method3871(); null != var0; var0 = (class3)client.field453.method3867()) {
         if(0 == var0.field72 || 3 == var0.field72) {
            class31.method777(var0, true);
         }
      }

      if(null != client.field526) {
         class23.method657(client.field526);
         client.field526 = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CS)C",
      garbageValue = "-4917"
   )
   static char method3044(char var0) {
      return 181 != var0 && var0 != 402?Character.toTitleCase(var0):var0;
   }
}
