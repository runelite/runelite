import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("o")
   public static Applet field2198;
   @ObfuscatedName("k")
   public static String field2194;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1461760579
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("h")
   String field2197;
   @ObfuscatedName("m")
   @Export("parent")
   Throwable parent;

   RunException(Throwable var1, String var2) {
      this.field2197 = var2;
      this.parent = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljf;IIS)Z",
      garbageValue = "23272"
   )
   static boolean method3215(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Area.decodeSprite(var3);
         return true;
      }
   }
}
