import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class191 {
   @ObfuscatedName("a")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-81"
   )
   static boolean method3509(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
