import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class5 implements Comparator {
   @ObfuscatedName("x")
   public static class182 field36;
   @ObfuscatedName("ah")
   static class184 field38;
   @ObfuscatedName("il")
   static Widget field40;

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZB)V",
      garbageValue = "1"
   )
   static void method71(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var1 == var6.parentId) {
            Friend.method190(var6, var2, var3, var4);
            ChatMessages.method947(var6, var2, var3);
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
               Script.method973(var0, var6, var4);
            }
         }
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method79((class2)var1, (class2)var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1557775715"
   )
   int method79(class2 var1, class2 var2) {
      return var1.field13.price < var2.field13.price?-1:(var1.field13.price == var2.field13.price?0:1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-1986099387"
   )
   public static int method80(CharSequence var0, int var1) {
      return class31.method718(var0, var1, true);
   }
}
