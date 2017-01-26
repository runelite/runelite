import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public class class183 implements Runnable {
   @ObfuscatedName("s")
   static int[] field2719;
   @ObfuscatedName("g")
   static Deque field2720 = new Deque();
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -2068999947
   )
   static int field2721;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 697727723
   )
   static int field2725 = 0;
   @ObfuscatedName("p")
   static Deque field2727 = new Deque();
   @ObfuscatedName("q")
   static Object field2728 = new Object();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2727;
            class180 var1;
            synchronized(field2727) {
               var1 = (class180)field2727.method2412();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2691 == 0) {
                  var1.field2690.method2246((int)var1.hash, var1.field2693, var1.field2693.length);
                  var2 = field2727;
                  synchronized(field2727) {
                     var1.unlink();
                  }
               } else if(var1.field2691 == 1) {
                  var1.field2693 = var1.field2690.method2240((int)var1.hash);
                  var2 = field2727;
                  synchronized(field2727) {
                     field2720.method2407(var1);
                  }
               }

               var14 = field2728;
               synchronized(field2728) {
                  if(field2725 <= 1) {
                     field2725 = 0;
                     field2728.notifyAll();
                     return;
                  }

                  field2725 = 600;
               }
            } else {
               class104.method1988(100L);
               var14 = field2728;
               synchronized(field2728) {
                  if(field2725 <= 1) {
                     field2725 = 0;
                     field2728.notifyAll();
                     return;
                  }

                  --field2725;
               }
            }
         }
      } catch (Exception var13) {
         class65.method1151((String)null, var13);
      }
   }
}
