import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public final class class176 {
   @ObfuscatedName("o")
   static class182 field2641;

   class176() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-128"
   )
   static final boolean method3255(Widget var0) {
      if(null == var0.field2041) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2041.length; ++var1) {
            int var2 = MessageNode.method214(var0, var1);
            int var3 = var0.field2119[var1];
            if(var0.field2041[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2041[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2041[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
