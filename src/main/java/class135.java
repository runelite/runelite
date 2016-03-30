import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ep")
public class class135 {
   @ObfuscatedName("t")
   static Hashtable field2095 = new Hashtable(16);
   @ObfuscatedName("x")
   static File field2096;
   @ObfuscatedName("w")
   static boolean field2100 = false;

   @ObfuscatedName("t")
   static int method2881(class122 var0) {
      int var1 = var0.method2777(2);
      int var2;
      if(0 == var1) {
         var2 = 0;
      } else if(1 == var1) {
         var2 = var0.method2777(5);
      } else if(2 == var1) {
         var2 = var0.method2777(8);
      } else {
         var2 = var0.method2777(11);
      }

      return var2;
   }
}
