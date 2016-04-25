import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class138 {
   @ObfuscatedName("h")
   static String field2110 = null;
   @ObfuscatedName("n")
   static class80[] field2111;
   @ObfuscatedName("rc")
   protected static String field2114;
   @ObfuscatedName("j")
   static Applet field2115 = null;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "283818411"
   )
   public static int method2899(int var0, int var1, int var2) {
      var2 &= 3;
      return 0 == var2?var1:(1 == var2?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "546863387"
   )
   static final void method2907(String var0) {
      if(null != class123.field2005) {
         client.field318.method2735(64);
         client.field318.method2503(class116.method2447(var0));
         client.field318.method2491(var0);
      }
   }
}
