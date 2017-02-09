import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
final class class44 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -2133939455
   )
   public static int field893;
   @ObfuscatedName("j")
   public static class182 field896;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1716417372"
   )
   int method818(class2 var1, class2 var2) {
      if(var1.field23 == var2.field23) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field23) {
               return -1;
            }

            if(Client.world == var2.field23) {
               return 1;
            }
         }

         return var1.field23 < var2.field23?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method818((class2)var1, (class2)var2);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;III)LFont;",
      garbageValue = "-2085615071"
   )
   public static Font method825(class182 var0, class182 var1, int var2, int var3) {
      if(!class63.method1175(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(null == var5) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class163.field2287, class225.field3214, class47.field932, class225.field3211, class225.field3215, class225.field3218);
            class221.method4056();
            var4 = var6;
         }

         return var4;
      }
   }
}
