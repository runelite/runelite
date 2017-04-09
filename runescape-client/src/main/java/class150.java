import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class150 {
   @ObfuscatedName("ps")
   static GarbageCollectorMXBean field2067;

   class150() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "29731"
   )
   static void method2839() {
      FileOnDisk var0 = null;

      try {
         var0 = class45.method868("", Client.field304.field2709, true);
         Buffer var1 = class148.field2058.method650();
         var0.method1447(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1448();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-3048"
   )
   static int method2841(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }
}
