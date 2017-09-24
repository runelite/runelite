import java.awt.Image;
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
   @ObfuscatedName("at")
   static Image field460;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1788214535
   )
   static int field472;
   @ObfuscatedName("a")
   String field458;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 684426583
   )
   int field463;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 679187049
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("d")
   boolean field466;
   @ObfuscatedName("j")
   String field457;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1073353735
   )
   int field467;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   Coordinates field461;
   @ObfuscatedName("l")
   LinkedList field464;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2076523025
   )
   int field465;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -769782893
   )
   int field468;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -367944901
   )
   int field462;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1093041537
   )
   int field456;

   public WorldMapData() {
      this.fileId = -1;
      this.field463 = -1;
      this.field467 = -1;
      this.field461 = null;
      this.field462 = Integer.MAX_VALUE;
      this.field468 = 0;
      this.field456 = Integer.MAX_VALUE;
      this.field465 = 0;
      this.field466 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "859359160"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field457 = var1.readString();
      this.field458 = var1.readString();
      this.field461 = new Coordinates(var1.readInt());
      this.field463 = var1.readInt();
      var1.readUnsignedByte();
      this.field466 = var1.readUnsignedByte() == 1;
      this.field467 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field464 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field464.add(this.method307(var1));
      }

      this.method312();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1425226394"
   )
   public String method340() {
      return this.field457;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1210037963"
   )
   public boolean method309(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field462 && var3 <= this.field468) {
         if(var4 >= this.field456 && var4 <= this.field465) {
            Iterator var5 = this.field464.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod747(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2081021787"
   )
   public int method313() {
      return this.fileId;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1937266980"
   )
   public int[] method310(int var1, int var2, int var3) {
      Iterator var4 = this.field464.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod746(var1, var2, var3));

      return var5.vmethod757(var1, var2, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1827891313"
   )
   public int method360() {
      return this.field462;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-490809154"
   )
   public int method373() {
      return this.field456;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1754778189"
   )
   public boolean method308(int var1, int var2, int var3) {
      Iterator var4 = this.field464.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod746(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "318764311"
   )
   public Coordinates method311(int var1, int var2) {
      Iterator var3 = this.field464.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod747(var1, var2));

      return var4.vmethod771(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method324() {
      return this.field461.plane;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-951590115"
   )
   public int method374() {
      return this.field461.worldX;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1664983282"
   )
   public int method325() {
      return this.field461.worldY;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1945442788"
   )
   public int method318() {
      return this.field467;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-24242"
   )
   void method312() {
      Iterator var1 = this.field464.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod745(this);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfp;I)Law;",
      garbageValue = "-1116805896"
   )
   WorldMapSectionBase method307(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)class88.forOrdinal(class27.method241(), var2);
      Object var4 = null;
      switch(var3.field405) {
      case 0:
         var4 = new class48();
         break;
      case 1:
         var4 = new WorldMapType3();
         break;
      case 2:
         var4 = new WorldMapType2();
         break;
      case 3:
         var4 = new WorldMapType1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod751(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1801906054"
   )
   public boolean method314() {
      return this.field466;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method320() {
      return this.field468;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1374160597"
   )
   public int method322() {
      return this.field465;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1899113761"
   )
   int method362() {
      return this.field463;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method323() {
      return this.field458;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)Lhs;",
      garbageValue = "49"
   )
   public Coordinates method306() {
      return new Coordinates(this.field461);
   }
}
