import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class236 implements Runnable {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   static Deque field3207;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   static Deque field3204;
   @ObfuscatedName("u")
   static Object field3203;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1488727779
   )
   static int field3205;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -322498655
   )
   @Export("cameraYaw")
   static int cameraYaw;

   static {
      field3207 = new Deque();
      field3204 = new Deque();
      field3205 = 0;
      field3203 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3207;
            FileSystem var1;
            synchronized(field3207) {
               var1 = (FileSystem)field3207.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3171 == 0) {
                  var1.index.method2939((int)var1.hash, var1.field3170, var1.field3170.length);
                  var2 = field3207;
                  synchronized(field3207) {
                     var1.unlink();
                  }
               } else if(var1.field3171 == 1) {
                  var1.field3170 = var1.index.method2938((int)var1.hash);
                  var2 = field3207;
                  synchronized(field3207) {
                     field3204.addFront(var1);
                  }
               }

               var14 = field3203;
               synchronized(field3203) {
                  if(field3205 <= 1) {
                     field3205 = 0;
                     field3203.notifyAll();
                     return;
                  }

                  field3205 = 600;
               }
            } else {
               Occluder.method2829(100L);
               var14 = field3203;
               synchronized(field3203) {
                  if(field3205 <= 1) {
                     field3205 = 0;
                     field3203.notifyAll();
                     return;
                  }

                  --field3205;
               }
            }
         }
      } catch (Exception var13) {
         WorldMapType2.method495((String)null, var13);
      }
   }
}
