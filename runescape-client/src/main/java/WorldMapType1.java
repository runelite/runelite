import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("k")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("or")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("o")
   @Export("blendedSaturation")
   static int[] blendedSaturation;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1486283911
   )
   int field441;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -214287531
   )
   int field438;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1136713989
   )
   int field436;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2007697125
   )
   int field443;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1372189647
   )
   int field442;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1332123963
   )
   int field435;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -148661181
   )
   int field444;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1372352907
   )
   int field439;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1490372533
   )
   int field445;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1863033107
   )
   int field437;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "122"
   )
   public boolean vmethod762(int var1, int var2) {
      return var1 >> 6 >= this.field441 && var1 >> 6 <= this.field443 && var2 >> 6 >= this.field442 && var2 >> 6 <= this.field444;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod741(int var1, int var2, int var3) {
      return var1 >= this.field438 && var1 < this.field436 + this.field438?var2 >> 6 >= this.field435 && var2 >> 6 <= this.field439 && var3 >> 6 >= this.field445 && var3 >> 6 <= this.field437:false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "239959050"
   )
   public void vmethod740(WorldMapData var1) {
      if(var1.field464 > this.field441) {
         var1.field464 = this.field441;
      }

      if(var1.field465 < this.field443) {
         var1.field465 = this.field443;
      }

      if(var1.field460 > this.field442) {
         var1.field460 = this.field442;
      }

      if(var1.field467 < this.field444) {
         var1.field467 = this.field444;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Lhh;",
      garbageValue = "0"
   )
   public Coordinates vmethod744(int var1, int var2) {
      if(!this.vmethod762(var1, var2)) {
         return null;
      } else {
         int var3 = this.field435 * 64 - this.field441 * 64 + var1;
         int var4 = this.field445 * 64 - this.field442 * 64 + var2;
         return new Coordinates(this.field438, var3, var4);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "216213566"
   )
   public int[] vmethod759(int var1, int var2, int var3) {
      if(!this.vmethod741(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field441 * 64 - this.field435 * 64 + var2, var3 + (this.field442 * 64 - this.field445 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-2081425823"
   )
   public void vmethod742(Buffer var1) {
      this.field438 = var1.readUnsignedByte();
      this.field436 = var1.readUnsignedByte();
      this.field435 = var1.readUnsignedShort();
      this.field445 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field437 = var1.readUnsignedShort();
      this.field441 = var1.readUnsignedShort();
      this.field442 = var1.readUnsignedShort();
      this.field443 = var1.readUnsignedShort();
      this.field444 = var1.readUnsignedShort();
      this.method269();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "67"
   )
   void method269() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "4"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = Widget.method4042(var0 - 1, var1 - 1) + Widget.method4042(var0 + 1, var1 - 1) + Widget.method4042(var0 - 1, var1 + 1) + Widget.method4042(var0 + 1, var1 + 1);
      int var3 = Widget.method4042(var0 - 1, var1) + Widget.method4042(var0 + 1, var1) + Widget.method4042(var0, var1 - 1) + Widget.method4042(var0, var1 + 1);
      int var4 = Widget.method4042(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
