import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("ModelData")
public class ModelData extends Renderable {
   @ObfuscatedName("y")
   short[] field1213;
   @ObfuscatedName("q")
   byte[] field1214;
   @ObfuscatedName("m")
   int[] field1215;
   @ObfuscatedName("am")
   public short field1216;
   @ObfuscatedName("w")
   int field1217 = 0;
   @ObfuscatedName("r")
   int[] field1218;
   @ObfuscatedName("c")
   int[] field1219;
   @ObfuscatedName("p")
   int[] field1220;
   @ObfuscatedName("g")
   byte[] field1221;
   @ObfuscatedName("z")
   byte[] field1222;
   @ObfuscatedName("h")
   int[] field1223;
   @ObfuscatedName("a")
   short[] field1224;
   @ObfuscatedName("u")
   short[] field1225;
   @ObfuscatedName("e")
   short[] field1226;
   @ObfuscatedName("n")
   int field1227 = 0;
   @ObfuscatedName("f")
   int field1228;
   @ObfuscatedName("d")
   int[] field1229;
   @ObfuscatedName("v")
   short[] field1230;
   @ObfuscatedName("i")
   short[] field1231;
   @ObfuscatedName("o")
   short[] field1232;
   @ObfuscatedName("b")
   short[] field1233;
   @ObfuscatedName("j")
   short[] field1234;
   @ObfuscatedName("k")
   short[] field1235;
   @ObfuscatedName("ax")
   int field1236;
   @ObfuscatedName("av")
   byte[] field1237;
   @ObfuscatedName("t")
   short[] field1238;
   @ObfuscatedName("l")
   byte[] field1239;
   @ObfuscatedName("aw")
   int[] field1240;
   @ObfuscatedName("ay")
   int[] field1241;
   @ObfuscatedName("as")
   int[][] field1242;
   @ObfuscatedName("ai")
   int[][] field1243;
   @ObfuscatedName("aq")
   FaceNormal[] field1244;
   @ObfuscatedName("ac")
   VertexNormal[] field1245;
   @ObfuscatedName("ae")
   VertexNormal[] field1246;
   @ObfuscatedName("ag")
   public short field1247;
   @ObfuscatedName("x")
   byte field1248 = 0;
   @ObfuscatedName("al")
   static int[] field1249 = new int[10000];
   @ObfuscatedName("ap")
   int field1250;
   @ObfuscatedName("az")
   int field1251;
   @ObfuscatedName("ab")
   int field1252;
   @ObfuscatedName("s")
   byte[] field1253;
   @ObfuscatedName("ad")
   int field1254;
   @ObfuscatedName("ah")
   static int[] field1255 = new int[10000];
   @ObfuscatedName("an")
   static int[] field1256;
   @ObfuscatedName("af")
   boolean field1257 = false;
   @ObfuscatedName("aa")
   static int field1258 = 0;
   @ObfuscatedName("at")
   static int[] field1259;

   @ObfuscatedName("f")
   public void method1490(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1217; ++var3) {
         if(this.field1213[var3] == var1) {
            this.field1213[var3] = var2;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)LModelData;",
      garbageValue = "0"
   )
   public static ModelData method1491(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3329(var1, var2);
      return var3 == null?null:new ModelData(var3);
   }

