import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class45 extends class28 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -828985169
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1084059471
   )
   static int field587;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -569688479
   )
   int field584;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -144957381
   )
   int field589;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 376404815
   )
   int field585;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 723245069
   )
   int field586;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1646991287"
   )
   int method611() {
      return this.field585;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2060605761"
   )
   boolean method608(int var1, int var2) {
      return var1 < this.field585 * 8?false:(var2 < this.field586 * 8?false:(var1 >= this.field585 * 8 + 8?false:var2 < this.field586 * 8 + 8));
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-271406584"
   )
   int method609() {
      return this.field586;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;Lfp;I)V",
      garbageValue = "414887534"
   )
   void method617(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field492.field500) {
         throw new IllegalStateException("");
      } else {
         super.field396 = var2.readUnsignedByte();
         super.field405 = var2.readUnsignedByte();
         super.field403 = var2.readUnsignedShort();
         super.field393 = var2.readUnsignedShort();
         this.field589 = var2.readUnsignedByte();
         this.field584 = var2.readUnsignedByte();
         super.field394 = var2.readUnsignedShort();
         super.field392 = var2.readUnsignedShort();
         this.field585 = var2.readUnsignedByte();
         this.field586 = var2.readUnsignedByte();
         super.field405 = Math.min(super.field405, 4);
         super.field398 = new short[1][64][64];
         super.field399 = new short[super.field405][64][64];
         super.field400 = new byte[super.field405][64][64];
         super.field401 = new byte[super.field405][64][64];
         super.field397 = new class31[super.field405][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field482.field481) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field394 && var5 == super.field392 && var6 == this.field585 && var7 == this.field586) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method224(this.field585 * 8 + var8, this.field586 * 8 + var9, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1706247622"
   )
   int method625() {
      return this.field589;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "823501395"
   )
   int method606() {
      return this.field584;
   }

   public int hashCode() {
      return super.field394 | super.field392 << 8 | this.field585 << 16 | this.field586 << 24;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field394 == var2.field394 && var2.field392 == super.field392?this.field585 == var2.field585 && this.field586 == var2.field586:false;
      }
   }
}
