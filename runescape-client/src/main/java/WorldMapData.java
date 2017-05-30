import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("u")
   String field449;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1848451837
   )
   int field450;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1373562203
   )
   int field451;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -55817721
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -340226737
   )
   int field453;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1937968869
   )
   int field454;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1101096617
   )
   int field456;
   @ObfuscatedName("k")
   boolean field457;
   @ObfuscatedName("r")
   LinkedList field458;
   @ObfuscatedName("h")
   String field459;
   @ObfuscatedName("gc")
   static ModIcon[] field460;
   @ObfuscatedName("ff")
   static byte[][] field461;
   @ObfuscatedName("v")
   Coordinates field462;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1329272397
   )
   int field463;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2075034041"
   )
   public boolean method270(int var1, int var2, int var3) {
      Iterator var4 = this.field458.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod724(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-18156"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field459 = var1.readString();
      this.field449 = var1.readString();
      this.field462 = new Coordinates(var1.readInt());
      this.field450 = var1.readInt();
      var1.readUnsignedByte();
      this.field457 = var1.readUnsignedByte() == 1;
      this.field451 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field458 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field458.add(this.method272(var1));
      }

      this.method277();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)Lclass42;",
      garbageValue = "-5808"
   )
   WorldMapSectionBase method272(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)Client.method1381(class27.method213(), var2);
      Object var4 = null;
      switch(var3.field394) {
      case 0:
         var4 = new WorldMapType0();
         break;
      case 1:
         var4 = new WorldMapType1();
         break;
      case 2:
         var4 = new WorldMapType2();
         break;
      case 3:
         var4 = new WorldMapType3();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod719(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2010696610"
   )
   public int method273() {
      return this.field462.worldY;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-108217358"
   )
   public boolean method275(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field453 && var3 <= this.field454) {
         if(var4 >= this.field463 && var4 <= this.field456) {
            Iterator var5 = this.field458.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod716(var1, var2));

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
      signature = "(B)V",
      garbageValue = "4"
   )
   void method277() {
      Iterator var1 = this.field458.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod715(this);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIS)[I",
      garbageValue = "18233"
   )
   public int[] method280(int var1, int var2, int var3) {
      Iterator var4 = this.field458.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod724(var1, var2, var3));

      return var5.vmethod717(var1, var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "65"
   )
   int method282() {
      return this.field450;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-49"
   )
   public int method283() {
      return this.field451;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-55305954"
   )
   public int method285() {
      return this.field454;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1910855438"
   )
   public int method286() {
      return this.field463;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-740600093"
   )
   public int method287() {
      return this.field456;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1990760578"
   )
   public int method289() {
      return this.field462.plane;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lclass212;",
      garbageValue = "1039512103"
   )
   public Coordinates method291() {
      return new Coordinates(this.field462);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-755406857"
   )
   public int method293() {
      return this.field462.worldX;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1688311639"
   )
   public String method295() {
      return this.field459;
   }

   public WorldMapData() {
      this.fileId = -1;
      this.field450 = -1;
      this.field451 = -1;
      this.field462 = null;
      this.field453 = Integer.MAX_VALUE;
      this.field454 = 0;
      this.field463 = Integer.MAX_VALUE;
      this.field456 = 0;
      this.field457 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "842807361"
   )
   public int method318() {
      return this.fileId;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIIZB)V",
      garbageValue = "12"
   )
   public static void method322(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2498 = 1;
      Varbit.field3380 = var0;
      class169.field2325 = var1;
      class203.field2499 = var2;
      class203.field2500 = var3;
      class203.field2495 = var4;
      class203.field2501 = 10000;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-138996328"
   )
   public boolean method330() {
      return this.field457;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1890406699"
   )
   public int method337() {
      return this.field453;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Lclass212;",
      garbageValue = "-1764009313"
   )
   public Coordinates method341(int var1, int var2) {
      Iterator var3 = this.field458.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod716(var1, var2));

      return var4.vmethod718(var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "96"
   )
   static int method348(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1581()?(var1.method1581()?0:1):(var1.method1581()?-1:0)):(var2 == 5?(var0.method1551()?(var1.method1551()?0:1):(var1.method1551()?-1:0)):(var2 == 6?(var0.method1552()?(var1.method1552()?0:1):(var1.method1552()?-1:0)):(var2 == 7?(var0.method1549()?(var1.method1549()?0:1):(var1.method1549()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "95"
   )
   static final void method349(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = MessageNode.field845.method4811(var0, 250);
      int var6 = MessageNode.field845.method4841(var0, 250) * 13;
      Rasterizer2D.method5042(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      Rasterizer2D.method5012(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 16777215);
      MessageNode.field845.method4818(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class44.method645(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         class40.field541.vmethod5083(0, 0);
      } else {
         ChatLineBuffer.method1903(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "-8551"
   )
   public String method350() {
      return this.field449;
   }
}
