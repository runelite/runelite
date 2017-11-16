import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1627394675
   )
   int field485;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1665626263
   )
   int field480;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2012516539
   )
   int field481;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 322276871
   )
   int field482;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1859218233
   )
   int field483;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 637769689
   )
   int field479;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "1999614542"
   )
   public void vmethod670(WorldMapData var1) {
      if(var1.field423 > this.field483) {
         var1.field423 = this.field483;
      }

      if(var1.field424 < this.field483) {
         var1.field424 = this.field483;
      }

      if(var1.field417 > this.field479) {
         var1.field417 = this.field479;
      }

      if(var1.field426 < this.field479) {
         var1.field426 = this.field479;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "16"
   )
   public boolean vmethod667(int var1, int var2, int var3) {
      return var1 >= this.field485 && var1 < this.field485 + this.field480?var2 >> 6 == this.field481 && var3 >> 6 == this.field482:false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "748684240"
   )
   public boolean vmethod668(int var1, int var2) {
      return var1 >> 6 == this.field483 && var2 >> 6 == this.field479;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1806249195"
   )
   public int[] vmethod682(int var1, int var2, int var3) {
      if(!this.vmethod667(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field483 * 64 - this.field481 * 64 + var2, var3 + (this.field479 * 64 - this.field482 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lhk;",
      garbageValue = "-98479540"
   )
   public Coordinates vmethod669(int var1, int var2) {
      if(!this.vmethod668(var1, var2)) {
         return null;
      } else {
         int var3 = this.field481 * 64 - this.field483 * 64 + var1;
         int var4 = this.field482 * 64 - this.field479 * 64 + var2;
         return new Coordinates(this.field485, var3, var4);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1450864888"
   )
   public void vmethod665(Buffer var1) {
      this.field485 = var1.readUnsignedByte();
      this.field480 = var1.readUnsignedByte();
      this.field481 = var1.readUnsignedShort();
      this.field482 = var1.readUnsignedShort();
      this.field483 = var1.readUnsignedShort();
      this.field479 = var1.readUnsignedShort();
      this.method490();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1132808738"
   )
   void method490() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-64"
   )
   public static boolean method507(int var0) {
      return var0 >= class228.field2892.field2888 && var0 <= class228.field2876.field2888;
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "879849420"
   )
   static final void method508(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         class5.field25[Client.field968 / 100].drawAt(Client.field954 - 8, Client.field955 - 8);
      }

      if(Client.cursorState == 2) {
         class5.field25[Client.field968 / 100 + 4].drawAt(Client.field954 - 8, Client.field955 - 8);
      }

      Client.field966 = 0;
      int var4 = (class275.localPlayer.x >> 7) + class13.baseX;
      int var5 = (class275.localPlayer.y >> 7) + ClanMember.baseY;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field966 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field966 = 1;
      }

      if(Client.field966 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field966 = 0;
      }

   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "95"
   )
   static void method506(int var0, int var1) {
      ContextMenuRow var2 = class31.topContextMenuRow;
      class14.menuAction(var2.param0, var2.param1, var2.type, var2.identifier, var2.option, var2.option, var0, var1);
      class31.topContextMenuRow = null;
   }
}
