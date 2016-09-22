import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class161 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1055113430"
   )
   static void method3211(int var0) {
      if(var0 == -1 && !Client.field426) {
         class186.field3015.method3671();
         class186.field3016 = 1;
         class186.field3017 = null;
      } else if(var0 != -1 && var0 != Client.field496 && Client.field517 != 0 && !Client.field426) {
         class171 var1 = class8.field140;
         int var2 = Client.field517;
         class186.field3016 = 1;
         class186.field3017 = var1;
         class186.field3019 = var0;
         class186.field3022 = 0;
         class177.field2951 = var2;
         class186.field3020 = false;
         class21.field585 = 2;
      }

      Client.field496 = var0;
   }
}
