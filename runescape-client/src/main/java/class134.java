import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public abstract class class134 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1569841920"
   )
   static void method2977(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3936((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2006239529"
   )
   public abstract void vmethod3251(Component var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "11744"
   )
   public abstract void vmethod3252(Component var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "467754474"
   )
   public abstract int vmethod3254();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "1853592114"
   )
   public static Widget method2983(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class14.method179(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1953743622"
   )
   static String method2984(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class164.field2702[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class164.field2702[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class164.field2702[(var6 & 15) << 2 | var7 >>> 6]).append(class164.field2702[var7 & 63]);
            } else {
               var3.append(class164.field2702[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class164.field2702[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}
