import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public abstract class class28 {
   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static Font field406;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1572099295
   )
   int field404;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -886264267
   )
   int field405;
   @ObfuscatedName("v")
   short[][][] field408;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1631245665
   )
   int field407;
   @ObfuscatedName("z")
   short[][][] field403;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[[[[Lal;"
   )
   class31[][][][] field412;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 83690387
   )
   int field402;
   @ObfuscatedName("r")
   byte[][][] field410;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 936609425
   )
   int field411;
   @ObfuscatedName("u")
   byte[][][] field413;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1424658913
   )
   int field409;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "14"
   )
   int method228(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field408[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILfh;IB)V",
      garbageValue = "99"
   )
   void method227(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field408[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field403[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field410[var9][var1][var2] = (byte)(var11 >> 2);
               this.field413[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field412[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3190();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILfh;II)V",
      garbageValue = "2081965416"
   )
   void method236(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field403[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field408[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2090038958"
   )
   int method237() {
      return this.field404;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "697784068"
   )
   int method229() {
      return this.field405;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILfh;I)V",
      garbageValue = "-872443443"
   )
   void method225(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method236(var1, var2, var3, var4);
         } else {
            this.method227(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lcc;",
      garbageValue = "1"
   )
   static Script method243(int var0) {
      Script var1 = (Script)Script.field1525.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class253.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class97.method1829(var2);
            Script.field1525.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
