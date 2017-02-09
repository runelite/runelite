import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
public class class183 implements Runnable {
   @ObfuscatedName("r")
   public static Object field2712 = new Object();
   @ObfuscatedName("y")
   static Deque field2713 = new Deque();
   @ObfuscatedName("k")
   static Deque field2714 = new Deque();
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 654450083
   )
   public static int field2715 = 0;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2714;
            class180 var1;
            synchronized(field2714) {
               var1 = (class180)field2714.method2403();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2685 == 0) {
                  var1.field2683.method2227((int)var1.hash, var1.field2682, var1.field2682.length);
                  var2 = field2714;
                  synchronized(field2714) {
                     var1.unlink();
                  }
               } else if(var1.field2685 == 1) {
                  var1.field2682 = var1.field2683.method2236((int)var1.hash);
                  var2 = field2714;
                  synchronized(field2714) {
                     field2713.method2380(var1);
                  }
               }

               var14 = field2712;
               synchronized(field2712) {
                  if(field2715 <= 1) {
                     field2715 = 0;
                     field2712.notifyAll();
                     return;
                  }

                  field2715 = 600;
               }
            } else {
               class195.method3560(100L);
               var14 = field2712;
               synchronized(field2712) {
                  if(field2715 <= 1) {
                     field2715 = 0;
                     field2712.notifyAll();
                     return;
                  }

                  --field2715;
               }
            }
         }
      } catch (Exception var13) {
         class32.method709((String)null, var13);
      }
   }
}
