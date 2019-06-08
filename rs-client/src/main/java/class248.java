import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class248 {
   @ObfuscatedName("e")
   @Export("__iu_e")
   static int[] __iu_e;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 662119345
   )
   @Export("__iu_n")
   static int __iu_n;
   @ObfuscatedName("m")
   final HashMap field3267;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   Bounds field3263;
   @ObfuscatedName("q")
   int[] field3271;
   @ObfuscatedName("w")
   int[] field3262;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1072223029
   )
   int field3266;

   public class248() {
      this.field3267 = new HashMap();
      this.field3263 = new Bounds(0, 0);
      this.field3271 = new int[2048];
      this.field3262 = new int[2048];
      this.field3266 = 0;
      Login.method2056();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2027223388"
   )
   void method4716(int var1) {
      int var2 = var1 * 2 + 1;
      double[] var3 = Bounds.method5905(0.0D, (double)((float)var1 / 3.0F), var1);
      double var4 = var3[var1] * var3[var1];
      int[] var6 = new int[var2 * var2];
      boolean var7 = false;

      for(int var8 = 0; var8 < var2; ++var8) {
         for(int var9 = 0; var9 < var2; ++var9) {
            int var10 = var6[var9 + var2 * var8] = (int)(256.0D * (var3[var9] * var3[var8] / var4));
            if(!var7 && var10 > 0) {
               var7 = true;
            }
         }
      }

      Sprite var11 = new Sprite(var6, var2, var2);
      this.field3267.put(Integer.valueOf(var1), var11);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lln;",
      garbageValue = "-1847730067"
   )
   Sprite method4718(int var1) {
      if(!this.field3267.containsKey(Integer.valueOf(var1))) {
         this.method4716(var1);
      }

      return (Sprite)this.field3267.get(Integer.valueOf(var1));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-703491177"
   )
   public final void method4738(int var1, int var2) {
      if(this.field3266 < this.field3271.length) {
         this.field3271[this.field3266] = var1;
         this.field3262[this.field3266] = var2;
         ++this.field3266;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "20019778"
   )
   public final void method4719() {
      this.field3266 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILln;FI)V",
      garbageValue = "1523665695"
   )
   public final void method4720(int var1, int var2, Sprite var3, float var4) {
      int var5 = (int)(18.0F * var4);
      Sprite var6 = this.method4718(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
      Bounds var9 = new Bounds(0, 0);
      this.field3263.__f_488(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3266; ++var10) {
         var11 = this.field3271[var10];
         var12 = this.field3262[var10];
         int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
         int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
         this.field3263.__m_487(var13, var14);
         this.field3263.__q_490(var8, var9);
         this.method4721(var6, var3, var9);
      }

      System.nanoTime();
      System.nanoTime();

      for(var10 = 0; var10 < var3.pixels.length; ++var10) {
         if(var3.pixels[var10] == 0) {
            var3.pixels[var10] = -16777216;
         } else {
            var11 = (var3.pixels[var10] + 64 - 1) / 256;
            if(var11 <= 0) {
               var3.pixels[var10] = -16777216;
            } else {
               if(var11 > __iu_e.length) {
                  var11 = __iu_e.length;
               }

               var12 = __iu_e[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lln;Lln;Lla;B)V",
      garbageValue = "112"
   )
   void method4721(Sprite var1, Sprite var2, Bounds var3) {
      if(var3.__q != 0 && var3.__w != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.__m == 0) {
            var4 = var1.subWidth - var3.__q;
         }

         if(var3.__f == 0) {
            var5 = var1.subHeight - var3.__w;
         }

         int var6 = var4 + var5 * var1.subWidth;
         int var7 = var2.subWidth * var3.__f + var3.__m;

         for(int var8 = 0; var8 < var3.__w; ++var8) {
            for(int var9 = 0; var9 < var3.__q; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.subWidth - var3.__q;
            var7 += var2.subWidth - var3.__q;
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "2033111880"
   )
   static int method4741(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
         return 1;
      } else if(var0 == 3905) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
         return 1;
      } else if(var0 == 3906) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
         return 1;
      } else if(var0 == 3908) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
               if(FloorDecoration.grandExchangeEvents != null) {
                  FloorDecoration.grandExchangeEvents.sort(GrandExchangeEvents.__g_w, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
               if(FloorDecoration.grandExchangeEvents != null) {
                  FloorDecoration.grandExchangeEvents.sort(GrandExchangeEvents.__g_q, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class179.Interpreter_intStackSize -= 2;
               var13 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] == 1;
               boolean var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1] == 1;
               if(FloorDecoration.grandExchangeEvents != null) {
                  Client.__client_sj.__m = var4;
                  FloorDecoration.grandExchangeEvents.sort(Client.__client_sj, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
               if(FloorDecoration.grandExchangeEvents != null) {
                  FloorDecoration.grandExchangeEvents.sort(GrandExchangeEvents.__g_f, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
               if(FloorDecoration.grandExchangeEvents != null) {
                  FloorDecoration.grandExchangeEvents.sort(GrandExchangeEvents.__g_o, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = FloorDecoration.grandExchangeEvents == null?0:FloorDecoration.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)FloorDecoration.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)FloorDecoration.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.__m_3();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)FloorDecoration.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.__f_4();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)FloorDecoration.grandExchangeEvents.events.get(var3);
                  long var5 = class203.currentTimeMs() - class15.__z_si - var11.__f;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)FloorDecoration.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)FloorDecoration.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)FloorDecoration.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
