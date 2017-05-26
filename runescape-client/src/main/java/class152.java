import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class152 extends RuntimeException {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -915272505
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("h")
   public static String field2196;
   @ObfuscatedName("q")
   String field2198;
   @ObfuscatedName("g")
   Throwable field2199;
   @ObfuscatedName("i")
   public static Applet field2201;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -407493319
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-273934086"
   )
   public static boolean method2965(int var0) {
      return (var0 & 1) != 0;
   }
}
