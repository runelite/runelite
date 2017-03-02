import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public class class183 implements Runnable {
   @ObfuscatedName("l")
   public static Deque field2725 = new Deque();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 899395225
   )
   public static int field2727 = 0;
   @ObfuscatedName("t")
   public static Object field2728 = new Object();
   @ObfuscatedName("a")
   static int[][] field2729;
   @ObfuscatedName("b")
   public static Deque field2730 = new Deque();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2730;
            class180 var1;
            synchronized(field2730) {
               var1 = (class180)field2730.method2472();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2697 == 0) {
                  var1.field2696.method2309((int)var1.hash, var1.field2695, var1.field2695.length);
                  var2 = field2730;
                  synchronized(field2730) {
                     var1.unlink();
                  }
               } else if(var1.field2697 == 1) {
                  var1.field2695 = var1.field2696.method2312((int)var1.hash);
                  var2 = field2730;
                  synchronized(field2730) {
                     field2725.method2468(var1);
                  }
               }

               var14 = field2728;
               synchronized(field2728) {
                  if(field2727 <= 1) {
                     field2727 = 0;
                     field2728.notifyAll();
                     return;
                  }

                  field2727 = 600;
               }
            } else {
               class115.method2301(100L);
               var14 = field2728;
               synchronized(field2728) {
                  if(field2727 <= 1) {
                     field2727 = 0;
                     field2728.notifyAll();
                     return;
                  }

                  --field2727;
               }
            }
         }
      } catch (Exception var13) {
         FaceNormal.method1950((String)null, var13);
      }
   }
}
