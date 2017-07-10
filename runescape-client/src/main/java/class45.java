import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class45 extends class28 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -789130939
   )
   int field613;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 913310253
   )
   int field614;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2141430175
   )
   int field615;
   @ObfuscatedName("fc")
   static int[] field616;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1160863115
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("el")
   static Font field618;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2120533875
   )
   int field622;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LModel;IIIII)V",
      garbageValue = "-1926754426"
   )
   static final void method653(Model var0, int var1, int var2, int var3, int var4) {
      class7.field234.method3543(new class10(var0, var1, var2, var3, var4));
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field410 == super.field410 && var2.field411 == super.field411?var2.field614 == this.field614 && var2.field615 == this.field615:false;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;B)V",
      garbageValue = "-63"
   )
   void method655(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field516.field525) {
         throw new IllegalStateException("");
      } else {
         super.field412 = var2.readUnsignedByte();
         super.field413 = var2.readUnsignedByte();
         super.field420 = var2.readUnsignedShort();
         super.field409 = var2.readUnsignedShort();
         this.field622 = var2.readUnsignedByte();
         this.field613 = var2.readUnsignedByte();
         super.field410 = var2.readUnsignedShort();
         super.field411 = var2.readUnsignedShort();
         this.field614 = var2.readUnsignedByte();
         this.field615 = var2.readUnsignedByte();
         super.field413 = Math.min(super.field413, 4);
         super.field414 = new short[1][64][64];
         super.field421 = new short[super.field413][64][64];
         super.field408 = new byte[super.field413][64][64];
         super.field419 = new byte[super.field413][64][64];
         super.field418 = new class31[super.field413][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field507.field506) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(super.field410 == var4 && var5 == super.field411 && this.field614 == var6 && this.field615 == var7) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method228(this.field614 * 8 + var8, this.field615 * 8 + var9, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1884885874"
   )
   int method656() {
      return this.field622;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1394326053"
   )
   int method657() {
      return this.field613;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "507260075"
   )
   int method658() {
      return this.field614;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   int method659() {
      return this.field615;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1193807264"
   )
   boolean method667(int var1, int var2) {
      return var1 < this.field614 * 8?false:(var2 < this.field615 * 8?false:(var1 >= this.field614 * 8 + 8?false:var2 < this.field615 * 8 + 8));
   }

   public int hashCode() {
      return super.field410 | super.field411 << 8 | this.field614 << 16 | this.field615 << 24;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1308656938"
   )
   static final String method684(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class220.method4055('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class220.method4055(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class220.method4055(16776960) + var1 + "</col>");
   }
}
