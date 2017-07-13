import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class17 implements Comparator {
   @ObfuscatedName("cr")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("ae")
   static int[] field312;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "777054383"
   )
   int method119(class14 var1, class14 var2) {
      return var1.field297.price < var2.field297.price?-1:(var2.field297.price == var1.field297.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method119((class14)var1, (class14)var2);
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "1473992678"
   )
   static void method120(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class181.method3424(var6, var2, var3, var4);
            class164.method3055(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class36.method487(var0, var6, var4);
            }
         }
      }

   }
}
