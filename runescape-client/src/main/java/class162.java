import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class162 {
   @ObfuscatedName("h")
   public static Calendar field2150;
   @ObfuscatedName("d")
   public static final String[] field2151 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("q")
   public static final String[][] field2152 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2150 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1735411163"
   )
   static final void method3116(boolean var0) {
      for(int var1 = 0; var1 < Client.field340; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field345[var1]];
         int var3 = 536870912 + (Client.field345[var1] << 14);
         if(var2 != null && var2.vmethod803() && var2.composition.isVisible == var0 && var2.composition.method3736()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field657 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field409 == Client.field408[var4][var5]) {
                     continue;
                  }

                  Client.field408[var4][var5] = Client.field409;
               }

               if(!var2.composition.field3035) {
                  var3 -= Integer.MIN_VALUE;
               }

               Script.region.method1758(WallObject.plane, var2.x, var2.y, class2.method19(var2.field657 * 64 - 64 + var2.x, var2.y + (var2.field657 * 64 - 64), WallObject.plane), var2.field657 * 64 - 64 + 60, var2, var2.angle, var3, var2.field627);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1806897958"
   )
   public static int method3117(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   class162() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-107"
   )
   public static final boolean method3118() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1710 == class105.field1723) {
            return false;
         } else {
            class7.field72 = class105.field1706[class105.field1710];
            class33.field772 = class105.field1727[class105.field1710];
            class105.field1710 = class105.field1710 + 1 & 127;
            return true;
         }
      }
   }
}
