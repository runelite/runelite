import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class215 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lig;",
      garbageValue = "855164858"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "131404512"
   )
   public static void method4106(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            FrameMap.widgetIndex.method4236(var0);
            if(class177.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class177.widgets[var0].length; ++var2) {
                  if(class177.widgets[var0][var2] != null) {
                     if(class177.widgets[var0][var2].type != 2) {
                        class177.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class177.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }
}
