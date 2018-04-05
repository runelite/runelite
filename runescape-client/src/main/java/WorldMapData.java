import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("v")
   @Export("cacheLocations")
   static String[] cacheLocations;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      longValue = -5942083673956606217L
   )
   static long field463;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 894764139
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("k")
   @Export("identifier")
   String identifier;
   @ObfuscatedName("t")
   @Export("name")
   String name;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1739420637
   )
   int field454;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1998719381
   )
   int field451;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   Coordinates field453;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1229817577
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1070736261
   )
   int field455;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -440059103
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1291934753
   )
   int field457;
   @ObfuscatedName("y")
   boolean field458;
   @ObfuscatedName("a")
   LinkedList field459;

   public WorldMapData() {
      this.fileId = -1;
      this.field454 = -1;
      this.field451 = -1;
      this.field453 = null;
      this.minX = Integer.MAX_VALUE;
      this.field455 = 0;
      this.minY = Integer.MAX_VALUE;
      this.field457 = 0;
      this.field458 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "-1284991583"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.identifier = var1.readString();
      this.name = var1.readString();
      this.field453 = new Coordinates(var1.readInt());
      this.field454 = var1.readInt();
      var1.readUnsignedByte();
      this.field458 = var1.readUnsignedByte() == 1;
      this.field451 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field459 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field459.add(this.method318(var1));
      }

      this.method323();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgc;B)Lau;",
      garbageValue = "-60"
   )
   WorldMapSectionBase method318(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)Permission.forOrdinal(class27.method243(), var2);
      Object var4 = null;
      switch(var3.field403) {
      case 0:
         var4 = new WorldMapType3();
         break;
      case 1:
         var4 = new WorldMapType2();
         break;
      case 2:
         var4 = new class49();
         break;
      case 3:
         var4 = new WorldMapType1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod754(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "1"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      Iterator var4 = this.field459.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1011288479"
   )
   public boolean method335(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.minX && var3 <= this.field455) {
         if(var4 >= this.minY && var4 <= this.field457) {
            Iterator var5 = this.field459.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod768(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-891314358"
   )
   public int[] method321(int var1, int var2, int var3) {
      Iterator var4 = this.field459.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5.vmethod753(var1, var2, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)Lix;",
      garbageValue = "-45"
   )
   public Coordinates method322(int var1, int var2) {
      Iterator var3 = this.field459.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod768(var1, var2));

      return var4.vmethod758(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4867"
   )
   void method323() {
      Iterator var1 = this.field459.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod767(this);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1323853267"
   )
   @Export("getFileId")
   public int getFileId() {
      return this.fileId;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-471791578"
   )
   public boolean method325() {
      return this.field458;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-180901539"
   )
   @Export("getIdentifier")
   public String getIdentifier() {
      return this.identifier;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "6"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-717137827"
   )
   int method352() {
      return this.field454;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1072606422"
   )
   public int method338() {
      return this.field451;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "10"
   )
   @Export("getMinX")
   public int getMinX() {
      return this.minX;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1543967105"
   )
   public int method360() {
      return this.field455;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1778136097"
   )
   @Export("getMinY")
   public int getMinY() {
      return this.minY;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "473990420"
   )
   public int method331() {
      return this.field457;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-28"
   )
   public int method334() {
      return this.field453.worldX;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1837071779"
   )
   public int method386() {
      return this.field453.plane;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1438575372"
   )
   public int method336() {
      return this.field453.worldY;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lix;",
      garbageValue = "530684756"
   )
   public Coordinates method337() {
      return new Coordinates(this.field453);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lei;IS)V",
      garbageValue = "128"
   )
   public static final void method398(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.indicesCount; ++var2) {
         if(var0.field1862[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.modelViewportYs[var3];
            int var7 = Model.modelViewportYs[var4];
            int var8 = Model.modelViewportYs[var5];
            method399(Model.modelViewportXs[var3], Model.modelViewportXs[var4], Model.modelViewportXs[var5], var6, var7, var8, var1);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-772938940"
   )
   static final void method399(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class149.method3104(var7, var9, var8, var10, -49088);
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-759067992"
   )
   static final void method400(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class189.loadWidget(var0)) {
         class319.method5651(MouseRecorder.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
