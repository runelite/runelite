import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class157 {
   @ObfuscatedName("x")
   public static String field2106;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "942752954"
   )
   public static Widget method3011(int var0, int var1) {
      Widget var2 = class44.method799(var0);
      return var1 == -1?var2:(null != var2 && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "16"
   )
   static final void method3024(int var0) {
      if(class94.method1870(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2215 = 0;
               var3.field2308 = 0;
            }
         }

      }
   }
}
