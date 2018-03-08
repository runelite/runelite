import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class204 {
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      longValue = 697021873402356309L
   )
   static long field2603;
   @ObfuscatedName("t")
   public static final String[][] field2605;
   @ObfuscatedName("q")
   public static final String[] field2602;
   @ObfuscatedName("i")
   public static Calendar field2606;
   @ObfuscatedName("fk")
   static byte[][] field2601;

   static {
      field2605 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2602 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2606 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "27015928"
   )
   public static void method3854() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1932277581"
   )
   static final void method3855() {
      Client.field892 = Client.cycleCntr;
      ScriptState.field726 = true;
   }
}
