import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1868688265
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("w")
   String field423;
   @ObfuscatedName("e")
   String field419;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1215404565
   )
   int field420;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1591748037
   )
   int field421;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   Coordinates field422;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2044442089
   )
   int field424;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1250331877
   )
   int field417;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1227056553
   )
   int field425;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1100327653
   )
   int field431;
   @ObfuscatedName("x")
   boolean field426;
   @ObfuscatedName("c")
   LinkedList field428;

   public WorldMapData() {
      this.fileId = -1;
      this.field420 = -1;
      this.field421 = -1;
      this.field422 = null;
      this.field424 = Integer.MAX_VALUE;
      this.field417 = 0;
      this.field425 = Integer.MAX_VALUE;
      this.field431 = 0;
      this.field426 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-741016784"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field423 = var1.readString();
      this.field419 = var1.readString();
      this.field422 = new Coordinates(var1.readInt());
      this.field420 = var1.readInt();
      var1.readUnsignedByte();
      this.field426 = var1.readUnsignedByte() == 1;
      this.field421 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field428 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field428.add(this.method276(var1));
      }

      this.method277();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;I)Lah;",
      garbageValue = "-357451150"
   )
   WorldMapSectionBase method276(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field367, class27.field366, class27.field369, class27.field368};
      class27 var4 = (class27)class91.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field370) {
      case 0:
         var5 = new WorldMapType3();
         break;
      case 1:
         var5 = new class48();
         break;
      case 2:
         var5 = new WorldMapType2();
         break;
      case 3:
         var5 = new WorldMapType1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod701(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "948932290"
   )
   public boolean method273(int var1, int var2, int var3) {
      Iterator var4 = this.field428.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod708(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "103"
   )
   public boolean method274(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field424 && var3 <= this.field417) {
         if(var4 >= this.field425 && var4 <= this.field431) {
            Iterator var5 = this.field428.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod698(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-127376075"
   )
   public int[] method275(int var1, int var2, int var3) {
      Iterator var4 = this.field428.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod708(var1, var2, var3));

      return var5.vmethod700(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Lhc;",
      garbageValue = "1196340198"
   )
   public Coordinates method289(int var1, int var2) {
      Iterator var3 = this.field428.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod698(var1, var2));

      return var4.vmethod714(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "43"
   )
   void method277() {
      Iterator var1 = this.field428.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod695(this);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "9"
   )
   public int method282() {
      return this.fileId;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "108"
   )
   public boolean method337() {
      return this.field426;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1149523154"
   )
   public String method330() {
      return this.field423;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-62782999"
   )
   public String method279() {
      return this.field419;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "1743"
   )
   int method270() {
      return this.field420;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1811890014"
   )
   public int method283() {
      return this.field421;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1534787498"
   )
   public int method340() {
      return this.field424;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1286665395"
   )
   public int method285() {
      return this.field417;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "288525984"
   )
   public int method286() {
      return this.field425;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1321200933"
   )
   public int method287() {
      return this.field431;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1866482305"
   )
   public int method288() {
      return this.field422.worldX;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "40"
   )
   public int method335() {
      return this.field422.plane;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-23"
   )
   public int method294() {
      return this.field422.worldY;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lhc;",
      garbageValue = "-1093469061"
   )
   public Coordinates method291() {
      return new Coordinates(this.field422);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;III)Lfx;",
      garbageValue = "1051888368"
   )
   public static class159 method342(Socket var0, int var1, int var2) throws IOException {
      return new class161(var0, var1, var2);
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "31"
   )
   static final void method305(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1033[var4] = true;
         }
      }

   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Lhz;III)V",
      garbageValue = "-948833101"
   )
   static final void method341(Widget var0, int var1, int var2) {
      if(Client.field1064 == null && !Client.isMenuOpen) {
         if(var0 != null && CacheFile.method2351(var0) != null) {
            Client.field1064 = var0;
            Client.field1002 = CacheFile.method2351(var0);
            Client.field889 = var1;
            Client.field943 = var2;
            FriendLoginUpdate.field751 = 0;
            Client.field1012 = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               PendingSpawn.topContextMenuRow = new ContextMenuRow();
               PendingSpawn.topContextMenuRow.param0 = Client.menuActionParams0[var3];
               PendingSpawn.topContextMenuRow.param1 = Client.menuActionParams1[var3];
               PendingSpawn.topContextMenuRow.type = Client.menuTypes[var3];
               PendingSpawn.topContextMenuRow.identifier = Client.menuIdentifiers[var3];
               PendingSpawn.topContextMenuRow.option = Client.menuOptions[var3];
            }

         }
      }
   }
}
