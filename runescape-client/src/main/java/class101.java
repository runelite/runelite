import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class101 extends RuntimeException {
   @ObfuscatedName("s")
   static Applet field1652;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 366809927
   )
   static int field1653;
   @ObfuscatedName("qv")
   protected static class109 field1654;
   @ObfuscatedName("h")
   String field1655;
   @ObfuscatedName("a")
   Throwable field1656;
   @ObfuscatedName("c")
   public static String field1657;
   @ObfuscatedName("eg")
   static SpritePixels[] field1658;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-905615855"
   )
   public static void method1902() {
      Widget.field2203.reset();
      Widget.field2204.reset();
      Widget.field2327.reset();
      Widget.field2206.reset();
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "1070561070"
   )
   static void method1903(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class108.method1988(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class16.field186;
         var3 = ChatMessages.field907;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class94.method1861(var0, var2, var3, false);
      class10.method99(var0, var2, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1064255568"
   )
   static void method1904(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var0);
      if(null != var1) {
         var1.unlink();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1264562497"
   )
   public static boolean method1905(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
