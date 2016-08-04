import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fz")
public class class173 implements Runnable {
   @ObfuscatedName("g")
   static class202 field2761 = new class202();
   @ObfuscatedName("e")
   public static Object field2763 = new Object();
   @ObfuscatedName("l")
   static class202 field2765 = new class202();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1050549683
   )
   public static int field2767 = 0;

   public void run() {
      try {
         while(true) {
            class202 var2 = field2765;
            class172 var1;
            synchronized(field2765) {
               var1 = (class172)field2765.method3980();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2757 == 0) {
                  var1.field2759.method3004((int)var1.field3175, var1.field2755, var1.field2755.length);
                  var2 = field2765;
                  synchronized(field2765) {
                     var1.method4067();
                  }
               } else if(var1.field2757 == 1) {
                  var1.field2755 = var1.field2759.method3016((int)var1.field3175);
                  var2 = field2765;
                  synchronized(field2765) {
                     field2761.method3963(var1);
                  }
               }

               var14 = field2763;
               synchronized(field2763) {
                  if(field2767 <= 1) {
                     field2767 = 0;
                     field2763.notifyAll();
                     return;
                  }

                  field2767 = 600;
               }
            } else {
               class22.method594(100L);
               var14 = field2763;
               synchronized(field2763) {
                  if(field2767 <= 1) {
                     field2767 = 0;
                     field2763.notifyAll();
                     return;
                  }

                  --field2767;
               }
            }
         }
      } catch (Exception var13) {
         class13.method176((String)null, var13);
      }
   }
}
