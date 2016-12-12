import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public abstract class class156 {
   @ObfuscatedName("e")
   static boolean field2117 = false;
   @ObfuscatedName("ck")
   static class110 field2118;
   @ObfuscatedName("ga")
   static Widget field2119;
   @ObfuscatedName("f")
   static ModIcon field2120;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1914510908"
   )
   abstract byte[] vmethod2952();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-22"
   )
   abstract void vmethod2953(byte[] var1);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "119"
   )
   public static void method2954() {
      CombatInfo2.field2837.reset();
      CombatInfo2.field2833.reset();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-884547072"
   )
   public static boolean method2956(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-70"
   )
   static void method2961() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2313(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2321()) {
         int var1 = var0.id;
         if(class212.method3870(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2198;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class191.method3433(var4);
               if(var5 != null) {
                  class94.method1890(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)LModIcon;",
      garbageValue = "119"
   )
   static ModIcon method2963() {
      ModIcon var0 = new ModIcon();
      var0.width = class225.field3215;
      var0.originalHeight = class225.field3216;
      var0.offsetX = class225.field3217[0];
      var0.offsetY = RSCanvas.field1748[0];
      var0.originalWidth = class225.field3218[0];
      var0.height = Item.field897[0];
      var0.palette = class167.field2191;
      var0.pixels = class154.field2106[0];
      class185.method3361();
      return var0;
   }
}
