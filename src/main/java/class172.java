import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fr")
public class class172 extends class204 {
   @ObfuscatedName("e")
   public class168 field2737;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1134231189
   )
   public int field2738;
   @ObfuscatedName("f")
   public byte field2739;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 383820943
   )
   static int field2741;

   @ObfuscatedName("w")
   public static void method3369(Component var0) {
      var0.removeMouseListener(class140.field2142);
      var0.removeMouseMotionListener(class140.field2142);
      var0.removeFocusListener(class140.field2142);
      class140.field2147 = 0;
   }

   @ObfuscatedName("w")
   public static class39 method3370(int var0) {
      class39 var1 = (class39)class39.field866.method3754((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class39.field894.method3280(9, var0);
         var1 = new class39();
         var1.field882 = var0;
         if(null != var2) {
            var1.method777(new class119(var2));
         }

         var1.method757();
         class39.field866.method3756(var1, (long)var0);
         return var1;
      }
   }
}
