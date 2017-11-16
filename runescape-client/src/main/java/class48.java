import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 324284971
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -125556105
   )
   int field576;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -628781693
   )
   int field571;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 902168645
   )
   int field566;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1965431513
   )
   int field567;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 436870139
   )
   int field568;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 292273323
   )
   int field569;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -166778025
   )
   int field570;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2564773
   )
   int field564;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 621142347
   )
   int field572;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1812839547
   )
   int field574;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "1999614542"
   )
   public void vmethod670(WorldMapData var1) {
      if(var1.field423 > this.field568) {
         var1.field423 = this.field568;
      }

      if(var1.field424 < this.field568) {
         var1.field424 = this.field568;
      }

      if(var1.field417 > this.field569) {
         var1.field417 = this.field569;
      }

      if(var1.field426 < this.field569) {
         var1.field426 = this.field569;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "16"
   )
   public boolean vmethod667(int var1, int var2, int var3) {
      return var1 >= this.field576 && var1 < this.field571 + this.field576?var2 >= (this.field566 << 6) + (this.field570 << 3) && var2 <= (this.field566 << 6) + (this.field570 << 3) + 7 && var3 >= (this.field567 << 6) + (this.field564 << 3) && var3 <= (this.field567 << 6) + (this.field564 << 3) + 7:false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "748684240"
   )
   public boolean vmethod668(int var1, int var2) {
      return var1 >= (this.field568 << 6) + (this.field572 << 3) && var1 <= (this.field568 << 6) + (this.field572 << 3) + 7 && var2 >= (this.field569 << 6) + (this.field574 << 3) && var2 <= (this.field569 << 6) + (this.field574 << 3) + 7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1806249195"
   )
   public int[] vmethod682(int var1, int var2, int var3) {
      if(!this.vmethod667(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field568 * 64 - this.field566 * 64 + var2 + (this.field572 * 8 - this.field570 * 8), var3 + (this.field569 * 64 - this.field567 * 64) + (this.field574 * 8 - this.field564 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lhk;",
      garbageValue = "-98479540"
   )
   public Coordinates vmethod669(int var1, int var2) {
      if(!this.vmethod668(var1, var2)) {
         return null;
      } else {
         int var3 = this.field566 * 64 - this.field568 * 64 + (this.field570 * 8 - this.field572 * 8) + var1;
         int var4 = this.field567 * 64 - this.field569 * 64 + var2 + (this.field564 * 8 - this.field574 * 8);
         return new Coordinates(this.field576, var3, var4);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1450864888"
   )
   public void vmethod665(Buffer var1) {
      this.field576 = var1.readUnsignedByte();
      this.field571 = var1.readUnsignedByte();
      this.field566 = var1.readUnsignedShort();
      this.field570 = var1.readUnsignedByte();
      this.field567 = var1.readUnsignedShort();
      this.field564 = var1.readUnsignedByte();
      this.field568 = var1.readUnsignedShort();
      this.field572 = var1.readUnsignedByte();
      this.field569 = var1.readUnsignedShort();
      this.field574 = var1.readUnsignedByte();
      this.method671();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method671() {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "8"
   )
   public static int method686(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "995392721"
   )
   public static void method690(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;Lij;I)V",
      garbageValue = "1761526131"
   )
   public static void method689(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class17.seq_ref = var0;
      Sequence.skel_ref = var1;
      Sequence.skin_ref = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "2044094855"
   )
   public static int method687(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class111.method2096(var9);
         var8 = class111.method2096(var10);
         var9 = class274.method4875(var9, var2);
         var10 = class274.method4875(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return class1.method0(var9, var2) - class1.method0(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return class1.method0(var11, var2) - class1.method0(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return class1.method0(var12, var2) - class1.method0(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1252993223"
   )
   static final void method673() {
      Timer.method2998();
      FloorUnderlayDefinition.underlays.reset();
      class224.method4071();
      ObjectComposition.objects.reset();
      ObjectComposition.field3489.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3491.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class20.method149();
      Spotanim.spotanims.reset();
      Spotanim.field3376.reset();
      WallObject.method2872();
      VarPlayerType.varplayers.reset();
      class261.field3469.reset();
      class261.field3464.reset();
      class261.field3465.reset();
      CombatInfo2.field3424.reset();
      CombatInfo2.spriteCache.reset();
      class284.method4941();
      class258.field3435.reset();
      PacketBuffer.method3484();
      PlayerComposition.field2695.reset();
      Widget.field2707.reset();
      Widget.field2708.reset();
      Widget.field2849.reset();
      Widget.field2783.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1436.reset();
      class139.indexInterfaces.reset();
      ChatLineBuffer.indexSoundEffects.reset();
      Friend.field759.reset();
      class23.field326.reset();
      RSCanvas.indexMaps.reset();
      class45.indexTrack1.reset();
      class22.indexModels.reset();
      Signlink.indexSprites.reset();
      FloorUnderlayDefinition.indexTextures.reset();
      Player.field840.reset();
      class61.indexTrack2.reset();
      class29.indexScripts.reset();
   }
}
