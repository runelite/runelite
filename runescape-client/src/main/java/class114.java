import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class114 {
   @ObfuscatedName("f")
   public static Calendar field2012;
   @ObfuscatedName("q")
   public static final String[] field2013 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("k")
   public static final String[][] field2014 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("mw")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2012 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "860585347"
   )
   public static void method2489(Buffer var0) {
      byte[] var1 = new byte[24];

      try {
         class152.field2283.method4165(0L);
         class152.field2283.method4167(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var5) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2565(var1, 0, 24);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "101"
   )
   static final void method2490() {
      Region.field1543 = false;
      Client.field282 = false;
   }
}
