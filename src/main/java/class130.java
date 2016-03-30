import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eh")
public class class130 {
   @ObfuscatedName("t")
   static final class130 field2064 = new class130(2);
   @ObfuscatedName("w")
   static final class130 field2065 = new class130(0);
   @ObfuscatedName("x")
   public static final class130 field2066 = new class130(1);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 668139557
   )
   public final int field2067;

   class130(int var1) {
      this.field2067 = var1;
   }

   @ObfuscatedName("x")
   static void method2833(int var0, byte[] var1, class134 var2) {
      class169 var3 = new class169();
      var3.field2723 = 0;
      var3.field3123 = (long)var0;
      var3.field2721 = var1;
      var3.field2722 = var2;
      class199 var4 = class170.field2729;
      synchronized(class170.field2729) {
         class170.field2729.method3834(var3);
      }

      Object var9 = class170.field2726;
      synchronized(class170.field2726) {
         if(0 == class170.field2728) {
            class123.field2036.method2889(new class170(), 5);
         }

         class170.field2728 = 600;
      }
   }

   @ObfuscatedName("dz")
   static boolean method2834(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class142.method2997(var0, class164.field2678);

         for(int var3 = 0; var3 < client.field561; ++var3) {
            if(var2.equalsIgnoreCase(class142.method2997(client.field474[var3].field260, class164.field2678)) && (!var1 || 0 != client.field474[var3].field255)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class142.method2997(class167.field2692.field59, class164.field2678))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
