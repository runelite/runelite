package net.runelite.rsmv;


public final class class19 extends class18 {
   public boolean field91 = false;
   private int field92;
   private int[] field93;
   private int[] field94;
   private int[] field95;
   private int field96;
   private int[] field97;
   private int[] field98;
   private int[] field99;
   private int[] field100;
   private int[] field101;
   private int[] field102;
   private int[] field103;
   private int[] field104;
   private int[] field105;
   private int[] field106;
   private int field107;
   private int[] field108;
   private int[] field109;
   private int[] field110;
   private int field111;
   private int field112;
   private int field113;
   private int field114;
   private int[] field115;
   private int[] field116;
   private class16[] field117;
   private static class15[] field118;
   private static boolean[] field119;
   private static boolean[] field120;
   private static int[] field121;
   private static int[] field122;
   private static int[] field123;
   private static int[] field124;
   private static int[] field125;
   private static int[] field126;
   private static int[] field127;
   private static int[][] field128;
   private static int[] field129;
   private static int[][] field130;
   private static int[] field131;
   private static int[] field132;
   private static int[] field133;
   private static final int[] field134;
   private static final int[] field135;
   private static final int[] field136;
   private static int[] field137;
   private static int[] field138;
   private static int[] field139;
   private static int[] field140;
   private static int[] field141;

   public static void method33(int var0) {
      field118 = new class15[1];
   }

   public static void method34(byte[] var0, int var1) {
      if(var0 == null) {
         class15 var13;
         (var13 = field118[0] = new class15()).field67 = 0;
         var13.field68 = 0;
         var13.field69 = 0;
      } else {
         class17 var12;
         (var12 = new class17(var0)).field88 = var0.length - 18;
         class15 var2;
         (var2 = field118[0] = new class15()).field66 = var0;
         var2.field67 = var12.method29();
         var2.field68 = var12.method29();
         var2.field69 = var12.method27();
         int var10 = var12.method27();
         int var3 = var12.method27();
         int var4 = var12.method27();
         int var5 = var12.method27();
         int var6 = var12.method27();
         int var7 = var12.method29();
         int var8 = var12.method29();
         var12.method29();
         int var11 = var12.method29();
         var2.field70 = 0;
         int var9 = 0 + var2.field67;
         var2.field76 = var9;
         var9 += var2.field68;
         var2.field79 = var9;
         if(var3 == 255) {
            var9 += var2.field68;
         } else {
            var2.field79 = -var3 - 1;
         }

         var2.field81 = var9;
         if(var5 == 1) {
            var9 += var2.field68;
         } else {
            var2.field81 = -1;
         }

         var2.field78 = var9;
         if(var10 == 1) {
            var9 += var2.field68;
         } else {
            var2.field78 = -1;
         }

         var2.field74 = var9;
         if(var6 == 1) {
            var9 += var2.field67;
         } else {
            var2.field74 = -1;
         }

         var2.field80 = var9;
         if(var4 == 1) {
            var9 += var2.field68;
         } else {
            var2.field80 = -1;
         }

         var2.field75 = var9;
         var9 += var11;
         var2.field77 = var9;
         var9 += var2.field68 << 1;
         var2.field82 = var9;
         var9 += var2.field69 * 6;
         var2.field71 = var9;
         var9 += var7;
         var2.field72 = var9;
         var9 += var8;
         var2.field73 = var9;
      }
   }

   public static class19 method35(int var0) {
      return field118 == null?null:new class19(0);
   }

   public static class19 method36(byte[] var0) {
      return new class19(var0);
   }

   private class19() {
   }

   public final void method37(int var1) {
      for(var1 = 0; var1 < this.field92; ++var1) {
         this.field93[var1] /= 4;
         this.field94[var1] /= 4;
         this.field95[var1] /= 4;
      }

   }

