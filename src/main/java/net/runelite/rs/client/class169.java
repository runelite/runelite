package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fc")
public class class169 implements Runnable {
   @ObfuscatedName("i")
   public static Object field2716 = new Object();
   @ObfuscatedName("j")
   public static class198 field2717 = new class198();
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 380530983
   )
   public static int field2718 = 0;
   @ObfuscatedName("b")
   public static class179 field2719;
   @ObfuscatedName("l")
   public static class198 field2720 = new class198();

   public void run() {
      try {
         while(true) {
            class198 var2 = field2717;
            class168 var1;
            synchronized(field2717) {
               var1 = (class168)field2717.method3773();
            }

            Object var14;
            if(null != var1) {
               if(0 == var1.field2709) {
                  var1.field2711.method2792((int)var1.field3112, var1.field2710, var1.field2710.length);
                  var2 = field2717;
                  synchronized(field2717) {
                     var1.method3853();
                  }
               } else if(1 == var1.field2709) {
                  var1.field2710 = var1.field2711.method2793((int)var1.field3112);
                  var2 = field2717;
                  synchronized(field2717) {
                     field2720.method3768(var1);
                  }
               }

               var14 = field2716;
               synchronized(field2716) {
                  if(field2718 <= 1) {
                     field2718 = 0;
                     field2716.notifyAll();
                     return;
                  }

                  field2718 = 600;
               }
            } else {
               class105.method2332(100L);
               var14 = field2716;
               synchronized(field2716) {
                  if(field2718 <= 1) {
                     field2718 = 0;
                     field2716.notifyAll();
                     return;
                  }

                  --field2718;
               }
            }
         }
      } catch (Exception var13) {
         class16.method184((String)null, var13);
      }
   }

   @ObfuscatedName("s")
   public static void method3326(boolean var0) {
      if(class168.field2714 != var0) {
         class7.method96();
         class168.field2714 = var0;
      }

   }

   @ObfuscatedName("bg")
   static final void method3327(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field231 == 0) {
         var1 = class107.field1906.method1901(var0.field242, var0.field230, var0.field235);
      }

      if(var0.field231 == 1) {
         var1 = class107.field1906.method1902(var0.field242, var0.field230, var0.field235);
      }

      if(2 == var0.field231) {
         var1 = class107.field1906.method1935(var0.field242, var0.field230, var0.field235);
      }

      if(var0.field231 == 3) {
         var1 = class107.field1906.method2010(var0.field242, var0.field230, var0.field235);
      }

      if(0 != var1) {
         int var5 = class107.field1906.method1983(var0.field242, var0.field230, var0.field235, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field241 = var2;
      var0.field236 = var3;
      var0.field234 = var4;
   }
}
