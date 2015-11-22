package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fo")
public class class169 implements Runnable {
   @ObfuscatedName("l")
   public static Object field2690 = new Object();
   @ObfuscatedName("m")
   public static class198 field2691 = new class198();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1573837355
   )
   public static int field2693 = 0;
   @ObfuscatedName("j")
   public static class198 field2694 = new class198();

   public void run() {
      try {
         while(true) {
            class198 var2 = field2694;
            class168 var1;
            synchronized(field2694) {
               var1 = (class168)field2694.method3871();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2684 == 0) {
                  var1.field2683.method2899((int)var1.field3104, var1.field2685, var1.field2685.length);
                  var2 = field2694;
                  synchronized(field2694) {
                     var1.method3965();
                  }
               } else if(var1.field2684 == 1) {
                  var1.field2685 = var1.field2683.method2898((int)var1.field3104);
                  var2 = field2694;
                  synchronized(field2694) {
                     field2691.method3868(var1);
                  }
               }

               var14 = field2690;
               synchronized(field2690) {
                  if(field2693 <= 1) {
                     field2693 = 0;
                     field2690.notifyAll();
                     return;
                  }

                  field2693 = 600;
               }
            } else {
               class29.method711(100L);
               var14 = field2690;
               synchronized(field2690) {
                  if(field2693 <= 1) {
                     field2693 = 0;
                     field2690.notifyAll();
                     return;
                  }

                  --field2693;
               }
            }
         }
      } catch (Exception var13) {
         class37.method803((String)null, var13);
      }
   }
}
