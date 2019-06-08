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
   public abstract int wait(int var1, int var2);

   @ObfuscatedName("m")
   public static String method3534(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class306.base37Table[(int)(var6 - 37L * var0)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
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
      class21.__b_by = var0;

      try {
         String var1 = TextureProvider.client.getParameter(ClientParameter.__ji_n.id);
         String var2 = TextureProvider.client.getParameter(ClientParameter.__ji_i.id);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + WorldMapSectionType.method252(class203.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class46.method850(TextureProvider.client, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }
}
