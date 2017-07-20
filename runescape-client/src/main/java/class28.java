import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public abstract class class28 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -931652045
   )
   int field392;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1286042623
   )
   int field394;
   @ObfuscatedName("s")
   short[][][] field398;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1700732753
   )
   int field405;
   @ObfuscatedName("x")
   short[][][] field399;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[[[[Lal;"
   )
   class31[][][][] field397;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2041189871
   )
   int field396;
   @ObfuscatedName("p")
   byte[][][] field400;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 45281111
   )
   int field403;
   @ObfuscatedName("k")
   byte[][][] field401;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1362559205
   )
   int field393;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-107"
   )
   int method220(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field398[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILfp;II)V",
      garbageValue = "978585539"
   )
   void method219(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field398[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field399[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field400[var9][var1][var2] = (byte)(var11 >> 2);
               this.field401[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field397[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3266();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILfp;II)V",
      garbageValue = "239111145"
   )
   void method223(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field399[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field398[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-15"
   )
   int method236() {
      return this.field394;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "836171332"
   )
   int method222() {
      return this.field392;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILfp;I)V",
      garbageValue = "1521478243"
   )
   void method224(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method223(var1, var2, var3, var4);
         } else {
            this.method219(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method239(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class265.field3642.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = DynamicObject.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
