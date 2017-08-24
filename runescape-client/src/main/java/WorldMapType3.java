import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1656794867
   )
   int field400;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -344756285
   )
   int field388;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1446004461
   )
   int field395;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1211949151
   )
   int field385;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1816425229
   )
   int field394;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -784966529
   )
   int field386;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -829553951
   )
   int field390;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1026156511
   )
   int field389;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1043462929
   )
   int field393;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 83675759
   )
   int field392;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2114538353
   )
   int field397;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -32453045
   )
   int field391;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1232782969
   )
   int field387;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1619536801
   )
   int field396;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "59"
   )
   public boolean vmethod747(int var1, int var2) {
      return var1 >= (this.field388 << 6) + (this.field395 << 3) && var1 <= (this.field388 << 6) + (this.field394 << 3) + 7 && var2 >= (this.field389 << 6) + (this.field393 << 3) && var2 <= (this.field389 << 6) + (this.field397 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1746025354"
   )
   public boolean vmethod746(int var1, int var2, int var3) {
      return var1 >= this.field400 && var1 < this.field400 + this.field385?var2 >= (this.field386 << 6) + (this.field390 << 3) && var2 <= (this.field386 << 6) + (this.field392 << 3) + 7 && var3 >= (this.field387 << 6) + (this.field391 << 3) && var3 <= (this.field387 << 6) + (this.field396 << 3) + 7:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "2013920575"
   )
   public void vmethod745(WorldMapData var1) {
      if(var1.field462 > this.field388) {
         var1.field462 = this.field388;
      }

      if(var1.field468 < this.field388) {
         var1.field468 = this.field388;
      }

      if(var1.field456 > this.field389) {
         var1.field456 = this.field389;
      }

      if(var1.field465 < this.field389) {
         var1.field465 = this.field389;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "1278074658"
   )
   public Coordinates vmethod771(int var1, int var2) {
      if(!this.vmethod747(var1, var2)) {
         return null;
      } else {
         int var3 = this.field386 * 64 - this.field388 * 64 + (this.field390 * 8 - this.field395 * 8) + var1;
         int var4 = this.field391 * 8 - this.field393 * 8 + this.field387 * 64 - this.field389 * 64 + var2;
         return new Coordinates(this.field400, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1584803853"
   )
   public int[] vmethod757(int var1, int var2, int var3) {
      if(!this.vmethod746(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field388 * 64 - this.field386 * 64 + var2 + (this.field395 * 8 - this.field390 * 8), this.field393 * 8 - this.field391 * 8 + var3 + (this.field389 * 64 - this.field387 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1644047401"
   )
   public void vmethod751(Buffer var1) {
      this.field400 = var1.readUnsignedByte();
      this.field385 = var1.readUnsignedByte();
      this.field386 = var1.readUnsignedShort();
      this.field390 = var1.readUnsignedByte();
      this.field392 = var1.readUnsignedByte();
      this.field387 = var1.readUnsignedShort();
      this.field391 = var1.readUnsignedByte();
      this.field396 = var1.readUnsignedByte();
      this.field388 = var1.readUnsignedShort();
      this.field395 = var1.readUnsignedByte();
      this.field394 = var1.readUnsignedByte();
      this.field389 = var1.readUnsignedShort();
      this.field393 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedByte();
      this.method211();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1068181048"
   )
   void method211() {
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-270480795"
   )
   static final void method239() {
      if(class8.soundSystem1 != null) {
         class8.soundSystem1.method2055();
      }

      if(CacheFile.soundSystem0 != null) {
         CacheFile.soundSystem0.method2055();
      }

   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "-1"
   )
   static void method237(Buffer var0, int var1) {
      byte[] var2 = var0.payload;
      if(Client.field979 == null) {
         Client.field979 = new byte[24];
      }

      class184.method3561(var2, var1, Client.field979, 0, 24);
      if(class156.field2253 != null) {
         try {
            class156.field2253.seek(0L);
            class156.field2253.write(var0.payload, var1, 24);
         } catch (Exception var4) {
            ;
         }
      }

   }
}
