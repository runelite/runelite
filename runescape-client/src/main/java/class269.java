import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
public class class269 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "2102156443"
   )
   public static boolean method4849(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
