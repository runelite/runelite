import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("w")
   static int[] field1574;
   @ObfuscatedName("m")
   static int[] field1576;
   @ObfuscatedName("q")
   static int[] field1573;
   @ObfuscatedName("b")
   static int[] field1583;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   @Export("skin")
   FrameMap skin;
   @ObfuscatedName("n")
   @Export("transformCount")
   int transformCount;
   @ObfuscatedName("h")
   @Export("transformTypes")
   int[] transformTypes;
   @ObfuscatedName("x")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("j")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("a")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("l")
   @Export("showing")
   boolean showing;

   static {
      field1574 = new int[500];
      field1576 = new int[500];
      field1573 = new int[500];
      field1583 = new int[500];
   }

   @ObfuscatedSignature(
      signature = "([BLdx;)V"
   )
   Frame(byte[] var1, FrameMap var2) {
      this.skin = null;
      this.transformCount = -1;
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
                     field1574[var7] = var10;
                     field1576[var7] = 0;
                     field1573[var7] = 0;
                     field1583[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1574[var7] = var8;
            short var11 = 0;
            if(this.skin.types[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1576[var7] = var4.readShortSmart();
            } else {
               field1576[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1573[var7] = var4.readShortSmart();
            } else {
               field1573[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1583[var7] = var4.readShortSmart();
            } else {
               field1583[var7] = var11;
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
         this.transformCount = var7;
         this.transformTypes = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.transformTypes[var8] = field1574[var8];
            this.translator_x[var8] = field1576[var8];
            this.translator_y[var8] = field1573[var8];
            this.translator_z[var8] = field1583[var8];
         }

      }
   }
}
