import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public abstract class class182 {
   @ObfuscatedName("o")
   class122[] field2708;
   @ObfuscatedName("h")
   int[] field2709;
   @ObfuscatedName("i")
   int[][] field2710;
   @ObfuscatedName("p")
   class122 field2711;
   @ObfuscatedName("j")
   int[] field2712;
   @ObfuscatedName("n")
   int[] field2713;
   @ObfuscatedName("v")
   boolean field2714;
   @ObfuscatedName("c")
   int[][] field2715;
   @ObfuscatedName("r")
   int[] field2717;
   @ObfuscatedName("m")
   Object[] field2718;
   @ObfuscatedName("s")
   Object[][] field2719;
   @ObfuscatedName("u")
   static class146 field2720 = new class146();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1935832939
   )
   public int field2721;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -995880537
   )
   int field2722;
   @ObfuscatedName("f")
   boolean field2723;
   @ObfuscatedName("d")
   int[] field2725;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -358626091
   )
   static int field2726 = 0;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "970678481"
   )
   void method3301(byte[] var1) {
      int var3 = var1.length;
      int var5 = -1;

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5 = var5 >>> 8 ^ Buffer.field2096[(var5 ^ var1[var6]) & 255];
      }

      var5 = ~var5;
      this.field2721 = var5;
      Buffer var4 = new Buffer(class16.method188(var1));
      var5 = var4.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.readInt();
         }

         var6 = var4.readUnsignedByte();
         if(var5 >= 7) {
            this.field2722 = var4.method2847();
         } else {
            this.field2722 = var4.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2725 = new int[this.field2722];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               this.field2725[var9] = var7 += var4.method2847();
               if(this.field2725[var9] > var8) {
                  var8 = this.field2725[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               this.field2725[var9] = var7 += var4.readUnsignedShort();
               if(this.field2725[var9] > var8) {
                  var8 = this.field2725[var9];
               }
            }
         }

         this.field2712 = new int[1 + var8];
         this.field2713 = new int[var8 + 1];
         this.field2717 = new int[1 + var8];
         this.field2715 = new int[var8 + 1][];
         this.field2718 = new Object[var8 + 1];
         this.field2719 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2709 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2722; ++var9) {
               this.field2709[this.field2725[var9]] = var4.readInt();
            }

            this.field2711 = new class122(this.field2709);
         }

         for(var9 = 0; var9 < this.field2722; ++var9) {
            this.field2712[this.field2725[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.field2722; ++var9) {
            this.field2713[this.field2725[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.field2722; ++var9) {
            this.field2717[this.field2725[var9]] = var4.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               var10 = this.field2725[var9];
               var11 = this.field2717[var10];
               var7 = 0;
               var12 = -1;
               this.field2715[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2715[var10][var13] = var7 += var4.method2847();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2719[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.field2722; ++var9) {
               var10 = this.field2725[var9];
               var11 = this.field2717[var10];
               var7 = 0;
               var12 = -1;
               this.field2715[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2715[var10][var13] = var7 += var4.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2719[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.field2710 = new int[1 + var8][];
            this.field2708 = new class122[var8 + 1];

            for(var9 = 0; var9 < this.field2722; ++var9) {
               var10 = this.field2725[var9];
               var11 = this.field2717[var10];
               this.field2710[var10] = new int[this.field2719[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2710[var10][this.field2715[var10][var12]] = var4.readInt();
               }

               this.field2708[var10] = new class122(this.field2710[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-708414522"
   )
   void vmethod3393(int var1) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "-252218266"
   )
   public static SpritePixels method3305(class182 var0, int var1, int var2) {
      return !class94.method1979(var0, var1, var2)?null:FileOnDisk.method1485();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "111625334"
   )
   public boolean method3306(int var1) {
      if(this.field2718[var1] != null) {
         return true;
      } else {
         this.vmethod3400(var1);
         return this.field2718[var1] != null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-13"
   )
   public boolean method3307() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2725.length; ++var2) {
         int var3 = this.field2725[var2];
         if(this.field2718[var3] == null) {
            this.vmethod3400(var3);
            if(this.field2718[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1562674117"
   )
   public byte[] method3308(int var1) {
      if(this.field2719.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2719[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-2131080431"
   )
   public byte[] method3310(int var1) {
      if(this.field2719.length == 1) {
         return this.method3365(0, var1);
      } else if(this.field2719[var1].length == 1) {
         return this.method3365(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1987192516"
   )
   void vmethod3400(int var1) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1013893268"
   )
   public int[] method3312(int var1) {
      return this.field2715[var1];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-477874066"
   )
   public int method3313(int var1) {
      return this.field2719[var1].length;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-76903692"
   )
   public int method3314() {
      return this.field2719.length;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-124"
   )
   public void method3315(int var1) {
      for(int var2 = 0; var2 < this.field2719[var1].length; ++var2) {
         this.field2719[var1][var2] = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1920629403"
   )
   public void method3316() {
      for(int var1 = 0; var1 < this.field2719.length; ++var1) {
         if(this.field2719[var1] != null) {
            for(int var2 = 0; var2 < this.field2719[var1].length; ++var2) {
               this.field2719[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1222318517"
   )
   boolean method3317(int var1, int[] var2) {
      if(null == this.field2718[var1]) {
         return false;
      } else {
         int var3 = this.field2717[var1];
         int[] var4 = this.field2715[var1];
         Object[] var5 = this.field2719[var1];
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
            if(null == var2 || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = ChatMessages.method918(this.field2718[var1], false);
            } else {
               var18 = ChatMessages.method918(this.field2718[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2853(var2, 5, var8.payload.length);
            }

            byte[] var20 = class16.method188(var18);
            if(this.field2714) {
               this.field2718[var1] = null;
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
                  if(!this.field2723) {
                     var5[var4[var15]] = Ignore.method205(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2723) {
               var5[var4[0]] = Ignore.method205(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "126336912"
   )
   public int method3319(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2708[var1].method2376(XItemContainer.method159(var2));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-991879867"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1861023404"
   )
   public boolean method3321(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2711.method2376(XItemContainer.method159(var1));
      int var4 = this.field2708[var3].method2376(XItemContainer.method159(var2));
      return this.method3376(var3, var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1797932988"
   )
   public boolean method3322(String var1) {
      int var2 = this.method3335("");
      return var2 != -1?this.method3321("", var1):this.method3321(var1, "");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1400654503"
   )
   public void method3323(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2711.method2376(XItemContainer.method159(var1));
      if(var2 >= 0) {
         this.vmethod3393(var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1525802000"
   )
   static final void method3325() {
      class168.method3208();
      FloorUnderlayDefinition.field2817.reset();
      class165.method3165();
      class26.method607();
      class15.method184();
      class22.method223();
      Actor.method635();
      class107.method2100();
      Varbit.field2852.reset();
      class187.field2779.reset();
      class196.field2870.reset();
      class196.spriteCache.reset();
      class196.field2872.reset();
      CombatInfo2.field2834.reset();
      CombatInfo2.field2835.reset();
      Ignore.method208();
      GameEngine.method2231();
      ((TextureProvider)class84.field1465).method1491();
      Script.field970.reset();
      class20.field228.method3316();
      class1.field23.method3316();
      class116.field1819.method3316();
      Client.field336.method3316();
      Client.field337.method3316();
      class11.field127.method3316();
      class10.field111.method3316();
      class165.field2167.method3316();
      class107.field1738.method3316();
      class38.field821.method3316();
      class150.field2044.method3316();
      class145.field2013.method3316();
   }

   class182(boolean var1, boolean var2) {
      this.field2714 = var1;
      this.field2723 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "414099354"
   )
   public int method3335(String var1) {
      var1 = var1.toLowerCase();
      return this.field2711.method2376(XItemContainer.method159(var1));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-936795427"
   )
   public byte[] method3338(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2711.method2376(XItemContainer.method159(var1));
      int var4 = this.field2708[var3].method2376(XItemContainer.method159(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass187;",
      garbageValue = "-1"
   )
   public static class187 method3356(int var0) {
      class187 var1 = (class187)class187.field2779.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class187.field2777.getConfigData(16, var0);
         var1 = new class187();
         if(var2 != null) {
            var1.method3441(new Buffer(var2));
         }

         class187.field2779.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-2109953695"
   )
   public byte[] method3365(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2719.length && null != this.field2719[var1] && var2 >= 0 && var2 < this.field2719[var1].length) {
         if(null == this.field2719[var1][var2]) {
            boolean var4 = this.method3317(var1, (int[])null);
            if(!var4) {
               this.vmethod3400(var1);
               var4 = this.method3317(var1, (int[])null);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var3 = ChatMessages.method918(this.field2719[var1][var2], false);
         return var3;
      } else {
         return null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "683106726"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2719.length && null != this.field2719[var1] && var2 >= 0 && var2 < this.field2719[var1].length) {
         if(null == this.field2719[var1][var2]) {
            boolean var4 = this.method3317(var1, var3);
            if(!var4) {
               this.vmethod3400(var1);
               var4 = this.method3317(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = ChatMessages.method918(this.field2719[var1][var2], false);
         if(this.field2723) {
            this.field2719[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1660035215"
   )
   public boolean method3376(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2719.length && this.field2719[var1] != null && var2 >= 0 && var2 < this.field2719[var1].length) {
         if(this.field2719[var1][var2] != null) {
            return true;
         } else if(this.field2718[var1] != null) {
            return true;
         } else {
            this.vmethod3400(var1);
            return this.field2718[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "1277623535"
   )
   public static int method3377(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
            var5[var6] = -102;
         } else if(var7 == 8250) {
            var5[var6] = -101;
         } else if(var7 == 339) {
            var5[var6] = -100;
         } else if(var7 == 382) {
            var5[var6] = -98;
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.method2840(var5.length);
      var0.offset += class210.field3126.method2751(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lclass48;",
      garbageValue = "24"
   )
   static Script method3378(int var0) {
      Script var1 = (Script)Script.field970.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class145.field2013.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new Script();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.readInt();
            var1.localIntCount = var3.readUnsignedShort();
            var1.localStringCount = var3.readUnsignedShort();
            var1.intStackCount = var3.readUnsignedShort();
            var1.stringStackCount = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2884();
            var1.instructions = new int[var4];
            var1.intOperands = new int[var4];
            var1.stringOperands = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.instructions[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.stringOperands[var5] = var3.readString();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.intOperands[var5] = var3.readInt();
               } else {
                  var1.intOperands[var5] = var3.readUnsignedByte();
               }
            }

            Script.field970.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IIS)LFont;",
      garbageValue = "512"
   )
   public static Font method3380(class182 var0, class182 var1, int var2, int var3) {
      return !class94.method1979(var0, var2, var3)?null:class196.method3608(var1.getConfigData(var2, var3));
   }
}
