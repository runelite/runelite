import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fd")
public class class170 implements Runnable {
   @ObfuscatedName("p")
   static Object field2726 = new Object();
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 677225601
   )
   static int field2728 = 0;
   @ObfuscatedName("w")
   public static class199 field2729 = new class199();
   @ObfuscatedName("x")
   public static class199 field2731 = new class199();

   @ObfuscatedName("bc")
   static final boolean method3396(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field448[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return 1007 == var1;
      }
   }

   public void run() {
      try {
         while(true) {
            class199 var2 = field2729;
            class169 var1;
            synchronized(field2729) {
               var1 = (class169)field2729.method3836();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2723 == 0) {
                  var1.field2722.method2867((int)var1.field3123, var1.field2721, var1.field2721.length);
                  var2 = field2729;
                  synchronized(field2729) {
                     var1.method3935();
                  }
               } else if(var1.field2723 == 1) {
                  var1.field2721 = var1.field2722.method2875((int)var1.field3123);
                  var2 = field2729;
                  synchronized(field2729) {
                     field2731.method3834(var1);
                  }
               }

               var14 = field2726;
               synchronized(field2726) {
                  if(field2728 <= 1) {
                     field2728 = 0;
                     field2726.notifyAll();
                     return;
                  }

                  field2728 = 600;
               }
            } else {
               class104.method2291(100L);
               var14 = field2726;
               synchronized(field2726) {
                  if(field2728 <= 1) {
                     field2728 = 0;
                     field2726.notifyAll();
                     return;
                  }

                  --field2728;
               }
            }
         }
      } catch (Exception var13) {
         class0.method0((String)null, var13);
      }
   }

   @ObfuscatedName("l")
   public static void method3402() {
      class179.field2933.method3776();
   }
}
