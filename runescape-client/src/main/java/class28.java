import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public abstract class class28 {
   @ObfuscatedName("an")
   @Export("clientInstance")
   static Client clientInstance;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1249089651
   )
   int field399;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1781889243
   )
   int field401;
   @ObfuscatedName("l")
   short[][][] field405;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1480932171
   )
   int field404;
   @ObfuscatedName("m")
   class31[][][][] field409;
   @ObfuscatedName("s")
   short[][][] field410;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -437437171
   )
   int field407;
   @ObfuscatedName("w")
   byte[][][] field406;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1070955015
   )
   int field403;
   @ObfuscatedName("p")
   byte[][][] field408;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -586331605
   )
   int field400;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "436002722"
   )
   int method222(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field405[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "532552929"
   )
   void method221(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field405[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field410[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field406[var9][var1][var2] = (byte)(var11 >> 2);
               this.field408[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field409[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3221();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "-1910673030"
   )
   void method231(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field410[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field405[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1659670791"
   )
   int method223() {
      return this.field401;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2129285286"
   )
   int method234() {
      return this.field399;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILBuffer;I)V",
      garbageValue = "-503831883"
   )
   void method219(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method231(var1, var2, var3, var4);
         } else {
            this.method221(var1, var2, var3, var4);
         }

      }
   }
}
