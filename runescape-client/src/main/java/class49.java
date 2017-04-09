import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class49 extends Renderable {
   @ObfuscatedName("g")
   public static String field972;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 30458433
   )
   int field973;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 200348911
   )
   int field974;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2024611723
   )
   int field976;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1598094925
   )
   int field977;
   @ObfuscatedName("l")
   Sequence field978;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1970435357
   )
   int field979;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1072907613
   )
   int field980;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 916584295
   )
   int field981;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1910690837
   )
   int field982;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "128848463"
   )
   static final byte[] method924(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 >= 0 && (IndexDataBase.field2740 == 0 || var3 <= IndexDataBase.field2740)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.readBytes(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.readInt();
            if(var4 < 0 || IndexDataBase.field2740 != 0 && var4 > IndexDataBase.field2740) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class147.method2806(var5, var4, var0, var3, 9);
               } else {
                  IndexDataBase.field2736.method2803(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      if(this.field978 != null) {
         int var1 = Client.gameCycle - this.field973;
         if(var1 > 100 && this.field978.frameStep > 0) {
            var1 = 100;
         }

         label47: {
            do {
               do {
                  if(var1 <= this.field978.frameLenghts[this.field979]) {
                     break label47;
                  }

                  var1 -= this.field978.frameLenghts[this.field979];
                  ++this.field979;
               } while(this.field979 < this.field978.frameIDs.length);

               this.field979 -= this.field978.frameStep;
            } while(this.field979 >= 0 && this.field979 < this.field978.frameIDs.length);

            this.field978 = null;
         }

         this.field973 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class140.getObjectDefinition(this.field982);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field974 != 1 && this.field974 != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.field976 + (var2 >> 1);
         int var5 = (var2 + 1 >> 1) + this.field976;
         int var6 = this.field977 + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.field977;
         int[][] var8 = class10.tileHeights[this.field981];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.field976 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field977 << 7);
         return var12.method3645(this.field980, this.field974, var8, var10, var9, var11, this.field978, this.field979);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass178;",
      garbageValue = "-2037635990"
   )
   public static class178 method928(int var0) {
      class178[] var1 = class104.method2039();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class178 var3 = var1[var2];
         if(var3.field2701 == var0) {
            return var3;
         }
      }

      return null;
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field982 = var1;
      this.field980 = var2;
      this.field974 = var3;
      this.field981 = var4;
      this.field976 = var5;
      this.field977 = var6;
      if(var7 != -1) {
         this.field978 = Friend.getAnimation(var7);
         this.field979 = 0;
         this.field973 = Client.gameCycle - 1;
         if(this.field978.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field978 == var10.field978) {
               this.field979 = var10.field979;
               this.field973 = var10.field973;
               return;
            }
         }

         if(var8 && this.field978.frameStep != -1) {
            this.field979 = (int)(Math.random() * (double)this.field978.frameIDs.length);
            this.field973 -= (int)(Math.random() * (double)this.field978.frameLenghts[this.field979]);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1393660367"
   )
   static int method929(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = FaceNormal.method1932(class32.field743[--class30.field713]);
      } else {
         var3 = var2?class154.field2123:class32.field746;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class32.field743[--class30.field713] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3261(var4, class32.scriptStringStack[--class32.scriptStringStackSize]);
            return 1;
         } else {
            --class32.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class30.field713 -= 2;
         var4 = class32.field743[class30.field713];
         int var5 = class32.field743[class30.field713 + 1];
         var3.parent = class118.method2354(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2297 = class32.field743[--class30.field713] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2295 = class32.field743[--class30.field713];
         return 1;
      } else if(var0 == 1304) {
         var3.field2223 = class32.field743[--class30.field713];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class32.scriptStringStack[--class32.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.field2328 = class32.scriptStringStack[--class32.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
