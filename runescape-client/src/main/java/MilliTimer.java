import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field2195;
   @ObfuscatedName("qr")
   static short[] field2190;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1564258371
   )
   int field2191;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1405868357
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("e")
   long[] field2196;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1631932775
   )
   int field2193;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 7338917908246051617L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1227807485
   )
   int field2189;

   MilliTimer() {
      this.field2196 = new long[10];
      this.field2191 = 256;
      this.sleepTime = 1;
      this.field2193 = 0;
      this.milliTime = class170.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2196[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1323858539"
   )
   public int vmethod3018(int var1, int var2) {
      int var3 = this.field2191;
      int var4 = this.sleepTime;
      this.field2191 = 300;
      this.sleepTime = 1;
      this.milliTime = class170.currentTimeMs();
      if(0L == this.field2196[this.field2189]) {
         this.field2191 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2196[this.field2189]) {
         this.field2191 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2196[this.field2189]));
      }

      if(this.field2191 < 25) {
         this.field2191 = 25;
      }

      if(this.field2191 > 256) {
         this.field2191 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2196[this.field2189]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2196[this.field2189] = this.milliTime;
      this.field2189 = (this.field2189 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2196[var5]) {
               this.field2196[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class41.method585((long)this.sleepTime);

      for(var5 = 0; this.field2193 < 256; this.field2193 += this.field2191) {
         ++var5;
      }

      this.field2193 &= 255;
      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1736198972"
   )
   public void vmethod3017() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2196[var1] = 0L;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "-135795792"
   )
   static int method2955(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class84.intStackSize -= 3;
         var3 = class84.intStack[class84.intStackSize];
         var4 = class84.intStack[class84.intStackSize + 1];
         int var5 = class84.intStack[class84.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class266.method4862(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class269.field3661 = var12;
               } else {
                  DecorativeObject.field2164 = var12;
               }

               class255.method4531(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class269.field3661:DecorativeObject.field2164;
            Widget var10 = class266.method4862(var9.id);
            var10.children[var9.index] = null;
            class255.method4531(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = class266.method4862(class84.intStack[--class84.intStackSize]);
            var9.children = null;
            class255.method4531(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = class266.method4862(class84.intStack[--class84.intStackSize]);
               if(var9 != null) {
                  class84.intStack[++class84.intStackSize - 1] = 1;
                  if(var2) {
                     class269.field3661 = var9;
                  } else {
                     DecorativeObject.field2164 = var9;
                  }
               } else {
                  class84.intStack[++class84.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class84.intStackSize -= 2;
            var3 = class84.intStack[class84.intStackSize];
            var4 = class84.intStack[class84.intStackSize + 1];
            Widget var11 = class24.method183(var3, var4);
            if(var11 != null && var4 != -1) {
               class84.intStack[++class84.intStackSize - 1] = 1;
               if(var2) {
                  class269.field3661 = var11;
               } else {
                  DecorativeObject.field2164 = var11;
               }
            } else {
               class84.intStack[++class84.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1763559788"
   )
   public static final void method2956() {
      while(true) {
         class9 var0 = (class9)class7.field229.method3584();
         if(var0 == null) {
            return;
         }

         var0.vmethod53();
      }
   }
}
