import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fs")
public class class170 implements Runnable {
   @ObfuscatedName("w")
   static class199 field2706 = new class199();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2060319013
   )
   public static int field2707 = 0;
   @ObfuscatedName("e")
   static class199 field2708 = new class199();
   @ObfuscatedName("s")
   public static Object field2709 = new Object();

   public void run() {
      try {
         while(true) {
            class199 var2 = field2708;
            class169 var1;
            synchronized(field2708) {
               var1 = (class169)field2708.method3825();
            }

            Object var14;
            if(null != var1) {
               if(0 == var1.field2703) {
                  var1.field2700.method2859((int)var1.field3115, var1.field2699, var1.field2699.length);
                  var2 = field2708;
                  synchronized(field2708) {
                     var1.method3913();
                  }
               } else if(1 == var1.field2703) {
                  var1.field2699 = var1.field2700.method2851((int)var1.field3115);
                  var2 = field2708;
                  synchronized(field2708) {
                     field2706.method3834(var1);
                  }
               }

               var14 = field2709;
               synchronized(field2709) {
                  if(field2707 <= 1) {
                     field2707 = 0;
                     field2709.notifyAll();
                     return;
                  }

                  field2707 = 600;
               }
            } else {
               class130.method2818(100L);
               var14 = field2709;
               synchronized(field2709) {
                  if(field2707 <= 1) {
                     field2707 = 0;
                     field2709.notifyAll();
                     return;
                  }

                  --field2707;
               }
            }
         }
      } catch (Exception var13) {
         class1.method16((String)null, var13);
      }
   }

   @ObfuscatedName("s")
   static void method3355(int var0, boolean var1, int var2, boolean var3) {
      if(null != class25.field615) {
         class36.method741(0, class25.field615.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("w")
   public static int method3363(int var0) {
      return var0 >> 11 & 63;
   }
}
