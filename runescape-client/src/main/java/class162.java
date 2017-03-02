import java.awt.Component;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class162 {
   @ObfuscatedName("b")
   static final String[][] field2140 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("i")
   static Calendar field2141;
   @ObfuscatedName("l")
   static final String[] field2143 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2141 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "1123107358"
   )
   static final void method3169(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field571 == 0) {
         var1 = Varbit.region.method1825(var0.field587, var0.field573, var0.field583);
      }

      if(var0.field571 == 1) {
         var1 = Varbit.region.method1851(var0.field587, var0.field573, var0.field583);
      }

      if(var0.field571 == 2) {
         var1 = Varbit.region.method1784(var0.field587, var0.field573, var0.field583);
      }

      if(var0.field571 == 3) {
         var1 = Varbit.region.method1785(var0.field587, var0.field573, var0.field583);
      }

      if(var1 != 0) {
         int var5 = Varbit.region.method1786(var0.field587, var0.field573, var0.field583, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field574 = var2;
      var0.field576 = var3;
      var0.field572 = var4;
   }

   class162() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-23868892"
   )
   public static void method3172(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "51"
   )
   public static void method3173(boolean var0) {
      if(var0 != ItemComposition.isMembersWorld) {
         XItemContainer.method176();
         ItemComposition.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("b")
   public static String method3174(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3086[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "-30"
   )
   public static void method3175(class182 var0) {
      class186.field2764 = var0;
   }
}
