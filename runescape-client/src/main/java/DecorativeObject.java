import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("bm")
   static IndexData field1584;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 12523779
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 891200355
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -686954743
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -232911325
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1090924701
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("z")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -93348927
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1185050127
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1958805439
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 935974933
   )
   @Export("x")
   int x;
   @ObfuscatedName("l")
   @Export("renderable2")
   public Renderable renderable2;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1281893423"
   )
   static final void method1928(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.method2657(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.method2645(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field350[++Client.field321 - 1] = var1;
               var3.field648 = Client.gameCycle;
               int var4 = Client.secretPacketBuffer2.method2645(1);
               int var5;
               if(var0) {
                  var5 = Client.secretPacketBuffer2.method2645(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = Client.secretPacketBuffer2.method2645(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = Client.field412[Client.secretPacketBuffer2.method2645(3)];
               if(var2) {
                  var3.field650 = var3.angle = var6;
               }

               var3.composition = Widget.getNpcDefinition(Client.secretPacketBuffer2.method2645(14));
               int var7 = Client.secretPacketBuffer2.method2645(1);
               if(var7 == 1) {
                  Client.field324[++Client.field292 - 1] = var1;
               }

               int var8;
               if(var0) {
                  var8 = Client.secretPacketBuffer2.method2645(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.secretPacketBuffer2.method2645(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field603 = var3.composition.field3042;
               var3.field652 = var3.composition.field3048;
               if(var3.field652 == 0) {
                  var3.angle = 0;
               }

               var3.field659 = var3.composition.field3065;
               var3.field608 = var3.composition.field3033;
               var3.field609 = var3.composition.field3062;
               var3.field610 = var3.composition.field3057;
               var3.idlePoseAnimation = var3.composition.field3047;
               var3.field605 = var3.composition.field3043;
               var3.field606 = var3.composition.field3066;
               var3.method734(class22.localPlayer.pathX[0] + var5, var8 + class22.localPlayer.pathY[0], var4 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.method2647();
         return;
      }
   }
}
