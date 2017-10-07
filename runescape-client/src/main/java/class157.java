import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class157 {
   @ObfuscatedName("d")
   public static boolean field2265;
   @ObfuscatedName("e")
   static Hashtable field2267;
   @ObfuscatedName("k")
   public static File field2264;

   static {
      field2265 = false;
      field2267 = new Hashtable(16);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1602499210"
   )
   public static void method3056() {
      class252.field3395.reset();
   }
}
