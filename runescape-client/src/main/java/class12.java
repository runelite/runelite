import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class12 extends Renderable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 572337783
   )
   int field176;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -275731089
   )
   int field177;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -735156831
   )
   int field178;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -399781585
   )
   int field179;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 932981437
   )
   int field180;
   @ObfuscatedName("m")
   Sequence field182;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1459765903
   )
   int field183;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1937777227
   )
   int field184;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1868323753
   )
   int field188;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "3"
   )
   protected final Model getModel() {
      if(this.field182 != null) {
         int var1 = Client.gameCycle - this.field184;
         if(var1 > 100 && this.field182.field996 > 0) {
            var1 = 100;
         }

         label62: {
            do {
               do {
                  if(var1 <= this.field182.field994[this.field183]) {
                     break label62;
                  }

                  var1 -= this.field182.field994[this.field183];
                  ++this.field183;
               } while(this.field183 < this.field182.field992.length);

               this.field183 -= this.field182.field996;
            } while(this.field183 >= 0 && this.field183 < this.field182.field992.length);

            this.field182 = null;
         }

         this.field184 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class8.getObjectDefinition(this.field188);
      if(null != var12.impostorIds) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field178 != 1 && this.field178 != 3) {
            var2 = var12.field936;
            var3 = var12.field937;
         } else {
            var2 = var12.field937;
            var3 = var12.field936;
         }

         int var4 = (var2 >> 1) + this.field180;
         int var5 = this.field180 + (1 + var2 >> 1);
         int var6 = (var3 >> 1) + this.field177;
         int var7 = this.field177 + (1 + var3 >> 1);
         int[][] var8 = class5.tileHeights[this.field179];
         int var9 = var8[var4][var7] + var8[var4][var6] + var8[var5][var6] + var8[var5][var7] >> 2;
         int var10 = (this.field180 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field177 << 7);
         return var12.method829(this.field176, this.field178, var8, var10, var9, var11, this.field182, this.field183);
      }
   }

   @ObfuscatedName("f")
   public static String method142(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class165.field2685[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-8910509"
   )
   static final void method145(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = 6 + var2;
      int var5 = class112.field1962.method4093(var0, 250);
      int var6 = class112.field1962.method4094(var0, 250) * 13;
      class82.method1861(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var2 + var6, 0);
      class82.method1852(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      class112.field1962.method4125(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class50.method1014(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2);
      if(var1) {
         try {
            Graphics var7 = GameObject.canvas.getGraphics();
            XClanMember.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            GameObject.canvas.repaint();
         }
      } else {
         class48.method968(var3, var4, var5, var6);
      }

   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field188 = var1;
      this.field176 = var2;
      this.field178 = var3;
      this.field179 = var4;
      this.field180 = var5;
      this.field177 = var6;
      if(var7 != -1) {
         this.field182 = class62.getAnimation(var7);
         this.field183 = 0;
         this.field184 = Client.gameCycle - 1;
         if(this.field182.replyMode == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field182 == this.field182) {
               this.field183 = var10.field183;
               this.field184 = var10.field184;
               return;
            }
         }

         if(var8 && this.field182.field996 != -1) {
            this.field183 = (int)(Math.random() * (double)this.field182.field992.length);
            this.field184 -= (int)(Math.random() * (double)this.field182.field994[this.field183]);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1521990747"
   )
   public static void method146(int var0) {
      class186.field3005 = 1;
      class186.field2996 = null;
      class186.field2997 = -1;
      class175.field2777 = -1;
      class186.field2999 = 0;
      class186.field2992 = false;
      class186.field3002 = var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1586064793"
   )
   static void method147() {
      class34.field763 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class34.field761[var0] = null;
         class34.field760[var0] = 1;
      }

   }
}