   ModelData(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method1492(var1);
      } else {
         this.method1493(var1);
      }

   }

   @ObfuscatedName("d")
   void method1492(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var2.offset = var1.length - 23;
      int var9 = var2.method3097();
      int var10 = var2.method3097();
      int var11 = var2.method3033();
      int var12 = var2.method3033();
      int var13 = var2.method3033();
      int var14 = var2.method3033();
      int var15 = var2.method3033();
      int var16 = var2.method3033();
      int var17 = var2.method3033();
      int var18 = var2.method3097();
      int var19 = var2.method3097();
      int var20 = var2.method3097();
      int var21 = var2.method3097();
      int var22 = var2.method3097();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1253 = new byte[var11];
         var2.offset = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1253[var26] = var2.method3047();
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
      this.field1227 = var9;
      this.field1217 = var10;
      this.field1228 = var11;
      this.field1229 = new int[var9];
      this.field1215 = new int[var9];
      this.field1223 = new int[var9];
      this.field1218 = new int[var10];
      this.field1219 = new int[var10];
      this.field1220 = new int[var10];
      if(var17 == 1) {
         this.field1240 = new int[var9];
      }

      if(var12 == 1) {
         this.field1221 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1222 = new byte[var10];
      } else {
         this.field1248 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1214 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1241 = new int[var10];
      }

      if(var16 == 1) {
         this.field1226 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1239 = new byte[var10];
      }

      this.field1213 = new short[var10];
      if(var11 > 0) {
         this.field1232 = new short[var11];
         this.field1231 = new short[var11];
         this.field1224 = new short[var11];
         if(var24 > 0) {
            this.field1233 = new short[var24];
            this.field1234 = new short[var24];
            this.field1235 = new short[var24];
            this.field1230 = new short[var24];
            this.field1237 = new byte[var24];
            this.field1225 = new short[var24];
         }

         if(var25 > 0) {
            this.field1238 = new short[var25];
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
         var52 = var2.method3033();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method3002();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method3002();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method3002();
         }

         this.field1229[var51] = var48 + var53;
         this.field1215[var51] = var49 + var54;
         this.field1223[var51] = var50 + var55;
         var48 = this.field1229[var51];
         var49 = this.field1215[var51];
         var50 = this.field1223[var51];
         if(var17 == 1) {
            this.field1240[var51] = var6.method3033();
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
         this.field1213[var51] = (short)var2.method3097();
         if(var12 == 1) {
            this.field1221[var51] = var3.method3047();
         }

         if(var13 == 255) {
            this.field1222[var51] = var4.method3047();
         }

         if(var14 == 1) {
            this.field1214[var51] = var5.method3047();
         }

         if(var15 == 1) {
            this.field1241[var51] = var6.method3033();
         }

         if(var16 == 1) {
            this.field1226[var51] = (short)(var7.method3097() - 1);
         }

         if(this.field1239 != null && this.field1226[var51] != -1) {
            this.field1239[var51] = (byte)(var8.method3033() - 1);
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
         var56 = var3.method3033();
         if(var56 == 1) {
            var51 = var2.method3002() + var54;
            var52 = var2.method3002() + var51;
            var53 = var2.method3002() + var52;
            var54 = var53;
            this.field1218[var55] = var51;
            this.field1219[var55] = var52;
            this.field1220[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method3002() + var54;
            var54 = var53;
            this.field1218[var55] = var51;
            this.field1219[var55] = var52;
            this.field1220[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method3002() + var54;
            var54 = var53;
            this.field1218[var55] = var51;
            this.field1219[var55] = var52;
            this.field1220[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method3002() + var54;
            var54 = var53;
            this.field1218[var55] = var51;
            this.field1219[var55] = var57;
            this.field1220[var55] = var53;
         }
      }

      var2.offset = var41;
      var3.offset = var42;
      var4.offset = var43;
      var5.offset = var44;
      var6.offset = var45;
      var7.offset = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1253[var55] & 255;
         if(var56 == 0) {
            this.field1232[var55] = (short)var2.method3097();
            this.field1231[var55] = (short)var2.method3097();
            this.field1224[var55] = (short)var2.method3097();
         }

         if(var56 == 1) {
            this.field1232[var55] = (short)var3.method3097();
            this.field1231[var55] = (short)var3.method3097();
            this.field1224[var55] = (short)var3.method3097();
            this.field1233[var55] = (short)var4.method3097();
            this.field1234[var55] = (short)var4.method3097();
            this.field1235[var55] = (short)var4.method3097();
            this.field1230[var55] = (short)var5.method3097();
            this.field1237[var55] = var6.method3047();
            this.field1225[var55] = (short)var7.method3097();
         }

         if(var56 == 2) {
            this.field1232[var55] = (short)var3.method3097();
            this.field1231[var55] = (short)var3.method3097();
            this.field1224[var55] = (short)var3.method3097();
            this.field1233[var55] = (short)var4.method3097();
            this.field1234[var55] = (short)var4.method3097();
            this.field1235[var55] = (short)var4.method3097();
            this.field1230[var55] = (short)var5.method3097();
            this.field1237[var55] = var6.method3047();
            this.field1225[var55] = (short)var7.method3097();
            this.field1238[var55] = (short)var7.method3097();
         }

         if(var56 == 3) {
            this.field1232[var55] = (short)var3.method3097();
            this.field1231[var55] = (short)var3.method3097();
            this.field1224[var55] = (short)var3.method3097();
            this.field1233[var55] = (short)var4.method3097();
            this.field1234[var55] = (short)var4.method3097();
            this.field1235[var55] = (short)var4.method3097();
            this.field1230[var55] = (short)var5.method3097();
            this.field1237[var55] = var6.method3047();
            this.field1225[var55] = (short)var7.method3097();
         }
      }

      var2.offset = var26;
      var55 = var2.method3033();
      if(var55 != 0) {
         new class88();
         var2.method3097();
         var2.method3097();
         var2.method3097();
         var2.method2995();
      }

   }

   @ObfuscatedName("h")
   void method1493(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var4.offset = var1.length - 18;
      int var9 = var4.method3097();
      int var10 = var4.method3097();
      int var11 = var4.method3033();
      int var12 = var4.method3033();
      int var13 = var4.method3033();
      int var14 = var4.method3033();
      int var15 = var4.method3033();
      int var16 = var4.method3033();
      int var17 = var4.method3097();
      int var18 = var4.method3097();
      int var19 = var4.method3097();
      int var20 = var4.method3097();
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
      this.field1227 = var9;
      this.field1217 = var10;
      this.field1228 = var11;
      this.field1229 = new int[var9];
      this.field1215 = new int[var9];
      this.field1223 = new int[var9];
      this.field1218 = new int[var10];
      this.field1219 = new int[var10];
      this.field1220 = new int[var10];
      if(var11 > 0) {
         this.field1253 = new byte[var11];
         this.field1232 = new short[var11];
         this.field1231 = new short[var11];
         this.field1224 = new short[var11];
      }

      if(var16 == 1) {
         this.field1240 = new int[var9];
      }

      if(var12 == 1) {
         this.field1221 = new byte[var10];
         this.field1239 = new byte[var10];
         this.field1226 = new short[var10];
      }

      if(var13 == 255) {
         this.field1222 = new byte[var10];
      } else {
         this.field1248 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1214 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1241 = new int[var10];
      }

      this.field1213 = new short[var10];
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
         var39 = var4.method3033();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method3002();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method3002();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method3002();
         }

         this.field1229[var38] = var35 + var40;
         this.field1215[var38] = var36 + var41;
         this.field1223[var38] = var37 + var42;
         var35 = this.field1229[var38];
         var36 = this.field1215[var38];
         var37 = this.field1223[var38];
         if(var16 == 1) {
            this.field1240[var38] = var8.method3033();
         }
      }

      var4.offset = var30;
      var5.offset = var26;
      var6.offset = var24;
      var7.offset = var28;
      var8.offset = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1213[var38] = (short)var4.method3097();
         if(var12 == 1) {
            var39 = var5.method3033();
            if((var39 & 1) == 1) {
               this.field1221[var38] = 1;
               var2 = true;
            } else {
               this.field1221[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1239[var38] = (byte)(var39 >> 2);
               this.field1226[var38] = this.field1213[var38];
               this.field1213[var38] = 127;
               if(this.field1226[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1239[var38] = -1;
               this.field1226[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1222[var38] = var6.method3047();
         }

         if(var14 == 1) {
            this.field1214[var38] = var7.method3047();
         }

         if(var15 == 1) {
            this.field1241[var38] = var8.method3033();
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
         var43 = var5.method3033();
         if(var43 == 1) {
            var38 = var4.method3002() + var41;
            var39 = var4.method3002() + var38;
            var40 = var4.method3002() + var39;
            var41 = var40;
            this.field1218[var42] = var38;
            this.field1219[var42] = var39;
            this.field1220[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method3002() + var41;
            var41 = var40;
            this.field1218[var42] = var38;
            this.field1219[var42] = var39;
            this.field1220[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method3002() + var41;
            var41 = var40;
            this.field1218[var42] = var38;
            this.field1219[var42] = var39;
            this.field1220[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method3002() + var41;
            var41 = var40;
            this.field1218[var42] = var38;
            this.field1219[var42] = var44;
            this.field1220[var42] = var40;
         }
      }

      var4.offset = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1253[var42] = 0;
         this.field1232[var42] = (short)var4.method3097();
         this.field1231[var42] = (short)var4.method3097();
         this.field1224[var42] = (short)var4.method3097();
      }

      if(this.field1239 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1239[var43] & 255;
            if(var44 != 255) {
               if((this.field1232[var44] & '\uffff') == this.field1218[var43] && (this.field1231[var44] & '\uffff') == this.field1219[var43] && (this.field1224[var44] & '\uffff') == this.field1220[var43]) {
                  this.field1239[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1239 = null;
         }
      }

      if(!var3) {
         this.field1226 = null;
      }

      if(!var2) {
         this.field1221 = null;
      }

   }

   @ObfuscatedName("w")
   final int method1495(ModelData var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1229[var2];
      int var5 = var1.field1215[var2];
      int var6 = var1.field1223[var2];

      for(int var7 = 0; var7 < this.field1227; ++var7) {
         if(var4 == this.field1229[var7] && var5 == this.field1215[var7] && var6 == this.field1223[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1229[this.field1227] = var4;
         this.field1215[this.field1227] = var5;
         this.field1223[this.field1227] = var6;
         if(var1.field1240 != null) {
            this.field1240[this.field1227] = var1.field1240[var2];
         }

         var3 = this.field1227++;
      }

      return var3;
   }

   @ObfuscatedName("u")
   void method1496() {
      this.field1245 = null;
      this.field1246 = null;
      this.field1244 = null;
      this.field1257 = false;
   }

   @ObfuscatedName("r")
   public ModelData method1497() {
      ModelData var1 = new ModelData();
      if(this.field1221 != null) {
         var1.field1221 = new byte[this.field1217];

         for(int var2 = 0; var2 < this.field1217; ++var2) {
            var1.field1221[var2] = this.field1221[var2];
         }
      }

      var1.field1227 = this.field1227;
      var1.field1217 = this.field1217;
      var1.field1228 = this.field1228;
      var1.field1229 = this.field1229;
      var1.field1215 = this.field1215;
      var1.field1223 = this.field1223;
      var1.field1218 = this.field1218;
      var1.field1219 = this.field1219;
      var1.field1220 = this.field1220;
      var1.field1222 = this.field1222;
      var1.field1214 = this.field1214;
      var1.field1239 = this.field1239;
      var1.field1213 = this.field1213;
      var1.field1226 = this.field1226;
      var1.field1248 = this.field1248;
      var1.field1253 = this.field1253;
      var1.field1232 = this.field1232;
      var1.field1231 = this.field1231;
      var1.field1224 = this.field1224;
      var1.field1233 = this.field1233;
      var1.field1234 = this.field1234;
      var1.field1235 = this.field1235;
      var1.field1230 = this.field1230;
      var1.field1237 = this.field1237;
      var1.field1225 = this.field1225;
      var1.field1238 = this.field1238;
      var1.field1240 = this.field1240;
      var1.field1241 = this.field1241;
      var1.field1242 = this.field1242;
      var1.field1243 = this.field1243;
      var1.field1245 = this.field1245;
      var1.field1244 = this.field1244;
      var1.field1247 = this.field1247;
      var1.field1216 = this.field1216;
      return var1;
   }

   @ObfuscatedName("z")
   @Export("computeAnimationTables")
   void computeAnimationTables() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1240 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1227; ++var3) {
            var4 = this.field1240[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1242 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1242[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1227; this.field1242[var4][var1[var4]++] = var3++) {
            var4 = this.field1240[var3];
         }

         this.field1240 = null;
      }

      if(this.field1241 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1217; ++var3) {
            var4 = this.field1241[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1243 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1243[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1217; this.field1243[var4][var1[var4]++] = var3++) {
            var4 = this.field1241[var3];
         }

         this.field1241 = null;
      }

   }

   @ObfuscatedName("q")
   public void method1500() {
      for(int var1 = 0; var1 < this.field1227; ++var1) {
         int var2 = this.field1229[var1];
         this.field1229[var1] = this.field1223[var1];
         this.field1223[var1] = -var2;
      }

      this.method1496();
   }

   @ObfuscatedName("l")
   public void method1501() {
      for(int var1 = 0; var1 < this.field1227; ++var1) {
         this.field1229[var1] = -this.field1229[var1];
         this.field1223[var1] = -this.field1223[var1];
      }

      this.method1496();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method1502(int var1) {
      int var2 = field1256[var1];
      int var3 = field1259[var1];

      for(int var4 = 0; var4 < this.field1227; ++var4) {
         int var5 = this.field1223[var4] * var2 + this.field1229[var4] * var3 >> 16;
         this.field1223[var4] = this.field1223[var4] * var3 - this.field1229[var4] * var2 >> 16;
         this.field1229[var4] = var5;
      }

      this.method1496();
   }

   @ObfuscatedName("x")
   public void method1504(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1227; ++var4) {
         this.field1229[var4] += var1;
         this.field1215[var4] += var2;
         this.field1223[var4] += var3;
      }

      this.method1496();
   }

   @ObfuscatedName("s")
   public void method1506(short var1, short var2) {
      if(this.field1226 != null) {
         for(int var3 = 0; var3 < this.field1217; ++var3) {
            if(this.field1226[var3] == var1) {
               this.field1226[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("o")
   public void method1507() {
      int var1;
      for(var1 = 0; var1 < this.field1227; ++var1) {
         this.field1223[var1] = -this.field1223[var1];
      }

      for(var1 = 0; var1 < this.field1217; ++var1) {
         int var2 = this.field1218[var1];
         this.field1218[var1] = this.field1220[var1];
         this.field1220[var1] = var2;
      }

      this.method1496();
   }

   @ObfuscatedName("k")
   public void method1508(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1227; ++var4) {
         this.field1229[var4] = this.field1229[var4] * var1 / 128;
         this.field1215[var4] = this.field1215[var4] * var2 / 128;
         this.field1223[var4] = this.field1223[var4] * var3 / 128;
      }

      this.method1496();
   }

   static {
      field1256 = class84.field1444;
      field1259 = class84.field1445;
   }

   @ObfuscatedName("aw")
   public final Model method1512(int var1, int var2, int var3, int var4, int var5) {
      this.computeNormals();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      Model var8 = new Model();
      var8.field1360 = new int[this.field1217];
      var8.field1361 = new int[this.field1217];
      var8.field1362 = new int[this.field1217];
      if(this.field1228 > 0 && this.field1239 != null) {
         int[] var16 = new int[this.field1228];

         int var10;
         for(var10 = 0; var10 < this.field1217; ++var10) {
            if(this.field1239[var10] != -1) {
               ++var16[this.field1239[var10] & 255];
            }
         }

         var8.field1368 = 0;

         for(var10 = 0; var10 < this.field1228; ++var10) {
            if(var16[var10] > 0 && this.field1253[var10] == 0) {
               ++var8.field1368;
            }
         }

         var8.field1406 = new int[var8.field1368];
         var8.field1355 = new int[var8.field1368];
         var8.field1371 = new int[var8.field1368];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1228; ++var11) {
            if(var16[var11] > 0 && this.field1253[var11] == 0) {
               var8.field1406[var10] = this.field1232[var11] & '\uffff';
               var8.field1355[var10] = this.field1231[var11] & '\uffff';
               var8.field1371[var10] = this.field1224[var11] & '\uffff';
               var16[var11] = var10++;
            } else {
               var16[var11] = -1;
            }
         }

         var8.field1365 = new byte[this.field1217];

         for(var11 = 0; var11 < this.field1217; ++var11) {
            if(this.field1239[var11] != -1) {
               var8.field1365[var11] = (byte)var16[this.field1239[var11] & 255];
            } else {
               var8.field1365[var11] = -1;
            }
         }
      }

      for(int var9 = 0; var9 < this.field1217; ++var9) {
         byte var17;
         if(this.field1221 == null) {
            var17 = 0;
         } else {
            var17 = this.field1221[var9];
         }

         byte var18;
         if(this.field1214 == null) {
            var18 = 0;
         } else {
            var18 = this.field1214[var9];
         }

         short var12;
         if(this.field1226 == null) {
            var12 = -1;
         } else {
            var12 = this.field1226[var9];
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
                  var19 = this.field1244[var9];
                  var14 = var1 + (var3 * var19.field1556 + var4 * var19.field1551 + var5 * var19.field1552) / (var7 + var7 / 2);
                  var8.field1360[var9] = method1513(this.field1213[var9] & '\uffff', var14);
                  var8.field1362[var9] = -1;
               } else if(var17 == 3) {
                  var8.field1360[var9] = 128;
                  var8.field1362[var9] = -1;
               } else {
                  var8.field1362[var9] = -2;
               }
            } else {
               int var15 = this.field1213[var9] & '\uffff';
               if(this.field1246 != null && this.field1246[this.field1218[var9]] != null) {
                  var13 = this.field1246[this.field1218[var9]];
               } else {
                  var13 = this.field1245[this.field1218[var9]];
               }

               var14 = var1 + (var3 * var13.field1417 + var4 * var13.field1415 + var5 * var13.field1418) / (var7 * var13.field1416);
               var8.field1360[var9] = method1513(var15, var14);
               if(this.field1246 != null && this.field1246[this.field1219[var9]] != null) {
                  var13 = this.field1246[this.field1219[var9]];
               } else {
                  var13 = this.field1245[this.field1219[var9]];
               }

               var14 = var1 + (var3 * var13.field1417 + var4 * var13.field1415 + var5 * var13.field1418) / (var7 * var13.field1416);
               var8.field1361[var9] = method1513(var15, var14);
               if(this.field1246 != null && this.field1246[this.field1220[var9]] != null) {
                  var13 = this.field1246[this.field1220[var9]];
               } else {
                  var13 = this.field1245[this.field1220[var9]];
               }

               var14 = var1 + (var3 * var13.field1417 + var4 * var13.field1415 + var5 * var13.field1418) / (var7 * var13.field1416);
               var8.field1362[var9] = method1513(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1244[var9];
               var14 = var1 + (var3 * var19.field1556 + var4 * var19.field1551 + var5 * var19.field1552) / (var7 + var7 / 2);
               var8.field1360[var9] = method1539(var14);
               var8.field1362[var9] = -1;
            } else {
               var8.field1362[var9] = -2;
            }
         } else {
            if(this.field1246 != null && this.field1246[this.field1218[var9]] != null) {
               var13 = this.field1246[this.field1218[var9]];
            } else {
               var13 = this.field1245[this.field1218[var9]];
            }

            var14 = var1 + (var3 * var13.field1417 + var4 * var13.field1415 + var5 * var13.field1418) / (var7 * var13.field1416);
            var8.field1360[var9] = method1539(var14);
            if(this.field1246 != null && this.field1246[this.field1219[var9]] != null) {
               var13 = this.field1246[this.field1219[var9]];
            } else {
               var13 = this.field1245[this.field1219[var9]];
            }

            var14 = var1 + (var3 * var13.field1417 + var4 * var13.field1415 + var5 * var13.field1418) / (var7 * var13.field1416);
            var8.field1361[var9] = method1539(var14);
            if(this.field1246 != null && this.field1246[this.field1220[var9]] != null) {
               var13 = this.field1246[this.field1220[var9]];
            } else {
               var13 = this.field1245[this.field1220[var9]];
            }

            var14 = var1 + (var3 * var13.field1417 + var4 * var13.field1415 + var5 * var13.field1418) / (var7 * var13.field1416);
            var8.field1362[var9] = method1539(var14);
         }
      }

      this.computeAnimationTables();
      var8.field1351 = this.field1227;
      var8.verticesX = this.field1229;
      var8.verticesY = this.field1215;
      var8.verticesZ = this.field1223;
      var8.field1356 = this.field1217;
      var8.indices1 = this.field1218;
      var8.indices2 = this.field1219;
      var8.indices3 = this.field1220;
      var8.field1410 = this.field1222;
      var8.field1364 = this.field1214;
      var8.field1367 = this.field1248;
      var8.field1372 = this.field1242;
      var8.field1369 = this.field1243;
      var8.field1366 = this.field1226;
      return var8;
   }

   @ObfuscatedName("ay")
   static final int method1513(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedSignature(
      signature = "(LModelData;ZZZZ)V",
      garbageValue = "1"
   )
   public ModelData(ModelData var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1227 = var1.field1227;
      this.field1217 = var1.field1217;
      this.field1228 = var1.field1228;
      int var6;
      if(var2) {
         this.field1229 = var1.field1229;
         this.field1215 = var1.field1215;
         this.field1223 = var1.field1223;
      } else {
         this.field1229 = new int[this.field1227];
         this.field1215 = new int[this.field1227];
         this.field1223 = new int[this.field1227];

         for(var6 = 0; var6 < this.field1227; ++var6) {
            this.field1229[var6] = var1.field1229[var6];
            this.field1215[var6] = var1.field1215[var6];
            this.field1223[var6] = var1.field1223[var6];
         }
      }

      if(var3) {
         this.field1213 = var1.field1213;
      } else {
         this.field1213 = new short[this.field1217];

         for(var6 = 0; var6 < this.field1217; ++var6) {
            this.field1213[var6] = var1.field1213[var6];
         }
      }

      if(!var4 && var1.field1226 != null) {
         this.field1226 = new short[this.field1217];

         for(var6 = 0; var6 < this.field1217; ++var6) {
            this.field1226[var6] = var1.field1226[var6];
         }
      } else {
         this.field1226 = var1.field1226;
      }

      this.field1214 = var1.field1214;
      this.field1218 = var1.field1218;
      this.field1219 = var1.field1219;
      this.field1220 = var1.field1220;
      this.field1221 = var1.field1221;
      this.field1222 = var1.field1222;
      this.field1239 = var1.field1239;
      this.field1248 = var1.field1248;
      this.field1253 = var1.field1253;
      this.field1232 = var1.field1232;
      this.field1231 = var1.field1231;
      this.field1224 = var1.field1224;
      this.field1233 = var1.field1233;
      this.field1234 = var1.field1234;
      this.field1235 = var1.field1235;
      this.field1230 = var1.field1230;
      this.field1237 = var1.field1237;
      this.field1225 = var1.field1225;
      this.field1238 = var1.field1238;
      this.field1240 = var1.field1240;
      this.field1241 = var1.field1241;
      this.field1242 = var1.field1242;
      this.field1243 = var1.field1243;
      this.field1245 = var1.field1245;
      this.field1244 = var1.field1244;
      this.field1246 = var1.field1246;
      this.field1247 = var1.field1247;
      this.field1216 = var1.field1216;
   }

   @ObfuscatedName("t")
   void method1514() {
      if(!this.field1257) {
         super.modelHeight = 0;
         this.field1250 = 0;
         this.field1251 = 999999;
         this.field1252 = -999999;
         this.field1236 = -99999;
         this.field1254 = 99999;

         for(int var1 = 0; var1 < this.field1227; ++var1) {
            int var2 = this.field1229[var1];
            int var3 = this.field1215[var1];
            int var4 = this.field1223[var1];
            if(var2 < this.field1251) {
               this.field1251 = var2;
            }

            if(var2 > this.field1252) {
               this.field1252 = var2;
            }

            if(var4 < this.field1254) {
               this.field1254 = var4;
            }

            if(var4 > this.field1236) {
               this.field1236 = var4;
            }

            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1250) {
               this.field1250 = var3;
            }
         }

         this.field1257 = true;
      }
   }

   public ModelData(ModelData[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1227 = 0;
      this.field1217 = 0;
      this.field1228 = 0;
      this.field1248 = -1;

      int var9;
      ModelData var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1227 += var10.field1227;
            this.field1217 += var10.field1217;
            this.field1228 += var10.field1228;
            if(var10.field1222 != null) {
               var4 = true;
            } else {
               if(this.field1248 == -1) {
                  this.field1248 = var10.field1248;
               }

               if(this.field1248 != var10.field1248) {
                  var4 = true;
               }
            }

            var3 |= var10.field1221 != null;
            var5 |= var10.field1214 != null;
            var6 |= var10.field1241 != null;
            var7 |= var10.field1226 != null;
            var8 |= var10.field1239 != null;
         }
      }

      this.field1229 = new int[this.field1227];
      this.field1215 = new int[this.field1227];
      this.field1223 = new int[this.field1227];
      this.field1240 = new int[this.field1227];
      this.field1218 = new int[this.field1217];
      this.field1219 = new int[this.field1217];
      this.field1220 = new int[this.field1217];
      if(var3) {
         this.field1221 = new byte[this.field1217];
      }

      if(var4) {
         this.field1222 = new byte[this.field1217];
      }

      if(var5) {
         this.field1214 = new byte[this.field1217];
      }

      if(var6) {
         this.field1241 = new int[this.field1217];
      }

      if(var7) {
         this.field1226 = new short[this.field1217];
      }

      if(var8) {
         this.field1239 = new byte[this.field1217];
      }

      this.field1213 = new short[this.field1217];
      if(this.field1228 > 0) {
         this.field1253 = new byte[this.field1228];
         this.field1232 = new short[this.field1228];
         this.field1231 = new short[this.field1228];
         this.field1224 = new short[this.field1228];
         this.field1233 = new short[this.field1228];
         this.field1234 = new short[this.field1228];
         this.field1235 = new short[this.field1228];
         this.field1230 = new short[this.field1228];
         this.field1237 = new byte[this.field1228];
         this.field1225 = new short[this.field1228];
         this.field1238 = new short[this.field1228];
      }

      this.field1227 = 0;
      this.field1217 = 0;
      this.field1228 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1217; ++var11) {
               if(var3 && var10.field1221 != null) {
                  this.field1221[this.field1217] = var10.field1221[var11];
               }

               if(var4) {
                  if(var10.field1222 != null) {
                     this.field1222[this.field1217] = var10.field1222[var11];
                  } else {
                     this.field1222[this.field1217] = var10.field1248;
                  }
               }

               if(var5 && var10.field1214 != null) {
                  this.field1214[this.field1217] = var10.field1214[var11];
               }

               if(var6 && var10.field1241 != null) {
                  this.field1241[this.field1217] = var10.field1241[var11];
               }

               if(var7) {
                  if(var10.field1226 != null) {
                     this.field1226[this.field1217] = var10.field1226[var11];
                  } else {
                     this.field1226[this.field1217] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1239 != null && var10.field1239[var11] != -1) {
                     this.field1239[this.field1217] = (byte)(var10.field1239[var11] + this.field1228);
                  } else {
                     this.field1239[this.field1217] = -1;
                  }
               }

               this.field1213[this.field1217] = var10.field1213[var11];
               this.field1218[this.field1217] = this.method1495(var10, var10.field1218[var11]);
               this.field1219[this.field1217] = this.method1495(var10, var10.field1219[var11]);
               this.field1220[this.field1217] = this.method1495(var10, var10.field1220[var11]);
               ++this.field1217;
            }

            for(var11 = 0; var11 < var10.field1228; ++var11) {
               byte var12 = this.field1253[this.field1228] = var10.field1253[var11];
               if(var12 == 0) {
                  this.field1232[this.field1228] = (short)this.method1495(var10, var10.field1232[var11]);
                  this.field1231[this.field1228] = (short)this.method1495(var10, var10.field1231[var11]);
                  this.field1224[this.field1228] = (short)this.method1495(var10, var10.field1224[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1232[this.field1228] = var10.field1232[var11];
                  this.field1231[this.field1228] = var10.field1231[var11];
                  this.field1224[this.field1228] = var10.field1224[var11];
                  this.field1233[this.field1228] = var10.field1233[var11];
                  this.field1234[this.field1228] = var10.field1234[var11];
                  this.field1235[this.field1228] = var10.field1235[var11];
                  this.field1230[this.field1228] = var10.field1230[var11];
                  this.field1237[this.field1228] = var10.field1237[var11];
                  this.field1225[this.field1228] = var10.field1225[var11];
               }

               if(var12 == 2) {
                  this.field1238[this.field1228] = var10.field1238[var11];
               }

               ++this.field1228;
            }
         }
      }

   }

   @ObfuscatedName("av")
   static void method1520(ModelData var0, ModelData var1, int var2, int var3, int var4, boolean var5) {
      var0.method1514();
      var0.computeNormals();
      var1.method1514();
      var1.computeNormals();
      ++field1258;
      int var6 = 0;
      int[] var7 = var1.field1229;
      int var8 = var1.field1227;

      int var9;
      for(var9 = 0; var9 < var0.field1227; ++var9) {
         VertexNormal var10 = var0.field1245[var9];
         if(var10.field1416 != 0) {
            int var11 = var0.field1215[var9] - var3;
            if(var11 <= var1.field1250) {
               int var12 = var0.field1229[var9] - var2;
               if(var12 >= var1.field1251 && var12 <= var1.field1252) {
                  int var13 = var0.field1223[var9] - var4;
                  if(var13 >= var1.field1254 && var13 <= var1.field1236) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        VertexNormal var15 = var1.field1245[var14];
                        if(var12 == var7[var14] && var13 == var1.field1223[var14] && var11 == var1.field1215[var14] && var15.field1416 != 0) {
                           if(var0.field1246 == null) {
                              var0.field1246 = new VertexNormal[var0.field1227];
                           }

                           if(var1.field1246 == null) {
                              var1.field1246 = new VertexNormal[var8];
                           }

                           VertexNormal var16 = var0.field1246[var9];
                           if(var16 == null) {
                              var16 = var0.field1246[var9] = new VertexNormal(var10);
                           }

                           VertexNormal var17 = var1.field1246[var14];
                           if(var17 == null) {
                              var17 = var1.field1246[var14] = new VertexNormal(var15);
                           }

                           var16.field1417 += var15.field1417;
                           var16.field1415 += var15.field1415;
                           var16.field1418 += var15.field1418;
                           var16.field1416 += var15.field1416;
                           var17.field1417 += var10.field1417;
                           var17.field1415 += var10.field1415;
                           var17.field1418 += var10.field1418;
                           var17.field1416 += var10.field1416;
                           ++var6;
                           field1255[var9] = field1258;
                           field1249[var14] = field1258;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1217; ++var9) {
            if(field1255[var0.field1218[var9]] == field1258 && field1255[var0.field1219[var9]] == field1258 && field1255[var0.field1220[var9]] == field1258) {
               if(var0.field1221 == null) {
                  var0.field1221 = new byte[var0.field1217];
               }

               var0.field1221[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1217; ++var9) {
            if(field1249[var1.field1218[var9]] == field1258 && field1249[var1.field1219[var9]] == field1258 && field1249[var1.field1220[var9]] == field1258) {
               if(var1.field1221 == null) {
                  var1.field1221 = new byte[var1.field1217];
               }

               var1.field1221[var9] = 2;
            }
         }

      }
   }

   ModelData() {
   }

   @ObfuscatedName("as")
   static final int method1539(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("y")
   public void method1540() {
      for(int var1 = 0; var1 < this.field1227; ++var1) {
         int var2 = this.field1223[var1];
         this.field1223[var1] = this.field1229[var1];
         this.field1229[var1] = -var2;
      }

      this.method1496();
   }

   @ObfuscatedName("c")
   public ModelData method1561(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method1514();
      int var7 = var2 + this.field1251;
      int var8 = var2 + this.field1252;
      int var9 = var4 + this.field1254;
      int var10 = var4 + this.field1236;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            ModelData var11 = new ModelData();
            var11.field1227 = this.field1227;
            var11.field1217 = this.field1217;
            var11.field1228 = this.field1228;
            var11.field1229 = this.field1229;
            var11.field1223 = this.field1223;
            var11.field1218 = this.field1218;
            var11.field1219 = this.field1219;
            var11.field1220 = this.field1220;
            var11.field1221 = this.field1221;
            var11.field1222 = this.field1222;
            var11.field1214 = this.field1214;
            var11.field1239 = this.field1239;
            var11.field1213 = this.field1213;
            var11.field1226 = this.field1226;
            var11.field1248 = this.field1248;
            var11.field1253 = this.field1253;
            var11.field1232 = this.field1232;
            var11.field1231 = this.field1231;
            var11.field1224 = this.field1224;
            var11.field1233 = this.field1233;
            var11.field1234 = this.field1234;
            var11.field1235 = this.field1235;
            var11.field1230 = this.field1230;
            var11.field1237 = this.field1237;
            var11.field1225 = this.field1225;
            var11.field1238 = this.field1238;
            var11.field1240 = this.field1240;
            var11.field1241 = this.field1241;
            var11.field1242 = this.field1242;
            var11.field1243 = this.field1243;
            var11.field1247 = this.field1247;
            var11.field1216 = this.field1216;
            var11.field1215 = new int[var11.field1227];
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
               for(var12 = 0; var12 < var11.field1227; ++var12) {
                  var13 = this.field1229[var12] + var2;
                  var14 = this.field1223[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1215[var12] = this.field1215[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1227; ++var12) {
                  var13 = (-this.field1215[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = this.field1229[var12] + var2;
                     var15 = this.field1223[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1215[var12] = this.field1215[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method1496();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("v")
   @Export("computeNormals")
   public void computeNormals() {
      if(this.field1245 == null) {
         this.field1245 = new VertexNormal[this.field1227];

         int var1;
         for(var1 = 0; var1 < this.field1227; ++var1) {
            this.field1245[var1] = new VertexNormal();
         }

         for(var1 = 0; var1 < this.field1217; ++var1) {
            int var2 = this.field1218[var1];
            int var3 = this.field1219[var1];
            int var4 = this.field1220[var1];
            int var5 = this.field1229[var3] - this.field1229[var2];
            int var6 = this.field1215[var3] - this.field1215[var2];
            int var7 = this.field1223[var3] - this.field1223[var2];
            int var8 = this.field1229[var4] - this.field1229[var2];
            int var9 = this.field1215[var4] - this.field1215[var2];
            int var10 = this.field1223[var4] - this.field1223[var2];
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
            if(this.field1221 == null) {
               var15 = 0;
            } else {
               var15 = this.field1221[var1];
            }

            if(var15 == 0) {
               VertexNormal var16 = this.field1245[var2];
               var16.field1417 += var11;
               var16.field1415 += var12;
               var16.field1418 += var13;
               ++var16.field1416;
               var16 = this.field1245[var3];
               var16.field1417 += var11;
               var16.field1415 += var12;
               var16.field1418 += var13;
               ++var16.field1416;
               var16 = this.field1245[var4];
               var16.field1417 += var11;
               var16.field1415 += var12;
               var16.field1418 += var13;
               ++var16.field1416;
            } else if(var15 == 1) {
               if(this.field1244 == null) {
                  this.field1244 = new FaceNormal[this.field1217];
               }

               FaceNormal var17 = this.field1244[var1] = new FaceNormal();
               var17.field1556 = var11;
               var17.field1551 = var12;
               var17.field1552 = var13;
            }
         }

      }
   }
}
