import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fj")
public class class170 implements Runnable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1911177599
   )
   public static int field2701 = 0;
   @ObfuscatedName("g")
   public static class199 field2702 = new class199();
   @ObfuscatedName("b")
   public static class199 field2704 = new class199();
   @ObfuscatedName("av")
   @Export("authCode")
   static String field2705;
   @ObfuscatedName("d")
   public static Object field2706 = new Object();

   public void run() {
      try {
         while(true) {
            class199 var2 = field2704;
            class169 var1;
            synchronized(field2704) {
               var1 = (class169)field2704.method3844();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2698 == 0) {
                  var1.field2695.method2898((int)var1.field3113, var1.field2694, var1.field2694.length);
                  var2 = field2704;
                  synchronized(field2704) {
                     var1.method3916();
                  }
               } else if(var1.field2698 == 1) {
                  var1.field2694 = var1.field2695.method2902((int)var1.field3113);
                  var2 = field2704;
                  synchronized(field2704) {
                     field2702.method3819(var1);
                  }
               }

               var14 = field2706;
               synchronized(field2706) {
                  if(field2701 <= 1) {
                     field2701 = 0;
                     field2706.notifyAll();
                     return;
                  }

                  field2701 = 600;
               }
            } else {
               class116.method2459(100L);
               var14 = field2706;
               synchronized(field2706) {
                  if(field2701 <= 1) {
                     field2701 = 0;
                     field2706.notifyAll();
                     return;
                  }

                  --field2701;
               }
            }
         }
      } catch (Exception var13) {
         class7.method94((String)null, var13);
      }
   }
}
