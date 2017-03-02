import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public abstract class class182 {
   @ObfuscatedName("r")
   class122[] field2706;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -975877879
   )
   int field2707;
   @ObfuscatedName("i")
   int[] field2708;
   @ObfuscatedName("t")
   class122 field2709;
   @ObfuscatedName("k")
   int[] field2710;
   @ObfuscatedName("h")
   int[] field2711;
   @ObfuscatedName("n")
   int[] field2712;
   @ObfuscatedName("f")
   int[][] field2713;
   @ObfuscatedName("a")
   int[][] field2714;
   @ObfuscatedName("l")
   int[] field2715;
   @ObfuscatedName("p")
   static class146 field2716 = new class146();
   @ObfuscatedName("z")
   Object[][] field2717;
   @ObfuscatedName("x")
   Object[] field2718;
   @ObfuscatedName("al")
   static class102 field2719;
   @ObfuscatedName("o")
   boolean field2720;
   @ObfuscatedName("y")
   boolean field2721;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1665576945
   )
   static int field2722 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 400763611
   )
   public int field2723;

   class182(boolean var1, boolean var2) {
      this.field2720 = var1;
      this.field2721 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "441144862"
   )
   void vmethod3433(int var1) {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1512650144"
   )
   void method3348(byte[] var1) {
      this.field2723 = class8.method114(var1, var1.length);
      Buffer var2 = new Buffer(class159.method3143(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.field2707 = var2.method2870();
         } else {
            this.field2707 = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2715 = new int[this.field2707];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2707; ++var7) {
               this.field2715[var7] = var5 += var2.method2870();
               if(this.field2715[var7] > var6) {
                  var6 = this.field2715[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2707; ++var7) {
               this.field2715[var7] = var5 += var2.readUnsignedShort();
               if(this.field2715[var7] > var6) {
                  var6 = this.field2715[var7];
               }
            }
         }

         this.field2710 = new int[1 + var6];
         this.field2711 = new int[1 + var6];
         this.field2712 = new int[var6 + 1];
         this.field2713 = new int[var6 + 1][];
         this.field2718 = new Object[var6 + 1];
         this.field2717 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field2708 = new int[1 + var6];

            for(var7 = 0; var7 < this.field2707; ++var7) {
               this.field2708[this.field2715[var7]] = var2.readInt();
            }

            this.field2709 = new class122(this.field2708);
         }

         for(var7 = 0; var7 < this.field2707; ++var7) {
            this.field2710[this.field2715[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field2707; ++var7) {
            this.field2711[this.field2715[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field2707; ++var7) {
            this.field2712[this.field2715[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2707; ++var7) {
               var8 = this.field2715[var7];
               var9 = this.field2712[var8];
               var5 = 0;
               var10 = -1;
               this.field2713[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2713[var8][var11] = var5 += var2.method2870();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2717[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field2707; ++var7) {
               var8 = this.field2715[var7];
               var9 = this.field2712[var8];
               var5 = 0;
               var10 = -1;
               this.field2713[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2713[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2717[var8] = new Object[1 + var10];
            }
         }

         if(var4 != 0) {
            this.field2714 = new int[1 + var6][];
            this.field2706 = new class122[1 + var6];

            for(var7 = 0; var7 < this.field2707; ++var7) {
               var8 = this.field2715[var7];
               var9 = this.field2712[var8];
               this.field2714[var8] = new int[this.field2717[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2714[var8][this.field2713[var8][var10]] = var2.readInt();
               }

               this.field2706[var8] = new class122(this.field2714[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "926540359"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2717.length && null != this.field2717[var1] && var2 >= 0 && var2 < this.field2717[var1].length) {
         if(this.field2717[var1][var2] == null) {
            boolean var4 = this.method3362(var1, var3);
            if(!var4) {
               this.vmethod3434(var1);
               var4 = this.method3362(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class107.method2093(this.field2717[var1][var2], false);
         if(this.field2721) {
            this.field2717[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1351856293"
   )
   public boolean method3352() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2715.length; ++var2) {
         int var3 = this.field2715[var2];
         if(null == this.field2718[var3]) {
            this.vmethod3434(var3);
            if(this.field2718[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1690819772"
   )
   public byte[] method3353(int var1) {
      if(this.field2717.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2717[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1857941043"
   )
   public byte[] method3354(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2717.length && null != this.field2717[var1] && var2 >= 0 && var2 < this.field2717[var1].length) {
         if(this.field2717[var1][var2] == null) {
            boolean var3 = this.method3362(var1, (int[])null);
            if(!var3) {
               this.vmethod3434(var1);
               var3 = this.method3362(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class107.method2093(this.field2717[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-21"
   )
   public byte[] method3355(int var1) {
      if(this.field2717.length == 1) {
         return this.method3354(0, var1);
      } else if(this.field2717[var1].length == 1) {
         return this.method3354(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "184508180"
   )
   void vmethod3434(int var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1746547324"
   )
   public int[] method3357(int var1) {
      return this.field2713[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "409636811"
   )
   public void method3360(int var1) {
      for(int var2 = 0; var2 < this.field2717[var1].length; ++var2) {
         this.field2717[var1][var2] = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   public void method3361() {
      for(int var1 = 0; var1 < this.field2717.length; ++var1) {
         if(this.field2717[var1] != null) {
            for(int var2 = 0; var2 < this.field2717[var1].length; ++var2) {
               this.field2717[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-1891070958"
   )
   boolean method3362(int var1, int[] var2) {
      if(this.field2718[var1] == null) {
         return false;
      } else {
         int var3 = this.field2712[var1];
         int[] var4 = this.field2713[var1];
         Object[] var5 = this.field2717[var1];
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
               var18 = class107.method2093(this.field2718[var1], false);
            } else {
               var18 = class107.method2093(this.field2718[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2876(var2, 5, var8.payload.length);
            }

            byte[] var20 = class159.method3143(var18);
            if(this.field2720) {
               this.field2718[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
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
                  if(!this.field2721) {
                     var5[var4[var15]] = class205.method3918(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2721) {
               var5[var4[0]] = class205.method3918(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-20"
   )
   public int method3363(String var1) {
      var1 = var1.toLowerCase();
      return this.field2709.method2392(NPC.method796(var1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "1230929450"
   )
   public byte[] method3365(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2709.method2392(NPC.method796(var1));
      int var4 = this.field2706[var3].method2392(NPC.method796(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "25"
   )
   public boolean method3366(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2709.method2392(NPC.method796(var1));
      int var4 = this.field2706[var3].method2392(NPC.method796(var2));
      return this.method3413(var3, var4);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1238928257"
   )
   public boolean method3367(String var1) {
      int var2 = this.method3363("");
      return var2 != -1?this.method3366("", var1):this.method3366(var1, "");
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "1801"
   )
   public void method3368(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2709.method2392(NPC.method796(var1));
      if(var2 >= 0) {
         this.vmethod3433(var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "729486230"
   )
   public boolean method3378(int var1) {
      if(null != this.field2718[var1]) {
         return true;
      } else {
         this.vmethod3434(var1);
         return null != this.field2718[var1];
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)Lclass189;",
      garbageValue = "-5238"
   )
   public static class189 method3384(int var0) {
      class189 var1 = (class189)class189.field2785.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class189.field2787.getConfigData(15, var0);
         var1 = new class189();
         if(null != var2) {
            var1.method3535(new Buffer(var2));
         }

         class189.field2785.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-984533760"
   )
   public int method3392() {
      return this.field2717.length;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-953958708"
   )
   public int method3398(int var1) {
      return this.field2717[var1].length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "-49"
   )
   public int method3407(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2706[var1].method2392(NPC.method796(var2));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "55"
   )
   public boolean method3413(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2717.length && null != this.field2717[var1] && var2 >= 0 && var2 < this.field2717[var1].length) {
         if(this.field2717[var1][var2] != null) {
            return true;
         } else if(null != this.field2718[var1]) {
            return true;
         } else {
            this.vmethod3434(var1);
            return this.field2718[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "0"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)Ljava/lang/String;",
      garbageValue = "1416431598"
   )
   public static String method3425(Buffer var0) {
      return ChatLineBuffer.method991(var0, 32767);
   }
}
