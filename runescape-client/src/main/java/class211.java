import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class211 {
   @ObfuscatedName("ek")
   static ModIcon[] field3121;
   @ObfuscatedName("g")
   public static int[] field3125;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-926676804"
   )
   public static ModIcon method3870(class182 var0, String var1, String var2) {
      int var3 = var0.method3218(var1);
      int var4 = var0.method3219(var3, var2);
      return class20.method197(var0, var3, var4);
   }
}
