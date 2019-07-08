import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
   @ObfuscatedName("c")
   @Export("userHomeDirectory")
   public static String userHomeDirectory;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("archive15")
   static Archive archive15;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1516124929
   )
   static int field1071;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1052834531
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1971304641
   )
   int field1072;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1483447179
   )
   int field1073;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1875803617
   )
   int field1074;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 284566685
   )
   int field1075;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1513010233
   )
   int field1076;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1383826035
   )
   int field1077;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1526007343
   )
   int field1078;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -890169045
   )
   int field1079;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1797724181
   )
   int field1080;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 325777555
   )
   int field1081;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "1384899025"
   )
   @Export("expandBounds")
   public void expandBounds(WorldMapArea area) {
      if (area.minX0 > this.field1076) {
         area.minX0 = this.field1076;
      }

      if (area.maxX0 < this.field1076) {
         area.maxX0 = this.field1076;
      }

      if (area.minY0 > this.field1077) {
         area.minY0 = this.field1077;
      }

      if (area.maxY0 < this.field1077) {
         area.maxY0 = this.field1077;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "93"
   )
   @Export("containsCoord")
   public boolean containsCoord(int plane, int x, int y) {
      return plane >= this.field1072 && plane < this.field1072 + this.field1073 ? x >= (this.field1074 << 6) + (this.field1078 << 3) && x <= (this.field1074 << 6) + (this.field1078 << 3) + 7 && y >= (this.field1075 << 6) + (this.field1079 << 3) && y <= (this.field1075 << 6) + (this.field1079 << 3) + 7 : false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "4"
   )
   @Export("containsPosition")
   public boolean containsPosition(int x, int y) {
      return x >= (this.field1076 << 6) + (this.field1080 << 3) && x <= (this.field1076 << 6) + (this.field1080 << 3) + 7 && y >= (this.field1077 << 6) + (this.field1081 << 3) && y <= (this.field1077 << 6) + (this.field1081 << 3) + 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1545934424"
   )
   @Export("position")
   public int[] position(int plane, int x, int y) {
      if (!this.containsCoord(plane, x, y)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field1076 * 64 - this.field1074 * 64 + x + (this.field1080 * 8 - this.field1078 * 8), y + (this.field1077 * 64 - this.field1075 * 64) + (this.field1081 * 8 - this.field1079 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhu;",
      garbageValue = "-1916486802"
   )
   @Export("coord")
   public Coord coord(int x, int y) {
      if (!this.containsPosition(x, y)) {
         return null;
      } else {
         int var3 = this.field1074 * 64 - this.field1076 * 64 + (this.field1078 * 8 - this.field1080 * 8) + x;
         int var4 = this.field1075 * 64 - this.field1077 * 64 + y + (this.field1079 * 8 - this.field1081 * 8);
         return new Coord(this.field1072, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "-113"
   )
   @Export("read")
   public void read(Buffer buffer) {
      this.field1072 = buffer.readUnsignedByte();
      this.field1073 = buffer.readUnsignedByte();
      this.field1074 = buffer.readUnsignedShort();
      this.field1078 = buffer.readUnsignedByte();
      this.field1075 = buffer.readUnsignedShort();
      this.field1079 = buffer.readUnsignedByte();
      this.field1076 = buffer.readUnsignedShort();
      this.field1080 = buffer.readUnsignedByte();
      this.field1077 = buffer.readUnsignedShort();
      this.field1081 = buffer.readUnsignedByte();
      this.method424();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2026323437"
   )
   void method424() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lim;",
      garbageValue = "-205156540"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
         var1 = new KitDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.KitDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2142100332"
   )
   static void method808() {
      Client.mouseLastLastPressedTimeMillis = 1L;
      Projectile.mouseRecorder.index = 0;
      class230.field1138 = true;
      Client.field166 = true;
      Client.field126 = -1L;
      PendingSpawn.method1694();
      Client.packetWriter.method239();
      Client.packetWriter.packetBuffer.index = 0;
      Client.packetWriter.serverPacket0 = null;
      Client.packetWriter.field676 = null;
      Client.packetWriter.field677 = null;
      Client.packetWriter.field678 = null;
      Client.packetWriter.serverPacket0Length = 0;
      Client.packetWriter.field674 = 0;
      Client.rebootTimer = 0;
      Client.field175 = 0;
      Client.hintArrowType = 0;
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
      MouseHandler.MouseHandler_idleCycles = 0;
      GroundItem.method2094();
      Client.isItemSelected = 0;
      Client.isSpellSelected = false;
      Client.soundEffectCount = 0;
      Client.camAngleY = 0;
      Client.oculusOrbState = 0;
      ClientParameter.field3645 = null;
      Client.minimapState = 0;
      Client.field125 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcCount = 0;
      Players.Players_count = 0;

      int var0;
      for (var0 = 0; var0 < 2048; ++var0) {
         Players.field733[var0] = null;
         Players.field732[var0] = 1;
      }

      for (var0 = 0; var0 < 2048; ++var0) {
         Client.players[var0] = null;
      }

      for (var0 = 0; var0 < 32768; ++var0) {
         Client.npcs[var0] = null;
      }

      Client.combatTargetPlayerIndex = -1;
      Client.projectiles.clear();
      Client.graphicsObjects.clear();

      for (var0 = 0; var0 < 4; ++var0) {
         for (int var1 = 0; var1 < 104; ++var1) {
            for (int var2 = 0; var2 < 104; ++var2) {
               Client.groundItems[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new NodeDeque();
      WorldMapArea.friendSystem.clear();

      for (var0 = 0; var0 < VarpDefinition.field944; ++var0) {
         VarpDefinition var3 = SecureRandomCallable.method1140(var0);
         if (var3 != null) {
            Varps.Varps_temp[var0] = 0;
            Varps.Varps_main[var0] = 0;
         }
      }

      class196.varcs.clearTransient();
      Client.followerIndex = -1;
      if (Client.rootInterface != -1) {
         AbstractByteArrayCopier.unloadInterface(Client.rootInterface);
      }

      for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
         MenuAction.closeInterface(var4, true);
      }

      Client.rootInterface = -1;
      Client.interfaceParents = new NodeHashTable(8);
      Client.field127 = null;
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
      Client.playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for (var0 = 0; var0 < 8; ++var0) {
         Client.playerMenuActions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      SpriteMask.method4389();
      Client.isLoading = true;

      for (var0 = 0; var0 < 100; ++var0) {
         Client.field100[var0] = true;
      }

      AbstractByteArrayCopier.method4024();
      PacketWriter.clanChat = null;

      for (var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      FloorDecoration.grandExchangeEvents = null;
   }
}
