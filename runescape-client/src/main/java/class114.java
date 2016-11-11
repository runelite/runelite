import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class114 {
   @ObfuscatedName("h")
   public static final String[] field2002 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("e")
   public static Calendar field2003;
   @ObfuscatedName("l")
   static class157 field2004;
   @ObfuscatedName("i")
   public static final String[][] field2006 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("ae")
   static class171 field2007;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2003 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1497527093"
   )
   public static String method2461(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(1 + var7 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(27 + var7 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var3 % 37L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = ItemLayer.method2244(var3);
      if(null == var8) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1089775664"
   )
   static void method2462(int var0) {
      if(var0 == -1 && !Client.field539) {
         Item.method659();
      } else if(var0 != -1 && var0 != Client.field538 && Client.field513 != 0 && !Client.field539) {
         class171 var1 = Client.field476;
         int var2 = Client.field513;
         class186.field3010 = 1;
         class35.field800 = var1;
         FrameMap.field1823 = var0;
         class186.field3015 = 0;
         class186.field3016 = var2;
         class186.field3017 = false;
         class54.field1154 = 2;
      }

      Client.field538 = var0;
   }
}
