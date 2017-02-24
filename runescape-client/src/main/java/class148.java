import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class148 {
   @ObfuscatedName("q")
   public static class182 field2028;

   static {
      new HashMap();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZLFont;I)V",
      garbageValue = "1925392189"
   )
   public static void method2796(class182 var0, class182 var1, boolean var2, Font var3) {
      ItemComposition.field2949 = var0;
      ItemComposition.field2961 = var1;
      ItemComposition.isMembersWorld = var2;
      ItemComposition.field2960 = ItemComposition.field2949.method3313(10);
      class185.field2768 = var3;
   }

   class148() throws Throwable {
      throw new Error();
   }
}
