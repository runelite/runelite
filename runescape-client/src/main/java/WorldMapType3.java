import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1917416017
   )
   int field379;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1783534623
   )
   int field378;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -635399295
   )
   int field381;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1950410143
   )
   int field387;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 431783931
   )
   int field386;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -634861037
   )
   int field384;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1473261395
   )
   int field376;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2053070521
   )
   int field389;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1645770289
   )
   int field385;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -382249999
   )
   int field382;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 264725575
   )
   int field374;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1121429913
   )
   int field388;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2001773791
   )
   int field377;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1572499235
   )
   int field383;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2141582860"
   )
   public boolean vmethod722(int var1, int var2) {
      return var1 >= (this.field378 << 6) + (this.field381 << 3) && var1 <= (this.field378 << 6) + (this.field386 << 3) + 7 && var2 >= (this.field389 << 6) + (this.field385 << 3) && var2 <= (this.field389 << 6) + (this.field374 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1671303044"
   )
   public boolean vmethod721(int var1, int var2, int var3) {
      return var1 >= this.field379 && var1 < this.field387 + this.field379?var2 >= (this.field384 << 6) + (this.field376 << 3) && var2 <= (this.field384 << 6) + (this.field382 << 3) + 7 && var3 >= (this.field377 << 6) + (this.field388 << 3) && var3 <= (this.field383 << 3) + (this.field377 << 6) + 7:false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "-1824757307"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field447 > this.field378) {
         var1.field447 = this.field378;
      }

      if(var1.field448 < this.field378) {
         var1.field448 = this.field378;
      }

      if(var1.field441 > this.field389) {
         var1.field441 = this.field389;
      }

      if(var1.field450 < this.field389) {
         var1.field450 = this.field389;
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
         int var3 = this.field384 * 64 - this.field378 * 64 + var1 + (this.field376 * 8 - this.field381 * 8);
         int var4 = this.field388 * 8 - this.field385 * 8 + this.field377 * 64 - this.field389 * 64 + var2;
         return new Coordinates(this.field379, var3, var4);
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
         int[] var4 = new int[]{this.field381 * 8 - this.field376 * 8 + this.field378 * 64 - this.field384 * 64 + var2, this.field385 * 8 - this.field388 * 8 + var3 + (this.field389 * 64 - this.field377 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-1909314997"
   )
   public void vmethod746(Buffer var1) {
      this.field379 = var1.readUnsignedByte();
      this.field387 = var1.readUnsignedByte();
      this.field384 = var1.readUnsignedShort();
      this.field376 = var1.readUnsignedByte();
      this.field382 = var1.readUnsignedByte();
      this.field377 = var1.readUnsignedShort();
      this.field388 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedByte();
      this.field378 = var1.readUnsignedShort();
      this.field381 = var1.readUnsignedByte();
      this.field386 = var1.readUnsignedByte();
      this.field389 = var1.readUnsignedShort();
      this.field385 = var1.readUnsignedByte();
      this.field374 = var1.readUnsignedByte();
      this.method183();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   void method183() {
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "265685137"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class202.method3682(var0, class164.field2317);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class202.method3682(Client.friends[var3].name, class164.field2317)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class202.method3682(Script.localPlayer.name, class164.field2317))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
