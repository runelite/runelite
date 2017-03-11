package net.runelite.rsmv;


public final class Model extends class18 {
   public boolean field91 = false;
   private int verticeCount;
   private int[] vertexX;
   private int[] vertexY;
   private int[] vertexZ;
   private int triangleCount;
   private int[] trianglePointsX;
   private int[] trianglePointsY;
   private int[] trianglePointsZ;
   private int[] field100;
   private int[] field101;
   private int[] field102;
   private int[] faceRenderType;
   private int[] field104;
   private int[] faceAlphas;
   private int[] field106;
   private int texTriangleCount;
   private int[] field108;
   private int[] field109;
   private int[] field110;
   private int field111;
   private int field112;
   private int field113;
   private int field114;
   private int[] vertexSkins;
   private int[] triangleSkinValues;
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
         (var13 = field118[0] = new class15()).vertexCount = 0;
         var13.triangleFaceCount = 0;
         var13.texTriangleCount = 0;
      } else {
         Buffer var12;
         (var12 = new Buffer(var0)).offset = var0.length - 18;
         class15 var2;
         (var2 = field118[0] = new class15()).field66 = var0;
         var2.vertexCount = var12.readUnsignedShort();
         var2.triangleFaceCount = var12.readUnsignedShort();
         var2.texTriangleCount = var12.readUnsignedByte();
         int var10 = var12.readUnsignedByte();
         int var3 = var12.readUnsignedByte();
         int var4 = var12.readUnsignedByte();
         int var5 = var12.readUnsignedByte();
         int var6 = var12.readUnsignedByte();
         int var7 = var12.readUnsignedShort();
         int var8 = var12.readUnsignedShort();
         var12.readUnsignedShort();
         int var11 = var12.readUnsignedShort();
         var2.field70 = 0;
         int var9 = 0 + var2.vertexCount;
         var2.field76 = var9;
         var9 += var2.triangleFaceCount;
         var2.field79 = var9;
         if(var3 == 255) {
            var9 += var2.triangleFaceCount;
         } else {
            var2.field79 = -var3 - 1;
         }

         var2.field81 = var9;
         if(var5 == 1) {
            var9 += var2.triangleFaceCount;
         } else {
            var2.field81 = -1;
         }

         var2.field78 = var9;
         if(var10 == 1) {
            var9 += var2.triangleFaceCount;
         } else {
            var2.field78 = -1;
         }

         var2.field74 = var9;
         if(var6 == 1) {
            var9 += var2.vertexCount;
         } else {
            var2.field74 = -1;
         }

         var2.field80 = var9;
         if(var4 == 1) {
            var9 += var2.triangleFaceCount;
         } else {
            var2.field80 = -1;
         }

         var2.field75 = var9;
         var9 += var11;
         var2.field77 = var9;
         var9 += var2.triangleFaceCount << 1;
         var2.field82 = var9;
         var9 += var2.texTriangleCount * 6;
         var2.field71 = var9;
         var9 += var7;
         var2.field72 = var9;
         var9 += var8;
         var2.field73 = var9;
      }
   }

   public static Model method35(int var0) {
      return field118 == null?null:new Model(0);
   }

   public static Model method36(byte[] var0) {
      return new Model(var0);
   }

   private Model() {
   }

   public final void method37(int var1) {
      for(var1 = 0; var1 < this.verticeCount; ++var1) {
         this.vertexX[var1] /= 4;
         this.vertexY[var1] /= 4;
         this.vertexZ[var1] /= 4;
      }

   }

   private Model(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var2.offset = var1.length - 23;
      int verticeCount = var2.readShortv2();
      int triangleCount = var2.readShortv2();
      int textureTriangleCount = var2.readUnsignedByte();
      class15 var12;
      (var12 = field118[0] = new class15()).field66 = var1;
      var12.vertexCount = verticeCount;
      var12.triangleFaceCount = triangleCount;
      var12.texTriangleCount = textureTriangleCount;
      int var165 = var2.readUnsignedByte();
      boolean var13 = ~(1 & var165) == -2;
      boolean var14;
      if(!(var14 = (8 & var165) == 8)) {
         Model var84 = this;
         Buffer var86 = new Buffer(var1);
         Buffer var87 = new Buffer(var1);
         Buffer var88 = new Buffer(var1);
         Buffer var89 = new Buffer(var1);
         Buffer var90 = new Buffer(var1);
         Buffer var91 = new Buffer(var1);
         Buffer var92 = new Buffer(var1);
         var86.offset = var1.length - 23;
         int var93 = var86.readShortv2();
         int var94 = var86.readShortv2();
         int var95 = var86.readUnsignedByte();
         class15 var96;
         (var96 = field118[0] = new class15()).field66 = var1;
         var96.vertexCount = var93;
         var96.triangleFaceCount = var94;
         var96.texTriangleCount = var95;
         int var97 = var86.readUnsignedByte();
         boolean var98 = ~(1 & var97) == -2;
         int var99 = var86.readUnsignedByte();
         int var100 = var86.readUnsignedByte();
         int var101 = var86.readUnsignedByte();
         int var102 = var86.readUnsignedByte();
         int var103 = var86.readUnsignedByte();
         int var104 = var86.readShortv2();
         int var105 = var86.readShortv2();
         int var106 = var86.readShortv2();
         int var107 = var86.readShortv2();
         int var108 = var86.readShortv2();
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
         short[] faceColor = null;
         int var125;
         if(var95 > 0) {
            var114 = new byte[var95];
            var86.offset = 0;

            for(var125 = 0; var125 < var95; ++var125) {
               byte var126;
               if((var126 = var114[var125] = var86.readByte()) == 0) {
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
         int[] vertexX = new int[var93];
         int[] vertexY = new int[var93];
         int[] vertexZ = new int[var93];
         int[] trianglePointsX = new int[var94];
         int[] trianglePointsY = new int[var94];
         int[] trianglePointsZ = new int[var94];
         this.vertexSkins = new int[var93];
         this.faceRenderType = new int[var94];
         this.field104 = new int[var94];
         this.faceAlphas = new int[var94];
         this.triangleSkinValues = new int[var94];
         if(var103 == 1) {
            this.vertexSkins = new int[var93];
         }

         if(var98) {
            this.faceRenderType = new int[var94];
         }

         if(var99 == 255) {
            this.field104 = new int[var94];
         }

         if(var100 == 1) {
            this.faceAlphas = new int[var94];
         }

         if(var101 == 1) {
            this.triangleSkinValues = new int[var94];
         }

         if(var102 == 1) {
            faceColor = new short[var94];
         }

         if(var102 == 1 && var95 > 0) {
            var113 = new byte[var94];
         }

         int[] faceColors = new int[var94];
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

         var86.offset = var95;
         var87.offset = var137;
         var88.offset = var138;
         var89.offset = var139;
         var90.offset = var131;
         int var155 = 0;
         int var156 = 0;
         int var157 = 0;

         int var158;
         int var159;
         int var160;
         int var161;
         int var162;
         for(var158 = 0; var158 < var93; ++var158) {
            var159 = var86.readUnsignedByte();
            var160 = 0;
            if((var159 & 1) != 0) {
               var160 = var87.readShortSmart();
            }

            var161 = 0;
            if((var159 & 2) != 0) {
               var161 = var88.readShortSmart();
            }

            var162 = 0;
            if((var159 & 4) != 0) {
               var162 = var89.readShortSmart();
            }

            vertexX[var158] = var155 + var160;
            vertexY[var158] = var156 + var161;
            vertexZ[var158] = var157 + var162;
            var155 = vertexX[var158];
            var156 = vertexY[var158];
            var157 = vertexZ[var158];
            if(var84.vertexSkins != null) {
               var84.vertexSkins[var158] = var90.readUnsignedByte();
            }
         }

         var86.offset = var136;
         var87.offset = var127;
         var88.offset = var129;
         var89.offset = var132;
         var90.offset = var130;
         var91.offset = var134;
         var92.offset = var135;

         for(var158 = 0; var158 < var94; ++var158) {
            faceColors[var158] = var86.readShortv2();
            if(var97 == 1) {
               var84.faceRenderType[var158] = var87.readByte();
               if(var84.faceRenderType[var158] == 2) {
                  faceColors[var158] = '\uffff';
               }

               var84.faceRenderType[var158] = 0;
            }

            if(var99 == 255) {
               var84.field104[var158] = var88.readByte();
            }

            if(var100 == 1) {
               var84.faceAlphas[var158] = var89.readByte();
               if(var84.faceAlphas[var158] < 0) {
                  var84.faceAlphas[var158] += 256;
               }
            }

            if(var101 == 1) {
               var84.triangleSkinValues[var158] = var90.readUnsignedByte();
            }

            if(var102 == 1) {
               faceColor[var158] = (short)(var91.readShortv2() - 1);
            }

            if(var113 != null) {
               if(faceColor[var158] != -1) {
                  var113[var158] = (byte)(var92.readUnsignedByte() - 1);
               } else {
                  var113[var158] = -1;
               }
            }
         }

         var86.offset = var133;
         var87.offset = var128;
         var158 = 0;
         var159 = 0;
         var160 = 0;
         var161 = 0;

         int var163;
         for(var162 = 0; var162 < var94; ++var162) {
            if((var163 = var87.readUnsignedByte()) == 1) {
               var161 = var158 = var86.readShortSmart() + var161;
               var161 = var159 = var86.readShortSmart() + var161;
               var161 = var160 = var86.readShortSmart() + var161;
               trianglePointsX[var162] = var158;
               trianglePointsY[var162] = var159;
               trianglePointsZ[var162] = var160;
            }

            if(var163 == 2) {
               var159 = var160;
               var161 = var160 = var86.readShortSmart() + var161;
               trianglePointsX[var162] = var158;
               trianglePointsY[var162] = var159;
               trianglePointsZ[var162] = var160;
            }

            if(var163 == 3) {
               var158 = var160;
               var161 = var160 = var86.readShortSmart() + var161;
               trianglePointsX[var162] = var158;
               trianglePointsY[var162] = var159;
               trianglePointsZ[var162] = var160;
            }

            if(var163 == 4) {
               int var164 = var158;
               var158 = var159;
               var159 = var164;
               var161 = var160 = var86.readShortSmart() + var161;
               trianglePointsX[var162] = var158;
               trianglePointsY[var162] = var164;
               trianglePointsZ[var162] = var160;
            }
         }

         var86.offset = var140;
         var87.offset = var141;
         var88.offset = var142;
         var89.offset = var143;
         var90.offset = var144;
         var91.offset = var145;

         for(var162 = 0; var162 < var95; ++var162) {
            if((var163 = var114[var162] & 255) == 0) {
               var152[var162] = var86.readShortv2();
               var153[var162] = var86.readShortv2();
               var154[var162] = var86.readShortv2();
            }

            if(var163 == 1) {
               var152[var162] = var87.readShortv2();
               var153[var162] = var87.readShortv2();
               var154[var162] = var87.readShortv2();
               var120[var162] = var88.readShortv2();
               var122[var162] = var88.readShortv2();
               var121[var162] = var88.readShortv2();
               var118[var162] = var89.readByte();
               var119[var162] = var90.readByte();
               var116[var162] = var91.readByte();
            }

            if(var163 == 2) {
               var152[var162] = var87.readShortv2();
               var153[var162] = var87.readShortv2();
               var154[var162] = var87.readShortv2();
               var120[var162] = var88.readShortv2();
               var122[var162] = var88.readShortv2();
               var121[var162] = var88.readShortv2();
               var118[var162] = var89.readByte();
               var119[var162] = var90.readByte();
               var116[var162] = var91.readByte();
               var117[var162] = var91.readByte();
               var115[var162] = var91.readByte();
            }

            if(var163 == 3) {
               var152[var162] = var87.readShortv2();
               var153[var162] = var87.readShortv2();
               var154[var162] = var87.readShortv2();
               var120[var162] = var88.readShortv2();
               var122[var162] = var88.readShortv2();
               var121[var162] = var88.readShortv2();
               var118[var162] = var89.readByte();
               var119[var162] = var90.readByte();
               var116[var162] = var91.readByte();
            }
         }

         if(var99 != 255) {
            for(var162 = 0; var162 < var94; ++var162) {
               var84.field104[var162] = var99;
            }
         }

         var84.field106 = faceColors;
         var84.verticeCount = var93;
         var84.triangleCount = var94;
         var84.vertexX = vertexX;
         var84.vertexY = vertexY;
         var84.vertexZ = vertexZ;
         var84.trianglePointsX = trianglePointsX;
         var84.trianglePointsY = trianglePointsY;
         var84.trianglePointsZ = trianglePointsZ;
      } else {
         int var166 = 0;
         if(var14) {
            var2.offset -= 7;
            var166 = var2.readUnsignedByte();
            var2.offset += 6;
         }

         if(var166 == 15) {
            this.field91 = true;
         }

         int modelPriority = var2.readUnsignedByte();
         int var15 = var2.readUnsignedByte();
         int var16 = var2.readUnsignedByte();
         int modelTexture = var2.readUnsignedByte();
         int modelVertexSkins = var2.readUnsignedByte();
         int var19 = var2.readShortv2();
         int var20 = var2.readShortv2();
         int var21 = var2.readShortv2();
         int var22 = var2.readShortv2();
         int var23 = var2.readShortv2();
         int textureAmount = 0;
         int var25 = 0;
         int var26 = 0;
         byte[] var27 = null;
         byte[] textureRenderTypes = null;
         byte[] var29 = null;
         byte[] var30 = null;
         byte[] var31 = null;
         byte[] var32 = null;
         byte[] var33 = null;
         int[] var34 = null;
         int[] var35 = null;
         int[] var36 = null;
         short[] var37 = null;
         int position;
         if(textureTriangleCount > 0) {
            textureRenderTypes = new byte[textureTriangleCount];
            var2.offset = 0;

            for(position = 0; position < textureTriangleCount; ++position) {
               byte var39;
               if((var39 = textureRenderTypes[position] = var2.readByte()) == 0) {
                  ++textureAmount;
               }

               if(var39 > 0 && var39 <= 3) {
                  ++var25;
               }

               if(var39 == 2) {
                  ++var26;
               }
            }
         }

         int renderTypePos = position = textureTriangleCount + verticeCount;
         if(var13) {
            position += triangleCount;
         }

         if(var165 == 1) {
            position += triangleCount;
         }

         int var40 = position;
         int var41 = position += triangleCount;
         if(modelPriority == 255) {
            position += triangleCount;
         }

         int var42 = position;
         if(var16 == 1) {
            position += triangleCount;
         }

         int var43 = position;
         if(modelVertexSkins == 1) {
            position += verticeCount;
         }

         int var44 = position;
         if(var15 == 1) {
            position += triangleCount;
         }

         int var45 = position;
         var22 = position += var22;
         if(modelTexture == 1) {
            position += triangleCount << 1;
         }

         int textureCoordPos = position;
         var23 = position += var23;
         int var47 = position += triangleCount << 1;
         int var48 = position += var19;
         var20 = position += var20;
         var21 = position += var21;
         textureAmount = position += textureAmount * 6;
         position += var25 * 6;
         byte var169 = 6;
         if(var166 != 14) {
            if(var166 >= 15) {
               var169 = 9;
            }
         } else {
            var169 = 7;
         }

         int var49 = position;
         int var50 = position += var169 * var25;
         int var51 = position += var25;
         int var64 = position + var25;
         int[] vertexX = new int[verticeCount];
         int[] vertexY = new int[verticeCount];
         int[] vertexZ = new int[verticeCount];
         int[] trianglePointsX = new int[triangleCount];
         int[] trianglePointsY = new int[triangleCount];
         int[] trianglePointsZ = new int[triangleCount];
         this.vertexSkins = new int[verticeCount];
         this.faceRenderType = new int[triangleCount];
         this.field104 = new int[triangleCount];
         this.faceAlphas = new int[triangleCount];
         this.triangleSkinValues = new int[triangleCount];
         if(modelVertexSkins == 1) {
            this.vertexSkins = new int[verticeCount];
         }

         if(var13) {
            this.faceRenderType = new int[triangleCount];
         }

         if(modelPriority == 255) {
            this.field104 = new int[triangleCount];
         }

         if(var15 == 1) {
            this.faceAlphas = new int[triangleCount];
         }

         if(var16 == 1) {
            this.triangleSkinValues = new int[triangleCount];
         }

         if(modelTexture == 1) {
            var37 = new short[triangleCount];
         }

         if(modelTexture == 1 && textureTriangleCount > 0) {
            var27 = new byte[triangleCount];
         }

         int[] var167 = new int[triangleCount];
         int[] var71 = null;
         int[] var72 = null;
         int[] var73 = null;
         if(textureTriangleCount > 0) {
            var71 = new int[textureTriangleCount];
            var72 = new int[textureTriangleCount];
            var73 = new int[textureTriangleCount];
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

         var2.offset = textureTriangleCount;
         var3.offset = var47;
         var4.offset = var48;
         var5.offset = var20;
         var6.offset = var43;
         int var74 = 0;
         int var75 = 0;
         int var76 = 0;

         int var77;
         int var78;
         int var79;
         int var80;
         int var81;
         for(var77 = 0; var77 < verticeCount; ++var77) {
            var78 = var2.readUnsignedByte();
            var79 = 0;
            if((var78 & 1) != 0) {
               var79 = var3.readShortSmart();
            }

            var80 = 0;
            if((var78 & 2) != 0) {
               var80 = var4.readShortSmart();
            }

            var81 = 0;
            if((var78 & 4) != 0) {
               var81 = var5.readShortSmart();
            }

            vertexX[var77] = var74 + var79;
            vertexY[var77] = var75 + var80;
            vertexZ[var77] = var76 + var81;
            var74 = vertexX[var77];
            var75 = vertexY[var77];
            var76 = vertexZ[var77];
            if(this.vertexSkins != null) {
               this.vertexSkins[var77] = var6.readUnsignedByte();
            }
         }

         var2.offset = var23;
         var3.offset = renderTypePos;
         var4.offset = var41;
         var5.offset = var44;
         var6.offset = var42;
         var7.offset = var22;
         var8.offset = textureCoordPos;

         for(var77 = 0; var77 < triangleCount; ++var77) {
            var167[var77] = var2.readShortv2();
            if(var165 == 1) {
               this.faceRenderType[var77] = var3.readByte();
               if(this.faceRenderType[var77] == 2) {
                  var167[var77] = '\uffff';
               }

               this.faceRenderType[var77] = 0;
            }

            if(modelPriority == 255) {
               this.field104[var77] = var4.readByte();
            }

            if(var15 == 1) {
               this.faceAlphas[var77] = var5.readByte();
               if(this.faceAlphas[var77] < 0) {
                  this.faceAlphas[var77] += 256;
               }
            }

            if(var16 == 1) {
               this.triangleSkinValues[var77] = var6.readUnsignedByte();
            }

            if(modelTexture == 1) {
               var37[var77] = (short)(var7.readShortv2() - 1);
            }

            if(var27 != null) {
               if(var37[var77] != -1) {
                  var27[var77] = (byte)(var8.readUnsignedByte() - 1);
               } else {
                  var27[var77] = -1;
               }
            }
         }

         var2.offset = var45;
         var3.offset = var40;
         var77 = 0;
         var78 = 0;
         var79 = 0;
         var80 = 0;

         int var82;
         for(var81 = 0; var81 < triangleCount; ++var81) {
            if((var82 = var3.readUnsignedByte()) == 1) {
               var80 = var77 = var2.readShortSmart() + var80;
               var80 = var78 = var2.readShortSmart() + var80;
               var80 = var79 = var2.readShortSmart() + var80;
               trianglePointsX[var81] = var77;
               trianglePointsY[var81] = var78;
               trianglePointsZ[var81] = var79;
            }

            if(var82 == 2) {
               var78 = var79;
               var80 = var79 = var2.readShortSmart() + var80;
               trianglePointsX[var81] = var77;
               trianglePointsY[var81] = var78;
               trianglePointsZ[var81] = var79;
            }

            if(var82 == 3) {
               var77 = var79;
               var80 = var79 = var2.readShortSmart() + var80;
               trianglePointsX[var81] = var77;
               trianglePointsY[var81] = var78;
               trianglePointsZ[var81] = var79;
            }

            if(var82 == 4) {
               int var83 = var77;
               var77 = var78;
               var78 = var83;
               var80 = var79 = var2.readShortSmart() + var80;
               trianglePointsX[var81] = var77;
               trianglePointsY[var81] = var83;
               trianglePointsZ[var81] = var79;
            }
         }

         var2.offset = var21;
         var3.offset = textureAmount;
         var4.offset = var49;
         var5.offset = var50;
         var6.offset = var51;
         var7.offset = var64;

         for(var81 = 0; var81 < textureTriangleCount; ++var81) {
            if((var82 = textureRenderTypes[var81] & 255) == 0) {
               var71[var81] = var2.readShortv2();
               var72[var81] = var2.readShortv2();
               var73[var81] = var2.readShortv2();
            }

            if(var82 == 1) {
               var71[var81] = var3.readShortv2();
               var72[var81] = var3.readShortv2();
               var73[var81] = var3.readShortv2();
               if(var166 < 15) {
                  var34[var81] = var4.readShortv2();
                  if(var166 >= 14) {
                     var36[var81] = var4.readMid();
                  } else {
                     var36[var81] = var4.readShortv2();
                  }

                  var35[var81] = var4.readShortv2();
               } else {
                  var34[var81] = var4.readMid();
                  var36[var81] = var4.readMid();
                  var35[var81] = var4.readMid();
               }

               var32[var81] = var5.readByte();
               var33[var81] = var6.readByte();
               var30[var81] = var7.readByte();
            }

            if(var82 == 2) {
               var71[var81] = var3.readShortv2();
               var72[var81] = var3.readShortv2();
               var73[var81] = var3.readShortv2();
               if(var166 >= 15) {
                  var34[var81] = var4.readMid();
                  var36[var81] = var4.readMid();
                  var35[var81] = var4.readMid();
               } else {
                  var34[var81] = var4.readShortv2();
                  if(var166 < 14) {
                     var36[var81] = var4.readShortv2();
                  } else {
                     var36[var81] = var4.readMid();
                  }

                  var35[var81] = var4.readShortv2();
               }

               var32[var81] = var5.readByte();
               var33[var81] = var6.readByte();
               var30[var81] = var7.readByte();
               var31[var81] = var7.readByte();
               var29[var81] = var7.readByte();
            }

            if(var82 == 3) {
               var71[var81] = var3.readShortv2();
               var72[var81] = var3.readShortv2();
               var73[var81] = var3.readShortv2();
               if(var166 < 15) {
                  var34[var81] = var4.readShortv2();
                  if(var166 < 14) {
                     var36[var81] = var4.readShortv2();
                  } else {
                     var36[var81] = var4.readMid();
                  }

                  var35[var81] = var4.readShortv2();
               } else {
                  var34[var81] = var4.readMid();
                  var36[var81] = var4.readMid();
                  var35[var81] = var4.readMid();
               }

               var32[var81] = var5.readByte();
               var33[var81] = var6.readByte();
               var30[var81] = var7.readByte();
            }
         }

         if(modelPriority != 255) {
            for(var81 = 0; var81 < triangleCount; ++var81) {
               this.field104[var81] = modelPriority;
            }
         }

         this.field106 = var167;
         this.verticeCount = verticeCount;
         this.triangleCount = triangleCount;
         this.vertexX = vertexX;
         this.vertexY = vertexY;
         this.vertexZ = vertexZ;
         this.trianglePointsX = trianglePointsX;
         this.trianglePointsY = trianglePointsY;
         this.trianglePointsZ = trianglePointsZ;
      }
   }

   private Model(int var1) {
      class15 var15 = field118[var1];
      this.verticeCount = var15.vertexCount;
      this.triangleCount = var15.triangleFaceCount;
      this.texTriangleCount = var15.texTriangleCount;
      this.vertexX = new int[this.verticeCount];
      this.vertexY = new int[this.verticeCount];
      this.vertexZ = new int[this.verticeCount];
      this.trianglePointsX = new int[this.triangleCount];
      this.trianglePointsY = new int[this.triangleCount];
      this.trianglePointsZ = new int[this.triangleCount];
      this.field108 = new int[this.texTriangleCount];
      this.field109 = new int[this.texTriangleCount];
      this.field110 = new int[this.texTriangleCount];
      if(var15.field74 >= 0) {
         this.vertexSkins = new int[this.verticeCount];
      }

      if(var15.field78 >= 0) {
         this.faceRenderType = new int[this.triangleCount];
      }

      if(var15.field79 >= 0) {
         this.field104 = new int[this.triangleCount];
      }

      if(var15.field80 >= 0) {
         this.faceAlphas = new int[this.triangleCount];
      }

      if(var15.field81 >= 0) {
         this.triangleSkinValues = new int[this.triangleCount];
      }

      this.field106 = new int[this.triangleCount];
      Buffer var2;
      (var2 = new Buffer(var15.field66)).offset = 0;
      Buffer var3;
      (var3 = new Buffer(var15.field66)).offset = var15.field71;
      Buffer var4;
      (var4 = new Buffer(var15.field66)).offset = var15.field72;
      Buffer var5;
      (var5 = new Buffer(var15.field66)).offset = var15.field73;
      Buffer var6;
      (var6 = new Buffer(var15.field66)).offset = var15.field74;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      for(var10 = 0; var10 < this.verticeCount; ++var10) {
         var11 = var2.readUnsignedByte();
         var12 = 0;
         if((var11 & 1) != 0) {
            var12 = var3.readShortSmart();
         }

         var13 = 0;
         if((var11 & 2) != 0) {
            var13 = var4.readShortSmart();
         }

         var14 = 0;
         if((var11 & 4) != 0) {
            var14 = var5.readShortSmart();
         }

         this.vertexX[var10] = var7 + var12;
         this.vertexY[var10] = var8 + var13;
         this.vertexZ[var10] = var9 + var14;
         var7 = this.vertexX[var10];
         var8 = this.vertexY[var10];
         var9 = this.vertexZ[var10];
         if(this.vertexSkins != null) {
            this.vertexSkins[var10] = var6.readUnsignedByte();
         }
      }

      var2.offset = var15.field77;
      var3.offset = var15.field78;
      var4.offset = var15.field79;
      var5.offset = var15.field80;
      var6.offset = var15.field81;

      for(var10 = 0; var10 < this.triangleCount; ++var10) {
         this.field106[var10] = var2.readUnsignedShort();
         if(this.faceRenderType != null) {
            this.faceRenderType[var10] = var3.readUnsignedByte();
         }

         if(this.field104 != null) {
            this.field104[var10] = var4.readUnsignedByte();
         }

         if(this.faceAlphas != null) {
            this.faceAlphas[var10] = var5.readUnsignedByte();
         }

         if(this.triangleSkinValues != null) {
            this.triangleSkinValues[var10] = var6.readUnsignedByte();
         }
      }

      var2.offset = var15.field75;
      var3.offset = var15.field76;
      var10 = 0;
      var11 = 0;
      var12 = 0;
      var13 = 0;

      for(var14 = 0; var14 < this.triangleCount; ++var14) {
         int var16;
         if((var16 = var3.readUnsignedByte()) == 1) {
            var13 = var10 = var2.readShortSmart() + var13;
            var13 = var11 = var2.readShortSmart() + var13;
            var13 = var12 = var2.readShortSmart() + var13;
            this.trianglePointsX[var14] = var10;
            this.trianglePointsY[var14] = var11;
            this.trianglePointsZ[var14] = var12;
         }

         if(var16 == 2) {
            var11 = var12;
            var13 = var12 = var2.readShortSmart() + var13;
            this.trianglePointsX[var14] = var10;
            this.trianglePointsY[var14] = var11;
            this.trianglePointsZ[var14] = var12;
         }

         if(var16 == 3) {
            var10 = var12;
            var13 = var12 = var2.readShortSmart() + var13;
            this.trianglePointsX[var14] = var10;
            this.trianglePointsY[var14] = var11;
            this.trianglePointsZ[var14] = var12;
         }

         if(var16 == 4) {
            var16 = var10;
            var10 = var11;
            var11 = var16;
            var13 = var12 = var2.readShortSmart() + var13;
            this.trianglePointsX[var14] = var10;
            this.trianglePointsY[var14] = var16;
            this.trianglePointsZ[var14] = var12;
         }
      }

      var2.offset = var15.field82;

      for(var14 = 0; var14 < this.texTriangleCount; ++var14) {
         this.field108[var14] = var2.readUnsignedShort();
         this.field109[var14] = var2.readUnsignedShort();
         this.field110[var14] = var2.readUnsignedShort();
      }

   }

   public final void method38(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      var1 = (int)Math.sqrt(5100.0D);
      var1 = var1 * 768 >> 8;
      if(this.field100 == null) {
         this.field100 = new int[this.triangleCount];
         this.field101 = new int[this.triangleCount];
         this.field102 = new int[this.triangleCount];
      }

      if(super.field89 == null) {
         super.field89 = new class16[this.verticeCount];

         for(var2 = 0; var2 < this.verticeCount; ++var2) {
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
      for(var2 = 0; var2 < this.triangleCount; ++var2) {
         var3 = this.trianglePointsX[var2];
         var4 = this.trianglePointsY[var2];
         var5 = this.trianglePointsZ[var2];
         var20 = this.vertexX[var4] - this.vertexX[var3];
         var7 = this.vertexY[var4] - this.vertexY[var3];
         var8 = this.vertexZ[var4] - this.vertexZ[var3];
         var9 = this.vertexX[var5] - this.vertexX[var3];
         var10 = this.vertexY[var5] - this.vertexY[var3];
         var11 = this.vertexZ[var5] - this.vertexZ[var3];
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
         if(this.faceRenderType != null && (this.faceRenderType[var2] & 1) != 0) {
            var3 = 64 + (var12 * -50 + var8 * -10 + var20 * -50) / (var1 + var1 / 2);
            this.field100[var2] = method39(this.field106[var2], var3, this.faceRenderType[var2]);
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
      Model var14 = this;

      for(var7 = 0; var7 < var14.triangleCount; ++var7) {
         var8 = var14.trianglePointsX[var7];
         var9 = var14.trianglePointsY[var7];
         var10 = var14.trianglePointsZ[var7];
         if(var14.faceRenderType == null) {
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
         } else if((var14.faceRenderType[var7] & 1) == 0) {
            var11 = var14.field106[var7];
            var12 = var14.faceRenderType[var7];
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
         var14.vertexSkins = null;
         var14.triangleSkinValues = null;
         if(var14.faceRenderType != null) {
            for(var7 = 0; var7 < var14.triangleCount; ++var7) {
               if((var14.faceRenderType[var7] & 2) == 2) {
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

      for(var2 = 0; var2 < var14.verticeCount; ++var2) {
         var3 = var14.vertexX[var2];
         var4 = var14.vertexY[var2];
         var5 = var14.vertexZ[var2];
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

      for(int var17 = 0; var17 < this.verticeCount; ++var17) {
         int var18 = this.vertexX[var17];
         int var19 = this.vertexY[var17];
         int var20 = this.vertexZ[var17];
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
         if(this.texTriangleCount > 0) {
            field124[var17] = var18;
            field125[var17] = var21;
            field126[var17] = var20;
         }
      }

      try {
         boolean var28 = false;
         var28 = false;
         var28 = false;
         Model var22 = this;

         for(var2 = 0; var2 < var22.field113; ++var2) {
            field127[var2] = 0;
         }

         for(var2 = 0; var2 < var22.triangleCount; ++var2) {
            if(var22.faceRenderType == null || var22.faceRenderType[var2] != -1) {
               var3 = var22.trianglePointsX[var2];
               var4 = var22.trianglePointsY[var2];
               var5 = var22.trianglePointsZ[var2];
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
         var6 = this.trianglePointsX[var1];
         var7 = this.trianglePointsY[var1];
         int var8 = this.trianglePointsZ[var1];
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

               if(this.faceRenderType == null) {
                  var6 = 0;
               } else {
                  var6 = this.faceRenderType[var1] & 3;
               }

               if(var6 == 0) {
                  class5.method3(var15, var3, var4, var12, var13, var14, field136[0], field136[1], field136[2]);
               } else if(var6 == 1) {
                  class5.method5(var15, var3, var4, var12, var13, var14, field140[this.field100[var1]]);
               } else if(var6 == 2) {
                  var6 = this.faceRenderType[var1] >> 2;
                  var7 = this.field108[var6];
                  var8 = this.field109[var6];
                  var6 = this.field110[var6];
                  class5.method7(var15, var3, var4, var12, var13, var14, field136[0], field136[1], field136[2], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
               } else if(var6 == 3) {
                  var6 = this.faceRenderType[var1] >> 2;
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

               if(this.faceRenderType == null) {
                  var6 = 0;
               } else {
                  var6 = this.faceRenderType[var1] & 3;
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
                  var6 = this.faceRenderType[var1] >> 2;
                  var7 = this.field108[var6];
                  var8 = this.field109[var6];
                  var6 = this.field110[var6];
                  class5.method7(var15, var3, var4, var12, var13, var14, field136[0], field136[1], field136[2], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
                  class5.method7(var15, var4, field135[3], var12, var14, field134[3], field136[0], field136[2], field136[3], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
                  return;
               }

               if(var6 == 3) {
                  var6 = this.faceRenderType[var1] >> 2;
                  var7 = this.field108[var6];
                  var8 = this.field109[var6];
                  var6 = this.field110[var6];
                  class5.method7(var15, var3, var4, var12, var13, var14, this.field100[var1], this.field100[var1], this.field100[var1], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
                  class5.method7(var15, var4, field135[3], var12, var14, field134[3], this.field100[var1], this.field100[var1], this.field100[var1], field124[var7], field124[var8], field124[var6], field125[var7], field125[var8], field125[var6], field126[var7], field126[var8], field126[var6], this.field106[var1]);
               }
            }
         }

      } else {
         int var2 = this.trianglePointsX[var1];
         var3 = this.trianglePointsY[var1];
         var4 = this.trianglePointsZ[var1];
         class5.field8 = field119[var1];
         if(this.faceAlphas == null) {
            class5.field11 = 0;
         } else {
            class5.field11 = this.faceAlphas[var1];
         }

         if(this.faceRenderType == null) {
            var5 = 0;
         } else {
            var5 = this.faceRenderType[var1] & 3;
         }

         if(var5 == 0) {
            class5.method3(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], this.field100[var1], this.field101[var1], this.field102[var1]);
         } else if(var5 == 1) {
            class5.method5(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], field140[this.field100[var1]]);
         } else if(var5 == 2) {
            var5 = this.faceRenderType[var1] >> 2;
            var6 = this.field108[var5];
            var7 = this.field109[var5];
            var5 = this.field110[var5];
            class5.method7(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], this.field100[var1], this.field101[var1], this.field102[var1], field124[var6], field124[var7], field124[var5], field125[var6], field125[var7], field125[var5], field126[var6], field126[var7], field126[var5], this.field106[var1]);
         } else {
            if(var5 == 3) {
               var5 = this.faceRenderType[var1] >> 2;
               var6 = this.field108[var5];
               var7 = this.field109[var5];
               var5 = this.field110[var5];
               class5.method7(field122[var2], field122[var3], field122[var4], field121[var2], field121[var3], field121[var4], this.field100[var1], this.field100[var1], this.field100[var1], field124[var6], field124[var7], field124[var5], field125[var6], field125[var7], field125[var5], field126[var6], field126[var7], field126[var5], this.field106[var1]);
            }

         }
      }
   }

   static {
      new Model();
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
