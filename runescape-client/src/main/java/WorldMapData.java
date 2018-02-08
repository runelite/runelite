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
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -1843058031
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1281386029
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("g")
   String field430;
   @ObfuscatedName("m")
   String field427;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -777050177
   )
   int field429;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 160041055
   )
   int field440;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   Coordinates field431;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -65467211
   )
   int field432;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1849033659
   )
   int field433;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1905411377
   )
   int field426;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -843816965
   )
   int field435;
   @ObfuscatedName("c")
   boolean field436;
   @ObfuscatedName("o")
   LinkedList field437;

   public WorldMapData() {
      this.fileId = -1;
      this.field429 = -1;
      this.field440 = -1;
      this.field431 = null;
      this.field432 = Integer.MAX_VALUE;
      this.field433 = 0;
      this.field426 = Integer.MAX_VALUE;
      this.field435 = 0;
      this.field436 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1056681482"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field430 = var1.readString();
      this.field427 = var1.readString();
      this.field431 = new Coordinates(var1.readInt());
      this.field429 = var1.readInt();
      var1.readUnsignedByte();
      this.field436 = var1.readUnsignedByte() == 1;
      this.field440 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field437 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field437.add(this.method273(var1));
      }

      this.method278();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)Lae;",
      garbageValue = "1533127536"
   )
   WorldMapSectionBase method273(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field383, class27.field384, class27.field374, class27.field386};
      class27 var4 = (class27)Projectile.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field377) {
      case 0:
         var5 = new class48();
         break;
      case 1:
         var5 = new WorldMapType3();
         break;
      case 2:
         var5 = new WorldMapType1();
         break;
      case 3:
         var5 = new WorldMapType2();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod686(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1735106973"
   )
   public boolean method334(int var1, int var2, int var3) {
      Iterator var4 = this.field437.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod682(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2011805503"
   )
   public boolean method335(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field432 && var3 <= this.field433) {
         if(var4 >= this.field426 && var4 <= this.field435) {
            Iterator var5 = this.field437.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod683(var1, var2));

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
      signature = "(IIII)[I",
      garbageValue = "804679581"
   )
   public int[] method331(int var1, int var2, int var3) {
      Iterator var4 = this.field437.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod682(var1, var2, var3));

      return var5.vmethod684(var1, var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhv;",
      garbageValue = "-1820330299"
   )
   public Coordinates method286(int var1, int var2) {
      Iterator var3 = this.field437.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod683(var1, var2));

      return var4.vmethod700(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1955994105"
   )
   void method278() {
      Iterator var1 = this.field437.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod681(this);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1629521613"
   )
   public int method279() {
      return this.fileId;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-19"
   )
   public boolean method280() {
      return this.field436;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "279571064"
   )
   public String method275() {
      return this.field430;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-102653598"
   )
   public String method281() {
      return this.field427;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "128"
   )
   int method272() {
      return this.field429;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-62"
   )
   public int method311() {
      return this.field440;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "814627225"
   )
   public int method284() {
      return this.field432;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1404998397"
   )
   public int method320() {
      return this.field433;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "38"
   )
   public int method305() {
      return this.field426;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2071475541"
   )
   public int method287() {
      return this.field435;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1581996497"
   )
   public int method308() {
      return this.field431.worldX;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1833948245"
   )
   public int method276() {
      return this.field431.plane;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-102"
   )
   public int method315() {
      return this.field431.worldY;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)Lhv;",
      garbageValue = "-1791020877"
   )
   public Coordinates method291() {
      return new Coordinates(this.field431);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "-1658455031"
   )
   static int method339(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class94.field1418:ItemLayer.field1668;
      if(var0 == 1600) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class80.intStack[++class80.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class80.intStack[++class80.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class80.intStack[++class80.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class80.intStack[++class80.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2786;
         return 1;
      } else if(var0 == 1611) {
         class80.intStack[++class80.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2780;
         return 1;
      } else if(var0 == 1613) {
         class80.intStack[++class80.intStackSize - 1] = var3.field2832.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-448731011"
   )
   static final void method338() {
      Region.regionLowMemory = false;
      Client.lowMemory = false;
   }
}
