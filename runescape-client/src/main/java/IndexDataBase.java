import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("v")
   boolean field3220;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1872702915
   )
   static int field3222;
   @ObfuscatedName("t")
   class187 field3223;
   @ObfuscatedName("c")
   class187[] field3224;
   @ObfuscatedName("z")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("j")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("w")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("f")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("e")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("o")
   Object[] field3230;
   @ObfuscatedName("q")
   Object[][] field3231;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -398582839
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1433209473
   )
   public int field3233;
   @ObfuscatedName("n")
   static class166 field3234;
   @ObfuscatedName("i")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("m")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("g")
   boolean field3238;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-841489721"
   )
   void method3993(byte[] var1) {
      int var2 = var1.length;
      int var3 = -1;

      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2406[(var3 ^ var1[var4]) & 255];
      }

      var3 = ~var3;
      this.field3233 = var3;
      Buffer var5 = new Buffer(class226.method3966(var1));
      var3 = var5.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var5.readInt();
         }

         var4 = var5.readUnsignedByte();
         if(var3 >= 7) {
            this.validArchivesCount = var5.method3154();
         } else {
            this.validArchivesCount = var5.readUnsignedShort();
         }

         int var6 = 0;
         int var7 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var8;
         if(var3 >= 7) {
            for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
               this.archiveIds[var8] = var6 += var5.method3154();
               if(this.archiveIds[var8] > var7) {
                  var7 = this.archiveIds[var8];
               }
            }
         } else {
            for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
               this.archiveIds[var8] = var6 += var5.readUnsignedShort();
               if(this.archiveIds[var8] > var7) {
                  var7 = this.archiveIds[var8];
               }
            }
         }

         this.archiveCrcs = new int[var7 + 1];
         this.archiveRevisions = new int[var7 + 1];
         this.archiveNumberOfFiles = new int[var7 + 1];
         this.archiveFileIds = new int[var7 + 1][];
         this.field3230 = new Object[var7 + 1];
         this.field3231 = new Object[var7 + 1][];
         if(var4 != 0) {
            this.archiveNames = new int[var7 + 1];

            for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
               this.archiveNames[this.archiveIds[var8]] = var5.readInt();
            }

            this.field3223 = new class187(this.archiveNames);
         }

         for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
            this.archiveCrcs[this.archiveIds[var8]] = var5.readInt();
         }

         for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
            this.archiveRevisions[this.archiveIds[var8]] = var5.readInt();
         }

         for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
            this.archiveNumberOfFiles[this.archiveIds[var8]] = var5.readUnsignedShort();
         }

         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if(var3 >= 7) {
            for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
               var9 = this.archiveIds[var8];
               var10 = this.archiveNumberOfFiles[var9];
               var6 = 0;
               var11 = -1;
               this.archiveFileIds[var9] = new int[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var13 = this.archiveFileIds[var9][var12] = var6 += var5.method3154();
                  if(var13 > var11) {
                     var11 = var13;
                  }
               }

               this.field3231[var9] = new Object[var11 + 1];
            }
         } else {
            for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
               var9 = this.archiveIds[var8];
               var10 = this.archiveNumberOfFiles[var9];
               var6 = 0;
               var11 = -1;
               this.archiveFileIds[var9] = new int[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var13 = this.archiveFileIds[var9][var12] = var6 += var5.readUnsignedShort();
                  if(var13 > var11) {
                     var11 = var13;
                  }
               }

               this.field3231[var9] = new Object[var11 + 1];
            }
         }

         if(var4 != 0) {
            this.archiveFileNames = new int[var7 + 1][];
            this.field3224 = new class187[var7 + 1];

            for(var8 = 0; var8 < this.validArchivesCount; ++var8) {
               var9 = this.archiveIds[var8];
               var10 = this.archiveNumberOfFiles[var9];
               this.archiveFileNames[var9] = new int[this.field3231[var9].length];

               for(var11 = 0; var11 < var10; ++var11) {
                  this.archiveFileNames[var9][this.archiveFileIds[var9][var11]] = var5.readInt();
               }

               this.field3224[var9] = new class187(this.archiveFileNames[var9]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-953159438"
   )
   void vmethod4096(int var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "540398505"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field3231.length && this.field3231[var1] != null && var2 >= 0 && var2 < this.field3231[var1].length) {
         if(this.field3231[var1][var2] == null) {
            boolean var4 = this.method4010(var1, var3);
            if(!var4) {
               this.vmethod4097(var1);
               var4 = this.method4010(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class228.method3971(this.field3231[var1][var2], false);
         if(this.field3220) {
            this.field3231[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1355084289"
   )
   public boolean method3997(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3231.length && this.field3231[var1] != null && var2 >= 0 && var2 < this.field3231[var1].length) {
         if(this.field3231[var1][var2] != null) {
            return true;
         } else if(this.field3230[var1] != null) {
            return true;
         } else {
            this.vmethod4097(var1);
            return this.field3230[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-123"
   )
   public boolean method3998(int var1) {
      if(this.field3230[var1] != null) {
         return true;
      } else {
         this.vmethod4097(var1);
         return this.field3230[var1] != null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "78"
   )
   public boolean method3999() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3230[var3] == null) {
            this.vmethod4097(var3);
            if(this.field3230[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1305160441"
   )
   int vmethod4098(int var1) {
      return this.field3230[var1] != null?100:0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "805763875"
   )
   public byte[] method4001(int var1) {
      if(this.field3231.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field3231[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-524253817"
   )
   public byte[] method4002(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3231.length && this.field3231[var1] != null && var2 >= 0 && var2 < this.field3231[var1].length) {
         if(this.field3231[var1][var2] == null) {
            boolean var3 = this.method4010(var1, (int[])null);
            if(!var3) {
               this.vmethod4097(var1);
               var3 = this.method4010(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class228.method3971(this.field3231[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "120"
   )
   public byte[] method4003(int var1) {
      if(this.field3231.length == 1) {
         return this.method4002(0, var1);
      } else if(this.field3231[var1].length == 1) {
         return this.method4002(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-848431386"
   )
   void vmethod4097(int var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)[I",
      garbageValue = "-30678"
   )
   public int[] method4005(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "82"
   )
   public int method4007() {
      return this.field3231.length;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-900700674"
   )
   public void method4008(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3223.method3403(class69.method1040(var1));
      if(var2 >= 0) {
         this.vmethod4096(var2);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-6950"
   )
   public void method4009() {
      for(int var1 = 0; var1 < this.field3231.length; ++var1) {
         if(this.field3231[var1] != null) {
            for(int var2 = 0; var2 < this.field3231[var1].length; ++var2) {
               this.field3231[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "-33"
   )
   boolean method4010(int var1, int[] var2) {
      if(this.field3230[var1] == null) {
         return false;
      } else {
         int var3 = this.archiveNumberOfFiles[var1];
         int[] var4 = this.archiveFileIds[var1];
         Object[] var5 = this.field3231[var1];
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
            if(var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
               var18 = class228.method3971(this.field3230[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.decryptXtea(var2, 5, var8.payload.length);
            } else {
               var18 = class228.method3971(this.field3230[var1], false);
            }

            byte[] var19 = class226.method3966(var18);
            if(this.field3238) {
               this.field3230[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var19.length;
               --var9;
               int var10 = var19[var9] & 255;
               var9 -= var3 * var10 * 4;
               Buffer var11 = new Buffer(var19);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var13;
               int var14;
               for(int var15 = 0; var15 < var10; ++var15) {
                  var13 = 0;

                  for(var14 = 0; var14 < var3; ++var14) {
                     var13 += var11.readInt();
                     var12[var14] += var13;
                  }
               }

               byte[][] var20 = new byte[var3][];

               for(var13 = 0; var13 < var3; ++var13) {
                  var20[var13] = new byte[var12[var13]];
                  var12[var13] = 0;
               }

               var11.offset = var9;
               var13 = 0;

               for(var14 = 0; var14 < var10; ++var14) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.readInt();
                     System.arraycopy(var19, var13, var20[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var13 += var16;
                  }
               }

               for(var14 = 0; var14 < var3; ++var14) {
                  if(!this.field3220) {
                     var5[var4[var14]] = class20.method166(var20[var14], false);
                  } else {
                     var5[var4[var14]] = var20[var14];
                  }
               }
            } else if(!this.field3220) {
               var5[var4[0]] = class20.method166(var19, false);
            } else {
               var5[var4[0]] = var19;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1438236341"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-12"
   )
   public boolean method4013(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3223.method3403(class69.method1040(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.field3224[var3].method3403(class69.method1040(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "-106"
   )
   public byte[] method4014(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3223.method3403(class69.method1040(var1));
      int var4 = this.field3224[var3].method3403(class69.method1040(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1065578123"
   )
   public boolean method4016(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3223.method3403(class69.method1040(var1));
      return this.method3998(var2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "14"
   )
   public int method4018(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3223.method3403(class69.method1040(var1));
      return this.vmethod4098(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "17"
   )
   public int method4020(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field3224[var1].method3403(class69.method1040(var2));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1979518858"
   )
   public boolean method4026(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3223.method3403(class69.method1040(var1));
      int var4 = this.field3224[var3].method3403(class69.method1040(var2));
      return this.method3997(var3, var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1731497225"
   )
   public void method4043(int var1) {
      for(int var2 = 0; var2 < this.field3231[var1].length; ++var2) {
         this.field3231[var1][var2] = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "524691694"
   )
   public int method4055(String var1) {
      var1 = var1.toLowerCase();
      return this.field3223.method3403(class69.method1040(var1));
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3238 = var1;
      this.field3220 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "431634514"
   )
   public int method4075(int var1) {
      return this.field3231[var1].length;
   }

   static {
      field3234 = new class166();
      field3222 = 0;
   }
}