   private class19(byte[] var1) {
      class17 var2 = new class17(var1);
      class17 var3 = new class17(var1);
      class17 var4 = new class17(var1);
      class17 var5 = new class17(var1);
      class17 var6 = new class17(var1);
      class17 var7 = new class17(var1);
      class17 var8 = new class17(var1);
      var2.field88 = var1.length - 23;
      int var9 = var2.method31();
      int var10 = var2.method31();
      int var11 = var2.method27();
      class15 var12;
      (var12 = field118[0] = new class15()).field66 = var1;
      var12.field67 = var9;
      var12.field68 = var10;
      var12.field69 = var11;
      int var165 = var2.method27();
      boolean var13 = ~(1 & var165) == -2;
      boolean var14;
      if(!(var14 = (8 & var165) == 8)) {
         class19 var84 = this;
         class17 var86 = new class17(var1);
         class17 var87 = new class17(var1);
         class17 var88 = new class17(var1);
         class17 var89 = new class17(var1);
         class17 var90 = new class17(var1);
         class17 var91 = new class17(var1);
         class17 var92 = new class17(var1);
         var86.field88 = var1.length - 23;
         int var93 = var86.method31();
         int var94 = var86.method31();
         int var95 = var86.method27();
         class15 var96;
         (var96 = field118[0] = new class15()).field66 = var1;
         var96.field67 = var93;
         var96.field68 = var94;
         var96.field69 = var95;
         int var97 = var86.method27();
         boolean var98 = ~(1 & var97) == -2;
         int var99 = var86.method27();
         int var100 = var86.method27();
         int var101 = var86.method27();
         int var102 = var86.method27();
         int var103 = var86.method27();
         int var104 = var86.method31();
         int var105 = var86.method31();
         int var106 = var86.method31();
         int var107 = var86.method31();
         int var108 = var86.method31();
         int var109 = 0;
         int var110 = 0;
         int var111 = 0;
         byte[] var113 = null;
         byte[] var114 = null;
         byte[] var115 = null;
         byte[] var116 = null;
         byte[] var117 = null;
         byte[] var118 = null;
         byte[] var119 = null;
         int[] var120 = null;
         int[] var121 = null;
         int[] var122 = null;
         short[] var123 = null;
         int var125;
         if(var95 > 0) {
            var114 = new byte[var95];
            var86.field88 = 0;

            for(var125 = 0; var125 < var95; ++var125) {
               byte var126;
               if((var126 = var114[var125] = var86.method28()) == 0) {
                  ++var109;
               }

               if(var126 > 0 && var126 <= 3) {
                  ++var110;
               }

               if(var126 == 2) {
                  ++var111;
               }
            }
         }

         int var127 = var125 = var95 + var93;
         if(var97 == 1) {
            var125 += var94;
         }

         int var128 = var125;
         int var129 = var125 += var94;
         if(var99 == 255) {
            var125 += var94;
         }

         int var130 = var125;
         if(var101 == 1) {
            var125 += var94;
         }

         int var131 = var125;
         if(var103 == 1) {
            var125 += var93;
         }

         int var132 = var125;
         if(var100 == 1) {
            var125 += var94;
         }

         int var133 = var125;
         int var134 = var125 += var107;
         if(var102 == 1) {
            var125 += var94 << 1;
         }

         int var135 = var125;
         int var136 = var125 += var108;
         int var137 = var125 += var94 << 1;
         int var138 = var125 += var104;
         int var139 = var125 += var105;
         int var140 = var125 += var106;
         int var141 = var125 += var109 * 6;
         int var142 = var125 += var110 * 6;
         int var143 = var125 += var110 * 6;
         int var144 = var125 += var110;
         int var145 = var125 + var110;
         int[] var146 = new int[var93];
         int[] var147 = new int[var93];
         int[] var148 = new int[var93];
         int[] var149 = new int[var94];
         int[] var150 = new int[var94];
         int[] var151 = new int[var94];
         this.field115 = new int[var93];
         this.field103 = new int[var94];
         this.field104 = new int[var94];
         this.field105 = new int[var94];
         this.field116 = new int[var94];
         if(var103 == 1) {
            this.field115 = new int[var93];
         }

         if(var98) {
            this.field103 = new int[var94];
         }

         if(var99 == 255) {
            this.field104 = new int[var94];
         }

         if(var100 == 1) {
            this.field105 = new int[var94];
         }

         if(var101 == 1) {
            this.field116 = new int[var94];
         }

         if(var102 == 1) {
            var123 = new short[var94];
         }

         if(var102 == 1 && var95 > 0) {
            var113 = new byte[var94];
         }

         int[] var124 = new int[var94];
         int[] var152 = null;
         int[] var153 = null;
         int[] var154 = null;
         if(var95 > 0) {
            var152 = new int[var95];
            var153 = new int[var95];
            var154 = new int[var95];
            if(var110 > 0) {
               var120 = new int[var110];
               var122 = new int[var110];
               var121 = new int[var110];
               var118 = new byte[var110];
               var119 = new byte[var110];
               var116 = new byte[var110];
            }

            if(var111 > 0) {
               var117 = new byte[var111];
               var115 = new byte[var111];
            }
         }

         var86.field88 = var95;
         var87.field88 = var137;
         var88.field88 = var138;
         var89.field88 = var139;
         var90.field88 = var131;
         int var155 = 0;
         int var156 = 0;
         int var157 = 0;

         int var158;
         int var159;
         int var160;
         int var161;
         int var162;
         for(var158 = 0; var158 < var93; ++var158) {
            var159 = var86.method27();
            var160 = 0;
            if((var159 & 1) != 0) {
               var160 = var87.method32();
            }

            var161 = 0;
            if((var159 & 2) != 0) {
               var161 = var88.method32();
            }

            var162 = 0;
            if((var159 & 4) != 0) {
               var162 = var89.method32();
            }

            var146[var158] = var155 + var160;
            var147[var158] = var156 + var161;
            var148[var158] = var157 + var162;
            var155 = var146[var158];
            var156 = var147[var158];
            var157 = var148[var158];
            if(var84.field115 != null) {
               var84.field115[var158] = var90.method27();
            }
         }

         var86.field88 = var136;
         var87.field88 = var127;
         var88.field88 = var129;
         var89.field88 = var132;
         var90.field88 = var130;
         var91.field88 = var134;
         var92.field88 = var135;

         for(var158 = 0; var158 < var94; ++var158) {
            var124[var158] = var86.method31();
            if(var97 == 1) {
               var84.field103[var158] = var87.method28();
               if(var84.field103[var158] == 2) {
                  var124[var158] = '\uffff';
               }

               var84.field103[var158] = 0;
            }

            if(var99 == 255) {
               var84.field104[var158] = var88.method28();
            }

            if(var100 == 1) {
               var84.field105[var158] = var89.method28();
               if(var84.field105[var158] < 0) {
                  var84.field105[var158] += 256;
               }
            }

            if(var101 == 1) {
               var84.field116[var158] = var90.method27();
            }

            if(var102 == 1) {
               var123[var158] = (short)(var91.method31() - 1);
            }

            if(var113 != null) {
               if(var123[var158] != -1) {
                  var113[var158] = (byte)(var92.method27() - 1);
               } else {
                  var113[var158] = -1;
               }
            }
         }

         var86.field88 = var133;
         var87.field88 = var128;
         var158 = 0;
         var159 = 0;
         var160 = 0;
         var161 = 0;

         int var163;
         for(var162 = 0; var162 < var94; ++var162) {
            if((var163 = var87.method27()) == 1) {
               var161 = var158 = var86.method32() + var161;
               var161 = var159 = var86.method32() + var161;
               var161 = var160 = var86.method32() + var161;
               var149[var162] = var158;
               var150[var162] = var159;
               var151[var162] = var160;
            }

            if(var163 == 2) {
               var159 = var160;
               var161 = var160 = var86.method32() + var161;
               var149[var162] = var158;
               var150[var162] = var159;
               var151[var162] = var160;
            }

            if(var163 == 3) {
               var158 = var160;
               var161 = var160 = var86.method32() + var161;
               var149[var162] = var158;
               var150[var162] = var159;
               var151[var162] = var160;
            }

            if(var163 == 4) {
               int var164 = var158;
               var158 = var159;
               var159 = var164;
               var161 = var160 = var86.method32() + var161;
               var149[var162] = var158;
               var150[var162] = var164;
               var151[var162] = var160;
            }
         }

         var86.field88 = var140;
         var87.field88 = var141;
         var88.field88 = var142;
         var89.field88 = var143;
         var90.field88 = var144;
         var91.field88 = var145;

         for(var162 = 0; var162 < var95; ++var162) {
            if((var163 = var114[var162] & 255) == 0) {
               var152[var162] = var86.method31();
               var153[var162] = var86.method31();
               var154[var162] = var86.method31();
            }

            if(var163 == 1) {
               var152[var162] = var87.method31();
               var153[var162] = var87.method31();
               var154[var162] = var87.method31();
               var120[var162] = var88.method31();
               var122[var162] = var88.method31();
               var121[var162] = var88.method31();
               var118[var162] = var89.method28();
               var119[var162] = var90.method28();
               var116[var162] = var91.method28();
            }

            if(var163 == 2) {
               var152[var162] = var87.method31();
               var153[var162] = var87.method31();
               var154[var162] = var87.method31();
               var120[var162] = var88.method31();
               var122[var162] = var88.method31();
               var121[var162] = var88.method31();
               var118[var162] = var89.method28();
               var119[var162] = var90.method28();
               var116[var162] = var91.method28();
               var117[var162] = var91.method28();
               var115[var162] = var91.method28();
            }

            if(var163 == 3) {
               var152[var162] = var87.method31();
               var153[var162] = var87.method31();
               var154[var162] = var87.method31();
               var120[var162] = var88.method31();
               var122[var162] = var88.method31();
               var121[var162] = var88.method31();
               var118[var162] = var89.method28();
               var119[var162] = var90.method28();
               var116[var162] = var91.method28();
            }
         }

         if(var99 != 255) {
            for(var162 = 0; var162 < var94; ++var162) {
               var84.field104[var162] = var99;
            }
         }

         var84.field106 = var124;
         var84.field92 = var93;
         var84.field96 = var94;
         var84.field93 = var146;
         var84.field94 = var147;
         var84.field95 = var148;
         var84.field97 = var149;
         var84.field98 = var150;
         var84.field99 = var151;
      } else {
         int var166 = 0;
         if(var14) {
            var2.field88 -= 7;
            var166 = var2.method27();
            var2.field88 += 6;
         }

         if(var166 == 15) {
            this.field91 = true;
         }

         int var168 = var2.method27();
         int var15 = var2.method27();
         int var16 = var2.method27();
         int var17 = var2.method27();
         int var18 = var2.method27();
         int var19 = var2.method31();
         int var20 = var2.method31();
         int var21 = var2.method31();
         int var22 = var2.method31();
         int var23 = var2.method31();
         int var24 = 0;
         int var25 = 0;
         int var26 = 0;
         byte[] var27 = null;
         byte[] var28 = null;
         byte[] var29 = null;
         byte[] var30 = null;
         byte[] var31 = null;
         byte[] var32 = null;
         byte[] var33 = null;
         int[] var34 = null;
         int[] var35 = null;
         int[] var36 = null;
         short[] var37 = null;
         int var38;
         if(var11 > 0) {
            var28 = new byte[var11];
            var2.field88 = 0;

            for(var38 = 0; var38 < var11; ++var38) {
               byte var39;
               if((var39 = var28[var38] = var2.method28()) == 0) {
                  ++var24;
               }

               if(var39 > 0 && var39 <= 3) {
                  ++var25;
               }

               if(var39 == 2) {
                  ++var26;
               }
            }
         }

         int var170 = var38 = var11 + var9;
         if(var13) {
            var38 += var10;
         }

         if(var165 == 1) {
            var38 += var10;
         }

         int var40 = var38;
         int var41 = var38 += var10;
         if(var168 == 255) {
            var38 += var10;
         }

         int var42 = var38;
         if(var16 == 1) {
            var38 += var10;
         }

         int var43 = var38;
         if(var18 == 1) {
            var38 += var9;
         }

         int var44 = var38;
         if(var15 == 1) {
            var38 += var10;
         }

         int var45 = var38;
         var22 = var38 += var22;
         if(var17 == 1) {
            var38 += var10 << 1;
         }

         int var46 = var38;
         var23 = var38 += var23;
         int var47 = var38 += var10 << 1;
         int var48 = var38 += var19;
         var20 = var38 += var20;
         var21 = var38 += var21;
         var24 = var38 += var24 * 6;
         var38 += var25 * 6;
         byte var169 = 6;
         if(var166 != 14) {
            if(var166 >= 15) {
               var169 = 9;
            }
         } else {
            var169 = 7;
         }

         int var49 = var38;
         int var50 = var38 += var169 * var25;
         int var51 = var38 += var25;
         int var64 = var38 + var25;
         int[] var65 = new int[var9];
         int[] var66 = new int[var9];
         int[] var67 = new int[var9];
         int[] var68 = new int[var10];
         int[] var69 = new int[var10];
         int[] var70 = new int[var10];
         this.field115 = new int[var9];
         this.field103 = new int[var10];
         this.field104 = new int[var10];
         this.field105 = new int[var10];
         this.field116 = new int[var10];
         if(var18 == 1) {
            this.field115 = new int[var9];
         }

         if(var13) {
            this.field103 = new int[var10];
         }

         if(var168 == 255) {
            this.field104 = new int[var10];
         }

         if(var15 == 1) {
            this.field105 = new int[var10];
         }

         if(var16 == 1) {
            this.field116 = new int[var10];
         }

         if(var17 == 1) {
            var37 = new short[var10];
         }

         if(var17 == 1 && var11 > 0) {
            var27 = new byte[var10];
         }

         int[] var167 = new int[var10];
         int[] var71 = null;
         int[] var72 = null;
         int[] var73 = null;
         if(var11 > 0) {
            var71 = new int[var11];
            var72 = new int[var11];
            var73 = new int[var11];
            if(var25 > 0) {
               var34 = new int[var25];
               var36 = new int[var25];
               var35 = new int[var25];
               var32 = new byte[var25];
               var33 = new byte[var25];
               var30 = new byte[var25];
            }

            if(var26 > 0) {
               var31 = new byte[var26];
               var29 = new byte[var26];
            }
         }

         var2.field88 = var11;
         var3.field88 = var47;
         var4.field88 = var48;
         var5.field88 = var20;
         var6.field88 = var43;
         int var74 = 0;
         int var75 = 0;
         int var76 = 0;

         int var77;
         int var78;
         int var79;
         int var80;
         int var81;
         for(var77 = 0; var77 < var9; ++var77) {
            var78 = var2.method27();
            var79 = 0;
            if((var78 & 1) != 0) {
               var79 = var3.method32();
            }

            var80 = 0;
            if((var78 & 2) != 0) {
               var80 = var4.method32();
            }

            var81 = 0;
            if((var78 & 4) != 0) {
               var81 = var5.method32();
            }

            var65[var77] = var74 + var79;
            var66[var77] = var75 + var80;
            var67[var77] = var76 + var81;
            var74 = var65[var77];
            var75 = var66[var77];
            var76 = var67[var77];
            if(this.field115 != null) {
               this.field115[var77] = var6.method27();
            }
         }

         var2.field88 = var23;
         var3.field88 = var170;
         var4.field88 = var41;
         var5.field88 = var44;
         var6.field88 = var42;
         var7.field88 = var22;
         var8.field88 = var46;

         for(var77 = 0; var77 < var10; ++var77) {
            var167[var77] = var2.method31();
            if(var165 == 1) {
               this.field103[var77] = var3.method28();
               if(this.field103[var77] == 2) {
                  var167[var77] = '\uffff';
               }

               this.field103[var77] = 0;
            }

            if(var168 == 255) {
               this.field104[var77] = var4.method28();
            }

            if(var15 == 1) {
               this.field105[var77] = var5.method28();
               if(this.field105[var77] < 0) {
                  this.field105[var77] += 256;
               }
            }

            if(var16 == 1) {
               this.field116[var77] = var6.method27();
            }

            if(var17 == 1) {
               var37[var77] = (short)(var7.method31() - 1);
            }

            if(var27 != null) {
               if(var37[var77] != -1) {
                  var27[var77] = (byte)(var8.method27() - 1);
               } else {
                  var27[var77] = -1;
               }
            }
         }

         var2.field88 = var45;
         var3.field88 = var40;
         var77 = 0;
         var78 = 0;
         var79 = 0;
         var80 = 0;

         int var82;
         for(var81 = 0; var81 < var10; ++var81) {
            if((var82 = var3.method27()) == 1) {
               var80 = var77 = var2.method32() + var80;
               var80 = var78 = var2.method32() + var80;
               var80 = var79 = var2.method32() + var80;
               var68[var81] = var77;
               var69[var81] = var78;
               var70[var81] = var79;
            }

            if(var82 == 2) {
               var78 = var79;
               var80 = var79 = var2.method32() + var80;
               var68[var81] = var77;
               var69[var81] = var78;
               var70[var81] = var79;
            }

            if(var82 == 3) {
               var77 = var79;
               var80 = var79 = var2.method32() + var80;
               var68[var81] = var77;
               var69[var81] = var78;
               var70[var81] = var79;
            }

            if(var82 == 4) {
               int var83 = var77;
               var77 = var78;
               var78 = var83;
               var80 = var79 = var2.method32() + var80;
               var68[var81] = var77;
               var69[var81] = var83;
               var70[var81] = var79;
            }
         }

         var2.field88 = var21;
         var3.field88 = var24;
         var4.field88 = var49;
         var5.field88 = var50;
         var6.field88 = var51;
         var7.field88 = var64;

         for(var81 = 0; var81 < var11; ++var81) {
            if((var82 = var28[var81] & 255) == 0) {
               var71[var81] = var2.method31();
               var72[var81] = var2.method31();
               var73[var81] = var2.method31();
            }

            if(var82 == 1) {
               var71[var81] = var3.method31();
               var72[var81] = var3.method31();
               var73[var81] = var3.method31();
               if(var166 < 15) {
                  var34[var81] = var4.method31();
                  if(var166 >= 14) {
                     var36[var81] = var4.method30();
                  } else {
                     var36[var81] = var4.method31();
                  }

                  var35[var81] = var4.method31();
               } else {
                  var34[var81] = var4.method30();
                  var36[var81] = var4.method30();
                  var35[var81] = var4.method30();
               }

               var32[var81] = var5.method28();
               var33[var81] = var6.method28();
               var30[var81] = var7.method28();
            }

            if(var82 == 2) {
               var71[var81] = var3.method31();
               var72[var81] = var3.method31();
               var73[var81] = var3.method31();
               if(var166 >= 15) {
                  var34[var81] = var4.method30();
                  var36[var81] = var4.method30();
                  var35[var81] = var4.method30();
               } else {
                  var34[var81] = var4.method31();
                  if(var166 < 14) {
                     var36[var81] = var4.method31();
                  } else {
                     var36[var81] = var4.method30();
                  }

                  var35[var81] = var4.method31();
               }

               var32[var81] = var5.method28();
               var33[var81] = var6.method28();
               var30[var81] = var7.method28();
               var31[var81] = var7.method28();
               var29[var81] = var7.method28();
            }

            if(var82 == 3) {
               var71[var81] = var3.method31();
               var72[var81] = var3.method31();
               var73[var81] = var3.method31();
               if(var166 < 15) {
                  var34[var81] = var4.method31();
                  if(var166 < 14) {
                     var36[var81] = var4.method31();
                  } else {
                     var36[var81] = var4.method30();
                  }

                  var35[var81] = var4.method31();
               } else {
                  var34[var81] = var4.method30();
                  var36[var81] = var4.method30();
                  var35[var81] = var4.method30();
               }

               var32[var81] = var5.method28();
               var33[var81] = var6.method28();
               var30[var81] = var7.method28();
            }
         }

         if(var168 != 255) {
            for(var81 = 0; var81 < var10; ++var81) {
               this.field104[var81] = var168;
            }
         }

         this.field106 = var167;
         this.field92 = var9;
         this.field96 = var10;
         this.field93 = var65;
         this.field94 = var66;
         this.field95 = var67;
         this.field97 = var68;
         this.field98 = var69;
         this.field99 = var70;
      }
   }

