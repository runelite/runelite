import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ft")
public class class170 implements Runnable {
   @ObfuscatedName("j")
   public static class199 field2702 = new class199();
   @ObfuscatedName("z")
   static Object field2704 = new Object();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1532326011
   )
   static int field2705 = 0;
   @ObfuscatedName("h")
   public static class199 field2707 = new class199();

   public void run() {
      try {
         while(true) {
            class199 var2 = field2702;
            class169 var1;
            synchronized(field2702) {
               var1 = (class169)field2702.method3784();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2694 == 0) {
                  var1.field2699.method2832((int)var1.field3122, var1.field2693, var1.field2693.length);
                  var2 = field2702;
                  synchronized(field2702) {
                     var1.method3883();
                  }
               } else if(1 == var1.field2694) {
                  var1.field2693 = var1.field2699.method2831((int)var1.field3122);
                  var2 = field2702;
                  synchronized(field2702) {
                     field2707.method3779(var1);
                  }
               }

               var14 = field2704;
               synchronized(field2704) {
                  if(field2705 <= 1) {
                     field2705 = 0;
                     field2704.notifyAll();
                     return;
                  }

                  field2705 = 600;
               }
            } else {
               class14.method170(100L);
               var14 = field2704;
               synchronized(field2704) {
                  if(field2705 <= 1) {
                     field2705 = 0;
                     field2704.notifyAll();
                     return;
                  }

                  --field2705;
               }
            }
         }
      } catch (Exception var13) {
         class6.method102((String)null, var13);
      }
   }
}
