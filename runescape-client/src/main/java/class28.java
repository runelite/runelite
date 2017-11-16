import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public abstract class class28 {
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -1612590847
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 344781897
   )
   static int field387;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 830264747
   )
   int field386;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 118744017
   )
   int field376;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1908712751
   )
   int field385;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1818447511
   )
   int field378;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -709977925
   )
   int field388;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 973284011
   )
   int field380;
   @ObfuscatedName("u")
   short[][][] field377;
   @ObfuscatedName("t")
   short[][][] field382;
   @ObfuscatedName("k")
   byte[][][] field383;
   @ObfuscatedName("n")
   byte[][][] field379;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[[[[Lan;"
   )
   class31[][][][] field384;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILfs;I)V",
      garbageValue = "877659794"
   )
   void method217(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method209(var1, var2, var3, var4);
         } else {
            this.method210(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILfs;II)V",
      garbageValue = "-16721119"
   )
   void method209(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field382[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field377[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILfs;II)V",
      garbageValue = "-1357333503"
   )
   void method210(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field377[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field382[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field383[var9][var1][var2] = (byte)(var11 >> 2);
               this.field379[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field384[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3201();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-27404"
   )
   int method211(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field377[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1249186091"
   )
   int method212() {
      return this.field385;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-142640688"
   )
   int method214() {
      return this.field378;
   }
}
