import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class189 {
   @ObfuscatedName("d")
   public static final String[][] field2538;
   @ObfuscatedName("x")
   public static final String[] field2539;
   @ObfuscatedName("k")
   public static Calendar field2537;

   static {
      field2538 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2539 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2537 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lfq;",
      garbageValue = "-2063453939"
   )
   public static PacketNode method3610() {
      PacketNode var0 = class89.method1765();
      var0.clientPacket = null;
      var0.field2421 = 0;
      var0.packetBuffer = new PacketBuffer(5000);
      return var0;
   }
}
