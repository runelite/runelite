import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class183 implements Runnable {
   @ObfuscatedName("d")
   static Deque field2727 = new Deque();
   @ObfuscatedName("h")
   static Object field2729 = new Object();
   @ObfuscatedName("n")
   static Deque field2731 = new Deque();
   @ObfuscatedName("kr")
   static class112 field2732;
   @ObfuscatedName("q")
   public static class208 field2733;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 220353037
   )
   static int field2734 = 0;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2731;
            class180 var1;
            synchronized(field2731) {
               var1 = (class180)field2731.method2466();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2699 == 0) {
                  var1.field2701.method2294((int)var1.hash, var1.field2700, var1.field2700.length);
                  var2 = field2731;
                  synchronized(field2731) {
                     var1.unlink();
                  }
               } else if(var1.field2699 == 1) {
                  var1.field2700 = var1.field2701.method2297((int)var1.hash);
                  var2 = field2731;
                  synchronized(field2731) {
                     field2727.method2454(var1);
                  }
               }

               var14 = field2729;
               synchronized(field2729) {
                  if(field2734 <= 1) {
                     field2734 = 0;
                     field2729.notifyAll();
                     return;
                  }

                  field2734 = 600;
               }
            } else {
               class0.method12(100L);
               var14 = field2729;
               synchronized(field2729) {
                  if(field2734 <= 1) {
                     field2734 = 0;
                     field2729.notifyAll();
                     return;
                  }

                  --field2734;
               }
            }
         }
      } catch (Exception var13) {
         class39.method772((String)null, var13);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)[LModIcon;",
      garbageValue = "26"
   )
   public static ModIcon[] method3419(class182 var0, String var1, String var2) {
      int var3 = var0.method3350(var1);
      int var4 = var0.method3345(var3, var2);
      ModIcon[] var5;
      if(!KitDefinition.method3566(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var7 = new ModIcon[class225.field3212];

         for(int var8 = 0; var8 < class225.field3212; ++var8) {
            ModIcon var9 = var7[var8] = new ModIcon();
            var9.width = class225.field3211;
            var9.originalHeight = class225.field3216;
            var9.offsetX = class225.field3213[var8];
            var9.offsetY = class225.field3214[var8];
            var9.originalWidth = class225.field3215[var8];
            var9.height = class225.field3219[var8];
            var9.palette = class225.field3210;
            var9.pixels = class225.field3218[var8];
         }

         class189.method3507();
         var5 = var7;
      }

      return var5;
   }
}
