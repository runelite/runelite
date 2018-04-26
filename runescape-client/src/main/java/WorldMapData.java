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
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1875931855
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("e")
   @Export("identifier")
   String identifier;
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1266346901
   )
   int field444;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1296252979
   )
   int field445;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   Coordinates field446;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -496169997
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -409240297
   )
   int field448;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1344263769
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1055216285
   )
   int field450;
   @ObfuscatedName("i")
   boolean field441;
   @ObfuscatedName("o")
   LinkedList field452;

   public WorldMapData() {
      this.fileId = -1;
      this.field444 = -1;
      this.field445 = -1;
      this.field446 = null;
      this.minX = Integer.MAX_VALUE;
      this.field448 = 0;
      this.minY = Integer.MAX_VALUE;
      this.field450 = 0;
      this.field441 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-907071767"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.identifier = var1.readString();
      this.name = var1.readString();
      this.field446 = new Coordinates(var1.readInt());
      this.field444 = var1.readInt();
      var1.readUnsignedByte();
      this.field441 = var1.readUnsignedByte() == 1;
      this.field445 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field452 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field452.add(this.method281(var1));
      }

      this.method286();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgg;I)Lau;",
      garbageValue = "675373286"
   )
   WorldMapSectionBase method281(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)class185.forOrdinal(class27.method218(), var2);
      Object var4 = null;
      switch(var3.field395) {
      case 0:
         var4 = new WorldMapType1();
         break;
      case 1:
         var4 = new WorldMapType2();
         break;
      case 2:
         var4 = new class49();
         break;
      case 3:
         var4 = new WorldMapType3();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod769(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1126776194"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      Iterator var4 = this.field452.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   public boolean method283(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.minX && var3 <= this.field448) {
         if(var4 >= this.minY && var4 <= this.field450) {
            Iterator var5 = this.field452.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod766(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1382001879"
   )
   public int[] method354(int var1, int var2, int var3) {
      Iterator var4 = this.field452.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5.vmethod767(var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)Lio;",
      garbageValue = "12"
   )
   public Coordinates method285(int var1, int var2) {
      Iterator var3 = this.field452.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod766(var1, var2));

      return var4.vmethod768(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-65"
   )
   void method286() {
      Iterator var1 = this.field452.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod763(this);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2003457344"
   )
   @Export("getFileId")
   public int getFileId() {
      return this.fileId;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1530487725"
   )
   public boolean method358() {
      return this.field441;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "-8764"
   )
   @Export("getIdentifier")
   public String getIdentifier() {
      return this.identifier;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1123735725"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-190813230"
   )
   int method316() {
      return this.field444;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2105428269"
   )
   public int method318() {
      return this.field445;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1937099924"
   )
   @Export("getMinX")
   public int getMinX() {
      return this.minX;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1871264734"
   )
   public int method294() {
      return this.field448;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1729566797"
   )
   @Export("getMinY")
   public int getMinY() {
      return this.minY;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2120906225"
   )
   public int method296() {
      return this.field450;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "59"
   )
   public int method297() {
      return this.field446.worldX;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2120055752"
   )
   public int method298() {
      return this.field446.plane;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "703582571"
   )
   public int method299() {
      return this.field446.worldY;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Lio;",
      garbageValue = "-112"
   )
   public Coordinates method300() {
      return new Coordinates(this.field446);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "925297228"
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "19136899"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class95.method2076(var0 - 1, var1 - 1) + class95.method2076(1 + var0, var1 - 1) + class95.method2076(var0 - 1, 1 + var1) + class95.method2076(var0 + 1, 1 + var1);
      int var3 = class95.method2076(var0 - 1, var1) + class95.method2076(1 + var0, var1) + class95.method2076(var0, var1 - 1) + class95.method2076(var0, var1 + 1);
      int var4 = class95.method2076(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1952673830"
   )
   static String method357(String var0) {
      Permission[] var1 = TextureProvider.method2688();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Permission var3 = var1[var2];
         if(var3.field3334 != -1 && var0.startsWith(class241.method4532(var3.field3334))) {
            var0 = var0.substring(6 + Integer.toString(var3.field3334).length());
            break;
         }
      }

      return var0;
   }
}
