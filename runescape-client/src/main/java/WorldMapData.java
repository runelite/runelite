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
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 167061605
   )
   int field458;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 263312107
   )
   int field459;
   @ObfuscatedName("e")
   String field460;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -295967603
   )
   int field461;
   @ObfuscatedName("m")
   String field462;
   @ObfuscatedName("z")
   Coordinates field463;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1375103959
   )
   int field465;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1180731869
   )
   int field466;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 183071763
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("o")
   boolean field468;
   @ObfuscatedName("q")
   LinkedList field469;
   @ObfuscatedName("bf")
   static ModIcon[] field471;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -229683839
   )
   int field472;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2118743910"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field462 = var1.readString();
      this.field460 = var1.readString();
      this.field463 = new Coordinates(var1.readInt());
      this.field461 = var1.readInt();
      var1.readUnsignedByte();
      this.field468 = var1.readUnsignedByte() == 1;
      this.field472 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field469 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field469.add(this.method347(var1));
      }

      this.method290();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-53"
   )
   public boolean method282(int var1, int var2, int var3) {
      Iterator var4 = this.field469.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod678(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1879147988"
   )
   public boolean method283(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field459 && var3 <= this.field465) {
         if(var4 >= this.field466 && var4 <= this.field458) {
            Iterator var5 = this.field469.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod679(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-964514330"
   )
   public int method286() {
      return this.field463.worldY;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1893827856"
   )
   public int method287() {
      return this.fileId;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-481690389"
   )
   public boolean method288() {
      return this.field468;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   void method290() {
      Iterator var1 = this.field469.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod680(this);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1126894023"
   )
   int method291() {
      return this.field461;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1282189780"
   )
   public int method293() {
      return this.field459;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-77139011"
   )
   public int method294() {
      return this.field465;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2092883206"
   )
   public int method296() {
      return this.field458;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1905732288"
   )
   public int method297() {
      return this.field463.worldX;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-63"
   )
   public int method298() {
      return this.field463.plane;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LCoordinates;",
      garbageValue = "55"
   )
   public Coordinates method300() {
      return new Coordinates(this.field463);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-40"
   )
   public int method305() {
      return this.field466;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-937858930"
   )
   public int method314() {
      return this.field472;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "5"
   )
   public String method315() {
      return this.field462;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)LCoordinates;",
      garbageValue = "7"
   )
   public Coordinates method317(int var1, int var2) {
      Iterator var3 = this.field469.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod679(var1, var2));

      return var4.vmethod685(var1, var2);
   }

   public WorldMapData() {
      this.fileId = -1;
      this.field461 = -1;
      this.field472 = -1;
      this.field463 = null;
      this.field459 = Integer.MAX_VALUE;
      this.field465 = 0;
      this.field466 = Integer.MAX_VALUE;
      this.field458 = 0;
      this.field468 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-804162076"
   )
   public String method338() {
      return this.field460;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "746098824"
   )
   public int[] method346(int var1, int var2, int var3) {
      Iterator var4 = this.field469.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod678(var1, var2, var3));

      return var5.vmethod682(var1, var2, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)LWorldMapSectionBase;",
      garbageValue = "-416202627"
   )
   WorldMapSectionBase method347(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field411, class27.field409, class27.field410, class27.field408};
      class27 var4 = (class27)RSCanvas.method735(var3, var2);
      Object var5 = null;
      switch(var4.field417) {
      case 0:
         var5 = new WorldMapType2();
         break;
      case 1:
         var5 = new WorldMapType1();
         break;
      case 2:
         var5 = new WorldMapType3();
         break;
      case 3:
         var5 = new class48();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod684(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "127"
   )
   static int method350(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class223.method3959(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class43.field582:class31.field457;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class83.intStack[--class83.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3909(var4, class83.scriptStringStack[--class24.scriptStringStackSize]);
            return 1;
         } else {
            --class24.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class83.intStackSize -= 2;
         var4 = class83.intStack[class83.intStackSize];
         int var5 = class83.intStack[class83.intStackSize + 1];
         var3.dragParent = class172.method3015(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2652 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2730 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2717 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class83.scriptStringStack[--class24.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class83.scriptStringStack[--class24.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "124"
   )
   static final boolean method351(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
