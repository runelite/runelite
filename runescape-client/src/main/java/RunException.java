import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("s")
   public static Applet field2122;
   @ObfuscatedName("g")
   public static String field2117;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 121981819
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("dx")
   @Export("host")
   static String host;
   @ObfuscatedName("h")
   String field2119;
   @ObfuscatedName("i")
   Throwable field2120;
}
