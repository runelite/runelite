import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("u")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("ck")
   static class208 field1186;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 8352139370560284819L
   )
   @Export("position")
   long position;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -6362623192829513763L
   )
   @Export("length")
   long length;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "943175223"
   )
   public final void method1365() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1483427968"
   )
   public final long method1367() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1521792658"
   )
   public final int method1368(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("u")
   final void method1369(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   protected void finalize() throws Throwable {
      if(null != this.file) {
         System.out.println("");
         this.method1365();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "5"
   )
   public final void method1375(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)I",
      garbageValue = "-1173651560"
   )
   static int method1383(class159 var0) {
      int var1 = var0.method3032(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3032(5);
      } else if(var1 == 2) {
         var2 = var0.method3032(8);
      } else {
         var2 = var0.method3032(11);
      }

      return var2;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "1456675396"
   )
   static final void method1384(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.field3016 != null) {
            var0 = var0.method3705();
         }

         if(null != var0) {
            if(var0.field3009) {
               if(!var0.field3021 || var1 == Client.field448) {
                  String var4 = var0.name;
                  int var8;
                  if(var0.combatLevel != 0) {
                     int var7 = var0.combatLevel;
                     var8 = class148.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class32.method691(16711680);
                     } else if(var9 < -6) {
                        var6 = class32.method691(16723968);
                     } else if(var9 < -3) {
                        var6 = class32.method691(16740352);
                     } else if(var9 < 0) {
                        var6 = class32.method691(16756736);
                     } else if(var9 > 9) {
                        var6 = class32.method691('\uff00');
                     } else if(var9 > 6) {
                        var6 = class32.method691(4259584);
                     } else if(var9 > 3) {
                        var6 = class32.method691(8453888);
                     } else if(var9 > 0) {
                        var6 = class32.method691(12648192);
                     } else {
                        var6 = class32.method691(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field447 == 1) {
                     GroundObject.addMenuEntry("Use", Client.field468 + " " + "->" + " " + class32.method691(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field435) {
                     if((class214.field3158 & 2) == 2) {
                        GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + class32.method691(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field300) {
                        var5 = class8.method112(var5);
                     }

                     int var10;
                     if(null != var5) {
                        for(var10 = 4; var10 >= 0; --var10) {
                           if(null != var5[var10] && !var5[var10].equalsIgnoreCase("Attack")) {
                              byte var11 = 0;
                              if(var10 == 0) {
                                 var11 = 9;
                              }

                              if(var10 == 1) {
                                 var11 = 10;
                              }

                              if(var10 == 2) {
                                 var11 = 11;
                              }

                              if(var10 == 3) {
                                 var11 = 12;
                              }

                              if(var10 == 4) {
                                 var11 = 13;
                              }

                              GroundObject.addMenuEntry(var5[var10], class32.method691(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var10 = 4; var10 >= 0; --var10) {
                           if(null != var5[var10] && var5[var10].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field307 != class40.field798) {
                                 if(Client.field307 == class40.field802 || Client.field307 == class40.field799 && var0.combatLevel > class148.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var10 == 0) {
                                    var8 = 9 + var12;
                                 }

                                 if(var10 == 1) {
                                    var8 = 10 + var12;
                                 }

                                 if(var10 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var10 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var10 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 GroundObject.addMenuEntry(var5[var10], class32.method691(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     GroundObject.addMenuEntry("Examine", class32.method691(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
