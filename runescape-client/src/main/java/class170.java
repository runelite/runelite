import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fs")
public class class170 implements Runnable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1495300121
   )
   public static int field2702 = 0;
   @ObfuscatedName("u")
   static class199 field2704 = new class199();
   @ObfuscatedName("b")
   public static Object field2705 = new Object();
   @ObfuscatedName("f")
   static class199 field2707 = new class199();
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1592031361
   )
   static int field2709;

   public void run() {
      try {
         while(true) {
            class199 var2 = field2707;
            class169 var1;
            synchronized(field2707) {
               var1 = (class169)field2707.method3852();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2697 == 0) {
                  var1.field2698.method2885((int)var1.field3115, var1.field2696, var1.field2696.length);
                  var2 = field2707;
                  synchronized(field2707) {
                     var1.method3946();
                  }
               } else if(var1.field2697 == 1) {
                  var1.field2696 = var1.field2698.method2883((int)var1.field3115);
                  var2 = field2707;
                  synchronized(field2707) {
                     field2704.method3877(var1);
                  }
               }

               var14 = field2705;
               synchronized(field2705) {
                  if(field2702 <= 1) {
                     field2702 = 0;
                     field2705.notifyAll();
                     return;
                  }

                  field2702 = 600;
               }
            } else {
               class98.method2264(100L);
               var14 = field2705;
               synchronized(field2705) {
                  if(field2702 <= 1) {
                     field2702 = 0;
                     field2705.notifyAll();
                     return;
                  }

                  --field2702;
               }
            }
         }
      } catch (Exception var13) {
         class45.method984((String)null, var13);
      }
   }
}
