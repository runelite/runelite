import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class33 {
   @ObfuscatedName("n")
   static String field776;
   @ObfuscatedName("w")
   static final class33 field777 = new class33();
   @ObfuscatedName("d")
   static final class33 field778 = new class33();
   @ObfuscatedName("c")
   static final class33 field779 = new class33();
   @ObfuscatedName("cw")
   static class224 field781;
   @ObfuscatedName("a")
   static final class33 field783 = new class33();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "408451640"
   )
   static int method799(int var0, int var1) {
      class15 var2 = (class15)class15.field230.method3868((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.field234.length?var2.field234[var1]:0);
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-534030722"
   )
   static boolean method800(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class23.method672(var0, client.field551);

         for(int var2 = 0; var2 < client.field397; ++var2) {
            class7 var3 = client.field395[var2];
            if(var1.equalsIgnoreCase(class23.method672(var3.field140, client.field551))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class23.method672(var3.field137, client.field551))) {
               return true;
            }
         }

         return false;
      }
   }
}
