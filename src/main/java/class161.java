import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public final class class161 {
   @ObfuscatedName("a")
   public static final char[] field2630 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("ik")
   static class172 field2632;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1243342795
   )
   static int field2633;

   @ObfuscatedName("a")
   static class132 method3203() {
      try {
         return new class146();
      } catch (Throwable var1) {
         return new class140();
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "73718226"
   )
   static final void method3208(class37 var0) {
      var0.field815 = false;
      class42 var1;
      if(var0.field840 != -1) {
         var1 = class134.method2875(var0.field840);
         if(var1 != null && null != var1.field988) {
            ++var0.field842;
            if(var0.field841 < var1.field988.length && var0.field842 > var1.field990[var0.field841]) {
               var0.field842 = 1;
               ++var0.field841;
               class25.method633(var1, var0.field841, var0.field870, var0.field813);
            }

            if(var0.field841 >= var1.field988.length) {
               var0.field842 = 0;
               var0.field841 = 0;
               class25.method633(var1, var0.field841, var0.field870, var0.field813);
            }
         } else {
            var0.field840 = -1;
         }
      }

      if(var0.field859 != -1 && client.field303 >= var0.field868) {
         if(var0.field849 < 0) {
            var0.field849 = 0;
         }

         int var3 = class24.method595(var0.field859).field1012;
         if(-1 != var3) {
            class42 var2 = class134.method2875(var3);
            if(null != var2 && null != var2.field988) {
               ++var0.field850;
               if(var0.field849 < var2.field988.length && var0.field850 > var2.field990[var0.field849]) {
                  var0.field850 = 1;
                  ++var0.field849;
                  class25.method633(var2, var0.field849, var0.field870, var0.field813);
               }

               if(var0.field849 >= var2.field988.length && (var0.field849 < 0 || var0.field849 >= var2.field988.length)) {
                  var0.field859 = -1;
               }
            } else {
               var0.field859 = -1;
            }
         } else {
            var0.field859 = -1;
         }
      }

      if(-1 != var0.field869 && var0.field846 <= 1) {
         var1 = class134.method2875(var0.field869);
         if(1 == var1.field999 && var0.field861 > 0 && var0.field857 <= client.field303 && var0.field863 < client.field303) {
            var0.field846 = 1;
            return;
         }
      }

      if(-1 != var0.field869 && 0 == var0.field846) {
         var1 = class134.method2875(var0.field869);
         if(null != var1 && var1.field988 != null) {
            ++var0.field856;
            if(var0.field844 < var1.field988.length && var0.field856 > var1.field990[var0.field844]) {
               var0.field856 = 1;
               ++var0.field844;
               class25.method633(var1, var0.field844, var0.field870, var0.field813);
            }

            if(var0.field844 >= var1.field988.length) {
               var0.field844 -= var1.field1000 * -1;
               ++var0.field847;
               if(var0.field847 >= var1.field998) {
                  var0.field869 = -1;
               } else if(var0.field844 >= 0 && var0.field844 < var1.field988.length) {
                  class25.method633(var1, var0.field844, var0.field870, var0.field813);
               } else {
                  var0.field869 = -1;
               }
            }

            var0.field815 = var1.field994;
         } else {
            var0.field869 = -1;
         }
      }

      if(var0.field846 > 0) {
         --var0.field846;
      }

   }
}
