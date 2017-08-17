import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("z")
   static int[] field399;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1795154535
   )
   int field387;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1390499403
   )
   int field388;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1668902327
   )
   int field385;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1358775613
   )
   int field386;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 5872763
   )
   int field397;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 201825363
   )
   int field396;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 932706913
   )
   int field395;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1223530131
   )
   int field390;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1506775307
   )
   int field398;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1505909039
   )
   int field393;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -820739925
   )
   int field400;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1235579493
   )
   int field392;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 355022847
   )
   int field391;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1436414113
   )
   int field394;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "122"
   )
   public boolean vmethod762(int var1, int var2) {
      return var1 >= (this.field388 << 6) + (this.field385 << 3) && var1 <= (this.field388 << 6) + (this.field397 << 3) + 7 && var2 >= (this.field390 << 6) + (this.field398 << 3) && var2 <= (this.field390 << 6) + (this.field400 << 3) + 7;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod741(int var1, int var2, int var3) {
      return var1 >= this.field387 && var1 < this.field386 + this.field387?var2 >= (this.field396 << 6) + (this.field395 << 3) && var2 <= (this.field396 << 6) + (this.field393 << 3) + 7 && var3 >= (this.field392 << 6) + (this.field391 << 3) && var3 <= (this.field392 << 6) + (this.field394 << 3) + 7:false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "239959050"
   )
   public void vmethod740(WorldMapData var1) {
      if(var1.field464 > this.field388) {
         var1.field464 = this.field388;
      }

      if(var1.field465 < this.field388) {
         var1.field465 = this.field388;
      }

      if(var1.field460 > this.field390) {
         var1.field460 = this.field390;
      }

      if(var1.field467 < this.field390) {
         var1.field467 = this.field390;
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
         int var3 = this.field395 * 8 - this.field385 * 8 + this.field396 * 64 - this.field388 * 64 + var1;
         int var4 = var2 + (this.field392 * 64 - this.field390 * 64) + (this.field391 * 8 - this.field398 * 8);
         return new Coordinates(this.field387, var3, var4);
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
         int[] var4 = new int[]{this.field388 * 64 - this.field396 * 64 + var2 + (this.field385 * 8 - this.field395 * 8), this.field390 * 64 - this.field392 * 64 + var3 + (this.field398 * 8 - this.field391 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-2081425823"
   )
   public void vmethod742(Buffer var1) {
      this.field387 = var1.readUnsignedByte();
      this.field386 = var1.readUnsignedByte();
      this.field396 = var1.readUnsignedShort();
      this.field395 = var1.readUnsignedByte();
      this.field393 = var1.readUnsignedByte();
      this.field392 = var1.readUnsignedShort();
      this.field391 = var1.readUnsignedByte();
      this.field394 = var1.readUnsignedByte();
      this.field388 = var1.readUnsignedShort();
      this.field385 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedByte();
      this.field390 = var1.readUnsignedShort();
      this.field398 = var1.readUnsignedByte();
      this.field400 = var1.readUnsignedByte();
      this.method215();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   void method215() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2142594245"
   )
   public static void method213() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "-1357387019"
   )
   static RenderOverview method225() {
      return class46.renderOverview;
   }
}
