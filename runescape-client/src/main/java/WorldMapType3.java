import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("bf")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("z")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2097029131
   )
   int field361;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -190267067
   )
   int field354;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 143723951
   )
   int field358;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1751414887
   )
   int field360;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1136630777
   )
   int field362;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1662793125
   )
   int field353;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2117973893
   )
   int field356;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 420202771
   )
   int field355;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1253989981
   )
   int field351;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2085472751
   )
   int field350;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1559977365
   )
   int field363;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1768429353
   )
   int field357;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -521770717
   )
   int field352;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1562403111
   )
   int field359;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-198305855"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >= (this.field354 << 6) + (this.field358 << 3) && var1 <= (this.field354 << 6) + (this.field362 << 3) + 7 && var2 >= (this.field355 << 6) + (this.field351 << 3) && var2 <= (this.field355 << 6) + (this.field363 << 3) + 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIS)Z",
      garbageValue = "4496"
   )
   public boolean vmethod714(int var1, int var2, int var3) {
      return var1 >= this.field361 && var1 < this.field360 + this.field361?var2 >= (this.field353 << 6) + (this.field356 << 3) && var2 <= (this.field353 << 6) + (this.field350 << 3) + 7 && var3 >= (this.field352 << 6) + (this.field357 << 3) && var3 <= (this.field352 << 6) + (this.field359 << 3) + 7:false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "103"
   )
   public void vmethod713(WorldMapData var1) {
      if(var1.field429 > this.field354) {
         var1.field429 = this.field354;
      }

      if(var1.field430 < this.field354) {
         var1.field430 = this.field354;
      }

      if(var1.field431 > this.field355) {
         var1.field431 = this.field355;
      }

      if(var1.field432 < this.field355) {
         var1.field432 = this.field355;
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
         int var3 = this.field356 * 8 - this.field358 * 8 + (this.field353 * 64 - this.field354 * 64) + var1;
         int var4 = this.field357 * 8 - this.field351 * 8 + this.field352 * 64 - this.field355 * 64 + var2;
         return new Coordinates(this.field361, var3, var4);
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
         int[] var4 = new int[]{var2 + (this.field354 * 64 - this.field353 * 64) + (this.field358 * 8 - this.field356 * 8), this.field351 * 8 - this.field357 * 8 + this.field355 * 64 - this.field352 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "996105043"
   )
   public void vmethod718(Buffer var1) {
      this.field361 = var1.readUnsignedByte();
      this.field360 = var1.readUnsignedByte();
      this.field353 = var1.readUnsignedShort();
      this.field356 = var1.readUnsignedByte();
      this.field350 = var1.readUnsignedByte();
      this.field352 = var1.readUnsignedShort();
      this.field357 = var1.readUnsignedByte();
      this.field359 = var1.readUnsignedByte();
      this.field354 = var1.readUnsignedShort();
      this.field358 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedByte();
      this.field355 = var1.readUnsignedShort();
      this.field351 = var1.readUnsignedByte();
      this.field363 = var1.readUnsignedByte();
      this.method180();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1160768554"
   )
   void method180() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-2130450673"
   )
   public static void method204(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      class177.method3419(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lik;",
      garbageValue = "-1555579227"
   )
   public static VarPlayerType method181(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lcc;I)V",
      garbageValue = "-940168697"
   )
   static void method203(World var0) {
      if(var0.method1596() != Client.isMembers) {
         Client.isMembers = var0.method1596();
         class22.method156(var0.method1596());
      }

      class1.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class229.field3149 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      class11.field254 = Client.socketType == 0?443:var0.id + '썐';
      class56.myWorldPort = class229.field3149;
   }
}
