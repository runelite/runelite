import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class162 {
   @ObfuscatedName("o")
   static final String[][] field2156 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("m")
   static final String[] field2157 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("b")
   static Calendar field2158;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2158 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "4"
   )
   static void method3012(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class181 var4 = (class181)class185.field2759.method2299(var2);
      if(null != var4) {
         class185.field2762.method2248(var4);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "-847413116"
   )
   public static String method3013(CharSequence var0, class228 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class94.method1868(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class94.method1868(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3234) {
               case 0:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var9 = new StringBuilder(var4);

               for(int var10 = var2; var10 < var3; ++var10) {
                  char var7 = var0.charAt(var10);
                  if(class72.method1384(var7)) {
                     char var8 = KitDefinition.method3426(var7);
                     if(var8 != 0) {
                        var9.append(var8);
                     }
                  }
               }

               if(var9.length() == 0) {
                  return null;
               }

               return var9.toString();
            }
         }

         return null;
      }
   }
}
