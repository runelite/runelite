import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class170 implements Runnable {
   @ObfuscatedName("j")
   static class199 field2720 = new class199();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 721143965
   )
   static int field2721 = 0;
   @ObfuscatedName("s")
   static class199 field2722 = new class199();
   @ObfuscatedName("x")
   static Object field2723 = new Object();

   public void run() {
      try {
         while(true) {
            class199 var1 = field2722;
            class199 var3 = field2722;
            class169 var2;
            synchronized(field2722) {
               var2 = (class169)field2722.method3812();
            }

            Object var4;
            Object var15;
            if(null != var2) {
               class199 var16;
               if(0 == var2.field2712) {
                  var2.field2713.method2849((int)var2.field3125, var2.field2714, var2.field2714.length);
                  var1 = field2722;
                  var16 = field2722;
                  synchronized(field2722) {
                     var2.method3898();
                  }
               } else if(1 == var2.field2712) {
                  var2.field2714 = var2.field2713.method2854((int)var2.field3125);
                  var1 = field2722;
                  var16 = field2722;
                  synchronized(field2722) {
                     field2720.method3807(var2);
                  }
               }

               var15 = field2723;
               var4 = field2723;
               synchronized(field2723) {
                  if(field2721 <= 1) {
                     field2721 = 0;
                     field2723.notifyAll();
                     return;
                  }

                  field2721 = 600;
               }
            } else {
               class116.method2448(100L);
               var15 = field2723;
               var4 = field2723;
               synchronized(field2723) {
                  if(field2721 <= 1) {
                     field2721 = 0;
                     field2723.notifyAll();
                     return;
                  }

                  --field2721;
               }
            }
         }
      } catch (Exception var14) {
         class90.method2067((String)null, var14);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "1"
   )
   public static boolean method3344(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         var0.delete();
         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
