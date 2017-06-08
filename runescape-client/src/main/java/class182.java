import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class182 {
   @ObfuscatedName("p")
   static final String[] field2451;
   @ObfuscatedName("n")
   static final String[][] field2452;
   @ObfuscatedName("i")
   static Calendar field2457;

   static {
      field2452 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2451 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2457 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIIZI)V",
      garbageValue = "-742427163"
   )
   public static void method3430(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2515 = 1;
      class203.field2516 = var0;
      class158.field2275 = var1;
      class275.field3730 = var2;
      FileOnDisk.field1774 = var3;
      class271.field3690 = var4;
      class155.field2261 = 10000;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "44967151"
   )
   static int method3431(int var0) {
      MessageNode var1 = (MessageNode)class98.field1524.method3493((long)var0);
      return var1 == null?-1:(class98.field1525.field2501 == var1.previous?-1:((MessageNode)var1.previous).id);
   }
}
