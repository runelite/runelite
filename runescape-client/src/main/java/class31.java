import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public final class class31 extends Renderable {
   @ObfuscatedName("j")
   boolean field715 = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1512014295
   )
   int field716;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 411892525
   )
   int field717;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1296019509
   )
   int field718 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1424217205
   )
   int field719;
   @ObfuscatedName("d")
   Sequence field720;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 330606527
   )
   int field722 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1099897495
   )
   int field723;
   @ObfuscatedName("ru")
   protected static String field726;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 903659435
   )
   int field727;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1835961349
   )
   int field730;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-304340218"
   )
   final void method663(int var1) {
      if(!this.field715) {
         this.field722 += var1;

         while(this.field722 > this.field720.field1019[this.field718]) {
            this.field722 -= this.field720.field1019[this.field718];
            ++this.field718;
            if(this.field718 >= this.field720.field1011.length) {
               this.field715 = true;
               break;
            }
         }

      }
   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field727 = var1;
      this.field716 = var2;
      this.field717 = var3;
      this.field723 = var4;
      this.field719 = var5;
      this.field730 = var6 + var7;
      int var8 = Sequence.method929(this.field727).field1033;
      if(var8 != -1) {
         this.field715 = false;
         this.field720 = class192.getAnimation(var8);
      } else {
         this.field715 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1050401255"
   )
   protected final Model getModel() {
      class45 var1 = Sequence.method929(this.field727);
      Model var2;
      if(!this.field715) {
         var2 = var1.method935(this.field718);
      } else {
         var2 = var1.method935(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-28"
   )
   static final void method666() {
      for(int var0 = 0; var0 < Client.field542; ++var0) {
         --Client.field545[var0];
         if(Client.field545[var0] >= -10) {
            class61 var1 = Client.field554[var0];
            if(null == var1) {
               Object var10000 = null;
               var1 = class61.method1293(class109.field1929, Client.field543[var0], 0);
               if(null == var1) {
                  continue;
               }

               Client.field545[var0] += var1.method1285();
               Client.field554[var0] = var1;
            }

            if(Client.field545[var0] < 0) {
               int var2;
               if(Client.field546[var0] != 0) {
                  int var3 = 128 * (Client.field546[var0] & 255);
                  int var4 = Client.field546[var0] >> 16 & 255;
                  int var5 = 64 + var4 * 128 - class138.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field546[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - class138.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field545[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field408 / var3;
               } else {
                  var2 = Client.field547;
               }

               if(var2 > 0) {
                  class65 var10 = var1.method1284().method1325(class127.field2079);
                  class67 var11 = class67.method1347(var10, 100, var2);
                  var11.method1376(Client.field544[var0] - 1);
                  class0.field11.method1177(var11);
               }

               Client.field545[var0] = -100;
            }
         } else {
            --Client.field542;

            for(int var9 = var0; var9 < Client.field542; ++var9) {
               Client.field543[var9] = Client.field543[var9 + 1];
               Client.field554[var9] = Client.field554[1 + var9];
               Client.field544[var9] = Client.field544[var9 + 1];
               Client.field545[var9] = Client.field545[1 + var9];
               Client.field546[var9] = Client.field546[var9 + 1];
            }

            --var0;
         }
      }

      if(Client.field539) {
         boolean var12;
         if(class186.field3010 != 0) {
            var12 = true;
         } else {
            var12 = class186.field3013.method3631();
         }

         if(!var12) {
            if(Client.field513 != 0 && Client.field538 != -1) {
               GroundObject.method2209(Client.field476, Client.field538, 0, Client.field513, false);
            }

            Client.field539 = false;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2132037162"
   )
   static final int method669(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (15731 * var2 * var2 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "-1044333267"
   )
   static String method670(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class40.method801(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class10.field181 != null) {
               var7 = class13.method159(class10.field181.field2268);
               if(class10.field181.field2270 != null) {
                  var7 = (String)class10.field181.field2270;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-2084050071"
   )
   public static void method671(class170 var0) {
      class48.field1071 = var0;
   }
}
