import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public enum class222 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2808(0, 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2809(1, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2814(2, 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2822(3, 0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2812(9, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2813(4, 1),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2818(5, 1),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2819(6, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2816(7, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2817(8, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2831(12, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2820(13, 2),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2823(14, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2821(15, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2827(16, 2),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2815(17, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2824(18, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2825(19, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2826(20, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2811(21, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2828(10, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2829(11, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   field2830(22, 3);

   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1608126215
   )
   public final int field2810;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class222(int var3, int var4) {
      this.field2810 = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field2810;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "617396281"
   )
   public static void method4083(int var0) {
      if(class204.field2507 != 0) {
         class204.field2504 = var0;
      } else {
         class204.field2501.method3689(var0);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-390611027"
   )
   static int method4084(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class84.intStack[--class84.intStackSize];
         class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var3].method101();
         return 1;
      } else if(var0 == 3904) {
         var3 = class84.intStack[--class84.intStackSize];
         class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class84.intStack[--class84.intStackSize];
         class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class84.intStack[--class84.intStackSize];
         class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class84.intStack[--class84.intStackSize];
         class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class84.intStack[--class84.intStackSize];
         class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class84.intStack[--class84.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method100();
            class84.intStack[++class84.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class84.intStack[--class84.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method100();
            class84.intStack[++class84.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class84.intStack[--class84.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method100();
            class84.intStack[++class84.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class84.intStack[--class84.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method100();
            class84.intStack[++class84.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class84.intStack[--class84.intStackSize] == 1;
               if(class61.field779 != null) {
                  class61.field779.method76(class13.field276, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class84.intStack[--class84.intStackSize] == 1;
               if(class61.field779 != null) {
                  class61.field779.method76(class13.field283, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class84.intStackSize -= 2;
               var13 = class84.intStack[class84.intStackSize] == 1;
               boolean var4 = class84.intStack[class84.intStackSize + 1] == 1;
               if(class61.field779 != null) {
                  class61.field779.method76(new class96(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class84.intStack[--class84.intStackSize] == 1;
               if(class61.field779 != null) {
                  class61.field779.method76(class13.field274, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class84.intStack[--class84.intStackSize] == 1;
               if(class61.field779 != null) {
                  class61.field779.method76(class13.field275, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class84.intStack[++class84.intStackSize - 1] = class61.field779 == null?0:class61.field779.field282.size();
               return 1;
            } else {
               class14 var11;
               if(var0 == 3920) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var11 = (class14)class61.field779.field282.get(var3);
                  class84.intStack[++class84.intStackSize - 1] = var11.field293;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var11 = (class14)class61.field779.field282.get(var3);
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var11.method85();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var11 = (class14)class61.field779.field282.get(var3);
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var11.method82();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var11 = (class14)class61.field779.field282.get(var3);
                  long var5 = class74.currentTimeMs() - class29.field429 - var11.field286;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var11 = (class14)class61.field779.field282.get(var3);
                  class84.intStack[++class84.intStackSize - 1] = var11.field291.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var11 = (class14)class61.field779.field282.get(var3);
                  class84.intStack[++class84.intStackSize - 1] = var11.field291.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var11 = (class14)class61.field779.field282.get(var3);
                  class84.intStack[++class84.intStackSize - 1] = var11.field291.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
