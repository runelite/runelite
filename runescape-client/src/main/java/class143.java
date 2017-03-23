import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class143 extends class68 {
   @ObfuscatedName("u")
   class51 field2023 = new class51();
   @ObfuscatedName("i")
   Deque field2024 = new Deque();
   @ObfuscatedName("f")
   class139 field2027;

   class143(class139 var1) {
      this.field2027 = var1;
   }

   @ObfuscatedName("n")
   protected class68 vmethod2753() {
      class140 var1;
      do {
         var1 = (class140)this.field2024.method2472();
         if(var1 == null) {
            return null;
         }
      } while(var1.field1993 == null);

      return var1.field1993;
   }

   @ObfuscatedName("w")
   protected void vmethod2755(int[] var1, int var2, int var3) {
      this.field2023.vmethod2755(var1, var2, var3);

      for(class140 var6 = (class140)this.field2024.method2464(); null != var6; var6 = (class140)this.field2024.method2472()) {
         if(!this.field2027.method2587(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1994) {
                  this.method2757(var6, var1, var4, var5, var5 + var4);
                  var6.field1994 -= var5;
                  break;
               }

               this.method2757(var6, var1, var4, var6.field1994, var5 + var4);
               var4 += var6.field1994;
               var5 -= var6.field1994;
            } while(!this.field2027.method2588(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("s")
   protected void vmethod2756(int var1) {
      this.field2023.vmethod2756(var1);

      for(class140 var3 = (class140)this.field2024.method2464(); var3 != null; var3 = (class140)this.field2024.method2472()) {
         if(!this.field2027.method2587(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1994) {
                  this.method2758(var3, var2);
                  var3.field1994 -= var2;
                  break;
               }

               this.method2758(var3, var3.field1994);
               var2 -= var3.field1994;
            } while(!this.field2027.method2588(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIIB)V",
      garbageValue = "-48"
   )
   void method2757(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2027.field1958[var1.field1990] & 4) != 0 && var1.field1983 < 0) {
         int var6 = this.field2027.field1963[var1.field1990] / class57.field1077;

         while(true) {
            int var7 = (1048575 + var6 - var1.field1996) / var6;
            if(var7 > var4) {
               var1.field1996 += var6 * var4;
               break;
            }

            var1.field1993.vmethod2755(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1996 += var7 * var6 - 1048576;
            int var8 = class57.field1077 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1993;
            if(this.field2027.field1969[var1.field1990] == 0) {
               var1.field1993 = class66.method1266(var1.field1986, var10.method1226(), var10.method1341(), var10.method1219());
            } else {
               var1.field1993 = class66.method1266(var1.field1986, var10.method1226(), 0, var10.method1219());
               this.field2027.method2574(var1, var1.field1976.field2013[var1.field1980] < 0);
               var1.field1993.method1223(var8, var10.method1341());
            }

            if(var1.field1976.field2013[var1.field1980] < 0) {
               var1.field1993.method1217(-1);
            }

            var10.method1246(var8);
            var10.vmethod2755(var2, var3, var5 - var3);
            if(var10.method1227()) {
               this.field2023.method942(var10);
            }
         }
      }

      var1.field1993.vmethod2755(var2, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass140;IB)V",
      garbageValue = "52"
   )
   void method2758(class140 var1, int var2) {
      if((this.field2027.field1958[var1.field1990] & 4) != 0 && var1.field1983 < 0) {
         int var3 = this.field2027.field1963[var1.field1990] / class57.field1077;
         int var4 = (1048575 + var3 - var1.field1996) / var3;
         var1.field1996 = var3 * var2 + var1.field1996 & 1048575;
         if(var4 <= var2) {
            if(this.field2027.field1969[var1.field1990] == 0) {
               var1.field1993 = class66.method1266(var1.field1986, var1.field1993.method1226(), var1.field1993.method1341(), var1.field1993.method1219());
            } else {
               var1.field1993 = class66.method1266(var1.field1986, var1.field1993.method1226(), 0, var1.field1993.method1219());
               this.field2027.method2574(var1, var1.field1976.field2013[var1.field1980] < 0);
            }

            if(var1.field1976.field2013[var1.field1980] < 0) {
               var1.field1993.method1217(-1);
            }

            var2 = var1.field1996 / var3;
         }
      }

      var1.field1993.vmethod2756(var2);
   }

   @ObfuscatedName("m")
   protected int vmethod2766() {
      return 0;
   }

   @ObfuscatedName("l")
   protected class68 vmethod2768() {
      class140 var1 = (class140)this.field2024.method2464();
      return (class68)(null == var1?null:(var1.field1993 != null?var1.field1993:this.vmethod2753()));
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static final void method2771() {
      class22.method197(Client.field476);
      ++class44.field912;
      if(Client.field484 && Client.field481) {
         int var0 = class115.field1817;
         int var1 = class115.field1818;
         var0 -= Client.field478;
         var1 -= Client.field479;
         if(var0 < Client.field324) {
            var0 = Client.field324;
         }

         if(Client.field476.width + var0 > Client.field477.width + Client.field324) {
            var0 = Client.field324 + Client.field477.width - Client.field476.width;
         }

         if(var1 < Client.field483) {
            var1 = Client.field483;
         }

         if(var1 + Client.field476.height > Client.field477.height + Client.field483) {
            var1 = Client.field483 + Client.field477.height - Client.field476.height;
         }

         int var2 = var0 - Client.field454;
         int var3 = var1 - Client.field491;
         int var4 = Client.field476.field2295;
         if(class44.field912 > Client.field476.field2223 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field487 = true;
         }

         int var5 = var0 - Client.field324 + Client.field477.scrollX;
         int var6 = Client.field477.scrollY + (var1 - Client.field483);
         class18 var7;
         if(null != Client.field476.field2308 && Client.field487) {
            var7 = new class18();
            var7.field207 = Client.field476;
            var7.field198 = var5;
            var7.field201 = var6;
            var7.field199 = Client.field476.field2308;
            class26.method565(var7);
         }

         if(class115.field1811 == 0) {
            if(Client.field487) {
               if(Client.field476.field2310 != null) {
                  var7 = new class18();
                  var7.field207 = Client.field476;
                  var7.field198 = var5;
                  var7.field201 = var6;
                  var7.field203 = Client.field480;
                  var7.field199 = Client.field476.field2310;
                  class26.method565(var7);
               }

               if(Client.field480 != null && DecorativeObject.method1956(Client.field476) != null) {
                  Client.secretCipherBuffer1.putOpcode(85);
                  Client.secretCipherBuffer1.method2895(Client.field480.item);
                  Client.secretCipherBuffer1.putShort(Client.field476.index);
                  Client.secretCipherBuffer1.method2909(Client.field480.id);
                  Client.secretCipherBuffer1.method2900(Client.field476.item);
                  Client.secretCipherBuffer1.method2973(Client.field480.index);
                  Client.secretCipherBuffer1.method2908(Client.field476.id);
               }
            } else {
               int var11 = World.method635();
               if(Client.menuOptionCount > 2 && (Client.field439 == 1 && !class187.method3495() || class177.method3324(var11))) {
                  class41.method815(Client.field454 + Client.field478, Client.field491 + Client.field479);
               } else if(Client.menuOptionCount > 0) {
                  int var8 = Client.field454 + Client.field478;
                  int var9 = Client.field491 + Client.field479;
                  class38 var10 = GameObject.field1645;
                  Item.menuAction(var10.field820, var10.field816, var10.field817, var10.field818, var10.field819, var10.field819, var8, var9);
                  GameObject.field1645 = null;
               }
            }

            Client.field476 = null;
         }

      } else {
         if(class44.field912 > 1) {
            Client.field476 = null;
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1706793581"
   )
   public static String method2782(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = DecorativeObject.method1955(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
