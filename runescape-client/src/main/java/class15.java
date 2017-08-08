import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class15 implements Comparator {
   @ObfuscatedName("f")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;B)I",
      garbageValue = "-2"
   )
   int method83(class14 var1, class14 var2) {
      return var1.field288.totalQuantity < var2.field288.totalQuantity?-1:(var2.field288.totalQuantity == var1.field288.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method83((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2015665121"
   )
   public static void method93() {
      try {
         if(class204.field2487 == 1) {
            int var0 = class204.field2486.method3702();
            if(var0 > 0 && class204.field2486.method3708()) {
               var0 -= class204.field2491;
               if(var0 < 0) {
                  var0 = 0;
               }

               class204.field2486.method3729(var0);
               return;
            }

            class204.field2486.method3738();
            class204.field2486.method3705();
            if(class204.field2488 != null) {
               class204.field2487 = 2;
            } else {
               class204.field2487 = 0;
            }

            class169.field2322 = null;
            CollisionData.field2270 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class204.field2486.method3738();
         class204.field2487 = 0;
         class169.field2322 = null;
         CollisionData.field2270 = null;
         class204.field2488 = null;
      }

   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lhg;B)I",
      garbageValue = "0"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }
}
