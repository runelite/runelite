import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class147 extends RuntimeException {
   @ObfuscatedName("s")
   String field2208;
   @ObfuscatedName("r")
   public static String field2209;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1039296895
   )
   static int field2210;
   @ObfuscatedName("a")
   static Applet field2211;
   @ObfuscatedName("y")
   Throwable field2212;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -521676429
   )
   @Export("baseX")
   static int field2214;

   @ObfuscatedName("qo")
   protected static final void method3130() {
      class28.field682.vmethod3128();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         class143.field2186[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         class143.field2191[var0] = 0L;
      }

      class43.field1022 = 0;
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(Lclass172;IIII)V",
      garbageValue = "1225553365"
   )
   static final void method3132(class172 var0, int var1, int var2) {
      class174 var3 = var0.method3433(false);
      if(null != var3) {
         if(client.field530 < 3) {
            class149.field2236.method1780(var1, var2, var3.field2884, var3.field2883, 25, 25, client.field495, 256, var3.field2886, var3.field2885);
         } else {
            class79.method1839(var1, var2, 0, var3.field2886, var3.field2885);
         }

      }
   }
}