   private class19(int var1) {
      class15 var15 = field118[var1];
      this.field92 = var15.field67;
      this.field96 = var15.field68;
      this.field107 = var15.field69;
      this.field93 = new int[this.field92];
      this.field94 = new int[this.field92];
      this.field95 = new int[this.field92];
      this.field97 = new int[this.field96];
      this.field98 = new int[this.field96];
      this.field99 = new int[this.field96];
      this.field108 = new int[this.field107];
      this.field109 = new int[this.field107];
      this.field110 = new int[this.field107];
      if(var15.field74 >= 0) {
         this.field115 = new int[this.field92];
      }

      if(var15.field78 >= 0) {
         this.field103 = new int[this.field96];
      }

      if(var15.field79 >= 0) {
         this.field104 = new int[this.field96];
      }

      if(var15.field80 >= 0) {
         this.field105 = new int[this.field96];
      }

      if(var15.field81 >= 0) {
         this.field116 = new int[this.field96];
      }

      this.field106 = new int[this.field96];
      class17 var2;
      (var2 = new class17(var15.field66)).field88 = 0;
      class17 var3;
      (var3 = new class17(var15.field66)).field88 = var15.field71;
      class17 var4;
      (var4 = new class17(var15.field66)).field88 = var15.field72;
      class17 var5;
      (var5 = new class17(var15.field66)).field88 = var15.field73;
      class17 var6;
      (var6 = new class17(var15.field66)).field88 = var15.field74;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      for(var10 = 0; var10 < this.field92; ++var10) {
         var11 = var2.method27();
         var12 = 0;
         if((var11 & 1) != 0) {
            var12 = var3.method32();
         }

         var13 = 0;
         if((var11 & 2) != 0) {
            var13 = var4.method32();
         }

         var14 = 0;
         if((var11 & 4) != 0) {
            var14 = var5.method32();
         }

         this.field93[var10] = var7 + var12;
         this.field94[var10] = var8 + var13;
         this.field95[var10] = var9 + var14;
         var7 = this.field93[var10];
         var8 = this.field94[var10];
         var9 = this.field95[var10];
         if(this.field115 != null) {
            this.field115[var10] = var6.method27();
         }
      }

      var2.field88 = var15.field77;
      var3.field88 = var15.field78;
      var4.field88 = var15.field79;
      var5.field88 = var15.field80;
      var6.field88 = var15.field81;

      for(var10 = 0; var10 < this.field96; ++var10) {
         this.field106[var10] = var2.method29();
         if(this.field103 != null) {
            this.field103[var10] = var3.method27();
         }

         if(this.field104 != null) {
            this.field104[var10] = var4.method27();
         }

         if(this.field105 != null) {
            this.field105[var10] = var5.method27();
         }

         if(this.field116 != null) {
            this.field116[var10] = var6.method27();
         }
      }

      var2.field88 = var15.field75;
      var3.field88 = var15.field76;
      var10 = 0;
      var11 = 0;
      var12 = 0;
      var13 = 0;

      for(var14 = 0; var14 < this.field96; ++var14) {
         int var16;
         if((var16 = var3.method27()) == 1) {
            var13 = var10 = var2.method32() + var13;
            var13 = var11 = var2.method32() + var13;
            var13 = var12 = var2.method32() + var13;
            this.field97[var14] = var10;
            this.field98[var14] = var11;
            this.field99[var14] = var12;
         }

         if(var16 == 2) {
            var11 = var12;
            var13 = var12 = var2.method32() + var13;
            this.field97[var14] = var10;
            this.field98[var14] = var11;
            this.field99[var14] = var12;
         }

         if(var16 == 3) {
            var10 = var12;
            var13 = var12 = var2.method32() + var13;
            this.field97[var14] = var10;
            this.field98[var14] = var11;
            this.field99[var14] = var12;
         }

         if(var16 == 4) {
            var16 = var10;
            var10 = var11;
            var11 = var16;
            var13 = var12 = var2.method32() + var13;
            this.field97[var14] = var10;
            this.field98[var14] = var16;
            this.field99[var14] = var12;
         }
      }

      var2.field88 = var15.field82;

      for(var14 = 0; var14 < this.field107; ++var14) {
         this.field108[var14] = var2.method29();
         this.field109[var14] = var2.method29();
         this.field110[var14] = var2.method29();
      }

   }

