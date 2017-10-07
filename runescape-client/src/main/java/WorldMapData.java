import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("e")
   String field469;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 358484699
   )
   int field470;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1629130759
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("y")
   boolean field481;
   @ObfuscatedName("k")
   String field468;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1353570259
   )
   int field471;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   Coordinates field477;
   @ObfuscatedName("o")
   LinkedList field472;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1979232561
   )
   int field476;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1832750369
   )
   int field474;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1636419931
   )
   int field473;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -59642277
   )
   int field475;

   public WorldMapData() {
      this.fileId = -1;
      this.field470 = -1;
      this.field471 = -1;
      this.field477 = null;
      this.field473 = Integer.MAX_VALUE;
      this.field474 = 0;
      this.field475 = Integer.MAX_VALUE;
      this.field476 = 0;
      this.field481 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "-1820399052"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field468 = var1.readString();
      this.field469 = var1.readString();
      this.field477 = new Coordinates(var1.readInt());
      this.field470 = var1.readInt();
      var1.readUnsignedByte();
      this.field481 = var1.readUnsignedByte() == 1;
      this.field471 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field472 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field472.add(this.method271(var1));
      }

      this.method305();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1473273369"
   )
   public String method279() {
      return this.field468;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1993964038"
   )
   public boolean method273(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field473 && var3 <= this.field474) {
         if(var4 >= this.field475 && var4 <= this.field476) {
            Iterator var5 = this.field472.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod722(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1891539820"
   )
   public int method313() {
      return this.fileId;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "3"
   )
   public int[] method285(int var1, int var2, int var3) {
      Iterator var4 = this.field472.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod725(var1, var2, var3));

      return var5.vmethod741(var1, var2, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2146750857"
   )
   public int method316() {
      return this.field473;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1787271169"
   )
   public int method333() {
      return this.field475;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1504447665"
   )
   public boolean method272(int var1, int var2, int var3) {
      Iterator var4 = this.field472.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod725(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Lhl;",
      garbageValue = "2133890698"
   )
   public Coordinates method275(int var1, int var2) {
      Iterator var3 = this.field472.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod722(var1, var2));

      return var4.vmethod727(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1878288075"
   )
   public int method288() {
      return this.field477.plane;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-541189718"
   )
   public int method287() {
      return this.field477.worldX;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1175565688"
   )
   public int method289() {
      return this.field477.worldY;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1655300219"
   )
   public int method292() {
      return this.field471;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2129016075"
   )
   void method305() {
      Iterator var1 = this.field472.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod723(this);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;I)Lap;",
      garbageValue = "-748797229"
   )
   WorldMapSectionBase method271(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)class48.forOrdinal(class27.method205(), var2);
      Object var4 = null;
      switch(var3.field404) {
      case 0:
         var4 = new WorldMapType2();
         break;
      case 1:
         var4 = new WorldMapType3();
         break;
      case 2:
         var4 = new WorldMapType1();
         break;
      case 3:
         var4 = new class48();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod728(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "55"
   )
   public boolean method278() {
      return this.field481;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2065562566"
   )
   public int method290() {
      return this.field474;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "323725333"
   )
   public int method323() {
      return this.field476;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   int method274() {
      return this.field470;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "8"
   )
   public String method280() {
      return this.field469;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lhl;",
      garbageValue = "1765771957"
   )
   public Coordinates method326() {
      return new Coordinates(this.field477);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1110881421"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
