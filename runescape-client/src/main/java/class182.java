import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public abstract class class182 {
   @ObfuscatedName("r")
   int[] field2707;
   @ObfuscatedName("d")
   int[] field2708;
   @ObfuscatedName("m")
   int[] field2709;
   @ObfuscatedName("h")
   class122 field2710;
   @ObfuscatedName("w")
   int[] field2711;
   @ObfuscatedName("c")
   int[] field2713;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 387005729
   )
   int field2714;
   @ObfuscatedName("y")
   static class153 field2715 = new class153();
   @ObfuscatedName("z")
   class122[] field2716;
   @ObfuscatedName("q")
   Object[] field2717;
   @ObfuscatedName("p")
   int[][] field2718;
   @ObfuscatedName("f")
   boolean field2719;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1449889611
   )
   public int field2720;
   @ObfuscatedName("x")
   boolean field2721;
   @ObfuscatedName("l")
   Object[][] field2722;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1473289593
   )
   static int field2723 = 0;
   @ObfuscatedName("g")
   int[][] field2724;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "1"
   )
   void method3327(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.field2285[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.field2720 = var5;
      Buffer var4 = new Buffer(XGrandExchangeOffer.method50(var1));
      var5 = var4.method3033();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2995();
         }

         var6 = var4.method3033();
         if(var5 >= 7) {
            this.field2714 = var4.method3004();
         } else {
            this.field2714 = var4.method3097();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2708 = new int[this.field2714];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2714; ++var9) {
               this.field2708[var9] = var7 += var4.method3004();
               if(this.field2708[var9] > var8) {
                  var8 = this.field2708[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2714; ++var9) {
               this.field2708[var9] = var7 += var4.method3097();
               if(this.field2708[var9] > var8) {
                  var8 = this.field2708[var9];
               }
            }
         }

         this.field2711 = new int[var8 + 1];
         this.field2707 = new int[1 + var8];
         this.field2713 = new int[1 + var8];
         this.field2718 = new int[var8 + 1][];
         this.field2717 = new Object[var8 + 1];
         this.field2722 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2709 = new int[1 + var8];

            for(var9 = 0; var9 < this.field2714; ++var9) {
               this.field2709[this.field2708[var9]] = var4.method2995();
            }

            this.field2710 = new class122(this.field2709);
         }

         for(var9 = 0; var9 < this.field2714; ++var9) {
            this.field2711[this.field2708[var9]] = var4.method2995();
         }

         for(var9 = 0; var9 < this.field2714; ++var9) {
            this.field2707[this.field2708[var9]] = var4.method2995();
         }

         for(var9 = 0; var9 < this.field2714; ++var9) {
            this.field2713[this.field2708[var9]] = var4.method3097();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2714; ++var9) {
               var10 = this.field2708[var9];
               var11 = this.field2713[var10];
               var7 = 0;
               var12 = -1;
               this.field2718[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2718[var10][var13] = var7 += var4.method3004();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2722[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2714; ++var9) {
               var10 = this.field2708[var9];
               var11 = this.field2713[var10];
               var7 = 0;
               var12 = -1;
               this.field2718[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2718[var10][var13] = var7 += var4.method3097();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2722[var10] = new Object[1 + var12];
            }
         }

         if(var6 != 0) {
            this.field2724 = new int[1 + var8][];
            this.field2716 = new class122[var8 + 1];

            for(var9 = 0; var9 < this.field2714; ++var9) {
               var10 = this.field2708[var9];
               var11 = this.field2713[var10];
               this.field2724[var10] = new int[this.field2722[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2724[var10][this.field2718[var10][var12]] = var4.method2995();
               }

               this.field2716[var10] = new class122(this.field2724[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1993074564"
   )
   void vmethod3425(int var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1685868428"
   )
   public byte[] method3329(int var1, int var2) {
      return this.method3330(var1, var2, (int[])null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-2073188236"
   )
   public byte[] method3330(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2722.length && null != this.field2722[var1] && var2 >= 0 && var2 < this.field2722[var1].length) {
         if(null == this.field2722[var1][var2]) {
            boolean var4 = this.method3387(var1, var3);
            if(!var4) {
               this.vmethod3426(var1);
               var4 = this.method3387(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class48.method892(this.field2722[var1][var2], false);
         if(this.field2719) {
            this.field2722[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2010510478"
   )
   public boolean method3332(int var1) {
      if(this.field2717[var1] != null) {
         return true;
      } else {
         this.vmethod3426(var1);
         return this.field2717[var1] != null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-2130556385"
   )
   public byte[] method3334(int var1) {
      if(this.field2722.length == 1) {
         return this.method3329(0, var1);
      } else if(this.field2722[var1].length == 1) {
         return this.method3329(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "5"
   )
   public byte[] method3335(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2722.length && null != this.field2722[var1] && var2 >= 0 && var2 < this.field2722[var1].length) {
         if(this.field2722[var1][var2] == null) {
            boolean var3 = this.method3387(var1, (int[])null);
            if(!var3) {
               this.vmethod3426(var1);
               var3 = this.method3387(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class48.method892(this.field2722[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-35483383"
   )
   public byte[] method3336(int var1) {
      if(this.field2722.length == 1) {
         return this.method3335(0, var1);
      } else if(this.field2722[var1].length == 1) {
         return this.method3335(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1017851702"
   )
   public int[] method3338(int var1) {
      return this.field2718[var1];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1155909100"
   )
   public int method3339(int var1) {
      return this.field2722[var1].length;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method3342() {
      for(int var1 = 0; var1 < this.field2722.length; ++var1) {
         if(null != this.field2722[var1]) {
            for(int var2 = 0; var2 < this.field2722[var1].length; ++var2) {
               this.field2722[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "2"
   )
   public int method3345(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2716[var1].method2381(class189.method3500(var2));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "38"
   )
   public byte[] method3346(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2710.method2381(class189.method3500(var1));
      int var4 = this.field2716[var3].method2381(class189.method3500(var2));
      return this.method3329(var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1318703916"
   )
   public boolean method3347(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2722.length && null != this.field2722[var1] && var2 >= 0 && var2 < this.field2722[var1].length) {
         if(null != this.field2722[var1][var2]) {
            return true;
         } else if(null != this.field2717[var1]) {
            return true;
         } else {
            this.vmethod3426(var1);
            return this.field2717[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "800241306"
   )
   public boolean method3348(String var1) {
      int var2 = this.method3350("");
      return var2 != -1?this.method3371("", var1):this.method3371(var1, "");
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-48"
   )
   public int method3350(String var1) {
      var1 = var1.toLowerCase();
      return this.field2710.method2381(class189.method3500(var1));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "750002896"
   )
   public void method3354(int var1) {
      for(int var2 = 0; var2 < this.field2722[var1].length; ++var2) {
         this.field2722[var1][var2] = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-839099042"
   )
   void vmethod3426(int var1) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1170220038"
   )
   public int method3360() {
      return this.field2722.length;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-2147433190"
   )
   public boolean method3371(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2710.method2381(class189.method3500(var1));
      int var4 = this.field2716[var3].method2381(class189.method3500(var2));
      return this.method3347(var3, var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1520130514"
   )
   public void method3384(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2710.method2381(class189.method3500(var1));
      if(var2 >= 0) {
         this.vmethod3425(var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-170878360"
   )
   boolean method3387(int var1, int[] var2) {
      if(this.field2717[var1] == null) {
         return false;
      } else {
         int var3 = this.field2713[var1];
         int[] var4 = this.field2718[var1];
         Object[] var5 = this.field2722[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(null == var5[var4[var7]]) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class48.method892(this.field2717[var1], false);
            } else {
               var18 = class48.method892(this.field2717[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2979(var2, 5, var8.payload.length);
            }

            byte[] var20 = XGrandExchangeOffer.method50(var18);
            if(this.field2721) {
               this.field2717[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= 4 * var3 * var10;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2995();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2995();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2719) {
                     var5[var4[var15]] = TextureProvider.method1484(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2719) {
               var5[var4[0]] = TextureProvider.method1484(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   class182(boolean var1, boolean var2) {
      this.field2721 = var1;
      this.field2719 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "255"
   )
   public boolean method3394() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2708.length; ++var2) {
         int var3 = this.field2708[var2];
         if(null == this.field2717[var3]) {
            this.vmethod3426(var3);
            if(this.field2717[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "549454488"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3046.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class182 var3 = class231.field3281;
         class182 var4 = Sequence.field3044;
         boolean var5 = true;
         int[] var6 = var3.method3338(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3335(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3335(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(null != var2) {
            Sequence.field3046.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "488601131"
   )
   static void method3405() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2414(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2409()) {
         int var1 = var0.id;
         if(class60.method1127(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2068;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class5.method79(var4);
               if(null != var5) {
                  Tile.method1577(var5);
               }
            }
         }
      }

   }
}
