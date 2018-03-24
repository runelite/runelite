import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "Lbi;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -967352255
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("q")
   @Export("identifier")
   String identifier;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1250150267
   )
   int field424;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -280205659
   )
   int field434;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   Coordinates field426;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1914931745
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 462302867
   )
   int field428;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1072902145
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -958613707
   )
   int field430;
   @ObfuscatedName("n")
   boolean field431;
   @ObfuscatedName("o")
   LinkedList field432;

   public WorldMapData() {
      this.fileId = -1;
      this.field424 = -1;
      this.field434 = -1;
      this.field426 = null;
      this.minX = Integer.MAX_VALUE;
      this.field428 = 0;
      this.minY = Integer.MAX_VALUE;
      this.field430 = 0;
      this.field431 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-903855891"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.identifier = var1.readString();
      this.name = var1.readString();
      this.field426 = new Coordinates(var1.readInt());
      this.field424 = var1.readInt();
      var1.readUnsignedByte();
      this.field431 = var1.readUnsignedByte() == 1;
      this.field434 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field432 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field432.add(this.method292(var1));
      }

      this.method297();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;B)Las;",
      garbageValue = "-122"
   )
   WorldMapSectionBase method292(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field368, class27.field375, class27.field370, class27.field366};
      class27 var4 = (class27)WorldMapRectangle.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field369) {
      case 0:
         var5 = new WorldMapType2();
         break;
      case 1:
         var5 = new WorldMapType1();
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

      ((WorldMapSectionBase)var5).vmethod761(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "6"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      Iterator var4 = this.field432.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean method294(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.minX && var3 <= this.field428) {
         if(var4 >= this.minY && var4 <= this.field430) {
            Iterator var5 = this.field432.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod764(var1, var2));

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
      signature = "(IIIB)[I",
      garbageValue = "-28"
   )
   public int[] method299(int var1, int var2, int var3) {
      Iterator var4 = this.field432.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5.vmethod765(var1, var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Lik;",
      garbageValue = "-228946585"
   )
   public Coordinates method296(int var1, int var2) {
      Iterator var3 = this.field432.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod764(var1, var2));

      return var4.vmethod770(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2120823412"
   )
   void method297() {
      Iterator var1 = this.field432.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod762(this);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "115248331"
   )
   @Export("getFileId")
   public int getFileId() {
      return this.fileId;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1405012819"
   )
   public boolean method351() {
      return this.field431;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1716879073"
   )
   @Export("getIdentifier")
   public String getIdentifier() {
      return this.identifier;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "550820419"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1920452094"
   )
   int method302() {
      return this.field424;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1878784579"
   )
   public int method367() {
      return this.field434;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-117"
   )
   @Export("getMinX")
   public int getMinX() {
      return this.minX;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-26635"
   )
   public int method304() {
      return this.field428;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "705595976"
   )
   @Export("getMinY")
   public int getMinY() {
      return this.minY;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method306() {
      return this.field430;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1059467755"
   )
   public int method307() {
      return this.field426.worldX;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-823381979"
   )
   public int method308() {
      return this.field426.plane;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "26"
   )
   public int method309() {
      return this.field426.worldY;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Lik;",
      garbageValue = "112"
   )
   public Coordinates method360() {
      return new Coordinates(this.field426);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-743648441"
   )
   static final void method317(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class62.field704[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljava/lang/String;Ljava/lang/String;I)[Llk;",
      garbageValue = "-1882453115"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      byte[] var7 = var0.getConfigData(var3, var4);
      boolean var6;
      if(var7 == null) {
         var6 = false;
      } else {
         Widget.decodeSprite(var7);
         var6 = true;
      }

      IndexedSprite[] var5;
      if(!var6) {
         var5 = null;
      } else {
         var5 = class304.method5411();
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-29"
   )
   public static void method365() {
      Area.areaSpriteCache.reset();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-184526842"
   )
   static void method312(int var0) {
      if(var0 != -1) {
         if(Script.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2898 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.objs = var3.field2898;
                  class25.runScript(var4, 5000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "114"
   )
   static void method363(int var0) {
      if(var0 == -1 && !Client.field956) {
         ScriptState.method1124();
      } else if(var0 != -1 && var0 != Client.field1080 && Client.field1079 != 0 && !Client.field956) {
         NPC.method1903(2, Varbit.indexTrack1, var0, 0, Client.field1079, false);
      }

      Client.field1080 = var0;
   }
}
