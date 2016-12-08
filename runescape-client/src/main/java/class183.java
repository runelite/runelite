import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class183 implements Runnable {
   @ObfuscatedName("o")
   public static Deque field2733 = new Deque();
   @ObfuscatedName("m")
   public static Deque field2734 = new Deque();
   @ObfuscatedName("g")
   public static Object field2736 = new Object();
   @ObfuscatedName("v")
   static byte[][][] field2737;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 240880821
   )
   public static int field2740 = 0;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2733;
            class180 var1;
            synchronized(field2733) {
               var1 = (class180)field2733.method2349();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2702 == 0) {
                  var1.field2704.method2186((int)var1.hash, var1.field2703, var1.field2703.length);
                  var2 = field2733;
                  synchronized(field2733) {
                     var1.unlink();
                  }
               } else if(var1.field2702 == 1) {
                  var1.field2703 = var1.field2704.method2185((int)var1.hash);
                  var2 = field2733;
                  synchronized(field2733) {
                     field2734.method2361(var1);
                  }
               }

               var14 = field2736;
               synchronized(field2736) {
                  if(field2740 <= 1) {
                     field2740 = 0;
                     field2736.notifyAll();
                     return;
                  }

                  field2740 = 600;
               }
            } else {
               XClanMember.method237(100L);
               var14 = field2736;
               synchronized(field2736) {
                  if(field2740 <= 1) {
                     field2740 = 0;
                     field2736.notifyAll();
                     return;
                  }

                  --field2740;
               }
            }
         }
      } catch (Exception var13) {
         FaceNormal.method1844((String)null, var13);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "609676524"
   )
   static final void method3292() {
      if(class8.field62 != null) {
         class8.field62.method1020();
      }

      if(null != class88.field1527) {
         class88.field1527.method1020();
      }

   }
}
