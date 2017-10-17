import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("nr")
   @ObfuscatedSignature(
      signature = "[Lbe;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1081886707
   )
   static int field451;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 657560699
   )
   int field448;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 394472219
   )
   int field444;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1926723921
   )
   int field449;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1388690319
   )
   int field447;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -419715153
   )
   int field446;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1328591581
   )
   int field445;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1824114945
   )
   int field442;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -40386513
   )
   int field443;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1324843087
   )
   int field440;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2023737759
   )
   int field439;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1359106856"
   )
   public boolean vmethod722(int var1, int var2) {
      return var1 >> 6 >= this.field448 && var1 >> 6 <= this.field447 && var2 >> 6 >= this.field446 && var2 >> 6 <= this.field442;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1997246299"
   )
   public boolean vmethod725(int var1, int var2, int var3) {
      return var1 >= this.field444 && var1 < this.field449 + this.field444?var2 >> 6 >= this.field445 && var2 >> 6 <= this.field443 && var3 >> 6 >= this.field440 && var3 >> 6 <= this.field439:false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Las;B)V",
      garbageValue = "125"
   )
   public void vmethod723(WorldMapData var1) {
      if(var1.field473 > this.field448) {
         var1.field473 = this.field448;
      }

      if(var1.field474 < this.field447) {
         var1.field474 = this.field447;
      }

      if(var1.field475 > this.field446) {
         var1.field475 = this.field446;
      }

      if(var1.field476 < this.field442) {
         var1.field476 = this.field442;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Lhl;",
      garbageValue = "-58"
   )
   public Coordinates vmethod727(int var1, int var2) {
      if(!this.vmethod722(var1, var2)) {
         return null;
      } else {
         int var3 = this.field445 * 64 - this.field448 * 64 + var1;
         int var4 = this.field440 * 64 - this.field446 * 64 + var2;
         return new Coordinates(this.field444, var3, var4);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-170036108"
   )
   public int[] vmethod741(int var1, int var2, int var3) {
      if(!this.vmethod725(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field448 * 64 - this.field445 * 64 + var2, var3 + (this.field446 * 64 - this.field440 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "88"
   )
   public void vmethod728(Buffer var1) {
      this.field444 = var1.readUnsignedByte();
      this.field449 = var1.readUnsignedByte();
      this.field445 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field443 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field448 = var1.readUnsignedShort();
      this.field446 = var1.readUnsignedShort();
      this.field447 = var1.readUnsignedShort();
      this.field442 = var1.readUnsignedShort();
      this.method245();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1977613153"
   )
   void method245() {
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-595719160"
   )
   static final void method264() {
      class33.method337();
      FloorUnderlayDefinition.underlays.reset();
      KitDefinition.identKits.reset();
      ObjectComposition.objects.reset();
      ObjectComposition.field3484.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3477.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      Spotanim.spotanims.reset();
      Spotanim.field3323.reset();
      Varbit.varbits.reset();
      class89.method1784();
      class243.method4420();
      CombatInfo2.field3362.reset();
      CombatInfo2.spriteCache.reset();
      class157.method3056();
      ClanMember.method1198();
      class21.method149();
      PlayerComposition.field2628.reset();
      class147.method2976();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1518.reset();
      class64.indexInterfaces.reset();
      Varcs.indexSoundEffects.reset();
      ClanMember.field918.reset();
      BaseVarType.field34.reset();
      class226.indexMaps.reset();
      class268.indexTrack1.reset();
      GraphicsObject.indexModels.reset();
      class37.indexSprites.reset();
      class8.indexTextures.reset();
      Client.field1193.reset();
      Renderable.indexTrack2.reset();
      class51.indexScripts.reset();
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-415054257"
   )
   static final void method266(int var0) {
      if(class93.loadWidget(var0)) {
         Widget[] var1 = class177.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2776 = 0;
               var3.field2781 = 0;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfd;I)V",
      garbageValue = "-1332728631"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = AbstractByteBuffer.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field886 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - WallObject.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - Varcs.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class5.plane = var2.field894 = var4;
      if(class94.field1478[var1] != null) {
         var2.decodeApperance(class94.field1478[var1]);
      }

      class94.playerIndexesCount = 0;
      class94.playerIndices[++class94.playerIndexesCount - 1] = var1;
      class94.field1476[var1] = 0;
      class94.field1474 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class94.field1483[var7] = (var10 << 14) + var11 + (var9 << 28);
            class94.field1475[var7] = 0;
            class94.field1481[var7] = -1;
            class94.field1482[++class94.field1474 - 1] = var7;
            class94.field1476[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
