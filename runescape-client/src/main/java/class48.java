import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Ljq;"
   )
   public static BufferProvider field582;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -108445845
   )
   static int field577;
   @ObfuscatedName("g")
   @Export("blendedSaturation")
   static int[] blendedSaturation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1508868603
   )
   int field573;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1829483183
   )
   int field576;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 178335539
   )
   int field580;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1588295937
   )
   int field572;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 280004539
   )
   int field574;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 572136827
   )
   int field578;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1601418651
   )
   int field584;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1273910923
   )
   int field581;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 233218547
   )
   int field575;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -512638879
   )
   int field579;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-198305855"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >= (this.field576 << 6) + (this.field580 << 3) && var1 <= (this.field576 << 6) + (this.field580 << 3) + 7 && var2 >= (this.field584 << 6) + (this.field581 << 3) && var2 <= (this.field584 << 6) + (this.field581 << 3) + 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIS)Z",
      garbageValue = "4496"
   )
   public boolean vmethod714(int var1, int var2, int var3) {
      return var1 >= this.field573 && var1 < this.field572 + this.field573?var2 >= (this.field574 << 6) + (this.field578 << 3) && var2 <= (this.field574 << 6) + (this.field578 << 3) + 7 && var3 >= (this.field575 << 6) + (this.field579 << 3) && var3 <= (this.field575 << 6) + (this.field579 << 3) + 7:false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "103"
   )
   public void vmethod713(WorldMapData var1) {
      if(var1.field429 > this.field576) {
         var1.field429 = this.field576;
      }

      if(var1.field430 < this.field576) {
         var1.field430 = this.field576;
      }

      if(var1.field431 > this.field584) {
         var1.field431 = this.field584;
      }

      if(var1.field432 < this.field584) {
         var1.field432 = this.field584;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Lhy;",
      garbageValue = "-93"
   )
   public Coordinates vmethod717(int var1, int var2) {
      if(!this.vmethod715(var1, var2)) {
         return null;
      } else {
         int var3 = this.field578 * 8 - this.field580 * 8 + this.field574 * 64 - this.field576 * 64 + var1;
         int var4 = this.field575 * 64 - this.field584 * 64 + var2 + (this.field579 * 8 - this.field581 * 8);
         return new Coordinates(this.field573, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "32"
   )
   public int[] vmethod716(int var1, int var2, int var3) {
      if(!this.vmethod714(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field576 * 64 - this.field574 * 64) + (this.field580 * 8 - this.field578 * 8), var3 + (this.field581 * 8 - this.field579 * 8) + (this.field584 * 64 - this.field575 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "996105043"
   )
   public void vmethod718(Buffer var1) {
      this.field573 = var1.readUnsignedByte();
      this.field572 = var1.readUnsignedByte();
      this.field574 = var1.readUnsignedShort();
      this.field578 = var1.readUnsignedByte();
      this.field575 = var1.readUnsignedShort();
      this.field579 = var1.readUnsignedByte();
      this.field576 = var1.readUnsignedShort();
      this.field580 = var1.readUnsignedByte();
      this.field584 = var1.readUnsignedShort();
      this.field581 = var1.readUnsignedByte();
      this.method720();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "873050809"
   )
   void method720() {
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Lhn;I)V",
      garbageValue = "843358455"
   )
   static void method732(Widget var0) {
      if(var0.loopCycle == Client.field906) {
         Client.field1088[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   public static void method729() {
      class203.field2473.method3819();
      class203.field2475 = 1;
      class262.field3614 = null;
   }
}
