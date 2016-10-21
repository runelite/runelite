import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class173 implements Runnable {
   @ObfuscatedName("e")
   public static Deque field2742 = new Deque();
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 754544877
   )
   public static int field2743 = 0;
   @ObfuscatedName("f")
   public static Deque field2744 = new Deque();
   @ObfuscatedName("t")
   public static Object field2746 = new Object();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2744;
            class172 var1;
            synchronized(field2744) {
               var1 = (class172)field2744.method3890();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2737 == 0) {
                  var1.field2736.method2888((int)var1.hash, var1.field2735, var1.field2735.length);
                  var2 = field2744;
                  synchronized(field2744) {
                     var1.unlink();
                  }
               } else if(var1.field2737 == 1) {
                  var1.field2735 = var1.field2736.method2887((int)var1.hash);
                  var2 = field2744;
                  synchronized(field2744) {
                     field2742.method3886(var1);
                  }
               }

               var14 = field2746;
               synchronized(field2746) {
                  if(field2743 <= 1) {
                     field2743 = 0;
                     field2746.notifyAll();
                     return;
                  }

                  field2743 = 600;
               }
            } else {
               class110.method2407(100L);
               var14 = field2746;
               synchronized(field2746) {
                  if(field2743 <= 1) {
                     field2743 = 0;
                     field2746.notifyAll();
                     return;
                  }

                  --field2743;
               }
            }
         }
      } catch (Exception var13) {
         Frames.method2316((String)null, var13);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-938844533"
   )
   public static boolean method3423() {
      try {
         if(class186.field3005 == 2) {
            if(null == class186.field3001) {
               class186.field3001 = class183.method3574(class186.field2996, class186.field2997, class175.field2777);
               if(class186.field3001 == null) {
                  return false;
               }
            }

            if(null == class186.field3000) {
               class186.field3000 = new class62(class186.field2994, class186.field2993);
            }

            if(class28.field670.method3748(class186.field3001, class186.field3003, class186.field3000, 22050)) {
               class28.field670.method3660();
               class28.field670.method3697(class186.field2999);
               class28.field670.method3662(class186.field3001, class186.field2992);
               class186.field3005 = 0;
               class186.field3001 = null;
               class186.field3000 = null;
               class186.field2996 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class28.field670.method3663();
         class186.field3005 = 0;
         class186.field3001 = null;
         class186.field3000 = null;
         class186.field2996 = null;
      }

      return false;
   }
}
