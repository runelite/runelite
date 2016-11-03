import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class85 implements class115 {
   @ObfuscatedName("q")
   public static final class85 field1484 = new class85(1, 1);
   @ObfuscatedName("f")
   public static final class85 field1485 = new class85(2, 2);
   @ObfuscatedName("c")
   public static final class85 field1486 = new class85(3, 3);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -600550695
   )
   public final int field1488;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1946838029
   )
   final int field1489;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -2011312723
   )
   static int field1490;
   @ObfuscatedName("k")
   public static final class85 field1492 = new class85(0, 0);
   @ObfuscatedName("v")
   public static final class85 field1494 = new class85(4, 4);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-116"
   )
   public int vmethod3197() {
      return this.field1489;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1488 = var1;
      this.field1489 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1399290420"
   )
   public static boolean method1938(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!class214.field3185.method3296(var0)) {
         return false;
      } else {
         int var1 = class214.field3185.method3290(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class214.field3185.method3305(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3417(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3445(new Buffer(var3));
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
