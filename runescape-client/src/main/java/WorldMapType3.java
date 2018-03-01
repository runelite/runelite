import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "[Lly;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1748782099
   )
   int field390;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1023503781
   )
   int field397;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1003648575
   )
   int field384;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -190940853
   )
   int field383;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 90715059
   )
   int field386;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -24173245
   )
   int field382;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2134120455
   )
   int field385;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2048284993
   )
   int field389;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1635326351
   )
   int field395;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1934696739
   )
   int field388;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 158924779
   )
   int field392;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 386016885
   )
   int field393;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -414522119
   )
   int field394;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1721756379
   )
   int field391;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;B)V",
      garbageValue = "-33"
   )
   public void vmethod716(WorldMapData var1) {
      if(var1.field459 > this.field386) {
         var1.field459 = this.field386;
      }

      if(var1.field460 < this.field386) {
         var1.field460 = this.field386;
      }

      if(var1.field453 > this.field382) {
         var1.field453 = this.field382;
      }

      if(var1.field462 < this.field382) {
         var1.field462 = this.field382;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1122721489"
   )
   public boolean vmethod712(int var1, int var2, int var3) {
      return var1 >= this.field390 && var1 < this.field390 + this.field397?var2 >= (this.field384 << 6) + (this.field385 << 3) && var2 <= (this.field384 << 6) + (this.field395 << 3) + 7 && var3 >= (this.field383 << 6) + (this.field389 << 3) && var3 <= (this.field383 << 6) + (this.field388 << 3) + 7:false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-78"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >= (this.field386 << 6) + (this.field392 << 3) && var1 <= (this.field386 << 6) + (this.field394 << 3) + 7 && var2 >= (this.field382 << 6) + (this.field393 << 3) && var2 <= (this.field382 << 6) + (this.field391 << 3) + 7;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "606812260"
   )
   public int[] vmethod714(int var1, int var2, int var3) {
      if(!this.vmethod712(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field386 * 64 - this.field384 * 64 + var2 + (this.field392 * 8 - this.field385 * 8), var3 + (this.field382 * 64 - this.field383 * 64) + (this.field393 * 8 - this.field389 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lic;",
      garbageValue = "-1902472796"
   )
   public Coordinates vmethod717(int var1, int var2) {
      if(!this.vmethod715(var1, var2)) {
         return null;
      } else {
         int var3 = this.field384 * 64 - this.field386 * 64 + (this.field385 * 8 - this.field392 * 8) + var1;
         int var4 = this.field383 * 64 - this.field382 * 64 + var2 + (this.field389 * 8 - this.field393 * 8);
         return new Coordinates(this.field390, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "241325114"
   )
   public void vmethod718(Buffer var1) {
      this.field390 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedByte();
      this.field384 = var1.readUnsignedShort();
      this.field385 = var1.readUnsignedByte();
      this.field395 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedShort();
      this.field389 = var1.readUnsignedByte();
      this.field388 = var1.readUnsignedByte();
      this.field386 = var1.readUnsignedShort();
      this.field392 = var1.readUnsignedByte();
      this.field394 = var1.readUnsignedByte();
      this.field382 = var1.readUnsignedShort();
      this.field393 = var1.readUnsignedByte();
      this.field391 = var1.readUnsignedByte();
      this.method218();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1868471805"
   )
   void method218() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-1621265697"
   )
   public static long method193(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }
}
