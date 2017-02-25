import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class2 {
   @ObfuscatedName("o")
   static int[] field24;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -7253701343691459277L
   )
   public final long field25;
   @ObfuscatedName("h")
   public final XGrandExchangeOffer field26;
   @ObfuscatedName("j")
   String field27;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -222202129
   )
   public final int field30;
   @ObfuscatedName("p")
   String field32;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "95"
   )
   static final int method19(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class10.tileHeights[var5][var3 + 1][var4] * var6 + (128 - var6) * class10.tileHeights[var5][var3][var4] >> 7;
         int var9 = (128 - var6) * class10.tileHeights[var5][var3][1 + var4] + class10.tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return var7 * var9 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public String method20() {
      return this.field32;
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field32 = var1.readString();
      this.field27 = var1.readString();
      this.field30 = var1.readUnsignedShort();
      this.field25 = var1.method2819();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field26 = new XGrandExchangeOffer();
      this.field26.method44(2);
      this.field26.method45(var2);
      this.field26.price = var4;
      this.field26.totalQuantity = var5;
      this.field26.quantitySold = 0;
      this.field26.spent = 0;
      this.field26.itemId = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1750780545"
   )
   public String method29() {
      return this.field27;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "112666264"
   )
   static int method30(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class32.field747[--class103.field1686];
         class32.field747[++class103.field1686 - 1] = Client.grandExchangeOffers[var3].method43();
         return 1;
      } else if(var0 == 3904) {
         var3 = class32.field747[--class103.field1686];
         class32.field747[++class103.field1686 - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class32.field747[--class103.field1686];
         class32.field747[++class103.field1686 - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class32.field747[--class103.field1686];
         class32.field747[++class103.field1686 - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class32.field747[--class103.field1686];
         class32.field747[++class103.field1686 - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class32.field747[--class103.field1686];
         class32.field747[++class103.field1686 - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var13;
         if(var0 == 3910) {
            var3 = class32.field747[--class103.field1686];
            var13 = Client.grandExchangeOffers[var3].method55();
            class32.field747[++class103.field1686 - 1] = var13 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class32.field747[--class103.field1686];
            var13 = Client.grandExchangeOffers[var3].method55();
            class32.field747[++class103.field1686 - 1] = var13 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class32.field747[--class103.field1686];
            var13 = Client.grandExchangeOffers[var3].method55();
            class32.field747[++class103.field1686 - 1] = var13 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class32.field747[--class103.field1686];
            var13 = Client.grandExchangeOffers[var3].method55();
            class32.field747[++class103.field1686 - 1] = var13 == 1?1:0;
            return 1;
         } else {
            boolean var12;
            if(var0 == 3914) {
               var12 = class32.field747[--class103.field1686] == 1;
               if(null != class105.field1703) {
                  class105.field1703.method14(class1.field20, var12);
               }

               return 1;
            } else if(var0 == 3915) {
               var12 = class32.field747[--class103.field1686] == 1;
               if(class105.field1703 != null) {
                  class105.field1703.method14(class1.field11, var12);
               }

               return 1;
            } else if(var0 == 3916) {
               class103.field1686 -= 2;
               var12 = class32.field747[class103.field1686] == 1;
               boolean var11 = class32.field747[class103.field1686 + 1] == 1;
               if(null != class105.field1703) {
                  class105.field1703.method14(new class44(var11), var12);
               }

               return 1;
            } else if(var0 == 3917) {
               var12 = class32.field747[--class103.field1686] == 1;
               if(class105.field1703 != null) {
                  class105.field1703.method14(class1.field10, var12);
               }

               return 1;
            } else if(var0 == 3918) {
               var12 = class32.field747[--class103.field1686] == 1;
               if(null != class105.field1703) {
                  class105.field1703.method14(class1.field13, var12);
               }

               return 1;
            } else if(var0 == 3919) {
               class32.field747[++class103.field1686 - 1] = null == class105.field1703?0:class105.field1703.field9.size();
               return 1;
            } else {
               class2 var4;
               if(var0 == 3920) {
                  var3 = class32.field747[--class103.field1686];
                  var4 = (class2)class105.field1703.field9.get(var3);
                  class32.field747[++class103.field1686 - 1] = var4.field30;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class32.field747[--class103.field1686];
                  var4 = (class2)class105.field1703.field9.get(var3);
                  class32.chatboxSegments[++class32.field749 - 1] = var4.method20();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class32.field747[--class103.field1686];
                  var4 = (class2)class105.field1703.field9.get(var3);
                  class32.chatboxSegments[++class32.field749 - 1] = var4.method29();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class32.field747[--class103.field1686];
                  var4 = (class2)class105.field1703.field9.get(var3);
                  long var5 = class0.method11() - class33.field766 - var4.field25;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(3600000 * var7) - (long)('\uea60' * var8)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class32.chatboxSegments[++class32.field749 - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class32.field747[--class103.field1686];
                  var4 = (class2)class105.field1703.field9.get(var3);
                  class32.field747[++class103.field1686 - 1] = var4.field26.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class32.field747[--class103.field1686];
                  var4 = (class2)class105.field1703.field9.get(var3);
                  class32.field747[++class103.field1686 - 1] = var4.field26.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class32.field747[--class103.field1686];
                  var4 = (class2)class105.field1703.field9.get(var3);
                  class32.field747[++class103.field1686 - 1] = var4.field26.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
