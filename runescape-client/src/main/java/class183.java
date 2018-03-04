import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class183 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2484;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2483;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2485;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2482;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2486;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2487;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2488;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2490;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2489;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static final class183 field2491;

   static {
      field2484 = new class183(14);
      field2483 = new class183(7);
      field2485 = new class183(5);
      field2482 = new class183(3);
      field2486 = new class183(5);
      field2487 = new class183(4);
      field2488 = new class183(15);
      field2490 = new class183(4);
      field2489 = new class183(2);
      field2491 = new class183(6);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "14"
   )
   class183(int var1) {
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "([Liw;Liw;ZI)V",
      garbageValue = "-910273712"
   )
   static void method3484(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      MessageNode.method1128(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         MessageNode.method1128(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class18.loadWidget(var6)) {
            MessageNode.method1128(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
