import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class111 {
   @ObfuscatedName("j")
   public static final String[] field1963 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("p")
   public static Calendar field1964;
   @ObfuscatedName("s")
   public static final String[][] field1966 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "617766816"
   )
   public static void method2419() {
      class179.field2935.method3750();
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Lclass173;",
      garbageValue = "113"
   )
   static class173 method2420(class173 var0) {
      int var1 = class165.method3216(class48.method962(var0));
      if(0 == var1) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class29.method645(var0.field2784);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-668076572"
   )
   static void method2421(int var0, int var1) {
      if(0 != client.field516 && -1 != var0) {
         class82.method1869(class3.field65, var0, 0, client.field516, false);
         client.field518 = true;
      }

   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1964 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
