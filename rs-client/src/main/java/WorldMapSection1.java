import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
   @ObfuscatedName("c")
   @Export("userHomeDirectory")
   public static String userHomeDirectory;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache15")
   static IndexCache indexCache15;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1516124929
   )
   @Export("__as_ey")
   static int __as_ey;
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
   @Export("__m")
   int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1483447179
   )
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1875803617
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 284566685
   )
   @Export("__w")
   int __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1513010233
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1383826035
   )
   @Export("__u")
   int __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1526007343
   )
   @Export("__g")
   int __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -890169045
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1797724181
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 325777555
   )
   @Export("__x")
   int __x;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "1384899025"
   )
   public void expandBounds(WorldMapArea var1) {
      if(var1.minX0 > this.__o) {
         var1.minX0 = this.__o;
      }

      if(var1.maxX0 < this.__o) {
         var1.maxX0 = this.__o;
      }

      if(var1.minY0 > this.__u) {
         var1.minY0 = this.__u;
      }

      if(var1.maxY0 < this.__u) {
         var1.maxY0 = this.__u;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "93"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.__m && var1 < this.__m + this.__f?var2 >= (this.__q << 6) + (this.__g << 3) && var2 <= (this.__q << 6) + (this.__g << 3) + 7 && var3 >= (this.__w << 6) + (this.__l << 3) && var3 <= (this.__w << 6) + (this.__l << 3) + 7:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "4"
   )
   public boolean containsPosition(int var1, int var2) {
      return var1 >= (this.__o << 6) + (this.__e << 3) && var1 <= (this.__o << 6) + (this.__e << 3) + 7 && var2 >= (this.__u << 6) + (this.__x << 3) && var2 <= (this.__u << 6) + (this.__x << 3) + 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1545934424"
   )
   public int[] position(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.__o * 64 - this.__q * 64 + var2 + (this.__e * 8 - this.__g * 8), var3 + (this.__u * 64 - this.__w * 64) + (this.__x * 8 - this.__l * 8)};
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhu;",
      garbageValue = "-1916486802"
   )
   public TileLocation coord(int var1, int var2) {
      if(!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.__q * 64 - this.__o * 64 + (this.__g * 8 - this.__e * 8) + var1;
         int var4 = this.__w * 64 - this.__u * 64 + var2 + (this.__l * 8 - this.__x * 8);
         return new TileLocation(this.__m, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "-113"
   )
   public void read(Buffer var1) {
      this.__m = var1.readUnsignedByte();
      this.__f = var1.readUnsignedByte();
      this.__q = var1.__ag_302();
      this.__g = var1.readUnsignedByte();
      this.__w = var1.__ag_302();
      this.__l = var1.readUnsignedByte();
      this.__o = var1.__ag_302();
      this.__e = var1.readUnsignedByte();
      this.__u = var1.__ag_302();
      this.__x = var1.readUnsignedByte();
      this.__g_84();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2026323437"
   )
   @Export("__g_84")
   void __g_84() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lim;",
      garbageValue = "-205156540"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.KitDefinition_indexCache.takeRecord(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.read(new Buffer(var2));
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
      class230.__hy_az = true;
      Client.__client_cw = true;
      Client.__client_pp = -1L;
      class68.method1694();
      Client.packetWriter.__m_165();
      Client.packetWriter.packetBuffer.index = 0;
      Client.packetWriter.serverPacket0 = null;
      Client.packetWriter.__k = null;
      Client.packetWriter.__n = null;
      Client.packetWriter.__i = null;
      Client.packetWriter.serverPacket0Length = 0;
      Client.packetWriter.__x = 0;
      Client.rebootTimer = 0;
      Client.__client_fd = 0;
      Client.hintArrowType = 0;
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
      MouseHandler.MouseHandler_idleCycles = 0;
      GroundItem.method2094();
      Client.isItemSelected = 0;
      Client.isSpellSelected = false;
      Client.soundEffectCount = 0;
      Client.minimapOrientation = 0;
      Client.oculusOrbState = 0;
      ClientParameter.field3645 = null;
      Client.minimapState = 0;
      Client.__client_ph = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcCount = 0;
      Players.Players_count = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Players.__cq_o[var0] = null;
         Players.__cq_w[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.players[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.npcs[var0] = null;
      }

      Client.combatTargetPlayerIndex = -1;
      Client.projectiles.clear();
      Client.graphicsObjects.clear();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItems[var0][var1][var2] = null;
            }
         }
      }

      Client.__client_kh = new NodeDeque();
      WorldMapArea.friendSystem.clear();

      for(var0 = 0; var0 < VarpDefinition.__ix_f; ++var0) {
         VarpDefinition var3 = SecureRandomCallable.method1140(var0);
         if(var3 != null) {
            Varps.Varps_temp[var0] = 0;
            Varps.Varps_main[var0] = 0;
         }
      }

      class196.varcs.clearTransient();
      Client.followerIndex = -1;
      if(Client.rootWidgetGroup != -1) {
         AbstractByteArrayCopier.method4023(Client.rootWidgetGroup);
      }

      for(WidgetGroupParent var4 = (WidgetGroupParent)Client.widgetGroupParents.first(); var4 != null; var4 = (WidgetGroupParent)Client.widgetGroupParents.next()) {
         MenuAction.closeWidgetGroup(var4, true);
      }

      Client.rootWidgetGroup = -1;
      Client.widgetGroupParents = new NodeHashTable(8);
      Client.__client_mo = null;
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
      Client.__client_ru.__m_385((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerMenuActions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      SpriteMask.method4389();
      Client.isLoading = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.__client_od[var0] = true;
      }

      AbstractByteArrayCopier.method4024();
      PacketWriter.clanChat = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      FloorDecoration.grandExchangeEvents = null;
   }
}
