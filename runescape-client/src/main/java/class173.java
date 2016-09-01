import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fy")
public class class173 implements Runnable {
   @ObfuscatedName("f")
   @Export("worldServersDownload")
   static class18 worldServersDownload;
   @ObfuscatedName("r")
   static Deque field2768 = new Deque();
   @ObfuscatedName("x")
   static Deque field2769 = new Deque();
   @ObfuscatedName("z")
   public static Object field2770 = new Object();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1202884537
   )
   public static int field2771 = 0;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2769;
            class172 var1;
            synchronized(field2769) {
               var1 = (class172)field2769.method3850();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2764 == 0) {
                  var1.field2762.method2912((int)var1.hash, var1.field2763, var1.field2763.length);
                  var2 = field2769;
                  synchronized(field2769) {
                     var1.unlink();
                  }
               } else if(var1.field2764 == 1) {
                  var1.field2763 = var1.field2762.method2913((int)var1.hash);
                  var2 = field2769;
                  synchronized(field2769) {
                     field2768.method3844(var1);
                  }
               }

               var14 = field2770;
               synchronized(field2770) {
                  if(field2771 <= 1) {
                     field2771 = 0;
                     field2770.notifyAll();
                     return;
                  }

                  field2771 = 600;
               }
            } else {
               class125.method2820(100L);
               var14 = field2770;
               synchronized(field2770) {
                  if(field2771 <= 1) {
                     field2771 = 0;
                     field2770.notifyAll();
                     return;
                  }

                  --field2771;
               }
            }
         }
      } catch (Exception var13) {
         class107.method2357((String)null, var13);
      }
   }
}
