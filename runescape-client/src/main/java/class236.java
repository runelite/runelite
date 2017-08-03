import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class236 implements Runnable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static Deque field3220;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static Deque field3214;
   @ObfuscatedName("y")
   static Object field3213;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1687454057
   )
   static int field3216;
   @ObfuscatedName("e")
   static Thread field3217;

   static {
      field3220 = new Deque();
      field3214 = new Deque();
      field3216 = 0;
      field3213 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3220;
            FileSystem var1;
            synchronized(field3220) {
               var1 = (FileSystem)field3220.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3180 == 0) {
                  var1.index.method3044((int)var1.hash, var1.field3181, var1.field3181.length);
                  var2 = field3220;
                  synchronized(field3220) {
                     var1.unlink();
                  }
               } else if(var1.field3180 == 1) {
                  var1.field3181 = var1.index.method3043((int)var1.hash);
                  var2 = field3220;
                  synchronized(field3220) {
                     field3214.addFront(var1);
                  }
               }

               var14 = field3213;
               synchronized(field3213) {
                  if(field3216 <= 1) {
                     field3216 = 0;
                     field3213.notifyAll();
                     return;
                  }

                  field3216 = 600;
               }
            } else {
               GroundObject.method2492(100L);
               var14 = field3213;
               synchronized(field3213) {
                  if(field3216 <= 1) {
                     field3216 = 0;
                     field3213.notifyAll();
                     return;
                  }

                  --field3216;
               }
            }
         }
      } catch (Exception var13) {
         class23.method165((String)null, var13);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-669180802"
   )
   public static boolean method4200(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
