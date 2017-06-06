import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class236 implements Runnable {
   @ObfuscatedName("v")
   public static Object field3234;
   @ObfuscatedName("c")
   static Deque field3235;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1045187219
   )
   public static int field3236;
   @ObfuscatedName("i")
   static Deque field3238;

   public void run() {
      try {
         while(true) {
            Deque var2 = field3238;
            class233 var1;
            synchronized(field3238) {
               var1 = (class233)field3238.method3576();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3207 == 0) {
                  var1.field3199.method3009((int)var1.hash, var1.field3198, var1.field3198.length);
                  var2 = field3238;
                  synchronized(field3238) {
                     var1.unlink();
                  }
               } else if(var1.field3207 == 1) {
                  var1.field3198 = var1.field3199.method3008((int)var1.hash);
                  var2 = field3238;
                  synchronized(field3238) {
                     field3235.method3571(var1);
                  }
               }

               var14 = field3234;
               synchronized(field3234) {
                  if(field3236 <= 1) {
                     field3236 = 0;
                     field3234.notifyAll();
                     return;
                  }

                  field3236 = 600;
               }
            } else {
               class4.method9(100L);
               var14 = field3234;
               synchronized(field3234) {
                  if(field3236 <= 1) {
                     field3236 = 0;
                     field3234.notifyAll();
                     return;
                  }

                  --field3236;
               }
            }
         }
      } catch (Exception var13) {
         class21.method138((String)null, var13);
      }
   }

   static {
      field3238 = new Deque();
      field3235 = new Deque();
      field3236 = 0;
      field3234 = new Object();
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "2010191879"
   )
   static void method4216(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class174.method3351(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class174.method3351(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3520((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(RSSocket.method2986(var6)) {
            class174.method3351(CombatInfo1.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
