import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2116236945
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("x")
   String field432;
   @ObfuscatedName("k")
   String field429;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1311307035
   )
   int field430;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1718033085
   )
   int field434;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   Coordinates field433;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1921260503
   )
   int field427;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 252987621
   )
   int field431;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -186892927
   )
   int field428;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1909580449
   )
   int field436;
   @ObfuscatedName("l")
   boolean field437;
   @ObfuscatedName("u")
   LinkedList field438;

   public WorldMapData() {
      this.fileId = -1;
      this.field430 = -1;
      this.field434 = -1;
      this.field433 = null;
      this.field427 = Integer.MAX_VALUE;
      this.field431 = 0;
      this.field428 = Integer.MAX_VALUE;
      this.field436 = 0;
      this.field437 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "-841735610"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field432 = var1.readString();
      this.field429 = var1.readString();
      this.field433 = new Coordinates(var1.readInt());
      this.field430 = var1.readInt();
      var1.readUnsignedByte();
      this.field437 = var1.readUnsignedByte() == 1;
      this.field434 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field438 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field438.add(this.method275(var1));
      }

      this.method280();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;I)Lai;",
      garbageValue = "-670367514"
   )
   WorldMapSectionBase method275(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field367, class27.field377, class27.field369, class27.field368};
      class27 var4 = (class27)class94.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field371) {
      case 0:
         var5 = new WorldMapType1();
         break;
      case 1:
         var5 = new class48();
         break;
      case 2:
         var5 = new WorldMapType3();
         break;
      case 3:
         var5 = new WorldMapType2();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod719(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "14"
   )
   public boolean method276(int var1, int var2, int var3) {
      Iterator var4 = this.field438.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod728(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1467055089"
   )
   public boolean method277(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field427 && var3 <= this.field431) {
         if(var4 >= this.field428 && var4 <= this.field436) {
            Iterator var5 = this.field438.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod716(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-315675987"
   )
   public int[] method278(int var1, int var2, int var3) {
      Iterator var4 = this.field438.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod728(var1, var2, var3));

      return var5.vmethod717(var1, var2, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIS)Lhp;",
      garbageValue = "2614"
   )
   public Coordinates method291(int var1, int var2) {
      Iterator var3 = this.field438.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod716(var1, var2));

      return var4.vmethod741(var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "782121311"
   )
   void method280() {
      Iterator var1 = this.field438.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod724(this);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-3975"
   )
   public int method281() {
      return this.fileId;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1493994652"
   )
   public boolean method303() {
      return this.field437;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1464007770"
   )
   public String method283() {
      return this.field432;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-99"
   )
   public String method284() {
      return this.field429;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1954741386"
   )
   int method285() {
      return this.field430;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2116330263"
   )
   public int method286() {
      return this.field434;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "19"
   )
   public int method287() {
      return this.field427;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   public int method288() {
      return this.field431;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "90"
   )
   public int method289() {
      return this.field428;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-495685061"
   )
   public int method290() {
      return this.field436;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1917887409"
   )
   public int method328() {
      return this.field433.worldX;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "63735069"
   )
   public int method292() {
      return this.field433.plane;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-4353"
   )
   public int method293() {
      return this.field433.worldY;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lhp;",
      garbageValue = "1318159393"
   )
   public Coordinates method356() {
      return new Coordinates(this.field433);
   }
}
