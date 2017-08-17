import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("y")
   static int[] field473;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -1953911409
   )
   static int field472;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 2049132639
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("f")
   String field458;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1767506971
   )
   int field469;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1948571337
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("o")
   boolean field468;
   @ObfuscatedName("h")
   String field459;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 940487487
   )
   int field462;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Coordinates field463;
   @ObfuscatedName("m")
   LinkedList field470;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -939637391
   )
   int field465;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -185172415
   )
   int field467;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1797228007
   )
   int field464;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 273715785
   )
   int field460;

   public WorldMapData() {
      this.fileId = -1;
      this.field469 = -1;
      this.field462 = -1;
      this.field463 = null;
      this.field464 = Integer.MAX_VALUE;
      this.field465 = 0;
      this.field460 = Integer.MAX_VALUE;
      this.field467 = 0;
      this.field468 = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "0"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field459 = var1.readString();
      this.field458 = var1.readString();
      this.field463 = new Coordinates(var1.readInt());
      this.field469 = var1.readInt();
      var1.readUnsignedByte();
      this.field468 = var1.readUnsignedByte() == 1;
      this.field462 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field470 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field470.add(this.method298(var1));
      }

      this.method303();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1720185193"
   )
   public String method306() {
      return this.field459;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-155291459"
   )
   public boolean method300(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field464 && var3 <= this.field465) {
         if(var4 >= this.field460 && var4 <= this.field467) {
            Iterator var5 = this.field470.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod762(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method311() {
      return this.fileId;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-960836204"
   )
   public int[] method368(int var1, int var2, int var3) {
      Iterator var4 = this.field470.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod741(var1, var2, var3));

      return var5.vmethod759(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "92"
   )
   public int method310() {
      return this.field464;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-112"
   )
   public int method327() {
      return this.field460;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "866559789"
   )
   public boolean method299(int var1, int var2, int var3) {
      Iterator var4 = this.field470.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod741(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhh;",
      garbageValue = "166808218"
   )
   public Coordinates method302(int var1, int var2) {
      Iterator var3 = this.field470.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod762(var1, var2));

      return var4.vmethod744(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1076538059"
   )
   public int method315() {
      return this.field463.plane;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1305794299"
   )
   public int method325() {
      return this.field463.worldX;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-859833136"
   )
   public int method316() {
      return this.field463.worldY;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "461095477"
   )
   public int method309() {
      return this.field462;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-887834545"
   )
   void method303() {
      Iterator var1 = this.field470.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod740(this);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;B)Lah;",
      garbageValue = "-69"
   )
   WorldMapSectionBase method298(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field402, class27.field403, class27.field404, class27.field408};
      class27 var4 = (class27)PlayerComposition.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field405) {
      case 0:
         var5 = new WorldMapType3();
         break;
      case 1:
         var5 = new WorldMapType1();
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

      ((WorldMapSectionBase)var5).vmethod742(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "46"
   )
   public boolean method305() {
      return this.field468;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-16"
   )
   public int method354() {
      return this.field465;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1153352324"
   )
   public int method356() {
      return this.field467;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1101170150"
   )
   int method308() {
      return this.field469;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1842448007"
   )
   public String method322() {
      return this.field458;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Lhh;",
      garbageValue = "-1334258435"
   )
   public Coordinates method317() {
      return new Coordinates(this.field463);
   }
}
