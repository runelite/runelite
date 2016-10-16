import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1881158487
   )
   static int field670;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1944132699
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1999818495
   )
   @Export("id")
   int id;
   @ObfuscatedName("eu")
   static SpritePixels[] field676;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "64"
   )
   static final void method671(int var0, int var1) {
      if(var0 != class54.field1132 || var1 != class53.field1122) {
         class54.field1132 = var0;
         class53.field1122 = var1;
         class112.setGameState(25);
         class22.method555("Loading - please wait.", true);
         int var2 = class23.baseX;
         int var3 = class8.baseY;
         class23.baseX = (var0 - 6) * 8;
         class8.baseY = (var1 - 6) * 8;
         int var4 = class23.baseX - var2;
         int var5 = class8.baseY - var3;
         var2 = class23.baseX;
         var3 = class8.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= 128 * var4;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= 128 * var4;
               var20.y -= var5 * 128;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var19; var18 != var12; var12 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var12 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var12][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var17 = (class16)Client.field401.method3808(); null != var17; var17 = (class16)Client.field401.method3810()) {
            var17.field209 -= var4;
            var17.field221 -= var5;
            if(var17.field209 < 0 || var17.field221 < 0 || var17.field209 >= 104 || var17.field221 >= 104) {
               var17.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field510 = 0;
         Client.field516 = false;
         Client.field451 = -1;
         Client.field403.method3802();
         Client.projectiles.method3802();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2360();
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-26"
   )
   protected final Model getModel() {
      return class174.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(ClassInfo.worldServersDownload == null) {
            ClassInfo.worldServersDownload = new class18(class8.field121, new URL(class178.field2947));
         } else {
            byte[] var0 = ClassInfo.worldServersDownload.method193();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field630 = var1.method2668();
               World.worldList = new World[World.field630];

               World var3;
               for(int var2 = 0; var2 < World.field630; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.method2668();
                  var3.mask = var1.method2526();
                  var3.address = var1.method2503();
                  var3.activity = var1.method2503();
                  var3.location = var1.method2481();
                  var3.playerCount = var1.method2474();
               }

               class20.method537(World.worldList, 0, World.worldList.length - 1, World.field633, World.field632);
               ClassInfo.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         ClassInfo.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1567833914"
   )
   public static void method675(class170 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3265(var1);
      int var6 = var0.method3266(var5, var2);
      class50.method1001(var0, var5, var6, var3, var4);
   }
}
