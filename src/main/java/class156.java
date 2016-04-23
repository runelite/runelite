import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class156 {
   @ObfuscatedName("pv")
   static GarbageCollectorMXBean field2283;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -906387845
   )
   static int field2294;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass39;",
      garbageValue = "-1038596759"
   )
   public static class39 method3130(int var0) {
      class39 var1 = (class39)class39.field902.method3704((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class39.field895.method3217(9, var0);
         var1 = new class39();
         var1.field898 = var0;
         if(null != var2) {
            var1.method756(new class119(var2));
         }

         var1.method782();
         class39.field902.method3706(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "980967115"
   )
   static final void method3131(int var0, int var1, int var2, boolean var3) {
      if(class107.method2374(var0)) {
         class150.method3116(class173.field2735[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1958058071"
   )
   public static String method3132(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class45.method947(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
