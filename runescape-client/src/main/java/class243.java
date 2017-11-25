import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class243 implements Runnable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field3307;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field3306;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1650854241
   )
   static int field3308;
   @ObfuscatedName("z")
   static Object field3309;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1005389043
   )
   static int field3310;
   @ObfuscatedName("n")
   public static boolean field3311;

   static {
      field3307 = new Deque();
      field3306 = new Deque();
      field3308 = 0;
      field3309 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3307;
            FileSystem var1;
            synchronized(field3307) {
               var1 = (FileSystem)field3307.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3282 == 0) {
                  var1.index.method3137((int)var1.hash, var1.field3280, var1.field3280.length);
                  var2 = field3307;
                  synchronized(field3307) {
                     var1.unlink();
                  }
               } else if(var1.field3282 == 1) {
                  var1.field3280 = var1.index.method3136((int)var1.hash);
                  var2 = field3307;
                  synchronized(field3307) {
                     field3306.addFront(var1);
                  }
               }

               var14 = field3309;
               synchronized(field3309) {
                  if(field3308 <= 1) {
                     field3308 = 0;
                     field3309.notifyAll();
                     return;
                  }

                  field3308 = 600;
               }
            } else {
               BaseVarType.method12(100L);
               var14 = field3309;
               synchronized(field3309) {
                  if(field3308 <= 1) {
                     field3308 = 0;
                     field3309.notifyAll();
                     return;
                  }

                  --field3308;
               }
            }
         }
      } catch (Exception var13) {
         Item.method1829((String)null, var13);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "99"
   )
   public static boolean method4358(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
