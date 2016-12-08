import java.io.File;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("da")
   static int[] field206;
   @ObfuscatedName("o")
   @Export("name")
   String name;
   @ObfuscatedName("pk")
   static GarbageCollectorMXBean field208;
   @ObfuscatedName("gb")
   static Widget field209;
   @ObfuscatedName("g")
   static File field210;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1097184963
   )
   static int field215;
   @ObfuscatedName("b")
   public static class182 field216;
   @ObfuscatedName("m")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("cj")
   static class208 field218;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "138721456"
   )
   static void method188() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2296(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2300()) {
         int var1 = var0.id;
         if(class2.method25(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2204;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class174.method3178(var4);
               if(var5 != null) {
                  class97.method1886(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   public static String method189(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class205.field3080[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
