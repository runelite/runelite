import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class170 {
   @ObfuscatedName("o")
   static boolean field2234;
   @ObfuscatedName("k")
   static File field2233;
   @ObfuscatedName("t")
   static Hashtable field2232;

   static {
      field2234 = false;
      field2232 = new Hashtable(16);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "20643"
   )
   public static void method3292() {
      PlayerComposition.field2797.reset();
   }
}
