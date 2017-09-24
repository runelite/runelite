import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class183 {
   @ObfuscatedName("i")
   public static final String[][] field2445;
   @ObfuscatedName("j")
   public static final String[] field2446;
   @ObfuscatedName("a")
   public static Calendar field2448;

   static {
      field2445 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2446 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2448 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfn;B)V",
      garbageValue = "49"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = Player.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field923 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class149.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class67.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class27.plane = var2.field910 = var4;
      if(class95.field1506[var1] != null) {
         var2.decodeApperance(class95.field1506[var1]);
      }

      class95.field1507 = 0;
      class95.field1511[++class95.field1507 - 1] = var1;
      class95.field1504[var1] = 0;
      class95.field1509 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class95.field1502[var7] = (var10 << 14) + var11 + (var9 << 28);
            class95.field1512[var7] = 0;
            class95.field1508[var7] = -1;
            class95.field1515[++class95.field1509 - 1] = var7;
            class95.field1504[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
