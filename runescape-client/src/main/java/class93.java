import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
final class class93 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class93(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lb;Lb;I)I",
      garbageValue = "-1564919917"
   )
   int method1836(class14 var1, class14 var2) {
      if(var2.field297 == var1.field297) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field297) {
               return -1;
            }

            if(var2.field297 == Client.world) {
               return 1;
            }
         }

         return var1.field297 < var2.field297?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1836((class14)var1, (class14)var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lin;",
      garbageValue = "-1720679585"
   )
   public static class254 method1843(int var0) {
      class254 var1 = (class254)class254.field3410.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3420.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4598(new Buffer(var2));
         }

         class254.field3410.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1469692066"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!FrameMap.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = FrameMap.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(class177.widgets[var0] == null) {
               class177.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class177.widgets[var0][var2] == null) {
                  byte[] var3 = FrameMap.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     class177.widgets[var0][var2] = new Widget();
                     class177.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class177.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        class177.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
