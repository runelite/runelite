import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("b")
   public static Applet field2147;
   @ObfuscatedName("q")
   public static String field2144;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1749454695
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("p")
   String field2146;
   @ObfuscatedName("a")
   Throwable field2143;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method3226() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "366230786"
   )
   static final String method3227(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?BoundingBox3D.getColTags(16711680):(var2 < -6?BoundingBox3D.getColTags(16723968):(var2 < -3?BoundingBox3D.getColTags(16740352):(var2 < 0?BoundingBox3D.getColTags(16756736):(var2 > 9?BoundingBox3D.getColTags(65280):(var2 > 6?BoundingBox3D.getColTags(4259584):(var2 > 3?BoundingBox3D.getColTags(8453888):(var2 > 0?BoundingBox3D.getColTags(12648192):BoundingBox3D.getColTags(16776960))))))));
   }
}
