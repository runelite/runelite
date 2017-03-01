import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class183 implements Runnable {
   @ObfuscatedName("v")
   static Object field2727 = new Object();
   @ObfuscatedName("n")
   public static Deque field2728 = new Deque();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1839882931
   )
   static int field2729 = 0;
   @ObfuscatedName("x")
   public static Deque field2731 = new Deque();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2731;
            class180 var1;
            synchronized(field2731) {
               var1 = (class180)field2731.method2503();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2695 == 0) {
                  var1.field2691.method2333((int)var1.hash, var1.field2690, var1.field2690.length);
                  var2 = field2731;
                  synchronized(field2731) {
                     var1.unlink();
                  }
               } else if(var1.field2695 == 1) {
                  var1.field2690 = var1.field2691.method2332((int)var1.hash);
                  var2 = field2731;
                  synchronized(field2731) {
                     field2728.method2511(var1);
                  }
               }

               var14 = field2727;
               synchronized(field2727) {
                  if(field2729 <= 1) {
                     field2729 = 0;
                     field2727.notifyAll();
                     return;
                  }

                  field2729 = 600;
               }
            } else {
               class47.method970(100L);
               var14 = field2727;
               synchronized(field2727) {
                  if(field2729 <= 1) {
                     field2729 = 0;
                     field2727.notifyAll();
                     return;
                  }

                  --field2729;
               }
            }
         }
      } catch (Exception var13) {
         class97.method2025((String)null, var13);
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "49"
   )
   static final boolean method3442(Widget var0) {
      if(null == var0.field2319) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2319.length; ++var1) {
            int var2 = class187.method3509(var0, var1);
            int var3 = var0.field2262[var1];
            if(var0.field2319[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2319[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2319[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
