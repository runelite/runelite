import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 2135051207
   )
   static int field473;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -159904903
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("s")
   String field462;
   @ObfuscatedName("q")
   String field470;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1721899829
   )
   int field463;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1098201103
   )
   int field465;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   Coordinates field466;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -345616469
   )
   int field464;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1249979755
   )
   int field468;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1842989937
   )
   int field469;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1828284383
   )
   int field461;
   @ObfuscatedName("z")
   boolean field471;
   @ObfuscatedName("n")
   LinkedList field472;

   public WorldMapData() {
      this.fileId = -1;
      this.field463 = -1;
      this.field465 = -1;
      this.field466 = null;
      this.field464 = Integer.MAX_VALUE;
      this.field468 = 0;
      this.field469 = Integer.MAX_VALUE;
      this.field461 = 0;
      this.field471 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "-2035704920"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field462 = var1.readString();
      this.field470 = var1.readString();
      this.field466 = new Coordinates(var1.readInt());
      this.field463 = var1.readInt();
      var1.readUnsignedByte();
      this.field471 = var1.readUnsignedByte() == 1;
      this.field465 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field472 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field472.add(this.method345(var1));
      }

      this.method312();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;I)Lad;",
      garbageValue = "-417786175"
   )
   WorldMapSectionBase method345(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field411, class27.field406, class27.field409, class27.field407};
      class27 var4 = (class27)class29.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field410) {
      case 0:
         var5 = new WorldMapType1();
         break;
      case 1:
         var5 = new WorldMapType3();
         break;
      case 2:
         var5 = new WorldMapType2();
         break;
      case 3:
         var5 = new class48();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod703(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "0"
   )
   public boolean method280(int var1, int var2, int var3) {
      Iterator var4 = this.field472.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod699(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "89"
   )
   public boolean method300(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field464 && var3 <= this.field468) {
         if(var4 >= this.field469 && var4 <= this.field461) {
            Iterator var5 = this.field472.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod700(var1, var2));

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
      signature = "(IIII)[I",
      garbageValue = "-1353509174"
   )
   public int[] method324(int var1, int var2, int var3) {
      Iterator var4 = this.field472.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod699(var1, var2, var3));

      return var5.vmethod709(var1, var2, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhg;",
      garbageValue = "-128"
   )
   public Coordinates method283(int var1, int var2) {
      Iterator var3 = this.field472.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod700(var1, var2));

      return var4.vmethod702(var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   void method312() {
      Iterator var1 = this.field472.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod720(this);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "19"
   )
   public int method285() {
      return this.fileId;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-588815789"
   )
   public boolean method286() {
      return this.field471;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1873265026"
   )
   public String method277() {
      return this.field462;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-325113388"
   )
   public String method309() {
      return this.field470;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1820999965"
   )
   int method289() {
      return this.field463;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-31918462"
   )
   public int method303() {
      return this.field465;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-15"
   )
   public int method291() {
      return this.field464;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-32"
   )
   public int method292() {
      return this.field468;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-239379421"
   )
   public int method293() {
      return this.field469;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1957241015"
   )
   public int method294() {
      return this.field461;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1050300807"
   )
   public int method295() {
      return this.field466.worldX;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1693556523"
   )
   public int method346() {
      return this.field466.plane;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method279() {
      return this.field466.worldY;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lhg;",
      garbageValue = "-716912460"
   )
   public Coordinates method298() {
      return new Coordinates(this.field466);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;B)V",
      garbageValue = "64"
   )
   public static void method338(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.field3559 = var0;
      NPCComposition.field3550 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "63"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(FileSystem.validInterfaces[var0]) {
         return true;
      } else if(!class89.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class89.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            FileSystem.validInterfaces[var0] = true;
            return true;
         } else {
            if(class215.widgets[var0] == null) {
               class215.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class215.widgets[var0][var2] == null) {
                  byte[] var3 = class89.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     class215.widgets[var0][var2] = new Widget();
                     class215.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class215.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        class215.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            FileSystem.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
