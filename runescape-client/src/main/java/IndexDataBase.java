import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("r")
   int[] field2724;
   @ObfuscatedName("i")
   int[] field2725;
   @ObfuscatedName("o")
   int[] field2726;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 442068875
   )
   int field2727;
   @ObfuscatedName("h")
   class122 field2728;
   @ObfuscatedName("p")
   boolean field2729;
   @ObfuscatedName("l")
   int[] field2730;
   @ObfuscatedName("m")
   int[][] field2732;
   @ObfuscatedName("w")
   class122[] field2733;
   @ObfuscatedName("j")
   Object[] field2734;
   @ObfuscatedName("s")
   Object[][] field2735;
   @ObfuscatedName("q")
   static class146 field2736 = new class146();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -626616507
   )
   public int field2737;
   @ObfuscatedName("n")
   int[][] field2738;
   @ObfuscatedName("y")
   boolean field2739;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1524118619
   )
   static int field2740 = 0;
   @ObfuscatedName("u")
   int[] field2741;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void vmethod3422(int var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-803678472"
   )
   public byte[] method3337(int var1) {
      if(this.field2735.length == 1) {
         return this.method3371(0, var1);
      } else if(this.field2735[var1].length == 1) {
         return this.method3371(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "139731796"
   )
   public boolean method3338(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2735.length && null != this.field2735[var1] && var2 >= 0 && var2 < this.field2735[var1].length) {
         if(null != this.field2735[var1][var2]) {
            return true;
         } else if(null != this.field2734[var1]) {
            return true;
         } else {
            this.vmethod3419(var1);
            return this.field2734[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2024928714"
   )
   void vmethod3419(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1190309711"
   )
   public int[] method3345(int var1) {
      return this.field2738[var1];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "129123022"
   )
   public int method3346(int var1) {
      return this.field2735[var1].length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1198647128"
   )
   public void method3348(int var1) {
      for(int var2 = 0; var2 < this.field2735[var1].length; ++var2) {
         this.field2735[var1][var2] = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1211605651"
   )
   public void method3349() {
      for(int var1 = 0; var1 < this.field2735.length; ++var1) {
         if(null != this.field2735[var1]) {
            for(int var2 = 0; var2 < this.field2735[var1].length; ++var2) {
               this.field2735[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "1"
   )
   public int method3351(String var1) {
      var1 = var1.toLowerCase();
      return this.field2728.method2393(XGrandExchangeOffer.method55(var1));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "32"
   )
   public int method3352(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2733[var1].method2393(XGrandExchangeOffer.method55(var2));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "19136896"
   )
   public byte[] method3353(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2728.method2393(XGrandExchangeOffer.method55(var1));
      int var4 = this.field2733[var3].method2393(XGrandExchangeOffer.method55(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-31479180"
   )
   public boolean method3354(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2728.method2393(XGrandExchangeOffer.method55(var1));
      int var4 = this.field2733[var3].method2393(XGrandExchangeOffer.method55(var2));
      return this.method3338(var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-105"
   )
   public void method3356(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2728.method2393(XGrandExchangeOffer.method55(var1));
      if(var2 >= 0) {
         this.vmethod3422(var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1569930279"
   )
   public int method3357() {
      return this.field2735.length;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   public boolean method3358() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2725.length; ++var2) {
         int var3 = this.field2725[var2];
         if(null == this.field2734[var3]) {
            this.vmethod3419(var3);
            if(null == this.field2734[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1482974870"
   )
   public boolean method3365(String var1) {
      int var2 = this.method3351("");
      return var2 != -1?this.method3354("", var1):this.method3354(var1, "");
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[IB)[B",
      garbageValue = "-25"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2735.length && null != this.field2735[var1] && var2 >= 0 && var2 < this.field2735[var1].length) {
         if(this.field2735[var1][var2] == null) {
            boolean var4 = this.method3397(var1, var3);
            if(!var4) {
               this.vmethod3419(var1);
               var4 = this.method3397(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class37.method763(this.field2735[var1][var2], false);
         if(this.field2739) {
            this.field2735[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1506817126"
   )
   public byte[] method3371(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2735.length && this.field2735[var1] != null && var2 >= 0 && var2 < this.field2735[var1].length) {
         if(null == this.field2735[var1][var2]) {
            boolean var4 = this.method3397(var1, (int[])null);
            if(!var4) {
               this.vmethod3419(var1);
               var4 = this.method3397(var1, (int[])null);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var3 = class37.method763(this.field2735[var1][var2], false);
         return var3;
      } else {
         return null;
      }
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field2729 = var1;
      this.field2739 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1726564169"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-464303859"
   )
   public boolean method3385(int var1) {
      if(this.field2734[var1] != null) {
         return true;
      } else {
         this.vmethod3419(var1);
         return null != this.field2734[var1];
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "1"
   )
   public byte[] method3389(int var1) {
      if(this.field2735.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2735[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2123306939"
   )
   void method3391(byte[] var1) {
      this.field2737 = class119.method2359(var1, var1.length);
      Buffer var2 = new Buffer(class49.method924(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.field2727 = var2.method2881();
         } else {
            this.field2727 = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2725 = new int[this.field2727];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               this.field2725[var7] = var5 += var2.method2881();
               if(this.field2725[var7] > var6) {
                  var6 = this.field2725[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               this.field2725[var7] = var5 += var2.readUnsignedShort();
               if(this.field2725[var7] > var6) {
                  var6 = this.field2725[var7];
               }
            }
         }

         this.field2724 = new int[1 + var6];
         this.field2726 = new int[var6 + 1];
         this.field2730 = new int[var6 + 1];
         this.field2738 = new int[1 + var6][];
         this.field2734 = new Object[var6 + 1];
         this.field2735 = new Object[1 + var6][];
         if(var4 != 0) {
            this.field2741 = new int[1 + var6];

            for(var7 = 0; var7 < this.field2727; ++var7) {
               this.field2741[this.field2725[var7]] = var2.readInt();
            }

            this.field2728 = new class122(this.field2741);
         }

         for(var7 = 0; var7 < this.field2727; ++var7) {
            this.field2724[this.field2725[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field2727; ++var7) {
            this.field2726[this.field2725[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field2727; ++var7) {
            this.field2730[this.field2725[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               var8 = this.field2725[var7];
               var9 = this.field2730[var8];
               var5 = 0;
               var10 = -1;
               this.field2738[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2738[var8][var11] = var5 += var2.method2881();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2735[var8] = new Object[1 + var10];
            }
         } else {
            for(var7 = 0; var7 < this.field2727; ++var7) {
               var8 = this.field2725[var7];
               var9 = this.field2730[var8];
               var5 = 0;
               var10 = -1;
               this.field2738[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2738[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2735[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2732 = new int[var6 + 1][];
            this.field2733 = new class122[var6 + 1];

            for(var7 = 0; var7 < this.field2727; ++var7) {
               var8 = this.field2725[var7];
               var9 = this.field2730[var8];
               this.field2732[var8] = new int[this.field2735[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2732[var8][this.field2738[var8][var10]] = var2.readInt();
               }

               this.field2733[var8] = new class122(this.field2732[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1886978373"
   )
   boolean method3397(int var1, int[] var2) {
      if(this.field2734[var1] == null) {
         return false;
      } else {
         int var3 = this.field2730[var1];
         int[] var4 = this.field2738[var1];
         Object[] var5 = this.field2735[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class37.method763(this.field2734[var1], false);
            } else {
               var18 = class37.method763(this.field2734[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2924(var2, 5, var8.payload.length);
            }

            byte[] var20 = class49.method924(var18);
            if(this.field2729) {
               this.field2734[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var3 * var10 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.readInt();
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
                     var16 += var11.readInt();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2739) {
                     var5[var4[var15]] = Client.method425(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2739) {
               var5[var4[0]] = Client.method425(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "83"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretCipherBuffer2.readUnsignedShort();
         var2 = Client.secretCipherBuffer2.method2904();
         var3 = Client.secretCipherBuffer2.readUnsignedShort();
         class41.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class41.xteaKeys[var4][var5] = Client.secretCipherBuffer2.readInt();
            }
         }

         class25.mapRegions = new int[var3];
         class44.field915 = new int[var3];
         XClanMember.field296 = new int[var3];
         class85.field1484 = new byte[var3][];
         Frames.field1593 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (6 + var1) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class25.mapRegions[var3] = var7;
                  class44.field915[var3] = class205.indexMaps.method3351("m" + var5 + "_" + var6);
                  XClanMember.field296[var3] = class205.indexMaps.method3351("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class5.method61(var2, var1);
      } else {
         var1 = Client.secretCipherBuffer2.method2903();
         var2 = Client.secretCipherBuffer2.method2853();
         var3 = Client.secretCipherBuffer2.readUnsignedShort();
         Client.secretCipherBuffer2.method3102();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.secretCipherBuffer2.method3111(1);
                  if(var7 == 1) {
                     Client.field364[var4][var5][var6] = Client.secretCipherBuffer2.method3111(26);
                  } else {
                     Client.field364[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.secretCipherBuffer2.method3103();
         class41.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class41.xteaKeys[var4][var5] = Client.secretCipherBuffer2.readInt();
            }
         }

         class25.mapRegions = new int[var3];
         class44.field915 = new int[var3];
         XClanMember.field296 = new int[var3];
         class85.field1484 = new byte[var3][];
         Frames.field1593 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field364[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class25.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class25.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class44.field915[var3] = class205.indexMaps.method3351("m" + var11 + "_" + var12);
                        XClanMember.field296[var3] = class205.indexMaps.method3351("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class5.method61(var2, var1);
      }

   }
}
