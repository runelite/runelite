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
   @ObfuscatedName("fd")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1519607413
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("z")
   String field465;
   @ObfuscatedName("n")
   String field455;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -969876331
   )
   int field456;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 342452355
   )
   int field454;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   Coordinates field457;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1212752855
   )
   int field459;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -177502831
   )
   int field460;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -275213023
   )
   int field453;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1056889133
   )
   int field462;
   @ObfuscatedName("m")
   boolean field458;
   @ObfuscatedName("h")
   LinkedList field464;

   public WorldMapData() {
      this.fileId = -1;
      this.field456 = -1;
      this.field454 = -1;
      this.field457 = null;
      this.field459 = Integer.MAX_VALUE;
      this.field460 = 0;
      this.field453 = Integer.MAX_VALUE;
      this.field462 = 0;
      this.field458 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1115158133"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field465 = var1.readString();
      this.field455 = var1.readString();
      this.field457 = new Coordinates(var1.readInt());
      this.field456 = var1.readInt();
      var1.readUnsignedByte();
      this.field458 = var1.readUnsignedByte() == 1;
      this.field454 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field464 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field464.add(this.method289(var1));
      }

      this.method351();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;I)Lan;",
      garbageValue = "-1755162530"
   )
   WorldMapSectionBase method289(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field399, class27.field401, class27.field404, class27.field400};
      class27 var4 = (class27)MapIcon.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field406) {
      case 0:
         var5 = new WorldMapType1();
         break;
      case 1:
         var5 = new WorldMapType2();
         break;
      case 2:
         var5 = new class49();
         break;
      case 3:
         var5 = new WorldMapType3();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod718(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-79"
   )
   public boolean method290(int var1, int var2, int var3) {
      Iterator var4 = this.field464.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod712(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2036858472"
   )
   public boolean method338(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field459 && var3 <= this.field460) {
         if(var4 >= this.field453 && var4 <= this.field462) {
            Iterator var5 = this.field464.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod715(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1577829595"
   )
   public int[] method291(int var1, int var2, int var3) {
      Iterator var4 = this.field464.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod712(var1, var2, var3));

      return var5.vmethod714(var1, var2, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)Lic;",
      garbageValue = "1"
   )
   public Coordinates method292(int var1, int var2) {
      Iterator var3 = this.field464.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod715(var1, var2));

      return var4.vmethod717(var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-220684309"
   )
   void method351() {
      Iterator var1 = this.field464.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod716(this);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1384503579"
   )
   public int method294() {
      return this.fileId;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2010238592"
   )
   public boolean method313() {
      return this.field458;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "19"
   )
   public String method296() {
      return this.field465;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2123083177"
   )
   public String method288() {
      return this.field455;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-120"
   )
   int method298() {
      return this.field456;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "102"
   )
   public int method329() {
      return this.field454;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1824462720"
   )
   public int method312() {
      return this.field459;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "287147450"
   )
   public int method300() {
      return this.field460;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-862051653"
   )
   public int method302() {
      return this.field453;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1583024041"
   )
   public int method348() {
      return this.field462;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1925496863"
   )
   public int method304() {
      return this.field457.worldX;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "14"
   )
   public int method305() {
      return this.field457.plane;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1391571075"
   )
   public int method306() {
      return this.field457.worldY;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Lic;",
      garbageValue = "1"
   )
   public Coordinates method307() {
      return new Coordinates(this.field457);
   }
}
