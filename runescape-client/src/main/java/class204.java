import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class204 {
   @ObfuscatedName("d")
   static final String[][] field2622;
   @ObfuscatedName("z")
   static final String[] field2620;
   @ObfuscatedName("n")
   static Calendar field2621;

   static {
      field2622 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2620 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2621 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-102"
   )
   public static boolean method3931(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1699058121"
   )
   static void method3930() {
      int var0 = class93.playerIndexesCount;
      int[] var1 = class93.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.field1103 && var1[var2] != Client.localInteractingIndex) {
            VertexNormal.method2844(Client.cachedPlayers[var1[var2]], true);
         }
      }

   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1723115073"
   )
   static final void method3928(int var0) {
      if(class18.loadWidget(var0)) {
         class19.method141(Widget.widgets[var0], -1);
      }
   }
}
