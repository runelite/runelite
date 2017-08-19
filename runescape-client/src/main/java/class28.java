import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public abstract class class28 {
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("nz")
   @ObfuscatedSignature(
      signature = "[Lbr;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 167009895
   )
   int field413;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -310993731
   )
   int field424;
   @ObfuscatedName("c")
   short[][][] field419;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1317301117
   )
   int field415;
   @ObfuscatedName("l")
   short[][][] field417;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[[[[Lav;"
   )
   class31[][][][] field420;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1660750161
   )
   int field414;
   @ObfuscatedName("w")
   byte[][][] field412;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -786848807
   )
   int field416;
   @ObfuscatedName("b")
   byte[][][] field423;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1554591281
   )
   int field411;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1175938269"
   )
   int method239(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field419[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILfb;II)V",
      garbageValue = "1484349355"
   )
   void method238(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field417[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field419[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILfb;II)V",
      garbageValue = "1450705538"
   )
   void method254(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field419[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field417[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field412[var9][var1][var2] = (byte)(var11 >> 2);
               this.field423[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field420[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3189();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "253335603"
   )
   int method236() {
      return this.field424;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1992357101"
   )
   int method240() {
      return this.field413;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILfb;S)V",
      garbageValue = "20616"
   )
   void method237(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method238(var1, var2, var3, var4);
         } else {
            this.method254(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;I)V",
      garbageValue = "-790315376"
   )
   public static void method255(IndexDataBase var0) {
      InvType.field3268 = var0;
   }
}
