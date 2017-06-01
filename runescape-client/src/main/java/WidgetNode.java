import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1833238245
   )
   int field840;
   @ObfuscatedName("cr")
   static IndexData field841;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1938151357
   )
   static int field842;
   @ObfuscatedName("z")
   public static Font field844;
   @ObfuscatedName("e")
   boolean field845;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -790644279
   )
   @Export("id")
   int id;

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   static final void method1084() {
      if(FaceNormal.field2155 != null) {
         FaceNormal.field2155.method2012();
      }

      if(class11.field267 != null) {
         class11.field267.method2012();
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1903609966"
   )
   static final void method1085(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.method3392(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.method3397(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field950[++Client.field968 - 1] = var1;
               var3.field1276 = Client.gameCycle;
               int var4 = Client.secretPacketBuffer2.method3397(1);
               if(var4 == 1) {
                  Client.field971[++Client.field970 - 1] = var1;
               }

               int var5;
               if(var0) {
                  var5 = Client.secretPacketBuffer2.method3397(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = Client.secretPacketBuffer2.method3397(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = Client.secretPacketBuffer2.method3397(1);
               int var7 = Client.field1058[Client.secretPacketBuffer2.method3397(3)];
               if(var2) {
                  var3.field1259 = var3.angle = var7;
               }

               var3.composition = class220.getNpcDefinition(Client.secretPacketBuffer2.method3397(14));
               int var8;
               if(var0) {
                  var8 = Client.secretPacketBuffer2.method3397(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.secretPacketBuffer2.method3397(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field1268 = var3.composition.field3577;
               var3.field1295 = var3.composition.field3574;
               if(var3.field1295 == 0) {
                  var3.angle = 0;
               }

               var3.field1242 = var3.composition.field3557;
               var3.field1299 = var3.composition.field3578;
               var3.field1288 = var3.composition.field3560;
               var3.field1253 = var3.composition.field3545;
               var3.idlePoseAnimation = var3.composition.field3550;
               var3.field1248 = var3.composition.field3555;
               var3.field1249 = var3.composition.field3556;
               var3.method1683(World.localPlayer.pathX[0] + var8, var5 + World.localPlayer.pathY[0], var6 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.method3391();
         return;
      }
   }

   WidgetNode() {
      this.field845 = false;
   }
}