   public final void method38(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      var1 = (int)Math.sqrt(5100.0D);
      var1 = var1 * 768 >> 8;
      if(this.field100 == null) {
         this.field100 = new int[this.field96];
         this.field101 = new int[this.field96];
         this.field102 = new int[this.field96];
      }

      if(super.field89 == null) {
         super.field89 = new class16[this.field92];

         for(var2 = 0; var2 < this.field92; ++var2) {
            super.field89[var2] = new class16();
         }
      }

      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var20;
      for(var2 = 0; var2 < this.field96; ++var2) {
         var3 = this.field97[var2];
         var4 = this.field98[var2];
         var5 = this.field99[var2];
         var20 = this.field93[var4] - this.field93[var3];
         var7 = this.field94[var4] - this.field94[var3];
         var8 = this.field95[var4] - this.field95[var3];
         var9 = this.field93[var5] - this.field93[var3];
         var10 = this.field94[var5] - this.field94[var3];
         var11 = this.field95[var5] - this.field95[var3];
         var12 = var7 * var11 - var10 * var8;
         var8 = var8 * var9 - var11 * var20;

         for(var20 = var20 * var10 - var9 * var7; var12 > 8192 || var8 > 8192 || var20 > 8192 || var12 < -8192 || var8 < -8192 || var20 < -8192; var20 >>= 1) {
            var12 >>= 1;
            var8 >>= 1;
         }

         if((var7 = (int)Math.sqrt((double)(var12 * var12 + var8 * var8 + var20 * var20))) <= 0) {
            var7 = 1;
         }

         var12 = (var12 << 8) / var7;
         var8 = (var8 << 8) / var7;
         var20 = (var20 << 8) / var7;
         if(this.field103 != null && (this.field103[var2] & 1) != 0) {
            var3 = 64 + (var12 * -50 + var8 * -10 + var20 * -50) / (var1 + var1 / 2);
            this.field100[var2] = method39(this.field106[var2], var3, this.field103[var2]);
         } else {
            class16 var13;
            class16 var10000 = var13 = super.field89[var3];
            var10000.field83 += var12;
            var13.field84 += var8;
            var13.field85 += var20;
            ++var13.field86;
            var10000 = var13 = super.field89[var4];
            var10000.field83 += var12;
            var13.field84 += var8;
            var13.field85 += var20;
            ++var13.field86;
            var10000 = var13 = super.field89[var5];
            var10000.field83 += var12;
            var13.field84 += var8;
            var13.field85 += var20;
            ++var13.field86;
         }
      }

      byte var21 = -50;
      byte var19 = -10;
      byte var18 = -50;
      var3 = var1;
      byte var17 = 64;
      class19 var14 = this;

      for(var7 = 0; var7 < var14.field96; ++var7) {
         var8 = var14.field97[var7];
         var9 = var14.field98[var7];
         var10 = var14.field99[var7];
         if(var14.field103 == null) {
            var11 = var14.field106[var7];
            class16 var15 = var14.field89[var8];
            var8 = var17 + (var18 * var15.field83 + var19 * var15.field84 + var21 * var15.field85) / (var3 * var15.field86);
            var14.field100[var7] = method39(var11, var8, 0);
            var15 = var14.field89[var9];
            var8 = var17 + (var18 * var15.field83 + var19 * var15.field84 + var21 * var15.field85) / (var3 * var15.field86);
            var14.field101[var7] = method39(var11, var8, 0);
            var15 = var14.field89[var10];
            var8 = var17 + (var18 * var15.field83 + var19 * var15.field84 + var21 * var15.field85) / (var3 * var15.field86);
            var14.field102[var7] = method39(var11, var8, 0);
         } else if((var14.field103[var7] & 1) == 0) {
            var11 = var14.field106[var7];
            var12 = var14.field103[var7];
            class16 var16 = var14.field89[var8];
            var8 = var17 + (var18 * var16.field83 + var19 * var16.field84 + var21 * var16.field85) / (var3 * var16.field86);
            var14.field100[var7] = method39(var11, var8, var12);
            var16 = var14.field89[var9];
            var8 = var17 + (var18 * var16.field83 + var19 * var16.field84 + var21 * var16.field85) / (var3 * var16.field86);
            var14.field101[var7] = method39(var11, var8, var12);
            var16 = var14.field89[var10];
            var8 = var17 + (var18 * var16.field83 + var19 * var16.field84 + var21 * var16.field85) / (var3 * var16.field86);
            var14.field102[var7] = method39(var11, var8, var12);
         }
      }

      label74: {
         var14.field89 = null;
         var14.field117 = null;
         var14.field115 = null;
         var14.field116 = null;
         if(var14.field103 != null) {
            for(var7 = 0; var7 < var14.field96; ++var7) {
               if((var14.field103[var7] & 2) == 2) {
                  break label74;
               }
            }
         }

         var14.field106 = null;
      }

      var14 = this;
      super.field90 = 0;
      this.field111 = 0;
      this.field112 = 0;

      for(var2 = 0; var2 < var14.field92; ++var2) {
         var3 = var14.field93[var2];
         var4 = var14.field94[var2];
         var5 = var14.field95[var2];
         if(-var4 > var14.field90) {
            var14.field90 = -var4;
         }

         if(var4 > var14.field112) {
            var14.field112 = var4;
         }

         if((var20 = var3 * var3 + var5 * var5) > var14.field111) {
            var14.field111 = var20;
         }
      }

      var14.field111 = (int)(Math.sqrt((double)var14.field111) + 0.99D);
      var14.field114 = (int)(Math.sqrt((double)(var14.field111 * var14.field111 + var14.field90 * var14.field90)) + 0.99D);
      var14.field113 = var14.field114 + (int)(Math.sqrt((double)(var14.field111 * var14.field111 + var14.field112 * var14.field112)) + 0.99D);
   }

