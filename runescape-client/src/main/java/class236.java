import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class236 implements Runnable {
   @ObfuscatedName("h")
   static Deque field3224;
   @ObfuscatedName("q")
   static Object field3225;
   @ObfuscatedName("i")
   static Deque field3226;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1912522721
   )
   static int field3227;

   public void run() {
      try {
         while(true) {
            Deque var2 = field3226;
            class233 var1;
            synchronized(field3226) {
               var1 = (class233)field3226.method3660();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3190 == 0) {
                  var1.field3192.method3067((int)var1.hash, var1.field3191, var1.field3191.length);
                  var2 = field3226;
                  synchronized(field3226) {
                     var1.unlink();
                  }
               } else if(var1.field3190 == 1) {
                  var1.field3191 = var1.field3192.method3058((int)var1.hash);
                  var2 = field3226;
                  synchronized(field3226) {
                     field3224.method3655(var1);
                  }
               }

               var14 = field3225;
               synchronized(field3225) {
                  if(field3227 <= 1) {
                     field3227 = 0;
                     field3225.notifyAll();
                     return;
                  }

                  field3227 = 600;
               }
            } else {
               class19.method145(100L);
               var14 = field3225;
               synchronized(field3225) {
                  if(field3227 <= 1) {
                     field3227 = 0;
                     field3225.notifyAll();
                     return;
                  }

                  --field3227;
               }
            }
         }
      } catch (Exception var13) {
         Game.method4169((String)null, var13);
      }
   }

   static {
      field3226 = new Deque();
      field3224 = new Deque();
      field3227 = 0;
      field3225 = new Object();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "115"
   )
   static boolean method4287(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }
}
