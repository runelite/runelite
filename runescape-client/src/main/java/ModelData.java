import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("ModelData")
public class ModelData extends Renderable {
   @ObfuscatedName("aj")
   static int[] field1502;
   @ObfuscatedName("ae")
   static int[] field1524;
   @ObfuscatedName("au")
   static int field1503;
   @ObfuscatedName("av")
   static int[] field1525;
   @ObfuscatedName("ab")
   static int[] field1481;
   @ObfuscatedName("w")
   @Export("vertexCount")
   int vertexCount;
   @ObfuscatedName("m")
   @Export("vertexX")
   int[] vertexX;
   @ObfuscatedName("q")
   @Export("vertexY")
   int[] vertexY;
   @ObfuscatedName("b")
   @Export("vertexZ")
   int[] vertexZ;
   @ObfuscatedName("f")
   @Export("triangleFaceCount")
   int triangleFaceCount;
   @ObfuscatedName("n")
   @Export("trianglePointsX")
   int[] trianglePointsX;
   @ObfuscatedName("h")
   @Export("trianglePointsY")
   int[] trianglePointsY;
   @ObfuscatedName("x")
   @Export("trianglePointsZ")
   int[] trianglePointsZ;
   @ObfuscatedName("j")
   @Export("faceRenderType")
   byte[] faceRenderType;
   @ObfuscatedName("a")
   @Export("faceRenderPriorities")
   byte[] faceRenderPriorities;
   @ObfuscatedName("l")
   @Export("faceAlphas")
   byte[] faceAlphas;
   @ObfuscatedName("d")
   @Export("textureCoords")
   byte[] textureCoords;
   @ObfuscatedName("s")
   @Export("faceColor")
   short[] faceColor;
   @ObfuscatedName("p")
   @Export("faceTextures")
   short[] faceTextures;
   @ObfuscatedName("g")
   @Export("priority")
   byte priority;
   @ObfuscatedName("y")
   int field1521;
   @ObfuscatedName("c")
   @Export("textureRenderTypes")
   byte[] textureRenderTypes;
   @ObfuscatedName("e")
   @Export("texTriangleX")
   short[] texTriangleX;
   @ObfuscatedName("t")
   @Export("texTriangleY")
   short[] texTriangleY;
   @ObfuscatedName("u")
   @Export("texTriangleZ")
   short[] texTriangleZ;
   @ObfuscatedName("i")
   short[] field1501;
   @ObfuscatedName("z")
   short[] field1508;
   @ObfuscatedName("k")
   short[] field1527;
   @ObfuscatedName("r")
   short[] field1504;
   @ObfuscatedName("v")
   short[] field1505;
   @ObfuscatedName("o")
   @Export("texturePrimaryColor")
   short[] texturePrimaryColor;
   @ObfuscatedName("ai")
   byte[] field1507;
   @ObfuscatedName("at")
   @Export("vertexSkins")
   int[] vertexSkins;
   @ObfuscatedName("ad")
   @Export("triangleSkinValues")
   int[] triangleSkinValues;
   @ObfuscatedName("ac")
   int[][] field1516;
   @ObfuscatedName("ay")
   int[][] field1511;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "[Ldy;"
   )
   @Export("faceNormals")
   FaceNormal[] faceNormals;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "[Ldv;"
   )
   @Export("normals")
   VertexNormal[] normals;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "[Ldv;"
   )
   VertexNormal[] field1514;
   @ObfuscatedName("ag")
   public short field1515;
   @ObfuscatedName("ah")
   @Export("contrast")
   public short contrast;
   @ObfuscatedName("az")
   boolean field1517;
   @ObfuscatedName("ao")
   int field1499;
   @ObfuscatedName("ap")
   int field1519;
   @ObfuscatedName("af")
   int field1498;
   @ObfuscatedName("am")
   int field1496;
   @ObfuscatedName("aq")
   int field1522;

   static {
      field1502 = new int[10000];
      field1524 = new int[10000];
      field1503 = 0;
      field1525 = Graphics3D.SINE;
      field1481 = Graphics3D.COSINE;
   }

   ModelData() {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1517 = false;
   }

   @ObfuscatedSignature(
      signature = "([Ldo;I)V"
   )
   public ModelData(ModelData[] var1, int var2) {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1517 = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.field1521 = 0;
      this.priority = -1;

      int var9;
      ModelData var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.vertexCount += var10.vertexCount;
            this.triangleFaceCount += var10.triangleFaceCount;
            this.field1521 += var10.field1521;
            if(var10.faceRenderPriorities != null) {
               var4 = true;
            } else {
               if(this.priority == -1) {
                  this.priority = var10.priority;
               }

               if(this.priority != var10.priority) {
                  var4 = true;
               }
            }

            var3 |= var10.faceRenderType != null;
            var5 |= var10.faceAlphas != null;
            var6 |= var10.triangleSkinValues != null;
            var7 |= var10.faceTextures != null;
            var8 |= var10.textureCoords != null;
         }
      }

      this.vertexX = new int[this.vertexCount];
      this.vertexY = new int[this.vertexCount];
      this.vertexZ = new int[this.vertexCount];
      this.vertexSkins = new int[this.vertexCount];
      this.trianglePointsX = new int[this.triangleFaceCount];
      this.trianglePointsY = new int[this.triangleFaceCount];
      this.trianglePointsZ = new int[this.triangleFaceCount];
      if(var3) {
         this.faceRenderType = new byte[this.triangleFaceCount];
      }

      if(var4) {
         this.faceRenderPriorities = new byte[this.triangleFaceCount];
      }

      if(var5) {
         this.faceAlphas = new byte[this.triangleFaceCount];
      }

      if(var6) {
         this.triangleSkinValues = new int[this.triangleFaceCount];
      }

      if(var7) {
         this.faceTextures = new short[this.triangleFaceCount];
      }

      if(var8) {
         this.textureCoords = new byte[this.triangleFaceCount];
      }

      this.faceColor = new short[this.triangleFaceCount];
      if(this.field1521 > 0) {
         this.textureRenderTypes = new byte[this.field1521];
         this.texTriangleX = new short[this.field1521];
         this.texTriangleY = new short[this.field1521];
         this.texTriangleZ = new short[this.field1521];
         this.field1501 = new short[this.field1521];
         this.field1508 = new short[this.field1521];
         this.field1527 = new short[this.field1521];
         this.field1504 = new short[this.field1521];
         this.field1507 = new byte[this.field1521];
         this.field1505 = new short[this.field1521];
         this.texturePrimaryColor = new short[this.field1521];
      }

      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.field1521 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.triangleFaceCount; ++var11) {
               if(var3 && var10.faceRenderType != null) {
                  this.faceRenderType[this.triangleFaceCount] = var10.faceRenderType[var11];
               }

               if(var4) {
                  if(var10.faceRenderPriorities != null) {
                     this.faceRenderPriorities[this.triangleFaceCount] = var10.faceRenderPriorities[var11];
                  } else {
                     this.faceRenderPriorities[this.triangleFaceCount] = var10.priority;
                  }
               }

               if(var5 && var10.faceAlphas != null) {
                  this.faceAlphas[this.triangleFaceCount] = var10.faceAlphas[var11];
               }

               if(var6 && var10.triangleSkinValues != null) {
                  this.triangleSkinValues[this.triangleFaceCount] = var10.triangleSkinValues[var11];
               }

               if(var7) {
                  if(var10.faceTextures != null) {
                     this.faceTextures[this.triangleFaceCount] = var10.faceTextures[var11];
                  } else {
                     this.faceTextures[this.triangleFaceCount] = -1;
                  }
               }

               if(var8) {
                  if(var10.textureCoords != null && var10.textureCoords[var11] != -1) {
                     this.textureCoords[this.triangleFaceCount] = (byte)(this.field1521 + var10.textureCoords[var11]);
                  } else {
                     this.textureCoords[this.triangleFaceCount] = -1;
                  }
               }

               this.faceColor[this.triangleFaceCount] = var10.faceColor[var11];
               this.trianglePointsX[this.triangleFaceCount] = this.method2646(var10, var10.trianglePointsX[var11]);
               this.trianglePointsY[this.triangleFaceCount] = this.method2646(var10, var10.trianglePointsY[var11]);
               this.trianglePointsZ[this.triangleFaceCount] = this.method2646(var10, var10.trianglePointsZ[var11]);
               ++this.triangleFaceCount;
            }

            for(var11 = 0; var11 < var10.field1521; ++var11) {
               byte var12 = this.textureRenderTypes[this.field1521] = var10.textureRenderTypes[var11];
               if(var12 == 0) {
                  this.texTriangleX[this.field1521] = (short)this.method2646(var10, var10.texTriangleX[var11]);
                  this.texTriangleY[this.field1521] = (short)this.method2646(var10, var10.texTriangleY[var11]);
                  this.texTriangleZ[this.field1521] = (short)this.method2646(var10, var10.texTriangleZ[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.texTriangleX[this.field1521] = var10.texTriangleX[var11];
                  this.texTriangleY[this.field1521] = var10.texTriangleY[var11];
                  this.texTriangleZ[this.field1521] = var10.texTriangleZ[var11];
                  this.field1501[this.field1521] = var10.field1501[var11];
                  this.field1508[this.field1521] = var10.field1508[var11];
                  this.field1527[this.field1521] = var10.field1527[var11];
                  this.field1504[this.field1521] = var10.field1504[var11];
                  this.field1507[this.field1521] = var10.field1507[var11];
                  this.field1505[this.field1521] = var10.field1505[var11];
               }

               if(var12 == 2) {
                  this.texturePrimaryColor[this.field1521] = var10.texturePrimaryColor[var11];
               }

               ++this.field1521;
            }
         }
      }

   }

   ModelData(byte[] var1) {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1517 = false;
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.decodeNewFormat(var1);
      } else {
         this.decodeOldFormat(var1);
      }

   }

   @ObfuscatedSignature(
      signature = "(Ldo;ZZZZ)V",
      garbageValue = "1"
   )
   public ModelData(ModelData var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1517 = false;
      this.vertexCount = var1.vertexCount;
      this.triangleFaceCount = var1.triangleFaceCount;
      this.field1521 = var1.field1521;
      int var6;
      if(var2) {
         this.vertexX = var1.vertexX;
         this.vertexY = var1.vertexY;
         this.vertexZ = var1.vertexZ;
      } else {
         this.vertexX = new int[this.vertexCount];
         this.vertexY = new int[this.vertexCount];
         this.vertexZ = new int[this.vertexCount];

         for(var6 = 0; var6 < this.vertexCount; ++var6) {
            this.vertexX[var6] = var1.vertexX[var6];
            this.vertexY[var6] = var1.vertexY[var6];
            this.vertexZ[var6] = var1.vertexZ[var6];
         }
      }

      if(var3) {
         this.faceColor = var1.faceColor;
      } else {
         this.faceColor = new short[this.triangleFaceCount];

         for(var6 = 0; var6 < this.triangleFaceCount; ++var6) {
            this.faceColor[var6] = var1.faceColor[var6];
         }
      }

      if(!var4 && var1.faceTextures != null) {
         this.faceTextures = new short[this.triangleFaceCount];

         for(var6 = 0; var6 < this.triangleFaceCount; ++var6) {
            this.faceTextures[var6] = var1.faceTextures[var6];
         }
      } else {
         this.faceTextures = var1.faceTextures;
      }

      this.faceAlphas = var1.faceAlphas;
      this.trianglePointsX = var1.trianglePointsX;
      this.trianglePointsY = var1.trianglePointsY;
      this.trianglePointsZ = var1.trianglePointsZ;
      this.faceRenderType = var1.faceRenderType;
      this.faceRenderPriorities = var1.faceRenderPriorities;
      this.textureCoords = var1.textureCoords;
      this.priority = var1.priority;
      this.textureRenderTypes = var1.textureRenderTypes;
      this.texTriangleX = var1.texTriangleX;
      this.texTriangleY = var1.texTriangleY;
      this.texTriangleZ = var1.texTriangleZ;
      this.field1501 = var1.field1501;
      this.field1508 = var1.field1508;
      this.field1527 = var1.field1527;
      this.field1504 = var1.field1504;
      this.field1507 = var1.field1507;
      this.field1505 = var1.field1505;
      this.texturePrimaryColor = var1.texturePrimaryColor;
      this.vertexSkins = var1.vertexSkins;
      this.triangleSkinValues = var1.triangleSkinValues;
      this.field1516 = var1.field1516;
      this.field1511 = var1.field1511;
      this.normals = var1.normals;
      this.faceNormals = var1.faceNormals;
      this.field1514 = var1.field1514;
      this.field1515 = var1.field1515;
      this.contrast = var1.contrast;
   }

   @ObfuscatedName("m")
   @Export("decodeNewFormat")
   void decodeNewFormat(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var2.offset = var1.length - 23;
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
      if(var11 > 0) {
         this.textureRenderTypes = new byte[var11];
         var2.offset = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.textureRenderTypes[var26] = var2.readByte();
            if(var27 == 0) {
               ++var23;
            }

            if(var27 >= 1 && var27 <= 3) {
               ++var24;
            }

            if(var27 == 2) {
               ++var25;
            }
         }
      }

      var26 = var11 + var9;
      int var28 = var26;
      if(var12 == 1) {
         var26 += var10;
      }

      int var29 = var26;
      var26 += var10;
      int var30 = var26;
      if(var13 == 255) {
         var26 += var10;
      }

      int var31 = var26;
      if(var15 == 1) {
         var26 += var10;
      }

      int var32 = var26;
      if(var17 == 1) {
         var26 += var9;
      }

      int var33 = var26;
      if(var14 == 1) {
         var26 += var10;
      }

      int var34 = var26;
      var26 += var21;
      int var35 = var26;
      if(var16 == 1) {
         var26 += var10 * 2;
      }

      int var36 = var26;
      var26 += var22;
      int var37 = var26;
      var26 += var10 * 2;
      int var38 = var26;
      var26 += var18;
      int var39 = var26;
      var26 += var19;
      int var40 = var26;
      var26 += var20;
      int var41 = var26;
      var26 += var23 * 6;
      int var42 = var26;
      var26 += var24 * 6;
      int var43 = var26;
      var26 += var24 * 6;
      int var44 = var26;
      var26 += var24 * 2;
      int var45 = var26;
      var26 += var24;
      int var46 = var26;
      var26 += var24 * 2 + var25 * 2;
      this.vertexCount = var9;
      this.triangleFaceCount = var10;
      this.field1521 = var11;
      this.vertexX = new int[var9];
      this.vertexY = new int[var9];
      this.vertexZ = new int[var9];
      this.trianglePointsX = new int[var10];
      this.trianglePointsY = new int[var10];
      this.trianglePointsZ = new int[var10];
      if(var17 == 1) {
         this.vertexSkins = new int[var9];
      }

      if(var12 == 1) {
         this.faceRenderType = new byte[var10];
      }

      if(var13 == 255) {
         this.faceRenderPriorities = new byte[var10];
      } else {
         this.priority = (byte)var13;
      }

      if(var14 == 1) {
         this.faceAlphas = new byte[var10];
      }

      if(var15 == 1) {
         this.triangleSkinValues = new int[var10];
      }

      if(var16 == 1) {
         this.faceTextures = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.textureCoords = new byte[var10];
      }

      this.faceColor = new short[var10];
      if(var11 > 0) {
         this.texTriangleX = new short[var11];
         this.texTriangleY = new short[var11];
         this.texTriangleZ = new short[var11];
         if(var24 > 0) {
            this.field1501 = new short[var24];
            this.field1508 = new short[var24];
            this.field1527 = new short[var24];
            this.field1504 = new short[var24];
            this.field1507 = new byte[var24];
            this.field1505 = new short[var24];
         }

         if(var25 > 0) {
            this.texturePrimaryColor = new short[var25];
         }
      }

      var2.offset = var11;
      var3.offset = var38;
      var4.offset = var39;
      var5.offset = var40;
      var6.offset = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.readUnsignedByte();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.readShortSmart();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.readShortSmart();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.readShortSmart();
         }

         this.vertexX[var51] = var48 + var53;
         this.vertexY[var51] = var49 + var54;
         this.vertexZ[var51] = var50 + var55;
         var48 = this.vertexX[var51];
         var49 = this.vertexY[var51];
         var50 = this.vertexZ[var51];
         if(var17 == 1) {
            this.vertexSkins[var51] = var6.readUnsignedByte();
         }
      }

      var2.offset = var37;
      var3.offset = var28;
      var4.offset = var30;
      var5.offset = var33;
      var6.offset = var31;
      var7.offset = var35;
      var8.offset = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.faceColor[var51] = (short)var2.readUnsignedShort();
         if(var12 == 1) {
            this.faceRenderType[var51] = var3.readByte();
         }

         if(var13 == 255) {
            this.faceRenderPriorities[var51] = var4.readByte();
         }

         if(var14 == 1) {
            this.faceAlphas[var51] = var5.readByte();
         }

         if(var15 == 1) {
            this.triangleSkinValues[var51] = var6.readUnsignedByte();
         }

         if(var16 == 1) {
            this.faceTextures[var51] = (short)(var7.readUnsignedShort() - 1);
         }

         if(this.textureCoords != null && this.faceTextures[var51] != -1) {
            this.textureCoords[var51] = (byte)(var8.readUnsignedByte() - 1);
         }
      }

      var2.offset = var34;
      var3.offset = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.readUnsignedByte();
         if(var56 == 1) {
            var51 = var2.readShortSmart() + var54;
            var52 = var2.readShortSmart() + var51;
            var53 = var2.readShortSmart() + var52;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var52;
            this.trianglePointsZ[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.readShortSmart() + var54;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var52;
            this.trianglePointsZ[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.readShortSmart() + var54;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var52;
            this.trianglePointsZ[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.readShortSmart() + var54;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var57;
            this.trianglePointsZ[var55] = var53;
         }
      }

      var2.offset = var41;
      var3.offset = var42;
      var4.offset = var43;
      var5.offset = var44;
      var6.offset = var45;
      var7.offset = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.textureRenderTypes[var55] & 255;
         if(var56 == 0) {
            this.texTriangleX[var55] = (short)var2.readUnsignedShort();
            this.texTriangleY[var55] = (short)var2.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var2.readUnsignedShort();
         }

         if(var56 == 1) {
            this.texTriangleX[var55] = (short)var3.readUnsignedShort();
            this.texTriangleY[var55] = (short)var3.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var3.readUnsignedShort();
            this.field1501[var55] = (short)var4.readUnsignedShort();
            this.field1508[var55] = (short)var4.readUnsignedShort();
            this.field1527[var55] = (short)var4.readUnsignedShort();
            this.field1504[var55] = (short)var5.readUnsignedShort();
            this.field1507[var55] = var6.readByte();
            this.field1505[var55] = (short)var7.readUnsignedShort();
         }

         if(var56 == 2) {
            this.texTriangleX[var55] = (short)var3.readUnsignedShort();
            this.texTriangleY[var55] = (short)var3.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var3.readUnsignedShort();
            this.field1501[var55] = (short)var4.readUnsignedShort();
            this.field1508[var55] = (short)var4.readUnsignedShort();
            this.field1527[var55] = (short)var4.readUnsignedShort();
            this.field1504[var55] = (short)var5.readUnsignedShort();
            this.field1507[var55] = var6.readByte();
            this.field1505[var55] = (short)var7.readUnsignedShort();
            this.texturePrimaryColor[var55] = (short)var7.readUnsignedShort();
         }

         if(var56 == 3) {
            this.texTriangleX[var55] = (short)var3.readUnsignedShort();
            this.texTriangleY[var55] = (short)var3.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var3.readUnsignedShort();
            this.field1501[var55] = (short)var4.readUnsignedShort();
            this.field1508[var55] = (short)var4.readUnsignedShort();
            this.field1527[var55] = (short)var4.readUnsignedShort();
            this.field1504[var55] = (short)var5.readUnsignedShort();
            this.field1507[var55] = var6.readByte();
            this.field1505[var55] = (short)var7.readUnsignedShort();
         }
      }

      var2.offset = var26;
      var55 = var2.readUnsignedByte();
      if(var55 != 0) {
         new class126();
         var2.readUnsignedShort();
         var2.readUnsignedShort();
         var2.readUnsignedShort();
         var2.readInt();
      }

   }

   @ObfuscatedName("q")
   @Export("decodeOldFormat")
   void decodeOldFormat(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var4.offset = var1.length - 18;
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
      int var45 = var21 + var9;
      int var23 = var45;
      var45 += var10;
      int var24 = var45;
      if(var13 == 255) {
         var45 += var10;
      }

      int var25 = var45;
      if(var15 == 1) {
         var45 += var10;
      }

      int var26 = var45;
      if(var12 == 1) {
         var45 += var10;
      }

      int var27 = var45;
      if(var16 == 1) {
         var45 += var9;
      }

      int var28 = var45;
      if(var14 == 1) {
         var45 += var10;
      }

      int var29 = var45;
      var45 += var20;
      int var30 = var45;
      var45 += var10 * 2;
      int var31 = var45;
      var45 += var11 * 6;
      int var32 = var45;
      var45 += var17;
      int var33 = var45;
      var45 += var18;
      int var10000 = var45 + var19;
      this.vertexCount = var9;
      this.triangleFaceCount = var10;
      this.field1521 = var11;
      this.vertexX = new int[var9];
      this.vertexY = new int[var9];
      this.vertexZ = new int[var9];
      this.trianglePointsX = new int[var10];
      this.trianglePointsY = new int[var10];
      this.trianglePointsZ = new int[var10];
      if(var11 > 0) {
         this.textureRenderTypes = new byte[var11];
         this.texTriangleX = new short[var11];
         this.texTriangleY = new short[var11];
         this.texTriangleZ = new short[var11];
      }

      if(var16 == 1) {
         this.vertexSkins = new int[var9];
      }

      if(var12 == 1) {
         this.faceRenderType = new byte[var10];
         this.textureCoords = new byte[var10];
         this.faceTextures = new short[var10];
      }

      if(var13 == 255) {
         this.faceRenderPriorities = new byte[var10];
      } else {
         this.priority = (byte)var13;
      }

      if(var14 == 1) {
         this.faceAlphas = new byte[var10];
      }

      if(var15 == 1) {
         this.triangleSkinValues = new int[var10];
      }

      this.faceColor = new short[var10];
      var4.offset = var21;
      var5.offset = var32;
      var6.offset = var33;
      var7.offset = var45;
      var8.offset = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.readUnsignedByte();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.readShortSmart();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.readShortSmart();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.readShortSmart();
         }

         this.vertexX[var38] = var35 + var40;
         this.vertexY[var38] = var36 + var41;
         this.vertexZ[var38] = var37 + var42;
         var35 = this.vertexX[var38];
         var36 = this.vertexY[var38];
         var37 = this.vertexZ[var38];
         if(var16 == 1) {
            this.vertexSkins[var38] = var8.readUnsignedByte();
         }
      }

      var4.offset = var30;
      var5.offset = var26;
      var6.offset = var24;
      var7.offset = var28;
      var8.offset = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.faceColor[var38] = (short)var4.readUnsignedShort();
         if(var12 == 1) {
            var39 = var5.readUnsignedByte();
            if((var39 & 1) == 1) {
               this.faceRenderType[var38] = 1;
               var2 = true;
            } else {
               this.faceRenderType[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.textureCoords[var38] = (byte)(var39 >> 2);
               this.faceTextures[var38] = this.faceColor[var38];
               this.faceColor[var38] = 127;
               if(this.faceTextures[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.textureCoords[var38] = -1;
               this.faceTextures[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.faceRenderPriorities[var38] = var6.readByte();
         }

         if(var14 == 1) {
            this.faceAlphas[var38] = var7.readByte();
         }

         if(var15 == 1) {
            this.triangleSkinValues[var38] = var8.readUnsignedByte();
         }
      }

      var4.offset = var29;
      var5.offset = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.readUnsignedByte();
         if(var43 == 1) {
            var38 = var4.readShortSmart() + var41;
            var39 = var4.readShortSmart() + var38;
            var40 = var4.readShortSmart() + var39;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var39;
            this.trianglePointsZ[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.readShortSmart() + var41;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var39;
            this.trianglePointsZ[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.readShortSmart() + var41;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var39;
            this.trianglePointsZ[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.readShortSmart() + var41;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var44;
            this.trianglePointsZ[var42] = var40;
         }
      }

      var4.offset = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.textureRenderTypes[var42] = 0;
         this.texTriangleX[var42] = (short)var4.readUnsignedShort();
         this.texTriangleY[var42] = (short)var4.readUnsignedShort();
         this.texTriangleZ[var42] = (short)var4.readUnsignedShort();
      }

      if(this.textureCoords != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.textureCoords[var43] & 255;
            if(var44 != 255) {
               if(this.trianglePointsX[var43] == (this.texTriangleX[var44] & '\uffff') && this.trianglePointsY[var43] == (this.texTriangleY[var44] & '\uffff') && this.trianglePointsZ[var43] == (this.texTriangleZ[var44] & '\uffff')) {
                  this.textureCoords[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.textureCoords = null;
         }
      }

      if(!var3) {
         this.faceTextures = null;
      }

      if(!var2) {
         this.faceRenderType = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ldo;I)I"
   )
   final int method2646(ModelData var1, int var2) {
      int var3 = -1;
      int var4 = var1.vertexX[var2];
      int var5 = var1.vertexY[var2];
      int var6 = var1.vertexZ[var2];

      for(int var7 = 0; var7 < this.vertexCount; ++var7) {
         if(var4 == this.vertexX[var7] && var5 == this.vertexY[var7] && var6 == this.vertexZ[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.vertexX[this.vertexCount] = var4;
         this.vertexY[this.vertexCount] = var5;
         this.vertexZ[this.vertexCount] = var6;
         if(var1.vertexSkins != null) {
            this.vertexSkins[this.vertexCount] = var1.vertexSkins[var2];
         }

         var3 = this.vertexCount++;
      }

      return var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   public ModelData method2624() {
      ModelData var1 = new ModelData();
      if(this.faceRenderType != null) {
         var1.faceRenderType = new byte[this.triangleFaceCount];

         for(int var2 = 0; var2 < this.triangleFaceCount; ++var2) {
            var1.faceRenderType[var2] = this.faceRenderType[var2];
         }
      }

      var1.vertexCount = this.vertexCount;
      var1.triangleFaceCount = this.triangleFaceCount;
      var1.field1521 = this.field1521;
      var1.vertexX = this.vertexX;
      var1.vertexY = this.vertexY;
      var1.vertexZ = this.vertexZ;
      var1.trianglePointsX = this.trianglePointsX;
      var1.trianglePointsY = this.trianglePointsY;
      var1.trianglePointsZ = this.trianglePointsZ;
      var1.faceRenderPriorities = this.faceRenderPriorities;
      var1.faceAlphas = this.faceAlphas;
      var1.textureCoords = this.textureCoords;
      var1.faceColor = this.faceColor;
      var1.faceTextures = this.faceTextures;
      var1.priority = this.priority;
      var1.textureRenderTypes = this.textureRenderTypes;
      var1.texTriangleX = this.texTriangleX;
      var1.texTriangleY = this.texTriangleY;
      var1.texTriangleZ = this.texTriangleZ;
      var1.field1501 = this.field1501;
      var1.field1508 = this.field1508;
      var1.field1527 = this.field1527;
      var1.field1504 = this.field1504;
      var1.field1507 = this.field1507;
      var1.field1505 = this.field1505;
      var1.texturePrimaryColor = this.texturePrimaryColor;
      var1.vertexSkins = this.vertexSkins;
      var1.triangleSkinValues = this.triangleSkinValues;
      var1.field1516 = this.field1516;
      var1.field1511 = this.field1511;
      var1.normals = this.normals;
      var1.faceNormals = this.faceNormals;
      var1.field1515 = this.field1515;
      var1.contrast = this.contrast;
      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Ldo;"
   )
   public ModelData method2625(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2637();
      int var7 = var2 + this.field1519;
      int var8 = var2 + this.field1498;
      int var9 = var4 + this.field1522;
      int var10 = var4 + this.field1496;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            ModelData var11 = new ModelData();
            var11.vertexCount = this.vertexCount;
            var11.triangleFaceCount = this.triangleFaceCount;
            var11.field1521 = this.field1521;
            var11.vertexX = this.vertexX;
            var11.vertexZ = this.vertexZ;
            var11.trianglePointsX = this.trianglePointsX;
            var11.trianglePointsY = this.trianglePointsY;
            var11.trianglePointsZ = this.trianglePointsZ;
            var11.faceRenderType = this.faceRenderType;
            var11.faceRenderPriorities = this.faceRenderPriorities;
            var11.faceAlphas = this.faceAlphas;
            var11.textureCoords = this.textureCoords;
            var11.faceColor = this.faceColor;
            var11.faceTextures = this.faceTextures;
            var11.priority = this.priority;
            var11.textureRenderTypes = this.textureRenderTypes;
            var11.texTriangleX = this.texTriangleX;
            var11.texTriangleY = this.texTriangleY;
            var11.texTriangleZ = this.texTriangleZ;
            var11.field1501 = this.field1501;
            var11.field1508 = this.field1508;
            var11.field1527 = this.field1527;
            var11.field1504 = this.field1504;
            var11.field1507 = this.field1507;
            var11.field1505 = this.field1505;
            var11.texturePrimaryColor = this.texturePrimaryColor;
            var11.vertexSkins = this.vertexSkins;
            var11.triangleSkinValues = this.triangleSkinValues;
            var11.field1516 = this.field1516;
            var11.field1511 = this.field1511;
            var11.field1515 = this.field1515;
            var11.contrast = this.contrast;
            var11.vertexY = new int[var11.vertexCount];
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
            if(var6 == 0) {
               for(var12 = 0; var12 < var11.vertexCount; ++var12) {
                  var13 = var2 + this.vertexX[var12];
                  var14 = var4 + this.vertexZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.vertexY[var12] = var21 + this.vertexY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.vertexCount; ++var12) {
                  var13 = (-this.vertexY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.vertexX[var12];
                     var15 = var4 + this.vertexZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.vertexY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.vertexY[var12];
                  }
               }
            }

            var11.method2638();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("l")
   @Export("computeAnimationTables")
   void computeAnimationTables() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.vertexSkins != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.vertexCount; ++var3) {
            var4 = this.vertexSkins[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1516 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1516[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.vertexCount; this.field1516[var4][var1[var4]++] = var3++) {
            var4 = this.vertexSkins[var3];
         }

         this.vertexSkins = null;
      }

      if(this.triangleSkinValues != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.triangleFaceCount; ++var3) {
            var4 = this.triangleSkinValues[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1511 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1511[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.triangleFaceCount; this.field1511[var4][var1[var4]++] = var3++) {
            var4 = this.triangleSkinValues[var3];
         }

         this.triangleSkinValues = null;
      }

   }

   @ObfuscatedName("d")
   public void method2649() {
      for(int var1 = 0; var1 < this.vertexCount; ++var1) {
         int var2 = this.vertexX[var1];
         this.vertexX[var1] = this.vertexZ[var1];
         this.vertexZ[var1] = -var2;
      }

      this.method2638();
   }

   @ObfuscatedName("p")
   public void method2627() {
      for(int var1 = 0; var1 < this.vertexCount; ++var1) {
         this.vertexX[var1] = -this.vertexX[var1];
         this.vertexZ[var1] = -this.vertexZ[var1];
      }

      this.method2638();
   }

   @ObfuscatedName("g")
   public void method2641() {
      for(int var1 = 0; var1 < this.vertexCount; ++var1) {
         int var2 = this.vertexZ[var1];
         this.vertexZ[var1] = this.vertexX[var1];
         this.vertexX[var1] = -var2;
      }

      this.method2638();
   }

   @ObfuscatedName("y")
   public void method2663(int var1) {
      int var2 = field1525[var1];
      int var3 = field1481[var1];

      for(int var4 = 0; var4 < this.vertexCount; ++var4) {
         int var5 = var2 * this.vertexZ[var4] + var3 * this.vertexX[var4] >> 16;
         this.vertexZ[var4] = var3 * this.vertexZ[var4] - var2 * this.vertexX[var4] >> 16;
         this.vertexX[var4] = var5;
      }

      this.method2638();
   }

   @ObfuscatedName("c")
   public void method2630(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.vertexCount; ++var4) {
         this.vertexX[var4] += var1;
         this.vertexY[var4] += var2;
         this.vertexZ[var4] += var3;
      }

      this.method2638();
   }

   @ObfuscatedName("e")
   @Export("recolor")
   public void recolor(short var1, short var2) {
      for(int var3 = 0; var3 < this.triangleFaceCount; ++var3) {
         if(this.faceColor[var3] == var1) {
            this.faceColor[var3] = var2;
         }
      }

   }

   @ObfuscatedName("t")
   public void method2632(short var1, short var2) {
      if(this.faceTextures != null) {
         for(int var3 = 0; var3 < this.triangleFaceCount; ++var3) {
            if(this.faceTextures[var3] == var1) {
               this.faceTextures[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("u")
   public void method2633() {
      int var1;
      for(var1 = 0; var1 < this.vertexCount; ++var1) {
         this.vertexZ[var1] = -this.vertexZ[var1];
      }

      for(var1 = 0; var1 < this.triangleFaceCount; ++var1) {
         int var2 = this.trianglePointsX[var1];
         this.trianglePointsX[var1] = this.trianglePointsZ[var1];
         this.trianglePointsZ[var1] = var2;
      }

      this.method2638();
   }

   @ObfuscatedName("i")
   public void method2674(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.vertexCount; ++var4) {
         this.vertexX[var4] = this.vertexX[var4] * var1 / 128;
         this.vertexY[var4] = var2 * this.vertexY[var4] / 128;
         this.vertexZ[var4] = var3 * this.vertexZ[var4] / 128;
      }

      this.method2638();
   }

   @ObfuscatedName("r")
   @Export("computeNormals")
   public void computeNormals() {
      if(this.normals == null) {
         this.normals = new VertexNormal[this.vertexCount];

         int var1;
         for(var1 = 0; var1 < this.vertexCount; ++var1) {
            this.normals[var1] = new VertexNormal();
         }

         for(var1 = 0; var1 < this.triangleFaceCount; ++var1) {
            int var2 = this.trianglePointsX[var1];
            int var3 = this.trianglePointsY[var1];
            int var4 = this.trianglePointsZ[var1];
            int var5 = this.vertexX[var3] - this.vertexX[var2];
            int var6 = this.vertexY[var3] - this.vertexY[var2];
            int var7 = this.vertexZ[var3] - this.vertexZ[var2];
            int var8 = this.vertexX[var4] - this.vertexX[var2];
            int var9 = this.vertexY[var4] - this.vertexY[var2];
            int var10 = this.vertexZ[var4] - this.vertexZ[var2];
            int var11 = var6 * var10 - var9 * var7;
            int var12 = var7 * var8 - var10 * var5;

            int var13;
            for(var13 = var5 * var9 - var8 * var6; var11 > 8192 || var12 > 8192 || var13 > 8192 || var11 < -8192 || var12 < -8192 || var13 < -8192; var13 >>= 1) {
               var11 >>= 1;
               var12 >>= 1;
            }

            int var14 = (int)Math.sqrt((double)(var11 * var11 + var12 * var12 + var13 * var13));
            if(var14 <= 0) {
               var14 = 1;
            }

            var11 = var11 * 256 / var14;
            var12 = var12 * 256 / var14;
            var13 = var13 * 256 / var14;
            byte var15;
            if(this.faceRenderType == null) {
               var15 = 0;
            } else {
               var15 = this.faceRenderType[var1];
            }

            if(var15 == 0) {
               VertexNormal var16 = this.normals[var2];
               var16.x += var11;
               var16.y += var12;
               var16.z += var13;
               ++var16.magnitude;
               var16 = this.normals[var3];
               var16.x += var11;
               var16.y += var12;
               var16.z += var13;
               ++var16.magnitude;
               var16 = this.normals[var4];
               var16.x += var11;
               var16.y += var12;
               var16.z += var13;
               ++var16.magnitude;
            } else if(var15 == 1) {
               if(this.faceNormals == null) {
                  this.faceNormals = new FaceNormal[this.triangleFaceCount];
               }

               FaceNormal var17 = this.faceNormals[var1] = new FaceNormal();
               var17.x = var11;
               var17.y = var12;
               var17.z = var13;
            }
         }

      }
   }

   @ObfuscatedName("v")
   void method2638() {
      this.normals = null;
      this.field1514 = null;
      this.faceNormals = null;
      this.field1517 = false;
   }

   @ObfuscatedName("o")
   void method2637() {
      if(!this.field1517) {
         super.modelHeight = 0;
         this.field1499 = 0;
         this.field1519 = 999999;
         this.field1498 = -999999;
         this.field1496 = -99999;
         this.field1522 = 99999;

         for(int var1 = 0; var1 < this.vertexCount; ++var1) {
            int var2 = this.vertexX[var1];
            int var3 = this.vertexY[var1];
            int var4 = this.vertexZ[var1];
            if(var2 < this.field1519) {
               this.field1519 = var2;
            }

            if(var2 > this.field1498) {
               this.field1498 = var2;
            }

            if(var4 < this.field1522) {
               this.field1522 = var4;
            }

            if(var4 > this.field1496) {
               this.field1496 = var4;
            }

            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1499) {
               this.field1499 = var3;
            }
         }

         this.field1517 = true;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIII)Ldk;"
   )
   @Export("light")
   public final Model light(int var1, int var2, int var3, int var4, int var5) {
      this.computeNormals();
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3 + var4 * var4));
      int var7 = var6 * var2 >> 8;
      Model var8 = new Model();
      var8.field1622 = new int[this.triangleFaceCount];
      var8.field1671 = new int[this.triangleFaceCount];
      var8.field1626 = new int[this.triangleFaceCount];
      if(this.field1521 > 0 && this.textureCoords != null) {
         int[] var9 = new int[this.field1521];

         int var10;
         for(var10 = 0; var10 < this.triangleFaceCount; ++var10) {
            if(this.textureCoords[var10] != -1) {
               ++var9[this.textureCoords[var10] & 255];
            }
         }

         var8.field1630 = 0;

         for(var10 = 0; var10 < this.field1521; ++var10) {
            if(var9[var10] > 0 && this.textureRenderTypes[var10] == 0) {
               ++var8.field1630;
            }
         }

         var8.field1635 = new int[var8.field1630];
         var8.field1632 = new int[var8.field1630];
         var8.field1633 = new int[var8.field1630];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1521; ++var11) {
            if(var9[var11] > 0 && this.textureRenderTypes[var11] == 0) {
               var8.field1635[var10] = this.texTriangleX[var11] & '\uffff';
               var8.field1632[var10] = this.texTriangleY[var11] & '\uffff';
               var8.field1633[var10] = this.texTriangleZ[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1627 = new byte[this.triangleFaceCount];

         for(var11 = 0; var11 < this.triangleFaceCount; ++var11) {
            if(this.textureCoords[var11] != -1) {
               var8.field1627[var11] = (byte)var9[this.textureCoords[var11] & 255];
            } else {
               var8.field1627[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.triangleFaceCount; ++var16) {
         byte var17;
         if(this.faceRenderType == null) {
            var17 = 0;
         } else {
            var17 = this.faceRenderType[var16];
         }

         byte var18;
         if(this.faceAlphas == null) {
            var18 = 0;
         } else {
            var18 = this.faceAlphas[var16];
         }

         short var12;
         if(this.faceTextures == null) {
            var12 = -1;
         } else {
            var12 = this.faceTextures[var16];
         }

         if(var18 == -2) {
            var17 = 3;
         }

         if(var18 == -1) {
            var17 = 2;
         }

         VertexNormal var13;
         int var14;
         FaceNormal var19;
         if(var12 == -1) {
            if(var17 != 0) {
               if(var17 == 1) {
                  var19 = this.faceNormals[var16];
                  var14 = (var4 * var19.y + var5 * var19.z + var3 * var19.x) / (var7 / 2 + var7) + var1;
                  var8.field1622[var16] = method2639(this.faceColor[var16] & '\uffff', var14);
                  var8.field1626[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1622[var16] = 128;
                  var8.field1626[var16] = -1;
               } else {
                  var8.field1626[var16] = -2;
               }
            } else {
               int var15 = this.faceColor[var16] & '\uffff';
               if(this.field1514 != null && this.field1514[this.trianglePointsX[var16]] != null) {
                  var13 = this.field1514[this.trianglePointsX[var16]];
               } else {
                  var13 = this.normals[this.trianglePointsX[var16]];
               }

               var14 = (var4 * var13.y + var5 * var13.z + var3 * var13.x) / (var7 * var13.magnitude) + var1;
               var8.field1622[var16] = method2639(var15, var14);
               if(this.field1514 != null && this.field1514[this.trianglePointsY[var16]] != null) {
                  var13 = this.field1514[this.trianglePointsY[var16]];
               } else {
                  var13 = this.normals[this.trianglePointsY[var16]];
               }

               var14 = (var4 * var13.y + var5 * var13.z + var3 * var13.x) / (var7 * var13.magnitude) + var1;
               var8.field1671[var16] = method2639(var15, var14);
               if(this.field1514 != null && this.field1514[this.trianglePointsZ[var16]] != null) {
                  var13 = this.field1514[this.trianglePointsZ[var16]];
               } else {
                  var13 = this.normals[this.trianglePointsZ[var16]];
               }

               var14 = (var4 * var13.y + var5 * var13.z + var3 * var13.x) / (var7 * var13.magnitude) + var1;
               var8.field1626[var16] = method2639(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.faceNormals[var16];
               var14 = (var4 * var19.y + var5 * var19.z + var3 * var19.x) / (var7 / 2 + var7) + var1;
               var8.field1622[var16] = method2676(var14);
               var8.field1626[var16] = -1;
            } else {
               var8.field1626[var16] = -2;
            }
         } else {
            if(this.field1514 != null && this.field1514[this.trianglePointsX[var16]] != null) {
               var13 = this.field1514[this.trianglePointsX[var16]];
            } else {
               var13 = this.normals[this.trianglePointsX[var16]];
            }

            var14 = (var4 * var13.y + var5 * var13.z + var3 * var13.x) / (var7 * var13.magnitude) + var1;
            var8.field1622[var16] = method2676(var14);
            if(this.field1514 != null && this.field1514[this.trianglePointsY[var16]] != null) {
               var13 = this.field1514[this.trianglePointsY[var16]];
            } else {
               var13 = this.normals[this.trianglePointsY[var16]];
            }

            var14 = (var4 * var13.y + var5 * var13.z + var3 * var13.x) / (var7 * var13.magnitude) + var1;
            var8.field1671[var16] = method2676(var14);
            if(this.field1514 != null && this.field1514[this.trianglePointsZ[var16]] != null) {
               var13 = this.field1514[this.trianglePointsZ[var16]];
            } else {
               var13 = this.normals[this.trianglePointsZ[var16]];
            }

            var14 = (var4 * var13.y + var5 * var13.z + var3 * var13.x) / (var7 * var13.magnitude) + var1;
            var8.field1626[var16] = method2676(var14);
         }
      }

      this.computeAnimationTables();
      var8.verticesCount = this.vertexCount;
      var8.verticesX = this.vertexX;
      var8.verticesY = this.vertexY;
      var8.verticesZ = this.vertexZ;
      var8.indicesCount = this.triangleFaceCount;
      var8.indices1 = this.trianglePointsX;
      var8.indices2 = this.trianglePointsY;
      var8.indices3 = this.trianglePointsZ;
      var8.field1648 = this.faceRenderPriorities;
      var8.field1629 = this.faceAlphas;
      var8.field1619 = this.priority;
      var8.vertexGroups = this.field1516;
      var8.field1660 = this.field1511;
      var8.field1628 = this.faceTextures;
      return var8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;II)Ldo;"
   )
   public static ModelData method2619(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new ModelData(var3);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ldo;Ldo;IIIZ)V"
   )
   static void method2660(ModelData var0, ModelData var1, int var2, int var3, int var4, boolean var5) {
      var0.method2637();
      var0.computeNormals();
      var1.method2637();
      var1.computeNormals();
      ++field1503;
      int var6 = 0;
      int[] var7 = var1.vertexX;
      int var8 = var1.vertexCount;

      int var9;
      for(var9 = 0; var9 < var0.vertexCount; ++var9) {
         VertexNormal var10 = var0.normals[var9];
         if(var10.magnitude != 0) {
            int var11 = var0.vertexY[var9] - var3;
            if(var11 <= var1.field1499) {
               int var12 = var0.vertexX[var9] - var2;
               if(var12 >= var1.field1519 && var12 <= var1.field1498) {
                  int var13 = var0.vertexZ[var9] - var4;
                  if(var13 >= var1.field1522 && var13 <= var1.field1496) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        VertexNormal var15 = var1.normals[var14];
                        if(var12 == var7[var14] && var13 == var1.vertexZ[var14] && var11 == var1.vertexY[var14] && var15.magnitude != 0) {
                           if(var0.field1514 == null) {
                              var0.field1514 = new VertexNormal[var0.vertexCount];
                           }

                           if(var1.field1514 == null) {
                              var1.field1514 = new VertexNormal[var8];
                           }

                           VertexNormal var16 = var0.field1514[var9];
                           if(var16 == null) {
                              var16 = var0.field1514[var9] = new VertexNormal(var10);
                           }

                           VertexNormal var17 = var1.field1514[var14];
                           if(var17 == null) {
                              var17 = var1.field1514[var14] = new VertexNormal(var15);
                           }

                           var16.x += var15.x;
                           var16.y += var15.y;
                           var16.z += var15.z;
                           var16.magnitude += var15.magnitude;
                           var17.x += var10.x;
                           var17.y += var10.y;
                           var17.z += var10.z;
                           var17.magnitude += var10.magnitude;
                           ++var6;
                           field1502[var9] = field1503;
                           field1524[var14] = field1503;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.triangleFaceCount; ++var9) {
            if(field1502[var0.trianglePointsX[var9]] == field1503 && field1502[var0.trianglePointsY[var9]] == field1503 && field1502[var0.trianglePointsZ[var9]] == field1503) {
               if(var0.faceRenderType == null) {
                  var0.faceRenderType = new byte[var0.triangleFaceCount];
               }

               var0.faceRenderType[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.triangleFaceCount; ++var9) {
            if(field1503 == field1524[var1.trianglePointsX[var9]] && field1503 == field1524[var1.trianglePointsY[var9]] && field1503 == field1524[var1.trianglePointsZ[var9]]) {
               if(var1.faceRenderType == null) {
                  var1.faceRenderType = new byte[var1.triangleFaceCount];
               }

               var1.faceRenderType[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("ad")
   static final int method2639(int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 65408) + var1;
   }

   @ObfuscatedName("ac")
   static final int method2676(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }
}
