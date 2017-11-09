import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public abstract class class28 {
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -321431079
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1432568443
   )
   int field399;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 680527433
   )
   int field392;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1032834175
   )
   int field393;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -541225933
   )
   int field394;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 475334833
   )
   int field395;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 561922039
   )
   int field391;
   @ObfuscatedName("e")
   short[][][] field396;
   @ObfuscatedName("l")
   short[][][] field397;
   @ObfuscatedName("b")
   byte[][][] field398;
   @ObfuscatedName("n")
   byte[][][] field400;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[[[[Lag;"
   )
   class31[][][][] field401;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILfv;I)V",
      garbageValue = "-883757846"
   )
   void method244(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method245(var1, var2, var3, var4);
         } else {
            this.method246(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILfv;IB)V",
      garbageValue = "-87"
   )
   void method245(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field397[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field396[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILfv;II)V",
      garbageValue = "1411505485"
   )
   void method246(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field396[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field397[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field398[var9][var1][var2] = (byte)(var11 >> 2);
               this.field400[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field401[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3301();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "472480388"
   )
   int method247(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field396[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "841702042"
   )
   int method265() {
      return this.field393;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1871507101"
   )
   int method249() {
      return this.field394;
   }
}
