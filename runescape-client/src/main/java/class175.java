import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class175 {
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      longValue = -6090202959263834037L
   )
   static long field2642;

   class175() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "53"
   )
   static void method3332(Widget var0) {
      Widget var1 = var0.parentId == -1?null:ChatLineBuffer.method993(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = RSCanvas.field1756;
         var3 = class65.field1128;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      Friend.method190(var0, var2, var3, false);
      ChatMessages.method947(var0, var2, var3);
   }
}
