import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("l")
   static int[] field433;
   @ObfuscatedName("x")
   String field425;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1863746045
   )
   int field438;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1195809317
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("g")
   boolean field428;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1335452119
   )
   int field423;
   @ObfuscatedName("q")
   String field424;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   Coordinates field436;
   @ObfuscatedName("s")
   LinkedList field434;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -917490943
   )
   int field430;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -635447299
   )
   int field432;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1416017249
   )
   int field429;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1377571259
   )
   int field431;

   public WorldMapData() {
      this.fileId = -1;
      this.field438 = -1;
      this.field423 = -1;
      this.field436 = null;
      this.field429 = Integer.MAX_VALUE;
      this.field430 = 0;
      this.field431 = Integer.MAX_VALUE;
      this.field432 = 0;
      this.field428 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "2079741899"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field424 = var1.readString();
      this.field425 = var1.readString();
      this.field436 = new Coordinates(var1.readInt());
      this.field438 = var1.readInt();
      var1.readUnsignedByte();
      this.field428 = var1.readUnsignedByte() == 1;
      this.field423 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field434 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field434.add(this.method277(var1));
      }

      this.method282();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "836718126"
   )
   public String method285() {
      return this.field424;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1437386055"
   )
   public boolean method279(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field429 && var3 <= this.field430) {
         if(var4 >= this.field431 && var4 <= this.field432) {
            Iterator var5 = this.field434.iterator();

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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "623450966"
   )
   public int method275() {
      return this.fileId;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1818999163"
   )
   public int[] method280(int var1, int var2, int var3) {
      Iterator var4 = this.field434.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod714(var1, var2, var3));

      return var5.vmethod716(var1, var2, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1723828595"
   )
   public int method289() {
      return this.field429;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-906334904"
   )
   public int method319() {
      return this.field431;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "113"
   )
   public boolean method278(int var1, int var2, int var3) {
      Iterator var4 = this.field434.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod714(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Lhy;",
      garbageValue = "42079439"
   )
   public Coordinates method281(int var1, int var2) {
      Iterator var3 = this.field434.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod715(var1, var2));

      return var4.vmethod717(var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "2263"
   )
   public int method296() {
      return this.field436.plane;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1786983851"
   )
   public int method292() {
      return this.field436.worldX;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-602229345"
   )
   public int method294() {
      return this.field436.worldY;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-23"
   )
   public int method288() {
      return this.field423;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1385854237"
   )
   void method282() {
      Iterator var1 = this.field434.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod713(this);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;B)Lan;",
      garbageValue = "-102"
   )
   WorldMapSectionBase method277(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field367, class27.field377, class27.field369, class27.field368};
      class27 var4 = (class27)CollisionData.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field371) {
      case 0:
         var5 = new class48();
         break;
      case 1:
         var5 = new WorldMapType1();
         break;
      case 2:
         var5 = new WorldMapType2();
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "1839"
   )
   public boolean method353() {
      return this.field428;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2045499312"
   )
   public int method290() {
      return this.field430;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   public int method276() {
      return this.field432;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1760069950"
   )
   int method287() {
      return this.field438;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "338963106"
   )
   public String method286() {
      return this.field425;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lhy;",
      garbageValue = "1730840571"
   )
   public Coordinates method318() {
      return new Coordinates(this.field436);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "24"
   )
   static boolean method354(File var0, boolean var1) {
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

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1103709930"
   )
   static void method337(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class118.field1676; ++var4) {
         ItemComposition var5 = Friend.getItemDefinition(var4);
         if((!var1 || var5.field3516) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               GameEngine.field695 = -1;
               class28.field392 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class28.field392 = var2;
      KitDefinition.field3341 = 0;
      GameEngine.field695 = var3;
      String[] var8 = new String[GameEngine.field695];

      for(int var9 = 0; var9 < GameEngine.field695; ++var9) {
         var8[var9] = Friend.getItemDefinition(var2[var9]).name;
      }

      ChatLineBuffer.method1881(var8, class28.field392);
   }
}
