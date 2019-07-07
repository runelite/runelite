import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("Clock")
public abstract class Clock {
   @ObfuscatedName("lu")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("mousedOverWidgetIf1")
   static Widget mousedOverWidgetIf1;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   @Export("mark")
   public abstract void mark();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-126803683"
   )
   @Export("wait")
   public abstract int wait(int cycleMs, int minSleepMs);

   @ObfuscatedName("m")
   public static String method3534(long var0) {
      if (var0 > 0L && var0 < 6582952005840035281L) {
         if (0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for (long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var4;
            char var8;
            for (var4 = new StringBuilder(var2); var0 != 0L; var4.append(var8)) {
               long var5 = var0;
               var0 /= 37L;
               var8 = class306.base37Table[(int)(var5 - 37L * var0)];
               if (var8 == '_') {
                  int var7 = var4.length() - 1;
                  var4.setCharAt(var7, Character.toUpperCase(var4.charAt(var7)));
                  var8 = 160;
               }
            }

            var4.reverse();
            var4.setCharAt(0, Character.toUpperCase(var4.charAt(0)));
            return var4.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1555959688"
   )
   static void method3533(String var0) {
      class21.field1123 = var0;

      try {
         String var1 = TextureProvider.client.getParameter(ClientParameter.field334.id);
         String var2 = TextureProvider.client.getParameter(ClientParameter.field335.id);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if (var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + WorldMapSectionType.method252(class203.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class46.method850(TextureProvider.client, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
      }

   }
}
