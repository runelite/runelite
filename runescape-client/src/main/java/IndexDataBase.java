import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("r")
   Object[][] field3203;
   @ObfuscatedName("j")
   boolean field3205;
   @ObfuscatedName("u")
   int[] field3206;
   @ObfuscatedName("g")
   int[] field3207;
   @ObfuscatedName("v")
   int[] field3208;
   @ObfuscatedName("k")
   Object[] field3209;
   @ObfuscatedName("p")
   int[][] field3210;
   @ObfuscatedName("l")
   int[][] field3211;
   @ObfuscatedName("a")
   class187[] field3212;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1113300183
   )
   int field3213;
   @ObfuscatedName("h")
   int[] field3214;
   @ObfuscatedName("b")
   static class166 field3215;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1219818613
   )
   public int field3216;
   @ObfuscatedName("o")
   boolean field3217;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1176565877
   )
   static int field3218;
   @ObfuscatedName("t")
   int[] field3219;
   @ObfuscatedName("q")
   class187 field3221;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2062356903"
   )
   void method4172(byte[] var1) {
      this.field3216 = class222.method4144(var1, var1.length);
      Buffer var2 = new Buffer(class22.method158(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.field3213 = var2.method3391();
         } else {
            this.field3213 = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.field3214 = new int[this.field3213];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field3213; ++var7) {
               this.field3214[var7] = var5 += var2.method3391();
               if(this.field3214[var7] > var6) {
                  var6 = this.field3214[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field3213; ++var7) {
               this.field3214[var7] = var5 += var2.readUnsignedShort();
               if(this.field3214[var7] > var6) {
                  var6 = this.field3214[var7];
               }
            }
         }

         this.field3207 = new int[var6 + 1];
         this.field3208 = new int[var6 + 1];
         this.field3219 = new int[var6 + 1];
         this.field3210 = new int[var6 + 1][];
         this.field3209 = new Object[var6 + 1];
         this.field3203 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field3206 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field3213; ++var7) {
               this.field3206[this.field3214[var7]] = var2.readInt();
            }

            this.field3221 = new class187(this.field3206);
         }

         for(var7 = 0; var7 < this.field3213; ++var7) {
            this.field3207[this.field3214[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field3213; ++var7) {
            this.field3208[this.field3214[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.field3213; ++var7) {
            this.field3219[this.field3214[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field3213; ++var7) {
               var8 = this.field3214[var7];
               var9 = this.field3219[var8];
               var5 = 0;
               var10 = -1;
               this.field3210[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field3210[var8][var11] = var5 += var2.method3391();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field3203[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.field3213; ++var7) {
               var8 = this.field3214[var7];
               var9 = this.field3219[var8];
               var5 = 0;
               var10 = -1;
               this.field3210[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field3210[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field3203[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field3211 = new int[var6 + 1][];
            this.field3212 = new class187[var6 + 1];

            for(var7 = 0; var7 < this.field3213; ++var7) {
               var8 = this.field3214[var7];
               var9 = this.field3219[var8];
               this.field3211[var8] = new int[this.field3203[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field3211[var8][this.field3210[var8][var10]] = var2.readInt();
               }

               this.field3212[var8] = new class187(this.field3211[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void vmethod4288(int var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "0"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "1450731334"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field3203.length && this.field3203[var1] != null && var2 >= 0 && var2 < this.field3203[var1].length) {
         if(this.field3203[var1][var2] == null) {
            boolean var5 = this.method4195(var1, var3);
            if(!var5) {
               this.vmethod4291(var1);
               var5 = this.method4195(var1, var3);
               if(!var5) {
                  return null;
               }
            }
         }

         byte[] var4 = IndexFile.method3071(this.field3203[var1][var2], false);
         if(this.field3205) {
            this.field3203[var1][var2] = null;
         }

         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1200335065"
   )
   public boolean method4176(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3203.length && this.field3203[var1] != null && var2 >= 0 && var2 < this.field3203[var1].length) {
         if(this.field3203[var1][var2] != null) {
            return true;
         } else if(this.field3209[var1] != null) {
            return true;
         } else {
            this.vmethod4291(var1);
            return this.field3209[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "70"
   )
   public boolean method4178() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field3214.length; ++var2) {
         int var3 = this.field3214[var2];
         if(this.field3209[var3] == null) {
            this.vmethod4291(var3);
            if(this.field3209[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1938921276"
   )
   public byte[] method4180(int var1) {
      if(this.field3203.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field3203[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   static {
      field3215 = new class166();
      field3218 = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "44"
   )
   public byte[] method4181(int var1) {
      if(this.field3203.length == 1) {
         return this.method4265(0, var1);
      } else if(this.field3203[var1].length == 1) {
         return this.method4265(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "559698349"
   )
   void vmethod4291(int var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-80"
   )
   public int[] method4183(int var1) {
      return this.field3210[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1152969406"
   )
   public int method4184(int var1) {
      return this.field3203[var1].length;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-860151817"
   )
   public void method4186(int var1) {
      for(int var2 = 0; var2 < this.field3203[var1].length; ++var2) {
         this.field3203[var1][var2] = null;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-765062881"
   )
   public void method4187() {
      for(int var1 = 0; var1 < this.field3203.length; ++var1) {
         if(this.field3203[var1] != null) {
            for(int var2 = 0; var2 < this.field3203[var1].length; ++var2) {
               this.field3203[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "28"
   )
   public int method4189(String var1) {
      var1 = var1.toLowerCase();
      return this.field3221.method3578(class123.method2367(var1));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "180097663"
   )
   public int method4190(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field3212[var1].method3578(class123.method2367(var2));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-24436479"
   )
   public boolean method4191(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3221.method3578(class123.method2367(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.field3212[var3].method3578(class123.method2367(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "13"
   )
   public byte[] method4192(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3221.method3578(class123.method2367(var1));
      int var4 = this.field3212[var3].method3578(class123.method2367(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)Z",
      garbageValue = "-25434"
   )
   public boolean method4193(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3221.method3578(class123.method2367(var1));
      int var4 = this.field3212[var3].method3578(class123.method2367(var2));
      return this.method4176(var3, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[IS)Z",
      garbageValue = "-10397"
   )
   boolean method4195(int var1, int[] var2) {
      if(this.field3209[var1] == null) {
         return false;
      } else {
         int var3 = this.field3219[var1];
         int[] var4 = this.field3210[var1];
         Object[] var5 = this.field3203[var1];
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
               var18 = IndexFile.method3071(this.field3209[var1], false);
            } else {
               var18 = IndexFile.method3071(this.field3209[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method3313(var2, 5, var8.payload.length);
            }

            byte[] var20 = class22.method158(var18);
            if(this.field3217) {
               this.field3209[var1] = null;
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
                  if(!this.field3205) {
                     var5[var4[var15]] = WorldMapType2.method538(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3205) {
               var5[var4[0]] = WorldMapType2.method538(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "2065730186"
   )
   public int method4196(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3221.method3578(class123.method2367(var1));
      return this.vmethod4290(var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1860501882"
   )
   int vmethod4290(int var1) {
      return this.field3209[var1] != null?100:0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "550497959"
   )
   public boolean method4217(int var1) {
      if(this.field3209[var1] != null) {
         return true;
      } else {
         this.vmethod4291(var1);
         return this.field3209[var1] != null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "110"
   )
   public int method4223() {
      return this.field3203.length;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-24"
   )
   public boolean method4225(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3221.method3578(class123.method2367(var1));
      return this.method4217(var2);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "700821836"
   )
   public void method4235(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3221.method3578(class123.method2367(var1));
      if(var2 >= 0) {
         this.vmethod4288(var2);
      }
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3217 = var1;
      this.field3205 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "977485747"
   )
   public byte[] method4265(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3203.length && this.field3203[var1] != null && var2 >= 0 && var2 < this.field3203[var1].length) {
         if(this.field3203[var1][var2] == null) {
            boolean var3 = this.method4195(var1, (int[])null);
            if(!var3) {
               this.vmethod4291(var1);
               var3 = this.method4195(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = IndexFile.method3071(this.field3203[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-774568237"
   )
   static final void method4269(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = Ignore.method1119(var0, var1, Sequence.plane) - var2;
         var0 -= class12.cameraX;
         var3 -= class40.cameraZ;
         var1 -= class12.cameraY;
         int var4 = class136.SINE[class36.cameraPitch];
         int var5 = class136.COSINE[class36.cameraPitch];
         int var6 = class136.SINE[class244.cameraYaw];
         int var7 = class136.COSINE[class244.cameraYaw];
         int var8 = var1 * var6 + var0 * var7 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var4 * var3 + var1 * var5 >> 16;
         if(var1 >= 50) {
            Client.field995 = Client.scale * var0 / var1 + Client.camera2 / 2;
            Client.field996 = var8 * Client.scale / var1 + Client.camera3 / 2;
         } else {
            Client.field995 = -1;
            Client.field996 = -1;
         }

      } else {
         Client.field995 = -1;
         Client.field996 = -1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;S)V",
      garbageValue = "18328"
   )
   public static void method4270(Applet var0, String var1) {
      class56.field678 = var0;
      class56.field673 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lclass244;",
      garbageValue = "54"
   )
   public static class244 method4271(int var0) {
      class244 var1 = (class244)class244.field3306.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class244.field3308.getConfigData(15, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4392(new Buffer(var2));
         }

         class244.field3306.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1847227596"
   )
   static void method4272() {
      RSCanvas.method776();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuOptionCount = 1;
   }
}
