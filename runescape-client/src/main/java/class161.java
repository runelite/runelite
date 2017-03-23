import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class161 {
   @ObfuscatedName("gn")
   static Widget field2160;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "94"
   )
   static String method3136() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class47.field949.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "1"
   )
   static final boolean method3138(Widget var0) {
      if(null == var0.field2224) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2224.length; ++var1) {
            int var2 = NPC.method748(var0, var1);
            int var3 = var0.field2333[var1];
            if(var0.field2224[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2224[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2224[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   class161() throws Throwable {
      throw new Error();
   }
}
