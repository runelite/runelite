import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("h")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("p")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("i")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("j")
   class187 field3218;
   @ObfuscatedName("f")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("m")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("c")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -375242557
   )
   @Export("validArchivesCount")
   int validArchivesCount;
   @ObfuscatedName("o")
   Object[][] field3223;
   @ObfuscatedName("g")
   class187[] field3224;
   @ObfuscatedName("e")
   Object[] field3225;
   @ObfuscatedName("y")
   boolean field3226;
   @ObfuscatedName("x")
   static class166 field3227;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 83864721
   )
   public int field3228;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1244661469
   )
   static int field3229;
   @ObfuscatedName("r")
   boolean field3230;
   @ObfuscatedName("z")
   @Export("archiveFileIds")
   int[][] archiveFileIds;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-288456955"
   )
   void vmethod4234(int var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "509477470"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field3223.length && this.field3223[var1] != null && var2 >= 0 && var2 < this.field3223[var1].length) {
         if(this.field3223[var1][var2] == null) {
            boolean var4 = this.method4140(var1, var3);
            if(!var4) {
               this.vmethod4235(var1);
               var4 = this.method4140(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = Spotanim.method4370(this.field3223[var1][var2], false);
         if(this.field3230) {
            this.field3223[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1624607322"
   )
   public boolean method4127(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3223.length && this.field3223[var1] != null && var2 >= 0 && var2 < this.field3223[var1].length) {
         if(this.field3223[var1][var2] != null) {
            return true;
         } else if(this.field3225[var1] != null) {
            return true;
         } else {
            this.vmethod4235(var1);
            return this.field3225[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "764037727"
   )
   public boolean method4128(int var1) {
      if(this.field3225[var1] != null) {
         return true;
      } else {
         this.vmethod4235(var1);
         return this.field3225[var1] != null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "126"
   )
   int vmethod4242(int var1) {
      return this.field3225[var1] != null?100:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-434144461"
   )
   public byte[] method4131(int var1) {
      if(this.field3223.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field3223[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-25"
   )
   public byte[] method4133(int var1) {
      if(this.field3223.length == 1) {
         return this.method4149(0, var1);
      } else if(this.field3223[var1].length == 1) {
         return this.method4149(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1328137381"
   )
   void vmethod4235(int var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "56"
   )
   public void method4138(int var1) {
      for(int var2 = 0; var2 < this.field3223[var1].length; ++var2) {
         this.field3223[var1][var2] = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-90393451"
   )
   public void method4139() {
      for(int var1 = 0; var1 < this.field3223.length; ++var1) {
         if(this.field3223[var1] != null) {
            for(int var2 = 0; var2 < this.field3223[var1].length; ++var2) {
               this.field3223[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "25"
   )
   boolean method4140(int var1, int[] var2) {
      if(this.field3225[var1] == null) {
         return false;
      } else {
         int var3 = this.archiveNumberOfFiles[var1];
         int[] var4 = this.archiveFileIds[var1];
         Object[] var5 = this.field3223[var1];
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
               var18 = Spotanim.method4370(this.field3225[var1], false);
            } else {
               var18 = Spotanim.method4370(this.field3225[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method3181(var2, 5, var8.payload.length);
            }

            byte[] var20 = Client.method1479(var18);
            if(this.field3226) {
               this.field3225[var1] = null;
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
                  if(!this.field3230) {
                     var5[var4[var15]] = RSCanvas.method772(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3230) {
               var5[var4[0]] = RSCanvas.method772(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-32"
   )
   public int method4141(String var1) {
      var1 = var1.toLowerCase();
      return this.field3218.method3515(class158.method2978(var1));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-2072437130"
   )
   public byte[] method4144(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3218.method3515(class158.method2978(var1));
      int var4 = this.field3224[var3].method3515(class158.method2978(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;S)Z",
      garbageValue = "-16711"
   )
   public boolean method4145(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3218.method3515(class158.method2978(var1));
      int var4 = this.field3224[var3].method3515(class158.method2978(var2));
      return this.method4127(var3, var4);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-130606016"
   )
   public void method4147(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3218.method3515(class158.method2978(var1));
      if(var2 >= 0) {
         this.vmethod4234(var2);
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-92"
   )
   public boolean method4148(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3218.method3515(class158.method2978(var1));
      return this.method4128(var2);
   }

   static {
      field3227 = new class166();
      field3229 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1144795387"
   )
   public byte[] method4149(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3223.length && this.field3223[var1] != null && var2 >= 0 && var2 < this.field3223[var1].length) {
         if(this.field3223[var1][var2] == null) {
            boolean var3 = this.method4140(var1, (int[])null);
            if(!var3) {
               this.vmethod4235(var1);
               var3 = this.method4140(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = Spotanim.method4370(this.field3223[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "3"
   )
   public int[] method4156(int var1) {
      return this.archiveFileIds[var1];
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1485002878"
   )
   public int method4172(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3218.method3515(class158.method2978(var1));
      return this.vmethod4242(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1311704878"
   )
   public int method4174(int var1) {
      return this.field3223[var1].length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1853442741"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3226 = var1;
      this.field3230 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2051920905"
   )
   void method4188(byte[] var1) {
      int var3 = var1.length;
      int var2 = class112.method2082(var1, 0, var3);
      this.field3228 = var2;
      Buffer var4 = new Buffer(Client.method1479(var1));
      int var5 = var4.readUnsignedByte();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.readInt();
         }

         int var6 = var4.readUnsignedByte();
         if(var5 >= 7) {
            this.validArchivesCount = var4.method3179();
         } else {
            this.validArchivesCount = var4.readUnsignedShort();
         }

         int var7 = 0;
         int var8 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var4.method3179();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveIds[var9] = var7 += var4.readUnsignedShort();
               if(this.archiveIds[var9] > var8) {
                  var8 = this.archiveIds[var9];
               }
            }
         }

         this.archiveCrcs = new int[var8 + 1];
         this.archiveRevisions = new int[var8 + 1];
         this.archiveNumberOfFiles = new int[var8 + 1];
         this.archiveFileIds = new int[var8 + 1][];
         this.field3225 = new Object[var8 + 1];
         this.field3223 = new Object[var8 + 1][];
         if(var6 != 0) {
            this.archiveNames = new int[var8 + 1];

            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               this.archiveNames[this.archiveIds[var9]] = var4.readInt();
            }

            this.field3218 = new class187(this.archiveNames);
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveCrcs[this.archiveIds[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveRevisions[this.archiveIds[var9]] = var4.readInt();
         }

         for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
            this.archiveNumberOfFiles[this.archiveIds[var9]] = var4.readUnsignedShort();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               var7 = 0;
               var12 = -1;
               this.archiveFileIds[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.archiveFileIds[var10][var13] = var7 += var4.method3179();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field3223[var10] = new Object[var12 + 1];
            }
         } else {
            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               var7 = 0;
               var12 = -1;
               this.archiveFileIds[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.archiveFileIds[var10][var13] = var7 += var4.readUnsignedShort();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field3223[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.archiveFileNames = new int[var8 + 1][];
            this.field3224 = new class187[var8 + 1];

            for(var9 = 0; var9 < this.validArchivesCount; ++var9) {
               var10 = this.archiveIds[var9];
               var11 = this.archiveNumberOfFiles[var10];
               this.archiveFileNames[var10] = new int[this.field3223[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.archiveFileNames[var10][this.archiveFileIds[var10][var12]] = var4.readInt();
               }

               this.field3224[var10] = new class187(this.archiveFileNames[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1358422984"
   )
   public boolean method4193(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3218.method3515(class158.method2978(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.field3224[var3].method3515(class158.method2978(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-821699540"
   )
   public boolean method4197() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3225[var3] == null) {
            this.vmethod4235(var3);
            if(this.field3225[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "-37"
   )
   public int method4209(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field3224[var1].method3515(class158.method2978(var2));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int method4215() {
      return this.field3223.length;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-322691131"
   )
   public static String method4221(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class230.method4112(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
