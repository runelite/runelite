import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
public class class124 {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 955719815
   )
   protected static int field2039;

   @ObfuscatedName("dd")
   static final boolean method2788(class173 var0) {
      int var1 = var0.field2890;
      if(var1 == 205) {
         client.field346 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field309.method3528(var2, 1 == var3);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field309.method3493(var2, 1 == var3);
         }

         if(var1 == 324) {
            client.field309.method3494(false);
         }

         if(325 == var1) {
            client.field309.method3494(true);
         }

         if(326 == var1) {
            client.field318.method2757(208);
            client.field309.method3506(client.field318);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("t")
   public static final boolean method2790() {
      class137 var0 = class137.field2131;
      synchronized(class137.field2131) {
         if(class137.field2140 == class137.field2138) {
            return false;
         } else {
            class137.field2118 = class137.field2122[class137.field2138];
            class33.field772 = class137.field2134[class137.field2138];
            class137.field2138 = 1 + class137.field2138 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("w")
   public static boolean method2791(class167 var0, class167 var1, class167 var2, class184 var3) {
      class183.field2969 = var0;
      class183.field2965 = var1;
      class183.field2966 = var2;
      class183.field2967 = var3;
      return true;
   }

   @ObfuscatedName("bh")
   static class107 method2792(int var0, int var1) {
      client.field373.field1892 = var0;
      client.field373.field1887 = var1;
      client.field373.field1888 = 1;
      client.field373.field1889 = 1;
      return client.field373;
   }
}
