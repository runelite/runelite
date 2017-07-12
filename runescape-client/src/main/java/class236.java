import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ih")
public class class236 implements Runnable {
   @ObfuscatedName("w")
   public static Deque field3242;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1667574173
   )
   public static int field3243;
   @ObfuscatedName("s")
   public static Object field3244;
   @ObfuscatedName("r")
   static Thread field3245;
   @ObfuscatedName("i")
   public static Deque field3247;

   public void run() {
      try {
         while(true) {
            Deque var1 = field3247;
            Deque var3 = field3247;
            FileSystem var2;
            synchronized(field3247) {
               var2 = (FileSystem)field3247.getFront();
            }

            Object var4;
            Object var15;
            if(var2 != null) {
               Deque var16;
               if(var2.field3213 == 0) {
                  var2.index.method3002((int)var2.hash, var2.field3215, var2.field3215.length);
                  var1 = field3247;
                  var16 = field3247;
                  synchronized(field3247) {
                     var2.unlink();
                  }
               } else if(var2.field3213 == 1) {
                  var2.field3215 = var2.index.method2997((int)var2.hash);
                  var1 = field3247;
                  var16 = field3247;
                  synchronized(field3247) {
                     field3242.addFront(var2);
                  }
               }

               var15 = field3244;
               var4 = field3244;
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
               var15 = field3244;
               var4 = field3244;
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
      } catch (Exception var14) {
         MilliTimer.method2912((String)null, var14);
      }
   }

   static {
      field3247 = new Deque();
      field3242 = new Deque();
      field3243 = 0;
      field3244 = new Object();
   }
}
