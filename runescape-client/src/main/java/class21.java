import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class21 implements class115 {
   @ObfuscatedName("x")
   static final class21 field574 = new class21(0);
   @ObfuscatedName("r")
   static final class21 field575 = new class21(1);
   @ObfuscatedName("f")
   static ModIcon field576;
   @ObfuscatedName("z")
   static final class21 field577 = new class21(3);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1144826613
   )
   final int field578;
   @ObfuscatedName("j")
   static final class21 field580 = new class21(2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1074689381"
   )
   public int vmethod3206() {
      return this.field578;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field578 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method553() {
      ObjectComposition.field925.reset();
      ObjectComposition.field926.reset();
      ObjectComposition.field927.reset();
      ObjectComposition.field928.reset();
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-1398884010"
   )
   static void method554(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      Client.method353(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         Client.method353(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3830((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class175.method3419(var6)) {
            Client.method353(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "603229081"
   )
   public static boolean method555() {
      return class186.field3009 != 0?true:class186.field3008.method3624();
   }
}
