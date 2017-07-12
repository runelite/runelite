import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class152 extends RuntimeException {
   @ObfuscatedName("v")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 152423061
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("i")
   public static Applet field2238;
   @ObfuscatedName("w")
   public static String field2234;
   @ObfuscatedName("s")
   String field2235;
   @ObfuscatedName("r")
   Throwable field2236;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1633469105"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      WorldMapData.addChatMessage(var0, var1, var2, (String)null);
   }
}
