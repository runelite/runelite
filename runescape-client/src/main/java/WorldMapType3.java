import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 881279813
   )
   int field376;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -944599897
   )
   int field377;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1660061957
   )
   int field378;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1129872967
   )
   int field379;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1542048159
   )
   int field380;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1816743947
   )
   int field381;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 776569977
   )
   int field382;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -608773289
   )
   int field383;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -148359099
   )
   int field384;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1304523273
   )
   int field385;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -607094949
   )
   int field386;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1445707133
   )
   int field387;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 477564139
   )
   int field388;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1983772111
   )
   int field389;

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-333716235"
   )
   static String method179(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field926 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field926 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field926 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field926 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field926 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class224.field2839 != null) {
         var3 = "/p=" + class224.field2839;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field896 + "/a=" + class59.field731 + var3 + "/";
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-664101150"
   )
   void method180() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-5"
   )
   public boolean vmethod724(int var1, int var2, int var3) {
      return var1 >= this.field387 && var1 < this.field377 + this.field387?var2 >= (this.field378 << 6) + (this.field382 << 3) && var2 <= (this.field378 << 6) + (this.field376 << 3) + 7 && var3 >= (this.field383 << 6) + (this.field385 << 3) && var3 <= (this.field379 << 3) + (this.field383 << 6) + 7:false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "437687546"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >= (this.field380 << 6) + (this.field386 << 3) && var1 <= (this.field380 << 6) + (this.field388 << 3) + 7 && var2 >= (this.field384 << 3) + (this.field381 << 6) && var2 <= (this.field381 << 6) + (this.field389 << 3) + 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "892960012"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod724(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field386 * 8 - this.field382 * 8 + this.field380 * 64 - this.field378 * 64 + var2, this.field381 * 64 - this.field383 * 64 + var3 + (this.field384 * 8 - this.field385 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lclass212;",
      garbageValue = "-820164631"
   )
   public Coordinates vmethod718(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field378 * 64 - this.field380 * 64) + (this.field382 * 8 - this.field386 * 8);
         int var4 = this.field385 * 8 - this.field384 * 8 + this.field383 * 64 - this.field381 * 64 + var2;
         return new Coordinates(this.field387, var3, var4);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1671424373"
   )
   public void vmethod719(Buffer var1) {
      this.field387 = var1.readUnsignedByte();
      this.field377 = var1.readUnsignedByte();
      this.field378 = var1.readUnsignedShort();
      this.field382 = var1.readUnsignedByte();
      this.field376 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedShort();
      this.field385 = var1.readUnsignedByte();
      this.field379 = var1.readUnsignedByte();
      this.field380 = var1.readUnsignedShort();
      this.field386 = var1.readUnsignedByte();
      this.field388 = var1.readUnsignedByte();
      this.field381 = var1.readUnsignedShort();
      this.field384 = var1.readUnsignedByte();
      this.field389 = var1.readUnsignedByte();
      this.method180();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass32;I)V",
      garbageValue = "-228062308"
   )
   public void vmethod715(WorldMapData var1) {
      if(var1.field453 > this.field380) {
         var1.field453 = this.field380;
      }

      if(var1.field454 < this.field380) {
         var1.field454 = this.field380;
      }

      if(var1.field463 > this.field381) {
         var1.field463 = this.field381;
      }

      if(var1.field456 < this.field381) {
         var1.field456 = this.field381;
      }

   }
}
