import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class236 implements Runnable {
   @ObfuscatedName("n")
   public static Deque field3233;
   @ObfuscatedName("p")
   public static Deque field3234;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1937146931
   )
   static int field3235;
   @ObfuscatedName("j")
   static Object field3236;

   public void run() {
      try {
         while(true) {
            Deque var2 = field3233;
            class233 var1;
            synchronized(field3233) {
               var1 = (class233)field3233.method3622();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3204 == 0) {
                  var1.field3201.method3009((int)var1.hash, var1.field3200, var1.field3200.length);
                  var2 = field3233;
                  synchronized(field3233) {
                     var1.unlink();
                  }
               } else if(var1.field3204 == 1) {
                  var1.field3200 = var1.field3201.method3008((int)var1.hash);
                  var2 = field3233;
                  synchronized(field3233) {
                     field3234.method3634(var1);
                  }
               }

               var14 = field3236;
               synchronized(field3236) {
                  if(field3235 <= 1) {
                     field3235 = 0;
                     field3236.notifyAll();
                     return;
                  }

                  field3235 = 600;
               }
            } else {
               class100.method1842(100L);
               var14 = field3236;
               synchronized(field3236) {
                  if(field3235 <= 1) {
                     field3235 = 0;
                     field3236.notifyAll();
                     return;
                  }

                  --field3235;
               }
            }
         }
      } catch (Exception var13) {
         Projectile.method1734((String)null, var13);
      }
   }

   static {
      field3233 = new Deque();
      field3234 = new Deque();
      field3235 = 0;
      field3236 = new Object();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "332619095"
   )
   public static int method4231(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
