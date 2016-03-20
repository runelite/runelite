import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class169 implements Runnable {
   @ObfuscatedName("r")
   static class198 field2694 = new class198();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1755515875
   )
   static int field2695 = 0;
   @ObfuscatedName("a")
   static class198 field2696 = new class198();
   @ObfuscatedName("l")
   static int[] field2697;
   @ObfuscatedName("s")
   static Object field2699 = new Object();

   public void run() {
      try {
         while(true) {
            class198 var2 = field2696;
            class168 var1;
            synchronized(field2696) {
               var1 = (class168)field2696.method3860();
            }

            Object var14;
            if(null != var1) {
               if(0 == var1.field2688) {
                  var1.field2689.method2868((int)var1.field3111, var1.field2687, var1.field2687.length);
                  var2 = field2696;
                  synchronized(field2696) {
                     var1.method3946();
                  }
               } else if(1 == var1.field2688) {
                  var1.field2687 = var1.field2689.method2872((int)var1.field3111);
                  var2 = field2696;
                  synchronized(field2696) {
                     field2694.method3855(var1);
                  }
               }

               var14 = field2699;
               synchronized(field2699) {
                  if(field2695 <= 1) {
                     field2695 = 0;
                     field2699.notifyAll();
                     return;
                  }

                  field2695 = 600;
               }
            } else {
               class103.method2301(100L);
               var14 = field2699;
               synchronized(field2699) {
                  if(field2695 <= 1) {
                     field2695 = 0;
                     field2699.notifyAll();
                     return;
                  }

                  --field2695;
               }
            }
         }
      } catch (Exception var13) {
         class28.method651((String)null, var13);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "92"
   )
   public static void method3396(int var0, int var1) {
      class47 var2 = class49.method1029(var0);
      int var3 = var2.field1063;
      int var4 = var2.field1065;
      int var5 = var2.field1066;
      int var6 = class175.field2893[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class175.field2890[var3] = class175.field2890[var3] & ~var6 | var1 << var4 & var6;
   }
}
