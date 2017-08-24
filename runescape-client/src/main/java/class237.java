import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class237 implements Runnable {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static Deque field3243;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static Deque field3235;
   @ObfuscatedName("r")
   public static Object field3239;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 332464061
   )
   public static int field3237;

   static {
      field3243 = new Deque();
      field3235 = new Deque();
      field3237 = 0;
      field3239 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3243;
            FileSystem var1;
            synchronized(field3243) {
               var1 = (FileSystem)field3243.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3205 == 0) {
                  var1.index.method3095((int)var1.hash, var1.field3206, var1.field3206.length);
                  var2 = field3243;
                  synchronized(field3243) {
                     var1.unlink();
                  }
               } else if(var1.field3205 == 1) {
                  var1.field3206 = var1.index.method3083((int)var1.hash);
                  var2 = field3243;
                  synchronized(field3243) {
                     field3235.addFront(var1);
                  }
               }

               var14 = field3239;
               synchronized(field3239) {
                  if(field3237 <= 1) {
                     field3237 = 0;
                     field3239.notifyAll();
                     return;
                  }

                  field3237 = 600;
               }
            } else {
               NPC.method1702(100L);
               var14 = field3239;
               synchronized(field3239) {
                  if(field3237 <= 1) {
                     field3237 = 0;
                     field3239.notifyAll();
                     return;
                  }

                  --field3237;
               }
            }
         }
      } catch (Exception var13) {
         class150.method2975((String)null, var13);
      }
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "972169161"
   )
   static void method4225(Widget var0, int var1, int var2) {
      if(var0.field2663 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2663 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2663 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2663 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2663 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2664 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2664 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2664 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2664 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2664 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1101 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
