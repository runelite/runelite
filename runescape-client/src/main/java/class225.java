import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class225 {
   @ObfuscatedName("s")
   public static class116 field3230;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "-30"
   )
   public static ModIcon method4021(class170 var0, String var1, String var2) {
      int var3 = var0.method3265(var1);
      int var4 = var0.method3266(var3, var2);
      ModIcon var5;
      if(!class35.method729(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = Frames.method2268();
      }

      return var5;
   }
}
