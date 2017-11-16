import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
public class class243 implements Runnable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static Deque field3291;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static Deque field3289;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -554768641
   )
   public static int field3288;
   @ObfuscatedName("g")
   public static Object field3290;
   @ObfuscatedName("x")
   static Thread field3287;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static SpritePixels field3292;

   static {
      field3291 = new Deque();
      field3289 = new Deque();
      field3288 = 0;
      field3290 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3291;
            FileSystem var1;
            synchronized(field3291) {
               var1 = (FileSystem)field3291.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3260 == 0) {
                  var1.index.method3029((int)var1.hash, var1.field3258, var1.field3258.length);
                  var2 = field3291;
                  synchronized(field3291) {
                     var1.unlink();
                  }
               } else if(var1.field3260 == 1) {
                  var1.field3258 = var1.index.method3028((int)var1.hash);
                  var2 = field3291;
                  synchronized(field3291) {
                     field3289.addFront(var1);
                  }
               }

               var14 = field3290;
               synchronized(field3290) {
                  if(field3288 <= 1) {
                     field3288 = 0;
                     field3290.notifyAll();
                     return;
                  }

                  field3288 = 600;
               }
            } else {
               GZipDecompressor.method3129(100L);
               var14 = field3290;
               synchronized(field3290) {
                  if(field3288 <= 1) {
                     field3288 = 0;
                     field3290.notifyAll();
                     return;
                  }

                  --field3288;
               }
            }
         }
      } catch (Exception var13) {
         class48.method690((String)null, var13);
      }
   }
}
