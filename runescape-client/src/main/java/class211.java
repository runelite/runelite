import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class211 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "1766517104"
   )
   public static SpritePixels method3824(class182 var0, String var1, String var2) {
      int var3 = var0.method3197(var1);
      int var4 = var0.method3198(var3, var2);
      return class37.method717(var0, var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method3825() {
      class138.field1923.method2503();
      class138.field1933 = 1;
      ChatLineBuffer.field967 = null;
   }
}
