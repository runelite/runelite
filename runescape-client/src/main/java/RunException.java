import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fm")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 2096836297
   )
   static int field2173;
   @ObfuscatedName("z")
   public static String field2172;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -157723393
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("r")
   String field2171;
   @ObfuscatedName("e")
   Throwable field2169;
}
