import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("ModelData")
public class ModelData extends Entity {
   @ObfuscatedName("aw")
   static int[] field548;
   @ObfuscatedName("al")
   static int[] field549;
   @ObfuscatedName("ab")
   static int field550;
   @ObfuscatedName("ae")
   @Export("ModelData_sine")
   static int[] ModelData_sine;
   @ObfuscatedName("at")
   @Export("ModelData_cosine")
   static int[] ModelData_cosine;
   @ObfuscatedName("m")
   @Export("verticesCount")
   int verticesCount;
   @ObfuscatedName("f")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("q")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("w")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("o")
   @Export("faceCount")
   int faceCount;
   @ObfuscatedName("u")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("g")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("l")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("e")
   byte[] field551;
   @ObfuscatedName("x")
   byte[] field552;
   @ObfuscatedName("d")
   @Export("faceAlphas")
   byte[] faceAlphas;
   @ObfuscatedName("k")
   @Export("textureCoords")
   byte[] textureCoords;
   @ObfuscatedName("n")
   @Export("faceColors")
   short[] faceColors;
   @ObfuscatedName("i")
   @Export("faceTextures")
   short[] faceTextures;
   @ObfuscatedName("a")
   byte field553;
   @ObfuscatedName("z")
   int field554;
   @ObfuscatedName("j")
   @Export("textureRenderTypes")
   byte[] textureRenderTypes;
   @ObfuscatedName("s")
   @Export("texTriangleX")
   short[] texTriangleX;
   @ObfuscatedName("t")
   @Export("texTriangleY")
   short[] texTriangleY;
   @ObfuscatedName("y")
   @Export("texTriangleZ")
   short[] texTriangleZ;
   @ObfuscatedName("h")
   int[] field555;
   @ObfuscatedName("b")
   int[] field556;
   @ObfuscatedName("c")
   @Export("vertexLabels")
   int[][] vertexLabels;
   @ObfuscatedName("r")
   @Export("faceLabelsAlpha")
   int[][] faceLabelsAlpha;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lel;"
   )
   @Export("faceNormals")
   FaceNormal[] faceNormals;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Ldq;"
   )
   VertexNormal[] field557;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "[Ldq;"
   )
   VertexNormal[] field558;
   @ObfuscatedName("aq")
   public short field559;
   @ObfuscatedName("aj")
   public short field560;
   @ObfuscatedName("av")
   @Export("isBoundsCalculated")
   boolean isBoundsCalculated;
   @ObfuscatedName("ar")
   int field561;
   @ObfuscatedName("ac")
   int field562;
   @ObfuscatedName("ay")
   int field563;
   @ObfuscatedName("ah")
   int field564;
   @ObfuscatedName("ak")
   int field565;

   ModelData() {
      this.verticesCount = 0;
      this.faceCount = 0;
      this.field553 = 0;
      this.isBoundsCalculated = false;
   }

   @ObfuscatedSignature(
      signature = "([Ldw;I)V"
   )
   public ModelData(ModelData[] var1, int var2) {
      this.verticesCount = 0;
      this.faceCount = 0;
      this.field553 = 0;
      this.isBoundsCalculated = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.verticesCount = 0;
      this.faceCount = 0;
      this.field554 = 0;
      this.field553 = -1;

      int var9;
      ModelData var10;
      for (var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if (var10 != null) {
            this.verticesCount += var10.verticesCount;
            this.faceCount += var10.faceCount;
            this.field554 += var10.field554;
            if (var10.field552 != null) {
               var4 = true;
            } else {
               if (this.field553 == -1) {
                  this.field553 = var10.field553;
               }

               if (this.field553 != var10.field553) {
                  var4 = true;
               }
            }

            var3 |= var10.field551 != null;
            var5 |= var10.faceAlphas != null;
            var6 |= var10.field556 != null;
            var7 |= var10.faceTextures != null;
            var8 |= var10.textureCoords != null;
         }
      }

      this.verticesX = new int[this.verticesCount];
      this.verticesY = new int[this.verticesCount];
      this.verticesZ = new int[this.verticesCount];
      this.field555 = new int[this.verticesCount];
      this.indices1 = new int[this.faceCount];
      this.indices2 = new int[this.faceCount];
      this.indices3 = new int[this.faceCount];
      if (var3) {
         this.field551 = new byte[this.faceCount];
      }

      if (var4) {
         this.field552 = new byte[this.faceCount];
      }

      if (var5) {
         this.faceAlphas = new byte[this.faceCount];
      }

      if (var6) {
         this.field556 = new int[this.faceCount];
      }

      if (var7) {
         this.faceTextures = new short[this.faceCount];
      }

      if (var8) {
         this.textureCoords = new byte[this.faceCount];
      }

      this.faceColors = new short[this.faceCount];
      if (this.field554 > 0) {
         this.textureRenderTypes = new byte[this.field554];
         this.texTriangleX = new short[this.field554];
         this.texTriangleY = new short[this.field554];
         this.texTriangleZ = new short[this.field554];
      }

      this.verticesCount = 0;
      this.faceCount = 0;
      this.field554 = 0;

      for (var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if (var10 != null) {
            int var11;
            for (var11 = 0; var11 < var10.faceCount; ++var11) {
               if (var3 && var10.field551 != null) {
                  this.field551[this.faceCount] = var10.field551[var11];
               }

               if (var4) {
                  if (var10.field552 != null) {
                     this.field552[this.faceCount] = var10.field552[var11];
                  } else {
                     this.field552[this.faceCount] = var10.field553;
                  }
               }

               if (var5 && var10.faceAlphas != null) {
                  this.faceAlphas[this.faceCount] = var10.faceAlphas[var11];
               }

               if (var6 && var10.field556 != null) {
                  this.field556[this.faceCount] = var10.field556[var11];
               }

               if (var7) {
                  if (var10.faceTextures != null) {
                     this.faceTextures[this.faceCount] = var10.faceTextures[var11];
                  } else {
                     this.faceTextures[this.faceCount] = -1;
                  }
               }

               if (var8) {
                  if (var10.textureCoords != null && var10.textureCoords[var11] != -1) {
                     this.textureCoords[this.faceCount] = (byte)(this.field554 + var10.textureCoords[var11]);
                  } else {
                     this.textureCoords[this.faceCount] = -1;
                  }
               }

               this.faceColors[this.faceCount] = var10.faceColors[var11];
               this.indices1[this.faceCount] = this.method205(var10, var10.indices1[var11]);
               this.indices2[this.faceCount] = this.method205(var10, var10.indices2[var11]);
               this.indices3[this.faceCount] = this.method205(var10, var10.indices3[var11]);
               ++this.faceCount;
            }

            for (var11 = 0; var11 < var10.field554; ++var11) {
               byte var12 = this.textureRenderTypes[this.field554] = var10.textureRenderTypes[var11];
               if (var12 == 0) {
                  this.texTriangleX[this.field554] = (short)this.method205(var10, var10.texTriangleX[var11]);
                  this.texTriangleY[this.field554] = (short)this.method205(var10, var10.texTriangleY[var11]);
                  this.texTriangleZ[this.field554] = (short)this.method205(var10, var10.texTriangleZ[var11]);
               }

               ++this.field554;
            }
         }
      }

   }

   ModelData(byte[] var1) {
      this.verticesCount = 0;
      this.faceCount = 0;
      this.field553 = 0;
      this.isBoundsCalculated = false;
      if (var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method203(var1);
      } else {
         this.method204(var1);
      }

   }

   @ObfuscatedSignature(
      signature = "(Ldw;ZZZZ)V",
      garbageValue = "1"
   )
   public ModelData(ModelData var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.verticesCount = 0;
      this.faceCount = 0;
      this.field553 = 0;
      this.isBoundsCalculated = false;
      this.verticesCount = var1.verticesCount;
      this.faceCount = var1.faceCount;
      this.field554 = var1.field554;
      int var6;
      if (var2) {
         this.verticesX = var1.verticesX;
         this.verticesY = var1.verticesY;
         this.verticesZ = var1.verticesZ;
      } else {
         this.verticesX = new int[this.verticesCount];
         this.verticesY = new int[this.verticesCount];
         this.verticesZ = new int[this.verticesCount];

         for (var6 = 0; var6 < this.verticesCount; ++var6) {
            this.verticesX[var6] = var1.verticesX[var6];
            this.verticesY[var6] = var1.verticesY[var6];
            this.verticesZ[var6] = var1.verticesZ[var6];
         }
      }

      if (var3) {
         this.faceColors = var1.faceColors;
      } else {
         this.faceColors = new short[this.faceCount];

         for (var6 = 0; var6 < this.faceCount; ++var6) {
            this.faceColors[var6] = var1.faceColors[var6];
         }
      }

      if (!var4 && var1.faceTextures != null) {
         this.faceTextures = new short[this.faceCount];

         for (var6 = 0; var6 < this.faceCount; ++var6) {
            this.faceTextures[var6] = var1.faceTextures[var6];
         }
      } else {
         this.faceTextures = var1.faceTextures;
      }

      this.faceAlphas = var1.faceAlphas;
      this.indices1 = var1.indices1;
      this.indices2 = var1.indices2;
      this.indices3 = var1.indices3;
      this.field551 = var1.field551;
      this.field552 = var1.field552;
      this.textureCoords = var1.textureCoords;
      this.field553 = var1.field553;
      this.textureRenderTypes = var1.textureRenderTypes;
      this.texTriangleX = var1.texTriangleX;
      this.texTriangleY = var1.texTriangleY;
      this.texTriangleZ = var1.texTriangleZ;
      this.field555 = var1.field555;
      this.field556 = var1.field556;
      this.vertexLabels = var1.vertexLabels;
      this.faceLabelsAlpha = var1.faceLabelsAlpha;
      this.field557 = var1.field557;
      this.faceNormals = var1.faceNormals;
      this.field558 = var1.field558;
      this.field559 = var1.field559;
      this.field560 = var1.field560;
   }

   @ObfuscatedName("f")
   void method203(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var2.index = var1.length - 23;
      int var9 = var2.readUnsignedShort();
      int var10 = var2.readUnsignedShort();
      int var11 = var2.readUnsignedByte();
      int var12 = var2.readUnsignedByte();
      int var13 = var2.readUnsignedByte();
      int var14 = var2.readUnsignedByte();
      int var15 = var2.readUnsignedByte();
      int var16 = var2.readUnsignedByte();
      int var17 = var2.readUnsignedByte();
      int var18 = var2.readUnsignedShort();
      int var19 = var2.readUnsignedShort();
      int var20 = var2.readUnsignedShort();
      int var21 = var2.readUnsignedShort();
      int var22 = var2.readUnsignedShort();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if (var11 > 0) {
         this.textureRenderTypes = new byte[var11];
         var2.index = 0;

         for (var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.textureRenderTypes[var26] = var2.readByte();
            if (var27 == 0) {
               ++var23;
            }

            if (var27 >= 1 && var27 <= 3) {
               ++var24;
            }

            if (var27 == 2) {
               ++var25;
            }
         }
      }

      var26 = var11 + var9;
      int var56 = var26;
      if (var12 == 1) {
         var26 += var10;
      }

      int var28 = var26;
      var26 += var10;
      int var29 = var26;
      if (var13 == 255) {
         var26 += var10;
      }

      int var30 = var26;
      if (var15 == 1) {
         var26 += var10;
      }

      int var31 = var26;
      if (var17 == 1) {
         var26 += var9;
      }

      int var32 = var26;
      if (var14 == 1) {
         var26 += var10;
      }

      int var33 = var26;
      var26 += var21;
      int var34 = var26;
      if (var16 == 1) {
         var26 += var10 * 2;
      }

      int var35 = var26;
      var26 += var22;
      int var36 = var26;
      var26 += var10 * 2;
      int var37 = var26;
      var26 += var18;
      int var38 = var26;
      var26 += var19;
      int var39 = var26;
      var26 += var20;
      int var40 = var26;
      var26 += var23 * 6;
      int var41 = var26;
      var26 += var24 * 6;
      int var42 = var26;
      var26 += var24 * 6;
      int var43 = var26;
      var26 += var24 * 2;
      int var44 = var26;
      var26 += var24;
      int var45 = var26;
      var26 += var24 * 2 + var25 * 2;
      this.verticesCount = var9;
      this.faceCount = var10;
      this.field554 = var11;
      this.verticesX = new int[var9];
      this.verticesY = new int[var9];
      this.verticesZ = new int[var9];
      this.indices1 = new int[var10];
      this.indices2 = new int[var10];
      this.indices3 = new int[var10];
      if (var17 == 1) {
         this.field555 = new int[var9];
      }

      if (var12 == 1) {
         this.field551 = new byte[var10];
      }

      if (var13 == 255) {
         this.field552 = new byte[var10];
      } else {
         this.field553 = (byte)var13;
      }

      if (var14 == 1) {
         this.faceAlphas = new byte[var10];
      }

      if (var15 == 1) {
         this.field556 = new int[var10];
      }

      if (var16 == 1) {
         this.faceTextures = new short[var10];
      }

      if (var16 == 1 && var11 > 0) {
         this.textureCoords = new byte[var10];
      }

      this.faceColors = new short[var10];
      if (var11 > 0) {
         this.texTriangleX = new short[var11];
         this.texTriangleY = new short[var11];
         this.texTriangleZ = new short[var11];
      }

      var2.index = var11;
      var3.index = var37;
      var4.index = var38;
      var5.index = var39;
      var6.index = var31;
      int var46 = 0;
      int var47 = 0;
      int var48 = 0;

      int var49;
      int var50;
      int var51;
      int var52;
      int var53;
      for (var49 = 0; var49 < var9; ++var49) {
         var50 = var2.readUnsignedByte();
         var51 = 0;
         if ((var50 & 1) != 0) {
            var51 = var3.method47();
         }

         var52 = 0;
         if ((var50 & 2) != 0) {
            var52 = var4.method47();
         }

         var53 = 0;
         if ((var50 & 4) != 0) {
            var53 = var5.method47();
         }

         this.verticesX[var49] = var46 + var51;
         this.verticesY[var49] = var47 + var52;
         this.verticesZ[var49] = var48 + var53;
         var46 = this.verticesX[var49];
         var47 = this.verticesY[var49];
         var48 = this.verticesZ[var49];
         if (var17 == 1) {
            this.field555[var49] = var6.readUnsignedByte();
         }
      }

      var2.index = var36;
      var3.index = var56;
      var4.index = var29;
      var5.index = var32;
      var6.index = var30;
      var7.index = var34;
      var8.index = var35;

      for (var49 = 0; var49 < var10; ++var49) {
         this.faceColors[var49] = (short)var2.readUnsignedShort();
         if (var12 == 1) {
            this.field551[var49] = var3.readByte();
         }

         if (var13 == 255) {
            this.field552[var49] = var4.readByte();
         }

         if (var14 == 1) {
            this.faceAlphas[var49] = var5.readByte();
         }

         if (var15 == 1) {
            this.field556[var49] = var6.readUnsignedByte();
         }

         if (var16 == 1) {
            this.faceTextures[var49] = (short)(var7.readUnsignedShort() - 1);
         }

         if (this.textureCoords != null && this.faceTextures[var49] != -1) {
            this.textureCoords[var49] = (byte)(var8.readUnsignedByte() - 1);
         }
      }

      var2.index = var33;
      var3.index = var28;
      var49 = 0;
      var50 = 0;
      var51 = 0;
      var52 = 0;

      int var54;
      for (var53 = 0; var53 < var10; ++var53) {
         var54 = var3.readUnsignedByte();
         if (var54 == 1) {
            var49 = var2.method47() + var52;
            var50 = var2.method47() + var49;
            var51 = var2.method47() + var50;
            var52 = var51;
            this.indices1[var53] = var49;
            this.indices2[var53] = var50;
            this.indices3[var53] = var51;
         }

         if (var54 == 2) {
            var50 = var51;
            var51 = var2.method47() + var52;
            var52 = var51;
            this.indices1[var53] = var49;
            this.indices2[var53] = var50;
            this.indices3[var53] = var51;
         }

         if (var54 == 3) {
            var49 = var51;
            var51 = var2.method47() + var52;
            var52 = var51;
            this.indices1[var53] = var49;
            this.indices2[var53] = var50;
            this.indices3[var53] = var51;
         }

         if (var54 == 4) {
            int var55 = var49;
            var49 = var50;
            var50 = var55;
            var51 = var2.method47() + var52;
            var52 = var51;
            this.indices1[var53] = var49;
            this.indices2[var53] = var55;
            this.indices3[var53] = var51;
         }
      }

      var2.index = var40;
      var3.index = var41;
      var4.index = var42;
      var5.index = var43;
      var6.index = var44;
      var7.index = var45;

      for (var53 = 0; var53 < var11; ++var53) {
         var54 = this.textureRenderTypes[var53] & 255;
         if (var54 == 0) {
            this.texTriangleX[var53] = (short)var2.readUnsignedShort();
            this.texTriangleY[var53] = (short)var2.readUnsignedShort();
            this.texTriangleZ[var53] = (short)var2.readUnsignedShort();
         }
      }

      var2.index = var26;
      var53 = var2.readUnsignedByte();
      if (var53 != 0) {
         new ModelData0();
         var2.readUnsignedShort();
         var2.readUnsignedShort();
         var2.readUnsignedShort();
         var2.readInt();
      }

   }

   @ObfuscatedName("q")
   void method204(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var4.index = var1.length - 18;
      int var9 = var4.readUnsignedShort();
      int var10 = var4.readUnsignedShort();
      int var11 = var4.readUnsignedByte();
      int var12 = var4.readUnsignedByte();
      int var13 = var4.readUnsignedByte();
      int var14 = var4.readUnsignedByte();
      int var15 = var4.readUnsignedByte();
      int var16 = var4.readUnsignedByte();
      int var17 = var4.readUnsignedShort();
      int var18 = var4.readUnsignedShort();
      int var19 = var4.readUnsignedShort();
      int var20 = var4.readUnsignedShort();
      byte var21 = 0;
      int var22 = var21 + var9;
      int var23 = var22;
      var22 += var10;
      int var24 = var22;
      if (var13 == 255) {
         var22 += var10;
      }

      int var25 = var22;
      if (var15 == 1) {
         var22 += var10;
      }

      int var26 = var22;
      if (var12 == 1) {
         var22 += var10;
      }

      int var27 = var22;
      if (var16 == 1) {
         var22 += var9;
      }

      int var28 = var22;
      if (var14 == 1) {
         var22 += var10;
      }

      int var29 = var22;
      var22 += var20;
      int var30 = var22;
      var22 += var10 * 2;
      int var31 = var22;
      var22 += var11 * 6;
      int var32 = var22;
      var22 += var17;
      int var33 = var22;
      var22 += var18;
      int var10000 = var22 + var19;
      this.verticesCount = var9;
      this.faceCount = var10;
      this.field554 = var11;
      this.verticesX = new int[var9];
      this.verticesY = new int[var9];
      this.verticesZ = new int[var9];
      this.indices1 = new int[var10];
      this.indices2 = new int[var10];
      this.indices3 = new int[var10];
      if (var11 > 0) {
         this.textureRenderTypes = new byte[var11];
         this.texTriangleX = new short[var11];
         this.texTriangleY = new short[var11];
         this.texTriangleZ = new short[var11];
      }

      if (var16 == 1) {
         this.field555 = new int[var9];
      }

      if (var12 == 1) {
         this.field551 = new byte[var10];
         this.textureCoords = new byte[var10];
         this.faceTextures = new short[var10];
      }

      if (var13 == 255) {
         this.field552 = new byte[var10];
      } else {
         this.field553 = (byte)var13;
      }

      if (var14 == 1) {
         this.faceAlphas = new byte[var10];
      }

      if (var15 == 1) {
         this.field556 = new int[var10];
      }

      this.faceColors = new short[var10];
      var4.index = var21;
      var5.index = var32;
      var6.index = var33;
      var7.index = var22;
      var8.index = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for (var38 = 0; var38 < var9; ++var38) {
         var39 = var4.readUnsignedByte();
         var40 = 0;
         if ((var39 & 1) != 0) {
            var40 = var5.method47();
         }

         var41 = 0;
         if ((var39 & 2) != 0) {
            var41 = var6.method47();
         }

         var42 = 0;
         if ((var39 & 4) != 0) {
            var42 = var7.method47();
         }

         this.verticesX[var38] = var35 + var40;
         this.verticesY[var38] = var36 + var41;
         this.verticesZ[var38] = var37 + var42;
         var35 = this.verticesX[var38];
         var36 = this.verticesY[var38];
         var37 = this.verticesZ[var38];
         if (var16 == 1) {
            this.field555[var38] = var8.readUnsignedByte();
         }
      }

      var4.index = var30;
      var5.index = var26;
      var6.index = var24;
      var7.index = var28;
      var8.index = var25;

      for (var38 = 0; var38 < var10; ++var38) {
         this.faceColors[var38] = (short)var4.readUnsignedShort();
         if (var12 == 1) {
            var39 = var5.readUnsignedByte();
            if ((var39 & 1) == 1) {
               this.field551[var38] = 1;
               var2 = true;
            } else {
               this.field551[var38] = 0;
            }

            if ((var39 & 2) == 2) {
               this.textureCoords[var38] = (byte)(var39 >> 2);
               this.faceTextures[var38] = this.faceColors[var38];
               this.faceColors[var38] = 127;
               if (this.faceTextures[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.textureCoords[var38] = -1;
               this.faceTextures[var38] = -1;
            }
         }

         if (var13 == 255) {
            this.field552[var38] = var6.readByte();
         }

         if (var14 == 1) {
            this.faceAlphas[var38] = var7.readByte();
         }

         if (var15 == 1) {
            this.field556[var38] = var8.readUnsignedByte();
         }
      }

      var4.index = var29;
      var5.index = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for (var42 = 0; var42 < var10; ++var42) {
         var43 = var5.readUnsignedByte();
         if (var43 == 1) {
            var38 = var4.method47() + var41;
            var39 = var4.method47() + var38;
            var40 = var4.method47() + var39;
            var41 = var40;
            this.indices1[var42] = var38;
            this.indices2[var42] = var39;
            this.indices3[var42] = var40;
         }

         if (var43 == 2) {
            var39 = var40;
            var40 = var4.method47() + var41;
            var41 = var40;
            this.indices1[var42] = var38;
            this.indices2[var42] = var39;
            this.indices3[var42] = var40;
         }

         if (var43 == 3) {
            var38 = var40;
            var40 = var4.method47() + var41;
            var41 = var40;
            this.indices1[var42] = var38;
            this.indices2[var42] = var39;
            this.indices3[var42] = var40;
         }

         if (var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method47() + var41;
            var41 = var40;
            this.indices1[var42] = var38;
            this.indices2[var42] = var44;
            this.indices3[var42] = var40;
         }
      }

      var4.index = var31;

      for (var42 = 0; var42 < var11; ++var42) {
         this.textureRenderTypes[var42] = 0;
         this.texTriangleX[var42] = (short)var4.readUnsignedShort();
         this.texTriangleY[var42] = (short)var4.readUnsignedShort();
         this.texTriangleZ[var42] = (short)var4.readUnsignedShort();
      }

      if (this.textureCoords != null) {
         boolean var45 = false;

         for (var43 = 0; var43 < var10; ++var43) {
            var44 = this.textureCoords[var43] & 255;
            if (var44 != 255) {
               if (this.indices1[var43] == (this.texTriangleX[var44] & '\uffff') && this.indices2[var43] == (this.texTriangleY[var44] & '\uffff') && this.indices3[var43] == (this.texTriangleZ[var44] & '\uffff')) {
                  this.textureCoords[var43] = -1;
               } else {
                  var45 = true;
               }
            }
         }

         if (!var45) {
            this.textureCoords = null;
         }
      }

      if (!var3) {
         this.faceTextures = null;
      }

      if (!var2) {
         this.field551 = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldw;I)I"
   )
   final int method205(ModelData var1, int var2) {
      int var3 = -1;
      int var4 = var1.verticesX[var2];
      int var5 = var1.verticesY[var2];
      int var6 = var1.verticesZ[var2];

      for (int var7 = 0; var7 < this.verticesCount; ++var7) {
         if (var4 == this.verticesX[var7] && var5 == this.verticesY[var7] && var6 == this.verticesZ[var7]) {
            var3 = var7;
            break;
         }
      }

      if (var3 == -1) {
         this.verticesX[this.verticesCount] = var4;
         this.verticesY[this.verticesCount] = var5;
         this.verticesZ[this.verticesCount] = var6;
         if (var1.field555 != null) {
            this.field555[this.verticesCount] = var1.field555[var2];
         }

         var3 = this.verticesCount++;
      }

      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Ldw;"
   )
   public ModelData method206() {
      ModelData var1 = new ModelData();
      if (this.field551 != null) {
         var1.field551 = new byte[this.faceCount];

         for (int var2 = 0; var2 < this.faceCount; ++var2) {
            var1.field551[var2] = this.field551[var2];
         }
      }

      var1.verticesCount = this.verticesCount;
      var1.faceCount = this.faceCount;
      var1.field554 = this.field554;
      var1.verticesX = this.verticesX;
      var1.verticesY = this.verticesY;
      var1.verticesZ = this.verticesZ;
      var1.indices1 = this.indices1;
      var1.indices2 = this.indices2;
      var1.indices3 = this.indices3;
      var1.field552 = this.field552;
      var1.faceAlphas = this.faceAlphas;
      var1.textureCoords = this.textureCoords;
      var1.faceColors = this.faceColors;
      var1.faceTextures = this.faceTextures;
      var1.field553 = this.field553;
      var1.textureRenderTypes = this.textureRenderTypes;
      var1.texTriangleX = this.texTriangleX;
      var1.texTriangleY = this.texTriangleY;
      var1.texTriangleZ = this.texTriangleZ;
      var1.field555 = this.field555;
      var1.field556 = this.field556;
      var1.vertexLabels = this.vertexLabels;
      var1.faceLabelsAlpha = this.faceLabelsAlpha;
      var1.field557 = this.field557;
      var1.faceNormals = this.faceNormals;
      var1.field559 = this.field559;
      var1.field560 = this.field560;
      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Ldw;"
   )
   public ModelData method207(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method217();
      int var7 = var2 + this.field562;
      int var8 = var2 + this.field563;
      int var9 = var4 + this.field565;
      int var10 = var4 + this.field564;
      if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            ModelData var11 = new ModelData();
            var11.verticesCount = this.verticesCount;
            var11.faceCount = this.faceCount;
            var11.field554 = this.field554;
            var11.verticesX = this.verticesX;
            var11.verticesZ = this.verticesZ;
            var11.indices1 = this.indices1;
            var11.indices2 = this.indices2;
            var11.indices3 = this.indices3;
            var11.field551 = this.field551;
            var11.field552 = this.field552;
            var11.faceAlphas = this.faceAlphas;
            var11.textureCoords = this.textureCoords;
            var11.faceColors = this.faceColors;
            var11.faceTextures = this.faceTextures;
            var11.field553 = this.field553;
            var11.textureRenderTypes = this.textureRenderTypes;
            var11.texTriangleX = this.texTriangleX;
            var11.texTriangleY = this.texTriangleY;
            var11.texTriangleZ = this.texTriangleZ;
            var11.field555 = this.field555;
            var11.field556 = this.field556;
            var11.vertexLabels = this.vertexLabels;
            var11.faceLabelsAlpha = this.faceLabelsAlpha;
            var11.field559 = this.field559;
            var11.field560 = this.field560;
            var11.verticesY = new int[var11.verticesCount];
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            if (var6 == 0) {
               for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.height;
                  if (var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.invalidate();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("g")
   void method208() {
      int[] var1;
      int var2;
      int var10003;
      int var4;
      int var5;
      if (this.field555 != null) {
         var1 = new int[256];
         var2 = 0;

         for (var4 = 0; var4 < this.verticesCount; ++var4) {
            var5 = this.field555[var4];
            var10003 = var1[var5]++;
            if (var5 > var2) {
               var2 = var5;
            }
         }

         this.vertexLabels = new int[var2 + 1][];

         for (var4 = 0; var4 <= var2; ++var4) {
            this.vertexLabels[var4] = new int[var1[var4]];
            var1[var4] = 0;
         }

         for (var4 = 0; var4 < this.verticesCount; this.vertexLabels[var5][var1[var5]++] = var4++) {
            var5 = this.field555[var4];
         }

         this.field555 = null;
      }

      if (this.field556 != null) {
         var1 = new int[256];
         var2 = 0;

         for (var4 = 0; var4 < this.faceCount; ++var4) {
            var5 = this.field556[var4];
            var10003 = var1[var5]++;
            if (var5 > var2) {
               var2 = var5;
            }
         }

         this.faceLabelsAlpha = new int[var2 + 1][];

         for (var4 = 0; var4 <= var2; ++var4) {
            this.faceLabelsAlpha[var4] = new int[var1[var4]];
            var1[var4] = 0;
         }

         for (var4 = 0; var4 < this.faceCount; this.faceLabelsAlpha[var5][var1[var5]++] = var4++) {
            var5 = this.field556[var4];
         }

         this.field556 = null;
      }

   }

   @ObfuscatedName("l")
   public void method209() {
      for (int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.invalidate();
   }

   @ObfuscatedName("x")
   public void method210() {
      for (int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.invalidate();
   }

   @ObfuscatedName("d")
   public void method211() {
      for (int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.invalidate();
   }

   @ObfuscatedName("a")
   public void method212(int var1) {
      int var2 = ModelData_sine[var1];
      int var3 = ModelData_cosine[var1];

      for (int var4 = 0; var4 < this.verticesCount; ++var4) {
         int var5 = var2 * this.verticesZ[var4] + var3 * this.verticesX[var4] >> 16;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] - var2 * this.verticesX[var4] >> 16;
         this.verticesX[var4] = var5;
      }

      this.invalidate();
   }

   @ObfuscatedName("z")
   public void method213(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.verticesCount; ++var4) {
         int[] var5 = this.verticesX;
         var5[var4] += var1;
         var5 = this.verticesY;
         var5[var4] += var2;
         var5 = this.verticesZ;
         var5[var4] += var3;
      }

      this.invalidate();
   }

   @ObfuscatedName("j")
   @Export("recolor")
   public void recolor(short from, short var2) {
      for (int var3 = 0; var3 < this.faceCount; ++var3) {
         if (this.faceColors[var3] == from) {
            this.faceColors[var3] = var2;
         }
      }

   }

   @ObfuscatedName("s")
   @Export("retexture")
   public void retexture(short from, short var2) {
      if (this.faceTextures != null) {
         for (int var3 = 0; var3 < this.faceCount; ++var3) {
            if (this.faceTextures[var3] == from) {
               this.faceTextures[var3] = var2;
            }
         }
      }

   }

   @ObfuscatedName("t")
   public void method214() {
      int var1;
      for (var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      for (var1 = 0; var1 < this.faceCount; ++var1) {
         int var2 = this.indices1[var1];
         this.indices1[var1] = this.indices3[var1];
         this.indices3[var1] = var2;
      }

      this.invalidate();
   }

   @ObfuscatedName("y")
   public void method215(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.invalidate();
   }

   @ObfuscatedName("h")
   public void method216() {
      if (this.field557 == null) {
         this.field557 = new VertexNormal[this.verticesCount];

         int var1;
         for (var1 = 0; var1 < this.verticesCount; ++var1) {
            this.field557[var1] = new VertexNormal();
         }

         for (var1 = 0; var1 < this.faceCount; ++var1) {
            int var2 = this.indices1[var1];
            int var3 = this.indices2[var1];
            int var4 = this.indices3[var1];
            int var5 = this.verticesX[var3] - this.verticesX[var2];
            int var6 = this.verticesY[var3] - this.verticesY[var2];
            int var7 = this.verticesZ[var3] - this.verticesZ[var2];
            int var8 = this.verticesX[var4] - this.verticesX[var2];
            int var9 = this.verticesY[var4] - this.verticesY[var2];
            int var10 = this.verticesZ[var4] - this.verticesZ[var2];
            int var11 = var6 * var10 - var9 * var7;
            int var12 = var7 * var8 - var10 * var5;

            int var13;
            for (var13 = var5 * var9 - var8 * var6; var11 > 8192 || var12 > 8192 || var13 > 8192 || var11 < -8192 || var12 < -8192 || var13 < -8192; var13 >>= 1) {
               var11 >>= 1;
               var12 >>= 1;
            }

            int var14 = (int)Math.sqrt((double)(var11 * var11 + var12 * var12 + var13 * var13));
            if (var14 <= 0) {
               var14 = 1;
            }

            var11 = var11 * 256 / var14;
            var12 = var12 * 256 / var14;
            var13 = var13 * 256 / var14;
            byte var15;
            if (this.field551 == null) {
               var15 = 0;
            } else {
               var15 = this.field551[var1];
            }

            if (var15 == 0) {
               VertexNormal var16 = this.field557[var2];
               var16.field947 += var11;
               var16.field948 += var12;
               var16.field949 += var13;
               ++var16.field950;
               var16 = this.field557[var3];
               var16.field947 += var11;
               var16.field948 += var12;
               var16.field949 += var13;
               ++var16.field950;
               var16 = this.field557[var4];
               var16.field947 += var11;
               var16.field948 += var12;
               var16.field949 += var13;
               ++var16.field950;
            } else if (var15 == 1) {
               if (this.faceNormals == null) {
                  this.faceNormals = new FaceNormal[this.faceCount];
               }

               FaceNormal var17 = this.faceNormals[var1] = new FaceNormal();
               var17.field346 = var11;
               var17.field347 = var12;
               var17.field348 = var13;
            }
         }
      }

   }

   @ObfuscatedName("b")
   @Export("invalidate")
   void invalidate() {
      this.field557 = null;
      this.field558 = null;
      this.faceNormals = null;
      this.isBoundsCalculated = false;
   }

   @ObfuscatedName("c")
   void method217() {
      if (!this.isBoundsCalculated) {
         super.height = 0;
         this.field561 = 0;
         this.field562 = 999999;
         this.field563 = -999999;
         this.field564 = -99999;
         this.field565 = 99999;

         for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if (var2 < this.field562) {
               this.field562 = var2;
            }

            if (var2 > this.field563) {
               this.field563 = var2;
            }

            if (var4 < this.field565) {
               this.field565 = var4;
            }

            if (var4 > this.field564) {
               this.field564 = var4;
            }

            if (-var3 > super.height) {
               super.height = -var3;
            }

            if (var3 > this.field561) {
               this.field561 = var3;
            }
         }

         this.isBoundsCalculated = true;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIII)Ldu;"
   )
   @Export("toModel")
   public final Model toModel(int var1, int var2, int var3, int var4, int var5) {
      this.method216();
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3 + var4 * var4));
      int var7 = var6 * var2 >> 8;
      Model var8 = new Model();
      var8.faceColors1 = new int[this.faceCount];
      var8.faceColors2 = new int[this.faceCount];
      var8.faceColors3 = new int[this.faceCount];
      if (this.field554 > 0 && this.textureCoords != null) {
         int[] var9 = new int[this.field554];

         int var10;
         for (var10 = 0; var10 < this.faceCount; ++var10) {
            if (this.textureCoords[var10] != -1) {
               ++var9[this.textureCoords[var10] & 255];
            }
         }

         var8.field544 = 0;

         for (var10 = 0; var10 < this.field554; ++var10) {
            if (var9[var10] > 0 && this.textureRenderTypes[var10] == 0) {
               ++var8.field544;
            }
         }

         var8.field545 = new int[var8.field544];
         var8.field546 = new int[var8.field544];
         var8.field547 = new int[var8.field544];
         var10 = 0;

         int var11;
         for (var11 = 0; var11 < this.field554; ++var11) {
            if (var9[var11] > 0 && this.textureRenderTypes[var11] == 0) {
               var8.field545[var10] = this.texTriangleX[var11] & '\uffff';
               var8.field546[var10] = this.texTriangleY[var11] & '\uffff';
               var8.field547[var10] = this.texTriangleZ[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field542 = new byte[this.faceCount];

         for (var11 = 0; var11 < this.faceCount; ++var11) {
            if (this.textureCoords[var11] != -1) {
               var8.field542[var11] = (byte)var9[this.textureCoords[var11] & 255];
            } else {
               var8.field542[var11] = -1;
            }
         }
      }

      for (int var17 = 0; var17 < this.faceCount; ++var17) {
         byte var18;
         if (this.field551 == null) {
            var18 = 0;
         } else {
            var18 = this.field551[var17];
         }

         byte var19;
         if (this.faceAlphas == null) {
            var19 = 0;
         } else {
            var19 = this.faceAlphas[var17];
         }

         short var12;
         if (this.faceTextures == null) {
            var12 = -1;
         } else {
            var12 = this.faceTextures[var17];
         }

         if (var19 == -2) {
            var18 = 3;
         }

         if (var19 == -1) {
            var18 = 2;
         }

         VertexNormal var13;
         int var14;
         FaceNormal var15;
         if (var12 == -1) {
            if (var18 != 0) {
               if (var18 == 1) {
                  var15 = this.faceNormals[var17];
                  var14 = (var4 * var15.field347 + var5 * var15.field348 + var3 * var15.field346) / (var7 / 2 + var7) + var1;
                  var8.faceColors1[var17] = method2802(this.faceColors[var17] & '\uffff', var14);
                  var8.faceColors3[var17] = -1;
               } else if (var18 == 3) {
                  var8.faceColors1[var17] = 128;
                  var8.faceColors3[var17] = -1;
               } else {
                  var8.faceColors3[var17] = -2;
               }
            } else {
               int var16 = this.faceColors[var17] & '\uffff';
               if (this.field558 != null && this.field558[this.indices1[var17]] != null) {
                  var13 = this.field558[this.indices1[var17]];
               } else {
                  var13 = this.field557[this.indices1[var17]];
               }

               var14 = (var4 * var13.field948 + var5 * var13.field949 + var3 * var13.field947) / (var7 * var13.field950) + var1;
               var8.faceColors1[var17] = method2802(var16, var14);
               if (this.field558 != null && this.field558[this.indices2[var17]] != null) {
                  var13 = this.field558[this.indices2[var17]];
               } else {
                  var13 = this.field557[this.indices2[var17]];
               }

               var14 = (var4 * var13.field948 + var5 * var13.field949 + var3 * var13.field947) / (var7 * var13.field950) + var1;
               var8.faceColors2[var17] = method2802(var16, var14);
               if (this.field558 != null && this.field558[this.indices3[var17]] != null) {
                  var13 = this.field558[this.indices3[var17]];
               } else {
                  var13 = this.field557[this.indices3[var17]];
               }

               var14 = (var4 * var13.field948 + var5 * var13.field949 + var3 * var13.field947) / (var7 * var13.field950) + var1;
               var8.faceColors3[var17] = method2802(var16, var14);
            }
         } else if (var18 != 0) {
            if (var18 == 1) {
               var15 = this.faceNormals[var17];
               var14 = (var4 * var15.field347 + var5 * var15.field348 + var3 * var15.field346) / (var7 / 2 + var7) + var1;
               var8.faceColors1[var17] = method2803(var14);
               var8.faceColors3[var17] = -1;
            } else {
               var8.faceColors3[var17] = -2;
            }
         } else {
            if (this.field558 != null && this.field558[this.indices1[var17]] != null) {
               var13 = this.field558[this.indices1[var17]];
            } else {
               var13 = this.field557[this.indices1[var17]];
            }

            var14 = (var4 * var13.field948 + var5 * var13.field949 + var3 * var13.field947) / (var7 * var13.field950) + var1;
            var8.faceColors1[var17] = method2803(var14);
            if (this.field558 != null && this.field558[this.indices2[var17]] != null) {
               var13 = this.field558[this.indices2[var17]];
            } else {
               var13 = this.field557[this.indices2[var17]];
            }

            var14 = (var4 * var13.field948 + var5 * var13.field949 + var3 * var13.field947) / (var7 * var13.field950) + var1;
            var8.faceColors2[var17] = method2803(var14);
            if (this.field558 != null && this.field558[this.indices3[var17]] != null) {
               var13 = this.field558[this.indices3[var17]];
            } else {
               var13 = this.field557[this.indices3[var17]];
            }

            var14 = (var4 * var13.field948 + var5 * var13.field949 + var3 * var13.field947) / (var7 * var13.field950) + var1;
            var8.faceColors3[var17] = method2803(var14);
         }
      }

      this.method208();
      var8.verticesCount = this.verticesCount;
      var8.verticesX = this.verticesX;
      var8.verticesY = this.verticesY;
      var8.verticesZ = this.verticesZ;
      var8.indicesCount = this.faceCount;
      var8.indices1 = this.indices1;
      var8.indices2 = this.indices2;
      var8.indices3 = this.indices3;
      var8.faceRenderPriorities = this.field552;
      var8.faceAlphas = this.faceAlphas;
      var8.field543 = this.field553;
      var8.vertexLabels = this.vertexLabels;
      var8.faceLabelsAlpha = this.faceLabelsAlpha;
      var8.faceTextures = this.faceTextures;
      return var8;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;II)Ldw;"
   )
   public static ModelData method2788(AbstractArchive var0, int var1, int var2) {
      byte[] var3 = var0.takeFile(var1, var2);
      return var3 == null ? null : new ModelData(var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ldw;Ldw;IIIZ)V"
   )
   static void method2800(ModelData var0, ModelData var1, int var2, int var3, int var4, boolean var5) {
      var0.method217();
      var0.method216();
      var1.method217();
      var1.method216();
      ++field550;
      int var6 = 0;
      int[] var7 = var1.verticesX;
      int var8 = var1.verticesCount;

      int var9;
      for (var9 = 0; var9 < var0.verticesCount; ++var9) {
         VertexNormal var10 = var0.field557[var9];
         if (var10.field950 != 0) {
            int var11 = var0.verticesY[var9] - var3;
            if (var11 <= var1.field561) {
               int var12 = var0.verticesX[var9] - var2;
               if (var12 >= var1.field562 && var12 <= var1.field563) {
                  int var13 = var0.verticesZ[var9] - var4;
                  if (var13 >= var1.field565 && var13 <= var1.field564) {
                     for (int var14 = 0; var14 < var8; ++var14) {
                        VertexNormal var15 = var1.field557[var14];
                        if (var12 == var7[var14] && var13 == var1.verticesZ[var14] && var11 == var1.verticesY[var14] && var15.field950 != 0) {
                           if (var0.field558 == null) {
                              var0.field558 = new VertexNormal[var0.verticesCount];
                           }

                           if (var1.field558 == null) {
                              var1.field558 = new VertexNormal[var8];
                           }

                           VertexNormal var16 = var0.field558[var9];
                           if (var16 == null) {
                              var16 = var0.field558[var9] = new VertexNormal(var10);
                           }

                           VertexNormal var17 = var1.field558[var14];
                           if (var17 == null) {
                              var17 = var1.field558[var14] = new VertexNormal(var15);
                           }

                           var16.field947 += var15.field947;
                           var16.field948 += var15.field948;
                           var16.field949 += var15.field949;
                           var16.field950 += var15.field950;
                           var17.field947 += var10.field947;
                           var17.field948 += var10.field948;
                           var17.field949 += var10.field949;
                           var17.field950 += var10.field950;
                           ++var6;
                           field548[var9] = field550;
                           field549[var14] = field550;
                        }
                     }
                  }
               }
            }
         }
      }

      if (var6 >= 3 && var5) {
         for (var9 = 0; var9 < var0.faceCount; ++var9) {
            if (field548[var0.indices1[var9]] == field550 && field548[var0.indices2[var9]] == field550 && field548[var0.indices3[var9]] == field550) {
               if (var0.field551 == null) {
                  var0.field551 = new byte[var0.faceCount];
               }

               var0.field551[var9] = 2;
            }
         }

         for (var9 = 0; var9 < var1.faceCount; ++var9) {
            if (field550 == field549[var1.indices1[var9]] && field550 == field549[var1.indices2[var9]] && field550 == field549[var1.indices3[var9]]) {
               if (var1.field551 == null) {
                  var1.field551 = new byte[var1.faceCount];
               }

               var1.field551[var9] = 2;
            }
         }
      }

   }

   @ObfuscatedName("ag")
   static final int method2802(int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if (var1 < 2) {
         var1 = 2;
      } else if (var1 > 126) {
         var1 = 126;
      }

      return (var0 & 65408) + var1;
   }

   @ObfuscatedName("aq")
   static final int method2803(int var0) {
      if (var0 < 2) {
         var0 = 2;
      } else if (var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   static {
      field548 = new int[10000];
      field549 = new int[10000];
      field550 = 0;
      ModelData_sine = Rasterizer3D.Rasterizer3D_sine;
      ModelData_cosine = Rasterizer3D.Rasterizer3D_cosine;
   }
}
