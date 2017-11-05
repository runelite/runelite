import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public class class236 implements Runnable {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field3229;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field3227;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1776284767
   )
   public static int field3228;
   @ObfuscatedName("o")
   public static Object field3231;

   static {
      field3229 = new Deque();
      field3227 = new Deque();
      field3228 = 0;
      field3231 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3229;
            FileSystem var1;
            synchronized(field3229) {
               var1 = (FileSystem)field3229.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3200 == 0) {
                  var1.index.method3058((int)var1.hash, var1.field3197, var1.field3197.length);
                  var2 = field3229;
                  synchronized(field3229) {
                     var1.unlink();
                  }
               } else if(var1.field3200 == 1) {
                  var1.field3197 = var1.index.method3060((int)var1.hash);
                  var2 = field3229;
                  synchronized(field3229) {
                     field3227.addFront(var1);
                  }
               }

               var14 = field3231;
               synchronized(field3231) {
                  if(field3228 <= 1) {
                     field3228 = 0;
                     field3231.notifyAll();
                     return;
                  }

                  field3228 = 600;
               }
            } else {
               class94.method1823(100L);
               var14 = field3231;
               synchronized(field3231) {
                  if(field3228 <= 1) {
                     field3228 = 0;
                     field3231.notifyAll();
                     return;
                  }

                  --field3228;
               }
            }
         }
      } catch (Exception var13) {
         class46.method680((String)null, var13);
      }
   }
}
