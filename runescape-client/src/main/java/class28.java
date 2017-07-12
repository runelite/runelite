import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public abstract class class28 {
   @ObfuscatedName("j")
   byte[][][] field408;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1657541437
   )
   int field409;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -292741467
   )
   int field410;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 731865583
   )
   int field411;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2043352399
   )
   int field412;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 16478029
   )
   int field413;
   @ObfuscatedName("v")
   short[][][] field414;
   @ObfuscatedName("fi")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = -772494883
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("e")
   class31[][][][] field418;
   @ObfuscatedName("k")
   byte[][][] field419;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2097863695
   )
   int field420;
   @ObfuscatedName("y")
   short[][][] field421;
   @ObfuscatedName("dx")
   static IndexData field424;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILBuffer;IB)V",
      garbageValue = "-38"
   )
   void method212(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field421[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field414[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2046991982"
   )
   int method213(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field414[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-45"
   )
   int method214() {
      return this.field410;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-966983615"
   )
   int method215() {
      return this.field411;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILBuffer;IB)V",
      garbageValue = "-101"
   )
   void method222(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field414[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var10;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var11 = var3.readUnsignedByte();
            if(var11 != 0) {
               this.field421[var9][var1][var2] = (short)var11;
               var10 = var3.readUnsignedByte();
               this.field408[var9][var1][var2] = (byte)(var10 >> 2);
               this.field419[var9][var1][var2] = (byte)(var10 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field418[var8][var1][var2] = new class31[var9];

               for(var10 = 0; var10 < var9; ++var10) {
                  int var12 = var3.method3130();
                  int var13 = var3.readUnsignedByte();
                  var14[var10] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILBuffer;I)V",
      garbageValue = "2029514419"
   )
   void method228(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method212(var1, var2, var3, var4);
         } else {
            this.method222(var1, var2, var3, var4);
         }
      }

   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-391"
   )
   static final void method231() {
      Overlay.overlays.reset();
      VertexNormal.method2580();
      KitDefinition.identKits.reset();
      Permission.method4098();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      class228.method4093();
      TextureProvider.method2399();
      NPC.method1704();
      ItemLayer.method2407();
      CombatInfo2.field3375.reset();
      CombatInfo2.spriteCache.reset();
      class252.field3402.reset();
      RSCanvas.method804();
      class225.method4082();
      PlayerComposition.field2630.reset();
      Widget.field2755.reset();
      Widget.field2649.reset();
      Widget.field2779.reset();
      Widget.field2657.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1551.reset();
      class44.indexInterfaces.reset();
      class261.indexSoundEffects.reset();
      class10.field259.reset();
      class98.field1545.reset();
      Frames.indexMaps.reset();
      class44.indexTrack1.reset();
      class1.indexModels.reset();
      class18.indexSprites.reset();
      class87.indexTextures.reset();
      DecorativeObject.field2194.reset();
      XGrandExchangeOffer.indexTrack2.reset();
      class169.indexScripts.reset();
   }
}
