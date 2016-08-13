import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fz")
public class class173 implements Runnable {
   @ObfuscatedName("g")
   static Deque field2761 = new Deque();
   @ObfuscatedName("e")
   public static Object field2763 = new Object();
   @ObfuscatedName("l")
   static Deque field2765 = new Deque();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1050549683
   )
   public static int field2767 = 0;

   public void run() {
      try {
         while(true) {
            Deque var1 = field2765;
            Deque var3 = field2765;
            class172 var2;
            synchronized(field2765) {
               var2 = (class172)field2765.method3980();
            }

            Object var4;
            Object var15;
            if(var2 != null) {
               Deque var16;
               if(var2.field2757 == 0) {
                  var2.field2759.method3004((int)var2.hash, var2.field2755, var2.field2755.length);
                  var1 = field2765;
                  var16 = field2765;
                  synchronized(field2765) {
                     var2.unlink();
                  }
               } else if(var2.field2757 == 1) {
                  var2.field2755 = var2.field2759.method3016((int)var2.hash);
                  var1 = field2765;
                  var16 = field2765;
                  synchronized(field2765) {
                     field2761.method3963(var2);
                  }
               }

               var15 = field2763;
               var4 = field2763;
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
               var15 = field2763;
               var4 = field2763;
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
      } catch (Exception var14) {
         class13.method176((String)null, var14);
      }
   }
}
