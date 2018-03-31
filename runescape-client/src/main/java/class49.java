import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class49 implements WorldMapSectionBase {
   @ObfuscatedName("mp")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -1720772873
   )
   static int field578;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1787871455
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -532991891
   )
   int field587;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1417519429
   )
   int field580;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1791094487
   )
   int field585;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -59732657
   )
   int field581;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -582850449
   )
   int field582;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1501048955
   )
   int field590;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 266786615
   )
   int field588;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1392419531
   )
   int field583;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1157574725
   )
   int field586;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 83191785
   )
   int field584;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "269119455"
   )
   public void vmethod751(WorldMapData var1) {
      if(var1.minX > this.field582) {
         var1.minX = this.field582;
      }

      if(var1.field431 < this.field582) {
         var1.field431 = this.field582;
      }

      if(var1.minY > this.field590) {
         var1.minY = this.field590;
      }

      if(var1.field436 < this.field590) {
         var1.field436 = this.field590;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "520265099"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field587 && var1 < this.field587 + this.field580?var2 >= (this.field585 << 6) + (this.field588 << 3) && var2 <= (this.field585 << 6) + (this.field588 << 3) + 7 && var3 >= (this.field581 << 6) + (this.field583 << 3) && var3 <= (this.field581 << 6) + (this.field583 << 3) + 7:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "9376"
   )
   public boolean vmethod758(int var1, int var2) {
      return var1 >= (this.field582 << 6) + (this.field586 << 3) && var1 <= (this.field582 << 6) + (this.field586 << 3) + 7 && var2 >= (this.field590 << 6) + (this.field584 << 3) && var2 <= (this.field590 << 6) + (this.field584 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "174791792"
   )
   public int[] vmethod754(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field582 * 64 - this.field585 * 64 + var2 + (this.field586 * 8 - this.field588 * 8), var3 + (this.field590 * 64 - this.field581 * 64) + (this.field584 * 8 - this.field583 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Lim;",
      garbageValue = "-64"
   )
   public Coordinates vmethod777(int var1, int var2) {
      if(!this.vmethod758(var1, var2)) {
         return null;
      } else {
         int var3 = this.field585 * 64 - this.field582 * 64 + (this.field588 * 8 - this.field586 * 8) + var1;
         int var4 = this.field581 * 64 - this.field590 * 64 + var2 + (this.field583 * 8 - this.field584 * 8);
         return new Coordinates(this.field587, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-314407075"
   )
   public void vmethod756(Buffer var1) {
      this.field587 = var1.readUnsignedByte();
      this.field580 = var1.readUnsignedByte();
      this.field585 = var1.readUnsignedShort();
      this.field588 = var1.readUnsignedByte();
      this.field581 = var1.readUnsignedShort();
      this.field583 = var1.readUnsignedByte();
      this.field582 = var1.readUnsignedShort();
      this.field586 = var1.readUnsignedByte();
      this.field590 = var1.readUnsignedShort();
      this.field584 = var1.readUnsignedByte();
      this.method757();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-854639313"
   )
   void method757() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-281347183"
   )
   static final void method778(String var0) {
      class47.method743(var0 + " is already on your ignore list");
   }
}
