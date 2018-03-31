import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public final class class80 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Deque field1261;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1188703061
   )
   int field1265;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -941884387
   )
   int field1264;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 915812067
   )
   int field1255;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1670250133
   )
   int field1256;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 661121375
   )
   int field1257;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -231796655
   )
   int field1258;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1074996169
   )
   int field1259;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   class115 field1260;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   ObjectComposition field1252;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -574238073
   )
   int field1266;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 255971133
   )
   int field1262;
   @ObfuscatedName("e")
   int[] field1263;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1514372027
   )
   int field1253;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   class115 field1254;

   static {
      field1261 = new Deque();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1638708764"
   )
   void method1732() {
      int var1 = this.field1259;
      ObjectComposition var2 = this.field1252.getImpostor();
      if(var2 != null) {
         this.field1259 = var2.ambientSoundId;
         this.field1258 = var2.int4 * 128;
         this.field1266 = var2.int5;
         this.field1262 = var2.int6;
         this.field1263 = var2.field3634;
      } else {
         this.field1259 = -1;
         this.field1258 = 0;
         this.field1266 = 0;
         this.field1262 = 0;
         this.field1263 = null;
      }

      if(var1 != this.field1259 && this.field1260 != null) {
         GameCanvas.field632.method2062(this.field1260);
         this.field1260 = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "3688509"
   )
   static void method1735() {
      class62.tileUnderlayIds = null;
      class62.tileOverlayIds = null;
      class62.tileOverlayPath = null;
      RunException.overlayRotations = null;
      class62.field721 = null;
      class62.field725 = null;
      class62.field719 = null;
      AttackOption.floorHues = null;
      class1.floorSaturations = null;
      class204.field2613 = null;
      class57.floorMultiplier = null;
      FrameMap.field1973 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lbz;I)V",
      garbageValue = "-428103561"
   )
   @Export("changeWorld")
   static void changeWorld(World var0) {
      if(var0.method1614() != Client.isMembers) {
         Client.isMembers = var0.method1614();
         boolean var1 = var0.method1614();
         if(var1 != class154.isMembersWorld) {
            class47.method745();
            class154.isMembersWorld = var1;
         }
      }

      Client.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      WorldMapRegion.port1 = Client.socketType == 0?43594:var0.id + 40000;
      FontName.port2 = Client.socketType == 0?443:var0.id + 50000;
      Player.myWorldPort = WorldMapRegion.port1;
   }
}
