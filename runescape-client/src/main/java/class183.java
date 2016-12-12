import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class183 implements Runnable {
   @ObfuscatedName("e")
   static Deque field2725 = new Deque();
   @ObfuscatedName("i")
   static Deque field2726 = new Deque();
   @ObfuscatedName("k")
   public static Object field2727 = new Object();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1423622681
   )
   public static int field2728 = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LModIcon;",
      garbageValue = "808864721"
   )
   static ModIcon[] method3303(class182 var0, int var1, int var2) {
      if(!class178.method3196(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var4 = new ModIcon[class225.field3214];

         for(int var5 = 0; var5 < class225.field3214; ++var5) {
            ModIcon var6 = var4[var5] = new ModIcon();
            var6.width = class225.field3215;
            var6.originalHeight = class225.field3216;
            var6.offsetX = class225.field3217[var5];
            var6.offsetY = RSCanvas.field1748[var5];
            var6.originalWidth = class225.field3218[var5];
            var6.height = Item.field897[var5];
            var6.palette = class167.field2191;
            var6.pixels = class154.field2106[var5];
         }

         class185.method3361();
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass191;",
      garbageValue = "1971672273"
   )
   public static class191 method3307(int var0) {
      class191 var1 = (class191)class191.field2809.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class191.field2813.method3211(1, var0);
         var1 = new class191();
         if(null != var2) {
            var1.method3429(new Buffer(var2), var0);
         }

         var1.method3434();
         class191.field2809.put(var1, (long)var0);
         return var1;
      }
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field2726;
            class180 var1;
            synchronized(field2726) {
               var1 = (class180)field2726.method2359();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2692 == 0) {
                  var1.field2693.method2208((int)var1.hash, var1.field2691, var1.field2691.length);
                  var2 = field2726;
                  synchronized(field2726) {
                     var1.unlink();
                  }
               } else if(var1.field2692 == 1) {
                  var1.field2691 = var1.field2693.method2206((int)var1.hash);
                  var2 = field2726;
                  synchronized(field2726) {
                     field2725.method2376(var1);
                  }
               }

               var14 = field2727;
               synchronized(field2727) {
                  if(field2728 <= 1) {
                     field2728 = 0;
                     field2727.notifyAll();
                     return;
                  }

                  field2728 = 600;
               }
            } else {
               class10.method149(100L);
               var14 = field2727;
               synchronized(field2727) {
                  if(field2728 <= 1) {
                     field2728 = 0;
                     field2727.notifyAll();
                     return;
                  }

                  --field2728;
               }
            }
         }
      } catch (Exception var13) {
         FaceNormal.method1864((String)null, var13);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass195;",
      garbageValue = "2000735519"
   )
   public static class195 method3314(int var0) {
      class195 var1 = (class195)class195.field2854.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class195.field2861.method3211(8, var0);
         var1 = new class195();
         if(null != var2) {
            var1.method3508(new Buffer(var2));
         }

         class195.field2854.put(var1, (long)var0);
         return var1;
      }
   }
}
