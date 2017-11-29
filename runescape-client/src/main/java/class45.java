import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class45 extends class28 {
   @ObfuscatedName("h")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1665034583
   )
   int field563;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1542776801
   )
   int field558;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 871641983
   )
   int field559;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1447073041
   )
   int field560;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;Lfr;I)V",
      garbageValue = "644507864"
   )
   void method657(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field482.field480) {
         throw new IllegalStateException("");
      } else {
         super.field389 = var2.readUnsignedByte();
         super.field383 = var2.readUnsignedByte();
         super.field391 = var2.readUnsignedShort();
         super.field379 = var2.readUnsignedShort();
         this.field563 = var2.readUnsignedByte();
         this.field558 = var2.readUnsignedByte();
         super.field385 = var2.readUnsignedShort();
         super.field381 = var2.readUnsignedShort();
         this.field559 = var2.readUnsignedByte();
         this.field560 = var2.readUnsignedByte();
         super.field383 = Math.min(super.field383, 4);
         super.field384 = new short[1][64][64];
         super.field386 = new short[super.field383][64][64];
         super.field378 = new byte[super.field383][64][64];
         super.field387 = new byte[super.field383][64][64];
         super.field388 = new class31[super.field383][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field475.field474) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field385 && var5 == super.field381 && var6 == this.field559 && var7 == this.field560) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method221(var8 + this.field559 * 8, var9 + this.field560 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-897787113"
   )
   boolean method639(int var1, int var2) {
      return var1 < this.field559 * 8?false:(var2 < this.field560 * 8?false:(var1 >= this.field559 * 8 + 8?false:var2 < this.field560 * 8 + 8));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-28"
   )
   int method642() {
      return this.field563;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2036819790"
   )
   int method643() {
      return this.field558;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2129947618"
   )
   int method644() {
      return this.field559;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1419690508"
   )
   int method641() {
      return this.field560;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field385 == super.field385 && var2.field381 == super.field381?this.field559 == var2.field559 && var2.field560 == this.field560:false;
      }
   }

   public int hashCode() {
      return super.field385 | super.field381 << 8 | this.field559 << 16 | this.field560 << 24;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lfp;",
      garbageValue = "1676443481"
   )
   static LoginPacket[] method665() {
      return new LoginPacket[]{LoginPacket.field2406, LoginPacket.field2401, LoginPacket.field2400, LoginPacket.field2402};
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)[Lck;",
      garbageValue = "-16711936"
   )
   static AttackOption[] method664() {
      return new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden};
   }
}
