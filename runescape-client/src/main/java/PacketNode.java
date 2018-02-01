import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("ol")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   static Resampler field2406;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lfa;"
   )
   @Export("packetBufferNodes")
   static PacketNode[] packetBufferNodes;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1985407565
   )
   static int field2404;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2141539355
   )
   public int field2400;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -812658017
   )
   public int field2399;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;

   static {
      packetBufferNodes = new PacketNode[300];
      field2404 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1822471847"
   )
   public void method3302() {
      if(field2404 < packetBufferNodes.length) {
         packetBufferNodes[++field2404 - 1] = this;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "65"
   )
   static void method3314(String var0, String var1, String var2) {
      class89.loginMessage1 = var0;
      class89.loginMessage2 = var1;
      class89.loginMessage3 = var2;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(ZLgd;B)V",
      garbageValue = "-23"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field867.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5;
               if(var0) {
                  var5 = var1.getBits(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = var1.getBits(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = Client.field934[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var6;
               }

               var4.composition = class230.getNpcDefinition(var1.getBits(14));
               int var7 = var1.getBits(1);
               int var8;
               if(var0) {
                  var8 = var1.getBits(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = var1.getBits(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               int var9 = var1.getBits(1);
               if(var9 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               var4.field1127 = var4.composition.field3611;
               var4.field1150 = var4.composition.field3634;
               if(var4.field1150 == 0) {
                  var4.angle = 0;
               }

               var4.field1105 = var4.composition.field3632;
               var4.field1144 = var4.composition.field3629;
               var4.field1104 = var4.composition.field3606;
               var4.field1108 = var4.composition.field3636;
               var4.idlePoseAnimation = var4.composition.field3614;
               var4.field1106 = var4.composition.field3615;
               var4.field1149 = var4.composition.field3616;
               var4.method1821(class36.localPlayer.pathX[0] + var5, class36.localPlayer.pathY[0] + var8, var7 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
