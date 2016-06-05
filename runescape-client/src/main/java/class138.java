import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class138 {
   @ObfuscatedName("i")
   public static String field2155 = null;
   @ObfuscatedName("t")
   public static Applet field2156 = null;
   @ObfuscatedName("ba")
   static class168 field2161;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1478573917
   )
   @Export("cameraPitch")
   static int field2164;

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)I",
      garbageValue = "1267763830"
   )
   static int method2906(class173 var0) {
      class201 var1 = (class201)client.field428.method3748(((long)var0.field2776 << 32) + (long)var0.field2777);
      return null != var1?var1.field3111:var0.field2817;
   }
}
