import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2041126369
   )
   public static int field507;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1796637883
   )
   int field504;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 665744605
   )
   int field499;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1445426511
   )
   int field501;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 67317995
   )
   int field503;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -114952059
   )
   int field498;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2026834723
   )
   int field500;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1173479592"
   )
   public void vmethod762(WorldMapData var1) {
      if(var1.minX > this.field498) {
         var1.minX = this.field498;
      }

      if(var1.field428 < this.field498) {
         var1.field428 = this.field498;
      }

      if(var1.minY > this.field500) {
         var1.minY = this.field500;
      }

      if(var1.field430 < this.field500) {
         var1.field430 = this.field500;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-52"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field504 && var1 < this.field499 + this.field504?var2 >> 6 == this.field501 && var3 >> 6 == this.field503:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "53"
   )
   public boolean vmethod764(int var1, int var2) {
      return var1 >> 6 == this.field498 && var2 >> 6 == this.field500;
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
         int[] var4 = new int[]{this.field498 * 64 - this.field501 * 64 + var2, var3 + (this.field500 * 64 - this.field503 * 64)};
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
         int var3 = this.field501 * 64 - this.field498 * 64 + var1;
         int var4 = this.field503 * 64 - this.field500 * 64 + var2;
         return new Coordinates(this.field504, var3, var4);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1382348566"
   )
   public void vmethod761(Buffer var1) {
      this.field504 = var1.readUnsignedByte();
      this.field499 = var1.readUnsignedByte();
      this.field501 = var1.readUnsignedShort();
      this.field503 = var1.readUnsignedShort();
      this.field498 = var1.readUnsignedShort();
      this.field500 = var1.readUnsignedShort();
      this.method559();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method559() {
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ILik;ZI)V",
      garbageValue = "-1759917029"
   )
   static void method578(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class155.method3159().getWorldMapDataByFileId(var0);
      int var4 = WorldMapData.localPlayer.field836;
      int var5 = (WorldMapData.localPlayer.x >> 7) + class38.baseX;
      int var6 = (WorldMapData.localPlayer.y >> 7) + PlayerComposition.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class155.method3159().method6006(var3, var7, var1, var2);
   }
}
