import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("x")
   static NodeCache field951 = new NodeCache(128);
   @ObfuscatedName("n")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1838036057
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("v")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1014873543
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2018835459
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("g")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 956239941
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("dk")
   static int[] field959;
   @ObfuscatedName("ak")
   static ModIcon[] field960;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "-1155170453"
   )
   public static class196 method971(int var0) {
      class196 var1 = (class196)class196.field2874.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2890.getConfigData(32, var0);
         var1 = new class196();
         if(null != var2) {
            var1.method3623(new Buffer(var2));
         }

         class196.field2874.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "596643795"
   )
   static void method973(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class5.method71(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class5.method71(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2437((long)var1.id);
      if(var5 != null) {
         class143.method2789(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
