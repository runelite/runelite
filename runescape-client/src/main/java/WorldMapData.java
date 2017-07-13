import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("n")
   String field443;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -115800963
   )
   int field452;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2058404923
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("m")
   boolean field451;
   @ObfuscatedName("j")
   String field442;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -307514461
   )
   int field445;
   @ObfuscatedName("e")
   Coordinates field444;
   @ObfuscatedName("u")
   LinkedList field449;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2100097771
   )
   int field448;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1378661023
   )
   int field450;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 54203537
   )
   int field447;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -346281609
   )
   int field441;

   public WorldMapData() {
      this.fileId = -1;
      this.field452 = -1;
      this.field445 = -1;
      this.field444 = null;
      this.field447 = Integer.MAX_VALUE;
      this.field448 = 0;
      this.field441 = Integer.MAX_VALUE;
      this.field450 = 0;
      this.field451 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1815537963"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field442 = var1.readString();
      this.field443 = var1.readString();
      this.field444 = new Coordinates(var1.readInt());
      this.field452 = var1.readInt();
      var1.readUnsignedByte();
      this.field451 = var1.readUnsignedByte() == 1;
      this.field445 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field449 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field449.add(this.method315(var1));
      }

      this.method284();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "32236484"
   )
   public String method287() {
      return this.field442;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-463253426"
   )
   public boolean method281(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field447 && var3 <= this.field448) {
         if(var4 >= this.field441 && var4 <= this.field450) {
            Iterator var5 = this.field449.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod722(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-65"
   )
   public int method296() {
      return this.fileId;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1940961754"
   )
   public int[] method331(int var1, int var2, int var3) {
      Iterator var4 = this.field449.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod721(var1, var2, var3));

      return var5.vmethod731(var1, var2, var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-76"
   )
   public int method291() {
      return this.field447;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1771158369"
   )
   public int method292() {
      return this.field441;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1671798251"
   )
   public boolean method280(int var1, int var2, int var3) {
      Iterator var4 = this.field449.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod721(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)LCoordinates;",
      garbageValue = "87"
   )
   public Coordinates method283(int var1, int var2) {
      Iterator var3 = this.field449.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod722(var1, var2));

      return var4.vmethod743(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-922975523"
   )
   public int method342() {
      return this.field444.plane;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1211433564"
   )
   public int method295() {
      return this.field444.worldX;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-774883735"
   )
   public int method297() {
      return this.field444.worldY;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "109"
   )
   public int method282() {
      return this.field445;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "363635444"
   )
   void method284() {
      Iterator var1 = this.field449.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod720(this);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)LWorldMapSectionBase;",
      garbageValue = "-33"
   )
   WorldMapSectionBase method315(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)PendingSpawn.forOrdinal(class27.method208(), var2);
      Object var4 = null;
      switch(var3.field392) {
      case 0:
         var4 = new WorldMapType1();
         break;
      case 1:
         var4 = new WorldMapType3();
         break;
      case 2:
         var4 = new class48();
         break;
      case 3:
         var4 = new WorldMapType2();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod746(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "935604549"
   )
   public boolean method286() {
      return this.field451;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2099359509"
   )
   public int method277() {
      return this.field448;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1750873756"
   )
   public int method279() {
      return this.field450;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-90"
   )
   int method335() {
      return this.field452;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1096009017"
   )
   public String method301() {
      return this.field443;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)LCoordinates;",
      garbageValue = "-87"
   )
   public Coordinates method298() {
      return new Coordinates(this.field444);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1629023943"
   )
   static int method347(int var0, int var1) {
      Overlay var2 = class243.method4269(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var3;
         if(var2.texture >= 0) {
            var3 = class287.method5105(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var3 = XGrandExchangeOffer.method99(var2.hue, var2.saturation, var2.lightness);
            int var4 = class287.method5105(var3, 96);
            return Graphics3D.colorPalette[var4] | -16777216;
         }
      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static void method346(int var0) {
      for(WidgetConfig var1 = (WidgetConfig)Client.widgetFlags.method3538(); var1 != null; var1 = (WidgetConfig)Client.widgetFlags.method3539()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass289;I)I",
      garbageValue = "-1893753654"
   )
   static final int method345(class289 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3850) {
         case 6:
            return 20;
         default:
            return 12;
         }
      }
   }
}
