import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class45 extends class28 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1379793499
   )
   int field579;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1684398281
   )
   int field580;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1031727777
   )
   int field581;
   @ObfuscatedName("fo")
   static int[] field582;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1136534469
   )
   static int field583;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -738308949
   )
   int field585;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2098708634"
   )
   int method619() {
      return this.field579;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-1"
   )
   public static int method620(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field418 == super.field418 && super.field412 == var2.field412?this.field580 == var2.field580 && var2.field585 == this.field585:false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;I)V",
      garbageValue = "-923170815"
   )
   void method622(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(class36.field507.field511 != var3) {
         throw new IllegalStateException("");
      } else {
         super.field413 = var2.readUnsignedByte();
         super.field414 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedShort();
         super.field410 = var2.readUnsignedShort();
         this.field579 = var2.readUnsignedByte();
         this.field581 = var2.readUnsignedByte();
         super.field418 = var2.readUnsignedShort();
         super.field412 = var2.readUnsignedShort();
         this.field580 = var2.readUnsignedByte();
         this.field585 = var2.readUnsignedByte();
         super.field414 = Math.min(super.field414, 4);
         super.field409 = new short[1][64][64];
         super.field416 = new short[super.field414][64][64];
         super.field417 = new byte[super.field414][64][64];
         super.field420 = new byte[super.field414][64][64];
         super.field419 = new class31[super.field414][64][64][];
         var3 = var1.readUnsignedByte();
         if(class35.field500.field505 != var3) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(super.field418 == var4 && var5 == super.field412 && var6 == this.field580 && this.field585 == var7) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method237(this.field580 * 8 + var8, var9 + this.field585 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-528697735"
   )
   int method623() {
      return this.field581;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-92"
   )
   int method624() {
      return this.field580;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "85504"
   )
   int method625() {
      return this.field585;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   boolean method626(int var1, int var2) {
      return var1 < this.field580 * 8?false:(var2 < this.field585 * 8?false:(var1 >= this.field580 * 8 + 8?false:var2 < this.field585 * 8 + 8));
   }

   public int hashCode() {
      return super.field418 | super.field412 << 8 | this.field580 << 16 | this.field585 << 24;
   }
}
