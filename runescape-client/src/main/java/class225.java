import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class225 extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -292416715
   )
   int field2694;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   class227 field2682;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   RawAudioNode field2683;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   class222 field2689;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1104224965
   )
   int field2685;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -237206035
   )
   int field2686;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 574128019
   )
   int field2681;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 456219485
   )
   int field2688;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -662095943
   )
   int field2687;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 294961113
   )
   int field2684;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1686953629
   )
   int field2691;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1307954449
   )
   int field2692;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -680672193
   )
   int field2693;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1452906351
   )
   int field2700;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1598866557
   )
   int field2695;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1940763109
   )
   int field2696;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -485288483
   )
   int field2697;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -974915767
   )
   int field2690;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class114 field2699;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -191394805
   )
   int field2698;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -647023037
   )
   int field2701;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   void method4257() {
      this.field2682 = null;
      this.field2683 = null;
      this.field2689 = null;
      this.field2699 = null;
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1111084843"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = WorldMapType1.getTileHeight(var0, var1, class230.plane) - var2;
         var0 -= class39.cameraX;
         var3 -= class159.cameraZ;
         var1 -= CombatInfo1.cameraY;
         int var4 = Graphics3D.SINE[DecorativeObject.cameraPitch];
         int var5 = Graphics3D.COSINE[DecorativeObject.cameraPitch];
         int var6 = Graphics3D.SINE[class60.cameraYaw];
         int var7 = Graphics3D.COSINE[class60.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = Client.viewportHeight / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Lim;I)V",
      garbageValue = "646386016"
   )
   static final void method4260(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field955 == -1) {
            Client.field955 = var0.spriteId;
            Client.field1070 = var0.field2883;
         }

         if(Client.field1068.isFemale) {
            var0.spriteId = Client.field955;
         } else {
            var0.spriteId = Client.field1070;
         }

      } else if(var1 == 325) {
         if(Client.field955 == -1) {
            Client.field955 = var0.spriteId;
            Client.field1070 = var0.field2883;
         }

         if(Client.field1068.isFemale) {
            var0.spriteId = Client.field1070;
         } else {
            var0.spriteId = Client.field955;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
