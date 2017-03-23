import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class114 {
   @ObfuscatedName("rw")
   protected static boolean field1803;
   @ObfuscatedName("f")
   public static Applet field1804 = null;
   @ObfuscatedName("i")
   public static String field1810 = null;

   class114() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-44"
   )
   static void method2257(int var0) {
      if(var0 != -1) {
         if(Ignore.method178(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2225 != null) {
                  class18 var4 = new class18();
                  var4.field207 = var3;
                  var4.field199 = var3.field2225;
                  CombatInfoListHolder.method719(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "1238247119"
   )
   public static class196 method2258(int var0) {
      class196 var1 = (class196)class196.field2875.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2885.getConfigData(32, var0);
         var1 = new class196();
         if(null != var2) {
            var1.method3618(new Buffer(var2));
         }

         class196.field2875.put(var1, (long)var0);
         return var1;
      }
   }
}
