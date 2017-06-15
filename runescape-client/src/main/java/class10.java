import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public final class class10 extends class9 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 519706483
   )
   final int field256;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 942166233
   )
   final int field257;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1809797043
   )
   final int field258;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1041797315
   )
   final int field259;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1243762901
   )
   final int field261;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2016354523
   )
   final int field262;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2016378267
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1072603023
   )
   final int field266;
   @ObfuscatedName("av")
   static int[] field268;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   public final void vmethod55() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field266:this.field256;
         int var2 = (var4 & 2) == 0?this.field257:this.field262;
         int var3 = (var4 & 4) == 0?this.field258:this.field261;
         if((var4 & 1) == 0) {
            class109.method1949(var1, var2, var3, this.field256, var2, var3, this.field259);
         }

         if((var4 & 2) == 0) {
            class109.method1949(var1, var2, var3, var1, this.field262, var3, this.field259);
         }

         if((var4 & 4) == 0) {
            class109.method1949(var1, var2, var3, var1, var2, this.field261, this.field259);
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(LModel;IIII)V",
      garbageValue = "-65281"
   )
   public class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field266 = var1.field1955 + var2 - var1.field1958;
      this.field257 = var3 + var1.field1956 - var1.field1959;
      this.field258 = var4 + var1.field1957 - var1.field1928;
      this.field256 = var1.field1958 + var2 + var1.field1955;
      this.field262 = var3 + var1.field1956 + var1.field1959;
      this.field261 = var1.field1957 + var4 + var1.field1928;
      this.field259 = var5;
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "1182131533"
   )
   static void method57(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = GameEngine.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1242 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1244 = 0;
         }

         if(var3 == 2) {
            var0.field1244 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || GameEngine.getAnimation(var1).forcedPriority >= GameEngine.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1242 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1244 = 0;
         var0.field1267 = var0.queueSize;
      }

   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1515121386"
   )
   static void method58(int var0) {
      class243.field3325 = new class89();
      class243.field3325.field1386 = Client.menuActionParams0[var0];
      class243.field3325.field1387 = Client.menuActionParams1[var0];
      class243.field3325.field1388 = Client.menuTypes[var0];
      class243.field3325.field1389 = Client.menuIdentifiers[var0];
      class243.field3325.field1392 = Client.menuOptions[var0];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1830600342"
   )
   static int method59(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].method114();
         return 1;
      } else if(var0 == 3904) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method113();
            class83.intStack[++class83.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method113();
            class83.intStack[++class83.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method113();
            class83.intStack[++class83.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method113();
            class83.intStack[++class83.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(Client.field1181 != null) {
                  Client.field1181.method79(class13.field285, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(Client.field1181 != null) {
                  Client.field1181.method79(class13.field283, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class83.intStackSize -= 2;
               var13 = class83.intStack[class83.intStackSize] == 1;
               boolean var4 = class83.intStack[class83.intStackSize + 1] == 1;
               if(Client.field1181 != null) {
                  Client.field1181.method79(new class95(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(Client.field1181 != null) {
                  Client.field1181.method79(class13.field282, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(Client.field1181 != null) {
                  Client.field1181.method79(class13.field288, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class83.intStack[++class83.intStackSize - 1] = Client.field1181 == null?0:Client.field1181.field287.size();
               return 1;
            } else {
               class14 var11;
               if(var0 == 3920) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)Client.field1181.field287.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field297;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)Client.field1181.field287.get(var3);
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var11.method81();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)Client.field1181.field287.get(var3);
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var11.method80();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)Client.field1181.field287.get(var3);
                  long var5 = class166.method2970() - Tile.field1921 - var11.field291;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class83.scriptStringStack[++class24.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)Client.field1181.field287.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field292.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)Client.field1181.field287.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field292.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)Client.field1181.field287.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field292.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
