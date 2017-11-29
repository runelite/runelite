import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("d")
   public static Applet field2126;
   @ObfuscatedName("x")
   @Export("localPlayerName")
   public static String localPlayerName;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 136952087
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("z")
   String field2129;
   @ObfuscatedName("v")
   Throwable field2130;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-111"
   )
   public static boolean method3060(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class273.cp1252AsciiExtension;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
