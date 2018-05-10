import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ez")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("w")
   public static Applet field1957;
   @ObfuscatedName("m")
   public static String field1958;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1361964555
   )
   public static int field1959;
   @ObfuscatedName("f")
   String field1960;
   @ObfuscatedName("n")
   @Export("parent")
   Throwable parent;

   RunException(Throwable var1, String var2) {
      this.field1960 = var2;
      this.parent = var1;
   }
}
