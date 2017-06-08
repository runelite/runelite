import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public class class271 {
   @ObfuscatedName("l")
   static String field3689;
   @ObfuscatedName("e")
   public static boolean field3690;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "-358351551"
   )
   public static SpritePixels[] method4937(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4141(var1);
      int var4 = var0.method4209(var3, var2);
      return class1.method4(var0, var3, var4);
   }
}