   private static int method39(int var0, int var1, int var2) {
      if((var2 & 2) == 2) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         return var1 = 127 - var1;
      } else {
         if((var1 = var1 * (var0 & 127) >> 7) < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   public final void method40(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      var5 = class5.field12;
      int var8 = class5.field13;
      int var9 = field138[var1];
      int var10 = field139[var1];
      int var11 = field138[var2];
      int var12 = field139[var2];
      int var13 = field138[var3];
      int var14 = field139[var3];
      int var15 = field138[var4];
      var4 = field139[var4];
      int var16 = var6 * var15 + var7 * var4 >> 16;

      for(int var17 = 0; var17 < this.field92; ++var17) {
         int var18 = this.field93[var17];
         int var19 = this.field94[var17];
         int var20 = this.field95[var17];
         int var21;
         if(var3 != 0) {
            var21 = var19 * var13 + var18 * var14 >> 16;
            var19 = var19 * var14 - var18 * var13 >> 16;
            var18 = var21;
         }

         if(var1 != 0) {
            var21 = var19 * var10 - var20 * var9 >> 16;
            var20 = var19 * var9 + var20 * var10 >> 16;
            var19 = var21;
         }

         if(var2 != 0) {
            var21 = var20 * var11 + var18 * var12 >> 16;
            var20 = var20 * var12 - var18 * var11 >> 16;
            var18 = var21;
         }

         var19 += var6;
         var20 += var7;
         var21 = var19 * var4 - var20 * var15 >> 16;
         var20 = var19 * var15 + var20 * var4 >> 16;
         field123[var17] = var20 - var16;
         field121[var17] = var5 + (var18 << 9) / var20;
         field122[var17] = var8 + (var21 << 9) / var20;
         if(this.field107 > 0) {
            field124[var17] = var18;
            field125[var17] = var21;
            field126[var17] = var20;
         }
      }

      try {
         boolean var28 = false;
         var28 = false;
         var28 = false;
         class19 var22 = this;

         for(var2 = 0; var2 < var22.field113; ++var2) {
            field127[var2] = 0;
         }

         for(var2 = 0; var2 < var22.field96; ++var2) {
            if(var22.field103 == null || var22.field103[var2] != -1) {
               var3 = var22.field97[var2];
               var4 = var22.field98[var2];
               var5 = var22.field99[var2];
               var6 = field121[var3];
               var7 = field121[var4];
               var8 = field121[var5];
               if((var6 - var7) * (field122[var5] - field122[var4]) - (field122[var3] - field122[var4]) * (var8 - var7) > 0) {
                  field120[var2] = false;
                  field119[var2] = var6 < 0 || var7 < 0 || var8 < 0 || var6 > class14.field65 || var7 > class14.field65 || var8 > class14.field65;
                  var9 = (field123[var3] + field123[var4] + field123[var5]) / 3 + var22.field114;
                  field128[var9][field127[var9]++] = var2;
               }
            }
         }

         int[] var23;
         if(var22.field104 != null) {
            for(var2 = 0; var2 < 12; ++var2) {
               field129[var2] = 0;
               field133[var2] = 0;
            }

            for(var2 = var22.field113 - 1; var2 >= 0; --var2) {
               if((var3 = field127[var2]) > 0) {
                  var23 = field128[var2];

                  for(var5 = 0; var5 < var3; ++var5) {
                     var6 = var23[var5];
                     var7 = var22.field104[var6];
                     var8 = field129[var7]++;
                     field130[var7][var8] = var6;
                     if(var7 < 10) {
                        field133[var7] += var2;
                     } else if(var7 == 10) {
                        field131[var8] = var2;
                     } else {
                        field132[var8] = var2;
                     }
                  }
               }
            }

            var2 = 0;
            if(field129[1] > 0 || field129[2] > 0) {
               var2 = (field133[1] + field133[2]) / (field129[1] + field129[2]);
            }

            var3 = 0;
            if(field129[3] > 0 || field129[4] > 0) {
               var3 = (field133[3] + field133[4]) / (field129[3] + field129[4]);
            }

            var4 = 0;
            if(field129[6] > 0 || field129[8] > 0) {
               var4 = (field133[6] + field133[8]) / (field129[6] + field129[8]);
            }

            var5 = 0;
            var6 = field129[10];
            int[] var24 = field130[10];
            int[] var25 = field131;
            if(var6 == 0) {
               var5 = 0;
               var6 = field129[11];
               var24 = field130[11];
               var25 = field132;
            }

            if(var6 > 0) {
               var9 = var25[0];
            } else {
               var9 = -1000;
            }

            for(var10 = 0; var10 < 10; ++var10) {
               while(var10 == 0 && var9 > var2) {
                  var22.method41(var24[var5++]);
                  if(var5 == var6 && var24 != field130[11]) {
                     var5 = 0;
                     var6 = field129[11];
                     var24 = field130[11];
                     var25 = field132;
                  }

                  if(var5 < var6) {
                     var9 = var25[var5];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var10 == 3 && var9 > var3) {
                  var22.method41(var24[var5++]);
                  if(var5 == var6 && var24 != field130[11]) {
                     var5 = 0;
                     var6 = field129[11];
                     var24 = field130[11];
                     var25 = field132;
                  }

                  if(var5 < var6) {
                     var9 = var25[var5];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var10 == 5 && var9 > var4) {
                  var22.method41(var24[var5++]);
                  if(var5 == var6 && var24 != field130[11]) {
                     var5 = 0;
                     var6 = field129[11];
                     var24 = field130[11];
                     var25 = field132;
                  }

                  if(var5 < var6) {
                     var9 = var25[var5];
                  } else {
                     var9 = -1000;
                  }
               }

               var11 = field129[var10];
               int[] var26 = field130[var10];

               for(var13 = 0; var13 < var11; ++var13) {
                  var22.method41(var26[var13]);
               }
            }

            while(var9 != -1000) {
               var22.method41(var24[var5++]);
               if(var5 == var6 && var24 != field130[11]) {
                  var5 = 0;
                  var24 = field130[11];
                  var6 = field129[11];
                  var25 = field132;
               }

               if(var5 < var6) {
                  var9 = var25[var5];
               } else {
                  var9 = -1000;
               }
            }

            return;
         }

         for(var2 = var22.field113 - 1; var2 >= 0; --var2) {
            if((var3 = field127[var2]) > 0) {
               var23 = field128[var2];

               for(var5 = 0; var5 < var3; ++var5) {
                  var22.method41(var23[var5]);
               }
            }
         }
      } catch (Exception var27) {
         ;
      }

   }

   private void method41(int var1) {
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(field120[var1]) {
         var3 = class5.field12;
         var4 = class5.field13;
         var5 = 0;
         var6 = this.field97[var1];
         var7 = this.field98[var1];
         int var8 = this.field99[var1];
         int var9 = field126[var6];
         int var10 = field126[var7];
         int var11 = field126[var8];
         int var12;
         int var13;
         int var14;
         int var15;
         if(var9 >= 50) {
            field134[0] = field121[var6];
            field135[0] = field122[var6];
            ++var5;
            field136[0] = this.field100[var1];
         } else {
            var12 = field124[var6];
            var13 = field125[var6];
            var14 = this.field100[var1];
            if(var11 >= 50) {
               var15 = (50 - var9) * field141[var11 - var9];
               field134[0] = var3 + (var12 + ((field124[var8] - var12) * var15 >> 16) << 9) / 50;
               field135[0] = var4 + (var13 + ((field125[var8] - var13) * var15 >> 16) << 9) / 50;
               ++var5;
               field136[0] = var14 + ((this.field102[var1] - var14) * var15 >> 16);
            }

            if(var10 >= 50) {
               var15 = (50 - var9) * field141[var10 - var9];
               field134[var5] = var3 + (var12 + ((field124[var7] - var12) * var15 >> 16) << 9) / 50;
               field135[var5] = var4 + (var13 + ((field125[var7] - var13) * var15 >> 16) << 9) / 50;
               field136[var5++] = var14 + ((this.field101[var1] - var14) * var15 >> 16);
            }
         }

         if(var10 >= 50) {
            field134[var5] = field121[var7];
            field135[var5] = field122[var7];
            field136[var5++] = this.field101[var1];
         } else {
            var12 = field124[var7];
            var13 = field125[var7];
            var14 = this.field101[var1];
            if(var9 >= 50) {
               var15 = (50 - var10) * field141[var9 - var10];
               field134[var5] = var3 + (var12 + ((field124[var6] - var12) * var15 >> 16) << 9) / 50;
               field135[var5] = var4 + (var13 + ((field125[var6] - var13) * var15 >> 16) << 9) / 50;
               field136[var5++] = var14 + ((this.field100[var1] - var14) * var15 >> 16);
            }

            if(var11 >= 50) {
               var15 = (50 - var10) * field141[var11 - var10];
               field134[var5] = var3 + (var12 + ((field124[var8] - var12) * var15 >> 16) << 9) / 50;
               field135[var5] = var4 + (var13 + ((field125[var8] - var13) * var15 >> 16) << 9) / 50;
               field136[var5++] = var14 + ((this.field102[var1] - var14) * var15 >> 16);
            }
         }

         if(var11 >= 50) {
            field134[var5] = field121[var8];
            field135[var5] = field122[var8];
            field136[var5++] = this.field102[var1];
         } else {
            var12 = field124[var8];
            var13 = field125[var8];
            var14 = this.field102[var1];
            if(var10 >= 50) {
               var15 = (50 - var11) * field141[var10 - var11];
               field134[var5] = var3 + (var12 + ((field124[var7] - var12) * var15 >> 16) << 9) / 50;
               field135[var5] = var4 + (var13 + ((field125[var7] - var13) * var15 >> 16) << 9) / 50;
               field136[var5++] = var14 + ((this.field101[var1] - var14) * var15 >> 16);
            }

            if(var9 >= 50) {
               var15 = (50 - var11) * field141[var9 - var11];
               field134[var5] = var3 + (var12 + ((field124[var6] - var12) * var15 >> 16) << 9) / 50;
               field135[var5] = var4 + (var13 + ((field125[var6] - var13) * var15 >> 16) << 9) / 50;
               field136[var5++] = var14 + ((this.field100[var1] - var14) * var15 >> 16);
            }
         }

         var12 = field134[0];
         var13 = field134[1];
         var14 = field134[2];
         var15 = field135[0];
         var3 = field135[1];
         var4 = field135[2];
         if((var12 - var13) * (var4 - var3) - (var15 - var3) * (var14 - var13) > 0) {
            class5.field8 = false;
            if(var5 == 3) {
               if(var12 < 0 || var13 < 0 || var14 < 0 || var12 > class14.field65 || var13 > class14.field65 || var14 > class14.field65) {
                  class5.field8 = true;
               }

               if(this.field103 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field103[var1] & 3;
               }

               if(var6 == 0) {
                  class5.method3(var15, var3, var4, var12, var13, var14, field136[0], field136[1], field136[2]);
               } else if(var6 == 1) {
                  class5.method5(var15, var3, var4, var12, var13, var14, field140[this.field100[var1]]);
               } else if(var6 == 2) {
                  var6 = this.field103[var1] >> 2;
                  var7 = this.field108[var6];
                  var8 = this.field109[var6];
                  var6 = this.field110[var6];
                  class5.method7(var15, var3, var4, var12, var13, var14, field136[0], field136[1], field136[2], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
               } else if(var6 == 3) {
                  var6 = this.field103[var1] >> 2;
                  var7 = this.field108[var6];
                  var8 = this.field109[var6];
                  var6 = this.field110[var6];
                  class5.method7(var15, var3, var4, var12, var13, var14, this.field100[var1], this.field100[var1], this.field100[var1], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
               }
            }

            if(var5 == 4) {
               if(var12 < 0 || var13 < 0 || var14 < 0 || var12 > class14.field65 || var13 > class14.field65 || var14 > class14.field65 || field134[3] < 0 || field134[3] > class14.field65) {
                  class5.field8 = true;
               }

               if(this.field103 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field103[var1] & 3;
               }

               if(var6 == 0) {
                  class5.method3(var15, var3, var4, var12, var13, var14, field136[0], field136[1], field136[2]);
                  class5.method3(var15, var4, field135[3], var12, var14, field134[3], field136[0], field136[2], field136[3]);
                  return;
               }

               if(var6 == 1) {
                  var6 = field140[this.field100[var1]];
                  class5.method5(var15, var3, var4, var12, var13, var14, var6);
                  class5.method5(var15, var4, field135[3], var12, var14, field134[3], var6);
                  return;
               }

               if(var6 == 2) {
                  var6 = this.field103[var1] >> 2;
                  var7 = this.field108[var6];
                  var8 = this.field109[var6];
                  var6 = this.field110[var6];
                  class5.method7(var15, var3, var4, var12, var13, var14, field136[0], field136[1], field136[2], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
                  class5.method7(var15, var4, field135[3], var12, var14, field134[3], field136[0], field136[2], field136[3], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
                  return;
               }

               if(var6 == 3) {
                  var6 = this.field103[var1] >> 2;
                  var7 = this.field108[var6];
                  var8 = this.field109[var6];
                  var6 = this.field110[var6];
                  class5.method7(var15, var3, var4, var12, var13, var14, this.field100[var1], this.field100[var1], this.field100[var1], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
                  class5.method7(var15, var4, field135[3], var12, var14, field134[3], this.field100[var1], this.field100[var1], this.field100[var1], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
               }
            }
         }

      } else {
         int var2 = this.field97[var1];
         var3 = this.field98[var1];
         var4 = this.field99[var1];
         class5.field8 = field119[var1];
         if(this.field105 == null) {
            class5.field11 = 0;
         } else {
            class5.field11 = this.field105[var1];
         }

         if(this.field103 == null) {
            var5 = 0;
         } else {
            var5 = this.field103[var1] & 3;
         }

         if(var5 == 0) {
            class5.method3(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], this.field100[var1], this.field101[var1], this.field102[var1]);
         } else if(var5 == 1) {
            class5.method5(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], field140[this.field100[var1]]);
         } else if(var5 == 2) {
            var5 = this.field103[var1] >> 2;
            var6 = this.field108[var5];
            var7 = this.field109[var5];
            var5 = this.field110[var5];
            class5.method7(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], this.field100[var1], this.field101[var1], this.field102[var1], field124[var6], field124[var7], field124[var5], field125[var6], field125[var7], field125[var5], field126[var6], field126[var7], field126[var5], this.field106[var1]);
         } else {
            if(var5 == 3) {
               var5 = this.field103[var1] >> 2;
               var6 = this.field108[var5];
               var7 = this.field109[var5];
               var5 = this.field110[var5];
               class5.method7(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], this.field100[var1], this.field100[var1], this.field100[var1], field124[var6], field124[var7], field124[var5], field125[var6], field125[var7], field125[var5], field126[var6], field126[var7], field126[var5], this.field106[var1]);
            }

         }
      }
   }

   static {
      new class19();
      field119 = new boolean[4096];
      field120 = new boolean[4096];
      field121 = new int[4096];
      field122 = new int[4096];
      field123 = new int[4096];
      field124 = new int[4096];
      field125 = new int[4096];
      field126 = new int[4096];
      field127 = new int[1500];
      field128 = new int[1500][512];
      field129 = new int[12];
      field130 = new int[12][2000];
      field131 = new int[2000];
      field132 = new int[2000];
      field133 = new int[12];
      field134 = new int[10];
      field135 = new int[10];
      field136 = new int[10];
      field137 = new int[1000];
      field138 = class5.field16;
      field139 = class5.field17;
      field140 = class5.field23;
      field141 = class5.field15;
   }
}
