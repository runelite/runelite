import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class181 extends CacheableNode {
   @ObfuscatedName("n")
   class184 field2703;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1202861357
   )
   int field2704;
   @ObfuscatedName("m")
   byte field2705;
   @ObfuscatedName("g")
   static ModIcon[] field2706;

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-608438885"
   )
   static void method3325(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      Frames.method1930(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         Frames.method1930(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2405((long)var1.id);
      if(var5 != null) {
         class101.method1990(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
