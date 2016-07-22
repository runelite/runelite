import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fr")
public class class173 implements Runnable {
   @ObfuscatedName("o")
   public static Object field2756 = new Object();
   @ObfuscatedName("w")
   public static class202 field2757 = new class202();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1256642947
   )
   public static int field2758 = 0;
   @ObfuscatedName("m")
   public static class202 field2759 = new class202();

   public void run() {
      try {
         while(true) {
            class202 var2 = field2759;
            class172 var1;
            synchronized(field2759) {
               var1 = (class172)field2759.method3882();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2753 == 0) {
                  var1.field2754.method2915((int)var1.field3167, var1.field2755, var1.field2755.length);
                  var2 = field2759;
                  synchronized(field2759) {
                     var1.method3990();
                  }
               } else if(var1.field2753 == 1) {
                  var1.field2755 = var1.field2754.method2914((int)var1.field3167);
                  var2 = field2759;
                  synchronized(field2759) {
                     field2757.method3877(var1);
                  }
               }

               var14 = field2756;
               synchronized(field2756) {
                  if(field2758 <= 1) {
                     field2758 = 0;
                     field2756.notifyAll();
                     return;
                  }

                  field2758 = 600;
               }
            } else {
               class141.method2993(100L);
               var14 = field2756;
               synchronized(field2756) {
                  if(field2758 <= 1) {
                     field2758 = 0;
                     field2756.notifyAll();
                     return;
                  }

                  --field2758;
               }
            }
         }
      } catch (Exception var13) {
         class54.method1130((String)null, var13);
      }
   }
}
