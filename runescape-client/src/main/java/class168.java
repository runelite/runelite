import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class168 {
   @ObfuscatedName("ib")
   @Export("localPlayer")
   static Player localPlayer;

   static {
      new HashMap();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1881866535"
   )
   static int method3119() {
      return ++class98.field1530 - 1;
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "52"
   )
   static Widget method3120(Widget var0) {
      int var1 = class44.method614(class251.method4472(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class177.method3390(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1362394658"
   )
   static final boolean method3121() {
      return class134.field2007;
   }
}
