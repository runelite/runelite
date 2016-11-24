import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class138 {
   @ObfuscatedName("d")
   public static class182 field1913;
   @ObfuscatedName("n")
   public static class182 field1914;
   @ObfuscatedName("m")
   public static class182 field1915;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -904381967
   )
   public static int field1917 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -721352887
   )
   public static int field1918;
   @ObfuscatedName("h")
   public static class139 field1919;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1740788939
   )
   static int field1920;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = 37782888975438621L
   )
   static long field1922;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2146434932"
   )
   static void method2533() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
   )
   public static void method2547() {
      class200.field3038.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "-1116149976"
   )
   public static SpritePixels[] method2548(class182 var0, String var1, String var2) {
      int var3 = var0.method3350(var1);
      int var4 = var0.method3345(var3, var2);
      SpritePixels[] var5;
      if(!KitDefinition.method3566(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = Tile.method1579();
      }

      return var5;
   }
}
