import java.awt.Canvas;
import java.awt.Color;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hj")
final class class215 implements Comparator {
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -797816203
   )
   static int field3152;
   @ObfuscatedName("m")
   static int[] field3153;

   @ObfuscatedName("a")
   public static String method3889(class118 var0) {
      String var1;
      try {
         int var2 = var0.method2466();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.field1998 += class221.field3175.method2392(var0.field1995, var0.field1998, var3, 0, var2);
         String var4 = class40.method798(var3, 0, var2);
         var1 = var4;
      } catch (Exception var5) {
         var1 = "Cabbage";
      }

      return var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method3891((class213)var1, (class213)var2);
   }

   @ObfuscatedName("j")
   int method3891(class213 var1, class213 var2) {
      return var1.field3142.field3167 < var2.field3142.field3167?-1:(var1.field3142.field3167 == var2.field3142.field3167?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ar")
   static void method3898() {
      class51.method1024(class125.field2039);
      Canvas var0 = class125.field2039;
      var0.removeMouseListener(class139.field2164);
      var0.removeMouseMotionListener(class139.field2164);
      var0.removeFocusListener(class139.field2164);
      class139.field2158 = 0;
      if(class185.field2998 != null) {
         class185.field2998.vmethod3057(class125.field2039);
      }

      client.field284.method2958();
      class125.field2039.setBackground(Color.black);
      Canvas var1 = class125.field2039;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class136.field2113);
      var1.addFocusListener(class136.field2113);
      Canvas var2 = class125.field2039;
      var2.addMouseListener(class139.field2164);
      var2.addMouseMotionListener(class139.field2164);
      var2.addFocusListener(class139.field2164);
      if(null != class185.field2998) {
         class185.field2998.vmethod3060(class125.field2039);
      }

      if(-1 != client.field448) {
         class51.method1078(false);
      }

      class143.field2212 = true;
   }
}
