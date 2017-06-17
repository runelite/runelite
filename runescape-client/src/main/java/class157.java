import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class157 {
   @ObfuscatedName("e")
   static Hashtable field2269;
   @ObfuscatedName("p")
   static boolean field2270;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "100"
   )
   public static boolean method2865(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   static {
      field2270 = false;
      field2269 = new Hashtable(16);
   }
}
