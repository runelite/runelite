import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("s")
   static int[] field1771;
   @ObfuscatedName("g")
   static int[] field1775;
   @ObfuscatedName("m")
   static int[] field1772;
   @ObfuscatedName("h")
   static int[] field1780;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("skin")
   FrameMap skin;
   @ObfuscatedName("w")
   int field1770;
   @ObfuscatedName("t")
   int[] field1776;
   @ObfuscatedName("d")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("z")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("k")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("c")
   @Export("showing")
   boolean showing;

   static {
      field1771 = new int[500];
      field1775 = new int[500];
      field1772 = new int[500];
      field1780 = new int[500];
   }

   @ObfuscatedSignature(
      signature = "([BLeo;)V"
   )
   Frame(byte[] var1, FrameMap var2) {
      this.skin = null;
      this.field1770 = -1;
      this.showing = false;
      this.skin = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.readUnsignedByte();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var5 + var3.offset;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.readUnsignedByte();
         if(var9 > 0) {
            if(this.skin.types[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.skin.types[var10] == 0) {
                     field1771[var7] = var10;
                     field1775[var7] = 0;
                     field1772[var7] = 0;
                     field1780[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1771[var7] = var8;
            short var11 = 0;
            if(this.skin.types[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1775[var7] = var4.readShortSmart();
            } else {
               field1775[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1772[var7] = var4.readShortSmart();
            } else {
               field1772[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1780[var7] = var4.readShortSmart();
            } else {
               field1780[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.skin.types[var8] == 5) {
               this.showing = true;
            }
         }
      }

      if(var1.length != var4.offset) {
         throw new RuntimeException();
      } else {
         this.field1770 = var7;
         this.field1776 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1776[var8] = field1771[var8];
            this.translator_x[var8] = field1775[var8];
            this.translator_y[var8] = field1772[var8];
            this.translator_z[var8] = field1780[var8];
         }

      }
   }
}
