import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class51 implements class103 {
   @ObfuscatedName("nz")
   @ObfuscatedSignature(
      signature = "Ljb;"
   )
   static class276 field654;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ldi;",
      garbageValue = "-1918466972"
   )
   public AbstractSoundSystem vmethod1850() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "75"
   )
   public static void method743() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "264723163"
   )
   static int method746(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
         class83.intStack[++BufferProvider.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
         if(var3.itemId != -1) {
            class83.intStack[++BufferProvider.intStackSize - 1] = var3.itemQuantity;
         } else {
            class83.intStack[++BufferProvider.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class83.intStack[--BufferProvider.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class83.intStack[++BufferProvider.intStackSize - 1] = 1;
         } else {
            class83.intStack[++BufferProvider.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class83.intStack[++BufferProvider.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "-112"
   )
   static int method745(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class83.intStack[--BufferProvider.intStackSize];
         class83.intStack[++BufferProvider.intStackSize - 1] = Client.grandExchangeOffers[var3].method96();
         return 1;
      } else if(var0 == 3904) {
         var3 = class83.intStack[--BufferProvider.intStackSize];
         class83.intStack[++BufferProvider.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class83.intStack[--BufferProvider.intStackSize];
         class83.intStack[++BufferProvider.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class83.intStack[--BufferProvider.intStackSize];
         class83.intStack[++BufferProvider.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class83.intStack[--BufferProvider.intStackSize];
         class83.intStack[++BufferProvider.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class83.intStack[--BufferProvider.intStackSize];
         class83.intStack[++BufferProvider.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++BufferProvider.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++BufferProvider.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++BufferProvider.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++BufferProvider.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class83.intStack[--BufferProvider.intStackSize] == 1;
               if(InvType.field3251 != null) {
                  InvType.field3251.method70(class13.field263, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class83.intStack[--BufferProvider.intStackSize] == 1;
               if(InvType.field3251 != null) {
                  InvType.field3251.method70(class13.field265, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               BufferProvider.intStackSize -= 2;
               var13 = class83.intStack[BufferProvider.intStackSize] == 1;
               boolean var4 = 1 == class83.intStack[BufferProvider.intStackSize + 1];
               if(InvType.field3251 != null) {
                  InvType.field3251.method70(new class95(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class83.intStack[--BufferProvider.intStackSize] == 1;
               if(InvType.field3251 != null) {
                  InvType.field3251.method70(class13.field264, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class83.intStack[--BufferProvider.intStackSize] == 1;
               if(InvType.field3251 != null) {
                  InvType.field3251.method70(class13.field267, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class83.intStack[++BufferProvider.intStackSize - 1] = InvType.field3251 == null?0:InvType.field3251.field266.size();
               return 1;
            } else {
               class14 var11;
               if(var0 == 3920) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var11 = (class14)InvType.field3251.field266.get(var3);
                  class83.intStack[++BufferProvider.intStackSize - 1] = var11.field278;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var11 = (class14)InvType.field3251.field266.get(var3);
                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var11.method82();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var11 = (class14)InvType.field3251.field266.get(var3);
                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var11.method73();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var11 = (class14)InvType.field3251.field266.get(var3);
                  long var5 = class157.currentTimeMs() - class14.field280 - var11.field275;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var11 = (class14)InvType.field3251.field266.get(var3);
                  class83.intStack[++BufferProvider.intStackSize - 1] = var11.field276.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var11 = (class14)InvType.field3251.field266.get(var3);
                  class83.intStack[++BufferProvider.intStackSize - 1] = var11.field276.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var11 = (class14)InvType.field3251.field266.get(var3);
                  class83.intStack[++BufferProvider.intStackSize - 1] = var11.field276.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lho;IB)Ljava/lang/String;",
      garbageValue = "90"
   )
   static String method747(Widget var0, int var1) {
      return !class98.method1779(class60.getWidgetConfig(var0), var1) && var0.field2717 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
