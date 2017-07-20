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
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 551067691
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   static class156 field438;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -2072721847
   )
   static int field448;
   @ObfuscatedName("i")
   String field437;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -805356243
   )
   int field441;
   @ObfuscatedName("r")
   boolean field445;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1869108129
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("o")
   String field436;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2133577833
   )
   int field439;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   Coordinates field440;
   @ObfuscatedName("w")
   LinkedList field446;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1274790153
   )
   int field444;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1984616375
   )
   int field435;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 568180031
   )
   int field443;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1548857273
   )
   int field442;

   public WorldMapData() {
      this.fileId = -1;
      this.field441 = -1;
      this.field439 = -1;
      this.field440 = null;
      this.field443 = Integer.MAX_VALUE;
      this.field444 = 0;
      this.field442 = Integer.MAX_VALUE;
      this.field435 = 0;
      this.field445 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "2108056689"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field436 = var1.readString();
      this.field437 = var1.readString();
      this.field440 = new Coordinates(var1.readInt());
      this.field441 = var1.readInt();
      var1.readUnsignedByte();
      this.field445 = var1.readUnsignedByte() == 1;
      this.field439 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field446 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field446.add(this.method274(var1));
      }

      this.method279();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "536532657"
   )
   public String method335() {
      return this.field436;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-57"
   )
   public boolean method276(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field443 && var3 <= this.field444) {
         if(var4 >= this.field442 && var4 <= this.field435) {
            Iterator var5 = this.field446.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod676(var1, var2));

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
      garbageValue = "1661138795"
   )
   public int[] method277(int var1, int var2, int var3) {
      Iterator var4 = this.field446.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod675(var1, var2, var3));

      return var5.vmethod677(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "151877370"
   )
   public int method284() {
      return this.fileId;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "422134433"
   )
   public int method286() {
      return this.field443;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-542790309"
   )
   public int method289() {
      return this.field442;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-17"
   )
   public boolean method304(int var1, int var2, int var3) {
      Iterator var4 = this.field446.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod675(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "1388696681"
   )
   public Coordinates method278(int var1, int var2) {
      Iterator var3 = this.field446.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod676(var1, var2));

      return var4.vmethod696(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1423749889"
   )
   public int method291() {
      return this.field440.plane;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1612305683"
   )
   public int method290() {
      return this.field440.worldX;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method273() {
      return this.field440.worldY;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-32763753"
   )
   public int method285() {
      return this.field439;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "12957"
   )
   void method279() {
      Iterator var1 = this.field446.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod693(this);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)Lah;",
      garbageValue = "1854853000"
   )
   WorldMapSectionBase method274(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)class36.forOrdinal(class27.method211(), var2);
      Object var4 = null;
      switch(var3.field385) {
      case 0:
         var4 = new class48();
         break;
      case 1:
         var4 = new WorldMapType3();
         break;
      case 2:
         var4 = new WorldMapType1();
         break;
      case 3:
         var4 = new WorldMapType2();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod678(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "6"
   )
   public boolean method281() {
      return this.field445;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "99506331"
   )
   public int method272() {
      return this.field444;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "128"
   )
   public int method305() {
      return this.field435;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1504093157"
   )
   int method337() {
      return this.field441;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-120"
   )
   public String method283() {
      return this.field437;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)Lhs;",
      garbageValue = "-13811"
   )
   public Coordinates method293() {
      return new Coordinates(this.field440);
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "8"
   )
   static String method347(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class31.sessionToken != null) {
         var3 = "/p=" + class31.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class20.field323 + var3 + "/";
   }
}
