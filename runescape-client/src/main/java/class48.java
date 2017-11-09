import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   static class47 field587;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1299500097
   )
   static int field595;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1514678413
   )
   int field586;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1437321729
   )
   int field585;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -381200671
   )
   int field596;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1126359821
   )
   int field588;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -538196747
   )
   int field589;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1114806857
   )
   int field590;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1447046559
   )
   int field601;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1354420929
   )
   int field592;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1488314477
   )
   int field593;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -680034781
   )
   int field594;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "-695326084"
   )
   public void vmethod772(WorldMapData var1) {
      if(var1.field430 > this.field589) {
         var1.field430 = this.field589;
      }

      if(var1.field432 < this.field589) {
         var1.field432 = this.field589;
      }

      if(var1.field438 > this.field590) {
         var1.field438 = this.field590;
      }

      if(var1.field439 < this.field590) {
         var1.field439 = this.field590;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2104062915"
   )
   public boolean vmethod778(int var1, int var2, int var3) {
      return var1 >= this.field586 && var1 < this.field585 + this.field586?var2 >= (this.field596 << 6) + (this.field601 << 3) && var2 <= (this.field596 << 6) + (this.field601 << 3) + 7 && var3 >= (this.field588 << 6) + (this.field592 << 3) && var3 <= (this.field588 << 6) + (this.field592 << 3) + 7:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   public boolean vmethod774(int var1, int var2) {
      return var1 >= (this.field589 << 6) + (this.field593 << 3) && var1 <= (this.field589 << 6) + (this.field593 << 3) + 7 && var2 >= (this.field590 << 6) + (this.field594 << 3) && var2 <= (this.field590 << 6) + (this.field594 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-579666919"
   )
   public int[] vmethod775(int var1, int var2, int var3) {
      if(!this.vmethod778(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field589 * 64 - this.field596 * 64 + var2 + (this.field593 * 8 - this.field601 * 8), var3 + (this.field590 * 64 - this.field588 * 64) + (this.field594 * 8 - this.field592 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhq;",
      garbageValue = "1"
   )
   public Coordinates vmethod797(int var1, int var2) {
      if(!this.vmethod774(var1, var2)) {
         return null;
      } else {
         int var3 = this.field596 * 64 - this.field589 * 64 + (this.field601 * 8 - this.field593 * 8) + var1;
         int var4 = this.field588 * 64 - this.field590 * 64 + var2 + (this.field592 * 8 - this.field594 * 8);
         return new Coordinates(this.field586, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfv;S)V",
      garbageValue = "256"
   )
   public void vmethod777(Buffer var1) {
      this.field586 = var1.readUnsignedByte();
      this.field585 = var1.readUnsignedByte();
      this.field596 = var1.readUnsignedShort();
      this.field601 = var1.readUnsignedByte();
      this.field588 = var1.readUnsignedShort();
      this.field592 = var1.readUnsignedByte();
      this.field589 = var1.readUnsignedShort();
      this.field593 = var1.readUnsignedByte();
      this.field590 = var1.readUnsignedShort();
      this.field594 = var1.readUnsignedByte();
      this.method803();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1559456665"
   )
   void method803() {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Len;IIIB)Z",
      garbageValue = "29"
   )
   public static final boolean method794(Model var0, int var1, int var2, int var3) {
      boolean var4 = class133.field1917;
      if(!var4) {
         return false;
      } else {
         Varcs.method1903();
         int var5 = var0.field1892 + var1;
         int var6 = var2 + var0.field1875;
         int var7 = var3 + var0.field1876;
         int var8 = var0.field1877;
         int var9 = var0.field1878;
         int var10 = var0.field1879;
         int var11 = class133.field1919 - var5;
         int var12 = class133.field1916 - var6;
         int var13 = class35.field475 - var7;
         return Math.abs(var11) > var8 + Varcs.field1423?false:(Math.abs(var12) > var9 + class133.field1920?false:(Math.abs(var13) > var10 + class239.field3259?false:(Math.abs(var13 * class258.field3444 - var12 * class133.field1913) > var9 * class239.field3259 + var10 * class133.field1920?false:(Math.abs(var11 * class133.field1913 - var13 * class133.field1918) > var10 * Varcs.field1423 + var8 * class239.field3259?false:Math.abs(var12 * class133.field1918 - var11 * class258.field3444) <= var8 * class133.field1920 + var9 * Varcs.field1423))));
      }
   }
}
