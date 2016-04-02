import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("u")
final class class21 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 532126463
   )
   protected static int field575;

   public int compare(Object var1, Object var2) {
      return this.method569((class214)var1, (class214)var2);
   }

   @ObfuscatedName("e")
   int method569(class214 var1, class214 var2) {
      if(var1.field3149 == var2.field3149) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3149 == client.field279) {
               return -1;
            }

            if(client.field279 == var2.field3149) {
               return 1;
            }
         }

         return var1.field3149 < var2.field3149?-1:1;
      }
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   public static void method578() {
      class39.field866.method3760();
      class39.field861.method3760();
   }

   @ObfuscatedName("df")
   static boolean method579(class173 var0) {
      if(client.field448) {
         if(class75.method1642(var0) != 0) {
            return false;
         }

         if(0 == var0.field2757) {
            return false;
         }
      }

      return var0.field2775;
   }
}
