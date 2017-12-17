import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("fj")
   static byte[][] field365;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2067562337
   )
   int field349;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1218222669
   )
   int field362;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 308981341
   )
   int field350;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 551418451
   )
   int field348;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2066588805
   )
   int field352;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1508820385
   )
   int field363;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1249939331
   )
   int field354;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 97993641
   )
   int field355;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 762870313
   )
   int field356;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 372237325
   )
   int field357;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 546411255
   )
   int field358;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 787651951
   )
   int field359;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1863393297
   )
   int field360;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -264406849
   )
   int field361;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lax;I)V",
      garbageValue = "-2145049745"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field424 > this.field352) {
         var1.field424 = this.field352;
      }

      if(var1.field417 < this.field352) {
         var1.field417 = this.field352;
      }

      if(var1.field425 > this.field363) {
         var1.field425 = this.field363;
      }

      if(var1.field431 < this.field363) {
         var1.field431 = this.field363;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1120247978"
   )
   public boolean vmethod708(int var1, int var2, int var3) {
      return var1 >= this.field349 && var1 < this.field362 + this.field349?var2 >= (this.field350 << 6) + (this.field354 << 3) && var2 <= (this.field350 << 6) + (this.field356 << 3) + 7 && var3 >= (this.field348 << 6) + (this.field355 << 3) && var3 <= (this.field348 << 6) + (this.field357 << 3) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1865125342"
   )
   public boolean vmethod698(int var1, int var2) {
      return var1 >= (this.field352 << 6) + (this.field358 << 3) && var1 <= (this.field352 << 6) + (this.field360 << 3) + 7 && var2 >= (this.field363 << 6) + (this.field359 << 3) && var2 <= (this.field363 << 6) + (this.field361 << 3) + 7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1197920526"
   )
   public int[] vmethod700(int var1, int var2, int var3) {
      if(!this.vmethod708(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field352 * 64 - this.field350 * 64 + var2 + (this.field358 * 8 - this.field354 * 8), var3 + (this.field363 * 64 - this.field348 * 64) + (this.field359 * 8 - this.field355 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Lhc;",
      garbageValue = "-879620257"
   )
   public Coordinates vmethod714(int var1, int var2) {
      if(!this.vmethod698(var1, var2)) {
         return null;
      } else {
         int var3 = this.field350 * 64 - this.field352 * 64 + (this.field354 * 8 - this.field358 * 8) + var1;
         int var4 = this.field348 * 64 - this.field363 * 64 + var2 + (this.field355 * 8 - this.field359 * 8);
         return new Coordinates(this.field349, var3, var4);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "1638498953"
   )
   public void vmethod701(Buffer var1) {
      this.field349 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedByte();
      this.field350 = var1.readUnsignedShort();
      this.field354 = var1.readUnsignedByte();
      this.field356 = var1.readUnsignedByte();
      this.field348 = var1.readUnsignedShort();
      this.field355 = var1.readUnsignedByte();
      this.field357 = var1.readUnsignedByte();
      this.field352 = var1.readUnsignedShort();
      this.field358 = var1.readUnsignedByte();
      this.field360 = var1.readUnsignedByte();
      this.field363 = var1.readUnsignedShort();
      this.field359 = var1.readUnsignedByte();
      this.field361 = var1.readUnsignedByte();
      this.method191();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "12345678"
   )
   void method191() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "887719997"
   )
   public static void method208() {
      if(class249.NetCache_socket != null) {
         class249.NetCache_socket.vmethod3081();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2397"
   )
   public static void method209() {
      ObjectComposition.objects.reset();
      ObjectComposition.field3512.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3521.reset();
   }
}
