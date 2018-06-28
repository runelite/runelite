import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("nl")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   static class307 field170;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 304469767
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("m")
   @Export("identifier")
   String identifier;
   @ObfuscatedName("q")
   @Export("name")
   String name;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1717593601
   )
   int field171;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 649016241
   )
   @Export("initialMapSurfaceZoom")
   int initialMapSurfaceZoom;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Coordinates field175;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1148285323
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 435286975
   )
   int field177;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -517933057
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 761760769
   )
   int field179;
   @ObfuscatedName("l")
   boolean field182;
   @ObfuscatedName("d")
   LinkedList field181;

   public WorldMapData() {
      this.fileId = -1;
      this.field171 = -1;
      this.initialMapSurfaceZoom = -1;
      this.field175 = null;
      this.minX = Integer.MAX_VALUE;
      this.field177 = 0;
      this.minY = Integer.MAX_VALUE;
      this.field179 = 0;
      this.field182 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1652999580"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.identifier = var1.readString();
      this.name = var1.readString();
      this.field175 = new Coordinates(var1.readInt());
      this.field171 = var1.readInt();
      var1.readUnsignedByte();
      this.field182 = var1.readUnsignedByte() == 1;
      this.initialMapSurfaceZoom = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field181 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field181.add(this.method234(var1));
      }

      this.method230();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)Lan;",
      garbageValue = "1857556313"
   )
   WorldMapSectionBase method234(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class15 var3 = (class15)class7.forOrdinal(class15.getWorldMapTypes(), var2);
      Object var4 = null;
      switch(var3.worldMapType) {
      case 0:
         var4 = new class37();
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

      ((WorldMapSectionBase)var4).vmethod697(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2127339237"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      Iterator var4 = this.field181.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "797903077"
   )
   @Export("surfaceContainsPosition")
   public boolean surfaceContainsPosition(int x, int y) {
      int var3 = x / 64;
      int var4 = y / 64;
      if(var3 >= this.minX && var3 <= this.field177) {
         if(var4 >= this.minY && var4 <= this.field179) {
            Iterator var5 = this.field181.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod694(x, y));

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
      garbageValue = "-115293407"
   )
   public int[] method281(int var1, int var2, int var3) {
      Iterator var4 = this.field181.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5.vmethod712(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Lhh;",
      garbageValue = "-158641779"
   )
   public Coordinates method229(int var1, int var2) {
      Iterator var3 = this.field181.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod694(var1, var2));

      return var4.vmethod707(var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   void method230() {
      Iterator var1 = this.field181.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod692(this);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1688444003"
   )
   @Export("getFileId")
   public int getFileId() {
      return this.fileId;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-246462321"
   )
   public boolean method265() {
      return this.field182;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-787896223"
   )
   @Export("getIdentifier")
   public String getIdentifier() {
      return this.identifier;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2031090465"
   )
   int method235() {
      return this.field171;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "490850638"
   )
   @Export("getInitialMapSurfaceZoom")
   public int getInitialMapSurfaceZoom() {
      return this.initialMapSurfaceZoom;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2121771207"
   )
   @Export("getMinX")
   public int getMinX() {
      return this.minX;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-118"
   )
   public int method238() {
      return this.field177;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1514892384"
   )
   @Export("getMinY")
   public int getMinY() {
      return this.minY;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1939790173"
   )
   public int method270() {
      return this.field179;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "257"
   )
   public int method241() {
      return this.field175.worldX;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "116"
   )
   public int method242() {
      return this.field175.plane;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1576650277"
   )
   public int method243() {
      return this.field175.worldY;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Lhh;",
      garbageValue = "-1803643827"
   )
   public Coordinates method244() {
      return new Coordinates(this.field175);
   }

   @ObfuscatedName("m")
   static final void method293(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-1942813104"
   )
   public static boolean method294(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
