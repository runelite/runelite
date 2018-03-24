import java.util.Iterator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 835171835
   )
   int field354;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1014362759
   )
   int field349;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1811931545
   )
   int field350;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2077092503
   )
   int field363;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1410065485
   )
   int field352;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -915722601
   )
   int field353;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1593900405
   )
   int field358;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1077986219
   )
   int field362;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1824883793
   )
   int field356;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 277934661
   )
   int field357;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1292806369
   )
   int field359;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1807209157
   )
   int field351;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 959080231
   )
   int field360;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2095925033
   )
   int field348;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1173479592"
   )
   public void vmethod762(WorldMapData var1) {
      if(var1.minX > this.field352) {
         var1.minX = this.field352;
      }

      if(var1.field428 < this.field352) {
         var1.field428 = this.field352;
      }

      if(var1.minY > this.field353) {
         var1.minY = this.field353;
      }

      if(var1.field430 < this.field353) {
         var1.field430 = this.field353;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-52"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field354 && var1 < this.field349 + this.field354?var2 >= (this.field350 << 6) + (this.field358 << 3) && var2 <= (this.field350 << 6) + (this.field356 << 3) + 7 && var3 >= (this.field363 << 6) + (this.field362 << 3) && var3 <= (this.field363 << 6) + (this.field357 << 3) + 7:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "53"
   )
   public boolean vmethod764(int var1, int var2) {
      return var1 >= (this.field352 << 6) + (this.field359 << 3) && var1 <= (this.field352 << 6) + (this.field360 << 3) + 7 && var2 >= (this.field353 << 6) + (this.field351 << 3) && var2 <= (this.field353 << 6) + (this.field348 << 3) + 7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-653420606"
   )
   public int[] vmethod765(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field352 * 64 - this.field350 * 64 + var2 + (this.field359 * 8 - this.field358 * 8), var3 + (this.field353 * 64 - this.field363 * 64) + (this.field351 * 8 - this.field362 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)Lik;",
      garbageValue = "-2033075237"
   )
   public Coordinates vmethod770(int var1, int var2) {
      if(!this.vmethod764(var1, var2)) {
         return null;
      } else {
         int var3 = this.field350 * 64 - this.field352 * 64 + (this.field358 * 8 - this.field359 * 8) + var1;
         int var4 = this.field363 * 64 - this.field353 * 64 + var2 + (this.field362 * 8 - this.field351 * 8);
         return new Coordinates(this.field354, var3, var4);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1382348566"
   )
   public void vmethod761(Buffer var1) {
      this.field354 = var1.readUnsignedByte();
      this.field349 = var1.readUnsignedByte();
      this.field350 = var1.readUnsignedShort();
      this.field358 = var1.readUnsignedByte();
      this.field356 = var1.readUnsignedByte();
      this.field363 = var1.readUnsignedShort();
      this.field362 = var1.readUnsignedByte();
      this.field357 = var1.readUnsignedByte();
      this.field352 = var1.readUnsignedShort();
      this.field359 = var1.readUnsignedByte();
      this.field360 = var1.readUnsignedByte();
      this.field353 = var1.readUnsignedShort();
      this.field351 = var1.readUnsignedByte();
      this.field348 = var1.readUnsignedByte();
      this.method207();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2049329402"
   )
   void method207() {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1129911217"
   )
   static void method227() {
      Iterator var0 = class95.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1166();
      }

   }
}
