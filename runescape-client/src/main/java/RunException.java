import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("n")
   public static Applet field2140;
   @ObfuscatedName("v")
   @Export("localPlayerName")
   public static String localPlayerName;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("r")
   String field2136;
   @ObfuscatedName("h")
   Throwable field2139;
}
