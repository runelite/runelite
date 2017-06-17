import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class182 {
   @ObfuscatedName("m")
   static final String[] field2452;
   @ObfuscatedName("e")
   static Calendar field2453;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1627321657
   )
   public static int field2455;
   @ObfuscatedName("p")
   static final String[][] field2456;

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "55"
   )
   static final void method3330(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class59.method961(var0)) {
         class275.method4791(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }

   }

   static {
      field2456 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2452 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2453 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
