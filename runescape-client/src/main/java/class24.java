import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class24 {
   @ObfuscatedName("ak")
   static Client field356;
   @ObfuscatedName("h")
   public static final class24 field357;
   @ObfuscatedName("u")
   public static final class24 field358;
   @ObfuscatedName("q")
   final String field359;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1580682051
   )
   final int field360;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1974680807
   )
   final int field361;
   @ObfuscatedName("j")
   static Buffer field362;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1264989545
   )
   static int field364;
   @ObfuscatedName("n")
   static int[] field365;
   @ObfuscatedName("i")
   public static final class24 field367;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1205881661
   )
   final int field368;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;III)V",
      garbageValue = "4"
   )
   class24(String var1, int var2, int var3, int var4) {
      this.field359 = var1;
      this.field360 = var2;
      this.field361 = var3;
      this.field368 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass24;",
      garbageValue = "767048081"
   )
   static class24[] method166() {
      return new class24[]{field358, field357, field367};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "643901213"
   )
   boolean method168(float var1) {
      return var1 >= (float)this.field368;
   }

   static {
      field367 = new class24("SMALL", 0, 0, 4);
      field357 = new class24("MEDIUM", 2, 1, 2);
      field358 = new class24("LARGE", 1, 2, 0);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method175() {
      if(class238.field3257 != null) {
         class238.field3257.method3048();
      }

   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "1347961198"
   )
   static void method176(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class123.method2366(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class123.method2366(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3615((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class14.method75(var6)) {
            class123.method2366(class90.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
