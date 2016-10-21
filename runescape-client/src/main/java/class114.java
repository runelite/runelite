import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class114 {
   @ObfuscatedName("e")
   static final String[] field2008 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("n")
   static Calendar field2009;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 447226099
   )
   static int field2011;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -325403643
   )
   static int field2013;
   @ObfuscatedName("f")
   static final String[][] field2015 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-332164239"
   )
   static void method2456(File var0) {
      class138.field2136 = var0;
      if(!class138.field2136.exists()) {
         throw new RuntimeException("");
      } else {
         class138.field2139 = true;
      }
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2009 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1972137312"
   )
   static final void method2458(int var0) {
      if(class171.method3404(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2910 = 0;
               var3.field2911 = 0;
            }
         }

      }
   }
}
