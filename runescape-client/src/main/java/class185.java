import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class185 implements Runnable {
   @ObfuscatedName("d")
   public static Deque field2727;
   @ObfuscatedName("c")
   public static Deque field2728;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1635959413
   )
   static int field2729;
   @ObfuscatedName("q")
   static Object field2730;
   @ObfuscatedName("p")
   static Thread field2731;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2727;
            class182 var1;
            synchronized(field2727) {
               var1 = (class182)field2727.method2828();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2702 == 0) {
                  var1.field2697.method2234((int)var1.hash, var1.field2695, var1.field2695.length);
                  var2 = field2727;
                  synchronized(field2727) {
                     var1.unlink();
                  }
               } else if(var1.field2702 == 1) {
                  var1.field2695 = var1.field2697.method2242((int)var1.hash);
                  var2 = field2727;
                  synchronized(field2727) {
                     field2728.method2824(var1);
                  }
               }

               var14 = field2730;
               synchronized(field2730) {
                  if(field2729 <= 1) {
                     field2729 = 0;
                     field2730.notifyAll();
                     return;
                  }

                  field2729 = 600;
               }
            } else {
               class0.method14(100L);
               var14 = field2730;
               synchronized(field2730) {
                  if(field2729 <= 1) {
                     field2729 = 0;
                     field2730.notifyAll();
                     return;
                  }

                  --field2729;
               }
            }
         }
      } catch (Exception var13) {
         class173.method3259((String)null, var13);
      }
   }

   static {
      field2727 = new Deque();
      field2728 = new Deque();
      field2729 = 0;
      field2730 = new Object();
   }
}
