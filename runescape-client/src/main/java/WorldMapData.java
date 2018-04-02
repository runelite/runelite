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
   @ObfuscatedName("cq")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -54601899
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("i")
   @Export("identifier")
   String identifier;
   @ObfuscatedName("o")
   @Export("name")
   String name;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 270572153
   )
   int field430;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1585681841
   )
   int field439;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   Coordinates field428;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1581477657
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1600219587
   )
   int field431;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1344274627
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2118625715
   )
   int field436;
   @ObfuscatedName("d")
   boolean field437;
   @ObfuscatedName("a")
   LinkedList field435;

   public WorldMapData() {
      this.fileId = -1;
      this.field430 = -1;
      this.field439 = -1;
      this.field428 = null;
      this.minX = Integer.MAX_VALUE;
      this.field431 = 0;
      this.minY = Integer.MAX_VALUE;
      this.field436 = 0;
      this.field437 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;IB)V",
      garbageValue = "39"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.identifier = var1.readString();
      this.name = var1.readString();
      this.field428 = new Coordinates(var1.readInt());
      this.field430 = var1.readInt();
      var1.readUnsignedByte();
      this.field437 = var1.readUnsignedByte() == 1;
      this.field439 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field435 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field435.add(this.method306(var1));
      }

      this.method315();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)Lay;",
      garbageValue = "1849374991"
   )
   WorldMapSectionBase method306(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)class44.forOrdinal(class27.method238(), var2);
      Object var4 = null;
      switch(var3.field381) {
      case 0:
         var4 = new WorldMapType1();
         break;
      case 1:
         var4 = new WorldMapType3();
         break;
      case 2:
         var4 = new WorldMapType2();
         break;
      case 3:
         var4 = new class49();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod756(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-14"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      Iterator var4 = this.field435.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "124"
   )
   public boolean method308(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.minX && var3 <= this.field431) {
         if(var4 >= this.minY && var4 <= this.field436) {
            Iterator var5 = this.field435.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod758(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "694724857"
   )
   public int[] method309(int var1, int var2, int var3) {
      Iterator var4 = this.field435.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5.vmethod754(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lim;",
      garbageValue = "1095448979"
   )
   public Coordinates method354(int var1, int var2) {
      Iterator var3 = this.field435.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod758(var1, var2));

      return var4.vmethod777(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   void method315() {
      Iterator var1 = this.field435.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod751(this);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1306418936"
   )
   @Export("getFileId")
   public int getFileId() {
      return this.fileId;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2120745005"
   )
   public boolean method374() {
      return this.field437;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "16"
   )
   @Export("getIdentifier")
   public String getIdentifier() {
      return this.identifier;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "58"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1057752141"
   )
   int method316() {
      return this.field430;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1822856889"
   )
   public int method352() {
      return this.field439;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("getMinX")
   public int getMinX() {
      return this.minX;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-357714868"
   )
   public int method319() {
      return this.field431;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-352981885"
   )
   @Export("getMinY")
   public int getMinY() {
      return this.minY;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-249777036"
   )
   public int method313() {
      return this.field436;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-98"
   )
   public int method322() {
      return this.field428.worldX;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "46"
   )
   public int method323() {
      return this.field428.plane;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1011483246"
   )
   public int method324() {
      return this.field428.worldY;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Lim;",
      garbageValue = "-1301380918"
   )
   public Coordinates method357() {
      return new Coordinates(this.field428);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-424428171"
   )
   static int method347(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      Enum var5;
      if(var0 == 3400) {
         SceneTilePaint.intStackSize -= 2;
         var3 = class81.intStack[SceneTilePaint.intStackSize];
         var4 = class81.intStack[SceneTilePaint.intStackSize + 1];
         Enum var15 = (Enum)Enum.EnumDefinition_cached.get((long)var3);
         if(var15 != null) {
            var5 = var15;
         } else {
            byte[] var16 = Enum.EnumDefinition_indexCache.getConfigData(8, var3);
            var15 = new Enum();
            if(var16 != null) {
               var15.decode(new Buffer(var16));
            }

            Enum.EnumDefinition_cached.put(var15, (long)var3);
            var5 = var15;
         }

         var15 = var5;
         if(var5.valType != 's') {
            ;
         }

         for(int var7 = 0; var7 < var15.size; ++var7) {
            if(var4 == var15.keys[var7]) {
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = var15.stringVals[var7];
               var15 = null;
               break;
            }
         }

         if(var15 != null) {
            class81.scriptStringStack[++World.scriptStringStackSize - 1] = var15.defaultString;
         }

         return 1;
      } else if(var0 == 3408) {
         SceneTilePaint.intStackSize -= 4;
         var3 = class81.intStack[SceneTilePaint.intStackSize];
         var4 = class81.intStack[SceneTilePaint.intStackSize + 1];
         int var11 = class81.intStack[SceneTilePaint.intStackSize + 2];
         int var12 = class81.intStack[SceneTilePaint.intStackSize + 3];
         Enum var8 = (Enum)Enum.EnumDefinition_cached.get((long)var11);
         Enum var10;
         if(var8 != null) {
            var10 = var8;
         } else {
            byte[] var9 = Enum.EnumDefinition_indexCache.getConfigData(8, var11);
            var8 = new Enum();
            if(var9 != null) {
               var8.decode(new Buffer(var9));
            }

            Enum.EnumDefinition_cached.put(var8, (long)var11);
            var10 = var8;
         }

         var8 = var10;
         if(var3 == var10.keyType && var4 == var10.valType) {
            for(int var13 = 0; var13 < var8.size; ++var13) {
               if(var12 == var8.keys[var13]) {
                  if(var4 == 115) {
                     class81.scriptStringStack[++World.scriptStringStackSize - 1] = var8.stringVals[var13];
                  } else {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var8.intVals[var13];
                  }

                  var8 = null;
                  break;
               }
            }

            if(var8 != null) {
               if(var4 == 115) {
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var8.defaultString;
               } else {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var8.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = "null";
            } else {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
            }

            return 1;
         }
      } else if(var0 == 3411) {
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         var5 = (Enum)Enum.EnumDefinition_cached.get((long)var3);
         Enum var14;
         if(var5 != null) {
            var14 = var5;
         } else {
            byte[] var6 = Enum.EnumDefinition_indexCache.getConfigData(8, var3);
            var5 = new Enum();
            if(var6 != null) {
               var5.decode(new Buffer(var6));
            }

            Enum.EnumDefinition_cached.put(var5, (long)var3);
            var14 = var5;
         }

         class81.intStack[++SceneTilePaint.intStackSize - 1] = var14.method4949();
         return 1;
      } else {
         return 2;
      }
   }
}
