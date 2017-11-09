import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
public class class280 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILhq;ZI)V",
      garbageValue = "1869522742"
   )
   static void method5096(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = BaseVarType.method13().method5438(var0);
      int var4 = class48.localPlayer.field852;
      int var5 = (class48.localPlayer.x >> 7) + ItemLayer.baseX;
      int var6 = (class48.localPlayer.y >> 7) + ItemLayer.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      BaseVarType.method13().method5428(var3, var7, var1, var2);
   }
}
