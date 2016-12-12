import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class212 {
   @ObfuscatedName("gy")
   public static final int[] field3132 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 5, 6, 0, 14, -1, 0, 0, 0, 0, -2, 0, 0, 6, 2, 0, 0, 7, 3, -2, 0, 2, 0, 0, 0, 0, 0, 0, 20, -2, 0, -2, 0, 0, 0, 0, 1, 5, 0, 2, 0, 0, 0, -2, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 8, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 1, 6, 2, 0, 0, 0, 6, 0, 0, 0, 0, 0, 4, -1, -2, 0, 0, 0, 0, 6, 8, 0, -1, 0, 0, 0, 2, -2, 0, 0, -2, 8, 0, 0, 0, 0, 28, 0, 0, 4, 0, 0, 5, 0, 4, 0, 0, 0, 0, -1, 0, 4, 6, 0, 0, 0, -2, 0, -2, 0, 0, 0, 0, 0, 0, -1, -2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 12, 0, -2, 2, 0, 4, 0, -2, 0, -1, 10, 4, 0, 6, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 15, 3, 0, 2, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 6, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 8, 2, 0, -2, 5, 6};

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-113"
   )
   public static boolean method3870(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2199.method3284(var0)) {
         return false;
      } else {
         int var1 = Widget.field2199.method3220(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = Widget.field2199.method3211(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3148(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3112(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
