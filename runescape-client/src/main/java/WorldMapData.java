import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("o")
   LinkedList field461;
   @ObfuscatedName("w")
   String field462;
   @ObfuscatedName("r")
   Coordinates field463;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -973651543
   )
   int field464;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 751680101
   )
   int field465;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1120027301
   )
   int field466;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1150511051
   )
   int field467;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1796334073
   )
   int field468;
   @ObfuscatedName("a")
   String field470;
   @ObfuscatedName("e")
   boolean field471;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 110688857
   )
   int field472;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2120268861
   )
   @Export("fileId")
   int fileId;

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1730328708"
   )
   static final boolean method272(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class177.method3365(var0, var1);
            int var3 = var0.field2645[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)LWorldMapSectionBase;",
      garbageValue = "1835250505"
   )
   WorldMapSectionBase method274(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field395, class27.field398, class27.field405, class27.field396};
      class27 var4 = (class27)class134.method2577(var3, var2);
      Object var5 = null;
      switch(var4.field399) {
      case 0:
         var5 = new WorldMapType2();
         break;
      case 1:
         var5 = new WorldMapType1();
         break;
      case 2:
         var5 = new WorldMapType3();
         break;
      case 3:
         var5 = new class48();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod732(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "81"
   )
   public boolean method275(int var1, int var2, int var3) {
      Iterator var4 = this.field461.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod728(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-2115123071"
   )
   public Coordinates method278(int var1, int var2) {
      Iterator var3 = this.field461.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod754(var1, var2));

      return var4.vmethod731(var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2035020902"
   )
   void method279() {
      Iterator var1 = this.field461.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod753(this);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-936991228"
   )
   public int method280() {
      return this.fileId;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-214162025"
   )
   public boolean method281() {
      return this.field471;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1058870856"
   )
   public String method282() {
      return this.field462;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1138350966"
   )
   public String method283() {
      return this.field470;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1514798951"
   )
   public int method285() {
      return this.field465;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "419439650"
   )
   public int method287() {
      return this.field468;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-25208"
   )
   public int method288() {
      return this.field472;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1708406099"
   )
   public int method289() {
      return this.field466;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-410734172"
   )
   public int method292() {
      return this.field463.worldY;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1890931839"
   )
   int method294() {
      return this.field464;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2116282925"
   )
   public int method305() {
      return this.field467;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1474946038"
   )
   public boolean method307(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field467 && var3 <= this.field468) {
         if(var4 >= this.field472 && var4 <= this.field466) {
            Iterator var5 = this.field461.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod754(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-497276117"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field462 = var1.readString();
      this.field470 = var1.readString();
      this.field463 = new Coordinates(var1.readInt());
      this.field464 = var1.readInt();
      var1.readUnsignedByte();
      this.field471 = var1.readUnsignedByte() == 1;
      this.field465 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field461 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field461.add(this.method274(var1));
      }

      this.method279();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "1"
   )
   public int[] method317(int var1, int var2, int var3) {
      Iterator var4 = this.field461.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod728(var1, var2, var3));

      return var5.vmethod730(var1, var2, var3);
   }

   public WorldMapData() {
      this.fileId = -1;
      this.field464 = -1;
      this.field465 = -1;
      this.field463 = null;
      this.field467 = Integer.MAX_VALUE;
      this.field468 = 0;
      this.field472 = Integer.MAX_VALUE;
      this.field466 = 0;
      this.field471 = false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-120244711"
   )
   public int method333() {
      return this.field463.plane;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "-769051734"
   )
   public Coordinates method334() {
      return new Coordinates(this.field463);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2015921890"
   )
   public int method336() {
      return this.field463.worldX;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1607787428"
   )
   static final void method341(boolean var0) {
      class14.method67();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.field979 && class244.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(203);

            try {
               class244.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.field979 = true;
            }
         }

      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "816331099"
   )
   static final int method343(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + var6 * class61.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = (128 - var6) * class61.tileHeights[var5][var3][var4 + 1] + class61.tileHeights[var5][var3 + 1][1 + var4] * var6 >> 7;
         return var8 * (128 - var7) + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "263872365"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method1885(var0, var1, var2, var3);
      class98.field1546.method3479(var5, (long)var5.id);
      class98.field1548.method3642(var5);
      Client.field1119 = Client.field1112;
   }
}
