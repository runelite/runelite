import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("g")
   Object[] field2708;
   @ObfuscatedName("c")
   int[] field2709;
   @ObfuscatedName("n")
   int[] field2710;
   @ObfuscatedName("u")
   int[] field2711;
   @ObfuscatedName("t")
   int[] field2712;
   @ObfuscatedName("r")
   static class122 field2713;
   @ObfuscatedName("p")
   int[] field2714;
   @ObfuscatedName("z")
   int[][] field2715;
   @ObfuscatedName("l")
   int[][] field2716;
   @ObfuscatedName("v")
   class143[] field2717;
   @ObfuscatedName("q")
   class143 field2719;
   @ObfuscatedName("e")
   boolean field2720;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1730627271
   )
   public int field2721;
   @ObfuscatedName("k")
   boolean field2722;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1144827271
   )
   int field2723;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -659346695
   )
   static int field2724;
   @ObfuscatedName("w")
   Object[][] field2725;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -1051945291
   )
   protected static int field2726;

   static {
      field2713 = new class122();
      field2724 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "242218521"
   )
   public int method3296(String var1) {
      var1 = var1.toLowerCase();
      return this.field2719.method2751(class114.method2208(var1));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1000804726"
   )
   public boolean method3297(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2725.length && this.field2725[var1] != null && var2 >= 0 && var2 < this.field2725[var1].length) {
         if(this.field2725[var1][var2] != null) {
            return true;
         } else if(this.field2708[var1] != null) {
            return true;
         } else {
            this.vmethod3384(var1);
            return this.field2708[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1148653296"
   )
   public boolean method3298(int var1) {
      if(this.field2708[var1] != null) {
         return true;
      } else {
         this.vmethod3384(var1);
         return this.field2708[var1] != null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2127396309"
   )
   public boolean method3299() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2709.length; ++var2) {
         int var3 = this.field2709[var2];
         if(this.field2708[var3] == null) {
            this.vmethod3384(var3);
            if(this.field2708[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1252144004"
   )
   public byte[] method3300(int var1) {
      if(this.field2725.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2725[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1523499109"
   )
   public byte[] method3301(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2725.length && this.field2725[var1] != null && var2 >= 0 && var2 < this.field2725[var1].length) {
         if(this.field2725[var1][var2] == null) {
            boolean var3 = this.method3313(var1, (int[])null);
            if(!var3) {
               this.vmethod3384(var1);
               var3 = this.method3313(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = FaceNormal.method1906(this.field2725[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-608185415"
   )
   void vmethod3384(int var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-356794397"
   )
   public int[] method3304(int var1) {
      return this.field2715[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2079073622"
   )
   public int method3305(int var1) {
      return this.field2725[var1].length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1646317832"
   )
   public int method3306() {
      return this.field2725.length;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-116"
   )
   public byte[] method3307(int var1) {
      if(this.field2725.length == 1) {
         return this.method3301(0, var1);
      } else if(this.field2725[var1].length == 1) {
         return this.method3301(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field2722 = var1;
      this.field2720 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-3259"
   )
   public void method3309() {
      for(int var1 = 0; var1 < this.field2725.length; ++var1) {
         if(this.field2725[var1] != null) {
            for(int var2 = 0; var2 < this.field2725[var1].length; ++var2) {
               this.field2725[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "84"
   )
   public int method3310(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2717[var1].method2751(class114.method2208(var2));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-814558231"
   )
   public byte[] method3311(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2719.method2751(class114.method2208(var1));
      int var4 = this.field2717[var3].method2751(class114.method2208(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1028317335"
   )
   public boolean method3312(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2719.method2751(class114.method2208(var1));
      int var4 = this.field2717[var3].method2751(class114.method2208(var2));
      return this.method3297(var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "2063203860"
   )
   boolean method3313(int var1, int[] var2) {
      if(this.field2708[var1] == null) {
         return false;
      } else {
         int var3 = this.field2711[var1];
         int[] var4 = this.field2715[var1];
         Object[] var5 = this.field2725[var1];
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
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = FaceNormal.method1906(this.field2708[var1], false);
            } else {
               var18 = FaceNormal.method1906(this.field2708[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2592(var2, 5, var8.payload.length);
            }

            byte[] var20 = class170.method3184(var18);
            if(this.field2722) {
               this.field2708[var1] = null;
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
                  if(!this.field2720) {
                     var5[var4[var15]] = XClanMember.method257(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2720) {
               var5[var4[0]] = XClanMember.method257(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2033957086"
   )
   void method3317(byte[] var1) {
      int var3 = var1.length;
      int var2 = class3.method41(var1, 0, var3);
      this.field2721 = var2;
      Buffer var4 = new Buffer(class170.method3184(var1));
      int var5 = var4.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.readInt();
         }

         int var6 = var4.readUnsignedByte();
         if(var5 >= 7) {
            this.field2723 = var4.method2494();
         } else {
            this.field2723 = var4.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2709 = new int[this.field2723];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2723; ++var9) {
               this.field2709[var9] = var7 += var4.method2494();
               if(this.field2709[var9] > var8) {
                  var8 = this.field2709[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2723; ++var9) {
               this.field2709[var9] = var7 += var4.readUnsignedShort();
               if(this.field2709[var9] > var8) {
                  var8 = this.field2709[var9];
               }
            }
         }

         this.field2712 = new int[var8 + 1];
         this.field2714 = new int[var8 + 1];
         this.field2711 = new int[var8 + 1];
         this.field2715 = new int[var8 + 1][];
         this.field2708 = new Object[var8 + 1];
         this.field2725 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.field2710 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2723; ++var9) {
               this.field2710[this.field2709[var9]] = var4.readInt();
            }

            this.field2719 = new class143(this.field2710);
         }

         for(var9 = 0; var9 < this.field2723; ++var9) {
            this.field2712[this.field2709[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.field2723; ++var9) {
            this.field2714[this.field2709[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.field2723; ++var9) {
            this.field2711[this.field2709[var9]] = var4.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2723; ++var9) {
               var10 = this.field2709[var9];
               var11 = this.field2711[var10];
               var7 = 0;
               var12 = -1;
               this.field2715[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2715[var10][var13] = var7 += var4.method2494();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2725[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.field2723; ++var9) {
               var10 = this.field2709[var9];
               var11 = this.field2711[var10];
               var7 = 0;
               var12 = -1;
               this.field2715[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2715[var10][var13] = var7 += var4.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2725[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.field2716 = new int[var8 + 1][];
            this.field2717 = new class143[var8 + 1];

            for(var9 = 0; var9 < this.field2723; ++var9) {
               var10 = this.field2709[var9];
               var11 = this.field2711[var10];
               this.field2716[var10] = new int[this.field2725[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2716[var10][this.field2715[var10][var12]] = var4.readInt();
               }

               this.field2717[var10] = new class143(this.field2716[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-507755062"
   )
   public void method3320(int var1) {
      for(int var2 = 0; var2 < this.field2725[var1].length; ++var2) {
         this.field2725[var1][var2] = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "1108034384"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2725.length && this.field2725[var1] != null && var2 >= 0 && var2 < this.field2725[var1].length) {
         if(this.field2725[var1][var2] == null) {
            boolean var4 = this.method3313(var1, var3);
            if(!var4) {
               this.vmethod3384(var1);
               var4 = this.method3313(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = FaceNormal.method1906(this.field2725[var1][var2], false);
         if(this.field2720) {
            this.field2725[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1969486859"
   )
   void vmethod3383(int var1) {
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1751955337"
   )
   public void method3335(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2719.method2751(class114.method2208(var1));
      if(var2 >= 0) {
         this.vmethod3383(var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1681163752"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1662656289"
   )
   public boolean method3352(String var1) {
      int var2 = this.method3296("");
      return var2 != -1?this.method3312("", var1):this.method3312(var1, "");
   }
}
