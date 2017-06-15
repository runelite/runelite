import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public abstract class class28 {
   @ObfuscatedName("i")
   short[][][] field419;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -955759519
   )
   int field420;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1962376639
   )
   int field421;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -877876967
   )
   int field422;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -978903633
   )
   int field423;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1026465469
   )
   int field424;
   @ObfuscatedName("j")
   short[][][] field425;
   @ObfuscatedName("f")
   byte[][][] field427;
   @ObfuscatedName("c")
   byte[][][] field428;
   @ObfuscatedName("o")
   class31[][][][] field429;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -209659439
   )
   int field430;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "397158106"
   )
   static int method229() {
      return 9;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILBuffer;I)V",
      garbageValue = "787717491"
   )
   void method230(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method231(var1, var2, var3, var4);
         } else {
            this.method232(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "1189209001"
   )
   void method231(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field419[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field425[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "-1373705650"
   )
   void method232(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field425[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field419[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field427[var9][var1][var2] = (byte)(var11 >> 2);
               this.field428[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field429[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3048();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1937594897"
   )
   int method233(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field425[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1281378281"
   )
   int method234() {
      return this.field421;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   int method235() {
      return this.field422;
   }

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "975499984"
   )
   static boolean method248(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
