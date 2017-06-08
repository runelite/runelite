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
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1643232657
   )
   int field457;
   @ObfuscatedName("p")
   String field458;
   @ObfuscatedName("i")
   String field459;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2095620809
   )
   int field460;
   @ObfuscatedName("o")
   LinkedList field461;
   @ObfuscatedName("m")
   Coordinates field462;
   @ObfuscatedName("e")
   boolean field463;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1237266687
   )
   int field464;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 53073087
   )
   int field465;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1865210101
   )
   int field466;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 982514711
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -609761423
   )
   int field468;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2001099461"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field458 = var1.readString();
      this.field459 = var1.readString();
      this.field462 = new Coordinates(var1.readInt());
      this.field464 = var1.readInt();
      var1.readUnsignedByte();
      this.field463 = var1.readUnsignedByte() == 1;
      this.field457 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field461 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field461.add(this.method290(var1));
      }

      this.method295();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)LWorldMapSectionBase;",
      garbageValue = "-1573478613"
   )
   WorldMapSectionBase method290(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field402, class27.field401, class27.field403, class27.field405};
      class27 var4 = (class27)Projectile.method1737(var3, var2);
      Object var5 = null;
      switch(var4.field400) {
      case 0:
         var5 = new WorldMapType0();
         break;
      case 1:
         var5 = new WorldMapType1();
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

      ((WorldMapSectionBase)var5).vmethod697(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2147187267"
   )
   public boolean method291(int var1, int var2, int var3) {
      Iterator var4 = this.field461.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod693(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-2"
   )
   public boolean method292(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field460 && var3 <= this.field468) {
         if(var4 >= this.field465 && var4 <= this.field466) {
            Iterator var5 = this.field461.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod713(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)LCoordinates;",
      garbageValue = "1"
   )
   public Coordinates method294(int var1, int var2) {
      Iterator var3 = this.field461.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod713(var1, var2));

      return var4.vmethod696(var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "138608349"
   )
   void method295() {
      Iterator var1 = this.field461.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod692(this);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-16572091"
   )
   public int method296() {
      return this.fileId;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "25837"
   )
   public String method297() {
      return this.field458;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-98"
   )
   public String method299() {
      return this.field459;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1501515867"
   )
   int method300() {
      return this.field464;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "228"
   )
   public int method301() {
      return this.field457;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1274057980"
   )
   public int method302() {
      return this.field460;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-26850"
   )
   public int method305() {
      return this.field466;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1346512917"
   )
   public int method307() {
      return this.field462.plane;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "748018332"
   )
   public int method308() {
      return this.field462.worldY;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-18640713"
   )
   public int method321() {
      return this.field462.worldX;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "248"
   )
   public int method322() {
      return this.field468;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2005119075"
   )
   public int method330() {
      return this.field465;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1371284265"
   )
   public int[] method336(int var1, int var2, int var3) {
      Iterator var4 = this.field461.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod693(var1, var2, var3));

      return var5.vmethod695(var1, var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "2064293727"
   )
   public Coordinates method343() {
      return new Coordinates(this.field462);
   }

   public WorldMapData() {
      this.fileId = -1;
      this.field464 = -1;
      this.field457 = -1;
      this.field462 = null;
      this.field460 = Integer.MAX_VALUE;
      this.field468 = 0;
      this.field465 = Integer.MAX_VALUE;
      this.field466 = 0;
      this.field463 = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "939502127"
   )
   public boolean method356() {
      return this.field463;
   }
}
