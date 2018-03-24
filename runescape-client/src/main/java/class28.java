import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public abstract class class28 {
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field377;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -244965017
   )
   int field379;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 805243399
   )
   int field378;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 665995871
   )
   int field390;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2091127369
   )
   int field385;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 852094465
   )
   int field381;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1899409351
   )
   int field382;
   @ObfuscatedName("e")
   short[][][] field383;
   @ObfuscatedName("x")
   short[][][] field384;
   @ObfuscatedName("p")
   byte[][][] field389;
   @ObfuscatedName("g")
   byte[][][] field386;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[[[[Lam;"
   )
   @Export("decorations")
   WorldMapDecoration[][][][] decorations;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILgb;B)V",
      garbageValue = "-34"
   )
   void method234(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method245(var1, var2, var3, var4);
         } else {
            this.method236(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILgb;IB)V",
      garbageValue = "-10"
   )
   void method245(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field384[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field383[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILgb;II)V",
      garbageValue = "502759590"
   )
   void method236(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field383[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field384[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field389[var9][var1][var2] = (byte)(var11 >> 2);
               this.field386[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3553();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "638810292"
   )
   int method237(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field383[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-471091684"
   )
   int method238() {
      return this.field390;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1269080879"
   )
   int method239() {
      return this.field385;
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "53"
   )
   static final void method253() {
      if(Client.field1036 > 0) {
         class132.method2765();
      } else {
         Client.field898.method5204();
         class20.setGameState(40);
         MapLabel.field445 = Client.field1072.getSocket();
         Client.field1072.method2082();
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(Lbw;II)V",
      garbageValue = "1954318899"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class25.worldToScreen(var0.x, var0.y, var1);
   }
}
