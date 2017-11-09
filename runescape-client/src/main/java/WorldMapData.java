import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1334836249
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("p")
   String field431;
   @ObfuscatedName("i")
   String field443;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -63328189
   )
   int field433;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2045022041
   )
   int field436;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   Coordinates field435;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1148635895
   )
   int field430;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -925579713
   )
   int field432;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1646297271
   )
   int field438;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1913492593
   )
   int field439;
   @ObfuscatedName("c")
   boolean field434;
   @ObfuscatedName("a")
   LinkedList field440;

   public WorldMapData() {
      this.fileId = -1;
      this.field433 = -1;
      this.field436 = -1;
      this.field435 = null;
      this.field430 = Integer.MAX_VALUE;
      this.field432 = 0;
      this.field438 = Integer.MAX_VALUE;
      this.field439 = 0;
      this.field434 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "-2009784845"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field431 = var1.readString();
      this.field443 = var1.readString();
      this.field435 = new Coordinates(var1.readInt());
      this.field433 = var1.readInt();
      var1.readUnsignedByte();
      this.field434 = var1.readUnsignedByte() == 1;
      this.field436 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field440 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field440.add(this.method340(var1));
      }

      this.method338();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfv;I)Lau;",
      garbageValue = "-516127159"
   )
   WorldMapSectionBase method340(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field390, class27.field379, class27.field378, class27.field377};
      class27 var4 = (class27)class47.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field388) {
      case 0:
         var5 = new class48();
         break;
      case 1:
         var5 = new WorldMapType2();
         break;
      case 2:
         var5 = new WorldMapType3();
         break;
      case 3:
         var5 = new WorldMapType1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod777(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-495715849"
   )
   public boolean method344(int var1, int var2, int var3) {
      Iterator var4 = this.field440.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod778(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1562854541"
   )
   public boolean method313(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field430 && var3 <= this.field432) {
         if(var4 >= this.field438 && var4 <= this.field439) {
            Iterator var5 = this.field440.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod774(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "13"
   )
   public int[] method314(int var1, int var2, int var3) {
      Iterator var4 = this.field440.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod778(var1, var2, var3));

      return var5.vmethod775(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lhq;",
      garbageValue = "2123567737"
   )
   public Coordinates method327(int var1, int var2) {
      Iterator var3 = this.field440.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod774(var1, var2));

      return var4.vmethod797(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "927745081"
   )
   void method338() {
      Iterator var1 = this.field440.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod772(this);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "56519651"
   )
   public int method392() {
      return this.fileId;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-299400708"
   )
   public boolean method316() {
      return this.field434;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "106"
   )
   public String method319() {
      return this.field431;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "701863181"
   )
   public String method310() {
      return this.field443;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "578731793"
   )
   int method321() {
      return this.field433;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "80"
   )
   public int method322() {
      return this.field436;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1191301352"
   )
   public int method323() {
      return this.field430;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-35690387"
   )
   public int method324() {
      return this.field432;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-663923325"
   )
   public int method325() {
      return this.field438;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-60"
   )
   public int method326() {
      return this.field439;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "763971778"
   )
   public int method328() {
      return this.field435.worldX;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "32132"
   )
   public int method317() {
      return this.field435.plane;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method329() {
      return this.field435.worldY;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lhq;",
      garbageValue = "-2013447321"
   )
   public Coordinates method311() {
      return new Coordinates(this.field435);
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "627085883"
   )
   static final void method330() {
      Client.field968 = 0;
      int var0 = (class48.localPlayer.x >> 7) + ItemLayer.baseX;
      int var1 = (class48.localPlayer.y >> 7) + ItemLayer.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field968 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field968 = 1;
      }

      if(Client.field968 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field968 = 0;
      }

   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(Lbf;II)V",
      garbageValue = "350664446"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class3.method6(var0.x, var0.y, var1);
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(Lhk;I)V",
      garbageValue = "250850114"
   )
   static void method394(Widget var0) {
      if(var0.loopCycle == Client.field1010) {
         Client.field1055[var0.boundsIndex] = true;
      }

   }
}
