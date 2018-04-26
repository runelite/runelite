import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("g")
   public static Applet field2168;
   @ObfuscatedName("e")
   public static String field2169;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1614496727
   )
   public static int field2170;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -1779827785
   )
   static int field2173;
   @ObfuscatedName("n")
   String field2171;
   @ObfuscatedName("l")
   @Export("parent")
   Throwable parent;

   RunException(Throwable var1, String var2) {
      this.field2171 = var2;
      this.parent = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-383753531"
   )
   public static void method3308(String var0, boolean var1, boolean var2) {
      NetWriter.method2154(var0, var1, "openjs", var2);
   }
}
