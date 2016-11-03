import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fc")
public class class173 implements Runnable {
   @ObfuscatedName("q")
   public static Deque field2755 = new Deque();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 805707391
   )
   static int field2756 = 0;
   @ObfuscatedName("c")
   static Object field2757 = new Object();
   @ObfuscatedName("k")
   public static Deque field2759 = new Deque();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2759;
            class172 var1;
            synchronized(field2759) {
               var1 = (class172)field2759.method3864();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2749 == 0) {
                  var1.field2748.method2905((int)var1.hash, var1.field2747, var1.field2747.length);
                  var2 = field2759;
                  synchronized(field2759) {
                     var1.unlink();
                  }
               } else if(var1.field2749 == 1) {
                  var1.field2747 = var1.field2748.method2903((int)var1.hash);
                  var2 = field2759;
                  synchronized(field2759) {
                     field2755.method3844(var1);
                  }
               }

               var14 = field2757;
               synchronized(field2757) {
                  if(field2756 <= 1) {
                     field2756 = 0;
                     field2757.notifyAll();
                     return;
                  }

                  field2756 = 600;
               }
            } else {
               class127.method2846(100L);
               var14 = field2757;
               synchronized(field2757) {
                  if(field2756 <= 1) {
                     field2756 = 0;
                     field2757.notifyAll();
                     return;
                  }

                  --field2756;
               }
            }
         }
      } catch (Exception var13) {
         RSCanvas.method2969((String)null, var13);
      }
   }
}
