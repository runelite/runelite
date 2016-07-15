import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class114 {
   @ObfuscatedName("e")
   public static final String[][] field2015 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("l")
   public static final String[] field2016 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("c")
   public static Calendar field2017;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1773289255
   )
   protected static int field2019;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1140665336"
   )
   public static void method2511() {
      class182.field2964.method3835();
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2017 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(III)Lclass110;",
      garbageValue = "1337435338"
   )
   static class110 method2512(int var0, int var1) {
      client.field575.field1952 = var0;
      client.field575.field1949 = var1;
      client.field575.field1955 = 1;
      client.field575.field1951 = 1;
      return client.field575;
   }
}
