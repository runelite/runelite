import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class118 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 7224299423400258823L
   )
   static long field2056;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "1268092019"
   )
   public static ModIcon method2468(class170 var0, String var1, String var2) {
      int var3 = var0.method3324(var1);
      int var4 = var0.method3313(var3, var2);
      return NPC.method763(var0, var3, var4);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1485228429"
   )
   static final void method2471() {
      Client.field401 = 0;
      int var0 = (WidgetNode.localPlayer.x >> 7) + class9.baseX;
      int var1 = KitDefinition.baseY + (WidgetNode.localPlayer.y >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field401 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field401 = 1;
      }

      if(Client.field401 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field401 = 0;
      }

   }
}
