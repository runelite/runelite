import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapArea")
public class WorldMapArea {
   @ObfuscatedName("rc")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   @Export("friendSystem")
   public static FriendSystem friendSystem;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -256520591
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1232579503
   )
   @Export("id0")
   int id0;
   @ObfuscatedName("f")
   @Export("archiveName0")
   String archiveName0;
   @ObfuscatedName("q")
   @Export("name0")
   String name0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 986239133
   )
   @Export("__w")
   int __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 196514055
   )
   @Export("zoom0")
   int zoom0;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("origin0")
   TileLocation origin0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1238532539
   )
   @Export("minX0")
   int minX0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 225384859
   )
   @Export("maxX0")
   int maxX0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 963380367
   )
   @Export("minY0")
   int minY0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1025105175
   )
   @Export("maxY0")
   int maxY0;
   @ObfuscatedName("d")
   @Export("isMain0")
   boolean isMain0;
   @ObfuscatedName("k")
   @Export("sections")
   LinkedList sections;

   public WorldMapArea() {
      this.id0 = -1;
      this.__w = -1;
      this.zoom0 = -1;
      this.origin0 = null;
      this.minX0 = Integer.MAX_VALUE;
      this.maxX0 = 0;
      this.minY0 = Integer.MAX_VALUE;
      this.maxY0 = 0;
      this.isMain0 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "1854512327"
   )
   @Export("read")
   public void read(Buffer var1, int var2) {
      this.id0 = var2;
      this.archiveName0 = var1.readStringCp1252NullTerminated();
      this.name0 = var1.readStringCp1252NullTerminated();
      this.origin0 = new TileLocation(var1.readInt());
      this.__w = var1.readInt();
      var1.readUnsignedByte();
      this.isMain0 = var1.readUnsignedByte() == 1;
      this.zoom0 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.sections = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.sections.add(this.readWorldMapSection(var1));
      }

      this.setBounds();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;S)Lab;",
      garbageValue = "-13154"
   )
   @Export("readWorldMapSection")
   WorldMapSection readWorldMapSection(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.__h_f, WorldMapSectionType.__h_w, WorldMapSectionType.__h_m, WorldMapSectionType.__h_q};
      WorldMapSectionType var4 = (WorldMapSectionType)ScriptFrame.findEnumerated(var3, var2);
      Object var5 = null;
      switch(var4.type) {
      case 0:
         var5 = new WorldMapSection2();
         break;
      case 1:
         var5 = new WorldMapSection3();
         break;
      case 2:
         var5 = new WorldMapSection1();
         break;
      case 3:
         var5 = new WorldMapSection0();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSection)var5).read(var1);
      return (WorldMapSection)var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1843012457"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      Iterator var4 = this.sections.iterator();

      WorldMapSection var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSection)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-693447297"
   )
   @Export("containsPosition")
   public boolean containsPosition(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.minX0 && var3 <= this.maxX0) {
         if(var4 >= this.minY0 && var4 <= this.maxY0) {
            Iterator var5 = this.sections.iterator();

            WorldMapSection var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSection)var5.next();
            } while(!var6.containsPosition(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "745399916"
   )
   @Export("position")
   public int[] position(int var1, int var2, int var3) {
      Iterator var4 = this.sections.iterator();

      WorldMapSection var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSection)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5.position(var1, var2, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Lhu;",
      garbageValue = "1509069978"
   )
   @Export("coord")
   public TileLocation coord(int var1, int var2) {
      Iterator var3 = this.sections.iterator();

      WorldMapSection var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSection)var3.next();
      } while(!var4.containsPosition(var1, var2));

      return var4.coord(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-17"
   )
   @Export("setBounds")
   void setBounds() {
      Iterator var1 = this.sections.iterator();

      while(var1.hasNext()) {
         WorldMapSection var2 = (WorldMapSection)var1.next();
         var2.expandBounds(this);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-628294476"
   )
   @Export("id")
   public int id() {
      return this.id0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-39"
   )
   @Export("isMain")
   public boolean isMain() {
      return this.isMain0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-65"
   )
   @Export("archiveName")
   public String archiveName() {
      return this.archiveName0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-66"
   )
   @Export("name")
   public String name() {
      return this.name0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1657905623"
   )
   @Export("__a_39")
   int __a_39() {
      return this.__w;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-641284417"
   )
   @Export("zoom")
   public int zoom() {
      return this.zoom0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-18"
   )
   @Export("minX")
   public int minX() {
      return this.minX0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("maxX")
   public int maxX() {
      return this.maxX0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "272992390"
   )
   @Export("minY")
   public int minY() {
      return this.minY0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1621710159"
   )
   @Export("maxY")
   public int maxY() {
      return this.maxY0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   @Export("originX")
   public int originX() {
      return this.origin0.x;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1875921633"
   )
   @Export("originPlane")
   public int originPlane() {
      return this.origin0.plane;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-135283879"
   )
   @Export("originY")
   public int originY() {
      return this.origin0.y;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lhu;",
      garbageValue = "-1411761003"
   )
   @Export("origin")
   public TileLocation origin() {
      return new TileLocation(this.origin0);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1490951132"
   )
   static int method427(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   static void method428() {
      if(Client.oculusOrbState == 1) {
         Client.__client_ij = true;
      }

   }
}
