import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      longValue = 5150890726337518591L
   )
   static long field608;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -362606635
   )
   static int field605;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -251057171
   )
   int field601;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1201511355
   )
   int field598;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 285699377
   )
   int field602;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 679265661
   )
   int field595;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2128091289
   )
   int field596;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1261408413
   )
   int field600;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 929332967
   )
   int field604;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1417995219
   )
   int field603;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 505385021
   )
   int field599;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 382408053
   )
   int field609;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2141582860"
   )
   public boolean vmethod722(int var1, int var2) {
      return var1 >= (this.field598 << 6) + (this.field602 << 3) && var1 <= (this.field598 << 6) + (this.field602 << 3) + 7 && var2 >= (this.field604 << 6) + (this.field603 << 3) && var2 <= (this.field604 << 6) + (this.field603 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1671303044"
   )
   public boolean vmethod721(int var1, int var2, int var3) {
      return var1 >= this.field601 && var1 < this.field601 + this.field595?var2 >= (this.field596 << 6) + (this.field600 << 3) && var2 <= (this.field596 << 6) + (this.field600 << 3) + 7 && var3 >= (this.field599 << 6) + (this.field609 << 3) && var3 <= (this.field599 << 6) + (this.field609 << 3) + 7:false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "-1824757307"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field447 > this.field598) {
         var1.field447 = this.field598;
      }

      if(var1.field448 < this.field598) {
         var1.field448 = this.field598;
      }

      if(var1.field441 > this.field604) {
         var1.field441 = this.field604;
      }

      if(var1.field450 < this.field604) {
         var1.field450 = this.field604;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Lhd;",
      garbageValue = "665140774"
   )
   public Coordinates vmethod743(int var1, int var2) {
      if(!this.vmethod722(var1, var2)) {
         return null;
      } else {
         int var3 = this.field600 * 8 - this.field602 * 8 + this.field596 * 64 - this.field598 * 64 + var1;
         int var4 = this.field609 * 8 - this.field603 * 8 + this.field599 * 64 - this.field604 * 64 + var2;
         return new Coordinates(this.field601, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "13"
   )
   public int[] vmethod731(int var1, int var2, int var3) {
      if(!this.vmethod721(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field602 * 8 - this.field600 * 8 + this.field598 * 64 - this.field596 * 64 + var2, this.field603 * 8 - this.field609 * 8 + this.field604 * 64 - this.field599 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-1909314997"
   )
   public void vmethod746(Buffer var1) {
      this.field601 = var1.readUnsignedByte();
      this.field595 = var1.readUnsignedByte();
      this.field596 = var1.readUnsignedShort();
      this.field600 = var1.readUnsignedByte();
      this.field599 = var1.readUnsignedShort();
      this.field609 = var1.readUnsignedByte();
      this.field598 = var1.readUnsignedShort();
      this.field602 = var1.readUnsignedByte();
      this.field604 = var1.readUnsignedShort();
      this.field603 = var1.readUnsignedByte();
      this.method724();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1606776473"
   )
   void method724() {
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(Lhy;B)V",
      garbageValue = "-94"
   )
   static void method749(Widget var0) {
      if(var0.loopCycle == Client.field1110) {
         Client.field1111[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1175012851"
   )
   static final void method750(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = Actor.getTileHeight(var0, var1, class45.plane) - var2;
         var0 -= class41.cameraX;
         var3 -= XItemContainer.cameraZ;
         var1 -= class7.cameraY;
         int var4 = Graphics3D.SINE[class8.cameraPitch];
         int var5 = Graphics3D.COSINE[class8.cameraPitch];
         int var6 = Graphics3D.SINE[Friend.cameraYaw];
         int var7 = Graphics3D.COSINE[Friend.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.screenY = Client.scale * var0 / var1 + Client.viewportHeight / 2;
            Client.screenX = var8 * Client.scale / var1 + Client.viewportWidth / 2;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
