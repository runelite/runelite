import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1897744937
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1302803231
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -194247391
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1021883979
   )
   @Export("z")
   int z;

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-125"
   )
   static final void method3143(int var0, int var1, int var2, int var3) {
      if(Client.field997) {
         if(Client.cursorState == 1) {
            ScriptState.crossSprites[Client.field1080 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
         }

         if(Client.cursorState == 2) {
            ScriptState.crossSprites[Client.field1080 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
         }
      }

      Client.myPlayerIndex = 0;
      int var4 = (class265.localPlayer.x >> 7) + ClientPacket.baseX;
      int var5 = (class265.localPlayer.y >> 7) + MapIconReference.baseY;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.myPlayerIndex = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.myPlayerIndex = 1;
      }

      if(Client.myPlayerIndex == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.myPlayerIndex = 0;
      }

   }
}
