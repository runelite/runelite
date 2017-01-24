import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class180 extends Node {
   @ObfuscatedName("c")
   byte[] field2701;
   @ObfuscatedName("f")
   class116 field2702;
   @ObfuscatedName("h")
   class184 field2703;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1520265473
   )
   int field2704;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1177269665
   )
   static int field2705;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IIB)LFont;",
      garbageValue = "5"
   )
   public static Font method3174(class182 var0, class182 var1, int var2, int var3) {
      return !class37.method718(var0, var2, var3)?null:Actor.method591(var1.getConfigData(var2, var3));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-39"
   )
   static void method3175(int var0) {
      Client.field557 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      class45.method789();
      if(Client.gameState >= 25) {
         Client.field336.method2963(104);
         Client.field336.method2708(Tile.method1515());
         Client.field336.method2709(class16.field186);
         Client.field336.method2709(ChatMessages.field907);
      }

      GameEngine.field1783 = true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1507738006"
   )
   public static int method3176(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "1160535928"
   )
   public static void method3177(class182 var0, class182 var1, class182 var2) {
      class196.field2880 = var0;
      class196.field2873 = var1;
      class196.field2872 = var2;
   }
}
