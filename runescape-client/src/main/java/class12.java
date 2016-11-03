import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class12 extends Renderable {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1931937023
   )
   int field173;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -347642815
   )
   int field174;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 35248861
   )
   int field175;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 946187501
   )
   int field176;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2033955557
   )
   int field177;
   @ObfuscatedName("ce")
   static class146 field178;
   @ObfuscatedName("an")
   static class149 field179;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1157840235
   )
   int field180;
   @ObfuscatedName("gz")
   static Widget field182;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -138634921
   )
   int field183;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1278316985
   )
   static int field184;
   @ObfuscatedName("dq")
   static int[] field185;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1085508723
   )
   int field186;
   @ObfuscatedName("m")
   Sequence field187;
   @ObfuscatedName("qk")
   protected static java.awt.Frame field188;

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1725952648"
   )
   static final void method139(String var0) {
      if(class114.clanMembers != null) {
         Client.field324.method2828(144);
         Client.field324.method2556(class31.method685(var0));
         Client.field324.method2562(var0);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1714992488"
   )
   protected final Model getModel() {
      if(this.field187 != null) {
         int var1 = Client.gameCycle - this.field180;
         if(var1 > 100 && this.field187.field1010 > 0) {
            var1 = 100;
         }

         label68: {
            do {
               do {
                  if(var1 <= this.field187.field1008[this.field186]) {
                     break label68;
                  }

                  var1 -= this.field187.field1008[this.field186];
                  ++this.field186;
               } while(this.field186 < this.field187.field1006.length);

               this.field186 -= this.field187.field1010;
            } while(this.field186 >= 0 && this.field186 < this.field187.field1006.length);

            this.field187 = null;
         }

         this.field180 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = Projectile.getObjectDefinition(this.field175);
      if(null != var12.impostorIds) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field174 != 1 && this.field174 != 3) {
            var2 = var12.field950;
            var3 = var12.field948;
         } else {
            var2 = var12.field948;
            var3 = var12.field950;
         }

         int var4 = (var2 >> 1) + this.field176;
         int var5 = (1 + var2 >> 1) + this.field176;
         int var6 = this.field177 + (var3 >> 1);
         int var7 = this.field177 + (var3 + 1 >> 1);
         int[][] var8 = class5.tileHeights[this.field183];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.field176 << 7) + (var2 << 6);
         int var11 = (this.field177 << 7) + (var3 << 6);
         return var12.method842(this.field173, this.field174, var8, var10, var9, var11, this.field187, this.field186);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "12"
   )
   static int method143(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method624()?(var1.method624()?0:1):(var1.method624()?-1:0)):(var2 == 5?(var0.method622()?(var1.method622()?0:1):(var1.method622()?-1:0)):(var2 == 6?(var0.method649()?(var1.method649()?0:1):(var1.method649()?-1:0)):(var2 == 7?(var0.method621()?(var1.method621()?0:1):(var1.method621()?-1:0)):var0.id - var1.id)))));
      }
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field175 = var1;
      this.field173 = var2;
      this.field174 = var3;
      this.field183 = var4;
      this.field176 = var5;
      this.field177 = var6;
      if(var7 != -1) {
         this.field187 = NPC.getAnimation(var7);
         this.field186 = 0;
         this.field180 = Client.gameCycle - 1;
         if(this.field187.replyMode == 0 && null != var9 && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field187 == this.field187) {
               this.field186 = var10.field186;
               this.field180 = var10.field180;
               return;
            }
         }

         if(var8 && this.field187.field1010 != -1) {
            this.field186 = (int)(Math.random() * (double)this.field187.field1006.length);
            this.field180 -= (int)(Math.random() * (double)this.field187.field1008[this.field186]);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-45"
   )
   static final int method145(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }
}
