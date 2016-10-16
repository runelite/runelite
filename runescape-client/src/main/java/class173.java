import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class173 implements Runnable {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 15937991
   )
   static int field2759 = 0;
   @ObfuscatedName("s")
   static Deque field2760 = new Deque();
   @ObfuscatedName("z")
   static Deque field2761 = new Deque();
   @ObfuscatedName("y")
   static Object field2762 = new Object();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2760;
            class172 var1;
            synchronized(field2760) {
               var1 = (class172)field2760.method3808();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2758 == 0) {
                  var1.field2750.method2863((int)var1.hash, var1.field2757, var1.field2757.length);
                  var2 = field2760;
                  synchronized(field2760) {
                     var1.unlink();
                  }
               } else if(var1.field2758 == 1) {
                  var1.field2757 = var1.field2750.method2868((int)var1.hash);
                  var2 = field2760;
                  synchronized(field2760) {
                     field2761.method3801(var1);
                  }
               }

               var14 = field2762;
               synchronized(field2762) {
                  if(field2759 <= 1) {
                     field2759 = 0;
                     field2762.notifyAll();
                     return;
                  }

                  field2759 = 600;
               }
            } else {
               class16.method185(100L);
               var14 = field2762;
               synchronized(field2762) {
                  if(field2759 <= 1) {
                     field2759 = 0;
                     field2762.notifyAll();
                     return;
                  }

                  --field2759;
               }
            }
         }
      } catch (Exception var13) {
         class144.method2970((String)null, var13);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1212073209"
   )
   public static int method3381(int var0) {
      class50 var2 = (class50)class50.field1063.get((long)var0);
      class50 var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = class50.field1065.method3272(14, var0);
         var2 = new class50();
         if(null != var7) {
            var2.method1000(new Buffer(var7));
         }

         class50.field1063.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.field1070;
      int var4 = var1.field1066;
      int var5 = var1.field1067;
      int var6 = class179.field2949[var5 - var4];
      return class179.widgetSettings[var3] >> var4 & var6;
   }
}
