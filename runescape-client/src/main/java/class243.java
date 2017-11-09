import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class243 implements Runnable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static Deque field3297;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static Deque field3295;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1201277355
   )
   public static int field3296;
   @ObfuscatedName("j")
   public static Object field3300;
   @ObfuscatedName("v")
   static Thread field3294;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[[Lhk;"
   )
   @Export("widgets")
   public static Widget[][] widgets;

   static {
      field3297 = new Deque();
      field3295 = new Deque();
      field3296 = 0;
      field3300 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3297;
            FileSystem var1;
            synchronized(field3297) {
               var1 = (FileSystem)field3297.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3267 == 0) {
                  var1.index.method3123((int)var1.hash, var1.field3265, var1.field3265.length);
                  var2 = field3297;
                  synchronized(field3297) {
                     var1.unlink();
                  }
               } else if(var1.field3267 == 1) {
                  var1.field3265 = var1.index.method3126((int)var1.hash);
                  var2 = field3297;
                  synchronized(field3297) {
                     field3295.addFront(var1);
                  }
               }

               var14 = field3300;
               synchronized(field3300) {
                  if(field3296 <= 1) {
                     field3296 = 0;
                     field3300.notifyAll();
                     return;
                  }

                  field3296 = 600;
               }
            } else {
               class61.method1130(100L);
               var14 = field3300;
               synchronized(field3300) {
                  if(field3296 <= 1) {
                     field3296 = 0;
                     field3300.notifyAll();
                     return;
                  }

                  --field3296;
               }
            }
         }
      } catch (Exception var13) {
         class33.method396((String)null, var13);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1593956711"
   )
   static final void method4378(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2834(var0, var1, var2);
      int[] var8 = Region.method2834(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }
}
