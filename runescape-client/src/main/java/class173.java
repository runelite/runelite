import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class173 implements Runnable {
   @ObfuscatedName("g")
   static Object field2753 = new Object();
   @ObfuscatedName("lv")
   static class133 field2754;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 502194381
   )
   static int field2755 = 0;
   @ObfuscatedName("i")
   public static Deque field2756 = new Deque();
   @ObfuscatedName("h")
   public static Deque field2757 = new Deque();
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -702078775
   )
   @Export("plane")
   static int plane;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1072233279"
   )
   public static int method3402(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field2756;
            class172 var1;
            synchronized(field2756) {
               var1 = (class172)field2756.method3845();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2747 == 0) {
                  var1.field2750.method2901((int)var1.hash, var1.field2748, var1.field2748.length);
                  var2 = field2756;
                  synchronized(field2756) {
                     var1.unlink();
                  }
               } else if(var1.field2747 == 1) {
                  var1.field2748 = var1.field2750.method2899((int)var1.hash);
                  var2 = field2756;
                  synchronized(field2756) {
                     field2757.method3865(var1);
                  }
               }

               var14 = field2753;
               synchronized(field2753) {
                  if(field2755 <= 1) {
                     field2755 = 0;
                     field2753.notifyAll();
                     return;
                  }

                  field2755 = 600;
               }
            } else {
               PlayerComposition.method3511(100L);
               var14 = field2753;
               synchronized(field2753) {
                  if(field2755 <= 1) {
                     field2755 = 0;
                     field2753.notifyAll();
                     return;
                  }

                  --field2755;
               }
            }
         }
      } catch (Exception var13) {
         class93.method2139((String)null, var13);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LWidget;",
      garbageValue = "70"
   )
   public static Widget method3412(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == Widget.widgets[var1] || null == Widget.widgets[var1][var2]) {
         boolean var3 = class14.method172(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
