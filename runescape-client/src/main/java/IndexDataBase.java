import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("IndexDataBase")
public abstract class IndexDataBase {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1436541123
   )
   static int field3215;
   @ObfuscatedName("h")
   @Export("archiveNumberOfFiles")
   int[] archiveNumberOfFiles;
   @ObfuscatedName("e")
   @Export("archiveNames")
   int[] archiveNames;
   @ObfuscatedName("v")
   class187 field3218;
   @ObfuscatedName("b")
   @Export("archiveCrcs")
   int[] archiveCrcs;
   @ObfuscatedName("j")
   boolean field3220;
   @ObfuscatedName("c")
   @Export("archiveIds")
   int[] archiveIds;
   @ObfuscatedName("x")
   @Export("archiveFileIds")
   int[][] archiveFileIds;
   @ObfuscatedName("f")
   @Export("archiveFileNames")
   int[][] archiveFileNames;
   @ObfuscatedName("y")
   @Export("archiveRevisions")
   int[] archiveRevisions;
   @ObfuscatedName("a")
   Object[] field3225;
   @ObfuscatedName("o")
   Object[][] field3226;
   @ObfuscatedName("z")
   static class166 field3227;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -882472505
   )
   public int field3228;
   @ObfuscatedName("n")
   class187[] field3229;
   @ObfuscatedName("k")
   boolean field3230;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -973575421
   )
   @Export("validArchivesCount")
   int validArchivesCount;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "25797915"
   )
   void method4107(byte[] var1) {
      this.field3228 = FaceNormal.method2866(var1, var1.length);
      Buffer var2 = new Buffer(class24.method163(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.validArchivesCount = var2.method3155();
         } else {
            this.validArchivesCount = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.archiveIds = new int[this.validArchivesCount];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.method3155();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveIds[var7] = var5 += var2.readUnsignedShort();
               if(this.archiveIds[var7] > var6) {
                  var6 = this.archiveIds[var7];
               }
            }
         }

         this.archiveCrcs = new int[var6 + 1];
         this.archiveRevisions = new int[var6 + 1];
         this.archiveNumberOfFiles = new int[var6 + 1];
         this.archiveFileIds = new int[var6 + 1][];
         this.field3225 = new Object[var6 + 1];
         this.field3226 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.archiveNames = new int[var6 + 1];

            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               this.archiveNames[this.archiveIds[var7]] = var2.readInt();
            }

            this.field3218 = new class187(this.archiveNames);
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveCrcs[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveRevisions[this.archiveIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
            this.archiveNumberOfFiles[this.archiveIds[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               var5 = 0;
               var10 = -1;
               this.archiveFileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.archiveFileIds[var8][var11] = var5 += var2.method3155();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field3226[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               var5 = 0;
               var10 = -1;
               this.archiveFileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.archiveFileIds[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field3226[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.archiveFileNames = new int[var6 + 1][];
            this.field3229 = new class187[var6 + 1];

            for(var7 = 0; var7 < this.validArchivesCount; ++var7) {
               var8 = this.archiveIds[var7];
               var9 = this.archiveNumberOfFiles[var8];
               this.archiveFileNames[var8] = new int[this.field3226[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.archiveFileNames[var8][this.archiveFileIds[var8][var10]] = var2.readInt();
               }

               this.field3229[var8] = new class187(this.archiveFileNames[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1650036716"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "359615922"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field3226.length && this.field3226[var1] != null && var2 >= 0 && var2 < this.field3226[var1].length) {
         if(this.field3226[var1][var2] == null) {
            boolean var5 = this.method4194(var1, var3);
            if(!var5) {
               this.vmethod4220(var1);
               var5 = this.method4194(var1, var3);
               if(!var5) {
                  return null;
               }
            }
         }

         byte[] var4 = FileOnDisk.method2365(this.field3226[var1][var2], false);
         if(this.field3230) {
            this.field3226[var1][var2] = null;
         }

         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1013978345"
   )
   public boolean method4111(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3226.length && this.field3226[var1] != null && var2 >= 0 && var2 < this.field3226[var1].length) {
         if(this.field3226[var1][var2] != null) {
            return true;
         } else if(this.field3225[var1] != null) {
            return true;
         } else {
            this.vmethod4220(var1);
            return this.field3225[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2145561686"
   )
   public boolean method4112(int var1) {
      if(this.field3225[var1] != null) {
         return true;
      } else {
         this.vmethod4220(var1);
         return this.field3225[var1] != null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1772367119"
   )
   public boolean method4113() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.archiveIds.length; ++var2) {
         int var3 = this.archiveIds[var2];
         if(this.field3225[var3] == null) {
            this.vmethod4220(var3);
            if(this.field3225[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-703132845"
   )
   int vmethod4241(int var1) {
      return this.field3225[var1] != null?100:0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-2070167514"
   )
   public byte[] method4115(int var1) {
      if(this.field3226.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field3226[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-1796568298"
   )
   public byte[] method4116(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field3226.length && this.field3226[var1] != null && var2 >= 0 && var2 < this.field3226[var1].length) {
         if(this.field3226[var1][var2] == null) {
            boolean var3 = this.method4194(var1, (int[])null);
            if(!var3) {
               this.vmethod4220(var1);
               var3 = this.method4194(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = FileOnDisk.method2365(this.field3226[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "98"
   )
   public byte[] method4117(int var1) {
      if(this.field3226.length == 1) {
         return this.method4116(0, var1);
      } else if(this.field3226[var1].length == 1) {
         return this.method4116(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1368937922"
   )
   void vmethod4220(int var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "46"
   )
   public int method4121() {
      return this.field3226.length;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-39"
   )
   public void method4122(int var1) {
      for(int var2 = 0; var2 < this.field3226[var1].length; ++var2) {
         this.field3226[var1][var2] = null;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "-8291"
   )
   public int method4125(String var1) {
      var1 = var1.toLowerCase();
      return this.field3218.method3493(class151.method2920(var1));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)I",
      garbageValue = "0"
   )
   public int method4126(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field3229[var1].method3493(class151.method2920(var2));
   }

   IndexDataBase(boolean var1, boolean var2) {
      this.field3220 = var1;
      this.field3230 = var2;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "659110529"
   )
   public boolean method4128(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3218.method3493(class151.method2920(var1));
      int var4 = this.field3229[var3].method3493(class151.method2920(var2));
      return this.method4111(var3, var4);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1136938397"
   )
   public boolean method4129(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3218.method3493(class151.method2920(var1));
      return this.method4112(var2);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-25276"
   )
   public void method4130(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3218.method3493(class151.method2920(var1));
      if(var2 >= 0) {
         this.vmethod4240(var2);
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "15"
   )
   public int method4133(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field3218.method3493(class151.method2920(var1));
      return this.vmethod4241(var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "447554552"
   )
   void vmethod4240(int var1) {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1544551247"
   )
   public int[] method4161(int var1) {
      return this.archiveFileIds[var1];
   }

   static {
      field3227 = new class166();
      field3215 = 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-573113031"
   )
   public byte[] method4170(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3218.method3493(class151.method2920(var1));
      int var4 = this.field3229[var3].method3493(class151.method2920(var2));
      return this.getConfigData(var3, var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-339023978"
   )
   public void method4173() {
      for(int var1 = 0; var1 < this.field3226.length; ++var1) {
         if(this.field3226[var1] != null) {
            for(int var2 = 0; var2 < this.field3226[var1].length; ++var2) {
               this.field3226[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1235717170"
   )
   public boolean method4176(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field3218.method3493(class151.method2920(var1));
      if(var3 < 0) {
         return false;
      } else {
         int var4 = this.field3229[var3].method3493(class151.method2920(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-14"
   )
   public int method4187(int var1) {
      return this.field3226[var1].length;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "-2076146720"
   )
   boolean method4194(int var1, int[] var2) {
      if(this.field3225[var1] == null) {
         return false;
      } else {
         int var3 = this.archiveNumberOfFiles[var1];
         int[] var4 = this.archiveFileIds[var1];
         Object[] var5 = this.field3226[var1];
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
               var18 = FileOnDisk.method2365(this.field3225[var1], false);
            } else {
               var18 = FileOnDisk.method2365(this.field3225[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method3161(var2, 5, var8.payload.length);
            }

            byte[] var20 = class24.method163(var18);
            if(this.field3220) {
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
                     var5[var4[var15]] = WorldMapType2.method490(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field3230) {
               var5[var4[0]] = WorldMapType2.method490(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-91"
   )
   static final void method4203(int var0) {
      if(RSSocket.method2986(var0)) {
         Widget[] var1 = CombatInfo1.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2675 = 0;
               var3.field2774 = 0;
            }
         }

      }
   }
}
