import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ih")
public class class236 implements Runnable {
   @ObfuscatedName("i")
   public static Deque field3247;
   @ObfuscatedName("w")
   public static Deque field3242;
   @ObfuscatedName("s")
   public static Object field3244;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1667574173
   )
   public static int field3243;
   @ObfuscatedName("r")
   static Thread field3245;

   static {
      field3247 = new Deque();
      field3242 = new Deque();
      field3243 = 0;
      field3244 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3247;
            FileSystem var1;
            synchronized(field3247) {
               var1 = (FileSystem)field3247.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3213 == 0) {
                  var1.index.method3002((int)var1.hash, var1.field3215, var1.field3215.length);
                  var2 = field3247;
                  synchronized(field3247) {
                     var1.unlink();
                  }
               } else if(var1.field3213 == 1) {
                  var1.field3215 = var1.index.method2997((int)var1.hash);
                  var2 = field3247;
                  synchronized(field3247) {
                     field3242.addFront(var1);
                  }
               }

               var14 = field3244;
               synchronized(field3244) {
                  if(field3243 <= 1) {
                     field3243 = 0;
                     field3244.notifyAll();
                     return;
                  }

                  field3243 = 600;
               }
            } else {
               XItemContainer.method1113(100L);
               var14 = field3244;
               synchronized(field3244) {
                  if(field3243 <= 1) {
                     field3243 = 0;
                     field3244.notifyAll();
                     return;
                  }

                  --field3243;
               }
            }
         }
      } catch (Exception var13) {
         MilliTimer.method2912((String)null, var13);
      }
   }
}
