import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
public class class273 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-1220515154"
   )
   public static ModIcon method4789(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4055(var1);
      int var4 = var0.method4020(var3, var2);
      ModIcon var5;
      if(!class1.method3(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var6 = new ModIcon();
         var6.width = class220.field2818;
         var6.originalHeight = class286.field3792;
         var6.offsetX = class286.field3793[0];
         var6.offsetY = class286.field3794[0];
         var6.originalWidth = class286.field3791[0];
         var6.height = class149.field2211[0];
         var6.palette = class116.field1686;
         var6.pixels = class286.field3797[0];
         class286.field3793 = null;
         class286.field3794 = null;
         class286.field3791 = null;
         class149.field2211 = null;
         class116.field1686 = null;
         class286.field3797 = (byte[][])null;
         var5 = var6;
      }

      return var5;
   }
}
