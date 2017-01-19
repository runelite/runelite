import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class215 {
   @ObfuscatedName("iu")
   static Widget field3163;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "-1487869157"
   )
   public static SpritePixels[] method3829(class182 var0, String var1, String var2) {
      int var3 = var0.method3197(var1);
      int var4 = var0.method3198(var3, var2);
      return class99.method1882(var0, var3, var4);
   }
}
