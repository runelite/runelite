import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class182 {
   @ObfuscatedName("d")
   public static final String[][] field2460;
   @ObfuscatedName("k")
   public static final String[] field2458;
   @ObfuscatedName("e")
   public static Calendar field2459;

   static {
      field2460 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2458 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2459 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lir;",
      garbageValue = "-274583188"
   )
   static class239[] method3547() {
      return new class239[]{class239.field3277, class239.field3273, class239.field3274};
   }
}
