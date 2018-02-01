import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 512123093
   )
   public static int field427;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1310212741
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("i")
   String field421;
   @ObfuscatedName("w")
   String field429;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1533471279
   )
   int field423;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1588105363
   )
   int field424;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   Coordinates field432;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 548054435
   )
   int field426;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1682096565
   )
   int field433;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -152605265
   )
   int field428;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1105735775
   )
   int field422;
   @ObfuscatedName("o")
   boolean field430;
   @ObfuscatedName("x")
   LinkedList field431;

   public WorldMapData() {
      this.fileId = -1;
      this.field423 = -1;
      this.field424 = -1;
      this.field432 = null;
      this.field426 = Integer.MAX_VALUE;
      this.field433 = 0;
      this.field428 = Integer.MAX_VALUE;
      this.field422 = 0;
      this.field430 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "714943653"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field421 = var1.readString();
      this.field429 = var1.readString();
      this.field432 = new Coordinates(var1.readInt());
      this.field423 = var1.readInt();
      var1.readUnsignedByte();
      this.field430 = var1.readUnsignedByte() == 1;
      this.field424 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field431 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field431.add(this.method306(var1));
      }

      this.method296();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;I)Lad;",
      garbageValue = "1932685746"
   )
   WorldMapSectionBase method306(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)ClanMember.forOrdinal(class27.method229(), var2);
      Object var4 = null;
      switch(var3.field369) {
      case 0:
         var4 = new class48();
         break;
      case 1:
         var4 = new WorldMapType3();
         break;
      case 2:
         var4 = new WorldMapType2();
         break;
      case 3:
         var4 = new WorldMapType1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod706(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1077858042"
   )
   public boolean method292(int var1, int var2, int var3) {
      Iterator var4 = this.field431.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod702(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1829837117"
   )
   public boolean method293(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field426 && var3 <= this.field433) {
         if(var4 >= this.field428 && var4 <= this.field422) {
            Iterator var5 = this.field431.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod703(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1045230722"
   )
   public int[] method294(int var1, int var2, int var3) {
      Iterator var4 = this.field431.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod702(var1, var2, var3));

      return var5.vmethod711(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "-1560712230"
   )
   public Coordinates method295(int var1, int var2) {
      Iterator var3 = this.field431.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod703(var1, var2));

      return var4.vmethod700(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1313075912"
   )
   void method296() {
      Iterator var1 = this.field431.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod701(this);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-215067709"
   )
   public int method297() {
      return this.fileId;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1164415217"
   )
   public boolean method324() {
      return this.field430;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public String method299() {
      return this.field421;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "743532993"
   )
   public String method300() {
      return this.field429;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-315810353"
   )
   int method354() {
      return this.field423;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1739272758"
   )
   public int method302() {
      return this.field424;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-34"
   )
   public int method358() {
      return this.field426;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2052920878"
   )
   public int method304() {
      return this.field433;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "31"
   )
   public int method305() {
      return this.field428;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1200577105"
   )
   public int method307() {
      return this.field422;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1525929458"
   )
   public int method355() {
      return this.field432.worldX;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "47"
   )
   public int method349() {
      return this.field432.plane;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "253705664"
   )
   public int method308() {
      return this.field432.worldY;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Lhn;",
      garbageValue = "-4"
   )
   public Coordinates method309() {
      return new Coordinates(this.field432);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-63"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(Ljm;IIII)V",
      garbageValue = "1057845748"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field879 != 0) {
         if(var0.field3662 != null && var1 < var0.field3662.length) {
            int var4 = var0.field3662[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var5;
               Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var6;
               Client.unknownSoundValues2[Client.queuedSoundEffectCount] = 0;
               Client.audioEffects[Client.queuedSoundEffectCount] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.soundLocations[Client.queuedSoundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.queuedSoundEffectCount;
            }
         }
      }
   }
}
