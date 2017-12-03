import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class94 {
   @ObfuscatedName("e")
   static byte[] field1389;
   @ObfuscatedName("k")
   static byte[] field1388;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lgh;"
   )
   static Buffer[] field1392;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1049985723
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("t")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -116092205
   )
   static int field1394;
   @ObfuscatedName("g")
   static int[] field1395;
   @ObfuscatedName("j")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("x")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("c")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 461839065
   )
   static int field1400;
   @ObfuscatedName("n")
   static int[] field1391;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   static Buffer field1401;

   static {
      field1389 = new byte[2048];
      field1388 = new byte[2048];
      field1392 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1394 = 0;
      field1395 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1400 = 0;
      field1391 = new int[2048];
      field1401 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-108"
   )
   public static void method1760(boolean var0) {
      if(var0 != ScriptState.isMembersWorld) {
         ItemComposition.items.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ScriptState.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Lhz;IIIIIII)V",
      garbageValue = "-567247749"
   )
   static final void method1767(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field909) {
         Client.field856 = 32;
      } else {
         Client.field856 = 0;
      }

      Client.field909 = false;
      int var7;
      if(MouseInput.mouseCurrentButton == 1 || !class34.field455 && MouseInput.mouseCurrentButton == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class33.method344(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class33.method344(var0);
         } else if(var5 >= var1 - Client.field856 && var5 < Client.field856 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class33.method344(var0);
            Client.field909 = true;
         }
      }

      if(Client.mouseWheelRotation != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.mouseWheelRotation * 45;
            class33.method344(var0);
         }
      }

   }
}
