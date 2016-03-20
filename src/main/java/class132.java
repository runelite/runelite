import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public abstract class class132 {
   @ObfuscatedName("n")
   static class211 field2062;

   @ObfuscatedName("r")
   abstract void vmethod3128();

   @ObfuscatedName("f")
   abstract int vmethod3122(int var1, int var2);

   @ObfuscatedName("g")
   static String method2859() {
      String var0 = "";

      class35 var2;
      for(Iterator var1 = class11.field164.iterator(); var1.hasNext(); var0 = var0 + var2.field791 + ':' + var2.field793 + '\n') {
         var2 = (class35)var1.next();
      }

      return var0;
   }
}
